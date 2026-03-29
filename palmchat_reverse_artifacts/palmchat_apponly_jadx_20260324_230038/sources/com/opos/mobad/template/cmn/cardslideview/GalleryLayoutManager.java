package com.opos.mobad.template.cmn.cardslideview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class GalleryLayoutManager extends RecyclerView.LayoutManager {
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    private static final String TAG = "GalleryLayoutManager";
    private boolean canScrollHorizontally;
    private boolean canScrollVertically;
    private boolean isLooper;
    private final boolean isRebound;
    private int itemMargin;
    private final float itemMarginPercent;
    private OrientationHelper mHorizontalHelper;
    private int mOffscreenPageLimit;
    private e mOnPageChangeListener;
    private f mOnPageScrollStateChangeListener;
    private int mOrientation;
    private g mPageTransformer;
    private RecyclerView mRecyclerView;
    private b mState;
    private OrientationHelper mVerticalHelper;
    private int offsetEdgeSize;
    private int mFirstVisiblePosition = 0;
    private int mLastVisiblePosition = 0;
    private int mInitialSelectedPosition = 0;
    private int mCurItem = -1;
    private final InnerScrollListener mInnerScrollListener = new InnerScrollListener();

    /* JADX INFO: compiled from: SearchBox */
    public class InnerScrollListener extends RecyclerView.OnScrollListener {
        private boolean mScrolled;

        private InnerScrollListener() {
            this.mScrolled = false;
        }

        private void dispatchScrollSelected(int i) {
            GalleryLayoutManager.this.mCurItem = i;
            if (GalleryLayoutManager.this.mOnPageChangeListener != null) {
                GalleryLayoutManager.this.mOnPageChangeListener.onPageSelected(GalleryLayoutManager.this.mCurItem);
            }
            dispatchScrollState(0);
        }

        private void dispatchScrollState(int i) {
            if (GalleryLayoutManager.this.mOnPageScrollStateChangeListener != null) {
                GalleryLayoutManager.this.mOnPageScrollStateChangeListener.a(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            int i2;
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.mScrolled) {
                this.mScrolled = false;
                if (snapToTargetExistingView()) {
                    return;
                }
            }
            if (i != 0) {
                dispatchScrollState(i);
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                dispatchScrollState(0);
                return;
            }
            View viewFindCenterView = GalleryLayoutManager.this.findCenterView();
            if (viewFindCenterView == null) {
                dispatchScrollState(0);
                return;
            }
            int position = layoutManager.getPosition(viewFindCenterView);
            if (position != GalleryLayoutManager.this.mCurItem) {
                GalleryLayoutManager galleryLayoutManager = GalleryLayoutManager.this;
                View viewFindViewByPosition = galleryLayoutManager.findViewByPosition(galleryLayoutManager.mCurItem);
                if (viewFindViewByPosition == null) {
                    dispatchScrollSelected(position);
                    return;
                }
                OrientationHelper orientationHelper = GalleryLayoutManager.this.getOrientationHelper();
                int decoratedStart = orientationHelper.getDecoratedStart(viewFindViewByPosition);
                int decoratedEnd = orientationHelper.getDecoratedEnd(viewFindViewByPosition);
                int startAfterPadding = orientationHelper.getStartAfterPadding();
                int endAfterPadding = orientationHelper.getEndAfterPadding();
                int decoratedMeasurement = (int) ((((endAfterPadding - startAfterPadding) - orientationHelper.getDecoratedMeasurement(viewFindCenterView)) / 2.0f) - GalleryLayoutManager.this.itemMargin);
                int i3 = startAfterPadding + decoratedMeasurement;
                if ((decoratedStart < i3 && decoratedEnd <= i3) || (decoratedStart >= (i2 = endAfterPadding - decoratedMeasurement) && decoratedEnd > i2)) {
                    dispatchScrollSelected(position);
                    return;
                }
            }
            dispatchScrollState(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            View viewFindCenterView;
            super.onScrolled(recyclerView, i, i2);
            if (i != 0 || i2 != 0) {
                this.mScrolled = true;
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null || (viewFindCenterView = GalleryLayoutManager.this.findCenterView()) == null) {
                return;
            }
            int position = layoutManager.getPosition(viewFindCenterView);
            if (GalleryLayoutManager.this.mCurItem == -1) {
                GalleryLayoutManager galleryLayoutManager = GalleryLayoutManager.this;
                if (galleryLayoutManager.findViewByPosition(galleryLayoutManager.mCurItem) == null) {
                    dispatchScrollSelected(position);
                }
            }
        }

        public boolean snapToTargetExistingView() {
            View viewFindCenterView;
            if (GalleryLayoutManager.this.mRecyclerView == null || (viewFindCenterView = GalleryLayoutManager.this.findCenterView()) == null) {
                return false;
            }
            int iCalculateDistanceToCenter = GalleryLayoutManager.this.calculateDistanceToCenter(viewFindCenterView, 0.0f);
            if (!(iCalculateDistanceToCenter != 0)) {
                return false;
            }
            if (GalleryLayoutManager.this.mOrientation == 0) {
                GalleryLayoutManager.this.mRecyclerView.smoothScrollBy(iCalculateDistanceToCenter, 0, new DecelerateInterpolator());
                return true;
            }
            GalleryLayoutManager.this.mRecyclerView.smoothScrollBy(0, iCalculateDistanceToCenter, new DecelerateInterpolator());
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends RecyclerView.LayoutParams {
        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9378a = 0;
        boolean b = false;
    }

    public GalleryLayoutManager(int i, boolean z, boolean z2, float f) {
        this.mOrientation = i;
        this.itemMarginPercent = f;
        this.isLooper = z;
        this.isRebound = z2;
        if (i == 0) {
            this.canScrollHorizontally = true;
            this.canScrollVertically = false;
        } else {
            this.canScrollHorizontally = false;
            this.canScrollVertically = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateDistanceToCenter(View view, float f) {
        OrientationHelper orientationHelper = getOrientationHelper();
        return (int) ((((orientationHelper.getDecoratedMeasurement(view) / 2.0f) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2.0f) + orientationHelper.getStartAfterPadding())) - f);
    }

    private float calculateOffsetPercentToCenter(View view, float f) {
        return (calculateDistanceToCenter(view, f) * 1.0f) / (getOrientationHelper().getDecoratedMeasurement(view) + this.itemMargin);
    }

    private void fill(RecyclerView.Recycler recycler, int i) {
        if (getItemCount() == 0) {
            return;
        }
        if (this.mOrientation == 0) {
            fillWithHorizontal(recycler, i);
        } else {
            fillWithVertical(recycler, i);
        }
        if (this.mPageTransformer != null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, calculateOffsetPercentToCenter(childAt, i), this.mOrientation);
                }
            }
        }
    }

    private void fillBottom(RecyclerView.Recycler recycler, int i, int i2, int i3) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int horizontalSpace = getHorizontalSpace();
        int itemCount = getItemCount();
        while (i2 < i3) {
            if (i >= itemCount) {
                if (!this.isLooper) {
                    return;
                } else {
                    i = 0;
                }
            }
            View viewForPosition = recycler.getViewForPosition(i);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasurementInOther = orientationHelper.getDecoratedMeasurementInOther(viewForPosition);
            int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - decoratedMeasurementInOther) / 2.0f));
            int i4 = this.itemMargin + i2;
            i2 = i4 + decoratedMeasurement;
            layoutDecoratedWithMargins(viewForPosition, paddingLeft, i4, paddingLeft + decoratedMeasurementInOther, i2);
            this.mLastVisiblePosition = i;
            i++;
        }
    }

    private void fillLeft(RecyclerView.Recycler recycler, int i, int i2, int i3) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int verticalSpace = getVerticalSpace();
        while (i2 > i3) {
            if (i < 0) {
                if (!this.isLooper) {
                    return;
                } else {
                    i = getItemCount() - 1;
                }
            }
            View viewForPosition = recycler.getViewForPosition(i);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
            int decoratedMeasurementInOther = orientationHelper.getDecoratedMeasurementInOther(viewForPosition);
            int i4 = i2 - this.itemMargin;
            i2 = i4 - decoratedMeasurement;
            int paddingTop = (int) (getPaddingTop() + ((verticalSpace - decoratedMeasurementInOther) / 2.0f));
            layoutDecoratedWithMargins(viewForPosition, i2, paddingTop, i4, paddingTop + decoratedMeasurementInOther);
            this.mFirstVisiblePosition = i;
            i--;
        }
    }

    private void fillRight(RecyclerView.Recycler recycler, int i, int i2, int i3) {
        int itemCount = getItemCount();
        OrientationHelper orientationHelper = getOrientationHelper();
        int verticalSpace = getVerticalSpace();
        while (i2 < i3) {
            if (i >= itemCount) {
                if (!this.isLooper) {
                    return;
                } else {
                    i = 0;
                }
            }
            View viewForPosition = recycler.getViewForPosition(i);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
            int decoratedMeasurementInOther = orientationHelper.getDecoratedMeasurementInOther(viewForPosition);
            int i4 = this.itemMargin + i2;
            int paddingTop = (int) (getPaddingTop() + ((verticalSpace - decoratedMeasurementInOther) / 2.0f));
            i2 = i4 + decoratedMeasurement;
            layoutDecoratedWithMargins(viewForPosition, i4, paddingTop, i2, paddingTop + decoratedMeasurementInOther);
            this.mLastVisiblePosition = i;
            i++;
        }
    }

    private void fillTop(RecyclerView.Recycler recycler, int i, int i2, int i3) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int horizontalSpace = getHorizontalSpace();
        while (i2 > i3) {
            if (i < 0) {
                if (!this.isLooper) {
                    return;
                } else {
                    i = getItemCount() - 1;
                }
            }
            View viewForPosition = recycler.getViewForPosition(i);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasurementInOther = orientationHelper.getDecoratedMeasurementInOther(viewForPosition);
            int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - decoratedMeasurementInOther) / 2.0f));
            int i4 = i2 - this.itemMargin;
            i2 = i4 - decoratedMeasurement;
            layoutDecoratedWithMargins(viewForPosition, paddingLeft, i2, paddingLeft + decoratedMeasurementInOther, i4);
            this.mFirstVisiblePosition = i;
            i--;
        }
    }

    private void fillWithHorizontal(RecyclerView.Recycler recycler, int i) {
        View childAt;
        View childAt2;
        OrientationHelper orientationHelper = getOrientationHelper();
        int startAfterPadding = orientationHelper.getStartAfterPadding() - this.offsetEdgeSize;
        int endAfterPadding = orientationHelper.getEndAfterPadding() + this.offsetEdgeSize;
        if (getChildCount() > 0) {
            if (i >= 0) {
                removeAndRecyclerWithStart(recycler, startAfterPadding + i);
            } else {
                removeAndRecyclerWithEnd(recycler, endAfterPadding + i);
            }
        }
        int decoratedStart = -1;
        if (i >= 0) {
            int position = this.mFirstVisiblePosition;
            if (getChildCount() != 0 && (childAt2 = getChildAt(getChildCount() - 1)) != null) {
                position = getPosition(childAt2) + 1;
                decoratedStart = orientationHelper.getDecoratedEnd(childAt2);
            }
            fillRight(recycler, position, decoratedStart, endAfterPadding + i);
            return;
        }
        int position2 = this.mFirstVisiblePosition;
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            position2 = getPosition(childAt) - 1;
            decoratedStart = orientationHelper.getDecoratedStart(childAt);
        }
        fillLeft(recycler, position2, decoratedStart, startAfterPadding + i);
    }

    private void fillWithVertical(RecyclerView.Recycler recycler, int i) {
        View childAt;
        View childAt2;
        OrientationHelper orientationHelper = getOrientationHelper();
        int startAfterPadding = orientationHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelper.getEndAfterPadding();
        if (getChildCount() > 0) {
            if (i >= 0) {
                removeAndRecyclerWithStart(recycler, startAfterPadding + i);
            } else {
                removeAndRecyclerWithEnd(recycler, endAfterPadding + i);
            }
        }
        int decoratedStart = -1;
        if (i >= 0) {
            int position = this.mFirstVisiblePosition;
            if (getChildCount() != 0 && (childAt2 = getChildAt(getChildCount() - 1)) != null) {
                position = getPosition(childAt2) + 1;
                decoratedStart = orientationHelper.getDecoratedEnd(childAt2);
            }
            fillBottom(recycler, position, decoratedStart, endAfterPadding + i);
            return;
        }
        int position2 = this.mFirstVisiblePosition;
        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
            position2 = getPosition(childAt) - 1;
            decoratedStart = orientationHelper.getDecoratedStart(childAt);
        }
        fillTop(recycler, position2, decoratedStart, startAfterPadding + i);
    }

    private void firstFill(RecyclerView.Recycler recycler) {
        if (this.mOrientation == 0) {
            firstFillWithHorizontal(recycler);
        } else {
            firstFillWithVertical(recycler);
        }
        if (this.mPageTransformer != null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, calculateOffsetPercentToCenter(childAt, 0.0f), this.mOrientation);
                }
            }
        }
    }

    private void firstFillWithHorizontal(RecyclerView.Recycler recycler) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int startAfterPadding = orientationHelper.getStartAfterPadding() - this.offsetEdgeSize;
        int endAfterPadding = orientationHelper.getEndAfterPadding() + this.offsetEdgeSize;
        int i = this.mInitialSelectedPosition;
        int horizontalSpace = getHorizontalSpace();
        int verticalSpace = getVerticalSpace();
        View viewForPosition = recycler.getViewForPosition(i);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
        int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - decoratedMeasurement) / 2.0f));
        int paddingTop = (int) (getPaddingTop() + ((verticalSpace - r0) / 2.0f));
        int i2 = paddingLeft + decoratedMeasurement;
        layoutDecoratedWithMargins(viewForPosition, paddingLeft, paddingTop, i2, paddingTop + orientationHelper.getDecoratedMeasurementInOther(viewForPosition));
        this.mLastVisiblePosition = i;
        this.mFirstVisiblePosition = i;
        int i3 = (int) (this.itemMarginPercent * decoratedMeasurement);
        this.itemMargin = i3;
        this.offsetEdgeSize = this.mOffscreenPageLimit * (decoratedMeasurement + i3);
        fillLeft(recycler, i - 1, paddingLeft, startAfterPadding);
        fillRight(recycler, i + 1, i2, endAfterPadding);
    }

    private void firstFillWithVertical(RecyclerView.Recycler recycler) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int startAfterPadding = orientationHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelper.getEndAfterPadding();
        int i = this.mInitialSelectedPosition;
        int horizontalSpace = getHorizontalSpace();
        int verticalSpace = getVerticalSpace();
        View viewForPosition = recycler.getViewForPosition(i);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int decoratedMeasurementInOther = orientationHelper.getDecoratedMeasurementInOther(viewForPosition);
        int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewForPosition);
        int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - decoratedMeasurementInOther) / 2.0f));
        int paddingTop = (int) (getPaddingTop() + ((verticalSpace - decoratedMeasurement) / 2.0f));
        int i2 = paddingTop + decoratedMeasurement;
        layoutDecoratedWithMargins(viewForPosition, paddingLeft, paddingTop, paddingLeft + decoratedMeasurementInOther, i2);
        this.mLastVisiblePosition = i;
        this.mFirstVisiblePosition = i;
        this.itemMargin = (int) (this.itemMarginPercent * decoratedMeasurement);
        fillTop(recycler, i - 1, paddingTop, startAfterPadding);
        fillBottom(recycler, i + 1, i2, endAfterPadding);
    }

    private int getHorizontalSpace() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private b getState() {
        if (this.mState == null) {
            this.mState = new b();
        }
        return this.mState;
    }

    private int getVerticalSpace() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void removeAndRecyclerWithEnd(RecyclerView.Recycler recycler, int i) {
        OrientationHelper orientationHelper = getOrientationHelper();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt == null || orientationHelper.getDecoratedStart(childAt) - this.itemMargin <= i) {
                return;
            }
            removeAndRecycleView(childAt, recycler);
            if (this.isLooper && this.mLastVisiblePosition == 0) {
                this.mLastVisiblePosition = getItemCount();
            }
            this.mLastVisiblePosition--;
        }
    }

    private void removeAndRecyclerWithStart(RecyclerView.Recycler recycler, int i) {
        OrientationHelper orientationHelper = getOrientationHelper();
        int childCount = getChildCount();
        while (childCount > 0) {
            View childAt = getChildAt(0);
            if (childAt == null || orientationHelper.getDecoratedEnd(childAt) + this.itemMargin >= i) {
                return;
            }
            removeAndRecycleView(childAt, recycler);
            if (this.isLooper && this.mFirstVisiblePosition >= getItemCount() - 1) {
                this.mFirstVisiblePosition = -1;
            }
            this.mFirstVisiblePosition++;
        }
    }

    private void reset() {
        int i = this.mCurItem;
        if (i != -1) {
            this.mInitialSelectedPosition = i;
        }
        int iMin = Math.min(Math.max(0, this.mInitialSelectedPosition), getItemCount() - 1);
        this.mInitialSelectedPosition = iMin;
        this.mFirstVisiblePosition = iMin;
        this.mLastVisiblePosition = iMin;
        this.mCurItem = -1;
    }

    private int scrollBy(int i, RecyclerView.Recycler recycler) {
        int iMin;
        int i2 = -i;
        OrientationHelper orientationHelper = getOrientationHelper();
        int endAfterPadding = ((orientationHelper.getEndAfterPadding() - orientationHelper.getStartAfterPadding()) / 2) + orientationHelper.getStartAfterPadding();
        if (i > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && this.mLastVisiblePosition == getItemCount() - 1 && !this.isLooper) {
                iMin = Math.max(0, Math.min(i, (((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - endAfterPadding) + (this.isRebound ? orientationHelper.getTotalSpace() / 3 : 0)));
                i2 = -iMin;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (this.mFirstVisiblePosition == 0 && childAt2 != null && !this.isLooper) {
                iMin = Math.min(0, Math.max(i, (((orientationHelper.getDecoratedMeasurement(childAt2) / 2) + orientationHelper.getDecoratedStart(childAt2)) - endAfterPadding) - (this.isRebound ? orientationHelper.getTotalSpace() / 3 : 0)));
                i2 = -iMin;
            }
        }
        int i3 = -i2;
        getState().f9378a = i3;
        fill(recycler, i3);
        return i2;
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(this);
        recyclerView.removeOnScrollListener(this.mInnerScrollListener);
        recyclerView.addOnScrollListener(this.mInnerScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.canScrollHorizontally && this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.canScrollVertically && this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Nullable
    public View findCenterView() {
        OrientationHelper orientationHelper = getOrientationHelper();
        int childCount = getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int iAbs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 1 ? new a(-1, -2) : new a(-2, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @NonNull
    public OrientationHelper getOrientationHelper() {
        if (this.mOrientation == 0) {
            if (this.mHorizontalHelper == null) {
                this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(this);
            }
            return this.mHorizontalHelper;
        }
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(this);
        }
        return this.mVerticalHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            reset();
            removeAndRecycleAllViews(recycler);
        } else {
            if (state.isPreLayout()) {
                return;
            }
            if (state.getItemCount() == 0 || state.didStructureChange() || getState().b) {
                reset();
                detachAndScrapAttachedViews(recycler);
                firstFill(recycler);
                getState().b = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1 || getChildCount() == 0 || i == 0) {
            return 0;
        }
        int iScrollBy = scrollBy(i, recycler);
        offsetChildrenHorizontal(iScrollBy);
        return -iScrollBy;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mCurItem = i;
        getState().b = true;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0 || getChildCount() == 0 || i == 0) {
            return 0;
        }
        int iScrollBy = scrollBy(i, recycler);
        offsetChildrenVertical(iScrollBy);
        return -iScrollBy;
    }

    public void setCanScrollHorizontally(boolean z) {
        this.canScrollHorizontally = z;
    }

    public void setCanScrollVertically(boolean z) {
        this.canScrollVertically = z;
    }

    public void setItemTransformer(g gVar) {
        this.mPageTransformer = gVar;
        this.mInitialSelectedPosition = this.mCurItem;
        getState().b = true;
        requestLayout();
    }

    public void setLooper(boolean z) {
        this.isLooper = z;
        this.mInitialSelectedPosition = this.mCurItem;
        getState().b = true;
        requestLayout();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mOffscreenPageLimit = i;
    }

    public void setOnPageChangeListener(e eVar) {
        this.mOnPageChangeListener = eVar;
    }

    public void setOnPageScrollStateChangeListener(f fVar) {
        this.mOnPageScrollStateChangeListener = fVar;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
        this.mInitialSelectedPosition = this.mCurItem;
        getState().b = true;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        int i2;
        View viewFindCenterView = findCenterView();
        if (viewFindCenterView == null) {
            scrollToPosition(i);
            return;
        }
        int position = getPosition(viewFindCenterView);
        int i3 = -1;
        boolean z = this.isLooper;
        if (i >= position) {
            if (z) {
                i2 = i - position;
                int itemCount = (position + getItemCount()) - i;
                if (i2 > itemCount) {
                    i2 = itemCount;
                }
            } else {
                i2 = i - position;
            }
            i3 = 1;
        } else if (z) {
            i2 = position - i;
            int itemCount2 = (i + getItemCount()) - position;
            if (i2 >= itemCount2) {
                i2 = itemCount2;
                i3 = 1;
            }
        } else {
            i2 = position - i;
        }
        OrientationHelper orientationHelper = getOrientationHelper();
        int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindCenterView);
        int totalSpace = ((i2 * (((int) (decoratedMeasurement * this.itemMarginPercent)) + decoratedMeasurement)) - ((((int) ((orientationHelper.getTotalSpace() + (decoratedMeasurement * i3)) / 2.0f)) - (i3 == 1 ? orientationHelper.getDecoratedEnd(viewFindCenterView) : orientationHelper.getDecoratedStart(viewFindCenterView))) * i3)) * i3;
        if (this.mOrientation == 0) {
            recyclerView.smoothScrollBy(totalSpace, 0);
        } else {
            recyclerView.smoothScrollBy(0, totalSpace);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }
}
