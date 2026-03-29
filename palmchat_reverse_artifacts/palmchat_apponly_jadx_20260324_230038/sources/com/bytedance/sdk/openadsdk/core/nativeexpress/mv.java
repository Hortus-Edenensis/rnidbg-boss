package com.bytedance.sdk.openadsdk.core.nativeexpress;

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
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class mv extends BackupView {
    private static o[] mv = {new o(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new o(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new o(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new o(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new o(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new o(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private TextView bg;
    private ImageView bq;
    private View k;
    private NativeExpressView my;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx o;
    private int s;
    private TextView sx;

    public mv(Context context) {
        super(context);
        this.u = context;
    }

    private void a() {
        View viewSu = com.bytedance.sdk.openadsdk.res.pn.su(this.u);
        this.k = viewSu;
        addView(viewSu);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387734);
        frameLayout.setVisibility(0);
        this.k.findViewById(2114387955).setVisibility(8);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        y.u((TextView) this.k.findViewById(2114387658), this.nr);
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView.setText(this.nr.yb());
        }
        View viewU = u(this.my);
        if (viewU != null) {
            frameLayout.removeAllViews();
            int i = this.iz;
            frameLayout.addView(viewU, new ViewGroup.LayoutParams(i, (i * 9) / 16));
        }
        u(this, false);
        u(textView, true);
    }

    private o b(int i) {
        o[] oVarArr = mv;
        o oVar = oVarArr[0];
        try {
            for (o oVar2 : oVarArr) {
                if (oVar2.u == i) {
                    return oVar2;
                }
            }
            return oVar;
        } catch (Throwable unused) {
            return oVar;
        }
    }

    private void fx(int i) {
        o oVarB = b(this.nr.ol());
        this.iz = y.fx(this.u, this.my.getExpectExpressWidth());
        this.x = y.fx(this.u, this.my.getExpectExpressHeight());
        if (this.iz <= 0) {
            this.iz = y.b(this.u);
        }
        if (this.x <= 0) {
            this.x = Float.valueOf(this.iz / oVarB.fx).intValue();
        }
        int i2 = this.iz;
        if (i2 > 0 && i2 > y.b(this.u)) {
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
        if (i == 9) {
            this.pn = WifiNestConst.NestTypeConst.NEST_DRAW_AD;
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr)) {
                t();
                return;
            } else {
                n();
                return;
            }
        }
        this.pn = "embeded_ad";
        int iOl = this.nr.ol();
        if (iOl == 2) {
            fx();
            return;
        }
        if (iOl == 3) {
            iz();
            return;
        }
        if (iOl == 4) {
            b();
            return;
        }
        if (iOl == 5) {
            a();
            return;
        }
        if (iOl == 15) {
            x();
            return;
        }
        if (iOl == 16) {
            jk();
            return;
        }
        if (iOl == 131) {
            jk();
        } else if (iOl != 166) {
            jk();
        } else {
            l();
        }
    }

    private void iz() {
        View viewSu = com.bytedance.sdk.openadsdk.res.pn.su(this.u);
        this.k = viewSu;
        addView(viewSu);
        this.k.findViewById(2114387734).setVisibility(8);
        this.k.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        y.u((TextView) this.k.findViewById(2114387658), this.nr);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.x);
        u(imageView);
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView.setText(this.nr.yb());
        }
        u(this, false);
        u(textView, true);
    }

    private void jk() {
        View viewV = com.bytedance.sdk.openadsdk.res.pn.v(this.u);
        this.k = viewV;
        addView(viewV);
        this.k.findViewById(2114387734).setVisibility(8);
        this.k.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        y.u((TextView) this.k.findViewById(2114387658), this.nr);
        u(imageView);
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView.setText(this.nr.yb());
        }
        u(this, false);
        u(textView, true);
    }

    private void l() {
        String strValueOf;
        String strValueOf2;
        if (this.nr == null) {
            return;
        }
        View viewMh = com.bytedance.sdk.openadsdk.res.pn.mh(this.u);
        this.k = viewMh;
        addView(viewMh);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387621);
        TextView textView = (TextView) this.k.findViewById(2114387827);
        TextView textView2 = (TextView) this.k.findViewById(2114387937);
        View view = (TextView) this.k.findViewById(2114387861);
        RoundImageView roundImageView = (RoundImageView) this.k.findViewById(2114387902);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(2114387851);
        TextView textView3 = (TextView) this.k.findViewById(2114387622);
        TextView textView4 = (TextView) this.k.findViewById(2114387672);
        TextView textView5 = (TextView) this.k.findViewById(2114387703);
        ImageView imageView = (ImageView) this.k.findViewById(2114387881);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr)) {
            String strA = m.a(this.nr);
            if (TextUtils.isEmpty(strA) || roundImageView == null) {
                y.u((View) relativeLayout, 8);
            } else {
                y.u((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.n.nr.u(strA).to(roundImageView);
            }
            if (textView2 != null) {
                textView2.setText(m.fx(this.nr));
            }
            if (textView3 != null) {
                int iB = m.b(this.nr);
                if (iB < 0) {
                    textView3.setVisibility(4);
                    y.u((View) imageView, 4);
                } else {
                    String strU = com.bytedance.sdk.component.utils.q.u(this.u, "tt_live_fans_text");
                    if (iB > 10000) {
                        strValueOf2 = (iB / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf2 = String.valueOf(iB);
                    }
                    textView3.setText(String.format(strU, strValueOf2));
                }
            }
            if (textView4 != null) {
                int iPn = m.pn(this.nr);
                if (iPn < 0) {
                    textView4.setVisibility(4);
                    y.u((View) imageView, 4);
                } else {
                    String strU2 = com.bytedance.sdk.component.utils.q.u(this.u, "tt_live_watch_text");
                    if (iPn > 10000) {
                        strValueOf = (iPn / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf = String.valueOf(iPn);
                    }
                    textView4.setText(String.format(strU2, strValueOf));
                }
            }
            if (textView != null) {
                textView.setText(m.iz(this.nr));
            }
            View viewU = u(this.my);
            if (viewU != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewU, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVarMv = mv();
            u(roundImageView, uVarMv, "click_live_avata");
            u(textView2, uVarMv, "click_live_author_nickname");
            u(textView3, uVarMv, "click_live_author_follower_count");
            u(textView4, uVarMv, "click_live_author_following_count");
            u(textView, uVarMv, "click_live_author_description");
            u(frameLayout, uVarMv, "click_live_feed");
            u(view, uVarMv, "click_live_button");
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    mv.this.pn();
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.nr.u mv() {
        Context context = this.u;
        bc bcVar = this.nr;
        String str = this.pn;
        final com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(context, bcVar, str, jp.nr(str)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.8
            @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
                if (view == null) {
                    super.u(view, jkVar);
                    return;
                }
                HashMap map = new HashMap();
                map.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
                super.u(view, jkVar);
            }
        };
        fx fxVar = new fx() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.fx
            public void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
                try {
                    qVar.u().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).pn());
                } catch (JSONException unused) {
                }
                mv.this.u(view, i, qVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.nr.u.nr.u uVar2 = (com.bytedance.sdk.openadsdk.core.nr.u.nr.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.nr.u.class);
        if (uVar2 != null) {
            uVar2.u(fxVar);
            uVar2.u(2);
        }
        return uVar;
    }

    private void n() {
        View viewTk = com.bytedance.sdk.openadsdk.res.pn.tk(this.u);
        this.k = viewTk;
        addView(viewTk);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387734);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        TextView textView = (TextView) this.k.findViewById(2114387920);
        TextView textView2 = (TextView) this.k.findViewById(2114387940);
        TextView textView3 = (TextView) this.k.findViewById(2114387633);
        TextView textView4 = (TextView) this.k.findViewById(2114387658);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        y.u(textView4, this.nr);
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView3.setText(this.nr.yb());
        }
        if (bc.nr(this.nr)) {
            imageView.setVisibility(8);
        } else {
            u(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        View viewU = u(this.my);
        NativeExpressView nativeExpressView = this.my;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (viewU instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) viewU;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (viewU != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(viewU, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.k.setBackgroundColor(-16777216);
        }
        u(textView2, false);
        u(textView, false);
        u(textView3, true);
    }

    private void pn(int i) {
        if (i == 1) {
            nr();
            this.k.setBackgroundColor(0);
            if (this.bq != null) {
                com.bytedance.sdk.component.utils.q.u(getContext(), "tt_dislike_icon_night", this.bq);
                return;
            }
            return;
        }
        u();
        this.k.setBackgroundColor(-1);
        if (this.bq != null) {
            com.bytedance.sdk.component.utils.q.u(getContext(), "tt_dislike_icon2", this.bq);
        }
    }

    private void t() {
        String strValueOf;
        String strValueOf2;
        if (this.nr == null) {
            return;
        }
        View viewWi = com.bytedance.sdk.openadsdk.res.pn.wi(this.u);
        this.k = viewWi;
        addView(viewWi);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387765);
        TextView textView = (TextView) this.k.findViewById(2114387899);
        View view = (RelativeLayout) this.k.findViewById(2114387650);
        RoundImageView roundImageView = (RoundImageView) this.k.findViewById(2114387818);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(2114387777);
        TextView textView2 = (TextView) this.k.findViewById(2114387768);
        TextView textView3 = (TextView) this.k.findViewById(2114387619);
        TextView textView4 = (TextView) this.k.findViewById(2114387895);
        ImageView imageView = (ImageView) this.k.findViewById(2114387881);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr)) {
            String strA = m.a(this.nr);
            if (TextUtils.isEmpty(strA) || roundImageView == null) {
                y.u((View) relativeLayout, 8);
            } else {
                y.u((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.n.nr.u(strA).to(roundImageView);
            }
            if (textView != null) {
                textView.setText(m.fx(this.nr));
            }
            if (textView2 != null) {
                int iB = m.b(this.nr);
                if (iB < 0) {
                    textView2.setVisibility(4);
                    y.u((View) imageView, 4);
                } else {
                    String strU = com.bytedance.sdk.component.utils.q.u(this.u, "tt_live_fans_text");
                    if (iB > 10000) {
                        strValueOf2 = (iB / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf2 = String.valueOf(iB);
                    }
                    textView2.setText(String.format(strU, strValueOf2));
                }
            }
            if (textView3 != null) {
                int iPn = m.pn(this.nr);
                if (iPn < 0) {
                    y.u((View) imageView, 4);
                    textView3.setVisibility(4);
                } else {
                    String strU2 = com.bytedance.sdk.component.utils.q.u(this.u, "tt_live_watch_text");
                    if (iPn > 10000) {
                        strValueOf = (iPn / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf = String.valueOf(iPn);
                    }
                    textView3.setText(String.format(strU2, strValueOf));
                }
            }
            if (textView4 != null) {
                textView4.setText(m.iz(this.nr));
            }
            View viewU = u(this.my);
            if (viewU != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewU, new ViewGroup.LayoutParams(-1, -1));
            }
            com.bytedance.sdk.openadsdk.core.nr.u uVarMv = mv();
            u(roundImageView, uVarMv, "click_live_avata");
            u(textView, uVarMv, "click_live_author_nickname");
            u(textView2, uVarMv, "click_live_author_follower_count");
            u(textView3, uVarMv, "click_live_author_following_count");
            u(textView4, uVarMv, "click_live_author_description");
            u(frameLayout, uVarMv, "click_live_feed");
            u(view, uVarMv, "click_live_button");
        }
    }

    private void x() {
        View viewV = com.bytedance.sdk.openadsdk.res.pn.v(this.u);
        this.k = viewV;
        addView(viewV);
        this.k.findViewById(2114387734).setVisibility(0);
        this.k.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(2114387965);
        ImageView imageView = (ImageView) this.k.findViewById(2114387913);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387855);
        TextView textView2 = (TextView) this.k.findViewById(2114387856);
        TextView textView3 = (TextView) this.k.findViewById(2114387633);
        TextView textView4 = (TextView) this.k.findViewById(2114387908);
        TTRatingBar tTRatingBar = (TTRatingBar) this.k.findViewById(2114387874);
        y.u((TextView) this.k.findViewById(2114387617), this.nr);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.dd()).to(imageView);
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        int iPn = this.nr.pu() != null ? this.nr.pu().pn() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(iPn)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(iPn);
        tTRatingBar.setStarImageWidth(y.fx(this.u, 15.0f));
        tTRatingBar.setStarImageHeight(y.fx(this.u, 14.0f));
        tTRatingBar.setStarImagePadding(y.fx(this.u, 4.0f));
        tTRatingBar.u();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView3.setText(this.nr.yb());
        }
        View viewU = u(this.my);
        if (viewU != null) {
            int i = (this.iz * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(viewU, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        u(this, false);
        u(textView3, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.u
    public void b_(int i) {
        super.b_(i);
        pn(i);
    }

    public void nr() {
        TextView textView = this.sx;
        if (textView == null || this.bg == null) {
            return;
        }
        textView.setTextColor(-1);
        this.bg.setTextColor(-1);
    }

    public void u(bc bcVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar) {
        setBackgroundColor(-1);
        this.nr = bcVar;
        this.my = nativeExpressView;
        this.o = fxVar;
        int iT = jp.t(bcVar);
        this.s = iT;
        nr(iT);
        int iJk = jp.jk(this.nr);
        fx(iJk);
        pn(com.bytedance.sdk.openadsdk.core.n.o().ay());
        int i = iJk != 9 ? -2 : -1;
        this.my.addView(this, new ViewGroup.LayoutParams(i, i));
    }

    private void b() {
        View viewYd = com.bytedance.sdk.openadsdk.res.pn.yd(this.u);
        this.k = viewYd;
        addView(viewYd);
        ImageView imageView = (ImageView) this.k.findViewById(2114387695);
        ImageView imageView2 = (ImageView) this.k.findViewById(2114387692);
        ImageView imageView3 = (ImageView) this.k.findViewById(2114387690);
        ImageView imageView4 = (ImageView) this.k.findViewById(2114387931);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        TextView textView = (TextView) this.k.findViewById(2114387633);
        y.u((TextView) this.k.findViewById(2114387658), this.nr);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(0)).to(imageView);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(1)).to(imageView2);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(2)).to(imageView3);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.dd()).to(imageView4);
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        if (!TextUtils.isEmpty(this.nr.yb())) {
            textView.setText(this.nr.yb());
        }
        u(this, false);
        u(textView, true);
    }

    private void u(ImageView imageView) {
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.nr)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.nr), com.bytedance.sdk.openadsdk.pn.u.jk(this.nr));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.pn.u.u(imageView, upieImageView);
        }
    }

    private void u(View view, TextView textView, bc bcVar) {
        if (view == null || textView == null) {
            return;
        }
        if (bcVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(bcVar.uc())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            y.u(view, bcVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            y.u(textView, bcVar);
        }
    }

    private void u(View view, com.bytedance.sdk.openadsdk.core.nr.nr nrVar, String str) {
        if (view == null || nrVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        NativeExpressView nativeExpressView = this.my;
        if (nativeExpressView != null) {
            if (i == 1 && nativeExpressView.getClickListener() != null) {
                this.my.getClickListener().nr(this.bq);
            }
            if (i == 2 && this.my.getClickCreativeListener() != null) {
                this.my.getClickCreativeListener().nr(this.bq);
            }
            this.my.u(view, i, qVar);
        }
    }

    private void fx() {
        View viewXw = com.bytedance.sdk.openadsdk.res.pn.xw(this.u);
        this.k = viewXw;
        addView(viewXw);
        ImageView imageView = (ImageView) this.k.findViewById(2114387936);
        this.bq = (ImageView) this.k.findViewById(2114387854);
        this.bg = (TextView) this.k.findViewById(2114387920);
        this.sx = (TextView) this.k.findViewById(2114387940);
        u((LinearLayout) this.k.findViewById(2114387660), (TextView) this.k.findViewById(2114387658), this.nr);
        u(imageView);
        this.bg.setText(getDescription());
        this.sx.setText(getTitle());
        this.bq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.mv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mv.this.pn();
            }
        });
        u(this, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public NativeVideoTsView u(Context context, bc bcVar, String str, boolean z, boolean z2) {
        if (WifiNestConst.NestTypeConst.NEST_DRAW_AD.equals(str)) {
            return new NativeDrawVideoTsView(context, bcVar, str, z, z2);
        }
        return new NativeVideoTsView(context, bcVar, str, z, z2);
    }

    public void u() {
        if (this.sx == null || this.bg == null) {
            return;
        }
        int iOl = this.nr.ol();
        if (iOl != 2) {
            if (iOl != 3) {
                if (iOl == 4) {
                    this.sx.setTextColor(Color.parseColor("#FF3E3E3E"));
                    this.bg.setTextColor(Color.parseColor("#FF3E3E3E"));
                    return;
                } else if (iOl != 5 && iOl != 15 && iOl != 16) {
                    return;
                }
            }
            this.sx.setTextColor(Color.parseColor("#FF222222"));
            this.bg.setTextColor(Color.parseColor("#FF505050"));
            return;
        }
        this.sx.setTextColor(Color.parseColor("#FFBCBCBC"));
        this.bg.setTextColor(Color.parseColor("#FF999999"));
    }
}
