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
public abstract class LayoutUserDetailEnergyViewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LightingAnimationView f13906a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ProgressBar d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final LinearLayout g;

    public LayoutUserDetailEnergyViewBinding(Object obj, View view, int i, LightingAnimationView lightingAnimationView, LinearLayout linearLayout, TextView textView, ProgressBar progressBar, TextView textView2, ConstraintLayout constraintLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f13906a = lightingAnimationView;
        this.b = linearLayout;
        this.c = textView;
        this.d = progressBar;
        this.e = textView2;
        this.f = constraintLayout;
        this.g = linearLayout2;
    }
}
