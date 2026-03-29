package com.zenmen.palmchat.webplatform.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.DeviceInfoUtil;
import defpackage.ev0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WebPlatformProvider extends ContentProvider {
    public static final Uri b = Uri.parse("content://com.zenmen.palmchat.webplatform.provider");
    public static final UriMatcher c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ev0 f15936a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        c = uriMatcher;
        uriMatcher.addURI("com.zenmen.palmchat.webplatform.provider", "modules", 1);
        uriMatcher.addURI("com.zenmen.palmchat.webplatform.provider", "modules/#", 2);
    }

    public final int a(SQLiteDatabase sQLiteDatabase, ContentValues[] contentValuesArr) {
        int i = 0;
        for (ContentValues contentValues : contentValuesArr) {
            Cursor cursorQuery = sQLiteDatabase.query("modules", null, "web_id=? and uid=?", new String[]{contentValues.getAsString("web_id"), contentValues.getAsString(DeviceInfoUtil.UID_TAG)}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.getCount() == 0) {
                    i++;
                    sQLiteDatabase.insert("modules", null, contentValues);
                }
                cursorQuery.close();
            }
        }
        return i;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] contentValuesArr) {
        int iA = c.match(uri) != 1 ? 0 : a(this.f15936a.getWritableDatabase(), contentValuesArr);
        if (iA > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iA;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int iDelete;
        SQLiteDatabase writableDatabase = this.f15936a.getWritableDatabase();
        int iMatch = c.match(uri);
        if (iMatch == 1) {
            iDelete = writableDatabase.delete("modules", str, strArr);
        } else if (iMatch != 2) {
            iDelete = 0;
        } else {
            iDelete = writableDatabase.delete("modules", "web_id=" + uri.getLastPathSegment(), null);
        }
        if (iDelete > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = c.match(uri);
        if (iMatch == 1) {
            return "vnd.android.cursor.dir/modules";
        }
        if (iMatch != 2) {
            return null;
        }
        return "vnd.android.cursor.item/modules";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        long jInsert = c.match(uri) != 1 ? -1L : this.f15936a.getWritableDatabase().insert("modules", null, contentValues);
        if (jInsert == -1) {
            return null;
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(uri, jInsert);
        getContext().getContentResolver().notifyChange(uri, null);
        return uriWithAppendedId;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f15936a = new ev0(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery;
        SQLiteDatabase readableDatabase = this.f15936a.getReadableDatabase();
        int iMatch = c.match(uri);
        if (iMatch == 1) {
            cursorQuery = readableDatabase.query("modules", strArr, str, strArr2, null, null, str2, null);
        } else if (iMatch != 2) {
            cursorQuery = null;
        } else {
            cursorQuery = readableDatabase.query("modules", strArr, "web_id=" + uri.getLastPathSegment(), null, null, null, str2, null);
        }
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        SQLiteDatabase writableDatabase = this.f15936a.getWritableDatabase();
        int iMatch = c.match(uri);
        if (iMatch == 1) {
            iUpdate = writableDatabase.update("modules", contentValues, str, strArr);
        } else if (iMatch != 2) {
            iUpdate = 0;
        } else {
            iUpdate = writableDatabase.update("modules", contentValues, "web_id=" + uri.getLastPathSegment(), null);
        }
        if (iUpdate > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iUpdate;
    }
}
