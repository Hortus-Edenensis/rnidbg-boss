package com.zenmen.palmchat.widget.toolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import defpackage.e5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZXActionBarView extends ImageView {
    private e5 actionItemVo;

    public ZXActionBarView(Context context) {
        super(context);
    }

    public void init(e5 e5Var, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public ZXActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZXActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ZXActionBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
