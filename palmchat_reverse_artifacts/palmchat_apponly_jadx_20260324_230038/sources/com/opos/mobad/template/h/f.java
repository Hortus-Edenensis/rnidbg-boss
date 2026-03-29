package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10008a;
    com.opos.mobad.template.cmn.q b;
    com.opos.mobad.template.cmn.baseview.f c;
    private com.opos.mobad.template.cmn.w d;
    private TextView e;
    private com.opos.mobad.template.cmn.n f;
    private RelativeLayout g;
    private LinearLayout h;
    private TextView i;
    private com.opos.mobad.template.k.c j;
    private com.opos.mobad.template.a.c l;
    private boolean m;
    private boolean n;
    private a.InterfaceC0778a o;

    public f(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.m = false;
        this.n = false;
        this.f10008a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.f.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.m || f.this.o == null) {
                    return;
                }
                f.this.o.h(view, iArr);
            }
        };
        this.b = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.f.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (f.this.m || f.this.o == null) {
                    return;
                }
                f.this.o.g(view, iArr);
            }
        };
        this.c = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.f.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                if (f.this.m || f.this.o == null) {
                    return;
                }
                f.this.o.a(view, i, z);
            }
        };
        b(context, aVar);
    }

    public static f a(Context context, com.opos.mobad.d.a aVar) {
        return new f(context, aVar);
    }

    private void b() {
        com.opos.mobad.template.cmn.p.a(this, this.f10008a);
        a(this.k);
        com.opos.mobad.template.cmn.p.a(this.d, this.b);
        this.d.a(this.c);
    }

    private void c() {
        this.d = new com.opos.mobad.template.cmn.w(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.d.setLayoutParams(layoutParams);
        this.d.setId(View.generateViewId());
        this.d.setBackgroundColor(Color.argb(255, 0, 102, 255));
        this.d.a(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f)));
        this.e.setTextSize(1, 14.0f);
        this.e.setGravity(17);
        this.e.setLines(1);
        this.e.setMaxWidth(com.opos.cmn.an.h.f.a.a(getContext(), 80.0f));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        this.e.setPadding(iA, 0, iA, 0);
        com.opos.mobad.template.h.a(this.e);
        this.e.setTextColor(-1);
        this.d.addView(this.e);
    }

    public void a() {
        this.m = true;
    }

    private void a(com.opos.mobad.d.a aVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.h = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        TextView textView = new TextView(getContext());
        this.i = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.i.setTextSize(1, 14.0f);
        this.i.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.i.setSingleLine(true);
        com.opos.mobad.template.h.a(this.i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.gravity = 16;
        linearLayout2.addView(this.i, layoutParams2);
        this.j = com.opos.mobad.template.k.c.a(getContext(), 0, 0, aVar);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        linearLayout2.addView(this.j, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext());
        this.l = cVar;
        cVar.setGravity(3);
        this.l.setVisibility(8);
        this.h.addView(linearLayout2, layoutParams);
        this.h.addView(this.l, layoutParams4);
    }

    private void b(Context context, com.opos.mobad.d.a aVar) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.argb(153, 0, 0, 0));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        setBackground(gradientDrawable);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(iA, iA, iA, iA);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.g = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.g.setPadding(iA2, iA2, iA2, iA2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.argb(20, 255, 255, 255));
        gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 10.0f));
        gradientDrawable2.setStroke(com.opos.cmn.an.h.f.a.a(context, 0.33f), Color.argb(31, 255, 255, 255));
        this.g.setBackground(gradientDrawable2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 40.0f), com.opos.cmn.an.h.f.a.a(getContext(), 40.0f));
        layoutParams.addRule(15);
        this.g.setVisibility(0);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 10.0f));
        this.f = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        c();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        a(aVar);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.g.getId());
        layoutParams4.addRule(0, this.d.getId());
        this.g.addView(this.f, layoutParams2);
        addView(this.g, layoutParams);
        addView(this.d, layoutParams3);
        addView(this.h, layoutParams4);
        b();
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("RewardBottomAreaView2", "setListener " + interfaceC0778a);
        this.o = interfaceC0778a;
        this.j.a(interfaceC0778a);
        this.l.a(interfaceC0778a);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.l) == null) {
            return;
        }
        cVar.a(aVar.f9412a, aVar.b);
        this.l.setVisibility(0);
    }

    public void a(com.opos.mobad.template.d.b bVar, com.opos.mobad.d.a aVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(bVar.j)) {
            this.e.setText(bVar.j);
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            this.i.setText(bVar.b);
        }
        this.j.a(bVar.p, bVar.e, bVar.g, bVar.i);
        a(bVar);
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            this.g.setVisibility(0);
            a(bVar.k, aVar);
            return;
        }
        this.g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = -1;
        this.h.setLayoutParams(layoutParams);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomAreaView2", "iconUrl is null");
        } else {
            if (this.n) {
                return;
            }
            this.n = true;
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.f.1
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (f.this.m) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (f.this.o != null) {
                            f.this.o.c(i);
                        }
                    } else {
                        if (i == 1 && f.this.o != null) {
                            f.this.o.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (f.this.m || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                f.this.f.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }
}
