package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class FragmentSuperExposeMyDynamicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LightingAnimationView f13896a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final RelativeLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final FrameLayout i;

    public FragmentSuperExposeMyDynamicBinding(Object obj, View view, int i, LightingAnimationView lightingAnimationView, RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView2, ImageView imageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f13896a = lightingAnimationView;
        this.b = relativeLayout;
        this.c = textView;
        this.d = linearLayout;
        this.e = relativeLayout2;
        this.f = relativeLayout3;
        this.g = textView2;
        this.h = imageView;
        this.i = frameLayout;
    }

    @NonNull
    public static FragmentSuperExposeMyDynamicBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSuperExposeMyDynamicBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSuperExposeMyDynamicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_super_expose_my_dynamic, viewGroup, z, obj);
    }
}
