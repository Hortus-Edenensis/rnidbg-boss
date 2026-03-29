package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static volatile nr fx;
    private static final Object pn = new Object();
    private final long u = 1000;
    private final Map<Integer, Long> nr = new HashMap();
    private final Set<String> b = new HashSet();
    private final SparseArray<u> iz = new SparseArray<>();

    private nr() {
    }

    public static boolean fx(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && nr(downloadInfo.getNotificationVisibility());
    }

    public static boolean nr(int i) {
        return i == 1 || i == 3;
    }

    public static nr u() {
        if (fx == null) {
            synchronized (nr.class) {
                if (fx == null) {
                    fx = new nr();
                }
            }
        }
        return fx;
    }

    public u b(int i) {
        u uVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.iz) {
            uVar = this.iz.get(i);
            if (uVar != null) {
                this.iz.remove(i);
                com.ss.android.socialbase.downloader.fx.u.u("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return uVar;
    }

    public void iz(int i) {
        b(i);
        if (i != 0) {
            u().fx(i);
        }
    }

    public u pn(int i) {
        u uVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.iz) {
            uVar = this.iz.get(i);
        }
        return uVar;
    }

    public void fx(int i) {
        Context contextOa = fx.oa();
        if (contextOa == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextOa, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.x.u.u().u(intent);
            } else {
                contextOa.startService(intent);
            }
        } catch (Throwable unused) {
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.x.u.u().u(intent);
            }
        }
    }

    public void nr(DownloadInfo downloadInfo) {
        if (fx(downloadInfo)) {
            iz(downloadInfo.getId());
        }
    }

    public SparseArray<u> nr() {
        SparseArray<u> sparseArray;
        synchronized (this.iz) {
            sparseArray = this.iz;
        }
        return sparseArray;
    }

    public void u(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(fx.oa()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        u(downloadInfo);
        nr(downloadInfo);
    }

    public void u(DownloadInfo downloadInfo) {
        jk jkVarKj = fx.kj();
        if (jkVarKj != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                jkVarKj.u(downloadInfo);
            } catch (SQLiteException unused) {
            }
        }
    }

    public void u(int i, int i2, Notification notification) {
        Context contextOa = fx.oa();
        if (contextOa == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.nr) {
                Long l = this.nr.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.nr.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextOa, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.x.u.u().u(intent);
            } else {
                contextOa.startService(intent);
            }
        } catch (Throwable unused) {
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.x.u.u().u(intent);
            }
        }
    }

    public void u(u uVar) {
        if (uVar == null) {
            return;
        }
        synchronized (this.iz) {
            this.iz.put(uVar.u(), uVar);
        }
    }
}
