package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private static volatile fx nr = null;
    private static String u = "fx";
    private ConcurrentHashMap<Long, Runnable> fx;

    public fx() {
        this.fx = null;
        this.fx = new ConcurrentHashMap<>();
    }

    public static fx u() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    public long nr() {
        return l.a().optLong("quick_app_check_internal", 1200L);
    }

    public void u(pn pnVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                u(id, false, 2);
                pnVar.nr(false);
                return;
            } else {
                u(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                u(id, false, 1);
                pnVar.fx(false);
                return;
            } else {
                u(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.fx.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.b.u.u().u(id, 1);
            u(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.n.u().nr().post(runnableRemove);
            }
            u(id, false, 1);
        }
    }

    private void u(long j, boolean z, int i) {
        com.ss.android.downloadlib.b.u.u().u(j, z, i);
        if (z) {
            l.dw();
        }
    }

    public void u(final pn pnVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.nr.pn.u().u(new com.ss.android.downloadlib.nr.b() { // from class: com.ss.android.downloadlib.addownload.fx.1
            @Override // com.ss.android.downloadlib.nr.b
            public void u(boolean z) {
                fx.this.u(pnVar, z, i, downloadModel);
            }
        }, nr());
    }

    public static boolean u(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
