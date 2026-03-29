package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p16> f20222a = new ArrayList(2);
    public final Context b;
    public cl2 c;

    public qc(Context context, cl2 cl2Var) {
        new i41();
        this.b = context;
        this.c = cl2Var;
        a();
    }

    public final void a() {
        this.f20222a.clear();
        cl2 cl2Var = this.c;
        if (cl2Var != null) {
            if (cl2Var.isSunsetSupport()) {
                this.f20222a.add(new sn5(this.b));
            }
            if (this.c.isDintingSupport()) {
                this.f20222a.add(new jd1(this.b));
            }
        }
    }

    public void b() {
        for (p16 p16Var : this.f20222a) {
            if (p16Var != null) {
                p16Var.register();
            }
        }
    }
}
