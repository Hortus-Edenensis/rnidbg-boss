package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.n;
import com.ss.android.socialbase.downloader.downloader.bq;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.ss.android.socialbase.downloader.downloader.jk {
    private volatile boolean b;
    private volatile boolean fx;
    private com.ss.android.socialbase.downloader.a.n iz;
    private bq nr;
    private n.u pn = new n.u() { // from class: com.ss.android.socialbase.downloader.impls.b.1
        @Override // com.ss.android.socialbase.downloader.a.n.u
        public void u(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    };
    private final t u = new t();

    public b() {
        this.iz = null;
        if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_sigbus_downloader_db") && !com.ss.android.socialbase.downloader.jk.iz.u() && com.ss.android.socialbase.downloader.downloader.fx.su()) {
            this.nr = com.ss.android.socialbase.downloader.downloader.fx.mh().u(new fx.u.InterfaceC0874u() { // from class: com.ss.android.socialbase.downloader.impls.b.2
                @Override // com.ss.android.socialbase.downloader.downloader.fx.u.InterfaceC0874u
                public void u() {
                    b.this.nr = new com.ss.android.socialbase.downloader.nr.pn();
                    com.bytedance.sdk.component.utils.k.nr("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        } else {
            this.nr = new com.ss.android.socialbase.downloader.nr.pn();
        }
        this.fx = false;
        this.iz = new com.ss.android.socialbase.downloader.a.n(Looper.getMainLooper(), this.pn);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        synchronized (this) {
            this.fx = true;
            notifyAll();
        }
    }

    public void a() {
        List<String> listU;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.fx) {
            if (this.b) {
                com.ss.android.socialbase.downloader.fx.u.nr("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.b = true;
            if (com.ss.android.socialbase.downloader.jk.iz.u()) {
                com.ss.android.socialbase.downloader.downloader.l lVarQq = com.ss.android.socialbase.downloader.downloader.fx.qq();
                if (lVarQq != null) {
                    listU = lVarQq.u();
                    arrayList = (listU == null || listU.isEmpty()) ? null : new ArrayList();
                } else {
                    listU = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayU = this.u.u();
                    for (int i = 0; i < sparseArrayU.size(); i++) {
                        int iKeyAt = sparseArrayU.keyAt(i);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayU.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    if (iKeyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(iKeyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.b.u.u(com.ss.android.socialbase.downloader.downloader.fx.x(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listU != null && arrayList != null && downloadInfo.getMimeType() != null && listU.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).nr("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (lVarQq == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                lVarQq.u(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean b() {
        return this.fx;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> fx(String str) {
        return this.u.fx(str);
    }

    public bq iz() {
        return this.nr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public Map<Long, com.ss.android.socialbase.downloader.iz.a> l(int i) {
        Map<Long, com.ss.android.socialbase.downloader.iz.a> mapL = this.u.l(i);
        if (mapL != null && !mapL.isEmpty()) {
            return mapL;
        }
        Map<Long, com.ss.android.socialbase.downloader.iz.a> mapL2 = this.nr.l(i);
        this.u.u(i, mapL2);
        return mapL2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void mv(int i) {
        this.u.mv(i);
        this.nr.mv(i);
    }

    public void n() {
        this.iz.sendMessageDelayed(this.iz.obtainMessage(1), com.ss.android.socialbase.downloader.n.u.fx().u("task_resume_delay") ? 4000L : Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean pn() {
        if (this.fx) {
            return true;
        }
        synchronized (this) {
            if (!this.fx) {
                com.ss.android.socialbase.downloader.fx.u.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException unused) {
                }
                com.ss.android.socialbase.downloader.fx.u.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.fx;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<com.ss.android.socialbase.downloader.iz.a> s(int i) {
        List<com.ss.android.socialbase.downloader.iz.a> listS = this.u.s(i);
        return (listS == null || listS.size() == 0) ? this.nr.s(i) : listS;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoX = this.u.x(i);
        fx(downloadInfoX);
        return downloadInfoX;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> b(String str) {
        return this.u.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<com.ss.android.socialbase.downloader.model.nr> fx(int i) {
        return this.u.fx(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean iz(int i) {
        com.ss.android.socialbase.downloader.downloader.mv mvVarU;
        if (!com.ss.android.socialbase.downloader.jk.iz.nr() || (mvVarU = l.u(true)) == null) {
            this.nr.iz(i);
        } else {
            mvVarU.my(i);
        }
        return this.u.iz(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo nr(int i) {
        return this.u.nr(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void b(int i) {
        this.u.b(i);
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.k(i);
                return;
            } else {
                this.nr.b(i);
                return;
            }
        }
        this.nr.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void fx() {
        try {
            this.u.fx();
        } catch (SQLiteException unused) {
        }
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.iz();
                return;
            } else {
                this.nr.fx();
                return;
            }
        }
        this.nr.fx();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> nr(String str) {
        return this.u.nr(str);
    }

    public t u() {
        return this.u;
    }

    public void x() {
        List<com.ss.android.socialbase.downloader.model.nr> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.fx.u(com.ss.android.socialbase.downloader.constants.b.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArray2 = new SparseArray<>();
        synchronized (this.u) {
            SparseArray<DownloadInfo> sparseArrayU = this.u.u();
            for (int i = 0; i < sparseArrayU.size(); i++) {
                int iKeyAt = sparseArrayU.keyAt(i);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayU.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArrayIz = this.u.iz();
            for (int i2 = 0; i2 < sparseArrayIz.size(); i2++) {
                int iKeyAt2 = sparseArrayIz.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayIz.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.nr.u(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.nr.b() { // from class: com.ss.android.socialbase.downloader.impls.b.3
            @Override // com.ss.android.socialbase.downloader.nr.b
            public void u() {
                synchronized (b.this.u) {
                    SparseArray<DownloadInfo> sparseArrayU2 = b.this.u.u();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayU2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArrayIz2 = b.this.u.iz();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayIz2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                b.this.jk();
                b.this.n();
                com.ss.android.socialbase.downloader.downloader.fx.u(com.ss.android.socialbase.downloader.constants.b.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> nr() {
        return this.u.nr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public List<DownloadInfo> u(String str) {
        return this.u.u(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo jk(int i) {
        DownloadInfo downloadInfoJk = this.u.jk(i);
        fx(downloadInfoJk);
        return downloadInfoJk;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo n(int i) {
        DownloadInfo downloadInfoN = this.u.n(i);
        fx(downloadInfoN);
        return downloadInfoN;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(com.ss.android.socialbase.downloader.model.nr nrVar) {
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.u(nrVar);
                return;
            } else {
                this.nr.u(nrVar);
                return;
            }
        }
        this.nr.u(nrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        synchronized (this.u) {
            this.u.u(nrVar);
        }
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.u(nrVar);
                return;
            } else {
                this.nr.u(nrVar);
                return;
            }
        }
        this.nr.u(nrVar);
    }

    private void fx(DownloadInfo downloadInfo) {
        u(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo b(int i, long j) {
        DownloadInfo downloadInfoB = this.u.b(i, j);
        nr(i, (List<com.ss.android.socialbase.downloader.model.nr>) null);
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo fx(int i, long j) {
        DownloadInfo downloadInfoFx = this.u.fx(i, j);
        nr(i, (List<com.ss.android.socialbase.downloader.model.nr>) null);
        return downloadInfoFx;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo nr(int i, long j) {
        DownloadInfo downloadInfoNr = this.u.nr(i, j);
        nr(i, (List<com.ss.android.socialbase.downloader.model.nr>) null);
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean pn(int i) {
        com.ss.android.socialbase.downloader.downloader.mv mvVarU;
        try {
            if (com.ss.android.socialbase.downloader.jk.iz.nr() && (mvVarU = l.u(true)) != null) {
                mvVarU.s(i);
            } else {
                this.nr.pn(i);
            }
        } catch (SQLiteException unused) {
        }
        return this.u.pn(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.u.u(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        try {
            u(this.u.nr(i));
            if (list == null) {
                list = this.u.fx(i);
            }
            if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
                com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
                if (mvVarU != null) {
                    mvVarU.nr(i, list);
                    return;
                } else {
                    this.nr.nr(i, list);
                    return;
                }
            }
            this.nr.nr(i, list);
        } catch (Exception unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, long j) {
        this.u.u(i, i2, j);
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.u(i, i2, j);
                return;
            } else {
                this.nr.u(i, i2, j);
                return;
            }
        }
        this.nr.u(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.u(i, i2, i3, j);
                return;
            } else {
                this.nr.u(i, i2, i3, j);
                return;
            }
        }
        this.nr.u(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.jk.iz.nr()) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.u(i, i2, i3, i4);
                return;
            } else {
                this.nr.u(i, i2, i3, i4);
                return;
            }
        }
        this.nr.u(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, int i2) {
        DownloadInfo downloadInfoU = this.u.u(i, i2);
        fx(downloadInfoU);
        return downloadInfoU;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zU = this.u.u(downloadInfo);
        fx(downloadInfo);
        return zU;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoU = this.u.u(i, j, str, str2);
        fx(downloadInfoU);
        return downloadInfoU;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo a(int i) {
        DownloadInfo downloadInfoA = this.u.a(i);
        fx(downloadInfoA);
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j) {
        DownloadInfo downloadInfoU = this.u.u(i, j);
        u(downloadInfoU, false);
        return downloadInfoU;
    }

    private void u(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.jk.iz.nr()) {
            this.nr.u(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.mv mvVarU = l.u(true);
            if (mvVarU != null) {
                mvVarU.fx(downloadInfo);
            } else {
                this.nr.u(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.u.u(i, list);
        if (com.ss.android.socialbase.downloader.jk.iz.fx()) {
            this.nr.nr(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean u(int i, Map<Long, com.ss.android.socialbase.downloader.iz.a> map) {
        this.u.u(i, map);
        this.nr.u(i, map);
        return false;
    }
}
