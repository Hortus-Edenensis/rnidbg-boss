package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.v;
import com.opos.mobad.template.cmn.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class p extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f10139a;
    protected int b;
    private View c;
    private TextView d;
    private TextView e;
    private y f;
    private RelativeLayout g;
    private RelativeLayout h;
    private ImageView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private com.opos.mobad.template.cmn.g l;
    private View m;
    private boolean n;

    public p(Context context) {
        super(context);
        this.f10139a = Color.parseColor(com.opos.mobad.template.cmn.d.COLOR_DEF.a());
        a(context);
    }

    private void c() {
        this.c.setBackgroundColor(this.b);
        int i = this.b;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.setAlphaComponent(i, 255), ColorUtils.setAlphaComponent(i, 255)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 24.0f));
        this.m.setBackground(gradientDrawable);
    }

    @Override // com.opos.mobad.template.i.e
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.template.i.e
    public void b() {
        this.n = true;
        removeAllViews();
    }

    private void a(int i) {
        this.b = (i < 0 || i > 19) ? com.opos.mobad.template.cmn.s.a(i, this.f10139a) : Color.parseColor("#E5685C");
    }

    private void b(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.h = relativeLayout;
        this.g.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = new View(context);
        this.m = view;
        this.h.addView(view, layoutParams);
        this.l = new com.opos.mobad.template.cmn.g(context, new int[]{1308622847, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, 654311423, 452984831}, new float[]{0.1f, 0.3f, 0.7f, 1.0f}).a(com.opos.cmn.an.h.f.a.a(context, 24.0f)).b(com.opos.cmn.an.h.f.a.a(context, 1.5f)).a(Paint.Style.STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(14);
        this.l.a(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.h.addView(this.l, layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1509949439, 1308622847, 1090519039, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, 654311423});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        View view2 = new View(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        view2.setBackground(gradientDrawable);
        layoutParams3.addRule(14);
        this.h.addView(view2, layoutParams3);
        v vVar = new v(context, com.opos.cmn.an.h.f.a.a(context, 12.0f));
        this.i = vVar;
        vVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 141.0f), com.opos.cmn.an.h.f.a.a(context, 248.0f));
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        layoutParams4.addRule(15);
        this.h.addView(this.i, layoutParams4);
        this.j = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 363.0f), com.opos.cmn.an.h.f.a.a(context, 106.0f));
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 197.0f);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 95.0f);
        layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        this.j.setLayoutParams(layoutParams5);
        this.h.addView(this.j);
        int iA = com.opos.cmn.an.h.f.a.a(context, 106.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.f = nVar;
        nVar.setId(View.generateViewId());
        this.j.addView(this.f, new RelativeLayout.LayoutParams(iA, iA));
        this.k = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 233.0f), -2);
        layoutParams6.addRule(15);
        layoutParams6.addRule(1, this.f.getId());
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        this.k.setLayoutParams(layoutParams6);
        this.j.addView(this.k);
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setId(View.generateViewId());
        this.d.setLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 253.0f), -2);
        this.d.setGravity(3);
        this.d.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF));
        this.d.setTextSize(1, 24.0f);
        com.opos.mobad.template.h.a(this.d);
        this.k.addView(this.d, layoutParams7);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        textView2.setLines(1);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 253.0f), -2);
        layoutParams8.addRule(3, this.d.getId());
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.e.setGravity(3);
        this.e.setTextSize(1, 16.0f);
        this.e.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.k.addView(this.e, layoutParams8);
    }

    private void b(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.i.p.1
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                p.this.a(palette);
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
        com.opos.mobad.template.h.a(context, 1, this);
        this.g = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 584.0f), com.opos.cmn.an.h.f.a.a(context, 296.0f));
        layoutParams.addRule(13);
        this.g.setLayoutParams(layoutParams);
        addView(this.g);
        b(context);
    }

    @Override // com.opos.mobad.template.i.e
    public void a(Bitmap bitmap) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        if (bitmap != null) {
            b(bitmap);
            return;
        }
        com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 141.0f), com.opos.cmn.an.h.f.a.a(getContext(), 248.0f), this.i);
        this.b = this.f10139a;
        c();
        com.opos.cmn.an.f.a.b("SplashLandIconCustomView", "Failed to call color picker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette) {
        if (this.n) {
            com.opos.cmn.an.f.a.a("SplashLandIconCustomView", "takeColor call view is destroyed");
            return;
        }
        Palette.Swatch swatchA = com.opos.mobad.template.cmn.s.a(palette);
        if (swatchA == null) {
            this.b = this.f10139a;
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
            }
            if (!TextUtils.isEmpty(bVar.f9413a)) {
                this.e.setText(bVar.f9413a);
            }
        }
        if (bitmap != null) {
            this.f.setImageBitmap(bitmap);
        } else {
            com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 106.0f), com.opos.cmn.an.h.f.a.a(getContext(), 106.0f), this.f);
        }
    }
}
