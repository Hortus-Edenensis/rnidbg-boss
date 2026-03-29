package com.opos.mobad.template.h;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i extends d {
    private com.opos.mobad.d.a f;
    private Context g;
    private com.opos.mobad.template.cmn.w h;
    private com.opos.mobad.template.cmn.y i;
    private RelativeLayout j;
    private com.opos.mobad.template.cmn.w l;
    private LinearLayout m;
    private TextView n;
    private com.opos.mobad.template.a.c o;
    private TextView p;
    private com.opos.mobad.template.k.c q;
    private com.opos.mobad.template.cmn.q r;
    private LinearLayout s;

    public i(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = context.getApplicationContext();
        this.f = aVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        setLayoutParams(layoutParams);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.g);
        this.l = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.g);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.g, 16.0f));
        wVar2.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, 153));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(1, 1, 1, 1);
        this.j = new RelativeLayout(this.g);
        this.j.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 360.0f), com.opos.cmn.an.h.f.a.a(this.g, 64.0f)));
        this.j.setPadding(com.opos.cmn.an.h.f.a.a(this.g, 12.0f), 0, com.opos.cmn.an.h.f.a.a(this.g, 12.0f), 0);
        wVar2.addView(this.j);
        this.l.addView(wVar2, layoutParams2);
        addView(this.l);
        a(context);
        b(context);
        c(context);
    }

    private RelativeLayout.LayoutParams c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.m = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.m.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(1, this.i.getId());
        layoutParams.addRule(0, this.h.getId());
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        layoutParams.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.m.setLayoutParams(layoutParams);
        this.m.setGravity(16);
        LinearLayout linearLayout2 = new LinearLayout(this.g);
        this.s = linearLayout2;
        linearLayout2.setOrientation(0);
        this.s.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.m.addView(this.s, layoutParams2);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setGravity(3);
        this.n.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.n.setTextColor(-1);
        TextPaint paint = this.n.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.n.setLines(1);
        this.n.setMaxEms(10);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setTextSize(1, 14.0f);
        this.s.addView(this.n);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.f);
        this.q = cVarA;
        this.s.addView(cVarA, layoutParams3);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.g);
        this.o = cVar;
        cVar.setGravity(3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 4.0f);
        this.m.addView(this.o, layoutParams4);
        this.j.addView(this.m);
        return layoutParams;
    }

    @Override // com.opos.mobad.template.h.d
    public void a() {
    }

    @Override // com.opos.mobad.template.h.d
    public void b() {
        com.opos.mobad.template.cmn.q qVar = this.r;
        if (qVar != null) {
            qVar.a(this.d);
        }
        this.h.setBackgroundColor(this.d);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.h, "backgroundColor", this.c, this.d);
        objectAnimatorOfInt.setDuration(350L);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        objectAnimatorOfInt.start();
    }

    @Override // com.opos.mobad.template.h.d
    public void c() {
        com.opos.mobad.template.cmn.q qVar = this.r;
        if (qVar != null) {
            qVar.a(this.d);
        }
        if (this.b) {
            b();
        }
    }

    private void a(Context context) {
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(context, com.opos.cmn.an.h.f.a.a(this.g, 8.0f));
        this.i = nVar;
        nVar.setId(View.generateViewId());
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        int iA = com.opos.cmn.an.h.f.a.a(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(15);
        this.i.setLayoutParams(layoutParams);
        this.j.addView(this.i);
    }

    private void b(final Context context) {
        this.h = new com.opos.mobad.template.cmn.w(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.h.setLayoutParams(layoutParams);
        this.h.setId(View.generateViewId());
        this.h.setBackgroundColor(this.c);
        TextView textView = new TextView(context);
        this.p = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.p.setLayoutParams(new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f)));
        this.p.setTextSize(1, 14.0f);
        this.p.setGravity(17);
        this.p.setLines(1);
        this.p.setMaxWidth(com.opos.cmn.an.h.f.a.a(this.g, 80.0f));
        int iA = com.opos.cmn.an.h.f.a.a(context, 10.0f);
        this.p.setPadding(iA, 0, iA, 0);
        TextPaint paint = this.p.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.p.setTextColor(-1);
        this.h.addView(this.p);
        this.p.post(new Runnable() { // from class: com.opos.mobad.template.h.i.1
            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                if (iVar.e) {
                    return;
                }
                i.this.h.a(iVar.p.getHeight() > 0 ? i.this.p.getHeight() / 2 : com.opos.cmn.an.h.f.a.a(context, 16.0f));
            }
        });
        this.j.addView(this.h);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.i.setVisibility(0);
            this.i.setImageBitmap(bitmap);
            return;
        }
        this.i.setVisibility(8);
        LinearLayout linearLayout = this.m;
        if (linearLayout == null || linearLayout.getLayoutParams() == null || !(this.m.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.addRule(9);
        if (this.j.indexOfChild(this.m) >= 0) {
            this.j.updateViewLayout(this.m, layoutParams);
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.q.a(interfaceC0778a);
        this.o.a(interfaceC0778a);
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.cmn.q qVar) {
        if (qVar != null) {
            this.r = qVar;
            com.opos.mobad.template.cmn.p.a(this.h, qVar);
        }
    }

    @Override // com.opos.mobad.template.h.d
    public void a(com.opos.mobad.template.d.b bVar) {
        if (bVar != null) {
            this.n.setText(bVar.b);
            this.p.setText(bVar.j);
            this.q.a(bVar.p, bVar.e, bVar.g, bVar.i);
            com.opos.mobad.template.d.a aVar = bVar.u;
            if (aVar != null) {
                this.o.a(aVar.f9412a, aVar.b);
            } else {
                this.o.setVisibility(8);
            }
        }
    }
}
