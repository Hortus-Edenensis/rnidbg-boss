package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class u implements k {
    private static final String pn = "u";
    protected volatile boolean fx;
    private WeakReference<Service> iz;
    protected final SparseArray<List<DownloadTask>> u = new SparseArray<>();
    protected volatile boolean nr = false;
    protected volatile boolean b = false;
    private Handler x = new Handler(Looper.getMainLooper());
    private Runnable n = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.u.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr(u.pn, "tryDownload: 2 try");
            }
            if (u.this.nr) {
                return;
            }
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr(u.pn, "tryDownload: 2 error");
            }
            u.this.startService(fx.oa(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        this.nr = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void fx() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean nr() {
        com.ss.android.socialbase.downloader.fx.u.fx(pn, "isServiceForeground = " + this.fx);
        return this.fx;
    }

    public void pn() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.u) {
            com.ss.android.socialbase.downloader.fx.u.nr(pn, "resumePendingTask pendingTasks.size:" + this.u.size());
            sparseArrayClone = this.u.clone();
            this.u.clear();
        }
        com.ss.android.socialbase.downloader.impls.u uVarRh = fx.rh();
        if (uVarRh != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.fx.u.nr(pn, "resumePendingTask key:" + downloadTask.getDownloadId());
                        uVarRh.u(downloadTask);
                    }
                }
            }
        }
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void fx(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void startService() {
        if (this.nr) {
            return;
        }
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(pn, "startService");
        }
        startService(fx.oa(), null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(s sVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void nr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.nr) {
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr(pn, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.jk.u.u(262144)) {
                u(downloadTask);
                if (!this.b) {
                    if (com.ss.android.socialbase.downloader.fx.u.u()) {
                        com.ss.android.socialbase.downloader.fx.u.nr(pn, "tryDownload: 1");
                    }
                    startService(fx.oa(), null);
                    this.b = true;
                    return;
                }
                this.x.removeCallbacks(this.n);
                this.x.postDelayed(this.n, 10L);
                return;
            }
            u(downloadTask);
            startService(fx.oa(), null);
            return;
        }
        String str = pn;
        com.ss.android.socialbase.downloader.fx.u.nr(str, "tryDownload when isServiceAlive");
        pn();
        com.ss.android.socialbase.downloader.impls.u uVarRh = fx.rh();
        if (uVarRh != null) {
            com.ss.android.socialbase.downloader.fx.u.nr(str, "tryDownload current task: " + downloadTask.getDownloadId());
            uVarRh.u(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(WeakReference weakReference) {
        this.iz = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean u() {
        return this.nr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public IBinder u(Intent intent) {
        com.ss.android.socialbase.downloader.fx.u.nr(pn, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(int i, Notification notification) {
        WeakReference<Service> weakReference = this.iz;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.fx.u.fx(pn, "startForeground  id = " + i + ", service = " + this.iz.get() + ",  isServiceAlive = " + this.nr);
            try {
                this.iz.get().startForeground(i, notification);
                this.fx = true;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.ss.android.socialbase.downloader.fx.u.b(pn, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(boolean z) {
        WeakReference<Service> weakReference = this.iz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.fx(pn, "stopForeground  service = " + this.iz.get() + ",  isServiceAlive = " + this.nr);
        try {
            this.fx = false;
            this.iz.get().stopForeground(z);
        } catch (Exception unused) {
        }
    }

    public void u(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.u) {
            String str = pn;
            com.ss.android.socialbase.downloader.fx.u.nr(str, "pendDownloadTask pendingTasks.size:" + this.u.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.u.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.u.put(downloadId, arrayList);
            }
            com.ss.android.socialbase.downloader.fx.u.nr(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.ss.android.socialbase.downloader.fx.u.nr(str, "after pendDownloadTask pendingTasks.size:" + this.u.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void u(int i) {
        com.ss.android.socialbase.downloader.fx.u.u(i);
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }
}
