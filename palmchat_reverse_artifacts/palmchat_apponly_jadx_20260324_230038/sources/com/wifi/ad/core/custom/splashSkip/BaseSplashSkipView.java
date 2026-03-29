package com.wifi.ad.core.custom.splashSkip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/wifi/ad/core/custom/splashSkip/BaseSplashSkipView;", "", "()V", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "handleTime", "", "second", "", "onCreateSkipView", "Landroid/view/View;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseSplashSkipView {
    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract View onCreateSkipView(Context context);

    public void handleTime(int second) {
    }
}
