package com.opos.mobad.ui.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f10254a;

    public g(Context context) {
        super(context);
        this.f10254a = new int[]{SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};
    }

    public int[] a() {
        return this.f10254a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f10254a[0] = com.opos.cmn.an.h.f.a.b(getContext(), motionEvent.getX());
            this.f10254a[1] = com.opos.cmn.an.h.f.a.b(getContext(), motionEvent.getY());
        } else if (motionEvent.getAction() == 2 || motionEvent.getAction() == 1) {
            this.f10254a[2] = com.opos.cmn.an.h.f.a.b(getContext(), motionEvent.getX());
            this.f10254a[3] = com.opos.cmn.an.h.f.a.b(getContext(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                childAt.measure(i, i2);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(iMax, iMax2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }
}
