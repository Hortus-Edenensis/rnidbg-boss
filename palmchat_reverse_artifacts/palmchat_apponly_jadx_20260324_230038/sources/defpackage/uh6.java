package defpackage;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class uh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f21214a;
    public final int b;
    public int c;
    public int d;

    public uh6(byte[] bArr) {
        this.f21214a = bArr;
        this.b = bArr.length;
    }

    public final void a() {
        int i;
        int i2 = this.c;
        vh.g(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public int b() {
        return (this.c * 8) + this.d;
    }

    public boolean c() {
        boolean z = (((this.f21214a[this.c] & UByte.MAX_VALUE) >> this.d) & 1) == 1;
        e(1);
        return z;
    }

    public int d(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.f21214a[i2] & UByte.MAX_VALUE) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.f21214a[i3] & UByte.MAX_VALUE) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        e(i);
        return i5;
    }

    public void e(int i) {
        int i2 = i / 8;
        int i3 = this.c + i2;
        this.c = i3;
        int i4 = this.d + (i - (i2 * 8));
        this.d = i4;
        if (i4 > 7) {
            this.c = i3 + 1;
            this.d = i4 - 8;
        }
        a();
    }
}
