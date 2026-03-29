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
public abstract class UserTrackFooterViewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13916a;

    public UserTrackFooterViewBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f13916a = textView;
    }

    @NonNull
    public static UserTrackFooterViewBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static UserTrackFooterViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (UserTrackFooterViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.user_track_footer_view, viewGroup, z, obj);
    }
}
