package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import com.umeng.analytics.pro.dn;
import java.lang.reflect.Field;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pble {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f19325a = -1;
    public static volatile String b = "";

    public static String a(Context context) {
        try {
            if (b == "") {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return b;
    }

    public static int b(Context context) {
        if (f19325a <= 0) {
            try {
                f19325a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return f19325a;
    }

    @SuppressLint({"PrivateApi"})
    public static Activity c() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e300ab", new byte[]{117, Utf8.REPLACEMENT_BYTE, 71, 86, 81, 124, 98, 92, 96, 112, 100, ByteCompanionObject.MAX_VALUE, 98, 71, 74, 124, 112, 27, 117, 121, 64, 57, 81, 65, 95, 113}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "72df0f", new byte[]{37, 37, 5, 0, 10, ByteCompanionObject.MAX_VALUE, 32, 50, 54, 34, 47, 38, 30, 6, 22, 69, 60, 1, 48, 55, 34}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bd728f", new byte[]{126, 71, 71, 82, dn.l, 103, 104, 81, 111, 103, 96}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbc29d", new byte[]{103, 97, 5, 85, 3, 119}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e28c4", new byte[]{35, 100, 85, 69, 74, 42, 36, 93}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e3a0ef", new byte[]{117, 56, 45, 67});
        }
        return null;
    }
}
