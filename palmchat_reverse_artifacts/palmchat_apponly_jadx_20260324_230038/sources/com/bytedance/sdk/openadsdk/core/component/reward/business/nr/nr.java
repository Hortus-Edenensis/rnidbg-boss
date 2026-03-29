package com.bytedance.sdk.openadsdk.core.component.reward.business.nr;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.jk;
import com.bytedance.sdk.openadsdk.core.component.reward.u.b;
import com.bytedance.sdk.openadsdk.core.component.reward.u.n;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.my.fx.nr.k;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u {
    private int iz;
    private boolean n;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u nr;
    private final u.InterfaceC0245u u;
    private final AtomicBoolean fx = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean pn = new AtomicBoolean(false);
    private int x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5227a = true;
    private String jk = "";
    private String t = "";
    private String l = "";
    private String mv = "";
    private String s = "";

    public nr(u.InterfaceC0245u interfaceC0245u) {
        this.u = interfaceC0245u;
    }

    private void t() {
        x.nr(new a("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(5)).nr(w.nr(nr.this.u.nr()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.fx.set(true);
            String strB = w.b(this.u.u());
            if (TextUtils.isEmpty(strB)) {
                strB = String.valueOf(this.iz);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = String.valueOf(jp.t(this.u.u()));
            }
            n.u().u(com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().u(strB), w.fx(this.u.u()), this.x, new b(new com.bytedance.sdk.openadsdk.bq.u.nr.u.x(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.3
                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void nr() {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void u(int i, String str) {
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            nr.this.b("当前无新视频，请点击重试");
                            nr.this.fx.set(false);
                            if (nr.this.nr != null) {
                                nr.this.nr.pn();
                            }
                            nr.this.u.u(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void nr(k kVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void u(final k kVar) {
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            k kVar2 = kVar;
                            if (kVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.fx) {
                                com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar = (com.bytedance.sdk.openadsdk.core.component.reward.fx) kVar2;
                                fxVar.nr(true);
                                fxVar.u(nr.this.iz);
                                fxVar.nr(nr.this.x + 1);
                                fxVar.fx(nr.this.u.nr());
                                if (!TextUtils.isEmpty(nr.this.jk) && !TextUtils.isEmpty(nr.this.t)) {
                                    fxVar.nr(nr.this.t);
                                    fxVar.u(nr.this.jk);
                                }
                                fxVar.fx(nr.this.n);
                                fxVar.u(nr.this.u.getActivity());
                                nr.this.u.pn();
                                nr.this.b.set(true);
                            } else {
                                nr.this.b("当前无新视频，请点击重试");
                                nr.this.fx.set(false);
                            }
                            nr.this.u.u(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.fx.set(false);
            b("当前无新视频，请退出后重试");
        }
    }

    private boolean jk() {
        if (!w.nr(this.u.u())) {
            return false;
        }
        if (this.fx.get()) {
            return true;
        }
        jk jkVar = new jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                if (nr.this.fx.get()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.s.b.u(nr.this.u.u(), "reward_endcard", "popup_cancel", (String) null);
                nr.this.u.fx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                if (nr.this.fx.get()) {
                    return;
                }
                if (nr.this.nr != null) {
                    nr.this.nr.b();
                }
                nr.this.a();
                com.bytedance.sdk.openadsdk.core.s.b.u(nr.this.u.u(), "reward_endcard", "reward_again", "popup");
            }
        };
        com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.nr(this.u.getActivity(), this.u.u());
        this.nr = nrVar;
        nrVar.b(this.jk);
        this.nr.fx(this.t);
        this.nr.u(this.s);
        this.u.b();
        return this.nr.u(jkVar).fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void b() {
        u.InterfaceC0245u interfaceC0245u = this.u;
        if (interfaceC0245u == null || interfaceC0245u.getActivity() == null || this.u.u() == null || !w.u(this.u.u())) {
            return;
        }
        if (!this.n) {
            boolean z = this.x == 0;
            this.u.u(z, null, null);
            this.f5227a = z;
        } else {
            this.f5227a = false;
            this.u.u(false, this.jk, this.t);
            final int i = this.x + 1;
            x.nr(new a("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        s sVarU = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        nr.this.u(sVarU.nr(w.nr(nr.this.u.nr()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public boolean fx(int i) {
        u.InterfaceC0245u interfaceC0245u = this.u;
        if (interfaceC0245u == null || interfaceC0245u.getActivity() == null || this.u.u() == null || this.fx.get() || !this.f5227a) {
            return false;
        }
        if (i == 1) {
            u.InterfaceC0245u interfaceC0245u2 = this.u;
            interfaceC0245u2.u(0, u(interfaceC0245u2.getActivity()));
            a();
            com.bytedance.sdk.openadsdk.core.s.b.u(this.u.u(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return jk();
            }
            if (i == 3) {
                u.InterfaceC0245u interfaceC0245u3 = this.u;
                interfaceC0245u3.u(0, u(interfaceC0245u3.getActivity()));
                a();
                com.bytedance.sdk.openadsdk.core.s.b.u(this.u.u(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public String iz() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.pn.get());
            jSONObject.put("mSourceRitId", this.iz);
            jSONObject.put("mNowPlayAgainCount", this.x);
            jSONObject.put("isCustomPlayAgain", this.n);
            jSONObject.put("isCanPlayAgain", this.f5227a);
            jSONObject.put("mPlayAgainRewardName", this.jk);
            jSONObject.put("mPlayAgainRewardAmount", this.t);
            jSONObject.put("mLastRewardName", this.l);
            jSONObject.put("mLastRewardAmount", this.mv);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void nr(boolean z) {
        this.n = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public boolean pn() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u uVar = this.nr;
        if (uVar == null) {
            return false;
        }
        return uVar.nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public String x() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void nr(int i) {
        this.iz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public boolean nr() {
        return this.b.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void u(boolean z) {
        this.pn.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void nr(String str) {
        this.mv = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void u(int i) {
        this.x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public boolean u() {
        return this.pn.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void u(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bundle bundle) {
        boolean z = bundle.getBoolean("play_again_allow");
        this.jk = bundle.getString("play_again_reward_name");
        this.t = bundle.getString("play_again_reward_amount");
        this.s = bundle.getString("extra_info");
        this.f5227a = z;
        if (z) {
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.2
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.u.u(true, nr.this.jk, nr.this.t);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        u.InterfaceC0245u interfaceC0245u = this.u;
        if (interfaceC0245u == null || interfaceC0245u.getActivity() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr.5
            @Override // java.lang.Runnable
            public void run() {
                h.u(nr.this.u.getActivity(), str, 0);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void fx() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.u uVar = this.nr;
        if (uVar != null) {
            uVar.fx();
        }
        t();
    }

    private TTProgressBar u(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(y.fx(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iFx = y.fx(context, 10.0f);
        tTProgressBar.setPadding(iFx, iFx, iFx, iFx);
        tTProgressBar.setIndeterminateDrawable(q.fx(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u
    public void fx(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.pn.set(jSONObject.getBoolean("isPlayAgain"));
            this.iz = jSONObject.optInt("mSourceRitId");
            this.x = jSONObject.optInt("mNowPlayAgainCount");
            this.n = jSONObject.optBoolean("isCustomPlayAgain");
            this.f5227a = jSONObject.optBoolean("isCanPlayAgain");
            this.jk = jSONObject.optString("mPlayAgainRewardName");
            this.t = jSONObject.optString("mPlayAgainRewardAmount");
            this.l = jSONObject.optString("mLastRewardName");
            this.t = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }
}
