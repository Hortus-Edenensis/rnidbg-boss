package com.zenmen.square.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import defpackage.me1;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdPager extends ViewPager {
    private boolean mIsAttachedToWindow;
    private boolean mIsAutoScroll;
    private Runnable mScrollRunnable;
    private Handler mUIHandler;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.PageTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f16162a;
        public final /* synthetic */ float b;

        public a(float f, float f2) {
            this.f16162a = f;
            this.b = f2;
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            if (f <= 0.0f) {
                view.setScaleY(1.0f);
                view.setScaleX(1.0f);
                view.setTranslationX(0.0f);
                return;
            }
            float width = view.getWidth();
            float height = view.getHeight();
            if (f > 1.0f) {
                float f2 = (height - (this.f16162a * 2.0f)) / height;
                view.setScaleX(f2);
                view.setScaleY(f2);
                view.setTranslationX(((-width) * f) + ((width * (1.0f - f2)) / 2.0f) + (this.b * f2));
                return;
            }
            float f3 = (height - ((this.f16162a * 2.0f) * f)) / height;
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setTranslationX(((-width) * f) + (((width * (1.0f - f3)) / 2.0f) * f) + (this.b * f3 * f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PagerAdapter adapter = AdPager.this.getAdapter();
            if (adapter != null) {
                int count = adapter.getCount();
                int currentItem = AdPager.this.getCurrentItem() + 1;
                if (currentItem >= count) {
                    currentItem = 0;
                }
                if (currentItem < count) {
                    AdPager.this.setCurrentItem(currentItem, true);
                }
            }
            AdPager.this.mUIHandler.postDelayed(this, 2500L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Scroller {
        public c(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, 500);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            startScroll(i, i2, i3, i4, 500);
        }
    }

    public AdPager(Context context) {
        super(context);
        this.mIsAttachedToWindow = false;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mIsAutoScroll = false;
        init(context);
    }

    private void init(Context context) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new c(context, new AccelerateInterpolator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOffscreenPageLimit(2);
        setPageTransformer(true, new a(me1.b(context, 7), me1.b(context, 10)));
    }

    public void beginAutoScroll() {
        if (this.mIsAttachedToWindow) {
            Runnable runnable = this.mScrollRunnable;
            if (runnable != null) {
                this.mUIHandler.removeCallbacks(runnable);
            }
            Handler handler = this.mUIHandler;
            b bVar = new b();
            this.mScrollRunnable = bVar;
            handler.postDelayed(bVar, 2500L);
        }
        this.mIsAutoScroll = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        if (this.mIsAutoScroll) {
            beginAutoScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
        Runnable runnable = this.mScrollRunnable;
        if (runnable != null) {
            this.mUIHandler.removeCallbacks(runnable);
            this.mScrollRunnable = null;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public AdPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAttachedToWindow = false;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mIsAutoScroll = false;
        init(context);
    }
}
