package com.bytedance.sdk.openadsdk.core.qq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.n.u.n {
    public static final u u = new u();
    private String b;
    private int fx;
    private long nr;

    private u() {
    }

    public static int l() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String t() {
        StringBuilder sb = new StringBuilder();
        try {
            if (gi.my()) {
                sb.append("MIUI-");
            } else if (gi.bq()) {
                sb.append("FLYME-");
            } else {
                String strDw = gi.dw();
                if (gi.u(strDw)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strDw)) {
                    sb.append(strDw);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String u(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", sx.fx());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public int b() {
        int iBf = dw.nr().bf();
        if (iBf < 0 || iBf == Integer.MAX_VALUE) {
            return 10;
        }
        return iBf;
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public long fx() {
        long jRh = dw.nr().rh();
        if (jRh < 0 || jRh == 2147483647L) {
            return 5000L;
        }
        return jRh;
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public String iz() {
        return jp.qq();
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public int jk() {
        return dw.nr().fn() ? 4 : 3;
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public boolean n() {
        return d.u();
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public byte[] nr(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrNr = nr(jSONObject);
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        if (bArrNr == null || uVarNr == null || !uVarNr.getArmorLoadStatus() || i <= 3) {
            return null;
        }
        byte[] bArrEncrypt = uVarNr.encrypt(bArrNr);
        if (bArrEncrypt != null) {
            return bArrEncrypt;
        }
        s.u().u(3, -1L, "stats");
        return bArrEncrypt;
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public com.bytedance.sdk.component.n.u.u.iz pn() {
        return new l(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr());
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public String x() {
        return jp.a("/api/ad/union/sdk/stats/batch/");
    }

    public String u(Context context) {
        try {
            return com.bytedance.sdk.openadsdk.core.y.t.fx(context) ? "tv" : com.bytedance.sdk.openadsdk.core.y.t.nr(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject u(List<com.bytedance.sdk.component.n.u.nr> list, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        Context context = dw.getContext();
        int i = 0;
        if (z) {
            try {
                jSONObject.put("sdk_version", d.b);
                jSONObject.put(bt.s, com.bytedance.sdk.openadsdk.core.n.u.pn());
                jSONObject.put("app_version", com.bytedance.sdk.openadsdk.core.n.u.b());
                jSONObject.put("package", jp.a());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> arrayListU = com.bytedance.sdk.component.utils.fx.u(context, "MD5");
                if (arrayListU != null && !arrayListU.isEmpty()) {
                    jSONObject.put("sig_hash", arrayListU.get(0));
                }
                jSONObject.put("version_code", jp.jk());
            } catch (Throwable th) {
                k.nr("log_net", th.getMessage());
            }
        }
        jSONObject.put("ua", com.bytedance.sdk.openadsdk.core.y.jk.mv());
        com.bytedance.sdk.openadsdk.k.nr.fx(context, jSONObject);
        jSONObject.put("openudid", com.bytedance.sdk.openadsdk.core.y.jk.u());
        jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.y.jk.fx(false));
        jSONObject.put("ad_sdk_version", d.b);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
        jSONObject.put("is_plugin", d.u());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.y.sx.u((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.y.jk.k());
        jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        jSONObject.put("sim_op", sx.t());
        jSONObject.put("root", z2 ? 1 : 0);
        jSONObject.put(bt.M, com.bytedance.sdk.openadsdk.core.y.jk.bg());
        jSONObject.put(bt.Q, o.x(context));
        jSONObject.put("os", AnalyticsConstants.SDK_TYPE);
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.b)) {
            this.b = u(context);
        }
        jSONObject.put(bt.ac, this.b);
        jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.y.jk.nr());
        jSONObject.put(bt.F, Build.BRAND);
        jSONObject.put(bt.H, Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put("resolution", y.pn(context) + "x" + y.b(context));
        jSONObject.put("display_density", u(y.n(context)));
        jSONObject.put("density_dpi", y.n(context));
        jSONObject.put("device_id", sx.fx());
        int iFx = com.bytedance.sdk.component.n.nr.fx.u.fx(list, com.bytedance.sdk.component.n.nr.u.pn("csj"));
        if (iFx != 0) {
            jSONObject.put("aid", String.valueOf(iFx));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put("rom", com.bytedance.sdk.openadsdk.core.y.jk.bq());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", com.bytedance.sdk.openadsdk.core.y.jk.t());
        jSONObject.put("ut", this.fx);
        jSONObject.put(DeviceInfoUtil.UID_TAG, this.nr);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.y.jk.fx());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.y.t.x() * 10.0f) / 10.0d);
        if (!com.bytedance.sdk.openadsdk.core.y.t.u()) {
            i = 1;
        }
        jSONObject.put("is_screen_off", i);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.n.u.u(context));
        }
        if (com.bytedance.sdk.openadsdk.core.gi.fx() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(com.bytedance.sdk.openadsdk.core.gi.fx()));
        }
        jSONObject.put("mnc", com.bytedance.sdk.openadsdk.core.y.jk.pn());
        jSONObject.put("mcc", com.bytedance.sdk.openadsdk.core.y.jk.b());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    private byte[] nr(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(jSONObject.toString().getBytes());
            gZIPOutputStream.close();
        } catch (Exception unused3) {
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public String nr() {
        return jp.kj();
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public JSONObject u(List<com.bytedance.sdk.component.n.u.nr> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z2 = false;
            try {
                u(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectX = it.next().x();
                    if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectX.optString("event"))) {
                        if (!z2) {
                            z2 = true;
                        }
                        jSONObjectX.putOpt("nt", Integer.valueOf(o.fx(dw.getContext())));
                    }
                    jSONArray.put(jSONObjectX);
                }
                jSONObject.put("header", u(list, z2, z));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                k.u(e.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public byte[] u(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrNr = nr(jSONObject);
        if (bArrNr == null) {
            return null;
        }
        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
        if (i > 3 && uVarNr != null) {
            byte[] bArrEncrypt = uVarNr.encrypt(bArrNr);
            if (bArrEncrypt != null) {
                return bArrEncrypt;
            }
            s.u().u(3, -1L, "applog");
            return bArrEncrypt;
        }
        return TTEncryptUtils.a(bArrNr, bArrNr.length);
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public boolean u() {
        return com.bytedance.sdk.openadsdk.core.n.o().wi();
    }

    @Override // com.bytedance.sdk.component.n.u.n
    public JSONObject u(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.u.u(jSONObject);
    }

    private void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        String strOptString;
        if (nrVar == null) {
            return;
        }
        JSONObject jSONObjectX = nrVar.x();
        JSONObject jSONObjectOptJSONObject = jSONObjectX.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("log_extra", "");
        } else {
            strOptString = jSONObjectX.optString("log_extra", "");
        }
        long jB = jp.b(strOptString);
        int iPn = jp.pn(strOptString);
        if (jB == 0) {
            jB = this.nr;
        }
        this.nr = jB;
        if (iPn == 0) {
            iPn = this.fx;
        }
        this.fx = iPn;
    }
}
