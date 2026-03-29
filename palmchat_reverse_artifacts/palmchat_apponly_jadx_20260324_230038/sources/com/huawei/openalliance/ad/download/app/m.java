package com.huawei.openalliance.ad.download.app;

import com.huawei.hms.ads.fh;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m {
    private static final String Code = "TaskDelTimer";
    private static final long V = 2000;
    private AppDownloadTask I;
    private Timer Z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends TimerTask {
        private AppDownloadTask Code;

        public a(AppDownloadTask appDownloadTask) {
            this.Code = appDownloadTask;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            fh.Code(m.Code, "del task");
            g.I().V(this.Code);
        }
    }

    public m(AppDownloadTask appDownloadTask) {
        this.I = appDownloadTask;
    }

    public void Code() {
        if (this.Z == null) {
            this.Z = new Timer();
        }
        fh.Code(Code, "start timer");
        this.Z.schedule(new a(this.I), 2000L);
    }

    public AppDownloadTask V() {
        return this.I;
    }

    public void Code(AppDownloadTask appDownloadTask) {
        this.I = appDownloadTask;
    }
}
