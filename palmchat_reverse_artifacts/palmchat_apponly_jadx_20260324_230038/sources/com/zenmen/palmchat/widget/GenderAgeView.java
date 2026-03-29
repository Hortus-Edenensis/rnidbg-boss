package com.zenmen.palmchat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$drawable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class GenderAgeView extends TextView {
    public GenderAgeView(Context context) {
        super(context);
    }

    public void setGenderAge(String str, int i) {
        setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            setText("");
            setPadding(me1.b(getContext(), 3), me1.b(getContext(), 2), me1.b(getContext(), 3), me1.b(getContext(), 2));
            setCompoundDrawablePadding(0);
        } else {
            setText(str);
            setPadding(me1.b(getContext(), 6), me1.b(getContext(), 2), me1.b(getContext(), 6), me1.b(getContext(), 2));
            setCompoundDrawablePadding(me1.b(getContext(), 2));
        }
        setBackgroundResource(i == 0 ? R$drawable.bg_member_gender_age_male : R$drawable.bg_member_gender_age_female);
        setCompoundDrawablesWithIntrinsicBounds(i == 0 ? R$drawable.ic_member_male : R$drawable.ic_member_female, 0, 0, 0);
        if (TextUtils.isEmpty(str) && i == -1) {
            setVisibility(8);
        }
    }

    public GenderAgeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GenderAgeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GenderAgeView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
