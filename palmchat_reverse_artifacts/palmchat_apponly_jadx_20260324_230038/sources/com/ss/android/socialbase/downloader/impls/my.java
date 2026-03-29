package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class my implements com.ss.android.socialbase.downloader.downloader.mv {
    private final boolean b;
    private final com.ss.android.socialbase.downloader.downloader.k fx;
    private final com.ss.android.socialbase.downloader.downloader.jk nr;
    private final u u;

    public my() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<com.ss.android.socialbase.downloader.model.nr> a(int i) {
        return this.nr.fx(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void b(int i) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.x(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public IDownloadFileUriProvider bg(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.jk(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void fx(int i) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.iz(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int iz(int i) {
        DownloadInfo downloadInfoB;
        u uVar = this.u;
        if (uVar == null || (downloadInfoB = uVar.b(i)) == null) {
            return 0;
        }
        return downloadInfoB.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void jk(int i) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.mv(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void k(int i) {
        this.nr.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean l(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.t(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int mv(int i) {
        return com.ss.android.socialbase.downloader.downloader.b.u().u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean my(int i) {
        return this.nr.iz(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public DownloadInfo n(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.b(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean nr(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.s(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public z o(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.a(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public long pn(int i) {
        DownloadInfo downloadInfoNr;
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.nr;
        if (jkVar == null || (downloadInfoNr = jkVar.nr(i)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfoNr.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfoNr.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.nr> listFx = this.nr.fx(i);
        if (listFx == null || listFx.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.jk.iz.nr(listFx);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean s(int i) {
        return this.nr.pn(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public ja sx(int i) {
        u uVar = this.u;
        ja jaVarN = uVar != null ? uVar.n(i) : null;
        return jaVarN == null ? com.ss.android.socialbase.downloader.downloader.fx.jp() : jaVarN;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void t(int i) {
        com.ss.android.socialbase.downloader.fx.u.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.pn(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean x(int i) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.u(i);
        }
        return false;
    }

    public my(boolean z) {
        this.u = com.ss.android.socialbase.downloader.downloader.fx.rh();
        this.nr = com.ss.android.socialbase.downloader.downloader.fx.kj();
        if (z) {
            this.fx = com.ss.android.socialbase.downloader.downloader.fx.gi();
        } else {
            this.fx = com.ss.android.socialbase.downloader.downloader.fx.z();
        }
        this.b = com.ss.android.socialbase.downloader.n.u.fx().nr("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> b() {
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.nr;
        if (jkVar != null) {
            return jkVar.nr();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> fx(String str) {
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.nr;
        if (jkVar != null) {
            return jkVar.fx(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> nr(String str) {
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.nr;
        if (jkVar != null) {
            return jkVar.nr(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, boolean z) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean x() {
        com.ss.android.socialbase.downloader.downloader.k kVar;
        return this.b && (kVar = this.fx) != null && kVar.u();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void iz() {
        this.nr.fx();
    }

    public void b(int i, boolean z) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.fx(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean fx() {
        return com.ss.android.socialbase.downloader.downloader.fx.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(List<String> list) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.nr(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u() {
        u uVar = this.u;
        if (uVar != null) {
            uVar.nr();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void fx(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.b.u().u(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> b(String str) {
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.nr;
        if (jkVar != null) {
            return jkVar.b(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean fx(DownloadInfo downloadInfo) {
        return this.nr.u(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public DownloadInfo nr(String str, String str2) {
        return n(com.ss.android.socialbase.downloader.downloader.fx.u(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(List<String> list) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> pn(String str) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.nr(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, boolean z) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.nr(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> u(String str) {
        u uVar = this.u;
        if (uVar != null) {
            return uVar.u(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean pn() {
        return this.nr.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u(i, i2, iDownloadListener, izVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int u(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.fx.u(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.nr(i, i2, iDownloadListener, izVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean nr() {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.fx;
        if (kVar != null) {
            return kVar.nr();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z, boolean z2) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u(i, i2, iDownloadListener, izVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.fx;
        if (kVar != null) {
            kVar.fx(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (zU) {
            if (com.ss.android.socialbase.downloader.jk.u.u(33554432)) {
                nr(downloadInfo.getId(), true);
            } else {
                b(downloadInfo.getId(), true);
            }
        }
        return zU;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(DownloadInfo downloadInfo) {
        this.nr.nr(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        this.nr.nr(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.fx;
        if (kVar != null) {
            kVar.u(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.fx;
        if (kVar != null) {
            kVar.u(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.fx;
        if (kVar != null) {
            kVar.nr(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        this.nr.u(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        this.nr.u(nrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, long j) {
        this.nr.u(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, int i3, long j) {
        this.nr.u(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, int i3, int i4) {
        this.nr.u(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(m mVar) {
        com.ss.android.socialbase.downloader.downloader.fx.u(mVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.fx.pn() != null) {
            for (m mVar : com.ss.android.socialbase.downloader.downloader.fx.pn()) {
                if (mVar != null) {
                    mVar.u(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, z zVar) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u(i, zVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, long j) {
        u uVar = this.u;
        if (uVar != null) {
            uVar.nr(i, j);
        }
    }
}
