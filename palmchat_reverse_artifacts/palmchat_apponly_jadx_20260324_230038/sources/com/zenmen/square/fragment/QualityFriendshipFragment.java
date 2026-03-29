package com.zenmen.square.fragment;

import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.bj5;
import defpackage.gu3;
import defpackage.rp4;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class QualityFriendshipFragment extends NearByFragment {
    @Override // com.zenmen.square.fragment.NearByFragment
    public boolean A0() {
        return false;
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public gu3 E0() {
        if (this.k == 0) {
            this.k = new rp4(o(), "onev1.beautiful.girls.list.v1");
        }
        return (gu3) this.k;
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        if (z) {
            T0();
        }
    }

    @Override // com.zenmen.square.fragment.NearByFragment
    public boolean K0() {
        return false;
    }

    public final void T0() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.FIND_FRIEND_TAB;
        if (sPUtil.a(scene, "key_quality_friendship_dialog_show_" + v4.e(c.b()), false)) {
            return;
        }
        bj5.b().a().W(getActivity(), bj5.b().a().L(), "qualityfriendship");
        sPUtil.t(scene, "key_quality_friendship_dialog_show_" + v4.e(c.b()), Boolean.TRUE);
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 75;
    }

    @Override // com.zenmen.square.fragment.NearByFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
