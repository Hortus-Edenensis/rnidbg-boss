package com.lantern.auth.openapi;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.lantern.auth.android.BLPackageManager;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.app.SMSLoginHelper;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLHttp;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.onekey.OneKeyLoginManager;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.lantern.auth.provider.ClientLoginManager;
import defpackage.b05;
import java.util.UUID;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OAuthApi {
    private static final String WK_AUTH_ACTIVITY = "com.lantern.auth.ui.AuthActivity";
    public static final String WK_PACKAGE_NAME = "com.snda.wifilocating";

    public static void checkSDKInit() {
        if (!WkSDKManager.isInit()) {
            throw new ExceptionInInitializerError("please init auth sdk first!");
        }
    }

    public static void confirmLogin(String str, PreLoginResult preLoginResult, BLCallback bLCallback) {
        checkSDKInit();
        OneKeyLoginManager.confirmLogin(str, bLCallback, preLoginResult);
    }

    public static int getAutoLoginType(String str) {
        try {
            return WkSDKManager.getSdkConfig().getLoginTypeByFilter(str, false);
        } catch (Exception e) {
            BLLog.e(e);
            return 2;
        }
    }

    public static void getLoginCode(long j, String str, BLCallback bLCallback) {
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        ClientLoginManager.funDC(FunDC.ID_AUTH_1078, "code", strReplace);
        if (j <= 0) {
            j = 6000;
        }
        WkSDKManager.updateTransferSid(strReplace);
        new ClientLoginManager(strReplace).getcode(j, str, bLCallback);
    }

    public static int getOperatorType(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("getOperatorType返回的type=");
        int i2 = i ^ 16;
        sb.append(i2);
        b05.d(sb.toString());
        return i2;
    }

    public static void getSMSCode(SMSInfo sMSInfo, BLCallback bLCallback) {
        FunDC.onEventById(FunDC.ID_AUTH_1072);
        SMSLoginHelper.getSMSCode(sMSInfo, bLCallback);
    }

    public static void getSimpleProfile(long j, BLCallback bLCallback) {
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        ClientLoginManager.funDC(FunDC.ID_AUTH_1078, "mobile", strReplace);
        if (!isWkAppInstalled()) {
            ClientLoginManager.funDC(FunDC.ID_AUTH_1082, "mobile", strReplace);
        }
        WkSDKManager.updateTransferSid(strReplace);
        new ClientLoginManager(strReplace).getMobileNumber(j, bLCallback);
    }

    public static void init(Application application, String str, String str2, int i, String str3) {
        WkSDKManager.init(application, str, str2, i, str3);
    }

    public static boolean isTargetType(int i, int i2) {
        return i2 == 16 ? (i & i2) == i2 : i == i2;
    }

    public static boolean isWkAppInstalled() {
        return BLPackageManager.isAppExsit(WkSDKManager.getContext(), "com.snda.wifilocating");
    }

    public static boolean isWkAppSupportAPI() {
        try {
            PackageManager packageManager = WkSDKManager.getContext().getPackageManager();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.snda.wifilocating", WK_AUTH_ACTIVITY));
            return packageManager.queryIntentActivities(intent, 32).size() > 0;
        } catch (Exception e) {
            BLLog.e(e);
            return false;
        }
    }

    public static void loginBySMSCode(LoginInfo loginInfo, BLCallback bLCallback) {
        FunDC.onEventById(FunDC.ID_AUTH_1074);
        SMSLoginHelper.postCode(loginInfo, bLCallback);
    }

    public static void onAppCreate() {
        try {
            BLHttp.sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        } catch (Exception e) {
            BLLog.e(e);
        }
    }

    public static void preLogin(BLCallback bLCallback) {
        checkSDKInit();
        FunDC.onEventById(FunDC.ID_AUTH_1076);
        OneKeyLoginManager.preLogin(bLCallback, WkOAuthConst.ENTRANCE_IMPLICIT);
    }

    public static void setPermissions(int i) {
        WkSDKManager.setPermissions(i);
    }
}
