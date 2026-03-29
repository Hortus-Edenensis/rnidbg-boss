package com.huawei.hms.ads.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final String Code = "AppDownloadUtils";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r1.S() > 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AppStatus Code(AppDownloadTask appDownloadTask) {
        switch (appDownloadTask.B()) {
            case 0:
                return AppStatus.PAUSE;
            case 1:
                return AppStatus.WAITING;
            case 2:
                return AppStatus.DOWNLOADING;
            case 3:
                return AppStatus.INSTALL;
            case 5:
                return AppStatus.INSTALLING;
            case 6:
                return AppStatus.INSTALLED;
        }
        return AppStatus.DOWNLOAD;
    }

    public static int V(String str, AppInfo appInfo) {
        if (appInfo != null && !bc.Code(str)) {
            if (Code(appInfo)) {
                return 3;
            }
            if (Code(str)) {
                return 2;
            }
        }
        return 1;
    }

    public static String Code(Context context, AppInfo appInfo) {
        if (context == null || appInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(appInfo.n())) {
            return appInfo.n();
        }
        int i = R.string.hiad_download_download;
        if ("11".equals(appInfo.i())) {
            i = R.string.hiad_download_install;
            if (appInfo.U() == 1) {
                i = R.string.hiad_preinstall_restore_and_open;
            }
        }
        return Code(appInfo.l(), context.getString(i));
    }

    public static String Code(Context context, AppInfo appInfo, int i) {
        int i2;
        if (context == null || appInfo == null) {
            return "";
        }
        String strM = appInfo.m();
        if (!Code(appInfo)) {
            i2 = R.string.hiad_download_open;
        } else {
            if (i == 1) {
                return context.getString(R.string.hiad_app_preordered);
            }
            i2 = R.string.hiad_app_preorder;
        }
        return Code(context, appInfo, strM, i2);
    }

    public static String Code(Context context, AppInfo appInfo, String str) {
        return (appInfo == null || context == null || h.V(context, appInfo.Code()) == null || !TextUtils.isEmpty(appInfo.Q())) ? str : context.getString(R.string.hiad_download_open);
    }

    private static String Code(Context context, AppInfo appInfo, String str, int i) {
        return !TextUtils.isEmpty(appInfo.o()) ? appInfo.o() : Code(str, context.getString(i));
    }

    public static String Code(String str, AppInfo appInfo) {
        if (appInfo != null && !bc.Code(str)) {
            if (Code(appInfo)) {
                return v.Code;
            }
            if (Code(str)) {
                return v.C;
            }
        }
        return "app";
    }

    public static String Code(String str, String str2) {
        return (TextUtils.isEmpty(str) || (!(bg.B() && "zh-CN".equalsIgnoreCase(d.V())) && bg.B())) ? str2 : str;
    }

    public static boolean Code(AppInfo appInfo) {
        return (appInfo == null || TextUtils.isEmpty(appInfo.Q())) ? false : true;
    }

    private static boolean Code(String str) {
        return "com.huawei.fastapp".equalsIgnoreCase(str) || "com.huawei.fastapp.dev".equalsIgnoreCase(str);
    }
}
