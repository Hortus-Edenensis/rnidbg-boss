package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R$attr;
import com.afollestad.materialdialogs.R$dimen;
import com.afollestad.materialdialogs.R$id;
import com.afollestad.materialdialogs.R$styleable;
import defpackage.ed1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MDRootLayout extends ViewGroup {
    private static final int INDEX_NEGATIVE = 1;
    private static final int INDEX_NEUTRAL = 0;
    private static final int INDEX_POSITIVE = 2;
    private ViewTreeObserver.OnScrollChangedListener mBottomOnScrollChangedListener;
    private int mButtonBarHeight;
    private GravityEnum mButtonGravity;
    private int mButtonHorizontalEdgeMargin;
    private int mButtonPaddingFull;
    private MDButton[] mButtons;
    private View mContent;
    private Paint mDividerPaint;
    private int mDividerWidth;
    private boolean mDrawBottomDivider;
    private boolean mDrawButtonLine;
    private boolean mDrawTopDivider;
    private boolean mForceStack;
    private boolean mIsStacked;
    private int mNoTitlePaddingFull;
    private boolean mReducePaddingNoTitleNoButtons;
    private View mTitleBar;
    private ViewTreeObserver.OnScrollChangedListener mTopOnScrollChangedListener;
    private boolean mUseFullPadding;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2505a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public a(View view, boolean z, boolean z2) {
            this.f2505a = view;
            this.b = z;
            this.c = z2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f2505a.getMeasuredHeight() == 0) {
                return true;
            }
            if (MDRootLayout.canWebViewScroll((WebView) this.f2505a)) {
                MDRootLayout.this.addScrollListener((ViewGroup) this.f2505a, this.b, this.c);
            } else {
                if (this.b) {
                    MDRootLayout.this.mDrawTopDivider = false;
                }
                if (this.c) {
                    MDRootLayout.this.mDrawBottomDivider = false;
                }
            }
            this.f2505a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2506a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public b(ViewGroup viewGroup, boolean z, boolean z2) {
            this.f2506a = viewGroup;
            this.b = z;
            this.c = z2;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            MDButton[] mDButtonArr = MDRootLayout.this.mButtons;
            int length = mDButtonArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < length) {
                    MDButton mDButton = mDButtonArr[i];
                    if (mDButton != null && mDButton.getVisibility() != 8) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            ViewGroup viewGroup = this.f2506a;
            if (viewGroup instanceof WebView) {
                MDRootLayout.this.invalidateDividersForWebView((WebView) viewGroup, this.b, this.c, z);
            } else {
                MDRootLayout.this.invalidateDividersForScrollingView(viewGroup, this.b, this.c, z);
            }
            MDRootLayout.this.invalidate();
        }
    }

    public MDRootLayout(Context context) {
        super(context);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = true;
        this.mDrawButtonLine = false;
        this.mButtons = new MDButton[3];
        this.mForceStack = false;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addScrollListener(ViewGroup viewGroup, boolean z, boolean z2) {
        if ((z2 || this.mTopOnScrollChangedListener != null) && !(z2 && this.mBottomOnScrollChangedListener == null)) {
            return;
        }
        b bVar = new b(viewGroup, z, z2);
        if (z2) {
            this.mBottomOnScrollChangedListener = bVar;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mBottomOnScrollChangedListener);
        } else {
            this.mTopOnScrollChangedListener = bVar;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mTopOnScrollChangedListener);
        }
        bVar.onScrollChanged();
    }

    private static boolean canAdapterViewScroll(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        return !(adapterView.getFirstVisiblePosition() == 0) || !(adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom();
    }

    public static boolean canRecyclerViewScroll(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new MaterialDialog.NotImplementedException("Material Dialogs currently only supports LinearLayoutManager. Please report any new layout managers.");
        }
        int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition == -1) {
            return false;
        }
        return !(iFindLastVisibleItemPosition == itemCount - 1) || (recyclerView.getChildCount() > 0 && recyclerView.getChildAt(recyclerView.getChildCount() - 1).getBottom() > recyclerView.getHeight() - recyclerView.getPaddingBottom());
    }

    private static boolean canScrollViewScroll(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        return (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canWebViewScroll(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    @Nullable
    private static View getBottomView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    @Nullable
    private static View getTopView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MDRootLayout, i, 0);
        this.mReducePaddingNoTitleNoButtons = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        typedArrayObtainStyledAttributes.recycle();
        this.mNoTitlePaddingFull = resources.getDimensionPixelSize(R$dimen.md_notitle_vertical_padding);
        this.mButtonBarHeight = resources.getDimensionPixelSize(R$dimen.md_button_height);
        this.mDividerPaint = new Paint();
        this.mDividerWidth = resources.getDimensionPixelSize(R$dimen.md_divider_height);
        this.mDividerPaint.setColor(ed1.g(context, R$attr.md_divider_color));
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateDividersForScrollingView(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (z && viewGroup.getChildCount() > 0) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (!z2 || viewGroup.getChildCount() <= 0) {
            return;
        }
        this.mDrawBottomDivider = z3 && (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() < viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateDividersForWebView(WebView webView, boolean z, boolean z2, boolean z3) {
        if (z) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            this.mDrawBottomDivider = z3 && ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) < ((float) webView.getContentHeight()) * webView.getScale();
        }
    }

    private static boolean isVisible(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        if (z && (view instanceof MDButton)) {
            return ((MDButton) view).getText().toString().trim().length() > 0;
        }
        return z;
    }

    private void setUpDividersVisibility(View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (canScrollViewScroll(scrollView)) {
                addScrollListener(scrollView, z, z2);
            } else {
                if (z) {
                    this.mDrawTopDivider = false;
                }
                if (z2) {
                    this.mDrawBottomDivider = true;
                }
            }
            this.mDrawButtonLine = true;
            return;
        }
        if (view instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view;
            if (canAdapterViewScroll(adapterView)) {
                addScrollListener(adapterView, z, z2);
            } else {
                if (z) {
                    this.mDrawTopDivider = false;
                }
                if (z2) {
                    this.mDrawBottomDivider = false;
                }
            }
            this.mDrawButtonLine = false;
            return;
        }
        if (view instanceof WebView) {
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, z, z2));
            return;
        }
        if (view instanceof RecyclerView) {
            boolean zCanRecyclerViewScroll = canRecyclerViewScroll((RecyclerView) view);
            if (z) {
                this.mDrawTopDivider = zCanRecyclerViewScroll;
            }
            if (z2) {
                this.mDrawBottomDivider = zCanRecyclerViewScroll;
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View topView = getTopView(viewGroup);
            setUpDividersVisibility(topView, z, z2);
            View bottomView = getBottomView(viewGroup);
            if (bottomView != topView) {
                setUpDividersVisibility(bottomView, false, true);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.mContent;
        if (view != null) {
            if (this.mDrawTopDivider) {
                canvas.drawRect(0.0f, r0 - this.mDividerWidth, getMeasuredWidth(), view.getTop(), this.mDividerPaint);
            }
            if (this.mDrawBottomDivider) {
                canvas.drawRect(0.0f, this.mContent.getBottom(), getMeasuredWidth(), r0 + this.mDividerWidth, this.mDividerPaint);
            }
        }
        if (isVisible(this.mButtons[1]) && isVisible(this.mButtons[2])) {
            canvas.drawRect(getMeasuredWidth() / 2, this.mButtons[1].getTop(), r0 + this.mDividerWidth, r1 + this.mButtonBarHeight, this.mDividerPaint);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == R$id.titleFrame) {
                this.mTitleBar = childAt;
            } else if (childAt.getId() == R$id.buttonDefaultNeutral) {
                this.mButtons[0] = (MDButton) childAt;
            } else if (childAt.getId() == R$id.buttonDefaultNegative) {
                this.mButtons[1] = (MDButton) childAt;
            } else if (childAt.getId() == R$id.buttonDefaultPositive) {
                this.mButtons[2] = (MDButton) childAt;
            } else {
                this.mContent = childAt;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredWidth;
        int measuredWidth2;
        int measuredWidth3;
        int measuredWidth4;
        int i6;
        int i7;
        int i8;
        int i9;
        if (isVisible(this.mTitleBar)) {
            int measuredHeight = this.mTitleBar.getMeasuredHeight() + i2;
            this.mTitleBar.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (this.mUseFullPadding) {
            i2 += this.mNoTitlePaddingFull;
        }
        if (isVisible(this.mContent)) {
            View view = this.mContent;
            view.layout(i, i2, i3, view.getMeasuredHeight() + i2);
        }
        if (this.mIsStacked) {
            int measuredHeight2 = i4 - this.mButtonPaddingFull;
            for (MDButton mDButton : this.mButtons) {
                if (isVisible(mDButton)) {
                    mDButton.layout(i, measuredHeight2 - mDButton.getMeasuredHeight(), i3, measuredHeight2);
                    measuredHeight2 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.mUseFullPadding) {
                i4 -= this.mButtonPaddingFull;
            }
            int i10 = i4 - this.mButtonBarHeight;
            int i11 = this.mButtonHorizontalEdgeMargin;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                MDButton[] mDButtonArr = this.mButtons;
                if (i12 >= mDButtonArr.length) {
                    break;
                }
                if (isVisible(mDButtonArr[i12])) {
                    i13++;
                }
                i12++;
            }
            int measuredWidth5 = i13 == 1 ? getMeasuredWidth() : i13 == 2 ? getMeasuredWidth() / 2 : getMeasuredWidth() / 3;
            if (isVisible(this.mButtons[2])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    i8 = i + i11;
                    i9 = i8 + measuredWidth5;
                    i5 = -1;
                } else {
                    int i14 = i3 - i11;
                    i8 = i14 - measuredWidth5;
                    i9 = i14;
                    i5 = i8;
                }
                this.mButtons[2].layout(i8, i10, i9, i4);
                i11 += measuredWidth5;
            } else {
                i5 = -1;
            }
            if (isVisible(this.mButtons[1])) {
                GravityEnum gravityEnum = this.mButtonGravity;
                if (gravityEnum == GravityEnum.END) {
                    i6 = i11 + i;
                    i7 = measuredWidth5 + i6;
                    measuredWidth = -1;
                } else if (gravityEnum == GravityEnum.START) {
                    int i15 = i3 - i11;
                    int i16 = i15 - measuredWidth5;
                    measuredWidth = -1;
                    i7 = i15;
                    i6 = i16;
                } else {
                    i6 = this.mButtonHorizontalEdgeMargin + i;
                    i7 = measuredWidth5 + i6;
                    measuredWidth = i7;
                }
                this.mButtons[1].layout(i6, i10, i7, i4);
            } else {
                measuredWidth = -1;
            }
            if (isVisible(this.mButtons[0])) {
                GravityEnum gravityEnum2 = this.mButtonGravity;
                if (gravityEnum2 == GravityEnum.END) {
                    measuredWidth4 = i3 - this.mButtonHorizontalEdgeMargin;
                    measuredWidth3 = measuredWidth4 - this.mButtons[0].getMeasuredWidth();
                } else if (gravityEnum2 == GravityEnum.START) {
                    measuredWidth3 = i + this.mButtonHorizontalEdgeMargin;
                    measuredWidth4 = this.mButtons[0].getMeasuredWidth() + measuredWidth3;
                } else {
                    if (measuredWidth != -1 || i5 == -1) {
                        if (i5 == -1 && measuredWidth != -1) {
                            measuredWidth2 = this.mButtons[0].getMeasuredWidth();
                        } else if (i5 == -1) {
                            measuredWidth = ((i3 - i) / 2) - (this.mButtons[0].getMeasuredWidth() / 2);
                            measuredWidth2 = this.mButtons[0].getMeasuredWidth();
                        }
                        i5 = measuredWidth + measuredWidth2;
                    } else {
                        measuredWidth = i5 - this.mButtons[0].getMeasuredWidth();
                    }
                    measuredWidth3 = measuredWidth;
                    measuredWidth4 = i5;
                }
                this.mButtons[0].layout(measuredWidth3, i10, measuredWidth4, i4);
            }
        }
        setUpDividersVisibility(this.mContent, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int measuredHeight;
        int i3;
        int measuredHeight2;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mUseFullPadding = true;
        int measuredHeight3 = 0;
        if (this.mForceStack) {
            z = true;
            z2 = false;
        } else {
            int measuredWidth = 0;
            z2 = false;
            for (MDButton mDButton : this.mButtons) {
                if (mDButton != null && isVisible(mDButton)) {
                    mDButton.setStacked(false, false);
                    measureChild(mDButton, i, i2);
                    measuredWidth += mDButton.getMeasuredWidth();
                    z2 = true;
                }
            }
            z = measuredWidth > size - (getContext().getResources().getDimensionPixelSize(R$dimen.md_neutral_button_margin) * 2);
        }
        this.mIsStacked = z;
        if (z) {
            measuredHeight = 0;
            for (MDButton mDButton2 : this.mButtons) {
                if (mDButton2 != null && isVisible(mDButton2)) {
                    mDButton2.setStacked(true, false);
                    measureChild(mDButton2, i, i2);
                    measuredHeight += mDButton2.getMeasuredHeight();
                    z2 = true;
                }
            }
        } else {
            measuredHeight = 0;
        }
        if (!z2) {
            i3 = (this.mButtonPaddingFull * 2) + 0;
            measuredHeight2 = size2;
        } else {
            if (this.mIsStacked) {
                measuredHeight2 = size2 - measuredHeight;
                int i5 = this.mButtonPaddingFull;
                i3 = (i5 * 2) + 0;
                i4 = (i5 * 2) + 0;
                if (isVisible(this.mTitleBar)) {
                    i3 += this.mNoTitlePaddingFull;
                } else {
                    this.mTitleBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), 0);
                    measuredHeight2 -= this.mTitleBar.getMeasuredHeight();
                }
                if (isVisible(this.mContent)) {
                    measuredHeight3 = measuredHeight2;
                } else {
                    this.mContent.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight2 - i4, Integer.MIN_VALUE));
                    if (this.mContent.getMeasuredHeight() > measuredHeight2 - i3) {
                        this.mUseFullPadding = false;
                    } else if (!this.mReducePaddingNoTitleNoButtons || isVisible(this.mTitleBar) || z2) {
                        this.mUseFullPadding = true;
                        measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i3);
                    } else {
                        this.mUseFullPadding = false;
                        measuredHeight3 = measuredHeight2 - (this.mContent.getMeasuredHeight() + i4);
                    }
                }
                setMeasuredDimension(size, size2 - measuredHeight3);
            }
            measuredHeight2 = size2 - this.mButtonBarHeight;
            i3 = (this.mButtonPaddingFull * 2) + 0;
        }
        i4 = 0;
        if (isVisible(this.mTitleBar)) {
        }
        if (isVisible(this.mContent)) {
        }
        setMeasuredDimension(size, size2 - measuredHeight3);
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.mButtonGravity = gravityEnum;
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        for (MDButton mDButton : this.mButtons) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    public void setDividerColor(int i) {
        this.mDividerPaint.setColor(i);
        invalidate();
    }

    public void setForceStack(boolean z) {
        this.mForceStack = z;
        invalidate();
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = true;
        this.mDrawButtonLine = false;
        this.mButtons = new MDButton[3];
        this.mForceStack = false;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = true;
        this.mDrawButtonLine = false;
        this.mButtons = new MDButton[3];
        this.mForceStack = false;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, i);
    }

    @TargetApi(21)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDrawTopDivider = false;
        this.mDrawBottomDivider = true;
        this.mDrawButtonLine = false;
        this.mButtons = new MDButton[3];
        this.mForceStack = false;
        this.mIsStacked = false;
        this.mUseFullPadding = true;
        this.mButtonGravity = GravityEnum.START;
        init(context, attributeSet, i);
    }
}
