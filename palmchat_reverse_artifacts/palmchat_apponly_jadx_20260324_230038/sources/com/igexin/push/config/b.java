package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.push.g.n;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f7124a;

    private b() {
    }

    public static synchronized b a() {
        if (f7124a == null) {
            f7124a = new b();
        }
        return f7124a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.f7129a, "PUSH_DOMAIN:" + r5.getString(r7));
        r5 = r5.getString(r7);
        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(new java.lang.String[]{"socket://xfr." + r5 + ":5224"});
        r6 = new java.lang.StringBuilder("XFR_ADDRESS_IPS:");
        r6.append(com.igexin.push.config.SDKUrlConfig.getXfrAddress()[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.f7129a, r6.toString());
        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = new java.lang.String[]{"socket://xfr_bak." + r5 + ":5224"};
        r1 = new java.lang.StringBuilder("XFR_ADDRESS_IPS_BAK:");
        r1.append(com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        com.igexin.c.a.c.a.a(r1.toString(), new java.lang.Object[0]);
        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = new java.lang.String[]{"https://bi." + r5 + "/api.php"};
        r1 = new java.lang.StringBuilder("BI_ADDRESS_IPS:");
        r1.append(com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.f7129a, r1.toString());
        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = new java.lang.String[]{"https://config." + r5 + "/api.php"};
        r0 = new java.lang.StringBuilder("CONFIG_ADDRESS_IPS:");
        r0.append(com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.f7129a, r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b() {
        try {
            Bundle bundle = n.b(com.igexin.push.core.e.l).metaData;
            if (bundle != null) {
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if ("PUSH_DOMAIN".equals(next)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new Object[0]);
        }
        return true;
    }

    private static String c() {
        return null;
    }

    private static int d() {
        return 0;
    }
}
