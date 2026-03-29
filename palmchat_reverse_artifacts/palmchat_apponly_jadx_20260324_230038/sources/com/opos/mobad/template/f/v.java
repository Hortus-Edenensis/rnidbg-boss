package com.opos.mobad.template.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a.g f9636a;
    private com.opos.mobad.template.k.c b;
    private TextView c;
    private TextView d;
    private int e;
    private View f;
    private com.opos.mobad.d.a g;
    private boolean h;
    private a.InterfaceC0778a i;

    public v(Context context, boolean z, com.opos.mobad.d.a aVar) {
        super(context);
        this.e = 0;
        this.g = aVar;
        this.h = z;
        a();
    }

    private void a() {
        View view;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        if (this.h) {
            this.b = com.opos.mobad.template.k.c.a(getContext(), 3, 0, this.g);
            layoutParams.addRule(15);
            view = this.b;
        } else {
            com.opos.mobad.template.a.g gVarA = com.opos.mobad.template.a.g.a(getContext(), this.g);
            this.f9636a = gVarA;
            gVarA.a(1308622847);
            view = this.f9636a;
        }
        addView(view, layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#8A42464C"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        relativeLayout.setPadding(iA, 0, iA, 0);
        com.opos.mobad.template.h.a(relativeLayout, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 102.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        addView(relativeLayout, layoutParams2);
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setId(View.generateViewId());
        this.c.setTextColor(-1);
        this.c.setTextSize(1, 14.0f);
        this.c.setGravity(17);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setSingleLine();
        this.c.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 40.0f));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.c, layoutParams3);
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setBackgroundColor(1308622847);
        this.f.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.setMargins(iA2, iA2, iA2, iA2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, this.c.getId());
        relativeLayout.addView(this.f, layoutParams4);
        this.d = new TextView(getContext());
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.v.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
                if (v.this.i != null) {
                    v.this.i.a(view2, iArr, v.this.e == 1);
                }
            }
        };
        this.d.setOnClickListener(pVar);
        this.d.setOnTouchListener(pVar);
        this.d.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 15.7f), com.opos.cmn.an.h.f.a.a(getContext(), 13.68f));
        layoutParams5.addRule(15);
        layoutParams5.addRule(0, this.f.getId());
        relativeLayout.addView(this.d, layoutParams5);
    }

    private void a(int i) {
        TextView textView;
        Resources resources;
        int i2;
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                textView = this.d;
                resources = getContext().getResources();
                i2 = R.drawable.opos_mobad_drawable_sound_off;
            } else if (i == 2) {
                this.d.setVisibility(8);
                return;
            } else {
                textView = this.d;
                resources = getContext().getResources();
                i2 = R.drawable.opos_mobad_drawable_sound_on;
            }
            textView.setBackground(resources.getDrawable(i2));
        }
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.i = interfaceC0778a;
        if (this.h) {
            this.b.a(interfaceC0778a);
        } else {
            this.f9636a.a(interfaceC0778a);
        }
    }

    public void a(boolean z, int i, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2) {
        if (this.h) {
            this.b.a(z, str, z2, eVar, str2);
        } else {
            this.f9636a.a(z, str, z2, eVar, str2);
        }
        this.c.setText(af.a(getContext()));
        a(i);
    }
}
