package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
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
public abstract class LovematchPopNewMsgBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EffectiveShapeView f13912a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    public LovematchPopNewMsgBinding(Object obj, View view, int i, EffectiveShapeView effectiveShapeView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4) {
        super(obj, view, i);
        this.f13912a = effectiveShapeView;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = imageView2;
        this.g = textView4;
    }

    @NonNull
    public static LovematchPopNewMsgBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LovematchPopNewMsgBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LovematchPopNewMsgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lovematch_pop_new_msg, null, false, obj);
    }
}
