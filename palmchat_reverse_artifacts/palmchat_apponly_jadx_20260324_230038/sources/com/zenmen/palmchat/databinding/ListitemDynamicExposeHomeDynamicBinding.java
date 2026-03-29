package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ListitemDynamicExposeHomeDynamicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f13910a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final AppCompatTextView d;

    @NonNull
    public final TextView e;

    public ListitemDynamicExposeHomeDynamicBinding(Object obj, View view, int i, ShapeableImageView shapeableImageView, ImageView imageView, TextView textView, AppCompatTextView appCompatTextView, TextView textView2) {
        super(obj, view, i);
        this.f13910a = shapeableImageView;
        this.b = imageView;
        this.c = textView;
        this.d = appCompatTextView;
        this.e = textView2;
    }

    @NonNull
    public static ListitemDynamicExposeHomeDynamicBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ListitemDynamicExposeHomeDynamicBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ListitemDynamicExposeHomeDynamicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.listitem_dynamic_expose_home_dynamic, viewGroup, z, obj);
    }
}
