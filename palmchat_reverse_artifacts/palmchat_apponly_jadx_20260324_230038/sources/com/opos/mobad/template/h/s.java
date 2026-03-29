package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseImageView f10054a;
    private BaseTextView b;
    private int c;
    private a.InterfaceC0778a d;

    public s(Context context, int i) {
        super(context);
        this.c = i;
        a();
    }

    public static s a(Context context) {
        return new s(context, 0);
    }

    private void a() {
        com.opos.mobad.template.cmn.p pVar;
        View view;
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        gradientDrawable.setColor(-1975368116);
        setBackground(gradientDrawable);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(iA2, iA, iA2, iA);
        if (this.c == 1) {
            BaseTextView baseTextView = new BaseTextView(getContext());
            this.b = baseTextView;
            baseTextView.setTextSize(1, 14.0f);
            this.b.setTextColor(Color.parseColor("#E5FFFFFF"));
            this.b.setText("关闭广告");
            addView(this.b, new LinearLayout.LayoutParams(-2, -2));
            pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.s.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (s.this.d != null) {
                        s.this.d.e(view2, iArr);
                    }
                }
            };
            this.b.setOnTouchListener(pVar);
            view = this.b;
        } else {
            BaseImageView baseImageView = new BaseImageView(getContext());
            this.f10054a = baseImageView;
            baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f10054a.setImageResource(R.drawable.opos_mobad_drawable_block_close);
            addView(this.f10054a, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f)));
            pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.s.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (s.this.d != null) {
                        s.this.d.e(view2, iArr);
                    }
                }
            };
            this.f10054a.setOnTouchListener(pVar);
            view = this.f10054a;
        }
        view.setOnClickListener(pVar);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.d = interfaceC0778a;
    }
}
