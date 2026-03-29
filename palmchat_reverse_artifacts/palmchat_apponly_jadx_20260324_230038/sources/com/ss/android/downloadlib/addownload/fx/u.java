package com.ss.android.downloadlib.addownload.fx;

import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.downloadlib.x.t;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.sx;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements sx {
    private int u;

    private long nr(com.ss.android.socialbase.downloader.n.u uVar) {
        long jU = uVar.u("clear_space_sleep_time", 0L);
        if (jU <= 0) {
            return 0L;
        }
        if (jU > 5000) {
            jU = 5000;
        }
        t.nr("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jU)), null);
        try {
            Thread.sleep(jU);
        } catch (InterruptedException unused) {
        }
        t.nr("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jU;
    }

    public void u(int i) {
        this.u = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.sx
    public boolean u(long j, long j2, o oVar) throws Throwable {
        long j3;
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(this.u);
        if (!u(uVarU)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        b.u().fx();
        long jNr = mv.nr(0L);
        u();
        long jNr2 = mv.nr(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jNr2 < j2) {
            long jNr3 = nr(uVarU);
            if (jNr3 > 0) {
                jNr2 = mv.nr(0L);
            }
            j3 = jNr3;
        } else {
            j3 = 0;
        }
        t.nr("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jNr2 + ", cleaned = " + (jNr2 - jNr), null);
        long j4 = jNr2;
        u(jNr, jNr2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (oVar == null) {
            return true;
        }
        oVar.u();
        return true;
    }

    private boolean u(com.ss.android.socialbase.downloader.n.u uVar) {
        if (uVar.u("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - b.u().nr() >= uVar.u("clear_space_min_time_interval", 600000L);
    }

    private void u() throws Throwable {
        l.my();
        fx.u();
        fx.nr();
    }

    private void u(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(this.u);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.u.u().u(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception unused) {
        }
    }
}
