package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import defpackage.aw2;
import defpackage.k63;
import defpackage.o75;
import defpackage.qv2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DownloadProvider extends ContentProvider {
    private static final String TAG = "DownloadProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            k63.a(TAG, "method:" + str + ", arg=" + str2);
            return aw2.c().b(getContext(), str, str2, bundle);
        } catch (Throwable th) {
            k63.l(TAG, "call e:" + th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return o75.t(getContext(), uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        k63.a(TAG, "DownloadProvider query:" + uri);
        try {
            String queryParameter = uri.getQueryParameter("from_package");
            Bundle bundle = new Bundle();
            bundle.putString("from_package", queryParameter);
            bundle.putInt("type", 4);
            qv2.a(getContext(), "waked", bundle);
            return null;
        } catch (Throwable th) {
            k63.l(TAG, "wake error:" + th.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
