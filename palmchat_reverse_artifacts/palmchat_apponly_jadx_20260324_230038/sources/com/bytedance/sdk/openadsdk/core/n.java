package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.my.fx.fx.b;
import com.bytedance.sdk.openadsdk.my.fx.fx.fx;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.gdt.action.ActionUtils;
import defpackage.g95;
import defpackage.r95;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static final com.bytedance.sdk.openadsdk.my.fx.fx.b u = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f5335a;
    private volatile boolean b;
    private volatile boolean bc;
    private pn bf;
    private volatile boolean bg;
    private Function<SparseArray<Object>, Object> bq;
    private volatile int c;
    private int d;
    private volatile boolean dw;
    private volatile String fx;
    private volatile Function<SparseArray<Object>, Object> gi;
    private int h;
    private volatile String iz;
    private long ja;
    private volatile boolean jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private String f5336jp;
    private volatile com.bytedance.sdk.openadsdk.my.fx.fx.b k;
    private boolean kj;
    private volatile boolean l;
    private String m;
    private Bitmap mv;
    private String my;
    private volatile com.bytedance.sdk.openadsdk.core.ja.u n;
    private volatile String nr;
    private String o;
    private com.bytedance.sdk.openadsdk.core.playable.b oa;
    private volatile String pb;
    private volatile String pn;
    private volatile JSONObject q;
    private HashMap<String, Object> qq;
    private int rh;
    private volatile com.bytedance.sdk.openadsdk.core.y.u s;
    private volatile boolean sx;
    private final Set<Integer> t;
    private String w;
    private boolean wq;
    private volatile String x;
    private String xg;
    private Map<String, Object> xw;
    private b y;
    private boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private String nr;
        private Map<String, Object> u;

        public b(Map<String, Object> map, String str) {
            this.u = map;
            this.nr = str;
        }

        public void u(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.u) == null || map.size() == 0 || TextUtils.isEmpty(this.nr)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.u.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.nr));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        public static final com.bytedance.sdk.component.b.nr.fx u = com.bytedance.sdk.openadsdk.core.y.bf.u("sp_global_info");
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static n u = new n();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u extends com.bytedance.sdk.openadsdk.my.fx.fx.b {
        public u() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public com.bytedance.sdk.openadsdk.my.fx.fx.fx a() {
            String[] strArrSplit;
            String strU = com.bytedance.sdk.openadsdk.tools.nr.u(8, "");
            if (TextUtils.isEmpty(strU) || (strArrSplit = strU.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new fx.u().u(Double.valueOf(str).doubleValue()).nr(Double.valueOf(str2).doubleValue()).u();
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean b() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean fx() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(9, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean iz() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(22, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public String jk() {
            return com.bytedance.sdk.openadsdk.tools.nr.u(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public String l() {
            return com.bytedance.sdk.openadsdk.tools.nr.u(13, "");
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean mv() {
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean n() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(24, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean nr() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(17, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean pn() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public String t() {
            return com.bytedance.sdk.openadsdk.tools.nr.u(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean u() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.nr.u(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
        public boolean x() {
            return false;
        }
    }

    private static com.bytedance.sdk.openadsdk.my.fx.fx.b jw() {
        return new b.u().nr(true).u(true).u((com.bytedance.sdk.openadsdk.my.fx.fx.fx) null).fx(true).u((String) null).b(true).nr((String) null).pn(true).fx((String) null).iz(true).b((String) null).x(false).u();
    }

    public static n o() {
        return nr.u;
    }

    public static Object zx() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return declaredField3.get(obj);
                    }
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a() {
        return jk() && com.bytedance.sdk.openadsdk.core.b.u.fx();
    }

    public int ay() {
        return com.bytedance.sdk.openadsdk.core.fx.b.u().b(0);
    }

    public com.bytedance.sdk.openadsdk.core.y.u b() {
        if (this.s == null) {
            fx(dw.getContext());
        }
        return this.s;
    }

    public com.bytedance.sdk.openadsdk.core.playable.b bc() {
        if (this.oa == null) {
            this.oa = new com.bytedance.sdk.openadsdk.core.playable.b(10, 8);
        }
        return this.oa;
    }

    public void bf() {
        com.bytedance.sdk.openadsdk.core.fx.b.u().nr(this.c);
        com.bytedance.sdk.openadsdk.core.fx.b.u().u(this.nr);
        com.bytedance.sdk.openadsdk.core.fx.b.u().nr(this.fx);
        com.bytedance.sdk.openadsdk.core.fx.b.u().nr(this.b);
        com.bytedance.sdk.openadsdk.core.fx.b.u().pn(this.pn);
        com.bytedance.sdk.openadsdk.core.fx.b.u().x(this.iz);
        com.bytedance.sdk.openadsdk.core.fx.b.u().a(u(this.qq));
        com.bytedance.sdk.component.b.nr.fx fxVar = fx.u;
        fxVar.put("title_bar_theme", this.f5335a);
        fxVar.put("allow_show_notify", this.jk);
        com.bytedance.sdk.openadsdk.core.fx.b.u().b(this.l);
        Set<Integer> set = this.t;
        if (set == null || set.isEmpty()) {
            fxVar.remove("network_state");
            return;
        }
        Iterator<Integer> it = this.t.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        fx.u.put("network_state", sb.toString());
    }

    public String bg() {
        return this.w;
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.b bq() {
        if (this.k == null || this.k.mv()) {
            this.k = tk() ? u : jw();
        }
        return this.k;
    }

    public String c() {
        return !TextUtils.isEmpty(this.nr) ? this.nr : com.bytedance.sdk.openadsdk.core.fx.b.u().b();
    }

    public String cj() {
        if (!com.bytedance.sdk.openadsdk.core.fx.fx.u().nr()) {
            return TextUtils.isEmpty(this.my) ? "" : this.my;
        }
        String str = fx.u.get("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public Map<String, Object> d() {
        if (!this.qq.isEmpty()) {
            return this.qq;
        }
        String strJk = com.bytedance.sdk.openadsdk.core.fx.b.u().jk("");
        this.qq.putAll(TextUtils.isEmpty(strJk) ? k(strJk) : new HashMap<>());
        return this.qq;
    }

    public boolean dw() {
        return fx.u.get("sdk_activate_init", true);
    }

    public boolean eh() {
        return this.wq;
    }

    public String f() {
        return fx.u.get("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public boolean fx() {
        if (!this.z && Build.VERSION.SDK_INT >= 26) {
            this.z = true;
            try {
                ShortcutManager shortcutManagerA = r95.a(dw.getContext().getSystemService(g95.a()));
                if (shortcutManagerA != null) {
                    this.kj = shortcutManagerA.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.kj;
    }

    public long gc() {
        return this.ja;
    }

    public String ge() {
        return fx.u.get("ritDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/rit_detail.html");
    }

    public String gi() {
        return !TextUtils.isEmpty(this.iz) ? this.iz : com.bytedance.sdk.openadsdk.core.fx.b.u().n("");
    }

    public int h() {
        return com.bytedance.sdk.openadsdk.core.multipro.nr.fx() ? fx.u.get("title_bar_theme", 0) : this.f5335a;
    }

    public String iz() {
        return com.bytedance.sdk.openadsdk.k.fx.u().nr();
    }

    public boolean ja() {
        return this.sx;
    }

    public boolean jk() {
        return !t() && n();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jp() {
        String string;
        JSONObject jSONObject = new JSONObject();
        String strXg = xg();
        if (TextUtils.isEmpty(strXg) && (!TextUtils.isEmpty(pb()) || !TextUtils.isEmpty(m()))) {
            strXg = "1.0.0";
        }
        try {
            jSONObject.put("gdt_version", strXg);
        } catch (JSONException unused) {
        }
        int iFx = com.bytedance.sdk.openadsdk.gi.l.fx("com.byted.mixed");
        if (iFx != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(iFx);
            String string2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < string2.length(); i++) {
                sb2.append(string2.charAt(i));
                if (i != string2.length() - 1) {
                    sb2.append(".");
                }
            }
            string = !TextUtils.isEmpty(sb2.toString()) ? sb2.toString() : "1.0.0.0";
        }
        if (jSONObject.has("gdt_version")) {
            try {
                jSONObject.put("app_id", this.nr);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, string);
                jSONObject.put("sdk_version", string);
                jSONObject.put("plugin_update_network", "2");
                this.q.put("com.byted.mixed", jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public b ju() {
        return this.y;
    }

    public void k() {
        my();
        Context context = dw.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.iz.u.u(context);
        }
        this.t.add(4);
        fx(context);
    }

    public String kj() {
        return !TextUtils.isEmpty(this.pn) ? this.pn : com.bytedance.sdk.openadsdk.core.fx.b.u().iz("");
    }

    public boolean kw() {
        com.bytedance.sdk.component.b.nr.fx fxVar = fx.u;
        if (fxVar.get("update_advance_preview_mode", false)) {
            long j = fxVar.get("update_advance_preview_mode_time", -1L);
            if (j != -1) {
                if (System.currentTimeMillis() - j <= 3600000) {
                    return true;
                }
                a(false);
            }
        }
        return false;
    }

    public boolean l() {
        return com.bytedance.sdk.openadsdk.k.fx.u().a();
    }

    public String lf() {
        return this.x;
    }

    public String m() {
        if (!TextUtils.isEmpty(this.f5336jp)) {
            return this.f5336jp;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                this.f5336jp = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String mh() {
        if (!TextUtils.isEmpty(this.o)) {
            return this.o;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        String str = fxVarU.get("any_door_id", (String) null);
        this.o = str;
        if (!TextUtils.isEmpty(str)) {
            return this.o;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        fxVarU.put("any_door_id", strValueOf);
        this.o = strValueOf;
        return strValueOf;
    }

    public String mk() {
        try {
            if ((dw.nr().hm() & 1) == 1) {
                return com.bytedance.sdk.openadsdk.core.fx.pn.u().pn();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void mv() {
        com.bytedance.sdk.openadsdk.k.fx.u().pn();
    }

    public void my() {
        this.bc = com.bytedance.sdk.openadsdk.core.b.u.nr();
    }

    public boolean n() {
        return com.bytedance.sdk.openadsdk.k.fx.u().x();
    }

    public int nb() {
        return this.rh;
    }

    public String nr() {
        if (TextUtils.isEmpty(this.pb)) {
            this.pb = com.bytedance.sdk.openadsdk.core.l.a.u();
        }
        return this.pb;
    }

    public Bitmap oa() {
        return com.bytedance.sdk.openadsdk.core.multipro.nr.fx() ? com.bytedance.sdk.component.utils.b.u(fx.u.get("pause_icon", "")) : this.mv;
    }

    public String ob() {
        return fx.u.get("codeidDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/codeid_detail.html");
    }

    public Object p() {
        WeakReference<Activity> weakReferenceU = this.s.u();
        if (weakReferenceU != null) {
            return weakReferenceU.get();
        }
        Object objApply = this.gi != null ? this.gi.apply(com.bytedance.sdk.openadsdk.my.b.u().u(14).u(Activity.class).nr()) : null;
        return objApply == null ? zx() : objApply;
    }

    public String pb() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        try {
            AtomicBoolean atomicBoolean = KsAdSDK.sHasInit;
            Object objInvoke = KsAdSDK.class.getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.m = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public boolean pn() {
        return com.bytedance.sdk.openadsdk.k.fx.u().iz();
    }

    public String q() {
        return !TextUtils.isEmpty(this.fx) ? this.fx : com.bytedance.sdk.openadsdk.core.fx.b.u().pn();
    }

    public boolean qq() {
        return com.bytedance.sdk.openadsdk.core.fx.fx.u().nr() ? com.bytedance.sdk.openadsdk.core.fx.b.u().u(this.b) : this.b;
    }

    public boolean rh() {
        return com.bytedance.sdk.openadsdk.core.multipro.nr.fx() ? fx.u.get("allow_show_notify", true) : this.jk;
    }

    public String rv() {
        return fx.u.get("adnDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/adn_detail.html");
    }

    public boolean s() {
        return com.bytedance.sdk.openadsdk.k.fx.u().fx();
    }

    public boolean su() {
        try {
            if ("com.union_test.toutiao".equals(dw.getContext().getPackageName()) && "5001121".equals(this.nr)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(dw.getContext().getPackageName()) && "5001121".equals(this.nr)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(dw.getContext().getPackageName()) && "5001121".equals(this.nr)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(dw.getContext().getPackageName()) && "5001121".equals(this.nr)) {
                return true;
            }
            if (dw.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
                return "5001121".equals(this.nr);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.b sx() {
        return new z(bq());
    }

    public boolean t() {
        return com.bytedance.sdk.openadsdk.k.fx.u().n();
    }

    public boolean tk() {
        return "5001121".equals(this.nr) && "com.union_test.toutiao".equals(jp.a());
    }

    public String tm() {
        return fx.u.get("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/basic_info.html");
    }

    public Function<SparseArray<Object>, Object> v() {
        return this.gi;
    }

    public int w() {
        if (!com.bytedance.sdk.openadsdk.core.fx.fx.u().nr()) {
            return this.c;
        }
        int iIz = com.bytedance.sdk.openadsdk.core.fx.b.u().iz();
        return iIz == Integer.MIN_VALUE ? this.c : iIz;
    }

    public boolean wi() {
        return "5001121".equals(this.nr);
    }

    public JSONObject wq() {
        if (d.nr()) {
            o().jp();
        }
        return this.q;
    }

    public boolean x() {
        return this.bc;
    }

    public String xg() {
        if (!TextUtils.isEmpty(this.xg)) {
            return this.xg;
        }
        try {
            Object objInvoke = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.xg = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public boolean xw() {
        return com.bytedance.sdk.openadsdk.core.fx.fx.u().nr() ? com.bytedance.sdk.openadsdk.core.fx.b.u().fx(false) : this.l;
    }

    public Function<SparseArray<Object>, Object> y() {
        Function<SparseArray<Object>, Object> function = this.bq;
        if (function != null) {
            return function;
        }
        if (com.bytedance.sdk.openadsdk.my.fx.b.nr(d.fx)) {
            this.bq = com.bytedance.sdk.openadsdk.core.l.b.my.u(dw.getContext());
        } else {
            this.bq = iz(3);
        }
        return this.bq;
    }

    public boolean yd() {
        return this.bg;
    }

    public com.bytedance.sdk.openadsdk.core.ja.u z() {
        return this.n;
    }

    public String za() {
        return fx.u.get("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/ad_preview.html");
    }

    private n() {
        this.n = new com.bytedance.sdk.openadsdk.core.ja.u(2);
        this.f5335a = 0;
        this.jk = true;
        this.t = Collections.synchronizedSet(new HashSet());
        this.l = false;
        this.mv = null;
        this.sx = false;
        this.bg = true;
        this.dw = true;
        this.c = 0;
        this.q = new JSONObject();
        this.qq = new HashMap<>();
        this.kj = false;
        this.z = false;
        this.gi = null;
        this.d = -1;
        this.h = -1;
        this.rh = -1;
        this.ja = -1L;
        this.w = null;
    }

    private static void bg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.bg.u(str.length() <= 20000, "data超长, 最长为20000");
    }

    private static void my(String str) {
        com.bytedance.sdk.component.utils.bg.u(str, "appid不能为空");
    }

    private static void o(String str) {
        com.bytedance.sdk.component.utils.bg.u(str, "name不能为空");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap map = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.isNull("__name__")) {
                    String strOptString = jSONObjectOptJSONObject.optString("__name__");
                    String strOptString2 = jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString("name"))) {
                    jk(jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z) {
            this.iz = jSONArray.toString();
        } else {
            this.iz = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.iz = jSONArray2.toString();
        }
        if (map.isEmpty()) {
            return;
        }
        this.qq.putAll(map);
    }

    private static void sx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.bg.u(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    public boolean a(String str) {
        Map<String, Object> map = this.xw;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xw.containsKey(str);
    }

    public void iz(final String str) {
        bg(str);
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.s(str);
            }
        });
    }

    public void l(String str) {
        fx.u.put("toolsAdPreviewUrl", str);
    }

    public void mv(String str) {
        fx.u.put("toolsBasicInfUrl", str);
    }

    public void n(String str) {
        pn(str);
        com.bytedance.sdk.openadsdk.core.fx.b.u().pn(str);
    }

    public void pn(String str) {
        sx(str);
        this.pn = str;
    }

    public void t(String str) {
        fx.u.put("toolsQueryHost", str);
    }

    public boolean u() {
        return this.s != null && this.s.nr();
    }

    public void x(String str) {
        iz(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.openadsdk.core.fx.b.u().x(str);
            com.bytedance.sdk.openadsdk.core.fx.b.u().a(u(this.qq));
        }
    }

    public void jk(String str) {
        this.x = str;
        com.bytedance.sdk.openadsdk.core.pb.n.u((com.bytedance.sdk.openadsdk.core.pb.pn) null).u(true);
    }

    public boolean u(boolean z) {
        return this.s != null && this.s.u(z);
    }

    public void a(boolean z) {
        com.bytedance.sdk.component.b.nr.fx fxVar = fx.u;
        fxVar.put("update_advance_preview_mode", z);
        fxVar.put("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public void b(String str) {
        o(str);
        this.fx = str;
    }

    public void iz(boolean z) {
        d.n = z;
        this.l = z;
    }

    public void n(boolean z) {
        this.wq = z;
    }

    public void nr(String str) {
        this.w = str;
    }

    public void pn(boolean z) {
        fx(z);
        com.bytedance.sdk.openadsdk.core.fx.b.u().nr(z);
    }

    public void u(String str) {
        this.pb = str;
    }

    public void nr(boolean z) {
        fx.u.put("sdk_activate_init", z);
    }

    public boolean u(Activity activity) {
        return this.s != null && this.s.u(activity);
    }

    private void fx(Context context) {
        this.s = new com.bytedance.sdk.openadsdk.core.y.u();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.s);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.s);
        }
    }

    private static final HashMap<String, Object> k(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    map.put(next, jSONObject.opt(next));
                }
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public void b(boolean z) {
        this.jk = z;
    }

    public Function<SparseArray<Object>, Object> iz(int i) {
        if (this.gi == null) {
            return null;
        }
        return (Function) this.gi.apply(com.bytedance.sdk.openadsdk.my.b.u().u(10).u(Object.class).u(0, Integer.valueOf(i)).nr());
    }

    public void nr(int i) {
        this.f5335a = i;
    }

    public void pn(int i) {
        com.bytedance.sdk.openadsdk.core.fx.b.u().fx(i);
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.b bVar) {
        this.k = bVar;
    }

    public void x(boolean z) {
        this.bg = z;
    }

    public void b(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.c = i;
        } catch (Throwable unused) {
        }
    }

    public boolean nr(Context context) {
        if (com.bytedance.sdk.openadsdk.core.bf.u.u().pn()) {
            this.h = 2;
        } else {
            this.h = 1;
        }
        return this.h == 1;
    }

    public void u(int i) {
        this.n = new com.bytedance.sdk.openadsdk.core.ja.u(i, true);
    }

    public void x(int i) {
        this.rh = i;
    }

    public void u(boolean z, SparseArray<Object> sparseArray) {
        com.bytedance.sdk.component.utils.k.nr("bstsdk", "bst(true) stat-quit, run new pl");
        this.sx = z;
        com.bytedance.sdk.openadsdk.core.b.u.u(true);
        Object obj = sparseArray == null ? null : sparseArray.get(23);
        if (obj instanceof Map) {
            this.xw = (Map) obj;
        }
        com.bytedance.sdk.openadsdk.core.b.fx.u();
    }

    public void fx(String str) {
        my(str);
        this.nr = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("sdk_version", d.b);
            this.q.put("com.byted.pangle", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.q.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.k.nr("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void u(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.q.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.nr;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put("app_id", str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.q.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    public void fx(boolean z) {
        this.b = z;
    }

    public boolean fx(int i) {
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            String str = fx.u.get("network_state", "");
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(",");
                if (strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (!TextUtils.isEmpty(str2) && String.valueOf(i).equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.t;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void u(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.nr);
                    u(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void u(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.t.clear();
            for (int i : iArr) {
                this.t.add(Integer.valueOf(i));
            }
        } catch (Throwable unused) {
        }
    }

    private static final String u(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject.toString();
    }

    public void u(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            String strU = com.bytedance.sdk.component.utils.b.u(bitmap);
            if (!TextUtils.isEmpty(strU)) {
                fx.u.put("pause_icon", strU);
            }
        }
        this.mv = bitmap;
    }

    public void u(Function<SparseArray<Object>, Object> function) {
        if (this.gi != null) {
            return;
        }
        this.gi = function;
    }

    public boolean u(Context context) {
        if (com.bytedance.sdk.openadsdk.core.bf.u.u().pn()) {
            this.d = 2;
        } else {
            this.d = 1;
        }
        return this.d == 1;
    }

    public void u(long j) {
        this.ja = j;
    }

    public void u(u.nr nrVar) {
        if (this.gi != null) {
            if (this.bf == null) {
                pn pnVar = new pn();
                this.bf = pnVar;
                pnVar.u(this.gi);
            }
            this.bf.u(nrVar);
        }
    }

    public void u(b bVar) {
        this.y = bVar;
    }
}
