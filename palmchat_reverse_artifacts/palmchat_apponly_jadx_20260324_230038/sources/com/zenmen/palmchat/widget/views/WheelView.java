package com.zenmen.palmchat.widget.views;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.views.a;
import defpackage.av2;
import defpackage.nk6;
import defpackage.ok6;
import defpackage.x74;
import defpackage.y74;
import defpackage.z74;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WheelView extends View {
    private static final int DEF_VISIBLE_ITEMS = 5;
    private static final int ITEM_OFFSET_PERCENT = 10;
    private static final int PADDING = 10;
    private int CENTER_DRAWABLE;
    private int[] SHADOWS_COLORS;
    private GradientDrawable bottomShadow;
    private Drawable centerDrawable;
    private List<x74> changingListeners;
    private List<y74> clickingListeners;
    private int currentItem;
    private DataSetObserver dataObserver;
    private int firstItem;
    boolean isCyclic;
    private boolean isScrollingPerformed;
    private int itemHeight;
    private LinearLayout itemsLayout;
    private nk6 recycle;
    private com.zenmen.palmchat.widget.views.a scroller;
    a.c scrollingListener;
    private List<z74> scrollingListeners;
    private int scrollingOffset;
    private GradientDrawable topShadow;
    private ok6 viewAdapter;
    private int visibleItems;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.c {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.views.a.c
        public void a() {
            if (WheelView.this.isScrollingPerformed) {
                WheelView.this.notifyScrollingListenersAboutEnd();
                WheelView.this.isScrollingPerformed = false;
            }
            WheelView.this.scrollingOffset = 0;
            WheelView.this.invalidate();
        }

        @Override // com.zenmen.palmchat.widget.views.a.c
        public void b(int i) {
            WheelView.this.doScroll(i);
            int height = WheelView.this.getHeight();
            if (WheelView.this.scrollingOffset > height) {
                WheelView.this.scrollingOffset = height;
                WheelView.this.scroller.o();
                return;
            }
            int i2 = -height;
            if (WheelView.this.scrollingOffset < i2) {
                WheelView.this.scrollingOffset = i2;
                WheelView.this.scroller.o();
            }
        }

        @Override // com.zenmen.palmchat.widget.views.a.c
        public void c() {
            if (Math.abs(WheelView.this.scrollingOffset) > 1) {
                WheelView.this.scroller.k(WheelView.this.scrollingOffset, 0);
            }
        }

        @Override // com.zenmen.palmchat.widget.views.a.c
        public void onStarted() {
            WheelView.this.isScrollingPerformed = true;
            WheelView.this.notifyScrollingListenersAboutStart();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            WheelView.this.invalidateWheel(false);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            WheelView.this.invalidateWheel(true);
        }
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SHADOWS_COLORS = new int[]{-285212673, -352321537, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR};
        this.CENTER_DRAWABLE = R.drawable.shape_wheel_val;
        this.currentItem = 0;
        this.visibleItems = 5;
        this.itemHeight = 0;
        this.isCyclic = false;
        this.recycle = new nk6(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }

    private boolean addViewItem(int i, boolean z) {
        View itemView = getItemView(i);
        if (itemView == null) {
            return false;
        }
        if (z) {
            this.itemsLayout.addView(itemView, 0);
            return true;
        }
        this.itemsLayout.addView(itemView);
        return true;
    }

    private void buildViewForMeasuring() {
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout != null) {
            this.recycle.b(linearLayout, this.firstItem, new av2());
        } else {
            createItemsLayout();
        }
        int i = this.visibleItems / 2;
        for (int i2 = this.currentItem + i; i2 >= this.currentItem - i; i2--) {
            if (addViewItem(i2, true)) {
                this.firstItem = i2;
            }
        }
    }

    private int calculateLayoutWidth(int i, int i2) {
        initResourcesIfNecessary();
        this.itemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.itemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.itemsLayout.getMeasuredWidth();
        if (i2 != 1073741824) {
            int iMax = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= iMax) {
                i = iMax;
            }
        }
        this.itemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return i;
    }

    private void createItemsLayout() {
        if (this.itemsLayout == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.itemsLayout = linearLayout;
            linearLayout.setOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScroll(int i) {
        this.scrollingOffset += i;
        int itemHeight = this.scrollingOffset / getItemHeight();
        throw null;
    }

    private void drawCenterRect(Canvas canvas) {
        int height = getHeight() / 2;
        int itemHeight = (int) (((double) (getItemHeight() / 2)) * 1.2d);
        this.centerDrawable.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.centerDrawable.draw(canvas);
    }

    private void drawItems(Canvas canvas) {
        canvas.save();
        canvas.translate(10.0f, (-(((this.currentItem - this.firstItem) * getItemHeight()) + ((getItemHeight() - getHeight()) / 2))) + this.scrollingOffset);
        this.itemsLayout.draw(canvas);
        canvas.restore();
    }

    private void drawShadows(Canvas canvas) {
        int itemHeight = (int) (((double) getItemHeight()) * 1.5d);
        this.topShadow.setBounds(0, 0, getWidth(), itemHeight);
        this.topShadow.draw(canvas);
        this.bottomShadow.setBounds(0, getHeight() - itemHeight, getWidth(), getHeight());
        this.bottomShadow.draw(canvas);
    }

    private int getDesiredHeight(LinearLayout linearLayout) {
        if (linearLayout != null && linearLayout.getChildAt(0) != null) {
            this.itemHeight = linearLayout.getChildAt(0).getMeasuredHeight();
        }
        int i = this.itemHeight;
        return Math.max((this.visibleItems * i) - ((i * 10) / 50), getSuggestedMinimumHeight());
    }

    private int getItemHeight() {
        int i = this.itemHeight;
        if (i != 0) {
            return i;
        }
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return getHeight() / this.visibleItems;
        }
        int height = this.itemsLayout.getChildAt(0).getHeight();
        this.itemHeight = height;
        return height;
    }

    private View getItemView(int i) {
        return null;
    }

    private av2 getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.currentItem;
        int iAsin = 1;
        while (getItemHeight() * iAsin < getHeight()) {
            i--;
            iAsin += 2;
        }
        int i2 = this.scrollingOffset;
        if (i2 != 0) {
            if (i2 > 0) {
                i--;
            }
            int itemHeight = i2 / getItemHeight();
            i -= itemHeight;
            iAsin = (int) (((double) (iAsin + 1)) + Math.asin(itemHeight));
        }
        return new av2(i, iAsin);
    }

    private void initData(Context context) {
        this.scroller = new com.zenmen.palmchat.widget.views.a(getContext(), this.scrollingListener);
    }

    private void initResourcesIfNecessary() {
        if (this.centerDrawable == null) {
            this.centerDrawable = getContext().getResources().getDrawable(this.CENTER_DRAWABLE);
        }
        if (this.topShadow == null) {
            this.topShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.SHADOWS_COLORS);
        }
        if (this.bottomShadow == null) {
            this.bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.SHADOWS_COLORS);
        }
    }

    private boolean isValidItemIndex(int i) {
        return false;
    }

    private void layout(int i, int i2) {
        this.itemsLayout.layout(0, 0, i - 20, i2);
    }

    private boolean rebuildItems() {
        boolean z;
        av2 itemsRange = getItemsRange();
        LinearLayout linearLayout = this.itemsLayout;
        if (linearLayout != null) {
            int iB = this.recycle.b(linearLayout, this.firstItem, itemsRange);
            z = this.firstItem != iB;
            this.firstItem = iB;
        } else {
            createItemsLayout();
            z = true;
        }
        if (!z) {
            z = (this.firstItem == itemsRange.c() && this.itemsLayout.getChildCount() == itemsRange.b()) ? false : true;
        }
        if (this.firstItem <= itemsRange.c() || this.firstItem > itemsRange.d()) {
            this.firstItem = itemsRange.c();
        } else {
            for (int i = this.firstItem - 1; i >= itemsRange.c() && addViewItem(i, true); i--) {
                this.firstItem = i;
            }
        }
        int i2 = this.firstItem;
        for (int childCount = this.itemsLayout.getChildCount(); childCount < itemsRange.b(); childCount++) {
            if (!addViewItem(this.firstItem + childCount, false) && this.itemsLayout.getChildCount() == 0) {
                i2++;
            }
        }
        this.firstItem = i2;
        return z;
    }

    private void updateView() {
        if (rebuildItems()) {
            calculateLayoutWidth(getWidth(), 1073741824);
            layout(getWidth(), getHeight());
        }
    }

    public void addChangingListener(x74 x74Var) {
        this.changingListeners.add(x74Var);
    }

    public void addClickingListener(y74 y74Var) {
        this.clickingListeners.add(y74Var);
    }

    public void addScrollingListener(z74 z74Var) {
        this.scrollingListeners.add(z74Var);
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public ok6 getViewAdapter() {
        return null;
    }

    public int getVisibleItems() {
        return this.visibleItems;
    }

    public void invalidateWheel(boolean z) {
        if (z) {
            this.recycle.a();
            LinearLayout linearLayout = this.itemsLayout;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.scrollingOffset = 0;
        } else {
            LinearLayout linearLayout2 = this.itemsLayout;
            if (linearLayout2 != null) {
                this.recycle.b(linearLayout2, this.firstItem, new av2());
            }
        }
        invalidate();
    }

    public boolean isCyclic() {
        return this.isCyclic;
    }

    public void notifyChangingListeners(int i, int i2) {
        Iterator<x74> it = this.changingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i, i2);
        }
    }

    public void notifyClickListenersAboutClick(int i) {
        Iterator<y74> it = this.clickingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i);
        }
    }

    public void notifyScrollingListenersAboutEnd() {
        Iterator<z74> it = this.scrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void notifyScrollingListenersAboutStart() {
        Iterator<z74> it = this.scrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawShadows(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout(i3 - i, i4 - i2);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        buildViewForMeasuring();
        int iCalculateLayoutWidth = calculateLayoutWidth(size, mode);
        if (mode2 != 1073741824) {
            int desiredHeight = getDesiredHeight(this.itemsLayout);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(desiredHeight, size2) : desiredHeight;
        }
        setMeasuredDimension(iCalculateLayoutWidth, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        getViewAdapter();
        return true;
    }

    public void removeChangingListener(x74 x74Var) {
        this.changingListeners.remove(x74Var);
    }

    public void removeClickingListener(y74 y74Var) {
        this.clickingListeners.remove(y74Var);
    }

    public void removeScrollingListener(z74 z74Var) {
        this.scrollingListeners.remove(z74Var);
    }

    public void scroll(int i, int i2) {
        this.scroller.k((i * getItemHeight()) - this.scrollingOffset, i2);
    }

    public void setCenterDrawable(int i) {
        this.CENTER_DRAWABLE = i;
    }

    public void setCurrentItem(int i, boolean z) {
    }

    public void setCyclic(boolean z) {
        this.isCyclic = z;
        invalidateWheel(false);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.scroller.l(interpolator);
    }

    public void setShadowColors(int[] iArr) {
        this.SHADOWS_COLORS = iArr;
    }

    public void setViewAdapter(ok6 ok6Var) {
        invalidateWheel(true);
    }

    public void setVisibleItems(int i) {
        this.visibleItems = i;
    }

    public void stopScrolling() {
        this.scroller.o();
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SHADOWS_COLORS = new int[]{-285212673, -352321537, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR};
        this.CENTER_DRAWABLE = R.drawable.shape_wheel_val;
        this.currentItem = 0;
        this.visibleItems = 5;
        this.itemHeight = 0;
        this.isCyclic = false;
        this.recycle = new nk6(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }

    public WheelView(Context context) {
        super(context);
        this.SHADOWS_COLORS = new int[]{-285212673, -352321537, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR};
        this.CENTER_DRAWABLE = R.drawable.shape_wheel_val;
        this.currentItem = 0;
        this.visibleItems = 5;
        this.itemHeight = 0;
        this.isCyclic = false;
        this.recycle = new nk6(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        this.scrollingListener = new a();
        this.dataObserver = new b();
        initData(context);
    }
}
