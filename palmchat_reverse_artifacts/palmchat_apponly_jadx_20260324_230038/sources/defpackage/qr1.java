package defpackage;

import com.igexin.push.core.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20308a;
    public final ku0 b;
    public final ku0 c;
    public final uw1 d;

    public qr1(ku0 ku0Var, ku0 ku0Var2, uw1 uw1Var, boolean z) {
        this.b = ku0Var;
        this.c = ku0Var2;
        this.d = uw1Var;
        this.f20308a = z;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public uw1 b() {
        return this.d;
    }

    public ku0 c() {
        return this.b;
    }

    public ku0 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qr1)) {
            return false;
        }
        qr1 qr1Var = (qr1) obj;
        return a(this.b, qr1Var.b) && a(this.c, qr1Var.c) && a(this.d, qr1Var.d);
    }

    public boolean f() {
        return this.c == null;
    }

    public int hashCode() {
        return (e(this.b) ^ e(this.c)) ^ e(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.b);
        sb.append(" , ");
        sb.append(this.c);
        sb.append(" : ");
        uw1 uw1Var = this.d;
        sb.append(uw1Var == null ? b.m : Integer.valueOf(uw1Var.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
