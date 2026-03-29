package com.lantern.core.configuration;

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
import com.igexin.push.core.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ConfigProvider extends ContentProvider {
    private static final int CONFIGS = 1;
    private static final int CONFIG_ID = 2;
    private static final String TAG = "com.lantern.core.configuration.ConfigProvider";
    private static final UriMatcher sURIMatcher = new UriMatcher(-1);
    private List<Uri> BASE_URIS;
    private SQLiteOpenHelper mOpenHelper = null;

    /* JADX INFO: compiled from: SearchBox */
    public class ReadOnlyCursorWrapper extends CursorWrapper implements CrossProcessCursor {
        private CrossProcessCursor mCursor;

        public ReadOnlyCursorWrapper(Cursor cursor) {
            super(cursor);
            this.mCursor = (CrossProcessCursor) cursor;
        }

        public boolean commitUpdates() {
            throw new SecurityException("Download manager cursors are read-only");
        }

        public boolean deleteRow() {
            throw new SecurityException("Download manager cursors are read-only");
        }

        @Override // android.database.CrossProcessCursor
        public void fillWindow(int i, CursorWindow cursorWindow) {
            this.mCursor.fillWindow(i, cursorWindow);
        }

        @Override // android.database.CrossProcessCursor
        public CursorWindow getWindow() {
            return this.mCursor.getWindow();
        }

        @Override // android.database.CrossProcessCursor
        public boolean onMove(int i, int i2) {
            return this.mCursor.onMove(i, i2);
        }
    }

    private static void copyString(String str, ContentValues contentValues, ContentValues contentValues2) {
        String asString = contentValues.getAsString(str);
        if (asString != null) {
            contentValues2.put(str, asString);
        }
    }

    private void logVerboseQueryInfo(String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase) {
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
        Log.v(TAG, sb.toString());
    }

    private void notifyContentChanged(Uri uri, int i) {
        Iterator<Uri> it = this.BASE_URIS.iterator();
        while (it.hasNext()) {
            getContext().getContentResolver().notifyChange(it.next(), null);
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int iMatch = sURIMatcher.match(uri);
        if (iMatch != 1) {
            throw new IllegalArgumentException("Unknown/Invaid URI " + uri);
        }
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : contentValuesArr) {
                if (writableDatabase.insert(ConfigOpenHelper.DB_TABLE, null, contentValues) < 0) {
                    return 0;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            notifyContentChanged(uri, iMatch);
            return contentValuesArr.length;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int iMatch = sURIMatcher.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            int iDelete = writableDatabase.delete(ConfigOpenHelper.DB_TABLE, str, strArr);
            notifyContentChanged(uri, iMatch);
            return iDelete;
        }
        throw new IllegalArgumentException("Cannot delete URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int iMatch = sURIMatcher.match(uri);
        if (iMatch != 1) {
            throw new IllegalArgumentException("Unknown/Invaid URI " + uri);
        }
        ContentValues contentValues2 = new ContentValues();
        copyString(ConfigConstant.COLUMN_EVENTID, contentValues, contentValues2);
        copyString("level", contentValues, contentValues2);
        copyString(ConfigConstant.COLUMN_AVAILABLETIME, contentValues, contentValues2);
        copyString(ConfigConstant.COLUMN_LIMIT, contentValues, contentValues2);
        copyString(ConfigConstant.COLUMN_OP, contentValues, contentValues2);
        long jInsert = writableDatabase.insert(ConfigOpenHelper.DB_TABLE, null, contentValues2);
        if (jInsert == -1) {
            return null;
        }
        notifyContentChanged(uri, iMatch);
        return ContentUris.withAppendedId(ConfigConstant.getContentURI(getContext()), jInsert);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i("CX_EVENT", "ConfigProvider onCreate!");
        this.mOpenHelper = new ConfigOpenHelper(getContext());
        Uri contentURI = ConfigConstant.getContentURI(getContext());
        ArrayList arrayList = new ArrayList();
        this.BASE_URIS = arrayList;
        arrayList.add(contentURI);
        UriMatcher uriMatcher = sURIMatcher;
        uriMatcher.addURI(ConfigConstant.getAuthority(getContext()), b.Y, 1);
        uriMatcher.addURI(ConfigConstant.getAuthority(getContext()), "config/#", 2);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.mOpenHelper.getReadableDatabase();
        if (sURIMatcher.match(uri) == -1) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        logVerboseQueryInfo(strArr, str, strArr2, str2, readableDatabase);
        Cursor cursorQuery = readableDatabase.query(ConfigOpenHelper.DB_TABLE, strArr, str, strArr2, null, null, str2);
        if (cursorQuery != null) {
            cursorQuery = new ReadOnlyCursorWrapper(cursorQuery);
        }
        if (cursorQuery != null) {
            cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int iMatch = sURIMatcher.match(uri);
        if (iMatch == 1 || iMatch == 2) {
            int iUpdate = writableDatabase.update(ConfigOpenHelper.DB_TABLE, contentValues, str, strArr);
            notifyContentChanged(uri, iMatch);
            return iUpdate;
        }
        throw new IllegalArgumentException("Cannot update URI: " + uri);
    }
}
