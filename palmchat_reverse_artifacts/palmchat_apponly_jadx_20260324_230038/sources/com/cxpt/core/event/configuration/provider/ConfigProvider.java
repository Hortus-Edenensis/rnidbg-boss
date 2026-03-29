package com.cxpt.core.event.configuration.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.igexin.push.core.b;
import com.lantern.core.configuration.ConfigConstant;
import defpackage.ql0;
import defpackage.vl0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ConfigProvider extends ContentProvider {
    public static final String c = "com.cxpt.core.event.configuration.provider.ConfigProvider";
    public static final UriMatcher d = new UriMatcher(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteOpenHelper f5534a = null;
    public List<Uri> b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CursorWrapper implements CrossProcessCursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CrossProcessCursor f5535a;

        public a(Cursor cursor) {
            super(cursor);
            this.f5535a = (CrossProcessCursor) cursor;
        }

        @Override // android.database.CrossProcessCursor
        public void fillWindow(int i, CursorWindow cursorWindow) {
            this.f5535a.fillWindow(i, cursorWindow);
        }

        @Override // android.database.CrossProcessCursor
        public CursorWindow getWindow() {
            return this.f5535a.getWindow();
        }

        @Override // android.database.CrossProcessCursor
        public boolean onMove(int i, int i2) {
            return this.f5535a.onMove(i, i2);
        }
    }

    public static void a(String str, ContentValues contentValues, ContentValues contentValues2) {
        String asString = contentValues.getAsString(str);
        if (asString != null) {
            contentValues2.put(str, asString);
        }
    }

    public final void b(String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("starting query, database is ");
        if (sQLiteDatabase != null) {
            sb.append("not ");
        }
        sb.append("null; ");
        if (strArr == null) {
            sb.append("projection is null; ");
        } else if (strArr.length == 0) {
            sb.append("projection is empty; ");
        } else {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("projection[");
                sb.append(i);
                sb.append("] is ");
                sb.append(strArr[i]);
                sb.append("; ");
            }
        }
        sb.append("selection is ");
        sb.append(str);
        sb.append("; ");
        if (strArr2 == null) {
            sb.append("selectionArgs is null; ");
        } else if (strArr2.length == 0) {
            sb.append("selectionArgs is empty; ");
        } else {
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                sb.append("selectionArgs[");
                sb.append(i2);
                sb.append("] is ");
                sb.append(strArr2[i2]);
                sb.append("; ");
            }
        }
        sb.append("sort is ");
        sb.append(str2);
        sb.append(".");
        Log.v(c, sb.toString());
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] contentValuesArr) {
        int iMatch = d.match(uri);
        if (iMatch != 1) {
            throw new IllegalArgumentException("Unknown/Invaid URI " + uri);
        }
        SQLiteDatabase writableDatabase = this.f5534a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : contentValuesArr) {
                if (writableDatabase.insert("configuration_data", null, contentValues) < 0) {
                    return 0;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            c(uri, iMatch);
            return contentValuesArr.length;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void c(Uri uri, int i) {
        Iterator<Uri> it = this.b.iterator();
        while (it.hasNext()) {
            getContext().getContentResolver().notifyChange(it.next(), null);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f5534a.getWritableDatabase();
        int iMatch = d.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            int iDelete = writableDatabase.delete("configuration_data", str, strArr);
            c(uri, iMatch);
            return iDelete;
        }
        throw new IllegalArgumentException("Cannot delete URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f5534a.getWritableDatabase();
        int iMatch = d.match(uri);
        if (iMatch != 1) {
            throw new IllegalArgumentException("Unknown/Invaid URI " + uri);
        }
        ContentValues contentValues2 = new ContentValues();
        a(ConfigConstant.COLUMN_EVENTID, contentValues, contentValues2);
        a("level", contentValues, contentValues2);
        a(ConfigConstant.COLUMN_AVAILABLETIME, contentValues, contentValues2);
        a(ConfigConstant.COLUMN_LIMIT, contentValues, contentValues2);
        a(ConfigConstant.COLUMN_OP, contentValues, contentValues2);
        long jInsert = writableDatabase.insert("configuration_data", null, contentValues2);
        if (jInsert == -1) {
            return null;
        }
        c(uri, iMatch);
        return ContentUris.withAppendedId(ql0.b(getContext()), jInsert);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i("CX_EVENT", "ConfigProvider onCreate!");
        this.f5534a = new vl0(getContext());
        Uri uriB = ql0.b(getContext());
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(uriB);
        UriMatcher uriMatcher = d;
        uriMatcher.addURI(ql0.a(getContext()), b.Y, 1);
        uriMatcher.addURI(ql0.a(getContext()), "config/#", 2);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.f5534a.getReadableDatabase();
        if (d.match(uri) == -1) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        b(strArr, str, strArr2, str2, readableDatabase);
        Cursor cursorQuery = readableDatabase.query("configuration_data", strArr, str, strArr2, null, null, str2);
        if (cursorQuery != null) {
            cursorQuery = new a(cursorQuery);
        }
        if (cursorQuery != null) {
            cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f5534a.getWritableDatabase();
        int iMatch = d.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            int iUpdate = writableDatabase.update("configuration_data", contentValues, str, strArr);
            c(uri, iMatch);
            return iUpdate;
        }
        throw new IllegalArgumentException("Cannot update URI: " + uri);
    }
}
