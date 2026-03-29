package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10014a;
    com.opos.mobad.template.cmn.p b;
    com.opos.mobad.template.cmn.p c;
    private boolean d;
    private com.opos.mobad.d.a e;
    private RelativeLayout f;
    private RelativeLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private com.opos.mobad.template.cmn.y l;
    private LinearLayout m;
    private TextView n;
    private com.opos.mobad.template.k.c o;
    private TextView p;
    private com.opos.mobad.template.cmn.w q;
    private TextView r;
    private boolean s;
    private a.InterfaceC0778a t;

    public g(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.d = false;
        this.f10014a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.g.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (g.this.d || g.this.t == null) {
                    return;
                }
                g.this.t.h(view, iArr);
            }
        };
        this.b = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.g.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (g.this.d || g.this.t == null) {
                    return;
                }
                g.this.t.g(view, iArr);
            }
        };
        this.c = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.g.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (g.this.d || g.this.t == null) {
                    return;
                }
                g.this.t.a(6, iArr);
            }
        };
        this.s = false;
        this.e = aVar;
        a(context);
    }

    public static g a(Context context, com.opos.mobad.d.a aVar) {
        return new g(context, aVar);
    }

    private void b() {
        this.h.setTextSize(1, 20.0f);
        this.h.setLetterSpacing(0.1f);
        this.h.setText("***");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        this.g.updateViewLayout(this.h, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 15.0f);
        this.g.updateViewLayout(this.i, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 15.0f);
        this.f.updateViewLayout(this.j, layoutParams3);
    }

    public void a() {
        this.d = true;
    }

    private void a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(context, 16.0f));
        gradientDrawable.setColor(-1);
        setBackground(gradientDrawable);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        setPadding(iA, iA, iA, iA);
        com.opos.mobad.template.cmn.x xVar = new com.opos.mobad.template.cmn.x(context);
        xVar.setId(View.generateViewId());
        xVar.setOrientation(0);
        xVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        xVar.setBackgroundColor(Color.argb(38, 235, 59, 47));
        addView(xVar, new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 58.0f)));
        this.f = new RelativeLayout(context);
        xVar.addView(this.f, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 76.0f), -1));
        this.g = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.g.setGravity(1);
        this.f.addView(this.g, layoutParams);
        TextView textView = new TextView(context);
        this.h = textView;
        textView.setId(View.generateViewId());
        this.h.setTextColor(Color.parseColor("#DB382C"));
        this.h.setTextSize(1, 20.0f);
        TextPaint paint = this.h.getPaint();
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 8.0f);
        this.g.addView(this.h, layoutParams2);
        TextView textView2 = new TextView(context);
        this.i = textView2;
        textView2.setTextColor(Color.parseColor("#DB382C"));
        this.i.setTextSize(1, 10.0f);
        this.i.setText("元");
        com.opos.mobad.template.h.a(this.i);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(context, 17.0f);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(context, 1.0f);
        layoutParams3.addRule(1, this.h.getId());
        this.g.addView(this.i, layoutParams3);
        TextView textView3 = new TextView(context);
        this.j = textView3;
        textView3.setTextColor(Color.parseColor("#DB382C"));
        this.j.setTextSize(1, 10.0f);
        this.j.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 72.0f));
        this.j.setLines(1);
        this.j.setSingleLine(true);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 2.0f);
        layoutParams4.leftMargin = iA2;
        layoutParams4.rightMargin = iA2;
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        layoutParams4.addRule(12);
        layoutParams4.addRule(14);
        this.f.addView(this.j, layoutParams4);
        View view = new View(context);
        view.setBackgroundResource(R.drawable.opos_mobad_coupons_v_line);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 40.0f));
        layoutParams5.gravity = 16;
        xVar.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        layoutParams6.rightMargin = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        layoutParams6.gravity = 16;
        xVar.addView(linearLayout, layoutParams6);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.l = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA3 = com.opos.cmn.an.h.f.a.a(context, 36.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iA3, iA3);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = com.opos.cmn.an.h.f.a.a(context, 6.0f);
        linearLayout.addView(this.l, layoutParams7);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.m = linearLayout3;
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 16;
        this.m.setLayoutParams(layoutParams8);
        this.m.setOrientation(0);
        linearLayout2.addView(this.m);
        TextView textView4 = new TextView(context);
        this.n = textView4;
        textView4.setTextSize(1, 14.0f);
        this.n.setTextColor(Color.argb(229, 0, 0, 0));
        this.n.setLines(1);
        this.n.setSingleLine(true);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.n);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams9.gravity = 16;
        this.m.addView(this.n, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 2, 0, this.e);
        this.o = cVarA;
        this.m.addView(cVarA, layoutParams10);
        this.p = new TextView(context);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.topMargin = com.opos.cmn.an.h.f.a.a(context, 1.0f);
        this.p.setTextSize(1, 10.0f);
        this.p.setLines(1);
        this.p.setSingleLine(true);
        this.p.setGravity(16);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextColor(Color.argb(102, 0, 0, 0));
        linearLayout2.addView(this.p, layoutParams11);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(context);
        wVar.setBackgroundColor(-1);
        wVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 16.0f), com.opos.cmn.an.h.f.a.a(context, 16.0f));
        layoutParams12.topMargin = -com.opos.cmn.an.h.f.a.a(context, 12.0f);
        layoutParams12.leftMargin = com.opos.cmn.an.h.f.a.a(context, 68.0f);
        addView(wVar, layoutParams12);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(context);
        wVar2.setBackgroundColor(-1);
        wVar2.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 16.0f), com.opos.cmn.an.h.f.a.a(context, 16.0f));
        layoutParams13.topMargin = com.opos.cmn.an.h.f.a.a(context, 54.0f);
        layoutParams13.leftMargin = com.opos.cmn.an.h.f.a.a(context, 68.0f);
        addView(wVar2, layoutParams13);
        com.opos.mobad.template.cmn.w wVar3 = new com.opos.mobad.template.cmn.w(context);
        this.q = wVar3;
        wVar3.setBackgroundColor(Color.parseColor("#EB3B2F"));
        this.q.a(90.0f);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 44.0f));
        layoutParams14.addRule(3, xVar.getId());
        layoutParams14.topMargin = com.opos.cmn.an.h.f.a.a(context, 10.0f);
        addView(this.q, layoutParams14);
        TextView textView5 = new TextView(context);
        this.r = textView5;
        textView5.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.r.setTextColor(-1);
        this.r.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.r);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.addRule(13);
        this.q.addView(this.r, layoutParams15);
        com.opos.mobad.template.cmn.p.a(this, this.f10014a);
        com.opos.mobad.template.cmn.p.a(this.q, this.b);
        com.opos.mobad.template.cmn.p.a(xVar, this.c);
        a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.g.1
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view2, int i, boolean z) {
                if (g.this.d || g.this.t == null) {
                    return;
                }
                g.this.t.a(view2, i, z);
            }
        });
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("RewardBottomCouponsView", "setListener " + interfaceC0778a);
        this.t = interfaceC0778a;
        this.o.a(interfaceC0778a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        String str;
        if (bVar != null) {
            if (bVar.J.containsKey("EXT_PARAM_KEY_QPON_VALUE")) {
                String str2 = bVar.J.get("EXT_PARAM_KEY_QPON_VALUE");
                if (TextUtils.isEmpty(str2)) {
                    b();
                } else {
                    a(com.opos.mobad.template.h.a(str2));
                }
            }
            if (bVar.J.containsKey("EXT_PARAM_KEY_QPON_THRESHOLD")) {
                String str3 = bVar.J.get("EXT_PARAM_KEY_QPON_THRESHOLD");
                if (TextUtils.isEmpty(str3)) {
                    this.j.setText("满减优惠");
                } else {
                    String strA = com.opos.mobad.template.h.a(str3);
                    this.j.setText("满" + strA + "元可用");
                }
            }
            if (!TextUtils.isEmpty(bVar.b)) {
                this.n.setText(bVar.b);
            }
            this.o.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
            if (bVar.J.containsKey("EXT_PARAM_KEY_TYPE_DOWNLOAD")) {
                if ("1".equals(bVar.J.get("EXT_PARAM_KEY_TYPE_DOWNLOAD"))) {
                    textView = this.p;
                    str = "下载领专属优惠券";
                } else {
                    textView = this.p;
                    str = "打开领专属优惠券";
                }
                textView.setText(str);
            }
            if (!TextUtils.isEmpty(bVar.j)) {
                this.r.setText(bVar.j);
            }
            com.opos.mobad.template.d.e eVar = bVar.k;
            if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                a(bVar.k, this.e);
            }
        }
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomCouponsView", "iconUrl is null");
        } else {
            if (this.s) {
                return;
            }
            this.s = true;
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 36.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.g.5
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (g.this.d) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (g.this.t != null) {
                            g.this.t.c(i);
                        }
                    } else {
                        if (i == 1 && g.this.t != null) {
                            g.this.t.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.g.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (g.this.d || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                g.this.l.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(String str) {
        int iA;
        boolean zContains = str.contains(".");
        this.h.setText(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        if (str.length() < (zContains ? 1 : 0) + 4) {
            this.h.setTextSize(1, 20.0f);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            this.g.updateViewLayout(this.h, layoutParams);
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 18.0f);
        } else {
            if (str.length() < (zContains ? 1 : 0) + 5) {
                this.h.setTextSize(1, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                this.g.updateViewLayout(this.h, layoutParams);
            } else if (str.length() >= (zContains ? 1 : 0) + 7) {
                b();
                return;
            } else {
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
                this.g.updateViewLayout(this.h, layoutParams);
                this.h.setTextSize(1, 14.0f);
            }
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 17.0f);
        }
        layoutParams2.topMargin = iA;
        this.g.updateViewLayout(this.i, layoutParams2);
    }
}
