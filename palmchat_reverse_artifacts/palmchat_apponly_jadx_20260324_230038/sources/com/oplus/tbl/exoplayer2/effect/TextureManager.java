package com.oplus.tbl.exoplayer2.effect;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor;
import com.oplus.tbl.exoplayer2.util.TimestampIterator;
import defpackage.bc2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class TextureManager implements GlShaderProgram.InputListener {
    private final Object lock = new Object();

    @Nullable
    @GuardedBy("lock")
    private VideoFrameProcessingTaskExecutor.Task onFlushCompleteTask;
    protected final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public TextureManager(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
    }

    public void flush() {
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

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public final void onFlush() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: com.oplus.tbl.exoplayer2.effect.d1
            @Override // com.oplus.tbl.exoplayer2.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f7594a.flush();
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        bc2.b(this, glTextureInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onReadyToAcceptInputFrame() {
        bc2.c(this);
    }

    public void queueInputBitmap(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator, boolean z) {
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

    public void releaseAllRegisteredFrames() {
    }

    public void setInputFrameInfo(FrameInfo frameInfo) {
    }
}
