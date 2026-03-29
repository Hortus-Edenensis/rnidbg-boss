package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.u {
    private static final String pn = "n";

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void fx() {
        if (com.ss.android.socialbase.downloader.jk.u.u(262144)) {
            this.nr = true;
            this.b = false;
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                com.ss.android.socialbase.downloader.fx.u.nr(pn, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.nr = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u, com.ss.android.socialbase.downloader.downloader.k
    public void u(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.fx.u.u()) {
            com.ss.android.socialbase.downloader.fx.u.nr(pn, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.jk.u.u(262144)) {
            this.nr = true;
        }
        pn();
    }
}
