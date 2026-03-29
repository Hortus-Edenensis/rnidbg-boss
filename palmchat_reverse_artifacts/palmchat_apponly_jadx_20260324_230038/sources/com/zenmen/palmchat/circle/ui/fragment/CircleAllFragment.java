package com.zenmen.palmchat.circle.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.openapi.config.LxApiProxy;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleFirstCateList;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.FragPageAdapterVp;
import com.zenmen.palmchat.circle.ui.adapter.TabAdapter;
import com.zenmen.palmchat.circle.ui.view.IndicatorLineView;
import com.zenmen.palmchat.circle.ui.view.TabLayoutScroll;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;
import defpackage.c70;
import defpackage.hx3;
import defpackage.me1;
import defpackage.ss5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAllFragment extends CircleLoadFragment {
    public ViewPager m;
    public TabLayoutScroll n;
    public IndicatorLineView o;
    public List<CircleFindFirstFragment> p;
    public ArrayList<CircleFirstCateList> q;
    public FragPageAdapterVp<CircleFirstCateList> r;
    public int s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<ArrayList<CircleFirstCateList>>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<CircleFirstCateList>> baseResponse) {
            CircleAllFragment.this.G();
            if (CircleAllFragment.this.getActivity() == null || CircleAllFragment.this.getActivity().isFinishing()) {
                CircleAllFragment.this.Z(false);
                return;
            }
            if (baseResponse == null) {
                sy5.f(CircleAllFragment.this.getActivity(), "接口异常", 0).g();
                CircleAllFragment.this.Z(false);
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                sy5.f(CircleAllFragment.this.getActivity(), TextUtils.isEmpty(baseResponse.getErrorMsg()) ? CircleAllFragment.this.getString(R.string.default_response_error) : baseResponse.getErrorMsg(), 0).g();
                CircleAllFragment.this.Z(false);
                return;
            }
            CircleAllFragment.this.q = baseResponse.getData();
            if (CircleAllFragment.this.q == null || CircleAllFragment.this.q.size() == 0) {
                sy5.f(CircleAllFragment.this.getActivity(), "分类列表为空", 0).g();
                CircleAllFragment.this.Z(false);
                return;
            }
            if (!LxApiProxy.getInstance().getConfigApi().b()) {
                for (CircleFirstCateList circleFirstCateList : CircleAllFragment.this.q) {
                    if (TextUtils.equals("推荐", circleFirstCateList.cateName)) {
                        circleFirstCateList.cateName = "精选";
                    }
                }
            }
            CircleAllFragment.this.n0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends FragPageAdapterVp<CircleFirstCateList> {
        public b(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // defpackage.nk2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(TabViewHolder tabViewHolder, int i, CircleFirstCateList circleFirstCateList, boolean z) {
            Log.i("createFragment", "bindDataToTab:" + i + "  " + z);
            TextView textView = (TextView) tabViewHolder.l(R.id.tv);
            if (z) {
                textView.setTextColor(CircleAllFragment.this.getResources().getColor(R.color.color_222222));
                textView.setTypeface(Typeface.defaultFromStyle(1));
                if (circleFirstCateList.cateName.length() <= 2) {
                    CircleAllFragment.this.o.getIndicator().m(me1.b(CircleAllFragment.this.getActivity(), 25));
                } else {
                    CircleAllFragment.this.o.getIndicator().m(me1.b(CircleAllFragment.this.getActivity(), 45));
                }
                if (CircleAllFragment.this.p != null && CircleAllFragment.this.p.size() >= i) {
                    ((CircleFindFirstFragment) CircleAllFragment.this.p.get(i)).T();
                }
            } else {
                textView.setTextColor(CircleAllFragment.this.getResources().getColor(R.color.color_676767));
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
            textView.setText(circleFirstCateList.cateName);
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.BaseFragPageAdapterVp
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Fragment h(CircleFirstCateList circleFirstCateList, int i) {
            Log.i("createFragment", "createFragment:" + i);
            ArrayList<CircleFirstCateList.SecondCate> arrayList = circleFirstCateList.secondCate;
            CircleFindFirstFragment circleFindFirstFragment = (CircleAllFragment.this.p.size() <= 0 || i >= CircleAllFragment.this.p.size()) ? null : (CircleFindFirstFragment) CircleAllFragment.this.p.get(i);
            if (circleFindFirstFragment != null) {
                circleFindFirstFragment.E0();
                return circleFindFirstFragment;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                CircleFindFirstFragment circleFindFirstFragmentN0 = CircleFindFirstFragment.N0(circleFirstCateList.id, null, CircleAllFragment.this.s);
                CircleAllFragment.this.p.add(i, circleFindFirstFragmentN0);
                return circleFindFirstFragmentN0;
            }
            CircleFindFirstFragment circleFindFirstFragmentN02 = CircleFindFirstFragment.N0(circleFirstCateList.id, arrayList, CircleAllFragment.this.s);
            CircleAllFragment.this.p.add(i, circleFindFirstFragmentN02);
            return circleFindFirstFragmentN02;
        }

        @Override // defpackage.nk2
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int b(int i, CircleFirstCateList circleFirstCateList) {
            return R.layout.tablayout_item;
        }
    }

    public static CircleAllFragment p0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        CircleAllFragment circleAllFragment = new CircleAllFragment();
        circleAllFragment.setArguments(bundle);
        return circleAllFragment;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_circle_all, viewGroup, false);
        this.n = (TabLayoutScroll) viewInflate.findViewById(R.id.tablayout);
        this.m = (ViewPager) viewInflate.findViewById(R.id.view_pager);
        this.o = (IndicatorLineView) viewInflate.findViewById(R.id.indicator);
        return viewInflate;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        r0();
    }

    public final void n0() {
        this.p = new ArrayList(this.q.size());
        this.m.setOffscreenPageLimit(this.q.size());
        this.n.setSpace_horizontal(me1.b(getActivity(), 20));
        this.r = new b(getChildFragmentManager(), 1);
        TabAdapter tabAdapterA = new ss5(this.n, this.m).A(this.r);
        this.r.f(this.q);
        tabAdapterA.f(this.q);
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.s = getArguments().getInt("type", -1);
    }

    public final void r0() {
        if (getActivity() == null || getActivity().isFinishing()) {
            Z(false);
        }
        if (!hx3.m(getActivity())) {
            sy5.f(getActivity(), getActivity().getString(R.string.network_error), 0).g();
            Z(false);
        }
        L();
        c70.R().E(new a());
    }
}
