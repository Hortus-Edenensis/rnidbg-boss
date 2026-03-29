package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.report.ITdReportParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b0 implements ITdReportParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10784a;
    public HashMap b;

    public b0(String str, HashMap map) {
        this.f10784a = str;
        a(map);
    }

    public final void a(HashMap map) {
        if (map != null && map.size() > 0) {
            a("extra_info", map);
        }
        a("plugin_ver_name", this.f10784a);
        a("plugin_ver_code", Integer.valueOf(TideWholeConfig.getInstance().getPluginVersionCode(this.f10784a)));
        a("host_ver_code", Integer.valueOf(TideWholeConfig.getInstance().getHostVersionCode(this.f10784a)));
        a("app_id", TideWholeConfig.getInstance().getAppId(this.f10784a));
        a("app_code", Integer.valueOf(TideWholeConfig.getInstance().getAppVersionCode()));
        a("app_version", TideWholeConfig.getInstance().getAppVersion());
        a("app_pkg", TideWholeConfig.getInstance().getPackageName());
        a("android_id", TideWholeConfig.getInstance().getAndroidId());
        a("os_version", Integer.valueOf(TideWholeConfig.getInstance().getOsVersion()));
        a("os", "android");
        a("vendor", TideWholeConfig.getInstance().getVendor());
        a("oa_id", TideWholeConfig.getInstance().getOaId());
        a("time_temp", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tide.protocol.report.ITdReportParams
    public final JSONObject toJsonObject() {
        return null;
    }

    @Override // com.tide.protocol.report.ITdReportParams
    public final String toJsonString() {
        return null;
    }

    @Override // com.tide.protocol.report.ITdReportParams
    public final Map toMap() {
        return this.b;
    }

    public b0(String str, String str2) {
        this.f10784a = str;
        a("p_request_id", str2);
        a(null);
    }

    public final void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, obj);
    }
}
