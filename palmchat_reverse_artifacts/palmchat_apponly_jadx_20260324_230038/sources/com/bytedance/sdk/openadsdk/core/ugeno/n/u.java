package com.bytedance.sdk.openadsdk.core.ugeno.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.mv;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.fx;
import com.bytedance.sdk.openadsdk.core.ugeno.jk.fx;
import com.bytedance.sdk.openadsdk.core.ugeno.n.pn;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.openalliance.ad.constant.dc;
import com.ss.bytertc.engine.type.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements t, b, fx, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> f5386a;
    protected com.bytedance.sdk.openadsdk.core.s.x b;
    protected nr bg;
    protected InterfaceC0296u bq;
    protected ViewGroup fx;
    protected com.bytedance.sdk.openadsdk.core.ugeno.pn.u iz;
    protected int k;
    private FrameLayout kj;
    protected String l;
    protected Map<String, Object> mv;
    protected int my;
    protected com.bytedance.adsdk.ugeno.nr.fx<View> n;
    protected Context nr;
    protected int o;
    protected bc pn;
    private iz qq;
    protected JSONObject s;
    protected int sx;
    protected com.bytedance.sdk.openadsdk.core.ugeno.x.u u;
    protected com.bytedance.adsdk.ugeno.nr.fx<View> x;
    private boolean z;
    private boolean c = true;
    private boolean q = true;
    protected AtomicInteger dw = new AtomicInteger(2);
    protected AtomicInteger jk = new AtomicInteger();
    protected Map<Integer, Boolean> t = new HashMap();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.n.u$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass6 extends a {
        final /* synthetic */ com.bytedance.adsdk.ugeno.nr.fx u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(String str, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
            super(str);
            this.u = fxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            u uVar = u.this;
            com.bytedance.sdk.openadsdk.core.gi.nr.u(uVar.pn, uVar.s, new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.6.1
                @Override // com.bytedance.sdk.openadsdk.core.dw.fx
                public void u(boolean z, List<bc> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (u.this.dw.get() > 0) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            u.this.u(anonymousClass6.u);
                            u.this.dw.decrementAndGet();
                            return;
                        } else {
                            InterfaceC0296u interfaceC0296u = u.this.bq;
                            if (interfaceC0296u != null) {
                                interfaceC0296u.u();
                                return;
                            }
                            return;
                        }
                    }
                    u.this.my = list.size();
                    u.this.o += list.size();
                    u uVar2 = u.this;
                    uVar2.sx = uVar2.k();
                    bc bcVar = list.get(0);
                    if (bcVar != null) {
                        u.this.s = bcVar.yy();
                    }
                    final List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> listU = u.this.u(list);
                    bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.adsdk.ugeno.nr.fx fxVar = AnonymousClass6.this.u;
                            if (fxVar == null || !(fxVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz)) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) fxVar).nr(listU);
                        }
                    });
                }
            }, u.this.pn.tm());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.n.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0296u {
        void u();
    }

    public u(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.s.x xVar, bc bcVar, String str, int i) {
        this.nr = context;
        this.fx = viewGroup;
        this.b = xVar;
        this.pn = bcVar;
        this.l = str;
        this.u = bcVar.ja();
        iz izVar = new iz(this.nr, this.b, bcVar, str, i);
        this.qq = izVar;
        izVar.u((b) this);
        this.qq.u((fx) this);
        if (this.pn.bl() != null) {
            this.qq.u((n) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public View o() {
        this.kj = new FrameLayout(this.nr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.kj.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.nr);
        com.bytedance.sdk.openadsdk.n.nr.u(com.bytedance.sdk.openadsdk.core.n.fx.u("shop_page_guide_gif.gif")).type(3).config(Bitmap.Config.RGB_565).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.3
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my myVar) {
                Object result = myVar.getResult();
                try {
                    if (result instanceof byte[]) {
                        if (myVar.isGif()) {
                            gifView.u((byte[]) result, false);
                        } else {
                            gifView.setImageDrawable(com.bytedance.sdk.openadsdk.core.y.bg.u((byte[]) result, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str, Throwable th) {
            }
        });
        int iFx = y.fx(this.nr, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iFx, iFx);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = y.fx(this.nr, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.kj.addView(gifView);
        TextView textView = new TextView(this.nr);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = y.fx(this.nr, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.kj.addView(textView);
        this.kj.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.jk.fx(this.nr, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.jk.fx.u
            public void nr() {
                u.this.kj.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.jk.fx.u
            public void u() {
                com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = u.this.n;
                if ((fxVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) && fxVar.a() != null) {
                    ((RecyclerView) u.this.n.a()).nr(1);
                }
                u uVar = u.this;
                uVar.u(uVar.n);
                u.this.kj.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.s.b.u(u.this.pn, com.huawei.openalliance.ad.constant.x.df, "in_web_click", (com.bytedance.sdk.openadsdk.iz.u.u) null);
            }
        }, 200));
        this.kj.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.5
            @Override // java.lang.Runnable
            public void run() {
                u.this.kj.setVisibility(8);
            }
        }, 3000L);
        return this.kj;
    }

    public int k() {
        int i = this.my;
        int i2 = this.k;
        return Math.max(i < i2 ? this.o - i : this.o - i2, 0);
    }

    public abstract List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> l();

    public void mv() {
        try {
            this.f5386a = l();
            pn.u(this.u, new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u
                public void u(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        u uVar = u.this;
                        uVar.u(jSONObject, uVar.f5386a);
                        return;
                    }
                    u.this.b.u(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar2 = u.this.iz;
                    if (uVar2 != null) {
                        uVar2.u(-1);
                    }
                }
            });
        } catch (Exception e) {
            this.b.u(-3, e.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = this.iz;
            if (uVar != null) {
                uVar.u(-3);
            }
        }
    }

    public void my() {
        bc bcVar = this.pn;
        xg.nr(bcVar != null ? bcVar.n() : 0);
    }

    public boolean s() {
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB;
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVar = this.x;
        return (fxVar == null || (fxVarB = fxVar.b("interactionWebView")) == 0 || fxVarB.a() == null || fxVarB.a().getVisibility() != 0) ? false : true;
    }

    public void nr(boolean z) {
        this.z = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(bc bcVar, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        String strNr = jp.nr(this.pn);
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.nr, bcVar, strNr, jp.nr(strNr));
        Map<String, Object> mapPn = ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).pn();
        mapPn.put("click_element_type", fxVar.ja());
        Map<String, Object> map = this.mv;
        if (map != null) {
            mapPn.putAll(map);
        }
        final String strLk = bcVar.lk();
        com.bytedance.sdk.openadsdk.core.l.nr.b bVarNr = com.bytedance.sdk.openadsdk.core.l.n.nr(this.nr, bcVar, strNr, false);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u((com.bytedance.sdk.openadsdk.core.l.nr.fx) bVarNr);
        uVar.u(null, new jk());
        if (bVarNr != null) {
            bVarNr.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.9
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
        Object obj = this.nr;
        if (obj instanceof com.bytedance.sdk.openadsdk.core.n.nr) {
            ((com.bytedance.sdk.openadsdk.core.n.nr) obj).u(2);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar) {
        this.iz = uVar;
    }

    public void u(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> list) {
        this.b.nr();
        this.qq.u((t) this);
        this.qq.u(jSONObject, list, new x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = u.this.iz;
                if (uVar != null) {
                    uVar.u(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                u uVar = u.this;
                uVar.x = fxVar;
                uVar.n = uVar.qq.u();
                u.this.fx.addView(fxVar.a(), new FrameLayout.LayoutParams(fxVar.wq(), fxVar.pb()));
                if (u.this.z) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(y.fx(u.this.nr, 200.0f), y.fx(u.this.nr, 200.0f));
                    layoutParams.gravity = 17;
                    u uVar2 = u.this;
                    uVar2.fx.addView(uVar2.o(), layoutParams);
                }
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar3 = u.this.iz;
                if (uVar3 != null) {
                    uVar3.u(fxVar.a());
                }
                u uVar4 = u.this;
                com.bytedance.sdk.openadsdk.core.s.b.u(uVar4.pn, uVar4.l, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.iz.u.u) null);
            }
        });
    }

    public void u(nr nrVar) {
        this.bg = nrVar;
        iz izVar = this.qq;
        if (izVar != null) {
            izVar.u(nrVar);
        }
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        com.bytedance.sdk.component.jk.x.nr(new AnonymousClass6("shop_page", fxVar));
    }

    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> u(List<bc> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (bc bcVar : list) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx fxVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx();
            JSONObject jSONObjectEt = bcVar.et();
            try {
                jSONObjectEt.put("voice_btn_position", com.bytedance.sdk.openadsdk.core.kj.bg.k(this.pn));
            } catch (JSONException unused) {
            }
            fxVar.u(-2134548432);
            fxVar.u(jSONObjectEt);
            arrayList.add(fxVar);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.n
    public void nr(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.bl() == null) {
            return;
        }
        fxVar.nr(0);
    }

    public void u(final bc bcVar, final com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (TextUtils.equals(fxVar.ja(), dc.C)) {
            com.bytedance.adsdk.ugeno.nr.u uVarRh = fxVar.rh();
            if (uVarRh != null) {
                com.bytedance.adsdk.ugeno.nr.fx fxVarB = uVarRh.b("video_" + bcVar.ol());
                if (fxVarB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) fxVarB;
                    if (nrVar.n()) {
                        nrVar.b(false);
                        if (fxVar instanceof com.bytedance.adsdk.ugeno.widget.image.nr) {
                            ((com.bytedance.adsdk.ugeno.widget.image.nr) fxVar).nr(q.fx(this.nr, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    nrVar.b(true);
                    if (fxVar instanceof com.bytedance.adsdk.ugeno.widget.image.nr) {
                        ((com.bytedance.adsdk.ugeno.widget.image.nr) fxVar).nr(q.fx(this.nr, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.c) {
            if (!com.bytedance.sdk.openadsdk.core.ugeno.jk.iz(this.pn)) {
                u(this.pn, this.mv);
            }
            com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, this.l, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.iz.u.u) null);
            com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, this.l, "page_click", (com.bytedance.sdk.openadsdk.iz.u.u) null);
            this.c = false;
        }
        u(bcVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.jk.b) {
            bcVar.jk(1);
            bc bcVar2 = this.pn;
            if (bcVar2 != null) {
                bcVar.u(bcVar2.ja());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u(bcVar, true)) {
            com.bytedance.sdk.openadsdk.core.nr.u.nr.fx fxVar2 = new com.bytedance.sdk.openadsdk.core.nr.u.nr.fx(bcVar, this.nr);
            fxVar2.u(new fx.nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.7
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.nr
                public void u() {
                    bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bc bcVar3 = bcVar;
                            if (bcVar3 == null || bcVar3.bb() == null) {
                                return;
                            }
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            h.u(u.this.nr, bcVar.bb().b(), 0);
                        }
                    });
                    u.this.nr(bcVar, fxVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.nr
                public void u(final String str, final boolean z) {
                    bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                h.u(u.this.nr, "你已领券，快去直播间下单吧", 0);
                            } else {
                                h.u(u.this.nr, "领券失败", 0);
                            }
                        }
                    });
                    u.this.nr(bcVar, fxVar);
                }
            });
            fxVar2.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.u.8
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u
                public void u() {
                }
            });
            return;
        }
        nr(bcVar, fxVar);
    }

    private void u(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u uVarBf;
        JSONObject jSONObjectNr;
        mv mvVarU;
        if (bcVar == null || (uVarBf = bcVar.bf()) == null || (jSONObjectNr = uVarBf.nr()) == null || (mvVarU = mv.u(jSONObjectNr)) == null) {
            return;
        }
        if (mvVarU.fx() == 0 || mvVarU.fx() == 5) {
            bcVar.u(mvVarU);
        }
    }

    public void u(JSONObject jSONObject) {
        bc bcVarU;
        if (jSONObject == null || (bcVarU = com.bytedance.sdk.openadsdk.core.u.u(jSONObject)) == null) {
            return;
        }
        String strNr = jp.nr(this.pn);
        HashMap map = new HashMap();
        map.put("is_slide", this.jk);
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVarU, strNr, map, (Double) null);
        com.bytedance.sdk.openadsdk.core.bf.u.u().b();
        bc bcVar = this.pn;
        xg.u(bcVar != null ? bcVar.n() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.q && this.jk.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.jk);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.s.b.u(bcVarU, strNr, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.iz.u.u) null);
        } catch (JSONException unused) {
        }
    }

    public void u(Map<String, Object> map) {
        this.mv = map;
    }

    public void u(InterfaceC0296u interfaceC0296u) {
        this.bq = interfaceC0296u;
    }

    private void u(bc bcVar, Map<String, Object> map) {
        if (bcVar == null) {
            return;
        }
        String strNr = jp.nr(bcVar);
        int iN = y.n(dw.getContext());
        com.bytedance.sdk.openadsdk.core.s.b.u("click", bcVar, new a.u().iz(-1.0f).pn(-1.0f).b(-1.0f).fx(-1.0f).nr(-1L).u(-1L).fx(-1).b(-1).pn(ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE).nr(com.bytedance.sdk.openadsdk.core.n.o().fx() ? 1 : 2).u(iN).u(y.iz(dw.getContext())).nr(y.x(dw.getContext())).u(), strNr, true, map, -1, false, false);
    }
}
