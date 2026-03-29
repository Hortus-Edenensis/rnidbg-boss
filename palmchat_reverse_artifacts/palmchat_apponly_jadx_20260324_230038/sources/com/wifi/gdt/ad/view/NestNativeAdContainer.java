package com.wifi.gdt.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class NestNativeAdContainer extends NativeAdContainer {
    public static final String TAG = "gdtAdContainer";

    public NestNativeAdContainer(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setTag("gdtAdContainer");
    }

    public NestNativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public NestNativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
