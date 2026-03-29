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
import com.zenmen.square.ad.AdPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareGenericListItemAdBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16237a;

    @NonNull
    public final TextView b;

    @NonNull
    public final EffectiveShapeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final AdComInfoAllLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final EffectiveShapeView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final FrameLayout m;

    @NonNull
    public final FrameLayout n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final AdPager p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final FrameLayout s;

    @NonNull
    public final FrameLayout t;

    @NonNull
    public final NestHuaWeiNativeAppButton u;

    @NonNull
    public final NestHuaWeiNativeAppButton v;

    @NonNull
    public final ShakeView w;

    @NonNull
    public final ShakeView x;

    @NonNull
    public final View y;

    @NonNull
    public final VisibleDetectView z;

    public SquareGenericListItemAdBinding(Object obj, View view, int i, TextView textView, TextView textView2, EffectiveShapeView effectiveShapeView, TextView textView3, AdComInfoAllLayout adComInfoAllLayout, LinearLayout linearLayout, TextView textView4, LinearLayout linearLayout2, EffectiveShapeView effectiveShapeView2, TextView textView5, ImageView imageView, ImageView imageView2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView3, AdPager adPager, TextView textView6, TextView textView7, FrameLayout frameLayout3, FrameLayout frameLayout4, NestHuaWeiNativeAppButton nestHuaWeiNativeAppButton, NestHuaWeiNativeAppButton nestHuaWeiNativeAppButton2, ShakeView shakeView, ShakeView shakeView2, View view2, VisibleDetectView visibleDetectView) {
        super(obj, view, i);
        this.f16237a = textView;
        this.b = textView2;
        this.c = effectiveShapeView;
        this.d = textView3;
        this.e = adComInfoAllLayout;
        this.f = linearLayout;
        this.g = textView4;
        this.h = linearLayout2;
        this.i = effectiveShapeView2;
        this.j = textView5;
        this.k = imageView;
        this.l = imageView2;
        this.m = frameLayout;
        this.n = frameLayout2;
        this.o = imageView3;
        this.p = adPager;
        this.q = textView6;
        this.r = textView7;
        this.s = frameLayout3;
        this.t = frameLayout4;
        this.u = nestHuaWeiNativeAppButton;
        this.v = nestHuaWeiNativeAppButton2;
        this.w = shakeView;
        this.x = shakeView2;
        this.y = view2;
        this.z = visibleDetectView;
    }

    @NonNull
    public static SquareGenericListItemAdBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareGenericListItemAdBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareGenericListItemAdBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_generic_list_item_ad, null, false, obj);
    }
}
