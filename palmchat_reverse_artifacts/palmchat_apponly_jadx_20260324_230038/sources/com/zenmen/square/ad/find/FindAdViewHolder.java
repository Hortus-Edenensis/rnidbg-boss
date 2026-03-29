package com.zenmen.square.ad.find;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.databinding.LayoutPraiseFootViewBinding;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.b6;
import defpackage.iu3;
import defpackage.pv1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FindAdViewHolder extends BaseViewHolder<NearByBean, LayoutPraiseFootViewBinding, iu3> {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByBean f16176a;
        public final /* synthetic */ pv1 b;

        public a(NearByBean nearByBean, pv1 pv1Var) {
            this.f16176a = nearByBean;
            this.b = pv1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FindAdViewHolder.this.e == null) {
                return;
            }
            ((iu3) FindAdViewHolder.this.e).A(this.f16176a);
            this.b.m();
        }
    }

    public FindAdViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        pv1 pv1Var = nearByBean.adItem;
        if (pv1Var == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.itemView;
        View viewF = pv1Var.f(viewGroup.getContext(), new a(nearByBean, pv1Var));
        if (b6.d()) {
            if (viewF == null || !r(viewF)) {
                return;
            }
        } else if (!r(viewF)) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(viewF, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean r(View view) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return true;
        }
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        ((ViewGroup) parent).removeView(view);
        return true;
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
    }
}
