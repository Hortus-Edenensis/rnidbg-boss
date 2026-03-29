package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.f;
import com.opos.mobad.template.cmn.v;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.cmn.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.d.b f10131a;
    private int b;
    private int c;
    private int d;
    private int e;
    private View f;
    private w g;
    private LinearLayout h;
    private y i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private View m;
    private g n;
    private RelativeLayout o;
    private boolean p;

    public m(Context context) {
        super(context);
        this.b = Color.parseColor(com.opos.mobad.template.cmn.d.COLOR_DEF.a());
        a(context);
    }

    private void c() {
        com.opos.mobad.template.d.b bVar = this.f10131a;
        if (bVar != null && TextUtils.isEmpty(bVar.b) && this.i.getVisibility() == 8) {
            this.h.setVisibility(8);
        }
    }

    private void d() {
        this.f.setBackgroundColor(ColorUtils.setAlphaComponent(this.c, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD));
        float[] fArr = {0.0f, 0.68f, 0.7f};
        ColorUtils.colorToHSL(this.c, fArr);
        float[] fArr2 = {0.0f, 0.68f, 0.6f};
        ColorUtils.colorToHSL(this.c, fArr2);
        this.d = ColorUtils.HSLToColor(fArr);
        this.e = ColorUtils.HSLToColor(fArr2);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(this.d, 200), ColorUtils.setAlphaComponent(this.d, 100), ColorUtils.setAlphaComponent(this.d, 50), ColorUtils.setAlphaComponent(this.d, 0)});
        gradientDrawable.setShape(0);
        this.m.setBackground(gradientDrawable);
        if (this.o.indexOfChild(this.n) < 0) {
            g gVar = new g(getContext(), this.c, this.d, this.e);
            this.n = gVar;
            gVar.setBackgroundResource(R.drawable.opos_mobad_half_background);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 243.0f));
            layoutParams.addRule(12);
            this.n.setLayoutParams(layoutParams);
            this.o.addView(this.n);
            this.n.invalidate();
            com.opos.mobad.template.h.a(getContext(), 0, this.o);
        }
    }

    @Override // com.opos.mobad.template.i.e
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.template.i.e
    public void b() {
        this.p = true;
        removeAllViews();
    }

    private void a(Context context) {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(imageView);
        a(context, imageView, R.drawable.opos_mobad_bg_splash);
        View view = new View(context);
        this.f = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f);
        this.o = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 120.0f);
        this.o.setLayoutParams(layoutParams);
        addView(this.o);
        this.g = new w(context);
        int iA = com.opos.cmn.an.h.f.a.a(context, 298.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 362.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.addRule(14);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(context, 10.0f);
        this.g.a(com.opos.cmn.an.h.f.a.a(context, 26.0f));
        this.o.addView(this.g, layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), ColorUtils.setAlphaComponent(-1, 89), ColorUtils.setAlphaComponent(-1, 38), ColorUtils.setAlphaComponent(-1, 0)});
        gradientDrawable.setShape(0);
        this.g.setBackground(gradientDrawable);
        w wVar = new w(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA - com.opos.cmn.an.h.f.a.a(context, 8.0f), iA2 - com.opos.cmn.an.h.f.a.a(context, 8.0f));
        layoutParams3.addRule(13);
        wVar.a(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.g.addView(wVar, layoutParams3);
        wVar.setBackgroundColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        this.m = new View(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 180.0f));
        layoutParams4.addRule(12);
        this.g.addView(this.m, layoutParams4);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 264.0f), -1);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        wVar.addView(linearLayout, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.h = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout.addView(this.h);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.i = nVar;
        nVar.setVisibility(8);
        int iA3 = com.opos.cmn.an.h.f.a.a(context, 42.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iA3, iA3);
        layoutParams6.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 12.0f));
        this.i.setLayoutParams(layoutParams6);
        this.h.addView(this.i);
        TextView textView = new TextView(context);
        this.j = textView;
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 210.0f), iA3);
        layoutParams7.gravity = 16;
        this.j.setTextColor(ColorUtils.setAlphaComponent(-16777216, 229));
        this.j.setGravity(16);
        this.j.setLines(1);
        this.j.setTextSize(1, 16.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.h.addView(this.j, layoutParams7);
        v vVar = new v(context, com.opos.cmn.an.h.f.a.a(context, 12.0f));
        this.k = vVar;
        vVar.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 148.0f));
        layoutParams8.gravity = 1;
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        linearLayout.addView(this.k, layoutParams8);
        this.l = new TextView(context);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 46.0f));
        layoutParams9.gravity = 16;
        layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        this.l.setMaxLines(2);
        this.l.setTextSize(1, 16.0f);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setTextColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD));
        linearLayout.addView(this.l, layoutParams9);
    }

    private void b(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.i.m.3
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                m.this.a(palette);
            }
        });
    }

    private void a(Context context, final View view, int i) {
        com.opos.mobad.template.cmn.f.a(context, BitmapFactory.decodeResource(context.getResources(), i), 100, 1.0f, 60.0f, new f.a() { // from class: com.opos.mobad.template.i.m.1
            @Override // com.opos.mobad.template.cmn.f.a
            public void a() {
            }

            @Override // com.opos.mobad.template.cmn.f.a
            public void a(Bitmap bitmap) {
                if (m.this.p) {
                    com.opos.cmn.an.f.a.a("SplashCustomView", "splashCustomView is destroy");
                } else {
                    m.this.a(bitmap, view);
                }
            }
        });
    }

    @Override // com.opos.mobad.template.i.e
    public void a(Bitmap bitmap) {
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        if (bitmap != null) {
            b(bitmap);
            return;
        }
        com.opos.mobad.template.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 264.0f), com.opos.cmn.an.h.f.a.a(getContext(), 148.0f), this.k);
        this.c = this.b;
        d();
        com.opos.cmn.an.f.a.b("SplashCustomView", "Failed to call color picker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap, final View view) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.i.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.p) {
                    com.opos.cmn.an.f.a.a("SplashCustomView", "setImageBackgroundDrawable is destroy");
                } else {
                    view.setBackground(new BitmapDrawable(bitmap));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette) {
        if (this.p) {
            com.opos.cmn.an.f.a.a("SplashCustomView", "takeColor call view is destroyed");
            return;
        }
        Palette.Swatch swatchA = com.opos.mobad.template.cmn.s.a(palette);
        this.c = swatchA == null ? this.b : com.opos.mobad.template.cmn.s.a((int) swatchA.getHsl()[0], this.b);
        d();
    }

    @Override // com.opos.mobad.template.i.e
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        int i;
        if (bVar != null) {
            this.f10131a = bVar;
            this.j.setText(bVar.b);
            this.l.setText(bVar.f9413a);
        }
        y yVar = this.i;
        if (bitmap != null) {
            yVar.setImageBitmap(bitmap);
            yVar = this.i;
            i = 0;
        } else {
            i = 8;
        }
        yVar.setVisibility(i);
        c();
    }
}
