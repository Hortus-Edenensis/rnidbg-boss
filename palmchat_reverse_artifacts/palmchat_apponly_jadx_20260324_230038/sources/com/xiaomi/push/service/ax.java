package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.af;
import com.xiaomi.push.ci;
import com.xiaomi.push.dp;
import com.xiaomi.push.fy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ax f11737a = new ax();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private af.b f954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Cdo.a f955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f956a = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {
        public void a(Cdo.a aVar) {
        }

        public void a(dp.b bVar) {
        }
    }

    private ax() {
    }

    private void b() throws Throwable {
        if (this.f955a == null) {
            d();
        }
    }

    private void c() {
        if (this.f954a != null) {
            return;
        }
        af.b bVar = new af.b() { // from class: com.xiaomi.push.service.ax.1

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            boolean f957a = false;

            @Override // com.xiaomi.push.af.b
            public void b() {
                try {
                    Cdo.a aVarA = Cdo.a.a(Base64.decode(ci.a(C1401r.m660a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.at>) null), 10));
                    if (aVarA != null) {
                        ax.this.f955a = aVarA;
                        this.f957a = true;
                        ax.this.e();
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("fetch config failure: " + e.getMessage());
                }
            }

            @Override // com.xiaomi.push.af.b
            /* JADX INFO: renamed from: c */
            public void mo289c() {
                a[] aVarArr;
                ax.this.f954a = null;
                if (this.f957a) {
                    synchronized (ax.this) {
                        aVarArr = (a[]) ax.this.f956a.toArray(new a[ax.this.f956a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(ax.this.f955a);
                    }
                }
            }
        };
        this.f954a = bVar;
        fy.a(bVar);
    }

    private void d() throws Throwable {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(C1401r.m660a().openFileInput("XMCloudCfg"));
                try {
                    this.f955a = Cdo.a.b(com.xiaomi.push.b.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m74a("load config failure: " + e.getMessage());
                }
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.w.a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            e = e3;
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            com.xiaomi.push.w.a((Closeable) bufferedInputStream);
            throw th;
        }
        com.xiaomi.push.w.a((Closeable) bufferedInputStream);
        if (this.f955a == null) {
            this.f955a = new Cdo.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f955a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C1401r.m660a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c cVarA = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f955a.a(cVarA);
                cVarA.m220a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("save config failure: " + e.getMessage());
        }
    }

    public static ax a() {
        return f11737a;
    }

    public synchronized void a(a aVar) {
        this.f956a.add(aVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m734a() {
        this.f956a.clear();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m732a() throws Throwable {
        b();
        Cdo.a aVar = this.f955a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Cdo.a m733a() throws Throwable {
        b();
        return this.f955a;
    }

    public void a(dp.b bVar) {
        a[] aVarArr;
        if (bVar.m324d() && bVar.d() > m732a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f956a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m729a() {
        if (f953a == null) {
            SharedPreferences sharedPreferences = C1401r.m660a().getSharedPreferences("XMPushServiceConfig", 0);
            String string = sharedPreferences.getString("DeviceUUID", null);
            f953a = string;
            if (string == null) {
                String strA = com.xiaomi.push.i.a(C1401r.m660a(), false);
                f953a = strA;
                if (strA != null) {
                    sharedPreferences.edit().putString("DeviceUUID", f953a).commit();
                }
            }
        }
        return f953a;
    }
}
