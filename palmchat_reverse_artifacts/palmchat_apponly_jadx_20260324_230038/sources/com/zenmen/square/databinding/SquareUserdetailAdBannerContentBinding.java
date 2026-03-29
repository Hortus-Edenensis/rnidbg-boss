package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAppButton;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareUserdetailAdBannerContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16243a;

    @NonNull
    public final TextView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final AdComInfoAllLayout d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final EffectiveShapeView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final FrameLayout i;

    @NonNull
    public final NestHuaWeiNativeAppButton j;

    @NonNull
    public final ShakeView k;

    public SquareUserdetailAdBannerContentBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, AdComInfoAllLayout adComInfoAllLayout, ImageView imageView2, EffectiveShapeView effectiveShapeView, TextView textView3, TextView textView4, FrameLayout frameLayout, NestHuaWeiNativeAppButton nestHuaWeiNativeAppButton, ShakeView shakeView) {
        super(obj, view, i);
        this.f16243a = textView;
        this.b = textView2;
        this.c = imageView;
        this.d = adComInfoAllLayout;
        this.e = imageView2;
        this.f = effectiveShapeView;
        this.g = textView3;
        this.h = textView4;
        this.i = frameLayout;
        this.j = nestHuaWeiNativeAppButton;
        this.k = shakeView;
    }

    @NonNull
    public static SquareUserdetailAdBannerContentBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareUserdetailAdBannerContentBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareUserdetailAdBannerContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_userdetail_ad_banner_content, null, false, obj);
    }
}
