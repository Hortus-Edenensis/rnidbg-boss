package com.zenmen.openapi.comm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import defpackage.fa3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LxRelativeLayout extends RelativeLayout {
    private fa3 mEventCallback;

    public LxRelativeLayout(Context context) {
        this(context, null);
    }

    public abstract void createView(Context context);

    public void disPatchEvent(int i, Object obj) {
        fa3 fa3Var = this.mEventCallback;
        if (fa3Var != null) {
            fa3Var.onEvent(i, obj);
        }
    }

    public void setEventCallback(fa3 fa3Var) {
        this.mEventCallback = fa3Var;
    }

    public LxRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LxRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        createView(context);
    }

    @RequiresApi(api = 21)
    public LxRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        createView(context);
        initAttr(context, attributeSet);
    }

    public void initAttr(Context context, AttributeSet attributeSet) {
    }
}
