package defpackage;

import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface i43 {
    void a(e0 e0Var, kk3 kk3Var, z[] zVarArr, vz5 vz5Var, or1[] or1VarArr);

    boolean b(e0 e0Var, kk3 kk3Var, long j, float f, boolean z, long j2);

    w9 getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);
}
