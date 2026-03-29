package com.zenmen.square.lxpager;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.o22;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LxFragmentViewHolder extends RecyclerView.ViewHolder {
    public o22 d;

    public LxFragmentViewHolder(@NonNull FrameLayout frameLayout) {
        super(frameLayout);
    }

    @NonNull
    public static LxFragmentViewHolder l(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new LxFragmentViewHolder(frameLayout);
    }

    @NonNull
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }

    public void m(BasePagerBean basePagerBean) {
        o22 o22Var = this.d;
        if (o22Var != null) {
            o22Var.m(getAdapterPosition(), basePagerBean);
        }
    }

    public void n() {
        SquareViewPager2 squareViewPager2;
        o22 o22Var = this.d;
        if (o22Var == null || (squareViewPager2 = o22Var.b) == null) {
            return;
        }
        squareViewPager2.getAdapter().notifyDataSetChanged();
    }

    public void o(BasePagerBean basePagerBean) {
        o22 o22Var = this.d;
        if (o22Var != null) {
            o22Var.p(basePagerBean);
        }
    }

    public void p(o22 o22Var) {
        this.d = o22Var;
    }

    public void q(BasePagerBean basePagerBean) {
        o22 o22Var = this.d;
        if (o22Var != null) {
            o22Var.B(getAdapterPosition(), basePagerBean);
        }
    }
}
