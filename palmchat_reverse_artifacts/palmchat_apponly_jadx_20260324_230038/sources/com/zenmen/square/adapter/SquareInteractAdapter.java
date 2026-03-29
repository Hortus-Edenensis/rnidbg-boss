package com.zenmen.square.adapter;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.mvp.holder.FootViewHolder;
import com.zenmen.square.mvp.holder.SquareHeaderViewHolder;
import com.zenmen.square.mvp.holder.SquareInteractViewHolder;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import defpackage.yi5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareInteractAdapter extends BaseRecyclerAdapter<BaseViewHolder, SquareInteractBean, yi5> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        BaseViewHolder squareHeaderViewHolder = i == 3 ? new SquareHeaderViewHolder(relativeLayout) : i == 1 ? new FootViewHolder(relativeLayout) : new SquareInteractViewHolder(relativeLayout);
        squareHeaderViewHolder.n(this.f);
        return squareHeaderViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (((SquareInteractBean) this.e.get(i)).squareUserPostStatisticsBean != null) {
            return 3;
        }
        return ((SquareInteractBean) this.e.get(i)).isBottomTip() ? 1 : 2;
    }
}
