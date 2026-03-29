package com.ss.android.socialbase.downloader.nr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.bq;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.iz.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.nr.fx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn extends fx.u implements bq {
    private static volatile SQLiteDatabase nr;
    private x b;
    private x fx;
    private volatile boolean iz;
    private x pn;
    nr u;

    public pn() {
        this(false);
    }

    private void a() {
        nr.beginTransaction();
    }

    private void jk() {
        try {
            if (nr == null || !nr.inTransaction()) {
                return;
            }
            nr.endTransaction();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (nr == null) {
            synchronized (pn.class) {
                if (nr == null) {
                    try {
                        nr = u.u().getWritableDatabase();
                        this.fx = new x(nr, "downloader", com.ss.android.socialbase.downloader.constants.fx.u, com.ss.android.socialbase.downloader.constants.fx.nr);
                        this.b = new x(nr, "downloadChunk", com.ss.android.socialbase.downloader.constants.fx.fx, com.ss.android.socialbase.downloader.constants.fx.b);
                        this.pn = new x(nr, "segments", com.ss.android.socialbase.downloader.constants.fx.pn, com.ss.android.socialbase.downloader.constants.fx.iz);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        try {
            a();
            nr.delete("downloader", null, null);
            nr.delete("downloadChunk", null, null);
            nr.setTransactionSuccessful();
            jk();
        } catch (Throwable unused) {
            jk();
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        n();
        if (nr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.3
            @Override // java.lang.Runnable
            public void run() {
                pn.this.u(i, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<DownloadInfo> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<DownloadInfo> fx(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean iz(final int i) {
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.11
            @Override // java.lang.Runnable
            public void run() {
                pn.this.pn(i);
                pn.this.b(i);
                pn.this.mv(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public Map<Long, a> l(int i) {
        Cursor cursorRawQuery;
        n();
        if (nr != null) {
            try {
                cursorRawQuery = nr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable unused) {
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    int columnIndex = cursorRawQuery.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                    HashMap map = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        a aVar = new a(jSONArray.getJSONObject(i2));
                        map.put(Long.valueOf(aVar.fx()), aVar);
                    }
                    com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                    return map;
                }
                com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
            } catch (Throwable unused2) {
                com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void mv(int i) {
        n();
        if (nr == null) {
            return;
        }
        try {
            u(i, this.pn.nr());
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<DownloadInfo> nr() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean pn() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo x(int i) {
        return null;
    }

    public pn(boolean z) {
        this.u = null;
        if (z) {
            this.iz = false;
            u();
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<DownloadInfo> nr(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean pn(int i) {
        x xVar;
        n();
        if (nr != null && (xVar = this.fx) != null) {
            try {
                u(i, xVar.nr());
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void b(final int i) {
        n();
        if (nr == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.u(i, pn.this.b.nr());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<com.ss.android.socialbase.downloader.model.nr> fx(int i) {
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList();
        n();
        if (nr != null) {
            try {
                cursorRawQuery = nr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    try {
                        arrayList.add(new com.ss.android.socialbase.downloader.model.nr(cursorRawQuery));
                    } catch (Throwable unused) {
                        com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                    }
                }
                com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo jk(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void nr(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo nr(int i) {
        Cursor cursorRawQuery;
        n();
        if (nr != null) {
            try {
                cursorRawQuery = nr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable unused) {
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                    com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
            } catch (Throwable unused2) {
                com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo pn(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!u(downloadInfo.getId())) {
                fx(downloadInfo);
                return;
            }
            x xVar = this.fx;
            if (xVar == null) {
                return;
            }
            try {
                nr(downloadInfo, xVar.fx());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo n(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public ArrayList<a> s(int i) {
        Map<Long, a> mapL = l(i);
        if (mapL == null || mapL.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapL.values());
    }

    private void fx(final DownloadInfo downloadInfo) {
        n();
        if (nr == null || this.fx == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn pnVar = pn.this;
                    pnVar.u(downloadInfo, pnVar.fx.u());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void nr(com.ss.android.socialbase.downloader.model.nr nrVar) {
        u(nrVar);
    }

    private void nr(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u() {
        u(new SparseArray<>(), new SparseArray<>(), (b) null);
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bq
    public void u(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArray2, final b bVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    b bVar2;
                    boolean z;
                    int iU;
                    pn.this.n();
                    if (pn.nr == null) {
                        return;
                    }
                    t tVarH = com.ss.android.socialbase.downloader.downloader.fx.h();
                    SparseArray sparseArray3 = new SparseArray();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Cursor cursorRawQuery = null;
                    int i = 0;
                    try {
                        cursorRawQuery = pn.nr.rawQuery("SELECT * FROM downloader", null);
                        while (cursorRawQuery.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursorRawQuery);
                            downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                            if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                downloadInfo.setStatus(-5);
                                if (com.ss.android.socialbase.downloader.n.u.fx().nr("status_not_update_to_db", true)) {
                                    sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                }
                            }
                            if (TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
                                z = true;
                            } else {
                                if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                                    if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                        downloadInfo.reset();
                                    }
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (downloadInfo.getStatus() == 11) {
                                    downloadInfo.setStatus(-5);
                                }
                                if (com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                    if (com.ss.android.socialbase.downloader.jk.u.u(33554432)) {
                                        z = true;
                                    } else {
                                        downloadInfo.erase();
                                    }
                                }
                            }
                            if (z) {
                                arrayList.add(Integer.valueOf(downloadInfo.getId()));
                                arrayList2.add(downloadInfo);
                            } else {
                                int id = downloadInfo.getId();
                                if (tVarH != null) {
                                    String taskKey = downloadInfo.getTaskKey();
                                    if (TextUtils.isEmpty(taskKey)) {
                                        taskKey = downloadInfo.getUrl();
                                    }
                                    iU = tVarH.u(taskKey, downloadInfo.getSavePath());
                                } else {
                                    iU = 0;
                                }
                                if (iU != id) {
                                    downloadInfo.setId(iU);
                                    sparseArray3.put(id, downloadInfo);
                                }
                                sparseArray.put(downloadInfo.getId(), downloadInfo);
                            }
                        }
                        com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                        pn.this.u(arrayList2);
                        pn.this.u(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.ss.android.socialbase.downloader.model.nr>>) sparseArray2);
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt = sparseArray.keyAt(i);
                                    if (iKeyAt != 0) {
                                        DownloadInfo downloadInfo2 = (DownloadInfo) sparseArray.get(iKeyAt);
                                        if (com.ss.android.socialbase.downloader.jk.u.u(8192)) {
                                            if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                                arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                sparseArray2.remove(downloadInfo2.getId());
                                            }
                                        } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                            arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                            sparseArray2.remove(downloadInfo2.getId());
                                        }
                                    }
                                    Iterator it = arrayList3.iterator();
                                    while (it.hasNext()) {
                                        sparseArray.remove(((Integer) it.next()).intValue());
                                    }
                                    i++;
                                }
                            }
                            bVar2 = bVar;
                        } catch (Throwable unused) {
                            bVar2 = bVar;
                            if (bVar2 != null) {
                            }
                        }
                    } catch (Throwable unused2) {
                        com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                        pn.this.u(arrayList2);
                        pn.this.u(arrayList2, arrayList, (SparseArray<DownloadInfo>) sparseArray3, (SparseArray<DownloadInfo>) sparseArray, (SparseArray<List<com.ss.android.socialbase.downloader.model.nr>>) sparseArray2);
                        try {
                            ArrayList arrayList4 = new ArrayList();
                            if (sparseArray != null) {
                                while (i < sparseArray.size()) {
                                    int iKeyAt2 = sparseArray.keyAt(i);
                                    if (iKeyAt2 != 0) {
                                        DownloadInfo downloadInfo3 = (DownloadInfo) sparseArray.get(iKeyAt2);
                                        if (com.ss.android.socialbase.downloader.jk.u.u(8192)) {
                                            if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                                arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                sparseArray2.remove(downloadInfo3.getId());
                                            }
                                        } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                            arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                            sparseArray2.remove(downloadInfo3.getId());
                                        }
                                    }
                                    Iterator it2 = arrayList4.iterator();
                                    while (it2.hasNext()) {
                                        sparseArray.remove(((Integer) it2.next()).intValue());
                                    }
                                    i++;
                                }
                            }
                            bVar2 = bVar;
                            if (bVar2 != null) {
                            }
                        } catch (Throwable unused3) {
                            bVar2 = bVar;
                            if (bVar2 != null) {
                            }
                        }
                    }
                    if (bVar2 != null) {
                        bVar2.u();
                        pn.this.iz = true;
                    }
                    pn.this.u(sparseArray, sparseArray2);
                }
            };
            ExecutorService executorServiceSx = com.ss.android.socialbase.downloader.downloader.fx.sx();
            if (executorServiceSx != null) {
                executorServiceSx.execute(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void fx() {
        n();
        if (nr == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.2
            @Override // java.lang.Runnable
            public void run() {
                pn.this.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.jk.iz.nr(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean b() {
        return this.iz;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo fx(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo nr(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || nr == null) {
            return;
        }
        synchronized (nr) {
            try {
                a();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.n.u.fx().u("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        nr.delete("downloader", str, strArr);
                        nr.delete("downloadChunk", str, strArr);
                    } else {
                        String strJoin = TextUtils.join(", ", list2);
                        nr.delete("downloader", "_id IN (?)", new String[]{strJoin});
                        nr.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int iKeyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(iKeyAt);
                    nr.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    nr.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.nr> listFx = fx(iKeyAt);
                        if (listFx.size() > 0) {
                            nr.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (com.ss.android.socialbase.downloader.model.nr nrVar : listFx) {
                                nrVar.nr(downloadInfo.getId());
                                nr.insert("downloadChunk", null, nrVar.u());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<com.ss.android.socialbase.downloader.model.nr> listU = com.ss.android.socialbase.downloader.jk.iz.u(fx(id));
                        if (listU != null && listU.size() > 0) {
                            sparseArray3.put(id, listU);
                        }
                    }
                }
                nr.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            jk();
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void nr(int i, List<com.ss.android.socialbase.downloader.model.nr> list) {
        try {
            b(i);
            if (list != null) {
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
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean u(int i) {
        return nr(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public List<DownloadInfo> u(String str) {
        Cursor cursorRawQuery;
        n();
        ArrayList arrayList = new ArrayList();
        if (nr != null) {
            try {
                cursorRawQuery = nr.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        arrayList.add(new DownloadInfo(cursorRawQuery));
                    }
                    com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                } catch (Throwable unused) {
                    com.ss.android.socialbase.downloader.jk.iz.u(cursorRawQuery);
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(final com.ss.android.socialbase.downloader.model.nr nrVar) {
        n();
        if (nr == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.u(nrVar, pn.this.b.u());
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.ss.android.socialbase.downloader.model.nr nrVar, SQLiteStatement sQLiteStatement) {
        if (nrVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                nrVar.u(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(final int i, final int i2, final long j) {
        n();
        if (i == 0 || i2 < 0 || j < 0 || nr == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.u(i, i2, j, pn.this.b.fx());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(final int i, final int i2, final int i3, final long j) {
        n();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || nr == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.u(i, i2, i3, j, pn.this.b.fx());
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(final int i, final int i2, final int i3, final int i4) {
        n();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || nr == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.u(i, i2, i3, i4, pn.this.b.fx());
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                nr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                nr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                nr.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo u(int i, int i2) {
        n();
        if (nr == null) {
            return null;
        }
        int i3 = 10;
        while (nr.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        nr.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public boolean u(final DownloadInfo downloadInfo) {
        n();
        if (downloadInfo == null || nr == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.fx.fx(new Runnable() { // from class: com.ss.android.socialbase.downloader.nr.pn.10
            @Override // java.lang.Runnable
            public void run() {
                pn.this.b(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo u(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public DownloadInfo u(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public boolean u(int i, Map<Long, a> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        n();
        if (nr == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).t());
            }
        } catch (Throwable unused) {
        }
        SQLiteStatement sQLiteStatementB = this.pn.b();
        synchronized (sQLiteStatementB) {
            sQLiteStatementB.clearBindings();
            sQLiteStatementB.bindLong(1, i);
            sQLiteStatementB.bindString(2, jSONArray.toString());
            sQLiteStatementB.execute();
        }
        com.ss.android.socialbase.downloader.fx.u.nr("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.jk.iz.fx(jCurrentTimeMillis));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, ContentValues contentValues) {
        int i2 = 10;
        while (nr.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        nr.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    @Override // com.ss.android.socialbase.downloader.nr.fx
    public void u(nr nrVar) {
        this.u = nrVar;
    }

    public void u(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.nr>> sparseArray2) {
        try {
            HashMap mapU = com.ss.android.socialbase.downloader.jk.iz.u(sparseArray);
            HashMap mapU2 = com.ss.android.socialbase.downloader.jk.iz.u(sparseArray2);
            nr nrVar = this.u;
            if (nrVar != null) {
                nrVar.u(mapU, mapU2);
            }
        } catch (Throwable unused) {
        }
    }
}
