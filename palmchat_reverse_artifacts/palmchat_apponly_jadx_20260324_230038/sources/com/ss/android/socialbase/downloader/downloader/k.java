package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface k<T extends CSJDownloadService> {
    void b();

    void fx();

    void fx(DownloadTask downloadTask);

    void nr(DownloadTask downloadTask);

    boolean nr();

    void startService();

    IBinder u(Intent intent);

    void u(int i);

    void u(int i, Notification notification);

    void u(Intent intent, int i, int i2);

    void u(s sVar);

    void u(WeakReference<T> weakReference);

    void u(boolean z);

    boolean u();
}
