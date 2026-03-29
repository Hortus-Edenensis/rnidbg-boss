package com.opos.mobad.model.utils;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, com.opos.mobad.model.c.e> f9110a = new ConcurrentHashMap();

    private static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> listI;
        MaterialData materialData;
        List<MaterialFileData> listD;
        if (adItemData == null || (listI = adItemData.i()) == null || listI.size() <= 0 || (materialData = listI.get(0)) == null || (listD = materialData.D()) == null || listD.size() <= 0) {
            return null;
        }
        return listD.get(0);
    }

    public static void b(Context context, AdData adData) {
        List<AdItemData> listF;
        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheNextVideo");
        if (adData == null || (listF = adData.f()) == null || listF.size() <= 0) {
            return;
        }
        for (int i = 0; i < listF.size(); i++) {
            MaterialFileData materialFileDataA = a(listF.get(i));
            if (materialFileDataA != null && TextUtils.isEmpty(com.opos.cmn.d.d.a(context, materialFileDataA.a(), materialFileDataA.b()))) {
                String strA = com.opos.cmn.d.c.a(materialFileDataA.a());
                com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + f9110a.size());
                if (f9110a.size() >= 2 || f9110a.containsKey(strA) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.e.b.a.c() <= 2147483648L) {
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                    return;
                }
                com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + materialFileDataA.toString());
                a(context, materialFileDataA);
                return;
            }
        }
    }

    public static void a(final Context context, ac acVar) {
        final List<ab> list = acVar.as;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.utils.g.1
            @Override // java.lang.Runnable
            public void run() {
                for (ab abVar : list) {
                    if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, abVar.f, abVar.g))) {
                        String strA = com.opos.cmn.d.c.a(abVar.f);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + g.f9110a.size());
                        if (g.f9110a.size() >= 2 || g.f9110a.containsKey(strA) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.e.b.a.c() <= 2147483648L) {
                            com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                            return;
                        }
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + abVar.toString());
                        HashSet hashSet = new HashSet();
                        com.opos.mobad.model.c.e eVar = new com.opos.mobad.model.c.e();
                        eVar.a(abVar.f);
                        eVar.b(abVar.g);
                        eVar.c(com.opos.cmn.d.d.b(context, abVar.f));
                        hashSet.add(eVar);
                        g.f9110a.put(strA, eVar);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + abVar.toString() + ",result=" + new com.opos.mobad.model.e.e(context).a(hashSet));
                        g.f9110a.remove(strA);
                        return;
                    }
                }
            }
        });
    }

    private static void a(final Context context, final MaterialFileData materialFileData) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.utils.g.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (materialFileData != null) {
                        HashSet hashSet = new HashSet();
                        com.opos.mobad.model.c.e eVar = new com.opos.mobad.model.c.e();
                        eVar.a(materialFileData.a());
                        eVar.b(materialFileData.b());
                        eVar.c(com.opos.cmn.d.d.b(context, materialFileData.a()));
                        hashSet.add(eVar);
                        String strA = com.opos.cmn.d.c.a(materialFileData.a());
                        g.f9110a.put(strA, eVar);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + materialFileData.toString() + ",result=" + new com.opos.mobad.model.e.e(context).a(hashSet));
                        g.f9110a.remove(strA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("VideoCacheUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static final boolean a(Context context, AdData adData) {
        if (context == null || adData == null) {
            return false;
        }
        try {
            List<AdItemData> listF = adData.f();
            if (listF == null || listF.size() <= 0) {
                return false;
            }
            for (int i = 0; i < listF.size(); i++) {
                if (1 == listF.get(i).t()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("VideoCacheUtils", "", e);
            return false;
        }
    }
}
