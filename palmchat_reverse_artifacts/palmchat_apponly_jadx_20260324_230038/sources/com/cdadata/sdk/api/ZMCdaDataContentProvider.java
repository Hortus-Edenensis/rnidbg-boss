package com.cdadata.sdk.api;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.umeng.analytics.pro.f;
import defpackage.e57;
import defpackage.g57;
import defpackage.p57;
import defpackage.q67;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ZMCdaDataContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher = new UriMatcher(-1);
    private e57 dbHelper;
    private p57 mProviderHelper;

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
                writableDatabase.beginTransaction();
                int length = contentValuesArr.length;
                for (ContentValues contentValues : contentValuesArr) {
                    insert(uri, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return length;
            } catch (SQLiteException e) {
                g57.a(e);
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            if (1 == uriMatcher.match(uri)) {
                p57 p57Var = this.mProviderHelper;
                if (!p57Var.c) {
                    return 0;
                }
                try {
                    SQLiteDatabase sQLiteDatabaseB = p57Var.b();
                    if (sQLiteDatabaseB != null) {
                        return sQLiteDatabaseB.delete(f.ax, str, strArr);
                    }
                    return 0;
                } catch (SQLiteException e) {
                    p57Var.c = false;
                    g57.a(e);
                    return 0;
                }
            }
        } catch (Exception e2) {
            g57.a(e2);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() != 0) {
            try {
                int iMatch = uriMatcher.match(uri);
                if (iMatch != 1) {
                    this.mProviderHelper.c(iMatch, contentValues);
                    return uri;
                }
                p57 p57Var = this.mProviderHelper;
                p57Var.getClass();
                try {
                    SQLiteDatabase sQLiteDatabaseB = p57Var.b();
                    if (sQLiteDatabaseB != null && contentValues.containsKey("data") && contentValues.containsKey("created_time")) {
                        uri = ContentUris.withAppendedId(uri, sQLiteDatabaseB.insert(f.ax, "_id", contentValues));
                        return uri;
                    }
                    return uri;
                } catch (Exception e) {
                    g57.a(e);
                    return uri;
                }
            } catch (Exception e2) {
                g57.a(e2);
            }
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String packageName;
        try {
            Context context = getContext();
            if (context == null) {
                return true;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(q67.a());
            try {
                packageName = context.getApplicationContext().getPackageName();
            } catch (UnsupportedOperationException unused) {
                packageName = "com.cdadata.sdk";
            }
            e57 e57Var = new e57(context);
            this.dbHelper = e57Var;
            p57 p57Var = new p57(context, e57Var);
            this.mProviderHelper = p57Var;
            p57Var.d(uriMatcher, packageName + ".ZMCdaDataContentProvider");
            return true;
        } catch (Exception e) {
            g57.a(e);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorA;
        try {
            int iMatch = uriMatcher.match(uri);
            if (iMatch == 1) {
                p57 p57Var = this.mProviderHelper;
                if (!p57Var.c) {
                    return null;
                }
                try {
                    SQLiteDatabase sQLiteDatabaseB = p57Var.b();
                    if (sQLiteDatabaseB == null) {
                        return null;
                    }
                    cursorA = sQLiteDatabaseB.query(f.ax, strArr, str, strArr2, null, null, str2);
                } catch (SQLiteException e) {
                    p57Var.c = false;
                    g57.a(e);
                    return null;
                }
            } else {
                cursorA = this.mProviderHelper.a(iMatch);
            }
            return cursorA;
        } catch (Exception e2) {
            g57.a(e2);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
