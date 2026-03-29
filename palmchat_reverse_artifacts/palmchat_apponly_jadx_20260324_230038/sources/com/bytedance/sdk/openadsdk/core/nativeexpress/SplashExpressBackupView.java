package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.wifi.ad.core.p001const.WifiNestConst;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SplashExpressBackupView extends BackupView implements fx.InterfaceC0154fx {
    private com.bytedance.sdk.openadsdk.core.gi.u.nr bg;
    private NativeVideoTsView bq;
    private fx.InterfaceC0154fx dw;
    private GifView k;
    private NativeExpressView mv;
    private TextView my;
    private Button o;
    private View s;
    private FrameLayout sx;

    public SplashExpressBackupView(Context context) {
        super(context);
        this.u = context;
        this.pn = WifiNestConst.NestTypeConst.NEST_SPLASH_AD;
    }

    private void a() {
        s();
        this.k.setVisibility(0);
        this.sx.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = y.fx(this.u, 291.0f);
        this.k.setLayoutParams(layoutParams);
        u(this.k, this.nr, this.bg);
        this.my.setText(this.nr.ym());
        if (this.nr.pq() != null) {
            y.u((View) this.o, 8);
        } else {
            y.u((View) this.o, 0);
            this.o.setText(this.nr.yb());
            u((View) this.o, true);
        }
        setExpressBackupListener(this.s);
    }

    private void iz() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.iz, this.x);
        }
        layoutParams.width = this.iz;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        u(this.nr.ol(), this.nr);
    }

    private void jk() {
        s();
        this.k.setVisibility(0);
        this.sx.setVisibility(8);
        u(this.k, this.nr, this.bg);
        this.my.setText(this.nr.ym());
        if (this.nr.pq() != null) {
            y.u((View) this.o, 8);
        } else {
            y.u((View) this.o, 0);
            this.o.setText(this.nr.yb());
            u((View) this.o, true);
        }
        setExpressBackupListener(this.s);
    }

    private void l() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) u(this.mv);
        this.bq = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.bq;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    private void mv() {
        GifView gifView = new GifView(this.u);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        u(gifView, this.nr, this.bg);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private boolean n() {
        bc bcVar = this.nr;
        return bcVar != null && bcVar.sv() == 2;
    }

    private void s() {
        View viewU = u(this.u);
        if (viewU == null) {
            return;
        }
        addView(viewU);
    }

    private void setExpressBackupListener(View view) {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.uq() != 1) {
            return;
        }
        u(view, true);
    }

    private void t() {
        s();
        this.k.setVisibility(8);
        this.sx.setVisibility(0);
        if (zx.k(this.nr) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) u(this.mv);
            this.bq = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.bq == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.sx.addView(this.bq, layoutParams);
        }
        this.my.setText(this.nr.ym());
        if (this.nr.pq() != null) {
            y.u((View) this.o, 8);
        } else {
            y.u((View) this.o, 0);
            this.o.setText(this.nr.yb());
            u((View) this.o, true);
        }
        setExpressBackupListener(this.s);
    }

    private boolean x() {
        NativeExpressView nativeExpressView = this.mv;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void D_() {
        fx.InterfaceC0154fx interfaceC0154fx = this.dw;
        if (interfaceC0154fx != null) {
            interfaceC0154fx.D_();
        }
    }

    public com.bykv.vk.openvk.component.video.api.b.fx getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.bq;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    public void setVideoAdListener(fx.InterfaceC0154fx interfaceC0154fx) {
        this.dw = interfaceC0154fx;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void u(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        NativeExpressView nativeExpressView = this.mv;
        if (nativeExpressView != null) {
            nativeExpressView.u(view, i, qVar);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar, bc bcVar, NativeExpressView nativeExpressView) {
        this.nr = bcVar;
        this.mv = nativeExpressView;
        this.iz = y.fx(this.u, nativeExpressView.getExpectExpressWidth());
        this.x = y.fx(this.u, this.mv.getExpectExpressWidth());
        this.bg = nrVar;
        iz();
        this.mv.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void u(int i, bc bcVar) {
        if (!x()) {
            if (i != 5) {
                l();
                return;
            } else {
                t();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        mv();
                        return;
                    }
                }
            }
            if (n()) {
                mv();
                return;
            } else {
                jk();
                return;
            }
        }
        a();
    }

    private View u(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        com.bytedance.sdk.component.utils.q.u(context, "tt_splash_ad_backup_bg", linearLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = y.fx(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.q.u(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.my = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = y.fx(context, 31.0f);
        layoutParams3.gravity = 1;
        this.my.setLayoutParams(layoutParams3);
        this.my.setGravity(1);
        this.my.setTextSize(2, 15.0f);
        this.my.setTextColor(Color.parseColor("#895434"));
        this.my.setSingleLine(false);
        linearLayout.addView(this.my);
        GifView gifView = new GifView(context);
        this.k = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = y.fx(context, 29.0f);
        layoutParams4.setMarginStart(y.fx(context, 15.0f));
        layoutParams4.setMarginEnd(y.fx(context, 15.0f));
        layoutParams4.gravity = 1;
        this.k.setLayoutParams(layoutParams4);
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.k);
        FrameLayout frameLayout = new FrameLayout(context);
        this.sx = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(y.fx(context, 15.0f));
        layoutParams5.setMarginEnd(y.fx(context, 15.0f));
        this.sx.setLayoutParams(layoutParams5);
        this.sx.setVisibility(8);
        linearLayout.addView(this.sx);
        Button button = new Button(context);
        this.o = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = y.fx(context, 37.0f);
        layoutParams6.gravity = 1;
        this.o.setLayoutParams(layoutParams6);
        this.o.setText(com.bytedance.sdk.component.utils.q.u(context, "tt_splash_backup_ad_btn"));
        this.o.setTextColor(Color.parseColor("#ffffff"));
        this.o.setTypeface(Typeface.defaultFromStyle(1));
        com.bytedance.sdk.component.utils.q.u(context, "tt_splash_ad_backup_btn_bg", this.o);
        linearLayout.addView(this.o);
        return linearLayout;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void o_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
    public void q_() {
    }

    private void u(GifView gifView) {
        rh rhVar = this.nr.zu().get(0);
        if (rhVar != null) {
            com.bytedance.sdk.openadsdk.n.nr.u(rhVar).to(gifView);
        }
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.nr)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.nr), com.bytedance.sdk.openadsdk.pn.u.jk(this.nr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.pn.u.u(gifView, upieImageView);
        }
    }

    public void u(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.u(bArr, false);
    }

    public void u(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    public void u(GifView gifView, bc bcVar, com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar) {
        Drawable drawableU;
        if (nrVar == null) {
            u(gifView);
            return;
        }
        if (nrVar.pn()) {
            u(nrVar.fx(), gifView);
            return;
        }
        if (bcVar.zu() == null || bcVar.zu().get(0) == null) {
            return;
        }
        if (nrVar.u() != null) {
            drawableU = new BitmapDrawable(nrVar.u());
        } else {
            drawableU = com.bytedance.sdk.openadsdk.core.y.bg.u(nrVar.fx(), bcVar.zu().get(0).nr());
        }
        u(drawableU, gifView);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.nr)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.nr), com.bytedance.sdk.openadsdk.pn.u.jk(this.nr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.pn.u.u(gifView, upieImageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void u(View view, boolean z) {
        bc bcVar = this.nr;
        if (bcVar == null || bcVar.pq() == null || this.nr.pq().u() != 1) {
            return;
        }
        super.u(view, z);
    }
}
