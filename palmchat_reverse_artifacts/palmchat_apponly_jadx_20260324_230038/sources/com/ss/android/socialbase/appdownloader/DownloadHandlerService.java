package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadHandlerService extends Service {
    private static final String u = "DownloadHandlerService";

    private void fx(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.fx.pn pnVar, z zVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.nr.u().u(id);
        downloadInfo.updateDownloadTime();
        if (pnVar != null) {
            pnVar.u(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.u(7, downloadInfo, "", "");
        }
    }

    private void nr(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.fx.pn pnVar, z zVar) {
        boolean zU;
        int id = downloadInfo.getId();
        ja jaVarMv = com.ss.android.socialbase.downloader.downloader.b.u().mv(id);
        if (jaVarMv != null) {
            try {
                zU = jaVarMv.u(downloadInfo);
            } catch (Throwable unused) {
                zU = false;
            }
        } else {
            zU = false;
        }
        if (zU) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.nr.u().u(id);
        downloadInfo.updateDownloadTime();
        if (pnVar != null) {
            pnVar.u(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.u(7, downloadInfo, "", "");
        }
    }

    private boolean u(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.fx.pn pnVarFx = b.t().fx();
        z downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.n.u.u(intExtra).nr("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.nr.u().iz(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            nr(context, downloadInfo, pnVarFx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            u(context, downloadInfo, pnVarFx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            u(context, downloadInfo, pnVarFx, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.n.u.u(intExtra).u("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.n.u.u(intExtra).nr("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.nr.u().u(intExtra);
                    com.ss.android.socialbase.downloader.notification.nr.u().iz(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            fx(context, downloadInfo, pnVarFx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.nr.u().u(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.fx.u(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "onStartCommand");
        }
        u(com.ss.android.socialbase.downloader.downloader.fx.oa(), intent);
        stopSelf();
        return 2;
    }

    private static void u(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.jk.iz.nr(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void u(Context context, final com.ss.android.socialbase.appdownloader.fx.pn pnVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (pnVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfoU;
                try {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        String str = (com.ss.android.socialbase.downloader.downloader.fx.oa() == null || (packageInfoU = fx.u(downloadInfo, file)) == null) ? "" : packageInfoU.packageName;
                        com.ss.android.socialbase.appdownloader.fx.pn pnVar2 = pnVar;
                        if (pnVar2 != null) {
                            pnVar2.u(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                        }
                        z zVar = downloadNotificationEventListener;
                        if (zVar != null) {
                            zVar.u(3, downloadInfo, str, "");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void u(Context context, int i, boolean z) {
        boolean zNr;
        ja jaVarMv;
        if (!z || (jaVarMv = com.ss.android.socialbase.downloader.downloader.b.u().mv(i)) == null) {
            zNr = false;
        } else {
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo != null) {
                    zNr = jaVarMv.nr(downloadInfo);
                }
            } catch (Throwable unused) {
            }
        }
        if (!zNr && fx.u(context, i, true) == 0) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    public static void u(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.fx.pn pnVar, z zVar) {
        com.ss.android.socialbase.downloader.notification.u uVarPn;
        int id = downloadInfo.getId();
        ja jaVarMv = com.ss.android.socialbase.downloader.downloader.b.u().mv(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && jaVarMv != null && fx.u(context, downloadInfo) && jaVarMv.fx(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.n.u.u(id).nr("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                u(com.ss.android.socialbase.downloader.downloader.fx.oa(), id, true);
                u(context, pnVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.n.u.u(id).u("notification_click_install_auto_cancel", 1) != 0 || (uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(id)) == null) {
                    z = true;
                } else {
                    uVarPn.x();
                    uVarPn.u(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.nr.u().u(id);
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.b.u().pn(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    fx.u(downloadInfo, true, false);
                }
                if (pnVar != null) {
                    pnVar.u(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.u(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                u(context, downloadInfo);
                if (pnVar != null) {
                    pnVar.u(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.u(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
