package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ActivitySuperExposeCityChoseLabelItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13890a;

    @NonNull
    public final TextView b;

    public ActivitySuperExposeCityChoseLabelItemBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f13890a = textView;
        this.b = textView2;
    }

    @NonNull
    public static ActivitySuperExposeCityChoseLabelItemBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySuperExposeCityChoseLabelItemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySuperExposeCityChoseLabelItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_expose_city_chose_label_item, viewGroup, z, obj);
    }
}
