package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class FragmentDynamicTrackBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f13895a;

    @NonNull
    public final TabLayout b;

    public FragmentDynamicTrackBinding(Object obj, View view, int i, ViewPager viewPager, TabLayout tabLayout) {
        super(obj, view, i);
        this.f13895a = viewPager;
        this.b = tabLayout;
    }

    @NonNull
    public static FragmentDynamicTrackBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDynamicTrackBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentDynamicTrackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_dynamic_track, viewGroup, z, obj);
    }
}
