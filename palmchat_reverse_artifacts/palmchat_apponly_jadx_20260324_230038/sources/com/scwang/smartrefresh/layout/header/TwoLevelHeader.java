package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import defpackage.fh5;
import defpackage.uu4;
import defpackage.v74;
import defpackage.vu4;
import defpackage.wu4;
import defpackage.xu4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TwoLevelHeader extends InternalAbstract implements uu4 {
    protected boolean mEnablePullToCloseTwoLevel;
    protected boolean mEnableRefresh;
    protected boolean mEnableTwoLevel;
    protected int mFloorDuration;
    protected float mFloorRate;
    protected int mHeaderHeight;
    protected float mMaxRate;
    protected float mPercent;
    protected vu4 mRefreshHeader;
    protected wu4 mRefreshKernel;
    protected float mRefreshRate;
    protected int mSpinner;
    protected v74 mTwoLevelListener;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10575a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f10575a = iArr;
            try {
                iArr[RefreshState.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10575a[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10575a[RefreshState.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10575a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        vu4 vu4Var = this.mRefreshHeader;
        return (vu4Var != null && vu4Var.equals(obj)) || super.equals(obj);
    }

    public TwoLevelHeader finishTwoLevel() {
        wu4 wu4Var = this.mRefreshKernel;
        if (wu4Var != null) {
            wu4Var.f();
        }
        return this;
    }

    public void moveSpinner(int i) {
        vu4 vu4Var = this.mRefreshHeader;
        if (this.mSpinner == i || vu4Var == null) {
            return;
        }
        this.mSpinner = i;
        fh5 spinnerStyle = vu4Var.getSpinnerStyle();
        if (spinnerStyle == fh5.d) {
            vu4Var.getView().setTranslationY(i);
        } else if (spinnerStyle.c) {
            View view = vu4Var.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSpinnerStyle = fh5.h;
        if (this.mRefreshHeader == null) {
            setRefreshHeader(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mSpinnerStyle = fh5.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof uu4) {
                this.mRefreshHeader = (uu4) childAt;
                this.mWrappedInternal = (vu4) childAt;
                bringChildToFront(childAt);
                return;
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onInitialized(@NonNull wu4 wu4Var, int i, int i2) {
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var == null) {
            return;
        }
        if (((i2 + i) * 1.0f) / i != this.mMaxRate && this.mHeaderHeight == 0) {
            this.mHeaderHeight = i;
            this.mRefreshHeader = null;
            wu4Var.d().setHeaderMaxDragRate(this.mMaxRate);
            this.mRefreshHeader = vu4Var;
        }
        if (this.mRefreshKernel == null && vu4Var.getSpinnerStyle() == fh5.d && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) vu4Var.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i;
            vu4Var.getView().setLayoutParams(marginLayoutParams);
        }
        this.mHeaderHeight = i;
        this.mRefreshKernel = wu4Var;
        wu4Var.g(this.mFloorDuration);
        wu4Var.b(this, !this.mEnablePullToCloseTwoLevel);
        vu4Var.onInitialized(wu4Var, i, i2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var == null) {
            super.onMeasure(i, i2);
        } else {
            if (View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
                super.onMeasure(i, i2);
                return;
            }
            vu4Var.getView().measure(i, i2);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), vu4Var.getView().getMeasuredHeight());
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.vu4
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        moveSpinner(i);
        vu4 vu4Var = this.mRefreshHeader;
        wu4 wu4Var = this.mRefreshKernel;
        if (vu4Var != null) {
            vu4Var.onMoving(z, f, i, i2, i3);
        }
        if (z) {
            float f2 = this.mPercent;
            float f3 = this.mFloorRate;
            if (f2 < f3 && f >= f3 && this.mEnableTwoLevel) {
                wu4Var.e(RefreshState.ReleaseToTwoLevel);
            } else if (f2 >= f3 && f < this.mRefreshRate) {
                wu4Var.e(RefreshState.PullDownToRefresh);
            } else if (f2 >= f3 && f < f3 && this.mEnableRefresh) {
                wu4Var.e(RefreshState.ReleaseToRefresh);
            } else if (!this.mEnableRefresh && wu4Var.d().getState() != RefreshState.ReleaseToTwoLevel) {
                wu4Var.e(RefreshState.PullDownToRefresh);
            }
            this.mPercent = f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, defpackage.l74
    public void onStateChanged(@NonNull xu4 xu4Var, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        vu4 vu4Var = this.mRefreshHeader;
        if (vu4Var != null) {
            if (refreshState2 == RefreshState.ReleaseToRefresh && !this.mEnableRefresh) {
                refreshState2 = RefreshState.PullDownToRefresh;
            }
            vu4Var.onStateChanged(xu4Var, refreshState, refreshState2);
            int i = a.f10575a[refreshState2.ordinal()];
            if (i == 1) {
                if (vu4Var.getView() != this) {
                    vu4Var.getView().animate().alpha(0.0f).setDuration(this.mFloorDuration / 2);
                }
                wu4 wu4Var = this.mRefreshKernel;
                if (wu4Var != null) {
                    wu4Var.h(true);
                    return;
                }
                return;
            }
            if (i == 3) {
                if (vu4Var.getView() != this) {
                    vu4Var.getView().animate().alpha(1.0f).setDuration(this.mFloorDuration / 2);
                }
            } else if (i == 4 && vu4Var.getView().getAlpha() == 0.0f && vu4Var.getView() != this) {
                vu4Var.getView().setAlpha(1.0f);
            }
        }
    }

    public TwoLevelHeader openTwoLevel(boolean z) {
        wu4 wu4Var = this.mRefreshKernel;
        if (wu4Var != null) {
            wu4Var.h(true);
        }
        return this;
    }

    public TwoLevelHeader setEnablePullToCloseTwoLevel(boolean z) {
        wu4 wu4Var = this.mRefreshKernel;
        this.mEnablePullToCloseTwoLevel = z;
        if (wu4Var != null) {
            wu4Var.b(this, !z);
        }
        return this;
    }

    public TwoLevelHeader setEnableTwoLevel(boolean z) {
        this.mEnableTwoLevel = z;
        return this;
    }

    public TwoLevelHeader setFloorDuration(int i) {
        this.mFloorDuration = i;
        return this;
    }

    public TwoLevelHeader setFloorRate(float f) {
        this.mFloorRate = f;
        return this;
    }

    public TwoLevelHeader setMaxRate(float f) {
        if (this.mMaxRate != f) {
            this.mMaxRate = f;
            wu4 wu4Var = this.mRefreshKernel;
            if (wu4Var != null) {
                this.mHeaderHeight = 0;
                wu4Var.d().setHeaderMaxDragRate(this.mMaxRate);
            }
        }
        return this;
    }

    public TwoLevelHeader setRefreshHeader(uu4 uu4Var) {
        return setRefreshHeader(uu4Var, -1, -2);
    }

    public TwoLevelHeader setRefreshRate(float f) {
        this.mRefreshRate = f;
        return this;
    }

    public TwoLevelHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mPercent = 0.0f;
        this.mMaxRate = 2.5f;
        this.mFloorRate = 1.9f;
        this.mRefreshRate = 1.0f;
        this.mEnableTwoLevel = true;
        this.mEnablePullToCloseTwoLevel = true;
        this.mEnableRefresh = true;
        this.mFloorDuration = 1000;
        this.mSpinnerStyle = fh5.f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TwoLevelHeader);
        this.mMaxRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlMaxRage, this.mMaxRate);
        this.mFloorRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlFloorRage, this.mFloorRate);
        this.mRefreshRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlRefreshRage, this.mRefreshRate);
        this.mMaxRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlMaxRate, this.mMaxRate);
        this.mFloorRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlFloorRate, this.mFloorRate);
        this.mRefreshRate = typedArrayObtainStyledAttributes.getFloat(R$styleable.TwoLevelHeader_srlRefreshRate, this.mRefreshRate);
        this.mFloorDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.TwoLevelHeader_srlFloorDuration, this.mFloorDuration);
        this.mEnableTwoLevel = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwoLevelHeader_srlEnableTwoLevel, this.mEnableTwoLevel);
        this.mEnableRefresh = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwoLevelHeader_srlEnableRefresh, this.mEnableRefresh);
        this.mEnablePullToCloseTwoLevel = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.mEnablePullToCloseTwoLevel);
        typedArrayObtainStyledAttributes.recycle();
    }

    public TwoLevelHeader setRefreshHeader(uu4 uu4Var, int i, int i2) {
        if (uu4Var != null) {
            if (i == 0) {
                i = -1;
            }
            if (i2 == 0) {
                i2 = -2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            ViewGroup.LayoutParams layoutParams2 = uu4Var.getView().getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            vu4 vu4Var = this.mRefreshHeader;
            if (vu4Var != null) {
                removeView(vu4Var.getView());
            }
            if (uu4Var.getSpinnerStyle() == fh5.f) {
                addView(uu4Var.getView(), 0, layoutParams);
            } else {
                addView(uu4Var.getView(), getChildCount(), layoutParams);
            }
            this.mRefreshHeader = uu4Var;
            this.mWrappedInternal = uu4Var;
        }
        return this;
    }

    public TwoLevelHeader setOnTwoLevelListener(v74 v74Var) {
        return this;
    }
}
