package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.cj;
import com.bytedance.sdk.openadsdk.core.widget.iz;
import com.bytedance.sdk.openadsdk.core.y.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends u {
    private com.bytedance.sdk.openadsdk.core.widget.iz o;
    private String sx;

    public n(Activity activity, bc bcVar) {
        super(activity, bcVar);
        this.o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public void fx() {
        com.bytedance.sdk.openadsdk.core.widget.iz izVar = this.o;
        if (izVar != null) {
            izVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.u, com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public nr.u nr(final jk jkVar) {
        final com.bytedance.sdk.openadsdk.core.widget.iz izVar = new com.bytedance.sdk.openadsdk.core.widget.iz(this.n);
        this.o = izVar;
        u(izVar, this.b);
        this.o.u(new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.n.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.iz.u
            public void nr() {
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.iz.u
            public void u() {
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
            }
        });
        this.o.show();
        return new nr.u(true, 0, "", this.o);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public String u() {
        return this.sx;
    }

    private void u(com.bytedance.sdk.openadsdk.core.widget.iz izVar, boolean z) {
        if (q.nr(this.x)) {
            int iGs = this.x.gs();
            int iU = cj.u(this.x);
            if (iGs == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (iU != 1 && !z && !this.fx) {
                    str = "试玩后才能领取奖励";
                }
                this.sx = str;
                izVar.u(com.bytedance.sdk.component.utils.q.fx(this.n, "tt_retain_gift")).u(a()).fx("继续试玩").b("坚持退出");
                izVar.u(com.bytedance.sdk.openadsdk.res.pn.a(this.n));
                return;
            }
            if (iGs != 1) {
                if (iGs != 3) {
                    return;
                }
                this.sx = "确定退出吗?";
                Activity activity = this.n;
                if (activity != null) {
                    Intent intent = activity.getIntent();
                    this.sx = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                u(izVar, a(), "继续观看", "坚持退出");
                izVar.u(Color.parseColor("#FC1D56"));
                return;
            }
            boolean zFx = bg.fx(this.x);
            if (iU != 0 || zFx) {
                this.sx = String.format("再看%s秒可得奖励", Integer.valueOf(this.u));
            } else {
                this.sx = "未满足奖励要求，需要继续浏览";
            }
            if (zFx) {
                izVar.nr("确定退出吗?");
                u(izVar, a(), "继续观看", "坚持退出");
            } else {
                izVar.u(com.bytedance.sdk.component.utils.q.fx(this.n, "tt_reward_coin")).u(Color.parseColor("#FC1D56")).u(a()).fx("继续观看").b("坚持退出");
                izVar.u(com.bytedance.sdk.openadsdk.res.pn.a(this.n));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.nr
    public boolean nr() {
        com.bytedance.sdk.openadsdk.core.widget.iz izVar = this.o;
        return izVar != null && izVar.isShowing();
    }

    private void u(com.bytedance.sdk.openadsdk.core.widget.iz izVar, String str, String str2, String str3) {
        izVar.u(com.bytedance.sdk.component.utils.q.fx(this.n, "tt_reward_browse_multi_icon")).u(str).fx(str2).b(str3);
        izVar.u(com.bytedance.sdk.openadsdk.res.pn.wq(this.n));
    }
}
