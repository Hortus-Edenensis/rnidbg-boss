package com.bytedance.sdk.openadsdk.res.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.gi.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class LazeLayout<T extends View> extends View {
    private AtomicBoolean b;
    private u fx;
    private View.OnClickListener iz;
    private T n;
    private volatile Context nr;
    private AtomicBoolean pn;
    private volatile com.bytedance.sdk.openadsdk.res.layout.u<T> u;
    private View.OnTouchListener x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u<T extends View> {
        void u(T t);
    }

    public LazeLayout(Context context, com.bytedance.sdk.openadsdk.res.layout.u uVar, u uVar2) {
        super(context);
        this.b = new AtomicBoolean(false);
        this.pn = new AtomicBoolean(false);
        this.u = uVar;
        this.nr = context;
        this.fx = uVar2;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.pn.set(true);
        if (this.b.get()) {
            return;
        }
        this.b.set(true);
        T t = this.n;
        if (t != null) {
            u(t, getParent());
        } else {
            jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.n = lazeLayout.u.nr(LazeLayout.this.nr);
                        if (LazeLayout.this.n == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.u(lazeLayout2.n, LazeLayout.this.getParent());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pn.set(false);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iz = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.x = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.pn.get()) {
                jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.u(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.b.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.pn.get()) {
                        LazeLayout.this.u(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.b.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.nr = null;
        this.u = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.iz;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.x;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        u uVar = this.fx;
        if (uVar != null) {
            uVar.u(t);
        }
        this.n = null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public void u() {
        this.n = null;
        this.u = null;
        this.nr = null;
        this.fx = null;
    }
}
