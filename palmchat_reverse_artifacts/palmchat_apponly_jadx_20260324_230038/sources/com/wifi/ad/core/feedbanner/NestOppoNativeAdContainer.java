package com.wifi.ad.core.feedbanner;

import android.content.Context;
import android.util.AttributeSet;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NestOppoNativeAdContainer extends NativeAdvanceContainer {
    public static final String TAG = "oppoAdContainer";

    public NestOppoNativeAdContainer(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setTag(TAG);
    }

    public NestOppoNativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public NestOppoNativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
