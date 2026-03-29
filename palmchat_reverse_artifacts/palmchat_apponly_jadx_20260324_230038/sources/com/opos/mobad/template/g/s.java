package com.opos.mobad.template.g;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v f9858a;
    private com.opos.mobad.template.cmn.n b;
    private RelativeLayout c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private int g;
    private boolean h;
    private boolean i;
    private com.opos.mobad.d.a j;
    private com.opos.mobad.template.a.c k;
    private com.opos.mobad.template.a.g l;
    private com.opos.mobad.template.k.c m;
    private Animator n;
    private com.opos.mobad.template.cmn.w o;
    private a.InterfaceC0778a p;

    public s(Context context, int i, com.opos.mobad.d.a aVar) {
        this(context, 0, false, aVar, false);
    }

    private void c() {
        View view;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        this.e.setMaxEms(7);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 16;
        linearLayout2.addView(this.e, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        if (this.i) {
            com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 1, 0, this.j);
            this.m = cVarA;
            view = cVarA;
        } else {
            com.opos.mobad.template.a.g gVarB = com.opos.mobad.template.a.g.b(getContext(), this.j);
            this.l = gVarB;
            view = gVarB;
        }
        linearLayout2.addView(view, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(getContext(), getContext().getResources().getColor(R.color.opos_mobad_version_company_color));
        this.k = cVar;
        cVar.setVisibility(4);
        layoutParams3.addRule(3, this.e.getId());
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        this.d.addView(linearLayout2, layoutParams4);
        this.d.addView(this.k, layoutParams3);
    }

    public s(Context context, int i, boolean z, com.opos.mobad.d.a aVar, boolean z2) {
        super(context);
        this.g = i;
        this.h = z;
        this.j = aVar;
        this.i = z2;
        a(context);
    }

    public static s a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new s(context, i, aVar);
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.f.setTextSize(1, 12.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.d.addView(this.e, layoutParams);
        this.d.addView(this.f, layoutParams2);
    }

    public static s a(Context context, int i, boolean z, com.opos.mobad.d.a aVar, boolean z2) {
        return new s(context, i, z, aVar, z2);
    }

    private void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.k) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.k.a(aVar.f9412a, aVar.b);
    }

    public void a() {
        Animator animator = this.n;
        if (animator != null) {
            animator.end();
        }
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.c.setPadding(iA, iA, iA, iA);
        this.c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.addRule(15);
        this.c.setVisibility(8);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.f9858a = this.g == 2 ? v.b(context, "") : v.a(context, "");
        this.f9858a.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        if (this.g == 2) {
            c();
        } else {
            b();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.c.getId());
        this.c.addView(this.b, layoutParams2);
        addView(this.c, layoutParams);
        if (this.h) {
            this.o = new com.opos.mobad.template.cmn.w(getContext());
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f));
            layoutParams5.addRule(5, this.f9858a.getId());
            layoutParams5.addRule(7, this.f9858a.getId());
            layoutParams5.addRule(6, this.f9858a.getId());
            layoutParams5.addRule(8, this.f9858a.getId());
            layoutParams5.addRule(13);
            this.o.setId(View.generateViewId());
            this.o.a(com.opos.cmn.an.h.f.a.a(context, 36.0f));
            Animator animatorB = com.opos.mobad.template.cmn.ae.b((RelativeLayout) this.o);
            this.n = animatorB;
            animatorB.start();
            this.o.setVisibility(4);
            layoutParams4.addRule(0, this.o.getId());
            addView(this.f9858a, layoutParams3);
            addView(this.o, layoutParams5);
        } else {
            layoutParams4.addRule(0, this.f9858a.getId());
            addView(this.f9858a, layoutParams3);
        }
        addView(this.d, layoutParams4);
    }

    public void a(final a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockBottomAreaView", "setListener " + interfaceC0778a);
        this.p = interfaceC0778a;
        v vVar = this.f9858a;
        if (vVar != null) {
            vVar.a(interfaceC0778a);
        }
        com.opos.mobad.template.cmn.baseview.f fVar = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.s.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockBottomAreaView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                a.InterfaceC0778a interfaceC0778a2 = interfaceC0778a;
                if (interfaceC0778a2 != null) {
                    interfaceC0778a2.a(view, i, z);
                }
            }
        };
        v vVar2 = this.f9858a;
        if (vVar2 != null) {
            vVar2.a(interfaceC0778a);
            this.f9858a.a(fVar);
        }
        if (this.i) {
            com.opos.mobad.template.k.c cVar = this.m;
            if (cVar != null) {
                cVar.a(interfaceC0778a);
            }
        } else {
            com.opos.mobad.template.a.g gVar = this.l;
            if (gVar != null) {
                gVar.a(interfaceC0778a);
            }
        }
        com.opos.mobad.template.a.c cVar2 = this.k;
        if (cVar2 != null) {
            cVar2.a(interfaceC0778a);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (this.i) {
            com.opos.mobad.template.k.c cVar = this.m;
            if (cVar != null) {
                cVar.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
                return;
            }
            return;
        }
        com.opos.mobad.template.a.g gVar = this.l;
        if (gVar != null) {
            gVar.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i);
        }
    }

    public void a(com.opos.mobad.template.d.b bVar, com.opos.mobad.d.a aVar, boolean z) {
        TextView textView;
        if (!TextUtils.isEmpty(bVar.j)) {
            this.f9858a.setText(bVar.j);
            if (this.n != null) {
                this.o.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            this.e.setText(bVar.b);
        }
        if (!TextUtils.isEmpty(bVar.f9413a) && (textView = this.f) != null) {
            textView.setText(bVar.f9413a);
        }
        if (this.g == 2) {
            a(bVar);
            b(bVar);
        }
        com.opos.mobad.template.d.e eVar = bVar.k;
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            this.c.setVisibility(0);
            a(bVar.k, aVar, z);
            return;
        }
        this.c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.width = -1;
        this.d.setLayoutParams(layoutParams);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar, final boolean z) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("BlockBottomAreaView", "iconUrl is null");
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.s.1
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (z) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (s.this.p != null) {
                            s.this.p.c(i);
                        }
                    } else {
                        if (i == 1 && s.this.p != null) {
                            s.this.p.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.s.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                s.this.b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }
}
