package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends com.opos.cmn.module.ui.b.c.b {
    private RelativeLayout e;
    private TextView f;

    public g(Context context) {
        super(context);
    }

    private void f() {
        this.e = new RelativeLayout(this.f8059a);
        g();
        h();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.c.addView(this.e, layoutParams);
    }

    private void g() {
        ImageView imageView = new ImageView(this.f8059a);
        this.d = imageView;
        imageView.setId(1);
        this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.d.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.f8059a, "opos_module_biz_ui_native_video_loading_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8059a, 24.0f), com.opos.cmn.an.h.f.a.a(this.f8059a, 24.0f));
        layoutParams.addRule(14);
        this.e.addView(this.d, layoutParams);
    }

    private void h() {
        TextView textView = new TextView(this.f8059a);
        this.f = textView;
        textView.setText("加载中...");
        this.f.setTextColor(-1);
        this.f.setTextSize(1, 14.0f);
        this.f.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f8059a, 12.0f);
        layoutParams.addRule(3, 1);
        this.e.addView(this.f, layoutParams);
    }

    @Override // com.opos.cmn.module.ui.b.c.b
    public void a() {
        ImageView imageView = new ImageView(this.f8059a);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#000000")));
        imageView.setAlpha(0.4f);
        this.c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.cmn.module.ui.b.c.b
    public void b() {
        f();
    }
}
