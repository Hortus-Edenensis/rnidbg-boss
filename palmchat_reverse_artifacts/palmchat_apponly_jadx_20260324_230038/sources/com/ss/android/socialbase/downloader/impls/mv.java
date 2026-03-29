package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.kj;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.xg;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class mv extends a.u {
    private static final String u = "mv";
    private final com.ss.android.socialbase.downloader.downloader.mv nr = new my(true);

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<com.ss.android.socialbase.downloader.model.nr> a(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void b(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public com.ss.android.socialbase.downloader.depend.x bg(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.jk.x.u(mvVar.bg(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void fx(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.fx(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public int iz(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return 0;
        }
        return mvVar.iz(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void jk(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.jk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void k(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.k(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void l(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.t(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public int mv(int i) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.b.u().nr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean my(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.my(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public DownloadInfo n(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.n(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean nr(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.nr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public kj o(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.jk.x.u(mvVar.o(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public long pn(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return 0L;
        }
        return mvVar.pn(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean s(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.s(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public rh sx(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.jk.x.u(mvVar.sx(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean t(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.l(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(com.ss.android.socialbase.downloader.model.u uVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.nr(com.ss.android.socialbase.downloader.jk.x.u(uVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean x(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.x(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> b(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.pn(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> fx(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.fx(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean iz() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.nr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public DownloadInfo nr(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.nr(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> pn(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean b() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.pn();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void fx(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.nr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> nr(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.nr(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void pn() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.iz();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void b(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.b.u().nr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean fx() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.fx();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> nr() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void nr(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar != null) {
            mvVar.nr(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public List<DownloadInfo> u(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return null;
        }
        return mvVar.u(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void nr(int i, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.nr(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public int u(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return 0;
        }
        return mvVar.u(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void nr(int i, int i2, com.ss.android.socialbase.downloader.depend.a aVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2, com.ss.android.socialbase.downloader.jk.x.u(aVar), com.ss.android.socialbase.downloader.jk.iz.pn(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean nr(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.fx(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2, com.ss.android.socialbase.downloader.depend.a aVar, int i3, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.nr(i, i2, com.ss.android.socialbase.downloader.jk.x.u(aVar), com.ss.android.socialbase.downloader.jk.iz.pn(i3), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2, com.ss.android.socialbase.downloader.depend.a aVar, int i3, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2, com.ss.android.socialbase.downloader.jk.x.u(aVar), com.ss.android.socialbase.downloader.jk.iz.pn(i3), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public boolean u(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return false;
        }
        return mvVar.u(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(nrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2, int i3, int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.nr(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(xg xgVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(com.ss.android.socialbase.downloader.jk.x.u(xgVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void u(int i, kj kjVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.mv mvVar = this.nr;
        if (mvVar == null) {
            return;
        }
        mvVar.u(i, com.ss.android.socialbase.downloader.jk.x.u(kjVar));
    }
}
