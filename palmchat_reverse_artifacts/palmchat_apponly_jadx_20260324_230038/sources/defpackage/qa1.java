package defpackage;

import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class qa1 implements GlShaderProgram.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoFrameProcessor.Listener f20211a;

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.ErrorListener
    public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
        this.f20211a.onError(videoFrameProcessingException);
    }
}
