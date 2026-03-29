package com.zenmen.palmchat.ui.widget.pullrecyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.mode.Mode;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.mode.PullMode;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.wrapperadapter.HeaderViewWrapperAdapter;
import defpackage.bd;
import defpackage.cx1;
import defpackage.fu4;
import defpackage.i74;
import defpackage.k36;
import defpackage.kf6;
import defpackage.un2;
import defpackage.w96;
import defpackage.wn2;
import defpackage.xn2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class StaticRecyclerView extends FrameLayout {
    private static final int ITEM_VIEW_TYPE_FOOTER_START = -99;
    private static final int ITEM_VIEW_TYPE_HEADER_START = -2;
    private static final String TAG = "StaticRecyclerView";
    private boolean canLoadMore;
    private boolean canPull;
    private int currentStatus;
    private PullRefreshFooter footerView;
    private e iconObserver;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<cx1> mFooterViewInfos;
    private ArrayList<cx1> mHeaderViewInfos;
    private Mode mode;
    private f onPreDispatchTouchListener;
    private i74 onRefreshListener;
    private RecyclerView.OnScrollListener onScrollListener;
    private PullMode pullMode;
    private RecyclerView recyclerView;
    private ImageView refreshIcon;
    private int refreshPosition;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements wn2 {
        public a() {
        }

        @Override // defpackage.wn2
        public void a(un2 un2Var, int i, int i2) {
            if (i2 != 2) {
                return;
            }
            Log.i("refreshState", "current state  >>>   " + StaticRecyclerView.this.currentStatus + "   refresh mode  >>>   " + StaticRecyclerView.this.pullMode);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements xn2 {
        public b() {
        }

        @Override // defpackage.xn2
        public void a(un2 un2Var, int i, float f) {
            if (f <= 0.0f || !StaticRecyclerView.this.canRefresh()) {
                return;
            }
            StaticRecyclerView.this.iconObserver.e(f);
            if (f < StaticRecyclerView.this.refreshPosition || i != 3 || StaticRecyclerView.this.currentStatus == 1) {
                return;
            }
            StaticRecyclerView.this.setCurrentStatus(1);
            if (StaticRecyclerView.this.onRefreshListener != null) {
                Log.i(StaticRecyclerView.TAG, com.alipay.sdk.m.x.d.w);
                StaticRecyclerView.this.onRefreshListener.g(0);
            }
            StaticRecyclerView.this.setPullMode(PullMode.FROM_START);
            StaticRecyclerView.this.iconObserver.f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (StaticRecyclerView.this.isScrollToBottom() && StaticRecyclerView.this.canLoadMore()) {
                StaticRecyclerView.this.onRefreshListener.a();
                Log.i("loadmoretag", "loadmore");
                StaticRecyclerView.this.setPullMode(PullMode.FROM_BOTTOM);
                StaticRecyclerView.this.setCurrentStatus(1);
                StaticRecyclerView.this.footerView.onRefreshing();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15657a;

        static {
            int[] iArr = new int[Mode.values().length];
            f15657a = iArr;
            try {
                iArr[Mode.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15657a[Mode.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15657a[Mode.LOADMORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kf6 f15658a;
        public ImageView b;
        public final int c;
        public RotateAnimation d;
        public ValueAnimator e;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends bd {
            public b() {
            }

            @Override // defpackage.bd, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.b.clearAnimation();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.e.start();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements ValueAnimator.AnimatorUpdateListener {
            public d() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.ui.widget.pullrecyclerview.StaticRecyclerView$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1117e extends bd {
            public C1117e() {
            }

            @Override // defpackage.bd, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.f();
            }
        }

        public e(ImageView imageView, int i) {
            this.b = imageView;
            this.c = i;
            this.f15658a = new kf6(imageView);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.d = rotateAnimation;
            rotateAnimation.setDuration(1000L);
            this.d.setInterpolator(new LinearInterpolator());
            this.d.setRepeatCount(-1);
            this.d.setFillBefore(true);
        }

        public final void c() {
            if (this.b.getY() < 0.0f) {
                ImageView imageView = this.b;
                imageView.offsetTopAndBottom(Math.abs(imageView.getTop()));
            } else if (this.b.getY() > this.c) {
                ImageView imageView2 = this.b;
                imageView2.offsetTopAndBottom(-(imageView2.getTop() - this.c));
            }
        }

        public void d() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.c);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.setDuration(540L);
            valueAnimatorOfFloat.addUpdateListener(new d());
            valueAnimatorOfFloat.addListener(new C1117e());
            valueAnimatorOfFloat.start();
        }

        public void e(float f) {
            if (h()) {
                this.b.setRotation((-f) * 2.0f);
                int i = this.c;
                if (f >= i) {
                    f = i;
                }
                this.f15658a.a((int) f);
                c();
            }
        }

        public void f() {
            if (h()) {
                this.b.clearAnimation();
                int top = this.b.getTop();
                int i = this.c;
                if (top < i) {
                    this.f15658a.a(i);
                }
                this.b.startAnimation(this.d);
            }
        }

        public void g() {
            Log.i("refreshTop", " top  >>>  " + this.b.getTop());
            if (this.e == null) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.c, 0.0f);
                this.e = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                this.e.addUpdateListener(new a());
                this.e.addListener(new b());
                this.e.setDuration(540L);
            }
            this.b.post(new c());
        }

        public final boolean h() {
            return this.b != null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        boolean Y(MotionEvent motionEvent);
    }

    public StaticRecyclerView(Context context) {
        this(context, null);
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
        if (isInEditMode()) {
            return;
        }
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-13487566, -13487566, -1, -1}));
        if (this.recyclerView == null) {
            RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.view_recyclerview, (ViewGroup) this, false);
            this.recyclerView = recyclerView;
            recyclerView.setBackgroundColor(-1);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
            this.linearLayoutManager = linearLayoutManager;
            this.recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.recyclerView.setItemAnimator(null);
        addView(this.recyclerView, -1, -1);
        int iB = k36.b(90.0f);
        this.refreshPosition = iB;
        this.iconObserver = new e(this.refreshIcon, iB);
        PullRefreshFooter pullRefreshFooter = new PullRefreshFooter(getContext());
        this.footerView = pullRefreshFooter;
        addFooterView(pullRefreshFooter);
        setMode(Mode.BOTH);
        setBackgroundColor(0);
        this.recyclerView.setBackgroundColor(0);
        this.footerView.setBackgroundColor(0);
    }

    private void initOverScroll() {
        w96 w96Var = new w96(new fu4(this.recyclerView), 2.0f, 1.0f, 2.0f);
        w96Var.a(new a());
        w96Var.b(new b());
    }

    private boolean isListEmpty(List<?> list) {
        return list == null || list.size() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentStatus(int i) {
        this.currentStatus = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPullMode(PullMode pullMode) {
        this.pullMode = pullMode;
    }

    public void addFooterView(View view) {
        cx1 cx1Var = new cx1(view, (-99) - this.mFooterViewInfos.size());
        if (checkFixedViewInfoNotAdded(cx1Var, this.mFooterViewInfos)) {
            this.mFooterViewInfos.add(cx1Var);
        }
        checkAndNotifyWrappedViewAdd(this.recyclerView.getAdapter(), cx1Var, false);
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
        checkAndNotifyWrappedViewAdd(this.recyclerView.getAdapter(), cx1Var, true);
    }

    public void autoRefresh() {
        if (!canRefresh() || this.iconObserver == null || this.onRefreshListener == null) {
            return;
        }
        setPullMode(PullMode.FROM_START);
        setCurrentStatus(1);
        this.iconObserver.d();
        this.onRefreshListener.g(0);
    }

    public boolean canLoadMore() {
        Mode mode;
        return this.canLoadMore && this.currentStatus != 1 && ((mode = this.mode) == Mode.LOADMORE || mode == Mode.BOTH);
    }

    public boolean canRefresh() {
        Mode mode;
        return this.canPull && this.currentStatus != 1 && ((mode = this.mode) == Mode.REFRESH || mode == Mode.BOTH);
    }

    public void compelete() {
        PullRefreshFooter pullRefreshFooter;
        e eVar;
        Log.i(TAG, "compelete");
        if (this.pullMode == PullMode.FROM_START && (eVar = this.iconObserver) != null) {
            eVar.g();
        }
        if (this.pullMode == PullMode.FROM_BOTTOM && (pullRefreshFooter = this.footerView) != null) {
            pullRefreshFooter.onFinish();
        }
        setCurrentStatus(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        f fVar = this.onPreDispatchTouchListener;
        if (fVar != null) {
            fVar.Y(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int findFirstVisibleItemPosition() {
        return this.linearLayoutManager.findFirstVisibleItemPosition();
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    public f getOnPreDispatchTouchListener() {
        return this.onPreDispatchTouchListener;
    }

    public i74 getOnRefreshListener() {
        return this.onRefreshListener;
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public boolean isScrollToBottom() {
        RecyclerView recyclerView = this.recyclerView;
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() + this.recyclerView.computeVerticalScrollOffset() >= this.recyclerView.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        if (getChildCount() > 2) {
            throw new IllegalStateException("咳咳，不能超过两个view哦");
        }
        super.onFinishInflate();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
                this.recyclerView.setAdapter(wrapHeaderRecyclerViewAdapterInternal(adapter, this.mHeaderViewInfos, this.mFooterViewInfos));
            } else {
                this.recyclerView.setAdapter(adapter);
            }
        }
    }

    public void setCanPull(boolean z) {
        this.canPull = z;
    }

    public void setLoadMoreEnable(boolean z) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return;
        }
        this.canLoadMore = z;
        if (z) {
            recyclerView.addOnScrollListener(this.onScrollListener);
        } else {
            this.footerView.onFinish();
            this.recyclerView.removeOnScrollListener(this.onScrollListener);
        }
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        int i = d.f15657a[mode.ordinal()];
        if (i == 1) {
            setCanPull(true);
            setLoadMoreEnable(false);
        } else if (i == 2) {
            setCanPull(true);
            setLoadMoreEnable(true);
        } else {
            if (i != 3) {
                return;
            }
            setCanPull(false);
            setLoadMoreEnable(true);
        }
    }

    public void setOnPreDispatchTouchListener(f fVar) {
        this.onPreDispatchTouchListener = fVar;
    }

    public void setOnRefreshListener(i74 i74Var) {
        this.onRefreshListener = i74Var;
    }

    public HeaderViewWrapperAdapter wrapHeaderRecyclerViewAdapterInternal(@NonNull RecyclerView.Adapter adapter, ArrayList<cx1> arrayList, ArrayList<cx1> arrayList2) {
        return new HeaderViewWrapperAdapter(this.recyclerView, adapter, arrayList, arrayList2);
    }

    public StaticRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeaderViewWrapperAdapter wrapHeaderRecyclerViewAdapterInternal(@NonNull RecyclerView.Adapter adapter) {
        return wrapHeaderRecyclerViewAdapterInternal(adapter, this.mHeaderViewInfos, this.mFooterViewInfos);
    }

    public StaticRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = Mode.BOTH;
        this.onScrollListener = new c();
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        init(context);
    }
}
