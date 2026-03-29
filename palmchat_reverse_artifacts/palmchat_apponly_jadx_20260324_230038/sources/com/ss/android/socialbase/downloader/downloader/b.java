package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.d;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static volatile b u;
    private volatile SparseArray<Boolean> nr = new SparseArray<>();
    private Handler fx = new Handler(Looper.getMainLooper());
    private volatile List<d> b = new ArrayList();

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                u = new b();
            }
        }
        return u;
    }

    public int a(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return 0;
        }
        return mvVarFx.iz(i);
    }

    public void b(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.u(i);
    }

    public mv fx(int i) {
        return com.ss.android.socialbase.downloader.impls.l.u(u(i) == 1 && !com.ss.android.socialbase.downloader.jk.iz.fx());
    }

    public void iz(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.fx(i);
    }

    public boolean jk(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return false;
        }
        return mvVarFx.x(i);
    }

    public boolean k(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return false;
        }
        return mvVarFx.l(i);
    }

    public z l(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return null;
        }
        return mvVarFx.o(i);
    }

    public ja mv(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return null;
        }
        return mvVarFx.sx(i);
    }

    public void my(int i) {
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU != null) {
            mvVarU.t(i);
        }
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU2 != null) {
            mvVarU2.t(i);
        }
    }

    public long n(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return 0L;
        }
        return mvVarFx.pn(i);
    }

    public void nr(d dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.contains(dVar)) {
                this.b.remove(dVar);
            }
        }
    }

    public void o(int i) {
        if (i == 0) {
            return;
        }
        nr(i, true);
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU == null) {
            return;
        }
        mvVarU.startService();
    }

    public boolean pn(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return false;
        }
        return mvVarFx.nr(i);
    }

    public void s(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.jk(i);
    }

    public IDownloadFileUriProvider sx(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return null;
        }
        return mvVarFx.bg(i);
    }

    public DownloadInfo t(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return null;
        }
        return mvVarFx.n(i);
    }

    public void x(int i) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.b(i);
    }

    public void fx(int i, boolean z) {
        if (!com.ss.android.socialbase.downloader.jk.iz.u()) {
            mv mvVarFx = fx(i);
            if (mvVarFx != null) {
                mvVarFx.u(i, z);
            }
            com.ss.android.socialbase.downloader.impls.l.u(true).u(2, i);
            return;
        }
        if (com.ss.android.socialbase.downloader.jk.u.u(8388608)) {
            mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(true);
            if (mvVarU != null) {
                mvVarU.u(i, z);
            }
            mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(false);
            if (mvVarU2 != null) {
                mvVarU2.u(i, z);
                return;
            }
            return;
        }
        mv mvVarU3 = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU3 != null) {
            mvVarU3.u(i, z);
        }
        mv mvVarU4 = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU4 != null) {
            mvVarU4.u(i, z);
        }
    }

    public void b(int i, boolean z) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.nr(i, z);
    }

    public boolean iz() {
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU != null) {
            return mvVarU.pn();
        }
        return false;
    }

    public List<DownloadInfo> pn(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        List<DownloadInfo> listPn = mvVarU != null ? mvVarU.pn(str) : null;
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        return u(listPn, mvVarU2 != null ? mvVarU2.pn(str) : null, sparseArray);
    }

    public boolean b() {
        return fx.w();
    }

    public void nr() {
        synchronized (this.b) {
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public List<DownloadInfo> b(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        List<DownloadInfo> listB = mvVarU != null ? mvVarU.b(str) : null;
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        return u(listB, mvVarU2 != null ? mvVarU2.b(str) : null, sparseArray);
    }

    public void u(d dVar) {
        if (dVar == null || com.ss.android.socialbase.downloader.jk.iz.fx()) {
            return;
        }
        com.ss.android.socialbase.downloader.impls.l.u(true);
        synchronized (this.b) {
            if (!this.b.contains(dVar)) {
                this.b.add(dVar);
            }
        }
    }

    public List<DownloadInfo> pn() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        List<DownloadInfo> listB = mvVarU != null ? mvVarU.b() : null;
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        return u(listB, mvVarU2 != null ? mvVarU2.b() : null, sparseArray);
    }

    public synchronized void nr(int i, boolean z) {
        this.nr.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int nr(int i) {
        if (this.nr.get(i) == null) {
            return -1;
        }
        return this.nr.get(i).booleanValue() ? 1 : 0;
    }

    public void u(int i, boolean z) {
        nr(i, z);
        if (fx.su() && !com.ss.android.socialbase.downloader.jk.iz.fx() && com.ss.android.socialbase.downloader.impls.l.u(true).x()) {
            com.ss.android.socialbase.downloader.impls.l.u(true).fx(i, z);
        }
        if (fx.fx() || com.ss.android.socialbase.downloader.jk.iz.fx() || com.ss.android.socialbase.downloader.jk.iz.u()) {
            return;
        }
        try {
            Intent intent = new Intent(fx.oa(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            fx.oa().startService(intent);
        } catch (Throwable unused) {
        }
    }

    private mv nr(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.nr> listA;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.jk.iz.fx() || !com.ss.android.socialbase.downloader.jk.iz.u()) {
            zIsNeedIndependentProcess = true;
        }
        int iU = u(downloadInfo.getId());
        if (iU >= 0 && iU != zIsNeedIndependentProcess) {
            try {
                if (iU == 1) {
                    if (com.ss.android.socialbase.downloader.jk.iz.u()) {
                        com.ss.android.socialbase.downloader.impls.l.u(true).u(downloadInfo.getId());
                        DownloadInfo downloadInfoN = com.ss.android.socialbase.downloader.impls.l.u(true).n(downloadInfo.getId());
                        if (downloadInfoN != null) {
                            com.ss.android.socialbase.downloader.impls.l.u(false).nr(downloadInfoN);
                        }
                        if (downloadInfoN.getChunkCount() > 1 && (listA = com.ss.android.socialbase.downloader.impls.l.u(true).a(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.u(false).u(downloadInfo.getId(), com.ss.android.socialbase.downloader.jk.iz.u(listA));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.jk.iz.u()) {
                    com.ss.android.socialbase.downloader.impls.l.u(false).u(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.nr> listA2 = com.ss.android.socialbase.downloader.impls.l.u(false).a(downloadInfo.getId());
                    if (listA2 != null) {
                        com.ss.android.socialbase.downloader.impls.l.u(true).u(downloadInfo.getId(), com.ss.android.socialbase.downloader.jk.iz.u(listA2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.l.u(true).u(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        u(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.l.u(zIsNeedIndependentProcess);
    }

    public void fx() {
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU != null) {
            mvVarU.u();
        }
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU2 != null) {
            mvVarU2.u();
        }
    }

    public List<DownloadInfo> fx(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        List<DownloadInfo> listFx = mvVarU != null ? mvVarU.fx(str) : null;
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        return u(listFx, mvVarU2 != null ? mvVarU2.fx(str) : null, sparseArray);
    }

    public int u(int i) {
        if (!fx.su()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.jk.iz.fx() && com.ss.android.socialbase.downloader.impls.l.u(true).x()) {
            return com.ss.android.socialbase.downloader.impls.l.u(true).mv(i);
        }
        return nr(i);
    }

    public int u(String str, String str2) {
        return fx.u(str, str2);
    }

    public List<DownloadInfo> u(String str) {
        List<DownloadInfo> listU = com.ss.android.socialbase.downloader.impls.l.u(false).u(str);
        List<DownloadInfo> listU2 = com.ss.android.socialbase.downloader.impls.l.u(true).u(str);
        if (listU == null && listU2 == null) {
            return null;
        }
        if (listU == null || listU2 == null) {
            return listU != null ? listU : listU2;
        }
        ArrayList arrayList = new ArrayList(listU);
        arrayList.addAll(listU2);
        return arrayList;
    }

    public void u(int i, z zVar) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.u(i, zVar);
    }

    private List<DownloadInfo> u(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public DownloadInfo nr(String str, String str2) {
        int iU = u(str, str2);
        mv mvVarFx = fx(iU);
        if (mvVarFx == null) {
            return null;
        }
        return mvVarFx.n(iU);
    }

    public List<DownloadInfo> nr(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        List<DownloadInfo> listNr = mvVarU != null ? mvVarU.nr(str) : null;
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        return u(listNr, mvVarU2 != null ? mvVarU2.nr(str) : null, sparseArray);
    }

    public void u(List<String> list) {
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU != null) {
            mvVarU.u(list);
        }
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU2 != null) {
            mvVarU2.u(list);
        }
    }

    public void nr(List<String> list) {
        mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(false);
        if (mvVarU != null) {
            mvVarU.nr(list);
        }
        mv mvVarU2 = com.ss.android.socialbase.downloader.impls.l.u(true);
        if (mvVarU2 != null) {
            mvVarU2.nr(list);
        }
    }

    public void u(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.nr(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, izVar, z);
    }

    public void u(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z, boolean z2) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.u(i, iDownloadListener.hashCode(), iDownloadListener, izVar, z, z2);
    }

    public void nr(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.iz izVar, boolean z) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.u(i, iDownloadListener.hashCode(), iDownloadListener, izVar, z);
    }

    public boolean u(DownloadInfo downloadInfo) {
        mv mvVarFx;
        if (downloadInfo == null || (mvVarFx = fx(downloadInfo.getId())) == null) {
            return false;
        }
        return mvVarFx.u(downloadInfo);
    }

    public void nr(com.ss.android.socialbase.downloader.depend.t tVar) {
        fx.nr(tVar);
    }

    public void u(final DownloadTask downloadTask) {
        final mv mvVarNr = nr(downloadTask);
        if (mvVarNr == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.b.u.u(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.fx.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.b.1
                @Override // java.lang.Runnable
                public void run() {
                    mvVarNr.u(downloadTask);
                }
            }, 500L);
        } else {
            mvVarNr.u(downloadTask);
        }
    }

    public void u(com.ss.android.socialbase.downloader.depend.t tVar) {
        fx.u(tVar);
    }

    public void u(int i, long j) {
        mv mvVarFx = fx(i);
        if (mvVarFx == null) {
            return;
        }
        mvVarFx.u(i, j);
    }
}
