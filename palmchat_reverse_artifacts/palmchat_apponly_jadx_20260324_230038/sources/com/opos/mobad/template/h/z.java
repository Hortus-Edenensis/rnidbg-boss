package com.opos.mobad.template.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class z extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f10094a;
    private View b;
    private BaseImageView c;
    private BaseTextView d;
    private int e;
    private int f;
    private int g;
    private a.InterfaceC0778a h;
    private a i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public z(Context context, int i) {
        super(context);
        this.e = 0;
        this.g = 0;
        this.f = i;
        d();
    }

    private void d() {
        com.opos.mobad.template.cmn.p pVar;
        View view;
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        int i = this.f;
        gradientDrawable.setColor(i == 2 ? -1975368116 : i == 1 ? -1305333198 : -1288555982);
        setBackground(gradientDrawable);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(iA2, iA, iA2, iA);
        this.f10094a = new TextView(getContext());
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.z.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
                if (z.this.h != null) {
                    z.this.h.a(view2, iArr, z.this.e == 1);
                }
            }
        };
        this.f10094a.setOnClickListener(pVar2);
        this.f10094a.setOnTouchListener(pVar2);
        this.f10094a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        addView(this.f10094a, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f)));
        View view2 = new View(getContext());
        this.b = view2;
        view2.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setVisibility(8);
        addView(this.b, layoutParams);
        if (this.f == 2) {
            BaseTextView baseTextView = new BaseTextView(getContext());
            this.d = baseTextView;
            baseTextView.setTextSize(1, 14.0f);
            this.d.setTextColor(Color.parseColor("#E5FFFFFF"));
            this.d.setText("关闭广告");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            this.d.setVisibility(8);
            addView(this.d, layoutParams2);
            pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.z.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view3, int[] iArr) {
                    if (z.this.h != null) {
                        int i2 = z.this.g;
                        if (i2 == 1 || i2 == 2) {
                            z.this.h.a(9, (int[]) null);
                        } else {
                            z.this.h.e(view3, iArr);
                        }
                    }
                }
            };
            this.d.setOnTouchListener(pVar);
            view = this.d;
        } else {
            BaseImageView baseImageView = new BaseImageView(getContext());
            this.c = baseImageView;
            baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setImageResource(R.drawable.opos_mobad_drawable_block_close);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            this.c.setVisibility(8);
            addView(this.c, layoutParams3);
            pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.z.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view3, int[] iArr) {
                    if (z.this.h != null) {
                        int i2 = z.this.g;
                        if (i2 == 1 || i2 == 2) {
                            z.this.h.a(9, (int[]) null);
                        } else {
                            z.this.h.e(view3, iArr);
                        }
                    }
                }
            };
            this.c.setOnTouchListener(pVar);
            view = this.c;
        }
        view.setOnClickListener(pVar);
    }

    public static z a(Context context) {
        return a(context, 0);
    }

    public void b() {
        this.b.setVisibility(8);
        BaseImageView baseImageView = this.c;
        if (baseImageView != null) {
            baseImageView.setVisibility(8);
        }
        BaseTextView baseTextView = this.d;
        if (baseTextView != null) {
            baseTextView.setVisibility(8);
        }
    }

    public void c() {
        this.f10094a.setVisibility(8);
        this.b.setVisibility(8);
        BaseImageView baseImageView = this.c;
        if (baseImageView != null) {
            baseImageView.setVisibility(0);
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = 0;
        }
    }

    public static z a(Context context, int i) {
        return new z(context, i);
    }

    private void c(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f10094a;
        if (textView == null || this.e == i) {
            return;
        }
        this.e = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            this.b.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    public void b(int i) {
        this.g = i;
    }

    public void a() {
        this.b.setVisibility(0);
        BaseImageView baseImageView = this.c;
        if (baseImageView != null) {
            baseImageView.setVisibility(0);
        }
        BaseTextView baseTextView = this.d;
        if (baseTextView != null) {
            baseTextView.setVisibility(0);
        }
    }

    public void a(int i) {
        if (this.e == i) {
            return;
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(i);
        }
        c(i);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.h = interfaceC0778a;
    }

    public void a(a aVar) {
        this.i = aVar;
    }
}
