package defpackage;

import android.content.Context;
import com.apm.lite.CrashType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class if7 extends y37 {
    public if7(Context context, nz6 nz6Var, b87 b87Var) {
        super(CrashType.NATIVE, context, nz6Var, b87Var);
    }

    @Override // defpackage.y37
    public ev6 a(int i, ev6 ev6Var) {
        ev6 ev6VarA = super.a(i, ev6Var);
        if (i == 0) {
            q37 q37VarA = q37.a(this.b);
            q37VarA.m();
            ev6VarA.d(q37VarA);
            uj7.a(ev6VarA, q37VarA, this.f22116a);
        } else if (i == 1) {
            q37 q37VarH = ev6VarA.H();
            q37VarH.o();
            q37VarH.q();
        } else if (i == 2) {
            q37.c(ev6VarA.H());
        }
        return ev6VarA;
    }

    @Override // defpackage.y37
    public boolean d() {
        return false;
    }

    @Override // defpackage.y37
    public int e() {
        return mz6.a();
    }

    @Override // defpackage.y37
    public boolean j() {
        return false;
    }

    @Override // defpackage.y37
    public void n(ev6 ev6Var) {
    }
}
