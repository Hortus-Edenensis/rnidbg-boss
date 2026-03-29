package com.zenmen.palmchat.deamon.comp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ConDirProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13920a = false;
    public static boolean b = false;
    public static boolean c = false;

    public static void a() {
        if (f13920a) {
            return;
        }
        f13920a = true;
        if (c) {
            b();
        }
    }

    public static void b() {
        if (b) {
            return;
        }
        b = true;
        c = false;
    }

    public static void c() {
        if (f13920a) {
            b();
        } else {
            c = true;
        }
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
        c();
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
