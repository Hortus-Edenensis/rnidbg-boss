package com.opos.mobad.template.cmn.cardslideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.opos.mobad.template.cmn.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CardSlideView<T> extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f9376a;
    private float b;
    private boolean c;
    private float d;
    private int e;
    private InnerRecyclerView f;
    private GalleryLayoutManager g;
    private CardAdapter<T> h;
    private CardAdapter<T> i;

    /* JADX INFO: compiled from: SearchBox */
    public static class CardAdapter<T> extends RecyclerView.Adapter<c> {
        private List<T> mData;

        @NonNull
        private b<T> mHolder;
        private float mItemRate;
        private int mOrientation;
        private float mSideOffsetPercent;
        private p onClickListener;

        public CardAdapter(List<T> list, @NonNull b<T> bVar, float f, int i, float f2, p pVar) {
            this.mData = list;
            this.mHolder = bVar;
            this.mSideOffsetPercent = f;
            this.mOrientation = i;
            this.mItemRate = f2;
            this.onClickListener = pVar;
        }

        public List<T> getData() {
            return this.mData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<T> list = this.mData;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void notifyChanged(List<T> list) {
            this.mData = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull c cVar, int i) {
            this.mHolder.a(cVar, this.mData.get(i), i);
            p pVar = this.onClickListener;
            if (pVar != null) {
                p.a(cVar.itemView, pVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View viewA = this.mHolder.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewA.getLayoutParams();
            if (this.mOrientation == 0) {
                int iRound = Math.round(viewGroup.getMeasuredWidth() / ((this.mSideOffsetPercent * 2.0f) + 1.0f));
                ((ViewGroup.MarginLayoutParams) layoutParams).width = ((iRound - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 0 + 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = ((Math.round(iRound * this.mItemRate) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 0 + 0;
            } else {
                int iRound2 = Math.round(viewGroup.getMeasuredHeight() / ((this.mSideOffsetPercent * 2.0f) + 1.0f));
                ((ViewGroup.MarginLayoutParams) layoutParams).height = ((iRound2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 0 + 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).width = ((Math.round(iRound2 / this.mItemRate) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 0 + 0;
            }
            return new c(viewA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class InnerRecyclerView extends RecyclerView {
        private float countRate;
        private float downX;
        private float downY;
        private float itemMarginPercent;
        private int mode;
        private int orientation;
        private Scroller scroller;
        private int touchSlop;

        private InnerRecyclerView(Context context) {
            super(context);
            this.mode = 1;
            this.orientation = 0;
            this.touchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
            setScrollingTouchSlop(1);
            setChildrenDrawingOrderEnabled(true);
            this.scroller = new Scroller(context, new DecelerateInterpolator());
            setOnFlingListener(new RecyclerView.OnFlingListener() { // from class: com.opos.mobad.template.cmn.cardslideview.CardSlideView.InnerRecyclerView.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
                public boolean onFling(int i, int i2) {
                    GalleryLayoutManager galleryLayoutManager;
                    View viewFindCenterView;
                    int decoratedStart;
                    int i3;
                    int minFlingVelocity = InnerRecyclerView.this.getMinFlingVelocity();
                    if (Math.abs(i2) <= minFlingVelocity && Math.abs(i) <= minFlingVelocity) {
                        return false;
                    }
                    RecyclerView.LayoutManager layoutManager = InnerRecyclerView.this.getLayoutManager();
                    if (!(layoutManager instanceof GalleryLayoutManager) || (viewFindCenterView = (galleryLayoutManager = (GalleryLayoutManager) layoutManager).findCenterView()) == null) {
                        return false;
                    }
                    OrientationHelper orientationHelper = galleryLayoutManager.getOrientationHelper();
                    int decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindCenterView);
                    int i4 = ((int) (decoratedMeasurement * InnerRecyclerView.this.itemMarginPercent)) + decoratedMeasurement;
                    int orientation = galleryLayoutManager.getOrientation();
                    int i5 = orientation == 0 ? i : i2;
                    int dist = (InnerRecyclerView.this.mode == 1 ? 1 : (int) ((InnerRecyclerView.this.getDist(i, i2, orientation) / ((double) i4)) * ((double) InnerRecyclerView.this.countRate))) * i4;
                    if (i5 > 0) {
                        decoratedStart = orientationHelper.getDecoratedEnd(viewFindCenterView);
                        i3 = 1;
                    } else {
                        decoratedStart = orientationHelper.getDecoratedStart(viewFindCenterView);
                        i3 = -1;
                    }
                    int totalSpace = dist - ((((int) ((orientationHelper.getTotalSpace() + (decoratedMeasurement * i3)) / 2.0f)) - decoratedStart) * i3);
                    InnerRecyclerView innerRecyclerView = InnerRecyclerView.this;
                    int i6 = totalSpace * i3;
                    if (orientation == 0) {
                        innerRecyclerView.smoothScrollBy(i6, 0);
                        return true;
                    }
                    innerRecyclerView.smoothScrollBy(0, i6);
                    return true;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getDist(int i, int i2, int i3) {
            this.scroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            Scroller scroller = this.scroller;
            return Math.abs(i3 == 0 ? scroller.getFinalX() : scroller.getFinalY());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setItemMarginPercent(float f) {
            this.itemMarginPercent = f;
            this.countRate = (f < 0.0f ? Math.max(-0.9f, f) : Math.min(1.0f, f)) + 1.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMode(int i) {
            this.mode = i;
            if (i == 1) {
                this.touchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
                setScrollingTouchSlop(1);
            } else {
                this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                setScrollingTouchSlop(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public int getChildDrawingOrder(int i, int i2) {
            if (this.itemMarginPercent < 0.0f) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                if (layoutManager instanceof GalleryLayoutManager) {
                    int iIndexOfChild = i2 - indexOfChild(((GalleryLayoutManager) layoutManager).findCenterView());
                    if (iIndexOfChild >= 0) {
                        i2 = (i - 1) - iIndexOfChild;
                    }
                    if (i2 < 0) {
                        return 0;
                    }
                    int i3 = i - 1;
                    return i2 > i3 ? i3 : i2;
                }
            }
            return super.getChildDrawingOrder(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
            } else if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float fAbs = Math.abs(x - this.downX);
                float fAbs2 = Math.abs(y - this.downY);
                int i = this.orientation;
                if ((i == 0 && fAbs > this.touchSlop && fAbs > fAbs2) || (i == 1 && fAbs2 > this.touchSlop && fAbs2 > fAbs)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setOrientation(int i) {
            this.orientation = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public CardSlideView(@NonNull Context context, float f, float f2, float f3, int i, int i2, int i3) {
        super(context);
        a(context, f, f2, f3, i, i2, i3);
    }

    public int a() {
        return this.g.getOrientation();
    }

    public List<T> b() {
        if (a() == 0) {
            CardAdapter<T> cardAdapter = this.h;
            if (cardAdapter == null) {
                return null;
            }
            return cardAdapter.getData();
        }
        CardAdapter<T> cardAdapter2 = this.i;
        if (cardAdapter2 == null) {
            return null;
        }
        return cardAdapter2.getData();
    }

    public int c() {
        return this.g.getItemCount();
    }

    public int d() {
        return this.g.getCurrentItem();
    }

    public View e() {
        return this.g.findCenterView();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iRound;
        int paddingBottom;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            iRound = View.MeasureSpec.getSize(i);
            paddingBottom = Math.round(Math.round(((iRound - getPaddingLeft()) - getPaddingRight()) / ((this.b * 2.0f) + 1.0f)) * this.d) + getPaddingTop() + getPaddingBottom();
        } else {
            iRound = 0;
            paddingBottom = 0;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            paddingBottom = View.MeasureSpec.getSize(i2);
            if (iRound == 0) {
                iRound = Math.round(Math.round(((paddingBottom - getPaddingTop()) - getPaddingBottom()) / ((this.b * 2.0f) + 1.0f)) / this.d) + getPaddingLeft() + getPaddingRight();
            }
        }
        if (iRound == 0 || paddingBottom == 0) {
            iRound = this.e;
            paddingBottom = getPaddingBottom() + Math.round(Math.round(((iRound - getPaddingLeft()) - getPaddingRight()) / ((this.b * 2.0f) + 1.0f)) * this.d) + getPaddingTop();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iRound, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824));
    }

    public int a(@NonNull View view) {
        return this.g.getPosition(view);
    }

    public void b(boolean z) {
        this.g.setCanScrollHorizontally(z);
    }

    public void c(boolean z) {
        this.g.setCanScrollVertically(z);
    }

    public void a(int i, boolean z) {
        int iC = c();
        if (iC > 0 && i != d()) {
            if (this.c) {
                if (i < 0) {
                    i = (i + iC) % iC;
                }
                if (i >= iC) {
                    i %= iC;
                }
            }
            if (i < 0 || i >= iC) {
                return;
            }
            if (z) {
                this.f.smoothScrollToPosition(i);
            } else {
                this.f.scrollToPosition(i);
            }
        }
    }

    private void a(Context context, float f, float f2, float f3, int i, int i2, int i3) {
        if (i <= 0) {
            i = 300;
        }
        this.e = com.opos.cmn.an.h.f.a.a(getContext(), i);
        this.c = true;
        this.b = f2;
        this.d = f3;
        this.b = Math.min(1.0f, Math.max(0.0f, f2));
        InnerRecyclerView innerRecyclerView = new InnerRecyclerView(context);
        this.f = innerRecyclerView;
        innerRecyclerView.setMode(i3);
        this.f.setHasFixedSize(true);
        this.f.setNestedScrollingEnabled(false);
        this.f.setOverScrollMode(2);
        this.f.setItemMarginPercent(f);
        addView(this.f);
        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(i2, this.c, false, f);
        this.g = galleryLayoutManager;
        galleryLayoutManager.setOffscreenPageLimit(1);
        this.g.setItemTransformer(new d());
        this.g.attachToRecyclerView(this.f);
    }

    public void a(g gVar) {
        this.g.setItemTransformer(gVar);
    }

    public void a(p pVar) {
        this.f9376a = pVar;
    }

    public void a(List<T> list, @NonNull b<T> bVar, boolean z) {
        CardAdapter<T> cardAdapter;
        int iA = a();
        if (iA == 0) {
            CardAdapter<T> cardAdapter2 = this.h;
            if (cardAdapter2 != null && !z) {
                cardAdapter2.notifyChanged(list);
                return;
            } else {
                cardAdapter = new CardAdapter<>(list, bVar, this.b, iA, this.d, this.f9376a);
                this.h = cardAdapter;
            }
        } else {
            CardAdapter<T> cardAdapter3 = this.i;
            if (cardAdapter3 != null && !z) {
                cardAdapter3.notifyChanged(list);
                return;
            } else {
                cardAdapter = new CardAdapter<>(list, bVar, this.b, iA, this.d, this.f9376a);
                this.i = cardAdapter;
            }
        }
        this.f.setAdapter(cardAdapter);
    }

    public void a(boolean z) {
        this.g.setLooper(z);
    }
}
