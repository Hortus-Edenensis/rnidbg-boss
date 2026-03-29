package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ac extends com.opos.mobad.template.cmn.baseview.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f9657a;
    private com.opos.mobad.template.cmn.ad b;
    private TextView c;
    private FrameLayout d;
    private a.InterfaceC0778a e;
    private a f;
    private com.opos.mobad.d.a g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9660a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;
        public final int f;
        public final boolean g;

        public a(int i, int i2, int i3, int i4, float f, int i5, boolean z) {
            this.f9660a = i;
            this.c = i3;
            this.b = i2;
            this.d = i4;
            this.e = f;
            this.f = i5;
            this.g = z;
        }
    }

    public ac(Context context, a aVar, com.opos.mobad.d.a aVar2) {
        super(context);
        this.f9657a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.ac.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockTipBar", "onFeedBackClick");
                if (ac.this.e != null) {
                    ac.this.e.a(view, iArr);
                }
            }
        };
        this.f = aVar;
        this.g = aVar2;
        a();
    }

    public static ac a(Context context, com.opos.mobad.d.a aVar) {
        return new ac(context, new a(10, 33, 14, 3, 3.0f, 637534208, true), aVar);
    }

    public static ac b(Context context, com.opos.mobad.d.a aVar) {
        return new ac(context, new a(10, 33, 14, 3, 3.0f, context.getResources().getColor(R.color.opos_mobad_small_bar_bg_color), true), aVar);
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f.f);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f.e));
        com.opos.mobad.template.h.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f.d), 0, 0, 0);
        setOrientation(0);
        com.opos.mobad.template.cmn.ad adVar = new com.opos.mobad.template.cmn.ad(getContext());
        this.b = adVar;
        adVar.setTextColor(Color.parseColor("#FFFFFF"));
        this.b.setTextSize(1, this.f.f9660a);
        this.b.setGravity(17);
        this.b.setMaxEms(6);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setLetterSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 0.67f));
        this.b.setSingleLine();
        this.b.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.b, layoutParams);
        this.d = new FrameLayout(getContext());
        TextView textView = new TextView(getContext());
        this.c = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_feedback_down_arrow);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams2.gravity = 17;
        this.d.addView(this.c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), 0, 0, 0);
        addView(this.d, layoutParams3);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockTipBar", "setListener " + interfaceC0778a);
        this.e = interfaceC0778a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ViewGroup.LayoutParams layoutParams) {
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), this.f.d);
        setPadding(iA, 0, z ? 0 : iA, 0);
        this.b.setLayoutParams(layoutParams);
        this.b.setVisibility(0);
    }

    private void a(final boolean z, com.opos.mobad.template.d.e eVar, final String str) {
        com.opos.mobad.template.h.a(this.e, eVar.f9414a, this.g, eVar.b, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.g.ac.1
            @Override // com.opos.mobad.template.b
            public void a(Bitmap bitmap) {
                int iA;
                BitmapDrawable bitmapDrawableA = bitmap != null ? com.opos.mobad.template.h.a(ac.this.getContext(), bitmap) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("getLogoDrawable=");
                sb.append(bitmapDrawableA != null ? bitmapDrawableA : com.igexin.push.core.b.m);
                com.opos.cmn.an.f.a.b("BlockTipBar", sb.toString());
                ViewGroup.LayoutParams layoutParams = ac.this.b.getLayoutParams();
                if (bitmapDrawableA != null) {
                    com.opos.mobad.template.h.a(ac.this.b, bitmapDrawableA);
                    layoutParams.width = com.opos.cmn.an.h.f.a.a(ac.this.getContext(), ac.this.f.b);
                    iA = com.opos.cmn.an.h.f.a.a(ac.this.getContext(), ac.this.f.c);
                } else {
                    ac.this.b.setText(TextUtils.isEmpty(str) ? "" : str);
                    iA = -2;
                    layoutParams.width = -2;
                }
                layoutParams.height = iA;
                ac.this.a(z, layoutParams);
            }
        });
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2) {
        a(z, z2, eVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.template.d.e eVar, String str) {
        com.opos.mobad.template.cmn.ad adVar;
        com.opos.mobad.template.cmn.p pVar;
        FrameLayout frameLayout = this.d;
        if (z) {
            frameLayout.setVisibility(0);
            com.opos.mobad.template.cmn.p.a(this.d, this.f9657a);
            adVar = this.b;
            pVar = this.f9657a;
        } else {
            frameLayout.setVisibility(8);
            adVar = this.b;
            pVar = null;
        }
        com.opos.mobad.template.cmn.p.a(adVar, pVar);
        if (!z2 || this.b.getVisibility() == 0) {
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f9414a)) {
            a(z, eVar, str);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        com.opos.mobad.template.cmn.ad adVar2 = this.b;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        adVar2.setText(str);
        layoutParams.width = -2;
        layoutParams.height = -2;
        a(z, layoutParams);
    }
}
