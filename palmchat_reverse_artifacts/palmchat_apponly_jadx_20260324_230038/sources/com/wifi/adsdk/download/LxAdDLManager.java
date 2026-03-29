package com.wifi.adsdk.download;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.utils.JsonUtil;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.entity.LxAdEventParams;
import com.wifi.adsdk.utils.BLUtils;
import com.wifi.adsdk.utils.LxAdConst;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.lxad.ad.R;
import defpackage.sz3;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDLManager {
    private static final String AD_DOWN_SP_NAME = "lxadx_apk_download_sp";
    private static final String AD_FILE_NAME = "lxad_apk_download_file";
    public static final String AUTH_DOWN_FILE_PROVIDER = "com.zenmen.palmchat.lxad.down.file.provider";
    public static final String CHANNEL_ID = "lxadxDownAdId";
    public static final String ITEM_ADVERNAME = "advertiserName";
    public static final String ITEM_APPSIZE = "appSize";
    public static final String ITEM_APPVER = "appVersion";
    public static final String ITEM_DESC = "desc";
    public static final String ITEM_DESCURL = "descriptionUrl";
    public static final String ITEM_ICONURL = "iconUrl";
    public static final String ITEM_PERURL = "permissionUrl";
    public static final String ITEM_PKGNAME = "pkgName";
    public static final String ITEM_PKGURL = "pkgUrl";
    public static final String ITEM_PRIPOLURL = "privacyPolicyUrl";
    public static final String ITEM_TITLE = "title";
    private static final String KEY_ALL_BYTE = "allByte";
    private static final String KEY_DOWN_PROCESS = "downProcess";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_NOTIFICATION_ID = "notificationId";
    private static final String KEY_PKG_URL = "pkgUrl";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_STATUS = "status";
    public static final int NOTIFICATION_ID = 8001;
    public static int STATUS_DOWNED = 3;
    public static int STATUS_DOWNING = 1;
    public static int STATUS_ERROR = -1;
    public static int STATUS_INSTALLED = 4;
    public static int STATUS_NORMAL = 0;
    public static int STATUS_PAUSE = 2;
    public static final String TAG_ITEM_ALL = "tagItemData";
    private static DecimalFormat dfTow = new DecimalFormat("#.##");
    private static LxAdDLManager dlManager;
    private static String downFilePath;
    public static int notificationNum;
    private HashMap<String, LxAdDownAllMapData> lxAdAllDownData = new HashMap<>();
    private Context mContext;
    private Handler mainHandler;
    private LxAdDownPkgAddReceiver pkgAddReceiver;
    private PackageManager pm;
    private SharedPreferences sharedPreferences;

    private LxAdDLManager(Context context) {
        this.mContext = context;
        this.mainHandler = new Handler(this.mContext.getMainLooper());
        this.sharedPreferences = context.getSharedPreferences(AD_DOWN_SP_NAME, 0);
        downFilePath = getSdcardStoragePath(context);
    }

    private void finishDownAdNotificationUi(LxAdDownAdSaveData lxAdDownAdSaveData) {
        RemoteViews remoteViews;
        if (lxAdDownAdSaveData == null || lxAdDownAdSaveData.currentId <= 0 || lxAdDownAdSaveData.notification == null || lxAdDownAdSaveData.notificationManager == null || (remoteViews = lxAdDownAdSaveData.remoteViews) == null) {
            return;
        }
        try {
            remoteViews.setViewVisibility(R.id.down_downed_layout, 0);
            lxAdDownAdSaveData.remoteViews.setViewVisibility(R.id.down_downing_layout, 8);
            lxAdDownAdSaveData.remoteViews.setImageViewResource(R.id.down_remote_icon, R.drawable.down_remote_downed);
            lxAdDownAdSaveData.remoteViews.setViewVisibility(R.id.down_remote_btn, 8);
            lxAdDownAdSaveData.notificationManager.notify(lxAdDownAdSaveData.currentId, lxAdDownAdSaveData.notification);
        } catch (Exception unused) {
        }
    }

    private LxAdDownMdaData getClickTimeMdaData(String str) {
        LxAdDownAllMapData lxAdDownAllMapData;
        List<LxAdDownMdaData> list;
        LxAdDownMdaData lxAdDownMdaData = null;
        if (str != null && this.lxAdAllDownData.containsKey(str) && (lxAdDownAllMapData = this.lxAdAllDownData.get(str)) != null && (list = lxAdDownAllMapData.downMdaDatas) != null && list.size() > 0) {
            if (lxAdDownAllMapData.downMdaDatas.size() == 1) {
                lxAdDownMdaData = lxAdDownAllMapData.downMdaDatas.get(0);
            } else {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < lxAdDownAllMapData.downMdaDatas.size(); i++) {
                    linkedList.add(lxAdDownAllMapData.downMdaDatas.get(i));
                }
                Collections.sort(linkedList, new Comparator<LxAdDownMdaData>() { // from class: com.wifi.adsdk.download.LxAdDLManager.4
                    @Override // java.util.Comparator
                    public int compare(LxAdDownMdaData lxAdDownMdaData2, LxAdDownMdaData lxAdDownMdaData3) {
                        return Long.compare(lxAdDownMdaData3.clickTime, lxAdDownMdaData2.clickTime);
                    }
                });
                if (linkedList.size() > 0) {
                    lxAdDownMdaData = (LxAdDownMdaData) linkedList.get(0);
                }
            }
            LxAdLog.d("LXadDown getClickTimeMdaData pkgName " + str + " mdaData " + lxAdDownMdaData);
        }
        return lxAdDownMdaData;
    }

    public static LxAdDLManager getInstance(Context context) {
        if (dlManager == null) {
            synchronized (LxAdDLManager.class) {
                if (dlManager == null) {
                    dlManager = new LxAdDLManager(context);
                }
            }
        }
        return dlManager;
    }

    private String getSdcardStoragePath(Context context) {
        File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + "lxadx");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    private boolean isApkValid(String str) {
        boolean z;
        try {
            if (this.pm == null) {
                this.pm = this.mContext.getPackageManager();
            }
            z = true;
            this.pm.getPackageArchiveInfo(str, 1);
        } catch (Exception e) {
            LxAdLog.d("isApkValid Exception e " + e.toString() + " apkPath " + str);
            z = false;
        }
        LxAdLog.d("isApkValid result " + z + " apkPath " + str);
        return z;
    }

    private void onDownErrorCancelNotificationUi(LxAdDownAdSaveData lxAdDownAdSaveData) {
        int i;
        NotificationManager notificationManager;
        if (lxAdDownAdSaveData == null || (i = lxAdDownAdSaveData.currentId) <= 0 || (notificationManager = lxAdDownAdSaveData.notificationManager) == null) {
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Exception unused) {
        }
    }

    private void reportAdError(LxAdDownMdaData lxAdDownMdaData, int i, String str) {
        LxAdBeanData lxAdBeanData;
        if (lxAdDownMdaData == null || (lxAdBeanData = lxAdDownMdaData.lxAdBeanData) == null) {
            return;
        }
        LxAdManager.getAdManager().getConfig().getUrlEvent().reportDownloadFail(lxAdBeanData);
        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD_FAIL, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), i, str, lxAdBeanData.getApiSlotId(), "100")));
    }

    private void reportAdInstallEd(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportInstallEd) {
            return;
        }
        lxAdDownMdaData.reportInstallEd = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportInstallFinished(lxAdBeanData);
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_INSTALL_SUCCESS, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "")));
        }
    }

    private void reportDown0Done(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportDown0Done) {
            return;
        }
        lxAdDownMdaData.reportDown0Done = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportDownloadS(lxAdBeanData);
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "0")));
        }
    }

    private void reportDown100Done(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportDown100Done) {
            return;
        }
        lxAdDownMdaData.reportDown100Done = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportDownloaded(lxAdBeanData);
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "100")));
        }
    }

    private void reportDown25Done(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportDown25Done) {
            return;
        }
        lxAdDownMdaData.reportDown25Done = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "25")));
        }
    }

    private void reportDown50Done(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportDown50Done) {
            return;
        }
        lxAdDownMdaData.reportDown50Done = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "50")));
        }
    }

    private void reportDown75Done(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportDown75Done) {
            return;
        }
        lxAdDownMdaData.reportDown75Done = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_DOWNLOAD, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "75")));
        }
    }

    private void reportStartInstall(LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdDownMdaData == null || lxAdDownMdaData.reportStartInstall) {
            return;
        }
        lxAdDownMdaData.reportStartInstall = true;
        LxAdBeanData lxAdBeanData = lxAdDownMdaData.lxAdBeanData;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getUrlEvent().reportInstallStart(lxAdBeanData);
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_INSTALL, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdBeanData.getReqParams(), lxAdBeanData.getEcpm(), lxAdBeanData.getMaterialType(), lxAdBeanData.getApiId(), 0, "", lxAdBeanData.getApiSlotId(), "")));
        }
    }

    private void resumeDownAdNotificationUi(LxAdDownAdSaveData lxAdDownAdSaveData) {
        RemoteViews remoteViews;
        if (lxAdDownAdSaveData == null || lxAdDownAdSaveData.currentId <= 0 || lxAdDownAdSaveData.notification == null || lxAdDownAdSaveData.notificationManager == null || (remoteViews = lxAdDownAdSaveData.remoteViews) == null) {
            return;
        }
        try {
            remoteViews.setViewVisibility(R.id.down_downed_layout, 8);
            lxAdDownAdSaveData.remoteViews.setViewVisibility(R.id.down_downing_layout, 0);
            RemoteViews remoteViews2 = lxAdDownAdSaveData.remoteViews;
            int i = R.id.down_remote_btn;
            remoteViews2.setViewVisibility(i, 0);
            lxAdDownAdSaveData.remoteViews.setImageViewResource(R.id.down_remote_icon, R.drawable.down_remote_downpause);
            lxAdDownAdSaveData.remoteViews.setTextViewText(i, "暂停");
            lxAdDownAdSaveData.remoteViews.setTextViewText(R.id.downing_text, "正在下载");
            lxAdDownAdSaveData.notificationManager.notify(lxAdDownAdSaveData.currentId, lxAdDownAdSaveData.notification);
        } catch (Exception unused) {
        }
    }

    private void showDownAdRemoteView(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        int downNotificationId = getDownNotificationId(str2);
        LxAdLog.d("LXadDown DLManager 开始下载 showDownAdRemoteView currentId  " + downNotificationId + " ::" + jSONObject);
        String strOptString = jSONObject.optString("title");
        String strOptString2 = jSONObject.optString("pkgUrl");
        int iOptInt = jSONObject.optInt(ITEM_APPSIZE);
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.layout_download_custom_notification);
        if (downNotificationId == 0) {
            int i = notificationNum + 1;
            notificationNum = i;
            downNotificationId = i + 8001;
            getInstance(this.mContext).saveNotificationId(str2, downNotificationId);
        }
        Intent intent = new Intent(this.mContext, (Class<?>) LxAdNotificationClickReceiver.class);
        intent.setAction(LxAdNotificationClickReceiver.EXTRA_ACTION_DOWN_BTN_CLICK);
        intent.putExtra(LxAdNotificationClickReceiver.EXTRA_DOWN_URL, strOptString2);
        intent.putExtra(LxAdNotificationClickReceiver.EXTRA_TITLE, strOptString);
        intent.putExtra(LxAdNotificationClickReceiver.EXTRA_PKG_NAME, str2);
        intent.putExtra(LxAdNotificationClickReceiver.EXTRA_CURRENTID, downNotificationId);
        intent.putExtra(LxAdNotificationClickReceiver.EXTRA_NOTIFI_FROM, LxAdNotificationClickReceiver.FROM_SPLASH);
        remoteViews.setOnClickPendingIntent(R.id.down_remote_btn, PendingIntent.getBroadcast(this.mContext, downNotificationId, intent, 134217728));
        Intent intent2 = new Intent(this.mContext, (Class<?>) LxAdNotificationClickReceiver.class);
        intent2.setAction(LxAdNotificationClickReceiver.EXTRA_ACTION_DOWN_LAYOUT_CLICK);
        intent2.putExtra(LxAdNotificationClickReceiver.EXTRA_PKG_NAME, str2);
        intent2.putExtra(LxAdNotificationClickReceiver.EXTRA_TITLE, strOptString);
        intent2.putExtra(LxAdNotificationClickReceiver.EXTRA_DOWN_URL, strOptString2);
        intent2.putExtra(LxAdNotificationClickReceiver.EXTRA_CURRENTID, downNotificationId);
        intent2.putExtra(LxAdNotificationClickReceiver.EXTRA_NOTIFI_FROM, LxAdNotificationClickReceiver.FROM_SPLASH);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, downNotificationId, intent2, 134217728);
        if (!TextUtils.isEmpty(strOptString)) {
            remoteViews.setTextViewText(R.id.down_remoteview_title, strOptString);
        }
        int i2 = (int) ((iOptInt / 1024.0f) / 1024.0f);
        remoteViews.setTextViewText(R.id.downed_allsize, i2 + "MB");
        remoteViews.setTextViewText(R.id.downing_allsize, "/" + i2 + "MB");
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(this.mContext, CHANNEL_ID).setSmallIcon(R.drawable.ic_lxad_launcher).setCustomContentView(remoteViews).setContentIntent(broadcast).setWhen(System.currentTimeMillis()).setAutoCancel(true).setDefaults(2);
        if (Build.VERSION.SDK_INT >= 23) {
            NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
            getInstance(this.mContext).createNotificationChannel(notificationManager);
            Notification notificationBuild = defaults.build();
            notificationManager.notify(downNotificationId, notificationBuild);
            LxAdDownAdSaveData lxAdDownAdSaveData = new LxAdDownAdSaveData();
            lxAdDownAdSaveData.notification = notificationBuild;
            lxAdDownAdSaveData.currentId = downNotificationId;
            lxAdDownAdSaveData.notificationManager = notificationManager;
            lxAdDownAdSaveData.jsonObject = jSONObject;
            lxAdDownAdSaveData.remoteViews = remoteViews;
            lxAdDownAdSaveData.allSize = i2;
            addAdRemoteLxAllData(lxAdDownAdSaveData, str2, strOptString2);
        }
        LxAdLog.d("LXadDown DLManager showDownAdRemoteView end currentId  " + downNotificationId);
    }

    private void startApkInstall(String str, String str2, String str3) {
        File file = new File(str);
        boolean z = false;
        if (file.exists()) {
            if (isApkValid(str)) {
                installAPK(file);
                startInstallRealReport(str2);
                z = true;
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.download.LxAdDLManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(LxAdManager.getAdManager().getContext(), "安装包解析失败", 0).show();
                    }
                });
            }
        }
        if (z) {
            return;
        }
        onDownError(str3, str2, -10002, "apk filePath not exists", false);
    }

    private void startInstallRealReport(String str) {
        LxAdDownMdaData clickTimeMdaData = getClickTimeMdaData(str);
        if (clickTimeMdaData != null) {
            reportDown0Done(clickTimeMdaData);
            reportDown25Done(clickTimeMdaData);
            reportDown50Done(clickTimeMdaData);
            reportDown75Done(clickTimeMdaData);
            reportDown100Done(clickTimeMdaData);
            reportStartInstall(clickTimeMdaData);
        }
    }

    private void stopDownAdNotificationUi(LxAdDownAdSaveData lxAdDownAdSaveData) {
        RemoteViews remoteViews;
        if (lxAdDownAdSaveData == null || lxAdDownAdSaveData.currentId <= 0 || lxAdDownAdSaveData.notification == null || lxAdDownAdSaveData.notificationManager == null || (remoteViews = lxAdDownAdSaveData.remoteViews) == null) {
            return;
        }
        try {
            remoteViews.setViewVisibility(R.id.down_downed_layout, 8);
            lxAdDownAdSaveData.remoteViews.setViewVisibility(R.id.down_downing_layout, 0);
            RemoteViews remoteViews2 = lxAdDownAdSaveData.remoteViews;
            int i = R.id.down_remote_btn;
            remoteViews2.setViewVisibility(i, 0);
            lxAdDownAdSaveData.remoteViews.setImageViewResource(R.id.down_remote_icon, R.drawable.down_remote_downpause);
            lxAdDownAdSaveData.remoteViews.setTextViewText(i, "继续");
            lxAdDownAdSaveData.remoteViews.setTextViewText(R.id.downing_text, "暂停中");
            lxAdDownAdSaveData.notificationManager.notify(lxAdDownAdSaveData.currentId, lxAdDownAdSaveData.notification);
        } catch (Exception unused) {
        }
    }

    private void updateDownProcessUi(String str, int i) {
        LxAdDownAdSaveData lxAdDownAdSaveData;
        if (!this.lxAdAllDownData.containsKey(str) || (lxAdDownAdSaveData = this.lxAdAllDownData.get(str).adSaveData) == null || lxAdDownAdSaveData.notification == null || lxAdDownAdSaveData.notificationManager == null || lxAdDownAdSaveData.remoteViews == null) {
            return;
        }
        if (i >= 95) {
            i = 100;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                lxAdDownAdSaveData.remoteViews.setProgressBar(R.id.down_notification_progress, 100, i, true);
            } else {
                lxAdDownAdSaveData.remoteViews.setProgressBar(R.id.down_notification_progress, 100, i, false);
            }
            String str2 = dfTow.format((i / 100.0f) * lxAdDownAdSaveData.allSize);
            if (i == 100) {
                str2 = lxAdDownAdSaveData.allSize + "";
            }
            lxAdDownAdSaveData.remoteViews.setTextViewText(R.id.downing_ed_size, str2 + "MB");
            lxAdDownAdSaveData.notificationManager.notify(lxAdDownAdSaveData.currentId, lxAdDownAdSaveData.notification);
        } catch (Exception unused) {
        }
    }

    public synchronized void adDownLoadChange(String str, int i, String str2) {
        LxAdDownAllMapData lxAdDownAllMapData;
        if (str != null) {
            if (this.lxAdAllDownData.containsKey(str) && (lxAdDownAllMapData = this.lxAdAllDownData.get(str)) != null) {
                int downStatus = getDownStatus(str);
                LxAdLog.d("LXadDown adDownLoadChange pkgName " + str + " downStatus " + downStatus);
                LxAdDownAdSaveData lxAdDownAdSaveData = lxAdDownAllMapData.adSaveData;
                if (lxAdDownAdSaveData != null) {
                    if (downStatus == STATUS_DOWNING) {
                        resumeDownAdNotificationUi(lxAdDownAdSaveData);
                    } else if (downStatus == STATUS_PAUSE) {
                        stopDownAdNotificationUi(lxAdDownAdSaveData);
                    } else if (downStatus == STATUS_DOWNED) {
                        finishDownAdNotificationUi(lxAdDownAdSaveData);
                    }
                }
                List<LxAdBaseView> list = lxAdDownAllMapData.adBaseViews;
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < lxAdDownAllMapData.adBaseViews.size(); i2++) {
                        LxAdBaseView lxAdBaseView = lxAdDownAllMapData.adBaseViews.get(i2);
                        if (downStatus == STATUS_NORMAL) {
                            lxAdBaseView.downListener.onStart(str);
                        } else if (downStatus == STATUS_DOWNING) {
                            lxAdBaseView.downListener.onResume(str);
                        } else if (downStatus == STATUS_PAUSE) {
                            lxAdBaseView.downListener.onStop(str);
                        } else if (downStatus == STATUS_DOWNED) {
                            lxAdBaseView.downListener.onFinish(str);
                        } else if (downStatus == STATUS_INSTALLED) {
                            lxAdBaseView.downListener.onInstalled(str);
                        }
                    }
                }
            }
        }
    }

    public synchronized void addAdRemoteLxAllData(LxAdDownAdSaveData lxAdDownAdSaveData, String str, String str2) {
        LxAdLog.d("LXadDown addAdRemoteLxAllData pkgName " + str);
        if (!TextUtils.isEmpty(str) && lxAdDownAdSaveData != null) {
            if (this.lxAdAllDownData.containsKey(str)) {
                this.lxAdAllDownData.get(str).adSaveData = lxAdDownAdSaveData;
            }
            adDownLoadChange(str, 0, "");
        }
    }

    public synchronized void checkDownTimeOutAd() {
        try {
            for (Map.Entry<String, ?> entry : this.sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    JSONObject jSONObject = new JSONObject((String) value);
                    long jOptLong = jSONObject.optLong("startTime", 0L);
                    if (jOptLong > 0 && System.currentTimeMillis() - jOptLong >= 86400000) {
                        deleteDownApp(jSONObject.optString("pkgUrl"), key);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void checkInstallRealReport(String str) {
        LxAdDownMdaData clickTimeMdaData = getClickTimeMdaData(str);
        if (clickTimeMdaData != null) {
            reportDown0Done(clickTimeMdaData);
            reportDown25Done(clickTimeMdaData);
            reportDown50Done(clickTimeMdaData);
            reportDown75Done(clickTimeMdaData);
            reportDown100Done(clickTimeMdaData);
            reportStartInstall(clickTimeMdaData);
            reportAdInstallEd(clickTimeMdaData);
        }
    }

    public void checkPkgAddReceiver() {
        if (this.pkgAddReceiver == null) {
            this.pkgAddReceiver = new LxAdDownPkgAddReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.pkgAddReceiver, intentFilter);
        }
    }

    public JSONObject createDialogJsonBeanByData(LxAdBeanData lxAdBeanData) {
        JSONObject jSONObject = new JSONObject();
        if (lxAdBeanData != null) {
            try {
                jSONObject.put("pkgName", lxAdBeanData.getAppBundleId());
                if (lxAdBeanData.getClickTargetUrl() != null) {
                    jSONObject.put("pkgUrl", lxAdBeanData.getClickTargetUrl().getPackageUrl());
                }
                jSONObject.put(ITEM_DESCURL, lxAdBeanData.getDescriptionUrl());
                jSONObject.put(ITEM_PERURL, lxAdBeanData.getPermissionUrl());
                jSONObject.put("privacyPolicyUrl", lxAdBeanData.getPrivacyPolicyUrl());
                jSONObject.put(ITEM_ICONURL, lxAdBeanData.getIconUrl());
                jSONObject.put("title", lxAdBeanData.getAppName());
                jSONObject.put(ITEM_DESC, lxAdBeanData.getDescription());
                jSONObject.put("appVersion", lxAdBeanData.getAppVersion());
                jSONObject.put(ITEM_APPSIZE, lxAdBeanData.getAppSize());
                jSONObject.put(ITEM_ADVERNAME, lxAdBeanData.getAdvertiserName());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public String createNotificationChannel(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26 && notificationManager != null && notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
            NotificationChannel notificationChannelA = sz3.a(CHANNEL_ID, "downLxadChannel", 4);
            notificationChannelA.setDescription("lxadDown");
            notificationChannelA.enableVibration(false);
            notificationChannelA.enableLights(false);
            notificationChannelA.setSound(null, null);
            notificationChannelA.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return CHANNEL_ID;
    }

    public synchronized void createOrAddLxAllDataByPkg(LxAdBaseView lxAdBaseView, String str, String str2, LxAdDownMdaData lxAdDownMdaData) {
        LxAdLog.d("LXadDown createOrAddLxAllDataByPkg pkgName " + str);
        if (!TextUtils.isEmpty(str)) {
            if (this.lxAdAllDownData.containsKey(str)) {
                LxAdDownAllMapData lxAdDownAllMapData = this.lxAdAllDownData.get(str);
                if (lxAdBaseView != null && !lxAdDownAllMapData.adBaseViews.contains(lxAdBaseView)) {
                    lxAdDownAllMapData.adBaseViews.add(lxAdBaseView);
                }
                if (lxAdDownMdaData != null && !lxAdDownAllMapData.downMdaDatas.contains(lxAdDownMdaData)) {
                    lxAdDownAllMapData.downMdaDatas.add(lxAdDownMdaData);
                }
            } else {
                LxAdDownAllMapData lxAdDownAllMapData2 = new LxAdDownAllMapData();
                this.lxAdAllDownData.put(str, lxAdDownAllMapData2);
                lxAdDownAllMapData2.pkgName = str;
                lxAdDownAllMapData2.downUrl = str2;
                if (lxAdBaseView != null) {
                    lxAdDownAllMapData2.adBaseViews.add(lxAdBaseView);
                }
                if (lxAdDownMdaData != null) {
                    lxAdDownAllMapData2.downMdaDatas.add(lxAdDownMdaData);
                }
            }
            adDownLoadChange(str, 0, "");
        }
    }

    public synchronized void deleteDownApp(String str, String str2) {
        NotificationManager notificationManager;
        try {
            LxAdLog.d("LXadDown DLManager deleteDownApp pkgName " + str2);
            if (!TextUtils.isEmpty(str2)) {
                WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                if (wifiNestAd.getMAdRequestCallBack() != null && !TextUtils.isEmpty(str)) {
                    wifiNestAd.getMAdRequestCallBack().deleteDownApp(str, str2);
                }
                if (this.sharedPreferences.contains(str2)) {
                    this.sharedPreferences.edit().remove(str2).apply();
                }
                if (this.lxAdAllDownData.containsKey(str2)) {
                    LxAdDownAllMapData lxAdDownAllMapData = this.lxAdAllDownData.get(str2);
                    LxAdDownAdSaveData lxAdDownAdSaveData = lxAdDownAllMapData.adSaveData;
                    if (lxAdDownAdSaveData != null && (notificationManager = lxAdDownAdSaveData.notificationManager) != null) {
                        notificationManager.cancel(lxAdDownAdSaveData.currentId);
                    }
                    List<LxAdBaseView> list = lxAdDownAllMapData.adBaseViews;
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < lxAdDownAllMapData.adBaseViews.size(); i++) {
                            lxAdDownAllMapData.adBaseViews.get(i).downListener.deleteDownApp(str2);
                        }
                    }
                    this.lxAdAllDownData.remove(str2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public LxAdDownMdaData findMdaDownData(LxAdBeanData lxAdBeanData, String str, String str2) {
        LxAdDownAllMapData lxAdDownAllMapData;
        List<LxAdDownMdaData> list;
        LxAdDownMdaData lxAdDownMdaData = null;
        if (str2 == null || str == null) {
            return null;
        }
        if (this.lxAdAllDownData.containsKey(str) && (lxAdDownAllMapData = this.lxAdAllDownData.get(str)) != null && (list = lxAdDownAllMapData.downMdaDatas) != null && list.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= lxAdDownAllMapData.downMdaDatas.size()) {
                    break;
                }
                LxAdDownMdaData lxAdDownMdaData2 = lxAdDownAllMapData.downMdaDatas.get(i);
                if (str2.equals(lxAdDownMdaData2.onlyId)) {
                    LxAdLog.d("LXadDown DLManager findMdaDownData onlyId  " + str2 + " pkgName " + str);
                    lxAdDownMdaData = lxAdDownMdaData2;
                    break;
                }
                i++;
            }
        }
        if (lxAdDownMdaData != null) {
            return lxAdDownMdaData;
        }
        LxAdDownMdaData lxAdDownMdaData3 = new LxAdDownMdaData();
        JsonUtil jsonUtil = JsonUtil.INSTANCE;
        lxAdDownMdaData3.lxAdBeanData = (LxAdBeanData) jsonUtil.fromJson(jsonUtil.toJson(lxAdBeanData), LxAdBeanData.class);
        lxAdDownMdaData3.onlyId = str2;
        lxAdDownMdaData3.clickTime = System.currentTimeMillis();
        lxAdDownMdaData3.pkgName = str;
        return lxAdDownMdaData3;
    }

    public synchronized void finishDownProcessSp(String str, File file) {
        LxAdLog.d("LXadDown DLManager finishDownProcessSp  pkg " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        jSONObject.put(KEY_DOWN_PROCESS, 100);
                        jSONObject.put("status", STATUS_DOWNED);
                        if (file != null) {
                            jSONObject.put("filePath", file.getPath());
                        }
                        this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized int getDownNotificationId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        return new JSONObject(string).optInt(KEY_NOTIFICATION_ID, 0);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getDownProcess(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        return new JSONObject(string).optInt(KEY_DOWN_PROCESS, 10);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 10;
    }

    public synchronized int getDownStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        return new JSONObject(string).optInt("status");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return STATUS_NORMAL;
    }

    public synchronized String getDownUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        return new JSONObject(string).optString("pkgUrl");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public synchronized String getFilepathByPkg(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        return new JSONObject(string).optString("filePath");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void installAPK(File file) {
        boolean z;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT < 24) {
                intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
            } else {
                intent.setDataAndType(FileProvider.getUriForFile(this.mContext, AUTH_DOWN_FILE_PROVIDER, file), AdBaseConstants.MIME_APK);
                intent.addFlags(3);
            }
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        LxAdLog.d("installAPK file " + file.getPath() + " isSuccess " + z);
        if (z) {
            getInstance(this.mContext).checkPkgAddReceiver();
        }
    }

    public void installDownClickReceiver(String str, String str2) {
        if (str2 != null) {
            String filepathByPkg = getFilepathByPkg(str2);
            if (TextUtils.isEmpty(filepathByPkg)) {
                return;
            }
            startApkInstall(filepathByPkg, str2, str);
        }
    }

    public void onDestroy() {
        LxAdDownPkgAddReceiver lxAdDownPkgAddReceiver = this.pkgAddReceiver;
        if (lxAdDownPkgAddReceiver != null) {
            this.mContext.unregisterReceiver(lxAdDownPkgAddReceiver);
            this.pkgAddReceiver = null;
        }
        HashMap<String, LxAdDownAllMapData> map = this.lxAdAllDownData;
        if (map != null) {
            map.clear();
        }
    }

    public void onDownError(String str, String str2, int i, String str3, boolean z) {
        if (z) {
            this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.download.LxAdDLManager.3
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(LxAdManager.getAdManager().getContext(), "下载失败", 0).show();
                }
            });
        }
        if (str2 == null || !this.lxAdAllDownData.containsKey(str2)) {
            return;
        }
        LxAdDownAllMapData lxAdDownAllMapData = this.lxAdAllDownData.get(str2);
        if (lxAdDownAllMapData != null) {
            onDownErrorCancelNotificationUi(lxAdDownAllMapData.adSaveData);
            List<LxAdBaseView> list = lxAdDownAllMapData.adBaseViews;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < lxAdDownAllMapData.adBaseViews.size(); i2++) {
                    lxAdDownAllMapData.adBaseViews.get(i2).downListener.onError(i, str3, str2);
                }
            }
            List<LxAdDownMdaData> list2 = lxAdDownAllMapData.downMdaDatas;
            if (list2 != null && list2.size() > 0) {
                for (int i3 = 0; i3 < lxAdDownAllMapData.downMdaDatas.size(); i3++) {
                    reportAdError(lxAdDownAllMapData.downMdaDatas.get(i3), i, str3);
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = getDownUrl(str2);
        }
        deleteDownApp(str, str2);
    }

    public void onFinishDownAd(String str, String str2, File file) {
        LxAdDownAllMapData lxAdDownAllMapData;
        List<LxAdDownMdaData> list;
        finishDownProcessSp(str2, file);
        adDownLoadChange(str2, 0, "");
        if (str2 != null && this.lxAdAllDownData.containsKey(str2) && (lxAdDownAllMapData = this.lxAdAllDownData.get(str2)) != null && (list = lxAdDownAllMapData.downMdaDatas) != null && list.size() > 0) {
            for (int i = 0; i < lxAdDownAllMapData.downMdaDatas.size(); i++) {
                LxAdDownMdaData lxAdDownMdaData = lxAdDownAllMapData.downMdaDatas.get(i);
                reportDown0Done(lxAdDownMdaData);
                reportDown25Done(lxAdDownMdaData);
                reportDown50Done(lxAdDownMdaData);
                reportDown75Done(lxAdDownMdaData);
                reportDown100Done(lxAdDownMdaData);
            }
        }
        String filepathByPkg = getFilepathByPkg(str2);
        if (TextUtils.isEmpty(filepathByPkg)) {
            return;
        }
        startApkInstall(filepathByPkg, str2, str);
    }

    public void onResumeDl(String str) {
        resumeDownAdSp(str);
        adDownLoadChange(str, 0, "");
    }

    public void onStartDownAd(String str, String str2, int i, JSONObject jSONObject) {
        startDownAdSp(str, str2, i);
        if (jSONObject != null) {
            try {
                jSONObject.put(ITEM_APPSIZE, i);
            } catch (Exception unused) {
            }
        }
        showDownAdRemoteView(jSONObject, str2, str);
        adDownLoadChange(str, 0, "");
    }

    public void onStopDl(String str) {
        stopDownAdSp(str);
        adDownLoadChange(str, 0, "");
    }

    public synchronized void removeDownViewMap(LxAdBaseView lxAdBaseView) {
        LxAdDownAllMapData lxAdDownAllMapData;
        LxAdLog.d("LXadDown removeDownViewMap baseView " + lxAdBaseView);
        if (lxAdBaseView != null && !TextUtils.isEmpty(lxAdBaseView.getPkgName()) && this.lxAdAllDownData.containsKey(lxAdBaseView.getPkgName()) && (lxAdDownAllMapData = this.lxAdAllDownData.get(lxAdBaseView.getPkgName())) != null && lxAdDownAllMapData.adBaseViews.contains(lxAdBaseView)) {
            lxAdDownAllMapData.adBaseViews.remove(lxAdBaseView);
        }
    }

    public synchronized void resumeDownAdSp(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        jSONObject.put("status", STATUS_DOWNING);
                        this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void saveDownInstallenSpStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        jSONObject.put("status", STATUS_INSTALLED);
                        this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void saveNotificationId(String str, int i) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    jSONObject = !TextUtils.isEmpty(string) ? new JSONObject(string) : null;
                } else {
                    jSONObject = new JSONObject();
                }
                if (jSONObject != null) {
                    jSONObject.put(KEY_NOTIFICATION_ID, i);
                    this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void saveViewClickTime(long j, String str, String str2) {
        LxAdDownAllMapData lxAdDownAllMapData;
        List<LxAdDownMdaData> list;
        if (str == null || str2 == null || !this.lxAdAllDownData.containsKey(str2) || (lxAdDownAllMapData = this.lxAdAllDownData.get(str2)) == null || (list = lxAdDownAllMapData.downMdaDatas) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < lxAdDownAllMapData.downMdaDatas.size(); i++) {
            LxAdDownMdaData lxAdDownMdaData = lxAdDownAllMapData.downMdaDatas.get(i);
            if (str.equals(lxAdDownMdaData.onlyId)) {
                LxAdLog.d("LXadDown DLManager saveViewClickTime onlyId  " + str + " pkgName " + str2);
                lxAdDownMdaData.clickTime = j;
            }
        }
    }

    public void startApp(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (BLUtils.isAppInstalled(str2, this.mContext)) {
            try {
                Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(str2);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    this.mContext.startActivity(launchIntentForPackage);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        onDownError(str, str2, -10003, "apk not install", false);
        this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.download.LxAdDLManager.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(LxAdDLManager.this.mContext, "应用不存在，请重新下载", 0).show();
            }
        });
        LxAdLog.d("startApp error 应用不存在 pkg " + str2);
    }

    public void startDlAd(String str, String str2, JSONObject jSONObject) {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getMAdRequestCallBack() == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        wifiNestAd.getMAdRequestCallBack().startDlAd(str, downFilePath, str2, jSONObject);
    }

    public void startDownActDialog(LxAdBeanData lxAdBeanData, LxAdDownMdaData lxAdDownMdaData) {
        if (lxAdBeanData != null) {
            try {
                Intent intent = new Intent(this.mContext, (Class<?>) LxAdDownFullActivity.class);
                if (!(this.mContext instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                JSONObject jSONObjectCreateDialogJsonBeanByData = createDialogJsonBeanByData(lxAdBeanData);
                LxAdLog.d("LXadsplash down startDownActDialog obj " + jSONObjectCreateDialogJsonBeanByData);
                intent.putExtra(TAG_ITEM_ALL, jSONObjectCreateDialogJsonBeanByData.toString());
                LxAdDownFullActivity.mdaData = lxAdDownMdaData;
                this.mContext.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void startDownAdSp(String str, String str2, int i) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    jSONObject = !TextUtils.isEmpty(string) ? new JSONObject(string) : null;
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("startTime", System.currentTimeMillis());
                }
                if (jSONObject != null) {
                    jSONObject.put("status", STATUS_DOWNING);
                    jSONObject.put(KEY_ALL_BYTE, i);
                    LxAdLog.d("LXadDown DLManager 开始下载 startDownAdSp " + jSONObject.toString());
                    this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void startDownClick(int i, String str, String str2) {
        LxAdLog.d("LXadDown startDownClick pkgName " + str2 + " curDownStatus " + i);
        if (i == STATUS_DOWNING) {
            WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
            if (wifiNestAd.getMAdRequestCallBack() == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            wifiNestAd.getMAdRequestCallBack().stopDlAd(str, str2);
            return;
        }
        if (i == STATUS_PAUSE) {
            WifiNestAd wifiNestAd2 = WifiNestAd.INSTANCE;
            if (wifiNestAd2.getMAdRequestCallBack() == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            wifiNestAd2.getMAdRequestCallBack().resumeDlAd(str, str2);
            return;
        }
        if (i != STATUS_DOWNED) {
            if (i == STATUS_INSTALLED) {
                startApp(str, str2);
            }
        } else {
            String filepathByPkg = getFilepathByPkg(str2);
            if (TextUtils.isEmpty(filepathByPkg)) {
                return;
            }
            startApkInstall(filepathByPkg, str2, str);
        }
    }

    public LxAdDownDialog startDownDialog(Activity activity, LxAdBeanData lxAdBeanData, LxAdBaseView lxAdBaseView, LxAdDownMdaData lxAdDownMdaData) {
        if (activity == null || activity.isFinishing() || lxAdBeanData == null) {
            return null;
        }
        LxAdDownDialog lxAdDownDialog = new LxAdDownDialog(activity, createDialogJsonBeanByData(lxAdBeanData), lxAdBaseView, lxAdDownMdaData);
        lxAdDownDialog.show();
        return lxAdDownDialog;
    }

    public synchronized void stopDownAdSp(String str) {
        LxAdLog.d("LXadsplash DLManager stopDownAdSp pkg " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.sharedPreferences.contains(str)) {
                    String string = this.sharedPreferences.getString(str, "");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        jSONObject.put("status", STATUS_PAUSE);
                        this.sharedPreferences.edit().putString(str, jSONObject.toString()).apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void updateDownAdProcess(String str, int i) {
        LxAdDownAllMapData lxAdDownAllMapData;
        updateDownProcessUi(str, i);
        LxAdLog.d("LXadDown updateDownAdProcess  pkgName " + str + " process " + i);
        if (str == null || !this.lxAdAllDownData.containsKey(str) || (lxAdDownAllMapData = this.lxAdAllDownData.get(str)) == null) {
            return;
        }
        List<LxAdBaseView> list = lxAdDownAllMapData.adBaseViews;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < lxAdDownAllMapData.adBaseViews.size(); i2++) {
                lxAdDownAllMapData.adBaseViews.get(i2).downListener.onProgress(i, str);
            }
        }
        List<LxAdDownMdaData> list2 = lxAdDownAllMapData.downMdaDatas;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < lxAdDownAllMapData.downMdaDatas.size(); i3++) {
            LxAdDownMdaData lxAdDownMdaData = lxAdDownAllMapData.downMdaDatas.get(i3);
            if (i < 10) {
                reportDown0Done(lxAdDownMdaData);
            } else if (i >= 15 && i <= 35) {
                reportDown0Done(lxAdDownMdaData);
                reportDown25Done(lxAdDownMdaData);
            } else if (i >= 40 && i <= 60) {
                reportDown0Done(lxAdDownMdaData);
                reportDown25Done(lxAdDownMdaData);
                reportDown50Done(lxAdDownMdaData);
            } else if (i >= 65 && i <= 85) {
                reportDown0Done(lxAdDownMdaData);
                reportDown25Done(lxAdDownMdaData);
                reportDown50Done(lxAdDownMdaData);
                reportDown75Done(lxAdDownMdaData);
            }
        }
    }
}
