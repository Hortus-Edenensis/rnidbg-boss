package com.opos.mobad.ui.feedback.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.cmn.module.ui.a.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10263a;
    private RelativeLayout b;
    private RelativeLayout c;
    private c d;

    public d(Context context, c cVar) {
        this.f10263a = context;
        this.d = cVar;
        b();
    }

    private int a(int i) {
        Context context = this.f10263a;
        if (context == null) {
            return 0;
        }
        return com.opos.cmn.an.h.f.a.a(context, i);
    }

    private void b() {
        this.c = new RelativeLayout(this.f10263a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.c.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f10263a);
        this.b = relativeLayout;
        relativeLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f10263a.getResources().getColor(R.color.opos_mobad_bg_color));
        gradientDrawable.setCornerRadius(a(24));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE), a(218));
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = a(40);
        this.b.setBackground(gradientDrawable);
        this.b.setLayoutParams(layoutParams2);
        c();
        this.c.addView(this.b);
    }

    private void c() {
        TextView textView = new TextView(this.f10263a);
        textView.setText("屏蔽此广告");
        textView.setTextSize(1, 18.0f);
        textView.setId(View.generateViewId());
        textView.setTypeface(null, 1);
        Resources resources = this.f10263a.getResources();
        int i = R.color.opos_mobad_text_color;
        textView.setTextColor(resources.getColor(i));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, a(24), 0, 0);
        this.b.addView(textView, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f10263a);
        linearLayout.setOrientation(0);
        linearLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), a(40));
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = a(14);
        layoutParams2.addRule(14);
        this.b.addView(linearLayout, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        e eVar = new e(this.f10263a);
        Resources resources2 = this.f10263a.getResources();
        int i2 = R.color.opos_mobad_start_color;
        int color = resources2.getColor(i2);
        Resources resources3 = this.f10263a.getResources();
        int i3 = R.color.opos_mobad_end_color;
        eVar.a(color, resources3.getColor(i3));
        eVar.setBackgroundColor(this.f10263a.getResources().getColor(i2));
        LinearLayout linearLayout2 = new LinearLayout(this.f10263a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(a(47), 0, a(47), 0);
        linearLayout2.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(this.f10263a);
        com.opos.mobad.ui.feedback.a.a aVar = com.opos.mobad.ui.feedback.a.a.TAG_TITLE_FAKE;
        textView2.setText(aVar.b());
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(this.f10263a.getResources().getColor(i));
        textView2.setId(View.generateViewId());
        textView2.setTypeface(null, 0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        linearLayout2.addView(textView2, layoutParams5);
        a(eVar, aVar.a());
        eVar.addView(linearLayout2, a(136), a(40));
        linearLayout.addView(eVar, layoutParams3);
        linearLayout.addView(new View(this.f10263a), new LinearLayout.LayoutParams(a(8), -1));
        e eVar2 = new e(this.f10263a);
        eVar2.a(this.f10263a.getResources().getColor(i2), this.f10263a.getResources().getColor(i3));
        eVar2.setBackgroundColor(this.f10263a.getResources().getColor(i2));
        LinearLayout linearLayout3 = new LinearLayout(this.f10263a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(a(33), 0, a(33), 0);
        linearLayout3.setLayoutParams(layoutParams6);
        TextView textView3 = new TextView(this.f10263a);
        com.opos.mobad.ui.feedback.a.a aVar2 = com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_LOW_QUALITY;
        textView3.setText(aVar2.b());
        textView3.setTextSize(1, 14.0f);
        textView3.setTextColor(this.f10263a.getResources().getColor(i));
        textView3.setTypeface(null, 0);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 16;
        linearLayout3.addView(textView3, layoutParams7);
        a(eVar2, aVar2.a());
        eVar2.addView(linearLayout3, a(136), a(40));
        linearLayout.addView(eVar2, layoutParams3);
        LinearLayout linearLayout4 = new LinearLayout(this.f10263a);
        linearLayout4.setOrientation(0);
        linearLayout4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), a(40));
        layoutParams8.addRule(3, linearLayout.getId());
        layoutParams8.topMargin = a(8);
        layoutParams8.addRule(14);
        this.b.addView(linearLayout4, layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        e eVar3 = new e(this.f10263a);
        eVar3.a(this.f10263a.getResources().getColor(i2), this.f10263a.getResources().getColor(i3));
        eVar3.setBackgroundColor(this.f10263a.getResources().getColor(i2));
        LinearLayout linearLayout5 = new LinearLayout(this.f10263a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout5.setOrientation(0);
        linearLayout5.setPadding(a(40), 0, a(40), 0);
        linearLayout5.setLayoutParams(layoutParams10);
        TextView textView4 = new TextView(this.f10263a);
        com.opos.mobad.ui.feedback.a.a aVar3 = com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_FAKE;
        textView4.setText(aVar3.b());
        textView4.setTextSize(1, 14.0f);
        textView4.setTextColor(this.f10263a.getResources().getColor(i));
        textView4.setId(View.generateViewId());
        textView4.setTypeface(null, 0);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.gravity = 16;
        linearLayout5.addView(textView4, layoutParams11);
        a(eVar3, aVar3.a());
        eVar3.addView(linearLayout5, a(136), a(40));
        linearLayout4.addView(eVar3, layoutParams9);
        linearLayout4.addView(new View(this.f10263a), new LinearLayout.LayoutParams(a(8), -1));
        e eVar4 = new e(this.f10263a);
        eVar4.a(this.f10263a.getResources().getColor(i2), this.f10263a.getResources().getColor(i3));
        eVar4.setBackgroundColor(this.f10263a.getResources().getColor(i2));
        LinearLayout linearLayout6 = new LinearLayout(this.f10263a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(a(136), a(40), 17.0f);
        linearLayout6.setOrientation(0);
        linearLayout6.setPadding(a(40), 0, a(40), 0);
        linearLayout6.setLayoutParams(layoutParams12);
        TextView textView5 = new TextView(this.f10263a);
        com.opos.mobad.ui.feedback.a.a aVar4 = com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_REPEAT;
        textView5.setText(aVar4.b());
        textView5.setTextSize(1, 14.0f);
        textView5.setTextColor(this.f10263a.getResources().getColor(i));
        textView5.setTypeface(null, 0);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 16;
        linearLayout6.addView(textView5, layoutParams13);
        a(eVar4, aVar4.a());
        eVar4.addView(linearLayout6, a(136), a(40));
        linearLayout4.addView(eVar4, layoutParams9);
        TextView textView6 = new TextView(this.f10263a);
        textView6.setText("取消");
        textView6.setTextSize(1, 16.0f);
        textView6.setTextColor(this.f10263a.getResources().getColor(R.color.opos_mobad_cancelBtn_color));
        textView6.setTypeface(null, 1);
        textView6.setGravity(17);
        textView6.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(a(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN), -2);
        layoutParams14.addRule(14);
        layoutParams14.addRule(3, linearLayout4.getId());
        layoutParams14.topMargin = a(20);
        a(textView6);
        this.b.addView(textView6, layoutParams14);
    }

    public View a() {
        return this.c;
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.feedback.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.d.a();
                }
            });
        }
    }

    private void a(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.feedback.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.d != null) {
                        d.this.d.a(i);
                    }
                }
            });
        }
    }
}
