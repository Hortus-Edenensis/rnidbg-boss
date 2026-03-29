package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.a.x;
import com.ss.android.socialbase.downloader.constants.pn;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.downloader.mv;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadNotificationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f10623a = 900;
    private static boolean b = true;
    private static int fx = -1;
    private static volatile long iz = 0;
    private static boolean n = false;
    private static int nr = -1;
    private static boolean pn = false;
    private static final String u = "DownloadNotificationService";
    private static volatile long x;
    private x jk;
    private final SparseArray<Notification> t = new SparseArray<>(2);

    private void b() {
        if (this.jk == null) {
            x xVar = new x("DownloaderNotifyThread");
            this.jk = xVar;
            xVar.u();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
        fx.u(this);
        com.ss.android.socialbase.downloader.n.u uVarFx = com.ss.android.socialbase.downloader.n.u.fx();
        int iU = uVarFx.u("download_service_foreground", 0);
        if ((iU == 1 || iU == 3) && nr == -1) {
            nr = 0;
        }
        if ((iU == 2 || iU == 3) && fx == -1) {
            fx = 0;
        }
        pn = uVarFx.nr("non_going_notification_foreground", false);
        n = uVarFx.nr("notify_too_fast", false);
        long jU = uVarFx.u("notification_time_window", 900L);
        f10623a = jU;
        if (jU < 0 || jU > 1200) {
            f10623a = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        x xVar = this.jk;
        if (xVar != null) {
            try {
                xVar.nr();
            } catch (Throwable unused) {
            }
            this.jk = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        u(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(NotificationManager notificationManager, int i, Notification notification) {
        if (u(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = b.u().u(i) == 1 && !iz.fx();
                if ((!z2 && nr == 0) || (z2 && fx == 0)) {
                    z = true;
                }
                if (z) {
                    mv mvVarFx = b.u().fx(i);
                    if (mvVarFx.x() && !mvVarFx.nr()) {
                        com.ss.android.socialbase.downloader.fx.u.fx(u, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            fx = i;
                        } else {
                            nr = i;
                        }
                        mvVarFx.u(i, notification);
                    } else {
                        com.ss.android.socialbase.downloader.fx.u.fx(u, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable unused) {
            }
        } else if ((nr == i || fx == i) && pn && (notification.flags & 2) == 0) {
            nr(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (iz < jCurrentTimeMillis) {
                iz = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused2) {
        }
    }

    private void u(final Intent intent) {
        x xVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (xVar = this.jk) == null) {
            return;
        }
        xVar.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.nr(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (iz.u((Context) DownloadNotificationService.this, g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(pn.u)) {
                                arrayList.add(pn.u);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.n) {
                            DownloadNotificationService.this.u(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.nr(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.n) {
                        DownloadNotificationService.this.u(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.jk != null) {
                            DownloadNotificationService.this.jk.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.nr(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(fx.oa()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(fx.oa()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.n) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.nr(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.x <= DownloadNotificationService.f10623a) {
                        return;
                    }
                    DownloadNotificationService.this.nr(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.t) {
            int iIndexOfKey = this.t.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.t.size()) {
                this.t.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = f10623a - (System.currentTimeMillis() - iz);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            x = jCurrentTimeMillis2;
            iz = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                nr(notificationManager, i, notification);
            } else if (this.jk != null) {
                synchronized (this.t) {
                    this.t.put(i, notification);
                }
                this.jk.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.u(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(NotificationManager notificationManager, int i) {
        boolean z;
        u uVarValueAt;
        int iU;
        int i2 = nr;
        if (i2 != i && fx != i) {
            try {
                notificationManager.cancel(i);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i2 == i) {
            nr = 0;
            z = false;
        } else {
            fx = 0;
            z = true;
        }
        try {
            mv mvVarFx = b.u().fx(i);
            if (!mvVarFx.nr()) {
                b = false;
                com.ss.android.socialbase.downloader.fx.u.b(u, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.fx.u.fx(u, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
            mvVarFx.u(false, true);
        } catch (Throwable unused2) {
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused3) {
        }
        if (b) {
            try {
                SparseArray<u> sparseArrayNr = nr.u().nr();
                if (sparseArrayNr != null) {
                    for (int size = sparseArrayNr.size() - 1; size >= 0; size--) {
                        uVarValueAt = sparseArrayNr.valueAt(size);
                        if (uVarValueAt != null && (iU = uVarValueAt.u()) != i && iU != nr && iU != fx && uVarValueAt.n()) {
                            if ((b.u().u(uVarValueAt.u()) == 1 && !iz.fx()) == z) {
                                break;
                            }
                        }
                    }
                    uVarValueAt = null;
                } else {
                    uVarValueAt = null;
                }
                if (uVarValueAt != null) {
                    int iU2 = uVarValueAt.u();
                    try {
                        notificationManager.cancel(iU2);
                    } catch (Throwable unused4) {
                    }
                    if (Downloader.getInstance(this).getStatus(iU2) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.fx.u.fx(u, "doCancel, updateNotification id = ".concat(String.valueOf(iU2)));
                    uVarValueAt.u((BaseException) null, z2);
                }
            } catch (Throwable unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.t) {
            notification = this.t.get(i);
            this.t.remove(i);
        }
        if (notification != null) {
            nr(notificationManager, i, notification);
        }
    }

    private boolean u(int i, Notification notification) {
        int i2;
        int i3;
        if (!b || (i2 = nr) == i || (i3 = fx) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (pn && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }
}
