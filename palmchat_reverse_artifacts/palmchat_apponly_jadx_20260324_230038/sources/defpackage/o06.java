package defpackage;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class o06 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public a f19652a;

    @Nullable
    public dp b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(z zVar);

        void onTrackSelectionsInvalidated();
    }

    public final dp b() {
        return (dp) vh.i(this.b);
    }

    public k06 c() {
        return k06.A;
    }

    @Nullable
    public a0.a d() {
        return null;
    }

    @CallSuper
    public void e(a aVar, dp dpVar) {
        this.f19652a = aVar;
        this.b = dpVar;
    }

    public final void f() {
        a aVar = this.f19652a;
        if (aVar != null) {
            aVar.onTrackSelectionsInvalidated();
        }
    }

    public final void g(z zVar) {
        a aVar = this.f19652a;
        if (aVar != null) {
            aVar.a(zVar);
        }
    }

    public boolean h() {
        return false;
    }

    public abstract void i(@Nullable Object obj);

    @CallSuper
    public void j() {
        this.f19652a = null;
        this.b = null;
    }

    public abstract p06 k(a0[] a0VarArr, vz5 vz5Var, i.b bVar, e0 e0Var) throws ExoPlaybackException;

    public void l(com.google.android.exoplayer2.audio.a aVar) {
    }

    public void m(k06 k06Var) {
    }
}
