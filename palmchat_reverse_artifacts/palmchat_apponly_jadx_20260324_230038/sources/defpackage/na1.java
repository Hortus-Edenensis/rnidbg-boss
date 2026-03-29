package defpackage;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.effect.GlShaderProgram;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class na1 implements GlShaderProgram.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoFrameProcessor.Listener f19470a;

    @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
    public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
        this.f19470a.onError(videoFrameProcessingException);
    }
}
