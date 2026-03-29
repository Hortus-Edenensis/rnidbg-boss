package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LovematchPopNewMatchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EffectiveShapeView f13911a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    public LovematchPopNewMatchBinding(Object obj, View view, int i, EffectiveShapeView effectiveShapeView, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2) {
        super(obj, view, i);
        this.f13911a = effectiveShapeView;
        this.b = frameLayout;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = imageView2;
    }

    @NonNull
    public static LovematchPopNewMatchBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LovematchPopNewMatchBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LovematchPopNewMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lovematch_pop_new_match, null, false, obj);
    }
}
