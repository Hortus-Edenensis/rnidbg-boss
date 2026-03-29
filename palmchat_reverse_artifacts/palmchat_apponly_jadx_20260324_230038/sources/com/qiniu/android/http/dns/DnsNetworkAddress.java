package com.qiniu.android.http.dns;

import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.utils.Utils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class DnsNetworkAddress implements IDnsNetworkAddress, Serializable {
    private final String hostValue;
    private final String ipValue;
    private final String sourceValue;
    private final Long timestampValue;
    private final Long ttlValue;

    public DnsNetworkAddress(String str, String str2, Long l, String str3, Long l2) {
        this.hostValue = str;
        this.ipValue = str2;
        this.ttlValue = l;
        this.sourceValue = str3;
        this.timestampValue = l2;
    }

    public static DnsNetworkAddress address(JSONObject jSONObject) throws JSONException {
        String string;
        String string2;
        Long lValueOf;
        Long lValueOf2;
        String string3 = null;
        try {
            string = jSONObject.getString("hostValue");
        } catch (JSONException unused) {
            string = null;
        }
        try {
            string2 = jSONObject.getString("ipValue");
        } catch (JSONException unused2) {
            string2 = null;
        }
        try {
            lValueOf = Long.valueOf(jSONObject.getLong("ttlValue"));
        } catch (JSONException unused3) {
            lValueOf = null;
        }
        try {
            lValueOf2 = Long.valueOf(jSONObject.getLong("timestampValue"));
        } catch (JSONException unused4) {
            lValueOf2 = null;
        }
        try {
            string3 = jSONObject.getString("sourceValue");
        } catch (JSONException unused5) {
        }
        return new DnsNetworkAddress(string, string2, lValueOf, string3, lValueOf2);
    }

    @Override // com.qiniu.android.http.dns.IDnsNetworkAddress
    public String getHostValue() {
        return this.hostValue;
    }

    @Override // com.qiniu.android.http.dns.IDnsNetworkAddress
    public String getIpValue() {
        return this.ipValue;
    }

    @Override // com.qiniu.android.http.dns.IDnsNetworkAddress
    public String getSourceValue() {
        return this.sourceValue;
    }

    @Override // com.qiniu.android.http.dns.IDnsNetworkAddress
    public Long getTimestampValue() {
        return this.timestampValue;
    }

    @Override // com.qiniu.android.http.dns.IDnsNetworkAddress
    public Long getTtlValue() {
        return this.ttlValue;
    }

    public boolean isValid() {
        String str;
        if (this.timestampValue == null || (str = this.ipValue) == null || str.length() == 0) {
            return false;
        }
        return Utils.currentTimestamp() / 1000 < this.timestampValue.longValue() + ((long) GlobalConfiguration.getInstance().dnsCacheMaxTTL);
    }

    public boolean needRefresh() {
        String str;
        if (this.timestampValue == null || this.ttlValue == null || (str = this.ipValue) == null || str.length() == 0) {
            return false;
        }
        return Utils.currentTimestamp() / 1000 > this.timestampValue.longValue() + ((long) this.ttlValue.intValue());
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hostValue", this.hostValue);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("ipValue", this.ipValue);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("ttlValue", this.ttlValue);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject.put("timestampValue", this.timestampValue);
        } catch (JSONException unused4) {
        }
        try {
            jSONObject.put("sourceValue", this.sourceValue);
        } catch (JSONException unused5) {
        }
        return jSONObject;
    }
}
