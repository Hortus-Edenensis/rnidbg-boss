package com.zenmen.square.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.fragment.MomentDetailFragment;
import com.zenmen.square.mvvm.MediaFriendViewModel;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.PageIndicatorView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutMomentsDetailFullBinding extends ViewDataBinding {

    @NonNull
    public final TextView A;

    @NonNull
    public final TextView B;

    @NonNull
    public final TextView C;

    @NonNull
    public final DoubleClickView E;

    @NonNull
    public final SquareHackyViewPager F;

    @Bindable
    public MediaFriendViewModel G;

    @Bindable
    public MomentDetailFragment H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16222a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final EffectiveShapeView f;

    @NonNull
    public final TextView g;

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
    public final LinearLayout n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final ConstraintLayout p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final RelativeLayout r;

    @NonNull
    public final PageIndicatorView s;

    @NonNull
    public final ProgressBar t;

    @NonNull
    public final ConstraintLayout u;

    @NonNull
    public final ConstraintLayout v;

    @NonNull
    public final LinearLayout w;

    @NonNull
    public final TextView x;

    @NonNull
    public final ClickShowMoreLayout y;

    @NonNull
    public final TextView z;

    public LayoutMomentsDetailFullBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, RelativeLayout relativeLayout, LinearLayout linearLayout, EffectiveShapeView effectiveShapeView, TextView textView3, RelativeLayout relativeLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout, LinearLayout linearLayout4, RelativeLayout relativeLayout3, PageIndicatorView pageIndicatorView, ProgressBar progressBar, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout5, TextView textView4, ClickShowMoreLayout clickShowMoreLayout, TextView textView5, TextView textView6, TextView textView7, TextView textView8, DoubleClickView doubleClickView, SquareHackyViewPager squareHackyViewPager) {
        super(obj, view, i);
        this.f16222a = textView;
        this.b = imageView;
        this.c = textView2;
        this.d = relativeLayout;
        this.e = linearLayout;
        this.f = effectiveShapeView;
        this.g = textView3;
        this.h = relativeLayout2;
        this.i = imageView2;
        this.j = imageView3;
        this.k = imageView4;
        this.l = imageView5;
        this.m = imageView6;
        this.n = linearLayout2;
        this.o = linearLayout3;
        this.p = constraintLayout;
        this.q = linearLayout4;
        this.r = relativeLayout3;
        this.s = pageIndicatorView;
        this.t = progressBar;
        this.u = constraintLayout2;
        this.v = constraintLayout3;
        this.w = linearLayout5;
        this.x = textView4;
        this.y = clickShowMoreLayout;
        this.z = textView5;
        this.A = textView6;
        this.B = textView7;
        this.C = textView8;
        this.E = doubleClickView;
        this.F = squareHackyViewPager;
    }

    public abstract void b(@Nullable MomentDetailFragment momentDetailFragment);

    public abstract void c(@Nullable MediaFriendViewModel mediaFriendViewModel);
}
