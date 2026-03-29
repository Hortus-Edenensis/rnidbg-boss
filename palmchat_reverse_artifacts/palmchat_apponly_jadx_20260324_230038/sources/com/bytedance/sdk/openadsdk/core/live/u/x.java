package com.bytedance.sdk.openadsdk.core.live.u;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja.nr.fx;
import com.bytedance.sdk.openadsdk.core.ja.nr.pn;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jp;
import com.bytedance.sdk.openadsdk.core.kj.v;
import com.bytedance.sdk.openadsdk.core.kj.y;
import com.bytedance.sdk.openadsdk.core.live.u.iz;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.pb.t;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.y.qq;
import com.bytedance.sdk.openadsdk.gi.l;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.bq;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends iz {
    private volatile com.bytedance.sdk.openadsdk.core.ja.nr.pn<Boolean> bg;
    private volatile Set<String> jk;
    private final AtomicBoolean n = new AtomicBoolean(false);
    public volatile com.bytedance.sdk.openadsdk.k.b x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f5333a = -5;
    private volatile boolean t = false;
    private final long l = System.currentTimeMillis();
    private volatile boolean mv = false;
    private volatile boolean s = false;
    private long k = -1;
    private long my = -1;
    private long o = -1;
    private boolean sx = false;
    private final AtomicInteger bq = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.live.u.x$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass3 implements fx.nr {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ja.nr.fx.nr
        public void u() throws Exception {
            if (x.this.f5333a != -3) {
                return;
            }
            jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.3.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.jk.x.nr(new a("live pl retry") { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (x.this.f5333a != -3) {
                                return;
                            }
                            x.this.n.set(false);
                            x.this.u();
                        }
                    });
                }
            }, 10000L);
        }
    }

    public x() {
        if (com.bytedance.sdk.openadsdk.gi.x.u()) {
            com.bytedance.sdk.openadsdk.gi.x.fx(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.a();
                }
            });
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        s();
        n.o().u("com.byted.live.lite", fx(l.nr("com.byted.live.lite")), this.pn, null);
        if (!dw.nr().hl()) {
            this.f5333a = -4;
        } else {
            jk();
            this.k = com.bytedance.sdk.openadsdk.core.nr.u().get("live_last_init_time", 0L);
        }
    }

    private void bg() {
        if (com.bytedance.sdk.openadsdk.core.pb.jk.b() && this.bg != null) {
            this.bg.fx();
        }
    }

    private void jk() {
        if (!this.mv && l()) {
            this.mv = true;
            jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.this.mv();
                }
            }, t());
        }
    }

    private boolean k() {
        try {
            if (d.fx >= 7000) {
                int iFx = Integer.parseInt(this.pn.replaceAll("\\.", ""));
                if (iFx == 0) {
                    iFx = l.fx("com.byted.live.lite");
                }
                if (iFx <= 211413) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        t tVarNr = dw.nr();
        y yVarDf = tVarNr.df();
        int iNr = n.o().z().nr();
        return (yVarDf == null || !yVarDf.pn() || !tVarNr.hl() || iNr == 4 || iNr == 5) ? false : true;
    }

    private boolean l() {
        if (n.o().jk() && this.x == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.pb.nr nrVarIt = dw.nr().it();
        if (nrVarIt != null) {
            if (nrVarIt.pn()) {
                return this.t;
            }
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.pb.b.nr) {
            return this.t;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        Object objApply;
        this.o = SystemClock.elapsedRealtime();
        if (this.u == null) {
            this.u = n.o().iz(2);
        }
        boolean zBooleanValue = false;
        if (this.u != null) {
            this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(9).u(Void.class).u(0, new com.bytedance.sdk.openadsdk.core.live.nr.u(this)).nr());
        }
        Function<SparseArray<Object>, Object> functionV = n.o().v();
        if (functionV != null && (objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, "com.byted.live.lite").nr())) != null) {
            zBooleanValue = ((Boolean) objApply).booleanValue();
        }
        if (zBooleanValue && this.f5333a != 2) {
            this.f5333a = 1;
        }
        com.bytedance.sdk.openadsdk.tools.nr.fx(21, nr() > 0 ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.nr.fx(20, nr() != 2 ? "0" : "1");
    }

    private Map my() {
        JSONObject jSONObjectFx;
        String strNr;
        Map map = new HashMap();
        map.put("app_name", dw.getContext().getPackageName());
        y yVarDf = dw.nr().df();
        if (yVarDf != null) {
            map.put("partner", yVarDf.fx());
            map.put("p_secret", yVarDf.b());
            map.put("g_appid", String.valueOf(yVarDf.nr()));
        }
        map.put("channel", "csj_channel");
        map.put("debug", Boolean.valueOf(k.fx()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        if (!n.o().n()) {
            map2.put("enable_init_oaid", ex.V);
        }
        if (!n.o().s()) {
            map2.put("can_use_ip", ex.V);
        }
        if (!n.o().pn()) {
            map2.put("can_use_sensor", ex.V);
        }
        if (n.o().jk()) {
            String strFx = com.bytedance.sdk.openadsdk.core.y.jk.fx(false);
            if (!com.bytedance.sdk.openadsdk.core.b.u.fx() || TextUtils.isEmpty(strFx)) {
                strNr = qq.nr(this.x);
            } else {
                map2.remove("enable_init_oaid");
                strNr = qq.nr(strFx);
            }
            if (!TextUtils.isEmpty(strNr)) {
                map2.put("oaid_object", strNr);
            }
        }
        com.bytedance.sdk.openadsdk.core.pb.nr nrVarIt = dw.nr().it();
        if (nrVarIt != null) {
            map.put("sub_process", Boolean.valueOf(nrVarIt.u()));
        }
        map.put("c_control", n.o().sx());
        com.bytedance.sdk.openadsdk.core.pb.nr nrVarIt2 = dw.nr().it();
        if (nrVarIt2 == null || (jSONObjectFx = nrVarIt2.fx()) == null) {
            u(map, map2);
        } else {
            Iterator<String> itKeys = jSONObjectFx.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectFx.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Object objNr = nr("getLiveSdkConfig");
        if (objNr == null || !(objNr instanceof JSONObject)) {
            return;
        }
        this.fx = (JSONObject) objNr;
    }

    private void s() {
        Function<SparseArray<Object>, Object> functionV = n.o().v();
        if (functionV == null) {
            return;
        }
        a_((String) u(functionV, 8, String.class));
    }

    private void sx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.pb.jk.nr()));
            jSONObject.put(Constant.MAP_KEY_UUID, com.bytedance.sdk.openadsdk.core.y.jk.sx());
            jSONObject.putOpt("has_install", Boolean.valueOf(this.sx));
            jSONObject.put("retry_count", this.bq.get());
        } catch (JSONException unused) {
        }
        s.u().b(jSONObject);
    }

    private long t() {
        com.bytedance.sdk.openadsdk.core.pb.nr nrVarIt = dw.nr().it();
        long jNr = com.bytedance.sdk.openadsdk.core.pb.b.u;
        if (nrVarIt != null) {
            jNr = nrVarIt.nr();
        }
        if (System.currentTimeMillis() - this.l > jNr) {
            return 0L;
        }
        return jNr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public boolean iz() {
        return this.f5333a == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public JSONObject n() {
        return this.fx;
    }

    private String fx(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void b() {
        if (this.u == null || !iz()) {
            return;
        }
        nr("warmingUpBeforeEnter");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int nr() {
        return this.f5333a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public int pn() {
        Object objNr;
        return (this.u == null || !iz() || (objNr = nr("hasAuthenticated")) == null || !(objNr instanceof Boolean)) ? false : ((Boolean) objNr).booleanValue() ? 2 : 1;
    }

    private Object nr(String str) {
        if (this.f5333a != 2) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.u != null) {
            return this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Void.class).u(0, map).nr());
        }
        return null;
    }

    private <T> T u(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        T t = (T) function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u((Class<?>) cls).u(0, "com.byted.live.lite").nr());
        if (t != null) {
            return t;
        }
        return null;
    }

    private boolean b(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.jk == null) {
            this.jk = new HashSet(11);
            this.jk.add("saas_easyplayable");
            this.jk.add("real_auth_status");
            this.jk.add("live_panel");
            this.jk.add("live_exit");
            this.jk.add("mnpl_user_close");
            this.jk.add("clickarea");
            this.jk.add("enterSection");
            this.jk.add("mini_playable_real_show");
            this.jk.add("mnpl_user_close");
            this.jk.add("mnpl_sdk_lifecycle_status");
        }
        return this.jk.contains(str);
    }

    private boolean pn(bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        if (jSONObjectTq == null) {
            return false;
        }
        if (jSONObjectTq.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(bcVar.uu())) {
            return com.bytedance.sdk.openadsdk.core.live.pn.u.u(bcVar);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public void u() {
        if (com.bytedance.sdk.openadsdk.core.pb.jk.b() && this.n.get()) {
            if (this.f5333a != -3) {
                return;
            }
        } else if (this.n.get()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.pb.jk.b()) {
            if (!this.s) {
                return;
            }
        } else if (this.f5333a != 5) {
            return;
        }
        if (this.f5333a != 2 && k()) {
            if (!com.bytedance.sdk.openadsdk.core.live.pn.nr.fx(this.pn)) {
                com.bytedance.sdk.openadsdk.core.live.pn.nr.b(this.pn);
                return;
            }
            this.sx = l.pn("com.byted.live.lite");
            this.my = SystemClock.elapsedRealtime();
            this.n.set(true);
            com.bytedance.sdk.openadsdk.core.live.pn.nr.u(this.pn);
            this.f5333a = 4;
            if (this.u != null) {
                this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(5).u(Void.class).u(0, my()).nr());
                this.bq.incrementAndGet();
                sx();
            }
            com.bytedance.sdk.openadsdk.core.live.pn.nr.nr(this.pn);
        }
    }

    private void fx(String str) {
        if (com.bytedance.sdk.openadsdk.core.pb.jk.b() && !TextUtils.isEmpty(str)) {
            if (str.contains("UnknownHostException") || str.contains("SocketException")) {
                if (gi.u(dw.getContext(), 0L) == 0) {
                    com.bytedance.sdk.openadsdk.core.ja.nr.fx.u().u(new AnonymousClass3());
                } else if (this.bg == null) {
                    this.bg = new pn.u(new Callable<Boolean>() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.4
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Boolean call() throws Exception {
                            com.bytedance.sdk.component.jk.x.nr(new a("live pl retry") { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x.this.n.set(false);
                                    x.this.u();
                                }
                            });
                            return Boolean.FALSE;
                        }
                    }).u(10000L).u(com.bytedance.sdk.openadsdk.core.pb.jk.nr()).u();
                    this.bg.nr();
                }
            }
        }
    }

    private JSONObject nr(int i, String str) {
        jp jpVarVg;
        JSONArray jSONArrayN;
        if (this.iz != null && this.iz.get() != null) {
            bc bcVar = this.iz.get();
            if (TextUtils.equals(bcVar.dv(), str) && (jpVarVg = bcVar.vg()) != null && (jSONArrayN = jpVarVg.n()) != null && jSONArrayN.length() != 0) {
                int length = jSONArrayN.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optInt("type") == i) {
                        return jSONObjectOptJSONObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public void b(bc bcVar) {
        if (bcVar == null || this.t || !pn(bcVar)) {
            return;
        }
        this.t = true;
        a();
    }

    public void fx(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) c.u(this.b, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        if (nrVar == null) {
            return;
        }
        nrVar.u(4, map);
    }

    public void nr(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get("status");
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if (!"1".equals(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = nr(Integer.parseInt(str), str4).optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            String strOptString = jSONObjectOptJSONObject.optString(bq.f.L);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strOptString);
            if (TextUtils.isEmpty(jSONObject.optString("name")) || (nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) c.u(this.b, com.bytedance.sdk.openadsdk.my.fx.u.nr.class)) == null) {
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("open_uid", str3);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, jSONObject.opt(next));
            }
            nrVar.u(3, map2);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.u, com.bytedance.sdk.openadsdk.core.live.u.b
    public long fx() {
        return this.k;
    }

    private void u(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.bytedance.sdk.openadsdk.core.pb.b.fx);
        map2.put("allow_npth_init", com.bytedance.sdk.openadsdk.core.pb.b.b);
        map2.put("allow_vlog_init", com.bytedance.sdk.openadsdk.core.pb.b.pn);
        map2.put("sec_init_use_thread", com.bytedance.sdk.openadsdk.core.pb.b.iz);
        map.put("live_tob_init_extra", map2);
    }

    public void u(int i, String str, boolean z, boolean z2) {
        int i2 = this.f5333a;
        this.f5333a = i;
        if (i == -3) {
            if (!z && this.f5333a != i2) {
                u(str, z2, false);
            }
            fx(str);
            return;
        }
        if (i == 5) {
            this.s = true;
            return;
        }
        if (i == 1) {
            com.bytedance.sdk.openadsdk.tools.nr.fx(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        bg();
        this.k = SystemClock.elapsedRealtime();
        if (!z && this.f5333a != i2) {
            u(str, z2, true);
        }
        com.bytedance.sdk.openadsdk.tools.nr.fx(21, "1");
        com.bytedance.sdk.openadsdk.tools.nr.fx(20, "1");
        s();
        o();
        com.bytedance.sdk.openadsdk.core.nr.u().put("live_last_init_time", this.k);
    }

    private void u(String str, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("has_install", Boolean.valueOf(this.sx));
            jSONObject.putOpt("fake_init", Boolean.valueOf(z));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jSONObject.putOpt("init_cost", Long.valueOf(jElapsedRealtime - this.my));
            jSONObject.putOpt(SharePluginInfo.ISSUE_COST, Long.valueOf(jElapsedRealtime - this.o));
            jSONObject.putOpt("success", Boolean.valueOf(z2));
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.pb.jk.nr()));
            jSONObject.put(Constant.MAP_KEY_UUID, com.bytedance.sdk.openadsdk.core.y.jk.sx());
            jSONObject.put("retry_count", this.bq.get());
        } catch (JSONException unused) {
        }
        s.u().fx(jSONObject);
    }

    public void u(boolean z, String str) {
        String str2;
        com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar;
        com.bytedance.sdk.openadsdk.gi.x.u(new a("getLiveSdk") { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.5
            @Override // java.lang.Runnable
            public void run() {
                x.this.o();
            }
        });
        if (this.iz != null && this.iz.get() != null) {
            com.bytedance.sdk.openadsdk.core.s.b.u(z ? 2 : 1, this.nr != null ? this.nr : "", this.iz.get());
        }
        if (!z || (str2 = this.b) == null || (nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) c.u(str2, com.bytedance.sdk.openadsdk.my.fx.u.nr.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        nrVar.u(1, map);
        u(10002, this.b);
    }

    private JSONObject u(int i, String str) {
        JSONObject jSONObjectNr = nr(i, str);
        if (jSONObjectNr != null) {
            try {
                jSONObjectNr.putOpt("status", 1);
            } catch (JSONException unused) {
            }
            bc bcVar = this.iz.get();
            if (bcVar != null) {
                com.bytedance.sdk.openadsdk.core.live.b.u.u(str, bcVar.lk() + "_" + i);
            }
        }
        return jSONObjectNr;
    }

    public void u(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get(ReportItem.RequestKeyRequestId);
        if (!TextUtils.isEmpty(str) && b(str)) {
            bc bcVar = this.iz != null ? this.iz.get() : null;
            final String str3 = map.get(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            com.bytedance.sdk.openadsdk.iz.u.u uVar = new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.6
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject) throws JSONException {
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jSONObject2.put(ReportItem.RequestKeyRequestId, str2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
            };
            if (bcVar != null) {
                com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, this.nr, str, uVar);
                String strXx = bcVar.xx();
                if (TextUtils.equals(strXx, str2)) {
                    return;
                }
                u(str2, str, "mate req is " + strXx);
                return;
            }
            new u.C0284u().u(this.nr).nr(str).u(uVar);
            u(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
        }
    }

    private void u(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyRequestId, str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        s.u().u("reportPangleEvent", jSONObject, (Throwable) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.iz, com.bytedance.sdk.openadsdk.core.live.u.b
    public int u(final bc bcVar, final fx fxVar, final String str) {
        if (bcVar == null) {
            return 0;
        }
        final String strEh = bcVar.eh();
        if (TextUtils.isEmpty(strEh)) {
            return 0;
        }
        if (this.f5333a != 2) {
            return -1;
        }
        this.nr = str;
        this.iz = new SoftReference<>(bcVar);
        v vVarEj = bcVar.ej();
        if (2 != pn() && vVarEj != null) {
            boolean z = vVarEj.b() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final boolean z2 = z;
            if (u(bcVar, new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.7
                @Override // com.bytedance.sdk.openadsdk.core.live.u.iz.u
                public void u(boolean z3) {
                    boolean z4;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        x.this.u(bcVar, fxVar, strEh, z3, z2, str, 1);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    s.u().u(bcVar, System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                }
            }, true)) {
                long jPn = vVarEj.pn();
                if (jPn <= 0) {
                    return 2;
                }
                final boolean z3 = z;
                jk.nr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.u.x.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            x.this.u(bcVar, fxVar, strEh, false, z3, str, 2);
                        }
                    }
                }, jPn);
                return 2;
            }
        }
        int iU = u(strEh);
        u(iU, bcVar, false, 0);
        return iU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar, fx fxVar, String str, boolean z, boolean z2, String str2, int i) {
        int iU = u(str);
        u(iU, bcVar, z, i);
        if (iU != 1) {
            if (fxVar != null) {
                fxVar.u(iU);
            }
        } else {
            if (z || !z2) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.live.fx.u().u(str2).u(dw.getContext(), bcVar);
        }
    }

    private void u(int i, bc bcVar, boolean z, int i2) {
        if (bcVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put(ReportItem.RequestKeyRequestId, bcVar.xx());
            jSONObject.put("auth", z);
            v vVarEj = bcVar.ej();
            if (vVarEj != null) {
                jSONObject.put("saas_info", vVarEj.u());
            }
            jSONObject.put("status", i2);
            jSONObject.put("ext", bcVar.ap());
        } catch (Exception unused) {
        }
        s.u().nr(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.u.b
    public void u(com.bytedance.sdk.openadsdk.k.b bVar) {
        this.x = bVar;
        a();
    }
}
