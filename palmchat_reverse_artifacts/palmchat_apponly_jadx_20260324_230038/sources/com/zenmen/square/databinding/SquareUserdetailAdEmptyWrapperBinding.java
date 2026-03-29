package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareUserdetailAdEmptyWrapperBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16244a;

    @NonNull
    public final FrameLayout b;

    public SquareUserdetailAdEmptyWrapperBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f16244a = textView;
        this.b = frameLayout;
    }
}
