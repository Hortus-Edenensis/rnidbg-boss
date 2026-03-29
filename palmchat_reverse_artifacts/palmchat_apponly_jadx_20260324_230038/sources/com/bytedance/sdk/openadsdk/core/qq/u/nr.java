package com.bytedance.sdk.openadsdk.core.qq.u;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.qq.u.nr;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.lantern.auth.server.WkParams;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr<T extends nr> implements u {
    private String fx;
    private String jk;
    private String k;
    private String l;
    private String mv;
    private String n;
    private String nr;
    private String pn;
    private String s;
    private String t;
    private String u;
    private String b = d.b;
    private long iz = System.currentTimeMillis() / 1000;
    private int x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5362a = 0;

    public static nr<nr> nr() {
        return new nr<>();
    }

    private JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            com.bytedance.sdk.openadsdk.k.nr.nr(dw.getContext(), jSONObject);
            jSONObject.put("oaid", jk.fx(false));
            jSONObject.put(WkParams.MODEL, jk.nr());
            jSONObject.put("android_id", jk.u());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", jp.a());
            jSONObject.put("ua", jk.mv());
            jSONObject.put("applog_did", jk.o());
            jSONObject.put("ip", jk.s());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public long a() {
        return this.iz;
    }

    public String b() {
        return this.nr;
    }

    public String fx() {
        return this.mv;
    }

    public String getType() {
        return this.u;
    }

    public String iz() {
        return this.b;
    }

    public int jk() {
        return this.x;
    }

    public String k() {
        return this.l;
    }

    public int l() {
        return this.f5362a;
    }

    public String mv() {
        return this.jk;
    }

    public String my() {
        return this.k;
    }

    public String n() {
        return this.pn;
    }

    public String pn() {
        return this.fx;
    }

    public String s() {
        return this.t;
    }

    public String t() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq.u.u
    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put("type", getType());
            }
            if (!TextUtils.isEmpty(b())) {
                jSONObject.put("rit", b());
            }
            if (!TextUtils.isEmpty(pn())) {
                jSONObject.put("creative_id", pn());
            }
            if (!TextUtils.isEmpty(iz())) {
                jSONObject.put("ad_sdk_version", iz());
            }
            if (TextUtils.isEmpty(n())) {
                jSONObject.put("app_version", jp.t());
            } else {
                jSONObject.put("app_version", n());
            }
            if (a() > 0) {
                jSONObject.put("timestamp", a());
            }
            if (jk() > 0) {
                jSONObject.put("adtype", jk());
            }
            if (!TextUtils.isEmpty(t())) {
                jSONObject.put(ReportItem.RequestKeyRequestId, t());
            }
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, l());
            if (!TextUtils.isEmpty(mv())) {
                jSONObject.put("error_msg", mv());
            }
            if (!TextUtils.isEmpty(s())) {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, s());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put(WfConstant.EXTRA_KEY_IMAGE_URL, k());
            }
            if (!TextUtils.isEmpty(fx())) {
                jSONObject.put("event_extra", fx());
            }
            if (!TextUtils.isEmpty(x())) {
                jSONObject.put("duration", x());
            }
            if (!TextUtils.isEmpty(n.o().c())) {
                jSONObject.put("appid", n.o().c());
            }
            if (!TextUtils.isEmpty(my())) {
                jSONObject.put("ad_info", my());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("is_plugin", d.u());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", o.nr(dw.getContext()));
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("device_info", o());
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public String x() {
        return this.s;
    }

    public T a(String str) {
        this.k = str;
        return (T) sx();
    }

    public T b(String str) {
        this.fx = str;
        return (T) sx();
    }

    public T fx(String str) {
        this.nr = str;
        return (T) sx();
    }

    public T iz(String str) {
        this.n = str;
        return (T) sx();
    }

    public T n(String str) {
        this.t = str;
        return (T) sx();
    }

    public T nr(String str) {
        this.mv = str;
        return (T) sx();
    }

    public T pn(String str) {
        this.s = str;
        return (T) sx();
    }

    public T x(String str) {
        this.jk = str;
        return (T) sx();
    }

    public T nr(int i) {
        this.f5362a = i;
        return (T) sx();
    }

    private T sx() {
        return this;
    }

    public T u(String str) {
        this.u = str;
        return (T) sx();
    }

    public T u(long j) {
        this.iz = j;
        return (T) sx();
    }

    public T u(int i) {
        this.x = i;
        return (T) sx();
    }
}
