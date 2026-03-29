package com.lantern.auth.onekey.task;

import android.os.AsyncTask;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.conf.WkSDKConfig;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpPostManager;
import com.lantern.auth.onekey.helper.OneKeyHelper;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.util.report.AuthReport;
import com.lantern.auth.util.report.OneKeyReportInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PreLoginTask extends AsyncTask<String, Void, PreLoginResult> {
    private BLCallback callback;
    private OneKeyHelper helper;
    private OneKeyReportInfo reportInfo;

    public PreLoginTask(OneKeyHelper oneKeyHelper, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.helper = oneKeyHelper;
        this.callback = bLCallback;
        this.reportInfo = oneKeyReportInfo;
    }

    public static void startPreLogin(OneKeyHelper oneKeyHelper, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        new PreLoginTask(oneKeyHelper, bLCallback, oneKeyReportInfo).executeOnExecutor(HttpPostManager.getExecutorPool(), new String[0]);
    }

    @Override // android.os.AsyncTask
    public PreLoginResult doInBackground(String... strArr) {
        WkSDKConfig sdkConfig = WkSDKManager.getSdkConfig();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final PreLoginResult[] preLoginResultArr = new PreLoginResult[1];
        AuthReport.doOnekeyEvent(this.reportInfo, 2);
        this.helper.preLogin(new BLCallback() { // from class: com.lantern.auth.onekey.task.PreLoginTask.1
            @Override // com.lantern.auth.core.BLCallback
            public void run(int i, String str, Object obj) {
                if (obj instanceof PreLoginResult) {
                    preLoginResultArr[0] = (PreLoginResult) obj;
                }
                countDownLatch.countDown();
            }
        }, this.reportInfo);
        try {
            countDownLatch.await(sdkConfig.getCMCCTimeout(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            BLLog.e(e);
        }
        PreLoginResult preLoginResult = preLoginResultArr[0];
        if (preLoginResult == null) {
            AuthReport.doOnekeyEvent(this.reportInfo, 5);
            PreLoginResult preLoginResult2 = new PreLoginResult();
            preLoginResultArr[0] = preLoginResult2;
            preLoginResult2.mRetCode = 13;
            preLoginResult2.mLoginType = this.reportInfo.mLoginType;
        } else if (preLoginResult.mRetCode == 1) {
            AuthReport.doOnekeyEvent(this.reportInfo, 3);
        } else {
            AuthReport.doOnekeyEvent(this.reportInfo, 4);
        }
        return preLoginResultArr[0];
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(PreLoginResult preLoginResult) {
        if (preLoginResult == null || preLoginResult.mRetCode != 1) {
            AuthReport.doOnekeyEvent(this.reportInfo, 8);
        } else {
            AuthReport.doOnekeyEvent(this.reportInfo, 7);
        }
        this.callback.run(preLoginResult.mRetCode, preLoginResult.mMsg, preLoginResult);
        this.callback = null;
    }
}
