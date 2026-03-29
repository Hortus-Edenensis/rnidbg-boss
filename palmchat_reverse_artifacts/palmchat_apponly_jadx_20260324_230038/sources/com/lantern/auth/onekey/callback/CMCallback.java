package com.lantern.auth.onekey.callback;

import android.text.TextUtils;
import com.cmic.sso.sdk.auth.TokenListener;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import defpackage.b05;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CMCallback extends OneKeyCallback implements TokenListener {
    public CMCallback(boolean z, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        super(z, bLCallback, oneKeyReportInfo);
    }

    @Override // com.cmic.sso.sdk.auth.TokenListener
    public void onGetTokenComplete(JSONObject jSONObject) {
        b05.d("CMCallback onGetTokenComplete " + jSONObject);
        if (this.isPreLogin) {
            AuthReport.doOnekeyEvent(this.reportInfo, 6, jSONObject + "");
        }
        PreLoginResult preLoginResult = new PreLoginResult();
        if (jSONObject != null) {
            preLoginResult.mMsg = jSONObject.optString("resultDesc");
            if ("103000".equals(jSONObject.optString("resultCode"))) {
                if (this.isPreLogin) {
                    String strOptString = jSONObject.optString("securityphone");
                    preLoginResult.mRetCode = 1;
                    preLoginResult.mLoginType = 1;
                    preLoginResult.mMaskPhone = strOptString;
                    preLoginResult.mFromSource = this.reportInfo.mScene;
                    this.callback.run(1, jSONObject + "", preLoginResult);
                    return;
                }
                preLoginResult.mLoginType = 1;
                preLoginResult.mRetCode = 1;
                preLoginResult.mCTS = System.currentTimeMillis();
                preLoginResult.mExpires = 1800000L;
                preLoginResult.mAccessToken = jSONObject.optString("token");
                preLoginResult.mFromSource = this.reportInfo.mScene;
                this.callback.run(1, jSONObject + "", preLoginResult);
                return;
            }
            if (TextUtils.isEmpty(preLoginResult.mMsg)) {
                preLoginResult.mMsg = jSONObject.optString("resultCode");
            }
        }
        preLoginResult.mRetCode = 0;
        preLoginResult.mLoginType = 1;
        preLoginResult.mFromSource = this.reportInfo.mScene;
        this.callback.run(0, jSONObject + "", preLoginResult);
    }
}
