package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.lxviewswitcher.CustomLoopingViewSwitcher;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SquareVoiceMatchGuideBubbleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f16249a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final CustomLoopingViewSwitcher c;

    @NonNull
    public final TextView d;

    @NonNull
    public final FrameLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public SquareVoiceMatchGuideBubbleBinding(Object obj, View view, int i, RelativeLayout relativeLayout, LinearLayout linearLayout, CustomLoopingViewSwitcher customLoopingViewSwitcher, TextView textView, FrameLayout frameLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f16249a = relativeLayout;
        this.b = linearLayout;
        this.c = customLoopingViewSwitcher;
        this.d = textView;
        this.e = frameLayout;
        this.f = textView2;
        this.g = textView3;
    }

    public static SquareVoiceMatchGuideBubbleBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SquareVoiceMatchGuideBubbleBinding c(@NonNull View view, @Nullable Object obj) {
        return (SquareVoiceMatchGuideBubbleBinding) ViewDataBinding.bind(obj, view, R$layout.square_voice_match_guide_bubble);
    }
}
