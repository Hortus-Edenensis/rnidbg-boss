package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.e;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends BaseTextView implements com.opos.mobad.template.e {
    public a(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.opos.mobad.template.e
    public View a() {
        return this;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.opos.mobad.template.e
    public void a(int i) {
        setText(String.format(Locale.getDefault(), "%1$d 跳过", Integer.valueOf(i)));
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(17);
        setTextColor(-1);
        setTextSize(1, 14.0f);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int i2 = iA * 3;
        setPadding(i2, iA, i2, iA);
        com.opos.mobad.template.h.a(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(60.0f);
        gradientDrawable.setColor(-1975368116);
        com.opos.mobad.d.c.e.a(this, gradientDrawable);
    }

    @Override // com.opos.mobad.template.e
    public void a(final e.a aVar) {
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.a.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                aVar.a(view, iArr);
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
    }
}
