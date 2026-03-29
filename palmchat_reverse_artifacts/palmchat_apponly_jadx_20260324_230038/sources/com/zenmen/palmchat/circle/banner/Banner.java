package com.zenmen.palmchat.circle.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.R;
import defpackage.jp;
import defpackage.n64;
import defpackage.ui6;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    private b adapter;
    private int bannerBackgroundImage;
    private ImageView bannerDefaultImage;
    private int bannerStyle;
    private TextView bannerTitle;
    private Context context;
    private int count;
    private int currentItem;
    private int delayTime;
    private DisplayMetrics dm;
    private int gravity;
    private ui6 handler;
    private ImageLoaderInterface imageLoader;
    private List imageUrls;
    private List<View> imageViews;
    private LinearLayout indicator;
    private List<ImageView> indicatorImages;
    private LinearLayout indicatorInside;
    private int indicatorSize;
    private boolean isAutoPlay;
    private boolean isScroll;
    private int lastPosition;
    private n64 listener;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorSelectedResId;
    private int mIndicatorUnselectedResId;
    private int mIndicatorWidth;
    private int mLayoutResId;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private jp mScroller;
    private TextView numIndicator;
    private TextView numIndicatorInside;
    private int scaleType;
    private int scrollTime;
    public String tag;
    private final Runnable task;
    private int titleBackground;
    private int titleHeight;
    private int titleTextColor;
    private int titleTextSize;
    private LinearLayout titleView;
    private List<String> titles;
    private BannerViewPager viewPager;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Banner.this.count <= 1 || !Banner.this.isAutoPlay) {
                return;
            }
            Banner banner = Banner.this;
            banner.currentItem = (banner.currentItem % (Banner.this.count + 1)) + 1;
            if (Banner.this.currentItem == 1) {
                Banner.this.viewPager.setCurrentItem(Banner.this.currentItem, false);
                Banner.this.handler.a(Banner.this.task);
            } else {
                Banner.this.viewPager.setCurrentItem(Banner.this.currentItem);
                Banner.this.handler.b(Banner.this.task, Banner.this.delayTime);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends PagerAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f13047a;

            public a(int i) {
                this.f13047a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Banner.this.listener.a(Banner.this.toRealPosition(this.f13047a));
            }
        }

        public b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Banner.this.imageViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) Banner.this.imageViews.get(i));
            View view = (View) Banner.this.imageViews.get(i);
            if (Banner.this.listener != null) {
                view.setOnClickListener(new a(i));
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void createIndicator() {
        this.indicatorImages.clear();
        this.indicator.removeAllViews();
        this.indicatorInside.removeAllViews();
        for (int i = 0; i < this.count; i++) {
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
            int i2 = this.mIndicatorMargin;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            if (i == 0) {
                imageView.setImageResource(this.mIndicatorSelectedResId);
            } else {
                imageView.setImageResource(this.mIndicatorUnselectedResId);
            }
            this.indicatorImages.add(imageView);
            int i3 = this.bannerStyle;
            if (i3 == 1 || i3 == 4) {
                this.indicator.addView(imageView, layoutParams);
            } else if (i3 == 5) {
                this.indicatorInside.addView(imageView, layoutParams);
            }
        }
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.mIndicatorWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, this.indicatorSize);
        this.mIndicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, this.indicatorSize);
        this.mIndicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 5);
        this.mIndicatorSelectedResId = typedArrayObtainStyledAttributes.getResourceId(4, R.drawable.banner_select_radius);
        this.mIndicatorUnselectedResId = typedArrayObtainStyledAttributes.getResourceId(5, R.drawable.banner_unselect_radius);
        this.scaleType = typedArrayObtainStyledAttributes.getInt(3, this.scaleType);
        this.delayTime = typedArrayObtainStyledAttributes.getInt(2, 2000);
        this.scrollTime = typedArrayObtainStyledAttributes.getInt(10, 800);
        this.isAutoPlay = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.titleBackground = typedArrayObtainStyledAttributes.getColor(11, -1);
        this.titleHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, -1);
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(13, -1);
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, -1);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(1, this.mLayoutResId);
        this.bannerBackgroundImage = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.no_banner);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initImages() {
        this.imageViews.clear();
        int i = this.bannerStyle;
        if (i == 1 || i == 4 || i == 5) {
            createIndicator();
            return;
        }
        if (i == 3) {
            this.numIndicatorInside.setText("1/" + this.count);
            return;
        }
        if (i == 2) {
            this.numIndicator.setText("1/" + this.count);
        }
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.imageViews.clear();
        handleTypedArray(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(this.mLayoutResId, (ViewGroup) this, true);
        this.bannerDefaultImage = (ImageView) viewInflate.findViewById(R.id.bannerDefaultImage);
        this.viewPager = (BannerViewPager) viewInflate.findViewById(R.id.bannerViewPager);
        this.titleView = (LinearLayout) viewInflate.findViewById(R.id.titleView);
        this.indicator = (LinearLayout) viewInflate.findViewById(R.id.circleIndicator);
        this.indicatorInside = (LinearLayout) viewInflate.findViewById(R.id.indicatorInside);
        this.bannerTitle = (TextView) viewInflate.findViewById(R.id.bannerTitle);
        this.numIndicator = (TextView) viewInflate.findViewById(R.id.numIndicator);
        this.numIndicatorInside = (TextView) viewInflate.findViewById(R.id.numIndicatorInside);
        this.bannerDefaultImage.setImageResource(this.bannerBackgroundImage);
        initViewPagerScroll();
    }

    private void initViewPagerScroll() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            jp jpVar = new jp(this.viewPager.getContext());
            this.mScroller = jpVar;
            jpVar.a(this.scrollTime);
            declaredField.set(this.viewPager, this.mScroller);
        } catch (Exception e) {
            Log.e(this.tag, e.getMessage());
        }
    }

    private void setBannerStyleUI() {
        int i = this.count > 1 ? 0 : 8;
        int i2 = this.bannerStyle;
        if (i2 == 1) {
            this.indicator.setVisibility(i);
            return;
        }
        if (i2 == 2) {
            this.numIndicator.setVisibility(i);
            return;
        }
        if (i2 == 3) {
            this.numIndicatorInside.setVisibility(i);
            setTitleStyleUI();
        } else if (i2 == 4) {
            this.indicator.setVisibility(i);
            setTitleStyleUI();
        } else {
            if (i2 != 5) {
                return;
            }
            this.indicatorInside.setVisibility(i);
            setTitleStyleUI();
        }
    }

    private void setData() {
        this.currentItem = 1;
        if (this.adapter == null) {
            this.adapter = new b();
            this.viewPager.addOnPageChangeListener(this);
        }
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setFocusable(true);
        this.viewPager.setCurrentItem(1);
        int i = this.gravity;
        if (i != -1) {
            this.indicator.setGravity(i);
        }
        if (!this.isScroll || this.count <= 1) {
            this.viewPager.setScrollable(false);
        } else {
            this.viewPager.setScrollable(true);
        }
        if (this.isAutoPlay) {
            startAutoPlay();
        }
    }

    private void setImageList(List<?> list) {
        if (list == null || list.size() <= 0) {
            this.bannerDefaultImage.setVisibility(0);
            Log.e(this.tag, "The image data set is empty.");
            return;
        }
        this.bannerDefaultImage.setVisibility(8);
        initImages();
        int i = 0;
        while (i <= this.count + 1) {
            ImageLoaderInterface imageLoaderInterface = this.imageLoader;
            View viewCreateImageView = imageLoaderInterface != null ? imageLoaderInterface.createImageView(this.context) : null;
            if (viewCreateImageView == null) {
                viewCreateImageView = new ImageView(this.context);
            }
            setScaleType(viewCreateImageView);
            Object obj = i == 0 ? list.get(this.count - 1) : i == this.count + 1 ? list.get(0) : list.get(i - 1);
            this.imageViews.add(viewCreateImageView);
            ImageLoaderInterface imageLoaderInterface2 = this.imageLoader;
            if (imageLoaderInterface2 != null) {
                imageLoaderInterface2.displayImage(this.context, obj, viewCreateImageView);
            } else {
                Log.e(this.tag, "Please set images loader.");
            }
            i++;
        }
    }

    private void setScaleType(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            switch (this.scaleType) {
                case 0:
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    break;
                case 1:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                case 2:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case 3:
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case 4:
                    imageView.setScaleType(ImageView.ScaleType.FIT_END);
                    break;
                case 5:
                    imageView.setScaleType(ImageView.ScaleType.FIT_START);
                    break;
                case 6:
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                case 7:
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    break;
            }
        }
    }

    private void setTitleStyleUI() {
        if (this.titles.size() != this.imageUrls.size()) {
            throw new RuntimeException("[Banner] --> The number of titles and images is different");
        }
        int i = this.titleBackground;
        if (i != -1) {
            this.titleView.setBackgroundColor(i);
        }
        if (this.titleHeight != -1) {
            this.titleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.titleHeight));
        }
        int i2 = this.titleTextColor;
        if (i2 != -1) {
            this.bannerTitle.setTextColor(i2);
        }
        int i3 = this.titleTextSize;
        if (i3 != -1) {
            this.bannerTitle.setTextSize(0, i3);
        }
        List<String> list = this.titles;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.bannerTitle.setText(this.titles.get(0));
        this.bannerTitle.setVisibility(0);
        this.titleView.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.isAutoPlay) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startAutoPlay();
            } else if (action == 0) {
                stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Banner isAutoPlay(boolean z) {
        this.isAutoPlay = z;
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        if (i == 0) {
            int i2 = this.currentItem;
            if (i2 == 0) {
                this.viewPager.setCurrentItem(this.count, false);
                return;
            } else {
                if (i2 == this.count + 1) {
                    this.viewPager.setCurrentItem(1, false);
                    return;
                }
                return;
            }
        }
        if (i != 1) {
            return;
        }
        int i3 = this.currentItem;
        int i4 = this.count;
        if (i3 == i4 + 1) {
            this.viewPager.setCurrentItem(1, false);
        } else if (i3 == 0) {
            this.viewPager.setCurrentItem(i4, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(toRealPosition(i), f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.currentItem = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(toRealPosition(i));
        }
        int i2 = this.bannerStyle;
        if (i2 == 1 || i2 == 4 || i2 == 5) {
            List<ImageView> list = this.indicatorImages;
            int i3 = this.lastPosition - 1;
            int i4 = this.count;
            list.get((i3 + i4) % i4).setImageResource(this.mIndicatorUnselectedResId);
            List<ImageView> list2 = this.indicatorImages;
            int i5 = this.count;
            list2.get(((i - 1) + i5) % i5).setImageResource(this.mIndicatorSelectedResId);
            this.lastPosition = i;
        }
        if (i == 0) {
            i = this.count;
        }
        if (i > this.count) {
            i = 1;
        }
        int i6 = this.bannerStyle;
        if (i6 == 2) {
            this.numIndicator.setText(i + "/" + this.count);
            return;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                this.bannerTitle.setText(this.titles.get(i - 1));
                return;
            } else {
                if (i6 != 5) {
                    return;
                }
                this.bannerTitle.setText(this.titles.get(i - 1));
                return;
            }
        }
        this.numIndicatorInside.setText(i + "/" + this.count);
        this.bannerTitle.setText(this.titles.get(i - 1));
    }

    public void releaseBanner() {
        this.handler.d(null);
    }

    public Banner setBannerAnimation(Class<? extends ViewPager.PageTransformer> cls) {
        try {
            setPageTransformer(true, cls.newInstance());
        } catch (Exception unused) {
            Log.e(this.tag, "Please set the PageTransformer class");
        }
        return this;
    }

    public Banner setBannerStyle(int i) {
        this.bannerStyle = i;
        return this;
    }

    public Banner setBannerTitles(List<String> list) {
        this.titles = list;
        return this;
    }

    public Banner setDelayTime(int i) {
        this.delayTime = i;
        return this;
    }

    public Banner setImageLoader(ImageLoaderInterface imageLoaderInterface) {
        this.imageLoader = imageLoaderInterface;
        return this;
    }

    public Banner setImages(List<?> list) {
        this.imageUrls = list;
        this.count = list.size();
        return this;
    }

    public Banner setIndicatorGravity(int i) {
        if (i == 5) {
            this.gravity = 19;
        } else if (i == 6) {
            this.gravity = 17;
        } else if (i == 7) {
            this.gravity = 21;
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i) {
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setOffscreenPageLimit(i);
        }
        return this;
    }

    public Banner setOnBannerListener(n64 n64Var) {
        this.listener = n64Var;
        return this;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public Banner setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        this.viewPager.setPageTransformer(z, pageTransformer);
        return this;
    }

    public Banner setViewPagerIsScroll(boolean z) {
        this.isScroll = z;
        return this;
    }

    public Banner start() {
        setBannerStyleUI();
        setImageList(this.imageUrls);
        setData();
        return this;
    }

    public void startAutoPlay() {
        this.handler.c(this.task);
        this.handler.b(this.task, this.delayTime);
    }

    public void stopAutoPlay() {
        this.handler.c(this.task);
    }

    public int toRealPosition(int i) {
        int i2 = this.count;
        int i3 = (i - 1) % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public void update(List<?> list, List<String> list2) {
        this.titles.clear();
        this.titles.addAll(list2);
        update(list);
    }

    public void updateBannerStyle(int i) {
        this.indicator.setVisibility(8);
        this.numIndicator.setVisibility(8);
        this.numIndicatorInside.setVisibility(8);
        this.indicatorInside.setVisibility(8);
        this.bannerTitle.setVisibility(8);
        this.titleView.setVisibility(8);
        this.bannerStyle = i;
        start();
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tag = MediationConstant.RIT_TYPE_BANNER;
        this.mIndicatorMargin = 5;
        this.bannerStyle = 1;
        this.delayTime = 2000;
        this.scrollTime = 800;
        this.isAutoPlay = true;
        this.isScroll = true;
        this.mIndicatorSelectedResId = R.drawable.banner_select_radius;
        this.mIndicatorUnselectedResId = R.drawable.banner_unselect_radius;
        this.mLayoutResId = R.layout.banner;
        this.count = 0;
        this.gravity = -1;
        this.lastPosition = 1;
        this.scaleType = 1;
        this.handler = new ui6();
        this.task = new a();
        this.context = context;
        this.titles = new ArrayList();
        this.imageUrls = new ArrayList();
        this.imageViews = new ArrayList();
        this.indicatorImages = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.dm = displayMetrics;
        this.indicatorSize = displayMetrics.widthPixels / 80;
        initView(context, attributeSet);
    }

    public void update(List<?> list) {
        this.imageUrls.clear();
        this.imageViews.clear();
        this.indicatorImages.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }
}
