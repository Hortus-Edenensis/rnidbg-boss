package com.zenmen.palmchat.contacts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppbarZoomBehavior extends AppBarLayout.Behavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f13308a;
    public View b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public boolean h;
    public ValueAnimator i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f13309a;

        public a(AppBarLayout appBarLayout) {
            this.f13309a = appBarLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            AppbarZoomBehavior.this.f13308a.setScaleX(fFloatValue);
            AppbarZoomBehavior.this.f13308a.setScaleY(fFloatValue);
            this.f13309a.setBottom((int) (AppbarZoomBehavior.this.g - ((AppbarZoomBehavior.this.g - AppbarZoomBehavior.this.c) * valueAnimator.getAnimatedFraction())));
            AppbarZoomBehavior.this.b.setTranslationY((int) ((AppbarZoomBehavior.this.d / 2) * (fFloatValue - 1.0f)));
        }
    }

    public AppbarZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void f(AppBarLayout appBarLayout) {
        appBarLayout.setClipChildren(false);
        this.c = appBarLayout.getHeight();
        this.f13308a = (ImageView) appBarLayout.findViewById(R.id.portrait);
        this.b = appBarLayout.findViewById(R.id.name);
        ImageView imageView = this.f13308a;
        if (imageView != null) {
            this.d = imageView.getHeight();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        return super.onNestedPreFling(coordinatorLayout, appBarLayout, view, f, f2);
    }

    public final void h(AppBarLayout appBarLayout) {
        if (this.e > 0.0f) {
            this.e = 0.0f;
            if (this.h) {
                ValueAnimator duration = ValueAnimator.ofFloat(this.f, 1.0f).setDuration(220L);
                this.i = duration;
                duration.addUpdateListener(new a(appBarLayout));
                this.i.start();
                return;
            }
            this.f13308a.setScaleX(1.0f);
            this.f13308a.setScaleY(1.0f);
            appBarLayout.setBottom(this.c);
            this.b.setTranslationY(0.0f);
        }
    }

    public final void i(AppBarLayout appBarLayout, int i) {
        float f = this.e + (-i);
        this.e = f;
        float fMin = Math.min(f, (this.d * 3.0f) / 2.0f);
        this.e = fMin;
        float fMax = Math.max(1.0f, (fMin / ((this.d * 3.0f) / 2.0f)) + 1.0f);
        this.f = fMax;
        this.f13308a.setScaleX(fMax);
        this.f13308a.setScaleY(this.f);
        int i2 = this.c + ((int) ((this.d / 2) * (this.f - 1.0f)));
        this.g = i2;
        appBarLayout.setBottom(i2);
        this.b.setTranslationY((int) ((this.d / 2) * (this.f - 1.0f)));
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        f(appBarLayout);
        return zOnLayoutChild;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (this.f13308a != null && appBarLayout.getBottom() >= this.c && i2 < 0 && i3 == 0) {
            i(appBarLayout, i2);
            return;
        }
        if (this.f13308a != null && appBarLayout.getBottom() > this.c && i2 > 0 && i3 == 0) {
            iArr[1] = i2;
            i(appBarLayout, i2);
            return;
        }
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        this.h = true;
        return true;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        if (i == 0) {
            h(appBarLayout);
        }
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
    }
}
