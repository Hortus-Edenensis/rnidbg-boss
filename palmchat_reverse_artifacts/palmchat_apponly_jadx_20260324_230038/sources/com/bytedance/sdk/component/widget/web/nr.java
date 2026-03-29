package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.mv.fx;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr extends u {
    private final WebViewImpl nr;
    private final com.bytedance.sdk.component.mv.u u;

    public nr(Object obj, String str, com.bytedance.sdk.component.mv.u uVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.u = uVar;
        this.nr = webViewImpl;
    }

    private boolean b(JSONObject jSONObject) {
        JSONObject jSONObjectNr = nr(jSONObject, "pushWebview");
        if (jSONObjectNr == null) {
            return false;
        }
        int iU = this.u.u(jSONObjectNr.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(iU));
            jSONObject2.putOpt("result", Boolean.valueOf(iU == 0));
        } catch (Exception unused) {
        }
        this.nr.u(nr(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean fx(JSONObject jSONObject) {
        JSONObject jSONObjectNr = nr(jSONObject, "sendWebviewEvent");
        if (jSONObjectNr == null) {
            return false;
        }
        String strOptString = jSONObjectNr.optString("event");
        if (strOptString == null) {
            return true;
        }
        this.u.u(this.nr, nr(), strOptString, jSONObjectNr.opt(RemoteMessageConst.MessageBody.PARAM));
        return true;
    }

    private boolean nr(JSONObject jSONObject) {
        JSONObject jSONObjectNr = nr(jSONObject, "removeWebviewListener");
        if (jSONObjectNr == null) {
            return false;
        }
        String strOptString = jSONObjectNr.optString("event");
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.u.nr(this.nr, strOptString);
        return true;
    }

    private boolean pn(JSONObject jSONObject) {
        if (!u(jSONObject, "popWebview")) {
            return false;
        }
        fx fxVarU = this.u.u();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(fxVarU == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(fxVarU != null));
        } catch (Exception unused) {
        }
        this.nr.u(nr(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean u(JSONObject jSONObject) {
        JSONObject jSONObjectNr = nr(jSONObject, "addWebviewListener");
        if (jSONObjectNr == null) {
            return false;
        }
        String strOptString = jSONObjectNr.optString("event");
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.u.u(this.nr, strOptString);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.u
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            if (pn(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("pushWebview")) {
            if (b(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("addWebviewListener")) {
            if (u(new JSONObject(str))) {
                return null;
            }
        } else {
            if (!str.contains("removeWebviewListener")) {
                if (str.contains("sendWebviewEvent")) {
                    if (fx(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
            if (nr(new JSONObject(str))) {
                return null;
            }
        }
        return super.invokeMethod(str);
    }

    private JSONObject nr(JSONObject jSONObject, String str) {
        if (u(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }

    private boolean u(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }
}
