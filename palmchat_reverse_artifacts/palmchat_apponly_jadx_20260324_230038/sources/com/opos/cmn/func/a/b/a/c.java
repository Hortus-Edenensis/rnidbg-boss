package com.opos.cmn.func.a.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.opos.acs.st.STManager;
import com.opos.cmn.func.a.a.a.b;
import com.opos.cmn.func.a.a.a.g;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static g a(Context context) {
        try {
            g.a aVar = new g.a();
            aVar.a(f(context));
            return aVar.a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ParamUtils", "getDefaultInitParameter", e);
            return null;
        }
    }

    public static g b(Context context) {
        try {
            return new g.a().a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ParamUtils", "getDefaultTaphttpInitParameter", e);
            return null;
        }
    }

    public static String c(Context context) {
        return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
    }

    public static String d(Context context) {
        return d.a(context);
    }

    public static b.a e(Context context) {
        return "CN".equalsIgnoreCase(d.a(context)) ? b.a.CN : STManager.REGION_OF_IN.equalsIgnoreCase(d.a(context)) ? b.a.SA : b.a.SEA;
    }

    private static SSLSocketFactory f(Context context) {
        return null;
    }

    public static com.opos.cmn.func.a.a.d a(Context context, com.opos.cmn.func.a.a.d dVar) {
        boolean z;
        try {
            d.a aVarA = new d.a().a(dVar);
            Map<String, String> mapA = a(dVar.c);
            byte[] bArrA = dVar.d;
            if (TextUtils.isEmpty(a(mapA, "Route-Data")) && context != null) {
                mapA.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
            }
            if (dVar.g && dVar.d != null) {
                boolean z2 = true;
                if (TextUtils.isEmpty(a(mapA, "Content-Encoding"))) {
                    z = false;
                } else {
                    com.opos.cmn.an.f.a.b("ParamUtils", "isAlreadyCompress=true");
                    z = true;
                }
                if (!z) {
                    if (dVar.d.length < 1024) {
                        z2 = false;
                    }
                    com.opos.cmn.an.f.a.b("ParamUtils", "neeCompress=" + z2);
                    if (z2) {
                        bArrA = com.opos.cmn.b.c.a.a(bArrA);
                        mapA.put("Content-Encoding", Constants.CP_GZIP);
                    }
                }
            }
            if (dVar.f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArrExecuteEncryptBytesV2 = EncryptUtils.executeEncryptBytesV2(bArrA);
                if (bArrExecuteEncryptBytesV2 == null || bArrExecuteEncryptBytesV2.length <= 0) {
                    com.opos.cmn.an.f.a.c("ParamUtils", "crypt data failed");
                } else {
                    mapA.put("encrypt", "v1");
                    bArrA = bArrExecuteEncryptBytesV2;
                }
                com.opos.cmn.an.f.a.b("ParamUtils", "crypt data costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            return aVarA.a(mapA).a(bArrA).a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ParamUtils", "getProcessedNetRequest", e);
            return dVar;
        }
    }

    private static String a(Map<String, String> map, String str) {
        if (str != null && map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }
}
