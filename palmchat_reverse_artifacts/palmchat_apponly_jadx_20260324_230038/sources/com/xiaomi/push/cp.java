package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11478a = "disconnection_event";
    private final String b = "count";
    private final String c = "host";
    private final String d = "network_state";
    private final String e = "reason";
    private final String f = "ping_interval";
    private final String g = "network_type";
    private final String h = "wifi_digest";
    private final String i = "duration";
    private final String j = "disconnect_time";
    private final String k = "connect_time";
    private final String l = "xmsf_vc";
    private final String m = "android_vc";
    private final String n = Constant.MAP_KEY_UUID;

    public void a(Context context, List<co> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        cn.a("upload size = " + list.size());
        String strM766a = com.xiaomi.push.service.q.m766a(context);
        for (co coVar : list) {
            HashMap map = new HashMap();
            map.put("count", Integer.valueOf(coVar.a()));
            map.put("host", coVar.m268a());
            map.put("network_state", Integer.valueOf(coVar.b()));
            map.put("reason", Integer.valueOf(coVar.c()));
            map.put("ping_interval", Long.valueOf(coVar.m267a()));
            map.put("network_type", Integer.valueOf(coVar.d()));
            map.put("wifi_digest", coVar.m270b());
            map.put("connected_network_type", Integer.valueOf(coVar.e()));
            map.put("duration", Long.valueOf(coVar.m269b()));
            map.put("disconnect_time", Long.valueOf(coVar.m271c()));
            map.put("connect_time", Long.valueOf(coVar.m272d()));
            map.put("xmsf_vc", Integer.valueOf(coVar.f()));
            map.put("android_vc", Integer.valueOf(coVar.g()));
            map.put(Constant.MAP_KEY_UUID, strM766a);
            eh.a().a("disconnection_event", map);
        }
    }
}
