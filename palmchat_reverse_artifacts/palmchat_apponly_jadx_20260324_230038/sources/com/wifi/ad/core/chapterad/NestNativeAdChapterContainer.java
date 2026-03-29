package com.wifi.ad.core.chapterad;

import android.content.Context;
import android.util.AttributeSet;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NestNativeAdChapterContainer extends NativeAdContainer {
    public static final String TAG = "gdtAdContainer";

    public NestNativeAdChapterContainer(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setTag("gdtAdContainer");
    }

    public NestNativeAdChapterContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public NestNativeAdChapterContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
