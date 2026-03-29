package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.cmn.biz.monitor.b;
import com.opos.cmn.biz.monitor.b.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f7828a = null;
    private static volatile boolean b = false;
    private com.opos.cmn.biz.monitor.b.a c;
    private com.opos.cmn.biz.monitor.b.a d = new com.opos.cmn.biz.monitor.b.d();

    private a() {
    }

    public static a a() {
        if (f7828a != null) {
            return f7828a;
        }
        synchronized (a.class) {
            if (f7828a != null) {
                return f7828a;
            }
            f7828a = new a();
            return f7828a;
        }
    }

    public com.opos.cmn.biz.monitor.b.a b() {
        com.opos.cmn.biz.monitor.b.a aVar = this.c;
        return aVar != null ? aVar : this.d;
    }

    public void a(Context context) {
        a(context, null);
    }

    public String b(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        if (context == null || TextUtils.isEmpty(str)) {
            return str;
        }
        if (monitorEvent == null) {
            monitorEvent = new MonitorEvent.b().a();
        }
        return e.a(context, str, monitorEvent).f7858a;
    }

    private void b(Context context) {
        if (b) {
            return;
        }
        a(context);
    }

    public void a(Context context, d dVar) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("MonitorManager", "init monitor failed, context can not be null");
        } else {
            if (b) {
                return;
            }
            com.opos.cmn.biz.monitor.a.c.a().a(context);
            b = true;
        }
    }

    public void a(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        a(context, str, monitorEvent, new b.a().a(true).a());
    }

    public void a(Context context, String str, MonitorEvent monitorEvent, b bVar) {
        b(context);
        if (context == null) {
            com.opos.cmn.an.f.a.d("MonitorManager", "report with context null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.d("MonitorManager", "report with url null");
            return;
        }
        if (monitorEvent == null) {
            com.opos.cmn.an.f.a.b("MonitorManager", "report with monitor event null");
            monitorEvent = new MonitorEvent.b().a();
        }
        if (bVar == null || bVar.f7845a) {
            str = e.a(context, str, monitorEvent).f7858a;
        }
        a(context, str, bVar != null && bVar.b, bVar != null ? bVar.c : 0L);
    }

    private void a(final Context context, final String str, boolean z, long j) {
        b(context);
        final boolean zA = e.a(str);
        final boolean z2 = zA || z;
        com.opos.cmn.an.f.a.b("MonitorManager", "send request url:" + str + ", isMixIn:" + zA + ", isNeedTry:" + z + ", delayMill: " + j);
        final com.opos.cmn.biz.monitor.a.d dVar = new com.opos.cmn.biz.monitor.a.d(str);
        if (z2) {
            com.opos.cmn.biz.monitor.a.c.a().a(dVar);
        }
        final Runnable runnable = new Runnable() { // from class: com.opos.cmn.biz.monitor.a.1
            @Override // java.lang.Runnable
            public void run() {
                new com.opos.cmn.biz.monitor.b.e(context, str, 3, a.this.b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.1.1
                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                        if (zA) {
                            com.opos.cmn.biz.monitor.a.c.a().a(true);
                        }
                    }

                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a(byte[] bArr) {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (z2) {
                            if (zA) {
                                com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                                if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                                    com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                                }
                            } else {
                                com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                            }
                            com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                        }
                        com.opos.cmn.biz.monitor.a.c.a().b();
                    }
                }).a();
            }
        };
        if (j <= 0) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.j.b.a().execute(runnable);
                }
            }, j);
        }
    }
}
