package com.vivo.push.util;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class f {
    public static boolean a(long j, long j2) {
        t.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
        HashMap<String, String> map = new HashMap<>();
        map.put(com.heytap.mcssdk.constant.b.c, String.valueOf(j));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        xVar.a(map);
        com.vivo.push.m.a().a(xVar);
        return true;
    }

    public static boolean a(long j, HashMap<String, String> map) {
        if (map == null) {
            t.a("ClientReportUtil", "reportParams is null");
            return false;
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j);
        xVar.a(map);
        xVar.d();
        com.vivo.push.m.a().a(xVar);
        return true;
    }
}
