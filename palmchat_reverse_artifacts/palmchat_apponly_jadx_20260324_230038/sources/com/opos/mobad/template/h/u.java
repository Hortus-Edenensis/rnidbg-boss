package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f10065a;
    private View b;
    private BaseTextView c;
    private int d;
    private a.InterfaceC0778a e;

    public u(Context context, int i) {
        super(context);
        this.d = i;
        a();
    }

    public static u a(Context context) {
        return a(context, 0);
    }

    public static u a(Context context, int i) {
        return new u(context, i);
    }

    private void a() {
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(iA2, iA, iA2, iA);
        TextView textView = new TextView(getContext());
        this.f10065a = textView;
        textView.setTextSize(1, 14.0f);
        this.f10065a.setEllipsize(TextUtils.TruncateAt.END);
        this.f10065a.setSingleLine();
        addView(this.f10065a, new LinearLayout.LayoutParams(-2, -1));
        View view = new View(getContext());
        this.b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.b, layoutParams);
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.c = baseTextView;
        baseTextView.setTextSize(1, 14.0f);
        this.c.setMaxLines(1);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.weight = 1.0f;
        int i = this.d;
        if (i == 2 || i == 1) {
            gradientDrawable.setColor(-1305333198);
            this.f10065a.setTextColor(Color.parseColor("#E5FFFFFF"));
            this.c.setTextColor(Color.parseColor("#E5FFFFFF"));
        } else {
            gradientDrawable.setColor(-1288555982);
            this.f10065a.setTextColor(Color.parseColor("#FFFFFF"));
            this.c.setTextColor(Color.parseColor("#FFBB0E"));
            com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.u.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    com.opos.cmn.an.f.a.b("RewardLeftBar", "onVIPClick");
                    if (u.this.e != null) {
                        u.this.e.l(view2, iArr);
                    }
                }
            };
            this.c.setOnClickListener(pVar);
            this.c.setOnTouchListener(pVar);
            this.c.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.u.2
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view2, int i2, boolean z) {
                    com.opos.cmn.an.f.a.a("RewardLeftBar", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view2.getClass().getName());
                    if (u.this.e != null) {
                        u.this.e.a(view2, i2, z);
                    }
                }
            });
        }
        addView(this.c, layoutParams2);
        setBackground(gradientDrawable);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.e = interfaceC0778a;
    }

    public void a(String str, int i) {
        BaseTextView baseTextView;
        String str2;
        if (TextUtils.isEmpty(str) && i == 0) {
            setVisibility(8);
            return;
        }
        if (this.f10065a != null) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.f10065a.setVisibility(0);
            this.f10065a.setText(str);
        }
        View view = this.b;
        if (i == 0) {
            view.setVisibility(8);
            this.c.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        this.c.setVisibility(0);
        if (i == 1) {
            baseTextView = this.c;
            str2 = "跳过广告";
        } else if (i != 2) {
            this.c.setVisibility(8);
            this.c.setVisibility(8);
            return;
        } else {
            baseTextView = this.c;
            str2 = "VIP免广告";
        }
        baseTextView.setText(str2);
        this.c.setVisibility(0);
    }
}
