package com.zenmen.listui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.listui.R$drawable;
import com.zenmen.listui.R$id;
import com.zenmen.listui.R$layout;
import com.zenmen.listui.list.BannerBean;
import com.zenmen.palmchat.router.PagerRouterManager;
import defpackage.a46;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ViewPagerBannerView extends ConstraintLayout {
    private View mCurrentIndicator;
    private LinearLayout mIndicator;
    private List<BannerBean> mItems;
    private Runnable mRotationRunnable;
    private InfiniteViewPager mViewPager;
    private float startX;
    private float startY;

    /* JADX INFO: compiled from: SearchBox */
    public class ContactAdapter extends PagerAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BannerBean f11852a;

            public a(BannerBean bannerBean) {
                this.f11852a = bannerBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerRouterManager.getRouter().c((Activity) ViewPagerBannerView.this.getContext(), this.f11852a.url, false);
                ViewPagerBannerView.this.onEvent(this.f11852a.url, "click");
            }
        }

        public ContactAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (ViewPagerBannerView.this.mItems == null || ViewPagerBannerView.this.mItems.size() == 0) {
                return 0;
            }
            return ViewPagerBannerView.this.mItems.size() == 1 ? 1 : Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setBackgroundColor(-7829368);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
            viewGroup.addView(imageView);
            BannerBean bannerBean = (BannerBean) ViewPagerBannerView.this.mItems.get(i % ViewPagerBannerView.this.mItems.size());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            a46.u(bannerBean.imgUrl, imageView, R$drawable.ic_default_portrait);
            ViewPagerBannerView.this.onEvent(bannerBean.url, "view");
            imageView.setOnClickListener(new a(bannerBean));
            return imageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.PageTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f11853a = 0.8f;
        public final float b = 0.5f;

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(@NonNull View view, float f) {
            float f2 = f - 0.625f;
            float f3 = ((f2 < 0.0f ? 0.19999999f : -0.19999999f) * f2) + 1.0f;
            float f4 = (f2 * (f2 < 0.0f ? 0.5f : -0.5f)) + 1.0f;
            if (f2 < 0.0f) {
                view.setPivotX(view.getWidth());
                view.setPivotY(view.getHeight() / 2);
            } else {
                view.setPivotX(0.0f);
                view.setPivotY(view.getHeight() / 2);
            }
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setAlpha(Math.abs(f4));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerBannerView.this.mViewPager.getCurrentItem();
        }
    }

    public ViewPagerBannerView(@NonNull Context context) {
        this(context, null);
    }

    private int findStartItem() {
        int i = 1073741823;
        while (i % this.mItems.size() != 0) {
            i++;
        }
        return i;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_banner_view_pager_infinite, (ViewGroup) this, true);
        InfiniteViewPager infiniteViewPager = (InfiniteViewPager) findViewById(R$id.banner_viewpager);
        this.mViewPager = infiniteViewPager;
        infiniteViewPager.setPageMargin(10);
        this.mViewPager.setOffscreenPageLimit(5);
        this.mViewPager.setPageTransformer(true, new a());
        this.mIndicator = (LinearLayout) findViewById(R$id.ll_banner_indicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEvent(String str, String str2) {
        HashMap map = new HashMap();
        map.put("url", str);
        zn6.j("pagechatroomlist_banner", str2, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRotation() {
        removeCallbacks(this.mRotationRunnable);
        postDelayed(this.mRotationRunnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndicator(int i) {
        View view = this.mCurrentIndicator;
        if (view != null) {
            view.setSelected(false);
            ViewGroup.LayoutParams layoutParams = this.mCurrentIndicator.getLayoutParams();
            layoutParams.width = a46.b(getContext(), 4.0f);
            this.mCurrentIndicator.setLayoutParams(layoutParams);
        }
        View childAt = this.mIndicator.getChildAt(i % this.mItems.size());
        this.mCurrentIndicator = childAt;
        childAt.setSelected(true);
        ViewGroup.LayoutParams layoutParams2 = this.mCurrentIndicator.getLayoutParams();
        layoutParams2.width = a46.b(getContext(), 12.0f);
        this.mCurrentIndicator.setLayoutParams(layoutParams2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        List<BannerBean> list = this.mItems;
        if (list == null || list.size() <= 0) {
            return;
        }
        startRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mRotationRunnable);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
        } else if (motionEvent.getAction() != 2 || Math.abs(motionEvent.getX() - this.startX) <= Math.abs(motionEvent.getY() - this.startY)) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDatas(List<BannerBean> list) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mItems = list;
        ContactAdapter contactAdapter = new ContactAdapter();
        this.mViewPager.setAdapter(contactAdapter);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mIndicator.removeAllViews();
        for (int i = 0; i < this.mItems.size(); i++) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            appCompatImageView.setImageResource(R$drawable.selector_banner_indicator);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a46.b(getContext(), 4.0f), a46.b(getContext(), 4.0f));
            if (i > 0) {
                layoutParams.setMargins(a46.b(getContext(), 6.0f), 0, 0, 0);
            }
            this.mIndicator.addView(appCompatImageView, i, layoutParams);
        }
        if (this.mItems.size() > 1) {
            int iFindStartItem = findStartItem();
            this.mViewPager.setCurrentItem(iFindStartItem);
            updateIndicator(iFindStartItem);
            this.mIndicator.setVisibility(0);
            startRotation();
        } else {
            this.mIndicator.setVisibility(4);
        }
        contactAdapter.notifyDataSetChanged();
    }

    public ViewPagerBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ViewPagerBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItems = new ArrayList();
        this.mRotationRunnable = new b();
        initView();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewPagerBannerView.this.updateIndicator(i);
            ViewPagerBannerView.this.startRotation();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
