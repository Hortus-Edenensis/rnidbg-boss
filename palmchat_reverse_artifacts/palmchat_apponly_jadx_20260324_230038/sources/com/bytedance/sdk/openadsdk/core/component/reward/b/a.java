package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.ss.bytertc.engine.type.ErrorCode;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends u {
    private boolean ja;
    boolean rh;

    public a(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = false;
        this.ja = false;
        this.ja = com.bytedance.sdk.openadsdk.core.live.fx.nr.u(bcVar) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge() {
        if (this.rh) {
            return;
        }
        this.rh = true;
        a(false);
        this.u.finish();
    }

    public static int u(bc bcVar) {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        FrameLayout frameLayout = new FrameLayout(this.u);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        this.u.nr(true, true);
        this.f5223a.fx(true);
        this.jk.fx(false);
        this.sx.u(false);
        int iN = y.n(dw.getContext());
        com.bytedance.sdk.openadsdk.core.s.b.u("click", this.nr, new a.u().iz(-1.0f).pn(-1.0f).b(-1.0f).fx(-1.0f).nr(-1L).u(-1L).fx(-1).b(-1).pn(ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE).nr(com.bytedance.sdk.openadsdk.core.n.o().fx() ? 1 : 2).u(iN).u(y.iz(dw.getContext())).nr(y.x(dw.getContext())).u(), this.l, true, this.u.xw(), -1, false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return u(this.nr);
    }

    public static boolean u(Context context, bc bcVar) {
        long jX;
        if (!su.b(bcVar)) {
            return false;
        }
        if (m.u(bcVar)) {
            jX = ((long) m.nr(bcVar)) * 1000;
        } else {
            jX = zx.k(bcVar) != null ? (long) (zx.x(bcVar) * 1000.0d) : 0L;
        }
        long jMin = Math.min(yd.u(), (long) (jX * (bcVar.na() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.fx.nr.u(bcVar)));
        return com.bytedance.sdk.openadsdk.core.live.nr.u().nr(context, bcVar, map) == 0;
    }

    private void a(final boolean z) {
        if (this.f5223a instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.a) {
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = a.this.f5223a;
                    if (nrVar == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.a aVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.a) nrVar;
                    if (z) {
                        aVar.nr();
                    } else {
                        aVar.fx();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.a aVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.a(this.u, this.nr, z);
        this.f5223a = aVar;
        return aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(int i, int i2, Intent intent) {
        super.u(i, i2, intent);
        if (i != 1) {
            this.u.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.u.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.ja && i3 == 1) {
                this.u.finish();
                return;
            }
            k.nr("rewardAuthFlag", "verify rew....");
            this.u.b(0);
            a(true);
            this.u.xg().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ge();
                }
            }, 2000L);
            return;
        }
        this.u.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(int i) {
        super.u(i);
        if (i == 0) {
            ge();
        }
    }
}
