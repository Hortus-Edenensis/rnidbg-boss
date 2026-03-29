package com.opos.mobad.model.utils;

import android.content.Context;
import android.os.Bundle;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.cmn.an.e.d.a f9109a;
    private static final byte[] b = new byte[0];
    private static Map<String, Boolean> c = new ConcurrentHashMap();

    public static Bundle a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    public static String b() {
        return "https://ssp-adx.ads.heytapmobi.com/v1/mixapi/ad_adapter/dsp/getAdInfo";
    }

    private static com.opos.cmn.an.e.d.a a(Context context) {
        com.opos.cmn.an.e.d.a aVar = f9109a;
        if (aVar == null) {
            synchronized (b) {
                aVar = f9109a;
                if (aVar == null) {
                    aVar = new com.opos.cmn.an.e.d.a(context, "mobad.record.show.prefs", 0);
                    f9109a = aVar;
                }
            }
        }
        return aVar;
    }

    private static void b(Context context, String str, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("putRecordShowEvent posId=");
            sb.append(str != null ? str : com.igexin.push.core.b.m);
            sb.append(",record=");
            sb.append(z);
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (context == null || com.opos.cmn.an.d.b.a(str)) {
                return;
            }
            a(context).a(str, Boolean.valueOf(z));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
        }
    }

    public static String a() {
        return "https://uapi.ads.heytapmobi.com/union/ads/v2/show";
    }

    private static boolean b(Context context, String str) {
        boolean zA = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    zA = a(context).a(str, true);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRecordShowEvent posId=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zA);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return zA;
    }

    public static Map<String, String> a(Bundle bundle) {
        HashMap map = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                map.put(str, bundle.getString(str));
            }
        }
        return map;
    }

    public static void a(Context context, String str, boolean z) {
        try {
            com.opos.cmn.an.f.a.b("Utils", "updateRecordEvent posId=" + str + ",record=" + z);
            if (z != a(context, str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("really updateRecordEvent=");
                sb.append(str != null ? str : com.igexin.push.core.b.m);
                sb.append(",record=");
                sb.append(z);
                com.opos.cmn.an.f.a.b("Utils", sb.toString());
                c.put(str, Boolean.valueOf(z));
                b(context, str, z);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
        }
    }

    public static boolean a(Context context, String str) {
        boolean zB = false;
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    if (c.containsKey(str)) {
                        zB = c.get(str).booleanValue();
                    } else {
                        zB = b(context, str);
                        c.put(str, Boolean.valueOf(zB));
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("recordShowEvent posId=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(zB);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return zB;
    }
}
