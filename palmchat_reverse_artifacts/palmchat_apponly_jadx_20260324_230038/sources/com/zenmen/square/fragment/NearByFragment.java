package com.zenmen.square.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.find.ConditionHelper;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.adapter.NearByAdapter;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.ui.widget.ListStateView;
import defpackage.a23;
import defpackage.a46;
import defpackage.aj5;
import defpackage.an1;
import defpackage.bj5;
import defpackage.dg6;
import defpackage.du3;
import defpackage.et4;
import defpackage.fg6;
import defpackage.ft4;
import defpackage.gu3;
import defpackage.iu3;
import defpackage.ju3;
import defpackage.l6;
import defpackage.mu3;
import defpackage.qj5;
import defpackage.qv1;
import defpackage.rv1;
import defpackage.to2;
import defpackage.zt4;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFragment extends SquareBaseFragment<NearByAdapter, gu3, NearByBean, iu3> implements to2, mu3.a {
    public mu3 q;
    public int r;
    public aj5 s;
    public NearByBean u;
    public View v;
    public int t = -1;
    public Handler w = new Handler(Looper.getMainLooper());
    public boolean x = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NearByFragment.this.N0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NearByFragment.this.N0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ft4.j();
            l6.k(44);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ft4.g();
            ju3.s(NearByFragment.this.getActivity());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16318a = -1;

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            int iFindLastVisibleItemPosition;
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || (iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == this.f16318a) {
                return;
            }
            this.f16318a = iFindLastVisibleItemPosition;
            int iG = ju3.g(iFindLastVisibleItemPosition);
            if (iG == -1) {
                NearByFragment.this.I0(false);
            } else {
                NearByFragment.this.R0(iG);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (NearByFragment.this.o() == 48) {
                ConditionHelper.getInstance().resetRecommendVipCondition();
            } else if (NearByFragment.this.o() == 49 || NearByFragment.this.o() == 113) {
                ConditionHelper.getInstance().resetNearbyVipCondition();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NearByFragment.this.x = true;
        }
    }

    public boolean A0() {
        return this.l == null || a46.p() || this.l.getState().f11843a != PageState.State.ERROR;
    }

    public void B0(boolean z) {
        M m = this.k;
        if (m != 0) {
            ((gu3) m).S(z);
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public NearByAdapter V() {
        if (this.j == 0) {
            NearByAdapter nearByAdapter = new NearByAdapter(o());
            this.j = nearByAdapter;
            nearByAdapter.f(getActivity());
        }
        return (NearByAdapter) this.j;
    }

    public gu3 E0() {
        if (this.k == 0) {
            this.k = new gu3(o(), "lbs.square.nearby.pull.v9");
        }
        return (gu3) this.k;
    }

    public int G0() {
        return this.t;
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void I() {
        super.I();
    }

    public void I0(boolean z) {
        if (this.v == null) {
            return;
        }
        if (z && this.u != null) {
            E0().e().remove(this.u);
            this.u = null;
            V().notifyDataSetChanged();
        }
        if (this.t == -1) {
            return;
        }
        this.v.setVisibility(8);
        this.t = -1;
        V().notifyDataSetChanged();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        if (z) {
            HashMap map = new HashMap();
            map.put("sid", this.f);
            map.put("from", Integer.valueOf(this.r));
            map.put("tabtype", Integer.valueOf(48 == o() ? 1 : 49 == o() ? 2 : 75 == o() ? 3 : -1));
            qj5.b("pagelffriend_tabview", "view", map);
            if (o() == 48 || 49 == o()) {
                bj5.b().a().M(getActivity());
            }
        }
        aj5 aj5Var = this.s;
        if (aj5Var != null) {
            aj5Var.g(z);
        }
    }

    public boolean K0() {
        return ConditionHelper.getInstance().getNearByCond().isDefaultCond();
    }

    public void L0(int i, NearByBean nearByBean) {
        super.j0(i, nearByBean);
        if (S0()) {
            this.w.postDelayed(new b(), com.igexin.push.config.c.j);
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public iu3 k0() {
        return new iu3(this, E0());
    }

    public void N0() {
        if (this.u != null) {
            List<NearByBean> listE = E0().e();
            listE.remove(this.u);
            int i = ju3.l().l;
            if (i <= listE.size()) {
                listE.add(i, this.u);
            }
            V().notifyDataSetChanged();
        }
        BaseRecyclerView baseRecyclerViewE = e();
        if (baseRecyclerViewE != null) {
            RecyclerView.LayoutManager layoutManager = baseRecyclerViewE.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int iG = ju3.g(((LinearLayoutManager) layoutManager).findLastVisibleItemPosition());
                if (iG == -1) {
                    I0(false);
                } else {
                    R0(iG);
                }
            }
        }
    }

    public void O0(int i) {
        this.r = i;
    }

    public void Q0(boolean z) {
        M m = this.k;
        if (m != 0) {
            ((gu3) m).T(z);
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public boolean R() {
        return false;
    }

    public void R0(int i) {
        View view = this.v;
        if (view == null) {
            return;
        }
        int i2 = this.t;
        if (i2 == -1 || i2 != i) {
            if (view.getVisibility() != 0) {
                this.v.setVisibility(0);
                l6.l(44);
                ft4.k();
                ft4.i();
                TextView textView = (TextView) this.v.findViewById(R$id.join_vip);
                TextView textView2 = (TextView) this.v.findViewById(R$id.see_reward);
                et4 et4VarL = ju3.l();
                textView.setText(et4VarL.b);
                textView2.setText(et4VarL.c);
                textView.setOnClickListener(new c());
                textView2.setOnClickListener(new d());
            }
            if (this.t == -1) {
                List<NearByBean> listE = E0().e();
                NearByBean nearByBean = this.u;
                if (nearByBean == null) {
                    NearByBean nearByBean2 = new NearByBean();
                    this.u = nearByBean2;
                    nearByBean2.lockTitle = true;
                } else {
                    listE.remove(nearByBean);
                }
                int i3 = ju3.l().l;
                if (i3 <= listE.size()) {
                    listE.add(i3, this.u);
                }
            }
            this.t = i;
            V().notifyDataSetChanged();
        }
    }

    public boolean S0() {
        return o() == 49;
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public Context W() {
        return getContext();
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public int Z() {
        return R$layout.layout_square_nearby_fragment;
    }

    @Override // mu3.a
    public void h() {
        if (isResumed() && this.h) {
            dg6.a(getContext(), new f(), new g(), "24");
        }
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.duration.BaseDurationFragment
    public void i(boolean z) {
        super.i(z);
        aj5 aj5Var = this.s;
        if (aj5Var != null) {
            aj5Var.g(z && isResumed());
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void l0(List<NearByBean> list) {
        super.l0(list);
        bj5.b().a().S(o());
        if (S0()) {
            this.w.postDelayed(new a(), com.igexin.push.config.c.j);
        }
        if (rv1.a()) {
            int iO = o();
            LogUtil.d("FindAdSJManager", "refresh start pageType " + o());
            if (iO == 49) {
                rv1.d();
            } else if (iO == 48) {
                rv1.e();
            }
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 49;
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        int iO = o();
        rv1.i(getActivity());
        if (iO == 48) {
            zt4.y().g(E0());
            if (!qv1.r()) {
                zt4.y().v(getActivity(), 1, 0);
            }
        } else if (iO == 49) {
            du3.y().g(E0());
            if (!du3.z()) {
                LogUtil.d("", "NearByFragment onActivityCreated NearByFindAdManager tryRequest");
                du3.y().v(getActivity(), 1, 0);
            }
        }
        if (S0()) {
            ju3.f(this);
            BaseRecyclerView baseRecyclerViewE = e();
            if (baseRecyclerViewE != null) {
                baseRecyclerViewE.addOnScrollListener(new e());
            }
        }
        this.s = new aj5(e(), o());
        this.l.setEmptyString("暂时没有你想找的人~");
        View view = getView();
        if (view != null) {
            this.v = view.findViewById(R$id.unlock_cover);
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        T(new a23() { // from class: eu3
            @Override // defpackage.a23
            public final void a() {
                this.f17363a.x();
            }
        });
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = new mu3(this);
        an1.c().p(this.q);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        an1.c().r(this.q);
        this.v = null;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        aj5 aj5Var = this.s;
        if (aj5Var != null) {
            aj5Var.e();
        }
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        aj5 aj5Var = this.s;
        if (aj5Var != null) {
            aj5Var.f(true);
        }
        if (this.t == -1 || !fg6.d(getActivity())) {
            return;
        }
        I0(true);
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void p0(PageState pageState) {
        ListStateView listStateView = this.l;
        if (listStateView != null) {
            listStateView.setVisibility(0);
            this.l.setState(pageState);
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public void u(String str) {
        super.u(str);
        E0().V(str);
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment
    public boolean x0() {
        boolean zX0 = super.x0();
        if (zX0 || !this.x) {
            return zX0;
        }
        this.x = false;
        if (bj5.b().a().b(getContext())) {
            x();
            return true;
        }
        if (o() == 48) {
            ConditionHelper.getInstance().resetRecommendVipCondition();
            return zX0;
        }
        if (o() == 49) {
            ConditionHelper.getInstance().resetNearbyVipCondition();
            return zX0;
        }
        if (o() != 113) {
            return zX0;
        }
        ConditionHelper.getInstance().resetNearbyVipCondition();
        return zX0;
    }

    @Override // defpackage.nm2
    public SmartRefreshLayout y() {
        if (getView() != null) {
            return (SmartRefreshLayout) getView().findViewById(R$id.refresh_layout);
        }
        return null;
    }

    @Override // defpackage.to2
    public BaseRecyclerView e() {
        if (getView() != null) {
            return (BaseRecyclerView) getView().findViewById(R$id.recycler_view_feeds);
        }
        return null;
    }

    @Override // defpackage.to2
    public void A() {
    }
}
