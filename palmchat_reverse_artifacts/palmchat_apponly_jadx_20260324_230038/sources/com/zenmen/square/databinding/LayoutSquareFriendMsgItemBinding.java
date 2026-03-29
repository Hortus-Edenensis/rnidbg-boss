package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.mvp.holder.FriendMessageViewHolder;
import com.zenmen.square.mvp.model.bean.PlaceFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareFriendMsgItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f16228a;

    @NonNull
    public final RelativeLayout b;

    @NonNull
    public final EffectiveShapeView c;

    @NonNull
    public final EffectiveShapeView d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

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
    public final ImageView m;

    @Bindable
    public PlaceFeed n;

    @Bindable
    public FriendMessageViewHolder o;

    public LayoutSquareFriendMsgItemBinding(Object obj, View view, int i, FrameLayout frameLayout, RelativeLayout relativeLayout, EffectiveShapeView effectiveShapeView, EffectiveShapeView effectiveShapeView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView) {
        super(obj, view, i);
        this.f16228a = frameLayout;
        this.b = relativeLayout;
        this.c = effectiveShapeView;
        this.d = effectiveShapeView2;
        this.e = constraintLayout;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
        this.l = textView7;
        this.m = imageView;
    }

    @Nullable
    public PlaceFeed o() {
        return this.n;
    }

    public abstract void p(@Nullable PlaceFeed placeFeed);

    public abstract void q(@Nullable FriendMessageViewHolder friendMessageViewHolder);
}
