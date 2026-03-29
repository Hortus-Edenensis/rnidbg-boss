package com.ss.android.downloadlib.addownload.nr;

import com.ss.android.downloadlib.x.mv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    public String b;
    public long fx;
    public String iz;
    public volatile long n;
    public long nr;
    public String pn;
    public long u;
    public String x;

    public u() {
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.u);
            jSONObject.put("mAdId", this.nr);
            jSONObject.put("mExtValue", this.fx);
            jSONObject.put("mPackageName", this.b);
            jSONObject.put("mAppName", this.pn);
            jSONObject.put("mLogExtra", this.iz);
            jSONObject.put("mFileName", this.x);
            jSONObject.put("mTimeStamp", this.n);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public u(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.u = j;
        this.nr = j2;
        this.fx = j3;
        this.b = str;
        this.pn = str2;
        this.iz = str3;
        this.x = str4;
    }

    public static u u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        try {
            uVar.u = mv.u(jSONObject, "mDownloadId");
            uVar.nr = mv.u(jSONObject, "mAdId");
            uVar.fx = mv.u(jSONObject, "mExtValue");
            uVar.b = jSONObject.optString("mPackageName");
            uVar.pn = jSONObject.optString("mAppName");
            uVar.iz = jSONObject.optString("mLogExtra");
            uVar.x = jSONObject.optString("mFileName");
            uVar.n = mv.u(jSONObject, "mTimeStamp");
            return uVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
