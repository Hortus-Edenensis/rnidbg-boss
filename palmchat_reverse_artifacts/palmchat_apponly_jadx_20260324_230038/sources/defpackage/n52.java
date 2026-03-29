package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.sdk.PushManager;
import com.zenmen.palmchat.thirdapp.lxgt.daemon.LXGTActivity;
import com.zenmen.palmchat.thirdapp.lxgt.daemon.LXGTService;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class n52 {
    public static void a(Context context) {
        boolean z;
        int i;
        boolean zOptBoolean;
        int iOptInt;
        boolean zOptBoolean2;
        int iOptInt2;
        if (ot0.f().b("getui")) {
            LogUtil.i("GeTuiInitHelper", "init ");
            b(context);
            c(context);
            PushManager.getInstance().initialize(context);
            String strM = k86.m(context);
            boolean z2 = true;
            if (TextUtils.isEmpty(strM) || strM.equals(context.getPackageName())) {
                JSONObject config = vs0.a().getConfig("getui_push");
                int iOptInt3 = 24;
                int i2 = 168;
                if (config != null) {
                    boolean zOptBoolean3 = config.optBoolean("imei_open", true);
                    int iOptInt4 = config.optInt("imei_interval", 168);
                    zOptBoolean = config.optBoolean("imsi_open", true);
                    iOptInt = config.optInt("imsi_interval", 168);
                    zOptBoolean2 = config.optBoolean("mac_open", true);
                    iOptInt2 = config.optInt("mac_interval", 168);
                    boolean zOptBoolean4 = config.optBoolean("iccId_open", true);
                    int iOptInt5 = config.optInt("iccId_interval", 168);
                    iOptInt3 = config.optInt("app_interval", 24);
                    z = zOptBoolean4;
                    z2 = zOptBoolean3;
                    i = iOptInt5;
                    i2 = iOptInt4;
                } else {
                    z = true;
                    i = 168;
                    zOptBoolean = true;
                    iOptInt = 168;
                    zOptBoolean2 = true;
                    iOptInt2 = 168;
                }
                PushManager.getInstance().setImeiEnable(context, z2);
                if (z2) {
                    PushManager.getInstance().setImeiInterval(context, i2);
                }
                b05.d("设置imsi_open=" + PushManager.getInstance().setImsiEnable(context, zOptBoolean));
                if (zOptBoolean) {
                    PushManager.getInstance().setImsiInterval(context, iOptInt);
                }
                PushManager.getInstance().setMacEnable(context, zOptBoolean2);
                if (zOptBoolean2) {
                    PushManager.getInstance().setMacInterval(context, iOptInt2);
                }
                PushManager.getInstance().setIccIdEnable(context, z);
                if (z) {
                    PushManager.getInstance().setIccIdInterval(context, i);
                }
                PushManager.getInstance().setAppListInterval(context, iOptInt3);
            }
        }
    }

    public static void b(Context context) {
        try {
            Method declaredMethod = PushManager.class.getDeclaredMethod("registerPushActivity", Context.class, Class.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(PushManager.getInstance(), context.getApplicationContext(), LXGTActivity.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(Context context) {
        try {
            Method declaredMethod = PushManager.class.getDeclaredMethod("registerUserService", Context.class, Class.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(PushManager.getInstance(), context.getApplicationContext(), LXGTService.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d(String str) {
        JSONObject jSONObjectG = x63.g();
        try {
            jSONObjectG.put("wakedType", str);
            jSONObjectG.put("OSver", ac1.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jSONObjectG.toString();
        zn6.d("lx_client_app_205152", null, string);
        LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_KEEPALIVE, null, "205152", "1", null, string);
        vt0.d().n("from_getui");
    }
}
