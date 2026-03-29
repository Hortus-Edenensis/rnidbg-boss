package com.zenmen.square.mvp.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.listui.list.a;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.LayoutSquareListDividerTiltleBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareDividerViewHolder extends BaseViewHolder<SquareFeed, LayoutSquareListDividerTiltleBinding, a> {
    public SquareDividerViewHolder(View view) {
        super(view);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_list_divider_tiltle, (ViewGroup) this.itemView, false);
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareListDividerTiltleBinding) Inflate).getRoot());
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        ((LayoutSquareListDividerTiltleBinding) this.d).b(squareFeed);
        ((LayoutSquareListDividerTiltleBinding) this.d).executePendingBindings();
    }
}
