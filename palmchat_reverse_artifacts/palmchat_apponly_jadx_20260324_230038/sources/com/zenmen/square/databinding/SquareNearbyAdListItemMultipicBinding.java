package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
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
public abstract class SquareNearbyAdListItemMultipicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16241a;

    @NonNull
    public final TextView b;

    @NonNull
    public final EffectiveShapeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final AdComInfoAllLayout g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final TextView i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final EffectiveShapeView k;

    @NonNull
    public final EffectiveShapeView l;

    @NonNull
    public final EffectiveShapeView m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final NestHuaWeiNativeAppButton s;

    @NonNull
    public final ShakeView t;

    @NonNull
    public final View u;

    @NonNull
    public final VisibleDetectView v;

    public SquareNearbyAdListItemMultipicBinding(Object obj, View view, int i, TextView textView, TextView textView2, EffectiveShapeView effectiveShapeView, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, AdComInfoAllLayout adComInfoAllLayout, LinearLayout linearLayout3, TextView textView4, LinearLayout linearLayout4, EffectiveShapeView effectiveShapeView2, EffectiveShapeView effectiveShapeView3, EffectiveShapeView effectiveShapeView4, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView5, TextView textView6, NestHuaWeiNativeAppButton nestHuaWeiNativeAppButton, ShakeView shakeView, View view2, VisibleDetectView visibleDetectView) {
        super(obj, view, i);
        this.f16241a = textView;
        this.b = textView2;
        this.c = effectiveShapeView;
        this.d = textView3;
        this.e = linearLayout;
        this.f = linearLayout2;
        this.g = adComInfoAllLayout;
        this.h = linearLayout3;
        this.i = textView4;
        this.j = linearLayout4;
        this.k = effectiveShapeView2;
        this.l = effectiveShapeView3;
        this.m = effectiveShapeView4;
        this.n = imageView;
        this.o = imageView2;
        this.p = imageView3;
        this.q = textView5;
        this.r = textView6;
        this.s = nestHuaWeiNativeAppButton;
        this.t = shakeView;
        this.u = view2;
        this.v = visibleDetectView;
    }

    @NonNull
    public static SquareNearbyAdListItemMultipicBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareNearbyAdListItemMultipicBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SquareNearbyAdListItemMultipicBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_nearby_ad_list_item_multipic, null, false, obj);
    }
}
