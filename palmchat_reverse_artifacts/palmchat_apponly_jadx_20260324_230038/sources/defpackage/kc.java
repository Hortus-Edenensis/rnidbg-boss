package defpackage;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.v;
import defpackage.dp;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface kc extends v.d, j, dp.a, b {
    void F(List<i.b> list, @Nullable i.b bVar);

    void G(oc ocVar);

    void a(m mVar, @Nullable ow0 ow0Var);

    void b(lw0 lw0Var);

    void c(lw0 lw0Var);

    void e(lw0 lw0Var);

    void j(lw0 lw0Var);

    void k(m mVar, @Nullable ow0 ow0Var);

    void notifySeekStarted();

    void o(v vVar, Looper looper);

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDecoderReleased(String str);

    void onAudioPositionAdvancing(long j);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i, long j, long j2);

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Object obj, long j);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDecoderReleased(String str);

    void onVideoFrameProcessingOffset(long j, int i);

    void release();
}
