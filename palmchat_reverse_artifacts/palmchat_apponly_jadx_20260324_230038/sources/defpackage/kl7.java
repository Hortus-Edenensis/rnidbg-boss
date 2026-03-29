package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class kl7 {
    public static volatile kl7 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18718a;

    public static kl7 b() {
        if (b == null) {
            synchronized (kl7.class) {
                if (b == null) {
                    b = new kl7();
                }
            }
        }
        return b;
    }

    public int a() {
        return this.f18718a;
    }

    public void c(int i) {
        if (i <= 0) {
            return;
        }
        this.f18718a = i;
    }
}
