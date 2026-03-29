package com.bytedance.sdk.openadsdk.core.ugeno.jk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.s.x;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import com.bytedance.sdk.openadsdk.core.ugeno.n.pn;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.ugeno.n.u implements rh.u {
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr c;
    private AtomicBoolean d;
    private boolean gi;
    private com.bytedance.sdk.openadsdk.core.dw.fx kj;
    private boolean q;
    private final Handler qq;
    private long z;

    public nr(Context context, ViewGroup viewGroup, x xVar, bc bcVar, String str, int i) {
        super(context, viewGroup, xVar, bcVar, str, i);
        this.q = false;
        this.qq = new rh(Looper.getMainLooper(), this);
        this.gi = true;
        this.d = new AtomicBoolean();
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b() {
    }

    public void bg() {
        Handler handler = this.qq;
        if (handler != null) {
            handler.removeMessages(10081);
            this.qq.removeMessages(10082);
        }
    }

    public void bq() {
        this.qq.removeMessages(10082);
    }

    public void dw() {
        if (jk.nr(this.pn)) {
            this.qq.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int fx() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.u
    public void my() {
        super.my();
        com.bytedance.sdk.openadsdk.core.playable.nr.u().nr(this.pn);
        bg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        return 0;
    }

    public void o() {
        ScrollView scrollView = new ScrollView(this.nr);
        LinearLayout linearLayout = new LinearLayout(this.nr);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.nr);
        q.u(this.nr, "tt_ecomm_page_backup_img", imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = y.fx(this.nr, 10.0f);
        layoutParams.leftMargin = y.fx(this.nr, 10.0f);
        layoutParams.rightMargin = y.fx(this.nr, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.nr);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        q.u(this.nr, "tt_ecomm_page_backup_img", imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = y.fx(this.nr, 10.0f);
        layoutParams2.leftMargin = y.fx(this.nr, 10.0f);
        layoutParams2.rightMargin = y.fx(this.nr, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.fx.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void pn() {
    }

    public void sx() {
        bg();
        if (this.gi) {
            this.gi = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.z);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, com.huawei.openalliance.ad.constant.x.df, "agg_stay_page", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.nr.3
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.u
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> l() {
        this.f5386a = new ArrayList();
        JSONObject jSONObjectEt = this.pn.et();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            jSONObjectEt.put("env_info", jSONObject);
        } catch (JSONException unused) {
        }
        this.f5386a.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx(jSONObjectEt, -2134548432));
        return this.f5386a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.u
    public void mv() {
        try {
            this.k = jk.u(this.pn);
            JSONObject jSONObjectYy = this.pn.yy();
            this.kj = new com.bytedance.sdk.openadsdk.core.dw.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.nr.1
                @Override // com.bytedance.sdk.openadsdk.core.dw.fx
                public void u(boolean z, List<bc> list, boolean z2) {
                    if (!z) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.get() > 0) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.get();
                            ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.decrementAndGet();
                            nr.this.mv();
                            return;
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).b.u(-3, "ad meta info load fail");
                            if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz != null) {
                                ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz.u(-3);
                                return;
                            }
                            return;
                        }
                    }
                    if (list != null && list.size() > 0) {
                        nr.this.nr(list);
                        return;
                    }
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.get() <= 0) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz != null) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz.u(-2);
                        }
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.get();
                        ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).dw.decrementAndGet();
                        nr.this.mv();
                    }
                }
            };
            bc bcVar = this.pn;
            boolean z = false;
            if ((bcVar == null || bcVar.bf() == null || this.pn.bf().fx() == null || this.pn.bf().fx().optInt("use_gnd_prefetch", 0) == 1) && com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.pn, this.kj)) {
                z = true;
            }
            if (z) {
                return;
            }
            bc bcVar2 = this.pn;
            com.bytedance.sdk.openadsdk.core.gi.nr.u(bcVar2, jSONObjectYy, this.kj, bcVar2.tm());
        } catch (Exception e) {
            if (this.dw.get() > 0) {
                this.dw.get();
                this.dw.decrementAndGet();
                mv();
            } else {
                this.b.u(-3, e.getMessage());
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = this.iz;
                if (uVar != null) {
                    uVar.u(-3);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void nr(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void b(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void iz(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        JSONObject jSONObjectJk;
        if (fxVar == null || (jSONObjectJk = fxVar.jk()) == null) {
            return;
        }
        Object objB = fxVar.b("video_".concat(String.valueOf(jSONObjectJk.optInt("image_mode"))));
        if (objB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) objB).lf();
        }
    }

    public void pn(int i) {
        if (i == 0) {
            if (this.d.get()) {
                return;
            }
            this.qq.sendEmptyMessageDelayed(10081, 5000L);
            return;
        }
        if (this.d.get()) {
            com.bytedance.sdk.openadsdk.core.ugeno.n.nr nrVar = this.bg;
            if (nrVar != null) {
                nrVar.nr();
            }
            this.d.set(false);
        }
        this.qq.removeMessages(10081);
        this.qq.removeMessages(10082);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f, float f2, float f3, float f4, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(@NonNull List<bc> list) {
        this.my = list.size();
        this.o = list.size();
        this.sx = k();
        bc bcVar = list.get(0);
        if (bcVar != null) {
            this.s = bcVar.yy();
        }
        this.f5386a = u(list);
        pn.u(this.u, new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.jk.nr.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u
            public void u(JSONObject jSONObject) {
                if (jSONObject != null) {
                    nr nrVar = nr.this;
                    nrVar.u(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx>) ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nrVar).f5386a);
                } else {
                    ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).b.u(-1, "template info load fail");
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz != null) {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.n.u) nr.this).iz.u(-1);
                    }
                }
            }
        });
    }

    public void fx(boolean z) {
        this.q = z;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.c;
        if (nrVar != null) {
            nrVar.b(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.fx
    public void fx(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        bc bcVarU;
        if (fxVar == null) {
            return;
        }
        if (fxVar.jk().has("ugen_sub_meta")) {
            bcVarU = com.bytedance.sdk.openadsdk.core.u.u(fxVar.jk().optJSONObject("ugen_sub_meta"));
        } else {
            bcVarU = com.bytedance.sdk.openadsdk.core.u.u(fxVar.jk());
        }
        if (bcVarU != null) {
            u(bcVarU, fxVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(int i, int i2) {
        if (i2 > 0) {
            this.jk.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(RecyclerView recyclerView, int i) {
        if (jk.nr(this.pn)) {
            pn(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void pn(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        JSONObject jSONObjectJk;
        if (fxVar == null || (jSONObjectJk = fxVar.jk()) == null) {
            return;
        }
        Object objB = fxVar.b("video_".concat(String.valueOf(jSONObjectJk.optInt("image_mode"))));
        if (objB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) objB;
            this.c = nrVar;
            nrVar.b(this.q);
            this.c.ay();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.b
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx fxVar2) {
        if (fxVar2 == null || fxVar2.u() == null) {
            return;
        }
        int iHashCode = fxVar2.u().hashCode();
        if (this.t.get(Integer.valueOf(iHashCode)) != null && this.t.containsKey(Integer.valueOf(iHashCode)) && this.t.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        u(fxVar2.u());
        if (i == this.sx) {
            u(fxVar);
        }
        this.t.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException unused) {
        }
        if (this.jk.get() == 1) {
            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.l, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.c;
        if (nrVar == null) {
            k.nr("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            nrVar.eh();
        } else if (i == 3) {
            nrVar.v();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i != 10081) {
            if (i != 10082) {
                return;
            }
            if (this.d.get()) {
                u(q.u(this.nr, "tt_ecomm_page_reward_slide_tip"));
                this.qq.sendEmptyMessageDelayed(10082, 6000L);
                return;
            } else {
                this.qq.removeMessages(10082);
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.n.nr nrVar = this.bg;
        if (nrVar != null) {
            nrVar.u();
            this.d.set(true);
            u(q.u(this.nr, "tt_ecomm_page_reward_slide_tip"));
            this.qq.sendEmptyMessageDelayed(10082, 6000L);
        }
    }

    public void u(String str) {
        ViewGroup viewGroup = this.fx;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        h.nr(this.nr, str, 0, 49, 0, 60);
    }
}
