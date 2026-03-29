package defpackage;

import android.content.Context;
import com.bytedance.u.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jm7 extends bd7 {
    public jm7(Context context, ui7 ui7Var, b17 b17Var) {
        super(fx.JAVA, context, ui7Var, b17Var);
    }

    @Override // defpackage.bd7
    public ql7 f(ql7 ql7Var) {
        ql7 ql7VarF = super.f(ql7Var);
        ql7VarF.n("app_count", 1);
        ql7VarF.n("magic_tag", "ss_app_log");
        b(ql7VarF);
        oi7 oi7VarI = oi7.i(this.b);
        oi7VarI.l(uh7.j().e());
        oi7VarI.k(uh7.c().a());
        oi7VarI.f(this.c.fx());
        ql7VarF.k(oi7VarI);
        fk7.c(ql7VarF, oi7VarI, this.f1698a);
        return ql7VarF;
    }
}
