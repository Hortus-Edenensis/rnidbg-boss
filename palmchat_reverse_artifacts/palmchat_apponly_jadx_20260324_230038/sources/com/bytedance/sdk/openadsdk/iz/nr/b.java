package com.bytedance.sdk.openadsdk.iz.nr;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.iz.fx.a;
import com.bytedance.sdk.openadsdk.iz.fx.jk;
import com.bytedance.sdk.openadsdk.iz.fx.k;
import com.bytedance.sdk.openadsdk.iz.fx.l;
import com.bytedance.sdk.openadsdk.iz.fx.mv;
import com.bytedance.sdk.openadsdk.iz.fx.my;
import com.bytedance.sdk.openadsdk.iz.fx.n;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import com.bytedance.sdk.openadsdk.iz.fx.pn;
import com.bytedance.sdk.openadsdk.iz.fx.s;
import com.bytedance.sdk.openadsdk.iz.fx.t;
import com.bytedance.sdk.openadsdk.iz.fx.x;
import com.cdo.oaps.ad.OapsWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.DesugarCollections;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final Map<com.bykv.vk.openvk.component.video.api.nr.u, o> u = DesugarCollections.synchronizedMap(new WeakHashMap());

    public static void b(com.bytedance.sdk.openadsdk.iz.fx.nr<jk> nrVar) {
        nr(nrVar, "load_video_cancel");
    }

    public static void fx(com.bytedance.sdk.openadsdk.iz.fx.nr<t> nrVar) {
        nr(nrVar, "load_video_error");
    }

    public static void pn(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.11
            @Override // java.lang.Runnable
            public void run() {
                o.u uVar3;
                o oVar;
                if (uVar == null || (uVar3 = uVar2) == null || uVar3.l() <= 0 || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jB = uVar2.b();
                if (jB <= 0) {
                    return;
                }
                s sVar = new s();
                sVar.u(uVar2.fx());
                sVar.nr(jB);
                sVar.u(uVar2.l());
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, sVar);
                nrVar.u(uVar2.mv());
                b.nr(nrVar, "play_buffer");
            }
        });
    }

    public static void b(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.10
            @Override // java.lang.Runnable
            public void run() {
                o.u uVar3;
                com.bykv.vk.openvk.component.video.api.nr.u uVar4 = uVar;
                if (uVar4 == null || (uVar3 = uVar2) == null) {
                    return;
                }
                b.pn(uVar4, uVar3);
                o oVar = (o) b.u.get(uVar);
                if (oVar == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                if (jB <= 0) {
                    return;
                }
                x xVar = new x();
                xVar.nr(uVar2.fx());
                xVar.u(jB);
                xVar.u(uVar2.t());
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, xVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    com.bytedance.sdk.openadsdk.core.rh.s.u(jNr, bcVarPn, izVarB);
                    b.nr(nrVar, b.nr(bcVarPn, "feed_over"), jSONObject);
                } catch (JSONException unused) {
                }
                b.u.remove(uVar);
            }
        });
    }

    public static void fx(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.8
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                com.bytedance.sdk.openadsdk.iz.fx.fx fxVar = new com.bytedance.sdk.openadsdk.iz.fx.fx();
                fxVar.fx(uVar2.fx());
                fxVar.b(jB);
                fxVar.nr(uVar2.x());
                fxVar.fx(uVar2.n());
                fxVar.nr(com.bytedance.sdk.openadsdk.gi.jk.u(bcVarPn.oi()).nr(izVarB));
                fxVar.u(jNr);
                fxVar.u(uVar2.a());
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, fxVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    b.nr(nrVar, "endcard_skip", jSONObject);
                } catch (JSONException unused) {
                }
                fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.u.remove(uVar);
                    }
                }, 1000L);
            }
        });
    }

    private static boolean pn(com.bytedance.sdk.openadsdk.iz.fx.nr nrVar) {
        bc bcVarU;
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm;
        if (nrVar == null || !nrVar.pn() || (bcVarU = nrVar.u()) == null || (nrVarTm = bcVarU.tm()) == null) {
            return false;
        }
        String strC = nrVarTm.c();
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strC);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString("name");
                if ("content_did".equalsIgnoreCase(strOptString)) {
                    z = true;
                } else if ("content_utmsource".equalsIgnoreCase(strOptString)) {
                    z2 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(strOptString)) {
                    z3 = true;
                }
            }
            return z && z2 && z3;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(iz izVar) {
        return new File(izVar.pn(), izVar.o()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long fx(iz izVar) {
        if (izVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.fx.b bVarQq = izVar.s() ? izVar.qq() : izVar.q();
        if (bVarQq != null) {
            return Double.valueOf(bVarQq.iz() * 1000.0d).longValue();
        }
        return 0L;
    }

    public static void nr(com.bytedance.sdk.openadsdk.iz.fx.nr<mv> nrVar) {
        nr(nrVar, "load_video_success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String nr(bc bcVar, String str) {
        if (bcVar == null || !jp.n(bcVar) || !jp.a(bcVar)) {
            return str;
        }
        str.hashCode();
        switch (str) {
        }
        return str;
    }

    public static JSONObject u(iz izVar, String str, int i, int i2, bc bcVar, long j) {
        com.bykv.vk.openvk.component.video.api.fx.b bVarQ;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (com.bytedance.sdk.openadsdk.gi.t.u(bcVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (izVar != null) {
                if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
                    jSONObject.put("codec", bcVar.o());
                    bVarQ = null;
                } else if (izVar.s()) {
                    bVarQ = izVar.qq();
                    jSONObject.put("codec", "h265");
                } else {
                    bVarQ = izVar.q();
                }
                if (bVarQ != null) {
                    jSONObject.put("video_resolution", bVarQ.a());
                    jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, Long.valueOf(bVarQ.pn()));
                    String strL = bVarQ.l();
                    jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_URL, strL);
                    jSONObject.put("is_expired", jp.l(strL));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (jp.s(bcVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", bVarQ.n());
                    if (bVarQ.x() > 0.0d) {
                        jSONObject.put("start", bVarQ.x());
                    }
                }
            }
            if (bcVar != null) {
                jSONObject.put("dynamic_join_type", bcVar.ts());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void nr(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.6
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                if (jB <= 0 || jNr <= 0) {
                    return;
                }
                com.bytedance.sdk.openadsdk.iz.fx.iz izVar = new com.bytedance.sdk.openadsdk.iz.fx.iz();
                izVar.u(uVar2.fx());
                izVar.nr(jB);
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, izVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    b.nr(nrVar, "feed_continue", jSONObject);
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(com.bytedance.sdk.openadsdk.iz.fx.nr nrVar, String str) {
        nr(nrVar, str, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final com.bytedance.sdk.openadsdk.iz.fx.nr nrVar, String str, JSONObject jSONObject) {
        if (nrVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nrVar.pn() && !TextUtils.isEmpty(nrVar.nr()) && !pn(nrVar)) {
            String strNr = nrVar.nr();
            strNr.hashCode();
            switch (strNr) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        nr.u(str, nrVar.u());
        com.bytedance.sdk.openadsdk.core.s.b.u(nrVar.u(), nrVar.nr(), str, jSONObject, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.2
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectFx = nrVar.fx();
                if (nrVar.b() != null) {
                    nrVar.b().a_(jSONObjectFx);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectFx.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(final bc bcVar, final iz izVar, final o.u uVar) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.3
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", b.fx(izVar));
                jSONObject.put("player_duration", uVar.b());
                jSONObject.put("cache_path_type", com.bytedance.sdk.openadsdk.gi.jk.b());
                jSONObject.put("url", izVar.my());
                jSONObject.put(OapsWrapper.KEY_PATH, b.b(izVar));
                jSONObject.put("player_type", izVar.sx());
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pangle_video_play_state").u(jp.jk(bcVar)).nr(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    public static synchronized iz nr(com.bykv.vk.openvk.component.video.api.nr.u uVar) {
        if (uVar == null) {
            return null;
        }
        o oVar = u.get(uVar);
        if (oVar == null) {
            return null;
        }
        return oVar.b();
    }

    public static void u(com.bytedance.sdk.openadsdk.iz.fx.nr<l> nrVar) {
        nr(nrVar, "load_video_start");
    }

    public static int u(bc bcVar, iz izVar, long j) {
        int iOi = bcVar.oi();
        com.bykv.vk.openvk.component.video.api.u.nr nrVarU = com.bytedance.sdk.openadsdk.gi.jk.u(iOi);
        if (iOi != 0) {
            if (iOi == 1) {
                return nrVarU.u(izVar) ? 1 : 2;
            }
            return 3;
        }
        boolean zMv = izVar.mv();
        int iIz = izVar.iz();
        long jL = izVar.l();
        if (zMv) {
            iIz = (int) jL;
        }
        int iNr = izVar.nr();
        if (iNr > 0) {
            iIz = iNr;
        }
        boolean z = j >= ((long) iIz);
        boolean z2 = j >= jL;
        if (j == 0) {
            return 2;
        }
        if (z2) {
            return 4;
        }
        return (!z || iIz == 0) ? 1 : 5;
    }

    public static String u() {
        return UUID.randomUUID().toString();
    }

    public static void u(final bc bcVar, final com.bykv.vk.openvk.component.video.api.nr.u uVar, final iz izVar, final boolean z, final String str) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.1
            @Override // java.lang.Runnable
            public void run() {
                bc bcVar2 = bcVar;
                if (bcVar2 == null || uVar == null || izVar == null) {
                    return;
                }
                long jNr = com.bytedance.sdk.openadsdk.gi.jk.u(bcVar2.oi()).nr(izVar);
                int iU = b.u(bcVar, izVar, jNr);
                b.u.put(uVar, new o(SystemClock.elapsedRealtime(), str, iU, izVar, bcVar));
                my myVar = new my();
                if (jNr > 0) {
                    myVar.u(jNr);
                }
                myVar.u(z);
                com.bytedance.sdk.openadsdk.core.rh.s.u(iU, jNr, bcVar, izVar);
                iz izVar2 = izVar;
                JSONObject jSONObjectU = b.u(izVar2, str, iU, izVar2.sx(), bcVar, 0L);
                b.u(jSONObjectU, izVar.pn("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVar, jp.nr(bcVar), jSONObjectU, myVar);
                nrVar.u(izVar.sx() == -1);
                b.nr(nrVar, "play_start");
            }
        });
    }

    public static void u(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.4
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.gi.t.u(bcVarPn) || bg.nr(bcVarPn)) {
                    if (!uVar2.mv()) {
                        b.nr(bcVarPn, izVarB, uVar2);
                    }
                    a aVar = new a();
                    aVar.nr(uVar2.s() ? 1 : 0);
                    aVar.u(uVar2.k() ? 1 : 0);
                    aVar.nr(com.bytedance.sdk.openadsdk.gi.jk.u(bcVarPn.oi()).nr(izVarB));
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - oVar.u();
                    aVar.u(jElapsedRealtime);
                    JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, jElapsedRealtime);
                    b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_START"));
                    com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, aVar);
                    nrVar.u(uVar2.mv());
                    b.nr(nrVar, b.nr(bcVarPn, "feed_play"));
                }
            }
        });
    }

    public static String u(com.bykv.vk.openvk.component.video.api.nr.u uVar) {
        o oVar;
        if (uVar == null || (oVar = u.get(uVar)) == null) {
            return "empty";
        }
        String strNr = oVar.nr();
        return TextUtils.isEmpty(strNr) ? "empty" : strNr;
    }

    public static void u(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2, final int i) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.5
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                if (jB <= 0 || jNr <= 0) {
                    return;
                }
                n nVar = new n();
                nVar.u(uVar2.fx());
                nVar.nr(jB);
                nVar.u(i);
                nVar.u(uVar2.my());
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, nVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    b.nr(nrVar, "feed_pause", jSONObject);
                } catch (JSONException unused) {
                }
            }
        });
    }

    public static void u(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2, final String str, final int i, final boolean z) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.7
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                if (jB < 0) {
                    return;
                }
                k kVar = new k();
                kVar.fx(uVar2.fx());
                kVar.b(jB);
                kVar.fx(uVar2.pn());
                kVar.b(uVar2.iz());
                kVar.nr(i);
                kVar.nr(com.bytedance.sdk.openadsdk.gi.jk.u(bcVarPn.oi()).nr(izVarB));
                kVar.u(str);
                JSONArray jSONArrayU = uVar2.u();
                if (jSONArrayU != null) {
                    kVar.u(jSONArrayU);
                }
                kVar.u(jNr);
                kVar.u(uVar2.a());
                kVar.u(z);
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, izVarB.pn("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, kVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    b.nr(nrVar, "play_error", jSONObject);
                } catch (JSONException unused) {
                }
                fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.u.remove(uVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void u(final com.bykv.vk.openvk.component.video.api.nr.u uVar, final o.u uVar2, final Map<String, Object> map, final int i) {
        fx.u().u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.iz.nr.b.9
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                if (uVar == null || uVar2 == null || (oVar = (o) b.u.get(uVar)) == null) {
                    return;
                }
                iz izVarB = oVar.b();
                bc bcVarPn = oVar.pn();
                if (izVarB == null || bcVarPn == null) {
                    return;
                }
                long jNr = uVar2.nr();
                long jB = uVar2.b();
                if (jB <= 0) {
                    return;
                }
                pn pnVar = new pn();
                pnVar.nr(uVar2.fx());
                pnVar.u(jB);
                pnVar.nr(uVar2.jk());
                pnVar.fx(uVar2.t());
                pnVar.u(i);
                JSONObject jSONObjectU = b.u(izVarB, oVar.nr(), oVar.fx(), izVarB.sx(), bcVarPn, SystemClock.elapsedRealtime() - oVar.u());
                b.u(jSONObjectU, map);
                com.bytedance.sdk.openadsdk.iz.fx.nr nrVar = new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVarPn, jp.nr(bcVarPn), jSONObjectU, pnVar);
                nrVar.u(uVar2.mv());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jNr);
                    jSONObject.put("percent", uVar2.a());
                    com.bytedance.sdk.openadsdk.core.rh.s.u(jNr, bcVarPn, izVarB);
                    b.nr(nrVar, b.nr(bcVarPn, "feed_break"), jSONObject);
                } catch (JSONException unused) {
                }
                b.u.remove(uVar);
            }
        });
    }

    public static void u(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused2) {
            }
        }
    }
}
