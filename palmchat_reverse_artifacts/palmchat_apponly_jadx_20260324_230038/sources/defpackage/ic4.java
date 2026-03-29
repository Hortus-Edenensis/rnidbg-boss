package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ic4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18147a;
    public String b;

    public ic4(int i, String str) {
        this.f18147a = i;
        this.b = str;
    }

    public String toString() {
        return this.f18147a + ": " + this.b;
    }

    public ic4(int i, String str, Object... objArr) {
        this.b = String.format(str, objArr);
        this.f18147a = i;
    }
}
