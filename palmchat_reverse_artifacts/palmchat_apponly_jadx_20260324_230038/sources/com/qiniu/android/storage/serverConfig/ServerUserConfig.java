package com.qiniu.android.storage.serverConfig;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ServerUserConfig {
    private Boolean http3Enable;
    private JSONObject info;
    private Boolean networkCheckEnable;
    private long timestamp;
    private long ttl;

    public ServerUserConfig(JSONObject jSONObject) {
        this.ttl = 10L;
        if (jSONObject == null) {
            return;
        }
        this.info = jSONObject;
        this.ttl = jSONObject.optLong(RemoteMessageConst.TTL, 300L);
        if (jSONObject.opt("timestamp") != null) {
            this.timestamp = jSONObject.optLong("timestamp");
        }
        if (this.timestamp == 0) {
            long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
            this.timestamp = jCurrentSecondTimestamp;
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(jCurrentSecondTimestamp));
            } catch (JSONException unused) {
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("http3");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.opt("enabled") != null) {
            this.http3Enable = Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("enabled"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("network_check");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.opt("enabled") == null) {
            return;
        }
        this.networkCheckEnable = Boolean.valueOf(jSONObjectOptJSONObject2.optBoolean("enabled"));
    }

    public Boolean getHttp3Enable() {
        return this.http3Enable;
    }

    public JSONObject getInfo() {
        return this.info;
    }

    public Boolean getNetworkCheckEnable() {
        return this.networkCheckEnable;
    }

    public boolean isValid() {
        return Utils.currentSecondTimestamp() < this.timestamp + this.ttl;
    }
}
