package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.amap.api.col.p0002sl.hb;
import com.cdo.oaps.ad.Launcher;
import com.kuaishou.weapon.p0.t;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(28)
public final class sh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f20747a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final long f;
    public static final long g;
    public static final long h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final Set n = new HashSet();

    static {
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            f20747a = unsafe;
            b = unsafe.objectFieldOffset(fh2.class.getDeclaredField("artMethod"));
            c = unsafe.objectFieldOffset(fh2.class.getDeclaredField("declaringClass"));
            long jObjectFieldOffset = unsafe.objectFieldOffset(ih2.class.getDeclaredField("artFieldOrMethod"));
            d = jObjectFieldOffset;
            e = unsafe.objectFieldOffset(jh2.class.getDeclaredField("info"));
            long jObjectFieldOffset2 = unsafe.objectFieldOffset(eh2.class.getDeclaredField("methods"));
            f = jObjectFieldOffset2;
            long jObjectFieldOffset3 = unsafe.objectFieldOffset(eh2.class.getDeclaredField("iFields"));
            g = jObjectFieldOffset3;
            h = unsafe.objectFieldOffset(eh2.class.getDeclaredField("sFields"));
            i = unsafe.objectFieldOffset(gh2.class.getDeclaredField("member"));
            Method declaredMethod = kh2.class.getDeclaredMethod("a", new Class[0]);
            Method declaredMethod2 = kh2.class.getDeclaredMethod(t.l, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j2 = unsafe.getLong(methodHandleUnreflect, jObjectFieldOffset);
            long j3 = unsafe.getLong(methodHandleUnreflect2, jObjectFieldOffset);
            long j4 = unsafe.getLong(kh2.class, jObjectFieldOffset2);
            long j5 = j3 - j2;
            j = j5;
            k = (j2 - j4) - j5;
            Field declaredField = kh2.class.getDeclaredField("i");
            Field declaredField2 = kh2.class.getDeclaredField(hb.j);
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            long j6 = unsafe.getLong(methodHandleUnreflectGetter, jObjectFieldOffset);
            long j7 = unsafe.getLong(methodHandleUnreflectGetter2, jObjectFieldOffset);
            long j8 = unsafe.getLong(kh2.class, jObjectFieldOffset3);
            l = j7 - j6;
            m = j6 - j8;
        } catch (ReflectiveOperationException e2) {
            Log.e("HiddenApiBypass", "Initialize error", e2);
            throw new ExceptionInInitializerError(e2);
        }
    }

    @VisibleForTesting
    public static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (clsArr[i2].isPrimitive()) {
                Class cls = clsArr[i2];
                if (cls == Integer.TYPE && !(objArr[i2] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i2] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i2] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i2] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i2] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i2] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i2] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i2] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i2];
                if (obj != null && !clsArr[i2].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        Set set = n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return d(strArr2);
    }

    public static Object c(@NonNull Class cls, @Nullable Object obj, @NonNull String str, Object... objArr) throws NoSuchMethodException {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = hh2.class.getDeclaredMethod(Launcher.Method.INVOKE_CALLBACK, Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = f20747a;
        long j2 = unsafe.getLong(cls, f);
        if (j2 == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i2 = unsafe.getInt(j2);
        for (int i3 = 0; i3 < i2; i3++) {
            f20747a.putLong(declaredMethod, b, (((long) i3) * j) + j2 + k);
            if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean d(@NonNull String... strArr) {
        try {
            c(VMRuntime.class, c(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
            return false;
        }
    }
}
