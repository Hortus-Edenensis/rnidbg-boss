package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class BouncyHScrollView extends HorizontalScrollView {
    private static final int MAX_X_OVERSCROLL_DISTANCE = 100;
    private Context mContext;
    private int mMaxXOverscrollDistance;

    public BouncyHScrollView(Context context) {
        super(context);
        this.mContext = context;
        initBounceDistance();
    }

    private void initBounceDistance() {
        this.mMaxXOverscrollDistance = (int) (this.mContext.getResources().getDisplayMetrics().density * 100.0f);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, this.mMaxXOverscrollDistance, i8, z);
    }

    public BouncyHScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initBounceDistance();
    }

    public BouncyHScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initBounceDistance();
    }
}
