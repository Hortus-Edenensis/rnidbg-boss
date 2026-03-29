package com.lantern.auth.onekey.callback;

import cn.com.chinatelecom.account.api.ResultListener;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.onekey.OneKeyLoginManager;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import com.wifi.ad.core.config.EventParams;
import defpackage.b05;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CTCallback extends OneKeyCallback implements ResultListener {
    public CTCallback(boolean z, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        super(z, bLCallback, oneKeyReportInfo);
    }

    @Override // cn.com.chinatelecom.account.api.ResultListener
    public void onResult(String str) {
        b05.d("CTCallback onResult " + str);
        if (this.isPreLogin) {
            AuthReport.doOnekeyEvent(this.reportInfo, 6, str);
        }
        PreLoginResult preLoginResult = new PreLoginResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("result");
            preLoginResult.mMsg = jSONObject.optString("msg");
            if ("0".equals(strOptString)) {
                b05.d("电信取号成功");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                String strOptString2 = jSONObjectOptJSONObject.optString("accessCode");
                String strOptString3 = jSONObjectOptJSONObject.optString(EventParams.KEY_PARAM_NUMBER);
                long jOptLong = jSONObjectOptJSONObject.optLong("expiredTime");
                String strOptString4 = jSONObjectOptJSONObject.optString("gwAuth");
                preLoginResult.mRetCode = 1;
                preLoginResult.mAccessToken = strOptString2;
                preLoginResult.mMaskPhone = strOptString3;
                preLoginResult.mExpires = jOptLong * 1000;
                preLoginResult.mUniqueId = strOptString4;
                preLoginResult.mLoginType = 8;
                preLoginResult.mFromSource = this.reportInfo.mScene;
                preLoginResult.mCTS = System.currentTimeMillis();
                this.callback.run(1, str, preLoginResult);
                return;
            }
        } catch (JSONException e) {
            BLLog.e(e);
        }
        preLoginResult.mRetCode = 0;
        preLoginResult.mLoginType = 8;
        preLoginResult.mFromSource = this.reportInfo.mScene;
        if (!this.isPreLogin) {
            this.callback.run(0, str, preLoginResult);
            return;
        }
        b05.d("电信取号失败========》跳转mob登陆");
        AuthReport.doOnekeyEvent(this.reportInfo, 25);
        OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
        oneKeyReportInfo.mLoginType = 16;
        OneKeyReportInfo oneKeyReportInfo2 = this.reportInfo;
        oneKeyReportInfo.mScene = oneKeyReportInfo2.mScene;
        oneKeyReportInfo.mSid = oneKeyReportInfo2.mSid;
        oneKeyReportInfo.isRetry = true;
        OneKeyLoginManager.preLogin(this.callback, oneKeyReportInfo);
    }
}
