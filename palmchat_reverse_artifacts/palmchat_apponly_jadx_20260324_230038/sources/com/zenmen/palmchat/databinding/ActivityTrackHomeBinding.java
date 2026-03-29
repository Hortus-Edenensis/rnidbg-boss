package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ActivityTrackHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f13892a;

    @NonNull
    public final ViewPager b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TabLayout d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final FrameLayout f;

    public ActivityTrackHomeBinding(Object obj, View view, int i, ImageView imageView, ViewPager viewPager, LinearLayout linearLayout, TabLayout tabLayout, RelativeLayout relativeLayout, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f13892a = imageView;
        this.b = viewPager;
        this.c = linearLayout;
        this.d = tabLayout;
        this.e = relativeLayout;
        this.f = frameLayout;
    }

    @NonNull
    public static ActivityTrackHomeBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityTrackHomeBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityTrackHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_track_home, null, false, obj);
    }
}
