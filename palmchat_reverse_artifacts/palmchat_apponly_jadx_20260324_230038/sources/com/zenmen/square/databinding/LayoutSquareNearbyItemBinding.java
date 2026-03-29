package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.flexbox.FlexboxLayout;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.palmchat.widget.LightingAnimationView;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.ui.widget.NearByFeedContainer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareNearbyItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LightingAnimationView f16233a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final LeftDrawableText c;

    @NonNull
    public final FrameLayout d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final LXPortraitView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final NearByFeedContainer p;

    @NonNull
    public final RelativeLayout q;

    @NonNull
    public final ConstraintLayout r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final TextView u;

    @NonNull
    public final FlexboxLayout v;

    @NonNull
    public final TextView w;

    @Bindable
    public NearByBean x;

    public LayoutSquareNearbyItemBinding(Object obj, View view, int i, LightingAnimationView lightingAnimationView, FrameLayout frameLayout, LeftDrawableText leftDrawableText, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, LXPortraitView lXPortraitView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView5, ImageView imageView6, NearByFeedContainer nearByFeedContainer, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, TextView textView7, FlexboxLayout flexboxLayout, TextView textView8) {
        super(obj, view, i);
        this.f16233a = lightingAnimationView;
        this.b = frameLayout;
        this.c = leftDrawableText;
        this.d = frameLayout2;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = textView;
        this.j = lXPortraitView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = imageView5;
        this.o = imageView6;
        this.p = nearByFeedContainer;
        this.q = relativeLayout;
        this.r = constraintLayout;
        this.s = textView5;
        this.t = textView6;
        this.u = textView7;
        this.v = flexboxLayout;
        this.w = textView8;
    }

    @Nullable
    public NearByBean o() {
        return this.x;
    }

    public abstract void p(@Nullable NearByBean nearByBean);
}
