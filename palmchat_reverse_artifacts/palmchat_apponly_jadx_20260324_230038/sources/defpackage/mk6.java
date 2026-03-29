package defpackage;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class mk6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f19259a = null;
    public static boolean b = false;

    public static void a(Application application, sp2 sp2Var) {
        if (na7.c(application) && !b) {
            f19259a = application.getApplicationContext();
            rt6.b(application).c(sp2Var);
            b = true;
        }
    }
}
