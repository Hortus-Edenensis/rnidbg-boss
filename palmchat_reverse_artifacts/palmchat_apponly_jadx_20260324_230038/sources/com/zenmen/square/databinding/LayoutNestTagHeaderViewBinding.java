package com.zenmen.square.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.NestTagInfoView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutNestTagHeaderViewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16223a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final EffectiveShapeView f;

    @NonNull
    public final NestTagInfoView g;

    @NonNull
    public final TextView h;

    @Bindable
    public SquareFeed i;

    public LayoutNestTagHeaderViewBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, EffectiveShapeView effectiveShapeView, NestTagInfoView nestTagInfoView, TextView textView5) {
        super(obj, view, i);
        this.f16223a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = imageView;
        this.e = textView4;
        this.f = effectiveShapeView;
        this.g = nestTagInfoView;
        this.h = textView5;
    }

    @Nullable
    public SquareFeed o() {
        return this.i;
    }

    public abstract void p(@Nullable SquareFeed squareFeed);
}
