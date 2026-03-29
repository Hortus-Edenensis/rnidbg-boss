package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class le3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f18964a;
    public int b;

    public void a(float f) {
        float f2 = this.f18964a + f;
        this.f18964a = f2;
        int i = this.b + 1;
        this.b = i;
        if (i == Integer.MAX_VALUE) {
            this.f18964a = f2 / 2.0f;
            this.b = i / 2;
        }
    }
}
