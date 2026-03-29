package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleNoticeItem;
import com.zenmen.palmchat.circle.ui.CircleNoteDetailActivity;
import defpackage.a46;
import defpackage.j70;
import defpackage.l50;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNoticeBanner extends FrameLayout implements ViewPager.OnPageChangeListener {
    private ViewGroup mLlCircleNoticeIndicatorWrapper;
    private ViewPager mViewPagerCircleNotice;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<CircleNoticeItem> f13296a;
        public final String b;

        public a(ArrayList<CircleNoticeItem> arrayList, String str) {
            this.f13296a = arrayList;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(CircleNoticeItem circleNoticeItem, View view) {
            h(circleNoticeItem);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (CollectionUtils.isEmpty(this.f13296a)) {
                return 0;
            }
            int size = this.f13296a.size();
            if (size > 3) {
                return 3;
            }
            return size;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }

        public final void h(CircleNoticeItem circleNoticeItem) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(CircleNoticeBanner.this.getContext(), CircleNoteDetailActivity.class);
            intent.putExtra(j70.f, circleNoticeItem);
            intent.putExtra(j70.f18338a, this.b);
            CircleNoticeBanner.this.getContext().startActivity(intent);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            TextView textView = new TextView(CircleNoticeBanner.this.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            int iB = a46.b(CircleNoticeBanner.this.getContext(), 26.0f);
            int iB2 = a46.b(CircleNoticeBanner.this.getContext(), 24.0f);
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(CircleNoticeBanner.this.getContext().getResources().getColor(R.color.color_222222));
            textView.setPadding(iB, iB2, iB, 0);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            final CircleNoticeItem circleNoticeItem = this.f13296a.get(i);
            textView.setText(circleNoticeItem.getContent());
            textView.setOnClickListener(new View.OnClickListener() { // from class: bb0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1678a.g(circleNoticeItem, view);
                }
            });
            viewGroup.addView(textView);
            return textView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CircleNoticeBanner(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCircleNotices$0(ArrayList arrayList, String str, View view) {
        int currentItem = this.mViewPagerCircleNotice.getCurrentItem();
        CircleNoticeItem circleNoticeItem = (CircleNoticeItem) arrayList.get(currentItem);
        CircleNoticeItem.markLocalShownStatus(circleNoticeItem.getNoticeId());
        if (currentItem < arrayList.size()) {
            arrayList.remove(circleNoticeItem);
            updateIndicator(arrayList);
            this.mViewPagerCircleNotice.setAdapter(new a(arrayList, str));
            resetIndicator();
            this.mLlCircleNoticeIndicatorWrapper.getChildAt(0).setSelected(true);
        }
        if (arrayList.isEmpty()) {
            setVisibility(8);
        }
    }

    private void resetIndicator() {
        for (int i = 0; i < this.mLlCircleNoticeIndicatorWrapper.getChildCount(); i++) {
            this.mLlCircleNoticeIndicatorWrapper.getChildAt(i).setSelected(false);
        }
    }

    private void updateIndicator(ArrayList<CircleNoticeItem> arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = 8;
            if (i >= this.mLlCircleNoticeIndicatorWrapper.getChildCount()) {
                break;
            }
            View childAt = this.mLlCircleNoticeIndicatorWrapper.getChildAt(i);
            if (i < size) {
                i2 = 0;
            }
            childAt.setVisibility(i2);
            i++;
        }
        this.mLlCircleNoticeIndicatorWrapper.setVisibility(size <= 1 ? 8 : 0);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.circle_notice_banner_layout, this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, a46.b(getContext(), 84.0f)));
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_circle_notice);
        this.mViewPagerCircleNotice = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.mLlCircleNoticeIndicatorWrapper = (ViewGroup) findViewById(R.id.ll_circle_notice_indicator_wrapper);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int count = this.mViewPagerCircleNotice.getAdapter().getCount();
        int i2 = 0;
        while (i2 < this.mLlCircleNoticeIndicatorWrapper.getChildCount()) {
            View childAt = this.mLlCircleNoticeIndicatorWrapper.getChildAt(i2);
            childAt.setVisibility(i2 < count ? 0 : 8);
            childAt.setSelected(i2 == i);
            i2++;
        }
    }

    public void setCircleNotices(ArrayList<CircleNoticeItem> arrayList, final String str) {
        setVisibility(CollectionUtils.isEmpty(arrayList) ? 8 : 0);
        if (CollectionUtils.isEmpty(arrayList)) {
            return;
        }
        final ArrayList<CircleNoticeItem> arrayList2 = new ArrayList<>(Arrays.asList(new CircleNoticeItem[arrayList.size()]));
        Collections.copy(arrayList2, arrayList);
        this.mViewPagerCircleNotice.setAdapter(new a(arrayList2, str));
        findViewById(R.id.iv_circle_notice_close).setOnClickListener(new View.OnClickListener() { // from class: ab0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1188a.lambda$setCircleNotices$0(arrayList2, str, view);
            }
        });
        updateIndicator(arrayList2);
        this.mLlCircleNoticeIndicatorWrapper.getChildAt(0).setSelected(true);
    }

    public CircleNoticeBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleNoticeBanner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onResume() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }
}
