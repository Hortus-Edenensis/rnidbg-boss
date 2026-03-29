package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class av6 {
    public static volatile av6 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r07 f1581a;
    public SQLiteDatabase b;

    public static av6 a() {
        if (c == null) {
            synchronized (av6.class) {
                if (c == null) {
                    c = new av6();
                }
            }
        }
        return c;
    }

    public synchronized void b(bv6 bv6Var) {
        e();
        r07 r07Var = this.f1581a;
        if (r07Var != null) {
            r07Var.f(this.b, bv6Var);
        }
    }

    public synchronized void c(Context context) {
        try {
            this.b = new q07(context).getWritableDatabase();
        } catch (Throwable th) {
            kj7.g(th);
        }
        this.f1581a = new r07();
    }

    public synchronized boolean d(String str) {
        e();
        r07 r07Var = this.f1581a;
        if (r07Var == null) {
            return false;
        }
        return r07Var.g(this.b, str);
    }

    public final void e() {
        if (this.f1581a == null) {
            c(x97.m());
        }
    }
}
