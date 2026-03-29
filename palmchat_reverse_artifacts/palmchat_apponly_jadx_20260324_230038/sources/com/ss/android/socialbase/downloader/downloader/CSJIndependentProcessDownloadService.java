package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        fx.u(this);
        if (fx.mh() == null) {
            fx.u(new c());
        }
        k kVarGi = fx.gi();
        this.u = kVarGi;
        kVarGi.u(new WeakReference(this));
    }
}
