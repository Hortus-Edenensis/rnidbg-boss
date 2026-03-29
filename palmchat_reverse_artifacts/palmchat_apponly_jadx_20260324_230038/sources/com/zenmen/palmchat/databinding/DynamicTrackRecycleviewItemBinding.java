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
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class DynamicTrackRecycleviewItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13893a;

    @NonNull
    public final LXPortraitView b;

    @NonNull
    public final ShapeableImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final AppCompatTextView g;

    public DynamicTrackRecycleviewItemBinding(Object obj, View view, int i, TextView textView, LXPortraitView lXPortraitView, ShapeableImageView shapeableImageView, TextView textView2, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.f13893a = textView;
        this.b = lXPortraitView;
        this.c = shapeableImageView;
        this.d = textView2;
        this.e = imageView;
        this.f = imageView2;
        this.g = appCompatTextView;
    }

    @NonNull
    public static DynamicTrackRecycleviewItemBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DynamicTrackRecycleviewItemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DynamicTrackRecycleviewItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dynamic_track_recycleview_item, viewGroup, z, obj);
    }
}
