package com.lantern.auth.app;

import android.text.TextUtils;
import com.lantern.auth.android.BLPlatform;
import com.lantern.auth.android.ResTool;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.http.PBPostTask;
import com.lantern.auth.onekey.task.PhoneNumLoginTask;
import com.lantern.auth.openapi.LoginInfo;
import com.lantern.auth.openapi.LoginResult;
import com.lantern.auth.openapi.SMSInfo;
import com.lantern.auth.pb.PBRequestBean;
import com.lantern.auth.pb.PBResponse;
import com.lantern.auth.pb.pb_client.RegisterRequestBeanOuterClass;
import com.lantern.auth.pb.pb_client.RegisterResponseModelOuterClass;
import com.lantern.auth.server.WkParams;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SMSLoginHelper {
    private static JSONObject getResultObj(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WkParams.RETCD, str);
            jSONObject.put(WkParams.RETMSG, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void getSMSCode(SMSInfo sMSInfo, BLCallback bLCallback) {
        if (sMSInfo != null && !TextUtils.isEmpty(sMSInfo.countryCode) && !TextUtils.isEmpty(sMSInfo.phoneNum)) {
            PhoneNumLoginTask.getSMS(sMSInfo, bLCallback);
            return;
        }
        String string = ResTool.getString("wk_empty_phone_country", WkSDKManager.getContext());
        LoginResult loginResult = new LoginResult();
        loginResult.mMsg = string;
        loginResult.mLocalType = 32;
        loginResult.mRetCode = 0;
        bLCallback.run(0, string, loginResult);
    }

    private static String makeExt(SMSInfo sMSInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(WkSDKManager.getDeviceId())) {
                jSONObject.put("deviceId", WkSDKManager.getDeviceId());
            }
            if (!TextUtils.isEmpty(sMSInfo.ext)) {
                jSONObject.put("ext", sMSInfo.ext);
            }
            jSONObject.put("srcReq", "sdk_sms_pb");
            jSONObject.put("fromSource", "sdk_pb");
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void postCode(LoginInfo loginInfo, final BLCallback bLCallback) {
        String string = (loginInfo == null || TextUtils.isEmpty(loginInfo.countryCode) || TextUtils.isEmpty(loginInfo.phoneNum)) ? ResTool.getString("wk_empty_phone_country", WkSDKManager.getContext()) : null;
        if (TextUtils.isEmpty(loginInfo.smsCode)) {
            string = ResTool.getString("wk_empty_code", WkSDKManager.getContext());
        }
        if (TextUtils.isEmpty(loginInfo.scope)) {
            string = ResTool.getString("wk_empty_scope", WkSDKManager.getContext());
        }
        if (!TextUtils.isEmpty(string)) {
            LoginResult loginResult = new LoginResult();
            loginResult.mMsg = string;
            loginResult.mLocalType = 32;
            loginResult.mRetCode = 0;
            bLCallback.run(0, string, loginResult);
            return;
        }
        RegisterRequestBeanOuterClass.RegisterRequestBean.Builder builderNewBuilder = RegisterRequestBeanOuterClass.RegisterRequestBean.newBuilder();
        builderNewBuilder.setFromSource("sdk_pb");
        builderNewBuilder.setCountryCode(loginInfo.countryCode);
        builderNewBuilder.setMobile(loginInfo.phoneNum);
        builderNewBuilder.setScope(loginInfo.scope);
        builderNewBuilder.setSmsCode(loginInfo.smsCode);
        builderNewBuilder.setThirdAppId(WkSDKManager.getAppId());
        builderNewBuilder.setExt(makeExt(loginInfo));
        builderNewBuilder.setDeviceId(WkSDKManager.getDeviceId());
        builderNewBuilder.setSimId(BLPlatform.getSimSerialNumber(WkSDKManager.getContext()));
        PBPostTask.doPostPB(new PBRequestBean(new BLCallback() { // from class: com.lantern.auth.app.SMSLoginHelper.1
            @Override // com.lantern.auth.core.BLCallback
            public void run(int i, String str, Object obj) {
                String oauthCode;
                String code;
                RegisterResponseModelOuterClass.RegisterResponseModel from;
                int i2 = 0;
                if (i == 1) {
                    try {
                        from = RegisterResponseModelOuterClass.RegisterResponseModel.parseFrom(((PBResponse) obj).getServerData());
                        str = from.getMsg();
                        code = from.getCode();
                    } catch (Exception e) {
                        e = e;
                        code = "";
                    }
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                    if (from.getCode().equals("0")) {
                        oauthCode = from.getOauthCode();
                        i2 = 1;
                    } else {
                        oauthCode = "";
                    }
                } else {
                    if (obj == null) {
                        str = ResTool.getString("wk_network_err", WkSDKManager.getContext());
                        i2 = 10;
                    }
                    oauthCode = "";
                    code = oauthCode;
                }
                HashMap<String, String> mapGenExt = FunDC.genExt("code", i2 + "");
                mapGenExt.put("msg", str);
                LoginResult loginResult2 = new LoginResult();
                loginResult2.mRetCode = i2;
                loginResult2.mMsg = str;
                loginResult2.mLocalType = 32;
                loginResult2.mAuthCode = oauthCode;
                loginResult2.mServerRetCd = code;
                FunDC.onEventById(FunDC.ID_AUTH_1075, mapGenExt);
                bLCallback.run(i2, str, loginResult2);
            }
        }, "00200418", builderNewBuilder.build().toByteArray(), WkConstants.ServerConsts.getPbUrl()));
    }
}
