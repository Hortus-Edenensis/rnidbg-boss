package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.swiper.u.b;
import com.bytedance.adsdk.ugeno.swiper.u.fx;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.b {
    private static final Interpolator z = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5041a;
    private int b;
    private int bg;
    private int bq;
    private FrameLayout c;
    private final Runnable d;
    private int dw;
    protected Context fx;
    private final Runnable gi;
    private int iz;
    private String jk;
    private boolean k;
    private com.bytedance.adsdk.ugeno.swiper.u kj;
    private boolean l;
    private boolean mv;
    private boolean my;
    private int n;
    protected ViewPager nr;
    private boolean o;
    private int pn;
    private BaseIndicator q;
    private u qq;
    private boolean s;
    private int sx;
    private float t;
    protected List<T> u;
    private int x;

    /* JADX INFO: compiled from: SearchBox */
    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        private MotionEvent u(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.k) {
                return false;
            }
            try {
                if (BaseSwiper.this.dw != 1) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(u(motionEvent));
                u(motionEvent);
                return zOnInterceptTouchEvent;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.k) {
                return false;
            }
            try {
                return BaseSwiper.this.dw == 1 ? super.onTouchEvent(u(motionEvent)) : super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends com.bytedance.adsdk.ugeno.viewpager.nr {
        public u() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public int u(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public boolean u(View view, Object obj) {
            return view == obj;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public int u() {
            if (BaseSwiper.this.s) {
                return 1024;
            }
            return BaseSwiper.this.u.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public Object u(ViewGroup viewGroup, int i) {
            View viewU = BaseSwiper.this.u(i, nr.u(BaseSwiper.this.s, i, BaseSwiper.this.u.size()));
            viewGroup.addView(viewU);
            return viewU;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public void u(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.nr
        public float u(int i) {
            if (BaseSwiper.this.t <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.t;
        }
    }

    public BaseSwiper(Context context) {
        super(context);
        this.u = new CopyOnWriteArrayList();
        this.b = 2000;
        this.pn = 500;
        this.iz = 500;
        this.x = 0;
        this.n = -1;
        this.f5041a = -1;
        this.jk = PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
        this.t = 1.0f;
        this.l = true;
        this.mv = true;
        this.s = true;
        this.k = true;
        this.sx = 0;
        this.bg = 0;
        this.bq = 0;
        this.dw = 0;
        this.gi = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.nr.getCurrentItem() + 1;
                if (BaseSwiper.this.s) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.nr.u(512, false);
                        return;
                    } else {
                        BaseSwiper.this.nr.u(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.viewpager.nr adapter = BaseSwiper.this.nr.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.u()) {
                        BaseSwiper.this.nr.u(0, false);
                    } else {
                        BaseSwiper.this.nr.u(currentItem, true);
                    }
                }
            }
        };
        this.d = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.mv) {
                    int currentItem = BaseSwiper.this.nr.getCurrentItem() + 1;
                    if (BaseSwiper.this.s) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.nr.u(512, false);
                        } else {
                            BaseSwiper.this.nr.u(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.d, BaseSwiper.this.b);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.viewpager.nr adapter = BaseSwiper.this.nr.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.u()) {
                            BaseSwiper.this.nr.u(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.d, BaseSwiper.this.b);
                        } else {
                            BaseSwiper.this.nr.u(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.d, BaseSwiper.this.b);
                        }
                    }
                }
            }
        };
        this.fx = context;
        this.c = new FrameLayout(context);
        this.nr = u();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.c.addView(this.nr, layoutParams);
        addView(this.c);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.b
    public void a(int i) {
        if (i == 1 && this.my) {
            b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mv) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.my) {
                    fx();
                }
            } else if (action == 0) {
                b();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.adsdk.ugeno.viewpager.nr getAdapter() {
        return this.nr.getAdapter();
    }

    public int getCurrentItem() {
        return this.nr.getCurrentItem();
    }

    public ViewPager getViewPager() {
        return this.nr;
    }

    public void jk(int i) {
        u(this.jk, this.x, this.n, this.f5041a, true);
        if (this.qq == null) {
            this.qq = new u();
            this.nr.u((ViewPager.b) this);
            this.nr.setAdapter(this.qq);
        }
        if (this.s) {
            if (i >= 1024) {
                this.nr.u(512, false);
                return;
            } else {
                this.nr.u(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.u.size()) {
            return;
        }
        this.nr.u(i, true);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.b
    public void n(int i) {
        if (this.kj != null) {
            int iU = nr.u(this.s, i, this.u.size());
            this.kj.u(this.s, iU, i, iU == 0, iU == this.u.size() - 1);
        }
        if (this.l) {
            this.q.u(i);
        }
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.u uVar) {
        this.kj = uVar;
    }

    public void setTwoItems(boolean z2) {
        this.o = z2;
    }

    public void t(int i) {
        removeCallbacks(this.gi);
        postDelayed(this.gi, i);
    }

    public abstract View x(int i);

    private boolean x() {
        return this.u.size() <= 2 && this.s;
    }

    public BaseSwiper b(boolean z2) {
        this.q.setLoop(z2);
        if (this.s != z2) {
            int iU = nr.u(z2, this.nr.getCurrentItem(), this.u.size());
            this.s = z2;
            u uVar = this.qq;
            if (uVar != null) {
                uVar.fx();
                this.nr.setCurrentItem(iU);
            }
        }
        return this;
    }

    public BaseSwiper fx(boolean z2) {
        this.l = z2;
        return this;
    }

    public BaseSwiper iz(int i) {
        this.f5041a = i;
        u(this.jk, this.x, this.n, i, true);
        return this;
    }

    public BaseSwiper nr(boolean z2) {
        this.k = z2;
        return this;
    }

    public BaseSwiper<T> pn(int i) {
        this.n = i;
        u(this.jk, this.x, i, this.f5041a, true);
        return this;
    }

    public ViewPager u() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper fx(int i) {
        this.q.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper nr(int i) {
        this.q.setSelectedColor(i);
        return this;
    }

    public BaseSwiper u(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.q = new RectangleIndicator(this.fx);
        } else {
            this.q = new DotIndicator(this.fx);
        }
        addView(this.q, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public void fx() {
        removeCallbacks(this.d);
        postDelayed(this.d, this.b);
    }

    public void iz() {
        removeCallbacks(this.gi);
    }

    public BaseSwiper nr(String str) {
        this.jk = str;
        u(str, this.x, this.n, this.f5041a, true);
        return this;
    }

    public void pn() {
        int i;
        u(this.jk, this.x, this.n, this.f5041a, true);
        if (this.qq == null) {
            this.qq = new u();
            this.nr.u((ViewPager.b) this);
            this.nr.setAdapter(this.qq);
        }
        int i2 = this.sx;
        if (i2 < 0 || i2 >= this.u.size()) {
            this.sx = 0;
        }
        if (this.s) {
            i = this.sx + 512;
        } else {
            i = this.sx;
        }
        this.nr.u(i, true);
    }

    public void nr() {
        int i;
        u(this.jk, this.x, this.n, this.f5041a, true);
        if (this.qq == null) {
            this.qq = new u();
            this.nr.u((ViewPager.b) this);
            this.nr.setAdapter(this.qq);
        }
        int i2 = this.sx;
        if (i2 < 0 || i2 >= this.u.size()) {
            this.sx = 0;
        }
        if (this.s) {
            i = this.sx + 512;
        } else {
            i = this.sx;
        }
        this.nr.u(i, true);
        if (!this.s) {
            n(i);
        }
        if (this.mv) {
            fx();
        }
    }

    public BaseSwiper u(boolean z2) {
        this.mv = z2;
        fx();
        return this;
    }

    public BaseSwiper b(int i) {
        this.x = i;
        u(this.jk, i, this.n, this.f5041a, true);
        return this;
    }

    public BaseSwiper u(int i) {
        this.b = i;
        fx();
        return this;
    }

    public void b() {
        removeCallbacks(this.d);
    }

    public BaseSwiper u(float f) {
        this.t = f;
        return this;
    }

    public void u(String str, int i, int i2, int i3, boolean z2) {
        u uVar = this.qq;
        if (uVar != null) {
            uVar.fx();
        }
        this.nr.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.dw == 1) {
                this.nr.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.nr.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.c.setClipChildren(false);
            this.nr.setClipChildren(false);
            this.nr.setClipToPadding(false);
        }
        if (this.dw == 1) {
            b bVar = new b();
            bVar.u(str);
            this.nr.u(true, (ViewPager.pn) bVar);
            this.nr.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.nr.u(false, (ViewPager.pn) new fx());
        } else if (TextUtils.equals(str, "cube")) {
            this.nr.u(false, (ViewPager.pn) new com.bytedance.adsdk.ugeno.swiper.u.u());
        } else if (TextUtils.equals(str, "fade")) {
            this.nr.u(false, (ViewPager.pn) new com.bytedance.adsdk.ugeno.swiper.u.nr());
        } else {
            this.nr.u(false, (ViewPager.pn) null);
        }
        this.nr.setOffscreenPageLimit((int) this.t);
    }

    public View u(int i, int i2) {
        if (this.u.size() == 0) {
            return new View(getContext());
        }
        View viewX = x(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewX instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (x()) {
            viewX.setTag("two_items_tag");
        }
        if (viewX.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewX.getParent()).removeView(viewX);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewX, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (x()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> u(T t) {
        if (t != null) {
            this.u.add(t);
            if (this.l) {
                this.q.u();
            }
        }
        u uVar = this.qq;
        if (uVar != null) {
            uVar.fx();
            this.q.u(this.sx, this.nr.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.b
    public void u(int i, float f, int i2) {
        if (this.kj != null) {
            nr.u(this.s, i, this.u.size());
        }
        if (x()) {
            u(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                u(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    private void u(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.u.get(nr.u(true, i, this.u.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.nr.fx) {
                viewFindViewWithTag = ((com.bytedance.adsdk.ugeno.nr.fx) t).a();
            } else if (t instanceof View) {
                viewFindViewWithTag = (View) t;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }
}
