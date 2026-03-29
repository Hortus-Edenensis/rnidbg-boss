package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t implements com.ss.android.socialbase.downloader.downloader.jk {
    private final SparseArray<DownloadInfo> u = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> nr = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.iz.a>> fx = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo a(int i) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setStatus(1);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean b() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<DownloadInfo> fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.u.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.u.size(); i++) {
            DownloadInfo downloadInfo = this.u.get(this.u.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> iz() {
        return this.nr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo jk(int i) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setStatus(-7);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized Map<Long, com.ss.android.socialbase.downloader.iz.a> l(int i) {
        return this.fx.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized void mv(int i) {
        this.fx.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo n(int i) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setStatus(5);
            downloadInfoNr.setFirstDownload(false);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean pn() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<com.ss.android.socialbase.downloader.iz.a> s(int i) {
        Map<Long, com.ss.android.socialbase.downloader.iz.a> map = this.fx.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setStatus(2);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.u.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.u.size(); i++) {
            DownloadInfo downloadInfo = this.u.get(this.u.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean iz(int i) {
        pn(i);
        b(i);
        mv(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(com.ss.android.socialbase.downloader.model.nr nrVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized boolean pn(int i) {
        this.u.remove(i);
        return true;
    }

    public SparseArray<DownloadInfo> u() {
        return this.u;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized DownloadInfo nr(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.u.get(i);
        } catch (Exception unused) {
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<DownloadInfo> u(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo downloadInfoValueAt = this.u.valueAt(i);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<DownloadInfo> nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.u.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.u.size(); i++) {
            DownloadInfo downloadInfo = this.u.get(this.u.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        int iT = nrVar.t();
        List<com.ss.android.socialbase.downloader.model.nr> arrayList = this.nr.get(iT);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.nr.put(iT, arrayList);
        }
        arrayList.add(nrVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<com.ss.android.socialbase.downloader.model.nr> fx(int i) {
        return this.nr.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized void u(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.nr> listFx = fx(i);
        if (listFx == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.nr nrVar : listFx) {
            if (nrVar != null && nrVar.bg() == i2) {
                nrVar.nr(j);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized void b(int i) {
        this.nr.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized void fx() {
        this.u.clear();
        this.nr.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo b(int i, long j) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setCurBytes(j, false);
            downloadInfoNr.setStatus(-2);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo fx(int i, long j) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setCurBytes(j, false);
            downloadInfoNr.setStatus(-3);
            downloadInfoNr.setFirstDownload(false);
            downloadInfoNr.setFirstSuccess(false);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized List<DownloadInfo> nr() {
        if (this.u.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.u.size());
        for (int i = 0; i < this.u.size(); i++) {
            DownloadInfo downloadInfoValueAt = this.u.valueAt(i);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0.x() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r3 = r0.x().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r5.bg() != r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        r5.nr(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.jk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void u(int i, int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.model.nr> listFx = fx(i);
        if (listFx == null) {
            return;
        }
        Iterator<com.ss.android.socialbase.downloader.model.nr> it = listFx.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.nr next = it.next();
            if (next != null && next.bg() == i3 && !next.iz()) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo nr(int i, long j) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setCurBytes(j, false);
            downloadInfoNr.setStatus(-1);
            downloadInfoNr.setFirstDownload(false);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void nr(DownloadInfo downloadInfo) {
        u(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized DownloadInfo u(int i, int i2) {
        DownloadInfo downloadInfoNr;
        downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setChunkCount(i2);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized boolean u(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.u.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.u.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setTotalBytes(j);
            downloadInfoNr.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoNr.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoNr.setName(str2);
            }
            downloadInfoNr.setStatus(3);
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public DownloadInfo u(int i, long j) {
        DownloadInfo downloadInfoNr = nr(i);
        if (downloadInfoNr != null) {
            downloadInfoNr.setCurBytes(j, false);
            if (downloadInfoNr.getStatus() != -3 && downloadInfoNr.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoNr.getStatus()) && downloadInfoNr.getStatus() != -4) {
                downloadInfoNr.setStatus(4);
            }
        }
        return downloadInfoNr;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        if (list == null) {
            return;
        }
        b(i);
        for (com.ss.android.socialbase.downloader.model.nr nrVar : list) {
            if (nrVar != null) {
                u(nrVar);
                if (nrVar.iz()) {
                    Iterator<com.ss.android.socialbase.downloader.model.nr> it = nrVar.x().iterator();
                    while (it.hasNext()) {
                        u(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public synchronized boolean u(int i, Map<Long, com.ss.android.socialbase.downloader.iz.a> map) {
        this.fx.put(i, map);
        return false;
    }
}
