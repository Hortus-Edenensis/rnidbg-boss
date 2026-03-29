package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CarouselViewPager extends com.opos.mobad.template.cmn.baseview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager f9347a;
    private TextView[] b;
    private BaseImageView[] c;
    private com.opos.mobad.d.c.d d;
    private boolean e;
    private int f;
    private final int g;
    private boolean h;
    private ImageView.ScaleType i;

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewPagerAdapter extends PagerAdapter {
        private ImageView[] mImageViewList;

        public ViewPagerAdapter(ImageView[] imageViewArr) {
            this.mImageViewList = imageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0) {
                ImageView[] imageViewArr = this.mImageViewList;
                if (i < imageViewArr.length) {
                    viewGroup.removeView(imageViewArr[i]);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mImageViewList.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < 0) {
                return null;
            }
            ImageView[] imageViewArr = this.mImageViewList;
            if (i >= imageViewArr.length) {
                return null;
            }
            ImageView imageView = imageViewArr[i];
            viewGroup.addView(imageView);
            return imageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CarouselViewPager(Context context, int i) {
        this(context, i, true, ImageView.ScaleType.FIT_XY);
    }

    public void a(int i) {
        this.f = i;
        this.d.a(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.a();
    }

    public CarouselViewPager(Context context, int i, boolean z, ImageView.ScaleType scaleType) {
        super(context, null);
        this.e = false;
        this.f = 3000;
        this.h = z;
        this.i = scaleType;
        this.g = i;
        this.d = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), new Runnable() { // from class: com.opos.mobad.template.cmn.CarouselViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!CarouselViewPager.this.e) {
                    CarouselViewPager.this.f9347a.setCurrentItem(CarouselViewPager.this.f9347a.getCurrentItem() + 1);
                }
                CarouselViewPager.this.d.a(CarouselViewPager.this.f);
            }
        });
        if (z) {
            this.b = new TextView[i];
        }
        this.c = new BaseImageView[i + 2];
        b(i);
    }

    private void b(int i) {
        ViewPager viewPager = new ViewPager(getContext());
        this.f9347a = viewPager;
        addView(viewPager, new FrameLayout.LayoutParams(-1, -1));
        for (int i2 = 0; i2 < i + 2; i2++) {
            this.c[i2] = new BaseImageView(getContext());
            this.c[i2].setScaleType(this.i);
        }
        if (this.h) {
            c(i);
        }
        this.f9347a.setAdapter(new ViewPagerAdapter(this.c));
        this.f9347a.setCurrentItem(1, false);
        this.f9347a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.template.cmn.CarouselViewPager.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9349a = 0;

            private void setSelect(int i3) {
                if (CarouselViewPager.this.h) {
                    int i4 = 0;
                    while (i4 < CarouselViewPager.this.b.length) {
                        CarouselViewPager.this.b[i4].setSelected(i4 == i3);
                        i4++;
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                ViewPager viewPager2;
                com.opos.cmn.an.f.a.b("viewPager", "onPageScrollStateChanged " + i3);
                int i4 = 1;
                if (i3 == 1 || i3 == 2) {
                    CarouselViewPager.this.e = true;
                    return;
                }
                if (i3 == 0) {
                    int i5 = this.f9349a;
                    if (i5 != 0) {
                        if (i5 == CarouselViewPager.this.g + 1) {
                            viewPager2 = CarouselViewPager.this.f9347a;
                        }
                        CarouselViewPager.this.e = false;
                    }
                    viewPager2 = CarouselViewPager.this.f9347a;
                    i4 = CarouselViewPager.this.g;
                    viewPager2.setCurrentItem(i4, false);
                    CarouselViewPager.this.e = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                int i4;
                this.f9349a = i3;
                com.opos.cmn.an.f.a.b("viewPager", "onPageSelected position = " + i3);
                if (i3 != 0 && i3 != CarouselViewPager.this.g) {
                    if (i3 == 1 || i3 == CarouselViewPager.this.g + 1) {
                        i4 = 0;
                    }
                    setSelect(i4);
                }
                i3 = CarouselViewPager.this.g;
                i4 = i3 - 1;
                setSelect(i4);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
            }
        });
    }

    private void c(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 1.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        for (int i2 = 0; i2 < i; i2++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA3, iA3);
            this.b[i2] = new TextView(getContext());
            this.b[i2].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.b[i2].setSelected(true);
            if (i2 == 0) {
                layoutParams.leftMargin = iA;
                this.b[i2].setSelected(true);
            } else {
                layoutParams.leftMargin = iA2;
                this.b[i2].setSelected(false);
            }
            if (i2 == i - 1) {
                layoutParams.rightMargin = iA;
            }
            linearLayout.addView(this.b[i2], layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 32.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
        layoutParams2.gravity = 81;
        addView(linearLayout, layoutParams2);
    }

    @Override // com.opos.mobad.template.cmn.baseview.a, com.opos.mobad.template.cmn.baseview.e
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        super.a(fVar);
        if (fVar == null) {
            return;
        }
        for (BaseImageView baseImageView : this.c) {
            baseImageView.a(fVar);
        }
    }

    public void a(p pVar) {
        if (pVar == null) {
            return;
        }
        for (BaseImageView baseImageView : this.c) {
            baseImageView.setOnClickListener(pVar);
            baseImageView.setOnTouchListener(pVar);
        }
    }

    public void a(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        int i = this.g;
        if (size > i) {
            list = list.subList(0, i);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Bitmap bitmap = list.get(i2);
            if (bitmap != null) {
                if (i2 == 0 && this.c[this.g + 1].getDrawable() == null) {
                    this.c[this.g + 1].setImageBitmap(bitmap);
                }
                if (i2 == this.g && this.c[0].getDrawable() == null) {
                    this.c[0].setImageBitmap(bitmap);
                }
                int i3 = i2 + 1;
                if (this.c[i3].getDrawable() == null) {
                    this.c[i3].setImageBitmap(bitmap);
                }
            }
        }
    }
}
