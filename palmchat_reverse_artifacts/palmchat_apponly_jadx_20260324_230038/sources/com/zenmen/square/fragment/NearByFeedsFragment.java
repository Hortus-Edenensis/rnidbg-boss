package com.zenmen.square.fragment;

import com.zenmen.square.R$layout;
import com.zenmen.square.support.SquareSingleton;
import defpackage.au4;
import defpackage.cu3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFeedsFragment extends RecommendFeedsFragment {
    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.list.BaseListFragment
    public int Z() {
        return R$layout.layout_nearby_feeds_fragment;
    }

    @Override // com.zenmen.square.fragment.RecommendFeedsFragment, com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: b1 */
    public au4 c0() {
        if (this.k == 0) {
            this.k = new cu3("square.lbs.recommend.v1", o());
        }
        return (au4) this.k;
    }

    @Override // com.zenmen.square.fragment.RecommendFeedsFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 73;
    }

    @Override // com.zenmen.square.fragment.RecommendFeedsFragment, com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (SquareSingleton.getInstance().getMessageCountManager().l()) {
            x();
        }
    }
}
