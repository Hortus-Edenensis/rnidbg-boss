package defpackage;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class fe0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17517a;
    public final int b;
    public final int c;
    public final int d;
    public int e = -1;

    public fe0(int i, int i2, int i3, int i4) {
        this.f17517a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f17517a;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b - this.f17517a;
    }

    public boolean g() {
        return h(this.e);
    }

    public boolean h(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    public void i(int i) {
        this.e = i;
    }

    public void j() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.d;
    }
}
