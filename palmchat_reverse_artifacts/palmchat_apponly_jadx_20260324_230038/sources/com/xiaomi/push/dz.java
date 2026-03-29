package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class dz {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String f356a = XMJobService.class.getCanonicalName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11530a = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(boolean z);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean mo396a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b A[EDGE_INSN: B:48:0x007b->B:30:0x007b BREAK  A[LOOP:0: B:10:0x002f->B:27:0x0075], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f355a = new ea(applicationContext);
            return;
        }
        int i = 0;
        try {
            ServiceInfo[] serviceInfoArr = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4).services;
            if (serviceInfoArr != null) {
                int length = serviceInfoArr.length;
                int i2 = 0;
                while (i < length) {
                    try {
                        ServiceInfo serviceInfo = serviceInfoArr[i];
                        if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            String str = f356a;
                            if (str.equals(serviceInfo.name)) {
                                i2 = 1;
                                if (i2 == 1) {
                                    break;
                                }
                            } else {
                                try {
                                    if (str.equals(C1401r.a(applicationContext, serviceInfo.name).getSuperclass().getCanonicalName())) {
                                    }
                                } catch (Exception unused) {
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        if (f356a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            i = 1;
                            break;
                        }
                        i++;
                    } catch (Exception e) {
                        e = e;
                        i = i2;
                        com.xiaomi.channel.commonutils.logger.b.m74a("check service err : " + e.getMessage());
                    }
                }
                i = i2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (i != 0 || !C1401r.m663a(applicationContext)) {
            f355a = new ea(applicationContext);
            return;
        }
        throw new RuntimeException("Should export service: " + f356a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
    }

    public static synchronized void a(Context context, int i) {
        int i2 = f11530a;
        if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
            if (i == 2) {
                f11530a = 2;
            } else {
                f11530a = 0;
            }
        }
        int i3 = f11530a;
        if (i2 != i3 && i3 == 2) {
            a();
            f355a = new ec(context);
        }
    }

    public static synchronized void a(boolean z) {
        if (f355a == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("timer is not initialized");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] register alarm. (" + z + ")");
        f355a.a(z);
    }

    public static synchronized void a() {
        if (f355a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] stop alarm.");
        f355a.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m395a() {
        a aVar = f355a;
        if (aVar == null) {
            return false;
        }
        return aVar.mo396a();
    }
}
