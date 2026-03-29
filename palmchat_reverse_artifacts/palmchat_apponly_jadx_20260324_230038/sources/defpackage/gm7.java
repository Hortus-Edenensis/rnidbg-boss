package defpackage;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class gm7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17750a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17751a;
        public final /* synthetic */ boolean b;

        public a(Context context, boolean z) {
            this.f17751a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl7.a().b(this.f17751a);
            d17.a(this.f17751a);
            if (this.b) {
                af7.a(this.f17751a).b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ li7 f17752a;

        public b(li7 li7Var) {
            this.f17752a = li7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            il7.c(this.f17752a);
        }
    }

    public static void a() {
        pl7.c();
    }

    public static synchronized void b(@NonNull Context context, @NonNull ij7 ij7Var, boolean z, boolean z2) {
        c(context, ij7Var, z, false, z2);
    }

    public static synchronized void c(@NonNull Context context, @NonNull ij7 ij7Var, boolean z, boolean z2, boolean z3) {
        d(context, ij7Var, z, z, z2, z3);
    }

    public static synchronized void d(@NonNull Context context, @NonNull ij7 ij7Var, boolean z, boolean z2, boolean z3, boolean z4) {
        if (f17750a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (ij7Var == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (sl7.b(context)) {
            return;
        }
        uh7.k(context, ij7Var);
        fj7.d(context);
        if (z || z2) {
            pl7 pl7VarE = pl7.e();
            if (z) {
                pl7VarE.f(new xc7(context));
            }
            b = true;
        }
        d = z3;
        f17750a = true;
        c = z4;
        im7.a().post(new a(context, z4));
    }

    public static void e(cf7 cf7Var) {
        uh7.g().f(cf7Var);
    }

    public static void f(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        uh7.g().g(map);
    }

    public static void g(li7 li7Var) {
        im7.a().post(new b(li7Var));
    }
}
