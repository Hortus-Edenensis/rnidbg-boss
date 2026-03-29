package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class o extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f10137a;
    protected int b;
    private View c;
    private TextView d;
    private TextView e;
    private y f;
    private RelativeLayout g;
    private RelativeLayout h;
    private RelativeLayout i;
    private RelativeLayout j;
    private com.opos.mobad.template.cmn.g k;
    private View l;
    private boolean m;

    public o(Context context) {
        super(context);
        this.f10137a = Color.parseColor(com.opos.mobad.template.cmn.d.COLOR_DEF.a());
        a(context);
    }

    private void c() {
        this.c.setBackgroundColor(this.b);
        int i = this.b;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.setAlphaComponent(i, 255), ColorUtils.setAlphaComponent(i, 255)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 24.0f));
        this.l.setBackground(gradientDrawable);
    }

    @Override // com.opos.mobad.template.i.e
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.template.i.e
    public void b() {
        this.m = true;
        removeAllViews();
    }

    private void a(int i) {
        this.b = (i < 0 || i > 19) ? com.opos.mobad.template.cmn.s.a(i, this.f10137a) : Color.parseColor("#E5685C");
    }

    private void b(Context context) {
        int iA = com.opos.cmn.an.h.f.a.a(context, 428.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 154.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams.addRule(14);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.h = relativeLayout;
        this.g.addView(relativeLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        View view = new View(context);
        this.l = view;
        this.h.addView(view, layoutParams2);
        this.k = new com.opos.mobad.template.cmn.g(context, new int[]{1308622847, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, 654311423, 452984831}, new float[]{0.1f, 0.3f, 0.7f, 1.0f}).a(com.opos.cmn.an.h.f.a.a(context, 24.0f)).b(com.opos.cmn.an.h.f.a.a(context, 1.5f)).a(Paint.Style.STROKE);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams3.addRule(14);
        this.k.a(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.h.addView(this.k, layoutParams3);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1509949439, 1308622847, 1090519039, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, 654311423});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        View view2 = new View(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA, iA2);
        view2.setBackground(gradientDrawable);
        layoutParams4.addRule(14);
        this.h.addView(view2, layoutParams4);
        this.i = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 380.0f), com.opos.cmn.an.h.f.a.a(context, 106.0f));
        layoutParams5.addRule(13);
        this.i.setLayoutParams(layoutParams5);
        this.h.addView(this.i);
        int iA3 = com.opos.cmn.an.h.f.a.a(context, 106.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.f = nVar;
        nVar.setId(View.generateViewId());
        this.i.addView(this.f, new RelativeLayout.LayoutParams(iA3, iA3));
        this.j = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 250.0f), -2);
        layoutParams6.addRule(15);
        layoutParams6.addRule(1, this.f.getId());
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        this.j.setLayoutParams(layoutParams6);
        this.i.addView(this.j);
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setId(View.generateViewId());
        this.d.setLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 240.0f), -2);
        this.d.setGravity(3);
        this.d.setTextColor(-1);
        com.opos.mobad.template.h.a(this.d);
        this.j.addView(this.d, layoutParams7);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        textView2.setLines(1);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 250.0f), -2);
        layoutParams8.addRule(3, this.d.getId());
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.e.setGravity(3);
        this.e.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.e.setTextSize(1, 16.0f);
        this.j.addView(this.e, layoutParams8);
    }

    private void b(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.i.o.1
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                o.this.a(palette);
            }
        });
    }

    public void a(Context context) {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(context);
        this.c = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.c);
        View view2 = new View(context);
        view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.opos.mobad.template.h.a(view2, context.getResources().getDrawable(R.drawable.opos_mobad_splash_land_two_circles));
        addView(view2);
        this.g = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 72.0f);
        this.g.setLayoutParams(layoutParams);
        addView(this.g);
        com.opos.mobad.template.h.a(context, 1, this.g);
        b(context);
    }

    @Override // com.opos.mobad.template.i.e
    public void a(Bitmap bitmap) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette) {
        if (this.m) {
            com.opos.cmn.an.f.a.a("SplashLandIconCustomView", "takeColor call view is destroyed");
            return;
        }
        Palette.Swatch swatchA = com.opos.mobad.template.cmn.s.a(palette);
        if (swatchA == null) {
            this.b = this.f10137a;
        } else {
            a((int) swatchA.getHsl()[0]);
        }
        c();
    }

    @Override // com.opos.mobad.template.i.e
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.b)) {
                this.d.setText(bVar.b);
                this.d.setTextSize(1, 24.0f);
            }
            if (!TextUtils.isEmpty(bVar.f9413a)) {
                this.e.setText(bVar.f9413a);
            }
        }
        if (bitmap != null) {
            this.f.setImageBitmap(bitmap);
            b(bitmap);
        } else {
            com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 106.0f), com.opos.cmn.an.h.f.a.a(getContext(), 106.0f), this.f);
            this.b = this.f10137a;
            c();
            com.opos.cmn.an.f.a.b("SplashLandIconCustomView", "Failed to call color picker");
        }
    }
}
