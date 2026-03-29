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
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentContentsLayout;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.SquareItemVideoView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FeedLayoutItemViewBinding extends ViewDataBinding {

    @NonNull
    public final RelativeLayout A;

    @NonNull
    public final RelativeLayout B;

    @NonNull
    public final RelativeLayout C;

    @NonNull
    public final RelativeLayout E;

    @NonNull
    public final TextView F;

    @NonNull
    public final TextView G;

    @NonNull
    public final ExpandableTextView H;

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
    public final LeftDrawableText U;

    @NonNull
    public final LeftDrawableText V;

    @NonNull
    public final TextView W;

    @Bindable
    public SquareFeed X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f16221a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final LXPortraitView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final FeedItemMultiPicView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final FeedItemVenusView m;

    @NonNull
    public final SquareItemVideoView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final RelativeLayout r;

    @NonNull
    public final CommentContentsLayout s;

    @NonNull
    public final RelativeLayout t;

    @NonNull
    public final RelativeLayout u;

    @NonNull
    public final ConstraintLayout v;

    @NonNull
    public final LinearLayout w;

    @NonNull
    public final LinearLayout x;

    @NonNull
    public final ConstraintLayout y;

    @NonNull
    public final RelativeLayout z;

    public FeedLayoutItemViewBinding(Object obj, View view, int i, View view2, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LXPortraitView lXPortraitView, ImageView imageView6, ImageView imageView7, FeedItemMultiPicView feedItemMultiPicView, ImageView imageView8, FeedItemVenusView feedItemVenusView, SquareItemVideoView squareItemVideoView, ImageView imageView9, ImageView imageView10, ImageView imageView11, RelativeLayout relativeLayout, CommentContentsLayout commentContentsLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, TextView textView, TextView textView2, ExpandableTextView expandableTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, LeftDrawableText leftDrawableText, LeftDrawableText leftDrawableText2, TextView textView15) {
        super(obj, view, i);
        this.f16221a = view2;
        this.b = imageView;
        this.c = constraintLayout;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = lXPortraitView;
        this.i = imageView6;
        this.j = imageView7;
        this.k = feedItemMultiPicView;
        this.l = imageView8;
        this.m = feedItemVenusView;
        this.n = squareItemVideoView;
        this.o = imageView9;
        this.p = imageView10;
        this.q = imageView11;
        this.r = relativeLayout;
        this.s = commentContentsLayout;
        this.t = relativeLayout2;
        this.u = relativeLayout3;
        this.v = constraintLayout2;
        this.w = linearLayout;
        this.x = linearLayout2;
        this.y = constraintLayout3;
        this.z = relativeLayout4;
        this.A = relativeLayout5;
        this.B = relativeLayout6;
        this.C = relativeLayout7;
        this.E = relativeLayout8;
        this.F = textView;
        this.G = textView2;
        this.H = expandableTextView;
        this.I = textView3;
        this.J = textView4;
        this.K = textView5;
        this.L = textView6;
        this.M = textView7;
        this.N = textView8;
        this.O = textView9;
        this.P = textView10;
        this.Q = textView11;
        this.R = textView12;
        this.S = textView13;
        this.T = textView14;
        this.U = leftDrawableText;
        this.V = leftDrawableText2;
        this.W = textView15;
    }

    @Nullable
    public SquareFeed o() {
        return this.X;
    }

    public abstract void p(@Nullable SquareFeed squareFeed);
}
