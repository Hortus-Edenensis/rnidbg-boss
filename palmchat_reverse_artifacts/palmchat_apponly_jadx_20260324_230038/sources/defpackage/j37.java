package defpackage;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class j37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d07 f18325a;
    public static final Object b = new Object();

    public static long a(d07 d07Var) {
        if (d07Var == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", d07Var.g(), d07Var.i(), Long.valueOf(d07Var.a()), d07Var.k(), d07Var.d());
        if (kc7.b(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static d07 b(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (b) {
            String strE = p77.a(context).e();
            if (kc7.b(strE)) {
                return null;
            }
            if (strE.endsWith("\n")) {
                strE = strE.substring(0, strE.length() - 1);
            }
            d07 d07Var = new d07();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strB = n77.b(context);
            String strD = n77.d(context);
            d07Var.h(strB);
            d07Var.c(strB);
            d07Var.e(jCurrentTimeMillis);
            d07Var.f(strD);
            d07Var.j(strE);
            d07Var.b(a(d07Var));
            return d07Var;
        }
    }

    public static synchronized d07 c(Context context) {
        d07 d07Var = f18325a;
        if (d07Var != null) {
            return d07Var;
        }
        if (context == null) {
            return null;
        }
        d07 d07VarB = b(context);
        f18325a = d07VarB;
        return d07VarB;
    }
}
