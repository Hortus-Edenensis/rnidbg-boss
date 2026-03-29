package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class ay implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ay f11739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f962a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f961a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f11741a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f963a;

        public a(String str, long j) {
            this.f963a = str;
            this.f11741a = j;
        }

        public abstract void a(ay ayVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ay.f11739a != null) {
                Context context = ay.f11739a.f959a;
                if (com.xiaomi.push.au.c(context)) {
                    if (System.currentTimeMillis() - ay.f11739a.f960a.getLong(":ts-" + this.f963a, 0L) > this.f11741a || com.xiaomi.push.ab.a(context)) {
                        com.xiaomi.push.p.a(ay.f11739a.f960a.edit().putLong(":ts-" + this.f963a, System.currentTimeMillis()));
                        a(ay.f11739a);
                    }
                }
            }
        }
    }

    private ay(Context context) {
        this.f959a = context.getApplicationContext();
        this.f960a = context.getSharedPreferences("sync", 0);
    }

    public static ay a(Context context) {
        if (f11739a == null) {
            synchronized (ay.class) {
                if (f11739a == null) {
                    f11739a = new ay(context);
                }
            }
        }
        return f11739a;
    }

    @Override // com.xiaomi.push.service.aa
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo736a() {
        if (this.f962a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f958a < 3600000) {
            return;
        }
        this.f958a = jCurrentTimeMillis;
        this.f962a = true;
        com.xiaomi.push.ae.a(this.f959a).a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = ay.this.f961a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("Sync job exception :" + e.getMessage());
                }
                ay.this.f962a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    public String a(String str, String str2) {
        return this.f960a.getString(str + ":" + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.p.a(f11739a.f960a.edit().putString(str + ":" + str2, str3));
    }

    public void a(a aVar) {
        if (this.f961a.putIfAbsent(aVar.f963a, aVar) == null) {
            com.xiaomi.push.ae.a(this.f959a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
