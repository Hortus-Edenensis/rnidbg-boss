package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ex6 implements id7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17390a;
    public int b;
    public int c;
    public final float d;

    public ex6() {
        this(3000, 1, 1.0f);
    }

    @Override // defpackage.id7
    public int a() {
        return this.f17390a;
    }

    @Override // defpackage.id7
    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b <= this.c;
    }

    public ex6(int i, int i2, float f) {
        this.f17390a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // defpackage.id7
    public void a(int i) {
        this.c = i;
    }

    @Override // defpackage.id7
    public void a(Exception exc) throws Exception {
        this.b++;
        int i = this.f17390a;
        this.f17390a = (int) (i + (i * this.d));
        if (!c()) {
            throw exc;
        }
    }
}
