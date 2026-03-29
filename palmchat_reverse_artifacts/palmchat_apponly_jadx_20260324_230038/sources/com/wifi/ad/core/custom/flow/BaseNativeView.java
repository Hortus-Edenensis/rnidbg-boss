package com.wifi.ad.core.custom.flow;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006JR\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H&J2\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J2\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u00012\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J2\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J>\u0010\u0017\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, d2 = {"Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "", "()V", "getAdButtonView", "Landroid/widget/TextView;", "clickViews", "", "Landroid/view/View;", "creativeViews", "registerViewAndActionFeedAd", "", "adProviderType", "", "container", "Landroid/view/ViewGroup;", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "showDrawVideoAd", "adObject", "showNative", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseNativeView {
    public static /* synthetic */ void showDrawVideoAd$default(BaseNativeView baseNativeView, String str, NestAdData nestAdData, ViewGroup viewGroup, NativeViewListener nativeViewListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDrawVideoAd");
        }
        if ((i & 8) != 0) {
            nativeViewListener = null;
        }
        baseNativeView.showDrawVideoAd(str, nestAdData, viewGroup, nativeViewListener);
    }

    public static /* synthetic */ void showNative$default(BaseNativeView baseNativeView, String str, Object obj, ViewGroup viewGroup, NativeViewListener nativeViewListener, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNative");
        }
        if ((i & 8) != 0) {
            nativeViewListener = null;
        }
        baseNativeView.showNative(str, obj, viewGroup, nativeViewListener);
    }

    public static /* synthetic */ void showNativeDrawVideoAd$default(BaseNativeView baseNativeView, String str, NestAdData nestAdData, ViewGroup viewGroup, NativeViewListener nativeViewListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNativeDrawVideoAd");
        }
        if ((i & 8) != 0) {
            nativeViewListener = null;
        }
        baseNativeView.showNativeDrawVideoAd(str, nestAdData, viewGroup, nativeViewListener);
    }

    public static /* synthetic */ void showTemplateFeedAd$default(BaseNativeView baseNativeView, String str, NestAdData nestAdData, ViewGroup viewGroup, NativeViewListener nativeViewListener, Activity activity, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showTemplateFeedAd");
        }
        baseNativeView.showTemplateFeedAd(str, nestAdData, viewGroup, (i & 8) != 0 ? null : nativeViewListener, (i & 16) != 0 ? null : activity);
    }

    public final TextView getAdButtonView(List<View> clickViews, List<View> creativeViews) {
        if (clickViews != null) {
            for (View view : clickViews) {
                if ((view instanceof TextView) && WifiNestConst.OtherConst.TAG_AD_BUTTON.equals(view.getTag())) {
                    return (TextView) view;
                }
            }
        }
        for (View view2 : creativeViews) {
            if ((view2 instanceof TextView) && WifiNestConst.OtherConst.TAG_AD_BUTTON.equals(view2.getTag())) {
                return (TextView) view2;
            }
        }
        return null;
    }

    public abstract void registerViewAndActionFeedAd(@NonNull String adProviderType, @NonNull ViewGroup container, @NonNull List<View> clickViews, @NonNull List<View> creativeViews, @NonNull NestAdData nestAdData, @Nullable NativeViewListener listener);

    public abstract void showDrawVideoAd(@NonNull String adProviderType, @NonNull NestAdData adObject, @NonNull ViewGroup container, @Nullable NativeViewListener listener);

    public abstract void showNative(@NonNull String adProviderType, @NonNull Object adObject, @NonNull ViewGroup container, @Nullable NativeViewListener listener);

    public abstract void showNativeDrawVideoAd(@NonNull String adProviderType, @NonNull NestAdData adObject, @NonNull ViewGroup container, @Nullable NativeViewListener listener);

    public abstract void showTemplateFeedAd(@NonNull String adProviderType, @NonNull NestAdData adObject, @NonNull ViewGroup container, @Nullable NativeViewListener listener, @Nullable Activity activity);
}
