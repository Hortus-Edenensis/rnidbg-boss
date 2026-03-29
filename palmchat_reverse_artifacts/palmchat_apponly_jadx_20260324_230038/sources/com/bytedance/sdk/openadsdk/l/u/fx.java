package com.bytedance.sdk.openadsdk.l.u;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.l.u.u;
import com.qiniu.android.collect.ReportItem;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    private String n;

    public fx(com.bytedance.sdk.openadsdk.l.u uVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(uVar, str, str2, jSONObject, str3, str4);
        this.n = "inspect_data";
    }

    public void b() {
        JSONObject jSONObject = this.iz;
        if (jSONObject == null) {
            return;
        }
        s.u().b(jSONObject.toString(), this.iz.optString(ReportItem.RequestKeyRequestId));
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void fx() {
        this.u.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.u.fx.1
            @Override // java.lang.Runnable
            public void run() {
                fx.this.b();
            }
        });
    }

    public JSONObject pn() {
        try {
            int i = this.u.nr().get();
            JSONArray jSONArrayOptJSONArray = this.iz.optJSONArray(this.n);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("jump_number", -1);
                if (iOptInt != -1 && iOptInt == i) {
                    return jSONObject;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(JSONObject jSONObject, String str, jk jkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public boolean u(WebView webView) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public boolean u(jk jkVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u() {
        try {
            this.iz.putOpt(ReportItem.RequestKeyRequestId, this.fx);
            this.iz.put(this.n, new JSONArray());
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(String str) {
        int i = this.u.nr().get();
        JSONArray jSONArrayOptJSONArray = this.iz.optJSONArray(this.n);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.iz.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void u(com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, u.InterfaceC0310u interfaceC0310u) {
        Uri uriU = nrVar.u();
        if (uriU != null) {
            try {
                String string = uriU.toString();
                String lowerCase = "unknown";
                if (jkVar != null && jkVar.nr() != null) {
                    lowerCase = jkVar.nr().trim().toLowerCase();
                }
                JSONObject jSONObjectPn = pn();
                if (jSONObjectPn != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectPn.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectPn.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    k.nr("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                k.u("weblp", "error", e);
            }
        }
        interfaceC0310u.u(false, null);
    }

    @Override // com.bytedance.sdk.openadsdk.l.u.u
    public void nr(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map) {
    }
}
