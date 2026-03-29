package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f3455a = new Object();
    private static s b;
    private SharedPreferences c;
    private SharedPreferences d = null;

    public s() {
        this.c = null;
        if (com.baidu.location.f.getServiceContext() != null) {
            this.c = a(com.baidu.location.f.getServiceContext());
        }
    }

    public synchronized long a(String str, long j) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                j = sharedPreferences.getLong(str, j);
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public SharedPreferences b(Context context) {
        if (this.d == null && context != null) {
            try {
                this.d = context.getSharedPreferences("MapCoreServicePregck", 0);
            } catch (Exception e) {
                e.printStackTrace();
                this.d = null;
            }
        }
        return this.d;
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("MapCoreServicePreIA", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void b(String str, long j) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putLong(str, j);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static s a() {
        s sVar;
        synchronized (f3455a) {
            if (b == null) {
                b = new s();
            }
            sVar = b;
        }
        return sVar;
    }

    public synchronized void b(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(str, str2);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public synchronized String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }
}
