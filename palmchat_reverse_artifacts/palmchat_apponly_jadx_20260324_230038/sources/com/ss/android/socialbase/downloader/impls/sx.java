package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class sx implements Handler.Callback, u.InterfaceC0886u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static nr f10608a;
    private static volatile sx u;
    private long iz;
    private ConnectivityManager n;
    private final boolean pn;
    private final Handler fx = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<u> b = new SparseArray<>();
    private int x = 0;
    private final Context nr = com.ss.android.socialbase.downloader.downloader.fx.oa();

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10609a;
        final int b;
        final int fx;
        final boolean iz;
        private boolean jk;
        private boolean l;
        private int n;
        final int nr;
        final int pn;
        private long t;
        final int u;
        final int[] x;

        public u(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.u = i;
            this.nr = i2;
            this.fx = i3;
            this.b = i4;
            this.pn = i5;
            this.iz = z;
            this.x = iArr;
            this.n = i4;
        }

        public int b() {
            return this.n;
        }

        public void fx() {
            this.n = this.b;
        }

        public synchronized void nr() {
            this.f10609a++;
        }

        public boolean u(long j, int i, int i2, boolean z) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.nr < i || this.f10609a >= this.fx) {
                return false;
            }
            if (!this.jk || i2 == 2) {
                return z || j - this.t >= ((long) this.b);
            }
            return false;
        }

        public synchronized void u() {
            this.n += this.pn;
        }

        public synchronized void u(long j) {
            this.t = j;
        }
    }

    private sx() {
        iz();
        this.pn = com.ss.android.socialbase.downloader.jk.iz.fx();
        com.ss.android.socialbase.downloader.u.u.u().u(this);
    }

    private void iz() {
        if (com.ss.android.socialbase.downloader.n.u.fx().u("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.sx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (sx.this.nr != null) {
                        sx sxVar = sx.this;
                        sxVar.n = (ConnectivityManager) sxVar.nr.getApplicationContext().getSystemService("connectivity");
                        sx.this.n.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.sx.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.fx.u.nr("RetryScheduler", "network onAvailable: ");
                                sx.this.u(1, true);
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        try {
            if (this.n == null) {
                this.n = (ConnectivityManager) this.nr.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.n.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            nr(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            u(message.what);
        }
        return true;
    }

    private u b(int i) {
        int[] iArrU;
        int i2;
        int i3;
        boolean z;
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(i);
        boolean z2 = false;
        int iU = uVarU.u("retry_schedule", 0);
        JSONObject jSONObjectB = uVarU.b("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectB != null) {
            int iOptInt = jSONObjectB.optInt("max_count", 60);
            int iOptInt2 = jSONObjectB.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectB.optInt("interval_sec_acceleration", 60);
            if (f10608a != null && jSONObjectB.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArrU = u(jSONObjectB.optString("allow_error_code"));
            i2 = iOptInt3;
            z = z2;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrU = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new u(i, iU, i3, i4 * 1000, i2 * 1000, z, iArrU);
    }

    private void fx(int i) {
        synchronized (this.b) {
            this.b.remove(i);
        }
    }

    private void nr(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.sx.2
            @Override // java.lang.Runnable
            public void run() {
                int iX;
                try {
                    if (sx.this.x > 0 && (iX = sx.this.x()) != 0) {
                        com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + sx.this.x);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (sx.this.b) {
                            for (int i2 = 0; i2 < sx.this.b.size(); i2++) {
                                u uVar = (u) sx.this.b.valueAt(i2);
                                if (uVar != null && uVar.u(jCurrentTimeMillis, i, iX, z)) {
                                    if (z) {
                                        uVar.fx();
                                    }
                                    arrayList.add(uVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                sx.this.u(((u) it.next()).u, iX, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void pn() {
        u(5, false);
    }

    private u nr(int i) {
        u uVarB = this.b.get(i);
        if (uVarB == null) {
            synchronized (this.b) {
                uVarB = this.b.get(i);
                if (uVarB == null) {
                    uVarB = b(i);
                }
                this.b.put(i, uVarB);
            }
        }
        return uVarB;
    }

    public static sx u() {
        if (u == null) {
            synchronized (sx.class) {
                if (u == null) {
                    u = new sx();
                }
            }
        }
        return u;
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void fx() {
        u(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void nr() {
        u(4, false);
    }

    public static void u(nr nrVar) {
        f10608a = nrVar;
    }

    public void b() {
        u(2, true);
    }

    public void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.pn.u) || !com.ss.android.socialbase.downloader.constants.pn.u.equals(downloadInfo.getMimeType())) {
            return;
        }
        u(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), x());
    }

    private void u(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        u uVarNr = nr(downloadInfo.getId());
        if (uVarNr.f10609a > uVarNr.fx) {
            com.ss.android.socialbase.downloader.fx.u.b("RetryScheduler", "tryStartScheduleRetry, id = " + uVarNr.u + ", mRetryCount = " + uVarNr.f10609a + ", maxCount = " + uVarNr.fx);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.jk.iz.n(failedException) && !com.ss.android.socialbase.downloader.jk.iz.a(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!u(uVarNr, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "allow error code, id = " + uVarNr.u + ", error code = " + errorCode);
        }
        uVarNr.jk = z;
        synchronized (this.b) {
            if (!uVarNr.l) {
                uVarNr.l = true;
                this.x++;
            }
        }
        int iB = uVarNr.b();
        com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "tryStartScheduleRetry: id = " + uVarNr.u + ", delayTimeMills = " + iB + ", mWaitingRetryTasks = " + this.x);
        if (!uVarNr.iz) {
            if (z) {
                return;
            }
            this.fx.removeMessages(downloadInfo.getId());
            this.fx.sendEmptyMessageDelayed(downloadInfo.getId(), iB);
            return;
        }
        if (i == 0) {
            uVarNr.fx();
        }
        nr nrVar = f10608a;
        if (nrVar != null) {
            nrVar.u(downloadInfo, iB, z, i);
        }
        if (this.pn) {
            uVarNr.u(System.currentTimeMillis());
            uVarNr.nr();
            uVarNr.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, boolean z) {
        if (this.x <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (jCurrentTimeMillis - this.iz < 10000) {
                    return;
                }
            }
            this.iz = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.fx.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z ? 1 : 0;
            this.fx.sendMessageDelayed(messageObtain, 2000L);
        }
    }

    public void u(final int i) {
        com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.sx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sx sxVar = sx.this;
                    sxVar.u(i, sxVar.x(), true);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.sx reserveWifiStatusListener;
        boolean zU;
        Context context = this.nr;
        if (context == null) {
            return;
        }
        synchronized (this.b) {
            u uVar = this.b.get(i);
            if (uVar == null) {
                return;
            }
            boolean z2 = true;
            if (uVar.l) {
                uVar.l = false;
                int i3 = this.x - 1;
                this.x = i3;
                if (i3 < 0) {
                    this.x = 0;
                }
            }
            com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + uVar.f10609a + ", mWaitingRetryTasksCount = " + this.x);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                fx(i);
                return;
            }
            com.ss.android.socialbase.downloader.fx.u.pn("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.u(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.l lVarQq = com.ss.android.socialbase.downloader.downloader.fx.qq();
                    if (lVarQq != null) {
                        lVarQq.u(Collections.singletonList(downloadInfo), 3);
                    }
                    fx(i);
                    return;
                }
                if (realStatus != -1) {
                    return;
                }
                if (i2 != 0) {
                    zU = true;
                } else if (!uVar.iz) {
                    return;
                } else {
                    zU = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (zU && com.ss.android.socialbase.downloader.jk.iz.n(failedException)) {
                    zU = u(downloadInfo, failedException);
                }
                uVar.nr();
                if (zU) {
                    com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + uVar.u);
                    uVar.u(System.currentTimeMillis());
                    if (z) {
                        uVar.u();
                    }
                    downloadInfo.setRetryScheduleCount(uVar.f10609a);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z) {
                    uVar.u();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z2 = false;
                }
                u(downloadInfo, z2, i2);
                return;
            }
            fx(i);
        }
    }

    private boolean u(u uVar, int i) {
        int[] iArr = uVar.x;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean u(DownloadInfo downloadInfo, BaseException baseException) {
        long jB;
        long totalBytes;
        try {
            jB = com.ss.android.socialbase.downloader.jk.iz.b(downloadInfo.getTempPath());
        } catch (BaseException unused) {
            jB = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.b) baseException).nr();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (jB < totalBytes) {
            com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
            if (uVarU.u("space_fill_part_download", 0) == 1) {
                if (jB > 0) {
                    int iU = uVarU.u("space_fill_min_keep_mb", 100);
                    if (iU > 0) {
                        long j = jB - (((long) iU) * 1048576);
                        com.ss.android.socialbase.downloader.fx.u.fx("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.jk.iz.u(jB) + "MB, minKeep = " + iU + "MB, canDownload = " + com.ss.android.socialbase.downloader.jk.iz.u(j) + "MB");
                        if (j <= 0) {
                            com.ss.android.socialbase.downloader.fx.u.b("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (uVarU.u("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
