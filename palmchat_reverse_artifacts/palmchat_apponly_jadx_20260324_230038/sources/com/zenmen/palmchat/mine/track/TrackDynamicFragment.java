package com.zenmen.palmchat.mine.track;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.listui.list.PageState;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.DynamicTrackRecycleviewItemBinding;
import com.zenmen.palmchat.databinding.FragmentTrackCommonBinding;
import com.zenmen.palmchat.databinding.UserTrackFooterViewBinding;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.mine.track.DynamicTrackBean;
import com.zenmen.palmchat.square.SMultRecycleAdapter;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.ListStateView;
import com.zenmen.square.ui.widget.SquarePullHeader;
import defpackage.a46;
import defpackage.ai5;
import defpackage.b05;
import defpackage.c74;
import defpackage.j74;
import defpackage.k86;
import defpackage.me1;
import defpackage.q05;
import defpackage.wz5;
import defpackage.xu4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TrackDynamicFragment extends BaseFragment {
    public int f;
    public FragmentTrackCommonBinding g;
    public View.OnClickListener h = new d();
    public SMultRecycleAdapter i = new e();
    public HashSet<String> j = new HashSet<>();
    public int k = 0;
    public boolean l = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicTrackBean.DynamicTrackBeanList f14714a;

        public a(DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList) {
            this.f14714a = dynamicTrackBeanList;
            put("tab", 2);
            put("subtab", Integer.valueOf(TrackDynamicFragment.this.f + 1));
            put("tuid", dynamicTrackBeanList.getUid());
            put("page", Integer.valueOf(dynamicTrackBeanList.getPage()));
            put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(dynamicTrackBeanList.getPosition()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements q05.d<LXBaseNetBean<DynamicTrackBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14715a;
        public final /* synthetic */ xu4 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Long d;

        public b(boolean z, xu4 xu4Var, int i, Long l) {
            this.f14715a = z;
            this.b = xu4Var;
            this.c = i;
            this.d = l;
        }

        @Override // q05.d
        public void a(Exception exc) {
            TrackDynamicFragment trackDynamicFragment = TrackDynamicFragment.this;
            if (!trackDynamicFragment.l) {
                trackDynamicFragment.l = true;
            }
            if (this.f14715a) {
                this.b.finishLoadMore(false);
            } else {
                trackDynamicFragment.e0(new PageState(PageState.State.ERROR, null));
                this.b.finishRefresh(false);
            }
        }

        @Override // q05.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(LXBaseNetBean<DynamicTrackBean> lXBaseNetBean) {
            DynamicTrackBean dynamicTrackBean;
            DynamicTrackBean dynamicTrackBean2;
            DynamicTrackBean dynamicTrackBean3;
            DynamicTrackBean dynamicTrackBean4;
            if (q05.o(TrackDynamicFragment.this.getActivity())) {
                return;
            }
            TrackDynamicFragment trackDynamicFragment = TrackDynamicFragment.this;
            if (!trackDynamicFragment.l) {
                trackDynamicFragment.l = true;
            }
            trackDynamicFragment.e0(new PageState(PageState.State.NORMAL, null));
            if (!this.f14715a) {
                TrackDynamicFragment.this.i.b().clear();
                this.b.finishRefresh();
            } else if (lXBaseNetBean == null || (dynamicTrackBean = lXBaseNetBean.data) == null || dynamicTrackBean.getResultList() == null || !lXBaseNetBean.data.getResultList().isEmpty()) {
                this.b.finishLoadMore();
            } else {
                this.b.finishLoadMoreWithNoMoreData();
            }
            if (lXBaseNetBean != null && (dynamicTrackBean4 = lXBaseNetBean.data) != null && dynamicTrackBean4.getResultList() != null && lXBaseNetBean.data.getResultList().size() > 0) {
                TrackDynamicFragment.this.k = this.c;
                if (this.d.longValue() == 0) {
                    b05.d("设置可以滚动");
                    this.b.setEnableLoadMore(true);
                }
                int i = 0;
                while (i < lXBaseNetBean.data.getResultList().size()) {
                    lXBaseNetBean.data.getResultList().get(i).setPage(TrackDynamicFragment.this.k + 1);
                    DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList = lXBaseNetBean.data.getResultList().get(i);
                    i++;
                    dynamicTrackBeanList.setPosition(i);
                }
                TrackDynamicFragment.this.i.b().addAll(lXBaseNetBean.data.getResultList());
            }
            if (!this.f14715a) {
                if (lXBaseNetBean == null || (dynamicTrackBean3 = lXBaseNetBean.data) == null) {
                    TrackDynamicFragment.this.e0(new PageState(PageState.State.ERROR, null));
                } else if (dynamicTrackBean3.getResultList() == null || lXBaseNetBean.data.getResultList().isEmpty()) {
                    TrackDynamicFragment.this.e0(new PageState(PageState.State.EMPTY, null));
                } else {
                    TrackDynamicFragment.this.e0(new PageState(PageState.State.NORMAL, null));
                }
            }
            if (lXBaseNetBean != null && (dynamicTrackBean2 = lXBaseNetBean.data) != null && ((dynamicTrackBean2.getResultList() == null || lXBaseNetBean.data.getResultList().isEmpty()) && this.f14715a)) {
                for (int size = TrackDynamicFragment.this.i.b().size() - 1; size >= 0; size--) {
                    if (TrackDynamicFragment.this.i.b().get(size) instanceof String) {
                        TrackDynamicFragment.this.i.b().remove(size);
                    }
                }
                TrackDynamicFragment.this.i.b().add(lXBaseNetBean.data.getBottomTip());
            }
            TrackDynamicFragment.this.i.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("tab", 2);
            put("subtab", Integer.valueOf(TrackDynamicFragment.this.f + 1));
            put("vague", 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PageState.State state = TrackDynamicFragment.this.g.c.getState().f11843a;
            if (state == PageState.State.LOADING || state == PageState.State.EMPTY) {
                return;
            }
            TrackDynamicFragment.this.g.b.autoRefresh();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends SMultRecycleAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SMultRecycleAdapter.a<SMultRecycleAdapter.ViewHolder> {
            public a() {
            }

            @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.a
            public SMultRecycleAdapter.ViewHolder a(ViewGroup viewGroup) {
                return TrackDynamicFragment.this.new m(DynamicTrackRecycleviewItemBinding.b(TrackDynamicFragment.this.getLayoutInflater(), viewGroup, false));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements SMultRecycleAdapter.a<SMultRecycleAdapter.ViewHolder> {
            public b() {
            }

            @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.a
            public SMultRecycleAdapter.ViewHolder a(ViewGroup viewGroup) {
                return TrackDynamicFragment.this.new n(UserTrackFooterViewBinding.b(TrackDynamicFragment.this.getLayoutInflater(), viewGroup, false));
            }
        }

        public e() {
            a(DynamicTrackBean.DynamicTrackBeanList.class, new a());
            a(String.class, new b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StaggeredGridLayoutManager f14720a;

        public f(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f14720a = staggeredGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            this.f14720a.invalidateSpanAssignments();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends RecyclerView.ItemDecoration {
        public final /* synthetic */ int b;

        public g(int i) {
            this.b = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int i = this.b;
            rect.bottom = i * 2;
            rect.left = i;
            rect.right = i;
            rect.top = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements j74 {
        public h() {
        }

        @Override // defpackage.j74
        public void a(@NonNull xu4 xu4Var) {
            TrackDynamicFragment.this.Z(false, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements c74 {
        public i() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            TrackDynamicFragment.this.Z(true, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends RecyclerView.OnScrollListener {
        public j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            b05.a("mRecycleview===》滑动的时候");
            TrackDynamicFragment.this.c0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b05.a("mRecycleview===》加载完成的时候");
            TrackDynamicFragment.this.c0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends SMultRecycleAdapter.ViewHolder<DynamicTrackBean.DynamicTrackBeanList> {
        public static int g;
        public DynamicTrackRecycleviewItemBinding d;
        public String e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DynamicTrackBean.DynamicTrackBeanList f14726a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.mine.track.TrackDynamicFragment$m$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1077a extends HashMap<String, Object> {
                public C1077a() {
                    put("subtab", Integer.valueOf(TrackDynamicFragment.this.f + 1));
                    put("tuid", a.this.f14726a.getUid());
                    put("page", Integer.valueOf(a.this.f14726a.getPage()));
                    put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(a.this.f14726a.getPosition()));
                }
            }

            public a(DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList) {
                this.f14726a = dynamicTrackBeanList;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q05.p()) {
                    return;
                }
                int i = 109;
                if (TrackDynamicFragment.this.f != 0) {
                    if (TrackDynamicFragment.this.f == 1) {
                        i = 110;
                    } else if (TrackDynamicFragment.this.f == 2) {
                        i = 111;
                    }
                }
                if (TrackDynamicFragment.this.i.b() != null) {
                    q05.a("pagefootprint_postclick", 0, new C1077a());
                    try {
                        ArrayList arrayList = new ArrayList();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_feed_uid", this.f14726a.getFeedId().toString());
                        if (this.f14726a.getFeedType().intValue() == 1) {
                            SquareFeed squareFeed = new SquareFeed();
                            squareFeed.id = this.f14726a.getFeedId().longValue();
                            squareFeed.feedType = this.f14726a.getFeedType().intValue();
                            squareFeed.uid = this.f14726a.getUid().toString();
                            squareFeed.exid = null;
                            MediaViewActivity.B1(i, TrackDynamicFragment.this.getActivity(), squareFeed, false);
                            return;
                        }
                        for (int i2 = 0; i2 < TrackDynamicFragment.this.i.b().size(); i2++) {
                            if (TrackDynamicFragment.this.i.b().get(i2) instanceof DynamicTrackBean.DynamicTrackBeanList) {
                                DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList = (DynamicTrackBean.DynamicTrackBeanList) TrackDynamicFragment.this.i.b().get(i2);
                                if (dynamicTrackBeanList.getFeedType().intValue() != 1) {
                                    SquareFeed squareFeed2 = new SquareFeed();
                                    squareFeed2.id = dynamicTrackBeanList.getFeedId().longValue();
                                    squareFeed2.uid = dynamicTrackBeanList.getUid().toString();
                                    squareFeed2.exid = null;
                                    squareFeed2.version = dynamicTrackBeanList.getVersion().longValue();
                                    squareFeed2.feedType = dynamicTrackBeanList.getFeedType().intValue();
                                    arrayList.add(squareFeed2);
                                }
                            }
                        }
                        int i3 = 0;
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            if (this.f14726a.getFeedId().longValue() == ((SquareFeed) arrayList.get(i4)).id) {
                                i3 = i4;
                            }
                        }
                        bundle.putInt("key_target_position", i3);
                        MediaViewActivity.C1(i, arrayList, TrackDynamicFragment.this.getActivity(), bundle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ImageView f14728a;
            public final /* synthetic */ String b;

            public b(ImageView imageView, String str) {
                this.f14728a = imageView;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a46.u(a46.h(this.f14728a, k86.p(this.b)), this.f14728a, R.drawable.bg_feed_item_loading);
            }
        }

        public m(DynamicTrackRecycleviewItemBinding dynamicTrackRecycleviewItemBinding) {
            super(dynamicTrackRecycleviewItemBinding.getRoot());
            this.d = dynamicTrackRecycleviewItemBinding;
        }

        @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.ViewHolder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void l(DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList, int i) {
            this.d.f.setVisibility(dynamicTrackBeanList.getFeedType().intValue() == 3 ? 0 : 8);
            this.d.c.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopLeftCornerSize(me1.b(TrackDynamicFragment.this.getContext(), 8)).setTopRightCornerSize(me1.b(TrackDynamicFragment.this.getContext(), 8)).setBottomLeftCornerSize(0.0f).setBottomRightCornerSize(0.0f).build());
            if (dynamicTrackBeanList.getFeedType().intValue() == 2 || dynamicTrackBeanList.getFeedType().intValue() == 3) {
                String strN = n(dynamicTrackBeanList.getMediaList(), dynamicTrackBeanList.getFeedType().intValue());
                if (TextUtils.isEmpty(strN) || TextUtils.equals(this.e, strN)) {
                    return;
                }
                this.e = strN;
                ai5.k().h();
                this.d.g.setVisibility(8);
                o(this.d.c, dynamicTrackBeanList.getMediaList(), strN);
            } else if (dynamicTrackBeanList.getFeedType().intValue() == 1) {
                p(dynamicTrackBeanList.getContent());
            }
            if (TextUtils.isEmpty(dynamicTrackBeanList.getContent())) {
                this.d.f13893a.setVisibility(8);
            } else {
                this.d.f13893a.setText(dynamicTrackBeanList.getContent());
                this.d.f13893a.setVisibility(0);
            }
            this.d.b.setAvatarView(dynamicTrackBeanList.getAvatar(), null);
            if (dynamicTrackBeanList.getGender() == null || dynamicTrackBeanList.getGender().intValue() != 1) {
                this.d.e.setImageResource(R.drawable.icon_sex_male);
            } else {
                this.d.e.setImageResource(R.drawable.icon_sex_female);
            }
            if (TextUtils.isEmpty(dynamicTrackBeanList.getNickname())) {
                this.d.d.setText("");
            } else {
                this.d.d.setText(dynamicTrackBeanList.getNickname());
            }
            this.d.getRoot().setOnClickListener(new a(dynamicTrackBeanList));
        }

        public final String n(List<DynamicTrackBean.TrackMediaList> list, int i) {
            if (i == 3) {
                if (list == null || list.isEmpty()) {
                    return null;
                }
                return list.get(0).getVideoUrl();
            }
            if (i != 2 || list == null || list.isEmpty()) {
                return null;
            }
            return list.get(0).getThumbUrl();
        }

        public final void o(ImageView imageView, List<DynamicTrackBean.TrackMediaList> list, String str) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.bg_track_item_loading);
            q(imageView, list.get(0));
            imageView.post(new b(imageView, str));
        }

        public void p(String str) {
            r(this.d.c);
            this.d.c.setBackgroundResource(R.drawable.icon_track_dynamic_text_bg);
            this.d.c.setImageDrawable(null);
            this.d.g.setVisibility(0);
            this.d.g.setText(str);
        }

        public ViewGroup.LayoutParams q(View view, DynamicTrackBean.TrackMediaList trackMediaList) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            if (g == 0) {
                g = (a46.m(this.itemView.getContext()).x / 2) - a46.b(view.getContext(), 12.0f);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).width = g;
            if (Integer.valueOf(trackMediaList.getHeight()).intValue() > Integer.valueOf(trackMediaList.getWidth()).intValue()) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = (g / 3) * 4;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = (g / 4) * 3;
            }
            view.setLayoutParams(layoutParams);
            return layoutParams;
        }

        public void r(View view) {
            if (g == 0) {
                g = (a46.m(this.itemView.getContext()).x / 2) - a46.b(view.getContext(), 12.0f);
            }
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            int i = g;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends SMultRecycleAdapter.ViewHolder<String> {
        public UserTrackFooterViewBinding d;

        public n(UserTrackFooterViewBinding userTrackFooterViewBinding) {
            super(userTrackFooterViewBinding.getRoot());
            this.d = userTrackFooterViewBinding;
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) userTrackFooterViewBinding.getRoot().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                userTrackFooterViewBinding.getRoot().setLayoutParams(layoutParams);
            }
            layoutParams.setFullSpan(true);
        }

        @Override // com.zenmen.palmchat.square.SMultRecycleAdapter.ViewHolder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void l(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                this.d.f13916a.setText("");
            } else {
                this.d.f13916a.setText(str);
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        ViewPager viewPagerW;
        b05.a("onUserVisibleChange===>" + z + ",index==>" + this.f);
        if (!z || (viewPagerW = W()) == null) {
            return;
        }
        int currentItem = viewPagerW.getCurrentItem();
        if (currentItem == this.f) {
            b05.a("正常加载数据");
            if (!this.l) {
                this.l = true;
                this.g.b.autoRefresh();
            }
            q05.a("pagefootprint", 0, new c());
            return;
        }
        b05.a("忽略错误的可见性回调：当前页面=" + currentItem + "，Fragment索引=" + this.f);
    }

    public RecyclerView.LayoutManager V() {
        return new StaggeredGridLayoutManager(2, 1);
    }

    public final ViewPager W() {
        if (getParentFragment() instanceof DynamicTrackFragment) {
            return ((DynamicTrackFragment) getParentFragment()).i.f13895a;
        }
        return null;
    }

    public final void Y() {
        this.g.c.setOnClickListener(this.h);
        this.g.c.setTopMargin(a46.b(getContext(), 80.0f));
        this.g.c.setImageSize(a46.b(getContext(), 180.0f), a46.b(getContext(), 143.0f));
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) V();
        staggeredGridLayoutManager.setGapStrategy(0);
        this.g.f13898a.addOnScrollListener(new f(staggeredGridLayoutManager));
        this.g.f13898a.setLayoutManager(staggeredGridLayoutManager);
        this.g.f13898a.setAdapter(this.i);
        int iB = a46.b(getContext(), 4.0f);
        this.g.f13898a.setPadding(iB, 0, iB, iB);
        this.g.f13898a.addItemDecoration(new g(iB));
        this.g.b.setEnableLoadMore(false);
        this.g.b.setOnRefreshListener(new h());
        this.g.b.setOnLoadMoreListener(new i());
        this.g.b.setRefreshHeader(new SquarePullHeader(getContext()));
        this.g.b.setRefreshFooter(new SAppUtil.CustomClassicsFooter(getContext()));
        this.g.f13898a.addOnScrollListener(new j());
        int i2 = this.f;
        String str = i2 == 0 ? "暂无动态浏览记录" : i2 == 1 ? "暂无评论过的动态" : "";
        if (i2 == 2) {
            str = "暂无赞过的动态";
        }
        this.g.c.setEmptyString(str);
        this.g.f13898a.post(new k());
        this.i.registerAdapterDataObserver(new l());
    }

    public void Z(boolean z, xu4 xu4Var) {
        int i2;
        long jLongValue = 0;
        if (z) {
            SMultRecycleAdapter sMultRecycleAdapter = this.i;
            if (sMultRecycleAdapter != null && sMultRecycleAdapter.b().size() > 0) {
                if (this.i.b().get(this.i.b().size() - 1) instanceof DynamicTrackBean.DynamicTrackBeanList) {
                    jLongValue = ((DynamicTrackBean.DynamicTrackBeanList) this.i.b().get(this.i.b().size() - 1)).getVersion().longValue();
                } else if (this.i.b().size() > 1 && (this.i.b().get(this.i.b().size() - 2) instanceof DynamicTrackBean.DynamicTrackBeanList)) {
                    jLongValue = ((DynamicTrackBean.DynamicTrackBeanList) this.i.b().get(this.i.b().size() - 2)).getVersion().longValue();
                }
            }
            i2 = this.k + 1;
        } else {
            this.k = 0;
            i2 = 0;
        }
        wz5.i().a(this.f, Long.valueOf(jLongValue), new b(z, xu4Var, i2, Long.valueOf(jLongValue)));
    }

    public final void c0() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g.f13898a.getLayoutManager();
        if (staggeredGridLayoutManager == null || this.i.b() == null) {
            return;
        }
        Integer numValueOf = null;
        int[] iArrFindFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
        int[] iArrFindLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
        Integer numValueOf2 = null;
        for (int i2 = 0; i2 < iArrFindFirstVisibleItemPositions.length; i2++) {
            numValueOf2 = numValueOf2 == null ? Integer.valueOf(iArrFindFirstVisibleItemPositions[i2]) : Integer.valueOf(Math.min(numValueOf2.intValue(), iArrFindFirstVisibleItemPositions[i2]));
        }
        for (int i3 = 0; i3 < iArrFindLastVisibleItemPositions.length; i3++) {
            numValueOf = numValueOf == null ? Integer.valueOf(iArrFindLastVisibleItemPositions[i3]) : Integer.valueOf(Math.max(numValueOf.intValue(), iArrFindLastVisibleItemPositions[i3]));
        }
        for (int iIntValue = numValueOf2.intValue(); iIntValue <= numValueOf.intValue(); iIntValue++) {
            b05.a("初始化显示第" + iIntValue + "个");
            if (iIntValue < this.i.b().size() && iIntValue >= 0 && this.i.b().size() > 0 && (this.i.b().get(iIntValue) instanceof DynamicTrackBean.DynamicTrackBeanList)) {
                DynamicTrackBean.DynamicTrackBeanList dynamicTrackBeanList = (DynamicTrackBean.DynamicTrackBeanList) this.i.b().get(iIntValue);
                String string = dynamicTrackBeanList.getFeedId().toString();
                if (!this.j.contains(string)) {
                    this.j.add(string);
                    b05.a("上传数据:" + string);
                    q05.a("pagefootprint_content", 0, new a(dynamicTrackBeanList));
                }
            }
        }
    }

    public void e0(PageState pageState) {
        ListStateView listStateView = this.g.c;
        if (listStateView != null) {
            listStateView.setVisibility(0);
            this.g.c.setState(pageState, R.drawable.icon_track_net_error, R.drawable.icon_track_user_empty);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getInt("ARG_PARAM_INDEX", 0);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentTrackCommonBinding fragmentTrackCommonBindingB = FragmentTrackCommonBinding.b(layoutInflater, viewGroup, false);
        this.g = fragmentTrackCommonBindingB;
        return fragmentTrackCommonBindingB.getRoot();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Y();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends RecyclerView.AdapterDataObserver {
        public l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            TrackDynamicFragment.this.c0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            TrackDynamicFragment.this.c0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            TrackDynamicFragment.this.c0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            TrackDynamicFragment.this.c0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            TrackDynamicFragment.this.c0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            TrackDynamicFragment.this.c0();
        }
    }
}
