package defpackage;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class dy5<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f17181a;
    public V[] b;
    public int c;
    public int d;

    public dy5() {
        this(10);
    }

    public static <V> V[] f(int i) {
        return (V[]) new Object[i];
    }

    public synchronized void a(long j, V v) {
        d(j);
        e();
        b(j, v);
    }

    public final void b(long j, V v) {
        int i = this.c;
        int i2 = this.d;
        V[] vArr = this.b;
        int length = (i + i2) % vArr.length;
        this.f17181a[length] = j;
        vArr[length] = v;
        this.d = i2 + 1;
    }

    public synchronized void c() {
        this.c = 0;
        this.d = 0;
        Arrays.fill(this.b, (Object) null);
    }

    public final void d(long j) {
        if (this.d > 0) {
            if (j <= this.f17181a[((this.c + r0) - 1) % this.b.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.b.length;
        if (this.d < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) f(i);
        int i2 = this.c;
        int i3 = length - i2;
        System.arraycopy(this.f17181a, i2, jArr, 0, i3);
        System.arraycopy(this.b, this.c, vArr, 0, i3);
        int i4 = this.c;
        if (i4 > 0) {
            System.arraycopy(this.f17181a, 0, jArr, i3, i4);
            System.arraycopy(this.b, 0, vArr, i3, this.c);
        }
        this.f17181a = jArr;
        this.b = vArr;
        this.c = 0;
    }

    @Nullable
    public synchronized V g(long j) {
        return h(j, false);
    }

    @Nullable
    public final V h(long j, boolean z) {
        V vK = null;
        long j2 = Long.MAX_VALUE;
        while (this.d > 0) {
            long j3 = j - this.f17181a[this.c];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            vK = k();
            j2 = j3;
        }
        return vK;
    }

    @Nullable
    public synchronized V i() {
        return this.d == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j) {
        return h(j, true);
    }

    @Nullable
    public final V k() {
        vh.g(this.d > 0);
        V[] vArr = this.b;
        int i = this.c;
        V v = vArr[i];
        vArr[i] = null;
        this.c = (i + 1) % vArr.length;
        this.d--;
        return v;
    }

    public synchronized int l() {
        return this.d;
    }

    public dy5(int i) {
        this.f17181a = new long[i];
        this.b = (V[]) f(i);
    }
}
