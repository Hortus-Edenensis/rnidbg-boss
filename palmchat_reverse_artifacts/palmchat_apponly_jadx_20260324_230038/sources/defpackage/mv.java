package defpackage;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mv implements ci2 {
    public static final vk4 d = new vk4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final os1 f19372a;
    public final m b;
    public final jy5 c;

    public mv(os1 os1Var, m mVar, jy5 jy5Var) {
        this.f19372a = os1Var;
        this.b = mVar;
        this.c = jy5Var;
    }

    @Override // defpackage.ci2
    public boolean a(ps1 ps1Var) throws IOException {
        return this.f19372a.c(ps1Var, d) == 0;
    }

    @Override // defpackage.ci2
    public void b(qs1 qs1Var) {
        this.f19372a.b(qs1Var);
    }

    @Override // defpackage.ci2
    public void c() {
        this.f19372a.seek(0L, 0L);
    }

    @Override // defpackage.ci2
    public boolean d() {
        os1 os1Var = this.f19372a;
        return (os1Var instanceof i26) || (os1Var instanceof b32);
    }

    @Override // defpackage.ci2
    public boolean e() {
        os1 os1Var = this.f19372a;
        return (os1Var instanceof c8) || (os1Var instanceof f2) || (os1Var instanceof l2) || (os1Var instanceof or3);
    }

    @Override // defpackage.ci2
    public ci2 recreate() {
        os1 or3Var;
        vh.g(!d());
        os1 os1Var = this.f19372a;
        if (os1Var instanceof gk6) {
            or3Var = new gk6(this.b.c, this.c);
        } else if (os1Var instanceof c8) {
            or3Var = new c8();
        } else if (os1Var instanceof f2) {
            or3Var = new f2();
        } else if (os1Var instanceof l2) {
            or3Var = new l2();
        } else {
            if (!(os1Var instanceof or3)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f19372a.getClass().getSimpleName());
            }
            or3Var = new or3();
        }
        return new mv(or3Var, this.b, this.c);
    }
}
