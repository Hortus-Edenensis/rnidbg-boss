package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ActivityDynamicExposeHomeBinding extends ViewDataBinding {

    @NonNull
    public final TextView A;

    @NonNull
    public final AppCompatTextView B;

    @NonNull
    public final TextView C;

    @NonNull
    public final LinearLayout E;

    @NonNull
    public final TextView F;

    @NonNull
    public final FrameLayout G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f13888a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final FrameLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final RelativeLayout k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final RecyclerView m;

    @NonNull
    public final LinearLayout n;

    @NonNull
    public final ShapeableImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final LXPortraitView q;

    @NonNull
    public final LinearLayout r;

    @NonNull
    public final TextView s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final TextView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final RecyclerView w;

    @NonNull
    public final TextView x;

    @NonNull
    public final TextView y;

    @NonNull
    public final TextView z;

    public ActivityDynamicExposeHomeBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView2, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout, LinearLayout linearLayout4, RecyclerView recyclerView, LinearLayout linearLayout5, ShapeableImageView shapeableImageView, ImageView imageView3, LXPortraitView lXPortraitView, LinearLayout linearLayout6, TextView textView5, LinearLayout linearLayout7, TextView textView6, TextView textView7, RecyclerView recyclerView2, TextView textView8, TextView textView9, TextView textView10, TextView textView11, AppCompatTextView appCompatTextView, TextView textView12, LinearLayout linearLayout8, TextView textView13, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.f13888a = imageView;
        this.b = linearLayout;
        this.c = textView;
        this.d = frameLayout;
        this.e = linearLayout2;
        this.f = imageView2;
        this.g = linearLayout3;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = relativeLayout;
        this.l = linearLayout4;
        this.m = recyclerView;
        this.n = linearLayout5;
        this.o = shapeableImageView;
        this.p = imageView3;
        this.q = lXPortraitView;
        this.r = linearLayout6;
        this.s = textView5;
        this.t = linearLayout7;
        this.u = textView6;
        this.v = textView7;
        this.w = recyclerView2;
        this.x = textView8;
        this.y = textView9;
        this.z = textView10;
        this.A = textView11;
        this.B = appCompatTextView;
        this.C = textView12;
        this.E = linearLayout8;
        this.F = textView13;
        this.G = frameLayout2;
    }

    @NonNull
    public static ActivityDynamicExposeHomeBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDynamicExposeHomeBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDynamicExposeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_dynamic_expose_home, null, false, obj);
    }
}
