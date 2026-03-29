package com.lantern.core.network;

import com.lantern.auth.server.WkParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NEResponse {
    private String mRetcode;
    private String mRetmsg;

    public NEResponse() {
        this(null, null);
    }

    public String getRetcode() {
        return this.mRetcode;
    }

    public String getRetmsg() {
        return this.mRetmsg;
    }

    public boolean isSeckeyExpired() {
        return "H.SEC.0100".equals(this.mRetcode);
    }

    public boolean isSeckeyInvalid() {
        return "H.SYS.0003".equals(this.mRetcode);
    }

    public boolean isSuccess() {
        return "0".equals(this.mRetcode);
    }

    public void setRetcode(String str) {
        this.mRetcode = str;
    }

    public void setRetmsg(String str) {
        this.mRetmsg = str;
    }

    public String toJSON() {
        return toJSONObject().toString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retcode", this.mRetcode);
            jSONObject.put("retmsg", this.mRetmsg);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public String toString() {
        return toJSONObject().toString();
    }

    public NEResponse(String str, String str2) {
        this.mRetcode = str == null ? "" : str;
        this.mRetmsg = str2 == null ? "" : str2;
    }

    public NEResponse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mRetcode = jSONObject.optString(WkParams.RETCD, "");
            this.mRetmsg = jSONObject.optString(WkParams.RETMSG, "");
        } else {
            this.mRetcode = "";
            this.mRetmsg = "";
        }
    }
}
