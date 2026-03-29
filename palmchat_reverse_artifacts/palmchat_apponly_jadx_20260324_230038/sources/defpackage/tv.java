package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class tv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f21074a;
    public final int b;
    public final int c;

    public tv(int i, int i2) {
        this.f21074a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.b = i;
        this.c = i2;
    }

    public void a(byte b) {
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.f21074a[i][i2] = b;
            }
        }
    }

    public byte b(int i, int i2) {
        return this.f21074a[i2][i];
    }

    public byte[][] c() {
        return this.f21074a;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(int i, int i2, int i3) {
        this.f21074a[i2][i] = (byte) i3;
    }

    public void g(int i, int i2, boolean z) {
        this.f21074a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = this.f21074a[i][i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
