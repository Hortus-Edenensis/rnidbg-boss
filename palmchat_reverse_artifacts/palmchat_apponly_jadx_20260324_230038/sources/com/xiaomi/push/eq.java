package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.dp;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class eq {
    public static void a(am.b bVar, String str, fa faVar) {
        String strA;
        dp.c cVar = new dp.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f938a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        er erVar = new er();
        erVar.c(bVar.f939b);
        erVar.a(Integer.parseInt(bVar.g));
        erVar.b(bVar.f936a);
        erVar.a("BIND", (String) null);
        erVar.a(erVar.e());
        com.xiaomi.channel.commonutils.logger.b.m74a("[Slim]: bind id=" + erVar.e());
        HashMap map = new HashMap();
        map.put("challenge", str);
        map.put("token", bVar.c);
        map.put("chid", bVar.g);
        map.put("from", bVar.f939b);
        map.put("id", erVar.e());
        map.put(RemoteMessageConst.TO, "xiaomi.com");
        if (bVar.f938a) {
            map.put("kick", "1");
        } else {
            map.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.e)) {
            map.put("client_attrs", "");
        } else {
            map.put("client_attrs", bVar.e);
        }
        if (TextUtils.isEmpty(bVar.f)) {
            map.put("cloud_attrs", "");
        } else {
            map.put("cloud_attrs", bVar.f);
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            strA = az.a(bVar.d, null, map, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            strA = null;
        }
        cVar.f(strA);
        erVar.a(cVar.m398a(), (String) null);
        faVar.b(erVar);
    }

    public static void a(String str, String str2, fa faVar) {
        er erVar = new er();
        erVar.c(str2);
        erVar.a(Integer.parseInt(str));
        erVar.a("UBND", (String) null);
        faVar.b(erVar);
    }
}
