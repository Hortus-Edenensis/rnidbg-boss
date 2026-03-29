package defpackage;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ej4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17307a;
    public static final boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements PrivilegedAction<ClassLoader> {
        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClassLoader run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    static {
        int iD = d();
        f17307a = iD;
        b = iD != 0;
    }

    public static int a() {
        return f17307a;
    }

    public static ClassLoader b() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean c() {
        return b;
    }

    public static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, b()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
