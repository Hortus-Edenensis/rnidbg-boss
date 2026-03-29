package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.b.u;
import com.bytedance.sdk.openadsdk.TTFileProvider;
import com.bytedance.sdk.openadsdk.core.kj.rv;
import com.kuaishou.weapon.p0.g;
import com.lantern.auth.server.WkParams;
import com.wifi.adsdk.download.LxAdDLManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kj {
    private static int b = 300;
    public static int fx = 2;
    public static int nr = 1;
    private static volatile u.InterfaceC0214u pn;
    public static int u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements u.nr {
        @Override // com.bytedance.sdk.component.b.u.nr
        public void reportSoftDecData(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            kj.u(jSONObject.toString(), str);
        }

        @Override // com.bytedance.sdk.component.b.u.nr
        public void setCryptInitStatus(long j, boolean z) {
            com.bytedance.sdk.openadsdk.core.qq.s.u().u(10001, j, Boolean.valueOf(z), (String) null);
        }
    }

    public static void a() {
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.3
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.component.b.u uVarNr = kj.nr();
                jSONObject.put("board", Build.BOARD + "#" + uVarNr.pglArmorCallApi2getProperty("ro.product.board", "unknown"));
                jSONObject.put(WkParams.MODEL, Build.MODEL + "#" + uVarNr.pglArmorCallApi2getProperty("ro.product.model", "unknown"));
                jSONObject.put("os_version", Build.VERSION.RELEASE + "#" + uVarNr.pglArmorCallApi2getProperty("ro.build.version.release", "unknown"));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + uVarNr.pglArmorCallApi2getProperty("ro.product.manufacturer", "unknown"));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + uVarNr.pglArmorCallApi2getProperty("ro.build.display.id", "unknown"));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(uVarNr.pglArmorCallApi2getProperty("ro.build.date.utc", "-1")) * 1000));
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pangle_build_pick").nr(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static JSONArray b() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put(WkParams.MODEL, usbAccessory.getModel());
                        jSONObject.put(LxAdDLManager.ITEM_DESC, usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void fx() {
        com.bytedance.sdk.component.b.u uVarNr = nr();
        if (uVarNr != null) {
            uVarNr.initPglArmorCallApi(new u());
        }
    }

    public static String iz() {
        try {
            com.bytedance.sdk.component.b.u uVarNr = nr();
            if (!com.bytedance.sdk.openadsdk.core.n.o().l()) {
                uVarNr.setBlt(false);
            }
            return uVarNr.getSoftChara();
        } catch (Throwable th) {
            return u(th);
        }
    }

    public static String jk() {
        rv rvVarT = t();
        com.bytedance.sdk.openadsdk.core.xw.u.u().u(rvVarT);
        if (rvVarT != null) {
            String string = rvVarT.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static void l() {
        Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.jp.u.fx fxVarU = com.bytedance.sdk.openadsdk.core.jp.u.fx.u(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.h.nr.u(context, g.b));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.h.nr.u(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put(WkParams.SIM, com.bytedance.sdk.openadsdk.core.jp.u.pn.u());
                jSONObject.put("network", fxVarU.u());
                u(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String mv() {
        com.bytedance.sdk.component.b.u uVarNr = nr();
        return uVarNr != null ? uVarNr.getArchEnv() : "";
    }

    public static boolean n() {
        String strMy = com.bytedance.sdk.openadsdk.core.dw.nr().my();
        try {
            com.bytedance.sdk.component.b.u uVarNr = nr();
            if (uVarNr != null) {
                return uVarNr.detectHostLocalIp(strMy);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static com.bytedance.sdk.component.b.u nr() {
        return (com.bytedance.sdk.component.b.u) com.bytedance.sdk.openadsdk.ats.fx.u("armor_service");
    }

    public static void pn() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayB = b();
            if (jSONArrayB.length() > 0) {
                jSONObject.put("usb", jSONArrayB);
            }
            JSONObject jSONObject2 = new JSONObject();
            int i = TTFileProvider.d;
            ClassLoader classLoader = TTFileProvider.class.getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                Class<? super Object> superclass = classLoader.getClass().getSuperclass();
                while (true) {
                    if (superclass == null || superclass.getName().equals("java.lang.Object")) {
                        break;
                    }
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        u(classLoader, superclass, jSONObject2);
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            u(jSONObject.toString(), "pangle_check");
        }
    }

    public static rv t() {
        try {
            if (!com.bytedance.sdk.openadsdk.core.dw.nr().uo()) {
                return null;
            }
            rv rvVarU = com.bytedance.sdk.openadsdk.core.jp.u.u(com.bytedance.sdk.openadsdk.core.dw.getContext()).u();
            if (rvVarU != null) {
                return rvVarU;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void u() {
        jk();
        iz();
        if (com.bytedance.sdk.openadsdk.core.dw.nr().ju()) {
            x();
            pn();
            a();
            l();
        }
    }

    public static void x() {
        String[] strArrLl = com.bytedance.sdk.openadsdk.core.dw.nr().ll();
        if (strArrLl == null || strArrLl.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrLl) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            u(arrayList);
        }
    }

    public static void nr(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.rh.fx fxVar;
        if (jSONObject == null || com.bytedance.sdk.openadsdk.core.dw.u(10003) == null || (fxVar = (com.bytedance.sdk.openadsdk.core.rh.fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya")) == null || !fxVar.isPitayaInitSuccess()) {
            return;
        }
        fxVar.isPitayaEnvAvailable();
        fxVar.runTask("antispam_handhold", jSONObject, new com.bytedance.sdk.openadsdk.core.rh.n() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.5
            @Override // com.bytedance.sdk.openadsdk.core.rh.n
            public PluginValueSet u(int i, com.bytedance.sdk.openadsdk.core.rh.a aVar) {
                com.bytedance.sdk.openadsdk.my.u uVarFx = aVar.fx();
                if (uVarFx == null) {
                    return null;
                }
                PluginValueSet pluginValueSetB = uVarFx.b();
                if (!uVarFx.u() || pluginValueSetB == null) {
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) pluginValueSetB.objectValue(2, JSONObject.class);
                if (jSONObject2 != null) {
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
                        if (jSONArray.length() == 1 && uVarNr != null) {
                            uVarNr.softDecTool2ua(jSONArray.optDouble(0), System.currentTimeMillis());
                        }
                    } catch (JSONException unused) {
                    }
                }
                return pluginValueSetB;
            }
        });
    }

    private static void u(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3);
                        sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void u(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(str2).nr(str);
            }
        }, str2);
    }

    public static void u(MotionEvent motionEvent) {
        try {
            nr().pglArmorCallApi2c(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String u(String str, long j, int i, boolean z) {
        try {
            return nr().pglArmorCallApi2ccc(str, j, i, z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void u(long j, int i) {
        try {
            nr().pglArmorCallApi2src(j, i);
        } catch (Throwable unused) {
        }
    }

    public static int u(String str) {
        int i = u;
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf("_");
            if (iIndexOf <= 0) {
                return fx;
            }
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            int iIndexOf2 = strSubstring2.indexOf("_");
            if (iIndexOf2 <= 0) {
                return fx;
            }
            String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
            String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
            long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
            try {
                com.bytedance.sdk.component.b.u uVarNr = nr();
                if (uVarNr != null) {
                    if (!uVarNr.signVerifyMD5withRSA(strSubstring3 + "_" + com.bytedance.sdk.openadsdk.core.sx.fx(), strSubstring4)) {
                        return fx;
                    }
                }
                if (Math.abs(jLongValue) > b) {
                    i = nr;
                }
                return i;
            } catch (Throwable unused) {
                return u;
            }
        }
        return fx;
    }

    public static String u(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void u(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pangle_clz_found").nr(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void u(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.4
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("har_automatic").nr(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void u(int i, final int i2) {
        final com.bytedance.sdk.component.b.u uVarNr = nr();
        if (uVarNr == null || uVarNr.getArmorContext() == null || !com.bytedance.sdk.openadsdk.core.n.o().pn() || !uVarNr.enableSetHARSensorCallBack(i)) {
            return;
        }
        if (pn == null) {
            pn = new u.InterfaceC0214u() { // from class: com.bytedance.sdk.openadsdk.core.y.kj.6
                @Override // com.bytedance.sdk.component.b.u.InterfaceC0214u
                public void reportSensorData(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("scene", i2);
                        } catch (JSONException unused) {
                        }
                        kj.nr(jSONObject);
                        kj.u(jSONObject);
                    }
                }
            };
            uVarNr.setHARSensorCallBack(pn);
        }
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("har") { // from class: com.bytedance.sdk.openadsdk.core.y.kj.7
            @Override // java.lang.Runnable
            public void run() {
                uVarNr.registerHarSensors();
            }
        });
    }
}
