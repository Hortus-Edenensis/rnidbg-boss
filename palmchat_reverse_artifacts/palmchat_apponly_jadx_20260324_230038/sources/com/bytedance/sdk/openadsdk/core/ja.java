package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.baidu.location.LocationConst;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.bq.u.m;
import com.bytedance.sdk.openadsdk.core.bq.u.xw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.nr.b;
import com.bytedance.sdk.openadsdk.core.widget.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dc;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.umeng.analytics.pro.dn;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ja implements com.bytedance.sdk.component.adexpress.pn.nr, rh.u, com.bytedance.sdk.openadsdk.core.bg.nr {
    private static volatile boolean ay;
    private static final Map<String, Boolean> fx;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<View> f5283a;
    private WeakReference<SSWebView> b;
    private boolean bc;
    private com.bytedance.sdk.openadsdk.iz.u bf;
    private JSONObject bq;
    private WeakReference<com.bytedance.sdk.openadsdk.core.dw.u> c;
    private x.u cj;
    private List<bc> d;
    private WeakReference<com.bytedance.sdk.openadsdk.core.bg.b> dw;
    private WeakReference<com.bytedance.sdk.openadsdk.core.dw.pn> eh;
    private WeakReference<com.bytedance.sdk.openadsdk.core.dw.iz> gi;
    private HashMap<String, a> h;
    private final WeakReference<Context> iz;
    private String jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f5284jp;
    private JSONObject kj;
    private String l;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.n.nr> mh;
    private bc mv;
    private String n;
    private String pb;
    private WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> q;
    private WeakReference<com.bytedance.sdk.openadsdk.jk.u> qq;
    private String s;
    private List<JSONObject> su;
    private SoftReference<com.bytedance.sdk.component.adexpress.nr.t> sx;
    private int t;
    private com.bytedance.sdk.openadsdk.core.ugeno.nr tk;
    protected Map<String, Object> u;
    private AtomicBoolean v;
    private JSONObject wi;
    private com.bytedance.sdk.component.u.o wq;
    private com.bytedance.sdk.openadsdk.core.bg.fx x;
    private com.bytedance.sdk.openadsdk.core.widget.u.u xg;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> yd;
    private WeakReference<com.bytedance.sdk.openadsdk.core.dw.nr> z;
    boolean nr = false;
    private boolean k = false;
    private boolean my = true;
    private boolean o = true;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.l bg = new com.bytedance.sdk.openadsdk.core.nativeexpress.l();
    private boolean rh = false;
    private boolean ja = false;
    private boolean m = false;
    private boolean y = false;
    private boolean xw = false;
    private boolean oa = false;
    private boolean w = false;
    private com.bytedance.sdk.component.utils.rh pn = new com.bytedance.sdk.component.utils.rh(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public JSONObject b;
        public String fx;
        public String nr;
        public int pn;
        public String u;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        fx = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
        ay = false;
    }

    public ja(Context context) {
        this.iz = new WeakReference<>(context);
    }

    private JSONObject bc() {
        View view;
        SSWebView sSWebView;
        try {
            view = this.f5283a.get();
            sSWebView = this.b.get();
        } catch (Throwable unused) {
        }
        if (view == null || sSWebView == null) {
            com.bytedance.sdk.component.utils.k.nr("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        }
        int[] iArrNr = y.nr(view);
        int[] iArrNr2 = y.nr(sSWebView);
        if (iArrNr != null && iArrNr2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", y.b(dw.getContext(), iArrNr[0] - iArrNr2[0]));
            jSONObject.put("y", y.b(dw.getContext(), iArrNr[1] - iArrNr2[1]));
            jSONObject.put(RXScreenCaptureService.KEY_WIDTH, y.b(dw.getContext(), view.getWidth()));
            jSONObject.put("h", y.b(dw.getContext(), view.getHeight()));
            jSONObject.put("isExist", true);
            return jSONObject;
        }
        com.bytedance.sdk.component.utils.k.nr("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
        return null;
    }

    private JSONObject cj() {
        return u(this.mv, this.v);
    }

    private void jp() {
        bc bcVar;
        WeakReference<SSWebView> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null || (bcVar = this.mv) == null) {
            return;
        }
        int iGz = bcVar.gz();
        int iAn = this.mv.an();
        int iQv = this.mv.qv();
        int iZq = this.mv.zq();
        int iKi = this.mv.ki();
        JSONObject jSONObjectXs = this.mv.xs();
        JSONObject jSONObjectOr = this.mv.or();
        JSONObject jSONObjectBi = this.mv.bi();
        this.b.get().setShakeValue(iGz);
        this.b.get().setDeepShakeValue(iAn);
        this.b.get().setWriggleValue(iQv);
        this.b.get().setTwistConfig(jSONObjectXs);
        this.b.get().setShakeInteractConf(jSONObjectOr);
        this.b.get().setTwistInteractConf(jSONObjectBi);
        this.b.get().setCalculationMethod(iZq);
        this.b.get().setCalculationTwistMethod(iKi);
    }

    private void k(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.nr> weakReference = this.z;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.z.get().u(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    private boolean m() {
        return n.o().tk();
    }

    private void mh() {
        if (this.x == null) {
            this.x = com.bytedance.sdk.openadsdk.core.bg.u.u(this, this.mv, this.xw);
        }
    }

    private void oa() {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.iz> weakReference = this.gi;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.gi.get().u();
    }

    private boolean su() {
        bc bcVar = this.mv;
        if (bcVar == null || bcVar.yy() == null || com.bytedance.sdk.openadsdk.core.y.q.nr(this.mv) || this.rh || this.mv.yy().optInt("parent_type") != 2) {
            return false;
        }
        int iJk = jp.jk(this.mv);
        if (iJk != 8 && iJk != 7) {
            return false;
        }
        this.rh = true;
        return true;
    }

    private void tk() {
        jw jwVarKg;
        Context context;
        bc bcVar = this.mv;
        if (bcVar != null && (jwVarKg = bcVar.kg()) != null && jwVarKg.nr() == 1 && jwVarKg.iz() == 1) {
            mh();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.iz;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.x.u(context, jSONObject, this.jk, this.t, this.k, true);
            u(jSONObject, false);
        }
    }

    private void w() {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.iz> weakReference = this.gi;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.gi.get().nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        Context context;
        List<bc> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.h = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.b;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.iz;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (bc bcVar : this.d) {
            this.h.put(bcVar.lk(), new a(context, bcVar, sSWebView, this.pb));
        }
    }

    private static List<String> xw() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private com.bytedance.sdk.component.mv.fx y() {
        WeakReference<SSWebView> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean yd() {
        return this.yd != null;
    }

    public boolean a() {
        bc bcVar = this.mv;
        return bcVar != null && bcVar.yd();
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = mv();
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            u(jSONObject, jp.jk(this.mv));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public int bf() {
        if (this.bg.l() == null) {
            return 0;
        }
        return this.bg.l().fx();
    }

    public void bg() {
        WeakReference<com.bytedance.sdk.openadsdk.jk.u> weakReference = this.qq;
        if (weakReference == null || weakReference.get() == null) {
            this.bg.t();
        } else {
            this.qq.get().u();
        }
    }

    public void bq() {
        u((JSONObject) null, new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.ja.12
            @Override // com.bytedance.sdk.openadsdk.core.dw.fx
            public void u(boolean z, List<bc> list, boolean z2) {
                ja.this.d = list;
                ja.this.wi();
                ja.this.dw();
            }
        });
    }

    public boolean c() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ja.this.iz(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ja.this.a(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.bg.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.u();
        }
        if (su()) {
            bq();
        }
    }

    public void dw() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", u(this.d));
            nr("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            t(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public Context getContext() {
        return this.iz.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        my(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.bq.toString();
        }
        try {
            JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.bq, new JSONObject(str));
            return jSONObjectU == null ? this.bq.toString() : jSONObjectU.toString();
        } catch (Exception unused) {
            return this.bq.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public String getTemplateInfo() {
        nr("getTemplateInfo", true);
        try {
            s();
            nr("getTemplateInfo", false);
            return this.bq.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String gi() {
        return jp.u(this.t);
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.bg.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.nr();
        }
        this.y = false;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.9
            @Override // java.lang.Runnable
            public void run() {
                if (ja.this.xg != null) {
                    com.bytedance.sdk.openadsdk.core.widget.u.u unused = ja.this.xg;
                }
            }
        });
    }

    public com.bytedance.sdk.component.u.o iz() {
        return this.wq;
    }

    public void ja() {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.q.get().u();
    }

    public WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> jk() {
        return this.q;
    }

    public void kj() {
        bc bcVar = this.mv;
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.fx(bcVar, this.iz.get(), gi());
    }

    public JSONObject l() {
        return this.wi;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ja.this.pn(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    public JSONObject mv() throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(this.mv, this.s);
    }

    public void my() {
        this.bg.n();
    }

    public void n(boolean z) {
        this.w = z;
    }

    public void o() {
        this.bg.b();
    }

    public void pb() {
        if (this.bg.l() != null) {
            this.bg.l().a();
        }
    }

    public int pn(boolean z) {
        if (!this.y && com.bytedance.sdk.openadsdk.core.kj.bf.u(this.mv) != 0 && z) {
            return 2;
        }
        if (this.f5284jp) {
            return 1;
        }
        return this.bc ? com.bytedance.sdk.openadsdk.core.kj.bf.u(this.mv) == 2 ? 2 : 1 : com.bytedance.sdk.openadsdk.core.kj.bf.u(this.mv) == 0 ? 1 : 2;
    }

    public boolean q() {
        bc bcVar = this.mv;
        return bcVar != null && com.bytedance.sdk.openadsdk.core.kj.bq.t(bcVar) == 1;
    }

    public void qq() {
        bc bcVar = this.mv;
        if (bcVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.iz.nr(bcVar, this.iz.get(), gi());
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            jk(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.bg.u(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.bytedance.sdk.openadsdk.core.qq.s.u().u(this.mv, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public void rh() {
        pn();
        com.bytedance.sdk.openadsdk.core.bg.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.fx();
        }
        WeakReference<SSWebView> weakReference = this.b;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.f5283a;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.iz;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.xg = null;
        this.tk = null;
    }

    public JSONObject s() {
        JSONObject jSONObject = this.bq;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (this.mv != null) {
            jSONObject.put("setting", cj());
            jSONObject.put("extension", this.mv.bl());
        }
        this.bq = jSONObject;
        return jSONObject;
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.qq.s.u().b(this.mv, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.8
            @Override // java.lang.Runnable
            public void run() {
                ja.this.k();
            }
        });
    }

    public void sx() {
        this.bg.pn();
    }

    public boolean t() {
        return this.nr;
    }

    public void wq() {
        WeakReference<com.bytedance.sdk.openadsdk.core.dw.pn> weakReference = this.eh;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eh.get().u();
    }

    public boolean x() {
        return this.oa;
    }

    public void xg() {
        this.bg.iz();
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        bc bcVar = this.mv;
        if (bcVar == null) {
            return jSONObject;
        }
        String strWu = bcVar.wu();
        if (TextUtils.isEmpty(strWu)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strWu);
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(JSONObject jSONObject) {
        com.bytedance.sdk.component.mv.fx fxVarY = y();
        if (fxVarY != null) {
            com.bytedance.sdk.component.utils.s.u(fxVarY, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")");
        }
    }

    private boolean my(JSONObject jSONObject) {
        if (this.bg.l() != null && jSONObject != null) {
            double dU = this.bg.l().u();
            int iNr = this.bg.l().nr();
            try {
                jSONObject.put("currentTime", dU / 1000.0d);
                jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, iNr);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void sx(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.bg.b> weakReference;
        com.bytedance.sdk.openadsdk.core.bg.b bVar;
        if (jSONObject == null || (weakReference = this.dw) == null || (bVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                bVar.u(false, null);
            } else {
                bVar.u(true, jSONArrayOptJSONArray);
            }
        } catch (Exception unused) {
            bVar.u(false, null);
        }
    }

    public void a(boolean z) {
        this.nr = z;
    }

    public boolean b() {
        WeakReference<SSWebView> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.b.get().J_();
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n fx() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference = this.yd;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ja iz(boolean z) {
        this.ja = z;
        return this;
    }

    public void jk(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.iz.u uVar = this.bf;
        if (uVar != null) {
            uVar.fx(jSONObject);
        }
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.ja.10
            @Override // java.lang.Runnable
            public void run() {
                double dOptDouble;
                double dOptDouble2;
                boolean z;
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                if (ja.this.sx == null || ja.this.sx.get() == null || jSONObject == null || ja.this.iz == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.nr.s sVar = new com.bytedance.sdk.component.adexpress.nr.s();
                sVar.u(1);
                try {
                    boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
                    if (jSONObjectOptJSONObject != null) {
                        dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                        dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
                    } else {
                        dOptDouble = 0.0d;
                        dOptDouble2 = 0.0d;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (jSONObjectOptJSONObject2 != null) {
                        float f = ((Context) ja.this.iz.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                        z = zOptBoolean;
                        double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                        d2 = dOptDouble2;
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                        if (ja.this.o(jSONObjectOptJSONObject2)) {
                            d = dOptDouble;
                            double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                            d4 = dOptDouble6;
                            double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                            d5 = dOptDouble5;
                            double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                            d3 = dOptDouble4;
                            double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                            if (dw.nr().uc()) {
                                sVar.u(y.nr(f, y.u(f2, (float) dOptDouble7)));
                                sVar.nr(y.nr(f, y.u(f2, (float) dOptDouble8)));
                                sVar.fx(y.nr(f, y.u(f2, (float) dOptDouble9)));
                                sVar.b(y.nr(f, y.u(f2, (float) dOptDouble10)));
                            } else {
                                sVar.u((float) dOptDouble7);
                                sVar.nr((float) dOptDouble8);
                                sVar.fx((float) dOptDouble9);
                                sVar.b((float) dOptDouble10);
                            }
                        } else {
                            d3 = dOptDouble4;
                            d4 = dOptDouble6;
                            d = dOptDouble;
                            d5 = dOptDouble5;
                        }
                        if (dw.nr().uc()) {
                            sVar.fx(y.nr(f, y.u(f2, (float) dOptDouble3)));
                            sVar.b(y.nr(f, y.u(f2, (float) d3)));
                            sVar.pn(y.nr(f, y.u(f2, (float) d5)));
                            sVar.iz(y.nr(f, y.u(f2, (float) d4)));
                        } else {
                            sVar.fx(dOptDouble3);
                            sVar.b(d3);
                            sVar.pn(d5);
                            sVar.iz(d4);
                        }
                    } else {
                        z = zOptBoolean;
                        d = dOptDouble;
                        d2 = dOptDouble2;
                    }
                    String strOptString = jSONObject.optString("msg", x.u(101));
                    int iOptInt = jSONObject.optInt("code", 101);
                    sVar.u(z);
                    sVar.u(d);
                    sVar.nr(d2);
                    sVar.u(strOptString);
                    sVar.nr(iOptInt);
                    ((com.bytedance.sdk.component.adexpress.nr.t) ja.this.sx.get()).u(sVar);
                } catch (Exception unused) {
                    sVar.nr(101);
                    sVar.u(x.u(101));
                    ((com.bytedance.sdk.component.adexpress.nr.t) ja.this.sx.get()).u(sVar);
                }
            }
        });
    }

    public boolean l(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", u(this.d));
        } catch (Exception unused) {
        }
        return true;
    }

    public JSONObject mv(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm;
        if (this.u != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (d.x()) {
                    try {
                        bc bcVar = this.mv;
                        if (bcVar != null && (nrVarTm = bcVar.tm()) != null) {
                            String strMv = nrVarTm.mv();
                            if (!TextUtils.isEmpty(strMv)) {
                                jSONObject2.putOpt("media_extra", strMv);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.u.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.k.u(e.toString());
            }
        }
        return jSONObject;
    }

    public bc n() {
        return this.mv;
    }

    public void t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.y.c.u(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    public void x(boolean z) {
        this.oa = z;
    }

    public void a(JSONObject jSONObject) {
        ja jaVar;
        SoftReference<com.bytedance.sdk.component.adexpress.nr.t> softReference;
        double dOptDouble;
        double d;
        double d2;
        double d3;
        double d4;
        String str;
        String str2;
        String str3;
        double d5;
        double d6;
        int i;
        int i2;
        JSONObject jSONObject2;
        double d7;
        double d8;
        SoftReference<com.bytedance.sdk.component.adexpress.nr.t> softReference2;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            String strOptString3 = jSONObject.optString("clickAreaId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            String strOptString4 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.kj.my.u(jSONObject.optString("clickScene"));
            jSONObject3.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject3.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject3.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                try {
                    double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                    double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                    double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                    double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                    double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                    double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                    double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                    double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                    double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                    dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                    d9 = dOptDouble2;
                    d = dOptDouble3;
                    d2 = dOptDouble4;
                    d3 = dOptDouble9;
                    d4 = dOptDouble10;
                    str = strOptString;
                    str2 = strOptString2;
                    str3 = strOptString4;
                    d5 = dOptDouble5;
                    d6 = dOptDouble6;
                    i = iOptInt;
                    i2 = iOptInt2;
                    jSONObject2 = jSONObject3;
                    d7 = dOptDouble7;
                    d8 = dOptDouble8;
                } catch (Exception unused) {
                    jaVar = this;
                    softReference = jaVar.sx;
                    if (softReference == null && softReference.get() != null) {
                        jaVar.sx.get().u(null, -1, null);
                        return;
                    } else {
                        tk();
                    }
                }
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                dOptDouble = -1.0d;
                str = strOptString;
                i = iOptInt;
                str2 = strOptString2;
                str3 = strOptString4;
                i2 = iOptInt2;
                jSONObject2 = jSONObject3;
                d7 = -1.0d;
                d6 = -1.0d;
                d5 = -1.0d;
                d8 = -1.0d;
            }
            try {
                com.bytedance.sdk.openadsdk.core.kj.q qVarU = new q.u().b((float) d9).fx((float) d).nr((float) d2).u((float) d5).nr((long) d6).u((long) d7).u((int) d8).nr((int) d3).fx((int) d4).b((int) dOptDouble).u(str2).nr(strOptString3).u(true).u((SparseArray<b.u>) null).u(jSONObject2).pn(str3).pn(i2).u();
                jaVar = this;
                int i3 = i;
                try {
                    if (!jaVar.u(str, i3, qVarU) && (softReference2 = jaVar.sx) != null && softReference2.get() != null) {
                        jaVar.sx.get().u(null, i3, qVarU);
                    } else {
                        tk();
                    }
                } catch (Exception unused2) {
                    softReference = jaVar.sx;
                    if (softReference == null) {
                    }
                    tk();
                }
            } catch (Exception unused3) {
                jaVar = this;
            }
        } catch (Exception unused4) {
            jaVar = this;
        }
    }

    public void iz(JSONObject jSONObject) {
        if (this.bg.l() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.bg.l().u(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.bytedance.sdk.openadsdk.core.qq.s.u().u(this.mv, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void n(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        String str;
        String str2;
        double d7;
        double d8;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            String strOptString3 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                str = strOptString;
                d9 = dOptDouble2;
                d = dOptDouble3;
                d7 = dOptDouble4;
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                str2 = strOptString2;
                d8 = dOptDouble5;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                dOptDouble = -1.0d;
                str = strOptString;
                str2 = strOptString2;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.kj.q qVarU = new q.u().b((int) d9).fx((int) d).nr((int) d7).u((int) d8).nr((long) d2).u((long) d3).u((int) d4).nr((int) d5).fx((int) d6).b((int) dOptDouble).u(strOptString3).u(true).u(jSONObject2).u((SparseArray<b.u>) null).pn(str2).pn(iOptInt2).u();
            SoftReference<com.bytedance.sdk.component.adexpress.nr.t> softReference = this.sx;
            if (softReference != null && softReference.get() != null) {
                this.sx.get().u(null, iOptInt, qVarU, x(jSONObject));
            }
            u(str, iOptInt, qVarU);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.nr.t> softReference2 = this.sx;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.sx.get().u(null, -1, null, 0);
        }
    }

    public JSONObject nr() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference = this.yd;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.yd.get().getCreativeVideoViewInfo();
    }

    public int x(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.mv.fx(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.mv.wj().u() == 2) {
            this.mv.fx(true);
        }
        return 1;
    }

    private void bg(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            bq(jSONObject);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.2
                @Override // java.lang.Runnable
                public void run() {
                    ja.this.bq(jSONObject);
                }
            });
        }
    }

    public void b(boolean z) {
        this.bc = z;
    }

    public void fx(boolean z) {
        this.f5284jp = z;
        this.y = z;
    }

    public void l(boolean z) {
        this.v = new AtomicBoolean(z);
    }

    public static void nr(boolean z) {
        ay = z;
    }

    public ja b(String str) {
        this.jk = str;
        return this;
    }

    public void jk(boolean z) {
        this.m = z;
    }

    public static JSONArray u(List<bc> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).et());
        }
        return jSONArray;
    }

    public ja b(JSONObject jSONObject) {
        this.bq = jSONObject;
        return this;
    }

    public ja fx(String str) {
        this.s = str;
        return this;
    }

    public ja nr(SSWebView sSWebView) {
        this.b = new WeakReference<>(sSWebView);
        return this;
    }

    public void pn() {
        com.bytedance.sdk.component.u.o oVar = this.wq;
        if (oVar == null) {
            return;
        }
        oVar.u();
        this.wq = null;
    }

    public void b(int i) {
        this.bg.nr(i);
    }

    public ja fx(int i) {
        this.t = i;
        return this;
    }

    public ja nr(String str) {
        this.n = str;
        return this;
    }

    public void t(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z ? 0 : 1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("TTAndroidObject", e.getMessage());
        }
        pn("visibleStateChange", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", bq.f.L);
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            bg(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void x(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                u uVar = new u();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        uVar.u = jSONObjectOptJSONObject.optString("__msg_type", null);
                        uVar.nr = jSONObjectOptJSONObject.optString("__callback_id", null);
                        uVar.fx = jSONObjectOptJSONObject.optString("func");
                        uVar.b = jSONObjectOptJSONObject.optJSONObject("params");
                        uVar.pn = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(uVar.u) && !TextUtils.isEmpty(uVar.fx)) {
                    Message messageObtainMessage = this.pn.obtainMessage(11);
                    messageObtainMessage.obj = uVar;
                    this.pn.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public ja fx(List<bc> list) {
        this.d = list;
        return this;
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.qq.s.u().b(this.mv, "stats_reward_full_deal_skip_video");
        this.bg.x();
    }

    public ja nr(List<JSONObject> list) {
        this.su = list;
        return this;
    }

    public void s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optString("cid");
        this.jk = jSONObject.optString("log_extra");
    }

    public void fx(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.iz.u uVar;
        if (jSONObject == null || (uVar = this.bf) == null) {
            return;
        }
        uVar.b(jSONObject);
    }

    public ja nr(int i) {
        this.k = true;
        return this;
    }

    public ja pn(String str) {
        this.l = str;
        return this;
    }

    public boolean iz(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || q();
    }

    public void nr(JSONObject jSONObject) {
        this.wi = jSONObject;
    }

    public void pn(JSONObject jSONObject) {
        if (this.bg.l() == null || jSONObject == null) {
            return;
        }
        try {
            this.bg.l().u(jSONObject.optBoolean(dc.C, false));
        } catch (Exception unused) {
        }
    }

    public ja u(String str) {
        this.pb = str;
        return this;
    }

    private void nr(String str, boolean z) {
        if (this.bf == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.bf.iz(str);
        } else {
            this.bf.x(str);
        }
    }

    public void fx(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.u.o oVar = this.wq;
            if (oVar != null) {
                oVar.u(str, jSONObject);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public ja u(boolean z) {
        this.xw = z;
        return this;
    }

    public ja u(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.k.nr("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        com.bytedance.sdk.component.u.o oVarNr = com.bytedance.sdk.component.u.o.u(sSWebView).u(new com.bytedance.sdk.openadsdk.a.u()).u("ToutiaoJSBridge").u(new com.bytedance.sdk.component.u.l() { // from class: com.bytedance.sdk.openadsdk.core.ja.1
            @Override // com.bytedance.sdk.component.u.l
            public <T> T u(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.u.l
            public <T> String u(T t) {
                return null;
            }
        }).u(m()).nr(true).u().nr();
        this.wq = oVarNr;
        com.bytedance.sdk.openadsdk.core.bq.u.q.u(oVarNr, this);
        com.bytedance.sdk.openadsdk.core.bq.u.iz.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.x.u(this.wq, this, this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.k.u(this.wq);
        com.bytedance.sdk.openadsdk.core.bq.u.gi.u(this.wq, sSWebView);
        com.bytedance.sdk.openadsdk.core.bq.u.n.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.l.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.jp.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.b.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.dw.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.sx.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.fx.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.u.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.pn.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.iz.u(this.wq, this);
        com.bytedance.sdk.openadsdk.a.u.nr.u(this.wq, this);
        jp();
        com.bytedance.sdk.openadsdk.core.bq.u.fx.u(this.wq, this.b.get(), this.n);
        com.bytedance.sdk.openadsdk.core.bq.u.h.u(this.wq, this.b.get(), this.n);
        com.bytedance.sdk.openadsdk.core.bq.u.nr.u(this.wq, this.b.get(), this.n);
        com.bytedance.sdk.openadsdk.core.bq.u.d.u(this.wq, this.b.get(), this.n);
        com.bytedance.sdk.openadsdk.core.bq.u.wq.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.c.u(this.wq, this);
        m.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.o.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.my.u(this.wq, this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.kj.u(this.wq, this.iz.get(), this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.t.u(this.wq, this.mv, this.su);
        com.bytedance.sdk.openadsdk.core.bq.u.z.u(this.wq, this, this.mh);
        com.bytedance.sdk.openadsdk.core.bq.u.bf.u(this.wq, this, this.mh);
        xw.u(this.wq, sSWebView, this);
        com.bytedance.sdk.openadsdk.core.bq.u.jk.u(this.wq, this.mv, this);
        com.bytedance.sdk.openadsdk.core.bq.u.s.u(this.wq, this.mv, this);
        com.bytedance.sdk.openadsdk.core.bq.u.bc.u(this.wq, this.cj);
        com.bytedance.sdk.openadsdk.core.bq.u.y.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.rh.u(this.wq, this.tk);
        com.bytedance.sdk.openadsdk.core.bq.u.ja.u(this.wq, this, this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.mv.u(this.wq, this.bq);
        com.bytedance.sdk.openadsdk.core.bq.u.a.u(this.wq, this.mv, this);
        com.bytedance.sdk.openadsdk.core.bq.u.u.u(this.wq, this.iz.get());
        com.bytedance.sdk.openadsdk.core.bq.u.pb.u(this.wq, this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.b.u(this.wq, this);
        com.bytedance.sdk.openadsdk.core.bq.u.bq.u(this.wq, this, this.iz.get(), this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.pn.u(this.wq);
        com.bytedance.sdk.openadsdk.core.bq.u.bg.u(this.wq);
        com.bytedance.sdk.openadsdk.core.bq.u.qq.u(this.wq, this, this.mv);
        com.bytedance.sdk.openadsdk.core.bq.u.xg.u(this.wq, this);
        return this;
    }

    public void pn(int i) {
        this.bg.b(i);
    }

    private void pn(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            bg(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void nr(final Uri uri) {
        long j;
        JSONObject jSONObjectMv;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ja.this.n(uri.toString());
                        }
                    });
                    return;
                }
                return;
            }
            String queryParameter = uri.getQueryParameter(com.huawei.openalliance.ad.constant.x.cw);
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (iz(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.kj.wq.nr(this.mv) && TextUtils.equals(queryParameter3, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK)) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter(ActionUtils.PAYMENT_AMOUNT));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j3 = j2;
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter(BaseConstants.EVENT_LABEL_EXTRA);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                u(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObjectMv = mv(jSONObject);
                    WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> weakReference = this.q;
                    if (weakReference != null && weakReference.get() != null) {
                        this.q.get().nr();
                    }
                } else {
                    jSONObjectMv = jSONObject;
                }
                com.bytedance.sdk.openadsdk.core.s.b.u(queryParameter, u(queryParameter2, queryParameter3), queryParameter3, j, j3, jSONObjectMv);
            }
        } catch (Exception unused4) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pn.nr
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.nr
    public void nr(String str, JSONObject jSONObject) {
        m();
        pn(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.bytedance.sdk.component.mv.fx fxVarY = y();
                    if (fxVarY != null) {
                        com.bytedance.sdk.component.utils.s.u(fxVarY, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                x(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject u() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference = this.yd;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.yd.get().getContainerInfo();
    }

    public void u(SSWebView.nr nrVar) {
        WeakReference<SSWebView> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null || nrVar == null) {
            return;
        }
        this.b.get().setOnShakeListener(nrVar);
    }

    public ja u(com.bytedance.sdk.openadsdk.core.ugeno.n.nr nrVar) {
        this.mh = new WeakReference<>(nrVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n nVar) {
        this.yd = new WeakReference<>(nVar);
        return this;
    }

    public void u(int i) {
        if (ay) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                nr("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.mv != null && b()) {
                com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.b = true;
            }
            nr("wobble_callback", (JSONObject) null);
        }
    }

    public ja u(com.bytedance.sdk.openadsdk.iz.u uVar) {
        this.bf = uVar;
        return this;
    }

    public ja u(View view) {
        this.f5283a = new WeakReference<>(view);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.dw.nr nrVar) {
        this.z = new WeakReference<>(nrVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.dw.iz izVar) {
        this.gi = new WeakReference<>(izVar);
        return this;
    }

    public ja u(bc bcVar) {
        this.mv = bcVar;
        return this;
    }

    public ja u(com.bytedance.sdk.component.adexpress.nr.t tVar) {
        this.sx = new SoftReference<>(tVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.nativeexpress.t tVar) {
        this.bg.u(tVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.bg.b bVar) {
        this.dw = new WeakReference<>(bVar);
        return this;
    }

    public ja u(JSONObject jSONObject) {
        this.kj = jSONObject;
        return this;
    }

    public ja u(Map<String, Object> map) {
        this.u = map;
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.dw.u uVar) {
        this.c = new WeakReference<>(uVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.core.dw.b bVar) {
        this.q = new WeakReference<>(bVar);
        return this;
    }

    public ja u(com.bytedance.sdk.openadsdk.jk.u uVar) {
        this.qq = new WeakReference<>(uVar);
        return this;
    }

    public void u(x.u uVar) {
        this.cj = uVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.nr nrVar) {
        this.tk = nrVar;
    }

    public static void u(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = xw().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put(WfConstant.EVENT_KEY_APP_NAME, com.bytedance.sdk.openadsdk.core.n.u.u());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.n.u.pn());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.core.n.u.nr());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.n.u.fx());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.n.u.b());
        jSONObject.put(EventParams.KEY_PARAM_NETTYPE, com.bytedance.sdk.openadsdk.core.n.u.iz());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.n.u.x());
        if (tk.u(i)) {
            jSONObject.put("themeStatus", n.o().ay());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:167:0x026d A[PHI: r3
      0x026d: PHI (r3v23 org.json.JSONObject) = (r3v19 org.json.JSONObject), (r3v24 org.json.JSONObject) binds: [B:166:0x026b, B:155:0x023f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject u(u uVar, int i) throws Exception {
        byte b;
        Context context;
        JSONObject jSONObjectBc;
        if (!NotificationCompat.CATEGORY_CALL.equals(uVar.u)) {
            return null;
        }
        m();
        JSONObject jSONObject = new JSONObject();
        String str = uVar.fx;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                b = !str.equals("subscribe_app_ad") ? (byte) -1 : (byte) 0;
                break;
            case -1752549500:
                if (str.equals("adInfoStash")) {
                    b = 1;
                    break;
                }
                break;
            case -1423303823:
                if (str.equals("adInfo")) {
                    b = 2;
                    break;
                }
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    b = 3;
                    break;
                }
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    b = 4;
                    break;
                }
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    b = 5;
                    break;
                }
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    b = 6;
                    break;
                }
                break;
            case -794273169:
                if (str.equals("appInfo")) {
                    b = 7;
                    break;
                }
                break;
            case -715147645:
                if (str.equals("getScreenSize")) {
                    b = 8;
                    break;
                }
                break;
            case -489318846:
                if (str.equals("getMaterialMeta")) {
                    b = 9;
                    break;
                }
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    b = 10;
                    break;
                }
                break;
            case -173752734:
                if (str.equals("getTeMaiAds")) {
                    b = 11;
                    break;
                }
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    b = 12;
                    break;
                }
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    b = dn.k;
                    break;
                }
                break;
            case 352242576:
                if (str.equals("getDownloadStatus")) {
                    b = dn.l;
                    break;
                }
                break;
            case 399543522:
                if (str.equals("getCloseButtonInfo")) {
                    b = 15;
                    break;
                }
                break;
            case 402955465:
                if (str.equals("isViewable")) {
                    b = 16;
                    break;
                }
                break;
            case 442647767:
                if (str.equals("sendReward")) {
                    b = 17;
                    break;
                }
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    b = 18;
                    break;
                }
                break;
            case 650209982:
                if (str.equals("getTemplateInfo")) {
                    b = 19;
                    break;
                }
                break;
            case 672928467:
                if (str.equals("cancel_download_app_ad")) {
                    b = 20;
                    break;
                }
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    b = 21;
                    break;
                }
                break;
            case 885131792:
                if (str.equals("getVolume")) {
                    b = 22;
                    break;
                }
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    b = 23;
                    break;
                }
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    b = 24;
                    break;
                }
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    b = 25;
                    break;
                }
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    b = 26;
                    break;
                }
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    b = 27;
                    break;
                }
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    b = 28;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                mh();
                WeakReference<Context> weakReference = this.iz;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    this.x.u(context, uVar.b, this.jk, this.t, this.k, this.w);
                }
                break;
            case 1:
                s(uVar.b);
                break;
            case 2:
                jSONObject = mv();
                break;
            case 3:
                oa();
                break;
            case 4:
                iz(uVar.b);
                break;
            case 5:
                fx(uVar.b);
                break;
            case 6:
                a(uVar.b);
                break;
            case 7:
                u(jSONObject, jp.jk(this.mv));
                break;
            case 8:
                WeakReference<com.bytedance.sdk.openadsdk.core.dw.u> weakReference2 = this.c;
                com.bytedance.sdk.openadsdk.core.dw.u uVar2 = weakReference2 != null ? weakReference2.get() : null;
                if (uVar2 != null) {
                    int iNr = uVar2.nr();
                    int iU = uVar2.u();
                    jSONObject.put("width", iNr);
                    jSONObject.put("height", iU);
                }
                break;
            case 9:
                l(jSONObject);
                break;
            case 10:
                sx(uVar.b);
                break;
            case 11:
                jSONObjectBc = this.kj;
                if (jSONObjectBc != null) {
                    jSONObject = jSONObjectBc;
                }
                break;
            case 12:
                jk(true);
                JSONObject jSONObject2 = uVar.b;
                u(uVar.b, jSONObject2 != null ? jSONObject2.optBoolean("is_compliant_download") : false);
                break;
            case 13:
                com.bytedance.sdk.openadsdk.core.bg.fx fxVar = this.x;
                if (fxVar != null) {
                    fxVar.u(uVar.b);
                }
                break;
            case 14:
                jSONObject = com.bytedance.sdk.openadsdk.core.bq.u.k.u(uVar.b);
                break;
            case 15:
                jSONObjectBc = bc();
                if (jSONObjectBc != null) {
                }
                break;
            case 16:
                jSONObject.put("viewStatus", this.ja ? 1 : 0);
                break;
            case 17:
                this.nr = true;
                JSONObject jSONObject3 = uVar.b;
                int iOptInt = jSONObject3 != null ? jSONObject3.optInt(MediationConstant.KEY_REWARD_TYPE) : 0;
                WeakReference<com.bytedance.sdk.openadsdk.core.dw.b> weakReference3 = this.q;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.q.get().u(iOptInt);
                }
                this.bg.fx(iOptInt);
                break;
            case 18:
                t(uVar.b);
                break;
            case 19:
                s();
                jSONObject = this.bq;
                break;
            case 20:
                com.bytedance.sdk.openadsdk.core.bg.fx fxVar2 = this.x;
                if (fxVar2 != null) {
                    fxVar2.nr(uVar.b);
                }
                break;
            case 21:
                my(jSONObject);
                break;
            case 22:
                AudioManager audioManager = (AudioManager) dw.getContext().getSystemService("audio");
                jSONObject.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 23:
                w();
                break;
            case 24:
                pn(uVar.b);
                break;
            case 25:
                jk(uVar.b);
                break;
            case 26:
                k(uVar.b);
                break;
            case 27:
                u(uVar, jSONObject);
                break;
            case 28:
                k();
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(uVar.nr)) {
            b(uVar.nr, jSONObject);
            m();
        }
        return jSONObject;
    }

    public void u(float f) {
        if (this.bg.l() == null) {
            return;
        }
        try {
            this.bg.l().u(f);
        } catch (Exception unused) {
        }
    }

    public void u(float f, float f2, float f3, float f4, int i) {
        this.bg.u(f, f2, f3, f4, i);
    }

    public static JSONObject u(bc bcVar, AtomicBoolean atomicBoolean) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (dw.nr() == null) {
            return jSONObject;
        }
        try {
            int iT = jp.t(bcVar);
            int iJk = jp.jk(bcVar);
            boolean z2 = true;
            int iB = com.bytedance.sdk.openadsdk.core.kj.ja.nr(true, bcVar, true) ? 0 : dw.nr().b(iT);
            int iPn = (com.bytedance.sdk.openadsdk.core.kj.ja.nr(false, bcVar, true) || (com.bytedance.sdk.openadsdk.core.kj.gi.u(bcVar) && com.bytedance.sdk.openadsdk.core.kj.gi.nr(bcVar) > 0)) ? 0 : dw.nr().pn(iT);
            boolean zPn = dw.nr().pn(String.valueOf(iT));
            if (atomicBoolean != null) {
                z = atomicBoolean.get();
            } else {
                z = bcVar.jn() == 1;
            }
            jSONObject.put("ad_slot_type", iJk);
            jSONObject.put("voice_control", z);
            jSONObject.put("rv_skip_time", iB);
            jSONObject.put("fv_skip_show", zPn);
            jSONObject.put("iv_skip_time", iPn);
            if (bcVar == null || !bcVar.uo()) {
                z2 = false;
            }
            jSONObject.put("show_dislike", z2);
            jSONObject.put("video_adaptation", bcVar != null ? bcVar.kw() : 0);
            jSONObject.put("h5_cache_resources_enable", com.bytedance.sdk.openadsdk.core.kj.d.u);
            jSONObject.put("dark_mode_config", tk.u());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void u(final u uVar, final JSONObject jSONObject) {
        if (uVar == null) {
            return;
        }
        try {
            u(uVar.b, new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.ja.11
                @Override // com.bytedance.sdk.openadsdk.core.dw.fx
                public void u(boolean z, List<bc> list, boolean z2) {
                    if (!z) {
                        ja.this.b(uVar.nr, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", ja.u(list));
                        ja.this.b(uVar.nr, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean u(String str, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        HashMap<String, a> map;
        a aVar;
        if (TextUtils.isEmpty(str) || (map = this.h) == null || (aVar = map.get(str)) == null) {
            return false;
        }
        aVar.u(i, qVar);
        return true;
    }

    public void u(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.dw.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.gi.nr.u(this.mv, jSONObject, fxVar, (com.bytedance.sdk.openadsdk.my.fx.fx.nr) null);
    }

    public boolean u(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (fx.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u(bc bcVar, int i) {
        WeakReference<Context> weakReference = this.iz;
        if (weakReference == null || bcVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.iz.get();
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(context, bcVar, this.pb, this.t);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).nr(true);
        com.bytedance.sdk.component.t.pn.u.u().u(bcVar.hashCode() + bcVar.xx()).put("live_saas_interaction_type", Integer.valueOf(i));
        final String strLk = bcVar.lk();
        com.bytedance.sdk.openadsdk.core.l.nr.b bVarNr = com.bytedance.sdk.openadsdk.core.l.n.nr(context, bcVar, this.pb, false);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u((com.bytedance.sdk.openadsdk.core.l.nr.fx) bVarNr);
        uVar.u(null, new com.bytedance.sdk.openadsdk.core.kj.jk());
        if (bVarNr != null) {
            bVarNr.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.ja.4
                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void fx(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void nr(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u() {
                    u.C0239u.u(strLk, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(long j, String str, String str2) {
                    u.C0239u.u(strLk, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(String str, String str2) {
                    u.C0239u.u(strLk, 6, 100);
                }
            });
        }
        if (yd()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference2 = this.yd;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.yd.get().b();
            return;
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.n.nr) {
            ((com.bytedance.sdk.openadsdk.core.n.nr) context).u(1);
        }
    }

    public void u(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        JSONObject jSONObject2;
        String str2 = "click";
        String strNr = "";
        try {
            if (bq.b.V.equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str2 = bq.b.V;
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray("click_url");
            } else {
                str2 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strFx = sx.fx();
                if (TextUtils.isEmpty(strFx)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String strOptString5 = jSONObject.optString("log_extra");
                try {
                    jSONObject2 = new JSONObject(strOptString5);
                    strOptString = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                    try {
                        strOptString2 = jSONObject2.optString("creative_id");
                    } catch (Throwable unused) {
                        strOptString2 = "";
                        strOptString3 = strOptString2;
                        strOptString4 = strOptString3;
                        HashMap map = new HashMap();
                        map.put("aid", strOptString);
                        map.put("cid", strOptString2);
                        map.put(ReportItem.RequestKeyRequestId, strOptString3);
                        map.put("customer_id", strOptString4);
                        com.bytedance.sdk.openadsdk.core.qq.nr.u(strFx, arrayList, true, map, com.bytedance.sdk.openadsdk.core.s.b.u(strOptString5, strOptString, strOptString3, strNr, str2));
                    }
                } catch (Throwable unused2) {
                    strOptString = "";
                    strOptString2 = strOptString;
                }
                try {
                    strOptString3 = jSONObject2.optString(ReportItem.RequestKeyRequestId);
                    try {
                        strOptString4 = jSONObject2.optString("customer_id");
                        try {
                            strNr = jp.nr(jSONObject2.optInt("ad_slot_type"));
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                        strOptString4 = "";
                    }
                } catch (Throwable unused5) {
                    strOptString3 = "";
                    strOptString4 = strOptString3;
                }
                HashMap map2 = new HashMap();
                map2.put("aid", strOptString);
                map2.put("cid", strOptString2);
                map2.put(ReportItem.RequestKeyRequestId, strOptString3);
                map2.put("customer_id", strOptString4);
                com.bytedance.sdk.openadsdk.core.qq.nr.u(strFx, arrayList, true, map2, com.bytedance.sdk.openadsdk.core.s.b.u(strOptString5, strOptString, strOptString3, strNr, str2));
            }
        } catch (Throwable unused6) {
        }
    }

    public String u(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && com.huawei.openalliance.ad.constant.x.df.equals(str)) || this.sx != null || yd()) ? str : jp.u(this.t);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof u) {
                try {
                    u((u) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void u(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.bg.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.u(str, z);
        }
    }

    public void u(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.x == null || (weakReference = this.iz) == null || weakReference.get() == null) {
            return;
        }
        this.x.u(this.o && this.my);
        this.x.nr(z);
        this.x.u(this.iz.get(), jSONObject, this.pb, this.jk);
    }

    public void u(com.bytedance.sdk.openadsdk.core.dw.pn pnVar) {
        this.eh = new WeakReference<>(pnVar);
    }

    public void u(int i, int i2) {
        int iFx = y.fx(dw.getContext(), i);
        int iFx2 = y.fx(dw.getContext(), i2);
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference = this.yd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.yd.get().u(Integer.MIN_VALUE, Integer.MIN_VALUE, iFx, iFx2);
    }

    public void u(int i, int i2, int i3, int i4) {
        int iFx;
        int iFx2;
        int iFx3;
        int iFx4 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            iFx = Integer.MIN_VALUE;
            iFx2 = Integer.MIN_VALUE;
        } else {
            iFx = y.fx(dw.getContext(), i);
            iFx2 = y.fx(dw.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            iFx3 = Integer.MIN_VALUE;
        } else {
            iFx4 = y.fx(dw.getContext(), i3);
            iFx3 = y.fx(dw.getContext(), i4);
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n> weakReference = this.yd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.yd.get().u(iFx, iFx2, iFx4, iFx3);
    }
}
