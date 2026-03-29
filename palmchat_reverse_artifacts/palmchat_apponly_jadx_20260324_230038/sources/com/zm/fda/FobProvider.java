package com.zm.fda;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.zm.fda.O52OZ.ZZ050;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FobProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f16621a;

    public static boolean a() {
        return f16621a;
    }

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
        boolean zA = ZZ050.a(getContext(), com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.p, true);
        f16621a = zA;
        if (zA) {
            O022Z.b(getContext());
            com.zm.fda.Z0225.ZZ00Z.a().a(getContext());
        }
        return true;
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
