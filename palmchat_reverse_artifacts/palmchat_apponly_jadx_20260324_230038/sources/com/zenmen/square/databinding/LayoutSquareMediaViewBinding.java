package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.MSVGAImageView;
import com.zenmen.square.fragment.FeedDetailFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareMediaViewBinding extends ViewDataBinding {

    @NonNull
    public final LinearLayout A;

    @NonNull
    public final ConstraintLayout B;

    @NonNull
    public final RelativeLayout C;

    @NonNull
    public final RelativeLayout E;

    @NonNull
    public final FrameLayout F;

    @NonNull
    public final MSVGAImageView G;

    @NonNull
    public final SVGAImageView H;

    @NonNull
    public final ConstraintLayout I;

    @NonNull
    public final TextView J;

    @NonNull
    public final ExpandableTextView K;

    @NonNull
    public final ExpandableTextView L;

    @NonNull
    public final TextView M;

    @NonNull
    public final TextView N;

    @NonNull
    public final TextView O;

    @NonNull
    public final TextView P;

    @NonNull
    public final TextView Q;

    @NonNull
    public final TextView R;

    @NonNull
    public final TextView S;

    @NonNull
    public final TextView T;

    @NonNull
    public final TextView U;

    @NonNull
    public final TextView V;

    @NonNull
    public final TextView W;

    @NonNull
    public final TextView X;

    @NonNull
    public final TextView Y;

    @NonNull
    public final DoubleClickView Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f16232a;

    @NonNull
    public final TextView b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final LinearLayout e;

    @Bindable
    public SquareFeed e0;

    @NonNull
    public final SquareHackyViewPager f;

    @Bindable
    public FeedDetailFragment f0;

    @NonNull
    public final EffectiveShapeView g;

    @NonNull
    public final RelativeLayout h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final ImageView r;

    @NonNull
    public final FrameLayout s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final LinearLayout u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final ConstraintLayout w;

    @NonNull
    public final LinearLayout x;

    @NonNull
    public final LinearLayout y;

    @NonNull
    public final ConstraintLayout z;

    public LayoutSquareMediaViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, LinearLayout linearLayout, SquareHackyViewPager squareHackyViewPager, EffectiveShapeView effectiveShapeView, RelativeLayout relativeLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, LinearLayout linearLayout5, LinearLayout linearLayout6, ConstraintLayout constraintLayout3, LinearLayout linearLayout7, ConstraintLayout constraintLayout4, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, FrameLayout frameLayout2, MSVGAImageView mSVGAImageView, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout5, TextView textView2, ExpandableTextView expandableTextView, ExpandableTextView expandableTextView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, DoubleClickView doubleClickView) {
        super(obj, view, i);
        this.f16232a = imageView;
        this.b = textView;
        this.c = constraintLayout;
        this.d = relativeLayout;
        this.e = linearLayout;
        this.f = squareHackyViewPager;
        this.g = effectiveShapeView;
        this.h = relativeLayout2;
        this.i = imageView2;
        this.j = imageView3;
        this.k = imageView4;
        this.l = imageView5;
        this.m = imageView6;
        this.n = imageView7;
        this.o = imageView8;
        this.p = imageView9;
        this.q = imageView10;
        this.r = imageView11;
        this.s = frameLayout;
        this.t = linearLayout2;
        this.u = linearLayout3;
        this.v = linearLayout4;
        this.w = constraintLayout2;
        this.x = linearLayout5;
        this.y = linearLayout6;
        this.z = constraintLayout3;
        this.A = linearLayout7;
        this.B = constraintLayout4;
        this.C = relativeLayout3;
        this.E = relativeLayout4;
        this.F = frameLayout2;
        this.G = mSVGAImageView;
        this.H = sVGAImageView;
        this.I = constraintLayout5;
        this.J = textView2;
        this.K = expandableTextView;
        this.L = expandableTextView2;
        this.M = textView3;
        this.N = textView4;
        this.O = textView5;
        this.P = textView6;
        this.Q = textView7;
        this.R = textView8;
        this.S = textView9;
        this.T = textView10;
        this.U = textView11;
        this.V = textView12;
        this.W = textView13;
        this.X = textView14;
        this.Y = textView15;
        this.Z = doubleClickView;
    }

    @Nullable
    public SquareFeed o() {
        return this.e0;
    }

    public abstract void p(@Nullable FeedDetailFragment feedDetailFragment);

    public abstract void q(@Nullable SquareFeed squareFeed);
}
