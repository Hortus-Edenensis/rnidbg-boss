package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class i {
    private static SQLiteOpenHelper b;
    private static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f10958a;
    private SQLiteDatabase c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f10959a = new i();

        private a() {
        }
    }

    public static i a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = h.a(applicationContext);
        }
        return a.f10959a;
    }

    public synchronized void b() {
        try {
            if (this.f10958a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private i() {
        this.f10958a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f10958a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }
}
