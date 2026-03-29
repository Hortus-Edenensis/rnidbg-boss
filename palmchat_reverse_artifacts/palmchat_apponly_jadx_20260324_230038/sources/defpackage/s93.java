package defpackage;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class s93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20685a;
    public final int b;

    public s93(int i, int i2) {
        this.f20685a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i, byte[] bArr);

    public final int d() {
        return this.f20685a;
    }

    public boolean e() {
        return false;
    }

    public s93 f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f20685a;
        byte[] bArrC = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrC = c(i2, bArrC);
            for (int i3 = 0; i3 < this.f20685a; i3++) {
                int i4 = bArrC[i3] & UByte.MAX_VALUE;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
