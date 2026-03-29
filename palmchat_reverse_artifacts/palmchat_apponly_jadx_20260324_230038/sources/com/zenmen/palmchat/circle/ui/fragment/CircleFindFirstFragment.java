package com.zenmen.palmchat.circle.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.baidu.location.LocationConst;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleFirstCateList;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleApplyGroupActivity;
import com.zenmen.palmchat.circle.ui.adapter.CircleRecommendAdapter;
import com.zenmen.palmchat.circle.ui.adapter.FragPageAdapterVp;
import com.zenmen.palmchat.circle.ui.adapter.TabAdapter;
import com.zenmen.palmchat.circle.ui.view.TabLayoutScroll;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.adapters.EndlessScrollListener;
import defpackage.c70;
import defpackage.gc0;
import defpackage.oc0;
import defpackage.sd3;
import defpackage.ss5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleFindFirstFragment extends CircleLoadFragment {
    public CircleRecommendAdapter A;
    public int B;
    public ArrayList<CircleFirstCateList.SecondCate> C;
    public String E;
    public ViewPager m;
    public ViewGroup n;
    public TabLayoutScroll o;
    public SwipeRefreshLayout p;
    public RecyclerView q;
    public LinearLayout r;
    public FragPageAdapterVp<CircleFirstCateList.SecondCate> s;
    public TabAdapter<CircleFirstCateList.SecondCate> t;
    public EndlessScrollListener u;
    public List<CircleRecommendItem> z;
    public int v = 1;
    public boolean w = true;
    public boolean x = false;
    public List<CircleRecommendItem> y = new ArrayList();
    public long F = 0;
    public List<CircleFindSecondFragment> G = new ArrayList();
    public CircleRecommendAdapter.c H = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends FragPageAdapterVp<CircleFirstCateList.SecondCate> {
        public a(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // defpackage.nk2
        @RequiresApi(api = 16)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(TabViewHolder tabViewHolder, int i, CircleFirstCateList.SecondCate secondCate, boolean z) {
            LogUtil.i("createFragment2", "bindDataToTab:" + i + "  " + z);
            TextView textView = (TextView) tabViewHolder.l(R.id.tv);
            if (z) {
                textView.setTextColor(CircleFindFirstFragment.this.getResources().getColor(R.color.black));
                textView.setBackgroundResource(R.drawable.tablayout_item_bg);
                if (i < CircleFindFirstFragment.this.G.size()) {
                    ((CircleFindSecondFragment) CircleFindFirstFragment.this.G.get(i)).T();
                }
            } else {
                textView.setTextColor(CircleFindFirstFragment.this.getResources().getColor(R.color.color_999999));
                textView.setBackground(null);
            }
            textView.setText(secondCate.cateName);
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.BaseFragPageAdapterVp
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Fragment h(CircleFirstCateList.SecondCate secondCate, int i) {
            LogUtil.i("createFragment2", "createFragment:" + i);
            if (i < CircleFindFirstFragment.this.G.size()) {
                return (Fragment) CircleFindFirstFragment.this.G.get(i);
            }
            return null;
        }

        @Override // defpackage.nk2
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int b(int i, CircleFirstCateList.SecondCate secondCate) {
            return R.layout.tablayout_second_item;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements EndlessScrollListener.a {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void a(int i) {
            CircleFindFirstFragment.this.w = false;
            CircleFindFirstFragment.this.u.a();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void b() {
            if (CircleFindFirstFragment.this.A != null) {
                CircleFindFirstFragment.this.A.h();
            }
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void c(int i) {
            if (CircleFindFirstFragment.this.w) {
                CircleFindFirstFragment.this.w = false;
                CircleFindFirstFragment.this.p.setRefreshing(false);
            }
            CircleFindFirstFragment.this.v = i;
            CircleFindFirstFragment.this.G0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse<List<CircleRecommendItem>>> {
        public c() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleRecommendItem>> baseResponse) {
            if (CircleFindFirstFragment.this.p != null) {
                CircleFindFirstFragment.this.p.setRefreshing(false);
            }
            CircleFindFirstFragment.this.G();
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleFindFirstFragment.this.getContext(), R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleFindFirstFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
                }
                CircleFindFirstFragment.this.u.c(CircleFindFirstFragment.this.v);
                if (CircleFindFirstFragment.this.F == 0) {
                    CircleFindFirstFragment.this.Z(false);
                    return;
                }
                return;
            }
            List<CircleRecommendItem> data = baseResponse.getData();
            if (data != null) {
                if (data.isEmpty()) {
                    if (CircleFindFirstFragment.this.y.isEmpty()) {
                        CircleFindFirstFragment.this.x = true;
                        CircleFindFirstFragment.this.z = data;
                        CircleFindFirstFragment.this.O0();
                        return;
                    } else {
                        LogUtil.i("CircleFindFirstFragment", "onResponse: 已加载全部数据 " + CircleFindFirstFragment.this.w);
                        sy5.f(CircleFindFirstFragment.this.getContext(), "已加载全部数据", 0).g();
                        CircleFindFirstFragment.this.u.a();
                        return;
                    }
                }
                CircleFindFirstFragment.this.u.b();
                CircleFindFirstFragment.this.F = data.get(data.size() - 1).id;
                if (!CircleFindFirstFragment.this.w) {
                    if (data.size() < 10) {
                        CircleFindFirstFragment.this.u.a();
                    }
                    CircleFindFirstFragment.this.y.addAll(data);
                    CircleFindFirstFragment.this.A.notifyDataSetChanged();
                    return;
                }
                CircleFindFirstFragment.this.x = true;
                CircleFindFirstFragment.this.z = data;
                CircleFindFirstFragment.this.O0();
                if (data.size() < 10) {
                    CircleFindFirstFragment.this.u.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CircleRecommendAdapter.c {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse<CircleApplyGroupType>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CircleRecommendItem f13272a;
            public final /* synthetic */ int b;

            public a(CircleRecommendItem circleRecommendItem, int i) {
                this.f13272a = circleRecommendItem;
                this.b = i;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse<CircleApplyGroupType> baseResponse) {
                if (baseResponse.getResultCode() == 0) {
                    CircleApplyGroupType data = baseResponse.getData();
                    this.f13272a.addType = baseResponse.getData().getAddType();
                    CircleFindFirstFragment.this.C0(this.f13272a, this.b, data);
                    return;
                }
                CircleFindFirstFragment.this.G();
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleFindFirstFragment.this.getContext(), R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleFindFirstFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public d() {
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.CircleRecommendAdapter.c
        public void a(CircleRecommendItem circleRecommendItem, int i) {
            if (circleRecommendItem.hasJoined == 1) {
                gc0.a(CircleFindFirstFragment.this.getContext(), circleRecommendItem, 3);
            } else {
                CircleFindFirstFragment.this.L();
                c70.R().C(String.valueOf(circleRecommendItem.id), new a(circleRecommendItem, i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleRecommendItem f13273a;
        public final /* synthetic */ int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public e(CircleRecommendItem circleRecommendItem, int i) {
            this.f13273a = circleRecommendItem;
            this.b = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleFindFirstFragment.this.G();
            if (baseResponse.getResultCode() == 0) {
                this.f13273a.hasJoined = 1;
                CircleFindFirstFragment.this.y.set(this.b, this.f13273a);
                gc0.a(CircleFindFirstFragment.this.getContext(), this.f13273a, 3);
            } else if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                new sd3(CircleFindFirstFragment.this.getContext()).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new a()).e().show();
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleFindFirstFragment.this.getContext(), R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleFindFirstFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        this.w = true;
        this.v = 1;
        this.F = 0L;
        this.u.d();
        this.A.i();
        this.x = false;
        G0();
    }

    public static CircleFindFirstFragment N0(String str, ArrayList<CircleFirstCateList.SecondCate> arrayList, int i) {
        CircleFindFirstFragment circleFindFirstFragment = new CircleFindFirstFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("fromtype", i);
        bundle.putSerializable("second_tab_cates", arrayList);
        bundle.putString("first_cate_id", str);
        circleFindFirstFragment.setArguments(bundle);
        return circleFindFirstFragment;
    }

    public final void C0(CircleRecommendItem circleRecommendItem, int i, CircleApplyGroupType circleApplyGroupType) {
        HashMap map = new HashMap();
        map.put("rid", String.valueOf(circleRecommendItem.id));
        map.put("fromtype", Integer.valueOf(this.B));
        map.put(az.at, 0);
        int i2 = circleRecommendItem.addType;
        if (i2 == 1) {
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, "1");
            c70.R().j(String.valueOf(circleRecommendItem.id), 3, "", "", new e(circleRecommendItem, i));
        } else if (i2 == 2) {
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, "2");
            G();
            CircleApplyGroupActivity.J1(getActivity(), circleApplyGroupType, 3, "");
        } else if (i2 == 3) {
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, "0");
            G();
            sy5.e(getContext(), R.string.circle_not_allow_join, 0).g();
        }
        oc0.h("lx_group_jion_click", map);
    }

    public void E0() {
        G();
    }

    public final void G0() {
        c70.R().X(this.v, 10, this.F, this.E, null, new c());
    }

    public final void I0() {
        this.B = getArguments().getInt("fromtype");
        this.E = getArguments().getString("first_cate_id");
        ArrayList<CircleFirstCateList.SecondCate> arrayList = (ArrayList) getArguments().getSerializable("second_tab_cates");
        this.C = arrayList;
        if (arrayList == null || arrayList.isEmpty()) {
            this.r.setVisibility(8);
            this.p.setVisibility(0);
            Q0();
        }
    }

    public final void K0() {
        if (this.t == null || this.s == null) {
            for (CircleFirstCateList.SecondCate secondCate : this.C) {
                this.G.add(CircleFindSecondFragment.K0(secondCate.parentId, secondCate.id, this.B));
            }
            this.o.setSpace_horizontal(10);
            this.m.setOffscreenPageLimit(this.C.size() - 1);
            this.s = new a(getChildFragmentManager(), 1);
            this.t = new ss5(this.o, this.m).A(this.s);
            this.r.setVisibility(0);
            this.p.setVisibility(8);
            this.s.f(this.C);
            this.t.f(this.C);
        }
    }

    public final void M0() {
        LogUtil.i("CircleFindFirstFragment", "loadFirstBodyData: ");
        this.w = true;
        G0();
    }

    public final void O0() {
        if (this.w) {
            if (!this.x) {
                return;
            }
            this.w = false;
            this.y.clear();
            this.y.addAll(this.z);
        }
        if (this.A != null) {
            if (this.y.isEmpty()) {
                this.u.a();
                return;
            } else {
                this.A.notifyDataSetChanged();
                return;
            }
        }
        CircleRecommendAdapter circleRecommendAdapter = new CircleRecommendAdapter(getContext(), this.y, this.B);
        this.A = circleRecommendAdapter;
        circleRecommendAdapter.j(this.H);
        this.q.setAdapter(this.A);
        if (this.y.isEmpty()) {
            this.u.a();
        }
    }

    public final void Q0() {
        this.p.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: c90
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f1924a.L0();
            }
        });
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(new b());
        this.u = endlessScrollListener;
        this.q.addOnScrollListener(endlessScrollListener);
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_circle_find_first, viewGroup, false);
        this.n = viewGroup2;
        this.r = (LinearLayout) viewGroup2.findViewById(R.id.ll_second_tab);
        this.m = (ViewPager) this.n.findViewById(R.id.view_pager);
        this.o = (TabLayoutScroll) this.n.findViewById(R.id.tablayout);
        this.p = (SwipeRefreshLayout) this.n.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = (RecyclerView) this.n.findViewById(R.id.circleRecyclerView);
        this.q = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        I0();
        return this.n;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        ArrayList<CircleFirstCateList.SecondCate> arrayList = this.C;
        if (arrayList == null || arrayList.isEmpty()) {
            M0();
        } else {
            K0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("CircleFindFirstFragment", "onDestroy: ");
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.i("CircleFindFirstFragment", "onPause: ");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.i("CircleFindFirstFragment", "onStart: ");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.i("CircleFindFirstFragment", "onStop: ");
    }
}
