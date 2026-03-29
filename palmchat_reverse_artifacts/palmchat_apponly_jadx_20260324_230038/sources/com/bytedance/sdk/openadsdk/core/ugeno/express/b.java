package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.component.adexpress.nr.n;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.pb;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.ex;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dc;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements bq, sx, com.bytedance.sdk.component.adexpress.dynamic.b, com.bytedance.sdk.component.adexpress.nr.b<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected n f5383a;
    protected JSONObject b;
    protected qq bg;
    protected com.bytedance.sdk.openadsdk.core.ugeno.t.u bq;
    private String c;
    private List<com.bytedance.adsdk.ugeno.nr.fx<View>> dw;
    protected com.bytedance.adsdk.ugeno.nr.fx<View> fx;
    protected bc iz;
    protected x jk;
    protected com.bytedance.adsdk.ugeno.nr.fx k;
    protected com.bytedance.adsdk.ugeno.nr.fx my;
    protected UGTimerContainer n;
    protected Context nr;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz o;
    protected JSONObject pn;
    private String q;
    private boolean qq;
    protected WeakReference<ViewGroup> s;
    protected s t;
    protected k u;
    protected nr x;
    protected List<com.bytedance.adsdk.ugeno.fx.n> l = new ArrayList();
    protected jk mv = new jk();
    protected AtomicBoolean sx = new AtomicBoolean(false);

    public b(Context context, bc bcVar, nr nrVar, ViewGroup viewGroup) {
        JSONObject jSONObjectOptJSONObject;
        this.qq = false;
        this.nr = context;
        this.u = new k(context);
        this.iz = bcVar;
        this.x = nrVar;
        this.n = new UGTimerContainer(context);
        this.s = new WeakReference<>(viewGroup);
        JSONObject jSONObjectU = u();
        this.b = jSONObjectU;
        if (bcVar != null && jSONObjectU != null && (jSONObjectOptJSONObject = jSONObjectU.optJSONObject("event_template")) != null) {
            this.qq = true;
            com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(jSONObjectOptJSONObject);
        }
        if (com.bytedance.sdk.openadsdk.pn.u.b(bcVar)) {
            u(new com.bytedance.adsdk.ugeno.fx.n() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.1
                @Override // com.bytedance.adsdk.ugeno.fx.n
                public void nr(a.u uVar) {
                    com.bytedance.sdk.openadsdk.pn.u.u(false, uVar);
                }

                @Override // com.bytedance.adsdk.ugeno.fx.n
                public void u(a.u uVar) {
                    com.bytedance.sdk.openadsdk.pn.u.u(true, uVar);
                }
            });
        }
        this.u.u(new com.bytedance.adsdk.ugeno.fx.n() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.2
            @Override // com.bytedance.adsdk.ugeno.fx.n
            public void nr(a.u uVar) {
                Iterator<com.bytedance.adsdk.ugeno.fx.n> it = b.this.l.iterator();
                while (it.hasNext()) {
                    it.next().nr(uVar);
                }
            }

            @Override // com.bytedance.adsdk.ugeno.fx.n
            public void u(a.u uVar) {
                Iterator<com.bytedance.adsdk.ugeno.fx.n> it = b.this.l.iterator();
                while (it.hasNext()) {
                    it.next().u(uVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s() {
        bc bcVar = this.iz;
        if (bcVar != null) {
            return bcVar.n();
        }
        return 0;
    }

    public boolean a() {
        return this.qq;
    }

    public float[] b() {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null) {
            return null;
        }
        Object objPn = fxVar.pn("InteractContainerView");
        if (objPn instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.interact.jk) {
            return ((com.bytedance.sdk.openadsdk.core.ugeno.component.interact.jk) objPn).v();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public int fx() {
        return tk.nr(this.iz);
    }

    public com.bytedance.adsdk.ugeno.nr.fx iz() {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null) {
            return null;
        }
        return fxVar.pn("PlayableComponent");
    }

    public JSONObject jk() {
        return this.x.wq();
    }

    public void l() {
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB;
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null || (fxVarB = fxVar.b("corver_container")) == 0 || fxVarB.a() == null) {
            return;
        }
        fxVarB.a().setVisibility(0);
    }

    public void mv() {
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB;
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null || (fxVarB = fxVar.b("corver_container")) == 0 || fxVarB.a() == null) {
            return;
        }
        fxVarB.a().setVisibility(8);
    }

    public List<com.bytedance.adsdk.ugeno.nr.fx<View>> n() {
        return this.dw;
    }

    public void nr() {
        List<com.bytedance.adsdk.ugeno.nr.fx<View>> list = this.dw;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = this.dw.iterator();
        while (it.hasNext()) {
            it.next().oa();
        }
    }

    public com.bytedance.adsdk.ugeno.nr.fx pn() {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null) {
            return null;
        }
        return fxVar.pn("VideoPlaceholder");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB;
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null || (fxVarB = fxVar.b("mute_image")) == 0) {
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(this.c)) {
                ((com.bytedance.adsdk.ugeno.widget.image.nr) fxVarB).l(this.c);
            }
        } else if (!TextUtils.isEmpty(this.q)) {
            ((com.bytedance.adsdk.ugeno.widget.image.nr) fxVarB).l(this.q);
        }
        fxVarB.nr();
    }

    public void t() {
        this.sx.set(false);
        qq qqVar = this.bg;
        if (qqVar != null) {
            qqVar.nr(s());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.bq;
        if (uVar != null) {
            uVar.nr();
        }
        List<com.bytedance.adsdk.ugeno.fx.n> list = this.l;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public View x() {
        return this.n;
    }

    private void fx(my myVar) {
        JSONObject jSONObjectFx;
        if (myVar == null || (jSONObjectFx = myVar.fx()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(this.iz, jSONObjectFx.optString("uttieUrl"), jSONObjectFx.optLong("duration"));
    }

    public void nr(com.bytedance.sdk.component.adexpress.nr.x xVar) {
        this.u.u((sx) this);
        this.u.u((bq) this);
        this.fx = this.u.u(this.b);
        this.x.pb().nr();
        this.x.pb().fx();
        this.u.nr(this.pn);
    }

    public void u(n nVar) {
        this.f5383a = nVar;
    }

    public void u(x xVar) {
        this.jk = xVar;
    }

    private boolean b(my myVar) {
        JSONObject jSONObjectFx;
        return myVar != null && myVar.nr() == 1 && (jSONObjectFx = myVar.fx()) != null && jSONObjectFx.optBoolean("lottieEvent", false);
    }

    private void fx(final my myVar, final sx.nr nrVar, final sx.u uVar) {
        if (this.bg == null) {
            qq qqVar = new qq(dw.getContext(), 2, this.x.a(), dw.nr().jk());
            this.bg = qqVar;
            qqVar.u(this.iz.gz());
            this.bg.fx(this.iz.an());
            this.bg.nr(this.iz.qv());
            this.bg.u(this.iz.xs());
            this.bg.iz(this.iz.ki());
            this.bg.pn(this.iz.zq());
            this.bg.nr(this.iz.bi());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.bg.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.3
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i) {
                if (i != 2) {
                    return;
                }
                b bVar = b.this;
                bVar.bg.nr(bVar.s());
                fArr[0] = 0.0f;
                View viewA = ((com.bytedance.adsdk.ugeno.nr.fx) nrVar).a();
                if (viewA != null) {
                    viewA.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.3.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z) {
                            if (z) {
                                b bVar2 = b.this;
                                bVar2.bg.u(bVar2.s());
                            } else {
                                b bVar3 = b.this;
                                bVar3.bg.nr(bVar3.s());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                b.this.u(myVar, nrVar, uVar, 2, false);
            }
        });
        this.bg.u(new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.4
            float u = 0.0f;
            float nr = 0.0f;
            float fx = 0.0f;
            float b = 0.0f;
            float pn = 0.0f;
            float iz = 0.0f;
            long x = System.currentTimeMillis();

            @Override // com.bytedance.sdk.component.utils.qq.nr
            public void u(float f, float f2, float f3) {
                JSONObject jSONObjectFx;
                View viewA;
                boolean z;
                float f4;
                float fCeil;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.x < 100) {
                    return;
                }
                this.x = jCurrentTimeMillis;
                my myVar2 = myVar;
                if (myVar2 == null || (jSONObjectFx = myVar2.fx()) == null) {
                    return;
                }
                double dOptDouble = jSONObjectFx.optDouble("rotateZ", -1.0d);
                if (dOptDouble == -1.0d) {
                    return;
                }
                sx.nr nrVar2 = nrVar;
                if ((nrVar2 instanceof com.bytedance.adsdk.ugeno.nr.fx) && (viewA = ((com.bytedance.adsdk.ugeno.nr.fx) nrVar2).a()) != null && viewA.isShown()) {
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    float fAbs3 = Math.abs(f3);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.u = fAbs;
                        this.nr = fAbs2;
                        this.fx = fAbs3;
                        this.b = f;
                        this.pn = f2;
                        this.iz = f3;
                        return;
                    }
                    float fMax = Math.max(Math.abs(fAbs - this.u), Math.max(Math.abs(fAbs2 - this.nr), Math.abs(fAbs3 - this.fx)));
                    int iQv = b.this.iz.qv();
                    if (iQv <= 0) {
                        iQv = 50;
                    }
                    if (Math.abs(fAbs - this.u) == fMax) {
                        f4 = f >= this.b ? fMax : -fMax;
                        z = true;
                    } else {
                        z = false;
                        f4 = 0.0f;
                    }
                    if (Math.abs(fAbs2 - this.nr) == fMax) {
                        f4 = f2 >= this.pn ? fMax : -fMax;
                        z = true;
                    }
                    if (Math.abs(fAbs3 - this.fx) != fMax) {
                        fMax = f4;
                    } else if (f3 < this.iz) {
                        fMax = -fMax;
                    }
                    if (b.this.iz.ki() == 0) {
                        fCeil = (float) Math.ceil(((double) (fMax * 180.0f)) / dOptDouble);
                    } else {
                        double degrees = Math.toDegrees(fMax);
                        float fCeil2 = (float) Math.ceil(degrees / dOptDouble);
                        if (z && Math.abs(degrees) < iQv - 8) {
                            return;
                        } else {
                            fCeil = z ? -Math.abs(fCeil2) : fCeil2;
                        }
                    }
                    if (Math.abs(fCeil - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewA, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, fArr[0], fCeil);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.setDuration(100L);
                    objectAnimatorOfFloat.start();
                    fArr[0] = fCeil;
                }
            }
        });
        this.bg.u(s());
    }

    private void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar, List<com.bytedance.adsdk.ugeno.nr.fx<View>> list) {
        if (fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) {
            if (fxVar.u(4)) {
                list.add(fxVar);
            }
            List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x();
            if (listX == null || listX.size() == 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
            while (it.hasNext()) {
                u(it.next(), list);
            }
            return;
        }
        if (fxVar == null || !fxVar.u(4)) {
            return;
        }
        list.add(fxVar);
    }

    private void b(final my myVar, final sx.nr nrVar, final sx.u uVar) {
        WeakReference<ViewGroup> weakReference = this.s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        pb.u(this.s, new com.bytedance.sdk.openadsdk.core.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.b.5
            @Override // com.bytedance.sdk.openadsdk.core.nr.fx
            public void u() {
                WeakReference<ViewGroup> weakReference2 = b.this.s;
                if (weakReference2 == null || weakReference2.get() == null || !pb.u(b.this.s.get())) {
                    return;
                }
                b.this.u(myVar, nrVar, uVar, 1, false);
            }
        });
    }

    private void nr(my myVar) {
        JSONObject jSONObjectFx;
        if (myVar == null || (jSONObjectFx = myVar.fx()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(this.iz, jSONObjectFx.optString("uttieUrl"));
    }

    private void nr(my myVar, sx.nr nrVar, sx.u uVar) {
        JSONObject jSONObjectFx = myVar.fx();
        if (jSONObjectFx == null) {
            return;
        }
        String strOptString = jSONObjectFx.optString("type", null);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (strOptString.equals("clickEvent")) {
            u(myVar, nrVar, uVar, 0, true);
            return;
        }
        if (strOptString.equals("close")) {
            x xVar = this.jk;
            if (xVar != null) {
                xVar.u();
            }
            com.bytedance.sdk.openadsdk.core.qq.s.u().fx(this.iz, jSONObjectFx.optString("uttieUrl"));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public void u(com.bytedance.sdk.component.adexpress.nr.x xVar) {
        this.x.pb().u();
        this.b = u();
        JSONObject jSONObjectJk = jk();
        this.pn = jSONObjectJk;
        if (this.b != null && jSONObjectJk != null) {
            nr(xVar);
            if (this.fx != null) {
                fx fxVar = new fx();
                this.t = fxVar;
                fxVar.u(true);
                this.t.u(fx());
                com.bytedance.adsdk.ugeno.nr.fx fxVarPn = pn();
                this.k = fxVarPn;
                if (fxVarPn != null && (fxVarPn instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.b.u)) {
                    ((fx) this.t).u((FrameLayout) fxVarPn.a());
                }
                com.bytedance.adsdk.ugeno.nr.fx fxVarIz = iz();
                this.my = fxVarIz;
                if (fxVarIz != null && (fxVarIz instanceof com.bytedance.adsdk.ugeno.widget.frame.u)) {
                    ((fx) this.t).nr((FrameLayout) fxVarIz.a());
                }
                s sVar = this.t;
                if (sVar instanceof fx) {
                    ((fx) sVar).u(this.bq);
                }
                this.n.setTimerHolder(this.bq);
                int iWq = this.fx.wq();
                int iPb = this.fx.pb();
                ArrayList arrayList = new ArrayList();
                this.dw = arrayList;
                u(this.fx, arrayList);
                View viewA = this.fx.a();
                ViewGroup viewGroup = (ViewGroup) viewA.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(viewA);
                }
                this.n.addView(this.fx.a(), new FrameLayout.LayoutParams(iWq, iPb));
                float fJa = this.x.ja();
                float fBf = this.x.bf();
                float fFx = y.fx(this.nr, fJa);
                float fFx2 = y.fx(this.nr, fBf);
                int iB = y.b(this.nr);
                int iA = (int) (y.a(this.nr) + y.t(this.nr));
                float f = iB;
                if (fFx > f) {
                    fFx = f;
                }
                float f2 = iA;
                if (fFx2 > f2) {
                    fFx2 = f2;
                }
                if (fBf <= 0.0f) {
                    this.n.setLayoutParams(new FrameLayout.LayoutParams((int) fFx, -2));
                } else {
                    this.n.setLayoutParams(new FrameLayout.LayoutParams((int) fFx, (int) fFx2));
                }
                if (fBf <= 0.0f) {
                    this.n.measure(View.MeasureSpec.makeMeasureSpec((int) fFx, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    int iB2 = y.b(this.nr, this.n.getMeasuredWidth());
                    int iB3 = y.b(this.nr, this.n.getMeasuredHeight());
                    this.t.u(iB2);
                    this.t.nr(iB3);
                } else {
                    this.t.u(y.b(this.nr, fFx));
                    this.t.nr(y.b(this.nr, fFx2));
                }
                if (this.sx.get()) {
                    xVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                    return;
                } else {
                    xVar.u(this.n, this.t);
                    return;
                }
            }
            xVar.u(138, (String) null);
            return;
        }
        xVar.u(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
    }

    private void fx(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.fx.u(jSONObjectOptJSONObject, this.nr, this.iz);
    }

    private void nr(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar;
        com.bytedance.adsdk.ugeno.nr.fx fxVarB;
        if (jSONObject == null) {
            return;
        }
        String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("type"), jk());
        String strU2 = com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("nodeId"), jk());
        if (TextUtils.isEmpty(strU2) || (fxVar = this.fx) == null || (fxVarB = fxVar.nr(fxVar).b(strU2)) == null) {
            return;
        }
        if (TextUtils.equals(strU, "onDismiss")) {
            fxVarB.nr(8);
        } else if (TextUtils.equals(strU, "onShow")) {
            fxVarB.nr(0);
        } else if (TextUtils.equals(strU, "haptic")) {
            fx(jSONObject);
        }
    }

    public JSONObject u() {
        return this.x.pn();
    }

    public void u(boolean z) {
        this.sx.set(z);
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        if (myVar == null) {
            return;
        }
        if (myVar.nr() == 18) {
            fx(myVar, nrVar, uVar);
        } else if (myVar.nr() == 3) {
            b(myVar, nrVar, uVar);
        } else if (myVar.nr() == 9) {
            nr(myVar.fx());
        } else if (myVar.nr() == 10) {
            u(myVar.fx());
        } else if (myVar.nr() == 21) {
            nr(myVar);
        } else if (myVar.nr() == 19) {
            fx(myVar);
        } else if (myVar.nr() != 20) {
            if (b(myVar)) {
                nr(myVar, nrVar, uVar);
            } else if (myVar.nr() == 22) {
                u(myVar);
            } else {
                u(myVar, nrVar, uVar, 0, false);
            }
        }
        if (myVar.fx() != null) {
            String strOptString = myVar.fx().optString("next");
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                my myVar2 = new my();
                myVar2.u(1);
                myVar2.u(new JSONObject(strOptString));
                myVar2.u(this.fx);
                u(myVar2, (sx.nr) null, (sx.u) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void u(my myVar) {
        JSONObject jSONObjectFx;
        if (myVar == null || (jSONObjectFx = myVar.fx()) == null) {
            return;
        }
        String strOptString = jSONObjectFx.optString("type");
        String strOptString2 = jSONObjectFx.optString("uchain");
        JSONObject jSONObjectOptJSONObject = jSONObjectFx.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectOptJSONObject.optString(next), jk()));
                } catch (Throwable unused) {
                }
            }
        }
        if (ex.Code.equals(strOptString2)) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.iz);
            HashMap map3 = new HashMap();
            map3.put("ugen_event_params", jSONObject);
            String strNr = jp.nr(this.iz);
            jp.gi();
            com.bytedance.sdk.openadsdk.core.a.u.b.u.u(this.iz, map, strOptString, map2, strNr, map3);
        }
    }

    private void u(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar;
        com.bytedance.adsdk.ugeno.nr.fx fxVarB;
        if (jSONObject == null) {
            return;
        }
        String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("type"), jk());
        String strU2 = com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("nodeId"), jk());
        if (TextUtils.isEmpty(strU2) || (fxVar = this.fx) == null || (fxVarB = fxVar.nr(fxVar).b(strU2)) == null) {
            return;
        }
        if (TextUtils.equals(strU, "onShow")) {
            fxVarB.nr(0);
        } else if (TextUtils.equals(strU, "onDismiss")) {
            fxVarB.nr(8);
        } else if (TextUtils.equals(strU, "haptic")) {
            fx(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(my myVar, sx.nr nrVar, sx.u uVar, int i, boolean z) {
        com.bytedance.adsdk.ugeno.nr.fx fxVarU;
        int i2;
        String strOptString;
        JSONObject jSONObjectWq;
        CharSequence text;
        if (myVar == null || (fxVarU = myVar.u()) == null) {
            return;
        }
        JSONObject jSONObjectFx = myVar.fx();
        String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("nodeId"), jk());
        String strU2 = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("type"), jk());
        int iOptInt = -1;
        if (TextUtils.equals(strU2, "clickEvent")) {
            strOptString = jSONObjectFx.optString("subConvertLinkTag");
            iOptInt = jSONObjectFx.optInt("dpaPosition", -1);
            i2 = 2;
        } else {
            if (TextUtils.equals(strU2, "muteVideo")) {
                this.c = jSONObjectFx.optString("muteSrc");
                this.q = jSONObjectFx.optString("unmuteSrc");
                i2 = 5;
            } else if (TextUtils.equals(strU2, "dislike")) {
                i2 = 3;
            } else if (TextUtils.equals(strU2, dc.F)) {
                i2 = 6;
            } else if (TextUtils.equals(strU2, "openPolicy")) {
                i2 = 7;
            } else if (TextUtils.equals(strU2, "openAppPolicy")) {
                i2 = 9;
            } else if (TextUtils.equals(strU2, "openAppPermission")) {
                i2 = 10;
            } else if (TextUtils.equals(strU2, "close")) {
                strOptString = "";
                i2 = 8;
            } else if (TextUtils.equals(strU2, "openAppFunctionDesc")) {
                i2 = 12;
            } else if (TextUtils.equals(strU2, "videoControl") || TextUtils.equals(strU2, "pauseVideo")) {
                i2 = 4;
            } else if (TextUtils.equals(strU2, "openCommonUrl")) {
                i2 = 13;
            } else {
                if (TextUtils.equals(strU2, "onDismiss")) {
                    com.bytedance.adsdk.ugeno.nr.fx fxVarB = myVar.u().nr(myVar.u()).b(strU);
                    if (fxVarB != null) {
                        fxVarB.nr(8);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(strU2, "onShow")) {
                    com.bytedance.adsdk.ugeno.nr.fx fxVarB2 = myVar.u().nr(myVar.u()).b(strU);
                    if (fxVarB2 != null) {
                        fxVarB2.nr(0);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(strU2, "haptic")) {
                    fx(myVar.fx());
                    return;
                }
                if (TextUtils.equals(strU2, "closeWidget")) {
                    this.o.pn();
                    return;
                } else if (TextUtils.equals(strU2, bq.b.C)) {
                    fxVarU.nr(8);
                    return;
                } else {
                    strOptString = "";
                    i2 = 0;
                }
            }
            strOptString = "";
        }
        q.u uVarPn = new q.u().b(this.mv.my()).fx(this.mv.o()).nr(this.mv.sx()).u(this.mv.bg()).u(fxVarU.ja()).nr(this.mv.s()).u(this.mv.k()).pn(strOptString).pn(iOptInt);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable unused) {
            }
        }
        View viewA = fxVarU.a();
        try {
            if ((viewA instanceof TextView) && (text = ((TextView) viewA).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.iz != null && this.qq && jSONObjectFx.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", strU2);
            }
        } catch (JSONException unused3) {
        }
        try {
            nr nrVar2 = this.x;
            if (nrVar2 != null && (jSONObjectWq = nrVar2.wq()) != null) {
                jSONObject.put("ugen_id", jSONObjectWq.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String strU3 = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("webUrl"), jk());
            String strU4 = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectFx.optString("webTitle"), jk());
            jSONObject.put("openCommonWebUrl", strU3);
            jSONObject.put("openCommonWebTitle", strU4);
        } catch (JSONException unused5) {
        }
        if (z) {
            try {
                jSONObject.put("isLottieInternalClick", true);
            } catch (JSONException unused6) {
            }
        }
        uVarPn.u(jSONObject);
        q qVarU = uVarPn.u();
        n nVar = this.f5383a;
        if (nVar != null) {
            nVar.u(viewA, i2, qVarU);
        }
        if (nrVar == null || myVar.b() == null) {
            return;
        }
        nrVar.u(myVar.b());
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar) {
        this.o = izVar;
    }

    public void u(long j, long j2) {
        com.bytedance.adsdk.ugeno.nr.fx fxVar = this.k;
        if (fxVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.b.u) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.b.u) fxVar).u(j, j2);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void u(CharSequence charSequence, int i, int i2, boolean z) {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.fx;
        if (fxVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB = fxVar.b("count_down_skip_container");
        if (fxVarB != 0 && fxVarB.a() != null) {
            fxVarB.a().setVisibility(0);
        }
        Object objB = this.fx.b("count_down");
        Object objB2 = this.fx.b(dc.F);
        if ((objB instanceof com.bytedance.adsdk.ugeno.widget.text.nr) && (objB2 instanceof com.bytedance.adsdk.ugeno.widget.text.nr)) {
            if (i2 == 0) {
                if (!TextUtils.equals(charSequence, "0") && !z) {
                    ((com.bytedance.adsdk.ugeno.widget.text.nr) objB).t(((Object) charSequence) + "s ");
                    com.bytedance.adsdk.ugeno.widget.text.nr nrVar = (com.bytedance.adsdk.ugeno.widget.text.nr) objB2;
                    nrVar.t("| 跳过");
                    nrVar.a().setVisibility(0);
                    return;
                }
                ((com.bytedance.adsdk.ugeno.widget.text.nr) objB).a().setVisibility(8);
                ((com.bytedance.adsdk.ugeno.widget.text.nr) objB2).t("跳过");
                return;
            }
            ((com.bytedance.adsdk.ugeno.widget.text.nr) objB).t(((Object) charSequence) + "s ");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.bq
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.mv.fx(motionEvent.getRawX());
            this.mv.b(motionEvent.getRawY());
            this.mv.nr(System.currentTimeMillis());
            return;
        }
        this.mv.pn((int) motionEvent.getRawX());
        this.mv.iz((int) motionEvent.getRawY());
        this.mv.u(motionEvent.getRawX());
        this.mv.nr(motionEvent.getRawY());
        this.mv.u(System.currentTimeMillis());
        this.mv.nr(motionEvent.getToolType(0));
        this.mv.fx(motionEvent.getDeviceId());
        this.mv.b(motionEvent.getSource());
    }

    public void u(com.bytedance.adsdk.ugeno.fx.n nVar) {
        this.l.add(nVar);
    }
}
