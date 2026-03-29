package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class tw1 extends sx4 {
    public final float c;
    public final int d;

    public tw1(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.c);
        return fAbs <= 1.0f || fAbs <= this.c;
    }

    public tw1 g(float f, float f2, float f3) {
        int i = this.d;
        int i2 = i + 1;
        float fC = (i * c()) + f2;
        float f4 = i2;
        return new tw1(fC / f4, ((this.d * d()) + f) / f4, ((this.d * this.c) + f3) / f4, i2);
    }

    public int h() {
        return this.d;
    }

    public float i() {
        return this.c;
    }

    public tw1(float f, float f2, float f3, int i) {
        super(f, f2);
        this.c = f3;
        this.d = i;
    }
}
