package defpackage;

import junit.framework.Assert;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ij0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18177a;
    public String b;
    public String c;
    public int d;
    public int e;

    public ij0(int i, String str, String str2) {
        this.f18177a = i;
        this.b = str;
        this.c = str2;
    }

    public final boolean a() {
        return this.b.equals(this.c);
    }

    public String b(String str) {
        if (this.b == null || this.c == null || a()) {
            return Assert.format(str, this.b, this.c);
        }
        f();
        g();
        return Assert.format(str, c(this.b), c(this.c));
    }

    public final String c(String str) {
        String str2 = "[" + str.substring(this.d, (str.length() - this.e) + 1) + "]";
        if (this.d > 0) {
            str2 = d() + str2;
        }
        if (this.e <= 0) {
            return str2;
        }
        return str2 + e();
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d > this.f18177a ? "..." : "");
        sb.append(this.b.substring(Math.max(0, this.d - this.f18177a), this.d));
        return sb.toString();
    }

    public final String e() {
        int iMin = Math.min((this.b.length() - this.e) + 1 + this.f18177a, this.b.length());
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        sb.append(str.substring((str.length() - this.e) + 1, iMin));
        sb.append((this.b.length() - this.e) + 1 < this.b.length() - this.f18177a ? "..." : "");
        return sb.toString();
    }

    public final void f() {
        this.d = 0;
        int iMin = Math.min(this.b.length(), this.c.length());
        while (true) {
            int i = this.d;
            if (i >= iMin || this.b.charAt(i) != this.c.charAt(this.d)) {
                return;
            } else {
                this.d++;
            }
        }
    }

    public final void g() {
        int length = this.b.length() - 1;
        int length2 = this.c.length() - 1;
        while (true) {
            int i = this.d;
            if (length2 < i || length < i || this.b.charAt(length) != this.c.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.e = this.b.length() - length;
    }
}
