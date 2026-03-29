package defpackage;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class iv2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw2 {
        public Context c;
        public String d;
        public Bundle e;

        public a(Context context, String str, Bundle bundle) {
            this.c = context;
            this.d = str;
            this.e = bundle;
            this.f22293a = str + "#BundleAction";
        }

        @Override // defpackage.yw2
        public void a() {
            try {
                iv2.this.c(this.c, this.d, this.e);
            } catch (Throwable th) {
                p63.f("JCommon", "BundleAction failed:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends yw2 {
        public Context c;
        public String d;

        public b(Context context, String str) {
            this.c = context;
            this.d = str;
            this.f22293a = str + "#CommonAction";
        }

        @Override // defpackage.yw2
        public void a() {
            try {
                iv2.this.d(this.c, this.d);
            } catch (Throwable th) {
                p63.f("JCommon", "dealAction failed:" + th.getMessage());
            }
        }
    }

    public final void c(Context context, String str, Bundle bundle) {
        q(str, bundle);
        boolean zJ = j();
        p63.a("JCommon", str + " isActionBundleEnable:" + zJ);
        if (zJ) {
            e(context, str);
            r(context, str);
        }
    }

    public final void d(Context context, String str) {
        boolean zO = o(context, str);
        p63.a("JCommon", str + " isBusinessEnable:" + zO);
        if (zO) {
            e(context, str);
        }
        boolean zP = p(context, str);
        p63.a("JCommon", str + " isReportEnable:" + zP);
        if (zP) {
            r(context, str);
        }
    }

    public abstract void e(Context context, String str);

    public void f(Context context) {
        try {
            String strI = i(context);
            p63.a("JCommon", "executeAction: [" + strI + "] from heartBeat");
            boolean zL = l(context, strI);
            boolean zO = o(context, strI);
            p63.a("JCommon", strI + " - isActionEnable:" + zL + ", isBusinessEnable:" + zO);
            if (zL && zO) {
                rv2.F(new b(context, strI));
            }
        } catch (Throwable th) {
            p63.a("JCommon", "executeAction failed, error:" + th);
        }
    }

    public void g(Context context, Bundle bundle) {
        String strI = i(context);
        p63.a("JCommon", "executeBundleAction: [" + strI + "] from bundle");
        boolean zN = n();
        p63.a("JCommon", strI + " isActionUserEnable:" + zN);
        if (zN) {
            rv2.F(new a(context, strI, bundle));
        }
    }

    public void h(Context context) {
        String strI = i(context);
        p63.a("JCommon", "executeCommandAction: [" + strI + "] from cmd");
        if (l(context, strI)) {
            rv2.F(new b(context, strI));
        }
    }

    public abstract String i(Context context);

    public boolean j() {
        return true;
    }

    public boolean k() {
        return true;
    }

    public final boolean l(Context context, String str) {
        boolean zN = n();
        boolean zK = k();
        boolean zM = m(context);
        boolean z = zN && zK && zM;
        p63.a("JCommon", str + " isActionEnable:" + z + ",actionUserEnable:" + zN + ",actionCommandEnable:" + zK + ",actionUidEnable:" + zM);
        return z;
    }

    public boolean m(Context context) {
        return rv2.u(context) > 0;
    }

    public boolean n() {
        return true;
    }

    public boolean o(Context context, String str) {
        return kv2.w(context, str);
    }

    public boolean p(Context context, String str) {
        return kv2.w(context, str);
    }

    public void q(String str, Bundle bundle) {
        if (bundle != null) {
            p63.a("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    public void r(Context context, String str) {
        kv2.F(context, str);
    }
}
