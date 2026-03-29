package com.zenmen.square.mvp.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.listui.list.a;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.LayoutPraiseFootViewBinding;
import com.zenmen.square.mvp.model.bean.PraiseBean;
import com.zenmen.square.mvp.model.bean.SquareBean;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FootViewHolder extends BaseViewHolder<SquareBean, LayoutPraiseFootViewBinding, a> implements View.OnClickListener {
    public boolean f;

    public FootViewHolder(View view) {
        super(view);
        this.f = false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_praise_foot_view, (ViewGroup) this.itemView, false);
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutPraiseFootViewBinding) Inflate).getRoot());
        this.itemView.setOnClickListener(this);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareBean squareBean, int i) {
        int iO;
        this.f = false;
        ((LayoutPraiseFootViewBinding) this.d).b(squareBean);
        ((LayoutPraiseFootViewBinding) this.d).executePendingBindings();
        P p = this.e;
        if ((p instanceof zt1) && ((iO = ((zt1) p).o()) == 6 || iO == 7)) {
            this.itemView.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = ((LayoutPraiseFootViewBinding) this.d).getRoot().getLayoutParams();
            layoutParams.height = 1;
            ((LayoutPraiseFootViewBinding) this.d).getRoot().setLayoutParams(layoutParams);
        }
        ((LayoutPraiseFootViewBinding) this.d).f16224a.setText(squareBean.bottomTips);
        if (squareBean instanceof PraiseBean) {
            this.f = ((PraiseBean) squareBean).hasMore;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.itemView && this.f) {
            ((a) this.e).j();
        }
    }
}
