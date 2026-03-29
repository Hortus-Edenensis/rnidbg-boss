package com.ss.android.socialbase.downloader.a;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kuaishou.weapon.p0.g;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.depend.sx;
import com.ss.android.socialbase.downloader.downloader.bg;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.iz.s;
import com.ss.android.socialbase.downloader.iz.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.nr;
import com.ss.android.socialbase.downloader.network.a;
import com.ss.android.socialbase.downloader.network.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements iz, Runnable {
    private static final String u = "fx";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10599a;
    private com.ss.android.socialbase.downloader.downloader.x bg;
    private final com.ss.android.socialbase.downloader.downloader.x bq;
    private final com.ss.android.socialbase.downloader.downloader.iz c;
    private bg dw;
    private final DownloadTask fx;
    private sx gi;
    private String ja;
    private boolean jk;
    private final jk k;
    private com.ss.android.socialbase.downloader.network.x kj;
    private boolean l;
    private final AtomicBoolean mv;
    private DownloadInfo my;
    private boolean n;
    private Future nr;
    private com.ss.android.socialbase.downloader.downloader.n o;
    private long pb;
    private AtomicInteger pn;
    private volatile BaseException q;
    private a qq;
    private final com.ss.android.socialbase.downloader.downloader.n sx;
    private boolean t;
    private long wq;
    private volatile com.ss.android.socialbase.downloader.downloader.pn x;
    private final com.ss.android.socialbase.downloader.n.u xg;
    private q z;
    private volatile boolean b = false;
    private final ArrayList<nr> iz = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.n s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_NONE;
    private volatile int d = 5;
    private boolean h = false;
    private boolean rh = false;
    private boolean bf = false;
    private int m = 0;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private volatile t f10600jp = null;

    public fx(DownloadTask downloadTask, Handler handler) {
        this.fx = downloadTask;
        if (downloadTask != null) {
            this.my = downloadTask.getDownloadInfo();
            this.o = downloadTask.getChunkStrategy();
            this.bg = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.gi = downloadTask.getDiskSpaceHandler();
            this.dw = u(downloadTask);
            this.xg = com.ss.android.socialbase.downloader.n.u.u(this.my.getId());
        } else {
            this.xg = com.ss.android.socialbase.downloader.n.u.fx();
        }
        n();
        this.k = com.ss.android.socialbase.downloader.downloader.fx.kj();
        this.sx = com.ss.android.socialbase.downloader.downloader.fx.m();
        this.bq = com.ss.android.socialbase.downloader.downloader.fx.y();
        this.c = new com.ss.android.socialbase.downloader.downloader.iz(downloadTask, handler);
        this.mv = new AtomicBoolean(true);
    }

    private boolean a() {
        int status = this.my.getStatus();
        if (status == 1 || this.my.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        nr(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private void bf() throws BaseException {
        if (TextUtils.isEmpty(this.my.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.my.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.my.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.jk.b.nr(this.my)) {
                throw new BaseException(1031, "download savePath is not a directory:" + this.my.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(1031, "download savePath is not directory:path=" + this.my.getSavePath());
        }
        boolean zMkdirs = file.mkdirs();
        if (zMkdirs || file.exists()) {
            return;
        }
        int i = 0;
        if (com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).u("opt_mkdir_failed", 0) != 1) {
            throw new BaseException(1030, "download savePath directory can not created:" + this.my.getSavePath());
        }
        while (!zMkdirs) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                zMkdirs = file.mkdirs();
                i = i2;
            } catch (InterruptedException unused) {
            }
        }
        if (zMkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.jk.iz.b(this.my.getSavePath()) < 16384) {
            throw new BaseException(1006, "download savePath directory can not created:" + this.my.getSavePath());
        }
        throw new BaseException(1030, "download savePath directory can not created:" + this.my.getSavePath());
    }

    private void bg() {
        o();
        sx();
    }

    private void bq() throws BaseException {
        if (this.x != null) {
            if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) {
                this.my.setStatus(-4);
                this.x.fx();
            } else if (this.s != com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                this.x.b();
            } else {
                this.my.setStatus(-2);
                this.x.nr();
            }
        }
    }

    private boolean c() {
        if (!dw() && this.my.getStatus() != -2) {
            return false;
        }
        if (dw()) {
            return true;
        }
        if (this.my.getStatus() == -2) {
            this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.my.getStatus() != -4) {
            return true;
        }
        this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED;
        return true;
    }

    private void d() throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        com.ss.android.socialbase.downloader.impls.u uVarRh;
        int id = this.my.getId();
        int iU = com.ss.android.socialbase.downloader.downloader.fx.u(this.my);
        if (this.my.isDownloaded() && !this.my.isExpiredRedownload() && !this.bf) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo downloadInfoNr = this.k.nr(iU);
        if (downloadInfoNr == null || (uVarRh = com.ss.android.socialbase.downloader.downloader.fx.rh()) == null || downloadInfoNr.getId() == id || !downloadInfoNr.equalsTask(this.my)) {
            return;
        }
        if (uVarRh.u(downloadInfoNr.getId())) {
            this.k.iz(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = this.k.fx(iU);
        com.ss.android.socialbase.downloader.jk.iz.u(this.my);
        this.k.iz(iU);
        if (downloadInfoNr.isBreakpointAvailable()) {
            this.my.copyFromCacheData(downloadInfoNr, false);
            this.k.u(this.my);
            if (listFx != null) {
                for (com.ss.android.socialbase.downloader.model.nr nrVar : listFx) {
                    nrVar.nr(id);
                    this.k.u(nrVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.a("retry task because id generator changed");
        }
    }

    private boolean dw() {
        return this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED || this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE;
    }

    private long gi() {
        return this.dw.u(this.my.getCurRetryTimeInTotal(), this.my.getTotalRetryCount());
    }

    private boolean h() {
        DownloadInfo downloadInfo = this.my;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.f10599a && this.my.getChunkCount() <= 1) || this.my.isChunkDowngradeRetryUsed() || !this.jk || this.l) ? false : true;
    }

    private void ja() throws com.ss.android.socialbase.downloader.exception.iz {
        if (this.my.isOnlyWifi() && !com.ss.android.socialbase.downloader.jk.iz.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), g.b)) {
            throw new com.ss.android.socialbase.downloader.exception.iz(1019, String.format("download task need permission:%s", g.b));
        }
        if (!this.my.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.fx();
        }
        if (!this.my.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.pn();
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00da: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:71:0x00e4 (LINE:219), block:B:68:0x00da */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0 A[Catch: all -> 0x00d7, TryCatch #9 {all -> 0x00d7, blocks: (B:52:0x009c, B:54:0x00a0, B:56:0x00a4, B:65:0x00d6), top: B:83:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e4 A[Catch: SQLiteException -> 0x00eb, TRY_LEAVE, TryCatch #12 {SQLiteException -> 0x00eb, blocks: (B:69:0x00dc, B:71:0x00e4), top: B:84:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void jk() throws com.ss.android.socialbase.downloader.exception.u {
        boolean z;
        boolean z2;
        DownloadTask downloadTask;
        int id;
        boolean z3 = false;
        try {
            try {
                id = this.my.getId();
            } catch (Throwable th) {
                if (0 != 0) {
                    if (z) {
                        try {
                            if (this.xg.u("fix_file_exist_update_download_info")) {
                                this.k.u(this.my);
                            }
                        } catch (SQLiteException unused) {
                        }
                    }
                }
                throw th;
            }
        } catch (com.ss.android.socialbase.downloader.exception.u e) {
            e = e;
        } catch (Throwable th2) {
            th = th2;
        }
        if (this.k != null) {
            if (com.ss.android.socialbase.downloader.jk.u.u(2048)) {
                this.k.pn();
            }
            DownloadInfo downloadInfoNr = this.k.nr(id);
            z2 = true;
            if (downloadInfoNr != null && !downloadInfoNr.isNewTask()) {
                String savePath = this.my.getSavePath();
                String md5 = this.my.getMd5();
                this.my.copyFromCacheData(downloadInfoNr, true);
                boolean z4 = com.ss.android.socialbase.downloader.jk.u.u(4096) && downloadInfoNr != this.my;
                try {
                    if (savePath.equals(downloadInfoNr.getSavePath()) && com.ss.android.socialbase.downloader.jk.iz.u(downloadInfoNr, false, md5)) {
                        try {
                            throw new com.ss.android.socialbase.downloader.exception.u(downloadInfoNr.getName());
                        } catch (com.ss.android.socialbase.downloader.exception.u e2) {
                            throw e2;
                        } catch (Throwable th3) {
                            th = th3;
                            z3 = z4;
                            downloadTask = this.fx;
                            if (downloadTask != null && this.my != null) {
                                com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), this.my, new BaseException(1003, com.ss.android.socialbase.downloader.jk.iz.nr(th, "checkTaskCache")), this.my.getStatus());
                            }
                            if (z3) {
                                if (z2) {
                                    try {
                                        if (!this.xg.u("fix_file_exist_update_download_info")) {
                                            return;
                                        }
                                    } catch (SQLiteException unused2) {
                                        return;
                                    }
                                }
                                this.k.u(this.my);
                                return;
                            }
                            return;
                        }
                    }
                    if (com.ss.android.socialbase.downloader.downloader.fx.u(downloadInfoNr) != id) {
                        try {
                            this.k.iz(id);
                        } catch (SQLiteException unused3) {
                        }
                    } else {
                        z2 = z4;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.u e3) {
                    e = e3;
                } catch (Throwable th4) {
                    th = th4;
                    z3 = z4;
                    z2 = false;
                    downloadTask = this.fx;
                    if (downloadTask != null) {
                        com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), this.my, new BaseException(1003, com.ss.android.socialbase.downloader.jk.iz.nr(th, "checkTaskCache")), this.my.getStatus());
                    }
                    if (z3) {
                    }
                }
                throw e;
            }
            this.my.reset();
        } else {
            z2 = false;
        }
        try {
            n();
            if (z2) {
                try {
                    this.k.u(this.my);
                } catch (SQLiteException unused4) {
                }
            }
        } catch (com.ss.android.socialbase.downloader.exception.u e4) {
            e = e4;
        } catch (Throwable th5) {
            th = th5;
            z3 = z2;
            z2 = false;
            downloadTask = this.fx;
            if (downloadTask != null) {
            }
            if (z3) {
            }
        }
    }

    private boolean jp() {
        return false;
    }

    private void k() {
        if (com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).u("reset_retain_retry_times", 0) != 1 || this.m >= 3) {
            return;
        }
        this.pn.set(this.my.isBackUpUrlUsed() ? this.my.getBackUpUrlRetryCount() : this.my.getRetryCount());
        this.m++;
    }

    private boolean kj() {
        if (this.my.isChunked()) {
            DownloadInfo downloadInfo = this.my;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.my.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.my.getTotalBytes());
        if (this.my.getCurBytes() > 0) {
            if (this.my.isIgnoreDataVerify()) {
                return true;
            }
            if (this.my.getTotalBytes() > 0 && this.my.getCurBytes() == this.my.getTotalBytes()) {
                return true;
            }
        }
        this.my.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.nr.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.my.reset();
        this.k.u(this.my);
        this.k.b(this.my.getId());
        this.k.mv(this.my.getId());
        com.ss.android.socialbase.downloader.jk.iz.u(this.my);
        return false;
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.nr> listFx;
        try {
            this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_NONE;
            this.my.updateStartDownloadTime();
            this.my.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.my.setFirstSpeedTime(-1L);
            try {
                jk();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.u e) {
                com.ss.android.socialbase.downloader.fx.u.nr(u, "file exist " + e.u());
                this.ja = e.u();
                z = true;
            }
            if (!this.h) {
                this.c.nr();
            }
            this.h = false;
            if (c()) {
                return;
            }
            if (!TextUtils.isEmpty(this.ja) && z) {
                if (this.my.isExpiredRedownload()) {
                    this.bf = com.ss.android.socialbase.downloader.jk.iz.b(this.my);
                }
                if (!this.bf) {
                    mv();
                    return;
                }
            }
            while (!c()) {
                try {
                    try {
                        try {
                            try {
                                bf();
                                d();
                                ja();
                                listFx = this.k.fx(this.my.getId());
                                wq();
                            } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                                try {
                                    com.ss.android.socialbase.downloader.fx.u.b(u, "downloadInner: retry throwable for " + e2.u());
                                    if (this.s != com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                                        AtomicInteger atomicInteger = this.pn;
                                        if (atomicInteger != null && atomicInteger.get() > 0) {
                                            this.my.updateCurRetryTime(this.pn.decrementAndGet());
                                            this.my.setStatus(5);
                                        } else if (this.pn == null) {
                                            nr(new BaseException(FunDC.ID_AUTH_1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.u()));
                                        } else if (this.my.trySwitchToNextBackupUrl()) {
                                            this.my.setStatus(5);
                                            this.pn.set(this.my.getRetryCount());
                                            this.my.updateCurRetryTime(this.pn.get());
                                        } else {
                                            nr(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.my.getRetryCount()), e2.u())));
                                        }
                                        bg();
                                    }
                                } catch (Throwable th) {
                                    bg();
                                    throw th;
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.u unused) {
                            mv();
                        }
                    } catch (BaseException e3) {
                        com.ss.android.socialbase.downloader.fx.u.b(u, "downloadInner: baseException = " + e3);
                        if (this.s != com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                            if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                if (u(e3)) {
                                    if (com.ss.android.socialbase.downloader.jk.iz.u(e3)) {
                                        pb();
                                    }
                                    if (u(e3, 0L) == com.ss.android.socialbase.downloader.exception.n.RETURN) {
                                        bg();
                                        return;
                                    }
                                    bg();
                                } else {
                                    nr(e3);
                                }
                            }
                            this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_RIGHT_NOW;
                            bg();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.fx.u.b(u, "downloadInner: throwable =  " + th2);
                    if (this.s != com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                        nr(new BaseException(FunDC.ID_AUTH_1045, th2));
                    }
                }
                if (s()) {
                    com.ss.android.socialbase.downloader.fx.u.fx(u, "downloadSegments return");
                    bg();
                    return;
                }
                String connectionUrl = this.my.getConnectionUrl();
                if (c()) {
                    bg();
                    return;
                }
                long jPn = this.f10599a ? com.ss.android.socialbase.downloader.jk.iz.pn(this.my) : 0L;
                com.ss.android.socialbase.downloader.model.nr nrVarU = u(this.my, jPn);
                List<com.ss.android.socialbase.downloader.model.fx> listU = u(nrVarU);
                com.ss.android.socialbase.downloader.jk.iz.u(listU, this.my);
                com.ss.android.socialbase.downloader.jk.iz.nr(listU, this.my);
                this.my.setPreconnectLevel(0);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    u(connectionUrl, listU, jPn);
                    this.my.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                    if (c()) {
                        bg();
                        return;
                    }
                    long totalBytes = this.my.getTotalBytes();
                    u(totalBytes);
                    int iU = u(totalBytes, listFx);
                    if (c()) {
                        bg();
                        return;
                    }
                    if (iU <= 0) {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                    boolean z2 = iU == 1;
                    this.n = z2;
                    if (z2) {
                        if (this.qq == null) {
                            try {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                u(connectionUrl, listU);
                                this.my.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                            } finally {
                            }
                        }
                        if (c()) {
                            bg();
                            return;
                        } else {
                            this.my.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                            k();
                            u(nrVarU, connectionUrl, this.qq);
                        }
                    } else {
                        if (!this.my.isNeedReuseFirstConnection()) {
                            sx();
                        }
                        if (c()) {
                            bg();
                            return;
                        }
                        k();
                        this.my.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                        if (this.f10599a) {
                            u(iU, listFx);
                        } else {
                            u(totalBytes, iU);
                        }
                    }
                    bg();
                    return;
                } finally {
                }
            }
        } finally {
            my();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.ss.android.socialbase.downloader.impls.u uVarRh;
        if (c() || (uVarRh = com.ss.android.socialbase.downloader.downloader.fx.rh()) == null) {
            return;
        }
        uVarRh.l(this.my.getId());
    }

    private void mv() {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.n.u.fx().nr("fix_end_for_file_exist_error", true)) {
            if (this.ja.equals(this.my.getName())) {
                this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.ja.equals(this.my.getTargetFilePath())) {
            this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void my() {
        boolean zQ;
        boolean z;
        com.ss.android.socialbase.downloader.fx.u.nr(u, "endDownloadRunnable::runStatus=" + this.s);
        boolean z2 = (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE || this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) ? false : true;
        try {
            zQ = q();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.c.u((BaseException) e);
            } else {
                this.c.u(new BaseException(FunDC.ID_AUTH_1046, e));
            }
            zQ = true;
            z = true;
        }
        if (!zQ && !z) {
            this.h = true;
            com.ss.android.socialbase.downloader.fx.u.nr(u, "jump to restart");
            return;
        }
        this.mv.set(false);
        if (z2) {
            try {
                com.ss.android.socialbase.downloader.impls.u uVarRh = com.ss.android.socialbase.downloader.downloader.fx.rh();
                if (uVarRh != null) {
                    uVarRh.u(this);
                }
            } catch (Throwable th) {
                qq monitorDepend = this.fx.getMonitorDepend();
                DownloadInfo downloadInfo = this.my;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.jk.iz.nr(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.my;
                com.ss.android.socialbase.downloader.b.u.u(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void n() {
        DownloadInfo downloadInfo = this.my;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.my.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.pn;
        if (atomicInteger == null) {
            this.pn = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private void o() {
        com.ss.android.socialbase.downloader.network.x xVar = this.kj;
        if (xVar != null) {
            xVar.fx();
            this.kj = null;
        }
    }

    private void pb() {
        com.ss.android.socialbase.downloader.fx.u.b(u, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.k.b(this.my.getId());
            this.k.mv(this.my.getId());
            com.ss.android.socialbase.downloader.jk.iz.u(this.my);
            this.f10599a = false;
            this.my.resetDataForEtagEndure("");
            this.k.u(this.my);
        } catch (Throwable unused) {
        }
    }

    private boolean q() {
        if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_ERROR) {
            this.c.u(this.q);
        } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) {
            this.c.fx();
        } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
            this.c.b();
        } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.c.x();
            } catch (BaseException e) {
                this.c.u(e);
            }
        } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.c.u(this.ja);
            } catch (BaseException e2) {
                this.c.u(e2);
            }
        } else {
            if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.c.u(this.q, false);
                return false;
            }
            if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.n nVar = this.s;
            com.ss.android.socialbase.downloader.constants.n nVar2 = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_RETRY_DELAY;
            if (nVar == nVar2 && !qq()) {
                com.ss.android.socialbase.downloader.fx.u.nr(u, "doTaskStatusHandle retryDelay");
                z();
                return this.s == nVar2;
            }
            try {
                if (!kj()) {
                    return false;
                }
                this.c.iz();
                com.ss.android.socialbase.downloader.impls.sx.u().b();
            } catch (Throwable th) {
                nr(new BaseException(1008, com.ss.android.socialbase.downloader.jk.iz.nr(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean qq() {
        if (this.my.getChunkCount() <= 1) {
            return this.my.getCurBytes() > 0 && this.my.getCurBytes() == this.my.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = this.k.fx(this.my.getId());
        if (listFx == null || listFx.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.nr nrVar : listFx) {
            if (nrVar == null || !nrVar.a()) {
                return false;
            }
        }
        return true;
    }

    private void rh() throws BaseException {
        long jB;
        int iU;
        try {
            jB = com.ss.android.socialbase.downloader.jk.iz.b(this.my.getTempPath());
        } catch (BaseException unused) {
            jB = 0;
        }
        String str = u;
        com.ss.android.socialbase.downloader.fx.u.fx(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.jk.iz.u(jB) + "MB");
        if (jB > 0) {
            long totalBytes = this.my.getTotalBytes() - this.my.getCurBytes();
            if (jB < totalBytes && (iU = com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).u("space_fill_min_keep_mb", 100)) > 0) {
                long j = jB - (((long) iU) * 1048576);
                com.ss.android.socialbase.downloader.fx.u.fx(str, "checkSpaceOverflowInProgress: minKeep  = " + iU + "MB, canDownload = " + com.ss.android.socialbase.downloader.jk.iz.u(j) + "MB");
                if (j > 0) {
                    this.wq = this.my.getCurBytes() + j + 1048576;
                    return;
                } else {
                    this.wq = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.b(jB, totalBytes);
                }
            }
        }
        this.wq = 0L;
    }

    private boolean s() throws InterruptedException, BaseException {
        if (this.my.isExpiredRedownload() || this.my.getChunkCount() != 1 || this.my.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectB = com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).b("segment_config");
        List<com.ss.android.socialbase.downloader.iz.a> listS = this.k.s(this.my.getId());
        if (this.my.getCurBytes() > 0) {
            if (listS == null || listS.isEmpty()) {
                return false;
            }
            if (jSONObjectB == null) {
                jSONObjectB = new JSONObject();
            }
        }
        if (jSONObjectB == null) {
            return false;
        }
        this.f10600jp = new t(this.my, s.u(jSONObjectB), this);
        if (!c()) {
            return this.f10600jp.u(listS);
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "downloadSegments: is stopped by user");
        if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) {
            this.f10600jp.u();
        } else {
            this.f10600jp.nr();
        }
        return true;
    }

    private void sx() {
        a aVar = this.qq;
        if (aVar != null) {
            aVar.b();
            this.qq = null;
        }
    }

    private void t() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.my;
            if (downloadInfo != null && this.pb > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.pb);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.fx.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.c.pn();
                    return;
                }
            }
        } catch (Throwable unused2) {
        }
        if (!a()) {
            qq monitorDepend = this.fx.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.my;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.my;
            com.ss.android.socialbase.downloader.b.u.u(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            l();
            if (!this.h) {
                return;
            }
            if (this.d > 0) {
                this.d--;
            } else {
                if (this.my.getCurBytes() != this.my.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.fx.u.nr(u, this.my.getErrorBytesLog());
                    this.c.u(new com.ss.android.socialbase.downloader.exception.iz(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.my.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.my.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.fx.u.nr(u, this.my.getErrorBytesLog());
                    this.c.u(new com.ss.android.socialbase.downloader.exception.iz(1026, "curBytes is 0, bytes invalid retry status is : " + this.my.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.my.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.fx.u.nr(u, this.my.getErrorBytesLog());
                    this.c.u(new com.ss.android.socialbase.downloader.exception.iz(FunDC.ID_AUTH_1044, "TotalBytes is 0, bytes invalid retry status is : " + this.my.getByteInvalidRetryStatus()));
                    return;
                }
            }
        }
    }

    private void wq() {
        long jIz = com.ss.android.socialbase.downloader.jk.iz.iz(this.my);
        long curBytes = this.my.getCurBytes();
        if (jIz != curBytes) {
            com.ss.android.socialbase.downloader.fx.u.b(u, "checkTaskCanResume: offset = " + jIz + ", curBytes = " + curBytes);
        }
        this.my.setCurBytes(jIz);
        boolean z = jIz > 0;
        this.f10599a = z;
        if (z || this.bf) {
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "checkTaskCanResume: deleteAllDownloadFiles");
        this.k.b(this.my.getId());
        this.k.mv(this.my.getId());
        com.ss.android.socialbase.downloader.jk.iz.u(this.my);
    }

    private void xg() {
        try {
            for (nr nrVar : (ArrayList) this.iz.clone()) {
                if (nrVar != null) {
                    nrVar.nr();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fx.u.fx(u, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private void z() {
        this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_NONE;
    }

    public boolean b() {
        return this.mv.get();
    }

    public DownloadTask fx() {
        return this.fx;
    }

    public void iz() {
        this.pb = System.currentTimeMillis();
        this.c.u();
    }

    public void nr() {
        com.ss.android.socialbase.downloader.constants.n nVar = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED;
        this.s = nVar;
        if (this.f10600jp != null) {
            this.f10600jp.u();
        }
        if (this.x != null) {
            this.x.fx();
        }
        if (this.f10600jp == null && this.x == null) {
            bg();
            this.s = nVar;
            my();
        }
        xg();
    }

    public int pn() {
        DownloadInfo downloadInfo = this.my;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.fx.u(this.fx, 3);
        try {
            com.ss.android.socialbase.downloader.network.nr.u().nr();
            t();
            com.ss.android.socialbase.downloader.network.nr.u().fx();
            com.ss.android.socialbase.downloader.downloader.fx.nr(this.fx, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.nr.u().fx();
            throw th;
        }
    }

    public Future x() {
        return this.nr;
    }

    private boolean b(BaseException baseException) {
        AtomicInteger atomicInteger = this.pn;
        boolean z = true;
        if (atomicInteger == null) {
            nr(new BaseException(FunDC.ID_AUTH_1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.my.trySwitchToNextBackupUrl()) {
                this.pn.set(this.my.getBackUpUrlRetryCount());
                this.my.updateCurRetryTime(this.pn.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.my.canReplaceHttpForRetry())) {
                    nr(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.pn), String.valueOf(this.my.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.pn.set(this.my.getRetryCount());
                this.my.updateCurRetryTime(this.pn.get());
                this.my.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.s != com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_RETRY_DELAY && z) {
            this.my.updateCurRetryTime(this.pn.decrementAndGet());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public void fx(BaseException baseException) {
        DownloadInfo downloadInfo = this.my;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        u(baseException, false);
    }

    public void u() {
        com.ss.android.socialbase.downloader.constants.n nVar = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE;
        this.s = nVar;
        if (this.f10600jp != null) {
            this.f10600jp.nr();
        }
        if (this.x != null) {
            this.x.nr();
        }
        if (this.f10600jp == null && this.x == null) {
            bg();
            this.s = nVar;
            my();
        }
        try {
            for (nr nrVar : (ArrayList) this.iz.clone()) {
                if (nrVar != null) {
                    nrVar.u();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void nr(String str, List<com.ss.android.socialbase.downloader.model.fx> list, long j) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        com.ss.android.socialbase.downloader.network.u.fx fxVarU;
        boolean z = true;
        if (this.my.getChunkCount() == 1 && (fxVarU = com.ss.android.socialbase.downloader.network.u.u.u().u(str, list)) != null) {
            this.kj = fxVarU;
            this.my.setPreconnectLevel(1);
        }
        if (this.kj == null && !this.rh && this.my.isHeadConnectionAvailable()) {
            try {
                int iNr = this.xg.nr("net_lib_strategy");
                if (this.xg.u("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.kj = com.ss.android.socialbase.downloader.downloader.fx.u(str, list, iNr, z, this.my);
            } catch (Throwable th) {
                this.my.setHeadConnectionException(com.ss.android.socialbase.downloader.jk.iz.jk(th));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int u(long j, List<com.ss.android.socialbase.downloader.model.nr> list) {
        int iU;
        int iU2;
        if (h()) {
            if (!this.f10599a) {
                com.ss.android.socialbase.downloader.downloader.n nVar = this.o;
                if (nVar != null) {
                    iU2 = nVar.u(j);
                } else {
                    iU2 = this.sx.u(j);
                }
                l lVarNr = com.ss.android.socialbase.downloader.network.t.u().nr();
                com.ss.android.socialbase.downloader.fx.u.nr(u, String.format("NetworkQuality is : %s", lVarNr.name()));
                this.my.setNetworkQuality(lVarNr.name());
                com.ss.android.socialbase.downloader.downloader.x xVar = this.bg;
                if (xVar != null) {
                    iU = xVar.u(iU2, lVarNr);
                } else {
                    iU = this.bq.u(iU2, lVarNr);
                }
            } else if (list != null) {
                iU = list.size();
            } else {
                iU = this.my.getChunkCount();
            }
            if (iU <= 0) {
            }
        } else {
            iU = 1;
        }
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(iU), this.my.getName(), String.valueOf(j)));
        }
        return iU;
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public boolean nr(long j) throws BaseException {
        if (this.wq > 0 && this.my.getCurBytes() > this.wq) {
            rh();
        }
        return this.c.u(j);
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public void nr(BaseException baseException) {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onError:" + baseException.getMessage());
        this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_ERROR;
        this.q = baseException;
        xg();
    }

    private void u(String str, List<com.ss.android.socialbase.downloader.model.fx> list, long j) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        nr(str, list, j);
        com.ss.android.socialbase.downloader.network.x xVar = this.kj;
        if (xVar != null) {
            try {
                u(str, xVar, j);
            } catch (Throwable unused) {
                this.rh = true;
            }
        }
        if (this.kj == null || this.rh) {
            u(str, list);
            u(str, this.qq, j);
        }
    }

    private void u(String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        a aVarU;
        if (this.qq != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.u.b bVarNr = this.my.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.u.u.u().nr(str, list) : null;
        try {
            if (bVarNr != null) {
                u(this.qq);
                this.my.setPreconnectLevel(2);
                this.qq = bVarNr;
            } else {
                try {
                    aVarU = com.ss.android.socialbase.downloader.downloader.fx.u(this.my.isNeedDefaultHttpServiceBackUp(), this.my.getMaxBytes(), str, null, list, this.xg.nr("net_lib_strategy"), this.xg.u("monitor_download_connect", 0) > 0, this.my);
                    this.qq = aVarU;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.my.isExpiredRedownload() && com.ss.android.socialbase.downloader.jk.iz.x(th) && com.ss.android.socialbase.downloader.jk.iz.fx(list)) {
                        com.ss.android.socialbase.downloader.fx.u.nr(u, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.my.getCacheControl());
                        long jA = com.ss.android.socialbase.downloader.jk.iz.a(this.my.getCacheControl());
                        if (jA <= 0) {
                            jA = com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).u("default_304_max_age", 300);
                        }
                        this.my.setCacheExpiredTime(System.currentTimeMillis() + (jA * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.u(this.ja);
                    }
                    if (com.ss.android.socialbase.downloader.jk.iz.iz(th)) {
                        u("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.jk.iz.pn(th)) {
                        u("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.jk.iz.u(th, "CreateFirstConnection");
                    }
                    aVarU = this.qq;
                }
                u(aVarU);
            }
            if (this.qq == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            u(this.qq);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.nr u(DownloadInfo downloadInfo, long j) {
        return new nr.u(downloadInfo.getId()).u(-1).u(0L).pn(j).nr(j).fx(0L).b(downloadInfo.getTotalBytes() - j).u();
    }

    private List<com.ss.android.socialbase.downloader.model.fx> u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        List<com.ss.android.socialbase.downloader.model.fx> listU = com.ss.android.socialbase.downloader.jk.iz.u(this.my.getExtraHeaders(), this.my.geteTag(), nrVar);
        if (this.my.isExpiredRedownload() && this.bf && this.my.getLastModified() != null) {
            listU.add(new com.ss.android.socialbase.downloader.model.fx("if-modified-since", this.my.getLastModified()));
            listU.add(new com.ss.android.socialbase.downloader.model.fx("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.fx.u.nr(u, "dcache::add head IF_MODIFIED_SINCE=" + this.my.getLastModified());
        }
        return listU;
    }

    private void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) throws BaseException {
        if (list.size() == i) {
            u(list, this.my.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void u(long j, int i) throws BaseException {
        long j2 = j / ((long) i);
        int id = this.my.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.model.nr nrVarU = new nr.u(id).u(i2).u(j3).pn(j3).nr(j3).fx(i2 == i + (-1) ? 0L : (j3 + j2) - 1).u();
            arrayList.add(nrVarU);
            this.k.u(nrVarU);
            j3 += j2;
            i2++;
        }
        this.my.setChunkCount(i);
        this.k.u(id, i);
        u(arrayList, j);
    }

    private void u(List<com.ss.android.socialbase.downloader.model.nr> list, long j) throws BaseException {
        long jMy;
        for (com.ss.android.socialbase.downloader.model.nr nrVar : list) {
            if (nrVar != null) {
                if (nrVar.my() == 0) {
                    jMy = j - nrVar.s();
                } else {
                    jMy = (nrVar.my() - nrVar.s()) + 1;
                }
                if (jMy > 0) {
                    nrVar.u(jMy);
                    if (this.my.isNeedReuseFirstConnection() && this.qq != null && (!this.my.isHeadConnectionAvailable() || this.rh)) {
                        if (nrVar.bg() == 0) {
                            this.iz.add(new nr(nrVar, this.fx, this.qq, this));
                        } else if (nrVar.bg() > 0) {
                            this.iz.add(new nr(nrVar, this.fx, this));
                        }
                    } else {
                        this.iz.add(new nr(nrVar, this.fx, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.jk.u.u(64)) {
            ArrayList arrayList = new ArrayList(this.iz.size());
            for (nr nrVar2 : this.iz) {
                if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) {
                    nrVar2.nr();
                } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                    nrVar2.u();
                } else {
                    arrayList.add(nrVar2);
                }
            }
            try {
                List<Future> listB = com.ss.android.socialbase.downloader.impls.pn.b(arrayList);
                for (Runnable runnablePn = (Runnable) arrayList.remove(0); runnablePn != null; runnablePn = com.ss.android.socialbase.downloader.impls.pn.pn(listB)) {
                    if (c()) {
                        return;
                    }
                    try {
                        runnablePn.run();
                    } catch (Throwable unused) {
                    }
                }
                if (listB == null || listB.isEmpty()) {
                    return;
                }
                for (Future future : listB) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return;
            } catch (Throwable unused3) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.iz.size());
        for (nr nrVar3 : this.iz) {
            if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_CANCELED) {
                nrVar3.nr();
            } else if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_PAUSE) {
                nrVar3.u();
            } else {
                arrayList2.add(Executors.callable(nrVar3));
            }
        }
        if (c()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.pn.fx(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(1020, e);
        }
    }

    private void u(com.ss.android.socialbase.downloader.model.nr nrVar, String str, a aVar) throws BaseException {
        nrVar.u(this.my.getTotalBytes() - nrVar.s());
        this.my.setChunkCount(1);
        this.k.u(this.my.getId(), 1);
        this.x = new com.ss.android.socialbase.downloader.downloader.pn(this.my, str, aVar, nrVar, this);
        bq();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:85|6|7|(9:9|(1:11)|12|(2:14|(4:16|(2:18|(1:20)(2:21|22))(1:23)|24|(3:26|(1:28)|49))(2:29|(1:31)(4:32|(1:34)(1:35)|36|37)))|81|50|51|72|73)(2:38|(4:40|(1:42)(1:43)|44|45)(2:46|(2:76|77)))|48|49|81|50|51|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0162, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0164, code lost:
    
        com.ss.android.socialbase.downloader.fx.u.pn(com.ss.android.socialbase.downloader.a.fx.u, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0183, code lost:
    
        if (r5 >= r24) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018f, code lost:
    
        r7.nr(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0193, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0195, code lost:
    
        com.ss.android.socialbase.downloader.fx.u.pn(com.ss.android.socialbase.downloader.a.fx.u, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ae, code lost:
    
        if (r4 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b6, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b7, code lost:
    
        if (r4 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01c8, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    @Override // com.ss.android.socialbase.downloader.a.iz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(long j) throws BaseException {
        long j2;
        boolean z;
        long j3;
        String tempPath = this.my.getTempPath();
        String tempName = this.my.getTempName();
        if (com.ss.android.socialbase.downloader.jk.iz.nr(j)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.pn pnVarU = com.ss.android.socialbase.downloader.jk.iz.u(this.my, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long totalBytes = j - length;
            long jB = com.ss.android.socialbase.downloader.jk.iz.b(tempPath);
            com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(this.my.getId());
            if (uVarU.u("space_fill_part_download", 0) == 1) {
                this.wq = 0L;
                if (totalBytes <= 0) {
                    totalBytes = this.my.getTotalBytes() - this.my.getCurBytes();
                }
                if (jB < totalBytes) {
                    String str = u;
                    com.ss.android.socialbase.downloader.fx.u.b(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.jk.iz.u(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.jk.iz.u(length) + "MB, required = " + com.ss.android.socialbase.downloader.jk.iz.u(totalBytes) + "MB, available = " + com.ss.android.socialbase.downloader.jk.iz.u(jB) + "MB");
                    if (jB > 0) {
                        int iU = uVarU.u("space_fill_min_keep_mb", 100);
                        if (iU > 0) {
                            long j4 = jB - (((long) iU) * 1048576);
                            com.ss.android.socialbase.downloader.fx.u.b(str, "checkSpaceOverflow: minKeep = " + iU + "MB, canDownload = " + com.ss.android.socialbase.downloader.jk.iz.u(j4) + "MB");
                            if (j4 > 0) {
                                this.wq = this.my.getCurBytes() + j4;
                                j3 = j4;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.b(jB, totalBytes);
                            }
                        } else {
                            j3 = jB;
                        }
                        if (length < j) {
                            j2 = j3 + length;
                            if (j2 > j) {
                            }
                            z = true;
                        }
                    } else {
                        if (uVarU.u("download_when_space_negative", 0) != 1) {
                            StringBuilder sb = new StringBuilder("availableSpace ");
                            sb.append(jB == 0 ? ContainerUtils.KEY_VALUE_DELIMITER : "<");
                            sb.append(" 0");
                            throw new BaseException(FunDC.ID_AUTH_1052, sb.toString());
                        }
                        j2 = j;
                        z = false;
                    }
                }
                pnVarU.nr(j);
                com.ss.android.socialbase.downloader.jk.iz.u(pnVarU);
            }
            if (jB <= 0) {
                StringBuilder sb2 = new StringBuilder("availableSpace ");
                sb2.append(jB == 0 ? ContainerUtils.KEY_VALUE_DELIMITER : "<");
                sb2.append(" 0");
                throw new BaseException(FunDC.ID_AUTH_1052, sb2.toString());
            }
            if (jB < totalBytes) {
                throw new com.ss.android.socialbase.downloader.exception.b(jB, totalBytes);
            }
            j2 = j;
            z = true;
            pnVarU.nr(j);
            com.ss.android.socialbase.downloader.jk.iz.u(pnVarU);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.jk.iz.u(pnVarU);
            throw th;
        }
    }

    private boolean u(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.t || this.jk)) {
            return (i == 201 || i == 416) && this.my.getCurBytes() > 0;
        }
        return true;
    }

    private void u(String str, String str2) throws com.ss.android.socialbase.downloader.exception.a {
        this.k.b(this.my.getId());
        this.k.mv(this.my.getId());
        com.ss.android.socialbase.downloader.jk.iz.u(this.my);
        this.f10599a = false;
        this.my.resetDataForEtagEndure(str);
        this.k.u(this.my);
        throw new com.ss.android.socialbase.downloader.exception.a(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0134 A[Catch: all -> 0x032d, a -> 0x0335, BaseException -> 0x0338, TryCatch #2 {BaseException -> 0x0338, a -> 0x0335, all -> 0x032d, blocks: (B:5:0x000f, B:7:0x0028, B:9:0x002e, B:10:0x0033, B:12:0x00d6, B:14:0x00e3, B:15:0x00f5, B:17:0x00fd, B:19:0x0101, B:33:0x0134, B:34:0x013a, B:35:0x0158, B:24:0x010f, B:26:0x011c, B:29:0x0125, B:38:0x015f, B:40:0x0167, B:42:0x0173, B:43:0x017d, B:45:0x0183, B:46:0x0188, B:48:0x0192, B:50:0x0198, B:52:0x019e, B:55:0x01a5, B:59:0x01b3, B:61:0x01b9, B:66:0x01c2, B:67:0x01cb, B:68:0x01cc, B:69:0x01df, B:70:0x01e0, B:73:0x01e6, B:75:0x01ea, B:76:0x01f0, B:77:0x01f7, B:78:0x01f8, B:82:0x0205, B:85:0x020e, B:86:0x0213, B:87:0x0214, B:89:0x0220, B:91:0x022c, B:95:0x0238, B:98:0x023d, B:99:0x0242, B:101:0x0245, B:103:0x0262, B:105:0x026d, B:108:0x02a2, B:110:0x02ae, B:112:0x02b8, B:114:0x02c2, B:116:0x02c6, B:117:0x02cc, B:118:0x02d3, B:119:0x02d4, B:122:0x02db, B:124:0x02e5, B:126:0x02f8, B:129:0x0303, B:130:0x0326, B:131:0x0327, B:106:0x0283, B:56:0x01ab, B:57:0x01b0), top: B:142:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013a A[Catch: all -> 0x032d, a -> 0x0335, BaseException -> 0x0338, TryCatch #2 {BaseException -> 0x0338, a -> 0x0335, all -> 0x032d, blocks: (B:5:0x000f, B:7:0x0028, B:9:0x002e, B:10:0x0033, B:12:0x00d6, B:14:0x00e3, B:15:0x00f5, B:17:0x00fd, B:19:0x0101, B:33:0x0134, B:34:0x013a, B:35:0x0158, B:24:0x010f, B:26:0x011c, B:29:0x0125, B:38:0x015f, B:40:0x0167, B:42:0x0173, B:43:0x017d, B:45:0x0183, B:46:0x0188, B:48:0x0192, B:50:0x0198, B:52:0x019e, B:55:0x01a5, B:59:0x01b3, B:61:0x01b9, B:66:0x01c2, B:67:0x01cb, B:68:0x01cc, B:69:0x01df, B:70:0x01e0, B:73:0x01e6, B:75:0x01ea, B:76:0x01f0, B:77:0x01f7, B:78:0x01f8, B:82:0x0205, B:85:0x020e, B:86:0x0213, B:87:0x0214, B:89:0x0220, B:91:0x022c, B:95:0x0238, B:98:0x023d, B:99:0x0242, B:101:0x0245, B:103:0x0262, B:105:0x026d, B:108:0x02a2, B:110:0x02ae, B:112:0x02b8, B:114:0x02c2, B:116:0x02c6, B:117:0x02cc, B:118:0x02d3, B:119:0x02d4, B:122:0x02db, B:124:0x02e5, B:126:0x02f8, B:129:0x0303, B:130:0x0326, B:131:0x0327, B:106:0x0283, B:56:0x01ab, B:57:0x01b0), top: B:142:0x000f }] */
    @Override // com.ss.android.socialbase.downloader.a.iz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(String str, com.ss.android.socialbase.downloader.network.x xVar, long j) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        com.ss.android.socialbase.downloader.network.x xVar2;
        long jNr;
        boolean z;
        if (xVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.b bVar = new com.ss.android.socialbase.downloader.model.b(str, xVar);
            int i = bVar.fx;
            String strB = bVar.b();
            if (TextUtils.isEmpty(this.my.getMimeType()) && !TextUtils.isEmpty(strB)) {
                this.my.setMimeType(strB);
            }
            boolean zNr = bVar.nr();
            this.jk = zNr;
            this.my.setSupportPartial(zNr);
            this.t = bVar.u();
            String str2 = this.my.geteTag();
            String strFx = bVar.fx();
            String strIz = bVar.iz();
            String strX = bVar.x();
            String str3 = u;
            com.ss.android.socialbase.downloader.fx.u.nr(str3, "dcache=responseCode=" + i + " last_modified=" + strIz + " CACHE_CONTROL=" + strX + " max-age=" + bVar.t() + " isDeleteCacheIfCheckFailed=" + this.my.isDeleteCacheIfCheckFailed());
            StringBuilder sb = new StringBuilder("dcache=firstOffset=");
            sb.append(j);
            sb.append(" cur=");
            sb.append(strIz);
            sb.append(" before=");
            sb.append(this.my.getLastModified());
            sb.append(" cur=");
            String str4 = strFx;
            sb.append(bVar.jk());
            sb.append(" before=");
            sb.append(this.my.getTotalBytes());
            com.ss.android.socialbase.downloader.fx.u.nr(str3, sb.toString());
            if (!TextUtils.isEmpty(strX)) {
                this.my.setCacheControl(strX);
                if (bVar.t() > 0) {
                    this.my.setCacheExpiredTime(System.currentTimeMillis() + (bVar.t() * 1000));
                }
            }
            if (this.my.isExpiredRedownload() && this.bf && !TextUtils.isEmpty(this.ja)) {
                if (i == 304) {
                    z = true;
                    if (z) {
                        com.ss.android.socialbase.downloader.jk.iz.u(this.my);
                    } else {
                        com.ss.android.socialbase.downloader.fx.u.nr(str3, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strIz);
                        throw new com.ss.android.socialbase.downloader.exception.u(this.ja);
                    }
                } else {
                    z = false;
                    if ((!TextUtils.isEmpty(this.my.getLastModified()) || !this.my.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strIz, this.my.getLastModified())) {
                        z = true;
                    }
                    if (z) {
                    }
                }
            }
            if (j > 0 && this.my.isExpiredRedownload() && !TextUtils.equals(strIz, this.my.getLastModified())) {
                com.ss.android.socialbase.downloader.fx.u.nr(str3, "dcache cdn file change, so retry");
                u("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strIz)) {
                this.my.setLastModified(strIz);
            }
            if (u(i, str2, str4)) {
                xVar2 = xVar;
                if (xVar2 instanceof a) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        str4 = "";
                    }
                    u(str4, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.nr(1002, i, "");
                }
            } else {
                xVar2 = xVar;
            }
            if (!this.jk && !this.t) {
                if (i == 403) {
                    throw new BaseException(FunDC.ID_AUTH_1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.nr(1004, i, "response code error : " + i);
            }
            if (this.t && j > 0) {
                if (xVar2 instanceof a) {
                    u("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            String str5 = str4;
            long jN = bVar.n();
            if (!(xVar2 instanceof a) && jN < 0 && com.ss.android.socialbase.downloader.jk.b.u(this.my)) {
                throw new BaseException(1004, "");
            }
            String strU = TextUtils.isEmpty(this.my.getName()) ? com.ss.android.socialbase.downloader.jk.iz.u(xVar2, this.my.getUrl()) : "";
            boolean zA = bVar.a();
            this.l = zA;
            if (!zA && jN == 0 && !(xVar2 instanceof a)) {
                throw new BaseException(1004, "");
            }
            if (zA) {
                jNr = -1;
            } else {
                String strNr = com.ss.android.socialbase.downloader.jk.iz.nr(xVar2, HttpHeaders.CONTENT_RANGE);
                com.ss.android.socialbase.downloader.fx.u.fx(str3, "firstConnection: contentRange = " + strNr);
                if (!TextUtils.isEmpty(strNr) && this.xg.nr("fix_get_total_bytes", true)) {
                    jNr = com.ss.android.socialbase.downloader.jk.iz.nr(strNr);
                    com.ss.android.socialbase.downloader.fx.u.fx(str3, "firstConnection: 1 totalLength = " + jNr);
                } else {
                    long j2 = j + jN;
                    com.ss.android.socialbase.downloader.fx.u.pn(str3, "firstConnection: 2 totalLength = " + j2 + ", contentLength = " + jN);
                    jNr = j2;
                }
            }
            if (!TextUtils.isEmpty(this.my.getTaskKey()) && this.my.getTotalBytes() > 0 && jNr != this.my.getTotalBytes()) {
                if (xVar2 instanceof a) {
                    u("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.nr(1002, i, "");
                }
            }
            if (c()) {
                return;
            }
            if (this.my.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).nr("force_check_file_length") == 1 && this.my.getExpectFileLength() != jNr) {
                throw new BaseException(FunDC.ID_AUTH_1070, "expectFileLength = " + this.my.getExpectFileLength() + " , totalLength = " + jNr);
            }
            this.c.u(jNr, str5, strU);
        } catch (BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.a e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.jk.iz.u(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public void u(nr nrVar) {
        if (this.n) {
            return;
        }
        synchronized (this) {
            this.iz.remove(nrVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public boolean u(BaseException baseException) {
        if (this.f10600jp != null && com.ss.android.socialbase.downloader.jk.iz.a(baseException) && this.pn.get() < this.my.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.jk.iz.nr(baseException)) {
            if (this.n && !this.b) {
                com.ss.android.socialbase.downloader.jk.iz.u(this.my);
                this.b = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.pn;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.my.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.my.canReplaceHttpForRetry()))) && !(baseException instanceof com.ss.android.socialbase.downloader.exception.iz);
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public void u(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onAllChunkRetryWithReset");
        this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.q = baseException;
        xg();
        if (z ? b(baseException) : false) {
            return;
        }
        pb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.my.setForbiddenBackupUrls(list, this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.u uVarRh = com.ss.android.socialbase.downloader.downloader.fx.rh();
        if (uVarRh != null) {
            uVarRh.l(this.my.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public com.ss.android.socialbase.downloader.exception.n u(com.ss.android.socialbase.downloader.model.nr nrVar, BaseException baseException, long j) {
        if (dw()) {
            return com.ss.android.socialbase.downloader.exception.n.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.jk.iz.n(baseException))) {
            return u(baseException, j);
        }
        this.q = baseException;
        this.my.increaseCurBytes(-j);
        this.k.u(this.my);
        if (b(baseException)) {
            return com.ss.android.socialbase.downloader.exception.n.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.iz izVar = this.c;
        com.ss.android.socialbase.downloader.constants.n nVar = this.s;
        com.ss.android.socialbase.downloader.constants.n nVar2 = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_RETRY_DELAY;
        izVar.u(nrVar, baseException, nVar == nVar2);
        if (this.s != nVar2 && this.my.isNeedRetryDelay()) {
            long jGi = gi();
            if (jGi > 0) {
                com.ss.android.socialbase.downloader.fx.u.fx(u, "onSingleChunkRetry with delay time " + jGi);
                try {
                    Thread.sleep(jGi);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.fx.u.b(u, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.n.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public com.ss.android.socialbase.downloader.exception.n u(BaseException baseException, long j) {
        long jU;
        long totalBytes;
        boolean z;
        this.q = baseException;
        this.my.increaseCurBytes(-j);
        this.k.u(this.my);
        if (dw()) {
            return com.ss.android.socialbase.downloader.exception.n.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.z != null && !this.my.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.nr nrVar = new com.ss.android.socialbase.downloader.depend.nr() { // from class: com.ss.android.socialbase.downloader.a.fx.1
                    @Override // com.ss.android.socialbase.downloader.depend.nr, com.ss.android.socialbase.downloader.depend.c
                    public void u(List<String> list) {
                        super.u(list);
                        fx.this.u(list);
                    }
                };
                boolean zU = this.z.u(nrVar);
                this.my.setForbiddenRetryed();
                if (zU) {
                    if (!nrVar.u()) {
                        xg();
                        this.c.n();
                        this.s = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.n.RETURN;
                    }
                    z = true;
                }
            } else if (b(baseException)) {
                return com.ss.android.socialbase.downloader.exception.n.RETURN;
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.jk.iz.n(baseException)) {
            if (this.gi == null) {
                nr(baseException);
                return com.ss.android.socialbase.downloader.exception.n.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            o oVar = new o() { // from class: com.ss.android.socialbase.downloader.a.fx.2
                @Override // com.ss.android.socialbase.downloader.depend.o
                public void u() {
                    synchronized (fx.this) {
                        atomicBoolean.set(true);
                        fx.this.m();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
                com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
                jU = bVar.u();
                totalBytes = bVar.nr();
            } else {
                jU = -1;
                totalBytes = this.my.getTotalBytes();
            }
            synchronized (this) {
                if (this.gi.u(jU, totalBytes, oVar)) {
                    if (!com.ss.android.socialbase.downloader.n.u.u(this.my.getId()).nr("not_delete_when_clean_space", false)) {
                        kj();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.n nVar = this.s;
                        com.ss.android.socialbase.downloader.constants.n nVar2 = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (nVar != nVar2) {
                            this.s = nVar2;
                            xg();
                            this.c.n();
                        }
                        return com.ss.android.socialbase.downloader.exception.n.RETURN;
                    }
                    if (b(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.n.RETURN;
                    }
                    z = true;
                } else {
                    if (this.s == com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.n.RETURN;
                    }
                    nr(baseException);
                    return com.ss.android.socialbase.downloader.exception.n.RETURN;
                }
            }
        } else {
            if (b(baseException)) {
                return com.ss.android.socialbase.downloader.exception.n.RETURN;
            }
            z = false;
        }
        if (!z && jp()) {
            xg();
        }
        com.ss.android.socialbase.downloader.downloader.iz izVar = this.c;
        com.ss.android.socialbase.downloader.constants.n nVar3 = this.s;
        com.ss.android.socialbase.downloader.constants.n nVar4 = com.ss.android.socialbase.downloader.constants.n.RUN_STATUS_RETRY_DELAY;
        izVar.u(baseException, nVar3 == nVar4);
        return this.s == nVar4 ? com.ss.android.socialbase.downloader.exception.n.RETURN : com.ss.android.socialbase.downloader.exception.n.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public synchronized com.ss.android.socialbase.downloader.model.nr u(int i) {
        com.ss.android.socialbase.downloader.model.nr nrVarU;
        if (this.my.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = this.k.fx(this.my.getId());
        if (listFx != null && !listFx.isEmpty()) {
            for (int i2 = 0; i2 < listFx.size(); i2++) {
                com.ss.android.socialbase.downloader.model.nr nrVar = listFx.get(i2);
                if (nrVar != null && (nrVarU = u(nrVar, i)) != null) {
                    return nrVarU;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.a.iz
    public void u(com.ss.android.socialbase.downloader.network.x xVar) {
        boolean z;
        if (xVar != null) {
            try {
                int iNr = xVar.nr();
                this.my.setHttpStatusCode(iNr);
                this.my.setHttpStatusMessage(com.ss.android.socialbase.downloader.jk.nr.u(iNr));
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.my.setHttpStatusCode(-1);
        this.my.setHttpStatusMessage("");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.ss.android.socialbase.downloader.model.nr u(com.ss.android.socialbase.downloader.model.nr nrVar, int i) {
        boolean z;
        int i2;
        com.ss.android.socialbase.downloader.model.nr nrVar2 = null;
        if (!nrVar.b()) {
            return null;
        }
        long jFx = nrVar.fx(true);
        com.ss.android.socialbase.downloader.fx.u.nr(u, "reuseChunk retainLen:" + jFx + " chunkIndex:" + i);
        if (!nrVar.iz() && jFx > com.ss.android.socialbase.downloader.constants.pn.iz && this.my.isNeedReuseChunkRunnable()) {
            List<com.ss.android.socialbase.downloader.model.nr> listU = nrVar.u(this.my.getChunkCount(), this.my.getTotalBytes());
            if (listU != null) {
                Iterator<com.ss.android.socialbase.downloader.model.nr> it = listU.iterator();
                while (it.hasNext()) {
                    this.k.nr(it.next());
                }
            }
        } else {
            if (!nrVar.iz()) {
                z = false;
            }
            if (z && nrVar.iz()) {
                for (i2 = 1; i2 < nrVar.x().size(); i2++) {
                    com.ss.android.socialbase.downloader.model.nr nrVar3 = nrVar.x().get(i2);
                    if (nrVar3 != null) {
                        com.ss.android.socialbase.downloader.fx.u.nr(u, "check can checkUnCompletedChunk -- chunkIndex:" + nrVar3.bg() + " currentOffset:" + nrVar3.s() + "  startOffset:" + nrVar3.l() + " contentLen:" + nrVar3.o());
                        if (nrVar3.bg() < 0 || (!nrVar3.a() && !nrVar3.fx())) {
                            nrVar2 = nrVar3;
                            break;
                        }
                    }
                }
                if (nrVar2 != null) {
                    long jS = nrVar.s();
                    com.ss.android.socialbase.downloader.fx.u.nr(u, "unComplete chunk " + nrVar.bg() + " curOffset:" + jS + " reuseChunk chunkIndex:" + i + " for subChunk:" + nrVar2.bg());
                    this.k.u(nrVar2.t(), nrVar2.bg(), nrVar2.nr(), i);
                    nrVar2.fx(i);
                    nrVar2.u(true);
                }
            }
            return nrVar2;
        }
        z = true;
        if (z) {
            while (i2 < nrVar.x().size()) {
            }
            if (nrVar2 != null) {
            }
        }
        return nrVar2;
    }

    private bg u(DownloadTask downloadTask) {
        bg retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.o(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.fx.bc();
    }

    public void u(Future future) {
        this.nr = future;
    }
}
