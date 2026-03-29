package com.opos.mobad.template.h;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k extends d {
    private TextView A;
    private TextView B;
    private TextView C;
    private a.InterfaceC0778a D;
    protected Context f;
    protected LinearLayout g;
    protected TextView h;
    com.opos.mobad.template.cmn.p i;
    private com.opos.mobad.d.a j;
    private int l;
    private LinearLayout m;
    private com.opos.mobad.template.cmn.w n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private com.opos.mobad.template.cmn.w r;
    private TextView s;
    private ImageView t;
    private com.opos.mobad.template.cmn.w u;
    private com.opos.mobad.template.k.c v;
    private TextView w;
    private com.opos.mobad.template.a.c x;
    private com.opos.mobad.template.cmn.q y;
    private RelativeLayout z;

    public k(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.l = -16777216;
        this.i = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.k.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                k kVar = k.this;
                if (kVar.e || kVar.D == null) {
                    return;
                }
                k.this.D.a(6, iArr);
            }
        };
        this.f = context.getApplicationContext();
        this.j = aVar;
        this.d = Color.parseColor("#EB493D");
        f();
        g();
        d();
        b(context);
        d(context);
        c(context);
        e();
        a(context);
        i();
    }

    private void i() {
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext());
        this.x = cVar;
        cVar.setGravity(3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.g.addView(this.x, layoutParams);
    }

    private void j() {
        this.A.setTextSize(1, 18.0f);
        this.A.setLetterSpacing(0.1f);
        this.A.setText("**");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.removeRule(15);
        this.z.updateViewLayout(this.A, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 13.0f);
        this.z.updateViewLayout(this.B, layoutParams2);
    }

    public void d() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        this.g = linearLayout;
        linearLayout.setOrientation(1);
        this.n = new com.opos.mobad.template.cmn.w(this.f);
        this.n.a(com.opos.cmn.an.h.f.a.a(this.f, 12.0f));
        this.n.setBackgroundColor(Color.argb(138, 66, 70, 76));
        this.g.addView(this.n, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 258.0f), com.opos.cmn.an.h.f.a.a(this.f, 108.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        com.opos.mobad.template.cmn.e eVar = new com.opos.mobad.template.cmn.e(this.f, Color.argb(255, 235, 73, 61));
        float f = iA;
        eVar.a(f, 0.0f, 0.0f, f);
        eVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 59.0f), com.opos.cmn.an.h.f.a.a(this.f, 40.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 56.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.n.addView(eVar, layoutParams);
        Context context = this.f;
        com.opos.mobad.template.cmn.u uVar = new com.opos.mobad.template.cmn.u(context, com.opos.cmn.an.h.f.a.a(context, 7.0f));
        uVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 10.0f), com.opos.cmn.an.h.f.a.a(this.f, 54.0f));
        layoutParams2.addRule(1, eVar.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 49.0f);
        this.n.addView(uVar, layoutParams2);
        com.opos.mobad.template.cmn.e eVar2 = new com.opos.mobad.template.cmn.e(this.f, Color.argb(255, 235, 73, 61));
        eVar2.a(0.0f, f, f, 0.0f);
        eVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 165.0f), com.opos.cmn.an.h.f.a.a(this.f, 40.0f));
        layoutParams3.addRule(1, uVar.getId());
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 56.0f);
        this.n.addView(eVar2, layoutParams3);
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        relativeLayout.setPadding(iA2, iA2, iA2, iA2);
        this.n.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        com.opos.mobad.template.cmn.x xVar = new com.opos.mobad.template.cmn.x(this.f);
        xVar.setId(View.generateViewId());
        xVar.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 40.0f));
        layoutParams4.addRule(12);
        relativeLayout.addView(xVar, layoutParams4);
        com.opos.mobad.template.cmn.p.a(xVar, this.i);
        LinearLayout linearLayout2 = new LinearLayout(this.f);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 64.0f), -1);
        linearLayout2.setGravity(17);
        xVar.addView(linearLayout2, layoutParams5);
        this.z = new RelativeLayout(this.f);
        linearLayout2.addView(this.z, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(this.f);
        this.A = textView;
        textView.setId(View.generateViewId());
        this.A.setTextColor(-1);
        this.A.setTextSize(1, 18.0f);
        TextPaint paint = this.A.getPaint();
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        this.z.addView(this.A, layoutParams6);
        TextView textView2 = new TextView(this.f);
        this.B = textView2;
        textView2.setTextColor(-1);
        this.B.setTextSize(1, 12.0f);
        this.B.setText("元");
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 1.0f);
        layoutParams7.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 14.0f);
        layoutParams7.addRule(1, this.A.getId());
        this.z.addView(this.B, layoutParams7);
        View view = new View(this.f);
        view.setBackgroundResource(R.drawable.opos_mobad_coupons_v_line2);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 1.0f), com.opos.cmn.an.h.f.a.a(this.f, 24.0f));
        layoutParams8.gravity = 16;
        xVar.addView(view, layoutParams8);
        this.C = new TextView(this.f);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.C.setPadding(iA2, iA2, iA2, iA2);
        this.C.setTextSize(1, 12.0f);
        this.C.setLines(1);
        this.C.setSingleLine(true);
        this.C.setGravity(16);
        this.C.setEllipsize(TextUtils.TruncateAt.END);
        this.C.setTextColor(-1);
        xVar.addView(this.C, layoutParams9);
        LinearLayout linearLayout3 = new LinearLayout(this.f);
        this.m = linearLayout3;
        linearLayout3.setOrientation(0);
        relativeLayout.addView(this.m, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 36.0f)));
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(12);
        layoutParams10.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 42.0f);
        addView(this.g, layoutParams10);
        this.n.setVisibility(4);
    }

    public void e() {
        LinearLayout linearLayout = new LinearLayout(this.f);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = h();
        linearLayout.setGravity(16);
        TextView textView = new TextView(this.f);
        this.h = textView;
        textView.setTextColor(-1);
        this.h.setTextSize(1, 14.0f);
        this.h.setLines(1);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextPaint paint = this.h.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        linearLayout.addView(this.h);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.j);
        this.v = cVarA;
        linearLayout.addView(cVarA, layoutParams2);
        this.g.addView(linearLayout, layoutParams);
    }

    public void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f, 280.0f));
        int iA = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        setPadding(iA, 0, iA, 0);
        layoutParams.addRule(12);
        setLayoutParams(layoutParams);
    }

    public void g() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(this.l, 255), ColorUtils.setAlphaComponent(this.l, 255), ColorUtils.setAlphaComponent(this.l, 200), ColorUtils.setAlphaComponent(this.l, 160), ColorUtils.setAlphaComponent(this.l, 0)});
        gradientDrawable.setShape(0);
        setBackground(gradientDrawable);
    }

    public int h() {
        return com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
    }

    @Override // com.opos.mobad.template.h.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.u.clearAnimation();
        this.n.clearAnimation();
        super.onDetachedFromWindow();
    }

    private void d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.o = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.o.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f, 36.0f));
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 6.0f));
        layoutParams.weight = 1.0f;
        this.o.setGravity(16);
        this.m.addView(this.o, layoutParams);
        TextView textView = new TextView(context);
        this.p = textView;
        textView.setGravity(3);
        this.p.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.p.setTextColor(Color.argb(229, 255, 255, 255));
        com.opos.mobad.template.h.a(this.p);
        this.p.setLines(1);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextSize(1, 14.0f);
        this.o.addView(this.p);
        TextView textView2 = new TextView(context);
        this.q = textView2;
        textView2.setGravity(3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 1.0f);
        this.q.setLayoutParams(layoutParams2);
        this.q.setLines(1);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextColor(Color.argb(102, 255, 255, 255));
        this.q.setTextSize(1, 10.0f);
        this.o.addView(this.q);
    }

    @Override // com.opos.mobad.template.h.d
    public void a() {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.3f, 0.0f, 0.2f, 1.0f);
        this.n.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.play(ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(this.n, "translationX", -(this.n.getWidth() - com.opos.cmn.an.h.f.a.a(this.f, 200.0f)), 0.0f));
        animatorSet.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void b() {
        com.opos.mobad.template.cmn.q qVar = this.y;
        if (qVar != null) {
            qVar.a(this.d);
        }
        this.u.setBackgroundColor(this.d);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.u, "backgroundColor", this.c, this.d);
        objectAnimatorOfInt.setDuration(350L);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void c() {
        com.opos.mobad.template.cmn.q qVar = this.y;
        if (qVar != null) {
            qVar.a(this.d);
        }
        if (this.b) {
            b();
        }
    }

    private void a(Context context) {
        this.w = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.w.setTextSize(1, 14.0f);
        this.w.setMaxLines(2);
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setTextColor(ColorUtils.setAlphaComponent(-1, 229));
        this.g.addView(this.w, layoutParams);
    }

    private void b(Context context) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        this.r = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.r.setId(View.generateViewId());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, 6.0f);
        this.m.addView(this.r, layoutParams);
        ImageView imageView = new ImageView(context);
        this.t = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(context, 36.0f);
        this.r.addView(this.t, new RelativeLayout.LayoutParams(iA, iA));
    }

    private void c(final Context context) {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        this.u = wVar;
        wVar.setId(View.generateViewId());
        this.u.setBackgroundColor(this.c);
        TextView textView = new TextView(context);
        this.s = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.s.setLayoutParams(new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f)));
        this.s.setTextSize(1, 12.0f);
        this.s.setGravity(17);
        int iA = com.opos.cmn.an.h.f.a.a(context, 10.0f);
        this.s.setPadding(iA, 0, iA, 0);
        com.opos.mobad.template.h.a(this.s);
        this.s.setTextColor(-1);
        this.u.addView(this.s);
        this.s.post(new Runnable() { // from class: com.opos.mobad.template.h.k.1
            @Override // java.lang.Runnable
            public void run() {
                k kVar = k.this;
                if (kVar.e) {
                    return;
                }
                k.this.u.a(kVar.s.getHeight() > 0 ? k.this.s.getHeight() / 2 : com.opos.cmn.an.h.f.a.a(context, 16.0f));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.m.addView(this.u, layoutParams);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
            this.t.setImageBitmap(bitmap);
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.v.a(interfaceC0778a);
        this.x.a(interfaceC0778a);
        this.D = interfaceC0778a;
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.cmn.q qVar) {
        if (qVar != null) {
            this.y = qVar;
            com.opos.mobad.template.cmn.p.a(this.u, qVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006d  */
    @Override // com.opos.mobad.template.h.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        String str;
        this.p.setText(bVar.b);
        this.h.setText(bVar.b);
        this.q.setText(bVar.f9413a);
        this.s.setText(bVar.j);
        this.w.setText(bVar.f9413a);
        this.v.a(bVar.p, bVar.e, bVar.g, bVar.i);
        if (bVar.u != null) {
            this.x.setVisibility(0);
            com.opos.mobad.template.a.c cVar = this.x;
            com.opos.mobad.template.d.a aVar = bVar.u;
            cVar.a(aVar.f9412a, aVar.b);
        } else {
            this.x.setVisibility(8);
        }
        if (bVar.J.containsKey("EXT_PARAM_KEY_QPON_VALUE")) {
            String str2 = bVar.J.get("EXT_PARAM_KEY_QPON_VALUE");
            if (TextUtils.isEmpty(str2)) {
                j();
            } else {
                a(com.opos.mobad.template.h.a(str2));
            }
        }
        if (bVar.J.containsKey("EXT_PARAM_KEY_TYPE_DOWNLOAD")) {
            if ("1".equals(bVar.J.get("EXT_PARAM_KEY_TYPE_DOWNLOAD"))) {
                textView = this.C;
                str = "下载领专属优惠券";
            } else {
                textView = this.C;
                str = "打开领专属优惠券";
            }
            textView.setText(str);
        }
    }

    private void a(String str) {
        float f;
        Context context;
        int iA;
        boolean zContains = str.contains(".");
        this.A.setText(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        if (str.length() < (zContains ? 1 : 0) + 4) {
            this.A.setTextSize(1, 18.0f);
            iA = com.opos.cmn.an.h.f.a.a(this.f, 14.0f);
        } else {
            if (str.length() < (zContains ? 1 : 0) + 5) {
                this.A.setTextSize(1, 14.0f);
                context = this.f;
                f = 13.0f;
            } else if (str.length() >= (zContains ? 1 : 0) + 6) {
                j();
                return;
            } else {
                f = 12.0f;
                this.A.setTextSize(1, 12.0f);
                context = this.f;
            }
            iA = com.opos.cmn.an.h.f.a.a(context, f);
        }
        layoutParams.topMargin = iA;
        this.z.updateViewLayout(this.B, layoutParams);
    }
}
