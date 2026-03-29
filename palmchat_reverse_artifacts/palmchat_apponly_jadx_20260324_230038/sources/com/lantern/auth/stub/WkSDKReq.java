package com.lantern.auth.stub;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.core.BLLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSDKReq {
    public String mAppId;
    public String mPackageName;
    public String mParams;
    public String mWhat;

    public WkSDKReq(String str) {
        this.mWhat = str;
    }

    public static WkSDKReq decode(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            if (intent.hasExtra("what")) {
                WkSDKReq wkSDKReq = new WkSDKReq(intent.getStringExtra("what"));
                wkSDKReq.mAppId = intent.getStringExtra("appid");
                wkSDKReq.mPackageName = intent.getStringExtra("pkg");
                wkSDKReq.mParams = intent.getStringExtra(RemoteMessageConst.MessageBody.PARAM);
                return wkSDKReq;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean send(Context context, String str, WkSDKReq wkSDKReq, boolean z) {
        if (context == null) {
            BLLog.e("Context is null");
            return false;
        }
        if (str == null) {
            BLLog.e("pkg is null");
            return false;
        }
        if (wkSDKReq == null || !wkSDKReq.isValid()) {
            BLLog.e("resp is invalid");
            return false;
        }
        Intent intent = new Intent(WkSDKFeature.REQ_ACTION);
        intent.setPackage(str);
        intent.putExtra("what", wkSDKReq.mWhat);
        intent.putExtra("appid", wkSDKReq.mAppId);
        intent.putExtra("pkg", wkSDKReq.mPackageName);
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, wkSDKReq.mParams);
        try {
            if (!z) {
                context.startService(intent);
                return true;
            }
            context.startActivity(intent);
            FunDC.onEvent(FunDC.AUTH_REQ_SUC);
            return true;
        } catch (Exception e) {
            FunDC.onEvent(FunDC.AUTH_REQ_FAIL);
            BLLog.e(e);
            return false;
        }
    }

    public static boolean sendChina(Context context, WkSDKReq wkSDKReq) {
        return send(context, "com.snda.wifilocating", wkSDKReq, true);
    }

    public String getScope() {
        try {
            return new JSONObject(this.mParams).optString("scope", "BASE");
        } catch (Exception unused) {
            return "BASE";
        }
    }

    public boolean isValid() {
        String str = this.mWhat;
        return str != null && str.length() > 0;
    }

    public String toJSON() {
        return toJSONObject().toString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("what", this.mWhat);
            jSONObject.put("appid", this.mAppId);
            jSONObject.put("pkg", this.mPackageName);
            jSONObject.put(RemoteMessageConst.MessageBody.PARAM, this.mParams);
            return jSONObject;
        } catch (JSONException e) {
            BLLog.e(e);
            return new JSONObject();
        }
    }

    public String toString() {
        return toJSON();
    }
}
