package com.zenmen.square.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.listui.list.PageState;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.FriendMessageAdapter;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import com.zenmen.square.ui.widget.PraiseListStateView;
import defpackage.l42;
import defpackage.m42;
import defpackage.qj5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FriendMessageFragment extends BaseListFragment<FriendMessageAdapter, l42, PlaceFeed, m42> {
    public PraiseListStateView l;
    public boolean m = false;

    @Override // com.zenmen.listui.list.BaseListFragment
    public Context W() {
        return getActivity();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public int Z() {
        return R$layout.layout_square_interact;
    }

    @Override // defpackage.nm2
    public BaseRecyclerView e() {
        return (BaseRecyclerView) getView().findViewById(R$id.recycler_view_messages);
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 19;
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        PraiseListStateView praiseListStateView = (PraiseListStateView) view.findViewById(R$id.layout_empty_praise_state);
        this.l = praiseListStateView;
        praiseListStateView.setEmptyIconRes(R$drawable.icon_square_load_state_empty_comment);
        this.l.setEmptyTitleRes(R$string.square_message_comment_list_state_empty);
        this.l.setEnableBtn(false);
        p0(new PageState(PageState.State.LOADING, null));
        s0();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void p0(PageState pageState) {
        PraiseListStateView praiseListStateView = this.l;
        if (praiseListStateView != null) {
            praiseListStateView.setVisibility(0);
            this.l.setState(pageState);
        }
    }

    public final void s0() {
        P p;
        if (this.m || !getUserVisibleHint() || (p = this.i) == 0) {
            return;
        }
        this.m = true;
        ((m42) p).v();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        s0();
        if (z) {
            qj5.K(o());
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public FriendMessageAdapter V() {
        if (this.j == 0) {
            this.j = new FriendMessageAdapter();
        }
        return (FriendMessageAdapter) this.j;
    }

    public l42 u0() {
        if (this.k == 0) {
            this.k = new l42();
        }
        return (l42) this.k;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public m42 k0() {
        return new m42(this, u0());
    }

    @Override // defpackage.nm2
    public SmartRefreshLayout y() {
        return (SmartRefreshLayout) getView().findViewById(R$id.refresh_layout_message);
    }
}
