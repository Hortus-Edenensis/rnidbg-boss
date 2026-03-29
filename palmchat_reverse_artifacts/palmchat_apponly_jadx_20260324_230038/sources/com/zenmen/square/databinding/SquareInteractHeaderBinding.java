package com.zenmen.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.MSVGAImageView;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareInteractHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f16239a;

    @NonNull
    public final TextView b;

    @NonNull
    public final MSVGAImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final View g;

    @NonNull
    public final View h;

    @NonNull
    public final View i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    public SquareInteractHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, MSVGAImageView mSVGAImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, View view3, View view4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.f16239a = linearLayout;
        this.b = textView;
        this.c = mSVGAImageView;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = view2;
        this.h = view3;
        this.i = view4;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = textView6;
        this.o = textView7;
        this.p = textView8;
    }

    @NonNull
    public static SquareInteractHeaderBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SquareInteractHeaderBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SquareInteractHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.square_interact_header, viewGroup, z, obj);
    }
}
