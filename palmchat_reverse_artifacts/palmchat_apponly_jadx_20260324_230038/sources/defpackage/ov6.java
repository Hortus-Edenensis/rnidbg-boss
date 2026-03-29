package defpackage;

import android.content.Context;
import com.apm.lite.CrashType;
import com.bytedance.pangle.provider.ContentProviderManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ov6 extends y37 {
    public ov6(Context context, nz6 nz6Var, b87 b87Var) {
        super(CrashType.ANR, context, nz6Var, b87Var);
    }

    @Override // defpackage.y37
    public ev6 b(ev6 ev6Var) {
        ev6 ev6VarB = super.b(ev6Var);
        q37 q37VarA = q37.a(this.b);
        q37.c(q37VarA);
        q37.h(q37VarA);
        q37VarA.m();
        q37VarA.o();
        q37VarA.q();
        ev6VarB.d(q37VarA);
        ev6VarB.j(ContentProviderManager.PLUGIN_PROCESS_NAME, kv6.m(this.b));
        uj7.a(ev6VarB, q37VarA, this.f22116a);
        return ev6VarB;
    }

    @Override // defpackage.y37
    public boolean d() {
        return true;
    }
}
