package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseTextView f9862a;
    private com.opos.mobad.template.cmn.n b;
    private RelativeLayout c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private com.opos.mobad.d.a g;
    private com.opos.mobad.template.a.c h;
    private com.opos.mobad.template.k.c i;
    private Animator j;
    private com.opos.mobad.template.cmn.w k;
    private int l;
    private int m;
    private LinearLayout n;
    private ViewTreeObserver.OnPreDrawListener o;
    private a.InterfaceC0778a p;

    public t(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.l = 0;
        this.m = 0;
        this.g = aVar;
        a(context);
    }

    public static t a(Context context, com.opos.mobad.d.a aVar) {
        return new t(context, aVar);
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.n = linearLayout2;
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_native_template_title_color));
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        com.opos.mobad.template.h.a(this.e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 16;
        this.n.addView(this.e, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.m = iA;
        layoutParams2.leftMargin = iA;
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 1, 0, this.g);
        this.i = cVarA;
        this.n.addView(cVarA, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext(), getContext().getResources().getColor(R.color.opos_mobad_version_company_color));
        this.h = cVar;
        cVar.setVisibility(8);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.d.addView(this.n, new LinearLayout.LayoutParams(-2, -2));
        this.d.addView(this.h, layoutParams3);
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.f.setTextSize(1, 10.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.d.addView(this.f, layoutParams4);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            this.f.setVisibility(0);
            return;
        }
        com.opos.mobad.template.a.c cVar = this.h;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.h.a(aVar.f9412a, aVar.b);
        }
    }

    public void a() {
        Animator animator = this.j;
        if (animator != null) {
            animator.end();
        }
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        addView(relativeLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        this.c = relativeLayout2;
        relativeLayout2.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.c.setPadding(iA, iA, iA, iA);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(getContext(), 0.33f), Color.parseColor("#1FFFFFFF"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        gradientDrawable.setColor(context.getResources().getColor(R.color.opos_mobad_native_template_icon_bg_color));
        this.c.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams2.addRule(15);
        this.c.setVisibility(8);
        relativeLayout.addView(this.c, layoutParams2);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.c.addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
        b();
        this.l = com.opos.cmn.an.h.f.a.a(getContext(), 246.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 246.0f), -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, this.c.getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        relativeLayout.addView(this.d, layoutParams3);
        BaseTextView baseTextView = new BaseTextView(context);
        this.f9862a = baseTextView;
        baseTextView.setId(View.generateViewId());
        this.f9862a.setTextSize(1, 16.0f);
        this.f9862a.setTextColor(-1);
        this.f9862a.setGravity(17);
        this.f9862a.setSingleLine();
        this.f9862a.setEllipsize(TextUtils.TruncateAt.END);
        com.opos.mobad.template.h.a(this.f9862a);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#0066FF"));
        gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        this.f9862a.setBackground(gradientDrawable2);
        int iA2 = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        this.f9862a.setPadding(iA2, 0, iA2, 0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 296.0f), com.opos.cmn.an.h.f.a.a(context, 44.0f));
        layoutParams4.addRule(3, relativeLayout.getId());
        layoutParams4.topMargin = iA2;
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        addView(this.f9862a, layoutParams4);
        com.opos.mobad.template.cmn.p.a(this.f9862a, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.t.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockBottomAreaView2", "onBtnClick");
                if (t.this.p != null) {
                    t.this.p.g(view, iArr);
                }
            }
        });
        this.f9862a.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.t.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBottomAreaView2", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (t.this.p != null) {
                    t.this.p.a(view, i, z);
                }
            }
        });
        this.k = new com.opos.mobad.template.cmn.w(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 44.0f));
        layoutParams5.addRule(5, this.f9862a.getId());
        layoutParams5.addRule(7, this.f9862a.getId());
        layoutParams5.addRule(6, this.f9862a.getId());
        layoutParams5.addRule(8, this.f9862a.getId());
        layoutParams5.addRule(13);
        this.k.setId(View.generateViewId());
        this.k.a(com.opos.cmn.an.h.f.a.a(context, 36.0f));
        Animator animatorD = com.opos.mobad.template.cmn.ae.d((RelativeLayout) this.k);
        this.j = animatorD;
        animatorD.start();
        this.k.setVisibility(4);
        addView(this.k, layoutParams5);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockBottomAreaView2", "setListener " + interfaceC0778a);
        this.p = interfaceC0778a;
        com.opos.mobad.template.k.c cVar = this.i;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.a.c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.k.c cVar = this.i;
        if (cVar != null) {
            cVar.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
        }
    }

    public void a(com.opos.mobad.template.d.b bVar, com.opos.mobad.d.a aVar, final boolean z) {
        TextView textView;
        if (!TextUtils.isEmpty(bVar.j)) {
            this.f9862a.setText(bVar.j);
            if (this.j != null) {
                this.k.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            this.e.setText(bVar.b);
        }
        if (!TextUtils.isEmpty(bVar.f9413a) && (textView = this.f) != null) {
            textView.setText(bVar.f9413a);
        }
        a(bVar);
        b(bVar);
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.c.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.removeRule(1);
            layoutParams.leftMargin = 0;
            layoutParams.width = com.opos.cmn.an.h.f.a.a(getContext(), 296.0f);
            this.l = com.opos.cmn.an.h.f.a.a(getContext(), 296.0f);
            this.d.setLayoutParams(layoutParams);
        } else {
            this.c.setVisibility(0);
            a(bVar.k, aVar, z);
        }
        if (this.o == null) {
            this.o = new ViewTreeObserver.OnPreDrawListener() { // from class: com.opos.mobad.template.g.t.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (!z && t.this.n != null && t.this.d != null && t.this.e != null && t.this.i != null && t.this.l != 0) {
                        try {
                            if (t.this.n.getWidth() <= t.this.e.getWidth() + t.this.i.getWidth() + ((int) ((t.this.d.getWidth() / t.this.l) * t.this.m))) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) t.this.e.getLayoutParams();
                                layoutParams2.weight = 1.0f;
                                if (t.this.e.getParent() != null && t.this.e.getParent() == t.this.n) {
                                    t.this.n.updateViewLayout(t.this.e, layoutParams2);
                                    if (t.this.d != null && t.this.o != null && t.this.d.getViewTreeObserver().isAlive()) {
                                        t.this.d.getViewTreeObserver().removeOnPreDrawListener(t.this.o);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("BlockBottomAreaView2", "preDrawListener->Exception:" + e);
                        }
                    }
                    return true;
                }
            };
            LinearLayout linearLayout = this.d;
            if (linearLayout == null || !linearLayout.getViewTreeObserver().isAlive()) {
                return;
            }
            this.d.getViewTreeObserver().addOnPreDrawListener(this.o);
        }
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, final boolean z) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("BlockBottomAreaView2", "iconUrl is null");
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.t.4
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (z) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (t.this.p != null) {
                            t.this.p.c(i);
                        }
                    } else {
                        if (i == 1 && t.this.p != null) {
                            t.this.p.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.t.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                t.this.b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }
}
