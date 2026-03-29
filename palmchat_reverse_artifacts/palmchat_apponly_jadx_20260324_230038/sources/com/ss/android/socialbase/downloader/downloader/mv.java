package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface mv {
    List<com.ss.android.socialbase.downloader.model.nr> a(int i);

    List<DownloadInfo> b();

    List<DownloadInfo> b(String str);

    void b(int i);

    IDownloadFileUriProvider bg(int i);

    List<DownloadInfo> fx(String str);

    void fx(int i);

    void fx(int i, boolean z);

    boolean fx();

    boolean fx(DownloadInfo downloadInfo);

    int iz(int i);

    void iz();

    void jk(int i);

    void k(int i);

    boolean l(int i);

    int mv(int i);

    boolean my(int i);

    DownloadInfo n(int i);

    DownloadInfo nr(String str, String str2);

    List<DownloadInfo> nr(String str);

    void nr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z);

    void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list);

    void nr(int i, boolean z);

    void nr(DownloadInfo downloadInfo);

    void nr(DownloadTask downloadTask);

    void nr(List<String> list);

    boolean nr();

    boolean nr(int i);

    z o(int i);

    long pn(int i);

    List<DownloadInfo> pn(String str);

    boolean pn();

    boolean s(int i);

    void startService();

    ja sx(int i);

    void t(int i);

    int u(String str, String str2);

    List<DownloadInfo> u(String str);

    void u();

    void u(int i);

    void u(int i, int i2);

    void u(int i, int i2, int i3, int i4);

    void u(int i, int i2, int i3, long j);

    void u(int i, int i2, long j);

    void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z);

    void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z, boolean z2);

    void u(int i, long j);

    void u(int i, Notification notification);

    void u(int i, z zVar);

    void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list);

    void u(int i, boolean z);

    void u(m mVar);

    void u(DownloadTask downloadTask);

    void u(com.ss.android.socialbase.downloader.model.nr nrVar);

    void u(List<String> list);

    void u(boolean z, boolean z2);

    boolean u(DownloadInfo downloadInfo);

    boolean x();

    boolean x(int i);
}
