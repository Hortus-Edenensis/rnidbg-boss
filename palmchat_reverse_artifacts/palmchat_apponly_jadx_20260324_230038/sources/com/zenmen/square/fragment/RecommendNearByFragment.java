package com.zenmen.square.fragment;

import com.zenmen.find.ConditionHelper;
import com.zenmen.openapi.config.LxApiProxy;
import defpackage.gu3;
import defpackage.yv1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RecommendNearByFragment extends NearByFragment {
    public boolean y = LxApiProxy.getInstance().getConfigApi().b();

    @Override // com.zenmen.square.fragment.NearByFragment
    public boolean A0() {
        return true;
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public gu3 E0() {
        if (this.k == 0) {
            this.k = new yv1(o(), "lbs.square.friends.recommend.pull.v4");
        }
        return (gu3) this.k;
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public boolean K0() {
        return ConditionHelper.getInstance().getRecommendCond().isDefaultCond();
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 48;
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.y != LxApiProxy.getInstance().getConfigApi().b()) {
            this.y = !this.y;
            z(true);
        }
    }
}
