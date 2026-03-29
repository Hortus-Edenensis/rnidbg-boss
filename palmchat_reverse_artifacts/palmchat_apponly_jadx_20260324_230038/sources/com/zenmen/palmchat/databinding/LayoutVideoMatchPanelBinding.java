package com.zenmen.palmchat.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
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
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.bridge.voicomatch.MatchPropInfoCardView;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LayoutVideoMatchPanelBinding extends ViewDataBinding {

    @NonNull
    public final ImageView A;

    @NonNull
    public final LinearLayout B;

    @NonNull
    public final TextView C;

    @NonNull
    public final FrameLayout E;

    @NonNull
    public final TextView F;

    @NonNull
    public final MatchPropInfoCardView G;

    @NonNull
    public final LinearLayout H;

    @NonNull
    public final TextureView I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LightingAnimationView f13907a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final RelativeLayout p;

    @NonNull
    public final TextView q;

    @NonNull
    public final ImageView r;

    @NonNull
    public final ImageView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final TextView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final TextView w;

    @NonNull
    public final TextView x;

    @NonNull
    public final LinearLayout y;

    @NonNull
    public final ImageView z;

    public LayoutVideoMatchPanelBinding(Object obj, View view, int i, LightingAnimationView lightingAnimationView, FrameLayout frameLayout, TextView textView, TextView textView2, LinearLayout linearLayout, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, ImageView imageView2, LinearLayout linearLayout2, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView9, ImageView imageView3, ImageView imageView4, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, LinearLayout linearLayout4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout5, TextView textView15, FrameLayout frameLayout2, TextView textView16, MatchPropInfoCardView matchPropInfoCardView, LinearLayout linearLayout6, TextureView textureView) {
        super(obj, view, i);
        this.f13907a = lightingAnimationView;
        this.b = frameLayout;
        this.c = textView;
        this.d = textView2;
        this.e = linearLayout;
        this.f = imageView;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = imageView2;
        this.k = linearLayout2;
        this.l = textView6;
        this.m = textView7;
        this.n = textView8;
        this.o = linearLayout3;
        this.p = relativeLayout;
        this.q = textView9;
        this.r = imageView3;
        this.s = imageView4;
        this.t = textView10;
        this.u = textView11;
        this.v = textView12;
        this.w = textView13;
        this.x = textView14;
        this.y = linearLayout4;
        this.z = imageView5;
        this.A = imageView6;
        this.B = linearLayout5;
        this.C = textView15;
        this.E = frameLayout2;
        this.F = textView16;
        this.G = matchPropInfoCardView;
        this.H = linearLayout6;
        this.I = textureView;
    }

    @NonNull
    public static LayoutVideoMatchPanelBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutVideoMatchPanelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutVideoMatchPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_video_match_panel, null, false, obj);
    }
}
