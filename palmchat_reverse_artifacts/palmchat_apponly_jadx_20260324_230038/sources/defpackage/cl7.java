package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class cl7 {
    public static volatile cl7 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public si7 f2015a;
    public SQLiteDatabase b;

    public static cl7 a() {
        if (c == null) {
            synchronized (cl7.class) {
                if (c == null) {
                    c = new cl7();
                }
            }
        }
        return c;
    }

    public void b(Context context) {
        try {
            this.b = new ri7(context).getWritableDatabase();
        } catch (Throwable th) {
            mf7.a(th);
        }
        this.f2015a = new si7();
    }

    public synchronized void c(el7 el7Var) {
        si7 si7Var = this.f2015a;
        if (si7Var != null) {
            si7Var.e(this.b, el7Var);
        }
    }

    public synchronized boolean d(String str) {
        si7 si7Var = this.f2015a;
        if (si7Var == null) {
            return false;
        }
        return si7Var.g(this.b, str);
    }
}
