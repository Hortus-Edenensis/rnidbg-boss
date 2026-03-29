package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface jk {
    DownloadInfo a(int i);

    DownloadInfo b(int i, long j);

    List<DownloadInfo> b(String str);

    void b(int i);

    boolean b();

    DownloadInfo fx(int i, long j);

    List<com.ss.android.socialbase.downloader.model.nr> fx(int i);

    List<DownloadInfo> fx(String str);

    void fx();

    boolean iz(int i);

    DownloadInfo jk(int i);

    Map<Long, com.ss.android.socialbase.downloader.iz.a> l(int i);

    void mv(int i);

    DownloadInfo n(int i);

    DownloadInfo nr(int i);

    DownloadInfo nr(int i, long j);

    List<DownloadInfo> nr();

    List<DownloadInfo> nr(String str);

    void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list);

    void nr(DownloadInfo downloadInfo);

    void nr(com.ss.android.socialbase.downloader.model.nr nrVar);

    boolean pn();

    boolean pn(int i);

    List<com.ss.android.socialbase.downloader.iz.a> s(int i);

    DownloadInfo u(int i, int i2);

    DownloadInfo u(int i, long j);

    DownloadInfo u(int i, long j, String str, String str2);

    List<DownloadInfo> u(String str);

    void u(int i, int i2, int i3, int i4);

    void u(int i, int i2, int i3, long j);

    void u(int i, int i2, long j);

    void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list);

    void u(com.ss.android.socialbase.downloader.model.nr nrVar);

    boolean u(int i, Map<Long, com.ss.android.socialbase.downloader.iz.a> map);

    boolean u(DownloadInfo downloadInfo);

    DownloadInfo x(int i);
}
