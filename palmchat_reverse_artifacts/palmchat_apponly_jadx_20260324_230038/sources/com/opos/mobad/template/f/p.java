package com.opos.mobad.template.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.f.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class p extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9575a;
    private com.opos.mobad.template.cmn.n b;
    private LinearLayout c;
    private TextView d;
    private com.opos.mobad.template.cmn.baseview.c e;
    private com.opos.mobad.template.f.a.a f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private TextView l;
    private TextView m;
    private TextView n;
    private int o;
    private boolean p;
    private RelativeLayout q;
    private RelativeLayout r;

    public p(Context context, int i) {
        super(context);
        this.o = i;
        c();
    }

    public static p a(Context context, Boolean bool) {
        f9575a = bool.booleanValue();
        return new p(context, 1);
    }

    public static p b(Context context, Boolean bool) {
        f9575a = bool.booleanValue();
        return new p(context, 0);
    }

    private void c() {
        this.p = (getResources().getConfiguration().uiMode & 48) == 32;
        f();
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        this.b = nVar;
        nVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f), com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        if (this.o == 1) {
            layoutParams.addRule(14);
        } else {
            if (f9575a) {
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            }
            layoutParams.addRule(15);
        }
        if (this.o == 1) {
            this.q = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(2, d().getId());
            layoutParams2.addRule(14);
            this.r = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(15);
            layoutParams3.addRule(14);
            this.r.addView(this.b, layoutParams);
            this.q.addView(this.r, layoutParams3);
            addView(this.q, layoutParams2);
        } else {
            addView(this.b, layoutParams);
        }
        i();
    }

    private com.opos.mobad.template.cmn.baseview.c d() {
        return (f9575a && this.o == 1) ? this.f.a() : this.e;
    }

    private void e() {
        com.opos.mobad.template.f.a.a aVar = new com.opos.mobad.template.f.a.a(getContext(), a.EnumC0783a.FINGER);
        this.f = aVar;
        aVar.a(16);
        this.f.b(8);
        addView(this.f.a(), h());
    }

    private void f() {
        TextView textView;
        int color;
        TextView textView2;
        float f;
        TextView textView3;
        int i;
        int iA;
        int iA2;
        float f2;
        if (f9575a && this.o == 1) {
            e();
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(getContext());
        this.e = cVar;
        cVar.setId(View.generateViewId());
        this.e.setBackground(g());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView4 = new TextView(getContext());
        this.d = textView4;
        textView4.setId(View.generateViewId());
        com.opos.mobad.template.h.a(this.d);
        if (f9575a && this.o == 0) {
            textView = this.d;
            color = getContext().getResources().getColor(R.color.opos_mobad_install_button_text_color);
        } else {
            textView = this.d;
            color = -1;
        }
        textView.setTextColor(color);
        if (this.o == 1) {
            if (f9575a) {
                this.d.setTextSize(1, 16.0f);
                textView3 = this.d;
                i = 8;
                textView3.setMaxEms(i);
            } else {
                textView2 = this.d;
                f = 14.0f;
                textView2.setTextSize(1, f);
            }
        } else if (f9575a) {
            this.d.setTextSize(1, 12.0f);
            textView3 = this.d;
            i = 4;
            textView3.setMaxEms(i);
        } else {
            textView2 = this.d;
            f = 10.0f;
            textView2.setTextSize(1, f);
        }
        this.d.setGravity(17);
        this.d.setSingleLine();
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        relativeLayout.addView(this.d, layoutParams);
        if (!f9575a) {
            TextView textView5 = new TextView(getContext());
            this.m = textView5;
            textView5.setId(View.generateViewId());
            TextView textView6 = this.m;
            int i2 = R.drawable.opos_mobad_bn_white_vector;
            textView6.setBackgroundResource(i2);
            if (this.o == 1) {
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 5.9f);
                iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 10.5f);
                f2 = 7.04f;
            } else {
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 3.56f);
                iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.36f);
                f2 = 1.62f;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams2.addRule(1, this.d.getId());
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), f2);
            layoutParams2.addRule(15);
            relativeLayout.addView(this.m, layoutParams2);
            TextView textView7 = new TextView(getContext());
            this.n = textView7;
            textView7.setId(View.generateViewId());
            this.n.setBackgroundResource(i2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.o == 1 ? 2.07f : 0.44f);
            layoutParams3.addRule(1, this.m.getId());
            layoutParams3.addRule(15);
            relativeLayout.addView(this.n, layoutParams3);
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.e.addView(relativeLayout, layoutParams4);
        addView(this.e, h());
    }

    private Drawable g() {
        int color;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (f9575a) {
            color = Color.parseColor(this.p ? this.o == 1 ? "#247CFF" : "#40247CFF" : this.o == 1 ? "#0066FF" : "#260066FF");
        } else {
            color = -16777216;
        }
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        return gradientDrawable;
    }

    private RelativeLayout.LayoutParams h() {
        if (this.o == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            return layoutParams;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 72.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        if (!f9575a) {
            return layoutParams2;
        }
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        return layoutParams2;
    }

    private void i() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.c = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.c.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.g = textView;
        com.opos.mobad.template.h.a(textView);
        this.g.setTextColor(-16777216);
        if (f9575a) {
            this.g.setTextColor(getContext().getResources().getColor(R.color.opos_mobad_black_color));
        }
        this.g.setTextSize(1, 14.0f);
        this.g.setGravity(17);
        this.g.setMaxEms(6);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.o == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.c.addView(this.g, layoutParams);
        j();
        TextView textView2 = new TextView(getContext());
        this.i = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        if (f9575a) {
            this.i.setTextColor(getContext().getResources().getColor(R.color.opos_mobad_title_or_desc_color));
        }
        this.i.setTextSize(1, 12.0f);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        if (this.o == 1) {
            this.i.setMaxEms(13);
            this.i.setGravity(17);
            layoutParams2.gravity = 1;
        } else {
            this.i.setMaxEms(7);
            layoutParams2.gravity = 3;
        }
        this.c.addView(this.i, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.o == 1) {
            layoutParams3.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(3, this.b.getId());
            this.r.addView(this.c, layoutParams3);
            return;
        }
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, this.b.getId());
        layoutParams3.addRule(0, d().getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.c, layoutParams3);
    }

    private void j() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.h = linearLayout;
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        textView.setBackgroundResource(f9575a ? this.p ? R.drawable.opos_mobad_download_vector_dark : R.drawable.opos_mobad_download_vector_light : R.drawable.opos_mobad_download_vector);
        layoutParams.gravity = 16;
        this.h.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.j = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        if (f9575a) {
            this.j.setTextColor(getContext().getResources().getColor(R.color.opos_mobad_title_or_desc_color));
        }
        this.j.setTextSize(1, 10.0f);
        this.j.setGravity(17);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.j.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 16;
        this.h.addView(this.j, layoutParams2);
        TextView textView3 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 0.66f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        textView3.setBackgroundColor(f9575a ? getContext().getResources().getColor(R.color.opos_mobad_title_or_desc_color) : -1946157056);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f));
        this.h.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.l = textView4;
        textView4.setTextColor(f9575a ? getContext().getResources().getColor(R.color.opos_mobad_title_or_desc_color) : Color.parseColor("#8C000000"));
        this.l.setTextSize(1, 10.0f);
        this.l.setGravity(17);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setSingleLine();
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.gravity = 16;
        this.h.addView(this.l, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        if (this.o == 1) {
            layoutParams5.gravity = 1;
        } else {
            layoutParams5.gravity = 3;
        }
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.c.addView(this.h, layoutParams5);
    }

    public void a() {
        TextView textView = this.m;
        if (textView == null || this.n == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.0f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        objectAnimatorOfFloat2.setStartDelay(170L);
        animatorSet.setDuration(1400L);
        animatorSet.start();
    }

    public void b() {
        this.b.setVisibility(8);
        if (this.o == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            layoutParams.removeRule(1);
            layoutParams.addRule(20);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }

    @Override // com.opos.mobad.template.cmn.baseview.c, com.opos.mobad.template.cmn.baseview.e
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        super.a(fVar);
        com.opos.mobad.template.cmn.baseview.c cVarD = d();
        if (cVarD != null) {
            cVarD.a(fVar);
        }
    }

    public void a(com.opos.mobad.template.cmn.p pVar) {
        com.opos.mobad.template.cmn.baseview.c cVarD = d();
        if (cVarD != null) {
            cVarD.setOnClickListener(pVar);
            cVarD.setOnTouchListener(pVar);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            this.c.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.i.setVisibility(8);
        } else {
            this.i.setText(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            this.h.setVisibility(8);
        } else {
            this.l.setText(str4);
            this.j.setText(str3);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str5);
        }
        com.opos.mobad.template.f.a.a aVar = this.f;
        if (aVar != null) {
            aVar.a(str5);
        }
    }
}
