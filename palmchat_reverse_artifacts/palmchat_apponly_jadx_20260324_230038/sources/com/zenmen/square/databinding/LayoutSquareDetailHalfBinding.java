package com.zenmen.square.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.comment.ui.CommentListView;
import com.zenmen.square.comment.widget.RichTextView;
import com.zenmen.square.comment.widget.VideoTabLoadingView;
import defpackage.sl2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareDetailHalfBinding extends ViewDataBinding {

    @NonNull
    public final TextView A;

    @NonNull
    public final VideoTabLoadingView B;

    @NonNull
    public final ImageView C;

    @NonNull
    public final LinearLayout E;

    @NonNull
    public final ImageView F;

    @NonNull
    public final TextView G;

    @NonNull
    public final TextView H;

    @Bindable
    public ISupperFeedBean I;

    @Bindable
    public sl2 J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f16226a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final CommentListView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RichTextView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final EffectiveShapeView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final FrameLayout n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final LinearLayout p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final RelativeLayout s;

    @NonNull
    public final ImageView t;

    @NonNull
    public final FrameLayout u;

    @NonNull
    public final ConstraintLayout v;

    @NonNull
    public final Toolbar w;

    @NonNull
    public final TextView x;

    @NonNull
    public final TextView y;

    @NonNull
    public final TextView z;

    public LayoutSquareDetailHalfBinding(Object obj, View view, int i, TextView textView, ImageView imageView, CommentListView commentListView, TextView textView2, RichTextView richTextView, ConstraintLayout constraintLayout, LinearLayout linearLayout, EffectiveShapeView effectiveShapeView, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, FrameLayout frameLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView6, TextView textView3, RelativeLayout relativeLayout, ImageView imageView7, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, Toolbar toolbar, TextView textView4, TextView textView5, TextView textView6, TextView textView7, VideoTabLoadingView videoTabLoadingView, ImageView imageView8, LinearLayout linearLayout5, ImageView imageView9, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.f16226a = textView;
        this.b = imageView;
        this.c = commentListView;
        this.d = textView2;
        this.e = richTextView;
        this.f = constraintLayout;
        this.g = linearLayout;
        this.h = effectiveShapeView;
        this.i = linearLayout2;
        this.j = imageView2;
        this.k = imageView3;
        this.l = imageView4;
        this.m = imageView5;
        this.n = frameLayout;
        this.o = linearLayout3;
        this.p = linearLayout4;
        this.q = imageView6;
        this.r = textView3;
        this.s = relativeLayout;
        this.t = imageView7;
        this.u = frameLayout2;
        this.v = constraintLayout2;
        this.w = toolbar;
        this.x = textView4;
        this.y = textView5;
        this.z = textView6;
        this.A = textView7;
        this.B = videoTabLoadingView;
        this.C = imageView8;
        this.E = linearLayout5;
        this.F = imageView9;
        this.G = textView8;
        this.H = textView9;
    }

    @Nullable
    public ISupperFeedBean o() {
        return this.I;
    }

    public abstract void p(@Nullable sl2 sl2Var);

    public abstract void q(@Nullable ISupperFeedBean iSupperFeedBean);
}
