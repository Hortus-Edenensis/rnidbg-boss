package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.FlowLayout;
import com.zenmen.square.mvp.model.bean.NearByBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutQualityFriendshipItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LeftDrawableText f16225a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final FrameLayout d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final FlowLayout f;

    @NonNull
    public final LeftDrawableText g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @Bindable
    public NearByBean k;

    public LayoutQualityFriendshipItemBinding(Object obj, View view, int i, LeftDrawableText leftDrawableText, ImageView imageView, ImageView imageView2, FrameLayout frameLayout, ConstraintLayout constraintLayout, FlowLayout flowLayout, LeftDrawableText leftDrawableText2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f16225a = leftDrawableText;
        this.b = imageView;
        this.c = imageView2;
        this.d = frameLayout;
        this.e = constraintLayout;
        this.f = flowLayout;
        this.g = leftDrawableText2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    @Nullable
    public NearByBean o() {
        return this.k;
    }

    public abstract void p(@Nullable NearByBean nearByBean);
}
