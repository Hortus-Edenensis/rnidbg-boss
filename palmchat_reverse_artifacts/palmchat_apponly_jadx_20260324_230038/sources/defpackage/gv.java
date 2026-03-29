package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static Method f17817a;

    @Nullable
    public static Method b;

    @Nullable
    public static IBinder a(Bundle bundle, @Nullable String str) {
        return g86.f17680a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    @Nullable
    public static IBinder b(Bundle bundle, @Nullable String str) {
        Method method = f17817a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f17817a = method2;
                method2.setAccessible(true);
                method = f17817a;
            } catch (NoSuchMethodException e) {
                y53.g("BundleUtil", "Failed to retrieve getIBinder method", e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            y53.g("BundleUtil", "Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }

    public static void c(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (g86.f17680a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    public static void d(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                b = method2;
                method2.setAccessible(true);
                method = b;
            } catch (NoSuchMethodException e) {
                y53.g("BundleUtil", "Failed to retrieve putIBinder method", e);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            y53.g("BundleUtil", "Failed to invoke putIBinder via reflection", e2);
        }
    }
}
