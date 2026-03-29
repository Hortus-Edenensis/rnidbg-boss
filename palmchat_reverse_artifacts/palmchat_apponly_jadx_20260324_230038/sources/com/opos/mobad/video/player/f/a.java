package com.opos.mobad.video.player.f;

import android.content.Context;
import com.nearme.play.api.AdTrialGameInfo;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.a.a.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.opos.mobad.video.player.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0817a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10344a;
        public String b;
        public long c;

        public String toString() {
            return "FetchParams{context=" + this.f10344a + ", id='" + this.b + "', vId=" + this.c + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(AdTrialGameInfo adTrialGameInfo);

        void a(com.opos.mobad.video.player.f.a.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> c(C0817a c0817a) {
        HashMap map = new HashMap(2);
        try {
            map.put("Content-Type", "application/json");
            if (c0817a != null) {
                map.put("Route-Data", e.a(c0817a.f10344a));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGameModel", "getHeaderMap() fail", e);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] d(C0817a c0817a) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", c0817a.b);
            jSONObject.put("vId", c0817a.c);
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TrialGameModel", "getData() fail", e);
            return null;
        }
    }

    public static void a(final C0817a c0817a, final b bVar) {
        com.opos.cmn.an.f.a.b("TrialGameModel", "fetchTrialGameInfo()", "params=", c0817a);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (!com.opos.cmn.an.h.c.a.d(c0817a.f10344a)) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(new com.opos.mobad.video.player.f.a.b(10100, "no net."));
                    }
                    com.opos.cmn.an.f.a.b("TrialGameModel", "fetchTrialGameInfo() but not net.");
                    return;
                }
                try {
                    com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(c0817a.f10344a, new d.a().a(a.d(c0817a)).a(a.c(c0817a)).a("POST").b("https://uapi.ads.oppomobile.com/union/demo/game/query").a());
                    if (eVarA == null || 200 != (i = eVarA.f7934a)) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("TrialGameModel", "fetchTrialGameInfo()", "code=", Integer.valueOf(i), "msg=", eVarA.b);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(eVarA.c);
                    try {
                        byte[] bArr = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int i2 = bufferedInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else if (i2 > 0) {
                                byteArrayOutputStream.write(bArr, 0, i2);
                            }
                        }
                        String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                        com.opos.cmn.an.f.a.b("TrialGameModel", "fetchTrialGameInfo()", "response=" + str);
                        JSONObject jSONObject = new JSONObject(str);
                        int i3 = jSONObject.getInt("ret");
                        if (i3 == 0) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (jSONObjectOptJSONObject != null) {
                                b bVar3 = bVar;
                                if (bVar3 != null) {
                                    bVar3.a(com.opos.mobad.cmn.b.a.a(jSONObjectOptJSONObject));
                                }
                            } else {
                                b bVar4 = bVar;
                                if (bVar4 != null) {
                                    bVar4.a(new com.opos.mobad.video.player.f.a.b(10418, com.opos.mobad.ad.a.a(10418) + "Response is null."));
                                }
                            }
                        } else {
                            b bVar5 = bVar;
                            if (bVar5 != null) {
                                bVar5.a(new com.opos.mobad.video.player.f.a.b(10418, com.opos.mobad.ad.a.a(10418) + "Response ret=" + i3));
                            }
                        }
                        bufferedInputStream.close();
                    } finally {
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("TrialGameModel", "fetchTrialGameInfo() fail", e);
                    b bVar6 = bVar;
                    if (bVar6 != null) {
                        bVar6.a(new com.opos.mobad.video.player.f.a.b(10418, com.opos.mobad.ad.a.a(10418) + e.getMessage()));
                    }
                }
            }
        });
    }
}
