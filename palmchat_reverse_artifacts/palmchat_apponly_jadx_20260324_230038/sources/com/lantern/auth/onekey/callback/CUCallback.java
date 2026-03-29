package com.lantern.auth.onekey.callback;

import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.onekey.OneKeyLoginManager;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import com.umeng.analytics.pro.bd;
import com.unicom.online.account.shield.ResultListener;
import defpackage.b05;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CUCallback extends OneKeyCallback implements ResultListener {
    public CUCallback(boolean z, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        super(z, bLCallback, oneKeyReportInfo);
    }

    @Override // com.unicom.online.account.shield.ResultListener
    public void onResult(String str) {
        b05.d("CUCallback onResult " + str);
        if (this.isPreLogin) {
            AuthReport.doOnekeyEvent(this.reportInfo, 6, str);
        }
        PreLoginResult preLoginResult = new PreLoginResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("resultCode");
            preLoginResult.mMsg = jSONObject.optString("resultMsg");
            if ("100".equals(strOptString)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("resultData");
                String strOptString2 = jSONObjectOptJSONObject.optString("accessCode");
                String strOptString3 = jSONObjectOptJSONObject.optString("fakeMobile");
                long jOptLong = jSONObjectOptJSONObject.optLong(bd.b);
                jSONObjectOptJSONObject.optString("operator");
                preLoginResult.mRetCode = 1;
                preLoginResult.mAccessToken = strOptString2;
                preLoginResult.mMaskPhone = strOptString3;
                preLoginResult.mExpires = jOptLong * 1000;
                preLoginResult.mLoginType = 4;
                preLoginResult.mFromSource = this.reportInfo.mScene;
                preLoginResult.mCTS = System.currentTimeMillis();
                this.callback.run(1, str, preLoginResult);
                return;
            }
        } catch (Exception e) {
            BLLog.e(e);
        }
        preLoginResult.mRetCode = 0;
        preLoginResult.mLoginType = 4;
        OneKeyReportInfo oneKeyReportInfo = this.reportInfo;
        preLoginResult.mFromSource = oneKeyReportInfo.mScene;
        if (!this.isPreLogin) {
            this.callback.run(0, str, preLoginResult);
            return;
        }
        AuthReport.doOnekeyEvent(oneKeyReportInfo, 25);
        OneKeyReportInfo oneKeyReportInfo2 = new OneKeyReportInfo();
        oneKeyReportInfo2.mLoginType = 1;
        OneKeyReportInfo oneKeyReportInfo3 = this.reportInfo;
        oneKeyReportInfo2.mScene = oneKeyReportInfo3.mScene;
        oneKeyReportInfo2.mSid = oneKeyReportInfo3.mSid;
        oneKeyReportInfo2.isRetry = true;
        OneKeyLoginManager.preLogin(this.callback, oneKeyReportInfo2);
    }
}
