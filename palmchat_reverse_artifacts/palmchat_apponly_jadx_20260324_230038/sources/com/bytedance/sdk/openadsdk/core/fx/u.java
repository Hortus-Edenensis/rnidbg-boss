package com.bytedance.sdk.openadsdk.core.fx;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.b;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.d;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.l;
import com.bytedance.sdk.openadsdk.core.y.qq;
import com.bytedance.sdk.openadsdk.core.y.t;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.lantern.auth.server.WkParams;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile String b = null;
    private static AtomicBoolean fx = new AtomicBoolean(false);
    private static boolean nr = false;
    private static long u = -1;

    public static String fx() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String strFx = b.u().fx((String) null);
        b = strFx;
        return strFx;
    }

    public static boolean nr() {
        if (nr) {
            return true;
        }
        if (u == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - u > 60000;
        nr = z;
        return z;
    }

    public static void u() {
        if (u > -1) {
            return;
        }
        u = SystemClock.elapsedRealtime();
    }

    public static JSONObject u(Context context, int i) {
        return nr(context, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0345 A[Catch: all -> 0x0393, TryCatch #0 {all -> 0x0393, blocks: (B:3:0x0009, B:7:0x0019, B:10:0x0025, B:12:0x002f, B:15:0x0036, B:22:0x004b, B:24:0x0055, B:27:0x005c, B:32:0x006d, B:35:0x007a, B:37:0x0084, B:40:0x008b, B:45:0x009c, B:48:0x00a8, B:52:0x00bb, B:54:0x00c5, B:57:0x00cc, B:62:0x00dd, B:65:0x0179, B:67:0x0183, B:70:0x018a, B:75:0x019b, B:79:0x01ee, B:81:0x025e, B:84:0x026b, B:86:0x0275, B:89:0x027c, B:97:0x0292, B:99:0x029c, B:102:0x02a3, B:110:0x02b9, B:112:0x02c3, B:115:0x02ca, B:123:0x02e0, B:125:0x02ea, B:129:0x02f2, B:137:0x0308, B:139:0x0312, B:144:0x0323, B:147:0x0333, B:149:0x0341, B:151:0x034c, B:153:0x035f, B:154:0x0364, B:156:0x0373, B:157:0x0378, B:161:0x0390, B:160:0x038d, B:150:0x0345, B:140:0x0316, B:143:0x0320, B:130:0x02f6, B:134:0x0301, B:116:0x02ce, B:120:0x02d9, B:103:0x02a7, B:107:0x02b2, B:90:0x0280, B:94:0x028b, B:71:0x018e, B:74:0x0198, B:58:0x00d0, B:61:0x00da, B:49:0x00b0, B:41:0x008f, B:44:0x0099, B:28:0x0060, B:31:0x006a, B:16:0x003a, B:19:0x0044), top: B:164:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject nr(Context context, int i) {
        String strS;
        String strMv;
        String strL;
        String strT;
        String strJk;
        String strMy;
        String strA;
        String strN;
        String strX;
        String strT2;
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.h.u uVar = new com.bytedance.sdk.openadsdk.core.h.u();
            int i2 = 0;
            boolean z = !nr();
            b.nr nrVar = new b.nr();
            String str = null;
            if (z && (strT2 = b.u().t(null)) != null) {
                if (TextUtils.isEmpty(strT2)) {
                    strT2 = null;
                }
                jSONObject.put(WkParams.IMEI, strT2);
            } else {
                String strNr = jk.nr(uVar);
                jSONObject.put(WkParams.IMEI, strNr);
                if (strNr == null) {
                    strNr = "";
                }
                nrVar.u(strNr);
            }
            if (z && (strX = b.u().x()) != null) {
                if (TextUtils.isEmpty(strX)) {
                    strX = null;
                }
                jSONObject.put("android_id", strX);
            } else {
                String strU = jk.u();
                jSONObject.put("android_id", strU);
                if (strU == null) {
                    strU = "";
                }
                nrVar.nr(strU);
            }
            jSONObject.put(Constant.MAP_KEY_UUID, jk.sx());
            if (z && (strN = b.u().n()) != null) {
                if (TextUtils.isEmpty(strN)) {
                    strN = null;
                }
                jSONObject.put("ssid", strN);
            } else {
                String strB = jk.b(uVar);
                jSONObject.put("ssid", strB);
                if (strB == null) {
                    strB = "";
                }
                nrVar.fx(strB);
            }
            if (b.u().x(i)) {
                jSONObject.put("wifi_mac", sx.x());
            } else {
                jSONObject.put("wifi_mac", jk.u(uVar));
            }
            if (z && (strA = b.u().a()) != null) {
                if (TextUtils.isEmpty(strA)) {
                    strA = null;
                }
                jSONObject.put("imsi", strA);
            } else {
                String strPn = jk.pn(uVar);
                jSONObject.put("imsi", strPn);
                if (strPn == null) {
                    strPn = "";
                }
                nrVar.b(strPn);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() - SystemClock.elapsedRealtime());
            jSONObject.put("boot", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SystemClock.elapsedRealtime());
            jSONObject.put("power_on_time", sb2.toString());
            jSONObject.put("rom_version", gi.u());
            jSONObject.put("rom_new_version", gi.k());
            jSONObject.put("sys_compiling_time", jk.jk());
            jSONObject.put("type", jk.u(z));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(WkParams.MODEL, jk.nr());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", t.b());
            if (z && (strMy = b.u().my()) != null) {
                if (TextUtils.isEmpty(strMy)) {
                    strMy = null;
                }
                jSONObject.put("mac", strMy);
            } else {
                String strFx = jk.fx(uVar);
                jSONObject.put("mac", strFx);
                if (strFx == null) {
                    strFx = "";
                }
                nrVar.pn(strFx);
            }
            int[] iArrFx = y.fx(context);
            jSONObject.put("screen_width", iArrFx[0]);
            jSONObject.put("screen_height", iArrFx[1]);
            jSONObject.put("oaid", jk.fx(z));
            jSONObject.put("oaid_source", qq.u());
            jSONObject.put("free_space", l.u);
            jSONObject.put("locale_language", jk.fx());
            jSONObject.put("screen_bright", Math.ceil(t.x() * 10.0f) / 10.0d);
            if (!t.u()) {
                i2 = 1;
            }
            jSONObject.put("is_screen_off", i2);
            jSONObject.put("cpu_num", jp.s());
            jSONObject.put("cpu_max_freq", jp.k());
            jSONObject.put("cpu_min_freq", jp.my());
            jSONObject.put("battery_remaining_pct", (int) t.u.nr(context));
            jSONObject.put("is_charging", t.u.u(context));
            jSONObject.put("total_mem", jk.iz());
            jSONObject.put("total_space", jk.x());
            jSONObject.put("free_space_in", String.valueOf(jp.bg()));
            jSONObject.put("sdcard_size", String.valueOf(jp.bq()));
            jSONObject.put("rooted", jp.c());
            if (!b.u().x(i)) {
                jSONObject.put("enable_assisted_clicking", t.jk());
            }
            if (z && (strJk = b.u().jk()) != null) {
                if (TextUtils.isEmpty(strJk)) {
                    strJk = null;
                }
                jSONObject.put("mnc", strJk);
            } else {
                String strPn2 = jk.pn();
                jSONObject.put("mnc", strPn2);
                if (strPn2 == null) {
                    strPn2 = "";
                }
                nrVar.iz(strPn2);
            }
            if (z && (strT = b.u().t()) != null) {
                if (TextUtils.isEmpty(strT)) {
                    strT = null;
                }
                jSONObject.put("mcc", strT);
            } else {
                String strB2 = jk.b();
                jSONObject.put("mcc", strB2);
                if (strB2 == null) {
                    strB2 = "";
                }
                nrVar.x(strB2);
            }
            if (z && (strL = b.u().l()) != null) {
                if (TextUtils.isEmpty(strL)) {
                    strL = null;
                }
                jSONObject.put("mnc_2", strL);
            } else {
                String strMy2 = sx.my();
                jSONObject.put("mnc_2", strMy2);
                if (strMy2 == null) {
                    strMy2 = "";
                }
                nrVar.n(strMy2);
            }
            if (z && (strMv = b.u().mv()) != null) {
                if (!TextUtils.isEmpty(strMv)) {
                    str = strMv;
                }
                jSONObject.put("mcc_2", str);
            } else {
                String strS2 = sx.s();
                jSONObject.put("mcc_2", strS2);
                if (strS2 == null) {
                    strS2 = "";
                }
                nrVar.a(strS2);
            }
            if (z && (strS = b.u().s()) != null) {
                jSONObject.put("download_channel", strS);
            } else {
                String strU2 = com.bytedance.sdk.openadsdk.core.n.u.u(context);
                jSONObject.put("download_channel", strU2);
                nrVar.jk(strU2 != null ? strU2 : "");
            }
            nrVar.u();
            jSONObject.put("is_app_log_con", com.bytedance.sdk.component.n.nr.fx.u.u());
            if (z) {
                String strK = b.u().k();
                if (!TextUtils.isEmpty(strK)) {
                    jSONObject.put("applog_did", strK);
                } else {
                    jSONObject.put("applog_did", jk.o());
                }
                jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.u.u.u.nr());
                long jMv = t.mv();
                if (jMv != -1) {
                    jSONObject.put("client_global_did", jMv);
                }
                jSONObject.put("sys_vol", t.s());
                String strJk2 = kj.jk();
                if (strJk2 != null) {
                    jSONObject.put("ud", strJk2);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value")));
                } catch (NumberFormatException unused) {
                    jSONObject.put("device_score", -1);
                }
                t.u(jSONObject);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public static void u(JSONObject jSONObject, int i) throws JSONException {
        if (!fx.u().u(i)) {
            nr(jSONObject);
            return;
        }
        JSONArray jSONArrayO = b.u().o();
        if (jSONArrayO != null) {
            if (jSONArrayO.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayO);
            }
            if (fx.get()) {
                return;
            }
            fx.set(true);
            x.nr(new a("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.fx.u.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.nr(null);
                    } catch (Exception unused) {
                    }
                    u.fx.set(false);
                }
            });
            return;
        }
        nr(jSONObject);
    }

    public static String[] u(int i) {
        try {
            return jk.nr(!nr());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String u(String str, int i) {
        return com.bytedance.sdk.openadsdk.core.y.sx.u(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(JSONObject jSONObject) throws JSONException {
        Set<String> setWv = dw.nr().wv();
        if (setWv == null || setWv.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapU = d.u(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapU.entrySet()) {
            String key = entry.getKey();
            if (setWv.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            b.u().u(jSONArray);
        } else {
            x.nr(new a("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.fx.u.2
                @Override // java.lang.Runnable
                public void run() {
                    b.u().u(jSONArray);
                }
            });
        }
    }
}
