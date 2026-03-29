package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v f9868a;
    private LinearLayout b;
    private TextView c;
    private int d;
    private com.opos.mobad.template.a.g e;
    private com.opos.mobad.template.k.c f;
    private com.opos.mobad.d.a g;
    private com.opos.mobad.template.a.c h;
    private boolean i;
    private boolean j;
    private com.opos.mobad.template.cmn.w k;
    private Animator l;

    public u(Context context, int i, com.opos.mobad.d.a aVar, boolean z, boolean z2) {
        super(context);
        this.d = i;
        this.g = aVar;
        this.i = z;
        this.j = z2;
        b(context);
    }

    public static u a(Context context) {
        return new u(context, null);
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(Color.parseColor(this.d == 1 ? "#FFFFFF" : "#D9FFFFFF"));
        this.c.setTextSize(1, 12.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        TextPaint paint = this.c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.addView(this.c, new LinearLayout.LayoutParams(-1, -2));
    }

    private void c() {
        View view;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(Color.parseColor(this.d == 2 ? "#FFFFFF" : "#D9FFFFFF"));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        this.c.setMaxEms(7);
        TextPaint paint = this.c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 16;
        linearLayout2.addView(this.c, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        if (this.j) {
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.g);
            this.f = cVarA;
            view = cVarA;
        } else {
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
            com.opos.mobad.template.a.g gVarB = com.opos.mobad.template.a.g.b(getContext(), this.g);
            this.e = gVarB;
            view = gVarB;
        }
        linearLayout2.addView(view, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext(), Color.parseColor("#66FFFFFF"));
        this.h = cVar;
        cVar.setVisibility(4);
        layoutParams3.addRule(3, this.c.getId());
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        this.b.addView(linearLayout2, layoutParams4);
        this.b.addView(this.h, layoutParams3);
    }

    private void d() {
        View view;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(Color.parseColor(this.d == 3 ? "#FFFFFF" : "#D9FFFFFF"));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        this.c.setMaxEms(7);
        TextPaint paint = this.c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        linearLayout2.addView(this.c, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (this.j) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.g);
            this.f = cVarA;
            view = cVarA;
        } else {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
            com.opos.mobad.template.a.g gVarB = com.opos.mobad.template.a.g.b(getContext(), this.g);
            this.e = gVarB;
            view = gVarB;
        }
        linearLayout2.addView(view, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        this.b.addView(linearLayout2, layoutParams2);
    }

    public u(Context context, com.opos.mobad.d.a aVar) {
        this(context, 0, aVar, false, false);
    }

    public static u a(Context context, int i) {
        return new u(context, i, null, false, false);
    }

    private void b(Context context) {
        ViewGroup.LayoutParams layoutParams;
        v vVarF;
        RelativeLayout.LayoutParams layoutParams2;
        int iA;
        int i = this.d;
        if (i == 2 || i == 3) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
            vVarF = v.f(context, "");
        } else {
            layoutParams = new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f));
            vVarF = v.e(context, "");
        }
        this.f9868a = vVarF;
        setLayoutParams(layoutParams);
        this.f9868a.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        int i2 = this.d;
        if (i2 == 2) {
            c();
            layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 224.0f), com.opos.cmn.an.h.f.a.a(getContext(), 38.0f));
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        } else {
            if (i2 == 3) {
                d();
                layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 224.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            } else {
                b();
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            }
            layoutParams2.leftMargin = iA;
            layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        }
        layoutParams2.addRule(15);
        if (this.i) {
            this.k = new com.opos.mobad.template.cmn.w(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f));
            layoutParams4.addRule(5, this.f9868a.getId());
            layoutParams4.addRule(7, this.f9868a.getId());
            layoutParams4.addRule(6, this.f9868a.getId());
            layoutParams4.addRule(8, this.f9868a.getId());
            layoutParams4.addRule(13);
            this.k.setId(View.generateViewId());
            this.k.a(com.opos.cmn.an.h.f.a.a(context, 36.0f));
            Animator animatorB = com.opos.mobad.template.cmn.ae.b((RelativeLayout) this.k);
            this.l = animatorB;
            animatorB.start();
            this.k.setVisibility(4);
            layoutParams2.addRule(0, this.k.getId());
            addView(this.f9868a, layoutParams3);
            addView(this.k, layoutParams4);
        } else {
            layoutParams2.addRule(0, this.f9868a.getId());
            addView(this.f9868a, layoutParams3);
        }
        addView(this.b, layoutParams2);
    }

    public static u a(Context context, int i, com.opos.mobad.d.a aVar, boolean z, boolean z2) {
        return new u(context, i, aVar, z, z2);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.h) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.h.a(aVar.f9412a, aVar.b);
    }

    public void a() {
        Animator animator = this.l;
        if (animator != null) {
            animator.end();
        }
    }

    public void a(final a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockButtonInsideTheCardView", "setListener " + interfaceC0778a);
        com.opos.mobad.template.a.c cVar = this.h;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
        if (this.j) {
            com.opos.mobad.template.k.c cVar2 = this.f;
            if (cVar2 != null) {
                cVar2.a(interfaceC0778a);
            }
        } else {
            com.opos.mobad.template.a.g gVar = this.e;
            if (gVar != null) {
                gVar.a(interfaceC0778a);
            }
        }
        v vVar = this.f9868a;
        if (vVar != null) {
            vVar.a(interfaceC0778a);
            this.f9868a.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.u.1
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view, int i, boolean z) {
                    com.opos.cmn.an.f.a.a("BlockButtonInsideTheCardView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                    a.InterfaceC0778a interfaceC0778a2 = interfaceC0778a;
                    if (interfaceC0778a2 != null) {
                        interfaceC0778a2.a(view, i, z);
                    }
                }
            });
        }
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        TextView textView;
        v vVar;
        if (!TextUtils.isEmpty(bVar.j) && (vVar = this.f9868a) != null) {
            vVar.setText(bVar.j);
            if (this.l != null) {
                this.k.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(bVar.b) && (textView = this.c) != null) {
            textView.setText(bVar.b);
        }
        if (this.j) {
            this.f.a(bVar.p, bVar.e, bVar.g, bVar.i);
        } else {
            com.opos.mobad.template.a.g gVar = this.e;
            if (gVar != null) {
                gVar.a(bVar.p, bVar.e, bVar.f, bVar.i);
            }
        }
        b(bVar);
    }
}
