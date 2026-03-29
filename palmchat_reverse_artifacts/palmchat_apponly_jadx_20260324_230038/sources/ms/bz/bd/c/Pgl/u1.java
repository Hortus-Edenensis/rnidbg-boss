package ms.bz.bd.c.Pgl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class u1 {
    public static volatile u1 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f19352a = null;

    private u1() {
    }

    public static u1 b() {
        if (b == null) {
            synchronized (u1.class) {
                if (b == null) {
                    b = new u1();
                }
            }
        }
        return b;
    }

    public final synchronized Throwable a() {
        return this.f19352a;
    }
}
