package com.zenmen.openapi.webapp.floatview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import defpackage.fa3;
import defpackage.h84;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppFloatMenuBox extends LxRelativeLayout implements fa3 {
    public AppFloatMenuBox(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        if (h84.c()) {
            View.inflate(context, R$layout.lx_webapp_float_menu_box_32286, this);
        } else {
            View.inflate(context, R$layout.lx_webapp_float_menu_box, this);
        }
        RelativeLayout relativeLayout = (RelativeLayout) getChildAt(0);
        int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = relativeLayout.getChildAt(i);
            if (childAt instanceof FloatMenuItemView) {
                ((FloatMenuItemView) childAt).setEventCallback(this);
            }
        }
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        disPatchEvent(i, obj);
    }

    public AppFloatMenuBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppFloatMenuBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public AppFloatMenuBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
