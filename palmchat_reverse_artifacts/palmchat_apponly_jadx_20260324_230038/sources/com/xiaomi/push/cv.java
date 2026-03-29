package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11486a = "power_consumption_stats";
    private final String b = "off_up_ct";
    private final String c = "off_dn_ct";
    private final String d = "off_ping_ct";
    private final String e = "off_pong_ct";
    private final String f = "off_dur";
    private final String g = "on_up_ct";
    private final String h = "on_dn_ct";
    private final String i = "on_ping_ct";
    private final String j = "on_pong_ct";
    private final String k = "on_dur";
    private final String l = com.umeng.analytics.pro.f.p;
    private final String m = com.umeng.analytics.pro.f.q;
    private final String n = "xmsf_vc";
    private final String o = "android_vc";
    private final String p = Constant.MAP_KEY_UUID;

    public void a(Context context, cu cuVar) {
        if (cuVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("off_up_ct", Integer.valueOf(cuVar.a()));
        map.put("off_dn_ct", Integer.valueOf(cuVar.b()));
        map.put("off_ping_ct", Integer.valueOf(cuVar.c()));
        map.put("off_pong_ct", Integer.valueOf(cuVar.d()));
        map.put("off_dur", Long.valueOf(cuVar.m278a()));
        map.put("on_up_ct", Integer.valueOf(cuVar.e()));
        map.put("on_dn_ct", Integer.valueOf(cuVar.f()));
        map.put("on_ping_ct", Integer.valueOf(cuVar.g()));
        map.put("on_pong_ct", Integer.valueOf(cuVar.h()));
        map.put("on_dur", Long.valueOf(cuVar.m279b()));
        map.put(com.umeng.analytics.pro.f.p, Long.valueOf(cuVar.m280c()));
        map.put(com.umeng.analytics.pro.f.q, Long.valueOf(cuVar.m281d()));
        map.put("xmsf_vc", Integer.valueOf(cuVar.i()));
        map.put("android_vc", Integer.valueOf(cuVar.j()));
        map.put(Constant.MAP_KEY_UUID, com.xiaomi.push.service.q.m766a(context));
        eh.a().a("power_consumption_stats", map);
    }
}
