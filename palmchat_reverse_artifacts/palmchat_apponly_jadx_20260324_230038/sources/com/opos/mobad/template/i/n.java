package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
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
public class n extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f10135a;
    protected int b;
    private View c;
    private TextView d;
    private TextView e;
    private y f;
    private View g;
    private View h;
    private RelativeLayout i;
    private com.opos.mobad.template.cmn.g j;
    private View k;
    private h l;
    private int m;
    private boolean n;

    public n(Context context, int i) {
        super(context);
        this.f10135a = Color.parseColor(com.opos.mobad.template.cmn.d.COLOR_DEF.a());
        this.m = a(i);
        a(context);
    }

    private int a(int i) {
        if (i == 10 || i == 9) {
            return i;
        }
        return 10;
    }

    private void c() {
        this.c.setBackgroundColor(this.b);
        int i = this.b;
        int[] iArr = {ColorUtils.setAlphaComponent(i, 200), ColorUtils.setAlphaComponent(i, 100), ColorUtils.setAlphaComponent(i, 50), ColorUtils.setAlphaComponent(i, 0)};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        gradientDrawable.setGradientType(0);
        this.g.setBackground(gradientDrawable);
        if (this.m == 9 && this.k != null) {
            iArr = new int[]{ColorUtils.setAlphaComponent(i, 255), ColorUtils.setAlphaComponent(i, 255)};
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
            gradientDrawable2.setGradientType(0);
            gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 24.0f));
            this.k.setBackground(gradientDrawable2);
        }
        if (this.m != 10 || this.h == null) {
            return;
        }
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        gradientDrawable3.setGradientType(0);
        this.h.setBackground(gradientDrawable3);
    }

    @Override // com.opos.mobad.template.i.e
    public void b() {
        this.n = true;
        removeAllViews();
    }

    private void b(int i) {
        this.b = (i < 0 || i > 19) ? com.opos.mobad.template.cmn.s.a(i, this.f10135a) : Color.parseColor("#E5685C");
    }

    @Override // com.opos.mobad.template.i.e
    public View a() {
        return this;
    }

    private void b(Context context) {
        int iA = com.opos.cmn.an.h.f.a.a(context, 250.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 290.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA2);
        this.k = new View(context);
        layoutParams.addRule(14);
        this.i.addView(this.k, layoutParams);
        this.j = new com.opos.mobad.template.cmn.g(context, new int[]{1308622847, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR, 654311423, 452984831}, new float[]{0.1f, 0.3f, 0.7f, 1.0f}).a(com.opos.cmn.an.h.f.a.a(context, 24.0f)).b(com.opos.cmn.an.h.f.a.a(context, 1.5f)).a(Paint.Style.STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.addRule(14);
        this.j.a(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.i.addView(this.j, layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1728053247, 1593835519, 1476395007, 1342177279});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(context, 24.0f));
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
        view.setBackground(gradientDrawable);
        layoutParams3.addRule(14);
        this.i.addView(view, layoutParams3);
    }

    public void a(Context context) {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View view = new View(context);
        this.c = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.c);
        View view2 = new View(context);
        view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (this.m == 9) {
            com.opos.mobad.template.h.a(view2, context.getResources().getDrawable(R.drawable.opos_mobad_splash_two_circles));
        } else {
            h hVar = new h(getContext());
            this.l = hVar;
            hVar.a(Paint.Style.FILL);
            this.l.a(new int[]{1946157055, 1090519039, 855638016, 637534208}, new float[]{0.1f, 0.3f, 0.5f, 1.0f});
            view2 = this.l;
        }
        addView(view2);
        this.g = new FrameLayout(context);
        addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        if (this.m == 10) {
            this.h = new FrameLayout(context);
            addView(this.h, new RelativeLayout.LayoutParams(-1, -1));
        }
        this.i = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 140.0f);
        this.i.setLayoutParams(layoutParams);
        addView(this.i);
        int iA = com.opos.cmn.an.h.f.a.a(context, 66.0f);
        if (this.m == 9) {
            b(context);
            iA = com.opos.cmn.an.h.f.a.a(context, 47.0f);
        }
        com.opos.mobad.template.h.a(context, 0, this.i);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 106.0f);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 24.0f));
        this.f = nVar;
        nVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = iA;
        this.i.addView(this.f, layoutParams2);
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setId(View.generateViewId());
        this.d.setLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 220.0f), com.opos.cmn.an.h.f.a.a(context, 44.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f.getId());
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(context, 24.0f);
        this.d.setGravity(17);
        this.d.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        com.opos.mobad.template.h.a(this.d);
        this.i.addView(this.d, layoutParams3);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        textView2.setLines(1);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 220.0f), -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, this.d.getId());
        this.e.setGravity(17);
        this.e.setTextColor(ColorUtils.setAlphaComponent(-1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.e.setTextSize(1, 16.0f);
        this.i.addView(this.e, layoutParams4);
    }

    private void b(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.opos.mobad.template.i.n.1
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(Palette palette) {
                n.this.a(palette);
            }
        });
    }

    @Override // com.opos.mobad.template.i.e
    public void a(Bitmap bitmap) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Palette palette) {
        if (this.n) {
            com.opos.cmn.an.f.a.a("SplashIconCustomView", "takeColor call view is destroyed");
            return;
        }
        Palette.Swatch swatchA = com.opos.mobad.template.cmn.s.a(palette);
        if (swatchA == null) {
            this.b = this.f10135a;
        } else {
            b((int) swatchA.getHsl()[0]);
        }
        c();
    }

    @Override // com.opos.mobad.template.i.e
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.b)) {
                this.d.setText(bVar.b);
                this.d.setTextSize(1, 30.0f);
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
            this.b = this.f10135a;
            c();
            com.opos.cmn.an.f.a.b("SplashIconCustomView", "Failed to call color picker");
        }
    }
}
