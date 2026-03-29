package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import defpackage.b37;
import defpackage.f47;
import defpackage.z27;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k17 {
    public static boolean j = false;
    public static boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z27 f18552a;
    public l17 b;
    public bc7 c;
    public ew6 d;
    public n17 e;
    public k77 f;
    public k87 g;
    public Context h;
    public f47 i;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b37 f18553a = new b37();

        public b a(int i) {
            this.f18553a.b(i);
            return this;
        }

        public b b(mw6 mw6Var) {
            this.f18553a.c(mw6Var);
            return this;
        }

        public b c(b37.b bVar) {
            this.f18553a.d(bVar);
            return this;
        }

        public b d(b37.c cVar) {
            this.f18553a.e(cVar);
            return this;
        }

        public b e(String str) {
            this.f18553a.f(str);
            return this;
        }

        public k17 f(Context context) {
            if (TextUtils.isEmpty(this.f18553a.o()) || context == null || context.getFilesDir() == null) {
                return null;
            }
            String strM = this.f18553a.m();
            if (strM == null || strM.isEmpty()) {
                this.f18553a.l(g(context, context.getFilesDir().getAbsolutePath()));
            } else {
                this.f18553a.l(g(context, strM));
            }
            k17 k17Var = new k17();
            k17Var.c(context, this.f18553a);
            return k17Var;
        }

        public final String g(Context context, String str) {
            String str2;
            if (o17.b.isEmpty()) {
                if (TextUtils.isEmpty(ne7.f19501a)) {
                    int iMyPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    String str3 = null;
                    if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            if (next.pid == iMyPid) {
                                str3 = next.processName;
                                break;
                            }
                        }
                    }
                    ne7.f19501a = str3;
                }
                str2 = ne7.f19501a;
            } else {
                str2 = o17.b;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str + "/" + str2 + "/";
        }

        public b h(int i) {
            this.f18553a.h(i);
            return this;
        }

        public b i(String str) {
            this.f18553a.l(str);
            return this;
        }

        public b j(int i) {
            this.f18553a.k(i);
            return this;
        }

        public b k(String str) {
            this.f18553a.i(str);
            this.f18553a.n(str);
            return this;
        }

        public b l(String str) {
            this.f18553a.p(str);
            return this;
        }

        public b m(String str) {
            o17.b = str;
            return this;
        }
    }

    public k17() {
    }

    public static void j(boolean z) {
        j = z;
    }

    public static boolean k() {
        return j;
    }

    public static boolean l() {
        return k;
    }

    public static b m() {
        return new b();
    }

    public final cw6 a() {
        bc7 bc7Var = this.c;
        return bc7Var != null ? bc7Var : new bc7(null);
    }

    public final void b(int i) {
        bc7 bc7Var = this.c;
        if (bc7Var != null) {
            bc7Var.g(i);
        }
    }

    public final void c(Context context, b37 b37Var) {
        if (b37Var == null) {
            b37Var = new b37();
        }
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.h = applicationContext;
            o17.c(applicationContext);
        }
        f47.a aVar = new f47.a();
        aVar.f17434a = b37Var.m();
        aVar.b = b37Var.o();
        f47.a aVarA = aVar.a(b37Var.u());
        aVarA.h = b37Var.r();
        aVarA.e = "0123456789012345".getBytes();
        aVarA.f = "0123456789012345".getBytes();
        f47 f47VarB = aVarA.b();
        this.i = f47VarB;
        l17 l17Var = new l17(f47VarB);
        this.b = l17Var;
        bc7 bc7Var = new bc7(l17Var);
        this.c = bc7Var;
        bc7Var.g(b37Var.s());
        this.c.j(b37Var.t());
        z27 z27Var = new z27(b37Var);
        this.f18552a = z27Var;
        z27Var.c(this.b);
        this.g = new h47(this.b);
        this.c.a("NearX-HLog", "sdk version : 4.0.6");
        n();
    }

    public final void d(z27.h hVar) {
        z27 z27Var = this.f18552a;
        if (z27Var != null) {
            z27Var.m(hVar);
        }
    }

    public final void e(String str, String str2, long j2, long j3, boolean z, String str3) {
        if (this.f18552a != null) {
            this.f18552a.j(new z27.d(str, j2, j3, z, str2, str3), 0);
        }
    }

    public final void f(String str, String str2, z27.f fVar) {
        z27 z27Var = this.f18552a;
        if (z27Var != null) {
            z27Var.u(str, str2, fVar);
        }
    }

    public final void g(boolean z) {
        l17 l17Var = this.b;
        if (l17Var != null) {
            if (z) {
                l17Var.a();
            } else {
                l17Var.a(null);
            }
        }
    }

    public final void h() {
        this.f18552a = null;
        this.c = null;
        this.g = null;
        o();
        this.b = null;
    }

    public final void i(int i) {
        bc7 bc7Var = this.c;
        if (bc7Var != null) {
            bc7Var.j(i);
        }
    }

    public final void n() {
        ew6 ew6Var = new ew6();
        this.d = ew6Var;
        Context context = this.h;
        k87 k87Var = this.g;
        if (context != null) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(ew6Var.b);
            ArrayList arrayList = new ArrayList();
            ew6Var.f17382a = arrayList;
            arrayList.add(new fw6(k87Var));
        }
        if (this.e == null) {
            n17 n17Var = new n17(this.g);
            this.e = n17Var;
            n17Var.a(this.h);
        }
        k77 k77Var = new k77(this.g);
        this.f = k77Var;
        k77Var.b(this.h);
        new ia7(this.g).a(this.h);
    }

    public final void o() {
        k77 k77Var = this.f;
        if (k77Var != null) {
            try {
                this.h.unregisterReceiver(k77Var);
            } catch (Exception e) {
                if (k()) {
                    e.printStackTrace();
                }
            }
            this.f = null;
        }
        ew6 ew6Var = this.d;
        if (ew6Var != null) {
            Context context = this.h;
            if (context != null) {
                ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(ew6Var.b);
            }
            this.d = null;
        }
        this.h = null;
    }
}
