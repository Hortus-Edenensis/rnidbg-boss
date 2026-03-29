package com.zenmen.square.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareEmptyFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16227a;

    @Bindable
    public SquareFeed b;

    public LayoutSquareEmptyFriendBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f16227a = textView;
    }

    public abstract void b(@Nullable SquareFeed squareFeed);
}
