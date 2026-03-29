package com.zenmen.palmchat.ui.widget.pullrecyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.friendcircle.R$dimen;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.wrapperadapter.HeaderViewWrapperAdapter;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bd;
import defpackage.cx1;
import defpackage.fu4;
import defpackage.gr2;
import defpackage.i74;
import defpackage.k36;
import defpackage.me1;
import defpackage.un2;
import defpackage.w96;
import defpackage.wn2;
import defpackage.xn2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CircleRecyclerViewB extends FrameLayout {
    private static final int ITEM_VIEW_TYPE_FOOTER_START = -99;
    private static final int ITEM_VIEW_TYPE_HEADER_START = -2;
    public static final int REFRESH_TYPE_DEFAULT = 0;
    private static final String TAG = "CircleRecyclerViewB";
    private boolean enableLoadMore;
    private Context mContext;
    private int mDragginOrigin;
    private PullRefreshFooter mFooterView;
    private ArrayList<cx1> mFooterViewInfos;
    private ArrayList<cx1> mHeaderViewInfos;
    private e mIconObserver;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private i mOnStyleStateListener;
    private f mOverScrollListener;
    private RecyclerView mRecyclerView;
    private ImageView mRefreshIcon;
    private int mRefreshIconOffset;
    private int mRefreshIconSize;
    private int mRefreshPosition;
    private h mScrollListener;
    j mState;
    private float mStyleAlpha;
    private float mStyleSwitchOffset;
    private float mStyleSwitchRange;
    private boolean mStyleTransparent;
    private g onPreDispatchTouchListener;
    private i74 onRefreshListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircleRecyclerViewB.this.mIconObserver.e();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements wn2 {
        public b() {
        }

        @Override // defpackage.wn2
        public void a(un2 un2Var, int i, int i2) {
            LogUtil.i(CircleRecyclerViewB.TAG, "Over scroll state change: " + i + " -> " + i2);
            if (i2 == 0) {
                gr2.j().p();
                CircleRecyclerViewB.access$100(CircleRecyclerViewB.this);
                return;
            }
            if (i2 == 1) {
                CircleRecyclerViewB circleRecyclerViewB = CircleRecyclerViewB.this;
                j jVar = circleRecyclerViewB.mState;
                if (jVar == j.IDLE || jVar == j.REFRESHING) {
                    circleRecyclerViewB.mIconObserver.j();
                    CircleRecyclerViewB circleRecyclerViewB2 = CircleRecyclerViewB.this;
                    circleRecyclerViewB2.mDragginOrigin = circleRecyclerViewB2.mRefreshIconOffset;
                    return;
                }
                return;
            }
            if (i2 == 3 && i == 1) {
                CircleRecyclerViewB circleRecyclerViewB3 = CircleRecyclerViewB.this;
                j jVar2 = circleRecyclerViewB3.mState;
                if (jVar2 != j.IDLE) {
                    if (jVar2 == j.REFRESHING) {
                        circleRecyclerViewB3.mIconObserver.h();
                    }
                } else if (circleRecyclerViewB3.mRefreshIconOffset >= CircleRecyclerViewB.this.mRefreshPosition) {
                    CircleRecyclerViewB.this.refresh();
                } else {
                    CircleRecyclerViewB.this.mIconObserver.i();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements xn2 {
        public c() {
        }

        @Override // defpackage.xn2
        public void a(un2 un2Var, int i, float f) {
            LogUtil.i(CircleRecyclerViewB.TAG, "Over scroll: " + f);
            if (i == 1) {
                CircleRecyclerViewB circleRecyclerViewB = CircleRecyclerViewB.this;
                j jVar = circleRecyclerViewB.mState;
                if (jVar == j.IDLE || jVar == j.REFRESHING) {
                    circleRecyclerViewB.mIconObserver.g(CircleRecyclerViewB.this.mDragginOrigin + f);
                    return;
                }
                return;
            }
            if (i == 2) {
                CircleRecyclerViewB circleRecyclerViewB2 = CircleRecyclerViewB.this;
                if (circleRecyclerViewB2.mState == j.IDLE) {
                    circleRecyclerViewB2.isScrollToBottom();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            LogUtil.i(CircleRecyclerViewB.TAG, "Scroll state change: " + i);
            if (i != 0) {
                if (i == 1) {
                    gr2.j().o();
                    if (i == 1) {
                        CircleRecyclerViewB.access$700(CircleRecyclerViewB.this);
                        return;
                    }
                    return;
                }
                return;
            }
            CircleRecyclerViewB circleRecyclerViewB = CircleRecyclerViewB.this;
            j jVar = circleRecyclerViewB.mState;
            if (jVar == j.IDLE) {
                circleRecyclerViewB.mIconObserver.i();
            } else if (jVar == j.REFRESHING) {
                circleRecyclerViewB.mIconObserver.h();
            }
            gr2.j().p();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            CircleRecyclerViewB circleRecyclerViewB;
            j jVar;
            super.onScrolled(recyclerView, i, i2);
            CircleRecyclerViewB.access$700(CircleRecyclerViewB.this);
            if (recyclerView.getScrollState() == 1 && i2 != 0 && CircleRecyclerViewB.this.mRefreshIconOffset > 0 && ((jVar = (circleRecyclerViewB = CircleRecyclerViewB.this).mState) == j.IDLE || jVar == j.REFRESHING)) {
                circleRecyclerViewB.mIconObserver.j();
                CircleRecyclerViewB.this.mIconObserver.g(CircleRecyclerViewB.this.mRefreshIconOffset - i2);
            }
            CircleRecyclerViewB.access$800(CircleRecyclerViewB.this);
            if (CircleRecyclerViewB.this.isScrollToBottom()) {
                CircleRecyclerViewB circleRecyclerViewB2 = CircleRecyclerViewB.this;
                if (circleRecyclerViewB2.mState == j.LOADING_MORE || i2 <= 0 || !circleRecyclerViewB2.enableLoadMore) {
                    return;
                }
                CircleRecyclerViewB.this.loadMore();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f15648a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.g(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends bd {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f15650a = false;

            public b() {
            }

            @Override // defpackage.bd, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f15650a = true;
            }

            @Override // defpackage.bd, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.f15650a) {
                    return;
                }
                e.this.h();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements ValueAnimator.AnimatorUpdateListener {
            public c() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircleRecyclerViewB.this.mRefreshIcon.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends bd {
            public d() {
            }

            @Override // defpackage.bd, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (CircleRecyclerViewB.this.mState != j.REFRESHING) {
                    animator.end();
                    CircleRecyclerViewB.this.mIconObserver.i();
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.ui.widget.pullrecyclerview.CircleRecyclerViewB$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1116e implements ValueAnimator.AnimatorUpdateListener {
            public C1116e() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.f(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        public e() {
        }

        public final ValueAnimator b() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(CircleRecyclerViewB.this.mRefreshIconOffset, 0.0f);
            valueAnimatorOfFloat.setDuration((((long) CircleRecyclerViewB.this.mRefreshIconOffset) * 400) / ((long) CircleRecyclerViewB.this.mRefreshPosition));
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new C1116e());
            return valueAnimatorOfFloat;
        }

        public final ValueAnimator c() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, CircleRecyclerViewB.this.mRefreshPosition);
            valueAnimatorOfFloat.setDuration(400L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.addListener(new b());
            return valueAnimatorOfFloat;
        }

        public final ValueAnimator d() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            valueAnimatorOfFloat.setDuration(400L);
            valueAnimatorOfFloat.setRepeatMode(1);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new c());
            valueAnimatorOfFloat.addListener(new d());
            return valueAnimatorOfFloat;
        }

        public void e() {
            ValueAnimator valueAnimatorC = c();
            this.f15648a = valueAnimatorC;
            valueAnimatorC.start();
        }

        public void f(float f) {
            CircleRecyclerViewB.this.offsetRefreshIcon(f);
        }

        public void g(float f) {
            CircleRecyclerViewB.this.mRefreshIcon.setRotation(2.0f * f);
            CircleRecyclerViewB.this.offsetRefreshIcon(f);
        }

        public void h() {
            ValueAnimator valueAnimatorD = d();
            this.f15648a = valueAnimatorD;
            valueAnimatorD.start();
        }

        public final void i() {
            if (CircleRecyclerViewB.this.mRefreshIconOffset > 0) {
                ValueAnimator valueAnimatorB = b();
                this.f15648a = valueAnimatorB;
                valueAnimatorB.start();
            }
        }

        public void j() {
            ValueAnimator valueAnimator = this.f15648a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f15648a = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum j {
        IDLE,
        REFRESHING,
        LOADING_MORE
    }

    public CircleRecyclerViewB(Context context) {
        this(context, null);
    }

    public static /* synthetic */ f access$100(CircleRecyclerViewB circleRecyclerViewB) {
        circleRecyclerViewB.getClass();
        return null;
    }

    public static /* synthetic */ h access$700(CircleRecyclerViewB circleRecyclerViewB) {
        circleRecyclerViewB.getClass();
        return null;
    }

    public static /* synthetic */ i access$800(CircleRecyclerViewB circleRecyclerViewB) {
        circleRecyclerViewB.getClass();
        return null;
    }

    private void checkAndNotifyWrappedViewAdd(RecyclerView.Adapter adapter, cx1 cx1Var, boolean z) {
        if (adapter == null || (adapter instanceof HeaderViewWrapperAdapter)) {
            return;
        }
        HeaderViewWrapperAdapter headerViewWrapperAdapterWrapHeaderRecyclerViewAdapterInternal = wrapHeaderRecyclerViewAdapterInternal(adapter);
        if (z) {
            headerViewWrapperAdapterWrapHeaderRecyclerViewAdapterInternal.notifyItemInserted(headerViewWrapperAdapterWrapHeaderRecyclerViewAdapterInternal.e(cx1Var.f16943a));
        } else {
            headerViewWrapperAdapterWrapHeaderRecyclerViewAdapterInternal.notifyItemInserted(headerViewWrapperAdapterWrapHeaderRecyclerViewAdapterInternal.d(cx1Var.f16943a));
        }
    }

    private boolean checkFixedViewInfoNotAdded(cx1 cx1Var, List<cx1> list) {
        if (isListEmpty(list) || cx1Var == null) {
            return true;
        }
        Iterator<cx1> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().f16943a == cx1Var.f16943a) {
                return false;
            }
        }
        return true;
    }

    private void init(Context context) {
        this.mContext = context;
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.view_recyclerview, (ViewGroup) this, false);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.mRecyclerView.setItemAnimator(null);
        addView(this.mRecyclerView, -1, -1);
        Resources resources = context.getResources();
        k36.g(this.mRecyclerView, -resources.getDimensionPixelSize(R$dimen.circle_recycler_view_overtop));
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        ImageView imageView = new ImageView(context);
        this.mRefreshIcon = imageView;
        imageView.setBackgroundColor(0);
        this.mRefreshIcon.setImageResource(R$drawable.rotate_icon);
        this.mRefreshIconSize = resources.getDimensionPixelSize(R$dimen.circle_recycler_view_refresh_icon_size);
        int i2 = this.mRefreshIconSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        layoutParams.leftMargin = resources.getDimensionPixelSize(R$dimen.circle_recycler_view_refresh_icon_margin_left);
        layoutParams.topMargin = -this.mRefreshIconSize;
        addView(this.mRefreshIcon, layoutParams);
        int iE = k36.e(this.mContext);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.title_bar_height) / 2;
        this.mRefreshPosition = (this.mRefreshIconSize / 2) + iE + dimensionPixelSize;
        float dimension = resources.getDimension(R$dimen.circle_recycler_view_style_switch_offset);
        this.mStyleSwitchOffset = (((k36.d(context) - r1) - iE) - dimensionPixelSize) - dimension;
        this.mStyleSwitchRange = dimension - dimensionPixelSize;
        this.mIconObserver = new e();
        PullRefreshFooter pullRefreshFooter = new PullRefreshFooter(getContext());
        this.mFooterView = pullRefreshFooter;
        addFooterView(pullRefreshFooter);
    }

    private void initOverScroll() {
        w96 w96Var = new w96(new fu4(this.mRecyclerView), 2.0f, 1.0f, 2.0f);
        w96Var.a(new b());
        w96Var.b(new c());
    }

    private boolean isListEmpty(List<?> list) {
        return list == null || list.size() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void offsetRefreshIcon(float f2) {
        int iMax = Math.max(0, Math.min(Math.round(f2), this.mRefreshPosition));
        this.mRefreshIconOffset = iMax;
        ImageView imageView = this.mRefreshIcon;
        ViewCompat.offsetTopAndBottom(imageView, iMax - imageView.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.mState == j.IDLE) {
            setState(j.REFRESHING);
            i74 i74Var = this.onRefreshListener;
            if (i74Var != null) {
                i74Var.g(0);
            }
            this.mIconObserver.h();
        }
    }

    private void setState(j jVar) {
        LogUtil.i(TAG, "Set state = " + jVar);
        this.mState = jVar;
    }

    public void addFooterView(View view) {
        cx1 cx1Var = new cx1(view, (-99) - this.mFooterViewInfos.size());
        if (checkFixedViewInfoNotAdded(cx1Var, this.mFooterViewInfos)) {
            this.mFooterViewInfos.add(cx1Var);
        }
        checkAndNotifyWrappedViewAdd(this.mRecyclerView.getAdapter(), cx1Var, false);
    }

    public void addHeaderView(View view) {
        cx1 cx1Var = new cx1(view, (-2) - this.mHeaderViewInfos.size());
        if (this.mHeaderViewInfos.size() == Math.abs(-97)) {
            ArrayList<cx1> arrayList = this.mHeaderViewInfos;
            arrayList.remove(arrayList.size() - 1);
        }
        if (checkFixedViewInfoNotAdded(cx1Var, this.mHeaderViewInfos)) {
            this.mHeaderViewInfos.add(cx1Var);
        }
        checkAndNotifyWrappedViewAdd(this.mRecyclerView.getAdapter(), cx1Var, true);
    }

    public void autoRefresh(int i2) {
        if (this.mState == j.IDLE) {
            setState(j.REFRESHING);
            i74 i74Var = this.onRefreshListener;
            if (i74Var != null) {
                i74Var.g(i2);
            }
            post(new a());
        }
    }

    public void complete() {
        LogUtil.i(TAG, "complete");
        if (this.mState == j.LOADING_MORE) {
            this.mFooterView.onFinish();
        }
        setState(j.IDLE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public PullRefreshFooter getFooterView() {
        return this.mFooterView;
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public int getVerticalScrollOffset() {
        return this.mRecyclerView.computeVerticalScrollOffset();
    }

    public void hideIcon() {
        this.mRefreshIcon.setVisibility(8);
    }

    public boolean isNeedAutoLoadMore() {
        return this.mRecyclerView.computeVerticalScrollExtent() + this.mRecyclerView.computeVerticalScrollOffset() >= this.mRecyclerView.computeVerticalScrollRange() - me1.b(this.mContext, 1000);
    }

    public boolean isScrollToBottom() {
        return this.mRecyclerView.computeVerticalScrollExtent() + this.mRecyclerView.computeVerticalScrollOffset() >= this.mRecyclerView.computeVerticalScrollRange();
    }

    public void loadMore() {
        if (this.mState == j.IDLE) {
            setState(j.LOADING_MORE);
            i74 i74Var = this.onRefreshListener;
            if (i74Var != null) {
                i74Var.a();
            }
            this.mFooterView.onRefreshing();
        }
    }

    public void moveRefreshIcon() {
        this.mRefreshIconSize = this.mContext.getResources().getDimensionPixelSize(R$dimen.circle_recycler_view_refresh_icon_size_fragment);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRefreshIcon.getLayoutParams();
        layoutParams.topMargin = -this.mRefreshIconSize;
        this.mRefreshIcon.setLayoutParams(layoutParams);
        int iE = k36.e(this.mContext);
        this.mRefreshPosition = (this.mRefreshIconSize / 2) + iE + (this.mContext.getResources().getDimensionPixelSize(R$dimen.title_bar_height) / 2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() <= 2) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + ": more than 2 subviews are not allowed.");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        offsetRefreshIcon(this.mRefreshIconOffset);
    }

    public void scrollToTop() {
        this.mRecyclerView.scrollToPosition(0);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
                this.mRecyclerView.setAdapter(wrapHeaderRecyclerViewAdapterInternal(adapter, this.mHeaderViewInfos, this.mFooterViewInfos));
            } else {
                this.mRecyclerView.setAdapter(adapter);
            }
        }
        initOverScroll();
    }

    public void setEnableLoadMore(boolean z) {
        this.enableLoadMore = z;
    }

    public void setOnRefreshListener(i74 i74Var) {
        this.onRefreshListener = i74Var;
    }

    public HeaderViewWrapperAdapter wrapHeaderRecyclerViewAdapterInternal(@NonNull RecyclerView.Adapter adapter, ArrayList<cx1> arrayList, ArrayList<cx1> arrayList2) {
        return new HeaderViewWrapperAdapter(this.mRecyclerView, adapter, arrayList, arrayList2);
    }

    public CircleRecyclerViewB(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeaderViewWrapperAdapter wrapHeaderRecyclerViewAdapterInternal(@NonNull RecyclerView.Adapter adapter) {
        return wrapHeaderRecyclerViewAdapterInternal(adapter, this.mHeaderViewInfos, this.mFooterViewInfos);
    }

    public CircleRecyclerViewB(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mState = j.IDLE;
        this.mRefreshIconOffset = 0;
        this.mStyleTransparent = false;
        this.mStyleAlpha = 1.0f;
        this.enableLoadMore = true;
        this.mOnScrollListener = new d();
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        init(context);
    }

    public void setOnPreDispatchTouchListener(g gVar) {
    }

    public void setOnScrollListener(h hVar) {
    }

    public void setOnStyleStateListener(i iVar) {
    }

    public void setOverScrollListener(f fVar) {
    }
}
