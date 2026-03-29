package cn.fly.verify;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class FlyVerifyProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context;
        String string;
        String str;
        PackageInfo packageInfo;
        Bundle bundle;
        String string2 = null;
        try {
            context = getContext();
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            } catch (Throwable unused) {
                string = null;
            }
        } catch (Throwable unused2) {
            context = null;
            string = null;
        }
        try {
            if (packageInfo == null || (bundle = packageInfo.applicationInfo.metaData) == null) {
                str = null;
                FlyVerify.init(context, string2, str);
                return false;
            }
            string = bundle.getString("custom-AppKey");
            try {
                string2 = bundle.getString("custom-AppSecret");
            } catch (Throwable unused3) {
            }
            FlyVerify.init(context, string2, str);
            return false;
        } catch (Throwable unused4) {
            return false;
        }
        str = string2;
        string2 = string;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
