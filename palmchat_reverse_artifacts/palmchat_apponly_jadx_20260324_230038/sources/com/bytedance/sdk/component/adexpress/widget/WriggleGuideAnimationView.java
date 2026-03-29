package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.jk;
import com.bytedance.sdk.component.utils.qq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class WriggleGuideAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5115a;
    private TextView b;
    private qq fx;
    private LinearLayout iz;
    private boolean jk;
    private jk n;
    private TextView nr;
    private u pn;
    public int u;
    private LottieAnimationView x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public WriggleGuideAnimationView(Context context, View view, jk jkVar, boolean z, int i, boolean z2) {
        super(context);
        this.n = jkVar;
        this.f5115a = z;
        this.u = i;
        this.jk = z2;
        u(context, view);
    }

    public TextView getTopTextView() {
        return this.nr;
    }

    public LinearLayout getWriggleLayout() {
        return this.iz;
    }

    public View getWriggleProgressIv() {
        return this.x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.fx == null) {
                this.fx = new qq(getContext().getApplicationContext(), 2, this.f5115a, this.jk);
            }
            this.fx.u(new qq.u() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.qq.u
                public void u(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.pn != null) {
                        WriggleGuideAnimationView.this.pn.u();
                    }
                }
            });
            if (this.n != null) {
                this.fx.nr(r0.fx());
                this.fx.iz(this.n.pn());
                this.fx.u(this.n.iz());
                this.fx.nr(this.n.n());
            }
            this.fx.u(this.u);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qq qqVar = this.fx;
        if (qqVar != null) {
            qqVar.nr(this.u);
        }
        try {
            LottieAnimationView lottieAnimationView = this.x;
            if (lottieAnimationView != null) {
                lottieAnimationView.iz();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        qq qqVar = this.fx;
        if (qqVar != null) {
            if (z) {
                qqVar.u(this.u);
            } else {
                qqVar.nr(this.u);
            }
        }
    }

    public void setOnShakeViewListener(u uVar) {
        this.pn = uVar;
    }

    public void setShakeText(String str) {
        this.b.setText(str);
    }

    private void u(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.iz = (LinearLayout) findViewById(2097610722);
        this.nr = (TextView) findViewById(2097610719);
        this.b = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.x = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.x.setImageAssetsFolder("images/");
        this.x.u(true);
    }

    public void u() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.x.u();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }
}
