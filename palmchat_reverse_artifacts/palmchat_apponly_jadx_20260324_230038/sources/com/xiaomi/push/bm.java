package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bm f11444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f154a;

    private bm(Context context) {
        this.f154a = context;
    }

    public static bm a(Context context) {
        if (f11444a == null) {
            synchronized (bm.class) {
                if (f11444a == null) {
                    f11444a = new bm(context);
                }
            }
        }
        return f11444a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m212a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f154a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m211a(String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = this.f154a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f154a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f154a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}
