package com.opos.mobad.template.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v extends BaseTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f9870a;
    com.opos.mobad.template.cmn.baseview.f b;
    private String c;
    private boolean d;
    private a.InterfaceC0778a e;

    public v(Context context, String str, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        super(context);
        this.c = "下载";
        this.d = false;
        this.f9870a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.v.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockClickButton", "onBtnClick");
                if (v.this.e != null) {
                    v.this.e.g(view, iArr);
                }
            }
        };
        this.b = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.v.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i5, boolean z3) {
                com.opos.cmn.an.f.a.a("BlockClickButton", "onMockEventIntercepted->clickMockEvent:" + i5 + ";disAllowClick:" + z3 + ";view:" + view.getClass().getName());
                if (v.this.e != null) {
                    v.this.e.a(view, i5, z3);
                }
            }
        };
        this.c = TextUtils.isEmpty(str) ? this.c : str;
        this.d = z2;
        a(i, i2, i3, i4, z);
    }

    public static v b(Context context, String str) {
        Resources resources = context.getResources();
        int i = R.color.opos_mobad_install_button_color;
        return new v(context, str, resources.getColor(i), context.getResources().getColor(i), 12, 22, false, false);
    }

    public static v c(Context context, String str) {
        return new v(context, str, context.getResources().getColor(R.color.opos_mobad_banner_button_background_color), context.getResources().getColor(R.color.opos_mobad_banner_button_color), 12, 22, false, true);
    }

    public static v d(Context context, String str) {
        return new v(context, str, context.getResources().getColor(R.color.opos_mobad_banner_button_background_color_blue), context.getResources().getColor(R.color.opos_mobad_banner_button_color_white), 12, 22, false, true);
    }

    public static v e(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_white_btn, context.getResources().getColor(R.color.opos_mobad_button_bg_white_color), 12, 22, true, true);
    }

    public static v f(Context context, String str) {
        return new v(context, str, Color.parseColor("#247CFF"), Color.parseColor("#FFFFFF"), 12, 22, false, true);
    }

    public static v a(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_btn, context.getResources().getColor(R.color.opos_mobad_white_color), 12, 22, true, false);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        Drawable drawable;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 72.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        setPadding(iA, iA2, iA, iA2);
        setLayoutParams(layoutParams);
        if (z) {
            drawable = getResources().getDrawable(i);
        } else {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
            drawable = gradientDrawable;
        }
        if (!this.d) {
            drawable.setAlpha((getResources().getConfiguration().uiMode & 48) == 32 ? 63 : 38);
        }
        setBackground(drawable);
        setGravity(17);
        setTextSize(1, i3);
        setTextColor(i2);
        setText(this.c);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(0.8f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f9870a);
        setOnTouchListener(this.f9870a);
        a(this.b);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("BlockClickButton", "setListener " + interfaceC0778a);
        this.e = interfaceC0778a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
