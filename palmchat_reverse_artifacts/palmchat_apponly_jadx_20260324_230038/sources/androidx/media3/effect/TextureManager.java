package androidx.media3.effect;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import defpackage.cc2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
abstract class TextureManager implements GlShaderProgram.InputListener {
    private final Object lock = new Object();

    @Nullable
    @GuardedBy("lock")
    private VideoFrameProcessingTaskExecutor.Task onFlushCompleteTask;
    protected final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public TextureManager(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
    }

    public void flush() throws VideoFrameProcessingException {
        synchronized (this.lock) {
            VideoFrameProcessingTaskExecutor.Task task = this.onFlushCompleteTask;
            if (task != null) {
                this.videoFrameProcessingTaskExecutor.submitWithHighPriority(task);
            }
        }
    }

    public Surface getInputSurface() {
        throw new UnsupportedOperationException();
    }

    public abstract int getPendingFrameCount();

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public final void onFlush() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.q1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException {
                this.f1346a.flush();
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        cc2.b(this, glTextureInfo);
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onReadyToAcceptInputFrame() {
        cc2.c(this);
    }

    public void queueInputBitmap(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    public void queueInputTexture(int i, long j) {
        throw new UnsupportedOperationException();
    }

    public void registerInputFrame(FrameInfo frameInfo) {
        throw new UnsupportedOperationException();
    }

    public abstract void release() throws VideoFrameProcessingException;

    public void setDefaultBufferSize(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public final void setOnFlushCompleteListener(@Nullable VideoFrameProcessingTaskExecutor.Task task) {
        synchronized (this.lock) {
            this.onFlushCompleteTask = task;
        }
    }

    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        throw new UnsupportedOperationException();
    }

    public abstract void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram);

    public abstract void signalEndOfCurrentInputStream();

    public void dropIncomingRegisteredFrames() {
    }

    public void releaseAllRegisteredFrames() {
    }

    public void setInputFrameInfo(FrameInfo frameInfo, boolean z) {
    }
}
