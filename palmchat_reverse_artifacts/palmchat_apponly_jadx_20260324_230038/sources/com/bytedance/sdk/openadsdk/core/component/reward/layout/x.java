package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends nr {
    private UpieImageView bg;
    private TTRoundRectImageView k;
    private TextView my;
    private TextView o;
    private ImageView s;
    private TextView sx;

    public x(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
    }

    private void fx() {
        TextView textView;
        this.s = (ImageView) this.nr.findViewById(2114387712);
        this.k = (TTRoundRectImageView) this.nr.findViewById(2114387722);
        this.my = (TextView) this.nr.findViewById(2114387702);
        this.o = (TextView) this.nr.findViewById(2114387962);
        this.sx = (TextView) this.nr.findViewById(2114387719);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.fx)) {
            UpieImageView upieImageView = new UpieImageView(this.s.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.fx), com.bytedance.sdk.openadsdk.pn.u.jk(this.fx));
            this.bg = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.fx.yb()) && (textView = this.o) != null) {
            textView.setText(this.fx.yb());
        }
        if (zx.k(this.fx) == null || !bc.nr(this.fx)) {
            u(this.s, this.bg);
            y.u((View) this.s, 0);
            y.u((View) this.f5236a, 8);
        } else {
            y.u((View) this.s, 8);
            y.u((View) this.f5236a, 0);
        }
        rh rhVarDd = this.fx.dd();
        if (rhVarDd != null) {
            com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(this.k);
        }
        TextView textView2 = this.my;
        if (textView2 != null) {
            textView2.setText(s());
        }
        TextView textView3 = this.sx;
        if (textView3 != null) {
            textView3.setText(k());
        }
        y.u((TextView) this.nr.findViewById(2114387658), this.fx);
    }

    private float iz() {
        return y.b(this.nr, y.jk((Context) this.nr));
    }

    private void nr() {
        int i = (int) (this.pn * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        u(this.b == 1 ? 0.562f : 1.777f);
    }

    private float pn() {
        return y.b(this.nr, y.a((Context) this.nr));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void b(int i) {
        y.u((View) this.t, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.f5236a = (FrameLayout) this.nr.findViewById(2114387915);
        u(this.x);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.fx)) {
            b();
        } else {
            fx();
            nr();
        }
    }

    private void b() {
        this.t = (RelativeLayout) this.nr.findViewById(2114387844);
        this.l = (TextView) this.nr.findViewById(2114387716);
        if (m.u(this.fx)) {
            String strN = m.n(this.fx);
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            com.bytedance.sdk.openadsdk.n.nr.u(strN).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.x.2
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(x.this.nr, myVar.getResult(), 25);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(x.this.nr.getResources(), bitmapU);
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.x.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup viewGroup = x.this.x;
                            if (viewGroup != null) {
                                viewGroup.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    private void u(View view) {
        bc bcVar = this.fx;
        if (bcVar == null || view == null) {
            return;
        }
        final float fCn = bcVar.cn();
        if (fCn <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.x.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), y.fx(dw.getContext(), fCn));
            }
        });
        view.setClipToOutline(true);
    }

    private void u(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fPn = pn();
        float fIz = iz();
        if (this.b == 2) {
            fMin = Math.max(fPn, fIz);
            fMax = Math.min(fPn, fIz);
        } else {
            fMin = Math.min(fPn, fIz);
            fMax = Math.max(fPn, fIz);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.fx.ng());
        if (this.b != 2) {
            TTBaseVideoActivity tTBaseVideoActivity = this.nr;
            fMax -= y.b(tTBaseVideoActivity, y.t((Context) tTBaseVideoActivity));
        }
        if (this.b != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.nr.getWindow().getDecorView().setPadding(y.fx(this.nr, f5), y.fx(this.nr, f4), y.fx(this.nr, f5), y.fx(this.nr, f4));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        u(this.o, nrVar, nrVar);
        u(this.l, nrVar, nrVar);
        u(this.f5236a, nrVar2, nrVar2);
        u(this.s, nrVar2, nrVar2);
        u(this.k, nrVar2, nrVar2);
        u(this.my, nrVar2, nrVar2);
        u(this.sx, nrVar2, nrVar2);
        u(this.x, nrVar2, nrVar2);
        u(this.bg, nrVar2, nrVar2);
    }

    private void u(View view, com.bytedance.sdk.openadsdk.core.nr.nr nrVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(nrVar);
    }
}
