package com.opos.exoplayer.core.upstream;

import com.opos.exoplayer.core.util.y;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8378a;
    private final int b;
    private final byte[] c;
    private final a[] d;
    private int e;
    private int f;
    private int g;
    private a[] h;

    public i(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // com.opos.exoplayer.core.upstream.b
    public synchronized a a() {
        a aVar;
        this.f++;
        int i = this.g;
        if (i > 0) {
            a[] aVarArr = this.h;
            int i2 = i - 1;
            this.g = i2;
            aVar = aVarArr[i2];
            aVarArr[i2] = null;
        } else {
            aVar = new a(new byte[this.b], 0);
        }
        return aVar;
    }

    @Override // com.opos.exoplayer.core.upstream.b
    public synchronized void b() {
        int i = 0;
        int iMax = Math.max(0, y.a(this.e, this.b) - this.f);
        int i2 = this.g;
        if (iMax >= i2) {
            return;
        }
        if (this.c != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                a[] aVarArr = this.h;
                a aVar = aVarArr[i];
                byte[] bArr = aVar.f8371a;
                byte[] bArr2 = this.c;
                if (bArr == bArr2) {
                    i++;
                } else {
                    a aVar2 = aVarArr[i3];
                    if (aVar2.f8371a != bArr2) {
                        i3--;
                    } else {
                        aVarArr[i] = aVar2;
                        aVarArr[i3] = aVar;
                        i3--;
                        i++;
                    }
                }
            }
            iMax = Math.max(iMax, i);
            if (iMax >= this.g) {
                return;
            }
        }
        Arrays.fill(this.h, iMax, this.g, (Object) null);
        this.g = iMax;
    }

    @Override // com.opos.exoplayer.core.upstream.b
    public int c() {
        return this.b;
    }

    public synchronized void d() {
        if (this.f8378a) {
            a(0);
        }
    }

    public synchronized int e() {
        return this.f * this.b;
    }

    public i(boolean z, int i, int i2) {
        com.opos.exoplayer.core.util.a.a(i > 0);
        com.opos.exoplayer.core.util.a.a(i2 >= 0);
        this.f8378a = z;
        this.b = i;
        this.g = i2;
        this.h = new a[i2 + 100];
        if (i2 > 0) {
            this.c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new a(this.c, i3 * i);
            }
        } else {
            this.c = null;
        }
        this.d = new a[1];
    }

    public synchronized void a(int i) {
        boolean z = i < this.e;
        this.e = i;
        if (z) {
            b();
        }
    }

    @Override // com.opos.exoplayer.core.upstream.b
    public synchronized void a(a aVar) {
        a[] aVarArr = this.d;
        aVarArr[0] = aVar;
        a(aVarArr);
    }

    @Override // com.opos.exoplayer.core.upstream.b
    public synchronized void a(a[] aVarArr) {
        int i = this.g;
        int length = aVarArr.length + i;
        a[] aVarArr2 = this.h;
        if (length >= aVarArr2.length) {
            this.h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            byte[] bArr = aVar.f8371a;
            com.opos.exoplayer.core.util.a.a(bArr == this.c || bArr.length == this.b);
            a[] aVarArr3 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            aVarArr3[i2] = aVar;
        }
        this.f -= aVarArr.length;
        notifyAll();
    }
}
