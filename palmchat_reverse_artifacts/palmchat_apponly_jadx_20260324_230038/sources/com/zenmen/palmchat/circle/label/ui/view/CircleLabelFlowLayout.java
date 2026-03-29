package com.zenmen.palmchat.circle.label.ui.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleLabelFlowLayout<T extends CircleLabelView> extends ViewGroup {
    private static final int CENTER = 0;
    private static final int LEFT = -1;
    private static final int MOVE_SPEED = 200;
    private static final int RIGHT = 1;
    private static final String TAG = "CircleLabelFlowLayout";
    private List<T> chooseViews;
    public a labelChangeListener;
    private List<View> lineViews;
    protected List<List<View>> mAllViews;
    private int mGravity;
    protected List<Integer> mLineHeight;
    protected List<Integer> mLineWidth;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public CircleLabelFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAllViews = new ArrayList();
        this.mLineHeight = new ArrayList();
        this.mLineWidth = new ArrayList();
        this.mGravity = -1;
        this.lineViews = new ArrayList();
        this.chooseViews = new LinkedList();
        initAnim();
    }

    private void initAnim() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(0, 200L);
        layoutTransition.setDuration(1, 200L);
        layoutTransition.setDuration(2, 200L);
        layoutTransition.setDuration(3, 200L);
        layoutTransition.setStartDelay(0, 0L);
        layoutTransition.setStartDelay(2, 0L);
        layoutTransition.setStartDelay(3, 0L);
        layoutTransition.setStartDelay(1, 0L);
        setLayoutTransition(layoutTransition);
    }

    public void addLabelChildView(T t, int i) {
        CircleLabel circleLabel = t.circleLabel;
        if (circleLabel != null && circleLabel.isChoose) {
            this.chooseViews.add(i, t);
        }
        addView(t, i);
        a aVar = this.labelChangeListener;
        if (aVar != null) {
            aVar.a(getChildCount());
        }
    }

    public T findViewByLabelId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof CircleLabelView) {
                T t = (T) childAt;
                if (t.getLabelId().equals(str)) {
                    return t;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public List<CircleLabel> getChooseLabels() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.chooseViews.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().circleLabel);
        }
        return arrayList;
    }

    public List<T> getChooseViews() {
        return this.chooseViews;
    }

    public boolean isExistLabelName(String str) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof CircleLabelView) && ((CircleLabelView) childAt).getLabelName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mAllViews.clear();
        this.mLineHeight.clear();
        this.mLineWidth.clear();
        this.lineViews.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int iMax = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i5 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.mLineHeight.add(Integer.valueOf(iMax));
                    this.mAllViews.add(this.lineViews);
                    this.mLineWidth.add(Integer.valueOf(i5));
                    iMax = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.lineViews = new ArrayList();
                    i5 = 0;
                }
                i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                iMax = Math.max(iMax, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.lineViews.add(childAt);
            }
        }
        this.mLineHeight.add(Integer.valueOf(iMax));
        this.mLineWidth.add(Integer.valueOf(i5));
        this.mAllViews.add(this.lineViews);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.mAllViews.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.lineViews = this.mAllViews.get(i7);
            int iIntValue = this.mLineHeight.get(i7).intValue();
            int iIntValue2 = this.mLineWidth.get(i7).intValue();
            int i8 = this.mGravity;
            if (i8 == -1) {
                paddingLeft = getPaddingLeft();
            } else if (i8 == 0) {
                paddingLeft = ((width - iIntValue2) / 2) + getPaddingLeft();
            } else if (i8 == 1) {
                paddingLeft = (width - (iIntValue2 + getPaddingLeft())) - getPaddingRight();
                Collections.reverse(this.lineViews);
            }
            for (int i9 = 0; i9 < this.lineViews.size(); i9++) {
                View view = this.lineViews.get(i9);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i10 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i11 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingTop += iIntValue;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                if (i4 == childCount - 1) {
                    iMax = Math.max(i5, iMax);
                    i7 += i6;
                }
                i3 = size2;
            } else {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i8 = i5 + measuredWidth;
                if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                    iMax = Math.max(iMax, i5);
                    i7 += i6;
                } else {
                    measuredHeight = Math.max(i6, measuredHeight);
                    measuredWidth = i8;
                }
                if (i4 == childCount - 1) {
                    iMax = Math.max(measuredWidth, iMax);
                    i7 += measuredHeight;
                }
                i6 = measuredHeight;
                i5 = measuredWidth;
            }
            i4++;
            size2 = i3;
        }
        int i9 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + iMax + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i9 : i7 + getPaddingTop() + getPaddingBottom());
    }

    public void removeLabelView(String str) {
        CircleLabelView circleLabelViewFindViewByLabelId = findViewByLabelId(str);
        removeView(circleLabelViewFindViewByLabelId);
        this.chooseViews.remove(circleLabelViewFindViewByLabelId);
        a aVar = this.labelChangeListener;
        if (aVar != null) {
            aVar.a(getChildCount());
        }
    }

    public void setLabelContainChangeListener(a aVar) {
        this.labelChangeListener = aVar;
    }

    public T unCheckLabelView(String str) {
        T t = (T) findViewByLabelId(str);
        this.chooseViews.remove(t);
        return t;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void addLabelChildView(T t) {
        CircleLabel circleLabel = t.circleLabel;
        if (circleLabel != null && circleLabel.isChoose) {
            this.chooseViews.add(t);
        }
        addView(t, -1);
        a aVar = this.labelChangeListener;
        if (aVar != null) {
            aVar.a(getChildCount());
        }
    }

    public CircleLabelFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initAnim();
    }

    public CircleLabelFlowLayout(Context context) {
        this(context, null);
        initAnim();
    }
}
