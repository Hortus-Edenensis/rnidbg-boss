package com.zenmen.palmchat.circle.ui.fragment;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleFirstCateList;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.FragPageAdapterVp;
import com.zenmen.palmchat.circle.ui.adapter.TabAdapter;
import com.zenmen.palmchat.circle.ui.view.IndicatorLineView;
import com.zenmen.palmchat.circle.ui.view.TabLayoutScroll;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c70;
import defpackage.hx3;
import defpackage.i53;
import defpackage.me1;
import defpackage.n53;
import defpackage.ry5;
import defpackage.ss5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNearFragment extends CircleLoadFragment implements View.OnClickListener, i53 {
    public int m;
    public TabLayoutScroll n;
    public IndicatorLineView o;
    public ViewPager p;
    public RelativeLayout q;
    public TextView r;
    public LocationEx s;
    public ArrayList<CircleFirstCateList> t;
    public List<CircleNearFirstFragment> u;
    public FragPageAdapterVp<CircleFirstCateList> v;
    public NestedScrollView w;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<ArrayList<CircleFirstCateList>>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<CircleFirstCateList>> baseResponse) {
            CircleNearFragment.this.G();
            if (CircleNearFragment.this.getActivity() == null || CircleNearFragment.this.getActivity().isFinishing()) {
                CircleNearFragment.this.Z(false);
                return;
            }
            if (baseResponse == null) {
                sy5.f(CircleNearFragment.this.getActivity(), "接口异常", 0).g();
                CircleNearFragment.this.Z(false);
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                sy5.f(CircleNearFragment.this.getActivity(), TextUtils.isEmpty(baseResponse.getErrorMsg()) ? CircleNearFragment.this.getString(R.string.default_response_error) : baseResponse.getErrorMsg(), 0).g();
                CircleNearFragment.this.Z(false);
                return;
            }
            CircleNearFragment.this.t = baseResponse.getData();
            if (CircleNearFragment.this.t == null || CircleNearFragment.this.t.size() == 0) {
                sy5.f(CircleNearFragment.this.getActivity(), "分类列表为空", 0).g();
                CircleNearFragment.this.Z(false);
            } else {
                CircleNearFragment.this.Z(true);
                CircleNearFragment.this.r0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends FragPageAdapterVp<CircleFirstCateList> {
        public c(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // defpackage.nk2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(TabViewHolder tabViewHolder, int i, CircleFirstCateList circleFirstCateList, boolean z) {
            LogUtil.i("createFragment", "bindDataToTab:" + i + "  " + z);
            TextView textView = (TextView) tabViewHolder.l(R.id.tv);
            if (z) {
                textView.setTextColor(CircleNearFragment.this.getResources().getColor(R.color.color_222222));
                textView.setTypeface(Typeface.defaultFromStyle(1));
                if (circleFirstCateList.cateName.length() <= 2) {
                    CircleNearFragment.this.o.getIndicator().m(me1.b(CircleNearFragment.this.getActivity(), 25));
                } else {
                    CircleNearFragment.this.o.getIndicator().m(me1.b(CircleNearFragment.this.getActivity(), 45));
                }
                if (CircleNearFragment.this.u != null && CircleNearFragment.this.u.size() >= i) {
                    ((CircleNearFirstFragment) CircleNearFragment.this.u.get(i)).T();
                }
            } else {
                textView.setTextColor(CircleNearFragment.this.getResources().getColor(R.color.color_676767));
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
            textView.setText(circleFirstCateList.cateName);
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.BaseFragPageAdapterVp
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Fragment h(CircleFirstCateList circleFirstCateList, int i) {
            LogUtil.i("createFragment", "createFragment:" + i);
            ArrayList<CircleFirstCateList.SecondCate> arrayList = circleFirstCateList.secondCate;
            CircleNearFirstFragment circleNearFirstFragment = (CircleNearFragment.this.u.size() <= 0 || i >= CircleNearFragment.this.u.size()) ? null : (CircleNearFirstFragment) CircleNearFragment.this.u.get(i);
            if (circleNearFirstFragment != null) {
                circleNearFirstFragment.C0();
                return circleNearFirstFragment;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                CircleNearFirstFragment circleNearFirstFragmentM0 = CircleNearFirstFragment.M0(circleFirstCateList.id, null, CircleNearFragment.this.s, CircleNearFragment.this.m);
                CircleNearFragment.this.u.add(i, circleNearFirstFragmentM0);
                return circleNearFirstFragmentM0;
            }
            CircleNearFirstFragment circleNearFirstFragmentM02 = CircleNearFirstFragment.M0(circleFirstCateList.id, arrayList, CircleNearFragment.this.s, CircleNearFragment.this.m);
            CircleNearFragment.this.u.add(i, circleNearFirstFragmentM02);
            return circleNearFirstFragmentM02;
        }

        @Override // defpackage.nk2
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int b(int i, CircleFirstCateList circleFirstCateList) {
            return R.layout.tablayout_item;
        }
    }

    public static CircleNearFragment s0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        CircleNearFragment circleNearFragment = new CircleNearFragment();
        circleNearFragment.setArguments(bundle);
        return circleNearFragment;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void R() {
        super.R();
        p0();
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_circle_near, viewGroup, false);
        this.n = (TabLayoutScroll) viewInflate.findViewById(R.id.tablayout);
        this.o = (IndicatorLineView) viewInflate.findViewById(R.id.indicator);
        this.p = (ViewPager) viewInflate.findViewById(R.id.view_pager);
        this.q = (RelativeLayout) viewInflate.findViewById(R.id.layout_permission);
        this.r = (TextView) viewInflate.findViewById(R.id.text_permission);
        this.w = (NestedScrollView) viewInflate.findViewById(R.id.nest_scroll_view);
        this.r.setOnClickListener(this);
        return viewInflate;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        LogUtil.d("CircleNearFragment", "load data");
        if (p0()) {
            y0();
        } else {
            this.w.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.text_permission) {
            x0();
        }
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.m = getArguments().getInt("type", -1);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        if (locationEx == null) {
            ry5.a("获取位置信息失败");
            LogUtil.d("CircleNearFragment", "location is null");
            return;
        }
        this.s = locationEx;
        LogUtil.d("CircleNearFragment", "location:" + this.s.toString());
        if (this.t == null) {
            w0();
        }
    }

    public final boolean p0() {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(AppContext.getContext(), g.g) == 0;
    }

    public final void r0() {
        this.u = new ArrayList(this.t.size());
        this.p.setOffscreenPageLimit(this.t.size());
        this.n.setSpace_horizontal(me1.b(getActivity(), 20));
        this.v = new c(getChildFragmentManager(), 1);
        TabAdapter tabAdapterA = new ss5(this.n, this.p).A(this.v);
        this.v.f(this.t);
        tabAdapterA.f(this.t);
    }

    public void t0(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (shouldShowRequestPermissionRationale(g.g)) {
            ry5.a("已拒绝权限");
        } else {
            ry5.a("已多次拒绝权限,请手动开启权限后再试");
        }
    }

    public void u0(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        y0();
    }

    public final void w0() {
        this.w.setVisibility(8);
        if (getActivity() == null || getActivity().isFinishing()) {
            Z(false);
        } else if (hx3.m(getActivity())) {
            L();
            c70.R().E(new b());
        } else {
            sy5.f(getActivity(), getActivity().getString(R.string.network_error), 0).g();
            Z(false);
        }
    }

    public final void x0() {
        BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getActivity(), BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_GET_LOCATION);
    }

    public final void y0() {
        Z(false);
        d.g().k(LocationScene.GROUP_NEARBY, new a());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {
        public a() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            CircleNearFragment.this.onLocationReceived(locationEx, i, str);
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
    }
}
