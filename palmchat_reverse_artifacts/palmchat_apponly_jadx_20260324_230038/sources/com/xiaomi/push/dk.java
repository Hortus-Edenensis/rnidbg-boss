package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ae;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dk f11507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f267a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    private dk(Context context) {
        this.f266a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ae aeVarA = ae.a(this.f266a);
        com.xiaomi.push.service.ah ahVarA = com.xiaomi.push.service.ah.a(this.f266a);
        SharedPreferences sharedPreferences = this.f266a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", jCurrentTimeMillis);
        if (j == jCurrentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", jCurrentTimeMillis).commit();
        }
        if (Math.abs(jCurrentTimeMillis - j) < 172800000) {
            return;
        }
        a(ahVarA, aeVarA, false);
        if (ahVarA.a(gk.StorageCollectionSwitch.a(), true)) {
            int iA = a(ahVarA.a(gk.StorageCollectionFrequency.a(), 86400));
            aeVarA.a(new dm(this.f266a, iA), iA, 0);
        }
        if (j.m651a(this.f266a) && (aVar = this.f267a) != null) {
            aVar.a();
        }
        if (ahVarA.a(gk.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(ahVarA, aeVarA, true);
    }

    public static dk a(Context context) {
        if (f11507a == null) {
            synchronized (dk.class) {
                if (f11507a == null) {
                    f11507a = new dk(context);
                }
            }
        }
        return f11507a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m294a() {
        ae.a(this.f266a).a(new Runnable() { // from class: com.xiaomi.push.dk.1
            @Override // java.lang.Runnable
            public void run() {
                dk.this.b();
            }
        });
    }

    private void a(com.xiaomi.push.service.ah ahVar, ae aeVar, boolean z) {
        if (ahVar.a(gk.UploadSwitch.a(), true)) {
            dn dnVar = new dn(this.f266a);
            if (z) {
                aeVar.a((ae.a) dnVar, a(ahVar.a(gk.UploadFrequency.a(), 86400)));
            } else {
                aeVar.m154a((ae.a) dnVar);
            }
        }
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f266a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new de(this.f266a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
