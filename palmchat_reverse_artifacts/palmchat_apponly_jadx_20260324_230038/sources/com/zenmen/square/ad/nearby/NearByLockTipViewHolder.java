package com.zenmen.square.ad.nearby;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.databinding.SquareNearbyUnlockItemTipBinding;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.iu3;
import defpackage.ju3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByLockTipViewHolder extends BaseViewHolder<NearByBean, SquareNearbyUnlockItemTipBinding, iu3> {
    public NearByLockTipViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        SquareNearbyUnlockItemTipBinding squareNearbyUnlockItemTipBindingB = SquareNearbyUnlockItemTipBinding.b(LayoutInflater.from(this.itemView.getContext()));
        this.d = squareNearbyUnlockItemTipBindingB;
        ((ViewGroup) this.itemView).addView(squareNearbyUnlockItemTipBindingB.getRoot(), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        ((SquareNearbyUnlockItemTipBinding) this.d).f16242a.setText(ju3.l().f17359a);
    }
}
