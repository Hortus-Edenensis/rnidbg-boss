package com.bytedance.sdk.openadsdk.s;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.g;
import com.oplus.tblplayer.Constants;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f5431a;
    private int ay;
    public final String b;
    private String bc;
    private long bf;
    private Set<String> bg;
    private List<JSONObject> bl;
    private String bq;
    private boolean c;
    private boolean cb;
    private int cj;
    private long d;
    private int dc;
    private String dd;
    private String df;
    private String dj;
    private String dw;
    private ViewTreeObserver.OnGlobalLayoutListener e;
    private int ec;
    private String eh;
    private JSONObject ex;
    private long f;
    private int fn;
    public final String fx;
    private float gb;
    private int gc;
    private u ge;
    private long gi;
    private float gl;
    private int h;
    private int hm;
    private String hs;
    private String i;
    private int ic;
    private int iq;
    private final String iz;
    private boolean j;
    private long ja;
    private int je;
    private String jf;
    private Runnable jk;
    private boolean jn;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private long f5432jp;
    private com.bytedance.sdk.component.mv.fx ju;
    private iz jw;
    private nr k;
    private String ki;
    private boolean kj;
    private long kw;
    private boolean ky;
    private final Handler l;
    private boolean lf;
    private long m;
    private int mh;
    private int mk;
    private Runnable mv;
    private boolean my;
    private final Handler n;
    private int nb;
    public final String nr;
    private boolean o;
    private String oa;
    private Context ob;
    private int p;
    private long pb;
    public final String pn;
    private int pq;
    private boolean q;
    private String qb;
    private String qe;
    private String qf;
    private boolean qq;
    private boolean r;
    private fx rg;
    private long rh;
    private int rv;
    private Runnable s;
    private JSONObject sf;
    private int su;
    private boolean sx;
    private Runnable t;
    private JSONObject te;
    private float ti;
    private int tk;
    private int tm;
    private Map<String, String> tr;
    public final String u;
    private int ua;
    private boolean uk;
    private com.bytedance.sdk.openadsdk.s.u uq;
    private int v;
    private String w;
    private boolean wi;
    private int wj;
    private long wq;
    private int wu;
    private boolean wv;
    private final String x;
    private long xg;
    private int xh;
    private String xw;
    private long y;
    private int yd;
    private String z;
    private JSONObject za;
    private String zn;
    private String zq;
    private WeakReference<View> zx;

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private n(Context context, com.bytedance.sdk.component.mv.fx fxVar, fx fxVar2, com.bytedance.sdk.openadsdk.s.u uVar, u uVar2, boolean z) {
        this.iz = "playable_stuck_check_ping";
        this.x = "playable_apply_media_permission_callback";
        this.n = new Handler(Looper.getMainLooper());
        this.l = new Handler(Looper.getMainLooper());
        this.my = true;
        this.o = true;
        this.sx = true;
        this.u = "PL_sdk_playable_global_viewable";
        this.nr = "PL_sdk_page_screen_blank";
        this.fx = "PL_sdk_playable_destroy_analyze_summary";
        this.b = "PL_sdk_playable_hardware_dialog_cancel";
        this.pn = "PL_sdk_playable_hardware_dialog_setting";
        this.bg = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.bq = null;
        this.dw = "embeded_ad";
        this.c = true;
        this.q = true;
        this.qq = true;
        this.kj = false;
        this.z = "";
        this.gi = 10L;
        this.d = 10L;
        this.h = 700;
        this.rh = 0L;
        this.ja = 0L;
        this.bf = -1L;
        this.wq = -1L;
        this.pb = -1L;
        this.xg = -1L;
        this.m = -1L;
        this.f5432jp = -1L;
        this.y = -1L;
        this.bc = "";
        this.xw = "";
        this.oa = "";
        this.w = "";
        this.cj = 0;
        this.tk = 0;
        this.wi = false;
        this.su = 0;
        this.mh = -1;
        this.yd = 0;
        this.ay = 0;
        this.v = 0;
        this.eh = null;
        this.lf = false;
        this.nb = 0;
        this.gc = 0;
        this.mk = 0;
        this.p = 0;
        this.kw = 0L;
        this.f = 0L;
        this.tm = -2;
        this.rv = 0;
        this.dc = 0;
        this.ua = 0;
        this.sf = new JSONObject();
        this.tr = new HashMap();
        this.ex = new JSONObject();
        this.hs = "";
        this.ti = 0.0f;
        this.gb = 0.0f;
        this.jn = false;
        this.j = false;
        this.wv = false;
        this.bl = new ArrayList();
        this.e = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.s.n.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) n.this.zx.get();
                    if (view == null) {
                        return;
                    }
                    n.this.nr(view);
                } catch (Throwable th) {
                    x.u("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.tm = 0;
        this.ge = uVar2;
        this.ju = fxVar;
        a.u(fxVar);
        if (!z) {
            u(fxVar.getView());
        }
        u(context, fxVar2, uVar);
    }

    private void jp() {
        Runnable runnable;
        Runnable runnable2;
        this.k.u(System.currentTimeMillis());
        Handler handler = this.l;
        if (handler != null) {
            int i = this.tm;
            if (i == 0 && (runnable2 = this.mv) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.s) != null) {
                handler.post(runnable);
            }
            this.k.u(500);
        }
    }

    public static /* synthetic */ int l(n nVar) {
        int i = nVar.cj;
        nVar.cj = i + 1;
        return i;
    }

    private void m() {
        String str;
        if (this.ex == null || (str = this.df) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.ex.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.df).getHost();
        if (TextUtils.isEmpty(host)) {
            this.df += "/cid_" + strOptString;
            return;
        }
        this.df = this.df.replace(host, host + "/cid_" + strOptString);
    }

    public static /* synthetic */ int mv(n nVar) {
        int i = nVar.tk;
        nVar.tk = i + 1;
        return i;
    }

    private void xg() {
        this.k = new nr(this, this.h);
        this.f5431a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.q) {
                    n.this.q = false;
                    n.this.n.removeCallbacks(n.this.jk);
                    n.this.u(2, "容器加载超时");
                }
            }
        };
        this.jk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.q) {
                    n.this.q = false;
                    n.this.n.removeCallbacks(n.this.f5431a);
                    n.this.u(3, "JSSDK加载超时");
                }
            }
        };
        this.mv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (n.this.ju != null) {
                    n.this.ju.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.s.n.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (n.this.k != null) {
                                n.this.k.u(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (n.this.l != null) {
                    n.this.l.postDelayed(this, 500L);
                }
            }
        };
        this.s = new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                n.this.u("playable_stuck_check_ping", new JSONObject());
                if (n.this.l != null) {
                    n.this.l.postDelayed(this, 500L);
                }
            }
        };
        this.t = new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.7
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.f <= 0) {
                    n.this.nr(1, "点击热区卡死");
                } else {
                    if (n.this.f - n.this.kw > n.this.h) {
                        n.this.nr(1, "点击热区卡死");
                        return;
                    }
                    n.this.rh();
                    n.this.kw = 0L;
                    n.this.f = 0L;
                }
            }
        };
    }

    public void bf() {
        this.dc = 0;
        this.ua = 0;
        this.gl = 0.0f;
        this.fn = 0;
        this.je = 0;
        this.ic = 0;
        this.iq = 0;
        this.wj = 0;
        this.ec = 0;
        this.pq = 0;
        this.hm = 0;
        this.wu = 0;
        this.xh = 0;
    }

    public JSONObject bg() {
        return this.ex;
    }

    public JSONObject bq() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.gl);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.fn);
            jSONObject2.put("height", this.je);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.iq);
            jSONObject3.put("y", this.ic);
            jSONObject3.put("width", this.wj);
            jSONObject3.put("height", this.ec);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.hm);
            jSONObject4.put("y", this.pq);
            jSONObject4.put("width", this.wu);
            jSONObject4.put("height", this.xh);
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, jSONObject4);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void c() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.m > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.m);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.pb > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.pb;
                this.y = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            fx("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void d() {
        nr nrVar;
        this.f = System.currentTimeMillis();
        int i = this.tm;
        if ((i == 1 || i == 2) && (nrVar = this.k) != null) {
            nrVar.u(System.currentTimeMillis());
        }
    }

    public void dw() {
        com.bytedance.sdk.openadsdk.s.u uVar = this.uq;
        if (uVar != null) {
            uVar.u();
        }
    }

    public Context getContext() {
        return this.ob;
    }

    public void gi() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.m > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.m);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.pb > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.pb);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            fx("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void h() {
        this.n.removeCallbacks(this.f5431a);
        this.n.removeCallbacks(this.jk);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.pb > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.pb);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            fx("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void ja() {
        try {
            nr nrVar = this.k;
            if (nrVar != null) {
                nrVar.u();
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public Intent k() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileU = pn.u();
        if (fileU == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.ob, this.ob.getPackageName() + ".playable.fileProvider", fileU));
        return intent;
    }

    public void kj() {
        if (this.uq != null) {
            u uVar = u.LAND_PAGE;
        }
    }

    public String my() {
        com.bytedance.sdk.openadsdk.s.u uVar;
        if (TextUtils.isEmpty(this.oa) && (uVar = this.uq) != null) {
            this.oa = uVar.b().toString();
        }
        return this.oa;
    }

    public com.bytedance.sdk.openadsdk.s.u o() {
        return this.uq;
    }

    public String pb() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public void q() {
        this.mh = 2;
    }

    public void qq() {
        this.lf = true;
    }

    public void rh() {
        if (this.qq) {
            this.f5432jp = System.currentTimeMillis();
            if (this.ge == u.FEED_AWEME) {
                if (this.uk && this.rv == 3) {
                    nr nrVar = this.k;
                    if (nrVar != null && nrVar.nr()) {
                        jp();
                        return;
                    } else {
                        if (this.k == null) {
                            this.k = new nr(this, this.h);
                            jp();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.uk && this.rv == 2) {
                nr nrVar2 = this.k;
                if (nrVar2 != null && nrVar2.nr()) {
                    jp();
                } else if (this.k == null) {
                    this.k = new nr(this, this.h);
                    jp();
                }
            }
        }
    }

    public JSONObject s() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.ge.ordinal());
            jSONObject.put("safe_area_top_height", this.ti);
            jSONObject.put("safe_area_bottom_height", this.gb);
            jSONObject.put("playable_enter_from", this.ay);
            jSONObject.put("playable_retry_count", this.yd);
            jSONObject.put("playable_card_session", this.bc);
            jSONObject.put("playable_video_session", this.xw);
            jSONObject.put("playable_network_type", my());
            jSONObject.put("aweme_id", this.w);
            return jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public JSONObject sx() {
        if (this.sf.isNull("width")) {
            View view = this.zx.get();
            if (view == null) {
                return this.sf;
            }
            nr(view);
        }
        return this.sf;
    }

    public void wq() {
        if (this.wv) {
            return;
        }
        this.wv = true;
        this.ja = 0L;
        this.o = true;
        bf();
        try {
            View view = this.zx.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.e);
            }
        } catch (Throwable unused) {
        }
        try {
            this.jw.nr();
        } catch (Throwable unused2) {
        }
        try {
            nr nrVar = this.k;
            if (nrVar != null) {
                nrVar.u();
                this.k = null;
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.df)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.cj);
                jSONObject.put("playable_hit_times", this.tk);
                int i = this.cj;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.tk) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                fx("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.df)) {
                if (this.bf != -1) {
                    this.rh += System.currentTimeMillis() - this.bf;
                    this.bf = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.rh);
                fx("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.n.removeCallbacks(this.f5431a);
        this.n.removeCallbacks(this.jk);
        this.n.removeCallbacksAndMessages(null);
    }

    public void z() {
        if (this.uq != null) {
            u uVar = u.LAND_PAGE;
        }
    }

    private boolean jk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.cb);
            return jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public String b() {
        return this.i;
    }

    public String fx() {
        return this.qe;
    }

    public String iz() {
        return this.zn;
    }

    public JSONObject l() {
        try {
            boolean zU = pn.u(this.ob, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zU);
            return jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject mv() {
        boolean zU;
        boolean zU2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zU = pn.u(this.ob, "android.permission.READ_MEDIA_IMAGES");
                zU2 = true;
            } else {
                zU = pn.u(this.ob, g.i);
                zU2 = pn.u(this.ob, g.j);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zU);
            jSONObject.put("isHasWrite", zU2);
            if (!zU || !zU2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public boolean n() {
        return this.uk;
    }

    public String pn() {
        return this.dj;
    }

    public JSONObject t() {
        try {
            boolean zU = pn.u(this.ob, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zU);
            return jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public boolean x() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.dc == view.getWidth() && this.ua == view.getHeight()) {
                return;
            }
            this.dc = view.getWidth();
            this.ua = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.dc);
            jSONObject.put("height", this.ua);
            u("resize", jSONObject);
            this.sf = jSONObject;
        } catch (Throwable th) {
            x.u("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public n b(String str) {
        this.zn = str;
        return this;
    }

    public n fx(String str) {
        this.dj = str;
        return this;
    }

    public void iz(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eh = jSONObject.optString("section");
        }
    }

    public Set<String> jk() {
        Set<String> setU = this.jw.u();
        Set<String> set = this.bg;
        if (set == null || set.size() <= 0) {
            return setU;
        }
        HashSet hashSet = new HashSet();
        for (String str : setU) {
            if (!this.bg.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public void n(JSONObject jSONObject) {
        nr(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public n pn(JSONObject jSONObject) {
        this.ex = jSONObject;
        return this;
    }

    public void x(JSONObject jSONObject) {
        this.za = jSONObject;
        this.v++;
        ja();
        this.n.removeCallbacks(this.t);
        if (this.qq) {
            this.f5432jp = System.currentTimeMillis();
            this.kw = System.currentTimeMillis();
            this.f = 0L;
            int i = this.tm;
            if (i == 0) {
                com.bytedance.sdk.component.mv.fx fxVar = this.ju;
                if (fxVar != null) {
                    fxVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.s.n.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            n.this.f = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                u("playable_stuck_check_ping", new JSONObject());
            }
            this.n.postDelayed(this.t, this.h);
        }
    }

    public void b(JSONObject jSONObject) {
        if (this.uq != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public n fx(boolean z) {
        this.cb = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.cb);
            u("change_playable_click", jSONObject);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public void iz(String str) {
        int i;
        int i2;
        this.rv = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.pb = jCurrentTimeMillis;
            long j = this.wq;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        fx("PL_sdk_html_load_start", jSONObject);
        if (this.c && ((i = this.tm) == 0 || i == 1 || i == 2)) {
            this.n.postDelayed(this.f5431a, this.gi * 1000);
            if (jk(this.df) || (i2 = this.tm) == 1 || i2 == 2) {
                this.n.postDelayed(this.jk, this.d * 1000);
            }
            this.c = false;
        }
        if (this.o) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (pn.u(this.ob, pn.l)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (pn.nr(this.ob, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (pn.u(this.ob, pn.t)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (pn.u(this.ob, pn.jk)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (pn.u(this.ob, pn.f5433a)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (pn.u(this.ob, pn.n)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (pn.nr(this.ob, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (pn.u(this.ob, pn.x)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (pn.u(this.ob)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                fx("PL_sdk_hardware_detect", jSONObject2);
                this.o = false;
            } catch (Throwable th2) {
                x.u("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public n pn(String str) {
        int iIndexOf;
        String strDecode;
        this.hs = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) && !BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(scheme)) {
                String host = uri.getHost();
                if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                    if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                        if (this.tm == -1) {
                            nr(2);
                        } else {
                            nr(1);
                        }
                    }
                } else {
                    nr(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf(Constants.STRING_VALUE_UNSET);
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                }
            } else {
                nr(0);
                if (str != null && (iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET)) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            }
        } catch (Throwable unused) {
        }
        this.df = str;
        return this;
    }

    private void u(Context context, fx fxVar, com.bytedance.sdk.openadsdk.s.u uVar) {
        this.bq = UUID.randomUUID().toString();
        this.ob = context;
        this.uq = uVar;
        this.rg = fxVar;
        jk.u(uVar);
        this.jw = new iz(this);
        xg();
    }

    public void n(String str) {
        this.n.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.10
            @Override // java.lang.Runnable
            public void run() {
                n.l(n.this);
            }
        });
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return t();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : mv();
        }
        return l();
    }

    public n b(boolean z) {
        this.qq = z;
        return this;
    }

    private String b(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.ki) && !TextUtils.isEmpty(this.hs)) {
            Uri uri = Uri.parse(this.hs);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.ki = builderAppendQueryParameter.toString();
        }
        return this.ki;
    }

    public void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.rv = 3;
                rh();
            } else {
                this.rv = -2;
            }
            if (zOptBoolean || !this.q) {
                return;
            }
            this.q = false;
            this.n.removeCallbacks(this.f5431a);
            this.n.removeCallbacks(this.jk);
            u(4, "素材渲染失败");
        }
    }

    public void fx(JSONObject jSONObject) throws Throwable {
        com.bytedance.sdk.openadsdk.s.u uVar = this.uq;
        if (uVar == null || uVar.u(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            nr(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            fx(strOptString2, strOptString);
        }
    }

    public JSONObject jk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt != 1) {
            if (iOptInt != 2) {
                if (iOptInt == 3) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", pn.u(this.ob));
                    } else {
                        jSONObject2.put("result", false);
                    }
                }
                return jSONObject2;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject2.put("result", pn.nr(this.ob, "android.permission.CAMERA"));
            } else {
                jSONObject2.put("result", false);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            jSONObject2.put("result", pn.nr(this.ob, "android.permission.RECORD_AUDIO"));
        } else {
            jSONObject2.put("result", false);
        }
        return jSONObject2;
    }

    public void a(String str) {
        this.n.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.mv(n.this);
            }
        });
    }

    public n nr(String str) {
        this.qe = str;
        return this;
    }

    public void u(View view) {
        if (view == null) {
            return;
        }
        try {
            this.zx = new WeakReference<>(view);
            nr(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public JSONObject nr() {
        return this.te;
    }

    public n nr(long j) {
        if (j <= 0) {
            this.d = 10L;
        } else {
            this.d = j;
        }
        return this;
    }

    public n nr(boolean z) {
        if (this.uk == z) {
            return this;
        }
        this.uk = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.uk) {
                jSONObject.put("playable_background_show_type", this.gc);
            }
        } catch (JSONException unused) {
        }
        fx(this.uk ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.wq == -1 && this.uk) {
            this.wq = System.currentTimeMillis();
            fx("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.wq != -1 && !this.uk && !this.jn) {
            this.jn = true;
        }
        if (this.uk) {
            this.bf = System.currentTimeMillis();
        } else if (this.bf != -1) {
            this.rh += System.currentTimeMillis() - this.bf;
            this.bf = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.uk);
            u("viewableChange", jSONObject2);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "setViewable error", th);
        }
        if (this.uk) {
            rh();
        } else {
            ja();
        }
        return this;
    }

    public n u(String str, String str2) {
        this.tr.put(str, str2);
        return this;
    }

    public void x(String str) {
        com.bytedance.sdk.component.mv.fx fxVar;
        this.rv = 2;
        this.zq = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.xg = jCurrentTimeMillis;
            long j = this.pb;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        fx("PL_sdk_html_load_finish", jSONObject);
        this.n.removeCallbacks(this.f5431a);
        try {
            if (this.tm == 0) {
                if (this.my && (fxVar = this.ju) != null) {
                    this.my = false;
                    fxVar.evaluateJavascript(pb(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.s.n.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                rh();
            }
        } catch (Throwable th2) {
            x.u("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void fx(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.ob, "视频保存失败", 0).show();
            return;
        }
        File fileU = pn.u(str, str2);
        if (fileU != null && fileU.exists()) {
            Uri uriFromFile = Uri.fromFile(fileU);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriFromFile);
            this.ob.sendBroadcast(intent);
            Toast.makeText(this.ob, "视频已保存到相册", 0).show();
            return;
        }
        Toast.makeText(this.ob, "视频保存失败", 0).show();
    }

    public Map<String, String> u() {
        return this.tr;
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectU = this.jw.u(str, jSONObject);
        if (x.u()) {
            System.currentTimeMillis();
        }
        return jSONObjectU;
    }

    public n u(String str) {
        this.i = str;
        return this;
    }

    public n u(boolean z) {
        this.r = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.r);
            u("volumeChange", jSONObject);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    private String pn(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.df = str3;
        return str3;
    }

    public n u(long j) {
        if (j <= 0) {
            this.gi = 10L;
        } else {
            this.gi = j;
        }
        return this;
    }

    private void pn(String str, JSONObject jSONObject) {
        try {
            int i = this.tm;
            if (i == 0) {
                if (this.ge != u.LAND_PAGE && !jk(this.df)) {
                    m();
                }
                jSONObject.put("playable_url", this.df);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", pn(this.jf, this.qb));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", b(this.qf, this.dd));
            }
            jSONObject.put("playable_render_type", this.tm);
            if (this.uq != null && this.tm == 0 && this.ge == u.LAND_PAGE) {
                jk(this.df);
            }
        } catch (JSONException unused) {
        }
    }

    public void u(JSONObject jSONObject) {
        if (this.uq != null) {
            k();
        }
    }

    private void fx(int i, String str) {
        com.bytedance.sdk.openadsdk.s.u uVar = this.uq;
        if (uVar != null) {
            uVar.u(i, str);
        }
    }

    public Intent u(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
        } else if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType("video/mp4");
        } else {
            intent.setType("*/*");
        }
        return intent;
    }

    public void fx(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.wi && this.tk > 0) {
                this.wi = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.uk);
            jSONObject.put("playable_session_id", this.bq);
            int i = this.tm;
            if (i == 0) {
                if (this.ge != u.LAND_PAGE && !jk(this.df)) {
                    m();
                }
                jSONObject.put("playable_url", this.df);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", pn(this.jf, this.qb));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", b(this.qf, this.dd));
            }
            jSONObject.put("playable_full_url", this.hs);
            jSONObject.put("playable_replay_count", this.su);
            jSONObject.put("playable_is_prerender", this.ky);
            jSONObject.put("playable_is_preload", this.wi);
            jSONObject.put("playable_render_type", this.tm);
            jSONObject.put("playable_scenes_type", this.ge.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.qf) ? "" : this.qf);
            if (!TextUtils.isEmpty(this.dd)) {
                str2 = this.dd;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.jf);
            jSONObject.put("playable_minigamelite_schema", this.qb);
            jSONObject.put("playable_is_debug", this.j);
            jSONObject.put("playable_retry_count", this.yd);
            jSONObject.put("playable_enter_from", this.ay);
            jSONObject.put("playable_sequence", this.v);
            jSONObject.put("playable_current_section", this.eh);
            jSONObject.put("is_playable_finish", this.lf);
            jSONObject.put("playable_card_session", this.bc);
            jSONObject.put("playable_video_session", this.xw);
            jSONObject.put("playable_network_type", my());
            jSONObject.put("playable_lynx_version", this.z);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.dw);
            jSONObject2.put("nt", 4);
            jSONObject2.put(com.huawei.openalliance.ad.constant.x.cw, BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put(ActionUtils.PAYMENT_AMOUNT, this.ex.opt("cid"));
            jSONObject2.put("log_extra", this.ex.opt("log_extra"));
            int i2 = this.tm;
            if (i2 != -1 && i2 != -2) {
                if (this.uq != null) {
                    List<JSONObject> list = this.bl;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.bl.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.tm);
                                jSONObjectOptJSONObject.put("playable_url", this.df);
                            }
                        }
                        this.bl.clear();
                    }
                    if (this.tm == 0 && this.ge == u.LAND_PAGE) {
                        jk(this.df);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.bl == null) {
                this.bl = new ArrayList();
            }
            this.bl.add(jSONObject2);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void u(String str, JSONObject jSONObject) {
        fx fxVar = this.rg;
        if (fxVar != null) {
            fxVar.u(str, jSONObject);
        }
    }

    public void u(int i, String str) {
        ja();
        fx(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "reportRenderFatal error", th);
        }
        fx("PL_sdk_global_faild", jSONObject);
    }

    public void nr(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            pn.fx = jSONObject.optInt("video_min_duration", 1);
            pn.b = jSONObject.optInt("video_max_duration", 20);
            pn.pn = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.uq != null) {
            u(iOptInt);
        }
    }

    public void u(int i, String str, String str2) {
        this.rv = -1;
        this.zq = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            x.u("PlayablePlugin", "onWebReceivedError error", th);
        }
        fx("PL_sdk_html_load_error", jSONObject);
        if (this.q) {
            this.q = false;
            this.n.removeCallbacks(this.f5431a);
            this.n.removeCallbacks(this.jk);
            u(1, "容器加载失败");
        }
    }

    public void nr(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.ob, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapNr = pn.nr(str2);
        if (bitmapNr != null) {
            MediaStore.Images.Media.insertImage(this.ob.getContentResolver(), bitmapNr, str, "");
            Toast.makeText(this.ob, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.ob, "照片保存失败", 0).show();
        }
    }

    public n nr(int i) {
        this.tm = i;
        return this;
    }

    public void nr(int i, String str) {
        this.mh = i;
        if (this.za == null) {
            this.za = new JSONObject();
        }
        try {
            this.za.put("playable_stuck_type", i);
            this.za.put("playable_stuck_reason", str);
            if (this.f5432jp > 0) {
                this.za.put("playable_stuck_duration", System.currentTimeMillis() - this.f5432jp);
            } else {
                this.za.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        fx("PL_sdk_page_stuck", this.za);
        ja();
        if (this.uq == null || i != 2) {
            return;
        }
        this.za = new JSONObject();
    }

    public void u(boolean z, String str, int i) {
        if (z) {
            this.rv = -1;
            this.zq = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                x.u("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            fx("PL_sdk_html_load_error", jSONObject);
            if (this.q) {
                this.q = false;
                this.n.removeCallbacks(this.f5431a);
                this.n.removeCallbacks(this.jk);
                u(1, "容器加载失败");
            }
        }
    }

    public void nr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pn(str, jSONObject);
    }

    public static n u(Context context, com.bytedance.sdk.component.mv.fx fxVar, fx fxVar2, com.bytedance.sdk.openadsdk.s.u uVar, Set<String> set, u uVar2, boolean z) {
        if (fxVar == null || fxVar2 == null || uVar == null) {
            return null;
        }
        return new n(context, fxVar, fxVar2, uVar, set, uVar2, z);
    }

    private n(Context context, com.bytedance.sdk.component.mv.fx fxVar, fx fxVar2, com.bytedance.sdk.openadsdk.s.u uVar, Set<String> set, u uVar2, boolean z) {
        this(context, fxVar, fxVar2, uVar, uVar2, z);
        this.bg = set;
    }
}
