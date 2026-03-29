package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class w extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a.InterfaceC0778a f10072a;

    public w(Context context, boolean z) {
        super(context);
        a(z);
    }

    public static w b(Context context) {
        return new w(context, false);
    }

    public static w a(Context context) {
        return new w(context, true);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.f10072a = interfaceC0778a;
    }

    private void a(boolean z) {
        Context context;
        float f;
        com.opos.mobad.template.cmn.baseview.c cVar = new com.opos.mobad.template.cmn.baseview.c(getContext());
        cVar.setBackgroundColor(Color.parseColor("#000000"));
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.w.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (w.this.f10072a != null) {
                    w.this.f10072a.h(view, iArr);
                }
            }
        };
        cVar.setOnClickListener(pVar);
        cVar.setOnTouchListener(pVar);
        cVar.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.w.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardLoadingView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                if (w.this.f10072a != null) {
                    w.this.f10072a.a(view, i, z2);
                }
            }
        });
        BaseImageView baseImageView = new BaseImageView(getContext());
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        baseImageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams.addRule(11);
        if (z) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 53.0f);
            context = getContext();
            f = 28.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            context = getContext();
            f = 54.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f);
        cVar.addView(baseImageView, layoutParams);
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.w.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (w.this.f10072a != null) {
                    w.this.f10072a.e(view, iArr);
                }
            }
        };
        baseImageView.setOnTouchListener(pVar2);
        baseImageView.setOnClickListener(pVar2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        ProgressBar progressBar = new ProgressBar(getContext());
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.addRule(13);
        progressBar.setVisibility(0);
        linearLayout.addView(progressBar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#4DFFFFFF"));
        textView.setTextSize(1, 14.0f);
        textView.setText("视频加载中...");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        linearLayout.addView(textView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        cVar.addView(linearLayout, layoutParams4);
        addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }
}
