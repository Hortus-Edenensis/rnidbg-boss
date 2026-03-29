package com.opos.cmn.biz.requeststatistic.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7867a = "b";

    public b(Context context) {
        super(context, "request_statistic.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public int a(long j) {
        return getWritableDatabase().delete("request_statistic", "createTime<= ?", new String[]{String.valueOf(j)});
    }

    public void b(List<c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < list.size(); i++) {
            sb.append("'");
            sb.append(list.get(i).a());
            sb.append("'");
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        getWritableDatabase().execSQL("delete\tfrom\trequest_statistic\twhere\tid\tin\t" + sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\trequest_statistic\t(id\tinteger primary key,\tdata\ttext,\tcreateTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.opos.cmn.an.f.a.a(f7867a, "onDowngrade db old version code=" + i + "\tnew version code=" + i2);
    }

    public List<c> a(long j, long j2, int i) {
        LinkedList linkedList = new LinkedList();
        Cursor cursorRawQuery = getWritableDatabase().rawQuery("select *\tfrom\trequest_statistic\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\tlimit ?;", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(i)});
        if (cursorRawQuery != null) {
            try {
                for (boolean zMoveToFirst = cursorRawQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorRawQuery.moveToNext()) {
                    linkedList.add(new c(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("id")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("data")), cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("createTime"))));
                }
            } finally {
                try {
                    cursorRawQuery.close();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c(f7867a, "cursor close fail", e);
                }
            }
        }
        return linkedList;
    }

    public void a(c cVar) {
        long jA = cVar.a();
        if (jA >= 0) {
            getWritableDatabase().delete("request_statistic", "id=?", new String[]{String.valueOf(jA)});
        } else {
            com.opos.cmn.an.f.a.c(f7867a, "delete data by id had not init");
            getWritableDatabase().delete("request_statistic", "data=?", new String[]{cVar.b});
        }
    }

    public void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (c cVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", cVar.b);
                contentValues.put("createTime", Long.valueOf(cVar.c));
                cVar.a(getWritableDatabase().insert("request_statistic", null, contentValues));
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
