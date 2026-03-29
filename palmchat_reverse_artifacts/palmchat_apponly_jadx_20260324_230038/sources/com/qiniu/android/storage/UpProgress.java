package com.qiniu.android.storage;

import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class UpProgress {
    private final UpProgressHandler handler;
    private volatile long maxProgressUploadBytes = -1;
    private volatile long previousUploadBytes = 0;

    public UpProgress(UpProgressHandler upProgressHandler) {
        this.handler = upProgressHandler;
    }

    public void notifyDone(final String str, final long j) {
        UpProgressHandler upProgressHandler = this.handler;
        if (upProgressHandler == null) {
            return;
        }
        if (upProgressHandler instanceof UpProgressBytesHandler) {
            AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.3
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("key:" + str + " progress uploadBytes:" + j + " totalBytes:" + j);
                    UpProgressBytesHandler upProgressBytesHandler = (UpProgressBytesHandler) UpProgress.this.handler;
                    String str2 = str;
                    long j2 = j;
                    upProgressBytesHandler.progress(str2, j2, j2);
                }
            });
        } else {
            AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.4
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("key:" + str + " progress:1");
                    UpProgress.this.handler.progress(str, 1.0d);
                }
            });
        }
    }

    public void progress(final String str, final long j, final long j2) {
        if (this.handler == null || j < 0) {
            return;
        }
        if (j2 <= 0 || j <= j2) {
            if (j2 > 0) {
                if (this.maxProgressUploadBytes < 0) {
                    this.maxProgressUploadBytes = (long) (j2 * 0.95d);
                }
                if (j > this.maxProgressUploadBytes) {
                    return;
                }
            }
            if (j > this.previousUploadBytes) {
                this.previousUploadBytes = j;
                if (this.handler instanceof UpProgressBytesHandler) {
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LogUtil.i("key:" + str + " progress uploadBytes:" + j + " totalBytes:" + j2);
                            ((UpProgressBytesHandler) UpProgress.this.handler).progress(str, j, j2);
                        }
                    });
                } else {
                    if (j2 < 0) {
                        return;
                    }
                    final double d = j / j2;
                    AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.storage.UpProgress.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LogUtil.i("key:" + str + " progress:" + d);
                            UpProgress.this.handler.progress(str, d);
                        }
                    });
                }
            }
        }
    }
}
