package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class UserTrackRecycleviewItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LeftDrawableText f13917a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LXPortraitView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    public UserTrackRecycleviewItemBinding(Object obj, View view, int i, LeftDrawableText leftDrawableText, LinearLayout linearLayout, LXPortraitView lXPortraitView, TextView textView, RelativeLayout relativeLayout, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.f13917a = leftDrawableText;
        this.b = linearLayout;
        this.c = lXPortraitView;
        this.d = textView;
        this.e = relativeLayout;
        this.f = imageView;
        this.g = textView2;
    }

    @NonNull
    public static UserTrackRecycleviewItemBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static UserTrackRecycleviewItemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (UserTrackRecycleviewItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.user_track_recycleview_item, viewGroup, z, obj);
    }
}
