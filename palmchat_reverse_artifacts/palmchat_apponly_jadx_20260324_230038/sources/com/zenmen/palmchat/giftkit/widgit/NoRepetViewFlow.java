package com.zenmen.palmchat.giftkit.widgit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NoRepetViewFlow extends AdapterView<Adapter> {
    private static final int DEFAULT_DURATION = 250;
    public static int SNAP_VELOCITY = 600;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private int currentIndex;
    private int direction;
    private Handler handler;
    private boolean isDetachedFromWindowDestroy;
    public boolean isNeedCarousel;
    private Adapter mAdapter;
    private d mDataSetObserver;
    private NoRepetCircleFlowIndicator mFlowIndicator;
    private float mLastionMotionX;
    private float mLastionMotionY;
    private LinkedList<View> mLoadedViews;
    private float mMotionX;
    private LinkedList<View> mRecycledViews;
    private Scroller mScroller;
    private int mTouchSlop;
    private int mTouchState;
    private VelocityTracker mVelocityTracker;
    private e mViewSwitchListener;
    private int timeSpan;
    private int[] timeSpans;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (NoRepetViewFlow.this.mAdapter == null || NoRepetViewFlow.this.mAdapter.getCount() <= 1) {
                return;
            }
            NoRepetViewFlow.this.snapToScreen(true);
            if (NoRepetViewFlow.this.timeSpans == null) {
                sendMessageDelayed(obtainMessage(0), NoRepetViewFlow.this.timeSpan);
            } else {
                if (NoRepetViewFlow.this.currentIndex == -1 || NoRepetViewFlow.this.currentIndex >= NoRepetViewFlow.this.timeSpans.length) {
                    return;
                }
                sendMessageDelayed(obtainMessage(0), NoRepetViewFlow.this.timeSpans[NoRepetViewFlow.this.currentIndex]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NoRepetViewFlow noRepetViewFlow = NoRepetViewFlow.this;
            noRepetViewFlow.scrollTo(noRepetViewFlow.getChildWidth(), 0);
            NoRepetViewFlow.this.switched(0);
            if (NoRepetViewFlow.this.mViewSwitchListener != null) {
                NoRepetViewFlow.this.mViewSwitchListener.a(null, NoRepetViewFlow.this.currentIndex);
            }
            NoRepetViewFlow.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NoRepetViewFlow.this.scrollTo(0, 0);
            NoRepetViewFlow.this.switched(0);
            if (NoRepetViewFlow.this.mViewSwitchListener != null) {
                NoRepetViewFlow.this.mViewSwitchListener.a(null, NoRepetViewFlow.this.currentIndex);
            }
            NoRepetViewFlow.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(View view, int i);
    }

    public NoRepetViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentIndex = -1;
        this.direction = 0;
        this.timeSpan = 5000;
        this.mTouchSlop = 0;
        this.isNeedCarousel = false;
        this.handler = new a();
        this.isDetachedFromWindowDestroy = true;
        this.mTouchState = 0;
        this.mVelocityTracker = null;
        this.mLastionMotionX = 0.0f;
        this.mLastionMotionY = 0.0f;
        this.mMotionX = 0.0f;
        init();
    }

    @SuppressLint({"WrongCall"})
    private void completeAnimation() {
        int i = this.direction;
        if (i > 0) {
            if (!this.mLoadedViews.isEmpty()) {
                recycleView(this.mLoadedViews.removeFirst());
            }
            int i2 = this.currentIndex == this.mAdapter.getCount() - 1 ? 0 : this.currentIndex + 1;
            this.direction = 0;
            makeAndAddView(i2, true);
            onLayout(true, 0, 0, 0, 0);
            scrollTo(getChildWidth(), 0);
            switched(0);
            e eVar = this.mViewSwitchListener;
            if (eVar != null) {
                eVar.a(null, this.currentIndex);
            }
            invalidate();
            return;
        }
        if (i < 0) {
            if (!this.mLoadedViews.isEmpty()) {
                recycleView(this.mLoadedViews.removeLast());
            }
            int count = this.currentIndex;
            if (count == 0) {
                count = this.mAdapter.getCount();
            }
            makeAndAddView(count - 1, false);
            this.direction = 0;
            onLayout(true, 0, 0, 0, 0);
            scrollTo(getChildWidth(), 0);
            switched(0);
            e eVar2 = this.mViewSwitchListener;
            if (eVar2 != null) {
                eVar2.a(null, this.currentIndex);
            }
            invalidate();
        }
    }

    private int getHeightPadding() {
        return getPaddingTop() + getPaddingBottom();
    }

    private int getWidthPadding() {
        return getPaddingLeft() + getPaddingRight() + (getHorizontalFadingEdgeLength() * 2);
    }

    private void init() {
        this.mLoadedViews = new LinkedList<>();
        this.mRecycledViews = new LinkedList<>();
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void makeAndAddView(int i, boolean z) {
        if (this.mAdapter.getCount() != 0 && i < this.mAdapter.getCount() && i >= 0) {
            View recycledView = getRecycledView();
            View view = this.mAdapter.getView(i, recycledView, this);
            if (z) {
                this.mLoadedViews.add(view);
            } else {
                this.mLoadedViews.add(0, view);
            }
            if (recycledView != view) {
                setupChild(view, z, false);
            } else {
                setupChild(view, z, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseCarousel() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private View setupChild(View view, boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.measure(View.MeasureSpec.makeMeasureSpec(getChildWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getChildHeight(), 1073741824));
        if (z2) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switched(int i) {
        switched(this.currentIndex, i);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.computeScrollOffset()) {
            completeAnimation();
            return;
        }
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        int i = this.direction;
        if (i > 0) {
            switched(this.currentIndex - 1, this.mScroller.getCurrX() - getChildWidth());
        } else if (i < 0) {
            switched(this.currentIndex + 1, this.mScroller.getCurrX() - getChildWidth());
        } else {
            switched(this.mScroller.getCurrX() - getChildWidth());
        }
        postInvalidate();
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getChildHeight() {
        return getHeight() - getHeightPadding();
    }

    public int getChildWidth() {
        return getWidth() - getWidthPadding();
    }

    public View getRecycledView() {
        if (this.mRecycledViews.isEmpty()) {
            return null;
        }
        return this.mRecycledViews.remove();
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    public int getViewsCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.getCount();
        }
        return 0;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isDetachedFromWindowDestroy) {
            reset();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() == 0) {
            return false;
        }
        if (action == 2 && this.mTouchState != 0) {
            Log.i("haha", "lje");
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.mLastionMotionX = x;
            this.mLastionMotionY = y;
            this.mMotionX = x;
            this.mTouchState = !this.mScroller.isFinished() ? 1 : 0;
            if (this.mAdapter.getCount() > 1) {
                requestParentDisallowInterceptTouchEvent(true);
                Log.i("haha", ScrollClickView.DIR_DOWN);
            }
        } else if (action == 1) {
            this.mTouchState = 0;
            Log.i("haha", "up");
        } else if (action == 2) {
            int iAbs = (int) Math.abs(this.mLastionMotionX - x);
            int iAbs2 = (int) Math.abs(this.mLastionMotionY - y);
            float f = this.mLastionMotionX - x;
            if (this.mAdapter.getCount() > 1) {
                if (f > 0.0f && this.currentIndex < this.mAdapter.getCount() - 1) {
                    if (iAbs > this.mTouchSlop && iAbs * 0.5f > iAbs2) {
                        this.mTouchState = 1;
                        requestParentDisallowInterceptTouchEvent(true);
                    }
                    Log.i("haha", "向右");
                } else if (f >= 0.0f || this.currentIndex <= 0) {
                    requestParentDisallowInterceptTouchEvent(false);
                    Log.i("haha", "不需要");
                } else {
                    if (iAbs > this.mTouchSlop && iAbs * 0.5f > iAbs2) {
                        this.mTouchState = 1;
                        requestParentDisallowInterceptTouchEvent(true);
                    }
                    Log.i("haha", "向左");
                }
            }
        } else if (action == 3) {
        }
        return this.mTouchState != 0;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft() + getHorizontalFadingEdgeLength();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                childAt.layout(paddingLeft, getPaddingTop(), measuredWidth, getPaddingTop() + childAt.getMeasuredHeight());
                paddingLeft = measuredWidth;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        int measuredWidth;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int widthPadding = getWidthPadding();
        int heightPadding = getHeightPadding();
        measureChildren(i, i2);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            measuredWidth = childAt.getMeasuredWidth();
            measuredHeight = childAt.getMeasuredHeight();
        } else {
            measuredHeight = 0;
            measuredWidth = 0;
        }
        if (mode == Integer.MIN_VALUE) {
            size = (measuredWidth + widthPadding) | 0;
        } else if (mode == 0) {
            size = measuredWidth + widthPadding;
        } else if (mode == 1073741824 && size < measuredWidth + widthPadding) {
            size |= 16777216;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (measuredHeight + heightPadding) | 0;
        } else if (mode2 == 0) {
            size2 = measuredHeight + heightPadding;
        } else if (mode2 == 1073741824 && size2 < measuredHeight + heightPadding) {
            size2 |= 16777216;
        }
        setMeasuredDimension(size, mode2 == 0 ? heightPadding + measuredHeight : size2 | 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            pauseCarousel();
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                completeAnimation();
            }
            this.mMotionX = x;
            this.mLastionMotionX = x;
            this.mLastionMotionY = y;
            Log.i("haha", "onTouchEvent  down");
        } else if (action == 1) {
            float f = this.mLastionMotionX - x;
            if (this.mAdapter.getCount() > 1 && ((f > 0.0f && this.currentIndex < this.mAdapter.getCount() - 1) || (f < 0.0f && this.currentIndex > 0))) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int i = SNAP_VELOCITY;
                if (xVelocity > i) {
                    snapToScreen(false);
                } else if (xVelocity < (-i)) {
                    snapToScreen(true);
                } else {
                    int scrollX = getScrollX() - getChildWidth();
                    if (scrollX > 0) {
                        if (Math.abs(scrollX) > getChildWidth() / 3) {
                            snapToScreen(true);
                        } else {
                            int childWidth = getChildWidth() - getScrollX();
                            this.mScroller.startScroll(getScrollX(), 0, childWidth, 0, Math.abs(childWidth) * 1);
                            invalidate();
                        }
                    } else if (Math.abs(scrollX) > getChildWidth() / 3) {
                        snapToScreen(false);
                    } else {
                        int childWidth2 = getChildWidth() - getScrollX();
                        this.mScroller.startScroll(getScrollX(), 0, childWidth2, 0, Math.abs(childWidth2) * 1);
                        invalidate();
                    }
                }
            }
            if (Math.abs(this.mLastionMotionX - x) < this.mTouchSlop && Math.abs(this.mLastionMotionY - y) < this.mTouchSlop) {
                performItemClick(null, this.currentIndex, -1L);
            }
            if (this.isNeedCarousel) {
                int[] iArr = this.timeSpans;
                if (iArr != null) {
                    startAutoCarousel(iArr);
                } else {
                    startAutoCarousel(this.timeSpan);
                }
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.mTouchState = 0;
        } else {
            if (action == 2) {
                int i2 = (int) (this.mMotionX - x);
                Math.abs(this.mLastionMotionX - x);
                Math.abs(this.mLastionMotionY - y);
                float f2 = this.mLastionMotionX - x;
                this.mMotionX = x;
                if (this.mAdapter.getCount() > 1) {
                    if (f2 > 0.0f && this.currentIndex < this.mAdapter.getCount() - 1) {
                        scrollBy(i2, 0);
                        switched(getScrollX() - getChildWidth());
                    } else if (f2 >= 0.0f || this.currentIndex <= 0) {
                        Log.i("haha", "onTouchEvent  move不处理");
                        requestParentDisallowInterceptTouchEvent(false);
                    } else {
                        scrollBy(i2, 0);
                        switched(getScrollX() - getChildWidth());
                    }
                }
                return false;
            }
            if (action == 3) {
            }
        }
        return true;
    }

    public void recycleView(View view) {
        if (view == null) {
            return;
        }
        detachViewFromParent(view);
        this.mRecycledViews.add(view);
    }

    public void recycleViews() {
        while (!this.mLoadedViews.isEmpty()) {
            recycleView(this.mLoadedViews.remove());
        }
    }

    public void reset() {
        pauseCarousel();
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.currentIndex = -1;
        this.direction = 0;
        recycleViews();
        this.mRecycledViews.clear();
        removeAllViewsInLayout();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.mDataSetObserver);
            reset();
        }
        this.mAdapter = adapter;
        if (adapter != null) {
            d dVar = new d();
            this.mDataSetObserver = dVar;
            this.mAdapter.registerDataSetObserver(dVar);
        }
        Adapter adapter3 = this.mAdapter;
        if (adapter3 == null || adapter3.getCount() == 0) {
            return;
        }
        setSelection(0);
        if (this.isNeedCarousel) {
            int[] iArr = this.timeSpans;
            if (iArr != null) {
                startAutoCarousel(iArr);
            } else {
                startAutoCarousel(this.timeSpan);
            }
        }
        NoRepetCircleFlowIndicator noRepetCircleFlowIndicator = this.mFlowIndicator;
        if (noRepetCircleFlowIndicator != null) {
            noRepetCircleFlowIndicator.requestLayout();
            this.mFlowIndicator.invalidate();
        }
    }

    public void setFlowIndicator(NoRepetCircleFlowIndicator noRepetCircleFlowIndicator) {
        this.mFlowIndicator = noRepetCircleFlowIndicator;
        noRepetCircleFlowIndicator.setViewFlow(this);
    }

    public void setNoWindowDestroy() {
        this.isDetachedFromWindowDestroy = false;
    }

    public void setOnViewSwitchListener(e eVar) {
        this.mViewSwitchListener = eVar;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            completeAnimation();
        }
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() == 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 0), this.mAdapter.getCount() - 1);
        recycleViews();
        this.currentIndex = iMin;
        this.direction = 0;
        if (this.mAdapter.getCount() <= 1) {
            makeAndAddView(0, true);
            requestLayout();
            postDelayed(new c(), 20L);
            return;
        }
        if (iMin == 0) {
            makeAndAddView(this.mAdapter.getCount() - 1, true);
        } else {
            makeAndAddView(iMin - 1, true);
        }
        makeAndAddView(iMin, true);
        if (iMin == this.mAdapter.getCount() - 1) {
            makeAndAddView(0, true);
        } else {
            makeAndAddView(iMin + 1, true);
        }
        requestLayout();
        postDelayed(new b(), 20L);
    }

    public void snapToScreen(boolean z) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            completeAnimation();
        }
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() < 2) {
            return;
        }
        int count = this.mAdapter.getCount();
        if (z) {
            int childWidth = (getChildWidth() * 2) - getScrollX();
            if (this.currentIndex == this.mAdapter.getCount() - 1) {
                this.currentIndex = 0;
            } else {
                this.currentIndex++;
            }
            this.direction = 1;
            if (Math.abs(childWidth) < 250) {
                this.mScroller.startScroll(getScrollX(), 0, childWidth, 0, 250);
            } else {
                this.mScroller.startScroll(getScrollX(), 0, childWidth, 0, Math.abs(childWidth) * 1);
            }
        } else {
            int i = this.currentIndex;
            if (i == 0) {
                this.currentIndex = count - 1;
            } else {
                this.currentIndex = i - 1;
            }
            int scrollX = 0 - getScrollX();
            this.direction = -1;
            if (Math.abs(scrollX) < 250) {
                this.mScroller.startScroll(getScrollX(), 0, scrollX, 0, 250);
            } else {
                this.mScroller.startScroll(getScrollX(), 0, scrollX, 0, Math.abs(scrollX) * 1);
            }
        }
        invalidate();
    }

    public void startAutoCarousel(int i) {
        Handler handler;
        this.isNeedCarousel = true;
        this.timeSpan = i;
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() < 2 || (handler = this.handler) == null) {
            return;
        }
        handler.removeMessages(0);
        Handler handler2 = this.handler;
        handler2.sendMessageDelayed(handler2.obtainMessage(0), this.timeSpan);
    }

    public void stopAutoCarousel() {
        this.isNeedCarousel = false;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    private void switched(int i, int i2) {
        if (this.mFlowIndicator != null) {
            this.mFlowIndicator.onSwitched(i, i2 / getChildWidth());
        }
    }

    public void startAutoCarousel(int[] iArr) {
        Handler handler;
        int i;
        this.isNeedCarousel = true;
        this.timeSpans = iArr;
        Adapter adapter = this.mAdapter;
        if (adapter == null || adapter.getCount() < 2 || (handler = this.handler) == null) {
            return;
        }
        handler.removeMessages(0);
        int[] iArr2 = this.timeSpans;
        if (iArr2 == null || (i = this.currentIndex) == -1 || i >= iArr2.length) {
            return;
        }
        Handler handler2 = this.handler;
        handler2.sendMessageDelayed(handler2.obtainMessage(0), this.timeSpans[this.currentIndex]);
    }

    public NoRepetViewFlow(Context context) {
        this(context, null);
    }

    public void setFlogTouch(boolean z) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends DataSetObserver {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NoRepetViewFlow.this.pauseCarousel();
                if (NoRepetViewFlow.this.mAdapter.getCount() == 0) {
                    NoRepetViewFlow.this.reset();
                } else if (NoRepetViewFlow.this.mAdapter.getCount() == 1) {
                    NoRepetViewFlow noRepetViewFlow = NoRepetViewFlow.this;
                    noRepetViewFlow.setSelection(noRepetViewFlow.currentIndex);
                } else {
                    NoRepetViewFlow noRepetViewFlow2 = NoRepetViewFlow.this;
                    noRepetViewFlow2.setSelection(noRepetViewFlow2.currentIndex);
                    NoRepetViewFlow noRepetViewFlow3 = NoRepetViewFlow.this;
                    if (noRepetViewFlow3.isNeedCarousel) {
                        if (noRepetViewFlow3.timeSpans != null) {
                            NoRepetViewFlow noRepetViewFlow4 = NoRepetViewFlow.this;
                            noRepetViewFlow4.startAutoCarousel(noRepetViewFlow4.timeSpans);
                        } else {
                            NoRepetViewFlow noRepetViewFlow5 = NoRepetViewFlow.this;
                            noRepetViewFlow5.startAutoCarousel(noRepetViewFlow5.timeSpan);
                        }
                    }
                }
                if (NoRepetViewFlow.this.mFlowIndicator != null) {
                    NoRepetViewFlow.this.mFlowIndicator.requestLayout();
                    NoRepetViewFlow.this.mFlowIndicator.invalidate();
                }
            }
        }

        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            NoRepetViewFlow.this.postDelayed(new a(), 10L);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }
}
