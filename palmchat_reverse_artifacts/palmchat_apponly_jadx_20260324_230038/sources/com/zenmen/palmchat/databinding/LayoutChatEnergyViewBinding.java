package com.zenmen.palmchat.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutChatEnergyViewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13903a;

    @NonNull
    public final ProgressBar b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final LinearLayout d;

    public LayoutChatEnergyViewBinding(Object obj, View view, int i, TextView textView, ProgressBar progressBar, ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f13903a = textView;
        this.b = progressBar;
        this.c = constraintLayout;
        this.d = linearLayout;
    }
}
