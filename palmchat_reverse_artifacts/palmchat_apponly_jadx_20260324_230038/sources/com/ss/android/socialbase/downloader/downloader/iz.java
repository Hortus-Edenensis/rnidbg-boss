package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.pb;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private static final String u = "iz";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<IDownloadListener> f10606a;
    private final jk b;
    private DownloadInfo fx;
    private DownloadTask iz;
    private long k;
    private com.ss.android.socialbase.downloader.depend.s my;
    private SparseArray<IDownloadListener> n;
    private final boolean nr;
    private qq o;
    private final Handler pn;
    private int s;
    private SparseArray<IDownloadListener> x;
    private boolean jk = false;
    private volatile long t = 0;
    private final AtomicLong l = new AtomicLong();
    private boolean mv = false;

    public iz(DownloadTask downloadTask, Handler handler) {
        this.iz = downloadTask;
        jk();
        this.pn = handler;
        this.b = fx.kj();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.nr = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("fix_start_with_file_exist_update_error");
        } else {
            this.nr = false;
        }
    }

    private void jk() {
        DownloadTask downloadTask = this.iz;
        if (downloadTask != null) {
            this.fx = downloadTask.getDownloadInfo();
            this.x = this.iz.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.MAIN);
            this.f10606a = this.iz.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION);
            this.n = this.iz.getDownloadListeners(com.ss.android.socialbase.downloader.constants.iz.SUB);
            this.my = this.iz.getDepend();
            this.o = this.iz.getMonitorDepend();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "saveFileAsTargetName onSuccess");
            try {
                mv();
                this.fx.setFirstSuccess(false);
                this.fx.setSuccessByCache(false);
                u(-3, (BaseException) null);
                this.b.fx(this.fx.getId(), this.fx.getTotalBytes());
                this.b.b(this.fx.getId());
                this.b.mv(this.fx.getId());
            } catch (BaseException e) {
                u(e);
            }
        } catch (Throwable th) {
            u(new BaseException(1008, com.ss.android.socialbase.downloader.jk.iz.nr(th, "onCompleted")));
        }
    }

    private void mv() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.mv> downloadCompleteHandlers = this.iz.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.fx;
        u(11, (BaseException) null);
        this.b.u(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.mv mvVar : downloadCompleteHandlers) {
            try {
                if (mvVar.nr(downloadInfo)) {
                    mvVar.u(downloadInfo);
                    this.b.u(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(FunDC.ID_AUTH_1071, th);
            }
        }
    }

    private void t() {
        ExecutorService executorServiceL = fx.l();
        if (executorServiceL != null) {
            executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    iz.this.b.a(iz.this.fx.getId());
                    iz.this.u(1, (BaseException) null);
                }
            });
        }
    }

    public void b() {
        this.fx.setStatus(-2);
        try {
            this.b.b(this.fx.getId(), this.fx.getCurBytes());
        } catch (SQLiteException unused) {
        }
        u(-2, (BaseException) null);
    }

    public void iz() {
        this.fx.setFirstDownload(false);
        if (!this.fx.isIgnoreDataVerify() && this.fx.getCurBytes() != this.fx.getTotalBytes()) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, this.fx.getErrorBytesLog());
            u(new com.ss.android.socialbase.downloader.exception.iz(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.fx.getByteInvalidRetryStatus()));
            return;
        }
        if (this.fx.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, this.fx.getErrorBytesLog());
            u(new com.ss.android.socialbase.downloader.exception.iz(1026, "curBytes is 0, bytes changed with process : " + this.fx.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.fx.isIgnoreDataVerify() && this.fx.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, this.fx.getErrorBytesLog());
            u(new com.ss.android.socialbase.downloader.exception.iz(FunDC.ID_AUTH_1044, "TotalBytes is 0, bytes changed with process : " + this.fx.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.nr(u, this.fx.getName() + " onCompleted start save file as target name");
        qq monitorDepend = this.o;
        DownloadTask downloadTask = this.iz;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.jk.iz.u(this.fx, monitorDepend, new pb() { // from class: com.ss.android.socialbase.downloader.downloader.iz.2
            @Override // com.ss.android.socialbase.downloader.depend.pb
            public void u() {
                iz.this.l();
            }

            @Override // com.ss.android.socialbase.downloader.depend.pb
            public void u(BaseException baseException) {
                String str = iz.u;
                StringBuilder sb = new StringBuilder("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.fx.u.nr(str, sb.toString());
                iz.this.u(baseException);
            }
        });
    }

    public void n() {
        this.fx.setStatus(8);
        this.fx.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.u.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.u uVarRh = fx.rh();
        if (uVarRh != null) {
            uVarRh.u(this.fx.getId(), this.iz.getHashCodeForSameTask(), 8);
        }
    }

    public void pn() {
        this.fx.setStatus(-7);
        try {
            this.b.jk(this.fx.getId());
        } catch (SQLiteException unused) {
        }
        u(-7, (BaseException) null);
    }

    public void x() throws BaseException {
        if (!this.nr) {
            mv();
            com.ss.android.socialbase.downloader.fx.u.nr(u, "onCompleteForFileExist");
            this.fx.setSuccessByCache(true);
            u(-3, (BaseException) null);
            this.b.fx(this.fx.getId(), this.fx.getTotalBytes());
            this.b.b(this.fx.getId());
            this.b.mv(this.fx.getId());
            return;
        }
        mv();
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onCompleteForFileExist");
        this.fx.setSuccessByCache(true);
        u(-3, (BaseException) null);
        this.b.fx(this.fx.getId(), this.fx.getTotalBytes());
        this.b.b(this.fx.getId());
        this.b.u(this.fx);
        this.b.mv(this.fx.getId());
    }

    public void fx() {
        u(-4, (BaseException) null);
    }

    public void nr() {
        if (this.fx.canSkipStatusHandler()) {
            this.fx.changeSkipStatus();
            return;
        }
        this.b.x(this.fx.getId());
        if (this.fx.isFirstDownload()) {
            u(6, (BaseException) null);
        }
        u(2, (BaseException) null);
    }

    private BaseException fx(BaseException baseException) {
        Context contextOa;
        if (com.ss.android.socialbase.downloader.n.u.u(this.fx.getId()).u("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.jk.iz.a(baseException) || (contextOa = fx.oa()) == null || com.ss.android.socialbase.downloader.jk.iz.fx(contextOa)) {
            return baseException;
        }
        return new BaseException(this.fx.isOnlyWifi() ? 1013 : FunDC.ID_AUTH_1049, baseException.getErrorMessage());
    }

    public void u() {
        if (this.fx.canSkipStatusHandler()) {
            return;
        }
        this.fx.setStatus(1);
        t();
    }

    public void u(long j, String str, String str2) {
        this.fx.setTotalBytes(j);
        this.fx.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.fx.getName())) {
            this.fx.setName(str2);
        }
        try {
            this.b.u(this.fx.getId(), j, str, str2);
        } catch (Exception unused) {
        }
        u(3, (BaseException) null);
        this.k = this.fx.getMinByteIntervalForPostToMainThread(j);
        this.s = this.fx.getMinProgressTimeMsInterval();
        this.jk = true;
        com.ss.android.socialbase.downloader.impls.sx.u().pn();
    }

    private void nr(BaseException baseException) {
        Log.getStackTraceString(new Throwable());
        try {
            if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
                this.b.iz(this.fx.getId());
            } else {
                try {
                    this.b.nr(this.fx.getId(), this.fx.getCurBytes());
                } catch (SQLiteException unused) {
                    this.b.iz(this.fx.getId());
                }
            }
        } catch (SQLiteException unused2) {
        }
        BaseException baseExceptionFx = fx(baseException);
        this.fx.setFailedException(baseExceptionFx);
        u(baseExceptionFx instanceof com.ss.android.socialbase.downloader.exception.pn ? -2 : -1, baseExceptionFx);
        if (com.ss.android.socialbase.downloader.n.u.u(this.fx.getId()).u("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.sx.u().u(this.fx);
        }
    }

    public boolean u(long j) {
        this.l.addAndGet(j);
        this.fx.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return u(jUptimeMillis, nr(jUptimeMillis));
    }

    private boolean nr(long j) {
        boolean z = true;
        if (!this.mv) {
            this.mv = true;
            return true;
        }
        long j2 = j - this.t;
        if (this.l.get() < this.k && j2 < this.s) {
            z = false;
        }
        if (z) {
            this.t = j;
            this.l.set(0L);
        }
        return z;
    }

    public void u(BaseException baseException, boolean z) {
        this.fx.setFirstDownload(false);
        this.l.set(0L);
        nr(baseException, z);
    }

    public void u(com.ss.android.socialbase.downloader.model.nr nrVar, BaseException baseException, boolean z) {
        this.fx.setFirstDownload(false);
        this.l.set(0L);
        this.b.n(this.fx.getId());
        u(z ? 10 : 9, baseException, true);
    }

    private void nr(BaseException baseException, boolean z) {
        this.b.n(this.fx.getId());
        u(z ? 7 : 5, baseException);
    }

    public void u(BaseException baseException) {
        this.fx.setFirstDownload(false);
        nr(baseException);
    }

    public void u(String str) throws BaseException {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.fx.getName());
        if (this.nr) {
            com.ss.android.socialbase.downloader.jk.iz.u(this.fx, str);
            mv();
            this.fx.setSuccessByCache(true);
            u(-3, (BaseException) null);
            this.b.u(this.fx);
            return;
        }
        this.b.u(this.fx);
        com.ss.android.socialbase.downloader.jk.iz.u(this.fx, str);
        this.fx.setSuccessByCache(true);
        mv();
        u(-3, (BaseException) null);
    }

    private boolean u(long j, boolean z) {
        boolean z2 = false;
        if (this.fx.getCurBytes() == this.fx.getTotalBytes()) {
            try {
                this.b.u(this.fx.getId(), this.fx.getCurBytes());
            } catch (Exception unused) {
            }
            return false;
        }
        if (this.jk) {
            this.jk = false;
            this.fx.setStatus(4);
        }
        if (this.fx.isNeedPostProgress() && z) {
            z2 = true;
        }
        u(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, BaseException baseException) {
        u(i, baseException, true);
    }

    private void u(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.fx.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        jk();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.fx.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.fx.updateDownloadTime();
            }
        }
        if (!this.fx.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.b.u.u(this.iz, baseException, i);
        }
        if (i == 6) {
            this.fx.setStatus(2);
        } else if (i == -6) {
            this.fx.setStatus(-3);
        } else {
            this.fx.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.fx.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.x.DELAY_RETRY_DOWNLOADING) {
                this.fx.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.x.DELAY_RETRY_DOWNLOADED);
            }
            if (this.fx.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.u.ASYNC_HANDLE_DOWNLOADING) {
                this.fx.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.u.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.fx.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.nr.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.fx.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.nr.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.jk.fx.u(i, this.n, true, this.fx, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.pn != null && (((sparseArray = this.x) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f10606a) != null && sparseArray2.size() > 0 && (this.fx.canShowNotification() || this.fx.isAutoInstallWithoutNotification())))) {
            this.pn.obtainMessage(i, this.fx.getId(), this.iz.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.u uVarRh = fx.rh();
        if (uVarRh != null) {
            uVarRh.u(this.fx.getId(), this.iz.getHashCodeForSameTask(), i);
        }
    }
}
