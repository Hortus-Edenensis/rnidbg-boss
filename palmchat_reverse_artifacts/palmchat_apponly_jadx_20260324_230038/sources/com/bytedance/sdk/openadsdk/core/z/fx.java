package com.bytedance.sdk.openadsdk.core.z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.bg;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.bq;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.l;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qq;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import com.bytedance.sdk.openadsdk.my.fx.nr.pn;
import com.bytedance.sdk.openadsdk.my.fx.nr.s;
import com.bytedance.sdk.openadsdk.my.fx.nr.x;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends mv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr f5416a;
    private Dialog b;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.fx bg;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u bq;
    private TextView dw;
    private final Context fx;
    private UGenVideoOrImgPanelView gi;
    private pn iz;
    private s jk;
    private float k;
    private View l;
    private float my;
    private int n;
    private final bc nr;
    private x pn;
    private final boolean qq;
    private volatile ViewGroup t;
    private final bq u;
    private int x;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx z;
    private boolean mv = false;
    private boolean s = true;
    private AtomicBoolean o = new AtomicBoolean(false);
    private AtomicBoolean sx = new AtomicBoolean(false);
    private boolean c = false;
    private boolean q = false;
    private volatile WeakReference<NativeVideoTsView> kj = null;
    private final com.bytedance.sdk.openadsdk.core.video.nativevideo.u d = new com.bytedance.sdk.openadsdk.core.video.nativevideo.u() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.1
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.u
        public void u() {
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.1.1
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.h();
                    fx.this.ja();
                }
            }, dw.nr().ad());
        }
    };
    private volatile boolean h = false;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u rh = null;

    public fx(Context context, final bc bcVar, int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        bg.u(bcVar, "materialMeta不能为null");
        this.qq = z;
        this.nr = bcVar;
        if (context == null) {
            this.fx = dw.getContext();
        } else {
            this.fx = context;
        }
        this.x = i;
        this.f5416a = nrVar;
        bq bqVar = new bq(this.fx, this, bcVar, u(i));
        this.u = bqVar;
        bqVar.u(i);
        this.jk = u(bcVar);
        this.z = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx(bcVar, true, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int fx() {
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void nr(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(float f) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void fx(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int nr() {
                NativeVideoTsView nativeVideoTsView;
                if (fx.this.kj == null || (nativeVideoTsView = (NativeVideoTsView) fx.this.kj.get()) == null) {
                    return 0;
                }
                com.bykv.vk.openvk.component.video.api.b.fx nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.bq()) {
                    return 5;
                }
                if (nativeVideoController.c()) {
                    return 1;
                }
                return ((nativeVideoController instanceof b) && ((b) nativeVideoController).bc()) ? 2 : 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i2, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public long u() {
                NativeVideoTsView nativeVideoTsView;
                com.bykv.vk.openvk.component.video.api.b.fx nativeVideoController;
                if (fx.this.kj == null || (nativeVideoTsView = (NativeVideoTsView) fx.this.kj.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.t()) / 1000;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void nr(View view, int i2, com.bytedance.sdk.component.adexpress.fx fxVar) {
                jk jkVar;
                if ((i2 == 1 || i2 == 2) && (fxVar instanceof q)) {
                    q qVar = (q) fxVar;
                    jkVar = new jk();
                    jkVar.u(qVar.u);
                    jkVar.nr(qVar.nr);
                    jkVar.fx(qVar.fx);
                    jkVar.b(qVar.b);
                    jkVar.u(qVar.pn);
                    jkVar.nr(qVar.iz);
                    jkVar.nr(qVar.k);
                } else {
                    jkVar = null;
                }
                if (i2 == 2) {
                    fx.this.u.u(view, jkVar);
                }
                if (i2 == 1) {
                    fx.this.u.nr(view, jkVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view) {
                if (fx.this.bq != null) {
                    fx.this.bq.u(view, fx.this);
                }
                a.u(bcVar, true, 2, 3, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view, int i2, com.bytedance.sdk.component.adexpress.fx fxVar) {
                jk jkVar;
                boolean zOptBoolean = false;
                if (fxVar instanceof q) {
                    q qVar = (q) fxVar;
                    jkVar = new jk();
                    jkVar.u(qVar.u);
                    jkVar.nr(qVar.nr);
                    jkVar.fx(qVar.fx);
                    jkVar.b(qVar.b);
                    jkVar.u(qVar.pn);
                    jkVar.nr(qVar.iz);
                    jkVar.nr(qVar.k);
                    jkVar.u(true);
                    zOptBoolean = qVar.u().optBoolean("isLottieInternalClick", false);
                } else {
                    jkVar = null;
                }
                int i3 = zOptBoolean ? 2 : 1;
                boolean zU = a.u(fx.this.kj == null ? null : (NativeVideoTsView) fx.this.kj.get(), fxVar);
                if (i2 == 1) {
                    fx.this.u.nr(view, jkVar);
                    a.u(bcVar, zU, 1, i3, (JSONObject) null);
                } else if (i2 == 2) {
                    fx.this.u.u(view, jkVar);
                    a.u(bcVar, zU, 1, i3, (JSONObject) null);
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    fx.this.xg();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void iz() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void pn() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void setPauseFromExpressView(boolean z2) {
            }
        });
    }

    private boolean bf() {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.qf() == 5) {
            return false;
        }
        if (this.n == 0) {
            this.n = jp.t(this.nr);
        }
        return dw.nr().x(this.n) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.gi;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.mv();
        }
        if (this.t != null) {
            for (int childCount = this.t.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.t.getChildAt(childCount);
                if (childAt != null && childAt.getTag() != null && "U_V_I_P_V_TAG".equals(childAt.getTag())) {
                    this.t.removeView(childAt);
                }
            }
        }
        if (UGenVideoOrImgPanelView.u(this.nr)) {
            a.u(this.nr, 3);
            if (bc.nr(this.nr)) {
                b();
            } else {
                rh();
            }
            bq bqVar = this.u;
            if (bqVar != null) {
                bqVar.u((NativeExpressView) this.gi);
            }
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = this.gi;
            if (uGenVideoOrImgPanelView2 != null) {
                uGenVideoOrImgPanelView2.setAdSlot(this.f5416a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        NativeVideoTsView nativeVideoTsView;
        iz izVarU = this.z.u();
        if (izVarU != null) {
            izVarU.b();
        }
        if (!bc.nr(this.nr)) {
            this.z.u(this.t, nr(this.t));
            return;
        }
        if (this.kj == null || this.kj.get() == null) {
            nativeVideoTsView = null;
        } else {
            nativeVideoTsView = this.kj.get();
            nativeVideoTsView.setEasyPlayableEventSender(izVarU);
        }
        this.z.u(this.t, nativeVideoTsView);
    }

    private void pb() {
        if (this.t == null || this.jk == null || this.l == null) {
            return;
        }
        this.t.removeAllViews();
        if (this.l.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeAllViews();
        }
        this.t.addView(this.l);
    }

    private void rh() {
        View viewNr = nr(this.t);
        if (viewNr == null) {
            a.u(this.nr, false, 3, 1);
            return;
        }
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = new UGenVideoOrImgPanelView(this.fx, this.nr, null, viewNr, this.t, jp.nr(this.x), true);
        this.gi = uGenVideoOrImgPanelView;
        uGenVideoOrImgPanelView.setOuterDislike(this.b);
        x xVar = this.pn;
        if (xVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.nr) {
            this.gi.setDislike((com.bytedance.sdk.openadsdk.core.dislike.ui.nr) xVar);
        }
    }

    private void wq() {
        com.bytedance.sdk.openadsdk.qq.u.nr.u.fx fxVar;
        if (this.jk == null) {
            com.bytedance.sdk.openadsdk.qq.u.nr.u.fx fxVar2 = this.bg;
            if (fxVar2 != null) {
                fxVar2.u(this.t, this.f5416a.n(), this.f5416a.a(), false);
                return;
            }
            return;
        }
        if (this.o.get() && (fxVar = this.bg) != null) {
            fxVar.u(this.l, this.k, this.my, this.sx.get());
        } else {
            this.jk.u(new com.bytedance.sdk.openadsdk.kj.u.nr.u.nr(null) { // from class: com.bytedance.sdk.openadsdk.core.z.fx.7
                @Override // com.bytedance.sdk.openadsdk.kj.u.nr.u.nr
                public void nr(View view, int i) {
                    if (fx.this.bq != null) {
                        fx.this.bq.u(fx.this);
                    }
                    if (fx.this.z != null && fx.this.z.u() != null) {
                        fx.this.z.u().b();
                    }
                    if (!fx.this.nr.fx() || fx.this.nr.kv() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.o.u.u().u(fx.this.fx, fx.this.nr.kv().nr());
                }

                @Override // com.bytedance.sdk.openadsdk.kj.u.nr.u.nr
                public void u(View view, int i) {
                    if (fx.this.bq != null) {
                        fx.this.bq.u(view, fx.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.kj.u.nr.u.nr
                public void u(View view, String str, int i) {
                    fx.this.o.set(true);
                    fx fxVar3 = fx.this;
                    fxVar3.l = fxVar3.t;
                    fx fxVar4 = fx.this;
                    fxVar4.k = fxVar4.f5416a.n();
                    fx fxVar5 = fx.this;
                    fxVar5.my = fxVar5.f5416a.a();
                    if (fx.this.bg != null) {
                        fx.this.bg.u(fx.this.t, fx.this.f5416a.n(), fx.this.f5416a.a(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.kj.u.nr.u.nr
                public void u(View view, float f, float f2) {
                    fx.this.o.set(true);
                    fx.this.sx.set(true);
                    fx.this.l = view;
                    fx.this.k = f;
                    fx.this.my = f2;
                    if (fx.this.bg != null) {
                        fx.this.bg.u(view, f, f2, true);
                    }
                }
            });
            this.jk.pn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        Dialog dialog = this.b;
        if (dialog != null) {
            dialog.show();
            return;
        }
        x xVar = this.pn;
        if (xVar != null) {
            xVar.u();
        } else {
            TTDelegateActivity.u(getContext(), this.nr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public int bg() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        List<rh> listZu = bcVar.zu();
        return (listZu == null || listZu.isEmpty() || listZu.get(0) == null || !listZu.get(0).pn() || !com.bytedance.sdk.openadsdk.pn.u.n(this.nr)) ? this.nr.ol() : listZu.get(0).nr() >= listZu.get(0).fx() ? 5 : 15;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.my.fx.nr.b bq() {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.vz() == null) {
            return null;
        }
        this.nr.vz().nr(u(this.x));
        return new com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.nr.vz());
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public pn c() {
        if (this.jk != null && this.o.get()) {
            return null;
        }
        bc bcVar = this.nr;
        boolean z = bcVar != null && bcVar.qf() == 4;
        if (this.iz == null && this.u != null && z) {
            this.iz = new pn() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.5
                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.pn
                public void nr() {
                    com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU;
                    if (fx.this.rh == null || (fxVarU = fx.this.u.u()) == null) {
                        return;
                    }
                    fxVarU.b();
                }

                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.pn
                public void u() {
                    int iL;
                    if (fx.this.rh != null) {
                        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = fx.this.u.u();
                        if ((fxVarU instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) && (1 == (iL = ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVarU).l()) || 4 == iL || 6 == iL || 7 == iL)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            fx fxVar = fx.this;
                            String strU = fxVar.u(fxVar.x);
                            a.u uVar = new a.u();
                            float fIz = y.iz(fx.this.fx);
                            com.bytedance.sdk.openadsdk.core.s.b.u("click", fx.this.nr, uVar.u(fIz).u(y.n(fx.this.fx)).nr(y.x(fx.this.fx)).u(), strU, true, map, 1, false, false);
                        }
                        if (fxVarU != null) {
                            fxVarU.b(true);
                            fxVarU.u(jp.dw(fx.this.nr), false);
                        }
                    }
                }
            };
        }
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    /* JADX INFO: renamed from: dw, reason: merged with bridge method [inline-methods] */
    public l d() {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.qf() != 4) {
            return null;
        }
        return new l(this.nr);
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.h) {
            return;
        }
        fx();
    }

    public Context getContext() {
        return this.fx;
    }

    public boolean gi() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public int h_() {
        if (this.nr.pu() != null) {
            return this.nr.pu().iz();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public int i_() {
        if (this.nr.pu() != null) {
            return this.nr.pu().x();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public String j_() {
        return this.nr.j();
    }

    public bc kj() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public List<com.bytedance.sdk.openadsdk.my.fx.nr.l> o() {
        ArrayList arrayList = new ArrayList();
        if (this.nr.zu() != null && !this.nr.zu().isEmpty()) {
            Iterator<rh> it = this.nr.zu().iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.my.fx.nr.l lVarU = rh.u(it.next());
                if (lVarU != null) {
                    arrayList.add(lVarU);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void q() {
        wq();
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.nr).u(this.x).nr(this.n);
    }

    public bq qq() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.my.fx.nr.l s_() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return rh.u(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            return TextUtils.isEmpty(m.n(this.nr)) ? rh.u(0, 0, "", 0.0d) : rh.u(m.mv(this.nr), m.l(this.nr), m.n(this.nr), 0.0d);
        }
        if (zx.k(this.nr) != null) {
            return rh.u(zx.fx(this.nr), zx.b(this.nr), zx.nr(this.nr), 0.0d);
        }
        List<rh> listZu = this.nr.zu();
        if (listZu == null || listZu.isEmpty() || listZu.get(0) == null || !listZu.get(0).pn() || !com.bytedance.sdk.openadsdk.pn.u.n(this.nr)) {
            return rh.u(0, 0, "", 0.0d);
        }
        return rh.u(listZu.get(0).fx(), listZu.get(0).nr(), listZu.get(0).u(), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public int sx() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.qf();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public String t_() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar) && !TextUtils.isEmpty(m.fx(this.nr))) {
            return m.fx(this.nr);
        }
        if (dw.nr().zn()) {
            if (!TextUtils.isEmpty(this.nr.wf())) {
                return this.nr.wf();
            }
            if (this.nr.pu() != null && !TextUtils.isEmpty(this.nr.pu().fx())) {
                return this.nr.pu().fx();
            }
            if (!TextUtils.isEmpty(j_())) {
                return j_();
            }
        } else {
            if (this.nr.pu() != null && !TextUtils.isEmpty(this.nr.pu().fx())) {
                return this.nr.pu().fx();
            }
            if (!TextUtils.isEmpty(j_())) {
                return j_();
            }
            if (!TextUtils.isEmpty(this.nr.wf())) {
                return this.nr.wf();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public View u() {
        return null;
    }

    public boolean z() {
        return this.s;
    }

    private NativeVideoTsView fx(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u(int i) {
        return i != 1 ? i != 2 ? i != 5 ? i != 6 ? i != 9 ? "embeded_ad" : WifiNestConst.NestTypeConst.NEST_DRAW_AD : "stream" : "embeded_ad" : "interaction" : "banner_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public String a() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar) && !TextUtils.isEmpty(m.iz(this.nr))) {
            return m.iz(this.nr);
        }
        if (dw.nr().zn()) {
            if (!TextUtils.isEmpty(this.nr.ym())) {
                return this.nr.ym();
            }
            if (!TextUtils.isEmpty(this.nr.wf())) {
                return this.nr.wf();
            }
        } else {
            if (!TextUtils.isEmpty(this.nr.wf())) {
                return this.nr.wf();
            }
            if (!TextUtils.isEmpty(this.nr.ym())) {
                return this.nr.ym();
            }
        }
        return "";
    }

    public void b() {
        if (this.kj == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.u(this.nr, false, 3, 1);
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.kj.get();
        if (nativeVideoTsView == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.u(this.nr, false, 3, 1);
            return;
        }
        if (nativeVideoTsView.o()) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.u(this.nr, false, 3, 5);
            return;
        }
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = new UGenVideoOrImgPanelView(this.fx, this.nr, nativeVideoTsView, null, this.t, jp.nr(this.x), true);
        this.gi = uGenVideoOrImgPanelView;
        uGenVideoOrImgPanelView.setOuterDislike(this.b);
        x xVar = this.pn;
        if (xVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.nr) {
            this.gi.setDislike((com.bytedance.sdk.openadsdk.core.dislike.ui.nr) xVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public String jk() {
        return this.nr.yb();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public Map<String, Object> k() {
        bc bcVar = this.nr;
        if (bcVar != null) {
            return bcVar.sj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.my.fx.nr.l my() {
        return com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr) ? TextUtils.isEmpty(m.a(this.nr)) ? rh.u(0, 0, "", 0.0d) : rh.u(m.t(this.nr), m.jk(this.nr), m.a(this.nr), 0.0d) : this.nr.dd() == null ? rh.u(0, 0, "", 0.0d) : rh.u(this.nr.dd());
    }

    public void pn() {
        if (this.kj == null || this.kj.get() == null) {
            return;
        }
        this.kj.get().setEasyPlayableEventSender(this.z.u());
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public int t() {
        if (this.nr.pu() != null) {
            return this.nr.pu().pn();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public Bitmap x() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return BitmapFactory.decodeResource(this.fx.getResources(), com.bytedance.sdk.component.utils.q.pn(dw.getContext(), "tt_ad_logo_new"));
        }
        String strUc = bcVar.uc();
        if (TextUtils.isEmpty(strUc)) {
            return BitmapFactory.decodeResource(this.fx.getResources(), com.bytedance.sdk.component.utils.q.pn(dw.getContext(), "tt_ad_logo_new"));
        }
        if (this.dw == null) {
            this.dw = new TextView(dw.getContext());
            this.dw.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        y.u(this.dw, strUc, dw.getContext());
        return y.x(this.dw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(List<View> list, View view) {
        if (view != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 == view) {
                    return true;
                }
                if ((view2 instanceof ViewGroup) && u((ViewGroup) view2, view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.u uVar2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View nr(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            u(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView2 = arrayList.get(i);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void fx() {
        this.h = true;
        s sVar = this.jk;
        if (sVar != null) {
            sVar.iz();
        }
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv());
        }
        bq bqVar = this.u;
        if (bqVar != null) {
            bqVar.nr();
        }
        this.z.nr();
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.gi;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.mv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        bg.u(viewGroup != null || this.sx.get(), "container不能为null");
        bg.u(view != null || this.sx.get(), "clickView不能为null");
        this.t = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        u(viewGroup, arrayList, null, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void nr(Activity activity) {
        if (activity != null) {
            this.u.u(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b nr() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void nr(final Dialog dialog, final Integer[] numArr) {
        s sVar = this.jk;
        if (sVar != null) {
            sVar.u(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.6
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVarVz = fx.this.nr != null ? fx.this.nr.vz() : null;
                    if (nrVarVz != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.u.nr.u(nrVarVz, dialog, numArr);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        u(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        boolean z = false;
        bg.u(viewGroup != null || this.sx.get(), "container不能为null");
        bg.u(list != null || this.sx.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        bg.u(z, "clickViews数量必须大于等于1");
        this.t = viewGroup;
        u(viewGroup, list, list2, (View) null, uVar);
    }

    private void fx(Activity activity) {
        Context context = this.fx;
        Context context2 = activity;
        if (context instanceof Activity) {
            context2 = activity;
            if (!((Activity) context).isFinishing()) {
                context2 = this.fx;
            }
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(context2, this.nr.vz(), u(this.x), false, com.bytedance.sdk.openadsdk.n.nr.u());
        this.pn = nrVar;
        com.bytedance.sdk.openadsdk.core.dislike.fx.u(context2, this.nr, nrVar);
    }

    public void nr(boolean z) {
        this.mv = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        bq bqVar = this.u;
        if (bqVar != null) {
            bqVar.u(d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        boolean z = false;
        bg.u(viewGroup != null || this.sx.get(), "container不能为null");
        bg.u(list != null || this.sx.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        bg.u(z, "clickViews数量必须大于等于1");
        this.t = viewGroup;
        u(viewGroup, null, list, list2, view, uVar);
    }

    private void fx(boolean z) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(this.x, this.nr, z);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        boolean z = false;
        bg.u(viewGroup != null || this.sx.get(), "container不能为null");
        bg.u(list2 != null || this.sx.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        bg.u(z, "clickViews数量必须大于等于1");
        this.t = viewGroup;
        u(viewGroup, list, list2, list3, (List<View>) null, view, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        int i;
        List<View> listU = list3;
        boolean z = false;
        bg.u(viewGroup != null || this.sx.get(), "container不能为null");
        bg.u(list2 != null || this.sx.get(), "clickView不能为null");
        bg.u(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.t = viewGroup;
        this.bq = uVar;
        if (listU != null && list3.size() > 0) {
            z = true;
        }
        fx(z);
        if (bf()) {
            listU = u(list2, listU);
        }
        List<View> list5 = listU;
        if (this.sx.get() && ((i = this.x) == 5 || i == 1 || i == 9)) {
            pb();
        }
        if (!this.sx.get()) {
            bq bqVar = this.u;
            if (bqVar != null) {
                bqVar.u(this.d);
                this.u.u(viewGroup, list, list2, list5, list4, view, uVar, this.rh);
            }
            u(viewGroup);
        }
        x xVar = this.pn;
        if (xVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.nr) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.nr) xVar).u(this.t);
        }
        if (!dw.nr().a() || bc.nr(this.nr) || com.bytedance.sdk.openadsdk.pn.u.n(this.nr)) {
            return;
        }
        u(viewGroup, list, list2, list5, list4);
    }

    private void u(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4) {
        com.bytedance.sdk.openadsdk.gi.x.fx(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    View viewNr = fx.this.nr(viewGroup);
                    com.bytedance.sdk.openadsdk.core.qq.s.u().u(fx.this.nr, fx.this.x, fx.nr((List<View>) list2, viewNr) ? 1 : fx.nr((List<View>) list3, viewNr) ? 2 : fx.nr((List<View>) list4, viewNr) ? 3 : fx.nr((List<View>) list, viewNr) ? 4 : 0, viewNr);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean u(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            if (viewGroup == view) {
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt == view) {
                    return true;
                }
                if (childAt instanceof ViewGroup) {
                    return u((ViewGroup) childAt, view);
                }
            }
        }
        return false;
    }

    private void u(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    u((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> u(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public void u(WeakReference<NativeVideoTsView> weakReference) {
        this.kj = weakReference;
        bq bqVar = this.u;
        if (bqVar != null) {
            bqVar.u(weakReference);
        }
    }

    public void u(ViewGroup viewGroup) {
        if (viewGroup != null && this.qq && t.u(this.nr)) {
            NativeVideoTsView nativeVideoTsViewFx = fx(viewGroup);
            if (nativeVideoTsViewFx != null) {
                if (5 == this.x) {
                    nativeVideoTsViewFx.setIsAutoPlay(this.mv ? this.f5416a.pn() : this.s);
                    return;
                } else {
                    nativeVideoTsViewFx.setIsAutoPlay(this.s);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.fx, this.nr, false, false, jp.nr(this.x), false, false);
            if (5 == this.x) {
                nativeVideoTsView.setIsAutoPlay(this.mv ? this.f5416a.pn() : this.s);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.s);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        bg.u(fxVar, "downloadListener不能为null");
        this.u.u(u.C0270u.u(fxVar));
        s sVar = this.jk;
        if (sVar != null) {
            sVar.u(fxVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public x u(Activity activity) {
        if (this.jk != null && this.sx.get()) {
            return this.jk.u(activity);
        }
        if (this.pn == null) {
            fx(activity);
        }
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public x u(final Dialog dialog, Integer[] numArr) {
        if (dialog != null) {
            com.bytedance.sdk.openadsdk.core.dislike.u.nr.u(this.nr.vz(), dialog, numArr);
            return new x() { // from class: com.bytedance.sdk.openadsdk.core.z.fx.4
                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
                public boolean fx() {
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
                public void u(com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
                public void u(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
                public void u() {
                    if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                        dialog.show();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
                public void nr() {
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.fx fxVar) {
        this.bg = fxVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        this.z.u(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        s sVar;
        if (uVar == null || activity == null || (sVar = this.jk) == null) {
            return;
        }
        sVar.u(activity, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.mv
    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.nr, str);
    }

    private s u(bc bcVar) {
        bc bcVar2 = this.nr;
        if (bcVar2 == null || tk.u(bcVar2) != 2) {
            return null;
        }
        boolean z = zx.k(bcVar) != null;
        int i = this.x;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.fx(this.fx, bcVar, this.f5416a);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.nr(this.fx, bcVar, this.f5416a);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.q(this.fx, bcVar, this.f5416a);
        }
        if (z) {
            return new qq(this.fx, bcVar, this.f5416a);
        }
        return new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this.fx, bcVar, this.f5416a);
    }

    private void u(Dialog dialog) {
        if (dialog == null) {
            k.u("dialog is null, please check");
        } else {
            this.b = dialog;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.c) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.nr, d);
        this.c = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.q) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.nr, d, str, str2);
        this.q = true;
    }

    public void u(boolean z) {
        this.s = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar) {
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv(), nrVar, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar) {
        this.rh = uVar;
    }
}
