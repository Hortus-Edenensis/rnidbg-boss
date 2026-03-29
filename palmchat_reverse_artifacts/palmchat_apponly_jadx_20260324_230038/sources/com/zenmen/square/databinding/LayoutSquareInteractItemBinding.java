package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.mvp.holder.SquareInteractViewHolder;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.ui.widget.InteractNestImageContainer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareInteractItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f16229a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final HorizontalScrollView c;

    @NonNull
    public final EffectiveShapeView d;

    @NonNull
    public final EffectiveShapeView e;

    @NonNull
    public final InteractNestImageContainer f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final ImageView o;

    @Bindable
    public SquareInteractBean p;

    @Bindable
    public SquareInteractViewHolder q;

    public LayoutSquareInteractItemBinding(Object obj, View view, int i, FrameLayout frameLayout, RelativeLayout relativeLayout, HorizontalScrollView horizontalScrollView, EffectiveShapeView effectiveShapeView, EffectiveShapeView effectiveShapeView2, InteractNestImageContainer interactNestImageContainer, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView) {
        super(obj, view, i);
        this.f16229a = frameLayout;
        this.b = relativeLayout;
        this.c = horizontalScrollView;
        this.d = effectiveShapeView;
        this.e = effectiveShapeView2;
        this.f = interactNestImageContainer;
        this.g = constraintLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = textView6;
        this.n = textView7;
        this.o = imageView;
    }

    @Nullable
    public SquareInteractBean o() {
        return this.p;
    }

    public abstract void p(@Nullable SquareInteractBean squareInteractBean);

    public abstract void q(@Nullable SquareInteractViewHolder squareInteractViewHolder);
}
