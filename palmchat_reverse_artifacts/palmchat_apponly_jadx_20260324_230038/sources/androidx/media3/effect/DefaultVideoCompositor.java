package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoCompositor;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.VideoCompositor;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.collect.ImmutableList;
import defpackage.bv2;
import defpackage.em4;
import j$.util.Objects;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultVideoCompositor implements VideoCompositor {
    private static final String TAG = "DefaultVideoCompositor";

    @GuardedBy("this")
    private boolean allInputsEnded;
    private final CompositorGlProgram compositorGlProgram;
    private ColorInfo configuredColorInfo;
    private EGLDisplay eglDisplay;
    private final GlObjectsProvider glObjectsProvider;
    private final VideoCompositor.Listener listener;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private EGLSurface placeholderEglSurface;
    private final LongArrayQueue syncObjects;
    private final GlTextureProducer.Listener textureOutputListener;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private int primaryInputIndex = -1;

    @GuardedBy("this")
    private final SparseArray<InputSource> inputSources = new SparseArray<>();
    private VideoCompositorSettings videoCompositorSettings = VideoCompositorSettings.DEFAULT;

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
            GlTextureInfo glTextureInfo = inputFrameInfo.timedGlTextureInfo.glTextureInfo;
            glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
            glProgram.setFloatsUniform("uTransformationMatrix", this.overlayMatrixProvider.getTransformationMatrix(new Size(glTextureInfo.width, glTextureInfo.height), inputFrameInfo.overlaySettings));
            glProgram.setFloatUniform("uAlphaScale", inputFrameInfo.overlaySettings.getAlphaScale());
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
        public final GlTextureProducer textureProducer;
        public final TimedGlTextureInfo timedGlTextureInfo;

        public InputFrameInfo(GlTextureProducer glTextureProducer, TimedGlTextureInfo timedGlTextureInfo, OverlaySettings overlaySettings) {
            this.textureProducer = glTextureProducer;
            this.timedGlTextureInfo = timedGlTextureInfo;
            this.overlaySettings = overlaySettings;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class InputSource {
        public final Queue<InputFrameInfo> frameInfos = new ArrayDeque();
        public boolean isInputEnded;
    }

    public DefaultVideoCompositor(Context context, GlObjectsProvider glObjectsProvider, ExecutorService executorService, final VideoCompositor.Listener listener, GlTextureProducer.Listener listener2, @IntRange(from = 1) int i) {
        this.listener = listener;
        this.textureOutputListener = listener2;
        this.glObjectsProvider = glObjectsProvider;
        this.compositorGlProgram = new CompositorGlProgram(context);
        this.outputTexturePool = new TexturePool(false, i);
        this.outputTextureTimestamps = new LongArrayQueue(i);
        this.syncObjects = new LongArrayQueue(i);
        Objects.requireNonNull(listener);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorService, false, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: androidx.media3.effect.m
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                listener.onError(videoFrameProcessingException);
            }
        });
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.n
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                this.f1335a.setupGlObjects();
            }
        });
    }

    private synchronized ImmutableList<InputFrameInfo> getFramesToComposite() {
        if (this.outputTexturePool.freeTextureCount() == 0) {
            return ImmutableList.of();
        }
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (this.inputSources.valueAt(i).frameInfos.isEmpty()) {
                return ImmutableList.of();
            }
        }
        ImmutableList.a aVar = new ImmutableList.a();
        InputFrameInfo inputFrameInfoElement = this.inputSources.get(this.primaryInputIndex).frameInfos.element();
        aVar.a(inputFrameInfoElement);
        for (int i2 = 0; i2 < this.inputSources.size(); i2++) {
            if (this.inputSources.keyAt(i2) != this.primaryInputIndex) {
                InputSource inputSourceValueAt = this.inputSources.valueAt(i2);
                if (inputSourceValueAt.frameInfos.size() == 1 && !inputSourceValueAt.isInputEnded) {
                    return ImmutableList.of();
                }
                Iterator<InputFrameInfo> it = inputSourceValueAt.frameInfos.iterator();
                long j = Long.MAX_VALUE;
                InputFrameInfo inputFrameInfo = null;
                while (it.hasNext()) {
                    InputFrameInfo next = it.next();
                    long j2 = next.timedGlTextureInfo.presentationTimeUs;
                    long jAbs = Math.abs(j2 - inputFrameInfoElement.timedGlTextureInfo.presentationTimeUs);
                    if (jAbs < j) {
                        inputFrameInfo = next;
                        j = jAbs;
                    }
                    if (j2 > inputFrameInfoElement.timedGlTextureInfo.presentationTimeUs || (!it.hasNext() && inputSourceValueAt.isInputEnded)) {
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
        return inputFrameInfo.timedGlTextureInfo.presentationTimeUs <= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeComposite() throws VideoFrameProcessingException, GlUtil.GlException {
        ImmutableList<InputFrameInfo> framesToComposite = getFramesToComposite();
        if (framesToComposite.isEmpty()) {
            return;
        }
        InputFrameInfo inputFrameInfo = framesToComposite.get(this.primaryInputIndex);
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < framesToComposite.size(); i++) {
            GlTextureInfo glTextureInfo = framesToComposite.get(i).timedGlTextureInfo.glTextureInfo;
            aVar.a(new Size(glTextureInfo.width, glTextureInfo.height));
        }
        Size outputSize = this.videoCompositorSettings.getOutputSize(aVar.e());
        this.outputTexturePool.ensureConfigured(this.glObjectsProvider, outputSize.getWidth(), outputSize.getHeight());
        GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
        long j = inputFrameInfo.timedGlTextureInfo.presentationTimeUs;
        this.outputTextureTimestamps.add(j);
        this.compositorGlProgram.drawFrame(framesToComposite, glTextureInfoUseTexture);
        long jCreateGlSyncFence = GlUtil.createGlSyncFence();
        this.syncObjects.add(jCreateGlSyncFence);
        this.textureOutputListener.onTextureRendered(this, glTextureInfoUseTexture, j, jCreateGlSyncFence);
        InputSource inputSource = this.inputSources.get(this.primaryInputIndex);
        releaseFrames(inputSource, 1);
        releaseExcessFramesInAllSecondaryStreams();
        if (this.allInputsEnded && inputSource.frameInfos.isEmpty()) {
            this.listener.onEnded();
        }
    }

    private synchronized void releaseExcessFramesInAllSecondaryStreams() {
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (this.inputSources.keyAt(i) != this.primaryInputIndex) {
                releaseExcessFramesInSecondaryStream(this.inputSources.valueAt(i));
            }
        }
    }

    private synchronized void releaseExcessFramesInSecondaryStream(InputSource inputSource) {
        InputSource inputSource2 = this.inputSources.get(this.primaryInputIndex);
        if (inputSource2.frameInfos.isEmpty() && inputSource2.isInputEnded) {
            releaseFrames(inputSource, inputSource.frameInfos.size());
            return;
        }
        InputFrameInfo inputFrameInfoPeek = inputSource2.frameInfos.peek();
        final long j = inputFrameInfoPeek != null ? inputFrameInfoPeek.timedGlTextureInfo.presentationTimeUs : -9223372036854775807L;
        releaseFrames(inputSource, Math.max(bv2.n(bv2.e(inputSource.frameInfos, new em4() { // from class: androidx.media3.effect.o
            @Override // defpackage.em4
            public final boolean apply(Object obj) {
                return DefaultVideoCompositor.lambda$releaseExcessFramesInSecondaryStream$1(j, (DefaultVideoCompositor.InputFrameInfo) obj);
            }
        })) - 1, 0));
    }

    private synchronized void releaseFrames(InputSource inputSource, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            InputFrameInfo inputFrameInfoRemove = inputSource.frameInfos.remove();
            inputFrameInfoRemove.textureProducer.releaseOutputTexture(inputFrameInfoRemove.timedGlTextureInfo.presentationTimeUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseGlObjects() {
        try {
            this.compositorGlProgram.release();
            this.outputTexturePool.deleteAllTextures();
            GlUtil.destroyEglSurface(this.eglDisplay, this.placeholderEglSurface);
        } catch (GlUtil.GlException e) {
            Log.e(TAG, "Error releasing GL resources", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public void setupGlObjects() throws GlUtil.GlException {
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        this.eglDisplay = defaultEglDisplay;
        this.placeholderEglSurface = this.glObjectsProvider.createFocusedPlaceholderEglSurface(this.glObjectsProvider.createEglContext(defaultEglDisplay, 2, GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888), this.eglDisplay);
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void queueInputTexture(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j) {
        Assertions.checkState(Util.contains(this.inputSources, i));
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
        inputSource.frameInfos.add(new InputFrameInfo(glTextureProducer, new TimedGlTextureInfo(glTextureInfo, j), this.videoCompositorSettings.getOverlaySettings(i, j)));
        if (i == this.primaryInputIndex) {
            releaseExcessFramesInAllSecondaryStreams();
        } else {
            releaseExcessFramesInSecondaryStream(inputSource);
        }
        this.videoFrameProcessingTaskExecutor.submit(new l(this));
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void registerInputSource(int i) {
        Assertions.checkState(!Util.contains(this.inputSources, i));
        this.inputSources.put(i, new InputSource());
        if (this.primaryInputIndex == -1) {
            this.primaryInputIndex = i;
        }
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void release() {
        try {
            this.videoFrameProcessingTaskExecutor.release(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.k
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f1326a.releaseGlObjects();
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.p
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f1341a.lambda$releaseOutputTexture$0(j);
            }
        });
    }

    @Override // androidx.media3.effect.VideoCompositor
    public void setVideoCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        this.videoCompositorSettings = videoCompositorSettings;
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void signalEndOfInputSource(int i) {
        Assertions.checkState(Util.contains(this.inputSources, i));
        boolean z = false;
        Assertions.checkState(this.primaryInputIndex != -1);
        this.inputSources.get(i).isInputEnded = true;
        int i2 = 0;
        while (true) {
            if (i2 >= this.inputSources.size()) {
                z = true;
                break;
            } else if (!this.inputSources.valueAt(i2).isInputEnded) {
                break;
            } else {
                i2++;
            }
        }
        this.allInputsEnded = z;
        if (this.inputSources.get(this.primaryInputIndex).frameInfos.isEmpty()) {
            if (i == this.primaryInputIndex) {
                releaseExcessFramesInAllSecondaryStreams();
            }
            if (z) {
                this.listener.onEnded();
                return;
            }
        }
        if (i != this.primaryInputIndex && this.inputSources.get(i).frameInfos.size() == 1) {
            this.videoFrameProcessingTaskExecutor.submit(new l(this));
        }
    }
}
