package com.wft.caller.trans;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import defpackage.c27;
import defpackage.yw6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TransProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c27 f11328a;

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        int i;
        Bundle bundle2 = new Bundle();
        yw6.a("call provider from : " + str2 + ", method : " + str);
        if ("Query".equalsIgnoreCase(str)) {
            if (this.f11328a.h() == 0) {
                this.f11328a.i(2);
                this.f11328a.k(str2);
                i = 100;
            } else {
                i = 101;
            }
            bundle2.putInt("id", i);
        }
        return bundle2;
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
        c27 c27Var = new c27(getContext());
        this.f11328a = c27Var;
        c27Var.i(0);
        this.f11328a.k(getContext().getPackageName());
        return false;
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
