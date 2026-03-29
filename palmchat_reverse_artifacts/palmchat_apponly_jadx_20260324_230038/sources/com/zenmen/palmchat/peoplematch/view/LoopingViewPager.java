package com.zenmen.palmchat.peoplematch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LoopingViewPager extends ViewPager {
    private int count;
    private int currentItem;
    private int fixedHeight;
    private c indicatorChangeListener;
    private boolean isAutoLooping;
    private boolean isTouching;
    private int lastDownX;
    private int lastDownY;
    private Runnable loop;
    private LoopingPagerAdapter pagerAdapter;
    private int scrollState;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            LoopingViewPager.this.scrollState = i;
            if (i == 0) {
                if (LoopingViewPager.this.currentItem == 0) {
                    LoopingViewPager loopingViewPager = LoopingViewPager.this;
                    loopingViewPager.setCurrentItem(loopingViewPager.count, false);
                    return;
                } else {
                    if (LoopingViewPager.this.currentItem == LoopingViewPager.this.count + 1) {
                        LoopingViewPager.this.setCurrentItem(1, false);
                        return;
                    }
                    return;
                }
            }
            if (i != 1) {
                return;
            }
            if (LoopingViewPager.this.currentItem == LoopingViewPager.this.count + 1) {
                LoopingViewPager.this.setCurrentItem(1, false);
            } else if (LoopingViewPager.this.currentItem == 0) {
                LoopingViewPager loopingViewPager2 = LoopingViewPager.this;
                loopingViewPager2.setCurrentItem(loopingViewPager2.count, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (LoopingViewPager.this.indicatorChangeListener != null) {
                LoopingViewPager.this.indicatorChangeListener.a(LoopingViewPager.this.toDataPosition(i), f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LoopingViewPager.this.currentItem = i;
            if (LoopingViewPager.this.indicatorChangeListener != null) {
                LoopingViewPager.this.indicatorChangeListener.b(LoopingViewPager.this.toDataPosition(i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!LoopingViewPager.this.isTouching) {
                LoopingViewPager.this.setCurrentItem(LoopingViewPager.this.getNextPosition(), true);
            }
            LoopingViewPager loopingViewPager = LoopingViewPager.this;
            loopingViewPager.postDelayed(loopingViewPager.loop, 3000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i, float f);

        void b(int i);
    }

    public LoopingViewPager(Context context) {
        super(context);
        this.scrollState = 0;
        this.fixedHeight = 0;
        this.isTouching = false;
        this.isAutoLooping = false;
        this.loop = new b();
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextPosition() {
        int i = this.currentItem;
        int i2 = this.count;
        return i < i2 + 1 ? 1 + i : i == i2 + 1 ? 1 : 0;
    }

    private void init(Context context) {
        addOnPageChangeListener(new a());
    }

    private void setAutoLoop(boolean z) {
        if (this.count > 1) {
            if (!z) {
                removeCallbacks(this.loop);
            } else {
                removeCallbacks(this.loop);
                postDelayed(this.loop, 3000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.lastDownX = (int) motionEvent.getX();
            this.lastDownY = (int) motionEvent.getY();
            this.isTouching = true;
        } else if (motionEvent != null && motionEvent.getAction() == 2) {
            int x = (int) motionEvent.getX();
            if (Math.abs(this.lastDownX - x) > ((double) Math.abs(this.lastDownY - ((int) motionEvent.getY()))) * Math.tan(Math.toRadians(30.0d)) && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (motionEvent != null && motionEvent.getAction() == 1) {
            this.isTouching = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrentPosition() {
        return toDataPosition(this.currentItem);
    }

    public int getScrollState() {
        return this.scrollState;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.loop);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.count <= 1) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.fixedHeight;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.count <= 1) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        LoopingPagerAdapter loopingPagerAdapter = (LoopingPagerAdapter) pagerAdapter;
        this.pagerAdapter = loopingPagerAdapter;
        loopingPagerAdapter.k(this);
    }

    public void setAutoLooping(boolean z) {
        this.isAutoLooping = z;
        setAutoLoop(z);
    }

    public void setFixedHeight(int i) {
        this.fixedHeight = i;
    }

    public void setIndicatorChangeListener(c cVar) {
        this.indicatorChangeListener = cVar;
    }

    public int toDataPosition(int i) {
        int i2 = this.count;
        int i3 = i2 != 0 ? (i - 1) % i2 : 0;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public void update(List<?> list, int i) {
        this.count = list.size();
        this.pagerAdapter.j(list);
        if (i >= 0) {
            this.currentItem = i + 1;
        } else {
            this.currentItem = 1;
        }
        setFocusable(true);
        setCurrentItem(this.currentItem, false);
    }

    public LoopingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollState = 0;
        this.fixedHeight = 0;
        this.isTouching = false;
        this.isAutoLooping = false;
        this.loop = new b();
        init(context);
    }
}
