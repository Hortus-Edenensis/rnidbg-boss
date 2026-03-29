package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SplashClickBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SplashClickBarBtn f5251a;
    private int b;
    private int fx;
    private String iz;
    private int n;
    private int nr;
    private int pn;
    private int u;
    private boolean x;

    public SplashClickBar(Context context, bc bcVar) {
        super(context);
        u(context, bcVar);
    }

    public void setBtnLayout(boolean z) {
        int iFx;
        int i = this.nr + 150;
        if (this.u <= i && this.n != 4) {
            this.u = i;
        }
        int i2 = z ? this.fx : this.b;
        if (i2 < 0) {
            i2 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5251a.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.n;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iFx = y.fx(getContext(), 10.0f);
            } else if (i3 != 7) {
                layoutParams.height = y.fx(dw.getContext(), this.nr);
                layoutParams.width = y.fx(dw.getContext(), this.u);
            } else {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iFx = y.fx(getContext(), 20.0f);
            }
            i2 += iFx;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = y.fx(dw.getContext(), i2);
        layoutParams.gravity = 81;
        this.f5251a.setLayoutParams(layoutParams);
    }

    public void u(Context context, bc bcVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), bcVar);
        this.f5251a = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.f5251a.setClipChildren(false);
    }

    public void u(bc bcVar) {
        this.u = bcVar.sf();
        this.nr = bcVar.ua();
        this.fx = bcVar.i();
        this.b = bcVar.qe();
        this.pn = bcVar.uq();
        this.iz = bcVar.rg();
        this.n = bcVar.dj();
        this.x = bcVar.dc();
        SplashClickBarBtn splashClickBarBtn = this.f5251a;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(bcVar.gz());
            this.f5251a.setDeepShakeValue(bcVar.an());
            this.f5251a.setWriggleValue(bcVar.qv());
            this.f5251a.setTwistConfig(bcVar.xs());
            this.f5251a.setShakeInteractConf(bcVar.or());
            this.f5251a.setTwistInteractConf(bcVar.bi());
            this.f5251a.setCalculationTwistMethod(bcVar.ki());
            this.f5251a.setCalculationMethod(bcVar.zq());
        }
        this.f5251a.u(bcVar.pq());
        if (this.pn == 1 && this.x) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.f5251a.u(uVar);
    }
}
