package com.opos.mobad.j;

import android.content.Context;
import android.view.View;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    private static List<String> a(String str, MaterialData materialData) {
        str.hashCode();
        switch (str) {
            case "25":
                return materialData.w();
            case "50":
                return materialData.x();
            case "75":
                return materialData.y();
            default:
                return null;
        }
    }

    private static void b(com.opos.mobad.b bVar, View view, String str, int i, AdItemData adItemData, MaterialData materialData, int i2, long j, Map<String, String> map) {
        boolean zA = a(j, adItemData.T(), adItemData.r());
        map.put("clientTemplateId", String.valueOf(i2));
        com.opos.mobad.cmn.func.b.e.b(bVar, view, str, adItemData, materialData, zA, i, map);
    }

    private static Map<String, String> a(String str, long j, long j2) {
        HashMap map = new HashMap();
        try {
            return !com.opos.cmn.an.d.b.a(str) ? com.opos.mobad.cmn.func.b.e.a(str, j, j2) : map;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdReportHelper", "getExposeExtraMap", e);
            return map;
        }
    }

    public static void b(com.opos.mobad.b bVar, String str, int i, AdItemData adItemData, MaterialData materialData, int i2, long j, View view, Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (view != null) {
            com.opos.mobad.cmn.func.b.e.a(view, map2);
        }
        if (map != null && !map.isEmpty()) {
            String strValueOf = String.valueOf(materialData.af());
            String str2 = map.get("template_interactive_mode");
            if (map.containsKey("template_interactive_mode")) {
                map2.put("aInteractiveMode", str2);
            }
            if (strValueOf != null && !strValueOf.equals(str2)) {
                bVar.i().a(i2, strValueOf, str2);
            }
            if (map.containsKey("isVisibleRect")) {
                map2.put("isVisibleRect", map.get("isVisibleRect"));
            }
            if (map.containsKey("isAttached")) {
                map2.put("isAttached", map.get("isAttached"));
            }
        }
        b(bVar, view, str, i, adItemData, materialData, i2, j, map2);
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        com.opos.mobad.cmn.func.b.e.a(context, str, str2, com.opos.mobad.cmn.func.b.c.c.a(i), z);
    }

    public static void b(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, long j) {
        try {
            a(bVar, str, adItemData, materialData, z, "0", 0, j);
            a(bVar, materialData.v(), 0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdReportHelper", "", (Throwable) e);
        }
    }

    private static void a(com.opos.mobad.b bVar, View view, String str, int i, AdItemData adItemData, MaterialData materialData, int i2, long j, Map<String, String> map) {
        boolean zA = a(j, adItemData.T(), adItemData.r());
        map.put("clientTemplateId", String.valueOf(i2));
        com.opos.mobad.cmn.func.b.e.a(bVar, view, str, adItemData, materialData, zA, i, map);
        com.opos.mobad.service.e.c.a(bVar.b(), materialData.l());
    }

    public static void b(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.mobad.cmn.func.b.e.a(bVar, str, adItemData, materialData, iArr, z, map);
        a(bVar, materialData);
    }

    public static void a(com.opos.mobad.b bVar, AdItemData adItemData, int i) {
        if (adItemData != null) {
            HashMap map = new HashMap();
            map.put("clientTemplateId", String.valueOf(i));
            com.opos.mobad.cmn.func.b.e.a(bVar, adItemData.b(), adItemData.g(), "3", adItemData.c(), adItemData.a(), map);
        }
    }

    private static void a(com.opos.mobad.b bVar, MaterialData materialData) {
        if (materialData != null) {
            com.opos.mobad.service.e.c.a(bVar.b(), materialData.m());
        } else {
            com.opos.cmn.an.f.a.c("AdReportHelper", "close with null data");
        }
    }

    public static void a(com.opos.mobad.b bVar, String str, int i, AdItemData adItemData, MaterialData materialData, int i2, long j, View view, Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (view != null) {
            com.opos.mobad.cmn.func.b.e.a(view, map2);
        }
        if (map != null && !map.isEmpty()) {
            String strValueOf = String.valueOf(materialData.af());
            String str2 = map.get("template_interactive_mode");
            if (map.containsKey("template_interactive_mode")) {
                map2.put("aInteractiveMode", str2);
            }
            if (strValueOf != null && !strValueOf.equals(str2)) {
                bVar.i().a(i2, strValueOf, str2);
            }
            if (map.containsKey("isShowCoupons")) {
                map2.put("isShowCoupons", map.get("isShowCoupons"));
            }
            if (map.containsKey("trialGameLoadCost")) {
                map2.put("trialGameLoadCost", map.get("trialGameLoadCost"));
            }
        }
        a(bVar, view, str, i, adItemData, materialData, i2, j, map2);
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, int i, String str2, int i2, String str3) {
        String strB;
        String strC;
        String strA;
        com.opos.mobad.b bVar2;
        String str4;
        String str5;
        HashMap map = new HashMap();
        map.put("rsCode", "" + i2);
        map.put("clientTemplateId", String.valueOf(i));
        if (adItemData == null) {
            strB = "";
            strC = "";
            bVar2 = bVar;
            str4 = str;
            str5 = str2;
            strA = str3;
        } else {
            strB = adItemData.b();
            strC = adItemData.c();
            strA = adItemData.a();
            bVar2 = bVar;
            str4 = str;
            str5 = str2;
        }
        com.opos.mobad.cmn.func.b.e.a(bVar2, strB, str4, str5, strC, strA, map);
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, long j) {
        a(bVar, str, adItemData, materialData, z, "100", (int) j, j);
        a(bVar, materialData.z(), j);
    }

    private static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, String str2, int i, long j) {
        Map<String, String> mapA = a(str2, i, j);
        mapA.put("progress", String.valueOf(i));
        if (com.opos.mobad.mediaplayer.b.d.a()) {
            mapA.put("vPlyRet", String.valueOf(10413));
        }
        com.opos.mobad.cmn.func.b.e.a(bVar, str, adItemData, materialData, adItemData.H() ? false : z, mapA);
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, String str2, long j, long j2) {
        try {
            a(bVar, str, adItemData, materialData, z, str2, (int) j, j2);
            a(bVar, a(str2, materialData), j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdReportHelper", "", (Throwable) e);
        }
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.mobad.cmn.func.b.e.a(bVar, str, z, adItemData, materialData, map, iArr);
        a(bVar, materialData);
    }

    private static void a(com.opos.mobad.b bVar, List<String> list, long j) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.mobad.service.e.c.a().a(list).a(j).a(bVar.b());
    }

    private static boolean a(long j, long j2, int i) {
        boolean z = j2 < j && j - j2 <= ((long) ((i * 60) * 1000));
        com.opos.cmn.an.f.a.b("AdReportHelper", "isValidExpose=" + z);
        return z;
    }
}
