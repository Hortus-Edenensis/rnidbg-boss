package androidx.media3.effect;

import android.opengl.GLES20;
import android.os.Build;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.effect.ByteBufferGlEffect;
import androidx.media3.effect.QueuingGlShaderProgram;
import defpackage.ai;
import defpackage.o65;
import defpackage.r33;
import defpackage.z42;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class ByteBufferConcurrentEffect<T> implements QueuingGlShaderProgram.ConcurrentEffect<T> {
    private static final int BYTES_PER_PIXEL = 4;
    private GlTextureInfo effectInputTexture;
    private final int pendingPixelBufferQueueSize;
    private final ByteBufferGlEffect.Processor<T> processor;
    private final Queue<TexturePixelBuffer> unmappedPixelBuffers = new ArrayDeque();
    private final Queue<TexturePixelBuffer> mappedPixelBuffers = new ArrayDeque();
    private final PixelBufferObjectProvider pixelBufferObjectProvider = new PixelBufferObjectProvider();
    private int inputWidth = -1;
    private int inputHeight = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static final class PixelBufferObjectInfo {
        public final int id;
        public final int size;

        public PixelBufferObjectInfo(int i) throws GlUtil.GlException {
            this.size = i;
            this.id = GlUtil.createPixelBufferObject(i);
        }

        public void release() throws GlUtil.GlException {
            GlUtil.deleteBuffer(this.id);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PixelBufferObjectProvider {
        private final Queue<PixelBufferObjectInfo> availablePixelBufferObjects = new ArrayDeque();

        /* JADX INFO: Access modifiers changed from: private */
        public PixelBufferObjectInfo getPixelBufferObject(int i) throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfoPoll = this.availablePixelBufferObjects.poll();
                if (pixelBufferObjectInfoPoll == null) {
                    return new PixelBufferObjectInfo(i);
                }
                if (pixelBufferObjectInfoPoll.size == i) {
                    return pixelBufferObjectInfoPoll;
                }
                GlUtil.deleteBuffer(pixelBufferObjectInfoPoll.id);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle(PixelBufferObjectInfo pixelBufferObjectInfo) {
            this.availablePixelBufferObjects.add(pixelBufferObjectInfo);
        }

        public void release() throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfoPoll = this.availablePixelBufferObjects.poll();
                if (pixelBufferObjectInfoPoll == null) {
                    return;
                } else {
                    pixelBufferObjectInfoPoll.release();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TexturePixelBuffer {
        public final o65<ByteBufferGlEffect.Image> imageSettableFuture = o65.E();
        private boolean mapped;
        private PixelBufferObjectInfo pixelBufferObjectInfo;
        private final GlTextureInfo textureInfo;

        public TexturePixelBuffer(GlTextureInfo glTextureInfo) {
            this.textureInfo = glTextureInfo;
        }

        public void map() throws GlUtil.GlException {
            ByteBuffer byteBufferAllocateDirect;
            Assertions.checkNotNull(this.pixelBufferObjectInfo);
            if (Build.VERSION.SDK_INT >= 24) {
                PixelBufferObjectInfo pixelBufferObjectInfo = this.pixelBufferObjectInfo;
                byteBufferAllocateDirect = GlUtil.mapPixelBufferObject(pixelBufferObjectInfo.id, pixelBufferObjectInfo.size);
            } else {
                byteBufferAllocateDirect = ByteBuffer.allocateDirect(ByteBufferConcurrentEffect.texturePixelBufferSize(this.textureInfo));
                GlTextureInfo glTextureInfo = this.textureInfo;
                GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
                GlUtil.checkGlError();
                GlTextureInfo glTextureInfo2 = this.textureInfo;
                GLES20.glReadPixels(0, 0, glTextureInfo2.width, glTextureInfo2.height, 6408, 5121, byteBufferAllocateDirect);
                GlUtil.checkGlError();
            }
            o65<ByteBufferGlEffect.Image> o65Var = this.imageSettableFuture;
            GlTextureInfo glTextureInfo3 = this.textureInfo;
            o65Var.A(new ByteBufferGlEffect.Image(glTextureInfo3.width, glTextureInfo3.height, byteBufferAllocateDirect));
            this.mapped = true;
        }

        public void schedulePixelBufferRead(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            PixelBufferObjectInfo pixelBufferObject = pixelBufferObjectProvider.getPixelBufferObject(ByteBufferConcurrentEffect.texturePixelBufferSize(this.textureInfo));
            this.pixelBufferObjectInfo = pixelBufferObject;
            if (Build.VERSION.SDK_INT >= 24) {
                GlTextureInfo glTextureInfo = this.textureInfo;
                GlUtil.schedulePixelBufferRead(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height, pixelBufferObject.id);
            }
        }

        public void unmapAndRecycle(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            Assertions.checkNotNull(this.pixelBufferObjectInfo);
            if (this.mapped && Build.VERSION.SDK_INT >= 24) {
                GlUtil.unmapPixelBufferObject(this.pixelBufferObjectInfo.id);
            }
            pixelBufferObjectProvider.recycle(this.pixelBufferObjectInfo);
        }
    }

    public ByteBufferConcurrentEffect(int i, ByteBufferGlEffect.Processor<T> processor) {
        this.processor = processor;
        this.pendingPixelBufferQueueSize = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r33 lambda$queueInputFrame$0(long j, ByteBufferGlEffect.Image image) throws Exception {
        return this.processor.processImage(image, j);
    }

    private boolean mapOnePixelBuffer() throws GlUtil.GlException {
        TexturePixelBuffer texturePixelBufferPoll = this.unmappedPixelBuffers.poll();
        if (texturePixelBufferPoll == null) {
            return false;
        }
        texturePixelBufferPoll.map();
        this.mappedPixelBuffers.add(texturePixelBufferPoll);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int texturePixelBufferSize(GlTextureInfo glTextureInfo) {
        return glTextureInfo.width * glTextureInfo.height * 4;
    }

    private void unmapAndRecyclePixelBuffers() throws GlUtil.GlException {
        while (true) {
            TexturePixelBuffer texturePixelBufferPoll = this.unmappedPixelBuffers.poll();
            if (texturePixelBufferPoll == null) {
                break;
            } else {
                texturePixelBufferPoll.unmapAndRecycle(this.pixelBufferObjectProvider);
            }
        }
        while (true) {
            TexturePixelBuffer texturePixelBufferPoll2 = this.mappedPixelBuffers.poll();
            if (texturePixelBufferPoll2 == null) {
                return;
            } else {
                texturePixelBufferPoll2.unmapAndRecycle(this.pixelBufferObjectProvider);
            }
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void finishProcessingAndBlend(GlTextureInfo glTextureInfo, long j, T t) throws VideoFrameProcessingException {
        try {
            ((TexturePixelBuffer) Assertions.checkNotNull(this.mappedPixelBuffers.poll())).unmapAndRecycle(this.pixelBufferObjectProvider);
            this.processor.finishProcessingAndBlend(glTextureInfo, j, t);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void flush() throws VideoFrameProcessingException {
        try {
            unmapAndRecyclePixelBuffers();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public Future<T> queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        while (this.unmappedPixelBuffers.size() >= this.pendingPixelBufferQueueSize) {
            try {
                Assertions.checkState(mapOnePixelBuffer());
            } catch (VideoFrameProcessingException | GlUtil.GlException e) {
                return z42.e(e);
            }
        }
        if (this.effectInputTexture == null || glTextureInfo.width != this.inputWidth || glTextureInfo.height != this.inputHeight) {
            while (mapOnePixelBuffer()) {
            }
            int i = glTextureInfo.width;
            this.inputWidth = i;
            int i2 = glTextureInfo.height;
            this.inputHeight = i2;
            Size sizeConfigure = this.processor.configure(i, i2);
            GlTextureInfo glTextureInfo2 = this.effectInputTexture;
            if (glTextureInfo2 != null) {
                glTextureInfo2.release();
            }
            this.effectInputTexture = glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(sizeConfigure.getWidth(), sizeConfigure.getHeight(), false), sizeConfigure.getWidth(), sizeConfigure.getHeight());
        }
        int i3 = glTextureInfo.fboId;
        GlRect scaledRegion = this.processor.getScaledRegion(j);
        GlTextureInfo glTextureInfo3 = this.effectInputTexture;
        GlUtil.blitFrameBuffer(i3, scaledRegion, glTextureInfo3.fboId, new GlRect(glTextureInfo3.width, glTextureInfo3.height));
        TexturePixelBuffer texturePixelBuffer = new TexturePixelBuffer(this.effectInputTexture);
        texturePixelBuffer.schedulePixelBufferRead(this.pixelBufferObjectProvider);
        this.unmappedPixelBuffers.add(texturePixelBuffer);
        return Util.transformFutureAsync(texturePixelBuffer.imageSettableFuture, new ai() { // from class: androidx.media3.effect.e
            @Override // defpackage.ai
            public final r33 apply(Object obj) {
                return this.f1312a.lambda$queueInputFrame$0(j, (ByteBufferGlEffect.Image) obj);
            }
        });
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void release() throws VideoFrameProcessingException {
        try {
            unmapAndRecyclePixelBuffers();
            this.pixelBufferObjectProvider.release();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void signalEndOfCurrentInputStream() throws VideoFrameProcessingException {
        do {
            try {
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        } while (mapOnePixelBuffer());
    }
}
