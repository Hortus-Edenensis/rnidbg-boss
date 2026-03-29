package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ActivitySuperExposeHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f13891a;

    @NonNull
    public final ViewPager b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TabLayout e;

    @NonNull
    public final RelativeLayout f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final FrameLayout i;

    public ActivitySuperExposeHomeBinding(Object obj, View view, int i, ImageView imageView, ViewPager viewPager, RelativeLayout relativeLayout, TextView textView, TabLayout tabLayout, RelativeLayout relativeLayout2, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f13891a = imageView;
        this.b = viewPager;
        this.c = relativeLayout;
        this.d = textView;
        this.e = tabLayout;
        this.f = relativeLayout2;
        this.g = imageView2;
        this.h = imageView3;
        this.i = frameLayout;
    }

    @NonNull
    public static ActivitySuperExposeHomeBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySuperExposeHomeBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySuperExposeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_expose_home, null, false, obj);
    }
}
