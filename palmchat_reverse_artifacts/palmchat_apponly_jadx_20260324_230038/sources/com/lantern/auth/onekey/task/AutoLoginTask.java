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
import com.lantern.auth.onekey.helper.OneKeyHelper;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.openapi.LoginResult;
import com.lantern.auth.pb.PBResponse;
import com.lantern.auth.pb.pb_client.LSAutoLoginReqOuterClass;
import com.lantern.auth.pb.pb_client.LSAutoLoginRespOuterClass;
import com.lantern.auth.pb.util.PbUtils;
import com.lantern.auth.util.NormalUtils;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AutoLoginTask extends AsyncTask<String, Void, LoginResult> {
    private BLCallback callback;
    private OneKeyHelper helper;
    private PreLoginResult preLoginResult;
    private OneKeyReportInfo reportInfo;

    public AutoLoginTask(BLCallback bLCallback, OneKeyHelper oneKeyHelper, PreLoginResult preLoginResult, OneKeyReportInfo oneKeyReportInfo) {
        this.callback = bLCallback;
        this.helper = oneKeyHelper;
        this.preLoginResult = preLoginResult;
        this.reportInfo = oneKeyReportInfo;
    }

    private boolean canCellularRetry(int i) {
        return i == 10 && "wg".equals(NormalUtils.getNetworkType(WkSDKManager.getContext()));
    }

    public static void doErrEvent(Exception exc, String str, String str2) {
        HashMap<String, String> mapGenExt = FunDC.genExt(null, null);
        mapGenExt.put("url", str);
        mapGenExt.put("pid", str2);
        mapGenExt.put("ErrName", exc.getClass().getName());
        mapGenExt.put("ErrMsg", exc.getMessage());
        FunDC.onEvent("pb_err", mapGenExt);
    }

    private byte[] getBussiByte(String str) {
        PreLoginResult preLoginResult = this.preLoginResult;
        if (preLoginResult == null || !preLoginResult.isValid()) {
            AuthReport.doOnekeyEvent(this.reportInfo, 11);
            final PreLoginResult[] preLoginResultArr = new PreLoginResult[1];
            final OneKeyReportInfo oneKeyReportInfo = this.reportInfo;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final PreLoginResult preLoginResult2 = this.preLoginResult;
            this.helper.retryAccessToken(new BLCallback() { // from class: com.lantern.auth.onekey.task.AutoLoginTask.1
                @Override // com.lantern.auth.core.BLCallback
                public void run(int i, String str2, Object obj) {
                    AuthReport.doOnekeyEvent(oneKeyReportInfo, 23, str2);
                    if (obj instanceof PreLoginResult) {
                        PreLoginResult preLoginResult3 = (PreLoginResult) obj;
                        preLoginResultArr[0] = preLoginResult3;
                        if (TextUtils.isEmpty(preLoginResult3.mMaskPhone)) {
                            preLoginResultArr[0].mMaskPhone = preLoginResult2.mMaskPhone;
                        }
                    }
                    countDownLatch.countDown();
                }
            }, this.reportInfo);
            try {
                countDownLatch.await(WkSDKManager.getSdkConfig().getCMCCTimeout(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                BLLog.e(e);
            }
            PreLoginResult preLoginResult3 = preLoginResultArr[0];
            if (preLoginResult3 == null) {
                AuthReport.doOnekeyEvent(this.reportInfo, 15);
                return null;
            }
            this.preLoginResult = preLoginResult3;
            if (preLoginResult3.mRetCode != 1) {
                AuthReport.doOnekeyEvent(this.reportInfo, 14);
                return null;
            }
            AuthReport.doOnekeyEvent(this.reportInfo, 13);
        } else {
            AuthReport.doOnekeyEvent(this.reportInfo, 12);
        }
        return getReqMdoel(str).build().toByteArray();
    }

    private LSAutoLoginReqOuterClass.LSAutoLoginReq.Builder getReqMdoel(String str) {
        LSAutoLoginReqOuterClass.LSAutoLoginReq.Builder builderNewBuilder = LSAutoLoginReqOuterClass.LSAutoLoginReq.newBuilder();
        if (TextUtils.equals(OneKeyHelper.MOVETYPE_TELECOM, this.helper.getMoveType())) {
            builderNewBuilder.setUniqueId(this.preLoginResult.mUniqueId);
        } else if (TextUtils.equals(OneKeyHelper.MOVETYPE_MOB, this.helper.getMoveType())) {
            builderNewBuilder.setToken(this.preLoginResult.mobToken);
            builderNewBuilder.setOperator(this.preLoginResult.operator);
        }
        builderNewBuilder.setClientId(this.helper.getClientIdByType());
        builderNewBuilder.setMoveType(this.helper.getMoveType());
        builderNewBuilder.setAccessToken(this.preLoginResult.mAccessToken);
        builderNewBuilder.setMaskMobile(this.preLoginResult.mMaskPhone);
        builderNewBuilder.setDeviceId(WkSDKManager.getDeviceId());
        builderNewBuilder.setScope(str);
        builderNewBuilder.setThirdAppId(WkSDKManager.getAppId());
        builderNewBuilder.setSimId(BLPlatform.getSimSerialNumber(WkSDKManager.getContext()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fromSource", this.preLoginResult.mFromSource);
        } catch (JSONException e) {
            BLLog.e(e);
        }
        String string = jSONObject.toString();
        if (string != null) {
            builderNewBuilder.setExt(string);
        }
        return builderNewBuilder;
    }

    private LoginResult handleResponse(byte[] bArr) {
        LoginResult loginResult = new LoginResult();
        loginResult.mLocalType = this.reportInfo.mLoginType;
        String code = null;
        if (bArr != null) {
            PBResponse response = PbUtils.getResponse(bArr);
            if (response != null) {
                if (!response.isSuccess() || response.getServerData() == null) {
                    loginResult.mMsg = response.getRetmsg();
                } else {
                    try {
                        LSAutoLoginRespOuterClass.LSAutoLoginResp from = LSAutoLoginRespOuterClass.LSAutoLoginResp.parseFrom(response.getServerData());
                        if ("0".equals(from.getCode())) {
                            loginResult.mAuthCode = from.getOauthCode();
                            loginResult.mRemoteType = from.getType();
                            loginResult.mRetCode = 1;
                        } else {
                            loginResult.mRetCode = 0;
                        }
                        code = from.getCode();
                        loginResult.mServerRetCd = code;
                        loginResult.mMsg = from.getMsg();
                    } catch (InvalidProtocolBufferException e) {
                        BLLog.e(e);
                    }
                }
                if (code == null) {
                    code = loginResult.mMsg;
                }
            }
        } else {
            loginResult.mMsg = ResTool.getString("wk_network_err", WkSDKManager.getContext());
        }
        if (loginResult.mRetCode != 1) {
            AuthReport.doOnekeyEvent(this.reportInfo, 24, code);
        }
        return loginResult;
    }

    public static void startTask(BLCallback bLCallback, OneKeyHelper oneKeyHelper, PreLoginResult preLoginResult, OneKeyReportInfo oneKeyReportInfo, String str) {
        new AutoLoginTask(bLCallback, oneKeyHelper, preLoginResult, oneKeyReportInfo).executeOnExecutor(HttpPostManager.getExecutorPool(), str);
    }

    @Override // android.os.AsyncTask
    public LoginResult doInBackground(String... strArr) {
        String str = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (TextUtils.isEmpty(str)) {
            str = "BASE";
        }
        AuthReport.doOnekeyEvent(this.reportInfo, 10);
        String pbOpenSSOUrl = WkConstants.ServerConsts.getPbOpenSSOUrl();
        try {
            byte[] request = PbUtils.getRequest("05000525", getBussiByte(str));
            BLHttp bLHttp = new BLHttp(pbOpenSSOUrl);
            bLHttp.setHeader("Content-Type", "application/octet-stream");
            bLHttp.setTimeout(3000, 3000);
            LoginResult loginResultHandleResponse = handleResponse(bLHttp.post(request));
            if (loginResultHandleResponse.mRetCode == 1) {
                AuthReport.doOnekeyEvent(this.reportInfo, 16);
                return loginResultHandleResponse;
            }
            AuthReport.doOnekeyEvent(this.reportInfo, 17);
            if (canCellularRetry(loginResultHandleResponse.mRetCode)) {
                AuthReport.doOnekeyEvent(this.reportInfo, 18);
                loginResultHandleResponse = handleResponse(bLHttp.post(request));
                if (loginResultHandleResponse.mRetCode == 1) {
                    AuthReport.doOnekeyEvent(this.reportInfo, 19);
                } else {
                    AuthReport.doOnekeyEvent(this.reportInfo, 20);
                }
            }
            return loginResultHandleResponse;
        } catch (Exception e) {
            BLLog.e(e);
            doErrEvent(e, pbOpenSSOUrl, "05000525");
            if (e instanceof UnknownHostException) {
                LoginResult loginResult = new LoginResult();
                loginResult.mRetCode = 50;
                loginResult.mMsg = "请升级至最新版本";
                loginResult.mLocalType = this.preLoginResult.mLoginType;
                return loginResult;
            }
            LoginResult loginResult2 = new LoginResult();
            loginResult2.mRetCode = 10;
            loginResult2.mMsg = ResTool.getString("wk_network_err", WkSDKManager.getContext());
            PreLoginResult preLoginResult = this.preLoginResult;
            if (preLoginResult != null && preLoginResult.mRetCode != 1 && !TextUtils.isEmpty(preLoginResult.mMsg)) {
                loginResult2.mMsg = this.preLoginResult.mMsg;
            }
            loginResult2.mLocalType = this.preLoginResult.mLoginType;
            return loginResult2;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(LoginResult loginResult) {
        if (loginResult.mRetCode == 1) {
            OneKeyReportInfo oneKeyReportInfo = this.reportInfo;
            oneKeyReportInfo.mRemoteType = loginResult.mRemoteType;
            AuthReport.doOnekeyEvent(oneKeyReportInfo, 21);
        } else {
            AuthReport.doOnekeyEvent(this.reportInfo, 22);
        }
        this.callback.run(loginResult.mRetCode, null, loginResult);
        this.callback = null;
        this.preLoginResult = null;
        this.helper = null;
    }
}
