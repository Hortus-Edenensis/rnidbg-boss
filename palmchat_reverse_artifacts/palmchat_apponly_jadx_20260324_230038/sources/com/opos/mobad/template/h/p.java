package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class p extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f10041a;
    private TextView b;
    private TextView c;
    private a d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public p(Context context) {
        super(context);
        a();
    }

    public void b(CharSequence charSequence) {
        TextView textView;
        if (charSequence == null || TextUtils.isEmpty(charSequence) || (textView = this.b) == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void c(CharSequence charSequence) {
        TextView textView;
        if (charSequence == null || TextUtils.isEmpty(charSequence) || (textView = this.c) == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public static p a(Context context) {
        return new p(context);
    }

    private void a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(0);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        RelativeLayout relativeLayout4 = new RelativeLayout(getContext());
        relativeLayout2.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_dialog_bg);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        TextView textView = new TextView(getContext());
        this.f10041a = textView;
        textView.setId(View.generateViewId());
        this.f10041a.setTextColor(Color.parseColor("#E5000000"));
        this.f10041a.setTextSize(1, 18.0f);
        this.f10041a.setGravity(17);
        this.f10041a.setMinHeight(com.opos.cmn.an.h.f.a.a(getContext(), 82.0f));
        this.f10041a.setMaxHeight(com.opos.cmn.an.h.f.a.a(getContext(), 192.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        TextPaint paint = this.f10041a.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        relativeLayout4.setId(View.generateViewId());
        relativeLayout4.setPadding(iA, iA, iA, iA2);
        relativeLayout4.addView(this.f10041a, layoutParams);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        int iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        TextView textView2 = new TextView(getContext());
        this.b = textView2;
        textView2.setTextColor(Color.parseColor("#0066FF"));
        this.b.setGravity(1);
        this.b.setTextSize(1, 16.0f);
        b("关闭视频");
        TextPaint paint2 = this.b.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iA4);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams2);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.p.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (p.this.d != null) {
                    p.this.d.a(view, iArr);
                }
            }
        };
        this.b.setOnClickListener(pVar);
        this.b.setOnTouchListener(pVar);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#33000000"));
        linearLayout.addView(textView3, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), iA3));
        TextView textView4 = new TextView(getContext());
        this.c = textView4;
        textView4.setTextColor(Color.parseColor("#0066FF"));
        this.c.setTextSize(1, 16.0f);
        this.c.setGravity(1);
        c("继续观看");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, iA4);
        layoutParams3.weight = 1.0f;
        TextPaint paint3 = this.c.getPaint();
        paint3.setStrokeWidth(1.0f);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        linearLayout.addView(this.c, layoutParams3);
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.p.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (p.this.d != null) {
                    p.this.d.b(view, iArr);
                }
            }
        };
        this.c.setOnClickListener(pVar2);
        this.c.setOnTouchListener(pVar2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 58.0f));
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, relativeLayout4.getId());
        relativeLayout3.addView(linearLayout, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(14);
        relativeLayout3.addView(relativeLayout4, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -2);
        layoutParams6.addRule(14);
        relativeLayout2.addView(relativeLayout3, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -2);
        layoutParams7.addRule(14);
        layoutParams7.addRule(12);
        layoutParams7.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
        relativeLayout.addView(relativeLayout2, layoutParams7);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(CharSequence charSequence) {
        TextView textView;
        if (charSequence == null || TextUtils.isEmpty(charSequence) || (textView = this.f10041a) == null) {
            return;
        }
        textView.setText(charSequence);
    }
}
