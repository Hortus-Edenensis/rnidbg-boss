package com.lantern.auth.onekey.callback;

import android.text.TextUtils;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.pure.entity.PreVerifyResult;
import cn.fly.verify.pure.entity.VerifyResult;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.onekey.OneKeyLoginManager;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.openapi.WkOAuthConst;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import defpackage.b05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MobCallback<T> extends OneKeyCallback<T> {
    public MobCallback(boolean z, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        super(z, bLCallback, oneKeyReportInfo);
    }

    private void handlePre(PreVerifyResult preVerifyResult) {
        if (preVerifyResult == null) {
            makeFailException();
            return;
        }
        AuthReport.doOnekeyEvent(this.reportInfo, 6, preVerifyResult.toJson());
        PreLoginResult preLoginResult = new PreLoginResult();
        preLoginResult.mRetCode = 1;
        preLoginResult.mLoginType = 16;
        String operator = preVerifyResult.getOperator();
        preLoginResult.mLoginType = (TextUtils.equals(operator, "CMCC") ? 1 : TextUtils.equals(operator, "CUCC") ? 4 : 8) | preLoginResult.mLoginType;
        preLoginResult.mMaskPhone = preVerifyResult.getSecurityPhone();
        preLoginResult.mFromSource = this.reportInfo.mScene;
        this.callback.run(1, preVerifyResult.toJson(), preLoginResult);
    }

    private void handlerConfirm(VerifyResult verifyResult) {
        if (verifyResult == null) {
            makeFailException();
            return;
        }
        BLLog.d("MOB handlerConfirm " + verifyResult.toJson(), new Object[0]);
        PreLoginResult preLoginResult = new PreLoginResult();
        preLoginResult.mRetCode = 1;
        preLoginResult.mAccessToken = verifyResult.getOpToken();
        preLoginResult.mobToken = verifyResult.getToken();
        String operator = verifyResult.getOperator();
        preLoginResult.operator = operator;
        preLoginResult.mLoginType = (TextUtils.equals(operator, "CMCC") ? 1 : TextUtils.equals(operator, "CUCC") ? 4 : 8) | 16;
        preLoginResult.mFromSource = this.reportInfo.mScene;
        preLoginResult.mExpires = 1800000L;
        preLoginResult.mCTS = System.currentTimeMillis();
        this.callback.run(1, verifyResult.toJson(), preLoginResult);
    }

    private void makeFailException() {
        onFailure(new VerifyException(-1, "MOB return null result"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lantern.auth.onekey.callback.MobCallbackBridge, cn.fly.verify.common.callback.OperationCallback
    public void onComplete(T t) {
        super.onComplete(t);
        b05.d("onComplete()");
        if (t instanceof PreVerifyResult) {
            handlePre((PreVerifyResult) t);
        } else if (t instanceof VerifyResult) {
            handlerConfirm((VerifyResult) t);
        }
    }

    @Override // com.lantern.auth.onekey.callback.MobCallbackBridge, cn.fly.verify.common.callback.OperationCallback
    public void onFailure(VerifyException verifyException) {
        super.onFailure(verifyException);
        b05.d("onFailure" + verifyException.getMessage());
        BLLog.e(verifyException);
        if (this.isPreLogin) {
            AuthReport.doOnekeyEvent(this.reportInfo, 6, verifyException.toString());
        }
        if (!this.isPreLogin) {
            PreLoginResult preLoginResult = new PreLoginResult();
            preLoginResult.mLoginType = 16;
            preLoginResult.mMsg = verifyException.getMessage();
            this.callback.run(0, verifyException.toString(), preLoginResult);
            return;
        }
        if (WkSDKManager.getSdkConfig().getLoginTypeByFilter(WkOAuthConst.ENTRANCE_AUTO, false) == 8) {
            b05.d("MobCallback===>onFailure: 发现是电信的网络，请求失败直接透出");
            PreLoginResult preLoginResult2 = new PreLoginResult();
            preLoginResult2.mLoginType = 16;
            preLoginResult2.mMsg = verifyException.getMessage();
            this.callback.run(0, verifyException.toString(), preLoginResult2);
            return;
        }
        b05.d("MobCallback===>onFailure: 调用其他网络一键登录");
        OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
        oneKeyReportInfo.mLoginType = WkSDKManager.getSdkConfig().getLoginTypeByFilter(WkOAuthConst.ENTRANCE_AUTO, false);
        OneKeyReportInfo oneKeyReportInfo2 = this.reportInfo;
        oneKeyReportInfo.mScene = oneKeyReportInfo2.mScene;
        oneKeyReportInfo.mSid = oneKeyReportInfo2.mSid;
        oneKeyReportInfo.isRetry = true;
        OneKeyLoginManager.preLogin(this.callback, oneKeyReportInfo);
        AuthReport.doOnekeyEvent(this.reportInfo, 6, verifyException.toString());
    }
}
