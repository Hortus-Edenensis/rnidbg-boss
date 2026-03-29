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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.zenmen.listui.R$drawable;
import com.zenmen.listui.R$id;
import com.zenmen.listui.R$layout;
import com.zenmen.listui.list.BannerBean;
import com.zenmen.palmchat.router.PagerRouterManager;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class BannerView extends ConstraintLayout {
    private RecyclerView.Adapter imageAdapter;
    private View mCurrentIndicator;
    private LinearLayout mIndicator;
    private List<BannerBean> mItems;
    private Runnable mRotationRunnable;
    private ViewPager2 mViewPager;
    private float startX;
    private float startY;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BannerView.this.mViewPager.setCurrentItem(BannerView.this.mViewPager.getCurrentItem() + 1, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            BannerView.this.updateIndicator(i);
            BannerView.this.startRotation();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends RecyclerView.Adapter<d> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            dVar.l((BannerBean) BannerView.this.mItems.get(i % BannerView.this.mItems.size()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            EffectiveShapeView effectiveShapeView = new EffectiveShapeView(viewGroup.getContext());
            effectiveShapeView.changeShapeType(3);
            effectiveShapeView.setDegreeForRoundRectangle(a46.b(BannerView.this.getContext(), 8.0f), a46.b(BannerView.this.getContext(), 8.0f));
            effectiveShapeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return BannerView.this.new d(effectiveShapeView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (BannerView.this.mItems == null || BannerView.this.mItems.size() == 0) {
                return 0;
            }
            return BannerView.this.mItems.size() == 1 ? 1 : Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.ViewHolder {
        public EffectiveShapeView d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BannerBean f11849a;

            public a(BannerBean bannerBean) {
                this.f11849a = bannerBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerRouterManager.getRouter().c((Activity) BannerView.this.getContext(), this.f11849a.url, false);
                BannerView.this.onEvent(this.f11849a.url, "click");
            }
        }

        public d(@NonNull View view) {
            super(view);
            this.d = (EffectiveShapeView) view;
        }

        public void l(BannerBean bannerBean) {
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            a46.u(bannerBean.imgUrl, this.d, R$drawable.ic_default_portrait);
            BannerView.this.onEvent(bannerBean.url, "view");
            this.d.setOnClickListener(new a(bannerBean));
        }
    }

    public BannerView(@NonNull Context context) {
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
        LayoutInflater.from(getContext()).inflate(R$layout.layout_banner_view_pager, (ViewGroup) this, true);
        this.mViewPager = (ViewPager2) findViewById(R$id.banner_viewpager);
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
        this.mViewPager.setAdapter(this.imageAdapter);
        this.mViewPager.registerOnPageChangeCallback(new b());
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
        this.imageAdapter.notifyDataSetChanged();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItems = new ArrayList();
        this.mRotationRunnable = new a();
        this.imageAdapter = new c();
        initView();
    }
}
