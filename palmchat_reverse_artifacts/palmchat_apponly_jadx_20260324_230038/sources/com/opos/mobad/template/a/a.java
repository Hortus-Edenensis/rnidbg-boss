package com.opos.mobad.template.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.cmn.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9270a;
    private n b;
    private TextView c;
    private TextView d;

    public a(Context context, int i) {
        super(context);
        this.f9270a = i;
        a();
    }

    private void a() {
        int iA;
        int iA2;
        int iC;
        int color;
        int color2;
        int iA3;
        int i;
        int i2;
        setGravity(1);
        setOrientation(1);
        this.d = new TextView(getContext());
        if (this.f9270a == 1) {
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 106.0f);
            iC = com.opos.cmn.an.h.f.a.c(getContext(), 24.0f);
            color = Color.parseColor("#E5FFFFFF");
            color2 = Color.parseColor("#8AFFFFFF");
            com.opos.mobad.template.h.a(this.d);
            i = 30;
            i2 = 16;
            iA3 = 0;
        } else {
            iA = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
            iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 70.0f);
            iC = com.opos.cmn.an.h.f.a.c(getContext(), 6.0f);
            color = Color.parseColor("#000000");
            color2 = Color.parseColor("#80000000");
            iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
            i = 24;
            i2 = 14;
        }
        this.b = new n(getContext(), iA);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA2);
        this.b.setScaleType(ImageView.ScaleType.FIT_START);
        this.b.setLayoutParams(layoutParams);
        this.d.setTextSize(1, i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = iC;
        this.d.setTextColor(color);
        this.d.setLayoutParams(layoutParams2);
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setTextSize(1, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iA3;
        this.c.setTextColor(color2);
        this.c.setLayoutParams(layoutParams3);
        addView(this.b);
        addView(this.d);
        addView(this.c);
        setVisibility(4);
    }

    private void a(int i) {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        if (i != 1) {
            context = getContext();
            f = 200.0f;
        } else if (this.f9270a == 1) {
            context = getContext();
            f = 46.0f;
        } else {
            context = getContext();
            f = 50.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f);
        setLayoutParams(layoutParams);
    }

    public void a(int i, Bitmap bitmap, String str, String str2) {
        this.b.setImageBitmap(bitmap);
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.c.setText(str2);
        }
        a(i);
        setVisibility(0);
    }
}
