package com.wifi.ad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wifi.ad.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/wifi/ad/core/custom/splashSkip/SplashSkipViewSimple2;", "Lcom/wifi/ad/core/custom/splashSkip/BaseSplashSkipView;", "()V", "tvTime", "Landroid/widget/TextView;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "handleTime", "", "second", "", "onCreateSkipView", "Landroid/view/View;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SplashSkipViewSimple2 extends BaseSplashSkipView {
    private TextView tvTime;

    @Override // com.wifi.ad.core.custom.splashSkip.BaseSplashSkipView
    public ViewGroup.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = 50;
        layoutParams.rightMargin = 30;
        return layoutParams;
    }

    @Override // com.wifi.ad.core.custom.splashSkip.BaseSplashSkipView
    public void handleTime(int second) {
        TextView textView = this.tvTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
        }
        textView.setText(String.valueOf(second));
    }

    @Override // com.wifi.ad.core.custom.splashSkip.BaseSplashSkipView
    public View onCreateSkipView(Context context) {
        View skipView = View.inflate(context, R.layout.layout_splash_skip_view_simple2, null);
        View viewFindViewById = skipView.findViewById(R.id.time);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "skipView.findViewById(R.id.time)");
        this.tvTime = (TextView) viewFindViewById;
        Intrinsics.checkExpressionValueIsNotNull(skipView, "skipView");
        return skipView;
    }
}
