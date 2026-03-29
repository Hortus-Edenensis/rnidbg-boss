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
import com.zenmen.palmchat.framework.bridge.voicomatch.MatchPropInfoCardView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutVoiceMatchPanelBinding extends ViewDataBinding {

    @NonNull
    public final TextView A;

    @NonNull
    public final FrameLayout B;

    @NonNull
    public final TextView C;

    @NonNull
    public final MatchPropInfoCardView E;

    @NonNull
    public final LinearLayout F;

    @NonNull
    public final LinearLayout G;

    @NonNull
    public final TextView H;

    @NonNull
    public final SVGAImageView I;

    @NonNull
    public final RelativeLayout J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13908a;

    @NonNull
    public final TextView b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LightingAnimationView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final RelativeLayout n;

    @NonNull
    public final TextView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final TextView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final LinearLayout w;

    @NonNull
    public final ImageView x;

    @NonNull
    public final EffectiveShapeView y;

    @NonNull
    public final LinearLayout z;

    public LayoutVoiceMatchPanelBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, LightingAnimationView lightingAnimationView, TextView textView3, LinearLayout linearLayout2, ImageView imageView, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2, TextView textView7, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView8, ImageView imageView3, ImageView imageView4, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, LinearLayout linearLayout4, ImageView imageView5, EffectiveShapeView effectiveShapeView, LinearLayout linearLayout5, TextView textView14, FrameLayout frameLayout, TextView textView15, MatchPropInfoCardView matchPropInfoCardView, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView16, SVGAImageView sVGAImageView, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.f13908a = textView;
        this.b = textView2;
        this.c = linearLayout;
        this.d = lightingAnimationView;
        this.e = textView3;
        this.f = linearLayout2;
        this.g = imageView;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
        this.k = imageView2;
        this.l = textView7;
        this.m = linearLayout3;
        this.n = relativeLayout;
        this.o = textView8;
        this.p = imageView3;
        this.q = imageView4;
        this.r = textView9;
        this.s = textView10;
        this.t = textView11;
        this.u = textView12;
        this.v = textView13;
        this.w = linearLayout4;
        this.x = imageView5;
        this.y = effectiveShapeView;
        this.z = linearLayout5;
        this.A = textView14;
        this.B = frameLayout;
        this.C = textView15;
        this.E = matchPropInfoCardView;
        this.F = linearLayout6;
        this.G = linearLayout7;
        this.H = textView16;
        this.I = sVGAImageView;
        this.J = relativeLayout2;
    }

    @NonNull
    public static LayoutVoiceMatchPanelBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutVoiceMatchPanelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutVoiceMatchPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_voice_match_panel, null, false, obj);
    }
}
