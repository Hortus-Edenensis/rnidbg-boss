package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.cdo.oaps.ad.OapsWrapper;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean aqY = false;
    private final e aqZ = new e(com.kwad.framework.filedownloader.f.c.Bd());
    private SQLiteDatabase ara;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.InterfaceC0581a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> aqO;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aqP;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> arb = new SparseArray<>();
        private b arc;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.aqO = sparseArray;
            this.aqP = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0581a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.arb.put(i, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0581a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aqO;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aqO.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.arc = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0581a
        public final void zy() {
            b bVar = this.arc;
            if (bVar != null) {
                bVar.zy();
            }
            try {
                SQLiteDatabase sQLiteDatabaseZz = d.this.zz();
                if (sQLiteDatabaseZz == null) {
                    return;
                }
                int size = this.arb.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        sQLiteDatabaseZz.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int iKeyAt = this.arb.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.arb.get(iKeyAt);
                            sQLiteDatabaseZz.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            sQLiteDatabaseZz.insert("ksad_file_download", null, cVar.AB());
                            if (cVar.AG() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> listBW = d.this.bW(iKeyAt);
                                if (listBW.size() > 0) {
                                    sQLiteDatabaseZz.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : listBW) {
                                        aVar.setId(cVar.getId());
                                        sQLiteDatabaseZz.insert("ksad_file_download_connection", null, aVar.AB());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aqO;
                        if (sparseArray != null && this.aqP != null) {
                            synchronized (sparseArray) {
                                int size2 = this.aqO.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.aqO.valueAt(i2).getId();
                                    List<com.kwad.framework.filedownloader.d.a> listBW2 = d.this.bW(id);
                                    if (listBW2 != null && listBW2.size() > 0) {
                                        synchronized (this.aqP) {
                                            this.aqP.put(id, listBW2);
                                        }
                                    }
                                }
                            }
                        }
                        sQLiteDatabaseZz.setTransactionSuccessful();
                    } catch (SQLiteException e) {
                        d.this.a(e);
                        try {
                            sQLiteDatabaseZz.endTransaction();
                        } catch (Exception e2) {
                            d.printStackTrace(e2);
                        }
                    } catch (Exception e3) {
                        d.printStackTrace(e3);
                        try {
                            sQLiteDatabaseZz.endTransaction();
                        } catch (Exception e4) {
                            d.printStackTrace(e4);
                        }
                    }
                } finally {
                    try {
                        sQLiteDatabaseZz.endTransaction();
                    } catch (Exception e5) {
                        d.printStackTrace(e5);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor are;
        private final List<Integer> arf = new ArrayList();
        private int arg;

        public b() {
            try {
                this.are = d.this.zz().query("ksad_file_download", null, null, null, null, null, null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: zA, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c cVarD = d.d(this.are);
            this.arg = cVarD.getId();
            return cVarD;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.are;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.arf.add(Integer.valueOf(this.arg));
        }

        public final void zy() {
            Cursor cursor = this.are;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.arf.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.arf);
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", strJoin);
            }
            try {
                SQLiteDatabase sQLiteDatabaseZz = d.this.zz();
                sQLiteDatabaseZz.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", strJoin));
                sQLiteDatabaseZz.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", strJoin));
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            zz().insert("ksad_file_download", null, cVar.AB());
        } catch (SQLiteException e) {
            cVar.bK(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private static void h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase zz() {
        if (this.ara == null) {
            this.ara = this.aqZ.getWritableDatabase();
        }
        return this.ara;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bV(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            zz().update("ksad_file_download", cVar.AB(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e) {
            cVar.bK(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:73), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bV(int i) throws Throwable {
        Cursor cursorRawQuery;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursorRawQuery = zz().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        com.kwad.framework.filedownloader.d.c cVarD = d(cursorRawQuery);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                        return cVarD;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    a(i, e);
                } catch (Exception e2) {
                    e = e2;
                    printStackTrace(e);
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Exception e4) {
            e = e4;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({HttpHeaders.RANGE})
    public final List<com.kwad.framework.filedownloader.d.a> bW(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                try {
                    cursorRawQuery = zz().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                    while (cursorRawQuery.moveToNext()) {
                        com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                        aVar.setId(i);
                        aVar.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                        aVar.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("startOffset")));
                        aVar.X(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                        aVar.Y(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("endOffset")));
                        arrayList.add(aVar);
                    }
                } catch (SQLiteException e) {
                    a(i, e);
                }
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bX(int i) {
        try {
            zz().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bY(int i) {
        try {
            return zz().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        bY(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            zz().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            zz().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void u(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            zz().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0581a zx() {
        return new a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                zz().insert("ksad_file_download_connection", null, aVar.AB());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            zz().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({HttpHeaders.RANGE})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex(OapsWrapper.KEY_PATH)), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.Z(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.ab(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.bK(cursor.getString(cursor.getColumnIndex(WifiNestConst.OtherConst.KEY_MSG)));
        cVar.bJ(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bL(cursor.getString(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME)));
        cVar.co(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME, str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bU(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bZ(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(WifiNestConst.OtherConst.KEY_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(WifiNestConst.OtherConst.KEY_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    public final a.InterfaceC0581a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i, ContentValues contentValues) {
        try {
            zz().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                bY(i);
                bX(i);
            }
            h(sQLiteException);
            aqY = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
