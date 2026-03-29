package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareUserdetailAdListWrapperBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16247a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final LinearLayout c;

    public SquareUserdetailAdListWrapperBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f16247a = textView;
        this.b = frameLayout;
        this.c = linearLayout;
    }
}
