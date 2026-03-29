package com.oplus.tblplayer.processor;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.FrameCache;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.utils.AssertUtil;
import defpackage.bc2;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public final class HomoShaderProgram implements GlShaderProgram, GlShaderProgram.InputListener {
    private static final long DEFAULT_TIME_DIFFERENCE_US = 5000;
    private final GlShaderProgram mCopyShaderProgram;
    private HomoMatrixTransformationEffect mHomoMatrixTransEffect;
    private int mPendingCopyGlShaderProgramFrames;
    private int mPendingWrappedGlShaderProgramFrames;
    private final GlShaderProgram mWrappedShaderProgram;
    private final WrappedShaderProgramInputListener mWrappedShaderProgramInputListener;

    public HomoShaderProgram(Context context, boolean z, HomoMatrixTransformationEffect homoMatrixTransformationEffect) throws VideoFrameProcessingException {
        this.mHomoMatrixTransEffect = homoMatrixTransformationEffect;
        BaseGlShaderProgram glShaderProgram = homoMatrixTransformationEffect.mGlEffect.toGlShaderProgram(context, z);
        this.mWrappedShaderProgram = glShaderProgram;
        WrappedShaderProgramInputListener wrappedShaderProgramInputListener = new WrappedShaderProgramInputListener();
        this.mWrappedShaderProgramInputListener = wrappedShaderProgramInputListener;
        glShaderProgram.setInputListener(wrappedShaderProgramInputListener);
        this.mCopyShaderProgram = new FrameCache(wrappedShaderProgramInputListener.readyFrameCount).toGlShaderProgram(context, z);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void flush() {
        this.mWrappedShaderProgramInputListener.setToForwardingMode(false);
        this.mWrappedShaderProgram.flush();
        this.mWrappedShaderProgramInputListener.setToForwardingMode(true);
        this.mCopyShaderProgram.flush();
        this.mPendingCopyGlShaderProgramFrames = 0;
        this.mPendingWrappedGlShaderProgramFrames = 0;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onFlush() {
        bc2.a(this);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        bc2.b(this, glTextureInfo);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
    public /* synthetic */ void onReadyToAcceptInputFrame() {
        bc2.c(this);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        GlShaderProgram glShaderProgram;
        long startTimeUs = this.mHomoMatrixTransEffect.getStartTimeUs();
        long endTimeUs = this.mHomoMatrixTransEffect.getEndTimeUs();
        if (startTimeUs == -9223372036854775807L || endTimeUs == -9223372036854775807L || startTimeUs - 5000 > j || j > endTimeUs + 5000) {
            this.mPendingCopyGlShaderProgramFrames++;
            glShaderProgram = this.mCopyShaderProgram;
        } else {
            this.mPendingWrappedGlShaderProgramFrames++;
            glShaderProgram = this.mWrappedShaderProgram;
        }
        glShaderProgram.queueInputFrame(glObjectsProvider, glTextureInfo, j);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.mCopyShaderProgram.release();
        this.mWrappedShaderProgram.release();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.mPendingCopyGlShaderProgramFrames > 0) {
            this.mCopyShaderProgram.releaseOutputFrame(glTextureInfo);
            this.mPendingCopyGlShaderProgramFrames--;
        } else {
            if (this.mPendingWrappedGlShaderProgramFrames <= 0) {
                throw new IllegalArgumentException("Output texture not contained in either shader.");
            }
            this.mWrappedShaderProgram.releaseOutputFrame(glTextureInfo);
            this.mPendingWrappedGlShaderProgramFrames--;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.mWrappedShaderProgram.setErrorListener(executor, errorListener);
        this.mCopyShaderProgram.setErrorListener(executor, errorListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.mWrappedShaderProgramInputListener.setListener(inputListener);
        this.mWrappedShaderProgramInputListener.setToForwardingMode(true);
        this.mCopyShaderProgram.setInputListener(inputListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.mWrappedShaderProgram.setOutputListener(outputListener);
        this.mCopyShaderProgram.setOutputListener(outputListener);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.mWrappedShaderProgram.signalEndOfCurrentInputStream();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class WrappedShaderProgramInputListener implements GlShaderProgram.InputListener {
        private boolean mForwardCalls;
        private GlShaderProgram.InputListener mListener;
        public int readyFrameCount;

        private WrappedShaderProgramInputListener() {
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            ((GlShaderProgram.InputListener) AssertUtil.checkNotNull(this.mListener)).onInputFrameProcessed(glTextureInfo);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public void onReadyToAcceptInputFrame() {
            GlShaderProgram.InputListener inputListener = this.mListener;
            if (inputListener == null) {
                this.readyFrameCount++;
            }
            if (this.mForwardCalls) {
                ((GlShaderProgram.InputListener) AssertUtil.checkNotNull(inputListener)).onReadyToAcceptInputFrame();
            }
        }

        public void setListener(GlShaderProgram.InputListener inputListener) {
            this.mListener = inputListener;
        }

        public void setToForwardingMode(boolean z) {
            AssertUtil.checkState((z && this.mListener == null) ? false : true);
            this.mForwardCalls = z;
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public void onFlush() {
        }
    }
}
