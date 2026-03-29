package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nr.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bq {
    private com.bytedance.sdk.openadsdk.my.fx.nr.mv b;
    private UpieImageView bf;
    private com.bytedance.sdk.openadsdk.core.l.nr.u bg;
    private EmptyView c;
    private Activity d;
    private volatile com.bytedance.sdk.openadsdk.core.l.nr.fx fx;
    private com.bytedance.sdk.openadsdk.core.nr.u gi;
    private WeakReference<NativeVideoTsView> h;
    private final com.bytedance.sdk.openadsdk.core.s.pn iz;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.u ja;
    private View k;
    private volatile com.bytedance.sdk.openadsdk.core.nr.u kj;
    private ViewGroup mv;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u my;
    private com.bytedance.sdk.openadsdk.qq.u.nr.u.u n;
    private final Context nr;
    private View q;
    private volatile com.bytedance.sdk.openadsdk.core.nr.nr qq;
    private WeakReference<ViewGroup> s;
    private com.bytedance.sdk.component.utils.qq sx;
    private final bc u;
    private u wq;
    private String x;
    private com.bytedance.sdk.openadsdk.core.nr.u z;
    private List<View> pn = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Double f5216a = null;
    private AtomicBoolean jk = new AtomicBoolean(false);
    private AtomicBoolean t = new AtomicBoolean(false);
    private AtomicBoolean l = new AtomicBoolean(false);
    private int o = 5;
    private volatile long bq = 0;
    private volatile boolean dw = true;
    private volatile boolean rh = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements View.OnLayoutChangeListener {
        private final ViewGroup nr;
        private final com.bytedance.sdk.openadsdk.core.s.pn u;

        public u(com.bytedance.sdk.openadsdk.core.s.pn pnVar, ViewGroup viewGroup) {
            this.u = pnVar;
            this.nr = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.u.u(wq.nr(this.nr), 17);
        }
    }

    public bq(Context context, com.bytedance.sdk.openadsdk.my.fx.nr.mv mvVar, bc bcVar, String str) {
        this.x = "embeded_ad";
        this.b = mvVar;
        this.u = bcVar;
        this.nr = context;
        this.x = str;
        this.iz = new com.bytedance.sdk.openadsdk.core.s.pn(bcVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.fx != null) {
            if (this.qq != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.qq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
            }
            if (this.kj != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.kj.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVar = this.gi;
            if (uVar != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVar2 = this.z;
            if (uVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.fx);
            }
            try {
                this.fx.u(false);
                this.fx.u(this.bg);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        bc bcVar = this.u;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        if (this.rh) {
            b();
        } else {
            this.rh = true;
            com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("feed_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bq.1
                @Override // java.lang.Runnable
                public void run() {
                    if (bq.this.fx == null) {
                        bq bqVar = bq.this;
                        bqVar.fx = com.bytedance.sdk.openadsdk.core.l.n.u(bqVar.nr, bq.this.u, bq.this.x, false);
                    }
                    bq.this.fx.u(bq.this.d);
                    bq.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        com.bytedance.sdk.openadsdk.core.kj.t tVarPn = pn();
        if (tVarPn == null) {
            return;
        }
        final float fNr = tVarPn.nr();
        final float fFx = tVarPn.fx();
        if (this.sx == null) {
            this.sx = new com.bytedance.sdk.component.utils.qq(dw.getContext(), 1, n.o().pn(), dw.nr().jk());
        }
        this.sx.nr(this.u.qv());
        this.sx.u(this.u.xs());
        this.sx.nr(this.u.bi());
        this.sx.iz(this.u.ki());
        this.sx.fx(this.u.or());
        this.sx.u(this.u.gz());
        this.sx.pn(this.u.zq());
        this.sx.u(new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.bq.7
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i) {
                if (i == 1 && bq.this.dw && wq.u(bq.this.mv)) {
                    com.bytedance.sdk.openadsdk.core.y.pb.u(bq.this.s, fNr, fFx, bq.this.bq);
                }
            }
        });
        com.bytedance.sdk.component.utils.qq qqVar = this.sx;
        bc bcVar = this.u;
        qqVar.u(bcVar != null ? bcVar.n() : 0);
    }

    private View nr(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String string = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                string = obj.toString();
            }
            if ("shake_compat".equals(string)) {
                return childAt;
            }
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.core.kj.t pn() {
        bc bcVar;
        com.bytedance.sdk.openadsdk.core.kj.t tVarTn;
        if (this.o == 5 && (bcVar = this.u) != null && (tVarTn = bcVar.tn()) != null && tVarTn.u() == 1) {
            return tVarTn;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> x() {
        NativeVideoTsView nativeVideoTsView;
        HashMap map = new HashMap();
        if (this.pn != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.pn) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            map.put("image_view", jSONArray.toString());
        }
        if (this.mv != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.mv.getWidth());
                jSONObject2.put("height", this.mv.getHeight());
                jSONObject2.put("alpha", this.mv.getAlpha());
            } catch (Throwable unused2) {
            }
            map.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.h;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("width", nativeVideoTsView.getWidth());
                jSONObject3.put("height", nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            map.put("video_view", jSONObject3.toString());
        }
        return map;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.mv mvVar) {
        this.b = mvVar;
    }

    public void u(Activity activity) {
        this.d = activity;
        if (this.fx != null) {
            this.fx.u(activity);
        }
    }

    private EmptyView fx(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void u(View view, int i) {
        com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar = this.n;
        if (uVar != null) {
            uVar.nr(view, this.b);
        }
    }

    public void nr(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
        if (this.qq != null) {
            this.qq.u(view, jkVar);
        }
    }

    public void u(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            if (this.kj != null) {
                nativeExpressView.setClickCreativeListener(this.kj);
            }
            if (this.qq != null) {
                nativeExpressView.setClickListener(this.qq);
            }
        }
    }

    public void nr() {
        u uVar;
        if (this.fx != null) {
            this.fx.nr();
        }
        WeakReference<ViewGroup> weakReference = this.s;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.mv;
        final EmptyView emptyView = this.c;
        if (viewGroup != null && emptyView != null) {
            com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
            u uVar2 = this.wq;
            if (uVar2 != null) {
                viewGroup.removeOnLayoutChangeListener(uVar2);
            }
        }
        final View view = this.q;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.10
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.bytedance.sdk.component.utils.qq qqVar = this.sx;
        if (qqVar != null) {
            bc bcVar = this.u;
            qqVar.nr(bcVar != null ? bcVar.n() : 0);
        }
        bc bcVar2 = this.u;
        com.bytedance.sdk.openadsdk.core.y.xg.nr(bcVar2 != null ? bcVar2.n() : 0);
        UpieImageView upieImageView = this.bf;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
        if (this.o == 9 && this.mv != null) {
            com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr(this.mv.getContext(), this.u, true);
        }
        if (viewGroup != null && (uVar = this.wq) != null) {
            viewGroup.removeOnLayoutChangeListener(uVar);
        }
        com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bq.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.s.pn pnVar = bq.this.iz;
                if (pnVar != null) {
                    pnVar.u(16);
                }
            }
        });
    }

    public void u(UpieImageView upieImageView) {
        this.bf = upieImageView;
        if (upieImageView == null || this.qq == null) {
            return;
        }
        this.bf.setOnClickListener(this.qq);
    }

    public com.bytedance.sdk.openadsdk.core.l.nr.fx u() {
        return this.fx;
    }

    public void u(final ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar2) {
        EmptyView emptyView;
        this.n = uVar;
        this.mv = viewGroup;
        this.s = new WeakReference<>(this.mv);
        this.k = view;
        this.my = uVar2;
        com.bytedance.sdk.openadsdk.core.s.b.u(this.u);
        Context context = this.nr;
        bc bcVar = this.u;
        String str = this.x;
        this.gi = new com.bytedance.sdk.openadsdk.core.nr.u(context, bcVar, str, jp.nr(str));
        u uVar3 = new u(this.iz, viewGroup);
        this.wq = uVar3;
        viewGroup.addOnLayoutChangeListener(uVar3);
        u(viewGroup);
        EmptyView emptyViewFx = fx(viewGroup);
        if (emptyViewFx == null) {
            bc bcVar2 = this.u;
            EmptyView emptyView2 = new EmptyView(this.nr, viewGroup, bcVar2 != null ? bcVar2.re() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.bq.3
                @Override // android.view.View
                public void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    com.bytedance.sdk.component.utils.qq qqVar = bq.this.sx;
                    if (qqVar == null) {
                        return;
                    }
                    try {
                        bq.this.dw = isShown();
                        if (isShown()) {
                            qqVar.u(bq.this.u != null ? bq.this.u.n() : 0);
                        } else {
                            qqVar.nr(bq.this.u != null ? bq.this.u.n() : 0);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView2.u(this.u, this.x);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = emptyViewFx;
        }
        emptyView.u();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.c = emptyView;
        u(this.gi, this.mv, this.k, uVar, this.my, 3);
        this.pn = list;
        Context context2 = this.nr;
        bc bcVar3 = this.u;
        String str2 = this.x;
        this.qq = new com.bytedance.sdk.openadsdk.core.nr.nr(context2, bcVar3, str2, jp.nr(str2));
        u(this.qq, viewGroup, view, uVar, uVar2, 0);
        Context context3 = this.nr;
        bc bcVar4 = this.u;
        String str3 = this.x;
        this.kj = new com.bytedance.sdk.openadsdk.core.nr.u(context3, bcVar4, str3, jp.nr(str3));
        u(this.kj, viewGroup, view, uVar, uVar2, 1);
        if (!com.bytedance.sdk.component.utils.mv.u(list4)) {
            Context context4 = this.nr;
            bc bcVar5 = this.u;
            String str4 = this.x;
            com.bytedance.sdk.openadsdk.core.nr.u uVar4 = new com.bytedance.sdk.openadsdk.core.nr.u(context4, bcVar5, str4, jp.nr(str4));
            this.z = uVar4;
            uVar4.u(2);
            u(this.z, viewGroup, view, uVar, uVar2, 2);
        }
        UpieImageView upieImageView = this.bf;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(this.qq);
        }
        emptyView.u(list2, this.qq);
        emptyView.u(list3, this.kj);
        emptyView.u(list4, this.z);
        emptyView.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.bq.4
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                if (bq.this.fx != null) {
                    bq.this.fx.nr();
                }
                try {
                    if (bq.this.sx != null) {
                        bq.this.sx.nr(bq.this.u != null ? bq.this.u.n() : 0);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.nr("ShakeUtils", "onPause error:" + th.getMessage());
                }
                bq.this.jk.set(false);
                bq.this.t.set(false);
                if (bq.this.o == 9) {
                    com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr(bq.this.mv.getContext(), bq.this.u, true);
                }
                bq.this.iz.u(wq.nr(viewGroup), 15);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z) {
                bq.this.iz.u(wq.nr(viewGroup), z ? 12 : 13);
                com.bytedance.sdk.component.utils.qq qqVar = bq.this.sx;
                if (qqVar != null) {
                    if (z) {
                        qqVar.u(bq.this.u != null ? bq.this.u.n() : 0);
                    } else {
                        try {
                            qqVar.nr(bq.this.u != null ? bq.this.u.n() : 0);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.k.nr("ShakeUtils", "onPause error:" + th.getMessage());
                        }
                    }
                }
                if (bq.this.o == 9) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(bq.this.mv.getContext(), bq.this.u, jp.qq(bq.this.u));
                    } else {
                        com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr(bq.this.mv.getContext(), bq.this.u, true);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                bq.this.fx();
                if (bq.this.o == 9) {
                    com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(bq.this.mv.getContext(), bq.this.u, jp.qq(bq.this.u));
                }
                bq.this.iz.u(wq.nr(viewGroup), 14);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view2, Map<String, Object> map) {
                com.bytedance.sdk.openadsdk.core.pn.u.u(bq.this.o, bq.this.u);
                bq.this.fx();
                bq.this.iz.u(wq.nr(viewGroup), 11);
                Map mapX = bq.this.x();
                mapX.put("is_repeat", Boolean.valueOf(bq.this.l.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapX.put("show_send_type", map.get("show_send_type"));
                }
                mapX.put("is_repeat", Boolean.valueOf(bq.this.l.get()));
                bq.this.jk.set(true);
                if (!bq.this.t.get()) {
                    bq.this.t.set(true);
                    com.bytedance.sdk.openadsdk.core.s.b.u(bq.this.u, bq.this.x, (Map<String, Object>) mapX, bq.this.f5216a);
                    com.bytedance.sdk.openadsdk.core.bf.u.u().b();
                    com.bytedance.sdk.openadsdk.core.y.xg.u(bq.this.u != null ? bq.this.u.n() : 0);
                }
                if (uVar != null) {
                    boolean zVp = dw.nr().vp();
                    if (!bq.this.l.getAndSet(true) || zVp) {
                        uVar.u(bq.this.b);
                        if (bq.this.u != null && bq.this.u.fx() && bq.this.u.kv() != null) {
                            com.bytedance.sdk.openadsdk.core.o.u.u().u(bq.this.nr, bq.this.u.kv().nr());
                        }
                    }
                    bq.this.bq = System.currentTimeMillis();
                    bq.this.iz();
                }
                if (bq.this.ja != null) {
                    bq.this.ja.u();
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        fx();
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nativevideo.u uVar) {
        this.ja = uVar;
    }

    public void u(WeakReference<NativeVideoTsView> weakReference) {
        this.h = weakReference;
    }

    private void u(final com.bytedance.sdk.openadsdk.core.nr.nr nrVar, ViewGroup viewGroup, View view, final com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar, final com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar2, int i) {
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        if (i != 3) {
            HashMap map = new HashMap();
            map.put("click_type", 1);
            ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
        }
        nrVar.u(viewGroup);
        nrVar.nr(view);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.b);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.bq.5
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
            public void u(View view2, int i2) {
                if (nrVar instanceof com.bytedance.sdk.openadsdk.core.nr.u) {
                    com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.nr(view2, bq.this.b);
                    }
                    com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar4 = uVar2;
                    if (uVar4 != null) {
                        uVar4.nr(view2, bq.this.b);
                    }
                } else {
                    com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar5 = uVar;
                    if (uVar5 != null) {
                        uVar5.u(view2, bq.this.b);
                    }
                    com.bytedance.sdk.openadsdk.qq.u.nr.u.u uVar6 = uVar2;
                    if (uVar6 != null) {
                        uVar6.u(view2, bq.this.b);
                    }
                }
                if (i2 != 2 || bq.this.u == null) {
                    return;
                }
                bq.this.u.fx(true);
            }
        });
    }

    public void u(int i) {
        this.o = i;
    }

    private void u(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View viewNr = nr(viewGroup);
        if (viewNr != null) {
            HashMap map = new HashMap();
            map.put("tag", "shake_compat");
            map.put("click_listener", this.gi);
            try {
                viewNr.setTag(com.bytedance.sdk.openadsdk.core.y.pb.u, map);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.nr("ShakeUtils", "onPause error:" + th.getMessage());
                com.bytedance.sdk.openadsdk.core.y.pb.u(com.bytedance.sdk.openadsdk.core.y.pb.u, th.getMessage());
            }
            this.q = viewNr;
            return;
        }
        View view = new View(this.nr);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.bq.6
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (bq.this.sx != null) {
                        bq.this.sx.nr(bq.this.u != null ? bq.this.u.n() : 0);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.k.nr("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }
        });
        HashMap map2 = new HashMap();
        map2.put("tag", "shake_compat");
        map2.put("click_listener", this.gi);
        try {
            view.setTag(com.bytedance.sdk.openadsdk.core.y.pb.u, map2);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.k.nr("ShakeUtils", "onPause error:" + th2.getMessage());
            com.bytedance.sdk.openadsdk.core.y.pb.u(com.bytedance.sdk.openadsdk.core.y.pb.u, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.q = view;
    }

    public void u(final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar) {
        fxVar.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.bq.8
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar.u(bq.this.c);
                fxVar.u(bq.this.x());
                fxVar.u(bq.this.x);
                fxVar.u(bq.this.f5216a);
                return bq.this.jk.get();
            }
        });
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
        this.bg = uVar;
    }

    public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
        if (this.kj != null) {
            this.kj.u(view, jkVar);
        }
    }

    public void u(Double d) {
        this.f5216a = d;
    }
}
