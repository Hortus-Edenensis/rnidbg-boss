package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class d75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16992a;
    public float b;
    public float c;
    public float d;

    public d75(float f, float f2, float f3, float f4) {
        this.b = f4;
        this.f16992a = f3;
        this.c = f;
        this.d = f2;
    }

    public float a(float f) {
        return (f - this.c) / this.f16992a;
    }

    public float b(float f) {
        return 1.0f - ((this.d - f) / this.b);
    }
}
