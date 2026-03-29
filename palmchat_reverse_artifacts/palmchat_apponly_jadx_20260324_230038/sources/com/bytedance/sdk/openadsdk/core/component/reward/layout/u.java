package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.ugeno.n.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private AtomicBoolean bg;
    private String bq;
    private AtomicBoolean c;
    private RewardLpBottomView dw;
    private com.bytedance.sdk.openadsdk.core.s.x k;
    private boolean kj;
    private com.bytedance.sdk.openadsdk.core.ugeno.jk.b my;
    private com.bytedance.sdk.openadsdk.core.ugeno.a.u o;
    private AtomicBoolean q;
    private com.bytedance.sdk.openadsdk.core.component.reward.nr.pn qq;
    private com.bytedance.sdk.openadsdk.core.ugeno.x.u s;
    private com.bytedance.sdk.openadsdk.core.ugeno.jk.nr sx;

    public u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z, com.bytedance.sdk.openadsdk.core.s.x xVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar) {
        super(tTBaseVideoActivity, bcVar, z);
        this.s = bcVar.ja();
        this.k = xVar;
        this.nr.x(0);
        this.bg = new AtomicBoolean();
        this.c = new AtomicBoolean();
        this.q = new AtomicBoolean();
        this.qq = pnVar;
    }

    private void bg() {
        com.bytedance.sdk.openadsdk.core.ugeno.a.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.a.u(this.nr, bq(), this.s, this.fx);
        this.o = uVar;
        uVar.u(this.nr.xw());
        this.o.u(new com.bytedance.sdk.openadsdk.core.ugeno.pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(View view) {
                com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr.x(8);
                        u.this.bg.set(true);
                        if (u.this.dw != null) {
                            u.this.dw.u();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(int i) {
                bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr.x(8);
                        u.this.nr.sx();
                    }
                });
                u.this.bg.set(false);
            }
        });
        this.o.u();
    }

    private ViewGroup bq() {
        if (this.x == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.nr);
        this.x.addView(playableEndcardFrameLayout);
        this.dw = new RewardLpBottomView(this.nr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.x.addView(this.dw, layoutParams);
        this.dw.u(this.fx, this.bq);
        playableEndcardFrameLayout.u(new PlayableEndcardFrameLayout.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.u
            public void u() {
                if (u.this.dw != null) {
                    u.this.dw.nr();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    private void o() {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.b bVar = new com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.nr, this.x, this.k, this.fx, this.bq, jp.nr(this.u));
        this.my = bVar;
        bVar.nr(true);
        this.my.u(new com.bytedance.sdk.openadsdk.core.ugeno.pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(View view) {
                u.this.nr.x(8);
                u.this.bg.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(int i) {
                bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr.x(8);
                        u.this.nr.sx();
                    }
                });
                u.this.bg.set(false);
            }
        });
        this.my.mv();
    }

    private void sx() {
        FrameLayout frameLayout = new FrameLayout(this.nr);
        this.x.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = new com.bytedance.sdk.openadsdk.core.ugeno.jk.nr(this.nr, frameLayout, this.k, this.fx, this.bq, jp.nr(this.u));
        this.sx = nrVar;
        nrVar.nr(true);
        this.sx.u(new com.bytedance.sdk.openadsdk.core.ugeno.n.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.nr
            public void nr() {
                u.this.nr.bc();
                u.this.c.set(true);
                u.this.sx.bq();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.nr
            public void u() {
                u.this.nr.y();
            }
        });
        this.sx.u(new com.bytedance.sdk.openadsdk.core.ugeno.pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(View view) {
                u.this.nr.x(8);
                u.this.bg.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(int i) {
                bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr.x(8);
                        u.this.sx.o();
                        u.this.sx.u(q.u(u.this.nr, "tt_ecomm_page_reward_acquire"));
                        u.this.nr.b(0);
                    }
                });
                u.this.bg.set(false);
            }
        });
        this.sx.u(new u.InterfaceC0296u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.u.InterfaceC0296u
            public void u() {
                bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (u.this.nr.ay()) {
                            u.this.sx.u(q.u(u.this.nr, "tt_ecomm_page_reward_acquire"));
                        } else {
                            u.this.sx.u(String.format(q.u(u.this.nr, "tt_ecomm_page_reward_tip"), Integer.valueOf(u.this.nr.yd().m())));
                        }
                    }
                });
            }
        });
        this.sx.mv();
        com.bytedance.sdk.openadsdk.core.n.o().b().fx(new u.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.6
            @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
            public void nr() {
                if (u.this.c.get() || !u.this.sx.s()) {
                    u.this.q.set(false);
                } else {
                    u.this.q.set(true);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
            public void u() {
            }
        });
        if (TextUtils.equals(this.s.u(), "3")) {
            return;
        }
        nr();
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.sx;
        if (nrVar != null) {
            nrVar.dw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void jk() {
        com.bytedance.sdk.openadsdk.core.ugeno.a.u uVar = this.o;
        if (uVar != null) {
            uVar.nr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.sx;
        if (nrVar != null) {
            nrVar.my();
        }
        RewardLpBottomView rewardLpBottomView = this.dw;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.nr();
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.sx;
        if (nrVar != null) {
            nrVar.sx();
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.sx;
        if (nrVar != null) {
            nrVar.bg();
        }
    }

    public boolean b() {
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.sx;
        if (nrVar != null) {
            return nrVar.s();
        }
        return false;
    }

    public boolean fx() {
        return this.q.get();
    }

    public boolean iz() {
        return this.bg.get();
    }

    public void nr() {
        final ImageView imageView = new ImageView(this.nr);
        float fFx = y.fx(this.nr, 18.0f);
        float fFx2 = y.fx(this.nr, 20.0f);
        int i = (int) fFx;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) fFx2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.x.addView(imageView, layoutParams);
        q.u((Context) this.nr, "tt_unmute", imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.kj = !r3.kj;
                u uVar = u.this;
                q.u((Context) uVar.nr, uVar.kj ? "tt_mute" : "tt_unmute", imageView);
                u.this.sx.fx(u.this.kj);
            }
        });
    }

    public AtomicInteger pn() {
        return new AtomicInteger(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.bq = jp.u(jp.nr(this.u));
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = this.s;
        if (uVar == null) {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.nr.x(8);
                    u.this.nr.sx();
                }
            });
            return;
        }
        int iB = uVar.b();
        if (iB == 2) {
            o();
            return;
        }
        if (iB == 3) {
            sx();
        } else if (iB != 4) {
            this.nr.x(8);
            this.nr.sx();
        } else {
            bg();
        }
    }

    public void nr(boolean z) {
        if (this.sx == null || !com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.fx)) {
            return;
        }
        this.sx.fx(z);
    }

    public void u(boolean z) {
        this.q.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        super.u(nrVar, nrVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.jk.b bVar = this.my;
        if (bVar != null) {
            bVar.u(this.nr.xw());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar3 = this.sx;
        if (nrVar3 != null) {
            nrVar3.u(this.nr.xw());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.a.u uVar = this.o;
        if (uVar != null) {
            uVar.u(nrVar);
        }
    }

    public void u(int i) {
        if (this.my == null || !com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.fx)) {
            return;
        }
        this.my.pn(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.a.u uVar = this.o;
        if (uVar != null) {
            uVar.u(downloadListener);
        }
    }
}
