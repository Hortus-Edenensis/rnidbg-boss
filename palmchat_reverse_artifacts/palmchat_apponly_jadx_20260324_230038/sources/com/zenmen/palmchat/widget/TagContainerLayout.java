package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.customview.widget.ViewDragHelper;
import com.zenmen.palmchat.framework.R$styleable;
import com.zenmen.palmchat.widget.TagView;
import defpackage.me1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TagContainerLayout extends ViewGroup {
    private static final float DEFAULT_INTERVAL = 5.0f;
    private static final int TAG_MIN_LENGTH = 3;
    private boolean isTagViewClickable;
    private boolean isTagViewSelectable;
    private int mBackgroundColor;
    private int mBorderColor;
    private float mBorderRadius;
    private float mBorderWidth;
    private int mChildHeight;
    private List<View> mChildViews;
    private List<int[]> mColorArrayList;
    private float mCrossAreaPadding;
    private float mCrossAreaWidth;
    private int mCrossColor;
    private float mCrossLineWidth;
    private int mDefaultImageDrawableID;
    private boolean mDragEnable;
    private boolean mEnableCross;
    private int mGravity;
    private int mHorizontalInterval;
    private int mMaxLines;
    private TagView.c mOnTagClickListener;
    private Paint mPaint;
    private RectF mRectF;
    private int mRippleAlpha;
    private int mRippleColor;
    private int mRippleDuration;
    private int mSelectedTagBackgroundColor;
    private float mSensitivity;
    private int mTagBackgroundColor;
    private int mTagBackgroundResource;
    private float mTagBdDistance;
    private int mTagBorderColor;
    private float mTagBorderRadius;
    private float mTagBorderWidth;
    private int mTagHorizontalPadding;
    private int mTagMaxLength;
    private boolean mTagSupportLettersRTL;
    private int mTagTextColor;
    private int mTagTextDirection;
    private float mTagTextSize;
    private Typeface mTagTypeface;
    private int mTagVerticalPadding;
    private int mTagViewState;
    private List<String> mTags;
    private int mVerticalInterval;
    private ViewDragHelper mViewDragHelper;
    private int[] mViewPos;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewDragHelper.Callback {
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int paddingLeft = TagContainerLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), (TagContainerLayout.this.getWidth() - view.getWidth()) - TagContainerLayout.this.getPaddingRight());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int paddingTop = TagContainerLayout.this.getPaddingTop();
            return Math.min(Math.max(i, paddingTop), (TagContainerLayout.this.getHeight() - view.getHeight()) - TagContainerLayout.this.getPaddingBottom());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return TagContainerLayout.this.getMeasuredWidth() - view.getMeasuredWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return TagContainerLayout.this.getMeasuredHeight() - view.getMeasuredHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            TagContainerLayout.this.mTagViewState = i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            super.onViewReleased(view, f, f2);
            TagContainerLayout.this.requestDisallowInterceptTouchEvent(false);
            int[] iArrOnGetNewPosition = TagContainerLayout.this.onGetNewPosition(view);
            TagContainerLayout.this.onChangeView(view, TagContainerLayout.this.onGetCoordinateReferPos(iArrOnGetNewPosition[0], iArrOnGetNewPosition[1]), ((Integer) view.getTag()).intValue());
            TagContainerLayout.this.mViewDragHelper.settleCapturedViewAt(iArrOnGetNewPosition[0], iArrOnGetNewPosition[1]);
            TagContainerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            TagContainerLayout.this.requestDisallowInterceptTouchEvent(true);
            return TagContainerLayout.this.mDragEnable;
        }

        public a() {
        }
    }

    public TagContainerLayout(Context context) {
        this(context, null);
    }

    private int ceilTagBorderWidth() {
        return (int) Math.ceil(this.mTagBorderWidth);
    }

    private int getChildLines(int i) {
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            View childAt = getChildAt(i4);
            int measuredWidth2 = childAt.getMeasuredWidth() + this.mHorizontalInterval;
            int measuredHeight = childAt.getMeasuredHeight();
            if (i4 != 0) {
                measuredHeight = Math.min(this.mChildHeight, measuredHeight);
            }
            this.mChildHeight = measuredHeight;
            i3 += measuredWidth2;
            if (i3 - this.mHorizontalInterval > measuredWidth) {
                i2++;
                i3 = measuredWidth2;
            }
        }
        int i5 = this.mMaxLines;
        return i5 <= 0 ? i2 : i5;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AndroidTagView, i, 0);
        this.mVerticalInterval = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_vertical_interval, me1.a(context, 5.0f));
        this.mHorizontalInterval = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_horizontal_interval, me1.a(context, 5.0f));
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_container_border_width, me1.a(context, this.mBorderWidth));
        this.mBorderRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_container_border_radius, me1.a(context, this.mBorderRadius));
        this.mTagBdDistance = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_bd_distance, me1.a(context, this.mTagBdDistance));
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_container_border_color, this.mBorderColor);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_container_background_color, this.mBackgroundColor);
        this.mDragEnable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AndroidTagView_container_enable_drag, false);
        this.mSensitivity = typedArrayObtainStyledAttributes.getFloat(R$styleable.AndroidTagView_container_drag_sensitivity, this.mSensitivity);
        this.mGravity = typedArrayObtainStyledAttributes.getInt(R$styleable.AndroidTagView_container_gravity, this.mGravity);
        this.mMaxLines = typedArrayObtainStyledAttributes.getInt(R$styleable.AndroidTagView_container_max_lines, this.mMaxLines);
        this.mTagMaxLength = typedArrayObtainStyledAttributes.getInt(R$styleable.AndroidTagView_tag_max_length, this.mTagMaxLength);
        this.mTagBorderWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_border_width, me1.a(context, this.mTagBorderWidth));
        this.mTagBorderRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_corner_radius, me1.a(context, this.mTagBorderRadius));
        this.mTagHorizontalPadding = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_horizontal_padding, me1.b(context, this.mTagHorizontalPadding));
        this.mTagVerticalPadding = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_vertical_padding, me1.b(context, this.mTagVerticalPadding));
        this.mTagTextSize = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_text_size, me1.a(context, this.mTagTextSize));
        this.mTagBorderColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_tag_border_color, this.mTagBorderColor);
        this.mTagBackgroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_tag_background_color, this.mTagBackgroundColor);
        this.mTagTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_tag_text_color, this.mTagTextColor);
        this.mTagTextDirection = typedArrayObtainStyledAttributes.getInt(R$styleable.AndroidTagView_tag_text_direction, this.mTagTextDirection);
        this.isTagViewClickable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AndroidTagView_tag_clickable, false);
        this.isTagViewSelectable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AndroidTagView_tag_selectable, false);
        this.mRippleColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_tag_ripple_color, Color.parseColor("#EEEEEE"));
        this.mRippleAlpha = typedArrayObtainStyledAttributes.getInteger(R$styleable.AndroidTagView_tag_ripple_alpha, this.mRippleAlpha);
        this.mRippleDuration = typedArrayObtainStyledAttributes.getInteger(R$styleable.AndroidTagView_tag_ripple_duration, this.mRippleDuration);
        this.mEnableCross = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AndroidTagView_tag_enable_cross, this.mEnableCross);
        this.mCrossAreaWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_cross_width, me1.a(context, this.mCrossAreaWidth));
        this.mCrossAreaPadding = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_cross_area_padding, me1.a(context, this.mCrossAreaPadding));
        this.mCrossColor = typedArrayObtainStyledAttributes.getColor(R$styleable.AndroidTagView_tag_cross_color, this.mCrossColor);
        this.mCrossLineWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.AndroidTagView_tag_cross_line_width, me1.a(context, this.mCrossLineWidth));
        this.mTagSupportLettersRTL = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AndroidTagView_tag_support_letters_rlt, this.mTagSupportLettersRTL);
        this.mTagBackgroundResource = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AndroidTagView_tag_background, this.mTagBackgroundResource);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mChildViews = new ArrayList();
        this.mViewDragHelper = ViewDragHelper.create(this, this.mSensitivity, new a());
        setWillNotDraw(false);
        setTagMaxLength(this.mTagMaxLength);
        setTagHorizontalPadding(this.mTagHorizontalPadding);
        setTagVerticalPadding(this.mTagVerticalPadding);
        if (isInEditMode()) {
            addTag("sample tag");
        }
    }

    private void initTagView(TagView tagView, int i) {
        int[] iArrOnUpdateColorFactory;
        List<int[]> list = this.mColorArrayList;
        if (list == null || list.size() <= 0) {
            iArrOnUpdateColorFactory = onUpdateColorFactory();
        } else {
            if (this.mColorArrayList.size() != this.mTags.size() || this.mColorArrayList.get(i).length < 4) {
                throw new RuntimeException("Illegal color list!");
            }
            iArrOnUpdateColorFactory = this.mColorArrayList.get(i);
        }
        tagView.setTagBackgroundColor(iArrOnUpdateColorFactory[0]);
        tagView.setTagBorderColor(iArrOnUpdateColorFactory[1]);
        tagView.setTagTextColor(iArrOnUpdateColorFactory[2]);
        tagView.setTagSelectedBackgroundColor(iArrOnUpdateColorFactory[3]);
        tagView.setTagMaxLength(this.mTagMaxLength);
        tagView.setTextDirection(this.mTagTextDirection);
        tagView.setTypeface(this.mTagTypeface);
        tagView.setBorderWidth(this.mTagBorderWidth);
        tagView.setBorderRadius(this.mTagBorderRadius);
        tagView.setTextSize(this.mTagTextSize);
        tagView.setHorizontalPadding(this.mTagHorizontalPadding);
        tagView.setVerticalPadding(this.mTagVerticalPadding);
        tagView.setIsViewClickable(this.isTagViewClickable);
        tagView.setIsViewSelectable(this.isTagViewSelectable);
        tagView.setBdDistance(this.mTagBdDistance);
        tagView.setOnTagClickListener(null);
        tagView.setRippleAlpha(this.mRippleAlpha);
        tagView.setRippleColor(this.mRippleColor);
        tagView.setRippleDuration(this.mRippleDuration);
        tagView.setEnableCross(this.mEnableCross);
        tagView.setCrossAreaWidth(this.mCrossAreaWidth);
        tagView.setCrossAreaPadding(this.mCrossAreaPadding);
        tagView.setCrossColor(this.mCrossColor);
        tagView.setCrossLineWidth(this.mCrossLineWidth);
        tagView.setTagSupportLettersRTL(this.mTagSupportLettersRTL);
        tagView.setBackgroundResource(this.mTagBackgroundResource);
    }

    private void invalidateTags() {
        Iterator<View> it = this.mChildViews.iterator();
        while (it.hasNext()) {
            ((TagView) it.next()).setOnTagClickListener(null);
        }
    }

    private void onAddTag(String str, int i) {
        if (i < 0 || i > this.mChildViews.size()) {
            throw new RuntimeException("Illegal position!");
        }
        TagView tagView = this.mDefaultImageDrawableID != -1 ? new TagView(getContext(), str, this.mDefaultImageDrawableID) : new TagView(getContext(), str);
        initTagView(tagView, i);
        this.mChildViews.add(i, tagView);
        if (i < this.mChildViews.size()) {
            for (int i2 = i; i2 < this.mChildViews.size(); i2++) {
                this.mChildViews.get(i2).setTag(Integer.valueOf(i2));
            }
        } else {
            tagView.setTag(Integer.valueOf(i));
        }
        addView(tagView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangeView(View view, int i, int i2) {
        this.mChildViews.remove(i2);
        this.mChildViews.add(i, view);
        for (View view2 : this.mChildViews) {
            view2.setTag(Integer.valueOf(this.mChildViews.indexOf(view2)));
        }
        removeViewAt(i2);
        addView(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onGetCoordinateReferPos(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.mViewPos;
            if (i3 >= iArr.length / 2) {
                return i4;
            }
            int i5 = i3 * 2;
            if (i == iArr[i5] && i2 == iArr[i5 + 1]) {
                i4 = i3;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] onGetNewPosition(View view) {
        int left = view.getLeft();
        int top = view.getTop();
        int i = this.mViewPos[((Integer) view.getTag()).intValue() * 2];
        int i2 = this.mViewPos[(((Integer) view.getTag()).intValue() * 2) + 1];
        int iAbs = Math.abs(top - i2);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.mViewPos;
            if (i4 >= iArr.length / 2) {
                break;
            }
            int i5 = (i4 * 2) + 1;
            if (Math.abs(top - iArr[i5]) < iAbs) {
                i2 = this.mViewPos[i5];
                iAbs = Math.abs(top - i2);
            }
            i4++;
        }
        int i6 = 0;
        int iAbs2 = 0;
        while (true) {
            int[] iArr2 = this.mViewPos;
            if (i3 >= iArr2.length / 2) {
                return new int[]{i, i2};
            }
            int i7 = i3 * 2;
            if (iArr2[i7 + 1] == i2) {
                if (i6 == 0) {
                    i = iArr2[i7];
                    iAbs2 = Math.abs(left - i);
                } else if (Math.abs(left - iArr2[i7]) < iAbs2) {
                    i = this.mViewPos[i7];
                    iAbs2 = Math.abs(left - i);
                }
                i6++;
            }
            i3++;
        }
    }

    private void onRemoveConsecutiveTags(List<Integer> list) {
        int iIntValue = ((Integer) Collections.min(list)).intValue();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (iIntValue2 < 0 || iIntValue2 >= this.mChildViews.size()) {
                throw new RuntimeException("Illegal position!");
            }
            this.mChildViews.remove(iIntValue);
            removeViewAt(iIntValue);
        }
        while (iIntValue < this.mChildViews.size()) {
            this.mChildViews.get(iIntValue).setTag(Integer.valueOf(iIntValue));
            iIntValue++;
        }
    }

    private void onRemoveTag(int i) {
        if (i < 0 || i >= this.mChildViews.size()) {
            throw new RuntimeException("Illegal position!");
        }
        this.mChildViews.remove(i);
        removeViewAt(i);
        while (i < this.mChildViews.size()) {
            this.mChildViews.get(i).setTag(Integer.valueOf(i));
            i++;
        }
    }

    private void onSetTag() {
        if (this.mTags == null) {
            throw new RuntimeException("NullPointer exception!");
        }
        removeAllTags();
        if (this.mTags.size() == 0) {
            return;
        }
        for (int i = 0; i < this.mTags.size(); i++) {
            onAddTag(this.mTags.get(i), this.mChildViews.size());
        }
        postInvalidate();
    }

    private int[] onUpdateColorFactory() {
        return new int[]{this.mTagBackgroundColor, this.mTagBorderColor, this.mTagTextColor, this.mSelectedTagBackgroundColor};
    }

    public void addTag(String str) {
        addTag(str, this.mChildViews.size());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mViewDragHelper.continueSettling(true)) {
            requestLayout();
        }
    }

    public void deselectTagView(int i) {
        if (this.isTagViewSelectable) {
            ((TagView) this.mChildViews.get(i)).deselectView();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderRadius() {
        return this.mBorderRadius;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCrossAreaPadding() {
        return this.mCrossAreaPadding;
    }

    public float getCrossAreaWidth() {
        return this.mCrossAreaWidth;
    }

    public int getCrossColor() {
        return this.mCrossColor;
    }

    public float getCrossLineWidth() {
        return this.mCrossLineWidth;
    }

    public int getDefaultImageDrawableID() {
        return this.mDefaultImageDrawableID;
    }

    public boolean getDragEnable() {
        return this.mDragEnable;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getHorizontalInterval() {
        return this.mHorizontalInterval;
    }

    public boolean getIsTagViewClickable() {
        return this.isTagViewClickable;
    }

    public boolean getIsTagViewSelectable() {
        return this.isTagViewSelectable;
    }

    public int getMaxLines() {
        return this.mMaxLines;
    }

    public int getRippleAlpha() {
        return this.mRippleAlpha;
    }

    public int getRippleColor() {
        return this.mRippleColor;
    }

    public int getRippleDuration() {
        return this.mRippleDuration;
    }

    public List<Integer> getSelectedTagViewPositions() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mChildViews.size(); i++) {
            if (((TagView) this.mChildViews.get(i)).getIsViewSelected()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public List<String> getSelectedTagViewText() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mChildViews.size(); i++) {
            TagView tagView = (TagView) this.mChildViews.get(i);
            if (tagView.getIsViewSelected()) {
                arrayList.add(tagView.getText());
            }
        }
        return arrayList;
    }

    public float getSensitivity() {
        return this.mSensitivity;
    }

    public int getTagBackgroundColor() {
        return this.mTagBackgroundColor;
    }

    public int getTagBackgroundResource() {
        return this.mTagBackgroundResource;
    }

    public float getTagBdDistance() {
        return this.mTagBdDistance;
    }

    public int getTagBorderColor() {
        return this.mTagBorderColor;
    }

    public float getTagBorderRadius() {
        return this.mTagBorderRadius;
    }

    public float getTagBorderWidth() {
        return this.mTagBorderWidth;
    }

    public int getTagHorizontalPadding() {
        return this.mTagHorizontalPadding;
    }

    public int getTagMaxLength() {
        return this.mTagMaxLength;
    }

    public String getTagText(int i) {
        return ((TagView) this.mChildViews.get(i)).getText();
    }

    public int getTagTextColor() {
        return this.mTagTextColor;
    }

    public int getTagTextDirection() {
        return this.mTagTextDirection;
    }

    public float getTagTextSize() {
        return this.mTagTextSize;
    }

    public Typeface getTagTypeface() {
        return this.mTagTypeface;
    }

    public int getTagVerticalPadding() {
        return this.mTagVerticalPadding;
    }

    public TagView getTagView(int i) {
        if (i < 0 || i >= this.mChildViews.size()) {
            throw new RuntimeException("Illegal position!");
        }
        return (TagView) this.mChildViews.get(i);
    }

    public int getTagViewState() {
        return this.mTagViewState;
    }

    public List<String> getTags() {
        ArrayList arrayList = new ArrayList();
        for (View view : this.mChildViews) {
            if (view instanceof TagView) {
                arrayList.add(((TagView) view).getText());
            }
        }
        return arrayList;
    }

    public int getVerticalInterval() {
        return this.mVerticalInterval;
    }

    public boolean isEnableCross() {
        return this.mEnableCross;
    }

    public boolean isTagSupportLettersRTL() {
        return this.mTagSupportLettersRTL;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mBackgroundColor);
        RectF rectF = this.mRectF;
        float f = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPaint.setColor(this.mBorderColor);
        RectF rectF2 = this.mRectF;
        float f2 = this.mBorderRadius;
        canvas.drawRoundRect(rectF2, f2, f2, this.mPaint);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mDragEnable) {
            return this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredWidth2 = getMeasuredWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        this.mViewPos = new int[childCount * 2];
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth3 = childAt.getMeasuredWidth();
                int i7 = this.mGravity;
                if (i7 == 5) {
                    if (measuredWidth2 - measuredWidth3 < getPaddingLeft()) {
                        measuredWidth2 = getMeasuredWidth() - getPaddingRight();
                        paddingTop += this.mChildHeight + this.mVerticalInterval;
                    }
                    int[] iArr = this.mViewPos;
                    int i8 = i6 * 2;
                    iArr[i8] = measuredWidth2 - measuredWidth3;
                    iArr[i8 + 1] = paddingTop;
                    measuredWidth2 -= measuredWidth3 + this.mHorizontalInterval;
                } else if (i7 == 17) {
                    if ((paddingLeft + measuredWidth3) - getPaddingLeft() > measuredWidth) {
                        int i9 = i6 - 1;
                        int measuredWidth4 = ((getMeasuredWidth() - this.mViewPos[i9 * 2]) - getChildAt(i9).getMeasuredWidth()) - getPaddingRight();
                        while (i5 < i6) {
                            int[] iArr2 = this.mViewPos;
                            int i10 = i5 * 2;
                            iArr2[i10] = iArr2[i10] + (measuredWidth4 / 2);
                            i5++;
                        }
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.mChildHeight + this.mVerticalInterval;
                        i5 = i6;
                    }
                    int[] iArr3 = this.mViewPos;
                    int i11 = i6 * 2;
                    iArr3[i11] = paddingLeft;
                    iArr3[i11 + 1] = paddingTop;
                    paddingLeft += measuredWidth3 + this.mHorizontalInterval;
                    if (i6 == childCount - 1) {
                        int measuredWidth5 = ((getMeasuredWidth() - this.mViewPos[i11]) - childAt.getMeasuredWidth()) - getPaddingRight();
                        for (int i12 = i5; i12 < childCount; i12++) {
                            int[] iArr4 = this.mViewPos;
                            int i13 = i12 * 2;
                            iArr4[i13] = iArr4[i13] + (measuredWidth5 / 2);
                        }
                    }
                } else {
                    if ((paddingLeft + measuredWidth3) - getPaddingLeft() > measuredWidth) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.mChildHeight + this.mVerticalInterval;
                    }
                    int[] iArr5 = this.mViewPos;
                    int i14 = i6 * 2;
                    iArr5[i14] = paddingLeft;
                    iArr5[i14 + 1] = paddingTop;
                    paddingLeft += measuredWidth3 + this.mHorizontalInterval;
                }
            }
        }
        for (int i15 = 0; i15 < this.mViewPos.length / 2; i15++) {
            View childAt2 = getChildAt(i15);
            int[] iArr6 = this.mViewPos;
            int i16 = i15 * 2;
            int i17 = iArr6[i16];
            int i18 = i16 + 1;
            childAt2.layout(i17, iArr6[i18], childAt2.getMeasuredWidth() + i17, this.mViewPos[i18] + this.mChildHeight);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int childLines = childCount == 0 ? 0 : getChildLines(childCount);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (childCount == 0) {
            setMeasuredDimension(0, 0);
        } else if (mode != Integer.MIN_VALUE && mode != 0) {
            setMeasuredDimension(size, size2);
        } else {
            int i3 = this.mVerticalInterval;
            setMeasuredDimension(size, (((this.mChildHeight + i3) * childLines) - i3) + getPaddingTop() + getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mViewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void removeAllTags() {
        this.mChildViews.clear();
        removeAllViews();
        postInvalidate();
    }

    public void removeConsecutiveTags(List<Integer> list) {
        onRemoveConsecutiveTags(list);
        postInvalidate();
    }

    public void removeTag(int i) {
        onRemoveTag(i);
        postInvalidate();
    }

    public void selectTagView(int i) {
        if (this.isTagViewSelectable) {
            ((TagView) this.mChildViews.get(i)).selectView();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public void setBorderRadius(float f) {
        this.mBorderRadius = f;
    }

    public void setBorderWidth(float f) {
        this.mBorderWidth = f;
    }

    public void setCrossAreaPadding(float f) {
        this.mCrossAreaPadding = f;
    }

    public void setCrossAreaWidth(float f) {
        this.mCrossAreaWidth = f;
    }

    public void setCrossColor(int i) {
        this.mCrossColor = i;
    }

    public void setCrossLineWidth(float f) {
        this.mCrossLineWidth = f;
    }

    public void setDefaultImageDrawableID(int i) {
        this.mDefaultImageDrawableID = i;
    }

    public void setDragEnable(boolean z) {
        this.mDragEnable = z;
    }

    public void setEnableCross(boolean z) {
        this.mEnableCross = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setHorizontalInterval(float f) {
        this.mHorizontalInterval = me1.a(getContext(), f);
        postInvalidate();
    }

    public void setIsTagViewClickable(boolean z) {
        this.isTagViewClickable = z;
    }

    public void setIsTagViewSelectable(boolean z) {
        this.isTagViewSelectable = z;
    }

    public void setMaxLines(int i) {
        this.mMaxLines = i;
        postInvalidate();
    }

    public void setOnTagClickListener(TagView.c cVar) {
        invalidateTags();
    }

    public void setRippleAlpha(int i) {
        this.mRippleAlpha = i;
    }

    public void setRippleColor(int i) {
        this.mRippleColor = i;
    }

    public void setRippleDuration(int i) {
        this.mRippleDuration = i;
    }

    public void setSensitivity(float f) {
        this.mSensitivity = f;
    }

    public void setTagBackgroundColor(int i) {
        this.mTagBackgroundColor = i;
    }

    public void setTagBackgroundResource(@DrawableRes int i) {
        this.mTagBackgroundResource = i;
    }

    public void setTagBdDistance(float f) {
        this.mTagBdDistance = me1.a(getContext(), f);
    }

    public void setTagBorderColor(int i) {
        this.mTagBorderColor = i;
    }

    public void setTagBorderRadius(float f) {
        this.mTagBorderRadius = f;
    }

    public void setTagBorderWidth(float f) {
        this.mTagBorderWidth = f;
    }

    public void setTagHorizontalPadding(int i) {
        int iCeilTagBorderWidth = ceilTagBorderWidth();
        if (i < iCeilTagBorderWidth) {
            i = iCeilTagBorderWidth;
        }
        this.mTagHorizontalPadding = i;
    }

    public void setTagMaxLength(int i) {
        if (i < 3) {
            i = 3;
        }
        this.mTagMaxLength = i;
    }

    public void setTagSupportLettersRTL(boolean z) {
        this.mTagSupportLettersRTL = z;
    }

    public void setTagTextColor(int i) {
        this.mTagTextColor = i;
    }

    public void setTagTextDirection(int i) {
        this.mTagTextDirection = i;
    }

    public void setTagTextSize(float f) {
        this.mTagTextSize = f;
    }

    public void setTagTypeface(Typeface typeface) {
        this.mTagTypeface = typeface;
    }

    public void setTagVerticalPadding(int i) {
        int iCeilTagBorderWidth = ceilTagBorderWidth();
        if (i < iCeilTagBorderWidth) {
            i = iCeilTagBorderWidth;
        }
        this.mTagVerticalPadding = i;
    }

    public void setTags(List<String> list) {
        this.mTags = list;
        onSetTag();
    }

    public void setVerticalInterval(float f) {
        this.mVerticalInterval = me1.a(getContext(), f);
        postInvalidate();
    }

    public int size() {
        return this.mChildViews.size();
    }

    public void toggleSelectTagView(int i) {
        if (this.isTagViewSelectable) {
            TagView tagView = (TagView) this.mChildViews.get(i);
            if (tagView.getIsViewSelected()) {
                tagView.deselectView();
            } else {
                tagView.selectView();
            }
        }
    }

    public TagContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addTag(String str, int i) {
        onAddTag(str, i);
        postInvalidate();
    }

    public TagContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 0.5f;
        this.mBorderRadius = 10.0f;
        this.mSensitivity = 1.0f;
        this.mBorderColor = Color.parseColor("#22FF0000");
        this.mBackgroundColor = Color.parseColor("#11FF0000");
        this.mGravity = 3;
        this.mMaxLines = 0;
        this.mTagMaxLength = 23;
        this.mTagBorderWidth = 0.5f;
        this.mTagBorderRadius = 15.0f;
        this.mTagTextSize = 14.0f;
        this.mTagTextDirection = 3;
        this.mTagHorizontalPadding = 10;
        this.mTagVerticalPadding = 8;
        this.mTagBorderColor = Color.parseColor("#88F44336");
        this.mTagBackgroundColor = Color.parseColor("#33F44336");
        this.mSelectedTagBackgroundColor = Color.parseColor("#33FF7669");
        this.mTagTextColor = Color.parseColor("#FF666666");
        this.mTagTypeface = Typeface.DEFAULT;
        this.mDefaultImageDrawableID = -1;
        this.mTagViewState = 0;
        this.mTagBdDistance = 2.75f;
        this.mTagSupportLettersRTL = false;
        this.mRippleDuration = 1000;
        this.mRippleAlpha = 128;
        this.mEnableCross = false;
        this.mCrossAreaWidth = 0.0f;
        this.mCrossAreaPadding = 10.0f;
        this.mCrossColor = -16777216;
        this.mCrossLineWidth = 1.0f;
        init(context, attributeSet, i);
    }

    public void setTags(List<String> list, List<int[]> list2) {
        this.mTags = list;
        this.mColorArrayList = list2;
        onSetTag();
    }

    public void setTags(String... strArr) {
        this.mTags = Arrays.asList(strArr);
        onSetTag();
    }
}
