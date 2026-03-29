package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.o;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.pn;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.ss.android.ttvecamera.TECameraSettings;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BannerExpressBackupView extends BackupView {
    private static o[] mv = {new o(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new o(3, 1.2f, 600, 500)};
    private TextView bg;
    private TextView bq;
    private ImageView dw;
    private NativeExpressView k;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx my;
    private int o;
    private View s;
    private o sx;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.o = 1;
        this.u = context;
    }

    private void b() {
        int i = this.sx.u;
        if (i == 2 || i == 3) {
            TextView textView = this.bg;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.bq;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.bg;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.dw != null) {
            q.u(getContext(), "tt_dislike_icon_night", this.dw);
        }
    }

    private void fx(int i) {
        if (i == 1) {
            b();
            this.s.setBackgroundColor(0);
        } else {
            fx();
            this.s.setBackgroundColor(-1);
        }
    }

    private void nr() {
        float fFx = (this.x * 1.0f) / y.fx(this.u, 50.0f);
        float f = this.x * 1.0f;
        int i = this.iz;
        if (f / i > 0.21875f) {
            fFx = (i * 1.0f) / y.fx(this.u, 320.0f);
        }
        View viewOa = pn.oa(this.u);
        this.s = viewOa;
        addView(viewOa);
        this.dw = (ImageView) this.s.findViewById(2114387854);
        ImageView imageView = (ImageView) this.s.findViewById(2114387931);
        this.bg = (TextView) this.s.findViewById(2114387940);
        TextView textView = (TextView) this.s.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.s.findViewById(2114387891);
        TextView textView2 = (TextView) this.s.findViewById(2114387633);
        this.bg.setTextSize(2, y.nr(this.u, r5.getTextSize()) * fFx);
        textView.setTextSize(2, y.nr(this.u, textView.getTextSize()) * fFx);
        textView2.setTextSize(2, y.nr(this.u, textView2.getTextSize()) * fFx);
        TextView textView3 = (TextView) this.s.findViewById(2114387658);
        this.dw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.pn();
            }
        });
        y.u(textView3, this.nr, 27, 11);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.dd()).to(imageView);
        this.bg.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (y.fx(this.u, 45.0f) * fFx);
            layoutParams.height = (int) (y.fx(this.u, 45.0f) * fFx);
        }
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView2.setText(this.nr.yb());
        }
        int iPn = this.nr.pu() != null ? this.nr.pu().pn() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iPn)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iPn);
        tTRatingBar.setStarImageWidth(y.fx(this.u, 15.0f) * fFx);
        tTRatingBar.setStarImageHeight(y.fx(this.u, 14.0f) * fFx);
        tTRatingBar.setStarImagePadding(y.fx(this.u, 4.0f));
        tTRatingBar.u();
        u((View) this, true);
        u((View) textView2, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.u
    public void b_(int i) {
        super.b_(i);
        fx(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        if (this.k != null) {
            if (i == 1 || i == 2) {
                View viewFindViewById = this.s.findViewById(2114387854);
                if (i == 1) {
                    this.k.getClickListener().nr(viewFindViewById);
                } else {
                    this.k.getClickCreativeListener().nr(viewFindViewById);
                }
            }
            this.k.u(view, i, qVar);
        }
    }

    private void fx() {
        int i = this.sx.u;
        if (i != 2 && i != 3) {
            TextView textView = this.bg;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FF333333"));
            }
            if (this.dw != null) {
                q.u(getContext(), "tt_dislike_icon", this.dw);
                return;
            }
            return;
        }
        TextView textView2 = this.bg;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        }
        TextView textView3 = this.bq;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#3E3E3E"));
        }
        if (this.dw != null) {
            this.dw.setImageDrawable(pn.cj(this.u));
        }
    }

    public void u(bc bcVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar) {
        setBackgroundColor(-1);
        this.nr = bcVar;
        this.k = nativeExpressView;
        this.my = fxVar;
        this.pn = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        int iT = jp.t(this.nr);
        this.n = iT;
        nr(iT);
        u();
        fx(n.o().ay());
    }

    private void u() {
        this.sx = u(this.k.getExpectExpressWidth(), this.k.getExpectExpressHeight());
        if (this.k.getExpectExpressWidth() > 0 && this.k.getExpectExpressHeight() > 0) {
            this.iz = y.fx(this.u, this.k.getExpectExpressWidth());
            this.x = y.fx(this.u, this.k.getExpectExpressHeight());
        } else {
            int iB = y.b(this.u);
            this.iz = iB;
            this.x = Float.valueOf(iB / this.sx.fx).intValue();
        }
        int i = this.iz;
        if (i > 0 && i > y.b(this.u)) {
            this.iz = y.b(this.u);
            this.x = Float.valueOf(this.x * (y.b(this.u) / this.iz)).intValue();
        }
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
        o oVar = this.sx;
        int i2 = oVar.u;
        if (i2 != 1 && i2 == 3) {
            u(oVar);
        } else {
            nr();
        }
    }

    private void u(ImageView imageView) {
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.nr)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.nr), com.bytedance.sdk.openadsdk.pn.u.jk(this.nr));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.bytedance.sdk.openadsdk.pn.u.u(imageView, upieImageView);
        }
    }

    private void u(o oVar) {
        View viewU;
        float fFx = (this.x * 1.0f) / y.fx(this.u, 250.0f);
        View viewW = pn.w(this.u);
        this.s = viewW;
        addView(viewW);
        FrameLayout frameLayout = (FrameLayout) this.s.findViewById(2114387772);
        this.dw = (ImageView) this.s.findViewById(2114387854);
        ImageView imageView = (ImageView) this.s.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.s.findViewById(2114387931);
        this.bg = (TextView) this.s.findViewById(2114387940);
        this.bq = (TextView) this.s.findViewById(2114387920);
        TextView textView = (TextView) this.s.findViewById(2114387927);
        TextView textView2 = (TextView) this.s.findViewById(2114387633);
        y.u((TextView) this.s.findViewById(2114387658), this.nr);
        LinearLayout linearLayout = (LinearLayout) this.s.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (y.fx(this.u, 45.0f) * fFx);
            layoutParams.height = (int) (y.fx(this.u, 45.0f) * fFx);
        }
        this.bg.setTextSize(2, y.nr(this.u, r8.getTextSize()) * fFx);
        this.bq.setTextSize(2, y.nr(this.u, r8.getTextSize()) * fFx);
        textView.setTextSize(2, y.nr(this.u, textView.getTextSize()) * fFx);
        textView2.setTextSize(2, y.nr(this.u, textView2.getTextSize()) * fFx);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = fFx - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = y.fx(this.u, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (y.fx(this.u, 16.0f) * fFx), 0, 0);
        } catch (Throwable unused) {
        }
        this.dw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.pn();
            }
        });
        int iFx = y.fx(this.u, 15.0f);
        y.u(this.dw, iFx, iFx, iFx, iFx);
        if (zx.k(this.nr) != null && (viewU = u(this.k)) != null) {
            int i = (this.iz * 406) / 600;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
            int i2 = oVar.nr;
            if (i2 == 1) {
                int i3 = (this.iz * 406) / 600;
                layoutParams3 = new FrameLayout.LayoutParams(i3, (i3 * 9) / 16);
            } else if (i2 == 2) {
                layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            } else if (i2 == 3) {
                int i4 = (this.x * 188) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                layoutParams3 = new FrameLayout.LayoutParams((i4 * 16) / 9, i4);
            } else if (i2 == 4) {
                int i5 = (this.iz * TECameraSettings.FPS_480) / 690;
                layoutParams3 = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
            }
            layoutParams3.gravity = 17;
            frameLayout.addView(viewU, 0, layoutParams3);
            y.u((View) imageView, 8);
        } else {
            u(imageView);
            y.u((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.dd()).to(imageView2);
        textView.setText(getNameOrSource());
        this.bg.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.bq.setText(getDescription());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView2.setText(this.nr.yb());
        }
        u((View) this, true);
        u((View) textView2, true);
        u(frameLayout);
    }

    private o u(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 300.0d) / 600.0d) ? mv[1] : mv[0];
        } catch (Throwable unused) {
            return mv[0];
        }
    }
}
