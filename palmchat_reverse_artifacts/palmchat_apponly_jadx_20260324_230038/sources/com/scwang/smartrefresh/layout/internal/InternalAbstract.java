package com.scwang.smartrefresh.layout.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import defpackage.fh5;
import defpackage.tu4;
import defpackage.uu4;
import defpackage.vu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class InternalAbstract extends RelativeLayout implements vu4 {
    protected fh5 mSpinnerStyle;
    protected vu4 mWrappedInternal;
    protected View mWrappedView;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalAbstract(@NonNull View view) {
        this(view, view instanceof vu4 ? (vu4) view : null);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof vu4) && getView() == ((vu4) obj).getView();
    }

    @Override // defpackage.vu4
    @NonNull
    public fh5 getSpinnerStyle() {
        int i;
        fh5 fh5Var = this.mSpinnerStyle;
        if (fh5Var != null) {
            return fh5Var;
        }
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var != null && vu4Var != this) {
            return vu4Var.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                fh5 fh5Var2 = ((SmartRefreshLayout.LayoutParams) layoutParams).b;
                this.mSpinnerStyle = fh5Var2;
                if (fh5Var2 != null) {
                    return fh5Var2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (fh5 fh5Var3 : fh5.i) {
                    if (fh5Var3.c) {
                        this.mSpinnerStyle = fh5Var3;
                        return fh5Var3;
                    }
                }
            }
        }
        fh5 fh5Var4 = fh5.d;
        this.mSpinnerStyle = fh5Var4;
        return fh5Var4;
    }

    @Override // defpackage.vu4
    @NonNull
    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    public boolean isSupportHorizontalDrag() {
        vu4 vu4Var = this.mWrappedInternal;
        return (vu4Var == null || vu4Var == this || !vu4Var.isSupportHorizontalDrag()) ? false : true;
    }

    public int onFinish(@NonNull xu4 xu4Var, boolean z) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return 0;
        }
        return vu4Var.onFinish(xu4Var, z);
    }

    public void onHorizontalDrag(float f, int i, int i2) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        vu4Var.onHorizontalDrag(f, i, i2);
    }

    public void onInitialized(@NonNull wu4 wu4Var, int i, int i2) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var != null && vu4Var != this) {
            vu4Var.onInitialized(wu4Var, i, i2);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                wu4Var.j(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f10550a);
            }
        }
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        vu4Var.onMoving(z, f, i, i2, i3);
    }

    public void onReleased(@NonNull xu4 xu4Var, int i, int i2) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        vu4Var.onReleased(xu4Var, i, i2);
    }

    public void onStartAnimator(@NonNull xu4 xu4Var, int i, int i2) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        vu4Var.onStartAnimator(xu4Var, i, i2);
    }

    public void onStateChanged(@NonNull xu4 xu4Var, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (vu4Var instanceof uu4)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (vu4Var instanceof tu4)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        vu4 vu4Var2 = this.mWrappedInternal;
        if (vu4Var2 != null) {
            vu4Var2.onStateChanged(xu4Var, refreshState, refreshState2);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z) {
        vu4 vu4Var = this.mWrappedInternal;
        return (vu4Var instanceof tu4) && ((tu4) vu4Var).setNoMoreData(z);
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        vu4 vu4Var = this.mWrappedInternal;
        if (vu4Var == null || vu4Var == this) {
            return;
        }
        vu4Var.setPrimaryColors(iArr);
    }

    public InternalAbstract(@NonNull View view, @Nullable vu4 vu4Var) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = vu4Var;
        if ((this instanceof RefreshFooterWrapper) && (vu4Var instanceof uu4) && vu4Var.getSpinnerStyle() == fh5.h) {
            vu4Var.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof RefreshHeaderWrapper) {
            vu4 vu4Var2 = this.mWrappedInternal;
            if ((vu4Var2 instanceof tu4) && vu4Var2.getSpinnerStyle() == fh5.h) {
                vu4Var.getView().setScaleY(-1.0f);
            }
        }
    }

    public InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
