package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ActivitySuperExposeCityChoseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f13889a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final RecyclerView f;

    @NonNull
    public final RelativeLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final RelativeLayout j;

    @NonNull
    public final FrameLayout k;

    public ActivitySuperExposeCityChoseBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, RelativeLayout relativeLayout, TextView textView4, TextView textView5, RelativeLayout relativeLayout2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f13889a = imageView;
        this.b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = recyclerView;
        this.g = relativeLayout;
        this.h = textView4;
        this.i = textView5;
        this.j = relativeLayout2;
        this.k = frameLayout;
    }

    @NonNull
    public static ActivitySuperExposeCityChoseBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySuperExposeCityChoseBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySuperExposeCityChoseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_expose_city_chose, null, false, obj);
    }
}
