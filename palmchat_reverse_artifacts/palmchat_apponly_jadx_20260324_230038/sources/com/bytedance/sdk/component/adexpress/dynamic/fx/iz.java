package com.bytedance.sdk.component.adexpress.dynamic.fx;

import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import com.wifi.ad.core.config.EventParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5083a;
    private boolean ay;
    private float b;
    private int bc;
    private String bf;
    private String bg;
    private String bq;
    private String c;
    private String cb;
    private boolean cj;
    private double d;
    private int dc;
    private List<String> dd;
    private boolean df;
    private boolean dj;
    private String dw;
    private String ec;
    private boolean eh;
    private int ex;
    private int f;
    private int fn;
    private float fx;
    private boolean gb;
    private int gc;
    private String ge;
    private int gi;
    private JSONObject gl;
    private double h;
    private boolean hm;
    private JSONObject hs;
    private int i;
    private int ic;
    private int iq;
    private float iz;
    private String j;
    private String ja;
    private int je;
    private boolean jf;
    private float jk;
    private String jn;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private int f5084jp;
    private boolean ju;
    private int jw;
    private String k;
    private JSONObject ki;
    private boolean kj;
    private int kw;
    private long ky = -1;
    private double l;
    private String lf;
    private int m;
    private String mh;
    private boolean mk;
    private String mv;
    private String my;
    private float n;
    private JSONObject nb;
    private float nr;
    private String o;
    private double oa;
    private String ob;
    private int p;
    private String pb;
    private boolean pn;
    private int pq;
    private String q;
    private String qb;
    private boolean qe;
    private String qf;
    private String qq;
    private int r;
    private List<u> rg;
    private String rh;
    private int rv;
    private String s;
    private int sf;
    private int su;
    private String sx;
    private double t;
    private int te;
    private String ti;
    private int tk;
    private int tm;
    private boolean tr;
    private float u;
    private int ua;
    private int uk;
    private int uq;
    private boolean v;
    private int w;
    private boolean wi;
    private int wj;
    private String wq;
    private String wu;
    private float x;
    private boolean xg;
    private boolean xh;
    private int xw;
    private int y;
    private boolean yd;
    private int z;
    private int za;
    private int zn;
    private double zq;
    private int zx;

    private void d(String str) {
        this.j = str;
    }

    public static iz u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        iz izVar = new iz();
        izVar.nr(jSONObject.optString("adType", "embeded"));
        izVar.k(jSONObject.optString("clickArea", ClickAreaSource.CREATIVE));
        izVar.my(jSONObject.optString("clickTigger", "click"));
        izVar.fx(jSONObject.optString("fontFamily", "PingFangSC"));
        izVar.b(jSONObject.optString("textAlign", "left"));
        izVar.pn(jSONObject.optString("color", "#999999"));
        izVar.iz(jSONObject.optString("bgColor", "transparent"));
        izVar.x(jSONObject.optString("bgImgUrl", ""));
        izVar.d(jSONObject.optString("bgImgData", ""));
        izVar.n(jSONObject.optString("borderColor", "#000000"));
        izVar.a(jSONObject.optString("borderStyle", "solid"));
        izVar.jk(jSONObject.optString("heightMode", "auto"));
        izVar.t(jSONObject.optString("widthMode", "fixed"));
        izVar.l(jSONObject.optString("interactText", ""));
        izVar.fx(jSONObject.optBoolean("isShowBgControl", false));
        izVar.mv(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            izVar.x(jSONObjectOptJSONObject.optInt("translateY", 0));
            izVar.n(jSONObjectOptJSONObject.optInt("translateX", 0));
            izVar.b(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            izVar.pn(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        izVar.s(jSONObject.optString("interactType", ""));
        izVar.pn(jSONObject.optInt("interactSlideDirection", -1));
        izVar.o(jSONObject.optString("justifyHorizontal", "space-around"));
        izVar.sx(jSONObject.optString("justifyVertical", "flex-start"));
        izVar.nr(jSONObject.optDouble("timingStart"));
        izVar.fx(jSONObject.optDouble("timingEnd"));
        izVar.b((float) jSONObject.optDouble("width", 0.0d));
        izVar.fx((float) jSONObject.optDouble("height", 0.0d));
        izVar.u((float) jSONObject.optDouble("borderRadius", 0.0d));
        izVar.nr((float) jSONObject.optDouble("borderSize", 0.0d));
        izVar.nr(jSONObject.optBoolean("interactValidate", false));
        izVar.a((float) jSONObject.optDouble("fontSize", 0.0d));
        izVar.pn((float) jSONObject.optDouble("paddingBottom", 0.0d));
        izVar.iz((float) jSONObject.optDouble("paddingLeft", 0.0d));
        izVar.x((float) jSONObject.optDouble("paddingRight", 0.0d));
        izVar.n((float) jSONObject.optDouble("paddingTop", 0.0d));
        izVar.b(jSONObject.optBoolean("lineFeed", false));
        izVar.a(jSONObject.optInt("lineCount", 0));
        izVar.iz(jSONObject.optDouble("lineHeight", 1.2d));
        izVar.s(jSONObject.optInt("letterSpacing", 0));
        izVar.pn(jSONObject.optBoolean("isDataFixed", false));
        izVar.k(jSONObject.optInt("fontWeight"));
        izVar.iz(jSONObject.optBoolean("lineLimit"));
        izVar.my(jSONObject.optInt(EventParams.KEY_CT_SDK_POSITION));
        izVar.bg(jSONObject.optString("align"));
        izVar.x(jSONObject.optBoolean("useLeft"));
        izVar.n(jSONObject.optBoolean("useRight"));
        izVar.a(jSONObject.optBoolean("useTop"));
        izVar.jk(jSONObject.optBoolean("useBottom"));
        izVar.bq(jSONObject.optString("data"));
        izVar.nr(jSONObject.optJSONObject("i18n"));
        izVar.l(jSONObject.optInt("marginLeft"));
        izVar.mv(jSONObject.optInt("marginRight"));
        izVar.jk(jSONObject.optInt("marginTop"));
        izVar.t(jSONObject.optInt("marginBottom"));
        izVar.o(jSONObject.optInt("tagMaxCount"));
        izVar.t(jSONObject.optBoolean("allowTextFlow"));
        izVar.sx(jSONObject.optInt("textFlowType"));
        izVar.bg(jSONObject.optInt("textFlowDuration"));
        izVar.bq(jSONObject.optInt("left"));
        izVar.dw(jSONObject.optInt("right"));
        izVar.c(jSONObject.optInt(Constant.MAP_KEY_TOP));
        izVar.q(jSONObject.optInt("bottom"));
        izVar.dw(jSONObject.optString("alignItems", "flex-start"));
        izVar.c(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, ""));
        izVar.u(jSONObject.optBoolean("loop", false));
        izVar.qq(jSONObject.optInt("zIndex"));
        izVar.h(jSONObject.optInt("interactVisibleTime"));
        izVar.kj(jSONObject.optInt("interactHiddenTime"));
        izVar.mv(jSONObject.optBoolean("interactEnableMask"));
        izVar.s(jSONObject.optBoolean("interactWontHide"));
        izVar.u(jSONObject.optString("bgGradient"));
        izVar.ja(jSONObject.optInt("areaType"));
        izVar.bf(jSONObject.optInt("interactSlideThreshold", 0));
        izVar.xg(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.b.u() ? 0 : 120));
        izVar.sx(jSONObject.optBoolean("openPlayableLandingPage", false));
        izVar.fx(jSONObject.optJSONObject("video"));
        izVar.b(jSONObject.optJSONObject("image"));
        izVar.wq(jSONObject.optInt("borderShadowExtent"));
        izVar.k(jSONObject.optBoolean("bgGauseBlur"));
        izVar.pb(jSONObject.optInt("bgGauseBlurRadius"));
        izVar.my(jSONObject.optBoolean("showTimeProgress", false));
        izVar.o(jSONObject.optBoolean("showPlayButton", false));
        izVar.u(jSONObject.optDouble("bgColorCg", 0.0d));
        izVar.iz(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        izVar.nr(jSONObject.optInt("borderTopLeftRadius", 0));
        izVar.u(jSONObject.optInt("borderTopRightRadius", 0));
        izVar.b(jSONObject.optInt("borderBottomLeftRadius", 0));
        izVar.fx(jSONObject.optInt("borderBottomRightRadius", 0));
        izVar.pn(jSONObject.optJSONObject("interactI18n"));
        izVar.qq(jSONObject.optString("imageObjectFit"));
        izVar.kj(jSONObject.optString("interactTitle"));
        izVar.rh(jSONObject.optInt("interactTextPositionTop"));
        izVar.q(jSONObject.optString("imageLottieTosPath"));
        izVar.l(jSONObject.optBoolean("animationsLoop"));
        izVar.z(jSONObject.optInt("lottieAppNameMaxLength"));
        izVar.d(jSONObject.optInt("lottieAdDescMaxLength"));
        izVar.gi(jSONObject.optInt("lottieAdTitleMaxLength"));
        izVar.gi(jSONObject.optString("imageFlipSlideType"));
        izVar.bg(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                izVar.nr(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    u uVar = new u();
                    uVar.fx(jSONObject2.optString("animationType"));
                    uVar.u(jSONObject2.optDouble("animationDuration"));
                    uVar.nr(jSONObject2.optDouble("animationScaleX"));
                    uVar.fx(jSONObject2.optDouble("animationScaleY"));
                    uVar.b(jSONObject2.optString("animationTimeFunction"));
                    uVar.b(jSONObject2.optDouble("animationDelay"));
                    uVar.iz(jSONObject2.optInt("animationIterationCount"));
                    uVar.pn(jSONObject2.optString("animationDirection"));
                    uVar.pn(jSONObject2.optDouble("animationInterval"));
                    uVar.u(jSONObject2.optInt("animationBorderWidth"));
                    uVar.u(jSONObject2.optLong("key"));
                    uVar.nr(jSONObject2.optInt("animationEffectWidth"));
                    uVar.fx(jSONObject2.optInt("animationSwing", 1));
                    uVar.b(jSONObject2.optInt("animationTranslateX"));
                    uVar.pn(jSONObject2.optInt("animationTranslateY"));
                    uVar.nr(jSONObject2.optString("animationRippleBackgroundColor"));
                    uVar.u(jSONObject2.optString("animationScaleDirection"));
                    uVar.x(jSONObject2.optInt("animationFadeStart"));
                    uVar.n(jSONObject2.optInt("animationFadeEnd"));
                    uVar.iz(jSONObject2.optString("animationFillMode"));
                    uVar.a(jSONObject2.optInt("animationBounceHeight"));
                    if (izVar.bg() > 0.0d) {
                        uVar.b(uVar.s() + izVar.bg());
                    }
                    arrayList2.add(uVar);
                }
                izVar.u(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                izVar.z(jSONObject.optString("triggerSlideDirection", "0"));
                izVar.u(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return izVar;
    }

    public int a() {
        return this.fn;
    }

    public boolean ay() {
        return this.cj;
    }

    public int b() {
        return this.iq;
    }

    public String bc() {
        return this.wq;
    }

    public int bf() {
        return this.z;
    }

    public double bg() {
        return this.t;
    }

    public double bq() {
        return this.l;
    }

    public String c() {
        return this.my;
    }

    public long cb() {
        return this.ky;
    }

    public int cj() {
        return this.f5084jp;
    }

    public String dc() {
        return this.ob;
    }

    public boolean df() {
        return this.hm;
    }

    public int dj() {
        return this.zn;
    }

    public String dw() {
        return this.k;
    }

    public boolean ec() {
        return this.tr;
    }

    public boolean eh() {
        return this.wi;
    }

    public int ex() {
        return this.uk;
    }

    public String f() {
        return this.lf;
    }

    public int fn() {
        return this.ua;
    }

    public int fx() {
        return this.ic;
    }

    public int gb() {
        List<u> list = this.rg;
        if (list == null) {
            return 0;
        }
        for (u uVar : list) {
            if ("translate".equals(uVar.a()) && uVar.x() < 0) {
                return -uVar.x();
            }
        }
        return 0;
    }

    public boolean gc() {
        return this.yd;
    }

    public int ge() {
        return this.p;
    }

    public String gi() {
        return this.dw;
    }

    public int gl() {
        return this.dc;
    }

    public String h() {
        return this.q;
    }

    public String hm() {
        return this.ti;
    }

    public String hs() {
        return this.ec;
    }

    public String i() {
        return this.wu;
    }

    public boolean ic() {
        return this.qe;
    }

    public int iq() {
        return this.i;
    }

    public JSONObject iz() {
        return this.gl;
    }

    public List<String> j() {
        return this.dd;
    }

    public boolean ja() {
        return this.kj;
    }

    public int je() {
        return this.sf;
    }

    public String jk() {
        return this.qb;
    }

    public String jn() {
        return this.cb;
    }

    public String jp() {
        return this.ja;
    }

    public int ju() {
        return this.f;
    }

    public int jw() {
        return this.tm;
    }

    public float k() {
        return this.x;
    }

    public boolean ki() {
        return this.gb;
    }

    public String kj() {
        return this.j;
    }

    public boolean kw() {
        return this.eh;
    }

    public String ky() {
        return ("flip".equals(this.qf) || "slide".equals(this.qf)) ? this.qf : "slide";
    }

    public float l() {
        return this.nr;
    }

    public int lf() {
        return this.su;
    }

    public String m() {
        return this.rh;
    }

    public double mh() {
        return this.oa;
    }

    public boolean mk() {
        return this.ay;
    }

    public boolean mv() {
        return this.pn;
    }

    public float my() {
        return this.n;
    }

    public double n() {
        return this.zq;
    }

    public String nb() {
        return this.mh;
    }

    public int nr() {
        return this.je;
    }

    public float o() {
        return this.f5083a;
    }

    public boolean oa() {
        return this.xg;
    }

    public int ob() {
        return this.kw;
    }

    public boolean p() {
        return this.v;
    }

    public double pb() {
        return this.d;
    }

    public int pn() {
        return this.wj;
    }

    public int pq() {
        return this.ex;
    }

    public String q() {
        return this.o;
    }

    public boolean qe() {
        return this.xh;
    }

    public boolean qf() {
        return this.jf;
    }

    public String qq() {
        return this.sx;
    }

    public void r() {
        u(this, this.ki);
    }

    public String rg() {
        return this.ge;
    }

    public String rh() {
        return this.qq;
    }

    public boolean rv() {
        return this.mk;
    }

    public float s() {
        return this.iz;
    }

    public int sf() {
        return this.jw;
    }

    public int su() {
        return this.xw;
    }

    public float sx() {
        return this.jk;
    }

    public float t() {
        return this.u;
    }

    public int te() {
        return this.pq;
    }

    public List<u> ti() {
        return this.rg;
    }

    public int tk() {
        return this.y;
    }

    public int tm() {
        return this.gc;
    }

    public int tr() {
        return this.r;
    }

    public int ua() {
        return this.zx;
    }

    public void uk() {
        u(this, this.hs);
    }

    public int uq() {
        return this.rv;
    }

    public int v() {
        return this.tk;
    }

    public int w() {
        return this.m;
    }

    public int wi() {
        return this.bc;
    }

    public boolean wj() {
        return this.dj;
    }

    public int wq() {
        return this.gi;
    }

    public boolean wu() {
        return this.df;
    }

    public int x() {
        return this.te;
    }

    public double xg() {
        return this.h;
    }

    public JSONObject xh() {
        return this.hs;
    }

    public String xw() {
        return this.pb;
    }

    public String y() {
        return this.bf;
    }

    public int yd() {
        return this.w;
    }

    public String z() {
        return this.bg;
    }

    public JSONObject za() {
        return this.nb;
    }

    public String zn() {
        return this.jn;
    }

    public int zq() {
        return this.uq;
    }

    public int zx() {
        return this.za;
    }

    public void a(float f) {
        this.jk = f;
    }

    public void b(int i) {
        this.wj = i;
    }

    public void bf(int i) {
        this.ua = i;
    }

    public void bg(String str) {
        this.mh = str;
    }

    public void bq(String str) {
        this.lf = str;
    }

    public void c(int i) {
        this.tm = i;
    }

    public String d() {
        return this.c;
    }

    public void dw(int i) {
        this.za = i;
    }

    public void fx(int i) {
        this.iq = i;
    }

    public void gi(int i) {
        this.r = i;
    }

    public void h(int i) {
        this.uq = i;
    }

    public void iz(int i) {
        this.fn = i;
    }

    public void ja(int i) {
        this.dc = i;
    }

    public void jk(String str) {
        this.dw = str;
    }

    public void k(String str) {
        this.ja = str;
    }

    public void kj(int i) {
        this.jw = i;
    }

    public void l(String str) {
        this.q = str;
    }

    public void mv(String str) {
        this.qq = str;
    }

    public void my(String str) {
        this.bf = str;
    }

    public void n(float f) {
        this.f5083a = f;
    }

    public void nr(int i) {
        this.ic = i;
    }

    public void o(String str) {
        this.wq = str;
    }

    public void pb(int i) {
        this.i = i;
    }

    public void pn(int i) {
        this.te = i;
    }

    public void q(int i) {
        this.rv = i;
    }

    public void qq(int i) {
        this.zx = i;
    }

    public void rh(int i) {
        this.pq = i;
    }

    public void s(String str) {
        this.rh = str;
    }

    public void sx(String str) {
        this.pb = str;
    }

    public void t(String str) {
        this.c = str;
    }

    public void wq(int i) {
        this.sf = i;
    }

    public void x(float f) {
        this.n = f;
    }

    public void xg(int i) {
        this.ex = i;
    }

    public void z(int i) {
        this.zn = i;
    }

    public void a(String str) {
        this.bq = str;
    }

    public void b(float f) {
        this.b = f;
    }

    public void bg(int i) {
        this.kw = i;
    }

    public void bq(int i) {
        this.f = i;
    }

    public void c(String str) {
        this.ob = str;
    }

    public void d(int i) {
        this.uk = i;
    }

    public void dw(String str) {
        this.ge = str;
    }

    public void fx(float f) {
        this.fx = f;
    }

    public void gi(String str) {
        this.qf = str;
    }

    public void iz(float f) {
        this.x = f;
    }

    public void jk(int i) {
        this.f5084jp = i;
    }

    public void k(int i) {
        this.tk = i;
    }

    public void kj(String str) {
        this.jn = str;
    }

    public void l(int i) {
        this.bc = i;
    }

    public void mv(int i) {
        this.xw = i;
    }

    public void my(int i) {
        this.su = i;
    }

    public void n(String str) {
        this.bg = str;
    }

    public void nr(float f) {
        this.nr = f;
    }

    public void o(int i) {
        this.gc = i;
    }

    public void pn(float f) {
        this.iz = f;
    }

    public void q(String str) {
        this.wu = str;
    }

    public void qq(String str) {
        this.ec = str;
    }

    public void s(int i) {
        this.w = i;
    }

    public void sx(int i) {
        this.p = i;
    }

    public void t(int i) {
        this.y = i;
    }

    public void x(String str) {
        this.sx = str;
    }

    public void z(String str) {
        this.cb = str;
    }

    public void a(int i) {
        this.m = i;
    }

    public void b(String str) {
        this.k = str;
    }

    public void bg(boolean z) {
        this.jf = z;
    }

    public void fx(double d) {
        this.l = d;
    }

    public void iz(String str) {
        this.o = str;
    }

    public void jk(boolean z) {
        this.eh = z;
    }

    public void k(boolean z) {
        this.qe = z;
    }

    public void l(boolean z) {
        this.xh = z;
    }

    public void mv(boolean z) {
        this.hm = z;
    }

    public void my(boolean z) {
        this.dj = z;
    }

    public void n(int i) {
        this.gi = i;
    }

    public void nr(boolean z) {
        this.pn = z;
    }

    public void o(boolean z) {
        this.tr = z;
    }

    public void pn(String str) {
        this.my = str;
    }

    public void s(boolean z) {
        this.gb = z;
    }

    public void sx(boolean z) {
        this.df = z;
    }

    public void t(boolean z) {
        this.mk = z;
    }

    public void x(int i) {
        this.z = i;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void b(double d) {
        this.d = d;
    }

    public void fx(String str) {
        this.s = str;
    }

    public void iz(double d) {
        this.oa = d;
    }

    public void n(boolean z) {
        this.ay = z;
    }

    public void nr(double d) {
        this.t = d;
    }

    public void pn(double d) {
        this.h = d;
    }

    public void x(boolean z) {
        this.yd = z;
    }

    public void b(boolean z) {
        this.xg = z;
    }

    public void fx(boolean z) {
        this.kj = z;
    }

    public void iz(boolean z) {
        this.wi = z;
    }

    public void nr(String str) {
        this.mv = str;
    }

    public void pn(boolean z) {
        this.cj = z;
    }

    public void b(JSONObject jSONObject) {
        this.hs = jSONObject;
    }

    public void fx(JSONObject jSONObject) {
        this.ki = jSONObject;
    }

    public void nr(JSONObject jSONObject) {
        this.nb = jSONObject;
    }

    public void pn(JSONObject jSONObject) {
        this.gl = jSONObject;
    }

    public void nr(List<String> list) {
        this.dd = list;
    }

    public boolean u() {
        return this.ju;
    }

    public void u(boolean z) {
        this.ju = z;
    }

    public void u(int i) {
        this.je = i;
    }

    public void u(double d) {
        this.zq = d;
    }

    public void u(String str) {
        this.qb = str;
    }

    public void u(float f) {
        this.u = f;
    }

    public void u(List<u> list) {
        this.rg = list;
    }

    public void u(long j) {
        this.ky = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void u(iz izVar, JSONObject jSONObject) {
        if (izVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        b = 11;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b = 12;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        b = dn.k;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = dn.l;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = 15;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = 16;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = 18;
                    }
                    break;
                case -962590849:
                    if (next.equals(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = 20;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = 21;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = 22;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        b = 23;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = 24;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = 25;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = 26;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = 27;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = 28;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = 29;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = 30;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        b = TELogUtils.DEBUG_LEVEL_V;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = 32;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 33;
                    }
                    break;
                case 115029:
                    if (next.equals(Constant.MAP_KEY_TOP)) {
                        b = 34;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 35;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b = 36;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 37;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 38;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 39;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 40;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b = 41;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b = 42;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 43;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 44;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 45;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 46;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        b = 47;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 48;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 49;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 50;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 51;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 52;
                    }
                    break;
                case 747804969:
                    if (next.equals(EventParams.KEY_CT_SDK_POSITION)) {
                        b = 53;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 54;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 55;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 56;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 57;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 58;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 59;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 60;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = 62;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = Utf8.REPLACEMENT_BYTE;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = 64;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = 65;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 66;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 67;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    izVar.fx(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    izVar.k(jSONObject.optString(next));
                    break;
                case 2:
                    izVar.z(jSONObject.optString(next));
                    break;
                case 3:
                    izVar.x(jSONObject.optString(next));
                    break;
                case 4:
                    izVar.a(jSONObject.optInt(next));
                    break;
                case 5:
                    izVar.sx(jSONObject.optBoolean(next));
                    break;
                case 6:
                    izVar.iz(jSONObject.optBoolean(next));
                    break;
                case 7:
                    izVar.mv(jSONObject.optString(next));
                    break;
                case 8:
                    izVar.iz((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    izVar.nr(jSONObject.optString(next));
                    break;
                case 10:
                    izVar.q(jSONObject.optInt(next));
                    break;
                case 11:
                    izVar.fx(jSONObject.optString(next));
                    break;
                case 12:
                    izVar.fx((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    izVar.b(jSONObject.optString(next));
                    break;
                case 14:
                    izVar.dw(jSONObject.optString(next));
                    break;
                case 15:
                    izVar.nr(jSONObject.optBoolean(next));
                    break;
                case 16:
                    izVar.jk(jSONObject.optInt(next));
                    break;
                case 17:
                    izVar.jk(jSONObject.optBoolean(next));
                    break;
                case 18:
                    izVar.u(jSONObject.optLong(next));
                    break;
                case 19:
                    izVar.c(jSONObject.optString(next));
                    break;
                case 20:
                    izVar.o(jSONObject.optInt(next));
                    break;
                case 21:
                    izVar.kj(jSONObject.optInt(next));
                    break;
                case 22:
                    izVar.a(jSONObject.optBoolean(next));
                    break;
                case 23:
                    izVar.k(jSONObject.optInt(next));
                    break;
                case 24:
                    izVar.qq(jSONObject.optInt(next));
                    break;
                case 25:
                    izVar.nr(jSONObject.optDouble(next));
                    break;
                case 26:
                    izVar.iz(jSONObject.optDouble(next));
                    break;
                case 27:
                    izVar.bg(jSONObject.optInt(next));
                    break;
                case 28:
                    izVar.n(jSONObject.optBoolean(next));
                    break;
                case 29:
                    izVar.t(jSONObject.optInt(next));
                    break;
                case 30:
                    izVar.iz(jSONObject.optString(next));
                    break;
                case 31:
                    izVar.s(jSONObject.optBoolean(next));
                    break;
                case 32:
                    izVar.x(jSONObject.optBoolean(next));
                    break;
                case 33:
                    izVar.t(jSONObject.optString(next));
                    break;
                case 34:
                    izVar.c(jSONObject.optInt(next));
                    break;
                case 35:
                    izVar.bq(jSONObject.optString(next));
                    break;
                case 36:
                    izVar.bq(jSONObject.optInt(next));
                    break;
                case 37:
                    izVar.u(jSONObject.optBoolean(next));
                    break;
                case 38:
                    izVar.n((float) jSONObject.optDouble(next));
                    break;
                case 39:
                    izVar.bg(jSONObject.optString(next));
                    break;
                case 40:
                    izVar.pn(jSONObject.optString(next));
                    break;
                case 41:
                    izVar.dw(jSONObject.optInt(next));
                    break;
                case 42:
                    izVar.b((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    izVar.fx(jSONObject.optDouble(next));
                    break;
                case 44:
                    izVar.pn((float) jSONObject.optDouble(next));
                    break;
                case 45:
                    izVar.t(jSONObject.optBoolean(next));
                    break;
                case 46:
                    izVar.s(jSONObject.optBoolean(next));
                    break;
                case 47:
                    izVar.a((float) jSONObject.optDouble(next));
                    break;
                case 48:
                    izVar.sx(jSONObject.optString(next));
                    break;
                case 49:
                    izVar.h(jSONObject.optInt(next));
                    break;
                case 50:
                    izVar.x((float) jSONObject.optDouble(next));
                    break;
                case 51:
                    izVar.n(jSONObject.optString(next));
                    break;
                case 52:
                    izVar.a(jSONObject.optString(next));
                    break;
                case 53:
                    izVar.my(jSONObject.optInt(next));
                    break;
                case 54:
                    izVar.pn(jSONObject.optBoolean(next));
                    break;
                case 55:
                    izVar.mv(jSONObject.optInt(next));
                    break;
                case 56:
                    izVar.o(jSONObject.optString(next));
                    break;
                case 57:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        izVar.x(jSONObjectOptJSONObject.optInt("translateY", 0));
                        izVar.n(jSONObjectOptJSONObject.optInt("translateX", 0));
                        izVar.b(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        izVar.pn(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 58:
                    izVar.b(jSONObject.optBoolean(next));
                    break;
                case 59:
                    izVar.l(jSONObject.optString(next));
                    break;
                case 60:
                    izVar.s(jSONObject.optString(next));
                    break;
                case 61:
                    izVar.u((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    izVar.my(jSONObject.optString(next));
                    break;
                case 63:
                    izVar.jk(jSONObject.optString(next));
                    break;
                case 64:
                    izVar.sx(jSONObject.optInt(next));
                    break;
                case 65:
                    izVar.nr((float) jSONObject.optDouble(next));
                    break;
                case 66:
                    izVar.l(jSONObject.optInt(next));
                    break;
                case 67:
                    izVar.s(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
