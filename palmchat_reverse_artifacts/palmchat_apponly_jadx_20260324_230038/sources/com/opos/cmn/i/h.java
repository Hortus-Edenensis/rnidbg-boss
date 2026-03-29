package com.opos.cmn.i;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h {
    public static String a(Map<String, String> map, String str) {
        if (map == null) {
            return "";
        }
        try {
            return map.containsKey(str) ? map.get(str) : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("MapUtils", "get() fail", e);
            return "";
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                map.put(str, str2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("MapUtils", "safePutValue() fail", e);
            }
        }
    }
}
