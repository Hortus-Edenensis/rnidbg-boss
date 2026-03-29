package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.bytedance.sdk.component.utils.k;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.fx.jk;
import com.ss.android.socialbase.appdownloader.fx.t;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.sz3;
import defpackage.tz3;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private static NotificationChannel nr;
    private static int u;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.n.u.u(i).nr("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.nr.u().iz(i);
        }
        u((Activity) n.u().nr());
        return com.ss.android.socialbase.downloader.n.u.u(i).u("install_queue_enable", 0) == 1 ? n.u().u(context, i, z) : nr(context, i, z);
    }

    public static boolean fx(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return nr(context, downloadInfo, u(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static String nr(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", WkAdxAdConfigMg.DSP_NAME_BAIDU};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return u(j, j2, strArr[i]);
            }
        }
        return null;
    }

    private static String u(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static boolean fx(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static String u(long j) {
        return u(j, true);
    }

    public static List<String> fx() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String u(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", WkAdxAdConfigMg.DSP_NAME_BAIDU};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return u(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    private static JSONObject b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int nr(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.fx.nr(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.fx.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.t().l();
                        int iU = fx.u(context, i, z, downloadInfo, file);
                        if (iU == 1 && b.t().sx() != null) {
                            b.t().sx().u(downloadInfo, null);
                        }
                        fx.nr(downloadInfo, z, iU);
                    }
                });
                return 1;
            }
        }
        nr(downloadInfo, z, 2);
        return 2;
    }

    private static String u(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().u(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int u(final Context context, final int i, final boolean z) {
        t tVarN = b.t().n();
        if (tVarN == null) {
            return b(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        u = 1;
        tVarN.u(downloadInfo, new jk() { // from class: com.ss.android.socialbase.appdownloader.fx.1
            @Override // com.ss.android.socialbase.appdownloader.fx.jk
            public void u() {
                int unused = fx.u = fx.b(context, i, z);
            }
        });
        return u;
    }

    public static boolean nr(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return u(context, downloadInfo, packageInfo, false);
    }

    public static int nr(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoU = u(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoU != null) {
                    int i = packageInfoU.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfoU;
        Intent intentU;
        Process processExec;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                processExec = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    processExec.waitFor();
                } catch (Throwable unused) {
                    if (processExec != null) {
                    }
                    packageInfoU = u(downloadInfo, file);
                    if (packageInfoU == null) {
                    }
                    if (b.t().b() != null) {
                    }
                    if (!u(context, downloadInfo, packageInfoU)) {
                    }
                }
            } catch (Throwable unused2) {
                processExec = null;
            }
            processExec.destroy();
        }
        try {
            packageInfoU = u(downloadInfo, file);
            if (packageInfoU == null) {
                try {
                    downloadInfo.setFilePackageName(packageInfoU.packageName);
                    th = null;
                } catch (Throwable th) {
                    th = th;
                }
            } else {
                th = null;
            }
        } catch (Throwable th2) {
            th = th2;
            packageInfoU = null;
        }
        if (b.t().b() != null) {
            if (packageInfoU == null) {
                BaseException baseException = new BaseException(2001, th);
                b.t().b().u(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                b.t().b().u(downloadInfo, null, 11);
            }
        }
        if (!u(context, downloadInfo, packageInfoU)) {
            return 2;
        }
        if (packageInfoU != null && com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfoU.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfoU.versionCode));
        }
        int[] iArr = new int[1];
        if (nr(context, downloadInfo, packageInfoU)) {
            intentU = context.getPackageManager().getLaunchIntentForPackage(packageInfoU.packageName);
        } else {
            if (!z && u(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            intentU = u(context, downloadInfo, file, z, iArr);
        }
        if (intentU == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        intentU.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("app_install_return_result", 0) == 1) {
            intentU.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && nr.u(context, downloadInfo, intentU, z)) {
            return 1;
        }
        return u(context, intentU);
    }

    public static String nr() {
        return com.ss.android.socialbase.downloader.jk.iz.pn();
    }

    public static boolean nr(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String nr(@NonNull Context context) {
        try {
            if (nr == null) {
                tz3.a();
                NotificationChannel notificationChannelA = sz3.a("111111", "channel_appdownloader", 3);
                nr = notificationChannelA;
                notificationChannelA.setSound(null, null);
                nr.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(nr);
            }
        } catch (Throwable unused) {
        }
        return "111111";
    }

    public static int u(Context context, Intent intent) {
        try {
            if (b.t().o() != null) {
                if (b.t().o().u(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean u(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.fx.pn pnVarFx = b.t().fx();
        if (pnVarFx != null) {
            pnVarFx.u(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (pnVarFx.u()) {
                return true;
            }
        }
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.u(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.fx.b bVarNr = b.t().nr();
        return (bVarNr instanceof com.ss.android.socialbase.appdownloader.fx.u) && ((com.ss.android.socialbase.appdownloader.fx.u) bVarNr).nr();
    }

    public static boolean u(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.n.u.u(i).u("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.iz.pn.mv() || com.ss.android.socialbase.appdownloader.iz.pn.s()) && com.ss.android.socialbase.downloader.jk.jk.u(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int u() {
        return b.t().x() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri u(int i, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri uriFromFile;
        if (iDownloadFileUriProvider != null) {
            uriFromFile = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
        } else {
            com.ss.android.socialbase.appdownloader.fx.x xVarIz = b.t().iz();
            if (xVarIz != null) {
                uriFromFile = xVarIz.u(i, str, file.getAbsolutePath());
            }
            uriFromFile = null;
            if (uriFromFile == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
                        uriFromFile = FileProvider.getUriForFile(context, str, file);
                    } else {
                        uriFromFile = Uri.fromFile(file);
                    }
                } catch (Throwable unused) {
                }
            }
            return uriFromFile;
        }
        if (uriFromFile == null) {
        }
        return uriFromFile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent u(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri uriU = u(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, b.t().pn(), file);
        if (uriU == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriU, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.fx.pn pnVarFx = b.t().fx();
        boolean zU = pnVarFx != null ? pnVarFx.u(downloadInfo.getId(), z) : false;
        z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? U = zU;
        if (downloadNotificationEventListener != null) {
            U = downloadNotificationEventListener.u(z);
        }
        iArr[0] = U;
        if (U != 0) {
            return null;
        }
        return intent;
    }

    public static boolean u(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && u(com.ss.android.socialbase.downloader.downloader.fx.oa(), downloadInfo, str);
        }
        return true;
    }

    public static boolean u(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                k.nr("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoU = u(downloadInfo, file);
                if (packageInfoU == null || !packageInfoU.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoU.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, u());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("install_callback_error")) {
                    return false;
                }
                String strU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int iU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (strU == null || TextUtils.isEmpty(strU) || !strU.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, u());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iU != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused3) {
            return false;
        }
    }

    public static boolean u(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, u());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean u(Context context, DownloadInfo downloadInfo) {
        return u(context, downloadInfo, true);
    }

    public static boolean u(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return fx(context, downloadInfo);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, u());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo u(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        k.nr("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return u(downloadInfo, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(String str, String str2, String str3, boolean z) {
        String lastPathSegment = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                str2 = (TextUtils.isEmpty(uri.getLastPathSegment()) || uri.getLastPathSegment().contains("..")) ? "default.apk" : uri.getLastPathSegment();
            }
        } else {
            if (!TextUtils.isEmpty(uri.getLastPathSegment()) && !uri.getLastPathSegment().contains("..")) {
                lastPathSegment = uri.getLastPathSegment();
            }
            if (!TextUtils.isEmpty(lastPathSegment)) {
                str2 = lastPathSegment;
            } else if (TextUtils.isEmpty(str2)) {
            }
        }
        if (!fx(str3) || str2.endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
            return str2;
        }
        return str2 + com.huawei.hms.ads.dynamicloader.b.b;
    }

    public static String u(String str, com.ss.android.socialbase.downloader.n.u uVar) {
        JSONObject jSONObjectB;
        String str2;
        if (uVar == null || (jSONObjectB = uVar.b("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectB.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int u(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    public static boolean u(Context context) {
        TypedArray typedArrayObtainStyledAttributes;
        int color;
        if (context == null) {
            return false;
        }
        try {
            color = context.getResources().getColor(pn.nr());
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(pn.pn(), new int[]{pn.fx(), pn.b()});
        } catch (Throwable unused) {
            typedArrayObtainStyledAttributes = null;
        }
        try {
            if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                try {
                    typedArrayObtainStyledAttributes.recycle();
                    return true;
                } catch (Throwable unused2) {
                    return true;
                }
            }
        } catch (Throwable unused3) {
            if (typedArrayObtainStyledAttributes != null) {
            }
            return false;
        }
        try {
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable unused4) {
        }
        return false;
    }

    public static void u(DownloadInfo downloadInfo, boolean z, boolean z2) {
        b.t().u(new iz(com.ss.android.socialbase.downloader.downloader.fx.oa(), downloadInfo.getUrl()).u(downloadInfo.getTitle()).nr(downloadInfo.getName()).fx(downloadInfo.getSavePath()).u(downloadInfo.isShowNotification()).nr(downloadInfo.isAutoInstallWithoutNotification()).fx(downloadInfo.isOnlyWifi() || z2).pn(downloadInfo.getExtra()).iz(downloadInfo.getMimeType()).u(downloadInfo.getExtraHeaders()).pn(true).nr(downloadInfo.getRetryCount()).fx(downloadInfo.getBackUpUrlRetryCount()).nr(downloadInfo.getBackUpUrls()).b(downloadInfo.getMinProgressTimeMsInterval()).pn(downloadInfo.getMaxProgressCount()).iz(z).b(downloadInfo.isNeedHttpsToHttpRetry()).x(downloadInfo.getPackageName()).n(downloadInfo.getMd5()).u(downloadInfo.getExpectFileLength()).a(downloadInfo.isNeedDefaultHttpServiceBackUp()).jk(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).u(downloadInfo.getEnqueueType()).s(downloadInfo.isForce()).mv(downloadInfo.isHeadConnectionAvailable()).x(downloadInfo.isNeedRetryDelay()).a(downloadInfo.getRetryDelayTimeArray()).u(b(downloadInfo.getDownloadSettingString())).t(downloadInfo.getIconUrl()).iz(downloadInfo.getExecutorGroup()).my(downloadInfo.isAutoInstall()));
    }

    public static void u(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception unused) {
            }
        }
    }

    public static PackageInfo u(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.iz.u.pn.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), file, u());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoU = com.ss.android.socialbase.appdownloader.iz.u.pn.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), file, u());
        downloadInfo.setPackageInfo(packageInfoU);
        return packageInfoU;
    }

    public static int u(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
