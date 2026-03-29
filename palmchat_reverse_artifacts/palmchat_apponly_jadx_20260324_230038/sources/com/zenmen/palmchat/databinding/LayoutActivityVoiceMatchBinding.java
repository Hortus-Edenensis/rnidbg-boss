package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.MarqueeTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutActivityVoiceMatchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f13902a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final RelativeLayout f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final SVGAImageView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final RelativeLayout m;

    @NonNull
    public final MarqueeTextView n;

    @NonNull
    public final FrameLayout o;

    @NonNull
    public final FrameLayout p;

    @NonNull
    public final FrameLayout q;

    public LayoutActivityVoiceMatchBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, RelativeLayout relativeLayout3, ImageView imageView2, SVGAImageView sVGAImageView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout4, MarqueeTextView marqueeTextView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        super(obj, view, i);
        this.f13902a = imageView;
        this.b = linearLayout;
        this.c = relativeLayout;
        this.d = relativeLayout2;
        this.e = textView;
        this.f = relativeLayout3;
        this.g = imageView2;
        this.h = sVGAImageView;
        this.i = linearLayout2;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = relativeLayout4;
        this.n = marqueeTextView;
        this.o = frameLayout;
        this.p = frameLayout2;
        this.q = frameLayout3;
    }

    @NonNull
    public static LayoutActivityVoiceMatchBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutActivityVoiceMatchBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutActivityVoiceMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_activity_voice_match, null, false, obj);
    }
}
