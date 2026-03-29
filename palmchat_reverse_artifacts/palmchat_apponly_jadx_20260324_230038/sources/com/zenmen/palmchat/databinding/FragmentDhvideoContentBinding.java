package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class FragmentDhvideoContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f13894a;

    @NonNull
    public final FrameLayout b;

    public FragmentDhvideoContentBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.f13894a = frameLayout;
        this.b = frameLayout2;
    }

    @NonNull
    public static FragmentDhvideoContentBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDhvideoContentBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentDhvideoContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_dhvideo_content, null, false, obj);
    }
}
