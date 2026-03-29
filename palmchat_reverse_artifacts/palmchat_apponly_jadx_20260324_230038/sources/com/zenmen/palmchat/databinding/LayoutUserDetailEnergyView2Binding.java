package com.zenmen.palmchat.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutUserDetailEnergyView2Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LightingAnimationView f13905a;

    @NonNull
    public final TextView b;

    @NonNull
    public final ProgressBar c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final LinearLayout g;

    public LayoutUserDetailEnergyView2Binding(Object obj, View view, int i, LightingAnimationView lightingAnimationView, TextView textView, ProgressBar progressBar, LinearLayout linearLayout, TextView textView2, ConstraintLayout constraintLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f13905a = lightingAnimationView;
        this.b = textView;
        this.c = progressBar;
        this.d = linearLayout;
        this.e = textView2;
        this.f = constraintLayout;
        this.g = linearLayout2;
    }
}
