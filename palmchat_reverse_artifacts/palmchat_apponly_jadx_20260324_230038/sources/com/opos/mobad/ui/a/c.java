package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends b {
    private TextView e;
    private com.opos.cmn.module.ui.a.c f;
    private final String g;
    private int h;
    private final String i;

    public c(Context context, e eVar) {
        super(context, eVar);
        this.g = "抱歉，视频播放失败，请点击重试";
        this.i = "opos_module_biz_ui_native_video_replay_cover.png";
    }

    private void e() {
        final int[] iArr = new int[4];
        this.f.setOnTouchListener(new com.opos.cmn.module.ui.a.b(iArr));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.b.a(cVar.f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.ui.a.b
    public void b() {
        TextView textView = new TextView(this.f10204a);
        this.e = textView;
        textView.setText("抱歉，视频播放失败，请点击重试");
        int iA = com.opos.mobad.cmn.func.b.h.a();
        this.h = iA;
        this.e.setId(iA);
        this.e.setTextColor(-1);
        this.e.setTextSize(1, 14.0f);
        this.e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.d.addView(this.e, layoutParams);
    }

    @Override // com.opos.mobad.ui.a.b
    public void c() {
        com.opos.cmn.module.ui.a.c cVar = new com.opos.cmn.module.ui.a.c(this.f10204a, 50.0f);
        this.f = cVar;
        cVar.setScaleType(ImageView.ScaleType.CENTER);
        this.f.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.f10204a, "opos_module_biz_ui_native_video_replay_cover.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10204a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f10204a, 40.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f10204a, 14.0f);
        layoutParams.addRule(3, this.h);
        layoutParams.addRule(14);
        this.d.addView(this.f, layoutParams);
        e();
    }

    public View d() {
        return this.c;
    }

    @Override // com.opos.mobad.ui.a.b
    public void a() {
        ImageView imageView = new ImageView(this.f10204a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(1.0f);
        this.c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }
}
