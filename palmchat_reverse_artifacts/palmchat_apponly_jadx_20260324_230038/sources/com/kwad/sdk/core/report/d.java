package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class d implements l<e> {
    private static final String[] aLe = {"count(*)"};
    private static boolean aLf = false;
    protected c aLg;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aLg = cVar;
    }

    private synchronized void c(e eVar) {
        if (aLf) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.aLg.getReadableDatabase().delete(Kh(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<e> list) {
        if (aLf) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase readableDatabase = null;
        try {
            try {
                readableDatabase = this.aLg.getReadableDatabase();
                readableDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                readableDatabase.setTransactionSuccessful();
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTrace(e3);
                    }
                }
            }
        } finally {
        }
    }

    public abstract String Kh();

    public abstract String[] Ki();

    public final synchronized List<e> Kj() {
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArrKi = Ki();
                cursorQuery = this.aLg.getReadableDatabase().query(Kh(), strArrKi.length == 0 ? null : strArrKi, null, null, null, null, null);
                if (cursorQuery != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        try {
                            arrayList.add(f(cursorQuery));
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                    if (aLf) {
                        Log.d(getTag(), "read size= " + arrayList.size());
                        for (e eVar : arrayList) {
                            Log.d(getTag(), "read action=" + eVar);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void m(e eVar) {
        ContentValues contentValues;
        if (aLf) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        try {
            this.aLg.getReadableDatabase().insert(Kh(), null, contentValues);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> dW(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.aLg.getReadableDatabase().query(Kh(), Ki(), null, null, null, null, null, "0,200");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(f(cursorQuery));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        }
        return arrayList;
    }

    public abstract e f(@NonNull Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.aLg.getReadableDatabase().query(Kh(), aLe, null, null, null, null, null);
            cursorQuery.moveToFirst();
            j = cursorQuery.getLong(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            j = 0;
        } finally {
        }
        return j;
    }
}
