package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class nt2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19595a = 0;
    public int b = -1;
    public int c = 0;
    public int[] d = new int[16];
    public int e;

    public nt2() {
        this.e = r0.length - 1;
    }

    public void a(int i) {
        if (this.c == this.d.length) {
            c();
        }
        int i2 = (this.b + 1) & this.e;
        this.b = i2;
        this.d[i2] = i;
        this.c++;
    }

    public void b() {
        this.f19595a = 0;
        this.b = -1;
        this.c = 0;
    }

    public final void c() {
        int[] iArr = this.d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i = this.f19595a;
        int i2 = length2 - i;
        System.arraycopy(iArr, i, iArr2, 0, i2);
        System.arraycopy(this.d, 0, iArr2, i2, i);
        this.f19595a = 0;
        this.b = this.c - 1;
        this.d = iArr2;
        this.e = iArr2.length - 1;
    }

    public boolean d() {
        return this.c == 0;
    }

    public int e() {
        int i = this.c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.d;
        int i2 = this.f19595a;
        int i3 = iArr[i2];
        this.f19595a = (i2 + 1) & this.e;
        this.c = i - 1;
        return i3;
    }
}
