package com.wifi.ad.core.feedbanner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.custom.flow.AdImageLoader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wifi/ad/core/feedbanner/WkFeedBannerSdkView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mImgView", "Landroid/widget/ImageView;", "initView", "", "setAdView", "adType", "", "imgUrl", "", "adView", "Landroid/view/View;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkFeedBannerSdkView extends FrameLayout {
    private HashMap _$_findViewCache;
    private ImageView mImgView;

    public WkFeedBannerSdkView(Context context) {
        super(context);
        initView(context);
    }

    private final void initView(Context context) {
        ImageView imageView = new ImageView(context);
        this.mImgView = imageView;
        addView(imageView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setAdView(int adType, String imgUrl, View adView) {
        if (adType == 4) {
            ImageView imageView = this.mImgView;
            if (imageView == null) {
                Intrinsics.throwNpe();
            }
            if (imageView.getVisibility() != 8) {
                ImageView imageView2 = this.mImgView;
                if (imageView2 == null) {
                    Intrinsics.throwNpe();
                }
                imageView2.setVisibility(8);
            }
            if (adView != null) {
                ViewParent parent = adView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(adView);
                }
                addView(adView, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        ImageView imageView3 = this.mImgView;
        if (imageView3 == null) {
            Intrinsics.throwNpe();
        }
        if (imageView3.getVisibility() != 0) {
            ImageView imageView4 = this.mImgView;
            if (imageView4 == null) {
                Intrinsics.throwNpe();
            }
            imageView4.setVisibility(0);
        }
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        if (togetherAd.getMImageLoader() == null || TextUtils.isEmpty(imgUrl)) {
            return;
        }
        AdImageLoader mImageLoader = togetherAd.getMImageLoader();
        if (mImageLoader == null) {
            Intrinsics.throwNpe();
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        ImageView imageView5 = this.mImgView;
        if (imageView5 == null) {
            Intrinsics.throwNpe();
        }
        if (imgUrl == null) {
            Intrinsics.throwNpe();
        }
        mImageLoader.loadImage(context, imageView5, imgUrl);
    }
}
