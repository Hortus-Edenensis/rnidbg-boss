package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i extends b {
    private TextView e;
    private com.opos.cmn.module.ui.a.a f;
    private final String g;
    private int h;

    public i(Context context, e eVar) {
        super(context, eVar);
        this.g = "当前是数据网络，播放视频将消耗流量";
    }

    private void e() {
        final int[] iArr = new int[4];
        this.f.setOnTouchListener(new com.opos.cmn.module.ui.a.b(iArr));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.a.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i iVar = i.this;
                iVar.b.b(iVar.f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.ui.a.b
    public void b() {
        TextView textView = new TextView(this.f10204a);
        this.e = textView;
        textView.setText("当前是数据网络，播放视频将消耗流量");
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
        com.opos.cmn.module.ui.a.a aVar = new com.opos.cmn.module.ui.a.a(this.f10204a, R.drawable.native_video_bt);
        this.f = aVar;
        aVar.setText("继续播放");
        this.f.setGravity(17);
        this.f.setTextSize(1, 14.0f);
        this.f.setTextColor(Color.parseColor("#2AD181"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f10204a, 70.0f), com.opos.cmn.an.h.f.a.a(this.f10204a, 24.0f));
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
        imageView.setAlpha(0.4f);
        this.c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }
}
