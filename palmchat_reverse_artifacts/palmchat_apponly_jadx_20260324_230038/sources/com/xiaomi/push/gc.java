package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gc {
    public static void a(Context context, ge geVar, List<gj> list) {
        HashMap<String, ArrayList<gj>> mapA = a(context, list);
        if (mapA != null && mapA.size() != 0) {
            a(context, geVar, mapA);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    private static HashMap<String, ArrayList<gj>> a(Context context, List<gj> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<gj>> map = new HashMap<>();
        for (gj gjVar : list) {
            a(context, gjVar);
            ArrayList<gj> arrayList = map.get(gjVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(gjVar.c(), arrayList);
            }
            arrayList.add(gjVar);
        }
        return map;
    }

    private static void a(Context context, gj gjVar) {
        if (gjVar.f510a) {
            gjVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(gjVar.d())) {
            gjVar.f(com.xiaomi.push.service.az.a());
        }
        gjVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(gjVar.e())) {
            gjVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(gjVar.c())) {
            gjVar.e(gjVar.e());
        }
    }

    private static void a(Context context, ge geVar, HashMap<String, ArrayList<gj>> map) {
        for (Map.Entry<String, ArrayList<gj>> entry : map.entrySet()) {
            try {
                ArrayList<gj> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    geVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }
}
