package com.zenmen.palmchat.widget.lxviewswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewSwitcher;
import com.zenmen.palmchat.framework.R$anim;
import defpackage.mp2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CustomLoopingViewSwitcher extends ViewSwitcher implements ViewSwitcher.ViewFactory {
    private int currentIndex;
    private Handler handler;
    private boolean hasStart;
    private int loopInterval;
    private Runnable showNextRunnable;
    public mp2 vp;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomLoopingViewSwitcher.this.showNextView();
            CustomLoopingViewSwitcher.this.handler.removeCallbacks(CustomLoopingViewSwitcher.this.showNextRunnable);
            CustomLoopingViewSwitcher.this.handler.postDelayed(CustomLoopingViewSwitcher.this.showNextRunnable, CustomLoopingViewSwitcher.this.loopInterval);
        }
    }

    public CustomLoopingViewSwitcher(Context context) {
        super(context);
        this.currentIndex = 0;
        this.hasStart = false;
        this.loopInterval = 5000;
        this.showNextRunnable = new a();
    }

    public void initData(mp2 mp2Var, int i, int i2, int i3) {
        this.vp = mp2Var;
        this.loopInterval = i;
        setFactory(this);
        Context context = getContext();
        if (i2 <= 0) {
            i2 = R$anim.enter_from_left;
        }
        setInAnimation(context, i2);
        Context context2 = getContext();
        if (i3 <= 0) {
            i3 = R$anim.out_to_right;
        }
        setOutAnimation(context2, i3);
        mp2Var.d(getCurrentView(), mp2Var.b());
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        return this.vp.a(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAutoScroll();
    }

    public void showNextView() {
        this.vp.d(getNextView(), this.vp.c());
        showNext();
    }

    public void startAutoScroll() {
        if (this.hasStart) {
            return;
        }
        if (this.handler == null) {
            this.handler = new Handler();
        }
        this.hasStart = true;
        this.handler.postDelayed(this.showNextRunnable, this.loopInterval);
    }

    public void stopAutoScroll() {
        this.hasStart = false;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.showNextRunnable);
        }
    }

    public CustomLoopingViewSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentIndex = 0;
        this.hasStart = false;
        this.loopInterval = 5000;
        this.showNextRunnable = new a();
    }
}
