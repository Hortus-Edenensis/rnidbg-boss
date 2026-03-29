package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface dw {

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements dw {
        @Override // com.ss.android.socialbase.downloader.downloader.dw
        public com.ss.android.socialbase.downloader.network.n fx() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.dw
        public IDownloadHttpService nr() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.dw
        public com.ss.android.socialbase.downloader.exception.x u(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.dw
        public boolean u() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.dw
        public boolean u(Throwable th) {
            return false;
        }
    }

    com.ss.android.socialbase.downloader.network.n fx();

    IDownloadHttpService nr();

    com.ss.android.socialbase.downloader.exception.x u(Throwable th, String str);

    boolean u();

    boolean u(Throwable th);
}
