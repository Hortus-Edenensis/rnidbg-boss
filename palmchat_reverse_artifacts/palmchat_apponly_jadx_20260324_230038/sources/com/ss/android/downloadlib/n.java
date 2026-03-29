package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {
    private static volatile n u;
    private long iz;
    private final List<com.ss.android.downloadlib.addownload.x> fx = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.x> b = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> pn = new CopyOnWriteArrayList<>();
    private final Handler nr = new Handler(Looper.getMainLooper());

    private n() {
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.x xVar : this.fx) {
            if (!xVar.nr() && jCurrentTimeMillis - xVar.b() > 300000) {
                xVar.n();
                arrayList.add(xVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.fx.removeAll(arrayList);
    }

    private void fx(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.pn pnVar = new com.ss.android.downloadlib.addownload.pn();
        pnVar.nr(context).nr(i, downloadStatusChangeListener).nr(downloadModel).u();
        this.b.put(downloadModel.getDownloadUrl(), pnVar);
    }

    private synchronized void nr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.fx.size() <= 0) {
            fx(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.ss.android.downloadlib.addownload.x xVarRemove = this.fx.remove(0);
        xVarRemove.nr(context).nr(i, downloadStatusChangeListener).nr(downloadModel).u();
        this.b.put(downloadModel.getDownloadUrl(), xVarRemove);
    }

    public static n u() {
        if (u == null) {
            synchronized (n.class) {
                if (u == null) {
                    u = new n();
                }
            }
        }
        return u;
    }

    private void fx() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.iz < 300000) {
            return;
        }
        this.iz = jCurrentTimeMillis;
        if (this.fx.isEmpty()) {
            return;
        }
        b();
    }

    public void u(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.x xVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = l.a().optInt("filter_download_url_key", 0) == 1;
        String strU = com.ss.android.downloadlib.addownload.iz.u().u(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strU)) {
            xVar = this.b.get(strU);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strU);
                }
            }
        } else {
            xVar = this.b.get(downloadModel.getDownloadUrl());
        }
        if (xVar != null) {
            xVar.nr(context).nr(i, downloadStatusChangeListener).nr(downloadModel).u();
            return;
        }
        if (this.fx.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strU)) {
                    nr(context, i, downloadStatusChangeListener, downloadModel, strU);
                    return;
                }
                String strU2 = com.ss.android.downloadlib.addownload.iz.u().u(downloadModel);
                if (!TextUtils.isEmpty(strU2)) {
                    nr(context, i, downloadStatusChangeListener, downloadModel, strU2);
                    if (downloadModel instanceof AdDownloadModel) {
                        AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                        if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(strU2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            fx(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strU)) {
                u(context, i, downloadStatusChangeListener, downloadModel, strU);
                return;
            }
            String strU3 = com.ss.android.downloadlib.addownload.iz.u().u(downloadModel);
            if (TextUtils.isEmpty(strU3)) {
                nr(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            u(context, i, downloadStatusChangeListener, downloadModel, strU3);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(strU3);
                    return;
                }
                return;
            }
            return;
        }
        nr(context, i, downloadStatusChangeListener, downloadModel);
    }

    private void nr(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.pn pnVar = new com.ss.android.downloadlib.addownload.pn();
        pnVar.nr(context).nr(i, downloadStatusChangeListener).nr(downloadModel).u(str).u();
        this.b.put(str, pnVar);
        com.ss.android.downloadlib.addownload.iz.u().u(str, downloadModel.getDownloadUrl());
    }

    public void nr(final DownloadInfo downloadInfo, final String str) {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.n.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : n.this.pn) {
                    if (obj instanceof com.ss.android.download.api.download.u.u) {
                        ((com.ss.android.download.api.download.u.u) obj).u(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u.u) {
                            ((com.ss.android.download.api.download.u.u) softReference.get()).u(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler nr() {
        return this.nr;
    }

    public com.ss.android.downloadlib.addownload.pn u(String str) {
        com.ss.android.downloadlib.addownload.x xVar;
        Map<String, com.ss.android.downloadlib.addownload.x> map = this.b;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (l.a().optInt("filter_download_url_key", 0) == 1) {
                xVar = this.b.get(com.ss.android.downloadlib.addownload.iz.u().u(str));
            } else {
                xVar = this.b.get(str);
            }
            if (xVar instanceof com.ss.android.downloadlib.addownload.pn) {
                return (com.ss.android.downloadlib.addownload.pn) xVar;
            }
        }
        return null;
    }

    private synchronized void u(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.fx.size() <= 0) {
            nr(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.ss.android.downloadlib.addownload.x xVarRemove = this.fx.remove(0);
        xVarRemove.nr(context).nr(i, downloadStatusChangeListener).nr(downloadModel).u(str).u();
        this.b.put(str, xVarRemove);
        com.ss.android.downloadlib.addownload.iz.u().u(str, downloadModel.getDownloadUrl());
    }

    public void u(String str, int i) {
        com.ss.android.downloadlib.addownload.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = l.a().optInt("filter_download_url_key", 0) == 1;
        String strU = com.ss.android.downloadlib.addownload.iz.u().u(str);
        if (z && !TextUtils.isEmpty(strU)) {
            xVar = this.b.get(strU);
        } else {
            xVar = this.b.get(str);
        }
        if (xVar != null) {
            if (xVar.u(i)) {
                this.fx.add(xVar);
                if (z && !TextUtils.isEmpty(strU)) {
                    this.b.remove(strU);
                    com.ss.android.downloadlib.addownload.iz.u().nr(strU);
                } else {
                    this.b.remove(str);
                }
            }
            fx();
        }
    }

    public void u(String str, boolean z) {
        com.ss.android.downloadlib.addownload.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = l.a().optInt("filter_download_url_key", 0) == 1;
        String strU = com.ss.android.downloadlib.addownload.iz.u().u(str);
        if (z2 && !TextUtils.isEmpty(strU)) {
            xVar = this.b.get(strU);
        } else {
            xVar = this.b.get(str);
        }
        if (xVar != null) {
            xVar.u(z);
        }
    }

    public void u(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        u(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void u(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        u(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void u(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.x xVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = l.a().optInt("filter_download_url_key", 0) == 1;
        String strU = com.ss.android.downloadlib.addownload.iz.u().u(str);
        if (z && !TextUtils.isEmpty(strU)) {
            xVar = this.b.get(strU);
        } else {
            xVar = this.b.get(str);
        }
        if (xVar != null) {
            xVar.u(j).nr(downloadEventConfig).nr(downloadController).u(onItemClickListener).u(iDownloadButtonClickListener).nr(i);
        }
    }

    public void u(com.ss.android.download.api.download.u.u uVar) {
        if (uVar != null) {
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("fix_listener_oom", false)) {
                this.pn.add(new SoftReference(uVar));
            } else {
                this.pn.add(uVar);
            }
        }
    }

    public void u(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.n.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : n.this.pn) {
                    if (!(obj instanceof com.ss.android.download.api.download.u.u) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u.u) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void u(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.n.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : n.this.pn) {
                    if (!(obj instanceof com.ss.android.download.api.download.u.u) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u.u) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void u(final DownloadInfo downloadInfo, final String str) {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.n.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : n.this.pn) {
                    if (!(obj instanceof com.ss.android.download.api.download.u.u) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u.u) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void u(final DownloadInfo downloadInfo) {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.n.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : n.this.pn) {
                    if (!(obj instanceof com.ss.android.download.api.download.u.u) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u.u) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }
}
