package com.qq.gdt.action.j;

import android.provider.Settings;
import com.kuaishou.weapon.p0.bq;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f10533a = null;
    private static String b = "";

    public static void a(JSONObject jSONObject) {
        try {
            if (com.qq.gdt.action.d.a().g() == null) {
                o.a("fillHarmonyInfo getApplicationContext is null  ", new Object[0]);
                jSONObject.putOpt("is_harmony_open", Boolean.FALSE);
                return;
            }
            boolean z = com.qq.gdt.action.b.a(com.qq.gdt.action.d.a().g()).n() == 0;
            o.a("fillHarmonyInfo harmonyCollect = " + z, new Object[0]);
            jSONObject.putOpt("is_harmony_open", Boolean.valueOf(z));
            if (z) {
                boolean zA = a();
                jSONObject.putOpt("is_harmony_os", Boolean.valueOf(zA));
                if (zA) {
                    jSONObject.putOpt("harmony_version", b());
                    jSONObject.putOpt("harmony_pure_mode", Integer.valueOf(c()));
                }
            }
        } catch (Throwable th) {
            o.c("fillHarmonyInfo error" + th);
        }
    }

    private static String b() {
        if (!a()) {
            return "";
        }
        if (!v.a(b)) {
            return b;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            b = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "hw_sc.build.platform.version");
            o.a("getHarmonyInfoFromSystemProperties value: " + b, new Object[0]);
        } catch (Throwable th) {
            b = bq.e;
            o.a("HarmonyOS getVersion" + th, new Object[0]);
        }
        return b;
    }

    private static int c() {
        try {
            if (com.qq.gdt.action.d.a().g() != null) {
                return Settings.Secure.getInt(com.qq.gdt.action.d.a().g().getContentResolver(), "pure_mode_state", -1);
            }
            return -1;
        } catch (Throwable th) {
            o.a("HarmonyOS getPureMode" + th, new Object[0]);
            return -1;
        }
    }

    private static boolean a() {
        Boolean bool = f10533a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            f10533a = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (Throwable th) {
            o.a("isHarmonyOS" + th, new Object[0]);
            f10533a = Boolean.FALSE;
        }
        return f10533a.booleanValue();
    }
}
