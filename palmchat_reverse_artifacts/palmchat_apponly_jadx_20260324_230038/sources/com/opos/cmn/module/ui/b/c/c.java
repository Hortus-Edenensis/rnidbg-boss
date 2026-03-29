package com.opos.cmn.module.ui.b.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends a {
    protected ImageView g;
    private TextView h;
    private TextView i;
    private int[] j;

    public c(Context context) {
        super(context);
        this.j = new int[4];
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8058a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f8058a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.d.addView(this.h, layoutParams);
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8058a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f8058a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.d.addView(this.i, layoutParams);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8058a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f8058a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.d.addView(this.g, layoutParams);
    }

    @Override // com.opos.cmn.module.ui.b.c.a
    public void a() {
        TextView textView = new TextView(this.f8058a);
        this.h = textView;
        textView.setGravity(17);
        this.h.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setTextColor(Color.parseColor("#767575"));
        this.h.setTextSize(1, 13.0f);
        TextView textView2 = new TextView(this.f8058a);
        this.i = textView2;
        textView2.setGravity(17);
        this.i.setSingleLine();
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setTextColor(Color.parseColor("#d95955"));
        this.i.setTextSize(1, 13.0f);
        ImageView imageView = new ImageView(this.f8058a);
        this.g = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.g.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        e();
        c();
        d();
    }

    public void b(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return;
        }
        this.h.setText(str);
        this.h.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.j));
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.module.ui.b.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.b.a(view, cVar.j);
            }
        });
    }

    public c(Context context, float f) {
        super(context, f);
        this.j = new int[4];
    }

    public void a(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return;
        }
        this.i.setText(str);
        this.i.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.j));
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.module.ui.b.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.b.b(view, cVar.j);
            }
        });
    }
}
