package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CSJDownloadService extends Service {
    private static final String nr = "CSJDownloadService";
    protected k u;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = nr;
        StringBuilder sb = new StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.u != null);
        com.ss.android.socialbase.downloader.fx.u.nr(str, sb.toString());
        k kVar = this.u;
        if (kVar != null) {
            return kVar.u(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        fx.u(this);
        k kVarZ = fx.z();
        this.u = kVarZ;
        kVarZ.u(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(nr, "Service onDestroy");
        }
        k kVar = this.u;
        if (kVar != null) {
            kVar.b();
            this.u = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(nr, "DownloadService onStartCommand");
        }
        this.u.fx();
        ExecutorService executorServiceL = fx.l();
        if (executorServiceL != null) {
            executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    k kVar = CSJDownloadService.this.u;
                    if (kVar != null) {
                        kVar.u(intent, i, i2);
                    }
                }
            });
        }
        return fx.jk() ? 2 : 3;
    }
}
