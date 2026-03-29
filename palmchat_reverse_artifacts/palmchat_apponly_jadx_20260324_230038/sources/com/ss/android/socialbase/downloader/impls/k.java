package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.mv, com.ss.android.socialbase.downloader.downloader.s {
    private static final String u = "k";
    private com.ss.android.socialbase.downloader.downloader.mv b = new my();
    private com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> fx;
    private volatile com.ss.android.socialbase.downloader.downloader.a nr;

    public k() {
        com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> kVarGi = com.ss.android.socialbase.downloader.downloader.fx.gi();
        this.fx = kVarGi;
        kVarGi.u(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<com.ss.android.socialbase.downloader.model.nr> a(int i) {
        if (this.nr == null) {
            return this.b.a(i);
        }
        try {
            return this.nr.a(i);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void b(int i) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.b(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public IDownloadFileUriProvider bg(int i) {
        if (this.nr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.jk.x.u(this.nr.bg(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void fx(int i) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.fx(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int iz(int i) {
        if (this.nr == null) {
            return 0;
        }
        try {
            return this.nr.iz(i);
        } catch (RemoteException unused) {
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void jk(int i) {
        if (this.nr == null) {
            this.b.jk(i);
        } else {
            try {
                this.nr.jk(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void k(int i) {
        if (this.nr == null) {
            this.b.k(i);
        } else {
            try {
                this.nr.k(i);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean l(int i) {
        if (this.nr == null) {
            return false;
        }
        try {
            return this.nr.t(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int mv(int i) {
        if (this.nr == null) {
            return com.ss.android.socialbase.downloader.downloader.b.u().nr(i);
        }
        try {
            return this.nr.mv(i);
        } catch (RemoteException unused) {
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean my(int i) {
        if (this.nr == null) {
            return this.b.my(i);
        }
        try {
            return this.nr.my(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public DownloadInfo n(int i) {
        if (this.nr == null) {
            return this.b.n(i);
        }
        try {
            return this.nr.n(i);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public z o(int i) {
        if (this.nr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.jk.x.u(this.nr.o(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public long pn(int i) {
        if (this.nr == null) {
            return 0L;
        }
        try {
            return this.nr.pn(i);
        } catch (RemoteException unused) {
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean s(int i) {
        if (this.nr == null) {
            return this.b.s(i);
        }
        try {
            return this.nr.s(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> kVar = this.fx;
        if (kVar != null) {
            kVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public ja sx(int i) {
        if (this.nr == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.jk.x.u(this.nr.sx(i));
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void t(int i) {
        com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> kVar = this.fx;
        if (kVar != null) {
            kVar.u(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u(i);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean x(int i) {
        if (this.nr == null) {
            return false;
        }
        try {
            return this.nr.x(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean nr(int i) {
        if (this.nr == null) {
            return false;
        }
        try {
            return this.nr.nr(i);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> b() {
        if (this.nr == null) {
            return this.b.b();
        }
        try {
            return this.nr.nr();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> fx(String str) {
        if (this.nr == null) {
            return this.b.fx(str);
        }
        try {
            return this.nr.fx(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void iz() {
        if (this.nr == null) {
            this.b.iz();
        } else {
            try {
                this.nr.pn();
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> pn(String str) {
        if (this.nr == null) {
            return null;
        }
        try {
            return this.nr.b(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, boolean z) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u(i, z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean x() {
        return this.nr != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public void n() {
        this.nr = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public DownloadInfo nr(String str, String str2) {
        return n(u(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean pn() {
        if (this.nr == null) {
            return this.b.pn();
        }
        try {
            return this.nr.b();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u() {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> b(String str) {
        if (this.nr == null) {
            return this.b.b(str);
        }
        try {
            return this.nr.pn(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean fx() {
        return com.ss.android.socialbase.downloader.downloader.fx.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> nr(String str) {
        if (this.nr == null) {
            return this.b.nr(str);
        }
        try {
            return this.nr.nr(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void fx(int i, boolean z) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.b(i, z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public List<DownloadInfo> u(String str) {
        if (this.nr == null) {
            return this.b.u(str);
        }
        try {
            return this.nr.u(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean fx(DownloadInfo downloadInfo) {
        if (this.nr == null) {
            return this.b.fx(downloadInfo);
        }
        try {
            return this.nr.nr(downloadInfo);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(List<String> list) {
        if (this.nr == null) {
            this.b.nr(list);
        } else {
            try {
                this.nr.nr(list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public int u(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.fx.u(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(List<String> list) {
        if (this.nr == null) {
            this.b.u(list);
        } else {
            try {
                this.nr.u(list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, boolean z) {
        if (this.nr == null) {
            this.b.nr(i, z);
        } else {
            try {
                this.nr.nr(i, z);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.nr(i, i2, com.ss.android.socialbase.downloader.jk.x.u(iDownloadListener, izVar != com.ss.android.socialbase.downloader.constants.iz.SUB), izVar.ordinal(), z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u(i, i2, com.ss.android.socialbase.downloader.jk.x.u(iDownloadListener, izVar != com.ss.android.socialbase.downloader.constants.iz.SUB), izVar.ordinal(), z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z, boolean z2) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u(i, i2, com.ss.android.socialbase.downloader.jk.x.u(iDownloadListener, izVar != com.ss.android.socialbase.downloader.constants.iz.SUB), izVar.ordinal(), z, z2);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean nr() {
        if (this.nr == null) {
            com.ss.android.socialbase.downloader.fx.u.b(u, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "aidlService.isServiceForeground");
        try {
            return this.nr.iz();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public boolean u(DownloadInfo downloadInfo) {
        if (this.nr == null) {
            return this.b.u(downloadInfo);
        }
        try {
            this.nr.u(downloadInfo);
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> kVar;
        if (downloadTask == null || (kVar = this.fx) == null) {
            return;
        }
        kVar.fx(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, Notification notification) {
        if (this.nr == null) {
            com.ss.android.socialbase.downloader.fx.u.b(u, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.nr.u(i, notification);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        if (this.nr == null) {
            this.b.nr(i, list);
        } else {
            try {
                this.nr.u(i, list);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(boolean z, boolean z2) {
        if (this.nr == null) {
            com.ss.android.socialbase.downloader.fx.u.b(u, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.fx(u, "aidlService.stopForeground");
        try {
            this.nr.u(z2);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.k<CSJIndependentProcessDownloadService> kVar;
        if (downloadTask == null || (kVar = this.fx) == null) {
            return;
        }
        kVar.nr(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.nr(i, list);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        if (this.nr == null) {
            this.b.u(nrVar);
        } else {
            try {
                this.nr.u(nrVar);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, long j) {
        if (this.nr == null) {
            this.b.u(i, i2, j);
        } else {
            try {
                this.nr.u(i, i2, j);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, int i3, long j) {
        if (this.nr == null) {
            this.b.u(i, i2, i3, j);
        } else {
            try {
                this.nr.u(i, i2, i3, j);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2, int i3, int i4) {
        if (this.nr == null) {
            this.b.u(i, i2, i3, i4);
        } else {
            try {
                this.nr.u(i, i2, i3, i4);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(m mVar) {
        if (this.nr != null) {
            try {
                this.nr.u(com.ss.android.socialbase.downloader.jk.x.u(mVar));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, int i2) {
        if (this.nr != null) {
            try {
                this.nr.u(i, i2);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, z zVar) {
        if (this.nr != null) {
            try {
                this.nr.u(i, com.ss.android.socialbase.downloader.jk.x.u(zVar));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public void u(IBinder iBinder) {
        this.nr = a.u.u(iBinder);
        if (com.ss.android.socialbase.downloader.jk.iz.u()) {
            u(new m() { // from class: com.ss.android.socialbase.downloader.impls.k.1
                @Override // com.ss.android.socialbase.downloader.depend.m
                public void u(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).pause(i);
                        List<com.ss.android.socialbase.downloader.model.nr> listA = l.u(false).a(i);
                        if (listA != null) {
                            l.u(true).u(i, com.ss.android.socialbase.downloader.jk.iz.u(listA));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mv
    public void u(int i, long j) {
        if (this.nr == null) {
            return;
        }
        try {
            this.nr.u(i, j);
        } catch (RemoteException unused) {
        }
    }
}
