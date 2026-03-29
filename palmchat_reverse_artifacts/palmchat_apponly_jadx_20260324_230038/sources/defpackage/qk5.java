package defpackage;

import com.google.common.math.Stats;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20272a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public double d = Double.NaN;
    public double e = Double.NaN;

    public static double g(double d, double d2) {
        if (we1.f(d)) {
            return d2;
        }
        if (we1.f(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }

    public void a(double d) {
        long j = this.f20272a;
        if (j == 0) {
            this.f20272a = 1L;
            this.b = d;
            this.d = d;
            this.e = d;
            if (we1.f(d)) {
                return;
            }
            this.c = Double.NaN;
            return;
        }
        this.f20272a = j + 1;
        if (we1.f(d) && we1.f(this.b)) {
            double d2 = this.b;
            double d3 = d - d2;
            double d4 = d2 + (d3 / this.f20272a);
            this.b = d4;
            this.c += d3 * (d - d4);
        } else {
            this.b = g(this.b, d);
            this.c = Double.NaN;
        }
        this.d = Math.min(this.d, d);
        this.e = Math.max(this.e, d);
    }

    public void b(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d : dArr) {
            a(d);
        }
    }

    public void e(int... iArr) {
        for (int i : iArr) {
            a(i);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats h() {
        return new Stats(this.f20272a, this.b, this.c, this.d, this.e);
    }
}
