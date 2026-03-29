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
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.palmchat.R;
import com.zenmen.square.ui.widget.ListStateView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class FragmentTrackCommonBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13898a;

    @NonNull
    public final SmartRefreshLayout b;

    @NonNull
    public final ListStateView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    public FragmentTrackCommonBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ListStateView listStateView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f13898a = recyclerView;
        this.b = smartRefreshLayout;
        this.c = listStateView;
        this.d = textView;
        this.e = linearLayout;
    }

    @NonNull
    public static FragmentTrackCommonBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentTrackCommonBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentTrackCommonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_track_common, viewGroup, z, obj);
    }
}
