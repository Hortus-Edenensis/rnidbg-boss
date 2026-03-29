package com.zenmen.square.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.show.DYPageIndicator;
import com.zenmen.square.show.FeedShowDetailFragment;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.LoopingSquareHackyViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareShowMediaViewBinding extends ViewDataBinding {

    @NonNull
    public final TextView A;

    @NonNull
    public final ExpandableTextView B;

    @NonNull
    public final ExpandableTextView C;

    @NonNull
    public final TextView E;

    @NonNull
    public final TextView F;

    @NonNull
    public final TextView G;

    @NonNull
    public final TextView H;

    @NonNull
    public final TextView I;

    @NonNull
    public final TextView J;

    @NonNull
    public final TextView K;

    @NonNull
    public final TextView L;

    @NonNull
    public final TextView M;

    @NonNull
    public final TextView N;

    @NonNull
    public final TextView O;

    @NonNull
    public final DoubleClickView P;

    @Bindable
    public SquareFeed Q;

    @Bindable
    public FeedShowDetailFragment R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final DYPageIndicator f16235a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final LoopingSquareHackyViewPager f;

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
    public final LinearLayout r;

    @NonNull
    public final LinearLayout s;

    @NonNull
    public final ConstraintLayout t;

    @NonNull
    public final ConstraintLayout u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final ConstraintLayout w;

    @NonNull
    public final RelativeLayout x;

    @NonNull
    public final RelativeLayout y;

    @NonNull
    public final ConstraintLayout z;

    public LayoutSquareShowMediaViewBinding(Object obj, View view, int i, DYPageIndicator dYPageIndicator, ImageView imageView, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, LinearLayout linearLayout, LoopingSquareHackyViewPager loopingSquareHackyViewPager, EffectiveShapeView effectiveShapeView, RelativeLayout relativeLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout4, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ConstraintLayout constraintLayout5, TextView textView, ExpandableTextView expandableTextView, ExpandableTextView expandableTextView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, DoubleClickView doubleClickView) {
        super(obj, view, i);
        this.f16235a = dYPageIndicator;
        this.b = imageView;
        this.c = constraintLayout;
        this.d = relativeLayout;
        this.e = linearLayout;
        this.f = loopingSquareHackyViewPager;
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
        this.r = linearLayout2;
        this.s = linearLayout3;
        this.t = constraintLayout2;
        this.u = constraintLayout3;
        this.v = linearLayout4;
        this.w = constraintLayout4;
        this.x = relativeLayout3;
        this.y = relativeLayout4;
        this.z = constraintLayout5;
        this.A = textView;
        this.B = expandableTextView;
        this.C = expandableTextView2;
        this.E = textView2;
        this.F = textView3;
        this.G = textView4;
        this.H = textView5;
        this.I = textView6;
        this.J = textView7;
        this.K = textView8;
        this.L = textView9;
        this.M = textView10;
        this.N = textView11;
        this.O = textView12;
        this.P = doubleClickView;
    }

    @Nullable
    public SquareFeed o() {
        return this.Q;
    }

    public abstract void p(@Nullable SquareFeed squareFeed);

    public abstract void q(@Nullable FeedShowDetailFragment feedShowDetailFragment);
}
