package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class j {
    private int i;
    private int j;
    private int k;
    private int l;
    private Format q;
    private int r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8299a = 1000;
    private int[] b = new int[1000];
    private long[] c = new long[1000];
    private long[] f = new long[1000];
    private int[] e = new int[1000];
    private int[] d = new int[1000];
    private n.a[] g = new n.a[1000];
    private Format[] h = new Format[1000];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8300a;
        public long b;
        public n.a c;
    }

    private long c(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iD = d(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.f[iD]);
            if ((this.e[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.f8299a - 1;
            }
        }
        return jMax;
    }

    private int d(int i) {
        int i2 = this.k + i;
        int i3 = this.f8299a;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public int a() {
        return this.j + this.i;
    }

    public int b() {
        return this.j + this.l;
    }

    public synchronized long e() {
        return this.n;
    }

    public synchronized void f() {
        this.l = 0;
    }

    public synchronized int g() {
        int i;
        int i2 = this.i;
        i = i2 - this.l;
        this.l = i2;
        return i;
    }

    public synchronized long h() {
        int i = this.i;
        if (i == 0) {
            return -1L;
        }
        return b(i);
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.f[i] <= j; i4++) {
            if (!z || (this.e[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.f8299a) {
                i = 0;
            }
        }
        return i3;
    }

    private long b(int i) {
        this.m = Math.max(this.m, c(i));
        int i2 = this.i - i;
        this.i = i2;
        this.j += i;
        int i3 = this.k + i;
        this.k = i3;
        int i4 = this.f8299a;
        if (i3 >= i4) {
            this.k = i3 - i4;
        }
        int i5 = this.l - i;
        this.l = i5;
        if (i5 < 0) {
            this.l = 0;
        }
        if (i2 != 0) {
            return this.c[this.k];
        }
        int i6 = this.k;
        if (i6 != 0) {
            i4 = i6;
        }
        int i7 = i4 - 1;
        return this.c[i7] + ((long) this.d[i7]);
    }

    public synchronized boolean c() {
        return this.l != this.i;
    }

    public synchronized Format d() {
        return this.p ? null : this.q;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int iD = d(this.l);
        if (c() && j >= this.f[iD] && (j <= this.n || z2)) {
            int iA = a(iD, this.i - this.l, j, z);
            if (iA == -1) {
                return -1;
            }
            this.l += iA;
            return iA;
        }
        return -1;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.i;
        if (i2 != 0) {
            long[] jArr = this.f;
            int i3 = this.k;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.l) != i2) {
                    i2 = i + 1;
                }
                int iA = a(i3, i2, j, z);
                if (iA == -1) {
                    return -1L;
                }
                return b(iA);
            }
        }
        return -1L;
    }

    public synchronized int a(com.opos.exoplayer.core.j jVar, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, Format format, a aVar) {
        if (!c()) {
            if (z2) {
                decoderInputBuffer.a_(4);
                return -4;
            }
            Format format2 = this.q;
            if (format2 == null || (!z && format2 == format)) {
                return -3;
            }
            jVar.f8252a = format2;
            return -5;
        }
        int iD = d(this.l);
        if (!z && this.h[iD] == format) {
            if (decoderInputBuffer.f()) {
                return -3;
            }
            decoderInputBuffer.c = this.f[iD];
            decoderInputBuffer.a_(this.e[iD]);
            aVar.f8300a = this.d[iD];
            aVar.b = this.c[iD];
            aVar.c = this.g[iD];
            this.l++;
            return -4;
        }
        jVar.f8252a = this.h[iD];
        return -5;
    }

    public synchronized boolean b(long j) {
        if (this.i == 0) {
            return j > this.m;
        }
        if (Math.max(this.m, c(this.l)) >= j) {
            return false;
        }
        int i = this.i;
        int iD = d(i - 1);
        while (i > this.l && this.f[iD] >= j) {
            i--;
            iD--;
            if (iD == -1) {
                iD = this.f8299a - 1;
            }
        }
        a(this.j + i);
        return true;
    }

    public long a(int i) {
        int iA = a() - i;
        com.opos.exoplayer.core.util.a.a(iA >= 0 && iA <= this.i - this.l);
        int i2 = this.i - iA;
        this.i = i2;
        this.n = Math.max(this.m, c(i2));
        int i3 = this.i;
        if (i3 == 0) {
            return 0L;
        }
        int iD = d(i3 - 1);
        return this.c[iD] + ((long) this.d[iD]);
    }

    public synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }

    public synchronized void a(long j, int i, long j2, int i2, n.a aVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        com.opos.exoplayer.core.util.a.b(!this.p);
        a(j);
        int iD = d(this.i);
        this.f[iD] = j;
        long[] jArr = this.c;
        jArr[iD] = j2;
        this.d[iD] = i2;
        this.e[iD] = i;
        this.g[iD] = aVar;
        this.h[iD] = this.q;
        this.b[iD] = this.r;
        int i3 = this.i + 1;
        this.i = i3;
        int i4 = this.f8299a;
        if (i3 == i4) {
            int i5 = i4 + 1000;
            int[] iArr = new int[i5];
            long[] jArr2 = new long[i5];
            long[] jArr3 = new long[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            n.a[] aVarArr = new n.a[i5];
            Format[] formatArr = new Format[i5];
            int i6 = this.k;
            int i7 = i4 - i6;
            System.arraycopy(jArr, i6, jArr2, 0, i7);
            System.arraycopy(this.f, this.k, jArr3, 0, i7);
            System.arraycopy(this.e, this.k, iArr2, 0, i7);
            System.arraycopy(this.d, this.k, iArr3, 0, i7);
            System.arraycopy(this.g, this.k, aVarArr, 0, i7);
            System.arraycopy(this.h, this.k, formatArr, 0, i7);
            System.arraycopy(this.b, this.k, iArr, 0, i7);
            int i8 = this.k;
            System.arraycopy(this.c, 0, jArr2, i7, i8);
            System.arraycopy(this.f, 0, jArr3, i7, i8);
            System.arraycopy(this.e, 0, iArr2, i7, i8);
            System.arraycopy(this.d, 0, iArr3, i7, i8);
            System.arraycopy(this.g, 0, aVarArr, i7, i8);
            System.arraycopy(this.h, 0, formatArr, i7, i8);
            System.arraycopy(this.b, 0, iArr, i7, i8);
            this.c = jArr2;
            this.f = jArr3;
            this.e = iArr2;
            this.d = iArr3;
            this.g = aVarArr;
            this.h = formatArr;
            this.b = iArr;
            this.k = 0;
            this.i = this.f8299a;
            this.f8299a = i5;
        }
    }

    public void a(boolean z) {
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = true;
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        if (z) {
            this.q = null;
            this.p = true;
        }
    }

    public synchronized boolean a(Format format) {
        if (format == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (y.a(format, this.q)) {
            return false;
        }
        this.q = format;
        return true;
    }
}
