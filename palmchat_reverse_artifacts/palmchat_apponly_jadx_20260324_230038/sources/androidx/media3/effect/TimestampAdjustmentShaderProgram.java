package androidx.media3.effect;

import androidx.annotation.Nullable;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampConsumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.TimestampAdjustment;
import defpackage.cc2;
import defpackage.ec2;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class TimestampAdjustmentShaderProgram implements GlShaderProgram {

    @Nullable
    private GlTextureInfo inputTexture;
    private final TimestampAdjustment.TimestampMap timestampMap;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.1
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
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.2
        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onCurrentOutputStreamEnded() {
            ec2.a(this);
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            ec2.b(this, glTextureInfo, j);
        }
    };
    private final AtomicInteger pendingCallbacksCount = new AtomicInteger();
    private final AtomicBoolean pendingEndOfStream = new AtomicBoolean();

    public TimestampAdjustmentShaderProgram(TimestampAdjustment.TimestampMap timestampMap) {
        this.timestampMap = timestampMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOutputTimeAvailable(long j) {
        this.outputListener.onOutputFrameAvailable((GlTextureInfo) Assertions.checkNotNull(this.inputTexture), j);
        if (this.pendingEndOfStream.get()) {
            this.outputListener.onCurrentOutputStreamEnded();
            this.pendingEndOfStream.set(false);
        }
        this.pendingCallbacksCount.decrementAndGet();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        throw new UnsupportedOperationException("This effect is not supported for previewing.");
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        this.inputTexture = glTextureInfo;
        this.timestampMap.calculateOutputTimeUs(j, new TimestampConsumer() { // from class: ly5
            @Override // androidx.media3.common.util.TimestampConsumer
            public final void onTimestamp(long j2) {
                this.f19106a.onOutputTimeAvailable(j2);
            }
        });
        this.pendingCallbacksCount.incrementAndGet();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.inputTexture = null;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        Assertions.checkState(glTextureInfo.texId == ((GlTextureInfo) Assertions.checkNotNull(this.inputTexture)).texId);
        this.inputListener.onInputFrameProcessed(glTextureInfo);
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.inputTexture == null) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        if (this.pendingCallbacksCount.get() == 0) {
            this.outputListener.onCurrentOutputStreamEnded();
        } else {
            this.pendingEndOfStream.set(true);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
    }
}
