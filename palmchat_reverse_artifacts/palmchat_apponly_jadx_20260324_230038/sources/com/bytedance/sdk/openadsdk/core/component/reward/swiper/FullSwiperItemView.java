package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.iz;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.res.pn;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FullSwiperItemView extends FrameLayout implements rh.u, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5243a;
    public FrameLayout b;
    private boolean bg;
    private int bq;
    private nr dw;
    public FrameLayout fx;
    public FrameLayout iz;
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.u jk;
    private boolean k;
    private Context l;
    private com.bytedance.sdk.openadsdk.core.component.reward.iz.u mv;
    private boolean my;
    private float n;
    public FrameLayout nr;
    private final rh o;
    public FrameLayout pn;
    private int s;
    private u sx;
    private FullRewardExpressView t;
    public ViewGroup u;
    public TTProgressBar x;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(View view, float f, float f2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.u uVar, float f, float f2) {
        super(context);
        this.o = new rh(Looper.getMainLooper(), this);
        this.jk = uVar;
        this.n = f;
        this.f5243a = f2;
        this.l = context;
        setBackgroundColor(0);
        l();
        this.bq = jp.t(uVar.u());
        this.bg = uVar.u().jn() == 1;
        mv();
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.u.getContext(), this.jk.u(), h.u(8, String.valueOf(this.bq), this.n, this.f5243a), this.jk.nr(), this.bg, null);
        this.t = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().u(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b() {
    }

    public void bg() {
        FullRewardExpressView fullRewardExpressView = this.t;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mv();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
        if (uVar != null) {
            uVar.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVarYd;
        u uVar = this.sx;
        if (uVar != null) {
            uVar.u();
        }
        Context context = this.l;
        if (!(context instanceof TTBaseVideoActivity) || (uVarYd = ((TTBaseVideoActivity) context).yd()) == null || uVarYd.u() == null) {
            return;
        }
        uVarYd.u().fx();
    }

    public void k() {
        if (this.mv != null && this.k) {
            this.jk.a();
            this.t.my();
            this.my = true;
            if (bc.nr(this.jk.u())) {
                this.o.sendEmptyMessageDelayed(102, 5000L);
            }
            this.jk.u(this.t);
            if (this.t.dw()) {
                return;
            }
            this.mv.u(this.jk.jk());
        }
    }

    public void l() {
        View viewL = pn.l(this.l);
        addView(viewL);
        this.u = (ViewGroup) viewL.findViewById(2114387892);
        this.nr = (FrameLayout) viewL.findViewById(2114387778);
        this.fx = (FrameLayout) viewL.findViewById(2114387812);
        this.b = (FrameLayout) viewL.findViewById(2114387670);
        this.pn = (FrameLayout) viewL.findViewById(2114387821);
        this.iz = (FrameLayout) viewL.findViewById(2114387679);
        this.x = (TTProgressBar) viewL.findViewById(2114387767);
    }

    public void mv() {
        bc bcVarU = this.jk.u();
        if (bcVarU == null) {
            return;
        }
        float fBa = bcVarU.ba();
        int iSv = bcVarU.sv();
        float fNg = bcVarU.ng();
        float[] fArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.l.getApplicationContext(), bcVarU.ba(), bcVarU.sv());
        float f = fArrU[0];
        float f2 = fArrU[1];
        if (fBa == 100.0f) {
            this.n = f;
            this.f5243a = f2;
            return;
        }
        int[] iArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.l.getApplicationContext(), fBa, fNg, iSv);
        int i = iArrU[0];
        int i2 = iArrU[1];
        int i3 = iArrU[2];
        int i4 = iArrU[3];
        this.n = (int) ((f - i) - i3);
        this.f5243a = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void my() {
        com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
        if (uVar == null) {
            return;
        }
        uVar.iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
        u uVar = this.sx;
        if (uVar != null) {
            uVar.u();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            bc bcVarU = this.jk.u();
            if (bcVarU != null && bcVarU.tw() != null) {
                jSONObject.put("refresh_num", this.jk.u().tw().fx());
            }
        } catch (JSONException unused) {
        }
        s.u().u(this.jk.u(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.l;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void nr(int i) {
    }

    public void o() {
        com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
        if (uVar != null) {
            uVar.n();
        }
    }

    public void s() {
        if (this.jk == null) {
            return;
        }
        this.x.setVisibility(0);
        this.t.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, float f, float f2) {
                if (FullSwiperItemView.this.dw != null) {
                    FullSwiperItemView.this.dw.u(view, f, f2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, int i) {
                super.u(view, i);
            }
        });
        this.t.setExpressVideoListenerProxy(this);
        this.t.setInteractListener(this.sx);
        this.t.setOnVideoSizeChangeListener(new FullRewardExpressView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.u
            public void u(int i) {
                FullSwiperItemView.this.s = i;
            }
        });
        if (this.t.getParent() != null) {
            ((ViewGroup) this.t.getParent()).removeView(this.t);
        }
        this.pn.addView(this.t);
        this.mv = new com.bytedance.sdk.openadsdk.core.component.reward.iz.u(this.u.getContext(), this.fx, this.jk.u(), null);
        this.mv.u(new fx(this.jk.pn(), wi.fx(this.jk.u()), new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.fx.u
            public void u() {
                if (FullSwiperItemView.this.l instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.l).gc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.fx.u
            public void u(long j, long j2) {
                iz izVarSu;
                if (FullSwiperItemView.this.t == null || !(FullSwiperItemView.this.l instanceof TTBaseVideoActivity) || (izVarSu = ((TTBaseVideoActivity) FullSwiperItemView.this.l).su()) == null) {
                    return;
                }
                izVarSu.nr(j);
                FullSwiperItemView.this.t.u(String.valueOf(izVarSu.h()), (int) (izVarSu.rh() / 1000), 0, j == j2 || izVarSu.bf());
            }
        }, this.o));
        this.mv.nr(this.bg);
        this.t.setVideoController(this.mv);
        this.jk.u(this.fx, this.b, this.t);
        this.t.o();
        this.t.sx();
    }

    public void setOnSwiperItemInteractListener(u uVar) {
        this.sx = uVar;
    }

    public void setOnSwiperItemRenderResultListener(nr nrVar) {
        this.dw = nrVar;
    }

    public void sx() {
        rh rhVar = this.o;
        if (rhVar != null) {
            rhVar.removeMessages(102);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
        s.u().b(this.jk.u(), "stats_reward_full_click_express_close");
        Context context = this.l;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).yd().u().u();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            bc bcVarU = this.jk.u();
            if (bcVarU != null && bcVarU.tw() != null) {
                jSONObject.put("refresh_num", this.jk.u().tw().fx());
            }
        } catch (JSONException unused) {
        }
        s.u().u(this.jk.u(), "stats_reward_full_click_native_close", jSONObject);
        u uVar = this.sx;
        if (uVar != null) {
            uVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int fx() {
        com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
        if (uVar == null) {
            return 0;
        }
        return (int) (uVar.t() / 1000);
    }

    public void nr(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.t;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.dw()) {
            Context context = this.l;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).sx();
            }
        } else {
            this.t.u((ViewGroup) this.nr, false);
        }
        this.k = true;
        this.jk.fx(z);
        k();
        this.x.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(int i, String str) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements u.InterfaceC0302u {
        private final int b;
        private boolean fx = false;
        private final u nr;
        private final rh pn;
        private final u.InterfaceC0302u u;

        /* JADX INFO: compiled from: SearchBox */
        public interface u {
            void u();

            void u(long j, long j2);
        }

        public fx(u.InterfaceC0302u interfaceC0302u, int i, u uVar, rh rhVar) {
            this.u = interfaceC0302u;
            this.nr = uVar;
            this.b = i;
            this.pn = rhVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void fx() {
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.fx();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void nr() {
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.nr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u() {
            this.fx = false;
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u();
            }
            u uVar = this.nr;
            if (uVar != null) {
                uVar.u();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u(int i, String str) {
            this.fx = false;
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u(long j, long j2) {
            this.pn.removeMessages(102);
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u(j, j2);
            }
            u uVar = this.nr;
            if (uVar != null) {
                uVar.u(j, j2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(boolean z) {
        if (this.bg != z) {
            this.bg = z;
            com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
            if (uVar != null) {
                uVar.nr(z);
            }
            Context context = this.l;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).yd().u().nr();
            }
            u uVar2 = this.sx;
            if (uVar2 != null) {
                uVar2.u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        com.bytedance.sdk.openadsdk.core.component.reward.iz.u uVar = this.mv;
        if (uVar == null || !this.my) {
            return 2;
        }
        if (uVar.tk()) {
            return 5;
        }
        if (this.mv.c()) {
            return 1;
        }
        if (this.mv.wi()) {
            return 2;
        }
        this.mv.qq();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        return this.mv.t();
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.u uVar = this.jk;
        if (uVar != null) {
            uVar.x();
        }
        Context context = this.l;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).t();
        }
        u uVar2 = this.sx;
        if (uVar2 != null) {
            uVar2.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void pn() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(boolean z) {
    }
}
