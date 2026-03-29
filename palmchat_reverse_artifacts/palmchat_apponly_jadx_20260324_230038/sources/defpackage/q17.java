package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class q17 implements cw6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20159a = 1;
    public int b = 1;

    @Override // defpackage.cw6
    public void a(String str, String str2) {
        h(str, str2, this.b != -1, (byte) 2);
    }

    @Override // defpackage.cw6
    public void b(String str, String str2) {
        h(str, str2, this.b != -1, (byte) 4);
    }

    @Override // defpackage.cw6
    public void c(String str, String str2) {
        h(str, str2, this.b != -1, (byte) 5);
    }

    @Override // defpackage.cw6
    public void d(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 5);
    }

    @Override // defpackage.cw6
    public void e(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 2);
    }

    public int f() {
        return this.f20159a;
    }

    public void g(int i) {
        this.f20159a = i;
    }

    public abstract void h(String str, String str2, boolean z, byte b);

    public int i() {
        return this.b;
    }

    public void j(int i) {
        this.b = i;
    }

    public int k() {
        return 101;
    }

    @Override // defpackage.cw6
    public void a(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 1);
    }

    @Override // defpackage.cw6
    public void b(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 3);
    }

    @Override // defpackage.cw6
    public void c(String str, String str2, boolean z) {
        h(str, str2, z, (byte) 4);
    }
}
