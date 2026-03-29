package com.wifi.ad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wifi.ad.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/custom/splashSkip/SplashSkipViewSimple1;", "Lcom/wifi/ad/core/custom/splashSkip/BaseSplashSkipView;", "()V", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "onCreateSkipView", "Landroid/view/View;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SplashSkipViewSimple1 extends BaseSplashSkipView {
    @Override // com.wifi.ad.core.custom.splashSkip.BaseSplashSkipView
    public ViewGroup.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = 50;
        layoutParams.rightMargin = 30;
        return layoutParams;
    }

    @Override // com.wifi.ad.core.custom.splashSkip.BaseSplashSkipView
    public View onCreateSkipView(Context context) {
        View viewInflate = View.inflate(context, R.layout.layout_splash_skip_view_simple1, null);
        Intrinsics.checkExpressionValueIsNotNull(viewInflate, "View.inflate(context, R.…_skip_view_simple1, null)");
        return viewInflate;
    }
}
