package com.vivo.push.g;

import android.text.TextUtils;
import com.vivo.push.g.u;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class w implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f11244a;

    public w(v vVar) {
        this.f11244a = vVar;
    }

    @Override // com.vivo.push.g.u.a
    public final void a() {
        long jK = com.vivo.push.m.a().k();
        if (jK < 1400 && jK != 1340) {
            com.vivo.push.util.t.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(jK)));
            return;
        }
        HashMap map = new HashMap();
        map.put("srt", "1");
        map.put("message_id", String.valueOf(this.f11244a.b.g()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("app_id", strA);
        }
        map.put("type", "1");
        map.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) map);
    }

    @Override // com.vivo.push.g.u.a
    public final void b() {
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.c, String.valueOf(this.f11244a.b.g()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) map);
    }
}
