package com.opos.mobad.template.h;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
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
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class r extends RelativeLayout implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.cmn.n f10047a;
    private TextView b;
    private TextView c;
    private com.opos.mobad.template.a.c d;
    private q e;
    private LinearLayout f;
    private com.opos.mobad.d.a g;
    private boolean h;
    private int i;
    private boolean j;
    private com.opos.mobad.template.d.d k;
    private TextView l;
    private com.opos.mobad.template.cmn.w m;
    private int n;
    private s o;
    private com.opos.mobad.template.k.c p;
    private boolean q;
    private a.InterfaceC0778a r;

    public r(Context context, boolean z, com.opos.mobad.d.a aVar, int i) {
        this(context, z, false, aVar, i);
    }

    private com.opos.mobad.template.cmn.q g() {
        return new com.opos.mobad.template.cmn.q(this.n) { // from class: com.opos.mobad.template.h.r.4
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (r.this.h || r.this.r == null) {
                    return;
                }
                r.this.r.j(view, iArr);
            }
        };
    }

    private void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        clearAnimation();
        this.h = true;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.i;
    }

    public r(Context context, boolean z, boolean z2, com.opos.mobad.d.a aVar, int i) {
        super(context);
        this.h = false;
        this.q = false;
        z = com.opos.mobad.d.c.b.a(getContext()) ? true : z;
        this.j = z2;
        this.n = Color.parseColor("#247CFF");
        this.g = aVar;
        this.i = i;
        a(z);
    }

    public static r a(Context context, com.opos.mobad.d.a aVar, int i) {
        return new r(context, true, aVar, i);
    }

    private void b(LinearLayout linearLayout) {
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f10047a = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f10047a.setVisibility(8);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f10047a, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, boolean z) {
        View view;
        if (this.j) {
            this.m = new com.opos.mobad.template.cmn.w(getContext());
            TextView textView = new TextView(getContext());
            this.l = textView;
            textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.l.setTextColor(-1);
            this.l.setTextSize(1, 16.0f);
            TextPaint paint = this.l.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.m.a(90.0f);
            this.m.addView(this.l, layoutParams);
            com.opos.mobad.template.cmn.q qVarG = g();
            this.m.setBackgroundColor(this.n);
            com.opos.mobad.template.cmn.p.a(this.m, qVarG);
            this.m.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.r.3
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view2, int i, boolean z2) {
                    com.opos.cmn.an.f.a.a("RewardEndPage", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z2 + ";view:" + view2.getClass().getName());
                    if (r.this.h || r.this.r == null) {
                        return;
                    }
                    r.this.r.a(view2, i, z2);
                }
            });
            view = this.m;
        } else {
            q qVarA = q.a(getContext(), "");
            this.e = qVarA;
            view = qVarA;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), z ? 296.0f : 280.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        relativeLayout.addView(view, layoutParams2);
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        this.b = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.b.setTextSize(1, 16.0f);
        this.b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.b.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setVisibility(8);
        layoutParams.gravity = 1;
        linearLayout.addView(this.b, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.c = textView2;
        textView2.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        this.c.setVisibility(8);
        layoutParams2.gravity = 1;
        linearLayout.addView(this.c, layoutParams2);
        this.d = new com.opos.mobad.template.a.c(getContext());
        new RelativeLayout.LayoutParams(-1, -2).addRule(5);
        this.d.setGravity(3);
        this.d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.d, layoutParams3);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.f = linearLayout2;
        linearLayout2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        int iA;
        int iA2;
        this.p = com.opos.mobad.template.k.c.a(getContext(), 3, 0, this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        Context context = getContext();
        if (z) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, 49.0f);
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, 16.0f);
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        }
        layoutParams.leftMargin = iA;
        this.o = s.a(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        if (z) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 49.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        } else {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        }
        layoutParams2.rightMargin = iA2;
        if (!z) {
            relativeLayout.addView(this.p, layoutParams);
            relativeLayout.addView(this.o, layoutParams2);
            return;
        }
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 94.0f));
        layoutParams3.addRule(10);
        cVar.setLayoutParams(layoutParams3);
        cVar.setBackgroundColor(-16777216);
        cVar.addView(this.p, layoutParams);
        cVar.addView(this.o, layoutParams2);
        relativeLayout.addView(cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.r = interfaceC0778a;
        q qVar = this.e;
        if (qVar != null) {
            qVar.a(interfaceC0778a);
        }
        this.d.a(interfaceC0778a);
        com.opos.mobad.template.k.c cVar = this.p;
        if (cVar != null) {
            cVar.a(this.r);
        }
        this.o.a(interfaceC0778a);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.a.c cVar;
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar = this.d) == null) {
            return;
        }
        cVar.setVisibility(0);
        this.d.a(aVar.f9412a, aVar.b);
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        this.f10047a.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "iconUrl is null");
        } else {
            if (this.q) {
                return;
            }
            this.q = true;
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.r.5
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (r.this.h) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (r.this.r != null) {
                            r.this.r.c(i);
                        }
                    } else {
                        if (i == 1 && r.this.r != null) {
                            r.this.r.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.r.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (r.this.h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                r.this.f10047a.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(com.opos.mobad.template.d.e eVar, String str, String str2, String str3, com.opos.mobad.d.a aVar) {
        q qVar;
        if (!TextUtils.isEmpty(str) && (qVar = this.e) != null) {
            qVar.a(str);
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b.setVisibility(0);
            this.b.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.c.setVisibility(0);
            this.c.setText(str3);
        }
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.f10047a.setVisibility(0);
            this.f10047a.setVisibility(8);
        } else {
            this.f10047a.setVisibility(0);
            a(eVar, aVar);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "data is null");
            a.InterfaceC0778a interfaceC0778a = this.r;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
                return;
            }
            return;
        }
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0778a interfaceC0778a2 = this.r;
            if (interfaceC0778a2 != null) {
                interfaceC0778a2.a(1);
                return;
            }
            return;
        }
        a(dVarC.O, dVarC.S, dVarC.Q, dVarC.R, this.g);
        a(dVarC);
        a(dVarC.l);
        com.opos.mobad.template.k.c cVar = this.p;
        if (cVar != null) {
            cVar.a(dVarC.p, dVarC.q, dVarC.e, dVarC.g, dVarC.i);
        }
        if (this.j) {
            if (this.k == null) {
                h();
            }
            this.k = dVarC;
        }
    }

    private void a(String str, int i) {
        if (TextUtils.isEmpty(str) || i >= 3) {
            return;
        }
        if (this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#8CFFFFFF"));
        textView.setTextSize(1, 10.0f);
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        textView.setText(str);
        textView.setPadding(iA2, 0, iA2, 0);
        textView.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_label_bg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        if (i > 0) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        }
        this.f.addView(textView, layoutParams);
    }

    private void a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            a(list.get(i), i);
        }
    }

    private void a(boolean z) {
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        cVar.setBackgroundColor(Color.parseColor(z ? "#B3000000" : "#CC000000"));
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.r.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (r.this.r != null) {
                    r.this.r.i(view, iArr);
                }
            }
        };
        cVar.setOnClickListener(pVar);
        cVar.setOnTouchListener(pVar);
        cVar.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.r.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardEndPage", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                if (r.this.r != null) {
                    r.this.r.a(view, i, z2);
                }
            }
        });
        b(linearLayout);
        c(linearLayout);
        a(linearLayout);
        b(cVar, z);
        a(cVar, z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 360.0f), -2);
        layoutParams.addRule(13);
        cVar.addView(linearLayout, layoutParams);
        addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this;
    }
}
