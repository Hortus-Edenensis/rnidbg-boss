package com.zenmen.square.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.mvp.model.bean.SquareFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareNestTopicFeedItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f16234a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final EffectiveShapeView c;

    @NonNull
    public final LeftDrawableText d;

    @NonNull
    public final View e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final AppCompatTextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @Bindable
    public SquareFeed l;

    public LayoutSquareNestTopicFeedItemBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, EffectiveShapeView effectiveShapeView, LeftDrawableText leftDrawableText, View view2, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, AppCompatTextView appCompatTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f16234a = relativeLayout;
        this.b = imageView;
        this.c = effectiveShapeView;
        this.d = leftDrawableText;
        this.e = view2;
        this.f = constraintLayout;
        this.g = imageView2;
        this.h = imageView3;
        this.i = appCompatTextView;
        this.j = textView;
        this.k = textView2;
    }

    @Nullable
    public SquareFeed o() {
        return this.l;
    }

    public abstract void p(@Nullable SquareFeed squareFeed);
}
