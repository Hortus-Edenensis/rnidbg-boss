package com.opos.mobad.template.h;

import android.content.Context;
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
public class q extends BaseTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.mobad.template.cmn.p f10044a;
    com.opos.mobad.template.cmn.baseview.f b;
    private String c;
    private a.InterfaceC0778a d;

    public q(Context context, String str, int i, int i2, int i3) {
        super(context);
        this.c = "立即安装";
        this.f10044a = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.q.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardEndClickButton", "onBtnClick");
                if (q.this.d != null) {
                    q.this.d.j(view, iArr);
                }
            }
        };
        this.b = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.q.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("RewardEndClickButton", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (q.this.d != null) {
                    q.this.d.a(view, i4, z);
                }
            }
        };
        this.c = TextUtils.isEmpty(str) ? this.c : str;
        a(i, i2, i3);
    }

    public static q a(Context context, String str) {
        return new q(context, str, R.drawable.opos_mobad_drawable_reward_endclick_btn, 16, 44);
    }

    private void a(int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), i3));
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(iA, iA2, iA, iA2);
        setLayoutParams(layoutParams);
        setBackgroundResource(i);
        setGravity(17);
        setTextSize(1, i2);
        setTextColor(-1);
        setText(this.c);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f10044a);
        setOnTouchListener(this.f10044a);
        a(this.b);
    }

    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.d = interfaceC0778a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
