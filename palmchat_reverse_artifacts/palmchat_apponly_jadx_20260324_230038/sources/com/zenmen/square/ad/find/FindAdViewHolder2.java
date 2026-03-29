package com.zenmen.square.ad.find;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.databinding.LayoutPraiseFootViewBinding;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.b6;
import defpackage.ev3;
import defpackage.iu3;
import defpackage.iv3;
import defpackage.nv3;
import defpackage.on2;
import defpackage.pv1;
import defpackage.rv1;
import defpackage.vv1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FindAdViewHolder2 extends BaseViewHolder<NearByBean, LayoutPraiseFootViewBinding, iu3> {
    public int f;
    public boolean g;
    public int h;
    public NearByBean i;
    public pv1 j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            LogUtil.d("FindAdSJManager", "onViewAttachedToWindow adViewHolder " + FindAdViewHolder2.this + " itemView " + FindAdViewHolder2.this.itemView);
            FindAdViewHolder2.this.g = true;
            rv1.b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
            LogUtil.d("FindAdSJManager", "onViewDetachedFromWindow adViewHolder " + FindAdViewHolder2.this + " itemView " + FindAdViewHolder2.this.itemView);
            FindAdViewHolder2.this.g = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements on2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16178a;

        public b(int i) {
            this.f16178a = i;
        }

        @Override // defpackage.on2
        public void a(int i, Object obj) {
            if (FindAdViewHolder2.this.e != null && (obj instanceof NearByBean)) {
                ((iu3) FindAdViewHolder2.this.e).A((NearByBean) obj);
                FindAdViewHolder2.this.j.m();
            }
        }

        @Override // defpackage.on2
        public void onAdClicked(NestAdData nestAdData) {
            vv1.a(nestAdData.getRequestId(), nestAdData, FindAdViewHolder2.this.j.i(), FindAdViewHolder2.this.j.h(), this.f16178a);
        }

        @Override // defpackage.on2
        public void onAdExposed(NestAdData nestAdData) {
            vv1.f(nestAdData.getRequestId(), nestAdData, FindAdViewHolder2.this.j.i(), FindAdViewHolder2.this.j.h(), this.f16178a);
        }
    }

    public FindAdViewHolder2(ViewGroup viewGroup, int i) {
        super(viewGroup);
        this.g = false;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.f = i;
        LogUtil.d("", "NativeType FindAdViewHolder2 start adView pageType " + this.f);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        NestAdData nestAdDataJ;
        this.h = i;
        this.i = nearByBean;
        this.j = nearByBean.adItem;
        LogUtil.d("", "NativeType FindAdViewHolder2 bind position " + i + " adData " + this.j);
        pv1 pv1Var = this.j;
        if (pv1Var == null || (nestAdDataJ = pv1Var.j()) == null) {
            return;
        }
        u(nestAdDataJ, 0);
        if (rv1.a()) {
            rv1.l(this, this.f);
            this.itemView.addOnAttachStateChangeListener(new a());
        }
    }

    public void s() {
        pv1 pv1Var;
        if (!b6.d() || (pv1Var = this.j) == null) {
            return;
        }
        pv1Var.l();
    }

    public final boolean t(View view) {
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

    public void u(NestAdData nestAdData, int i) {
        pv1 pv1Var;
        LogUtil.d("FindAdSJManager", "showAdUi adTabChange " + i + " adViewHolder " + this);
        if (nestAdData == null || (pv1Var = this.j) == null) {
            return;
        }
        iv3 iv3Var = new iv3(nestAdData.getAdScene(), nestAdData, new ev3(this.h, pv1Var.h() != null ? this.j.h().l() : 36, this.i, new b(i)));
        View viewD = nv3.d(iv3Var, this.itemView.getContext());
        if ((viewD instanceof ViewGroup) && t(viewD)) {
            ViewGroup viewGroup = (ViewGroup) this.itemView;
            viewGroup.removeAllViews();
            viewGroup.addView(viewD, new ViewGroup.LayoutParams(-1, -1));
            nv3.a(iv3Var, this.itemView.getContext(), (ViewGroup) viewD);
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
    }
}
