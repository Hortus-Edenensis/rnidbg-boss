package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n37 f19431a;

    public static n37 a() {
        if (f19431a == null) {
            synchronized (n37.class) {
                if (f19431a == null) {
                    f19431a = new n37();
                }
            }
        }
        return f19431a;
    }

    public static void b(String str, Throwable th) {
    }

    public static void c(Throwable th, String str) {
    }
}
