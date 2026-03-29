package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ju;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.mh;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.m;
import com.bytedance.sdk.openadsdk.core.y.xw;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kwad.sdk.api.model.AdnName;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bd;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kj implements qq<com.bytedance.sdk.openadsdk.core.s.u> {
    private AtomicLong b = new AtomicLong(0);
    private final Context u;
    private static final AtomicInteger nr = new AtomicInteger(0);
    private static final AtomicInteger fx = new AtomicInteger(0);

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public final ju fx;
        public final boolean nr;
        public final int u;

        private b(int i, boolean z, ju juVar) {
            this.u = i;
            this.nr = z;
            this.fx = juVar;
        }

        public static b u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            ju juVar = new ju();
            if (jSONObjectOptJSONObject != null) {
                try {
                    juVar.u(jSONObjectOptJSONObject.optInt("reason"));
                    juVar.nr(jSONObjectOptJSONObject.optInt("corp_type"));
                    juVar.fx(jSONObjectOptJSONObject.optInt(MediationConstant.REWARD_AMOUNT));
                    juVar.u(jSONObjectOptJSONObject.optString(MediationConstant.REWARD_NAME));
                } catch (Throwable unused) {
                }
            }
            return new b(iOptInt, zOptBoolean, juVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        public final mh fx;
        public final String nr;
        public final int u;

        private fx(int i, String str, mh mhVar) {
            this.u = i;
            this.nr = str;
            this.fx = mhVar;
        }

        public static fx u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            mh mhVar = new mh();
            if (jSONObjectOptJSONObject != null) {
                try {
                    mhVar.u(jSONObjectOptJSONObject.optBoolean("is_open"));
                    mhVar.u(jSONObjectOptJSONObject.optString(ReportItem.RequestKeyRequestId));
                } catch (Throwable unused) {
                }
            }
            return new fx(iOptInt, strOptString, mhVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public final boolean nr;
        public final int u;

        private nr(int i, boolean z) {
            this.u = i;
            this.nr = z;
        }

        public static nr u(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new nr(jSONObject.optInt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE), jSONObject.optBoolean("result"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5294a;
        final int b;
        final long fx;
        final int iz;
        final ArrayList<Integer> jk;
        public final com.bytedance.sdk.openadsdk.core.kj.u n;
        final long nr;
        final String pn;
        final int u;
        final String x;

        private u(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.kj.u uVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.u = i;
            this.b = i2;
            this.pn = str2;
            this.x = str3;
            this.n = uVar;
            this.f5294a = str;
            this.iz = i3;
            this.nr = j;
            this.fx = j2;
            this.jk = arrayList;
        }

        public static u u(JSONObject jSONObject) {
            return u(jSONObject, null, null);
        }

        public static u u(JSONObject jSONObject, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar) {
            Object obj;
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt(ReportItem.RequestKeyStatusCode);
            String strOptString2 = jSONObject.optString(LxAdDLManager.ITEM_DESC);
            String strOptString3 = jSONObject.optString(be.g);
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.kj.u, ArrayList<Integer>> pairU = com.bytedance.sdk.openadsdk.core.u.u(jSONObject, nrVar, oaVar, jOptLong2);
            if (pairU != null && (obj = pairU.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.kj.u) obj).u(jSONObject.optLong("request_after"));
            }
            return pairU == null ? new u(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null) : new u(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.kj.u) pairU.first, jOptLong, jOptLong2, (ArrayList) pairU.second);
        }
    }

    public kj(Context context) {
        this.u = context;
    }

    private boolean fx(String str) {
        if (com.bytedance.sdk.openadsdk.core.my.fx.fx()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.my.fx.nr(str)) {
            return false;
        }
        String strB = com.bytedance.sdk.openadsdk.core.my.fx.b();
        if (!TextUtils.isEmpty(strB)) {
            com.bytedance.sdk.openadsdk.core.qq.s.u(strB, System.currentTimeMillis(), true);
        }
        return true;
    }

    private boolean nr(int i) {
        return i == 3 || i == 4;
    }

    public void b(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, qq.nr nrVar2) {
        nr(nrVar, oaVar, i, nrVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    public void pn(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, qq.nr nrVar2) {
        final com.bytedance.sdk.openadsdk.core.u.u uVar = new com.bytedance.sdk.openadsdk.core.u.u(nrVar2);
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.kj.22
            @Override // java.lang.Runnable
            public void run() {
                kj.this.u(nrVar, oaVar, i, uVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    private boolean b(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        return nrVar != null && nrVar.x() == 320 && nrVar.iz() == 640;
    }

    private boolean nr(String str) {
        if (com.bytedance.sdk.openadsdk.core.my.fx.u()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.my.fx.u(str)) {
            return false;
        }
        String strNr = com.bytedance.sdk.openadsdk.core.my.fx.nr();
        if (!TextUtils.isEmpty(strNr)) {
            com.bytedance.sdk.openadsdk.core.qq.s.u(strNr, System.currentTimeMillis(), false);
        }
        return true;
    }

    private void b(String str) {
        com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
        fxVarFx.u(str);
        fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.18
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void fx(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, qq.nr nrVar2) {
        final com.bytedance.sdk.openadsdk.core.u.u uVar = new com.bytedance.sdk.openadsdk.core.u.u(nrVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.kj.23
                @Override // java.lang.Runnable
                public void run() {
                    kj.this.u(nrVar, oaVar, i, uVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            u(nrVar, oaVar, i, uVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void nr(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, qq.nr nrVar2) {
        final com.bytedance.sdk.openadsdk.core.u.u uVar = new com.bytedance.sdk.openadsdk.core.u.u(nrVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.kj.12
                @Override // java.lang.Runnable
                public void run() {
                    kj.this.u(nrVar, oaVar, i, uVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            u(nrVar, oaVar, i, uVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    private static String fx(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        String strGi = n.o().gi();
        String strIz = n.o().iz();
        n.o().nr((String) null);
        String strC = nrVar != null ? nrVar.c() : null;
        if (TextUtils.isEmpty(strGi)) {
            return u(strC, strIz);
        }
        try {
            if (!TextUtils.isEmpty(strGi) && strGi.contains("game_adapter_did")) {
                strGi = u(new JSONArray(strGi)).toString();
            }
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(strC)) {
            return u(strGi, strIz);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strC);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strIz, "0")) {
                            jSONObject.put(ActionUtils.PAYMENT_AMOUNT, "0");
                            n.o().nr("0");
                        } else {
                            n.o().nr(jSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                        }
                        z = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strGi);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString("name", null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strIz, "0")) {
                                    jSONObject2.put(ActionUtils.PAYMENT_AMOUNT, "0");
                                    n.o().nr("0");
                                } else {
                                    n.o().nr(jSONObject2.optString(ActionUtils.PAYMENT_AMOUNT));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = nr(jSONArray, strIz);
                }
                return u(u(jSONArray), strIz).toString();
            } catch (Throwable unused2) {
                return u(strC, strIz);
            }
        } catch (Throwable unused3) {
            return u(strGi, strIz);
        }
    }

    public JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, boolean z, int i2, boolean z2) {
        return u(nrVar, oaVar, i, z, i2, z2, (String) null);
    }

    private void nr(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, final qq.nr nrVar2, String str, final int i2) {
        final com.bytedance.sdk.openadsdk.core.kj.nr nrVar3 = new com.bytedance.sdk.openadsdk.core.kj.nr();
        nrVar3.u(nrVar);
        try {
            boolean[] zArr = {false};
            if (u(nrVar, nrVar3, nrVar2, i2 == 5, oaVar, i, zArr)) {
                return;
            }
            com.bytedance.sdk.component.a.nr.pn pnVarU = u(nrVar, oaVar, i, nrVar2, str, i2, nrVar3, zArr[0]);
            if (pnVarU == null) {
                nrVar3.u(-15);
                nrVar2.u(-15, x.u(-15), nrVar3);
            } else {
                pnVarU.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.19
                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar4) {
                        kj.this.u(bVar, nrVar4, nrVar3, nrVar2, nrVar, oaVar, i, i2);
                    }

                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                        kj.this.u(bVar, iOException, nrVar3, nrVar2);
                    }
                });
                com.bytedance.sdk.openadsdk.core.b.u().fx();
                u();
            }
        } catch (Throwable th) {
            u(th, nrVar3, nrVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[Catch: all -> 0x03e6, TryCatch #2 {all -> 0x03e6, blocks: (B:4:0x0017, B:6:0x0021, B:14:0x0039, B:16:0x003f, B:19:0x004b, B:20:0x0050, B:21:0x0054, B:25:0x005c, B:27:0x0060, B:29:0x0065, B:31:0x006d, B:60:0x00e8, B:62:0x00f0, B:63:0x00f5, B:65:0x00fc, B:66:0x0101, B:70:0x012b, B:35:0x0082, B:37:0x0086, B:7:0x0026, B:9:0x002c), top: B:169:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, boolean z, int i2, boolean z2, String str) {
        String strNr;
        int i3;
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2;
        String str2;
        String str3;
        int andSet;
        String strU;
        int i4;
        JSONObject jSONObject = new JSONObject();
        if (oaVar != null) {
            try {
                if (!TextUtils.isEmpty(oaVar.nr())) {
                    strNr = oaVar.nr();
                } else {
                    strNr = TextUtils.isEmpty(str) ? jp.n() : str;
                }
                if (nrVar != null && nrVar.q() != null) {
                    int iU = com.bytedance.sdk.openadsdk.core.bc.u.b.u(nrVar.q());
                    if (iU == 1) {
                        jSONObject.put("req_type", 1);
                    } else if (iU != 3) {
                        jSONObject.put("req_type", -1);
                    } else {
                        jSONObject.put("req_type", 3);
                    }
                }
                if (i == 7) {
                    if (oaVar != null && (i4 = oaVar.u) > 0) {
                        jSONObject.put("req_type", i4);
                    }
                    if (oaVar != null && !TextUtils.isEmpty(oaVar.nr)) {
                        jSONObject.put("pre_sessions", oaVar.nr);
                        jSONObject.put("play_again_count", oaVar.fx);
                    }
                } else if (i == 8 && oaVar != null && (i3 = oaVar.u) > 0) {
                    jSONObject.put("req_type", i3);
                }
                try {
                    String strPn = com.bytedance.sdk.openadsdk.core.fx.pn.u().pn();
                    String strIz = com.bytedance.sdk.openadsdk.core.fx.pn.u().iz();
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(strPn)) {
                        jSONObject2.putOpt("version", strPn);
                    }
                    if (nrVar != null) {
                        strU = jp.u(nrVar.o());
                        if (!TextUtils.isEmpty(strU)) {
                            jSONObject2.put("external_ab_vid", strU);
                        }
                    } else {
                        strU = null;
                    }
                    if (!TextUtils.isEmpty(strIz)) {
                        jSONObject2.putOpt(RemoteMessageConst.MessageBody.PARAM, strIz);
                    }
                    if (!TextUtils.isEmpty(strPn) || !TextUtils.isEmpty(strU) || !TextUtils.isEmpty(strIz)) {
                        jSONObject.put("abtest", jSONObject2);
                    }
                } catch (Throwable unused) {
                }
                if (i2 == 5 && (andSet = fx.getAndSet(0)) > 0) {
                    jSONObject.put("throttle_count", andSet);
                }
                jSONObject.put(be.g, strNr);
                if (z2) {
                    jSONObject.put("exemption_req", 1);
                }
                jSONObject.put("ad_sdk_version", d.b);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
                jSONObject.put("is_plugin", d.u());
                jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.b.u.b());
                jSONObject.put("is_use_tt_video", d.b() ? 1 : 2);
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.live.nr nrVarU = com.bytedance.sdk.openadsdk.core.live.nr.u();
                int iFx = nrVarU.fx();
                jSONObject.put("live_sdk_status", iFx);
                jSONObject.put("live_auth_status", nrVarU.pn());
                jSONObject.put("live_sdk_config", nrVarU.n());
                jSONObject.put("live_ad_click_count", nrVarU.iz());
                n.o().mv();
                if (iFx != 2) {
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        jSONObject.put("app_start_time", jElapsedRealtime - Process.getStartElapsedRealtime());
                        jSONObject.put("live_last_init_time", jElapsedRealtime - nrVarU.a());
                    } catch (Throwable unused2) {
                    }
                }
                jSONObject.put("csj_type", n.o().xw() ? 1 : 0);
                jSONObject.put("pma_data", com.bytedance.sdk.openadsdk.core.miniapp.u.u().nr());
                String strX = nrVarU.x();
                if (!TextUtils.isEmpty(strX)) {
                    jSONObject.put("live_plugin_version", strX);
                }
                oaVar.u("liveInfo", System.currentTimeMillis() - jCurrentTimeMillis, i2 == 5);
                jSONObject.put("source_type", "app");
                jSONObject.put("logsdk_version", com.bytedance.sdk.openadsdk.core.fx.b.u().pn(i));
                jSONObject.put("app", com.bytedance.sdk.openadsdk.core.y.t.u(i, i2 == 4 || i2 == 5));
                try {
                    JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.u.u(this.u, i);
                    if (jSONObjectU != null) {
                        if (!dw.nr().uq() && !com.bytedance.sdk.openadsdk.core.l.a.fx()) {
                            jSONObjectU.remove("free_space");
                        }
                        nrVar2 = nrVar;
                        if (nrVar2 != null && nrVar.k() > 0) {
                            jSONObjectU.put(bq.f.V, nrVar.k());
                        }
                        if (gi.fx() > 0) {
                            jSONObjectU.put("screenshot_time", String.valueOf(gi.fx()));
                        }
                        if (com.bytedance.sdk.openadsdk.core.fx.b.u().x(i)) {
                            jSONObjectU.put("wifi_signal", "unknown");
                            jSONObjectU.put("cellular_signal", "unknown");
                        } else {
                            jSONObjectU.put("wifi_signal", com.bytedance.sdk.openadsdk.core.y.t.u(0));
                            jSONObjectU.put("cellular_signal", com.bytedance.sdk.openadsdk.core.y.t.u(1));
                        }
                        if (i2 != 4) {
                            jSONObjectU.put("sof_chara", com.bytedance.sdk.openadsdk.core.y.kj.iz());
                        }
                        com.bytedance.sdk.openadsdk.core.y.s.u(jSONObjectU);
                        jSONObjectU.put("cpu_arch", com.bytedance.sdk.openadsdk.core.y.kj.mv());
                        jSONObjectU.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.bytedance.sdk.openadsdk.core.bf.u.u().iz());
                        jSONObjectU.put("font_size", com.bytedance.sdk.openadsdk.core.k.fx.pn().l());
                        jSONObjectU.put("gpu_model", com.bytedance.sdk.openadsdk.core.k.n.u());
                    } else {
                        nrVar2 = nrVar;
                    }
                    jSONObject.put("device", jSONObjectU);
                    jSONObject.put("pan_code_serial", "1000");
                    jSONObject.put(bd.m, u(nrVar2, i));
                    jSONObject.put("ua", com.bytedance.sdk.openadsdk.core.y.jk.mv());
                    jSONObject.put("channel", d.x);
                    String[] strArrU = com.bytedance.sdk.openadsdk.core.fx.u.u(i);
                    String strConcat = "";
                    if (strArrU == null || strArrU.length < 2) {
                        str2 = "";
                        str3 = str2;
                    } else {
                        str3 = strArrU[0];
                        str2 = strArrU[1];
                    }
                    jSONObject.put("ip", str3);
                    jSONObject.put("client_ipv6", str2);
                    jSONObject.put("client_ipv4", com.bytedance.sdk.openadsdk.core.fx.u.u(str3, i));
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(u(nrVar2, i, oaVar));
                    jSONObject.put("adslots", jSONArray);
                    int i5 = oaVar.mv;
                    if (i5 > 0) {
                        jSONObject.put("load_ad_api", i5);
                    }
                    com.bytedance.sdk.openadsdk.core.fx.u.u(jSONObject, i);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("start2req_time", SystemClock.elapsedRealtime() - bg.pn);
                    jSONObject3.put("start_type", bg.nr.get() ? 0 : 1);
                    jSONObject3.put("show_count", com.bytedance.sdk.openadsdk.core.s.b.u);
                    jSONObject.put("ads_parameter", jSONObject3);
                    u(jSONObject, oaVar);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                    jSONObject.put("ts", jCurrentTimeMillis2);
                    if (nrVar.b() != null && strNr != null) {
                        strConcat = String.valueOf(jCurrentTimeMillis2).concat(nrVar.b()).concat(strNr);
                    }
                    jSONObject.put("req_sign", com.bytedance.sdk.component.utils.x.nr(strConcat));
                    if (i2 == 4) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        jSONObject.putOpt("has_pre_fetch", Boolean.valueOf(dw.nr().u(nrVar.b())));
                        if (dw.nr().nr(nrVar.b())) {
                            u(7 == nrVar.bq(), jSONObject, nrVar.b());
                        } else {
                            com.bytedance.sdk.openadsdk.core.qq.s.u().u(nrVar.b(), (String) null, (String) null, true);
                        }
                        q qVar = oaVar.s;
                        if (qVar != null) {
                            qVar.u("precache_time", System.currentTimeMillis() - jCurrentTimeMillis3);
                        }
                    }
                    if (z) {
                        jSONObject.put("ad_sdk_version", d.b);
                        return jSONObject;
                    }
                    if (i2 == 3) {
                        jSONObject.put("material_keys", jp.u(nrVar));
                    }
                    if (dw.nr().lk()) {
                        jSONObject.put("feature_data", com.bytedance.sdk.openadsdk.core.k.fx.pn().x());
                    }
                    int i6 = oaVar.my;
                    if (i6 > 0) {
                        jSONObject.put("second_page_type", i6);
                        jSONObject.put("second_page_origin_req_id", oaVar.o);
                    }
                } catch (Throwable unused3) {
                }
            } catch (Throwable unused4) {
            }
        }
        return jSONObject;
    }

    private JSONObject nr(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, List<com.bytedance.sdk.openadsdk.my.fx.nr.iz> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", d.b);
            com.bytedance.sdk.openadsdk.k.nr.u(this.u, jSONObject2);
            if (nrVar != null) {
                jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, nrVar.pn());
                if (nrVar.fx() == null) {
                    nrVar.u(AdnName.OTHER);
                }
                jSONObject2.put("dislike_source", nrVar.fx());
            }
            String strU = u(list);
            if (strU != null) {
                jSONObject2.put(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, strU);
                list.clear();
            } else {
                jSONObject2.put(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, (Object) null);
            }
            jSONObject2.put("filter_words", nr(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put(AssistPushConsts.MSG_TYPE_ACTIONS, jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONArray nr(List<com.bytedance.sdk.openadsdk.my.fx.nr.iz> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.my.fx.nr.iz> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().u());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private static String nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        String strFx = fx(nrVar);
        Map<String, Object> mapD = n.o().d();
        if (mapD == null || mapD.isEmpty()) {
            return strFx;
        }
        try {
            JSONArray jSONArray = TextUtils.isEmpty(strFx) ? new JSONArray() : new JSONArray(strFx);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("name") : "";
                if (!TextUtils.isEmpty(strOptString) && mapD.containsKey(strOptString)) {
                    mapD.remove(strOptString);
                }
            }
            for (Map.Entry<String, Object> entry : mapD.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", entry.getKey());
                    jSONObject.put(ActionUtils.PAYMENT_AMOUNT, entry.getValue());
                    jSONArray.put(jSONObject);
                }
            }
            return u(jSONArray).toString();
        } catch (Exception unused) {
            return strFx;
        }
    }

    private static JSONArray nr(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put("name", "is_shake_ads");
                jSONObject.put(ActionUtils.PAYMENT_AMOUNT, "0");
                n.o().nr("0");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(jw jwVar, String str, String str2, final qq.fx fxVar, int i, long j) {
        JSONObject jSONObjectU = u(jwVar, str, str2);
        com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
        if (i == 1) {
            pnVarNr.u(jwVar.x());
        } else {
            pnVarNr.u(jwVar.u());
        }
        pnVarNr.u(jSONObjectU);
        pnVarNr.pn(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kj.11
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                fxVar.u(602, "time out!");
            }
        }, j);
        pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.13
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (nrVar == null) {
                    fxVar.u(603, "response is null!");
                    return;
                }
                if (!nrVar.a()) {
                    fxVar.u(nrVar.nr(), nrVar.fx());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(nrVar.pn());
                    String strOptString = jSONObject.optString("message");
                    int iOptInt = jSONObject.optInt("status", -1);
                    if (iOptInt != 200) {
                        fxVar.u(iOptInt, strOptString);
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject != null) {
                        fxVar.u(jSONObjectOptJSONObject);
                        return;
                    }
                    fxVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, strOptString + ", data is null!");
                } catch (Throwable th) {
                    fxVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                fxVar.u(601, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject, final qq.fx<com.bytedance.sdk.component.a.nr> fxVar) {
        String strU = jp.u("/api/ad/union/sdk/apply_coupon/v2", false);
        xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
        xwVar.u(strU);
        xwVar.fx(jSONObject, "coupon_apply");
        xwVar.pn(new HashMap());
        xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.17
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                qq.fx fxVar2 = fxVar;
                if (fxVar2 != null) {
                    fxVar2.u(nrVar);
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                qq.fx fxVar2 = fxVar;
                if (fxVar2 != null) {
                    fxVar2.u(601, iOException.getMessage());
                }
            }
        });
    }

    private void u(JSONObject jSONObject, oa oaVar) {
        JSONArray jSONArray;
        if (oaVar == null || (jSONArray = oaVar.pn) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private void u(com.bytedance.sdk.openadsdk.core.kj.nr nrVar, long j, long j2, long j3, long j4) {
        if (nrVar == null) {
            return;
        }
        nrVar.u(j);
        nrVar.nr(j3);
        nrVar.fx(j2);
        nrVar.b(j4);
    }

    private boolean u(String str, oa oaVar) {
        float fB = com.bytedance.sdk.openadsdk.core.fx.pn.u().b();
        if (oaVar != null && oaVar.b == 2 && fB > 0.0f) {
            return fx(str);
        }
        return nr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, qq.nr nrVar2) {
        final com.bytedance.sdk.openadsdk.core.u.u uVar = new com.bytedance.sdk.openadsdk.core.u.u(nrVar2);
        uVar.u(i);
        if ((i != 3 || !com.bytedance.sdk.openadsdk.core.component.splash.pn.u(nrVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.jk.x.pn(new com.bytedance.sdk.component.jk.a("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.kj.1
                @Override // java.lang.Runnable
                public void run() {
                    kj.this.b(nrVar, oaVar, i, uVar);
                }
            });
        } else {
            b(nrVar, oaVar, i, uVar);
        }
    }

    public com.bytedance.sdk.openadsdk.core.wq.nr u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2, oa oaVar, int i, int i2, qq.nr nrVar3, boolean z) {
        com.bytedance.sdk.openadsdk.core.wq.nr nrVarNr;
        com.bytedance.sdk.openadsdk.tools.nr.u(nrVar);
        boolean z2 = i2 == 5;
        oaVar.u("buildAdBodyReady", z2);
        JSONObject jSONObjectU = u(nrVar, oaVar, i, false, i2, z);
        oaVar.u("doBuildAdBody", z2);
        if (jSONObjectU == null) {
            nrVar2.u(-9);
            nrVar3.u(-9, x.u(-9), nrVar2);
            return null;
        }
        String string = jSONObjectU.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            nrVarNr = com.bytedance.sdk.openadsdk.core.fx.iz.u().u(string);
            oaVar.u("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        } else {
            nrVarNr = com.bytedance.sdk.openadsdk.core.fx.iz.u().nr(string);
        }
        if (nrVarNr == null) {
            nrVar2.u(-9);
            nrVar3.u(-9, x.u(-9), nrVar2);
            return null;
        }
        nrVarNr.u(jSONObjectU);
        return nrVarNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, qq.nr nrVar2, String str, int i2) {
        nr(nrVar, oaVar, i, nrVar2, str, i2);
    }

    private boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2, qq.nr nrVar3, boolean z, oa oaVar, int i, boolean[] zArr) {
        if (nrVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            nrVar2.u(1000);
            nrVar3.u(1000, "广告请求开关已关闭,请联系穿山甲管理员", nrVar2);
            return true;
        }
        if (z) {
            oaVar.u("execGetAdReady", z);
            if (!TextUtils.isEmpty(nrVar.dw()) && oaVar.b <= 0) {
                u(nrVar2, nrVar, nrVar3, oaVar, i);
                com.bytedance.sdk.openadsdk.core.qq.nr.u();
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (u(nrVar.b(), oaVar)) {
                if (com.bytedance.sdk.openadsdk.core.my.iz.u().nr(nrVar.b())) {
                    zArr[0] = true;
                    return false;
                }
                nrVar2.u(-8);
                nrVar3.u(-8, x.u(-8), nrVar2);
                fx.incrementAndGet();
                com.bytedance.sdk.openadsdk.core.qq.nr.u();
                return true;
            }
            oaVar.u("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z);
        }
        return false;
    }

    private void u(com.bytedance.sdk.openadsdk.core.kj.nr nrVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2, final qq.nr nrVar3, oa oaVar, int i) {
        nrVar.fx(2);
        nrVar.u(nrVar2.dw());
        try {
            boolean z = false;
            JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.iz.u(new JSONObject(nrVar2.dw()), false, true);
            if (jSONObjectU == null) {
                u(nrVar3, nrVar);
                return;
            }
            u uVarU = u.u(jSONObjectU, nrVar2, oaVar);
            nrVar.u(uVarU.jk);
            sx.u(uVarU.f5294a);
            int i2 = uVarU.b;
            if (i2 != 20000) {
                nrVar.u(i2);
                nrVar3.u(uVarU.b, "reason: " + uVarU.iz + "  message: " + uVarU.pn, nrVar);
                return;
            }
            com.bytedance.sdk.openadsdk.core.kj.u uVar = uVarU.n;
            if (uVar == null) {
                u(nrVar3, nrVar);
                return;
            }
            uVar.u(jSONObjectU);
            List<bc> listNr = uVarU.n.nr();
            if (listNr != null) {
                List<bc> arrayList = new ArrayList<>(listNr);
                for (bc bcVar : listNr) {
                    bc bcVarU = com.bytedance.sdk.openadsdk.core.y.pn.u(bcVar.m(), i);
                    if (bcVarU != null) {
                        arrayList.remove(bcVar);
                        bcVarU.rh(bcVar.ir());
                        arrayList.add(bcVarU);
                    } else if (bcVar.jp()) {
                        final String str = uVarU.x;
                        if (!TextUtils.isEmpty(str) && oaVar != null) {
                            oaVar.u(str);
                        }
                        final String strB = nrVar2.b();
                        final String strU = jp.u(nrVar2);
                        dw.u().fx(nrVar2, oaVar, i, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.kj.20
                            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                            public void u(int i3, String str2, com.bytedance.sdk.openadsdk.core.kj.nr nrVar4) {
                                com.bytedance.sdk.openadsdk.core.qq.s.u().u(i3, str2, str, strB, strU);
                                nrVar3.u(i3, str2, nrVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar2, com.bytedance.sdk.openadsdk.core.kj.nr nrVar4) {
                                com.bytedance.sdk.openadsdk.core.qq.s.u().u(0, "success", str, strB, strU);
                                nrVar3.u(uVar2, nrVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    uVarU.n.u(arrayList);
                }
            }
            nrVar3.u(uVarU.n, nrVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("NetApiImpl", "get ad error: ", th);
            u(nrVar3, nrVar);
        }
    }

    private com.bytedance.sdk.component.a.nr.pn u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, qq.nr nrVar2, String str, int i2, com.bytedance.sdk.openadsdk.core.kj.nr nrVar3, boolean z) throws JSONException {
        byte[] bytes;
        Map<String, String> mapU;
        com.bytedance.sdk.openadsdk.core.wq.nr nrVarU = u(nrVar, nrVar3, oaVar, i, i2, nrVar2, z);
        if (nrVarU == null) {
            return null;
        }
        String strU = jp.u(str, true);
        com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
        String strU2 = com.bytedance.sdk.openadsdk.x.fx.u(pnVarNr, strU);
        pnVarNr.u(strU2);
        if (nrVarU.u() != null) {
            com.bytedance.sdk.openadsdk.x.fx.u(nrVarU.u(), 0);
        }
        if (i2 == 5) {
            if (nrVarU.b() != null) {
                JSONObject jSONObjectB = nrVarU.b();
                pnVarNr.u(jSONObjectB);
                bytes = jSONObjectB.toString().getBytes(StandardCharsets.UTF_8);
                pnVarNr.u(false);
            } else {
                if (nrVarU.fx() == null) {
                    return null;
                }
                bytes = nrVarU.fx();
                pnVarNr.u("application/octet-stream", bytes);
                pnVarNr.u(true);
            }
        } else {
            JSONObject jSONObjectB2 = nrVarU.b();
            pnVarNr.u(jSONObjectB2);
            bytes = jSONObjectB2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z2 = i2 == 5;
        oaVar.u("doHttpReqSignReady", z2);
        com.bytedance.sdk.openadsdk.u.u.u uVarU = com.bytedance.sdk.openadsdk.u.u.u.u(true);
        oaVar.u("MSInst", z2);
        Map<String, String> mapU2 = uVarU.u(strU2, bytes);
        oaVar.u("doHttpReqSign", z2);
        if (mapU2 == null) {
            mapU2 = new HashMap<>();
        }
        if (i2 == 5 && (mapU = com.bytedance.sdk.openadsdk.tools.nr.u(nrVar.b())) != null) {
            mapU2.putAll(mapU);
        }
        m.u(mapU2);
        Map<String, String> mapPn = nrVarU.pn();
        pnVarNr.nr("User-Agent", com.bytedance.sdk.openadsdk.core.y.jk.mv());
        if (mapPn != null) {
            mapU2.putAll(mapPn);
        }
        if (mapU2.size() > 0) {
            for (Map.Entry<String, String> entry : mapU2.entrySet()) {
                pnVarNr.nr(entry.getKey(), entry.getValue());
            }
        }
        pnVarNr.pn(u(bytes, mapPn, nrVarU));
        oaVar.u("appendHeader", z2);
        return pnVarNr;
    }

    private Map<String, Object> u(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.wq.nr nrVar) {
        HashMap map2 = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.wq.u uVar = new com.bytedance.sdk.openadsdk.core.wq.u();
            uVar.n(System.currentTimeMillis());
            uVar.a(bArr == null ? 0L : bArr.length);
            uVar.fx(nrVar.nr());
            if (map != null) {
                uVar.u(map.get("x-pglcypher"));
            }
            uVar.u(nrVar.u());
            com.bytedance.sdk.component.b.u uVarNr = com.bytedance.sdk.openadsdk.core.y.kj.nr();
            uVar.nr(uVarNr != null ? uVarNr.getSpecificArmorLoadStatus() : 0);
            uVar.u(dw.nr().gl());
            map2.put("load_time_model", uVar);
        } catch (Exception unused) {
        }
        return map2;
    }

    private void u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.b.get() >= 30000) {
            this.b.set(jCurrentTimeMillis);
            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kj.21
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pb.n.u((com.bytedance.sdk.openadsdk.core.pb.pn) null).fx();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException, com.bytedance.sdk.openadsdk.core.kj.nr nrVar, qq.nr nrVar2) {
        com.bytedance.sdk.openadsdk.core.qq.nr.u();
        if (iOException != null) {
            nrVar.u(602);
            nrVar2.u(602, iOException.getMessage(), nrVar);
        }
    }

    private void u(Throwable th, com.bytedance.sdk.openadsdk.core.kj.nr nrVar, qq.nr nrVar2) {
        if (nrVar2 != null) {
            nrVar.u(4000);
            nrVar2.u(4000, th.getMessage(), nrVar);
            com.bytedance.sdk.component.utils.k.u("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void u(com.bytedance.sdk.component.a.nr nrVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2, int i, oa oaVar, qq.nr nrVar3, com.bytedance.sdk.openadsdk.core.kj.nr nrVar4, com.bytedance.sdk.component.a.nr.b bVar) {
        u uVar;
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        oa oaVar2 = oaVar;
        com.bytedance.sdk.openadsdk.core.kj.nr nrVar5 = nrVar4;
        if (nrVar == null) {
            return;
        }
        if (nrVar.a()) {
            try {
                com.bytedance.sdk.openadsdk.core.wq.u uVarU = u(bVar);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strPn = nrVar.pn();
                nrVar5.u(strPn);
                LogAdapter logAdapter = LogAdapter.u;
                if (logAdapter != null) {
                    logAdapter.fx("NetApiImpl", "response:");
                    LogAdapter.u.fx("NetApiImpl", strPn);
                }
                JSONObject jSONObject3 = new JSONObject(strPn);
                int iOptInt = jSONObject3.optInt(ReportItem.RequestKeyStatusCode);
                String strOptString = new JSONObject(nrVar2.dw()).optString("auction_price");
                int i2 = 20000;
                try {
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            nrVar5.u(iOptInt);
                            nrVar3.u(40046, x.u(iOptInt), nrVar5);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject4.put("auction_price", strOptString);
                        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.iz.u(jSONObject4, false, true);
                        if (jSONObjectU == null) {
                            u(nrVar3, nrVar4);
                            return;
                        }
                        u uVarU2 = u.u(jSONObjectU, nrVar2, oaVar2);
                        nrVar5.u(uVarU2.jk);
                        int i3 = uVarU2.b;
                        if (i3 != i2) {
                            nrVar5.u(i3);
                            nrVar3.u(uVarU2.b, "reason: " + uVarU2.iz + "  message: " + uVarU2.pn, nrVar5);
                            com.bytedance.sdk.openadsdk.core.my.iz.u().u(nrVar2.b(), uVarU2.b, uVarU2.iz);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.kj.u uVar2 = uVarU2.n;
                        if (uVar2 == null) {
                            u(nrVar3, nrVar4);
                            return;
                        }
                        uVar2.u(jSONObjectU);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (oaVar2 != null) {
                            try {
                                uVar = uVarU2;
                                str = strOptString;
                                jSONObject = jSONObjectOptJSONObject;
                                jSONObject2 = jSONObjectU;
                                u(nrVar4, uVarU.a() - oaVar2.x, uVarU2.u, jCurrentTimeMillis - uVarU.a(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                            } catch (Throwable th) {
                                th = th;
                                com.bytedance.sdk.component.utils.k.u("NetApiImpl", "get ad error: ", th);
                                u(nrVar3, nrVar4);
                                return;
                            }
                        } else {
                            uVar = uVarU2;
                            jSONObject = jSONObjectOptJSONObject;
                            jSONObject2 = jSONObjectU;
                            str = strOptString;
                        }
                        nrVar3.u(uVar.n, nrVar4);
                        com.bytedance.sdk.openadsdk.nr.nr.u().u(jSONObject2);
                        jSONObjectOptJSONObject = jSONObject;
                        oaVar2 = oaVar;
                        nrVar5 = nrVar4;
                        strOptString = str;
                        i2 = 20000;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            int iNr = nrVar.nr();
            String strFx = nrVar.fx();
            nrVar5.u(iNr);
            nrVar3.u(iNr, strFx, nrVar5);
        }
    }

    private void u(com.bytedance.sdk.component.a.nr nrVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2, int i, oa oaVar, qq.nr nrVar3, com.bytedance.sdk.openadsdk.core.kj.nr nrVar4) {
        if (nrVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(nrVar.pn()).optJSONArray("ads");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    if (nrVar3 != null) {
                        nrVar3.u(-9, x.u(-9), nrVar4);
                        return;
                    }
                    return;
                }
                int iY = dw.nr().y();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i2).optJSONObject(ClickAreaSource.CREATIVE);
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.iz.u(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                        if (jSONObjectU == null && nrVar3 != null) {
                            nrVar3.u(-9, x.u(-9), nrVar4);
                        } else {
                            u uVarU = u.u(jSONObjectU, nrVar2, oaVar);
                            com.bytedance.sdk.openadsdk.core.y.pn.u(uVarU.n, i, iY);
                            if (nrVar3 != null) {
                                nrVar3.u(uVarU.n, nrVar4);
                            }
                        }
                    } else if (nrVar3 != null) {
                        nrVar3.u(-9, x.u(-9), nrVar4);
                    }
                }
            } catch (Exception unused) {
                if (nrVar3 != null) {
                    nrVar3.u(-9, x.u(-9), nrVar4);
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.wq.u u(com.bytedance.sdk.component.a.nr.b bVar) {
        try {
            Object obj = bVar.fx().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.wq.u) {
                com.bytedance.sdk.openadsdk.core.wq.u uVar = (com.bytedance.sdk.openadsdk.core.wq.u) obj;
                uVar.fx(true);
                return uVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.wq.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2, qq.nr nrVar3, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar4, oa oaVar, int i, int i2) {
        String str;
        long length;
        JSONObject jSONObjectU;
        com.bytedance.sdk.openadsdk.core.wq.u uVar;
        final boolean zBooleanValue;
        u uVar2;
        JSONObject jSONObject;
        com.bytedance.sdk.openadsdk.core.wq.u uVar3;
        int i3;
        long length2;
        com.bytedance.sdk.openadsdk.core.wq.u uVar4;
        if (nrVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!nrVar.a()) {
            int iNr = nrVar.nr();
            String strFx = nrVar.fx();
            nrVar2.u(iNr);
            nrVar3.u(iNr, strFx, nrVar2);
            com.bytedance.sdk.openadsdk.core.my.iz.u().u(nrVar4 != null ? nrVar4.b() : "", iNr, 0);
            com.bytedance.sdk.openadsdk.core.iz.nr.nr();
            return;
        }
        if (i2 == 1) {
            u(nrVar, nrVar4, i, oaVar, nrVar3, nrVar2);
            return;
        }
        if (i2 == 3) {
            u(nrVar, nrVar4, i, oaVar, nrVar3, nrVar2, bVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.wq.u uVarU = u(bVar);
        uVarU.iz(jCurrentTimeMillis);
        com.bytedance.sdk.openadsdk.core.qq.nr.u();
        try {
            final String strPn = nrVar.pn();
            if (i2 == 5) {
                byte[] bArrT = nrVar.t();
                Pair<Boolean, JSONObject> pairU = com.bytedance.sdk.openadsdk.core.fx.iz.u(nrVar, "get_ads", true);
                final JSONObject jSONObject2 = (JSONObject) pairU.second;
                zBooleanValue = ((Boolean) pairU.first).booleanValue();
                if (zBooleanValue) {
                    length2 = TextUtils.isEmpty(strPn) ? 0L : strPn.getBytes(StandardCharsets.UTF_8).length;
                    nrVar2.u(strPn);
                } else {
                    length2 = bArrT == null ? 0L : bArrT.length;
                }
                long j = length2;
                if (LogAdapter.u == null || jSONObject2 == null) {
                    uVar4 = uVarU;
                } else {
                    uVar4 = uVarU;
                    com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("logAdapter") { // from class: com.bytedance.sdk.openadsdk.core.kj.24
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj;
                            try {
                                String string = "";
                                if (zBooleanValue) {
                                    string = strPn;
                                } else {
                                    Pair<Integer, JSONObject> pairU2 = com.bytedance.sdk.openadsdk.core.fx.iz.u().u(jSONObject2.toString(), false);
                                    if (pairU2 != null && (obj = pairU2.second) != null) {
                                        string = ((JSONObject) obj).toString();
                                    }
                                }
                                if (LogAdapter.u == null || TextUtils.isEmpty(string)) {
                                    return;
                                }
                                LogAdapter.u.fx("NetApiImpl", "response:");
                                LogAdapter.u.fx("NetApiImpl", string);
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.k.u(e.getMessage());
                            }
                        }
                    });
                }
                length = j;
                jSONObjectU = jSONObject2;
                uVar = uVar4;
            } else {
                nrVar2.u(strPn);
                LogAdapter logAdapter = LogAdapter.u;
                if (logAdapter != null) {
                    logAdapter.fx("NetApiImpl", "response:");
                    LogAdapter.u.fx("NetApiImpl", strPn);
                }
                JSONObject jSONObject3 = new JSONObject(strPn);
                length = TextUtils.isEmpty(strPn) ? 0L : strPn.getBytes(StandardCharsets.UTF_8).length;
                jSONObjectU = com.bytedance.sdk.openadsdk.core.fx.iz.u(jSONObject3, false, true);
                uVar = uVarU;
                zBooleanValue = false;
            }
            uVar.x(length);
            if (jSONObjectU == null) {
                u(nrVar3, nrVar2);
                return;
            }
            com.bytedance.sdk.openadsdk.x.fx.nr(jSONObjectU, 0);
            u uVarU2 = u.u(jSONObjectU, nrVar4, oaVar);
            nrVar2.u(uVarU2.jk);
            sx.u(uVarU2.f5294a);
            int i4 = uVarU2.b;
            if (i4 != 20000) {
                nrVar2.u(i4);
                nrVar2.nr(uVarU2.iz);
                nrVar3.u(uVarU2.b, "reason: " + uVarU2.iz + "  message: " + uVarU2.pn, nrVar2);
                com.bytedance.sdk.openadsdk.core.my.iz.u().u(nrVar4 != null ? nrVar4.b() : "", uVarU2.b, uVarU2.iz);
                return;
            }
            com.bytedance.sdk.openadsdk.core.kj.u uVar5 = uVarU2.n;
            if (uVar5 == null) {
                u(nrVar3, nrVar2);
                return;
            }
            uVar5.u(jSONObjectU);
            uVar.nr(System.currentTimeMillis());
            if (oaVar != null) {
                uVar2 = uVarU2;
                uVar3 = uVar;
                jSONObject = jSONObjectU;
                str = "NetApiImpl";
                i3 = 0;
                try {
                    u(nrVar2, uVar.a() - oaVar.x, uVarU2.u, uVar.iz() - uVar.a(), uVar.nr() - uVar.iz());
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.k.u(str, "get ad error: ", th);
                    u(nrVar3, nrVar2);
                    return;
                }
            } else {
                uVar2 = uVarU2;
                jSONObject = jSONObjectU;
                uVar3 = uVar;
                str = "NetApiImpl";
                i3 = 0;
            }
            nrVar3.u(uVar2.n, nrVar2);
            for (bc bcVar : uVar2.n.nr()) {
                if (oaVar != null) {
                    bcVar.gi(oaVar.nr());
                    bcVar.pm().u(oaVar.u);
                    bcVar.pm().nr(1);
                }
                if (com.bytedance.sdk.openadsdk.pn.u.u(bcVar)) {
                    com.bytedance.sdk.openadsdk.upie.nr.u().u(this.u, com.bytedance.sdk.openadsdk.pn.u.a(bcVar));
                }
            }
            if (uVar3.l() && uVar2.n.nr() != null && !uVar2.n.nr().isEmpty()) {
                bc bcVar2 = uVar2.n.nr().get(i3);
                com.bytedance.sdk.openadsdk.core.b.u().u(bcVar2);
                String strNr = jp.nr(i);
                com.bytedance.sdk.openadsdk.core.wq.u uVar6 = uVar3;
                uVar6.nr(i2 != 5);
                uVar6.u(i2 != 5 || zBooleanValue);
                uVar6.pn(nrVar.iz());
                uVar6.b(nrVar.x());
                uVar6.u(uVar2.u);
                com.bytedance.sdk.component.nr.u.t tVarL = nrVar.l();
                if (tVarL != null) {
                    uVar6.jk(tVarL.u);
                    uVar6.t(tVarL.nr);
                    uVar6.l(tVarL.fx);
                    uVar6.mv(tVarL.b);
                    uVar6.s(tVarL.pn);
                }
                u(oaVar, bcVar2, strNr, uVar6);
            }
            com.bytedance.sdk.openadsdk.nr.nr.u().u(jSONObject);
            com.bytedance.sdk.openadsdk.core.iz.nr.nr();
        } catch (Throwable th2) {
            th = th2;
            str = "NetApiImpl";
        }
    }

    private void u(oa oaVar, bc bcVar, String str, com.bytedance.sdk.openadsdk.core.wq.u uVar) {
        long jNr;
        long j;
        if (dw.nr().ju() && uVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (oaVar != null) {
                try {
                    if (oaVar.x > 0) {
                        jSONObject.put("client_start_time", uVar.a() - oaVar.x);
                        jNr = uVar.nr() - oaVar.x;
                    } else {
                        jNr = 0;
                    }
                    if (oaVar.n > 0) {
                        jSONObject.put("real_user_duration", uVar.nr() - oaVar.n);
                        jSONObject.put("switch_st1_time", oaVar.x - oaVar.n);
                    }
                    j = jNr;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j = 0;
            }
            jSONObject.put("net_send_time", uVar.pn() - uVar.a());
            jSONObject.put("net_rcv_time", uVar.b() - uVar.pn());
            jSONObject.put("net_callback_time", uVar.iz() - uVar.b());
            jSONObject.put("network_time", uVar.iz() - uVar.a());
            jSONObject.put("sever_time", uVar.u());
            jSONObject.put("client_end_time", uVar.nr() - uVar.iz());
            if (uVar.jk() > 0) {
                jSONObject.put("req_body_length", uVar.jk());
            }
            if (uVar.n() > 0) {
                jSONObject.put("res_body_length", uVar.n());
            }
            if (!TextUtils.isEmpty(uVar.t())) {
                jSONObject.put("x-pglcypher", uVar.t());
            }
            jSONObject.put("cypher_v", uVar.sx());
            jSONObject.put("armor_s", uVar.bg());
            long jFx = uVar.fx();
            if (jFx > 0) {
                jSONObject.put("raw_req_length", jFx);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.fx.fx.u().iz());
            if (!uVar.x()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.fx.fx.u().x());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.b.u.b());
            jSONObject.put("opt_config", String.valueOf(dw.nr().jc()));
            jSONObject.put("report_index", nr.getAndIncrement());
            if (uVar.my() > 0) {
                jSONObject.put("net_whqueue", uVar.s() - uVar.mv());
                jSONObject.put("net_wtqueue", uVar.k() - uVar.s());
                jSONObject.put("net_oconn", uVar.o() - uVar.my());
                jSONObject.put("net_bconn", uVar.my() - uVar.k());
            }
            try {
                JSONObject jSONObjectU = oaVar.s.u(-1L);
                Iterator<String> itKeys = jSONObjectU.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectU.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, str, "load_ad_time", j, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, List<com.bytedance.sdk.openadsdk.my.fx.nr.iz> list) {
        JSONObject jSONObjectNr;
        if (com.bytedance.sdk.openadsdk.core.pb.a.u() && (jSONObjectNr = nr(nrVar, list)) != null) {
            xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
            xwVar.u(jp.n("/api/ad/union/dislike_event/"));
            xwVar.fx(jSONObjectNr, "dislike");
            xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.25
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar2) {
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                }
            });
        }
    }

    private String u(List<com.bytedance.sdk.openadsdk.my.fx.nr.iz> list) {
        if (list.get(0).u().equals("0:00")) {
            return list.get(0).nr();
        }
        return null;
    }

    public static void u(qq.nr nrVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
        nrVar2.u(-1);
        nrVar.u(-1, x.u(-1), nrVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(qq.pn pnVar) {
        pnVar.u(-1, x.u(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(qq.b bVar) {
        bVar.u(-1, x.u(-1));
    }

    private JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            u(jSONObject, "keywords", n.o().kj());
            jSONObject.put("protection_of_minors", n.o().w());
            if (!com.bytedance.sdk.openadsdk.core.fx.b.u().x(i)) {
                com.bytedance.sdk.openadsdk.k.nr.b(this.u, jSONObject);
            }
            String strNr = nr(nrVar);
            String strU = com.bytedance.sdk.openadsdk.core.fx.b.u().u(nrVar.b(), "");
            if (!TextUtils.isEmpty(strU)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("name", "dynamic_slot_ab_extra");
                jSONObject2.putOpt(ActionUtils.PAYMENT_AMOUNT, strU);
                if (TextUtils.isEmpty(strNr)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(strNr);
                }
                jSONArray.put(jSONObject2);
                String string = jSONArray.toString();
                if (!TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, string)) {
                    u(jSONObject, "data", string);
                }
            } else if (!TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, strNr)) {
                u(jSONObject, "data", strNr);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray u(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("name", "can_use_sensor");
                jSONObject.put(ActionUtils.PAYMENT_AMOUNT, str);
            } catch (Exception unused) {
                return jSONArray;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return jSONArray;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONArray.put(jSONArray.length(), jSONObject);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(0, jSONObject);
        return jSONArray2;
    }

    private static String u(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayNr = nr(u((JSONArray) null, str2), str2);
            if (jSONArrayNr == null) {
                return null;
            }
            return jSONArrayNr.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString("name"), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put(ActionUtils.PAYMENT_AMOUNT, "0");
                        n.o().nr("0");
                    } else {
                        n.o().nr(jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                    }
                    z = true;
                }
            }
            if (!z) {
                jSONArray = nr(jSONArray, str2);
            }
            JSONArray jSONArrayU = u(jSONArray, str2);
            return jSONArrayU == null ? str : jSONArrayU.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static JSONArray u(JSONArray jSONArray) throws JSONException {
        if (d.x() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString("name", null);
                    if (!"device_id".equals(strOptString)) {
                        if ("game_adapter_did".equals(strOptString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put("name", "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void u(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i, oa oaVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nrVar.b());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, nrVar.bg());
            jSONObject.put("show_seq", nrVar.sx());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", n.o().ay());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.bytedance.sdk.openadsdk.core.k.fx.pn().u(nrVar.b()));
            if (!TextUtils.isEmpty(nrVar.u()) || !TextUtils.isEmpty(nrVar.nr()) || !TextUtils.isEmpty(nrVar.fx()) || com.bytedance.sdk.openadsdk.tools.nr.u()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(nrVar.u())) {
                    jSONObject2.put(MediationConstant.EXTRA_ADID, nrVar.u());
                }
                if (!TextUtils.isEmpty(nrVar.nr())) {
                    jSONObject2.put("creative_id", nrVar.nr());
                }
                if (nrVar.fx() != null) {
                    jSONObject2.put("ext", nrVar.fx());
                }
                com.bytedance.sdk.openadsdk.tools.nr.u(jSONObject2, nrVar.b());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (com.bytedance.sdk.openadsdk.tools.nr.u() && n.o().kw()) {
                com.bytedance.sdk.openadsdk.tools.nr.nr(jSONObject, nrVar.b());
            }
            n.b bVarJu = n.o().ju();
            if (bVarJu != null && jp.a().equals("com.pangolin_demo.toutiao")) {
                bVarJu.u(jSONObject);
            }
            int iL = 1;
            if (i == 3 || i == 4) {
                if (oaVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", oaVar.f5318a);
                    jSONObject3.put("time_out_control", oaVar.jk);
                    jSONObject3.put("time_out", oaVar.t);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (oaVar != null) {
                jSONObject.put("render_method", oaVar.iz);
                int i2 = oaVar.iz;
                if (i2 == 1) {
                    if (b(nrVar)) {
                        u(i, jSONObject);
                    } else {
                        u(jSONObject, "accepted_size", nrVar.iz(), nrVar.x());
                    }
                } else if (i2 == 2) {
                    if (nrVar.n() > 0.0f && nrVar.a() > 0.0f) {
                        u(jSONObject, "accepted_size", y.fx(this.u, nrVar.n()), y.fx(this.u, nrVar.a()));
                    } else if (b(nrVar)) {
                        u(i, jSONObject);
                    } else {
                        u(jSONObject, "accepted_size", nrVar.iz(), nrVar.x());
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                u(jSONObject, "accepted_size", nrVar.iz(), nrVar.x());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.fx.nr.u().u(nrVar.b(), i));
            jSONObject.put("ptpl_ids_v3", com.bytedance.sdk.openadsdk.core.fx.nr.u().nr(nrVar.b(), i));
            jSONObject.put("pos", jp.pn(i));
            jSONObject.put("is_support_dpl", nrVar.jk());
            jSONObject.put("if_support_render_control", nrVar.t() ? 1 : 0);
            jSONObject.put("support_icon_style", (d.fx < 5900 || !nrVar.z()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", dw.nr().n(jp.nr(nrVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (oaVar != null && (obj = oaVar.l) != null) {
                jSONObject.put("session_params", obj);
            }
            int iL2 = nrVar.l();
            if (i == 7) {
                if (com.bytedance.sdk.openadsdk.core.kj.ja.u()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.kj.ja.pn());
                }
                if (com.bytedance.sdk.openadsdk.core.kj.ja.fx()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.kj.ja.x());
                }
                if (com.bytedance.sdk.openadsdk.core.kj.ja.b()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.kj.ja.x());
                }
                iL2 = 1;
            }
            if (i == 8) {
                boolean zK = dw.nr().k(nrVar.b());
                boolean zU = com.bytedance.sdk.openadsdk.core.my.b.u(nrVar.b());
                if (!zK) {
                    jSONObject.put("refresh_control", 0);
                } else if (zU) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.2
                        @Override // com.bytedance.sdk.openadsdk.t.u.u
                        public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("cid", "");
                            } catch (JSONException unused) {
                            }
                            return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("refresh_max").nr(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", dw.nr().jn());
                }
                if (com.bytedance.sdk.openadsdk.core.kj.ja.nr()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.kj.ja.iz());
                }
            } else {
                iL = iL2;
            }
            if (oaVar != null && oaVar.pn != null) {
                iL = nrVar.l();
            }
            jSONObject.put("ad_count", iL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void u(int i, JSONObject jSONObject) {
        if (nr(i)) {
            u(jSONObject, "accepted_size", y.b(this.u), y.pn(this.u));
        } else {
            u(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private void u(JSONObject jSONObject, String str, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i > 0 && i2 > 0) {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
            } else {
                jSONObject2.put("width", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                jSONObject2.put("height", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void u(JSONObject jSONObject, String str, float f, float f2) {
        if (f <= 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f);
            jSONObject2.put("height", (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(JSONObject jSONObject, final qq.pn pnVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            if (pnVar != null) {
                pnVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || pnVar == null) {
                return;
            }
            xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
            xwVar.u(jp.n("/api/ad/union/sdk/reward_video/reward/"));
            xwVar.fx(jSONObject, "verify");
            xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.3
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar != null) {
                        if (!nrVar.a()) {
                            String strU = x.u(-2);
                            int iNr = nrVar.nr();
                            if (!nrVar.a() && !TextUtils.isEmpty(nrVar.fx())) {
                                strU = nrVar.fx();
                            }
                            pnVar.u(iNr, strU);
                            return;
                        }
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.fx.iz.u(nrVar, "verify", false).second;
                            b bVarU = b.u(obj != null ? (JSONObject) obj : new JSONObject(nrVar.pn()));
                            int i = bVarU.u;
                            if (i != 20000) {
                                pnVar.u(i, x.u(i));
                                return;
                            } else if (bVarU.fx == null) {
                                kj.this.u(pnVar);
                                return;
                            } else {
                                pnVar.u(bVarU);
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    kj.this.u(pnVar);
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    pnVar.u(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(JSONObject jSONObject, final qq.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            if (bVar != null) {
                bVar.u(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || bVar == null) {
                return;
            }
            JSONObject jSONObjectU = com.bytedance.sdk.component.utils.u.u(jSONObject);
            com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
            pnVarNr.u(jp.n("/api/ad/union/sdk/reward_video/live_room/reward"));
            pnVarNr.fx(jSONObjectU.toString());
            pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.4
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar2, com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar != null) {
                        if (!nrVar.a() || TextUtils.isEmpty(nrVar.pn())) {
                            String strU = x.u(-2);
                            int iNr = nrVar.nr();
                            if (!nrVar.a() && !TextUtils.isEmpty(nrVar.fx())) {
                                strU = nrVar.fx();
                            }
                            bVar.u(iNr, strU);
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(nrVar.pn());
                            String strFx = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.u.fx(jSONObject2.optString("message")) : null;
                            if (!TextUtils.isEmpty(strFx)) {
                                try {
                                    jSONObject2 = new JSONObject(strFx);
                                } catch (Throwable unused) {
                                }
                            }
                            fx fxVarU = fx.u(jSONObject2);
                            int i = fxVarU.u;
                            if (i != 20000) {
                                bVar.u(i, x.u(i));
                                return;
                            } else if (fxVarU.fx == null) {
                                kj.this.u(bVar);
                                return;
                            } else {
                                bVar.u(fxVarU);
                                return;
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    kj.this.u(bVar);
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar2, IOException iOException) {
                    bVar.u(-2, iOException.getMessage());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[PHI: r1
      0x00d0: PHI (r1v9 java.lang.String) = (r1v8 java.lang.String), (r1v11 java.lang.String) binds: [B:31:0x00b7, B:36:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.qq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z, int i) {
        int iBq;
        String strOptString;
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        oa oaVar = new oa();
        String strNr = oaVar.nr();
        u(nrVar, strNr);
        q qVar = oaVar.s;
        if (3 == nrVar.bq()) {
            oaVar.x = System.currentTimeMillis();
        }
        if (z) {
            oaVar.iz = 2;
        }
        if (1 == nrVar.my() || 2 == nrVar.my()) {
            oaVar.iz = 2;
        }
        if (oaVar.iz != 2 && dw.nr().a(nrVar.b())) {
            oaVar.iz = 2;
        }
        if (nrVar.bq() > 0) {
            iBq = nrVar.bq();
        } else {
            iBq = i > 0 ? i : 0;
        }
        JSONObject jSONObjectU = u(nrVar, oaVar, iBq, true, 4, false, strNr);
        qVar.nr("adbody_time");
        u(nrVar, oaVar, iBq);
        qVar.nr("prefetch_time");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("User-Agent", com.bytedance.sdk.openadsdk.core.y.jk.mv());
            qVar.nr("request_headers_time");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("bid_request", jSONObjectU);
        } catch (Exception unused) {
        }
        Pair<Integer, JSONObject> pairU = com.bytedance.sdk.openadsdk.core.fx.iz.u().u(jSONObject.toString(), true);
        qVar.nr("encry_time");
        try {
            com.bytedance.sdk.openadsdk.core.qq.s.u().u(i, qVar);
        } catch (Throwable unused2) {
        }
        strOptString = "";
        if (pairU == null) {
            iIntValue = 3;
        } else {
            Object obj = pairU.second;
            strOptString = obj != null ? ((JSONObject) obj).optString("message") : "";
            Object obj2 = pairU.first;
            if (obj2 != null) {
                iIntValue = ((Integer) obj2).intValue();
            }
        }
        if (iIntValue != 3) {
            return "0000000004" + strOptString;
        }
        return "0000000003" + strOptString;
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        String string = UUID.randomUUID().toString();
        com.bytedance.sdk.openadsdk.core.q.u.u uVar = (com.bytedance.sdk.openadsdk.core.q.u.u) com.bytedance.sdk.openadsdk.core.q.b.u(0);
        uVar.fx(string);
        uVar.u(string, new com.bytedance.sdk.openadsdk.core.d.u.u());
        uVar.u(str, string);
        uVar.u(string, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.5
            @Override // com.bytedance.sdk.openadsdk.core.q.fx.u
            public void u(com.bytedance.sdk.openadsdk.core.q.u uVar2) {
                if (uVar2 instanceof com.bytedance.sdk.openadsdk.core.component.u) {
                    ((com.bytedance.sdk.openadsdk.core.component.u) uVar2).u = nrVar;
                }
            }
        });
        uVar.u(string, com.bytedance.sdk.openadsdk.core.q.b.u.START);
    }

    private boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i) {
        boolean zU = dw.nr().u(nrVar.b());
        if (zU) {
            pn(nrVar, oaVar, i, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.kj.6
                @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                public void u(int i2, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                    com.bytedance.sdk.openadsdk.core.qq.s.u().u(i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                    com.bytedance.sdk.openadsdk.core.qq.s.u().u(0);
                }
            });
        }
        return zU;
    }

    private void u(boolean z, JSONObject jSONObject, String str) throws Exception {
        String strU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().u(z, str);
        String strOptString = "0";
        String str2 = null;
        if (strU != null && !TextUtils.isEmpty(strU)) {
            if (TextUtils.equals(strU, "0")) {
                str2 = "0";
            } else if (TextUtils.equals(strU, "1")) {
                str2 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(strU);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString(ReportItem.RequestKeyRequestId);
            }
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(str, strOptString, str2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public String u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        return u(nrVar, false, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(String str, String str2, final qq.u uVar) {
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            if (uVar != null) {
                uVar.u(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || uVar == null) {
            return;
        }
        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.pn.nr.fx.u(str, str2);
        xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
        String strN = jp.n("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(strN).getQuery())) {
                strN = strN + "?abort_aes=1";
            } else {
                strN = strN + "&abort_aes=1";
            }
        } catch (Exception unused) {
        }
        xwVar.u(strN);
        xwVar.fx(jSONObjectU, "check_ad");
        xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.7
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                long j;
                boolean z;
                if (nrVar != null) {
                    if (!nrVar.a()) {
                        uVar.u(false, nrVar.nr() != 0 ? nrVar.nr() : -1L, nrVar.jk());
                        return;
                    }
                    if (nrVar.pn() != null) {
                        try {
                            nr nrVarU = nr.u(new JSONObject(nrVar.pn()));
                            j = nrVarU.u;
                            j = j;
                            z = nrVarU.nr;
                        } catch (JSONException unused2) {
                            j = j;
                            z = false;
                        }
                    } else {
                        j = j;
                        z = false;
                    }
                    uVar.u(z, j, nrVar.jk());
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                uVar.u(false, 0L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.pn.nr.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        xw xwVar = new xw(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
        String strN = jp.n("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strN).getQuery())) {
                strN = strN + "?abort_aes=1";
            } else {
                strN = strN + "&abort_aes=1";
            }
        } catch (Exception unused) {
        }
        xwVar.u(strN);
        xwVar.fx(jSONObject, "checkAndCorrectAd");
        xwVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.8
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar2) {
                long j;
                if (nrVar2 != null) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (nrVar2.a()) {
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.fx.iz.u(nrVar2, "checkAndCorrectAd", false).second;
                            com.bytedance.sdk.openadsdk.core.pn.nr.b bVarU = null;
                            JSONObject jSONObject2 = obj != null ? (JSONObject) obj : null;
                            if (jSONObject2 != null) {
                                try {
                                    bVarU = com.bytedance.sdk.openadsdk.core.pn.nr.b.u(jSONObject2);
                                    j = bVarU != null ? bVarU.u : -1L;
                                } catch (Exception unused2) {
                                    j = -1;
                                }
                            } else {
                                j = -1;
                            }
                            nrVar.u(bVarU, j, jCurrentTimeMillis2);
                            return;
                        } catch (Exception unused3) {
                        }
                    }
                    nrVar.u(null, nrVar2.nr() != 0 ? nrVar2.nr() : -1L, jCurrentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                nrVar.u(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public com.bytedance.sdk.component.adexpress.u.fx.u u(int i) {
        String strHs;
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB = null;
        if (!com.bytedance.sdk.openadsdk.core.pb.a.u()) {
            return null;
        }
        if (i == 2) {
            strHs = dw.nr().te();
        } else {
            strHs = dw.nr().hs();
        }
        if (TextUtils.isEmpty(strHs)) {
            return null;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
        fxVarFx.u(m.nr(strHs));
        com.bytedance.sdk.component.a.nr nrVarU = fxVarFx.u();
        if (nrVarU != null) {
            try {
                if (nrVarU.a()) {
                    if (i == 2) {
                        uVarB = com.bytedance.sdk.openadsdk.core.ugeno.x.nr.pn(nrVarU.pn());
                    } else {
                        uVarB = com.bytedance.sdk.component.adexpress.u.fx.u.b(nrVarU.pn());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return uVarB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public com.bytedance.sdk.openadsdk.core.kj.b u(final bc bcVar, String str) {
        String strVk;
        String strMv;
        Object obj;
        if (bcVar != null) {
            strVk = bcVar.vk();
            com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
            com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
            strMv = izVarHm != null ? izVarHm.mv() : null;
            if (TextUtils.isEmpty(strMv) && pnVarPu != null) {
                strMv = pnVarPu.b();
            }
            Map<String, Object> mapSj = bcVar.sj();
            if (TextUtils.isEmpty(strMv) && mapSj != null && (obj = mapSj.get("ad_package_name")) != null) {
                strMv = obj.toString();
            }
            if (TextUtils.isEmpty(strMv)) {
                strMv = bcVar.nr;
            }
        } else {
            strVk = null;
            strMv = null;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
        fxVarFx.u("https://" + dw.nr().ti() + "/customer/api/app/pkg_info");
        fxVarFx.u("convert_id", strVk);
        fxVarFx.u("package_name", strMv);
        fxVarFx.u(WfConstant.EXTRA_KEY_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.gi.n.nr(str));
        String str2 = strVk + "_" + strMv + "_" + str;
        com.bytedance.sdk.openadsdk.core.kj.b bVarU = com.bytedance.sdk.openadsdk.core.l.u.u(str2);
        if (bVarU != null) {
            return bVarU;
        }
        final com.bytedance.sdk.component.a.nr[] nrVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.9
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                nrVarArr[0] = nrVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(final com.bytedance.sdk.component.a.nr.b bVar, final IOException iOException) {
                countDownLatch.countDown();
                com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.9.1
                    @Override // com.bytedance.sdk.openadsdk.t.u.u
                    public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        com.bytedance.sdk.component.a.nr.b bVar2 = bVar;
                        if (bVar2 != null) {
                            jSONObject.putOpt("net_extra", bVar2.b());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        com.bytedance.sdk.openadsdk.core.qq.u.nr<com.bytedance.sdk.openadsdk.core.qq.u.nr> nrVarNr = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr();
                        bc bcVar2 = bcVar;
                        return nrVarNr.n(bcVar2 != null ? bcVar2.ap() : "").u("pkg_info_failed").nr(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        try {
            com.bytedance.sdk.component.a.nr nrVar = nrVarArr[0];
            if (nrVar != null && nrVar.a() && !TextUtils.isEmpty(nrVarArr[0].pn()) && new JSONObject(nrVarArr[0].pn()).optInt("code", -1) == 0) {
                com.bytedance.sdk.openadsdk.core.kj.b bVar = new com.bytedance.sdk.openadsdk.core.kj.b(new JSONObject(nrVarArr[0].pn()));
                com.bytedance.sdk.openadsdk.core.l.u.u(str2, bVar);
                return bVar;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(final jw jwVar, final String str, final String str2, final qq.fx fxVar, final int i, final long j) {
        if (fxVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.kj.10
                @Override // java.lang.Runnable
                public void run() {
                    kj.this.nr(jwVar, str, str2, fxVar, i, j);
                }
            });
        } else {
            nr(jwVar, str, str2, fxVar, i, j);
        }
    }

    private JSONObject u(jw jwVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", jwVar.fx());
            jSONObject.put("site_id", jwVar.b());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(String str) {
        b(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(final JSONObject jSONObject, final qq.fx<com.bytedance.sdk.component.a.nr> fxVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.jk.x.u().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kj.14
                @Override // java.lang.Runnable
                public void run() {
                    kj.this.nr(jSONObject, (qq.fx<com.bytedance.sdk.component.a.nr>) fxVar);
                }
            });
        } else {
            nr(jSONObject, fxVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(final Function<SparseArray<Object>, Object> function) {
        com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
        pnVarNr.u("https://" + n.o().f() + "/ad_union_qa/sdk/query_config_list");
        pnVarNr.nr("x-pglcypher", "4");
        pnVarNr.nr("x-ad-sdk-version", d.b);
        pnVarNr.nr("x-plugin-version", "7.2.3.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", n.o().c());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
        } catch (Throwable unused) {
        }
        byte[] bArrU = com.bytedance.sdk.openadsdk.core.y.mv.u(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.bytedance.sdk.component.b.u uVarNr = com.bytedance.sdk.openadsdk.core.y.kj.nr();
        if (uVarNr == null) {
            u(function, -4, "armor service init fail");
        } else {
            pnVarNr.u("application/octet-stream", uVarNr.encrypt(bArrU));
            pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.15
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    Function function2 = function;
                    if (function2 == null || nrVar == null) {
                        kj.this.u((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String strNr = com.bytedance.sdk.openadsdk.core.y.mv.nr((TextUtils.equals(nrVar.b().get("content-type"), "application/octet-stream") || TextUtils.equals(nrVar.b().get("x-pglcypher"), "4")) ? uVarNr.decrypt(nrVar.t()) : nrVar.pn().getBytes());
                    if (TextUtils.isEmpty(strNr)) {
                        kj.this.u((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strNr);
                        int iOptInt = jSONObject2.optInt("code", -1);
                        String strOptString = jSONObject2.optString("message");
                        if (iOptInt != 0) {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                            return;
                        }
                        String strOptString2 = jSONObject2.optString("data");
                        if (TextUtils.isEmpty(strOptString2)) {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, iOptInt, "response data is empty");
                        } else {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, strOptString2);
                        }
                    } catch (JSONException unused2) {
                        kj.this.u((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    kj.this.u((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(10000).u(Void.class).u(0, str).nr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(10001).u(Void.class).u(0, Integer.valueOf(i)).u(1, str).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qq
    public void u(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
        pnVarNr.u("https://" + n.o().f() + "/ad_union_qa/sdk/get_ad_config");
        pnVarNr.nr("x-pglcypher", "4");
        pnVarNr.nr("x-ad-sdk-version", d.b);
        pnVarNr.nr("x-plugin-version", "7.2.3.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", n.o().c());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] bArrU = com.bytedance.sdk.openadsdk.core.y.mv.u(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.bytedance.sdk.component.b.u uVarNr = com.bytedance.sdk.openadsdk.core.y.kj.nr();
            if (uVarNr == null) {
                u(function, -4, "armor service init fail");
            } else {
                pnVarNr.u("application/octet-stream", uVarNr.encrypt(bArrU));
                pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.16
                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                        String strNr;
                        int iOptInt = -1;
                        if (nrVar == null) {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String str = nrVar.b().get("content-type");
                        String str2 = nrVar.b().get("x-pglcypher");
                        String strOptString = "";
                        if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                            strNr = com.bytedance.sdk.openadsdk.core.y.mv.nr(uVarNr.decrypt(nrVar.t()));
                            if (TextUtils.isEmpty(strNr)) {
                                strOptString = "data is null";
                            } else {
                                PluginValueSet pluginValueSetNr = com.bytedance.sdk.openadsdk.my.fx.nr(function);
                                if (!TextUtils.isEmpty(strNr) && function != null && pluginValueSetNr != null && TextUtils.equals((CharSequence) pluginValueSetNr.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    n.o().u(new n.b(map, strNr));
                                }
                                iOptInt = 0;
                            }
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(nrVar.pn());
                                iOptInt = jSONObject2.optInt("code");
                                String strOptString2 = jSONObject2.optString("message");
                                try {
                                    strOptString = jSONObject2.optString("data");
                                    PluginValueSet pluginValueSetNr2 = com.bytedance.sdk.openadsdk.my.fx.nr(function);
                                    if (!TextUtils.isEmpty(strOptString) && function != null && pluginValueSetNr2 != null && TextUtils.equals((CharSequence) pluginValueSetNr2.objectValue(0, String.class), "GetAdConfigImpl")) {
                                        n.o().u(new n.b(map, strOptString));
                                    }
                                } catch (JSONException unused) {
                                }
                                String str3 = strOptString;
                                strOptString = strOptString2;
                                strNr = str3;
                            } catch (JSONException unused2) {
                                strNr = "";
                            }
                        }
                        if (iOptInt == 0) {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, strNr);
                        } else {
                            kj.this.u((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                        }
                    }

                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                        kj.this.u((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
