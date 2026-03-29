package com.lantern.auth.stub;

import android.content.Context;
import android.content.Intent;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.core.BLLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSDKResp {
    public static String mno = "";
    public static String token = "";
    public String mData;
    public int mRetCode;
    public String mRetMsg;
    public String mWhat;

    public WkSDKResp(String str) {
        this.mWhat = str;
    }

    public static WkSDKResp decode(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            if (intent.hasExtra("what")) {
                WkSDKResp wkSDKResp = new WkSDKResp(intent.getStringExtra("what"));
                wkSDKResp.mRetCode = intent.getIntExtra("retcode", -1);
                wkSDKResp.mRetMsg = intent.getStringExtra("retmsg");
                String stringExtra = intent.getStringExtra("data");
                wkSDKResp.mData = stringExtra;
                if (stringExtra == null || stringExtra.length() < 10 || wkSDKResp.mData.equals(token)) {
                    return wkSDKResp;
                }
                FunDC.onEvent(FunDC.AUTH_OK);
                token = wkSDKResp.mData;
                return wkSDKResp;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean send(Context context, String str, WkSDKResp wkSDKResp) {
        if (context == null) {
            BLLog.e("Context is null");
            return false;
        }
        if (str == null) {
            BLLog.e("pkg is null");
            return false;
        }
        if (wkSDKResp == null || !wkSDKResp.isValid()) {
            BLLog.e("resp is invalid");
            return false;
        }
        Intent intent = new Intent(WkSDKFeature.RESP_ACTION);
        intent.setPackage(str);
        intent.putExtra("what", wkSDKResp.mWhat);
        intent.putExtra("retcode", wkSDKResp.mRetCode);
        String str2 = wkSDKResp.mRetMsg;
        if (str2 != null) {
            intent.putExtra("retmsg", str2);
        }
        String str3 = wkSDKResp.mData;
        if (str3 != null) {
            intent.putExtra("data", str3);
        }
        try {
            intent.addFlags(268435456).addFlags(134217728);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            BLLog.e(e);
            return false;
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
            jSONObject.put("retcode", this.mRetCode);
            jSONObject.put("retmsg", this.mRetMsg);
            jSONObject.put("data", this.mData);
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
