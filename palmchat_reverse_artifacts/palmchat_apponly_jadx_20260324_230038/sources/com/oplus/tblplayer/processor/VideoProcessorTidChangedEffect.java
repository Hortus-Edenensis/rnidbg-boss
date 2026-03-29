package com.oplus.tblplayer.processor;

import android.content.Context;
import android.os.Process;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram;
import defpackage.yb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class VideoProcessorTidChangedEffect implements GlEffect {
    private VideoProcessorTidChangedListener mListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface VideoProcessorTidChangedListener {
        void onVideoProcessorTidChanged(int i);
    }

    public VideoProcessorTidChangedEffect(VideoProcessorTidChangedListener videoProcessorTidChangedListener) {
        this.mListener = videoProcessorTidChangedListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        this.mListener.onVideoProcessorTidChanged(Process.myTid());
        return new PassthroughShaderProgram();
    }
}
