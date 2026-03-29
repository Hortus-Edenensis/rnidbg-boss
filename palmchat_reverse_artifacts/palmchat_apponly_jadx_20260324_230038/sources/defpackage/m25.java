package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f19130a;
    public float b;

    public m25(float f, float f2) {
        this.f19130a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        return this.f19130a == f && this.b == f2;
    }

    public float b() {
        return this.f19130a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.f19130a = f;
        this.b = f2;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public m25() {
        this(1.0f, 1.0f);
    }
}
