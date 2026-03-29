package com.bytedance.adsdk.ugeno.nr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.adsdk.ugeno.fx.jk;
import com.bytedance.adsdk.ugeno.fx.mv;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.nr.b;
import com.bytedance.adsdk.ugeno.fx.nr.iz;
import com.bytedance.adsdk.ugeno.fx.nr.pn;
import com.bytedance.adsdk.ugeno.fx.o;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.fx.x;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.iz.u;
import com.bytedance.adsdk.ugeno.nr.u;
import com.bytedance.adsdk.ugeno.u;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class fx<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.fx, sx.nr, sx.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected s f5034a;
    private long ad;
    protected boolean ay;
    protected JSONObject b;
    protected float bc;
    protected boolean bf;
    protected float bg;
    private boolean bl;
    protected float bq;
    protected boolean c;
    private boolean cb;
    protected float cj;
    protected float d;
    protected float dc;
    private boolean dd;
    protected u.C0170u df;
    protected x dj;
    protected float dw;
    private boolean e;
    private com.bytedance.adsdk.ugeno.fx.u ec;
    protected float eh;
    protected boolean ex;
    protected com.bytedance.adsdk.ugeno.u.u f;
    private boolean fn;
    protected JSONObject fx;
    private boolean gb;
    protected int gc;
    protected float ge;
    protected float gi;
    private boolean gl;
    protected float h;

    @Deprecated
    private com.bytedance.adsdk.ugeno.fx.nr.nr hm;
    private boolean hs;
    protected sx i;
    private boolean ic;
    private GradientDrawable iq;
    protected u<ViewGroup> iz;
    private boolean j;
    protected boolean ja;
    private boolean je;
    private boolean jf;
    protected boolean jk;
    private boolean jn;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    protected String f5035jp;
    protected float ju;
    protected float jw;
    protected float k;
    private boolean ki;
    protected boolean kj;
    protected ViewGroup.LayoutParams kw;
    private c ky;
    protected String l;
    protected int lf;
    protected int m;
    protected boolean mh;
    protected float mk;
    protected float mv;
    private float mx;
    protected float my;
    protected a.u n;
    protected String nb;
    protected Context nr;
    protected float o;
    protected boolean oa;
    protected float ob;
    protected boolean p;
    protected boolean pb;
    protected T pn;

    @Deprecated
    private iz pq;
    protected boolean q;
    private boolean qb;
    protected bq qe;
    private boolean qf;
    protected boolean qq;
    private mv r;
    protected float rg;
    protected float rh;
    protected float rv;
    protected float s;
    protected jk sf;
    protected float su;
    protected float sx;
    protected String t;
    private boolean te;
    private boolean ti;
    protected float tk;
    protected float tm;
    protected Map<Integer, my> tr;
    private boolean u;
    protected float ua;
    private String uk;
    protected float uq;
    protected boolean v;
    private boolean vp;
    protected float w;
    protected float wi;
    private String wj;
    protected boolean wq;

    @Deprecated
    private com.bytedance.adsdk.ugeno.fx.nr.fx wu;
    private JSONObject wv;
    protected u<ViewGroup> x;
    protected boolean xg;

    @Deprecated
    private pn xh;
    protected boolean xw;
    protected ImageView.ScaleType y;
    protected boolean yd;
    protected float z;
    protected com.bytedance.adsdk.ugeno.u.iz za;

    @Deprecated
    private b.u zn;
    protected com.bytedance.adsdk.ugeno.pn.a zq;
    private com.bytedance.adsdk.ugeno.pn.u.u zu;
    protected float zx;

    public fx(Context context) {
        this(context, null);
    }

    private void ay() {
        my myVar;
        if (this.i == null || !u(18) || (myVar = this.tr.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectFx = myVar.fx();
        if (jSONObjectFx != null) {
            try {
                jSONObjectFx.put("rotateZ", com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("rotateZ"), this.b));
            } catch (JSONException unused) {
            }
        }
        this.i.u(myVar, this, this);
    }

    private void eh() {
        if (TextUtils.equals("dashed", this.nb)) {
            GradientDrawable gradientDrawable = this.iq;
            float f = this.eh;
            gradientDrawable.setStroke((int) f, this.lf, 3.0f * f, f);
        } else {
            if (!TextUtils.equals("dotted", this.nb)) {
                this.iq.setStroke((int) this.eh, this.lf);
                return;
            }
            GradientDrawable gradientDrawable2 = this.iq;
            float f2 = this.eh;
            gradientDrawable2.setStroke((int) f2, this.lf, f2 / 2.0f, f2);
        }
    }

    private void lf() {
        float f = this.mh ? this.cj : this.w;
        float f2 = this.yd ? this.wi : this.w;
        float f3 = this.ay ? this.tk : this.w;
        float f4 = this.v ? this.su : this.w;
        this.iq.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    @Deprecated
    private void n() {
        b bVarB;
        this.pn.setVisibility(this.gc);
        float f = this.dc;
        if (f != 0.0f) {
            this.pn.setRotation(f);
        }
        a.u uVar = this.n;
        if (uVar != null && TextUtils.isEmpty(uVar.nr())) {
            this.pn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.nr.fx.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fx fxVar = fx.this;
                    if (fxVar.sf == null || !fxVar.qb) {
                        return;
                    }
                    fx fxVar2 = fx.this;
                    fxVar2.sf.u(fxVar2);
                }
            });
        } else if (u(1) && !this.jn) {
            this.pn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.nr.fx.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fx fxVar = fx.this;
                    if (fxVar.i == null || !fxVar.qb) {
                        return;
                    }
                    fx fxVar2 = fx.this;
                    sx sxVar = fxVar2.i;
                    my myVar = fxVar2.tr.get(1);
                    fx fxVar3 = fx.this;
                    sxVar.u(myVar, fxVar3, fxVar3);
                }
            });
        }
        if (this.i != null && u(4)) {
            if (u(1)) {
                this.cb = true;
                this.xh = new pn(this.nr, this.tr.get(4), this.tr.get(1), this.cb, yd());
            } else {
                this.xh = new pn(this.nr, this.tr.get(4), this.cb, yd());
            }
        }
        if (this.i != null && u(1) && this.jn) {
            this.wu = new com.bytedance.adsdk.ugeno.fx.nr.fx(this.nr, this.tr.get(1));
        }
        ay();
        if (this.i != null && u(3) && (bVarB = com.bytedance.adsdk.ugeno.b.u().b()) != null) {
            b.u uVar2 = this.zn;
            if (uVar2 != null) {
                uVar2.nr();
            }
            b.u uVarU = bVarB.u(this.nr, this);
            this.zn = uVarU;
            uVarU.u(this.mx);
            this.zn.u();
            this.zn.u(new b.nr() { // from class: com.bytedance.adsdk.ugeno.nr.fx.3
                @Override // com.bytedance.adsdk.ugeno.fx.nr.b.nr
                public void u(int i) {
                    fx fxVar;
                    sx sxVar;
                    fx.this.zn.nr();
                    if (fx.this.pn.isShown() && (sxVar = (fxVar = fx.this).i) != null && i == 1) {
                        my myVar = fxVar.tr.get(3);
                        fx fxVar2 = fx.this;
                        sxVar.u(myVar, fxVar2, fxVar2);
                    }
                }
            });
        }
        if (this.i != null && u(9)) {
            iz izVar = new iz(this.nr, this.tr.get(9), this);
            this.pq = izVar;
            izVar.u(this.i);
        }
        if (u(10)) {
            com.bytedance.adsdk.ugeno.fx.nr.nr nrVar = new com.bytedance.adsdk.ugeno.fx.nr.nr(this.nr, this.tr.get(10), this);
            this.hm = nrVar;
            nrVar.u(this.i);
        }
    }

    private void v() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.t);
        this.pn.setContentDescription(sb);
    }

    private void x() {
        if (this.u) {
            this.pn.setTranslationX(this.rv);
        }
        if (this.ki) {
            this.pn.setTranslationY(this.ge);
        }
        if (this.hs) {
            this.pn.setScaleX(this.ju);
        }
        if (this.te) {
            this.pn.setScaleY(this.zx);
        }
        if (this.ti) {
            this.pn.setRotation(this.jw);
        }
        if (this.gb) {
            this.pn.setRotationX(this.uq);
        }
        if (this.gl) {
            this.pn.setRotationY(-this.rg);
        }
        if (this.fn) {
            this.pn.setAlpha(this.ua);
        }
        float f = this.dc;
        if (f != 0.0f) {
            this.pn.setRotation(f);
        }
        if (this.ti || this.gb || this.gl) {
            this.pn.setCameraDistance(10000.0f);
        }
    }

    public T a() {
        return this.pn;
    }

    public String bf() {
        return this.l;
    }

    public float bg() {
        return this.dc;
    }

    public float bq() {
        return this.ua;
    }

    public sx c() {
        return this.i;
    }

    public float cj() {
        T t = this.pn;
        if (t instanceof com.bytedance.adsdk.ugeno.u.x) {
            return ((com.bytedance.adsdk.ugeno.u.x) t).getRipple();
        }
        return 0.0f;
    }

    public a.u d() {
        return this.n;
    }

    public float dw() {
        return this.w;
    }

    public ViewGroup.LayoutParams gi() {
        return this.kw;
    }

    public boolean h() {
        return this.jk;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void iz() {
        mv mvVar = this.r;
        if (mvVar != null) {
            mvVar.nr();
        }
        com.bytedance.adsdk.ugeno.u.u uVar = this.f;
        if (uVar != null) {
            uVar.fx();
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            izVar.fx();
        }
        c cVar = this.ky;
        if (cVar != null) {
            cVar.pn();
        }
        b.u uVar2 = this.zn;
        if (uVar2 != null) {
            uVar2.nr();
        }
    }

    public String ja() {
        return this.t;
    }

    public JSONObject jk() {
        return this.b;
    }

    public int jp() {
        return this.m;
    }

    public float k() {
        return this.ju;
    }

    public void kj() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapU;
        if (TextUtils.isEmpty(this.f5035jp)) {
            if (this.ex) {
                u(this.df);
                return;
            } else {
                this.iq.setColor(this.m);
                fx(this.m);
                return;
            }
        }
        if (!this.f5035jp.startsWith("local://")) {
            z();
            return;
        }
        String strReplace = this.f5035jp.replace("local://", "");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = this.xw ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.nr.getResources().openRawResource(com.bytedance.adsdk.ugeno.iz.b.nr(this.nr, strReplace)), null, options);
            if (this.xw && (bitmapU = n.u(this.nr, bitmapDecodeStream, (int) this.bc)) != null) {
                bitmapDrawable = new BitmapDrawable(this.nr.getResources(), bitmapU);
                u(bitmapDrawable);
            } else {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.nr.getResources(), bitmapDecodeStream);
                bitmapDrawable = bitmapDrawable2;
                u(bitmapDrawable);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        this.pn.setPadding((int) (this.bf ? this.gi : this.z), (int) (this.pb ? this.h : this.z), (int) (this.wq ? this.d : this.z), (int) (this.xg ? this.rh : this.z));
    }

    public boolean m() {
        return this.p;
    }

    public boolean mh() {
        return this.ic;
    }

    public float mv() {
        return this.rv;
    }

    public float my() {
        return this.zx;
    }

    public void nr(JSONObject jSONObject) {
        this.b = jSONObject;
        t();
    }

    public float o() {
        return this.uq;
    }

    public void oa() {
        pn pnVar = this.xh;
        if (pnVar != null) {
            pnVar.nr();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        pn pnVar;
        sx sxVar;
        com.bytedance.adsdk.ugeno.fx.nr.fx fxVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            bc();
        } else if (action == 1 || action == 3) {
            xw();
        }
        bq bqVar = this.qe;
        if (bqVar != null) {
            bqVar.u(this, motionEvent);
        }
        if (u(17) && motionEvent.getAction() == 0) {
            this.i.u(this.tr.get(17), this, this);
        }
        if (u(1) && this.jn && (sxVar = this.i) != null && (fxVar = this.wu) != null) {
            return fxVar.u(sxVar, this, motionEvent);
        }
        sx sxVar2 = this.i;
        if (sxVar2 != null && (pnVar = this.xh) != null) {
            return pnVar.u(sxVar2, this, motionEvent, yd());
        }
        com.bytedance.adsdk.ugeno.pn.a aVar = this.zq;
        if (aVar != null) {
            return aVar.u(motionEvent);
        }
        return false;
    }

    public int pb() {
        return (int) this.s;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void pn() {
        com.bytedance.adsdk.ugeno.fx.u uVar = this.ec;
        if (uVar != null) {
            mv mvVar = new mv(this.pn, uVar);
            this.r = mvVar;
            mvVar.u();
        }
        com.bytedance.adsdk.ugeno.u.u uVar2 = this.f;
        if (uVar2 != null) {
            uVar2.u();
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            izVar.nr();
        }
        c cVar = this.ky;
        if (cVar != null) {
            cVar.b();
        }
        com.bytedance.adsdk.ugeno.pn.a aVar = this.zq;
        if (aVar != null) {
            aVar.pn();
        }
        if (this.hm != null && u(10)) {
            this.hm.u();
        }
        if (this.pq != null && u(9)) {
            this.pq.u();
        }
        pn pnVar = this.xh;
        if (pnVar != null) {
            pnVar.u();
        }
        this.ad = System.currentTimeMillis();
    }

    public long q() {
        return this.ad;
    }

    public JSONObject qq() {
        return this.fx;
    }

    public u rh() {
        return this.iz;
    }

    public float s() {
        return this.ge;
    }

    public float su() {
        T t = this.pn;
        if (t instanceof com.bytedance.adsdk.ugeno.u.x) {
            return ((com.bytedance.adsdk.ugeno.u.x) t).getRubIn();
        }
        return 0.0f;
    }

    public float sx() {
        return this.rg;
    }

    public void t() {
        this.vp = this.b.optBoolean("gesture_through_enable", false);
    }

    public float tk() {
        T t = this.pn;
        if (t instanceof com.bytedance.adsdk.ugeno.u.x) {
            return ((com.bytedance.adsdk.ugeno.u.x) t).getShine();
        }
        return 0.0f;
    }

    public T u() {
        return null;
    }

    public boolean w() {
        return this.mk > 0.0f;
    }

    public float wi() {
        T t = this.pn;
        if (t instanceof com.bytedance.adsdk.ugeno.u.x) {
            return ((com.bytedance.adsdk.ugeno.u.x) t).getStretch();
        }
        return 0.0f;
    }

    public int wq() {
        return (int) this.mv;
    }

    public s xg() {
        return this.f5034a;
    }

    public com.bytedance.adsdk.ugeno.pn.u.u y() {
        return this.zu;
    }

    public boolean yd() {
        return this.vp;
    }

    public void z() {
        x xVar = this.dj;
        if (xVar != null) {
            xVar.u();
        }
        com.bytedance.adsdk.ugeno.b.u().nr().u(this.f5034a, this.f5035jp, new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.nr.fx.4
            @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
            public void u(final Bitmap bitmap) {
                if (bitmap == null) {
                    fx fxVar = fx.this;
                    x xVar2 = fxVar.dj;
                    if (xVar2 != null) {
                        xVar2.nr(fxVar, fxVar.f5035jp);
                        return;
                    }
                    return;
                }
                fx fxVar2 = fx.this;
                x xVar3 = fxVar2.dj;
                if (xVar3 != null) {
                    xVar3.u(fxVar2, fxVar2.f5035jp);
                }
                fx fxVar3 = fx.this;
                if (!fxVar3.xw) {
                    n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.nr.fx.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fx.this.u(new BitmapDrawable(bitmap));
                        }
                    });
                    return;
                }
                final Bitmap bitmapU = n.u(fxVar3.nr, bitmap, (int) fxVar3.bc);
                if (bitmapU != null) {
                    n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.nr.fx.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fx.this.u(new BitmapDrawable(bitmapU));
                        }
                    });
                }
            }
        });
    }

    public fx(Context context, u<ViewGroup> uVar) {
        this.mv = -2.0f;
        this.s = -2.0f;
        this.nb = "solid";
        this.gc = 0;
        this.p = true;
        this.tm = 0.0f;
        this.rv = 0.0f;
        this.ge = 0.0f;
        this.ob = 1.0f;
        this.ju = 1.0f;
        this.zx = 1.0f;
        this.jw = 0.0f;
        this.uq = 0.0f;
        this.rg = 0.0f;
        this.dc = 0.0f;
        this.ua = 1.0f;
        this.je = true;
        this.qb = true;
        this.bl = false;
        this.e = false;
        this.vp = false;
        this.mx = 12.0f;
        this.nr = context;
        this.iz = uVar;
        this.tr = new HashMap();
        this.iq = new GradientDrawable();
        this.pn = (T) u();
    }

    private ImageView.ScaleType t(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.y = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.y = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.y = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.y = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.y;
    }

    public List<com.bytedance.adsdk.ugeno.pn.fx.nr> a(String str) {
        com.bytedance.adsdk.ugeno.pn.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.zq) == null) {
            return null;
        }
        return aVar.u(str);
    }

    public fx<T> b(String str) {
        return u(str);
    }

    public void fx(JSONObject jSONObject) {
        this.fx = jSONObject;
    }

    public com.bytedance.adsdk.ugeno.u.u jk(String str) {
        com.bytedance.adsdk.ugeno.u.u uVar = this.f;
        if (uVar != null && TextUtils.equals(str, uVar.pn())) {
            return this.f;
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            return izVar.u(str);
        }
        return null;
    }

    public void u(JSONObject jSONObject) {
        this.b = jSONObject;
        t();
        JSONObject jSONObject2 = this.fx;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        u<ViewGroup> uVar = this.iz;
        u.C0171u c0171uN = uVar instanceof u ? uVar.n() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strU = com.bytedance.adsdk.ugeno.b.nr.u(this.fx.optString(next), jSONObject);
            u(next, strU);
            if (c0171uN != null) {
                c0171uN.u(this.nr, next, strU);
            }
        }
        if (c0171uN != null) {
            u(c0171uN.u());
        }
        if (this.wv == null || this.b == null) {
            return;
        }
        try {
            if (!h()) {
                this.b.put("i18n", this.wv);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("i18n", this.wv);
            this.b.put("xNode", jSONObject3);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void b() {
        if (this.ky == null || this.dd) {
            return;
        }
        this.dd = true;
    }

    public void fx(int i) {
        this.iq.setShape(0);
        this.iq.setColor(i);
        lf();
        eh();
        this.pn.setBackground(this.iq);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void nr() {
        kj();
        l();
        nr(this.gc);
        x();
        n();
        com.bytedance.adsdk.ugeno.pn.a aVar = this.zq;
        if (aVar != null) {
            aVar.u();
            this.zq.nr();
            this.zq.fx();
        }
        this.pn.setOnTouchListener(this);
        v();
        ViewGroup viewGroup = (ViewGroup) this.pn.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.je);
        }
        com.bytedance.adsdk.ugeno.u.u uVar = this.f;
        if (uVar != null) {
            uVar.b();
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            izVar.u();
        }
        com.bytedance.adsdk.ugeno.pn.a aVar2 = this.zq;
        if (aVar2 != null) {
            aVar2.b();
        }
        if (this.i == null || !u(22)) {
            return;
        }
        this.i.u(this.tr.get(22), this, this);
    }

    private boolean l(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void b(int i) {
        if (h()) {
            T t = this.pn;
            if (t instanceof nr) {
                ((nr) t).u(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof nr) {
                ((nr) viewParent).u(this.pn, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.pn.getLayoutParams();
        layoutParams.width = i;
        this.pn.setLayoutParams(layoutParams);
    }

    public fx<T> fx(String str) {
        if (jk(str) != null) {
            return this;
        }
        return null;
    }

    public void fx(boolean z) {
        this.jk = z;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void fx() {
        if (this.ky == null || this.j) {
            return;
        }
        this.j = true;
    }

    public fx<T> iz(String str) {
        return fx(str);
    }

    public void bc() {
    }

    public void xw() {
    }

    public fx<T> pn(String str) {
        return nr(str);
    }

    public void pn(int i) {
        if (h()) {
            T t = this.pn;
            if (t instanceof nr) {
                ((nr) t).nr(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof nr) {
                ((nr) viewParent).nr(this.pn, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.pn.getLayoutParams();
        layoutParams.height = i;
        this.pn.setLayoutParams(layoutParams);
    }

    public void u(c cVar) {
        this.ky = cVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void u(boolean z) {
        c cVar = this.ky;
        if (cVar != null) {
            cVar.u(z);
        }
    }

    public void x(String str) {
        this.t = str;
    }

    public boolean u(int i) {
        Map<Integer, my> map = this.tr;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void u(bq bqVar) {
        this.qe = bqVar;
    }

    public void nr(boolean z) {
        this.jn = z;
    }

    public void u(sx sxVar) {
        this.i = sxVar;
    }

    public void nr(int i) {
        ViewParent viewParent = (ViewGroup) this.pn.getParent();
        if (viewParent instanceof nr) {
            ((nr) viewParent).fx(this.pn, i);
        } else {
            this.pn.setVisibility(i);
        }
    }

    public void u(u.C0170u c0170u) {
        if (c0170u == null) {
            return;
        }
        this.iq.setShape(0);
        this.iq.setOrientation(c0170u.u);
        if (Build.VERSION.SDK_INT >= 29) {
            this.iq.setColors(c0170u.nr, c0170u.fx);
        } else {
            this.iq.setColors(c0170u.nr);
        }
        lf();
        eh();
        this.pn.setBackground(this.iq);
    }

    public fx<T> nr(String str) {
        if (TextUtils.isEmpty(this.l) || !TextUtils.equals(this.l, str)) {
            return null;
        }
        return this;
    }

    public void n(String str) {
        this.l = str;
    }

    public void nr(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.tr == null) {
            return;
        }
        try {
            int type = o.u(str).getType();
            my myVar = new my();
            myVar.u(type);
            myVar.u(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.mx = Float.parseFloat(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("shakeAmplitude"), this.b));
                } catch (NumberFormatException unused) {
                    this.mx = 12.0f;
                }
            }
            sx sxVar = this.i;
            if (!(sxVar instanceof com.bytedance.adsdk.ugeno.fx.u.nr)) {
                u(type, jSONObject, myVar);
            } else if (!((com.bytedance.adsdk.ugeno.fx.u.nr) sxVar).u()) {
                u(type, jSONObject, myVar);
            } else {
                myVar.u(jSONObject);
                this.tr.put(Integer.valueOf(type), myVar);
            }
        } catch (JSONException unused2) {
        }
    }

    public void u(Drawable drawable) {
        this.pn.setBackground(drawable);
    }

    public void u(ViewGroup.LayoutParams layoutParams) {
        T t = this.pn;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.kw = layoutParams;
    }

    public void u(boolean z, boolean z2) {
        if (this.pn != null) {
            u(this.kw);
            if (z) {
                b((int) this.mv);
            }
            if (z2) {
                pn((int) this.s);
            }
        }
    }

    public void u(a.u uVar) {
        this.n = uVar;
    }

    public fx<T> u(String str) {
        if (TextUtils.isEmpty(this.t) || !TextUtils.equals(this.t, str)) {
            return null;
        }
        return this;
    }

    public void u(u uVar) {
        this.iz = uVar;
    }

    public void u(s sVar) {
        this.f5034a = sVar;
    }

    public void u(jk jkVar) {
        this.sf = jkVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void nr(Canvas canvas) {
        if (this instanceof u) {
            com.bytedance.adsdk.ugeno.u.u uVar = this.f;
            if (uVar != null) {
                uVar.nr(canvas);
            }
            com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
            if (izVar != null) {
                izVar.nr(canvas);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 10;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b = 11;
                }
                break;
            case -1291329255:
                if (str.equals(f.ax)) {
                    b = 12;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = dn.k;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = dn.l;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 15;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = 16;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = 18;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 19;
                }
                break;
            case -925180581:
                if (str.equals(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                    b = 20;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = 21;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = 22;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b = 23;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = 24;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = 25;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = 26;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = 27;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = 28;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = 29;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = 30;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 32;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 33;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 34;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 35;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 36;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 37;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    b = 38;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 39;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 40;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 41;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 42;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 43;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 44;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 45;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 46;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 47;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 48;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 49;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 50;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 51;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 52;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 53;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 54;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 55;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 56;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 57;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 58;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 59;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = 60;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = Base64.padSymbol;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 62;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = 64;
                }
                break;
            case 1941332754:
                if (str.equals(RemoteMessageConst.Notification.VISIBILITY)) {
                    b = 65;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 66;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 67;
                }
                break;
        }
        switch (b) {
            case 0:
                this.qb = com.bytedance.adsdk.ugeno.iz.fx.u(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 33:
            case 39:
            case 48:
            case 51:
            case 54:
            case 62:
            case 64:
                nr(str, str2);
                break;
            case 2:
                this.u = true;
                this.rv = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 3:
                this.ki = true;
                this.ge = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 4:
                this.gi = n.u(this.nr, str2);
                this.bf = true;
                break;
            case 5:
                this.bq = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 11:
            case 55:
                if (com.bytedance.adsdk.ugeno.iz.u.fx(str2)) {
                    this.ex = true;
                    this.df = com.bytedance.adsdk.ugeno.iz.u.nr(str2);
                } else {
                    this.m = com.bytedance.adsdk.ugeno.iz.u.u(str2, 0);
                    this.ex = false;
                }
                break;
            case 12:
                this.zq = com.bytedance.adsdk.ugeno.pn.a.u(this, str2);
                break;
            case 13:
                this.fn = true;
                this.ua = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 1.0f);
                break;
            case 14:
                this.cj = n.u(this.nr, str2);
                this.mh = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.s = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.s = -2.0f;
                } else {
                    this.s = n.u(this.nr, str2);
                }
                this.e = true;
                break;
            case 16:
                this.k = n.u(this.nr, str2);
                break;
            case 17:
                this.sx = n.u(this.nr, str2);
                this.qq = true;
                break;
            case 19:
            case 56:
                this.f5035jp = str2;
                break;
            case 20:
                this.ti = true;
                this.jw = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 21:
                this.hs = true;
                this.ju = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 22:
                this.te = true;
                this.zx = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 23:
                this.z = n.u(this.nr, str2);
                this.ja = true;
                break;
            case 24:
                this.uk = str2;
                break;
            case 25:
                this.bg = n.u(this.nr, str2);
                this.kj = true;
                break;
            case 26:
                this.dw = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 27:
                this.t = str2;
                break;
            case 28:
                this.wv = com.bytedance.adsdk.ugeno.iz.nr.u(str2, (JSONObject) null);
                break;
            case 29:
                this.l = str2;
                break;
            case 30:
                float fU = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                this.bc = fU;
                if (fU > 0.0f) {
                    this.xw = true;
                }
                break;
            case 31:
                this.h = n.u(this.nr, str2);
                this.pb = true;
                break;
            case 32:
                this.wj = str2;
                break;
            case 34:
                this.mk = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 35:
                this.hs = true;
                this.te = true;
                float[] fArrFx = com.bytedance.adsdk.ugeno.u.b.fx(str2);
                this.ju = fArrFx[0];
                this.zx = fArrFx[1];
                break;
            case 36:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.mv = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.mv = -2.0f;
                } else {
                    this.mv = n.u(this.nr, str2);
                }
                this.bl = true;
                break;
            case 37:
                this.rh = n.u(this.nr, str2);
                this.xg = true;
                break;
            case 38:
                List<com.bytedance.adsdk.ugeno.u.fx> listU = com.bytedance.adsdk.ugeno.u.b.u(str2, this.b);
                if (listU != null && !listU.isEmpty()) {
                    this.za = new com.bytedance.adsdk.ugeno.u.iz(this.nr, this, listU);
                    break;
                }
                break;
            case 40:
                this.wi = n.u(this.nr, str2);
                this.yd = true;
                break;
            case 41:
                this.je = l(str2);
                break;
            case 42:
                this.tk = n.u(this.nr, str2);
                this.ay = true;
                break;
            case 43:
                this.su = n.u(this.nr, str2);
                this.v = true;
                break;
            case 44:
                this.d = n.u(this.nr, str2);
                this.wq = true;
                break;
            case 45:
                this.lf = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case 46:
                this.nb = str2;
                break;
            case 47:
                this.eh = n.u(this.nr, str2);
                break;
            case 49:
                this.o = n.u(this.nr, str2);
                this.q = true;
                break;
            case 50:
                this.u = true;
                this.ki = true;
                float[] fArrFx2 = com.bytedance.adsdk.ugeno.u.b.fx(str2);
                this.rv = n.u(this.nr, fArrFx2[0]);
                this.ge = n.u(this.nr, fArrFx2[1]);
                break;
            case 52:
                try {
                    this.f = new com.bytedance.adsdk.ugeno.u.u(this.nr, this, com.bytedance.adsdk.ugeno.u.b.u(new JSONObject(str2), this.b));
                } catch (JSONException unused) {
                    return;
                }
                break;
            case 53:
                this.ec = com.bytedance.adsdk.ugeno.fx.u.u(str2, this);
                break;
            case 57:
                this.oa = true;
                this.y = t(str2);
                break;
            case 58:
                this.w = n.u(this.nr, str2);
                break;
            case 59:
                this.gb = true;
                this.uq = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 60:
                this.gl = true;
                this.rg = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 61:
                this.dc = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 63:
                this.ic = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                break;
            case 65:
                if (TextUtils.equals(MapBundleKey.MapObjKey.OBJ_SL_VISI, str2)) {
                    this.gc = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.gc = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.gc = 8;
                }
                this.pn.setVisibility(this.gc);
                break;
            case 66:
                this.my = n.u(this.nr, str2);
                this.c = true;
                break;
            case 67:
                this.p = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void nr(int i, int i2, int i3, int i4) {
        mv mvVar = this.r;
        if (mvVar != null) {
            mvVar.u(i, i2);
        }
        com.bytedance.adsdk.ugeno.u.u uVar = this.f;
        if (uVar != null) {
            uVar.u(i, i2);
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            izVar.u(i, i2);
        }
    }

    public fx nr(fx fxVar) {
        return (fxVar.rh() == null && (fxVar instanceof u)) ? fxVar : nr(fxVar.rh());
    }

    @Deprecated
    public void u(int i, JSONObject jSONObject, my myVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            my myVar2 = new my();
            myVar2.u(jSONObjectOptJSONObject);
            myVar2.u(this);
            myVar.u(myVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            my myVar3 = new my();
            myVar3.u(jSONObjectOptJSONObject2);
            myVar3.u(this);
            myVar.nr(myVar3);
        }
        myVar.u(jSONObject);
        this.tr.put(Integer.valueOf(i), myVar);
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public int[] u(int i, int i2) {
        if (this.mk > 0.0f) {
            if (this.bl) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.mk;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.e) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.mk;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.ky != null && !this.qf) {
            this.qf = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void u(int i, int i2, int i3, int i4) {
        if (this.ky == null || this.jf) {
            return;
        }
        this.jf = true;
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void u(Canvas canvas, com.bytedance.adsdk.ugeno.fx.pn pnVar) {
        mv mvVar = this.r;
        if (mvVar != null) {
            mvVar.u(canvas, pnVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx
    public void u(Canvas canvas) {
        if (this instanceof u) {
            return;
        }
        com.bytedance.adsdk.ugeno.u.u uVar = this.f;
        if (uVar != null) {
            uVar.u(canvas);
        }
        com.bytedance.adsdk.ugeno.u.iz izVar = this.za;
        if (izVar != null) {
            izVar.u(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx.nr
    public void u(my myVar) {
        u<ViewGroup> uVar;
        fx<T> fxVarB;
        if (myVar == null || myVar.fx() == null) {
            return;
        }
        b.u uVar2 = this.zn;
        if (uVar2 != null) {
            uVar2.nr();
        }
        if (TextUtils.equals(myVar.fx().optString("type"), "onDismiss")) {
            String strOptString = myVar.fx().optString("nodeId");
            nr(8);
            this.x = (u) nr(this);
            if (TextUtils.isEmpty(strOptString) || (uVar = this.x) == null || (fxVarB = uVar.b(strOptString)) == null) {
                return;
            }
            fxVarB.nr(8);
        }
    }

    public void u(com.bytedance.adsdk.ugeno.pn.u.u uVar) {
        this.zu = uVar;
    }

    public void u(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listA = a(str);
        if (listA == null || listA.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listA) {
            nrVar.u(this.zq);
            nrVar.u(objArr);
        }
    }

    public void u(com.bytedance.adsdk.ugeno.fx.iz izVar) {
        com.bytedance.adsdk.ugeno.pn.a aVar = this.zq;
        if (aVar != null) {
            aVar.u(izVar);
        }
    }

    public void u(x xVar) {
        this.dj = xVar;
    }

    public void u(com.bytedance.adsdk.ugeno.pn.mv mvVar) {
        com.bytedance.adsdk.ugeno.pn.a aVar = this.zq;
        if (aVar != null) {
            aVar.u(mvVar);
        }
    }
}
