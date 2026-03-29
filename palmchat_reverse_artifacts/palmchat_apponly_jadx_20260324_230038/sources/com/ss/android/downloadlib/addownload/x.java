package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface x {
    long b();

    void n();

    x nr(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    x nr(Context context);

    x nr(DownloadController downloadController);

    x nr(DownloadEventConfig downloadEventConfig);

    x nr(DownloadModel downloadModel);

    void nr(int i);

    boolean nr();

    x u(long j);

    x u(IDownloadButtonClickListener iDownloadButtonClickListener);

    x u(OnItemClickListener onItemClickListener);

    x u(String str);

    void u();

    void u(boolean z);

    boolean u(int i);
}
