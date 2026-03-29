package com.zenmen.palmchat.framework.httpdns;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.jt0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DNSCacheProvider extends ContentProvider {
    public static final UriMatcher b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jt0 f13976a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        b = uriMatcher;
        uriMatcher.addURI("com.zenmen.palmchat.network.dnscache.provider", "tb_dns_cache", 1000);
    }

    public final long a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        long jInsert;
        String asString = contentValues.getAsString("domain");
        if (!TextUtils.isEmpty(asString)) {
            String[] strArr = {asString};
            Cursor cursorQuery = sQLiteDatabase.query("tb_dns_cache", null, "domain=?", strArr, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    jInsert = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    sQLiteDatabase.update("tb_dns_cache", contentValues, "domain=?", strArr);
                } else {
                    jInsert = sQLiteDatabase.insert("tb_dns_cache", null, contentValues);
                }
                cursorQuery.close();
                return jInsert;
            }
        }
        return 0L;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase = this.f13976a.getWritableDatabase();
        if (contentValuesArr == null) {
            return 0;
        }
        if (b.match(uri) != 1000) {
            throw new UnsupportedOperationException("unknown uri:" + uri.toString());
        }
        for (ContentValues contentValues : contentValuesArr) {
            a(writableDatabase, contentValues);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return contentValuesArr.length;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f13976a.getWritableDatabase();
        if (b.match(uri) == 1000) {
            int iDelete = writableDatabase.delete("tb_dns_cache", str, strArr);
            if (iDelete > 0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            return iDelete;
        }
        throw new UnsupportedOperationException("unknown uri:" + uri.toString());
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f13976a.getWritableDatabase();
        if (b.match(uri) != 1000) {
            throw new UnsupportedOperationException("unknown uri:" + uri.toString());
        }
        long jA = a(writableDatabase, contentValues);
        if (jA <= 0) {
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, jA);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        jt0 jt0Var = new jt0(getContext());
        this.f13976a = jt0Var;
        jt0Var.setWriteAheadLoggingEnabled(false);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            SQLiteDatabase readableDatabase = this.f13976a.getReadableDatabase();
            if (b.match(uri) == 1000) {
                return readableDatabase.query("tb_dns_cache", strArr, str, strArr2, null, null, str2);
            }
            throw new UnsupportedOperationException("unknown uri:" + uri.toString());
        } catch (SQLiteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f13976a.getWritableDatabase();
        if (b.match(uri) == 1000) {
            int iUpdate = writableDatabase.update("tb_dns_cache", contentValues, str, strArr);
            if (iUpdate > 0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            return iUpdate;
        }
        throw new UnsupportedOperationException("unknown uri:" + uri.toString());
    }
}
