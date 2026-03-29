package com.wifi.ad.core.feedbanner;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ClearLogoNativeAdContainer extends NestNativeAdFeedContainer {
    public ClearLogoNativeAdContainer(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        if (childCount > 1) {
            getChildAt(childCount - 1).layout(0, 0, 0, 0);
        }
    }

    public ClearLogoNativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClearLogoNativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
