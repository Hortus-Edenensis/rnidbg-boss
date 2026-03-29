package com.opos.mobad.cmn.func.b.a;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.lantern.auth.server.WkParams;
import com.opos.acs.st.STManager;
import com.opos.cmn.an.c.c;
import com.opos.cmn.i.h;
import com.opos.mobad.b;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.d.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static Map<String, String> a(b bVar) {
        HashMap map = new HashMap();
        map.put("appId", bVar.d());
        map.put("phBrand", com.opos.cmn.an.c.a.a(bVar.b()));
        map.put("phMaker", c.e());
        map.put("aid", com.opos.mobad.service.d.b.a().getAndroidId());
        map.put("ua", g.h());
        String strH = bVar.h().h();
        if (TextUtils.isEmpty(strH)) {
            strH = "";
        }
        map.put("ouId", strH);
        String strI = bVar.h().i();
        map.put("duId", TextUtils.isEmpty(strI) ? "" : strI);
        map.put("ouidStatus", bVar.h().l() ? "1" : "0");
        map.put("appOuidStatus", bVar.h().f() ? "1" : "0");
        a.C0768a c0768aM = bVar.h().m();
        if (c0768aM != null) {
            map.put(WkParams.IMEI, c0768aM.f9210a);
            map.put("imeiType", String.valueOf(1));
        }
        return map;
    }

    public static void b(String str, Map<String, String> map) {
        h.a(map, "respId", str);
    }

    public static void c(String str, Map<String, String> map) {
        h.a(map, "sdkReqId", str);
        h.a(map, "reqId", str);
    }

    public static void a(AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        if (map != null) {
            map.put("adSource", adItemData.b());
            map.put("adId", adItemData.f());
            map.put("cache", adItemData.O() ? "1" : "0");
            map.put("planId", adItemData.h());
            b(adItemData.c(), map);
            map.put("mtId", materialData.c());
            map.put("traceId", materialData.o());
            c(adItemData.a(), map);
            map.put("classifyByAge", adItemData.ab() != null ? adItemData.ab() : "");
            a(adItemData, map);
            map.put("tInteractiveMode", String.valueOf(materialData.af()));
        }
    }

    public static void b(Map<String, String> map) {
        h.a(map, "turnX", "-1");
        h.a(map, "turnY", "-1");
        h.a(map, "turnZ", "-1");
        h.a(map, "turnTime", "-1");
    }

    public static void a(AdItemData adItemData, Map<String, String> map) {
        if (map == null || adItemData == null) {
            return;
        }
        if (TextUtils.isEmpty(adItemData.I())) {
            map.put("isFallback", "2");
        } else {
            map.put("isFallback", "1");
            map.put("errorReqId", adItemData.I());
        }
    }

    public static void b(Map<String, String> map, float f) {
        a(map, "coverRatio", String.valueOf(f));
    }

    public static void a(String str, Map<String, String> map) {
        h.a(map, STManager.KEY_AD_POS_ID, str);
        h.a(map, "newPosId", str);
    }

    public static void b(Map<String, String> map, String str) {
        h.a(map, "clickTraceId", str);
    }

    public static void a(Map<String, String> map) {
        map.put("uSdkVC", g.g() + "");
        map.put("bizSdkVer", g.g() + "");
        map.put("InstVer", d.a().d());
        map.put("InstSdkVer", d.a().b());
    }

    public static void b(Map<String, String> map, boolean z) {
        a(map, "isFakeLocation", z ? "1" : "0");
    }

    public static void a(Map<String, String> map, float f) {
        a(map, "transparency", String.valueOf(f));
    }

    public static void a(Map<String, String> map, String str) {
        h.a(map, STManager.KEY_DATA_TYPE, str);
        h.a(map, "oriDatatype", str);
    }

    public static void a(Map<String, String> map, String str, String str2) {
        String str3;
        if (map != null) {
            String strA = h.a(map, "cTransport");
            if (TextUtils.isEmpty(strA)) {
                str3 = "";
            } else {
                str3 = strA + x.aQ;
            }
            h.a(map, "cTransport", str3 + str + "-" + str2);
        }
    }

    public static void a(Map<String, String> map, boolean z) {
        a(map, "isFakeIp", z ? "1" : "0");
    }
}
