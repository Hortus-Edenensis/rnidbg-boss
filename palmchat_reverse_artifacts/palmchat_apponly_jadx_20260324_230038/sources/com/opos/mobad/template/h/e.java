package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f10003a;
    private com.opos.mobad.template.cmn.n b;
    private RelativeLayout c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private boolean g;
    private com.opos.mobad.template.k.c h;
    private com.opos.mobad.d.a i;
    private com.opos.mobad.template.a.c j;
    private boolean l;
    private boolean m;
    private a.InterfaceC0778a n;

    public e(Context context, boolean z, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = false;
        this.m = false;
        this.l = z;
        this.i = aVar;
        a(context);
    }

    public static e a(Context context, boolean z, com.opos.mobad.d.a aVar) {
        return new e(context, z, aVar);
    }

    private void b() {
        TextView textView;
        int color;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        linearLayout2.setGravity(16);
        TextView textView2 = new TextView(getContext());
        this.e = textView2;
        textView2.setId(View.generateViewId());
        if (this.l) {
            this.e.setTextColor(Color.parseColor("#E6000000"));
        } else {
            this.e.setTextColor(-1);
        }
        this.e.setTextSize(1, 14.0f);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.gravity = 16;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams3.gravity = 16;
        linearLayout2.addView(this.e, layoutParams2);
        this.h = this.l ? com.opos.mobad.template.k.c.a(getContext(), 2, 0, this.i) : com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.i);
        linearLayout2.addView(this.h, layoutParams3);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView3 = new TextView(getContext());
        this.f = textView3;
        textView3.setTextSize(1, 10.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        if (this.l) {
            this.j = new com.opos.mobad.template.a.c(getContext(), Color.parseColor("#66000000"));
            textView = this.f;
            color = Color.parseColor("#66000000");
        } else {
            this.j = new com.opos.mobad.template.a.c(getContext());
            textView = this.f;
            color = Color.parseColor("#66FFFFFF");
        }
        textView.setTextColor(color);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(5);
        this.j.setGravity(3);
        this.j.setVisibility(8);
        relativeLayout.addView(this.f, layoutParams5);
        relativeLayout.addView(this.j, layoutParams6);
        this.d.addView(linearLayout2, layoutParams);
        this.d.addView(relativeLayout, layoutParams4);
    }

    public void a() {
        this.g = true;
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_bottom_bg);
        if (this.l) {
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
            setPadding(iA, iA2, iA, iA2);
        } else {
            int iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            setPadding(iA3, iA3, iA3, iA3);
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.c.setPadding(iA4, iA4, iA4, iA4);
        this.c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.addRule(15);
        this.c.setVisibility(0);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        n nVarA = n.a(context, "", this.l);
        this.f10003a = nVarA;
        nVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        b();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.c.getId());
        layoutParams4.addRule(0, this.f10003a.getId());
        this.c.addView(this.b, layoutParams2);
        addView(this.c, layoutParams);
        addView(this.f10003a, layoutParams3);
        addView(this.d, layoutParams4);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.e.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (e.this.g || e.this.n == null) {
                    return;
                }
                e.this.n.h(view, iArr);
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
        a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.e.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                if (e.this.g || e.this.n == null) {
                    return;
                }
                e.this.n.a(view, i, z);
            }
        });
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("RewardBottomAreaView", "setListener " + interfaceC0778a);
        this.n = interfaceC0778a;
        this.f10003a.a(interfaceC0778a);
        this.h.a(interfaceC0778a);
        this.j.a(interfaceC0778a);
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b)) {
            this.f.setVisibility(0);
            return;
        }
        com.opos.mobad.template.a.c cVar = this.j;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.j.a(aVar.f9412a, aVar.b);
        }
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomAreaView", "iconUrl is null");
        } else {
            if (this.m) {
                return;
            }
            this.m = true;
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
            aVar.a(eVar.f9414a, eVar.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.e.3
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (e.this.g) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (e.this.n != null) {
                            e.this.n.c(i);
                        }
                    } else {
                        if (i == 1 && e.this.n != null) {
                            e.this.n.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (e.this.g || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                e.this.b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(com.opos.mobad.template.d.e eVar, String str, String str2, String str3, com.opos.mobad.d.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f10003a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f.setText(str3);
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            this.c.setVisibility(0);
            a(eVar, aVar);
            return;
        }
        this.c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = -1;
        this.d.setLayoutParams(layoutParams);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.template.d.e eVar, com.opos.mobad.template.d.e eVar2, com.opos.mobad.template.d.e eVar3, String str) {
        if (this.l) {
            this.h.a(z, z2, eVar2, eVar3, str);
        } else {
            this.h.a(z, z2, eVar, str);
        }
    }
}
