package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.palmchat.circle.ui.view.CircleTabItemView;
import defpackage.a46;
import defpackage.hc0;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleTabLayout extends LinearLayout implements CircleTabItemView.a {
    private int lastPosition;
    private List<hc0> mItems;
    private b mListener;
    private ViewPager mViewPager;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);
    }

    public CircleTabLayout(Context context) {
        super(context);
        this.lastPosition = 0;
    }

    private void selectedTargetItem(int i) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof CircleTabItemView) {
            ((CircleTabItemView) viewFindViewWithTag).setCurrentSelected(false, false);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof CircleTabItemView) {
            ((CircleTabItemView) viewFindViewWithTag2).setCurrentSelected(true, false);
        }
        this.lastPosition = i;
    }

    public void bindMatchTableItems(List<hc0> list, String str) {
        if (list != null) {
            this.mItems = list;
            removeAllViews();
            int i = 0;
            for (hc0 hc0Var : list) {
                CircleTabItemView circleTabItemView = new CircleTabItemView(getContext());
                circleTabItemView.setTabMatch();
                circleTabItemView.setViewText(hc0Var.f17922a);
                circleTabItemView.setTag(Integer.valueOf(i));
                circleTabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.weight = 1.0f;
                addView(circleTabItemView, layoutParams);
                if (TextUtils.equals(hc0Var.b, str)) {
                    circleTabItemView.setCurrentSelected(true, false);
                }
                i++;
            }
        }
    }

    public void bindTableItems(List<hc0> list, String str) {
        if (list != null) {
            this.mItems = list;
            removeAllViews();
            int i = 0;
            for (hc0 hc0Var : list) {
                CircleTabItemView circleTabItemView = new CircleTabItemView(getContext());
                circleTabItemView.setViewText(hc0Var.f17922a);
                circleTabItemView.setTag(Integer.valueOf(i));
                circleTabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.weight = 1.0f;
                if (i > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 24.0f);
                }
                addView(circleTabItemView, layoutParams);
                if (TextUtils.equals(hc0Var.b, str)) {
                    circleTabItemView.setCurrentSelected(true, false);
                }
                i++;
            }
        }
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    @Override // com.zenmen.palmchat.circle.ui.view.CircleTabItemView.a
    public void onSelect(int i) {
        if (i == this.lastPosition) {
            return;
        }
        selectedTargetItem(i);
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(i);
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    public void setTabListener(b bVar) {
        this.mListener = bVar;
    }

    public void setupWithViewPage(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new a());
    }

    public CircleTabLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastPosition = 0;
    }

    public CircleTabLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastPosition = 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != CircleTabLayout.this.lastPosition) {
                CircleTabLayout.this.onSelect(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
