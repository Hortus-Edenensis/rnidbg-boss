package com.lantern.auth.onekey.task;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.auth.android.BLPlatform;
import com.lantern.auth.android.ResTool;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLHttp;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpPostManager;
import com.lantern.auth.openapi.LoginResult;
import com.lantern.auth.openapi.SMSInfo;
import com.lantern.auth.pb.PBResponse;
import com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass;
import com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass;
import com.lantern.auth.pb.util.PbUtils;
import com.lantern.auth.server.WkParams;
import java.net.UnknownHostException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PhoneNumLoginTask extends AsyncTask<Object, Void, LoginResult> {
    private BLCallback callback;

    public PhoneNumLoginTask(BLCallback bLCallback) {
        this.callback = bLCallback;
    }

    private byte[] getBussiByte(SMSInfo sMSInfo) {
        return getReqMdoel(sMSInfo).build().toByteArray();
    }

    private LSAutoLoginReqOuterClass.LSAutoLoginReq.Builder getReqMdoel(SMSInfo sMSInfo) {
        LSAutoLoginReqOuterClass.LSAutoLoginReq.Builder builderNewBuilder = LSAutoLoginReqOuterClass.LSAutoLoginReq.newBuilder();
        builderNewBuilder.setDeviceId(WkSDKManager.getDeviceId());
        builderNewBuilder.setScope(sMSInfo.scope);
        builderNewBuilder.setThirdAppId(WkSDKManager.getAppId());
        builderNewBuilder.setSimId(BLPlatform.getSimSerialNumber(WkSDKManager.getContext()));
        builderNewBuilder.setMaskMobile(sMSInfo.phoneNum);
        builderNewBuilder.setCountryCode(sMSInfo.countryCode);
        if (sMSInfo.ext != null) {
            builderNewBuilder.setExt(makeExt(sMSInfo));
        }
        return builderNewBuilder;
    }

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

    public static void getSMS(SMSInfo sMSInfo, BLCallback bLCallback) {
        new PhoneNumLoginTask(bLCallback).executeOnExecutor(HttpPostManager.getExecutorPool(), sMSInfo);
    }

    private LoginResult handleResponse(byte[] bArr, LoginResult loginResult) {
        String code;
        if (bArr != null) {
            PBResponse response = PbUtils.getResponse(bArr);
            if (response != null) {
                if (response.isSuccess() && response.getServerData() != null) {
                    try {
                        LSAutoLoginRespOuterClass.LSAutoLoginResp from = LSAutoLoginRespOuterClass.LSAutoLoginResp.parseFrom(response.getServerData());
                        loginResult.mMsg = from.getMsg();
                        code = from.getCode();
                        try {
                            if ("0".equals(code)) {
                                loginResult.mAuthCode = from.getOauthCode();
                                loginResult.mRemoteType = from.getType();
                                loginResult.mRetCode = 1;
                            } else if ("1".equals(code)) {
                                loginResult.mRetCode = 1;
                                if (TextUtils.isEmpty(loginResult.mMsg)) {
                                    loginResult.mMsg = ResTool.getString("wk_sms_send_success", WkSDKManager.getContext());
                                }
                            } else {
                                loginResult.mRetCode = 0;
                            }
                            loginResult.mServerRetCd = code;
                        } catch (InvalidProtocolBufferException e) {
                            e = e;
                            BLLog.e(e);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        e = e2;
                        code = "";
                    }
                }
                HashMap<String, String> mapGenExt = FunDC.genExt("code", loginResult.mRetCode + "");
                mapGenExt.put(WkParams.RETCD, code);
                mapGenExt.put("msg", loginResult.mMsg);
                FunDC.onEventById(FunDC.ID_AUTH_1073, mapGenExt);
                return loginResult;
            }
            loginResult.mMsg = response.getRetmsg();
        } else {
            loginResult.mMsg = ResTool.getString("wk_network_err", WkSDKManager.getContext());
        }
        code = "";
        HashMap<String, String> mapGenExt2 = FunDC.genExt("code", loginResult.mRetCode + "");
        mapGenExt2.put(WkParams.RETCD, code);
        mapGenExt2.put("msg", loginResult.mMsg);
        FunDC.onEventById(FunDC.ID_AUTH_1073, mapGenExt2);
        return loginResult;
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
            if (!TextUtils.isEmpty(sMSInfo.typeLength)) {
                jSONObject.put("typeLength", sMSInfo.typeLength);
            }
            jSONObject.put("srcReq", "sdk_sms_pb");
            jSONObject.put("fromSource", "sdk_pb");
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public LoginResult doInBackground(Object... objArr) {
        LoginResult loginResult = new LoginResult();
        loginResult.mLocalType = 32;
        if (objArr == null || objArr.length <= 0) {
            return loginResult;
        }
        String pbOpenSSOUrl = WkConstants.ServerConsts.getPbOpenSSOUrl();
        byte[] request = PbUtils.getRequest("05000526", getBussiByte((SMSInfo) objArr[0]));
        BLHttp bLHttp = new BLHttp(pbOpenSSOUrl);
        bLHttp.setHeader("Content-Type", "application/octet-stream");
        bLHttp.setTimeout(3000, 3000);
        try {
            return handleResponse(bLHttp.post(request), loginResult);
        } catch (Exception e) {
            BLLog.e(e);
            loginResult.mMsg = ResTool.getString("wk_network_err", WkSDKManager.getContext());
            if (!(e instanceof UnknownHostException)) {
                return loginResult;
            }
            loginResult.mRetCode = 50;
            loginResult.mMsg = "请升级至新版本";
            return loginResult;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(LoginResult loginResult) {
        BLCallback bLCallback = this.callback;
        if (bLCallback != null) {
            bLCallback.run(loginResult.mRetCode, loginResult.mMsg, loginResult);
        }
        this.callback = null;
    }
}
