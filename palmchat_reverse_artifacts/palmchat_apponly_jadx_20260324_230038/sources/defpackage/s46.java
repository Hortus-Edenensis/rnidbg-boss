package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class s46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f20665a;
    public static final boolean b;

    static {
        b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f20665a = unsafe;
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f20665a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    public static boolean b() {
        return (f20665a == null || b) ? false : true;
    }
}
