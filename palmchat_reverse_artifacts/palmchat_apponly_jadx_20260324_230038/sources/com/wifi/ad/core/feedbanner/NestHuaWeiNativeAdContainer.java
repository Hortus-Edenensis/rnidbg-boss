package com.wifi.ad.core.feedbanner;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.nativead.NativeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NestHuaWeiNativeAdContainer extends NativeView {
    public static final String TAG = "huaweiAdContainer";

    public NestHuaWeiNativeAdContainer(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setTag(TAG);
    }

    public NestHuaWeiNativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public NestHuaWeiNativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
