package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAppButton;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareNearbyAdListItemBigpicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16240a;

    @NonNull
    public final EffectiveShapeView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final AdComInfoAllLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final EffectiveShapeView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final FrameLayout j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final FrameLayout n;

    @NonNull
    public final NestHuaWeiNativeAppButton o;

    @NonNull
    public final ShakeView p;

    @NonNull
    public final View q;

    @NonNull
    public final VisibleDetectView r;

    public SquareNearbyAdListItemBigpicBinding(Object obj, View view, int i, TextView textView, EffectiveShapeView effectiveShapeView, TextView textView2, AdComInfoAllLayout adComInfoAllLayout, LinearLayout linearLayout, TextView textView3, LinearLayout linearLayout2, EffectiveShapeView effectiveShapeView2, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, TextView textView4, TextView textView5, FrameLayout frameLayout2, NestHuaWeiNativeAppButton nestHuaWeiNativeAppButton, ShakeView shakeView, View view2, VisibleDetectView visibleDetectView) {
        super(obj, view, i);
        this.f16240a = textView;
        this.b = effectiveShapeView;
        this.c = textView2;
        this.d = adComInfoAllLayout;
        this.e = linearLayout;
        this.f = textView3;
        this.g = linearLayout2;
        this.h = effectiveShapeView2;
        this.i = imageView;
        this.j = frameLayout;
        this.k = imageView2;
        this.l = textView4;
        this.m = textView5;
        this.n = frameLayout2;
        this.o = nestHuaWeiNativeAppButton;
        this.p = shakeView;
        this.q = view2;
        this.r = visibleDetectView;
    }

    @NonNull
    public static SquareNearbyAdListItemBigpicBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareNearbyAdListItemBigpicBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareNearbyAdListItemBigpicBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_nearby_ad_list_item_bigpic, null, false, obj);
    }
}
