package com.google.common.collect;

import androidx.media3.muxer.MuxerUtil;
import com.google.common.collect.x;
import com.google.common.collect.y;
import defpackage.dm4;
import defpackage.m54;
import defpackage.sg0;
import defpackage.vg2;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class z<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object[] f6237a;
    public transient int[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;
    public transient long[] f;
    public transient float g;
    public transient int h;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends y.b<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f6238a;
        public int b;

        public a(int i) {
            this.f6238a = (K) z.this.f6237a[i];
            this.b = i;
        }

        public void b() {
            int i = this.b;
            if (i == -1 || i >= z.this.C() || !m54.a(this.f6238a, z.this.f6237a[this.b])) {
                this.b = z.this.m(this.f6238a);
            }
        }

        @Override // com.google.common.collect.x.a
        public int getCount() {
            b();
            int i = this.b;
            if (i == -1) {
                return 0;
            }
            return z.this.b[i];
        }

        @Override // com.google.common.collect.x.a
        public K getElement() {
            return this.f6238a;
        }
    }

    public z() {
        n(3, 1.0f);
    }

    public static long D(long j, int i) {
        return (j & (-4294967296L)) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) i));
    }

    public static <K> z<K> b() {
        return new z<>();
    }

    public static <K> z<K> c(int i) {
        return new z<>(i);
    }

    public static int h(long j) {
        return (int) (j >>> 32);
    }

    public static int j(long j) {
        return (int) j;
    }

    public static long[] q(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] iArrR = r(i);
        long[] jArr = this.f;
        int length = iArrR.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int iH = h(jArr[i3]);
            int i4 = iH & length;
            int i5 = iArrR[i4];
            iArrR[i4] = i3;
            jArr[i3] = (((long) iH) << 32) | (((long) i5) & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        }
        this.h = i2;
        this.e = iArrR;
    }

    public void B(int i, int i2) {
        dm4.m(i, this.c);
        this.b[i] = i2;
    }

    public int C() {
        return this.c;
    }

    public void a() {
        this.d++;
        Arrays.fill(this.f6237a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    public void d(int i) {
        if (i > this.f.length) {
            y(i);
        }
        if (i >= this.h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int e() {
        return this.c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int iM = m(obj);
        if (iM == -1) {
            return 0;
        }
        return this.b[iM];
    }

    public x.a<K> g(int i) {
        dm4.m(i, this.c);
        return new a(i);
    }

    public K i(int i) {
        dm4.m(i, this.c);
        return (K) this.f6237a[i];
    }

    public int k(int i) {
        dm4.m(i, this.c);
        return this.b[i];
    }

    public final int l() {
        return this.e.length - 1;
    }

    public int m(Object obj) {
        int iD = vg2.d(obj);
        int iJ = this.e[l() & iD];
        while (iJ != -1) {
            long j = this.f[iJ];
            if (h(j) == iD && m54.a(obj, this.f6237a[iJ])) {
                return iJ;
            }
            iJ = j(j);
        }
        return -1;
    }

    public void n(int i, float f) {
        dm4.e(i >= 0, "Initial capacity must be non-negative");
        dm4.e(f > 0.0f, "Illegal load factor");
        int iA = vg2.a(i, f);
        this.e = r(iA);
        this.g = f;
        this.f6237a = new Object[i];
        this.b = new int[i];
        this.f = q(i);
        this.h = Math.max(1, (int) (iA * f));
    }

    public void o(int i, K k, int i2, int i3) {
        this.f[i] = (((long) i3) << 32) | MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        this.f6237a[i] = k;
        this.b[i] = i2;
    }

    public void p(int i) {
        int iC = C() - 1;
        if (i >= iC) {
            this.f6237a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
            return;
        }
        Object[] objArr = this.f6237a;
        objArr[i] = objArr[iC];
        int[] iArr = this.b;
        iArr[i] = iArr[iC];
        objArr[iC] = null;
        iArr[iC] = 0;
        long[] jArr = this.f;
        long j = jArr[iC];
        jArr[i] = j;
        jArr[iC] = -1;
        int iH = h(j) & l();
        int[] iArr2 = this.e;
        int i2 = iArr2[iH];
        if (i2 == iC) {
            iArr2[iH] = i;
            return;
        }
        while (true) {
            long j2 = this.f[i2];
            int iJ = j(j2);
            if (iJ == iC) {
                this.f[i2] = D(j2, i);
                return;
            }
            i2 = iJ;
        }
    }

    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int t(int i, int i2) {
        return i - 1;
    }

    public int u(K k, int i) {
        sg0.d(i, "count");
        long[] jArr = this.f;
        Object[] objArr = this.f6237a;
        int[] iArr = this.b;
        int iD = vg2.d(k);
        int iL = l() & iD;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[iL];
        if (i3 == -1) {
            iArr2[iL] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == iD && m54.a(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int iJ = j(j);
                if (iJ == -1) {
                    jArr[i3] = D(j, i2);
                    break;
                }
                i3 = iJ;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        z(i5);
        o(i2, k, i, iD);
        this.c = i5;
        if (i2 >= this.h) {
            A(this.e.length * 2);
        }
        this.d++;
        return 0;
    }

    public int v(Object obj) {
        return w(obj, vg2.d(obj));
    }

    public final int w(Object obj, int i) {
        int iL = l() & i;
        int i2 = this.e[iL];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f[i2]) == i && m54.a(obj, this.f6237a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.e[iL] = j(this.f[i2]);
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int iJ = j(this.f[i2]);
            if (iJ == -1) {
                return 0;
            }
            i3 = i2;
            i2 = iJ;
        }
    }

    public int x(int i) {
        return w(this.f6237a[i], h(this.f[i]));
    }

    public void y(int i) {
        this.f6237a = Arrays.copyOf(this.f6237a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.f = jArrCopyOf;
    }

    public final void z(int i) {
        int length = this.f.length;
        if (i > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                y(iMax);
            }
        }
    }

    public z(z<? extends K> zVar) {
        n(zVar.C(), 1.0f);
        int iE = zVar.e();
        while (iE != -1) {
            u(zVar.i(iE), zVar.k(iE));
            iE = zVar.s(iE);
        }
    }

    public z(int i) {
        this(i, 1.0f);
    }

    public z(int i, float f) {
        n(i, f);
    }
}
