package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.DefaultVideoCompositor;
import com.oplus.tbl.exoplayer2.effect.GlTextureProducer;
import com.oplus.tbl.exoplayer2.effect.VideoCompositor;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.LongArrayQueue;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.bv2;
import defpackage.em4;
import j$.util.Objects;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class DefaultVideoCompositor implements VideoCompositor {
    private static final int PRIMARY_INPUT_ID = 0;
    private static final String TAG = "DefaultVideoCompositor";
    private static final String THREAD_NAME = "Effect:DefaultVideoCompositor:GlThread";

    @GuardedBy("this")
    private boolean allInputsEnded;
    private final CompositorGlProgram compositorGlProgram;
    private ColorInfo configuredColorInfo;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private final GlObjectsProvider glObjectsProvider;

    @GuardedBy("this")
    private final List<InputSource> inputSources = new ArrayList();
    private final VideoCompositor.Listener listener;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private EGLSurface placeholderEglSurface;
    private final VideoCompositorSettings settings;
    private final LongArrayQueue syncObjects;
    private final GlTextureProducer.Listener textureOutputListener;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CompositorGlProgram {
        private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_alpha_scale_es2.glsl";
        private static final String TAG = "CompositorGlProgram";
        private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
        private final Context context;
        private GlProgram glProgram;
        private final OverlayMatrixProvider overlayMatrixProvider = new OverlayMatrixProvider();

        public CompositorGlProgram(Context context) {
            this.context = context;
        }

        private void blendOntoFocusedTexture(InputFrameInfo inputFrameInfo) throws GlUtil.GlException {
            GlProgram glProgram = (GlProgram) Assertions.checkNotNull(this.glProgram);
            GlTextureInfo glTextureInfo = inputFrameInfo.texture;
            glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
            glProgram.setFloatsUniform("uTransformationMatrix", this.overlayMatrixProvider.getTransformationMatrix(new Size(glTextureInfo.width, glTextureInfo.height), inputFrameInfo.overlaySettings));
            glProgram.setFloatUniform("uAlphaScale", inputFrameInfo.overlaySettings.alphaScale);
            glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        }

        private void ensureConfigured() throws VideoFrameProcessingException, GlUtil.GlException {
            if (this.glProgram != null) {
                return;
            }
            try {
                GlProgram glProgram = new GlProgram(this.context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
                this.glProgram = glProgram;
                glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
                this.glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
            } catch (IOException e) {
                throw new VideoFrameProcessingException(e);
            }
        }

        public void drawFrame(List<InputFrameInfo> list, GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
            ensureConfigured();
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
            this.overlayMatrixProvider.configure(new Size(glTextureInfo.width, glTextureInfo.height));
            GlUtil.clearFocusedBuffers();
            ((GlProgram) Assertions.checkNotNull(this.glProgram)).use();
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
            GlUtil.checkGlError();
            for (int size = list.size() - 1; size >= 0; size--) {
                blendOntoFocusedTexture(list.get(size));
            }
            GLES20.glDisable(3042);
            GlUtil.checkGlError();
        }

        public void release() {
            try {
                GlProgram glProgram = this.glProgram;
                if (glProgram != null) {
                    glProgram.delete();
                }
            } catch (GlUtil.GlException e) {
                Log.e(TAG, "Error releasing GL Program", e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class InputFrameInfo {
        public final OverlaySettings overlaySettings;
        public final long presentationTimeUs;
        public final GlTextureInfo texture;
        public final GlTextureProducer textureProducer;

        public InputFrameInfo(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j, OverlaySettings overlaySettings) {
            this.textureProducer = glTextureProducer;
            this.texture = glTextureInfo;
            this.presentationTimeUs = j;
            this.overlaySettings = overlaySettings;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class InputSource {
        public final Queue<InputFrameInfo> frameInfos = new ArrayDeque();
        public boolean isInputEnded;
    }

    @RequiresApi(api = 17)
    public DefaultVideoCompositor(Context context, GlObjectsProvider glObjectsProvider, VideoCompositorSettings videoCompositorSettings, @Nullable ExecutorService executorService, final VideoCompositor.Listener listener, GlTextureProducer.Listener listener2, @IntRange(from = 1) int i) {
        this.listener = listener;
        this.textureOutputListener = listener2;
        this.glObjectsProvider = glObjectsProvider;
        this.settings = videoCompositorSettings;
        this.compositorGlProgram = new CompositorGlProgram(context);
        this.outputTexturePool = new TexturePool(false, i);
        this.outputTextureTimestamps = new LongArrayQueue(i);
        this.syncObjects = new LongArrayQueue(i);
        boolean z = executorService == null;
        ExecutorService executorServiceNewSingleThreadExecutor = z ? Util.newSingleThreadExecutor(THREAD_NAME) : (ExecutorService) Assertions.checkNotNull(executorService);
        Objects.requireNonNull(listener);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorServiceNewSingleThreadExecutor, z, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: com.oplus.tbl.exoplayer2.effect.k
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                listener.onError(videoFrameProcessingException);
            }
        });
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.l
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                this.f7610a.setupGlObjects();
            }
        });
    }

    private synchronized ImmutableList<InputFrameInfo> getFramesToComposite() {
        if (this.outputTexturePool.freeTextureCount() == 0) {
            return ImmutableList.of();
        }
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (this.inputSources.get(i).frameInfos.isEmpty()) {
                return ImmutableList.of();
            }
        }
        ImmutableList.a aVar = new ImmutableList.a();
        InputFrameInfo inputFrameInfoElement = this.inputSources.get(0).frameInfos.element();
        aVar.a(inputFrameInfoElement);
        for (int i2 = 0; i2 < this.inputSources.size(); i2++) {
            if (i2 != 0) {
                InputSource inputSource = this.inputSources.get(i2);
                if (inputSource.frameInfos.size() == 1 && !inputSource.isInputEnded) {
                    return ImmutableList.of();
                }
                Iterator<InputFrameInfo> it = inputSource.frameInfos.iterator();
                long j = Long.MAX_VALUE;
                InputFrameInfo inputFrameInfo = null;
                while (it.hasNext()) {
                    InputFrameInfo next = it.next();
                    long j2 = next.presentationTimeUs;
                    long jAbs = Math.abs(j2 - inputFrameInfoElement.presentationTimeUs);
                    if (jAbs < j) {
                        inputFrameInfo = next;
                        j = jAbs;
                    }
                    if (j2 > inputFrameInfoElement.presentationTimeUs || (!it.hasNext() && inputSource.isInputEnded)) {
                        aVar.a((InputFrameInfo) Assertions.checkNotNull(inputFrameInfo));
                        break;
                    }
                }
            }
        }
        ImmutableList<InputFrameInfo> immutableListE = aVar.e();
        if (immutableListE.size() == this.inputSources.size()) {
            return immutableListE;
        }
        return ImmutableList.of();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$releaseExcessFramesInSecondaryStream$1(long j, InputFrameInfo inputFrameInfo) {
        return inputFrameInfo.presentationTimeUs <= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public synchronized void maybeComposite() throws VideoFrameProcessingException, GlUtil.GlException {
        ImmutableList<InputFrameInfo> framesToComposite = getFramesToComposite();
        if (framesToComposite.isEmpty()) {
            return;
        }
        InputFrameInfo inputFrameInfo = framesToComposite.get(0);
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < framesToComposite.size(); i++) {
            GlTextureInfo glTextureInfo = framesToComposite.get(i).texture;
            aVar.a(new Size(glTextureInfo.width, glTextureInfo.height));
        }
        Size outputSize = this.settings.getOutputSize(aVar.e());
        this.outputTexturePool.ensureConfigured(this.glObjectsProvider, outputSize.getWidth(), outputSize.getHeight());
        GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
        long j = inputFrameInfo.presentationTimeUs;
        this.outputTextureTimestamps.add(j);
        this.compositorGlProgram.drawFrame(framesToComposite, glTextureInfoUseTexture);
        long jCreateGlSyncFence = GlUtil.createGlSyncFence();
        this.syncObjects.add(jCreateGlSyncFence);
        this.textureOutputListener.onTextureRendered(this, glTextureInfoUseTexture, j, jCreateGlSyncFence);
        InputSource inputSource = this.inputSources.get(0);
        releaseFrames(inputSource, 1);
        releaseExcessFramesInAllSecondaryStreams();
        if (this.allInputsEnded && inputSource.frameInfos.isEmpty()) {
            this.listener.onEnded();
        }
    }

    private synchronized void releaseExcessFramesInAllSecondaryStreams() {
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (i != 0) {
                releaseExcessFramesInSecondaryStream(this.inputSources.get(i));
            }
        }
    }

    private synchronized void releaseExcessFramesInSecondaryStream(InputSource inputSource) {
        InputSource inputSource2 = this.inputSources.get(0);
        if (inputSource2.frameInfos.isEmpty() && inputSource2.isInputEnded) {
            releaseFrames(inputSource, inputSource.frameInfos.size());
            return;
        }
        InputFrameInfo inputFrameInfoPeek = inputSource2.frameInfos.peek();
        final long j = inputFrameInfoPeek != null ? inputFrameInfoPeek.presentationTimeUs : -9223372036854775807L;
        releaseFrames(inputSource, Math.max(bv2.n(bv2.e(inputSource.frameInfos, new em4() { // from class: com.oplus.tbl.exoplayer2.effect.h
            @Override // defpackage.em4
            public final boolean apply(Object obj) {
                return DefaultVideoCompositor.lambda$releaseExcessFramesInSecondaryStream$1(j, (DefaultVideoCompositor.InputFrameInfo) obj);
            }
        })) - 1, 0));
    }

    private synchronized void releaseFrames(InputSource inputSource, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            InputFrameInfo inputFrameInfoRemove = inputSource.frameInfos.remove();
            inputFrameInfoRemove.textureProducer.releaseOutputTexture(inputFrameInfoRemove.presentationTimeUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public void releaseGlObjects() {
        try {
            try {
                try {
                    this.compositorGlProgram.release();
                    this.outputTexturePool.deleteAllTextures();
                    GlUtil.destroyEglSurface(this.eglDisplay, this.placeholderEglSurface);
                    GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
                } catch (GlUtil.GlException e) {
                    Log.e(TAG, "Error releasing GL resources", e);
                    GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
                }
            } catch (GlUtil.GlException e2) {
                Log.e(TAG, "Error releasing GL context", e2);
            }
        } catch (Throwable th) {
            try {
                GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
            } catch (GlUtil.GlException e3) {
                Log.e(TAG, "Error releasing GL context", e3);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    /* JADX INFO: renamed from: releaseOutputTextureInternal, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$releaseOutputTexture$0(long j) throws VideoFrameProcessingException, GlUtil.GlException {
        while (this.outputTexturePool.freeTextureCount() < this.outputTexturePool.capacity() && this.outputTextureTimestamps.element() <= j) {
            this.outputTexturePool.freeTexture();
            this.outputTextureTimestamps.remove();
            GlUtil.deleteSyncObject(this.syncObjects.remove());
        }
        maybeComposite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public void setupGlObjects() throws GlUtil.GlException {
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        this.eglDisplay = defaultEglDisplay;
        EGLContext eGLContextCreateEglContext = this.glObjectsProvider.createEglContext(defaultEglDisplay, 2, GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888);
        this.eglContext = eGLContextCreateEglContext;
        this.placeholderEglSurface = this.glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContextCreateEglContext, this.eglDisplay);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor
    @RequiresApi(api = 17)
    public synchronized void queueInputTexture(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j) {
        InputSource inputSource = this.inputSources.get(i);
        boolean z = true;
        Assertions.checkState(!inputSource.isInputEnded);
        if (ColorInfo.isTransferHdr(colorInfo)) {
            z = false;
        }
        Assertions.checkStateNotNull(Boolean.valueOf(z), "HDR input is not supported.");
        if (this.configuredColorInfo == null) {
            this.configuredColorInfo = colorInfo;
        }
        Assertions.checkState(this.configuredColorInfo.equals(colorInfo), "Mixing different ColorInfos is not supported.");
        inputSource.frameInfos.add(new InputFrameInfo(glTextureProducer, glTextureInfo, j, this.settings.getOverlaySettings(i, j)));
        if (i == 0) {
            releaseExcessFramesInAllSecondaryStreams();
        } else {
            releaseExcessFramesInSecondaryStream(inputSource);
        }
        this.videoFrameProcessingTaskExecutor.submit(new i(this));
    }

    @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor
    public synchronized int registerInputSource() {
        this.inputSources.add(new InputSource());
        return this.inputSources.size() - 1;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor
    @RequiresApi(api = 17)
    public synchronized void release() {
        Assertions.checkState(this.allInputsEnded);
        try {
            this.videoFrameProcessingTaskExecutor.release(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.j
                @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f7606a.releaseGlObjects();
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlTextureProducer
    @RequiresApi(api = 17)
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.m
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f7612a.lambda$releaseOutputTexture$0(j);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.VideoCompositor
    @RequiresApi(api = 17)
    public synchronized void signalEndOfInputSource(int i) {
        boolean z;
        this.inputSources.get(i).isInputEnded = true;
        int i2 = 0;
        while (true) {
            if (i2 >= this.inputSources.size()) {
                z = true;
                break;
            } else {
                if (!this.inputSources.get(i2).isInputEnded) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        this.allInputsEnded = z;
        if (this.inputSources.get(0).frameInfos.isEmpty()) {
            if (i == 0) {
                releaseExcessFramesInAllSecondaryStreams();
            }
            if (z) {
                this.listener.onEnded();
                return;
            }
        }
        if (i != 0 && this.inputSources.get(i).frameInfos.size() == 1) {
            this.videoFrameProcessingTaskExecutor.submit(new i(this));
        }
    }
}
