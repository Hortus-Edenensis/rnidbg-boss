package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class NewPeopleMatchLikedLoadingFooterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13913a;

    @NonNull
    public final TextView b;

    @NonNull
    public final LinearLayout c;

    public NewPeopleMatchLikedLoadingFooterBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f13913a = textView;
        this.b = textView2;
        this.c = linearLayout;
    }

    @NonNull
    public static NewPeopleMatchLikedLoadingFooterBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static NewPeopleMatchLikedLoadingFooterBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (NewPeopleMatchLikedLoadingFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_people_match_liked_loading_footer, viewGroup, z, obj);
    }
}
