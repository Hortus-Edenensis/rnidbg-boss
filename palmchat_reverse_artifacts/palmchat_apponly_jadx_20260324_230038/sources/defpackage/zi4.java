package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class zi4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yf4 f22433a = b();

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements yf4 {
        public b() {
        }
    }

    public static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    public static yf4 b() {
        return new b();
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }
}
