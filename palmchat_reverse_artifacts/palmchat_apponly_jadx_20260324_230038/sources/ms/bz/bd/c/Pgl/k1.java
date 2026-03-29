package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19316a;
    public static String b;

    @SuppressLint({"MissingPermission"})
    public static synchronized String a(Context context) {
        TelephonyManager telephonyManager;
        String str = f19316a;
        if (str != null) {
            return v1.a(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblr.a("676574537562736372696265724964")), new Class[0]);
        declaredMethod.setAccessible(true);
        b = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return v1.a(b);
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String b(Context context) {
        TelephonyManager telephonyManager;
        String str = f19316a;
        if (str != null) {
            return v1.a(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblr.a("6765744465766963654964")), new Class[0]);
        declaredMethod.setAccessible(true);
        f19316a = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return v1.a(f19316a);
    }
}
