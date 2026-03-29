package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import defpackage.fk2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fk2 f19439a;
    public static fk2 b;
    public static fk2 c;
    public static fk2 d;
    public static fk2 e;
    public static fk2 f;
    public static fk2 g;
    public static fk2 h;

    public static Intent a(Context context, fk2.a aVar) {
        return f19439a.a(context, aVar);
    }

    public static Intent b(Context context, fk2.a aVar) {
        return d.a(context, aVar);
    }

    public static Intent c(Context context, fk2.a aVar) {
        return b.a(context, aVar);
    }

    public static void d(fk2 fk2Var, fk2 fk2Var2, fk2 fk2Var3, fk2 fk2Var4, fk2 fk2Var5, fk2 fk2Var6, fk2 fk2Var7, fk2 fk2Var8) {
        f19439a = fk2Var;
        b = fk2Var2;
        c = fk2Var3;
        d = fk2Var4;
        e = fk2Var5;
        f = fk2Var6;
        g = fk2Var7;
        h = fk2Var8;
    }

    public static void e(Context context, String str) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString("group_id", str);
        aVar.b(bundle);
        context.startActivity(h.a(context, aVar));
    }

    public static void f(Context context, Bundle bundle) {
        fk2.a aVar = new fk2.a();
        aVar.b(bundle);
        context.startActivity(e.a(context, aVar));
    }
}
