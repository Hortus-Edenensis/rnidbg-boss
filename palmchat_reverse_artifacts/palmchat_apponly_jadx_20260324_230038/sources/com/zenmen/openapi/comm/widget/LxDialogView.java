package com.zenmen.openapi.comm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import defpackage.fa3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LxDialogView extends RelativeLayout {
    protected fa3 mCallback;
    protected a mInfo;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public LxDialogView(Context context) {
        this(context, null);
    }

    public void initView(a aVar) {
        this.mInfo = aVar;
    }

    public void setEventCallback(fa3 fa3Var) {
        this.mCallback = fa3Var;
    }

    public LxDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LxDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public LxDialogView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
