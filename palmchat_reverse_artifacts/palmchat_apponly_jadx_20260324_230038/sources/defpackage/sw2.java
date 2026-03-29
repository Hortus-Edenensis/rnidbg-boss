package defpackage;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sw2 {
    public static void d(Context context, int i) {
        boolean z;
        boolean z2;
        String strN = kv2.n(context);
        boolean zA = new sw2().a(context);
        boolean z3 = true;
        if (!TextUtils.isEmpty(strN)) {
            if (TextUtils.equals("ON", strN)) {
                z = false;
                z2 = true;
            } else {
                z = !TextUtils.equals("OFF", strN);
                z2 = false;
            }
            if (z) {
                p63.a("JNotificationState", "notification state do not changed");
                z3 = z;
            } else if (z2 == zA) {
                z3 = false;
            }
        }
        p63.a("JNotificationState", "lastCacheNotificationState:" + strN + ",currentNotificationSate:" + zA + ",isNeedReport:" + z3 + ",triggerScene:" + i);
        if (!z3) {
            p63.a("JNotificationState", "do not need report notification state");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("notification_state", zA);
            jSONObject.put(WkParams.IMEI, "");
            jSONObject.put("device_id", rv2.i(context));
            jSONObject.put("trigger_scene", i);
            rv2.b(context, jSONObject, "android_notification_state");
            rv2.C(context, jSONObject);
            kv2.H(context, zA ? "ON" : "OFF");
        } catch (Throwable th) {
            p63.f("JNotificationState", "report notification state failed, error:" + th.getMessage());
        }
    }

    public final boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? b(context) : c(context);
    }

    @TargetApi(24)
    public final boolean b(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            p63.f("JNotificationState", "invoke areNotificationsEnabled method failed, error:" + th.getMessage());
            return true;
        }
    }

    public final boolean c(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        } catch (Throwable th) {
            p63.f("JNotificationState", "getNotificationStateCommon failed, other error:" + th.getMessage());
            return true;
        }
    }
}
