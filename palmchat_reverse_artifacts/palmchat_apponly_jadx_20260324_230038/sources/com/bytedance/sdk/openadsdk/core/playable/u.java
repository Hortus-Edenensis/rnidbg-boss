package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.cj;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements rh.u {
    private final bc fx;
    private FrameLayout iz;
    private fx n;
    private final Context nr;
    private final int pn;
    private final com.bytedance.sdk.openadsdk.core.video.nr.nr s;
    private boolean t;
    private final String u;
    private PlayableVideoContainer x;
    private final rh b = new rh(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5357a = false;
    private boolean jk = true;
    private boolean l = false;
    private boolean mv = false;

    public u(String str, Activity activity, bc bcVar, int i, com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar, FrameLayout frameLayout) {
        this.u = str;
        this.nr = activity;
        this.fx = bcVar;
        this.pn = i;
        if (!bg.b(bcVar)) {
            this.iz = frameLayout;
        }
        pn();
        this.s = nrVar;
    }

    private void a() {
        PlayableVideoContainer playableVideoContainer = this.x;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.nr(true);
        this.b.sendEmptyMessageDelayed(1, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        if (this.x == null || this.iz == null) {
            return;
        }
        x();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationX", -y.fx(this.nr, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.x, "translationY", -y.fx(this.nr, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.x, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.l = true;
        if (this.t) {
            this.t = false;
            nr();
        }
        u(this.jk);
    }

    private void iz() {
        y.u((View) this.iz, 8);
        y.u((View) this.x, 8);
    }

    private void pn() {
        if (this.iz == null) {
            return;
        }
        if (cj.nr(this.fx) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.nr);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(y.fx(this.nr, 156.0f), y.fx(this.nr, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = y.fx(this.nr, 55.0f);
            layoutParams.rightMargin = y.fx(this.nr, 20.0f);
            this.iz.addView(playableVideoContainer, layoutParams);
            this.x = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.nr);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(y.fx(this.nr, 73.0f), y.fx(this.nr, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = y.fx(this.nr, 55.0f);
        layoutParams2.rightMargin = y.fx(this.nr, 30.0f);
        this.iz.addView(playableVideoContainer2, layoutParams2);
        this.x = playableVideoContainer2;
    }

    private void x() {
        y.u((View) this.iz, 0);
        y.u((View) this.x, 0);
    }

    public void b() {
        fx fxVar = this.n;
        if (fxVar == null) {
            return;
        }
        fxVar.jk();
        this.n = null;
        this.f5357a = false;
        this.t = false;
        this.l = false;
    }

    public void fx() {
        if (this.mv && this.f5357a && this.n != null) {
            this.t = false;
            this.b.sendEmptyMessageDelayed(1, 2000L);
            if (this.n.wi()) {
                return;
            }
            this.n.n();
        }
    }

    public void nr() {
        if (this.mv && this.f5357a && this.n != null) {
            this.b.removeMessages(1);
            if (this.l) {
                this.n.iz();
            } else {
                this.t = true;
            }
        }
    }

    public void u(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.mv = true;
        this.jk = z;
        u(j);
        if (this.f5357a) {
            if (this.s != null && (playableVideoContainer = this.x) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.jk();
                    }
                }, 500L);
                this.x.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.u.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.iz != null) {
                            u.this.u();
                            u.this.s.nr();
                        }
                    }
                });
            } else if (t.u(this.fx)) {
                iz();
            } else {
                x();
            }
        }
    }

    public void u() {
        this.mv = false;
        b();
        iz();
    }

    private void u(long j) {
        if (this.x == null) {
            return;
        }
        if (this.s != null || t.u(this.fx)) {
            if (this.f5357a) {
                fx fxVar = this.n;
                if (fxVar != null) {
                    fxVar.nr(j);
                    this.n.u(j);
                    return;
                }
                return;
            }
            this.f5357a = true;
            iz izVarU = zx.u(1, this.fx);
            izVarU.nr(this.fx.lk());
            izVarU.nr(this.x.getWidth());
            izVarU.fx(this.x.getHeight());
            izVarU.fx(this.fx.ap());
            izVarU.u(j);
            izVarU.nr(this.jk);
            if (t.u(this.fx)) {
                izVarU.u(true);
            }
            fx fxVar2 = new fx(this.nr, this.x.getVideoContainer(), this.fx, null);
            this.n = fxVar2;
            fxVar2.u(new u.InterfaceC0302u() { // from class: com.bytedance.sdk.openadsdk.core.playable.u.3
                @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
                public void fx() {
                    u.this.n();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
                public void nr() {
                    u.this.x.u(true);
                    if (u.this.s != null) {
                        u.this.s.jk();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
                public void u() {
                    if (u.this.s != null) {
                        u.this.u();
                        u.this.s.fx();
                    } else {
                        if (!t.u(u.this.fx) || u.this.n == null || u.this.n.pn()) {
                            return;
                        }
                        u.this.u();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
                public void u(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    u.this.x.u(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
                public void u(long j2, long j3) {
                    u.this.x.u(false);
                    if (u.this.s != null) {
                        u.this.s.u(j2, j3);
                    }
                }
            });
            this.n.nr(j);
            this.n.u(izVarU);
            if (this.s != null) {
                this.n.qq();
                this.n.x(false);
                this.x.u();
            } else {
                if (t.u(this.fx)) {
                    this.n.x(true);
                }
                a();
            }
        }
    }

    public void u(boolean z) {
        fx fxVar = this.n;
        if (fxVar == null) {
            return;
        }
        this.jk = z;
        fxVar.nr(z);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        PlayableVideoContainer playableVideoContainer = this.x;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.nr(false);
    }
}
