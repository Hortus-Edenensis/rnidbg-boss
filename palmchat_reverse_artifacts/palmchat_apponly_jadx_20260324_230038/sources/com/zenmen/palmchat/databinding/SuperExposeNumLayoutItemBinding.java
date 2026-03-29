package com.zenmen.palmchat.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler.SuperExposeTabRecyclerItemLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class SuperExposeNumLayoutItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f13915a;

    @NonNull
    public final TextView b;

    @NonNull
    public final EffectiveShapeView c;

    @NonNull
    public final SuperExposeTabRecyclerItemLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final View i;

    @NonNull
    public final View j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final LinearLayout m;

    public SuperExposeNumLayoutItemBinding(Object obj, View view, int i, TextView textView, TextView textView2, EffectiveShapeView effectiveShapeView, SuperExposeTabRecyclerItemLayout superExposeTabRecyclerItemLayout, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, View view2, View view3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.f13915a = textView;
        this.b = textView2;
        this.c = effectiveShapeView;
        this.d = superExposeTabRecyclerItemLayout;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = linearLayout;
        this.i = view2;
        this.j = view3;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = linearLayout4;
    }
}
