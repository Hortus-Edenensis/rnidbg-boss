package com.lantern.auth.onekey;

import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.onekey.task.AutoLoginTask;
import com.lantern.auth.onekey.task.PreLoginTask;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OneKeyLoginManager {
    public static void confirmLogin(String str, BLCallback bLCallback, PreLoginResult preLoginResult) {
        BLLog.d("start login and type is " + preLoginResult.mLoginType, new Object[0]);
        OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
        oneKeyReportInfo.mLoginType = preLoginResult.mLoginType;
        oneKeyReportInfo.mSid = UUID.randomUUID().toString();
        oneKeyReportInfo.mScene = preLoginResult.mFromSource;
        AuthReport.doOnekeyEvent(oneKeyReportInfo, 9);
        AutoLoginTask.startTask(bLCallback, HelperFactory.createHelper(preLoginResult.mLoginType, WkSDKManager.getContext()), preLoginResult, oneKeyReportInfo, str);
    }

    public static void preLogin(BLCallback bLCallback, String str) {
        OneKeyReportInfo oneKeyReportInfo = new OneKeyReportInfo();
        oneKeyReportInfo.mLoginType = WkSDKManager.getSdkConfig().getLoginTypeByFilter(str, true);
        oneKeyReportInfo.mSid = UUID.randomUUID().toString();
        oneKeyReportInfo.mScene = str;
        preLogin(bLCallback, oneKeyReportInfo);
    }

    public static void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        AuthReport.doOnekeyEvent(oneKeyReportInfo, 1);
        PreLoginTask.startPreLogin(HelperFactory.createHelper(oneKeyReportInfo.mLoginType, WkSDKManager.getContext()), bLCallback, oneKeyReportInfo);
    }
}
