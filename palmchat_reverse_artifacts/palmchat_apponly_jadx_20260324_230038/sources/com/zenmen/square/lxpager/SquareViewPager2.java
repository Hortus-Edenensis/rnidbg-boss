package com.zenmen.square.lxpager;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.widget.NoneRefreshFooter;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.fragment.FeedDetailFragment;
import com.zenmen.square.ui.widget.FullMediaGuideView;
import com.zenmen.square.ui.widget.SquarePullHeader;
import defpackage.hg1;
import defpackage.py5;
import defpackage.q66;
import defpackage.tb4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareViewPager2 extends LxRelativeLayout {
    private View backView;
    private hg1 dragCloseHelper;
    FullMediaGuideView guideView;
    private LxFragmentStateAdapter mAdapter;
    private PagerFragment mCurrentFragment;
    private View mInfoLayout;
    private ViewPager2.OnPageChangeCallback mPageChangCallback;
    private ViewPager2 mPager2;
    private tb4 mPagerListModel;
    private SmartRefreshLayout mRefreshLayout;
    private boolean needRefresh;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            if (i == 0 && (SquareViewPager2.this.mCurrentFragment instanceof FeedDetailFragment)) {
                q66.b(SquareViewPager2.this.mCurrentFragment.getActivity(), SquareViewPager2.this.mCurrentFragment.getSid());
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (i < 0 || i >= SquareViewPager2.this.mAdapter.getItemCount()) {
                return;
            }
            SquareViewPager2 squareViewPager2 = SquareViewPager2.this;
            squareViewPager2.mCurrentFragment = squareViewPager2.mAdapter.b(i);
            if (SquareViewPager2.this.mCurrentFragment == null) {
                return;
            }
            q66.c = i;
            SquareViewPager2 squareViewPager22 = SquareViewPager2.this;
            squareViewPager22.mInfoLayout = squareViewPager22.mCurrentFragment.D();
            SquareViewPager2.this.mCurrentFragment.L(SquareViewPager2.this.dragCloseHelper);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements hg1.e {
        public b() {
        }

        @Override // hg1.e
        public void a() {
            SquareViewPager2.this.setBackgroundColor(0);
        }

        @Override // hg1.e
        public void b() {
            if (SquareViewPager2.this.mInfoLayout == null) {
                return;
            }
            SquareViewPager2.this.mInfoLayout.setAlpha(1.0f);
            SquareViewPager2.this.backView.setAlpha(1.0f);
            SquareViewPager2.this.setBackgroundColor(-16777216);
        }

        @Override // hg1.e
        public void c(float f) {
            if (SquareViewPager2.this.mInfoLayout == null) {
                return;
            }
            float fMax = Math.max(0.0f, 1.0f - ((1.0f - f) * 20.0f));
            SquareViewPager2.this.mInfoLayout.setAlpha(fMax);
            SquareViewPager2.this.backView.setAlpha(fMax);
        }

        @Override // hg1.e
        public void d(boolean z) {
            if (z) {
                Context context = SquareViewPager2.this.getContext();
                if (context instanceof Activity) {
                    ((Activity) context).onBackPressed();
                }
            }
        }

        @Override // hg1.e
        public boolean intercept() {
            return SquareViewPager2.this.mCurrentFragment == null || SquareViewPager2.this.mCurrentFragment.E() || SquareViewPager2.this.mPager2.getCurrentItem() != 0 || SquareViewPager2.this.needRefresh;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements hg1.f {
        public c() {
        }

        @Override // hg1.f
        public void a() {
            if (SquareViewPager2.this.mCurrentFragment != null) {
                SquareViewPager2.this.mCurrentFragment.K();
            }
        }

        @Override // hg1.f
        public void b() {
            if (SquareViewPager2.this.mCurrentFragment != null) {
                SquareViewPager2.this.mCurrentFragment.J();
            }
        }

        @Override // hg1.f
        public void c() {
            FullMediaGuideView fullMediaGuideView = SquareViewPager2.this.guideView;
            if (fullMediaGuideView == null || fullMediaGuideView.getVisibility() != 0) {
                return;
            }
            SquareViewPager2.this.guideView.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16412a;

        public d(int i) {
            this.f16412a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareViewPager2 squareViewPager2 = SquareViewPager2.this;
            squareViewPager2.mCurrentFragment = squareViewPager2.mAdapter.b(this.f16412a);
        }
    }

    public SquareViewPager2(Context context) {
        super(context);
        this.mPageChangCallback = new a();
        this.needRefresh = false;
    }

    private void addGuideAnimation() {
        tb4 tb4Var = this.mPagerListModel;
        if (tb4Var == null || tb4Var.n()) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
        if (sPUtil.a(scene, "key_square_detail_show_guide", false)) {
            return;
        }
        sPUtil.t(scene, "key_square_detail_show_guide", Boolean.TRUE);
        this.guideView.setVisibility(0);
        this.guideView.startAnimation();
    }

    private void initDragViewHelper() {
        hg1 hg1Var = new hg1(getContext());
        this.dragCloseHelper = hg1Var;
        hg1Var.v(false);
        this.dragCloseHelper.t(this, this);
        this.dragCloseHelper.s(new b());
        this.dragCloseHelper.u(new c());
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        setBackgroundColor(-16777216);
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        this.mRefreshLayout = smartRefreshLayout;
        smartRefreshLayout.setRefreshFooter(new NoneRefreshFooter(context));
        addView(this.mRefreshLayout, -1, -1);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mPager2 = viewPager2;
        this.mRefreshLayout.addView(viewPager2, -1, -1);
        this.mPager2.setOrientation(1);
        this.mPager2.setOffscreenPageLimit(1);
        FullMediaGuideView fullMediaGuideView = new FullMediaGuideView(context);
        this.guideView = fullMediaGuideView;
        fullMediaGuideView.setVisibility(8);
        addView(this.guideView, -1, -1);
        initDragViewHelper();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FullMediaGuideView fullMediaGuideView;
        if (this.dragCloseHelper.o(motionEvent)) {
            return true;
        }
        if (motionEvent.getAction() != 1 || (fullMediaGuideView = this.guideView) == null || fullMediaGuideView.getVisibility() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.guideView.setVisibility(8);
        motionEvent.setAction(3);
        return super.dispatchTouchEvent(motionEvent);
    }

    public LxFragmentStateAdapter getAdapter() {
        return this.mAdapter;
    }

    public PagerFragment getCurrentFragment() {
        return this.mCurrentFragment;
    }

    public SmartRefreshLayout getRefreshLayout() {
        return this.mRefreshLayout;
    }

    public ViewPager2 getViewPager2() {
        return this.mPager2;
    }

    public void insertedItem(int i) {
        this.mAdapter.notifyItemInserted(i);
    }

    public void loadMore(List<BasePagerBean> list, int i, int i2) {
        this.mAdapter.l(list, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mPager2.registerOnPageChangeCallback(this.mPageChangCallback);
        addGuideAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPager2.unregisterOnPageChangeCallback(this.mPageChangCallback);
    }

    public void refresh(List<BasePagerBean> list) {
        LxFragmentStateAdapter lxFragmentStateAdapter = this.mAdapter;
        if (lxFragmentStateAdapter != null) {
            lxFragmentStateAdapter.n(list);
        }
    }

    public void removeItem(int i) {
        this.mAdapter.notifyItemRemoved(i);
        if (this.mAdapter.getItemCount() > 0 && this.mAdapter.getItemCount() - i > 0) {
            LxFragmentStateAdapter lxFragmentStateAdapter = this.mAdapter;
            lxFragmentStateAdapter.notifyItemRangeChanged(i, lxFragmentStateAdapter.getItemCount() - i);
        }
        if (this.mAdapter.getItemCount() == 0 && (getContext() instanceof Activity)) {
            ((Activity) getContext()).onBackPressed();
        }
    }

    public void setAdapter(LxFragmentStateAdapter lxFragmentStateAdapter) {
        this.mAdapter = lxFragmentStateAdapter;
        this.mPager2.setAdapter(lxFragmentStateAdapter);
    }

    public void setBackView(View view) {
        this.backView = view;
    }

    public void setCurrentItem(int i) {
        this.mPager2.setCurrentItem(i, false);
        postDelayed(new d(i), 100L);
    }

    public void setNeedRefresh(boolean z) {
        this.needRefresh = z;
        if (z) {
            SquarePullHeader squarePullHeader = new SquarePullHeader(getContext());
            squarePullHeader.setHideSuccess(true);
            this.mRefreshLayout.setRefreshHeader(squarePullHeader);
            this.mRefreshLayout.setEnableRefresh(true);
        }
    }

    public void setOffscreenPageLimit(int i) {
        this.mPager2.setOffscreenPageLimit(i);
    }

    public void setOrientation(int i) {
        this.mPager2.setOrientation(i);
    }

    public void setPagerListModel(tb4 tb4Var) {
        this.mPagerListModel = tb4Var;
    }

    public void showMessage(String str) {
        py5.b().d(getContext(), str, 0);
    }

    public void updateItem(int i) {
        this.mAdapter.notifyItemChanged(i);
    }

    public SquareViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPageChangCallback = new a();
        this.needRefresh = false;
    }

    public SquareViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPageChangCallback = new a();
        this.needRefresh = false;
    }

    public SquareViewPager2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPageChangCallback = new a();
        this.needRefresh = false;
    }
}
