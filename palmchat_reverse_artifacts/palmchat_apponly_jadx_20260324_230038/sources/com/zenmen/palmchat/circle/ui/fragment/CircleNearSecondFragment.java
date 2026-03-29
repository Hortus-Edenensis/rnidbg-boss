package com.zenmen.palmchat.circle.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.baidu.location.LocationConst;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleApplyGroupActivity;
import com.zenmen.palmchat.circle.ui.adapter.CircleRecommendAdapter;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.adapters.EndlessScrollListener;
import defpackage.c70;
import defpackage.gc0;
import defpackage.oc0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wi0;
import defpackage.wn4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNearSecondFragment extends CircleLoadFragment {
    public LocationEx A;
    public SwipeRefreshLayout m;
    public RecyclerView n;
    public EndlessScrollListener o;
    public List<CircleRecommendItem> t;
    public CircleRecommendAdapter u;
    public int v;
    public String w;
    public String x;
    public wn4 z;
    public int p = 1;
    public boolean q = true;
    public boolean r = false;
    public List<CircleRecommendItem> s = new ArrayList();
    public long y = 0;
    public CircleRecommendAdapter.c B = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements EndlessScrollListener.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void a(int i) {
            CircleNearSecondFragment.this.q = false;
            CircleNearSecondFragment.this.o.a();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void b() {
            if (CircleNearSecondFragment.this.u != null) {
                CircleNearSecondFragment.this.u.h();
            }
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void c(int i) {
            if (CircleNearSecondFragment.this.q) {
                CircleNearSecondFragment.this.q = false;
                CircleNearSecondFragment.this.m.setRefreshing(false);
            }
            CircleNearSecondFragment.this.p = i;
            CircleNearSecondFragment.this.C0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<List<CircleRecommendItem>>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleRecommendItem>> baseResponse) {
            if (CircleNearSecondFragment.this.m != null) {
                CircleNearSecondFragment.this.m.setRefreshing(false);
            }
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleNearSecondFragment.this.getContext(), R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleNearSecondFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
                }
                CircleNearSecondFragment.this.o.c(CircleNearSecondFragment.this.p);
                if (CircleNearSecondFragment.this.p == 1) {
                    CircleNearSecondFragment.this.Z(false);
                    return;
                }
                return;
            }
            List<CircleRecommendItem> data = baseResponse.getData();
            if (data != null) {
                if (data.isEmpty()) {
                    if (CircleNearSecondFragment.this.s.isEmpty()) {
                        CircleNearSecondFragment.this.r = true;
                        CircleNearSecondFragment.this.t = data;
                        CircleNearSecondFragment.this.K0();
                        return;
                    } else {
                        LogUtil.i("CircleSecondFragment", "onResponse: 已加载全部数据 " + CircleNearSecondFragment.this.q);
                        sy5.f(CircleNearSecondFragment.this.getContext(), "已加载全部数据", 0).g();
                        CircleNearSecondFragment.this.o.a();
                        return;
                    }
                }
                CircleNearSecondFragment.this.o.b();
                CircleNearSecondFragment.this.y = data.get(data.size() - 1).id;
                if (!CircleNearSecondFragment.this.q) {
                    if (data.size() < 10) {
                        CircleNearSecondFragment.this.o.a();
                    }
                    CircleNearSecondFragment.this.s.addAll(data);
                    CircleNearSecondFragment.this.u.notifyDataSetChanged();
                    return;
                }
                CircleNearSecondFragment.this.r = true;
                CircleNearSecondFragment.this.t = data;
                CircleNearSecondFragment.this.K0();
                if (data.size() < 10) {
                    CircleNearSecondFragment.this.o.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CircleRecommendAdapter.c {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse<CircleApplyGroupType>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CircleRecommendItem f13293a;
            public final /* synthetic */ int b;

            public a(CircleRecommendItem circleRecommendItem, int i) {
                this.f13293a = circleRecommendItem;
                this.b = i;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse<CircleApplyGroupType> baseResponse) {
                if (baseResponse.getResultCode() == 0) {
                    CircleApplyGroupType data = baseResponse.getData();
                    this.f13293a.addType = baseResponse.getData().getAddType();
                    CircleNearSecondFragment.this.A0(this.f13293a, this.b, data);
                    return;
                }
                CircleNearSecondFragment.this.G();
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleNearSecondFragment.this.getContext(), R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleNearSecondFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
                }
            }
        }

        public c() {
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.CircleRecommendAdapter.c
        public void a(CircleRecommendItem circleRecommendItem, int i) {
            if (circleRecommendItem.hasJoined == 1) {
                gc0.a(CircleNearSecondFragment.this.getContext(), circleRecommendItem, 3);
            } else {
                CircleNearSecondFragment.this.L();
                c70.R().C(String.valueOf(circleRecommendItem.id), new a(circleRecommendItem, i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleRecommendItem f13294a;
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

        public d(CircleRecommendItem circleRecommendItem, int i) {
            this.f13294a = circleRecommendItem;
            this.b = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleNearSecondFragment.this.G();
            if (baseResponse.getResultCode() == 0) {
                this.f13294a.hasJoined = 1;
                CircleNearSecondFragment.this.s.set(this.b, this.f13294a);
                gc0.a(CircleNearSecondFragment.this.getContext(), this.f13294a, 3);
            } else if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                new sd3(CircleNearSecondFragment.this.getContext()).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new a()).e().show();
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleNearSecondFragment.this.getContext(), R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleNearSecondFragment.this.getContext(), baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        this.q = true;
        this.p = 1;
        this.y = 0L;
        this.o.d();
        this.u.i();
        this.r = false;
        C0();
    }

    public static CircleNearSecondFragment I0(String str, String str2, int i, LocationEx locationEx) {
        CircleNearSecondFragment circleNearSecondFragment = new CircleNearSecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("first_cate_id", str);
        bundle.putString("second_cate_id", str2);
        bundle.putInt("fromtype", i);
        bundle.putParcelable("key_location", locationEx);
        circleNearSecondFragment.setArguments(bundle);
        return circleNearSecondFragment;
    }

    public final void A0(CircleRecommendItem circleRecommendItem, int i, CircleApplyGroupType circleApplyGroupType) {
        HashMap map = new HashMap();
        map.put("rid", String.valueOf(circleRecommendItem.id));
        map.put("fromtype", Integer.valueOf(this.v));
        map.put(az.at, 1);
        int i2 = circleRecommendItem.addType;
        if (i2 == 1) {
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, "1");
            c70.R().j(String.valueOf(circleRecommendItem.id), 3, "", "", new d(circleRecommendItem, i));
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

    public final void B0() {
        this.q = true;
        C0();
    }

    public final void C0() {
        if (this.A == null) {
            sy5.f(getContext(), "获取地理位置信息失败，请稍后重试", 0).g();
        } else {
            c70.R().W(this.p, 10, this.A.getLongitude(), this.A.getLatitude(), this.w, this.x, new b());
        }
    }

    public final void E0() {
        this.w = getArguments().getString("first_cate_id");
        this.x = getArguments().getString("second_cate_id");
        this.v = getArguments().getInt("fromtype");
        this.A = (LocationEx) getArguments().getParcelable("key_location");
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void G() {
        wn4 wn4Var = this.z;
        if (wn4Var != null) {
            try {
                wn4Var.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void K0() {
        if (this.q) {
            if (!this.r) {
                return;
            }
            this.q = false;
            this.s.clear();
            this.s.addAll(this.t);
        }
        if (this.u != null) {
            if (this.s.isEmpty()) {
                this.o.a();
                return;
            } else {
                this.u.notifyDataSetChanged();
                return;
            }
        }
        CircleRecommendAdapter circleRecommendAdapter = new CircleRecommendAdapter(getContext() != null ? getContext() : getActivity(), this.s, this.v);
        this.u = circleRecommendAdapter;
        circleRecommendAdapter.k();
        this.u.j(this.B);
        this.n.setAdapter(this.u);
        if (this.s.isEmpty()) {
            this.o.a();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void L() {
        if (this.z == null) {
            wn4 wn4Var = new wn4(getActivity());
            this.z = wn4Var;
            wn4Var.setCancelable(false);
            this.z.b(getString(R.string.progress_sending));
        }
        this.z.show();
    }

    public final void L0() {
        this.m.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: xa0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f21910a.G0();
            }
        });
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(new a());
        this.o = endlessScrollListener;
        this.n.addOnScrollListener(endlessScrollListener);
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LogUtil.i("CircleSecondFragment", "onCreateView: ");
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_circle_find_second, viewGroup, false);
        this.m = (SwipeRefreshLayout) viewGroup2.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(R.id.circleRecyclerView);
        this.n = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        E0();
        L0();
        return viewGroup2;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        B0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("CircleSecondFragment", "onDestroy: ");
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.i("CircleSecondFragment", "onPause: ");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.i("CircleSecondFragment", "onStart: ");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.i("CircleSecondFragment", "onStop: ");
    }
}
