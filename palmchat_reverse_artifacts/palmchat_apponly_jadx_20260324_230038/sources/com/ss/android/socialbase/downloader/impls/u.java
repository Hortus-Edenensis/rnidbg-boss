package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.a.n;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class u implements n.u {
    private final SparseArray<DownloadTask> nr = new SparseArray<>();
    private final SparseArray<DownloadTask> fx = new SparseArray<>();
    private final SparseArray<DownloadTask> b = new SparseArray<>();
    private final SparseArray<DownloadTask> pn = new SparseArray<>();
    private final SparseArray<DownloadTask> iz = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> x = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.jk.n<Integer, DownloadTask> n = new com.ss.android.socialbase.downloader.jk.n<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Long> f10610a = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> jk = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.a.n u = new com.ss.android.socialbase.downloader.a.n(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.jk t = com.ss.android.socialbase.downloader.downloader.fx.kj();

    private void fx(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.jk.isEmpty()) {
                u(downloadTask, true);
                this.jk.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.jk.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && u(downloadTask.getDownloadId())) {
                    return;
                }
                pn(first.getDownloadId());
                u(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.jk.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.jk.getFirst().getDownloadId() == downloadTask.getDownloadId() && u(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.jk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.jk.put(downloadTask);
            new com.ss.android.socialbase.downloader.downloader.iz(downloadTask, this.u).u();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask k(int i) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.b.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.fx.get(i);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.pn.get(i);
        return downloadTask4 == null ? this.iz.get(i) : downloadTask4;
    }

    private void my(int i) {
        DownloadTask first;
        if (this.jk.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.jk.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.jk.poll();
        }
        if (this.jk.isEmpty() || (first = this.jk.getFirst()) == null) {
            return;
        }
        u(first, true);
    }

    public synchronized z a(int i) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.fx.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.b.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.pn.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.iz.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized DownloadInfo b(int i) {
        DownloadInfo downloadInfoNr;
        DownloadTask downloadTask;
        downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr == null && (downloadTask = this.nr.get(i)) != null) {
            downloadInfoNr = downloadTask.getDownloadInfo();
        }
        return downloadInfoNr;
    }

    public abstract com.ss.android.socialbase.downloader.a.fx fx(int i);

    public synchronized boolean iz(int i) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            u(downloadTask);
        } else {
            x(i);
        }
        return true;
    }

    public synchronized IDownloadFileUriProvider jk(int i) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.fx.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.b.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.pn.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.iz.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean l(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.iz.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            u(downloadTask);
        }
        return true;
    }

    public synchronized void mv(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            u(downloadTask);
        }
    }

    public synchronized ja n(int i) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.fx.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.b.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.pn.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.iz.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public abstract void nr(int i);

    public synchronized boolean pn(int i) {
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr != null && downloadInfoNr.getStatus() == 11) {
            return false;
        }
        synchronized (this.nr) {
            nr(i);
        }
        if (downloadInfoNr == null) {
            DownloadTask downloadTask = this.nr.get(i);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.iz(downloadTask, this.u).b();
                return true;
            }
        } else {
            u(downloadInfoNr);
            if (downloadInfoNr.getStatus() == 1) {
                DownloadTask downloadTask2 = this.nr.get(i);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.iz(downloadTask2, this.u).b();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoNr.getStatus())) {
                downloadInfoNr.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r1.b.get(r2) != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean s(int i) {
        if (i != 0) {
            if (this.nr.get(i) == null) {
            }
            return true;
        }
        return false;
    }

    public synchronized boolean t(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.pn.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                u(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr != null && downloadInfoNr.canStartRetryDelayTask()) {
            u(new DownloadTask(downloadInfoNr), false);
        }
        return false;
    }

    public abstract List<Integer> u();

    public abstract void u(int i, long j);

    public abstract void u(int i, DownloadTask downloadTask);

    public abstract void u(com.ss.android.socialbase.downloader.a.fx fxVar);

    public abstract boolean u(int i);

    public synchronized boolean x(int i) {
        DownloadTask downloadTask = this.b.get(i);
        if (downloadTask == null) {
            downloadTask = this.pn.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        u(downloadTask);
        return true;
    }

    private void nr(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.x.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.x.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void u(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTaskRemove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.jk.iz.fx(com.ss.android.socialbase.downloader.downloader.fx.oa()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.iz(downloadTask, this.u).u(new BaseException(FunDC.ID_AUTH_1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            u(downloadInfo);
        }
        if (this.b.get(id) != null) {
            this.b.remove(id);
        }
        if (this.fx.get(id) != null) {
            this.fx.remove(id);
        }
        if (this.pn.get(id) != null) {
            this.pn.remove(id);
        }
        if (this.iz.get(id) != null) {
            this.iz.remove(id);
        }
        if (u(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.u.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.jk.u.u(32768) && (downloadTaskRemove = this.n.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTaskRemove);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.nr.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        nr(downloadTask);
        this.nr.put(id, downloadTask);
        this.f10610a.put(id, Long.valueOf(jUptimeMillis));
        u(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i, boolean z) {
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoNr = this.t.nr(i);
            if (downloadInfoNr != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.jk.iz.u(downloadInfoNr);
                } else {
                    com.ss.android.socialbase.downloader.jk.iz.fx(downloadInfoNr.getTempPath(), downloadInfoNr.getTempName());
                }
                downloadInfoNr.erase();
            }
            try {
                this.t.iz(i);
            } catch (SQLiteException unused) {
            }
            u(i, 0, -4);
            if (this.b.get(i) != null) {
                this.b.remove(i);
            }
            if (this.fx.get(i) != null) {
                this.fx.remove(i);
            }
            this.n.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.n.u.nr(i);
        } catch (Throwable unused2) {
        }
    }

    public synchronized void nr(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.ss.android.socialbase.downloader.jk.iz.nr(com.ss.android.socialbase.downloader.downloader.fx.oa())) {
                for (int i = 0; i < this.nr.size(); i++) {
                    DownloadTask downloadTask = this.nr.get(this.nr.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && nr(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        u(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.sx reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.u(downloadInfo, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void fx(final int i, final boolean z) {
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr != null) {
            u(downloadInfoNr);
        }
        this.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.nr.u().iz(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.fx.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.5
            @Override // java.lang.Runnable
            public void run() {
                u.this.fx(i);
                u.this.pn(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn(int i, boolean z) {
        try {
            DownloadInfo downloadInfoNr = this.t.nr(i);
            if (downloadInfoNr != null) {
                com.ss.android.socialbase.downloader.jk.iz.u(downloadInfoNr, z);
                downloadInfoNr.erase();
            }
            try {
                this.t.b(i);
                this.t.u(downloadInfoNr);
            } catch (SQLiteException unused) {
            }
            if (this.b.get(i) != null) {
                this.b.remove(i);
            }
            if (this.fx.get(i) != null) {
                this.fx.remove(i);
            }
            this.n.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.n.u.nr(i);
        } catch (Throwable unused2) {
        }
    }

    private boolean nr(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void nr() {
        List<Integer> listU = u();
        if (listU == null) {
            return;
        }
        Iterator<Integer> it = listU.iterator();
        while (it.hasNext()) {
            pn(it.next().intValue());
        }
    }

    public void nr(final int i, final boolean z) {
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr != null) {
            u(downloadInfoNr);
        }
        this.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.nr.u().iz(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.fx.u(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskK;
                if (u.this.fx(i) == null && (downloadTaskK = u.this.k(i)) != null) {
                    DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskK.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                u.this.b(i, z);
            }
        }, false);
    }

    public synchronized void nr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        u(i, i2, iDownloadListener, izVar, z, true);
    }

    public List<DownloadInfo> nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = u().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoB = b(it.next().intValue());
            if (downloadInfoB != null && str.equals(downloadInfoB.getMimeType())) {
                arrayList.add(downloadInfoB);
            }
        }
        return arrayList;
    }

    public synchronized void u(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            fx(downloadTask);
        } else {
            u(downloadTask, true);
        }
    }

    public void nr(int i, long j) {
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setThrottleNetSpeed(j);
        }
        u(i, j);
    }

    public synchronized List<DownloadInfo> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listU = this.t.u(str);
        if (listU != null && !listU.isEmpty()) {
            return listU;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.nr.size();
        for (int i = 0; i < size; i++) {
            DownloadTask downloadTaskValueAt = this.nr.valueAt(i);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean u(int i, boolean z) {
        DownloadTask downloadTaskK = this.nr.get(i);
        if (downloadTaskK == null && com.ss.android.socialbase.downloader.jk.u.u(65536)) {
            downloadTaskK = k(i);
        }
        if (downloadTaskK != null) {
            if (!com.ss.android.socialbase.downloader.n.u.u(i).nr("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.iz(downloadTaskK, this.u).fx();
            }
            final DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskK.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskK.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION);
            this.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoNr = this.t.nr(i);
        if (com.ss.android.socialbase.downloader.jk.u.u(65536)) {
            if (downloadInfoNr != null) {
                downloadInfoNr.setStatus(-4);
            }
        } else if (downloadInfoNr != null && DownloadStatus.isDownloading(downloadInfoNr.getStatus())) {
            downloadInfoNr.setStatus(-4);
        }
        nr(i, z);
        return true;
    }

    private void u(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.x.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.x.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void u(int i, z zVar) {
        DownloadTask downloadTask = this.nr.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(zVar);
        }
    }

    public synchronized void u(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zNr = com.ss.android.socialbase.downloader.jk.u.u(1048576) ? com.ss.android.socialbase.downloader.jk.iz.nr(com.ss.android.socialbase.downloader.downloader.fx.oa()) : true;
            for (int i = 0; i < this.b.size(); i++) {
                DownloadTask downloadTask = this.b.get(this.b.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zNr)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    u(downloadTask);
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        DownloadTask downloadTaskK = k(i);
        if (downloadTaskK == null) {
            downloadTaskK = this.n.get(Integer.valueOf(i));
        }
        if (downloadTaskK != null) {
            downloadTaskK.removeDownloadListener(i2, iDownloadListener, izVar, z);
        }
    }

    public synchronized void u(int i, int i2, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoNr;
        DownloadTask downloadTaskK = k(i);
        if (downloadTaskK != null) {
            downloadTaskK.addDownloadListener(i2, iDownloadListener, izVar, z);
            final DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
            if (z2 && downloadInfo != null && !u(i) && (izVar == com.ss.android.socialbase.downloader.constants.iz.MAIN || izVar == com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION)) {
                if (izVar != com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION || downloadInfo.canShowNotification()) {
                    this.u.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
            return;
        }
        if (com.ss.android.socialbase.downloader.jk.u.u(32768) && (downloadInfoNr = this.t.nr(i)) != null && downloadInfoNr.getStatus() != -3) {
            DownloadTask downloadTask = this.n.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoNr);
                this.n.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, izVar, z);
        }
    }

    private void u(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.jk.fx.u(i, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.jk.fx.u(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void u(int i, int i2) {
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.nr.remove(i);
            this.x.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.x.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.nr.remove(i);
                this.x.remove(i);
                return;
            }
            return;
        }
        this.nr.remove(i);
    }

    public synchronized void u(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 != -6) {
                if (i3 == -4) {
                    u(i, i2);
                } else if (i3 == -3) {
                    this.fx.put(i, this.nr.get(i));
                    u(i, i2);
                } else if (i3 != -1) {
                    if (i3 != 7) {
                        if (i3 == 8) {
                            DownloadTask downloadTask = this.nr.get(i);
                            if (downloadTask != null && this.iz.get(i) == null) {
                                this.iz.put(i, downloadTask);
                            }
                        }
                        return;
                    }
                    DownloadTask downloadTask2 = this.nr.get(i);
                    if (downloadTask2 != null) {
                        if (this.pn.get(i) == null) {
                            this.pn.put(i, downloadTask2);
                        }
                        u(i, i2);
                    }
                    my(i);
                    return;
                }
                my(i);
                return;
            }
            this.fx.put(i, this.nr.get(i));
            u(i, i2);
            return;
        }
        DownloadTask downloadTask3 = this.nr.get(i);
        if (downloadTask3 != null) {
            if (this.b.get(i) == null) {
                this.b.put(i, downloadTask3);
            }
            u(i, i2);
        }
        my(i);
    }

    @Override // com.ss.android.socialbase.downloader.a.n.u
    public void u(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.fx.u.nr("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.nr.get(i);
            } else {
                SparseArray<DownloadTask> sparseArray = this.x.get(i);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i2);
                }
            }
            if (downloadTask == null) {
                return;
            }
            u(message.what, baseException, downloadTask);
            u(i, i2, message.what);
        }
    }
}
