package com.zenmen.palmchat.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.zenmen.palmchat.ad.VisibleDetectView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PinnedSectionListView extends ListView implements VisibleDetectView.e {
    private final DataSetObserver mDataSetObserver;
    AbsListView.OnScrollListener mDelegateOnScrollListener;
    private MotionEvent mDownEvent;
    private final AbsListView.OnScrollListener mOnScrollListener;
    private List<VisibleDetectView.f> mOnScrollListeners;
    d mPinnedSection;
    d mRecycleSection;
    private int mSectionsDistanceY;
    private GradientDrawable mShadowDrawable;
    private int mShadowHeight;
    private final PointF mTouchPoint;
    private final Rect mTouchRect;
    private int mTouchSlop;
    private View mTouchTarget;
    int mTranslateY;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.mDelegateOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
            Iterator it = PinnedSectionListView.this.mOnScrollListeners.iterator();
            while (it.hasNext()) {
                ((VisibleDetectView.f) it.next()).a();
            }
            ListAdapter adapter = PinnedSectionListView.this.getAdapter();
            if (adapter == null || i2 == 0) {
                return;
            }
            if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.destroyPinnedShadow();
                    return;
                } else {
                    PinnedSectionListView.this.ensureShadowForPosition(i, i, i2);
                    return;
                }
            }
            int iFindCurrentSectionPosition = PinnedSectionListView.this.findCurrentSectionPosition(i);
            if (iFindCurrentSectionPosition > -1) {
                PinnedSectionListView.this.ensureShadowForPosition(iFindCurrentSectionPosition, i, i2);
            } else {
                PinnedSectionListView.this.destroyPinnedShadow();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.mDelegateOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PinnedSectionListView.this.recreatePinnedShadow();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            PinnedSectionListView.this.recreatePinnedShadow();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PinnedSectionListView.this.recreatePinnedShadow();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f15992a;
        public int b;
        public long c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e extends ListAdapter {
        void d(View view, int i, long j);

        boolean k(int i);

        void n(View view, int i, long j);
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchRect = new Rect();
        this.mTouchPoint = new PointF();
        this.mOnScrollListeners = new LinkedList();
        this.mOnScrollListener = new a();
        this.mDataSetObserver = new b();
        initView();
    }

    private void clearTouchTarget() {
        this.mTouchTarget = null;
        MotionEvent motionEvent = this.mDownEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.mDownEvent = null;
        }
    }

    private void initView() {
        setOnScrollListener(this.mOnScrollListener);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        initShadow(false);
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((e) listAdapter).k(i);
    }

    private boolean isPinnedViewTouched(View view, float f, float f2) {
        view.getHitRect(this.mTouchRect);
        Rect rect = this.mTouchRect;
        int i = rect.top;
        int i2 = this.mTranslateY;
        rect.top = i + i2;
        rect.bottom += i2 + getPaddingTop();
        this.mTouchRect.left += getPaddingLeft();
        this.mTouchRect.right -= getPaddingRight();
        return this.mTouchRect.contains((int) f, (int) f2);
    }

    private boolean performPinnedItemClick() {
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.mPinnedSection == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.mPinnedSection.b)) {
            return false;
        }
        View view = this.mPinnedSection.f15992a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        d dVar = this.mPinnedSection;
        onItemClickListener.onItemClick(this, view, dVar.b, dVar.c);
        return true;
    }

    @Override // com.zenmen.palmchat.ad.VisibleDetectView.e
    public void addOnScrollListener(VisibleDetectView.f fVar) {
        this.mOnScrollListeners.add(fVar);
    }

    public void createPinnedShadow(int i) {
        d dVar = this.mRecycleSection;
        this.mRecycleSection = null;
        if (dVar == null) {
            dVar = new d();
        }
        View view = getAdapter().getView(i, dVar.f15992a, this);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        int mode = View.MeasureSpec.getMode(layoutParams.height);
        int size = View.MeasureSpec.getSize(layoutParams.height);
        if (mode == 0) {
            mode = 1073741824;
        }
        int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
        if (size > height) {
            size = height;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.mTranslateY = 0;
        dVar.f15992a = view;
        dVar.b = i;
        dVar.c = getAdapter().getItemId(i);
        this.mPinnedSection = dVar;
        ListAdapter adapter = getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            ListAdapter wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            if (wrappedAdapter instanceof e) {
                d dVar2 = this.mPinnedSection;
                ((e) wrappedAdapter).d(dVar2.f15992a, dVar2.b, dVar2.c);
            }
        }
    }

    public void destroyPinnedShadow() {
        d dVar = this.mPinnedSection;
        if (dVar != null) {
            this.mRecycleSection = dVar;
            if (dVar != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    ListAdapter wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                    if (wrappedAdapter instanceof e) {
                        d dVar2 = this.mPinnedSection;
                        ((e) wrappedAdapter).n(dVar2.f15992a, dVar2.b, dVar2.c);
                    }
                }
            }
            this.mPinnedSection = null;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mPinnedSection != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.mPinnedSection.f15992a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + (this.mShadowDrawable == null ? 0 : Math.min(this.mShadowHeight, this.mSectionsDistanceY)) + listPaddingTop);
            canvas.translate(listPaddingLeft, listPaddingTop + this.mTranslateY);
            drawChild(canvas, this.mPinnedSection.f15992a, getDrawingTime());
            GradientDrawable gradientDrawable = this.mShadowDrawable;
            if (gradientDrawable != null && this.mSectionsDistanceY > 0) {
                gradientDrawable.setBounds(this.mPinnedSection.f15992a.getLeft(), this.mPinnedSection.f15992a.getBottom(), this.mPinnedSection.f15992a.getRight(), this.mPinnedSection.f15992a.getBottom() + this.mShadowHeight);
                this.mShadowDrawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        d dVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.mTouchTarget == null && (dVar = this.mPinnedSection) != null && isPinnedViewTouched(dVar.f15992a, x, y)) {
            this.mTouchTarget = this.mPinnedSection.f15992a;
            PointF pointF = this.mTouchPoint;
            pointF.x = x;
            pointF.y = y;
            this.mDownEvent = MotionEvent.obtain(motionEvent);
        }
        View view = this.mTouchTarget;
        if (view == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (isPinnedViewTouched(view, x, y)) {
            this.mTouchTarget.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            super.dispatchTouchEvent(motionEvent);
            performPinnedItemClick();
            clearTouchTarget();
        } else if (action == 3) {
            clearTouchTarget();
        } else if (action == 2 && Math.abs(y - this.mTouchPoint.y) > this.mTouchSlop) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            this.mTouchTarget.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            super.dispatchTouchEvent(this.mDownEvent);
            super.dispatchTouchEvent(motionEvent);
            clearTouchTarget();
        }
        return true;
    }

    public void ensureShadowForPosition(int i, int i2, int i3) {
        if (i3 < 2) {
            destroyPinnedShadow();
            return;
        }
        d dVar = this.mPinnedSection;
        if (dVar != null && dVar.b != i) {
            destroyPinnedShadow();
        }
        if (this.mPinnedSection == null) {
            createPinnedShadow(i);
        }
        int i4 = i + 1;
        if (i4 < getCount()) {
            int iFindFirstVisibleSectionPosition = findFirstVisibleSectionPosition(i4, i3 - (i4 - i2));
            if (iFindFirstVisibleSectionPosition <= -1) {
                this.mTranslateY = 0;
                this.mSectionsDistanceY = Integer.MAX_VALUE;
                return;
            }
            View childAt = getChildAt(iFindFirstVisibleSectionPosition - i2);
            int top = childAt.getTop() - (this.mPinnedSection.f15992a.getBottom() + getPaddingTop());
            this.mSectionsDistanceY = top;
            if (top < 0) {
                this.mTranslateY = top;
            } else {
                this.mTranslateY = 0;
            }
        }
    }

    public int findCurrentSectionPosition(int i) {
        ListAdapter adapter = getAdapter();
        if (i >= adapter.getCount()) {
            return -1;
        }
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i));
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i >= 0) {
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public int findFirstVisibleSectionPosition(int i, int i2) {
        ListAdapter adapter = getAdapter();
        int count = adapter.getCount();
        if (getLastVisiblePosition() >= count) {
            return -1;
        }
        if (i + i2 >= count) {
            i2 = count - i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                return i4;
            }
        }
        return -1;
    }

    public void initShadow(boolean z) {
        if (z) {
            if (this.mShadowDrawable == null) {
                this.mShadowDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.mShadowHeight = (int) (getResources().getDisplayMetrics().density * 8.0f);
                return;
            }
            return;
        }
        if (this.mShadowDrawable != null) {
            this.mShadowDrawable = null;
            this.mShadowHeight = 0;
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mPinnedSection == null || ((i3 - i) - getPaddingLeft()) - getPaddingRight() == this.mPinnedSection.f15992a.getWidth()) {
            return;
        }
        recreatePinnedShadow();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new c());
    }

    public void recreatePinnedShadow() {
        int firstVisiblePosition;
        int iFindCurrentSectionPosition;
        destroyPinnedShadow();
        ListAdapter adapter = getAdapter();
        if (adapter == null || adapter.getCount() <= 0 || (iFindCurrentSectionPosition = findCurrentSectionPosition((firstVisiblePosition = getFirstVisiblePosition()))) == -1) {
            return;
        }
        ensureShadowForPosition(iFindCurrentSectionPosition, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
    }

    @Override // com.zenmen.palmchat.ad.VisibleDetectView.e
    public void removeOnScrollListener(VisibleDetectView.f fVar) {
        this.mOnScrollListeners.remove(fVar);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.mOnScrollListener) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.mDelegateOnScrollListener = onScrollListener;
        }
    }

    public void setShadowVisible(boolean z) {
        initShadow(z);
        d dVar = this.mPinnedSection;
        if (dVar != null) {
            View view = dVar.f15992a;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.mShadowHeight);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            if (!(listAdapter instanceof e)) {
                throw new IllegalArgumentException("Does your adapter implement PinnedSectionListAdapter?");
            }
            if (listAdapter.getViewTypeCount() < 2) {
                throw new IllegalArgumentException("Does your adapter handle at least two types of views in getViewTypeCount() method: items and sections?");
            }
        }
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mDataSetObserver);
        }
        if (adapter != listAdapter) {
            destroyPinnedShadow();
        }
        super.setAdapter(listAdapter);
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchRect = new Rect();
        this.mTouchPoint = new PointF();
        this.mOnScrollListeners = new LinkedList();
        this.mOnScrollListener = new a();
        this.mDataSetObserver = new b();
        initView();
    }
}
