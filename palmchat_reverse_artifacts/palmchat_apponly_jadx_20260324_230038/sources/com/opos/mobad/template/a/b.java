package com.opos.mobad.template.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f9271a;
    private TextView b;
    private TextView c;
    private a.InterfaceC0778a d;

    public b(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f9271a = linearLayout;
        linearLayout.setOrientation(0);
        this.f9271a.setId(View.generateViewId());
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 9.0f);
        textView.setTextColor(Color.parseColor("#2F80ED"));
        textView.setText(R.string.mobad_app_privacy);
        textView.setGravity(17);
        p pVar = new p() { // from class: com.opos.mobad.template.a.b.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.d != null) {
                    b.this.d.b(view, iArr);
                }
            }
        };
        textView.setOnTouchListener(pVar);
        textView.setOnClickListener(pVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams.gravity = 16;
        this.f9271a.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundColor(DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, com.opos.cmn.an.h.f.a.a(getContext(), 7.0f));
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f9271a.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setTextSize(1, 9.0f);
        textView3.setTextColor(Color.parseColor("#2F80ED"));
        textView3.setGravity(17);
        textView3.setText(R.string.mobad_app_permissions);
        p pVar2 = new p() { // from class: com.opos.mobad.template.a.b.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.d != null) {
                    b.this.d.c(view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(pVar2);
        textView3.setOnClickListener(pVar2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f9271a.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        textView4.setBackgroundColor(DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(1, com.opos.cmn.an.h.f.a.a(getContext(), 7.0f));
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f9271a.addView(textView4, layoutParams4);
        TextView textView5 = new TextView(getContext());
        textView5.setTextSize(1, 9.0f);
        textView5.setTextColor(Color.parseColor("#2F80ED"));
        textView5.setText(R.string.mobad_app_introduce);
        textView5.setGravity(17);
        p pVar3 = new p() { // from class: com.opos.mobad.template.a.b.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (b.this.d != null) {
                    b.this.d.d(view, iArr);
                }
            }
        };
        textView5.setOnTouchListener(pVar3);
        textView5.setOnClickListener(pVar3);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f9271a.addView(textView5, layoutParams5);
        TextView textView6 = new TextView(getContext());
        this.c = textView6;
        textView6.setId(View.generateViewId());
        this.c.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.c.setTextSize(1, 9.0f);
        this.c.setSingleLine();
        this.c.setMaxEms(21);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView7 = new TextView(getContext());
        this.b = textView7;
        textView7.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.b.setTextSize(1, 9.0f);
        this.b.setSingleLine();
        this.b.setMaxEms(21);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
    }

    private void a(int i) {
        int i2;
        int i3;
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, iA);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, iA);
        if (i == 0) {
            layoutParams.addRule(10);
            i2 = 14;
            layoutParams.addRule(14);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
            i3 = 3;
            layoutParams2.addRule(3, this.f9271a.getId());
            layoutParams2.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        } else {
            layoutParams.addRule(9);
            i2 = 15;
            layoutParams.addRule(15);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            i3 = 1;
            layoutParams2.addRule(1, this.f9271a.getId());
            layoutParams2.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        }
        layoutParams3.addRule(i3, this.c.getId());
        layoutParams3.addRule(i2);
        if (indexOfChild(this.f9271a) < 0) {
            addView(this.f9271a, layoutParams);
            addView(this.c, layoutParams2);
            addView(this.b, layoutParams3);
        } else {
            updateViewLayout(this.f9271a, layoutParams);
            updateViewLayout(this.c, layoutParams2);
            updateViewLayout(this.b, layoutParams3);
        }
    }

    public void a(int i, String str, String str2) {
        a(i);
        this.c.setText(this.c.getContext().getString(R.string.mobad_compliance_version) + str);
        this.b.setText(this.b.getContext().getString(R.string.mobad_compliance_author) + str2);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.d = interfaceC0778a;
    }
}
