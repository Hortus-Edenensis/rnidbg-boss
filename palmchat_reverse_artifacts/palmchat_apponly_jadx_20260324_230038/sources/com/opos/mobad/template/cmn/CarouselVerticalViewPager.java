package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CarouselVerticalViewPager extends com.opos.mobad.template.cmn.baseview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ag f9344a;
    private ah b;
    private TextView[] c;
    private BaseImageView[] d;
    private com.opos.mobad.d.c.d e;
    private boolean f;
    private int g;
    private int h;
    private final int i;

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewPagerAdapter extends PagerAdapter {
        private BaseImageView[] mImageViewList;

        public ViewPagerAdapter(BaseImageView[] baseImageViewArr) {
            this.mImageViewList = baseImageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0) {
                BaseImageView[] baseImageViewArr = this.mImageViewList;
                if (i < baseImageViewArr.length) {
                    viewGroup.removeView(baseImageViewArr[i]);
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
            BaseImageView[] baseImageViewArr = this.mImageViewList;
            if (i >= baseImageViewArr.length) {
                return null;
            }
            BaseImageView baseImageView = baseImageViewArr[i];
            viewGroup.addView(baseImageView);
            return baseImageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CarouselVerticalViewPager(Context context, int i, boolean z, int i2) {
        super(context, null);
        this.f = false;
        this.g = 5000;
        this.i = i;
        this.h = i2;
        this.e = new com.opos.mobad.d.c.d(com.opos.mobad.d.c.c.a(), new Runnable() { // from class: com.opos.mobad.template.cmn.CarouselVerticalViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!CarouselVerticalViewPager.this.f) {
                    CarouselVerticalViewPager.this.f9344a.setCurrentItem(CarouselVerticalViewPager.this.f9344a.getCurrentItem() + 1);
                    if (CarouselVerticalViewPager.this.b != null && CarouselVerticalViewPager.this.h > 0) {
                        CarouselVerticalViewPager.this.b.a(CarouselVerticalViewPager.this.h);
                    }
                }
                CarouselVerticalViewPager.this.e.a(CarouselVerticalViewPager.this.g + CarouselVerticalViewPager.this.h);
            }
        });
        this.c = new TextView[i];
        this.d = new BaseImageView[i + 2];
        a(i, z);
    }

    public static CarouselVerticalViewPager a(Context context, int i, boolean z) {
        return new CarouselVerticalViewPager(context, i, z, 0);
    }

    public static CarouselVerticalViewPager b(Context context, int i, boolean z) {
        return new CarouselVerticalViewPager(context, i, z, 300);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.a();
    }

    public void a() {
        com.opos.mobad.d.c.d dVar = this.e;
        if (dVar != null) {
            dVar.a();
            this.e.b();
        }
    }

    private void b() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            ah ahVar = new ah(this.f9344a.getContext(), new AccelerateInterpolator());
            this.b = ahVar;
            declaredField.set(this.f9344a, ahVar);
            this.b.a(this.h);
        } catch (Exception unused) {
            this.b = null;
        }
    }

    public void a(int i) {
        this.g = i;
        this.e.a(i);
    }

    private void a(int i, final boolean z) {
        this.f9344a = new ag(getContext());
        if (this.h > 0) {
            b();
        }
        addView(this.f9344a, new FrameLayout.LayoutParams(-1, -1));
        for (int i2 = 0; i2 < i + 2; i2++) {
            this.d[i2] = new BaseImageView(getContext());
            this.d[i2].setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (z) {
            b(i);
        }
        this.f9344a.setAdapter(new ViewPagerAdapter(this.d));
        this.f9344a.setCurrentItem(1, false);
        this.f9344a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.template.cmn.CarouselVerticalViewPager.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9346a = 0;

            private void setSelect(int i3) {
                int i4 = 0;
                while (i4 < CarouselVerticalViewPager.this.c.length) {
                    if (CarouselVerticalViewPager.this.c[i4] != null) {
                        CarouselVerticalViewPager.this.c[i4].setSelected(i4 == i3);
                    }
                    i4++;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                ag agVar;
                com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageScrollStateChanged " + i3);
                int i4 = 1;
                if (i3 == 1 || i3 == 2) {
                    CarouselVerticalViewPager.this.f = true;
                    return;
                }
                if (i3 == 0) {
                    int i5 = this.f9346a;
                    if (i5 != 0) {
                        if (i5 == CarouselVerticalViewPager.this.i + 1) {
                            agVar = CarouselVerticalViewPager.this.f9344a;
                        }
                        CarouselVerticalViewPager.this.f = false;
                    }
                    agVar = CarouselVerticalViewPager.this.f9344a;
                    i4 = CarouselVerticalViewPager.this.i;
                    agVar.setCurrentItem(i4, false);
                    CarouselVerticalViewPager.this.f = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                int i4;
                this.f9346a = i3;
                com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageSelected position = " + i3);
                if (z) {
                    if (i3 != 0 && i3 != CarouselVerticalViewPager.this.i) {
                        if (i3 == 1 || i3 == CarouselVerticalViewPager.this.i + 1) {
                            i4 = 0;
                        }
                        setSelect(i4);
                    }
                    i3 = CarouselVerticalViewPager.this.i;
                    i4 = i3 - 1;
                    setSelect(i4);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
            }
        });
    }

    private void b(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        for (int i2 = 0; i2 < i; i2++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA2, iA2);
            this.c[i2] = new TextView(getContext());
            this.c[i2].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.c[i2].setSelected(true);
            if (i2 == 0) {
                this.c[i2].setSelected(true);
            } else {
                layoutParams.topMargin = iA;
                this.c[i2].setSelected(false);
            }
            linearLayout.addView(this.c[i2], layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        layoutParams2.gravity = 21;
        addView(linearLayout, layoutParams2);
    }

    @Override // com.opos.mobad.template.cmn.baseview.a, com.opos.mobad.template.cmn.baseview.e
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        super.a(fVar);
        if (fVar == null) {
            return;
        }
        for (BaseImageView baseImageView : this.d) {
            baseImageView.a(fVar);
        }
    }

    public void a(p pVar) {
        if (pVar == null) {
            return;
        }
        for (BaseImageView baseImageView : this.d) {
            baseImageView.setOnClickListener(pVar);
            baseImageView.setOnTouchListener(pVar);
        }
    }

    public void a(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        int i = this.i;
        if (size > i) {
            list = list.subList(0, i);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Bitmap bitmap = list.get(i2);
            if (bitmap != null) {
                if (i2 == 0 && this.d[this.i + 1].getDrawable() == null) {
                    this.d[this.i + 1].setImageBitmap(bitmap);
                }
                if (i2 == this.i && this.d[0].getDrawable() == null) {
                    this.d[0].setImageBitmap(bitmap);
                }
                int i3 = i2 + 1;
                if (this.d[i3].getDrawable() == null) {
                    this.d[i3].setImageBitmap(bitmap);
                }
            }
        }
    }
}
