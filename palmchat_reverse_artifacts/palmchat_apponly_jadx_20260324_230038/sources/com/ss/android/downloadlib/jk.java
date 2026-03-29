package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.s;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk {
    private static volatile jk u;
    private final com.ss.android.downloadad.api.u b;
    private final n fx;
    private long iz;
    private final com.ss.android.download.api.u nr;
    private com.ss.android.downloadad.api.nr pn;

    /* JADX INFO: Access modifiers changed from: private */
    public n n() {
        return this.fx;
    }

    public com.ss.android.downloadad.api.u b() {
        return this.b;
    }

    public void fx() {
        this.iz = System.currentTimeMillis();
    }

    public String iz() {
        return l.s();
    }

    public com.ss.android.downloadad.api.nr pn() {
        if (this.pn == null) {
            this.pn = nr.u();
        }
        return this.pn;
    }

    public void x() {
        pn.u().iz();
    }

    private jk(Context context) {
        this.fx = n.u();
        this.nr = new iz();
        this.iz = System.currentTimeMillis();
        nr(context);
        this.b = u.u();
    }

    private void nr(Context context) {
        l.u(context);
        Downloader.getInstance(l.getContext());
        com.ss.android.downloadlib.addownload.nr.iz.u().nr();
        com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), "misc_config", new com.ss.android.downloadlib.fx.x(), new com.ss.android.downloadlib.fx.iz(context), new fx());
        com.ss.android.downloadlib.fx.b bVar = new com.ss.android.downloadlib.fx.b();
        com.ss.android.socialbase.appdownloader.b.t().u(bVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(bVar);
        com.ss.android.socialbase.appdownloader.b.t().u(new s());
        com.ss.android.socialbase.downloader.downloader.fx.u(new com.ss.android.downloadlib.fx.pn());
        com.ss.android.socialbase.appdownloader.b.t().u(com.ss.android.downloadlib.iz.fx.u());
    }

    public static jk u(final Context context) {
        if (u == null) {
            synchronized (jk.class) {
                if (u == null) {
                    com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.1
                        @Override // java.lang.Runnable
                        public void run() {
                            jk unused = jk.u = new jk(context);
                        }
                    });
                }
            }
        }
        return u;
    }

    public com.ss.android.download.api.u u() {
        return this.nr;
    }

    public com.ss.android.download.api.u u(String str) {
        com.ss.android.download.api.config.iz izVarNr = x.u().nr();
        if (izVarNr != null && izVarNr.u(str)) {
            return izVarNr.nr(str);
        }
        return this.nr;
    }

    public long nr() {
        return this.iz;
    }

    public DownloadInfo nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), str);
    }

    @MainThread
    public void u(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.4
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    public void u(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.5
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void u(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.6
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void u(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.7
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void u(final String str, final int i) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.2
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(str, i);
            }
        });
    }

    @MainThread
    public void u(final String str, final boolean z) {
        com.ss.android.downloadlib.pn.nr.u(new Runnable() { // from class: com.ss.android.downloadlib.jk.3
            @Override // java.lang.Runnable
            public void run() {
                jk.this.n().u(str, z);
            }
        });
    }

    public void u(com.ss.android.download.api.download.u.u uVar) {
        n().u(uVar);
    }

    public DownloadInfo u(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return nr(str);
        }
        return Downloader.getInstance(l.getContext()).getDownloadInfo(str, str2);
    }
}
