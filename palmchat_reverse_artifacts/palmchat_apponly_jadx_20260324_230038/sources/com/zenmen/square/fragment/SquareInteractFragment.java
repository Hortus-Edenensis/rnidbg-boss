package com.zenmen.square.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.adapter.SquareInteractAdapter;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareUserPostStatisticsBean;
import com.zenmen.square.ui.widget.PraiseListStateView;
import defpackage.go2;
import defpackage.kj1;
import defpackage.q05;
import defpackage.qj5;
import defpackage.sw4;
import defpackage.xi5;
import defpackage.yi5;
import defpackage.zw4;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareInteractFragment extends BaseListFragment<SquareInteractAdapter, xi5, SquareInteractBean, yi5> {
    public PraiseListStateView l;
    public boolean m = false;
    public boolean n = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements PraiseListStateView.c {
        public a() {
        }

        @Override // com.zenmen.square.ui.widget.PraiseListStateView.c
        public void a(PageState.State state) {
            if (PageState.State.ERROR != state || SquareInteractFragment.this.i == null) {
                return;
            }
            ((yi5) SquareInteractFragment.this.i).v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SquareUserPostStatisticsBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16345a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public b(String str, HashMap map, boolean z) {
            this.f16345a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f16345a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SquareUserPostStatisticsBean> lXBaseNetBean, Exception exc) {
            if (q05.o(SquareInteractFragment.this.getActivity()) || !z || lXBaseNetBean.data == null) {
                return;
            }
            SquareInteractFragment.this.l.setState(new PageState(PageState.State.NORMAL, null));
            if (((SquareInteractAdapter) SquareInteractFragment.this.j).getItemCount() <= 0) {
                SquareInteractBean squareInteractBean = new SquareInteractBean();
                squareInteractBean.squareUserPostStatisticsBean = lXBaseNetBean.data;
                ((SquareInteractAdapter) SquareInteractFragment.this.j).a().add(0, squareInteractBean);
                ((SquareInteractAdapter) SquareInteractFragment.this.j).notifyDataSetChanged();
            } else if (((SquareInteractAdapter) SquareInteractFragment.this.j).a().get(0).squareUserPostStatisticsBean == null) {
                SquareInteractBean squareInteractBean2 = new SquareInteractBean();
                squareInteractBean2.squareUserPostStatisticsBean = lXBaseNetBean.data;
                ((SquareInteractAdapter) SquareInteractFragment.this.j).a().add(0, squareInteractBean2);
                ((SquareInteractAdapter) SquareInteractFragment.this.j).notifyDataSetChanged();
            } else {
                ((SquareInteractAdapter) SquareInteractFragment.this.j).a().get(0).squareUserPostStatisticsBean = lXBaseNetBean.data;
                ((SquareInteractAdapter) SquareInteractFragment.this.j).notifyDataSetChanged();
            }
            SquareInteractFragment squareInteractFragment = SquareInteractFragment.this;
            if (squareInteractFragment.n) {
                return;
            }
            squareInteractFragment.n = true;
            q05.a("postboost_interactSummary", 1, null);
        }
    }

    public final void I0() {
        zw4.e(new b(q05.c() + "/square.user.post.statistics", new HashMap(), false));
    }

    public final void K0() {
        P p;
        if (this.m || !getUserVisibleHint() || (p = this.i) == 0) {
            return;
        }
        this.m = true;
        ((yi5) p).v();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public SquareInteractAdapter V() {
        if (this.j == 0) {
            this.j = new SquareInteractAdapter();
        }
        return (SquareInteractAdapter) this.j;
    }

    public xi5 M0() {
        if (this.k == 0) {
            this.k = new xi5();
        }
        return (xi5) this.k;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public yi5 k0() {
        return new yi5(this, M0());
    }

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

    @Override // com.zenmen.listui.list.BaseListFragment
    public void l0(List<SquareInteractBean> list) {
        super.l0(list);
        if (kj1.b().c().booleanValue()) {
            I0();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 17;
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        q05.w("KEY_NEED_SHOW_SQUARE_INTERACT_DOT", Boolean.FALSE);
        PraiseListStateView praiseListStateView = (PraiseListStateView) view.findViewById(R$id.layout_empty_praise_state);
        this.l = praiseListStateView;
        praiseListStateView.setEmptyIconRes(R$drawable.icon_square_load_state_empty_comment);
        this.l.setEmptyTitleRes(R$string.square_message_comment_list_state_empty);
        this.l.setEnableBtn(false);
        this.l.setOnStateViewClickListener(new a());
        K0();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void p0(PageState pageState) {
        PraiseListStateView praiseListStateView = this.l;
        if (praiseListStateView != null) {
            praiseListStateView.setVisibility(0);
            this.l.setState(pageState);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        K0();
        if (z) {
            qj5.K(o());
        }
    }

    @Override // defpackage.nm2
    public SmartRefreshLayout y() {
        return (SmartRefreshLayout) getView().findViewById(R$id.refresh_layout_message);
    }
}
