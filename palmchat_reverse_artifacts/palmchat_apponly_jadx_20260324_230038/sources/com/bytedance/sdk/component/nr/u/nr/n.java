package com.bytedance.sdk.component.nr.u.nr;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class n extends b {
    final transient int[] n;
    final transient byte[][] x;

    public n(u uVar, int i) {
        super(null);
        jk.u(uVar.nr, 0L, i);
        iz izVar = uVar.u;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = izVar.fx;
            int i6 = izVar.nr;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            izVar = izVar.iz;
        }
        this.x = new byte[i4][];
        this.n = new int[i4 * 2];
        iz izVar2 = uVar.u;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.x;
            bArr[i7] = izVar2.u;
            int i8 = izVar2.fx;
            int i9 = izVar2.nr;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.n;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            izVar2.b = true;
            i7++;
            izVar2 = izVar2.iz;
        }
    }

    private b pn() {
        return new b(b());
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public byte[] b() {
        int[] iArr = this.n;
        byte[][] bArr = this.x;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.n;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.x[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.fx() == fx() && u(0, bVar, 0, fx())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public int fx() {
        return this.n[this.x.length - 1];
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public int hashCode() {
        int i = this.pn;
        if (i != 0) {
            return i;
        }
        int length = this.x.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.x[i2];
            int[] iArr = this.n;
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
        this.pn = i4;
        return i4;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public String nr() {
        return pn().nr();
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public String toString() {
        return pn().toString();
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public String u() {
        return pn().u();
    }

    private int nr(int i) {
        int iBinarySearch = Arrays.binarySearch(this.n, 0, this.x.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public b u(int i, int i2) {
        return pn().u(i, i2);
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public byte u(int i) {
        jk.u(this.n[this.x.length - 1], i, 1L);
        int iNr = nr(i);
        int i2 = iNr == 0 ? 0 : this.n[iNr - 1];
        int[] iArr = this.n;
        byte[][] bArr = this.x;
        return bArr[iNr][(i - i2) + iArr[bArr.length + iNr]];
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public boolean u(int i, b bVar, int i2, int i3) {
        if (i < 0 || i > fx() - i3) {
            return false;
        }
        int iNr = nr(i);
        while (i3 > 0) {
            int i4 = iNr == 0 ? 0 : this.n[iNr - 1];
            int iMin = Math.min(i3, ((this.n[iNr] - i4) + i4) - i);
            int[] iArr = this.n;
            byte[][] bArr = this.x;
            if (!bVar.u(i2, bArr[iNr], (i - i4) + iArr[bArr.length + iNr], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iNr++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr.b
    public boolean u(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > fx() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iNr = nr(i);
        while (i3 > 0) {
            int i4 = iNr == 0 ? 0 : this.n[iNr - 1];
            int iMin = Math.min(i3, ((this.n[iNr] - i4) + i4) - i);
            int[] iArr = this.n;
            byte[][] bArr2 = this.x;
            if (!jk.u(bArr2[iNr], (i - i4) + iArr[bArr2.length + iNr], bArr, i2, iMin)) {
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
