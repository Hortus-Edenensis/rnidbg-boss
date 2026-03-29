package com.zenmen.square.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.listui.list.BaseRecyclerView;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.holder.FeedImageViewHolder;
import com.zenmen.square.mvp.holder.FeedVenusShareViewHolder;
import com.zenmen.square.mvp.holder.FeedVideoViewHolder;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareHotCityBean;
import defpackage.a23;
import defpackage.au4;
import defpackage.bj5;
import defpackage.ds0;
import defpackage.ij5;
import defpackage.ir5;
import defpackage.k86;
import defpackage.lb3;
import defpackage.ma3;
import defpackage.mj5;
import defpackage.qm5;
import defpackage.to2;
import defpackage.wh5;
import defpackage.xj5;
import defpackage.yi2;
import defpackage.ym;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RecommendFeedsFragment extends FeedsFragment<au4> implements to2 {
    public SquareHotCityBean u;
    public boolean v = false;
    public int w = 0;
    public SquareFeedEvent x;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if ((layoutManager instanceof LinearLayoutManager) && recyclerView.getAdapter() != null && i == 0) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                for (int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < recyclerView.getAdapter().getItemCount(); iFindFirstVisibleItemPosition++) {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                    if (((viewHolderFindViewHolderForAdapterPosition instanceof FeedImageViewHolder) || (viewHolderFindViewHolderForAdapterPosition instanceof FeedVideoViewHolder) || (viewHolderFindViewHolderForAdapterPosition instanceof FeedVenusShareViewHolder)) && iFindFirstVisibleItemPosition >= 5) {
                        SPUtil sPUtil = SPUtil.f14322a;
                        SPUtil.SCENE scene = SPUtil.SCENE.CONTACT;
                        long jI = sPUtil.i(scene, k86.a("key_inited_time"), -1L);
                        if (ir5.c(true) - jI >= 259200000 || sPUtil.a(scene, k86.a("key_square_share_success"), false)) {
                            bj5.b().a().e0(RecommendFeedsFragment.this.getActivity(), 2);
                            return;
                        }
                        LogUtil.d("loguser", "tryShowDialog: return, initedTime = " + jI);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f16323a;
        public final /* synthetic */ Bundle b;

        public b(List list, Bundle bundle) {
            this.f16323a = list;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaViewActivity.C1(47, this.f16323a, RecommendFeedsFragment.this.getContext(), this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeedEvent f16324a;

        public c(SquareFeedEvent squareFeedEvent) {
            this.f16324a = squareFeedEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareFeedEvent squareFeedEvent = this.f16324a;
            if (squareFeedEvent == null || squareFeedEvent.feed == null || RecommendFeedsFragment.this.k == null) {
                return;
            }
            SquareFeedEvent squareFeedEvent2 = this.f16324a;
            int i = 1;
            if (squareFeedEvent2.eventType == 1 && squareFeedEvent2.feed.visibleType == 0) {
                if (((au4) RecommendFeedsFragment.this.k).e() == null || ((au4) RecommendFeedsFragment.this.k).o() == 1) {
                    RecommendFeedsFragment.this.x = this.f16324a;
                    LogUtil.d("RecommendFeedsFragment", "add feed but datas is empty");
                } else {
                    RecommendFeedsFragment.this.x = null;
                    if (((au4) RecommendFeedsFragment.this.k).e().size() <= 0 || (!((au4) RecommendFeedsFragment.this.k).e().get(0).isHeadTopic && !((au4) RecommendFeedsFragment.this.k).e().get(0).isVipBanner)) {
                        i = 0;
                    }
                    ((au4) RecommendFeedsFragment.this.k).M(i, this.f16324a.feed);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendFeedsFragment recommendFeedsFragment = RecommendFeedsFragment.this;
            recommendFeedsFragment.addSquareFeed(recommendFeedsFragment.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        if (mj5.r().t()) {
            return;
        }
        x();
    }

    @Override // defpackage.to2
    public void A() {
        z(true);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        ma3.a("RecommendFeedsFragment onUserVisibleChange " + z, new Object[0]);
        if (z && this.h && getActivity() != null) {
            xj5.h().o(getActivity());
        }
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.n(z);
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            ij5Var.h(z);
        }
    }

    @qm5
    public void addSquareFeed(SquareFeedEvent squareFeedEvent) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new c(squareFeedEvent));
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public au4 c0() {
        if (this.k == 0) {
            this.k = new au4("square.recommend.list.v8", o(), getSid());
        }
        return (au4) this.k;
    }

    @Override // defpackage.to2
    public /* bridge */ /* synthetic */ RecyclerView e() {
        return super.e();
    }

    @Override // com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.duration.BaseDurationFragment
    public void i(boolean z) {
        super.i(z);
        boolean z2 = false;
        ma3.a("ZMMediaPlayer RecommendFeedsFragment onSupperSelect " + z, new Object[0]);
        ym ymVar = this.q;
        if (ymVar != null) {
            ymVar.n(z && isResumed());
        }
        ij5 ij5Var = this.r;
        if (ij5Var != null) {
            if (z && isResumed()) {
                z2 = true;
            }
            ij5Var.h(z2);
        }
    }

    @Override // com.zenmen.listui.list.BaseListFragment
    public void l0(List<SquareFeed> list) {
        super.l0(list);
        if (this.x != null) {
            getView().post(new d());
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 1;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (o() == 1) {
            wh5.s(c0());
        } else if (o() == 73) {
            wh5.q(c0());
        }
        BaseRecyclerView baseRecyclerViewE = e();
        if (baseRecyclerViewE != null) {
            baseRecyclerViewE.addOnScrollListener(new a());
        }
    }

    @qm5
    public void onCityEvent(yi2 yi2Var) {
        throw null;
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        T(new a23() { // from class: yt4
            @Override // defpackage.a23
            public final void a() {
                this.f22276a.c1();
            }
        });
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ds0.a().d(this);
    }

    @Override // com.zenmen.square.fragment.FeedsFragment, com.zenmen.square.fragment.SquareBaseFragment, com.zenmen.listui.list.BaseListFragment, com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.u != null && this.v) {
            ArrayList arrayList = new ArrayList();
            Bundle bundle = new Bundle();
            arrayList.add(this.u.feed);
            bundle.putString("key_city_name", this.u.cityName);
            bundle.putString("key_city_code", this.u.cityCode);
            if (e() != null) {
                e().postDelayed(new b(arrayList, bundle), 100L);
            }
        }
        this.u = null;
        ma3.a("RecommendFeedsFragment onResume", new Object[0]);
    }

    @Override // com.zenmen.listui.list.BaseListFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ds0.a().c(this);
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        if (lb3Var != null) {
            int iB = lb3Var.b();
            if (iB == 1 || iB == 2) {
                this.v = true;
            }
        }
    }
}
