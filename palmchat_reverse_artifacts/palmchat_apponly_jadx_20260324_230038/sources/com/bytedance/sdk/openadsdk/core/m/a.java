package com.bytedance.sdk.openadsdk.core.m;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private final String b;
    private final JSONObject fx;
    private String iz;
    private final String nr;
    private String pn;
    private final Map<String, List<String>> u;

    public a(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.nr = str;
        this.b = str2;
        this.u = map;
        this.fx = jSONObject;
    }

    public String b() {
        return this.b;
    }

    public String fx() {
        try {
            String strOptString = this.fx.optString("expandParams");
            String str = "apppackage=" + this.pn + "|appsign=" + this.iz;
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str;
            }
            this.fx.put("expandParams", str);
        } catch (Exception unused) {
        }
        JSONObject jSONObject = this.fx;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String nr() {
        return this.nr;
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.u.get(str);
        if (list != null) {
            list.add(str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.u.put(str, arrayList);
    }

    public void nr(String str) {
        this.iz = str;
    }

    public Map<String, List<String>> u() {
        return this.u;
    }

    public void u(String str) {
        this.pn = str;
    }
}
