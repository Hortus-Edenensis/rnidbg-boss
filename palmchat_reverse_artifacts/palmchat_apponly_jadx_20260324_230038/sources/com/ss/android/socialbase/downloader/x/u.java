package com.ss.android.socialbase.downloader.x;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.a.x;
import com.ss.android.socialbase.downloader.constants.pn;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static volatile u x;
    private volatile x b;
    private volatile long nr;
    private volatile long u;
    private long fx = 1000;
    private final SparseArray<Notification> pn = new SparseArray<>(2);
    private AtomicBoolean iz = new AtomicBoolean(false);

    public void nr() {
        if (this.iz.compareAndSet(false, true)) {
            this.b = new x("DownloaderNotifyThread");
            this.b.u();
            long jU = com.ss.android.socialbase.downloader.n.u.fx().u("notification_time_window", 1000L);
            this.fx = jU;
            if (jU < 0 || jU > 1200) {
                this.fx = 1000L;
            }
        }
    }

    public static u u() {
        if (x == null) {
            synchronized (u.class) {
                if (x == null) {
                    x = new u();
                }
            }
        }
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context contextOa = fx.oa();
        if (contextOa == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextOa.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    u(notificationManager, intExtra, notification);
                    return;
                } else {
                    u(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (Downloader.getInstance(fx.oa()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(fx.oa()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.nr > this.fx) {
                nr(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                nr(notificationManager, intExtra);
                return;
            }
            return;
        }
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
            try {
                if (iz.u(contextOa, g.b) && (connectivityManager = (ConnectivityManager) contextOa.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(pn.u)) {
                        arrayList.add(pn.u);
                    }
                    arrayList.add("mime_type_plg");
                    Downloader.getInstance(contextOa).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(contextOa).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(fx.oa()).pauseAll();
            } catch (Exception unused2) {
            }
        }
    }

    public void u(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        nr();
        if (this.b == null) {
            return;
        }
        this.b.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.x.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.nr(intent);
            }
        });
    }

    private void u(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.pn) {
            int iIndexOfKey = this.pn.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.pn.size()) {
                this.pn.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.fx - (System.currentTimeMillis() - this.u);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.nr = jCurrentTimeMillis2;
            this.u = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                nr(notificationManager, i, notification);
            } else if (this.b != null) {
                synchronized (this.pn) {
                    this.pn.put(i, notification);
                }
                this.b.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.x.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.u(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.pn) {
            notification = this.pn.get(i);
            this.pn.remove(i);
        }
        if (notification != null) {
            nr(notificationManager, i, notification);
        }
    }

    private void nr(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.u < jCurrentTimeMillis) {
                this.u = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void nr(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
