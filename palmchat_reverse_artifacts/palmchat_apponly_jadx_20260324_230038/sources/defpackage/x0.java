package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x0<T> {
    public final float[] b;
    public float c = 1.0f;
    public float d = 1.0f;
    public int e = 0;
    public int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21846a = 0;

    public x0(int i) {
        this.b = new float[i];
    }

    public void a() {
        this.f21846a = 0;
    }

    public void b(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public int c() {
        return this.b.length;
    }
}
