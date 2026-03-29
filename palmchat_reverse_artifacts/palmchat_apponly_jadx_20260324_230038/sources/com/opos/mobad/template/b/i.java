package com.opos.mobad.template.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.cmn.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9336a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private com.opos.mobad.template.a.c e;
    private com.opos.mobad.template.k.c f;
    private com.opos.mobad.d.a g;
    private TextView h;
    private w i;
    private a.InterfaceC0778a j;

    public i(Context context, boolean z, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = aVar;
        this.f9336a = z;
        a(context, z);
    }

    public static i b(Context context, com.opos.mobad.d.a aVar) {
        return new i(context, true, aVar);
    }

    public View a() {
        return this.i;
    }

    public void b(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.k.c cVar = this.f;
        if (cVar == null) {
            return;
        }
        cVar.a(bVar.p, bVar.e, bVar.f, bVar.h, bVar.i);
    }

    public static i a(Context context, com.opos.mobad.d.a aVar) {
        return new i(context, false, aVar);
    }

    private void a(Context context, int i) {
        TextView textView;
        Resources resources;
        int i2;
        w wVar = new w(context);
        this.i = wVar;
        wVar.setId(View.generateViewId());
        this.i.a(90.0f);
        this.h = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 72.0f), i);
        layoutParams.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.i.setLayoutParams(layoutParams);
        int iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
        this.i.setPadding(iA, 0, iA, 0);
        this.i.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        TextPaint paint = this.h.getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.h.setGravity(17);
        this.h.setLayoutParams(layoutParams2);
        this.h.setLines(1);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        if (this.f9336a) {
            textView = this.h;
            resources = context.getResources();
            i2 = R.color.opos_mobad_banner_button_color;
        } else {
            textView = this.h;
            resources = context.getResources();
            i2 = R.color.opos_mobad_button_green_color;
        }
        textView.setTextColor(resources.getColor(i2));
        this.h.setTextSize(1, 12);
        int alphaComponent = ColorUtils.setAlphaComponent(context.getResources().getColor(R.color.opos_mobad_button_green_color), 38);
        this.i.setBackgroundColor(alphaComponent);
        if (this.f9336a) {
            this.i.setBackgroundColor(context.getResources().getColor(R.color.opos_mobad_banner_button_background_color));
        } else {
            this.i.setBackgroundColor(alphaComponent);
        }
        this.i.addView(this.h);
        p.a(this.i, new p() { // from class: com.opos.mobad.template.b.i.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (i.this.j != null) {
                    i.this.j.g(view, iArr);
                }
            }
        });
        this.i.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.b.i.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i3, boolean z) {
                com.opos.cmn.an.f.a.a("BannerRightAreaView", "onMockEventIntercepted->clickMockEvent:" + i3 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (i.this.j != null) {
                    i.this.j.a(view, i3, z);
                }
            }
        });
    }

    private void a(Context context, boolean z) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 62.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(context, 28.0f);
        a(context, iA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a(z);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.addRule(0, this.i.getId());
        addView(this.i, layoutParams);
        addView(this.b, layoutParams2);
    }

    private void a(RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(getContext(), 1, 0, this.g);
        this.f = cVarA;
        cVarA.setId(View.generateViewId());
        relativeLayout.addView(this.f, layoutParams);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BannerRightAreaView", "setListener " + interfaceC0778a);
        this.j = interfaceC0778a;
        this.e.a(interfaceC0778a);
        com.opos.mobad.template.k.c cVar = this.f;
        if (cVar != null) {
            cVar.a(interfaceC0778a);
        }
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            this.d.setVisibility(0);
            return;
        }
        com.opos.mobad.template.a.c cVar = this.e;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.e.a(aVar.f9412a, aVar.b);
        }
    }

    public void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.c.setText(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.d.setText(str3);
    }

    private void a(boolean z) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setGravity(3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            a(relativeLayout);
        }
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.c.setTextSize(1, 14.0f);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        TextPaint paint = this.c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        com.opos.mobad.template.k.c cVar = this.f;
        if (cVar != null) {
            layoutParams2.addRule(0, cVar.getId());
        }
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView2 = new TextView(getContext());
        this.d = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.d.setTextSize(1, 12.0f);
        this.d.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.d.setSingleLine(true);
        this.d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        this.e = new com.opos.mobad.template.a.c(getContext(), getResources().getColor(R.color.opos_mobad_version_company_color), getResources().getColor(R.color.opos_mobad_version_company_split_line_color));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(5);
        this.e.setGravity(3);
        this.e.setVisibility(8);
        relativeLayout2.addView(this.d, layoutParams4);
        relativeLayout2.addView(this.e, layoutParams5);
        relativeLayout.addView(this.c, layoutParams2);
        this.b.addView(relativeLayout, layoutParams);
        this.b.addView(relativeLayout2, layoutParams3);
    }
}
