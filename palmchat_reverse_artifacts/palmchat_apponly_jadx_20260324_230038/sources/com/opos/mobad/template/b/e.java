package com.opos.mobad.template.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.q;
import com.opos.mobad.template.cmn.w;
import com.opos.mobad.template.g.v;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e extends g {
    private w l;
    private boolean m;
    private View n;
    private ImageView o;
    private com.opos.mobad.template.k.c p;
    private com.opos.mobad.template.a.c q;
    private v r;
    private LinearLayout s;
    private TextView t;
    private TextView u;

    public e(Context context, int i, com.opos.mobad.d.a aVar, boolean z) {
        super(context, i, aVar, z);
    }

    private void h() {
        v vVarC = v.c(this.d, "");
        this.r = vVarC;
        vVarC.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.d, 28.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 21.0f);
        this.l.addView(this.r, layoutParams);
    }

    private void i() {
        ImageView imageView = new ImageView(getContext());
        this.o = imageView;
        imageView.setId(View.generateViewId());
        this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.setBackgroundColor(getContext().getResources().getColor(R.color.opos_mobad_stroke_icon_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 51.0f));
        layoutParams.addRule(10);
        this.l.addView(this.o, layoutParams);
    }

    private void j() {
        LinearLayout linearLayout = new LinearLayout(this.d);
        this.s = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.d, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.d, 8.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.d, 16.0f);
        layoutParams.addRule(0, this.r.getId());
        this.l.addView(this.s, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.d);
        relativeLayout.setGravity(3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.d, 14.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 1, 0, this.b);
        this.p = cVarA;
        cVarA.setId(View.generateViewId());
        relativeLayout.addView(this.p, layoutParams3);
        TextView textView = new TextView(this.d);
        this.u = textView;
        textView.setTextColor(this.d.getResources().getColor(R.color.opos_mobad_title_color));
        this.u.setTextSize(1, 14.0f);
        this.u.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.u.setSingleLine(true);
        TextPaint paint = this.u.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(0, this.p.getId());
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.d, 4.0f);
        relativeLayout.addView(this.u, layoutParams4);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.d);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(this.d, 4.0f);
        TextView textView2 = new TextView(this.d);
        this.t = textView2;
        Resources resources = this.d.getResources();
        int i = R.color.opos_mobad_version_company_color;
        textView2.setTextColor(resources.getColor(i));
        this.t.setTextSize(1, 12.0f);
        this.t.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.t.setSingleLine(true);
        this.t.setVisibility(8);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        this.q = new com.opos.mobad.template.a.c(this.d, getResources().getColor(i), getResources().getColor(R.color.opos_mobad_version_company_split_line_color));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(5);
        this.q.setGravity(3);
        this.q.setVisibility(8);
        relativeLayout2.addView(this.t, layoutParams6);
        relativeLayout2.addView(this.q, layoutParams7);
        this.s.addView(relativeLayout, layoutParams2);
        this.s.addView(relativeLayout2, layoutParams5);
    }

    private void k() {
        this.n = new View(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.n.setBackgroundColor(this.d.getResources().getColor(R.color.opos_mobad_white_color));
        this.l.addView(this.n, layoutParams);
    }

    @Override // com.opos.mobad.template.b.g
    public g a(a.InterfaceC0778a interfaceC0778a) {
        this.c = interfaceC0778a;
        this.p.a(interfaceC0778a);
        this.q.a(this.c);
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a_(com.opos.mobad.template.cmn.baseview.f fVar) {
        super.a_(fVar);
        w wVar = this.l;
        if (wVar != null) {
            wVar.a(fVar);
        }
        v vVar = this.r;
        if (vVar != null) {
            vVar.a(fVar);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g b(p pVar) {
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g c(String str) {
        if (this.u != null && !TextUtils.isEmpty(str)) {
            this.u.setText(str);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.m = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.m = true;
        super.onDetachedFromWindow();
    }

    @Override // com.opos.mobad.template.b.g
    public g a(p pVar) {
        p.a(this.l, pVar);
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g b(String str) {
        if (this.t != null && !TextUtils.isEmpty(str)) {
            this.t.setText(str);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(final q qVar) {
        p.a(this.r, new p() { // from class: com.opos.mobad.template.b.e.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (e.this.m) {
                    com.opos.cmn.an.f.a.a("BannerNewFullImageView", "btnClickListener has been destroyed");
                    return;
                }
                q qVar2 = qVar;
                if (qVar2 != null) {
                    qVar2.b(view, iArr);
                }
            }
        });
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    @TargetApi(21)
    public void b() {
        this.h = new w(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.d, 28.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 21.0f);
        this.h.setBackgroundColor(0);
        this.h.a(com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        this.l.addView(this.h, layoutParams);
        this.i = a.a((RelativeLayout) this.h);
    }

    @Override // com.opos.mobad.template.b.g
    public g a(com.opos.mobad.template.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.f9412a)) {
            this.q.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.q.setVisibility(0);
            this.q.a(aVar.f9412a, aVar.b);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(com.opos.mobad.template.d.b bVar) {
        this.p.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(String str) {
        if (this.r != null && !TextUtils.isEmpty(str)) {
            this.r.a(str);
        }
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public g a(List<Bitmap> list, int i) {
        if (list == null || list.get(0) == null) {
            com.opos.cmn.an.f.a.a("BannerNewFullImageView", "setImageGroup bitmapList is null");
            return this;
        }
        this.o.setImageBitmap(list.get(0));
        return this;
    }

    @Override // com.opos.mobad.template.b.g
    public void a() {
        this.l = new w(this.d);
        this.l.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 328.0f), com.opos.cmn.an.h.f.a.a(this.d, 116.97f)));
        this.l.a(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        addView(this.l);
        k();
        i();
        h();
        j();
        b();
        a((RelativeLayout) this.l);
    }
}
