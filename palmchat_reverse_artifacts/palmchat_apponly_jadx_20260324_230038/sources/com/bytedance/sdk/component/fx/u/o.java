package com.bytedance.sdk.component.fx.u;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class o extends iz {
    final transient byte[][] iz;
    final transient int[] x;

    public o(fx fxVar, int i) {
        super(null);
        dw.u(fxVar.nr, 0L, i);
        k kVar = fxVar.u;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = kVar.fx;
            int i6 = kVar.nr;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            kVar = kVar.iz;
        }
        this.iz = new byte[i4][];
        this.x = new int[i4 * 2];
        k kVar2 = fxVar.u;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.iz;
            bArr[i7] = kVar2.u;
            int i8 = kVar2.fx;
            int i9 = kVar2.nr;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.x;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            kVar2.b = true;
            i7++;
            kVar2 = kVar2.iz;
        }
    }

    private iz a() {
        return new iz(n());
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public iz b() {
        return a().b();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iz) {
            iz izVar = (iz) obj;
            if (izVar.x() == x() && u(0, izVar, 0, x())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public iz fx() {
        return a().fx();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int length = this.iz.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.iz[i2];
            int[] iArr = this.x;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.b = i4;
        return i4;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public iz iz() {
        return a().iz();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public byte[] n() {
        int[] iArr = this.x;
        byte[][] bArr = this.iz;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.x;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.iz[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public String nr() {
        return a().nr();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public String pn() {
        return a().pn();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public String toString() {
        return a().toString();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public String u() {
        return a().u();
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public int x() {
        return this.x[this.iz.length - 1];
    }

    private int nr(int i) {
        int iBinarySearch = Arrays.binarySearch(this.x, 0, this.iz.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public iz u(int i, int i2) {
        return a().u(i, i2);
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public byte u(int i) {
        dw.u(this.x[this.iz.length - 1], i, 1L);
        int iNr = nr(i);
        int i2 = iNr == 0 ? 0 : this.x[iNr - 1];
        int[] iArr = this.x;
        byte[][] bArr = this.iz;
        return bArr[iNr][(i - i2) + iArr[bArr.length + iNr]];
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public void u(fx fxVar) {
        int length = this.iz.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.x;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            k kVar = new k(this.iz[i], i3, (i3 + i4) - i2, true, false);
            k kVar2 = fxVar.u;
            if (kVar2 == null) {
                kVar.x = kVar;
                kVar.iz = kVar;
                fxVar.u = kVar;
            } else {
                kVar2.x.u(kVar);
            }
            i++;
            i2 = i4;
        }
        fxVar.nr += (long) i2;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public boolean u(int i, iz izVar, int i2, int i3) {
        if (i < 0 || i > x() - i3) {
            return false;
        }
        int iNr = nr(i);
        while (i3 > 0) {
            int i4 = iNr == 0 ? 0 : this.x[iNr - 1];
            int iMin = Math.min(i3, ((this.x[iNr] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr = this.iz;
            if (!izVar.u(i2, bArr[iNr], (i - i4) + iArr[bArr.length + iNr], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iNr++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.fx.u.iz
    public boolean u(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > x() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iNr = nr(i);
        while (i3 > 0) {
            int i4 = iNr == 0 ? 0 : this.x[iNr - 1];
            int iMin = Math.min(i3, ((this.x[iNr] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr2 = this.iz;
            if (!dw.u(bArr2[iNr], (i - i4) + iArr[bArr2.length + iNr], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iNr++;
        }
        return true;
    }
}
