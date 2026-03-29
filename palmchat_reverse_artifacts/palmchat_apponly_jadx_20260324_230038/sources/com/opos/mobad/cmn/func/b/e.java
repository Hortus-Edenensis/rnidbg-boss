package com.opos.mobad.cmn.func.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.opos.acs.st.STManager;
import com.opos.cmn.i.o;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class e {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    public static void c(final com.opos.mobad.b bVar, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-common");
                    mapA.put(STManager.KEY_AD_POS_ID, adItemData.g());
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", "1");
                    mapA.put("dlChannel", materialData.r());
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    mapA.put("data_event", "1");
                    mapA.put("status", "3");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderCompleteEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdDownloaderCompleteEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void d(final com.opos.mobad.b bVar, String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData.g(), mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    mapA.put("evtType", "9");
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", z ? "1" : "0");
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloadDialogCancelEvent() map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdDownloadDialogCancelEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static String e(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        String strC = com.opos.mobad.mediaplayer.a.c.c(map);
        String strD = com.opos.mobad.mediaplayer.a.c.d(map);
        String strA = com.opos.cmn.i.h.a(map, "trialGameId");
        String strA2 = com.opos.cmn.i.h.a(map, "trialGameVId");
        try {
            jSONObject.put("vPlyType", strC);
            jSONObject.put("vErrType", strD);
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("trialGameId", strA);
            }
            if (!TextUtils.isEmpty(strA2)) {
                jSONObject.put("trialGameVId", strA2);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("STEventUtils", "fillPlayExtraMap", e);
        }
        return jSONObject.toString();
    }

    private static String g(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("STEventUtils", "getCommonExtraInfo() fail", e);
            }
        }
        return "";
    }

    public static Map<String, String> a(int i, String str, Map<String, String> map) {
        HashMap map2 = new HashMap();
        try {
            map2.put("vPlyRet", String.valueOf(i));
            map2.put(MediationConstant.KEY_ERROR_MSG, String.valueOf(str));
            map2.put("vExt", o.a(e(map)));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("STEventUtils", "fillPlayErrorExtraMap", e);
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        com.opos.mobad.cmn.func.b.c.c.b();
    }

    public static void c(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    mapA.put("evtType", "5");
                    mapA.put("valid", z ? "1" : "0");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordDeepLinkAdClickEvent() map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordDeepLinkAdClickEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static final void d(Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put("evtType", "1");
    }

    public static Map<String, String> a(long j, long j2) {
        HashMap map = new HashMap();
        a(map, j, j2);
        return map;
    }

    public static void b(final com.opos.mobad.b bVar, final View view, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int i, final Map<String, String> map) {
        final int iB = com.opos.mobad.d.c.e.b(view);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-expose-temp");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    mapA.put("valid", z ? "1" : "0");
                    mapA.put("sspWinPrice", i + "");
                    mapA.put("rewardScene", adItemData.w() + "");
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, com.opos.mobad.d.c.e.d(view));
                    com.opos.mobad.cmn.func.b.a.a.b(mapA, iB);
                    Map map2 = map;
                    if (map2 != null && !map2.isEmpty()) {
                        mapA.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEventWithoutFocus map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdExpEventWithoutFocus() fail", (Throwable) e);
                }
            }
        });
    }

    public static final void c(Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put("evtType", "4");
    }

    public static Map<String, String> a(String str, long j, long j2) {
        HashMap map = new HashMap();
        try {
            if (!com.opos.cmn.an.d.b.a(str)) {
                Map<String, String> mapA = a(j, j2);
                if (mapA != null && mapA.size() > 0) {
                    map.putAll(mapA);
                }
                map.put("vPrs", str);
                map.put("playProgress", str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "getVideoExposeExtraMap() fail", (Throwable) e);
        }
        return map;
    }

    public static void b(final com.opos.mobad.b bVar, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-common");
                    mapA.put(STManager.KEY_AD_POS_ID, adItemData.g());
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", "1");
                    mapA.put("dlChannel", materialData.r());
                    mapA.put("data_event", "1");
                    mapA.put("status", "1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderStartEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdDownloaderStartEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void b(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, String str2) {
        HashMap map = new HashMap();
        map.put("scene", "7");
        a(bVar, str, adItemData, materialData, str2, map);
    }

    public static void a(int i, int i2, int i3, int i4, Map<String, String> map) {
        map.put("expCoordinate", i + "-" + i2);
        map.put("expSize", i3 + "-" + i4);
    }

    public static void b(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    mapA.put("evtType", "4");
                    mapA.put("valid", z ? "1" : "0");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordMiddlePageAdClickEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordMiddlePageAdClickEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context) {
        if (com.opos.mobad.cmn.func.b.c.c.a()) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.21
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.cmn.func.b.c.c.a(context, com.opos.mobad.cmn.func.b.c.c.a(context), new com.opos.mobad.cmn.func.b.c.a() { // from class: com.opos.mobad.cmn.func.b.e.21.1
                        @Override // com.opos.mobad.cmn.func.b.c.a
                        public void a(Context context2, String str, String str2, int i, JSONObject jSONObject) {
                            com.opos.cmn.an.f.a.b("STEventUtils", "recordViewMockEvenWithId->posId:" + str + ";templateId:" + str2 + ";count:" + i + ";mockEventData:" + jSONObject);
                            e.a(context2, str, str2, i, jSONObject);
                        }
                    });
                    e.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(com.opos.mobad.b bVar, String str, Map<String, String> map) {
        String strG;
        if (map != null) {
            try {
                strG = !map.isEmpty() ? g(map) : "";
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("STEventUtils", "report transform fail", e);
                return;
            }
        }
        new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.a.a(bVar.b()), new StatisticModelIdentify(g.g() + "", com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, strG);
    }

    public static void a(Context context, String str, String str2, int i, JSONObject jSONObject) {
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("posId", str);
            jSONObject2.put("tTemplateId", str2);
            jSONObject2.put("mockEventCount", i);
            jSONObject2.put("tExtJson", jSONObject);
            com.opos.cmn.an.f.a.b("STEventUtils", "recordViewMockEvenWithId infoJson=" + jSONObject2);
            map.put("event_info", URLEncoder.encode(jSONObject2.toString()));
            map.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
            map.put("data_event", String.valueOf(22));
            map.put("uSdkVC", g.g() + "");
            com.opos.cmn.an.f.a.b("STEventUtils", "recordViewMockEvenWithId map=", map);
            a(context, "", map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("STEventUtils", "recordViewMockEvenWithId() fail", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.opos.mobad.b bVar, Map<String, String> map) {
        b(bVar, (String) null, map);
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final boolean z) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.22
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.cmn.func.b.c.c.a(context, str, str2, str3, z);
                e.a(context);
            }
        });
    }

    public static void b(Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put("evtType", "5");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, String str, Map<String, String> map) {
        String strG;
        if (map != null) {
            try {
                strG = !map.isEmpty() ? g(map) : "";
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("STEventUtils", "report() fail", e);
                return;
            }
        }
        new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.a.a(context), new StatisticModelIdentify(g.g() + "", com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, strG);
    }

    public static void b(Map<String, String> map, String str) {
        if (map != null) {
            map.put("foregroundStatus", str);
        }
    }

    public static void a(View view, Map<String, String> map) {
        try {
            Context context = view.getContext();
            view.getLocationOnScreen(new int[2]);
            a(com.opos.cmn.an.h.f.a.b(context, r1[0]), com.opos.cmn.an.h.f.a.b(context, r1[1]), com.opos.cmn.an.h.f.a.b(context, view.getWidth()), com.opos.cmn.an.h.f.a.b(context, view.getHeight()), map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
        }
    }

    public static void a(final com.opos.mobad.b bVar, final View view, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int i, final Map<String, String> map) {
        final int iB = com.opos.mobad.d.c.e.b(view);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-expose");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    mapA.put("valid", z ? "1" : "0");
                    mapA.put("sspWinPrice", i + "");
                    mapA.put("rewardScene", adItemData.w() + "");
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, com.opos.mobad.d.c.e.d(view));
                    com.opos.mobad.cmn.func.b.a.a.b(mapA, iB);
                    Map map2 = map;
                    if (map2 != null && !map2.isEmpty()) {
                        mapA.putAll(map);
                        if (map.containsKey("trialGameLoadCost")) {
                            com.opos.mobad.cmn.func.b.a.a.a(mapA, "trialGameLoadCost", (String) map.get("trialGameLoadCost"));
                        }
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdExpEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, View view, String str, AdItemData adItemData, MaterialData materialData, boolean z, Map<String, String> map) {
        a(bVar, view, str, adItemData, materialData, z, 0, map);
    }

    public static void a(final com.opos.mobad.b bVar, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData.g(), mapA);
                    mapA.put("evtType", "6");
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", "1");
                    mapA.put("dlChannel", materialData.r());
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdInstallCompleteEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdInstallCompleteEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final AdItemData adItemData, final MaterialData materialData, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-common");
                    mapA.put(STManager.KEY_AD_POS_ID, adItemData.g());
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", "1");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    mapA.put("dlChannel", materialData.r());
                    mapA.put("data_event", "1");
                    mapA.put("status", "2");
                    if (!TextUtils.isEmpty(str)) {
                        mapA.put("errormsg", str);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderFailEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdDownloaderFailEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData.g(), mapA);
                    mapA.put("valid", z ? "1" : "0");
                    mapA.put("evtType", "7");
                    mapA.put("dlChannel", materialData.r());
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdLaunchAppHomePageEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdLaunchAppHomePageEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    mapA.put(STManager.KEY_DATA_TYPE, "lm-feedback");
                    mapA.put(STManager.KEY_AD_POS_ID, str);
                    mapA.put("uSdkVC", g.g() + "");
                    mapA.put("fbContent", i + "");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFeedbackEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdFeedbackEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final long j, final long j2, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-reward");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    e.a(mapA, j2, j);
                    mapA.put("rewardScene", adItemData.w() + "");
                    mapA.put("rewardAct", i + "");
                    mapA.put("rewardDrt", adItemData.Q() + "");
                    mapA.put("rewardSource", "1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordRewardEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordRewardEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, String str2) {
        HashMap map = new HashMap();
        map.put("scene", "0");
        a(bVar, str, adItemData, materialData, str2, map);
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final String str2, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    Map map2 = map;
                    if (map2 != null && !map2.isEmpty()) {
                        mapA.putAll(map);
                    }
                    mapA.put(STManager.KEY_DATA_TYPE, "lm-l-interactive");
                    mapA.put("itrTemplateId", str2);
                    mapA.put(STManager.KEY_AD_POS_ID, str);
                    mapA.put("uSdkVC", g.g() + "");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    e.b(bVar, materialData.p(), mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordLightInteractiveEvent() dataMap=", mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("STEventUtils", "recordLightInteractiveEvent() fail", e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final String str2, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-play");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", z ? "1" : "0");
                    if (!TextUtils.isEmpty(str2)) {
                        mapA.put("clientTemplateId", str2);
                    }
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    e.a(materialData, mapA);
                    Map map2 = map;
                    if (map2 != null && !map2.isEmpty()) {
                        mapA.putAll(map);
                    }
                    com.opos.cmn.i.h.a(mapA, "progress", "-1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordVideoAdPlayErrorEvent map=", mapA);
                    com.opos.mobad.b bVar2 = bVar;
                    MaterialData materialData2 = materialData;
                    e.b(bVar2, materialData2 != null ? materialData2.p() : "", mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("STEventUtils", "recordVideoAdPlayErrorEvent", e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-play");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("valid", z ? "1" : "0");
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordVideoAdExpEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("STEventUtils", "recordVideoAdExpEvent", e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = "1";
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    mapA.put("evtType", "1");
                    if (!z) {
                        str2 = "0";
                    }
                    mapA.put("valid", str2);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdClickEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, AdItemData adItemData, MaterialData materialData, int[] iArr, boolean z, Map<String, String> map) {
        a(map, z ? "5" : "4");
        a(bVar, str, false, adItemData, materialData, map, iArr);
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final int i) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("STEventUtils", "reportActivation() report null");
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-activation");
                        mapA.put(STManager.KEY_AD_POS_ID, str);
                        String str3 = str2;
                        if (str3 == null) {
                            str3 = "";
                        }
                        mapA.put("targetPkg", str3);
                        mapA.put("code", String.valueOf(i));
                        e.b(bVar, (String) null, mapA);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("STEventUtils", "reportActivation() fail", e);
                    }
                }
            });
        }
    }

    public static void a(com.opos.mobad.b bVar, String str, String str2, int i, long j, boolean z, String str3, String str4, String str5, String str6) {
        a(bVar, str, str2, i, j, z, str3, str4, str5, str6, "", "");
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final int i, final long j, final boolean z, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.utils.f.a(bVar.b(), str)) {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-show");
                        mapA.put(STManager.KEY_AD_POS_ID, str);
                        mapA.put("adSource", "");
                        com.opos.mobad.cmn.func.b.a.a.c(str2, mapA);
                        mapA.put("rt", String.valueOf(j));
                        mapA.put("uSdkVC", g.g() + "");
                        mapA.put("ret", "2");
                        String str9 = str8;
                        if (str9 == null) {
                            str9 = "";
                        }
                        mapA.put("filteIds", str9);
                        String str10 = str7;
                        if (str10 == null) {
                            str10 = "";
                        }
                        mapA.put("st", str10);
                        com.opos.mobad.cmn.func.b.a.a.b("", mapA);
                        HashMap map = new HashMap();
                        map.put("rsCode", "" + i);
                        mapA.put("cache", z ? "1" : "0");
                        String str11 = str3;
                        if (str11 == null) {
                            str11 = "";
                        }
                        mapA.put("process", str11);
                        String str12 = str4;
                        if (str12 == null) {
                            str12 = "";
                        }
                        mapA.put("classifyByAge", str12);
                        String str13 = str5;
                        if (str13 == null) {
                            str13 = "";
                        }
                        mapA.put("cAdTrace", str13);
                        String str14 = str6;
                        mapA.put("cKeyWords", str14 != null ? str14 : "");
                        if (map.size() > 0) {
                            mapA.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqFail map=", mapA);
                        e.b(bVar, mapA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdReqFail() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, String str2, int i, String str3, long j, String str4, boolean z) {
        a(bVar, str, str2, i, str3, j, str4, z, false);
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final int i, final String str3, final long j, final String str4, final boolean z, final boolean z2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.utils.f.a(bVar.b(), str)) {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        mapA.put(STManager.KEY_AD_POS_ID, str);
                        com.opos.mobad.cmn.func.b.a.a.c(str2, mapA);
                        mapA.put("rsCode", String.valueOf(i));
                        mapA.put("ret", "2");
                        mapA.put("rt", String.valueOf(j));
                        mapA.put("uSdkVC", g.g() + "");
                        mapA.put("type", z ? "2" : "1");
                        mapA.put("isFallback", z2 ? "1" : "2");
                        String str5 = str3;
                        if (str5 == null) {
                            str5 = "";
                        }
                        mapA.put("filteIds", str5);
                        String str6 = str4;
                        mapA.put("st", str6 != null ? str6 : "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", mapA);
                        e.b(bVar, mapA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdFetchEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final AdHelper.AdHelperData adHelperData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.c(str2, mapA);
                    AdHelper.AdHelperData adHelperData2 = adHelperData;
                    if (adHelperData2 != null) {
                        com.opos.mobad.cmn.func.b.a.a.a(adHelperData2.c, adHelperData2.d, mapA);
                    }
                    bVar.i().b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "reportAdShow() dataMap=", mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("STEventUtils", "reportAdShow() fail", e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, String str2, String str3, long j, boolean z, String str4, String str5, int i, String str6, String str7) {
        a(bVar, str, str2, str3, j, z, str4, str5, i, str6, str7, "", "");
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final String str3, final long j, final boolean z, final String str4, final String str5, final int i, final String str6, final String str7, final String str8, final String str9) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.23
            @Override // java.lang.Runnable
            public void run() {
                String str10 = "1";
                try {
                    if (com.opos.mobad.model.utils.f.a(bVar.b(), str)) {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-show");
                        mapA.put(STManager.KEY_AD_POS_ID, str);
                        mapA.put("adSource", "");
                        com.opos.mobad.cmn.func.b.a.a.c(str3, mapA);
                        mapA.put("rt", String.valueOf(j));
                        mapA.put("uSdkVC", g.g() + "");
                        mapA.put("ret", "1");
                        String str11 = str4;
                        if (str11 == null) {
                            str11 = "";
                        }
                        mapA.put("process", str11);
                        String str12 = str9;
                        if (str12 == null) {
                            str12 = "";
                        }
                        mapA.put("filteIds", str12);
                        String str13 = str8;
                        if (str13 == null) {
                            str13 = "";
                        }
                        mapA.put("st", str13);
                        com.opos.mobad.cmn.func.b.a.a.b(str2, mapA);
                        if (!z) {
                            str10 = "0";
                        }
                        mapA.put("cache", str10);
                        String str14 = str5;
                        if (str14 == null) {
                            str14 = "";
                        }
                        mapA.put("classifyByAge", str14);
                        mapA.put("ecpm", i + "");
                        String str15 = str6;
                        if (str15 == null) {
                            str15 = "";
                        }
                        mapA.put("cAdTrace", str15);
                        String str16 = str7;
                        mapA.put("cKeyWords", str16 != null ? str16 : "");
                        com.opos.mobad.cmn.func.b.a.a.a(mapA, g.c(bVar.b()));
                        com.opos.mobad.cmn.func.b.a.a.b(mapA, com.opos.mobad.service.d.b.a().c() != null && com.opos.mobad.service.d.b.a().c().d());
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", mapA);
                        e.b(bVar, mapA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdReqEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, String str2, String str3, String str4, long j, String str5, boolean z) {
        a(bVar, str, str2, str3, str4, j, str5, z, false);
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final String str3, final String str4, final long j, final String str5, final boolean z, final boolean z2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.utils.f.a(bVar.b(), str)) {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        mapA.put(STManager.KEY_AD_POS_ID, str);
                        com.opos.mobad.cmn.func.b.a.a.c(str2, mapA);
                        mapA.put("ret", str3);
                        mapA.put("rt", String.valueOf(j));
                        mapA.put("uSdkVC", g.g() + "");
                        mapA.put("type", z ? "2" : "1");
                        mapA.put("isFallback", z2 ? "1" : "2");
                        String str6 = str4;
                        if (str6 == null) {
                            str6 = "";
                        }
                        mapA.put("filteIds", str6);
                        String str7 = str5;
                        mapA.put("st", str7 != null ? str7 : "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchSuccEvent map=", mapA);
                        e.b(bVar, mapA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdFetchSuccEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(com.opos.mobad.b bVar, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        HashMap map = new HashMap();
        map.put("rsCode", "" + i2);
        map.put("clientTemplateId", String.valueOf(i));
        a(bVar, str, str2, str3, str4, str5, map);
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final String str3, final String str4, final String str5, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.utils.f.a(bVar.b(), str2)) {
                        Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                        mapA.put(STManager.KEY_DATA_TYPE, "lm-show");
                        mapA.put(STManager.KEY_AD_POS_ID, str2);
                        mapA.put("adSource", str);
                        com.opos.mobad.cmn.func.b.a.a.c(str5, mapA);
                        mapA.put("ret", str3);
                        com.opos.mobad.cmn.func.b.a.a.b(str4, mapA);
                        com.opos.mobad.cmn.func.b.a.a.a(mapA);
                        Map map2 = map;
                        if (map2 != null && map2.size() > 0) {
                            mapA.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdRenderEvent map=", mapA);
                        e.b(bVar, mapA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdRenderEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final String str2, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-common");
                    mapA.put("data_event", "3");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.c(str2, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    mapA.put("cExtInfo", e.h(map));
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordMspDqResult map=", mapA);
                    e.b(bVar, "", mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("STEventUtils", "recordMspDqResult() fail", e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.b bVar, final String str, final boolean z, final AdItemData adItemData, final MaterialData materialData, final Map<String, String> map, final int[] iArr) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.func.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                Map map2;
                String str2 = "2";
                try {
                    if (adItemData == null || materialData == null) {
                        return;
                    }
                    Map<String, String> mapA = com.opos.mobad.cmn.func.b.a.a.a(bVar);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA, "lm-click");
                    mapA.put("evtType", "2");
                    com.opos.mobad.cmn.func.b.a.a.a(str, mapA);
                    com.opos.mobad.cmn.func.b.a.a.a(adItemData, materialData, mapA);
                    if (z) {
                        str2 = "3";
                    } else {
                        if (1 != adItemData.k()) {
                            if (2 == adItemData.k()) {
                            }
                            com.opos.mobad.cmn.func.b.a.a.a(mapA);
                            map2 = map;
                            if (map2 != null && map2.size() > 0) {
                                mapA.putAll(map);
                            }
                            e.a(iArr, mapA);
                            com.opos.mobad.cmn.func.b.a.a.b(mapA);
                            com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", mapA);
                            e.b(bVar, materialData.p(), mapA);
                        }
                        str2 = "1";
                    }
                    e.a(mapA, str2);
                    com.opos.mobad.cmn.func.b.a.a.a(mapA);
                    map2 = map;
                    if (map2 != null) {
                        mapA.putAll(map);
                    }
                    e.a(iArr, mapA);
                    com.opos.mobad.cmn.func.b.a.a.b(mapA);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", mapA);
                    e.b(bVar, materialData.p(), mapA);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "recordAdCloseEvent() fail", (Throwable) e);
                }
            }
        });
    }

    public static void a(MaterialData materialData, Map<String, String> map) {
        List<MaterialFileData> listD;
        MaterialFileData materialFileData;
        if (materialData == null || (listD = materialData.D()) == null || listD.isEmpty() || (materialFileData = listD.get(0)) == null) {
            return;
        }
        map.put("vUrl", materialFileData.a());
    }

    public static void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put("evtType", "9");
    }

    public static final void a(Map<String, String> map, long j, long j2) {
        try {
            map.put("vDrt", j2 + "");
            map.put("vedioduration", j2 + "");
            map.put("vPlyPos", j + "");
            map.put("currentPos", j + "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "fillVideoProcess() fail", (Throwable) e);
        }
    }

    public static void a(Map<String, String> map, MaterialData materialData) {
        if (map == null || materialData == null) {
            return;
        }
        map.put("evtType", "7");
        map.put("dlChannel", materialData.r() != null ? materialData.r() : "");
    }

    public static void a(Map<String, String> map, String str) {
        if (map != null) {
            map.put("clsType", str);
            map.put("handleObj", BaseWrapper.ENTER_ID_MARKET);
            map.put("handleValue", b(str));
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        a(map, str, str2, "1");
    }

    public static void a(Map<String, String> map, String str, String str2, String str3) {
        if (map != null) {
            try {
                map.put("actSource", str);
                map.put("interactiveMode", str3);
                map.put("handleObj", a(str));
                map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, String.valueOf(str2));
                map.put("handleValue", String.valueOf(str2));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
            }
        }
    }

    public static void a(Map<String, String> map, String str, int[] iArr) {
        if (map != null) {
            try {
                map.put("actSource", "7");
                map.put("interactiveMode", "2");
                map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, String.valueOf(str));
                if (iArr == null || iArr.length != 3) {
                    return;
                }
                map.put("xAcc", String.valueOf(iArr[0]));
                map.put("yAcc", String.valueOf(iArr[1]));
                map.put("zAcc", String.valueOf(iArr[2]));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
            }
        }
    }

    public static void a(int[] iArr, Map<String, String> map) {
        String str;
        String str2;
        if (iArr == null || iArr.length != 4) {
            return;
        }
        String str3 = map.get("actSource");
        if ("10".equals(str3) || "9".equals(str3)) {
            str = iArr[0] + x.aQ + iArr[1] + x.aQ + iArr[2] + x.aQ + iArr[3];
            str2 = "tiltAngle";
        } else {
            map.put(STManager.KEY_DOWN_X, iArr[0] + "");
            map.put(STManager.KEY_DOWN_Y, iArr[1] + "");
            map.put("upX", iArr[2] + "");
            map.put("upY", iArr[3] + "");
            str = iArr[2] + "-" + iArr[3] + "-" + iArr[0] + "-" + iArr[1];
            str2 = "coordinates";
        }
        map.put(str2, str);
    }
}
