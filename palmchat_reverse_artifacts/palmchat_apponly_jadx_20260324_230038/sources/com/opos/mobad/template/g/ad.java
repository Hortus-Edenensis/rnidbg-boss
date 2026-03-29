package com.opos.mobad.template.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.wifi.adsdk.utils.LxAdSystemBarTintManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ad extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9661a;
    private ac b;
    private com.opos.mobad.template.k.c c;
    private com.opos.mobad.template.cmn.baseview.b d;
    private TextView e;
    private int f;
    private com.opos.mobad.d.a g;
    private int h;
    private RelativeLayout i;
    private BaseImageView j;
    private a.InterfaceC0778a k;
    private a l;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public ad(Context context, int i, com.opos.mobad.d.a aVar) {
        super(context);
        this.f9661a = 12;
        this.f = 0;
        this.g = aVar;
        this.h = i;
        if (a(i)) {
            b(i);
        } else {
            a();
        }
    }

    private void b(int i) {
        int iA;
        ImageView imageView = new ImageView(getContext());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.i = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (i == 10) {
            imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close_native_no_bg);
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            this.f9661a = 6;
        } else {
            imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close_native);
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        }
        this.i.addView(imageView, new RelativeLayout.LayoutParams(iA, iA));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f9661a);
        if (i == 9) {
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(10);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f9661a);
        }
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ad.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ad.this.k != null) {
                    ad.this.k.e(view, iArr);
                }
            }
        };
        this.i.setOnTouchListener(pVar);
        this.i.setOnClickListener(pVar);
        addView(this.i, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i = this.f;
        int i2 = i != 0 ? i == 1 ? 0 : -1 : 1;
        if (i2 == -1) {
            return;
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(i2);
        }
        c(i2);
    }

    public ad(Context context, boolean z, com.opos.mobad.d.a aVar) {
        this(context, z ? 4 : 5, aVar);
    }

    public static ad a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new ad(context, i, aVar);
    }

    private void b(RelativeLayout.LayoutParams layoutParams, int i, com.opos.mobad.template.cmn.p pVar) {
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.i = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(LxAdSystemBarTintManager.DEFAULT_TINT_COLOR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        int i2 = this.h;
        if (i2 == 1 || i2 == 6) {
            layoutParams.topMargin = i;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), 0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f)});
        } else if (i2 == 2 || i2 == 7) {
            layoutParams.topMargin = i;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f)});
        } else if (i2 == 3) {
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
            gradientDrawable.setCornerRadii(new float[]{com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), 0.0f, 0.0f, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f), 0.0f, 0.0f});
        }
        addView(this.h == 11 ? this.c : this.b, layoutParams);
        this.i.setBackground(gradientDrawable);
        layoutParams2.addRule(11);
        addView(this.i, layoutParams2);
        BaseImageView baseImageView = new BaseImageView(getContext());
        this.j = baseImageView;
        baseImageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams3.addRule(13);
        this.i.addView(this.j, layoutParams3);
        this.j.setOnTouchListener(pVar);
        this.j.setOnClickListener(pVar);
    }

    private void c() {
        if (b()) {
            this.e = new TextView(getContext());
            com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ad.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (ad.this.k != null) {
                        ad.this.d();
                        ad.this.k.a(view, iArr, ad.this.f == 1);
                    }
                }
            };
            this.e.setOnClickListener(pVar);
            this.e.setOnTouchListener(pVar);
            this.e.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
            if (this.h == 4) {
                layoutParams.addRule(0, this.d.getId());
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
            } else {
                layoutParams.addRule(0, this.i.getId());
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            }
            addView(this.e, layoutParams);
        }
    }

    public static ad a(Context context, boolean z, com.opos.mobad.d.a aVar) {
        return new ad(context, z, aVar);
    }

    private void c(int i) {
        Resources resources;
        int i2;
        TextView textView = this.e;
        if (textView == null || this.f == i) {
            return;
        }
        this.f = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    private void a() {
        if (this.h == 11) {
            this.c = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.g);
        } else {
            this.b = ac.a(getContext(), this.g);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.leftMargin = iA;
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ad.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ad.this.k != null) {
                    ad.this.k.e(view, iArr);
                }
            }
        };
        int i = this.h;
        if (i == 4 || i == 5 || i == 11) {
            a(layoutParams, iA, pVar);
        } else {
            b(layoutParams, iA, pVar);
        }
        c();
    }

    private boolean b() {
        int i = this.h;
        return i == 4 || i == 6 || i == 7;
    }

    private void a(RelativeLayout.LayoutParams layoutParams, int i, com.opos.mobad.template.cmn.p pVar) {
        layoutParams.addRule(15);
        addView(this.h == 11 ? this.c : this.b, layoutParams);
        this.d = new com.opos.mobad.template.cmn.baseview.b(getContext());
        ImageView imageView = new ImageView(getContext());
        this.d.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        this.d.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = i;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        this.d.setOnTouchListener(pVar);
        this.d.setOnClickListener(pVar);
        addView(this.d, layoutParams2);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.k = interfaceC0778a;
        if (this.h == 11) {
            com.opos.mobad.template.k.c cVar = this.c;
            if (cVar != null) {
                cVar.a(interfaceC0778a);
                return;
            }
            return;
        }
        ac acVar = this.b;
        if (acVar != null) {
            acVar.a(interfaceC0778a);
        }
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        this.c.a(bVar.p, bVar.e, bVar.g, bVar.i);
        c(bVar.A);
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2, int i) {
        this.b.a(z, str, z2, eVar, str2);
        c(i);
    }

    private boolean a(int i) {
        return i == 9 || i == 8 || i == 10;
    }
}
