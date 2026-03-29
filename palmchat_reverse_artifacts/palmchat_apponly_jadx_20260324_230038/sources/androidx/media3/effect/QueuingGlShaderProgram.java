package androidx.media3.effect;

import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.GlShaderProgram;
import defpackage.cc2;
import defpackage.ec2;
import defpackage.er3;
import defpackage.z42;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
final class QueuingGlShaderProgram<T> implements GlShaderProgram {
    private static final long PROCESSING_TIMEOUT_MS = 500000;
    private static final String TAG = "QueuingGlShaderProgram";
    private final ConcurrentEffect<T> concurrentEffect;
    private GlShaderProgram.ErrorListener errorListener;
    private Executor errorListenerExecutor;
    private final Queue<QueuedFrame<T>> frameQueue;
    private int inputHeight;
    private GlShaderProgram.InputListener inputListener;
    private int inputWidth;
    private GlShaderProgram.OutputListener outputListener;
    private final TexturePool outputTexturePool;

    /* JADX INFO: compiled from: SearchBox */
    public interface ConcurrentEffect<T> {
        void finishProcessingAndBlend(GlTextureInfo glTextureInfo, long j, T t) throws VideoFrameProcessingException;

        void flush() throws VideoFrameProcessingException;

        Future<T> queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j);

        void release() throws VideoFrameProcessingException;

        void signalEndOfCurrentInputStream() throws VideoFrameProcessingException;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class QueuedFrame<T> {
        public final Future<T> task;
        public final TimedGlTextureInfo timedGlTextureInfo;

        public QueuedFrame(TimedGlTextureInfo timedGlTextureInfo, Future<T> future) {
            this.timedGlTextureInfo = timedGlTextureInfo;
            this.task = future;
        }
    }

    public QueuingGlShaderProgram(boolean z, @IntRange(from = 1) int i, ConcurrentEffect<T> concurrentEffect) {
        Assertions.checkArgument(i > 0);
        this.concurrentEffect = concurrentEffect;
        this.frameQueue = new ArrayDeque(i);
        this.outputTexturePool = new TexturePool(z, i);
        this.inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.1
            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onFlush() {
                cc2.a(this);
            }

            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
                cc2.b(this, glTextureInfo);
            }

            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onReadyToAcceptInputFrame() {
                cc2.c(this);
            }
        };
        this.outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.2
            @Override // androidx.media3.effect.GlShaderProgram.OutputListener
            public /* synthetic */ void onCurrentOutputStreamEnded() {
                ec2.a(this);
            }

            @Override // androidx.media3.effect.GlShaderProgram.OutputListener
            public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
                ec2.b(this, glTextureInfo, j);
            }
        };
        this.errorListener = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.e1
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                Log.e(QueuingGlShaderProgram.TAG, "Exception caught by default QueuingGlShaderProgram errorListener.", videoFrameProcessingException);
            }
        };
        this.errorListenerExecutor = er3.a();
        this.inputWidth = -1;
        this.inputHeight = -1;
    }

    private void cancelProcessingOfPendingFrames() {
        while (true) {
            QueuedFrame<T> queuedFramePoll = this.frameQueue.poll();
            if (queuedFramePoll == null) {
                return;
            } else {
                queuedFramePoll.task.cancel(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$1(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    private void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f1316a.lambda$onError$1(exc);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean outputOneFrame() {
        QueuedFrame<T> queuedFramePoll = this.frameQueue.poll();
        if (queuedFramePoll == null) {
            return false;
        }
        try {
            Object objB = z42.b(queuedFramePoll.task, VideoFrameProcessingException.class, PROCESSING_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            GlTextureInfo glTextureInfo = queuedFramePoll.timedGlTextureInfo.glTextureInfo;
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
            ConcurrentEffect<T> concurrentEffect = this.concurrentEffect;
            TimedGlTextureInfo timedGlTextureInfo = queuedFramePoll.timedGlTextureInfo;
            concurrentEffect.finishProcessingAndBlend(timedGlTextureInfo.glTextureInfo, timedGlTextureInfo.presentationTimeUs, objB);
            GlShaderProgram.OutputListener outputListener = this.outputListener;
            TimedGlTextureInfo timedGlTextureInfo2 = queuedFramePoll.timedGlTextureInfo;
            outputListener.onOutputFrameAvailable(timedGlTextureInfo2.glTextureInfo, timedGlTextureInfo2.presentationTimeUs);
            return true;
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            onError(e);
            return false;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    @CallSuper
    public void flush() {
        try {
            this.concurrentEffect.flush();
        } catch (VideoFrameProcessingException e) {
            onError(e);
        }
        cancelProcessingOfPendingFrames();
        this.outputTexturePool.freeAllTextures();
        this.inputListener.onFlush();
        for (int i = 0; i < this.outputTexturePool.capacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            if (this.inputWidth != glTextureInfo.width || this.inputHeight != glTextureInfo.height || !this.outputTexturePool.isConfigured()) {
                while (outputOneFrame()) {
                }
                int i = glTextureInfo.width;
                this.inputWidth = i;
                int i2 = glTextureInfo.height;
                this.inputHeight = i2;
                this.outputTexturePool.ensureConfigured(glObjectsProvider, i, i2);
            }
            GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
            Assertions.checkState(glTextureInfo.fboId != -1);
            GlUtil.blitFrameBuffer(glTextureInfo.fboId, new GlRect(this.inputWidth, this.inputHeight), glTextureInfoUseTexture.fboId, new GlRect(this.inputWidth, this.inputHeight));
            this.frameQueue.add(new QueuedFrame<>(new TimedGlTextureInfo(glTextureInfoUseTexture, j), this.concurrentEffect.queueInputFrame(glObjectsProvider, glTextureInfoUseTexture, j)));
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            if (this.frameQueue.size() == this.outputTexturePool.capacity()) {
                Assertions.checkState(outputOneFrame());
            }
        } catch (GlUtil.GlException e) {
            onError(e);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    @CallSuper
    public void release() throws VideoFrameProcessingException {
        try {
            cancelProcessingOfPendingFrames();
            this.concurrentEffect.release();
            this.outputTexturePool.deleteAllTextures();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.outputTexturePool.isUsingTexture(glTextureInfo)) {
            this.outputTexturePool.freeTexture(glTextureInfo);
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        for (int i = 0; i < this.outputTexturePool.freeTextureCount(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        try {
            this.concurrentEffect.signalEndOfCurrentInputStream();
        } catch (VideoFrameProcessingException e) {
            onError(e);
        }
        while (outputOneFrame()) {
        }
        this.outputListener.onCurrentOutputStreamEnded();
    }
}
