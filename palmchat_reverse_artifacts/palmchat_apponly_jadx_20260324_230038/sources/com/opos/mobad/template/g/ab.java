package com.opos.mobad.template.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ab extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ac f9655a;
    private com.opos.mobad.template.cmn.baseview.b b;
    private TextView c;
    private com.opos.mobad.d.a d;
    private a.InterfaceC0778a e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public ab(Context context, boolean z, com.opos.mobad.d.a aVar) {
        super(context);
        this.d = aVar;
        a(z);
    }

    public static ab b(Context context, com.opos.mobad.d.a aVar) {
        return new ab(context, false, aVar);
    }

    public static ab a(Context context, com.opos.mobad.d.a aVar) {
        return new ab(context, true, aVar);
    }

    private void b(boolean z) {
        if (z) {
            TextView textView = new TextView(getContext());
            this.c = textView;
            textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_bar_title_color));
            this.c.setTextSize(1, 12.0f);
            this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
            int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
            layoutParams.leftMargin = iA;
            layoutParams.rightMargin = iA2;
            layoutParams.addRule(15);
            layoutParams.addRule(1, this.f9655a.getId());
            layoutParams.addRule(0, this.b.getId());
            addView(this.c, layoutParams);
        }
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.e = interfaceC0778a;
        this.f9655a.a(interfaceC0778a);
    }

    private void a(boolean z) {
        ac acVarB = ac.b(getContext(), this.d);
        this.f9655a = acVarB;
        acVarB.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.f9655a, layoutParams);
        this.b = new com.opos.mobad.template.cmn.baseview.b(getContext());
        ImageView imageView = new ImageView(getContext());
        this.b.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_small_close);
        this.b.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ab.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ab.this.e != null) {
                    ab.this.e.e(view, iArr);
                }
            }
        };
        this.b.setOnTouchListener(pVar);
        this.b.setOnClickListener(pVar);
        addView(this.b, layoutParams2);
        b(z);
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2, int i, String str3) {
        TextView textView;
        this.f9655a.a(z, str, z2, eVar, str2);
        if (TextUtils.isEmpty(str3) || (textView = this.c) == null) {
            return;
        }
        textView.setText(str3);
    }
}
