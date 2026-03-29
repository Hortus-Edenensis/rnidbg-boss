package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
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
public class n extends BaseTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10028a;
    private String b;
    private final boolean c;
    private a.InterfaceC0778a d;

    public n(Context context, String str, int i, int i2, int i3, boolean z) {
        super(context);
        this.b = "立即安装";
        this.f10028a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.n.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardClickButton", "onBtnClick");
                if (n.this.d != null) {
                    n.this.d.g(view, iArr);
                }
            }
        };
        this.b = TextUtils.isEmpty(str) ? this.b : str;
        this.c = z;
        a(i, i2, i3);
    }

    public static n a(Context context, String str, boolean z) {
        return new n(context, str, z ? R.drawable.opos_mobad_drawable_reward_block_click_btn : R.drawable.opos_mobad_drawable_reward_block_click_btn2, 12, 28, z);
    }

    private void a(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), i3));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(iA, iA2, iA, iA2);
        setLayoutParams(layoutParams);
        setBackgroundResource(i);
        setGravity(17);
        setTextSize(1, i2);
        setTextColor(this.c ? Color.parseColor("#0066FF") : -1);
        setText(this.b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f10028a);
        setOnTouchListener(this.f10028a);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        com.opos.cmn.an.f.a.b("RewardClickButton", "setListener " + interfaceC0778a);
        this.d = interfaceC0778a;
    }
}
