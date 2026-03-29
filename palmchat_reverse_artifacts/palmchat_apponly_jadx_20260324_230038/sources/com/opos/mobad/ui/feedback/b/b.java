package com.opos.mobad.ui.feedback.b;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.cmn.module.ui.a.e;
import com.opos.mobad.ui.feedback.FeedBackWebViewActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f10260a = true;
    private Context b;
    private RelativeLayout c;
    private RelativeLayout d;
    private c e;
    private d f;
    private UiModeManager g;
    private String h;

    public b(Context context, c cVar, String str) {
        this.b = context;
        this.g = (UiModeManager) context.getSystemService("uimode");
        this.e = cVar;
        this.h = str;
        c();
    }

    private int a(int i) {
        Context context = this.b;
        if (context == null) {
            return 0;
        }
        return com.opos.cmn.an.h.f.a.a(context, i);
    }

    private void c() {
        this.d = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.c = relativeLayout;
        relativeLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.b.getResources().getColor(R.color.opos_mobad_bg_color));
        gradientDrawable.setCornerRadius(a(24));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE), a(218));
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = a(40);
        this.c.setBackground(gradientDrawable);
        this.c.setLayoutParams(layoutParams2);
        d();
        this.d.addView(this.c);
    }

    private void d() {
        TextView textView = new TextView(this.b);
        textView.setText("关闭这条广告的原因");
        textView.setTextSize(1, 18.0f);
        textView.setId(View.generateViewId());
        Resources resources = this.b.getResources();
        int i = R.color.opos_mobad_text_color;
        textView.setTextColor(resources.getColor(i));
        textView.setTypeface(null, 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, a(24), 0, 0);
        this.c.addView(textView, layoutParams);
        UiModeManager uiModeManager = this.g;
        Drawable drawableC = com.opos.cmn.an.e.a.a.c(this.b, (uiModeManager == null || uiModeManager.getNightMode() != 2) ? "ic_feed_block_arrow_right.png" : "ic_feed_block_arrow_right_night.png");
        if (!f10260a && drawableC == null) {
            throw new AssertionError();
        }
        drawableC.setBounds(a(8), a(4), a(6), a(10));
        e eVar = new e(this.b);
        eVar.setId(View.generateViewId());
        Resources resources2 = this.b.getResources();
        int i2 = R.color.opos_mobad_start_color;
        int color = resources2.getColor(i2);
        Resources resources3 = this.b.getResources();
        int i3 = R.color.opos_mobad_end_color;
        eVar.a(color, resources3.getColor(i3));
        eVar.setBackgroundColor(this.b.getResources().getColor(i2));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), a(40));
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.addRule(14);
        layoutParams2.topMargin = a(14);
        TextView textView2 = new TextView(this.b);
        textView2.setGravity(17);
        com.opos.mobad.ui.feedback.a.a aVar = com.opos.mobad.ui.feedback.a.a.TAG_NOT_INTERESTED_CONTENT;
        textView2.setText(aVar.b());
        textView2.setTextColor(this.b.getResources().getColor(i));
        textView2.setTypeface(null, 0);
        textView2.setTextSize(1, 14.0f);
        a(eVar, aVar.a());
        eVar.addView(textView2, a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), a(40));
        this.c.addView(eVar, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(0);
        linearLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), a(40));
        layoutParams3.addRule(3, eVar.getId());
        layoutParams3.topMargin = a(8);
        layoutParams3.addRule(14);
        this.c.addView(linearLayout, layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, a(40), 1.0f);
        e eVar2 = new e(this.b);
        eVar2.a(this.b.getResources().getColor(i2), this.b.getResources().getColor(i3));
        eVar2.setBackgroundColor(this.b.getResources().getColor(i2));
        LinearLayout linearLayout2 = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(a(25), 0, a(25), 0);
        linearLayout2.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(this.b);
        textView3.setId(View.generateViewId());
        com.opos.mobad.ui.feedback.a.a aVar2 = com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT;
        textView3.setText(aVar2.b());
        textView3.setTextColor(this.b.getResources().getColor(i));
        textView3.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 16;
        linearLayout2.addView(textView3, layoutParams6);
        ImageView imageView = new ImageView(this.b);
        imageView.setImageDrawable(drawableC);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(a(16), a(16));
        layoutParams7.gravity = 16;
        linearLayout2.addView(imageView, layoutParams7);
        a(eVar2, aVar2.a());
        eVar2.addView(linearLayout2, a(136), a(40));
        linearLayout.addView(eVar2, layoutParams4);
        linearLayout.addView(new View(this.b), new LinearLayout.LayoutParams(a(8), -1));
        e eVar3 = new e(this.b);
        eVar3.a(this.b.getResources().getColor(i2), this.b.getResources().getColor(i3));
        eVar3.setBackgroundColor(this.b.getResources().getColor(i2));
        LinearLayout linearLayout3 = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(a(32), 0, a(32), 0);
        linearLayout3.setLayoutParams(layoutParams8);
        TextView textView4 = new TextView(this.b);
        textView4.setId(View.generateViewId());
        com.opos.mobad.ui.feedback.a.a aVar3 = com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT;
        textView4.setText(aVar3.b());
        textView4.setTextColor(this.b.getResources().getColor(i));
        textView4.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 16;
        linearLayout3.addView(textView4, layoutParams9);
        ImageView imageView2 = new ImageView(this.b);
        imageView2.setImageDrawable(drawableC);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(a(16), a(16));
        layoutParams10.gravity = 16;
        linearLayout3.addView(imageView2, layoutParams10);
        a(eVar3, aVar3.a());
        eVar3.addView(linearLayout3, a(136), a(40));
        linearLayout.addView(eVar3, layoutParams4);
        TextView textView5 = new TextView(this.b);
        textView5.setText("取消");
        textView5.setTextSize(1, 16.0f);
        textView5.setTextColor(this.b.getResources().getColor(R.color.opos_mobad_cancelBtn_color));
        textView5.setTypeface(null, 1);
        textView5.setGravity(17);
        textView5.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), -2);
        layoutParams11.addRule(14);
        layoutParams11.addRule(3, linearLayout.getId());
        layoutParams11.topMargin = a(20);
        a(textView5);
        this.c.addView(textView5, layoutParams11);
    }

    public View a() {
        return this.d;
    }

    public void b() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.feedback.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.e.a();
                }
            });
        }
    }

    private void a(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.feedback.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (i == com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a() && b.this.d != null) {
                        b.this.d.removeView(b.this.d);
                        b bVar = b.this;
                        bVar.f = new d(bVar.b, b.this.e);
                        b.this.d.addView(b.this.f.a());
                    }
                    int i2 = i;
                    com.opos.mobad.ui.feedback.a.a aVar = com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT;
                    if (i2 == aVar.a()) {
                        try {
                            com.opos.cmn.module.ui.b.a.b.a(b.this.b, (b.this.h == null || b.this.h.length() <= 0) ? "https://api-audit.heytapmobi.com/report/index?content_id=552650788&source=advertise" : b.this.h, aVar.b(), FeedBackWebViewActivity.class);
                            FeedBackWebViewActivity.a(b.this.e);
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("FeedBackViewOS15", "WebViewDialog show error" + e);
                        }
                    }
                    if (b.this.e != null) {
                        b.this.e.a(i);
                    }
                }
            });
        }
    }
}
