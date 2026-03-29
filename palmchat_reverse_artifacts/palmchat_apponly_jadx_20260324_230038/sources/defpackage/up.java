package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class up {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wp[] f21256a;
    public int b;
    public final int c;
    public final int d;

    public up(int i, int i2) {
        wp[] wpVarArr = new wp[i];
        this.f21256a = wpVarArr;
        int length = wpVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f21256a[i3] = new wp(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    public wp a() {
        return this.f21256a[this.b];
    }

    public byte[][] b(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.c * i2, this.d * i);
        int i3 = this.c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f21256a[i4 / i2].b(i);
        }
        return bArr;
    }

    public void c() {
        this.b++;
    }
}
