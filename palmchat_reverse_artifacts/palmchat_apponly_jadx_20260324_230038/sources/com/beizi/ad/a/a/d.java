package com.beizi.ad.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4337a;
    private AdSpacesBean.BuyerBean.ScrollClickBean b;
    private AdSpacesBean.BuyerBean.ScrollClickBean c;
    private AdSpacesBean.BuyerBean.ScrollClickPositionBean d;
    private View f;
    private String g;
    private int l;
    private ValueAnimator m;
    private int n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private LinearLayout u;
    private a e = null;
    private String h = "up";
    private String i = ScrollClickView.DIR_DOWN;
    private String j = "left";
    private String k = "right";
    private String r = "#9CBBFF";
    private String s = "#C1D4FF";
    private String t = "#FFFFFF";

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public d(Context context, AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, String str, String str2) {
        try {
            this.f4337a = context;
            this.b = scrollClickBean;
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanA = a(scrollClickBean.getOrderData(), str2);
            if (orderDataScrollViewOrderBeanA != null && orderDataScrollViewOrderBeanA.getScrollClick() != null) {
                this.c = orderDataScrollViewOrderBeanA.getScrollClick();
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.c;
            if (scrollClickBean2 != null) {
                this.g = scrollClickBean2.getScrollDirection();
                this.l = this.c.getScrollDistance();
                this.d = this.c.getPosition();
            } else {
                AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.b;
                if (scrollClickBean3 != null) {
                    this.g = scrollClickBean3.getScrollDirection();
                    this.l = this.b.getScrollDistance();
                    this.d = this.b.getPosition();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ int h(d dVar) {
        int i = dVar.n;
        dVar.n = i + 1;
        return i;
    }

    private void b() {
        this.u.setGravity(17);
        int i = this.u.getLayoutParams().width;
        int i2 = this.u.getLayoutParams().height;
        this.o = new ImageView(this.f4337a);
        this.p = new ImageView(this.f4337a);
        this.q = new ImageView(this.f4337a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.h.equals(this.g)) {
            this.u.setOrientation(1);
            ImageView imageView = this.o;
            int i3 = R.mipmap.beizi_interaction_icon_arrow_up;
            imageView.setImageResource(i3);
            this.p.setImageResource(i3);
            this.q.setImageResource(i3);
            this.o.setColorFilter(Color.parseColor(this.r));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.t));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.i.equals(this.g)) {
            this.u.setOrientation(1);
            ImageView imageView2 = this.o;
            int i4 = R.mipmap.beizi_interaction_icon_arrow_down;
            imageView2.setImageResource(i4);
            this.p.setImageResource(i4);
            this.q.setImageResource(i4);
            this.o.setColorFilter(Color.parseColor(this.t));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.r));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.j.equals(this.g)) {
            this.u.setOrientation(0);
            ImageView imageView3 = this.o;
            int i5 = R.mipmap.beizi_interaction_icon_arrow_left;
            imageView3.setImageResource(i5);
            this.p.setImageResource(i5);
            this.q.setImageResource(i5);
            this.o.setColorFilter(Color.parseColor(this.r));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.t));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        } else if (this.k.equals(this.g)) {
            this.u.setOrientation(0);
            ImageView imageView4 = this.o;
            int i6 = R.mipmap.beizi_interaction_icon_arrow_right;
            imageView4.setImageResource(i6);
            this.p.setImageResource(i6);
            this.q.setImageResource(i6);
            this.o.setColorFilter(Color.parseColor(this.t));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.r));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        }
        this.u.addView(this.o, layoutParams);
        this.u.addView(this.p, layoutParams);
        this.u.addView(this.q, layoutParams);
    }

    private void c() {
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.d.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f4338a;
            float b;
            float c;
            float d;
            float e;
            float f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f4338a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                } else if (action == 1) {
                    m.b("BeiZisAd", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f4338a + ",mPosY = " + this.b);
                    float f = this.d;
                    float f2 = this.b;
                    if (f - f2 <= 0.0f || Math.abs(f - f2) <= d.this.l) {
                        float f3 = this.d;
                        float f4 = this.b;
                        if (f3 - f4 >= 0.0f || Math.abs(f3 - f4) <= d.this.l) {
                            float f5 = this.c;
                            float f6 = this.f4338a;
                            if (f5 - f6 >= 0.0f || Math.abs(f5 - f6) <= d.this.l) {
                                float f7 = this.c;
                                float f8 = this.f4338a;
                                if (f7 - f8 <= 0.0f || Math.abs(f7 - f8) <= d.this.l) {
                                    if (Math.abs(this.c - this.f4338a) <= 15.0f && Math.abs(this.d - this.b) <= 15.0f && d.this.e != null) {
                                        d.this.e.b(this.f4338a + "", this.b + "", this.e + "", this.f + "", this.f4338a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (d.this.k.equalsIgnoreCase(d.this.g) && d.this.e != null) {
                                    d.this.e.a(this.f4338a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else if (d.this.j.equalsIgnoreCase(d.this.g) && d.this.e != null) {
                                d.this.e.a(this.f4338a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else if (d.this.h.equalsIgnoreCase(d.this.g) && d.this.e != null) {
                            d.this.e.a(this.f4338a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else if (d.this.i.equalsIgnoreCase(d.this.g) && d.this.e != null) {
                        d.this.e.a(this.f4338a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else if (action == 2) {
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    private void d() {
        try {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, 0);
            this.m = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(500L);
            this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.ad.a.a.d.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.m.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.ad.a.a.d.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    m.c("ScrollUtil", "addScrollViewViewAnimation onAnimationEnd");
                    try {
                        d.h(d.this);
                        if (d.this.h.equals(d.this.g) || d.this.j.equals(d.this.g)) {
                            if (d.this.n == 1) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.s));
                                d.this.p.setColorFilter(Color.parseColor(d.this.t));
                                d.this.q.setColorFilter(Color.parseColor(d.this.r));
                            } else if (d.this.n == 2) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.t));
                                d.this.p.setColorFilter(Color.parseColor(d.this.r));
                                d.this.q.setColorFilter(Color.parseColor(d.this.s));
                            } else if (d.this.n == 3) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.r));
                                d.this.p.setColorFilter(Color.parseColor(d.this.s));
                                d.this.q.setColorFilter(Color.parseColor(d.this.t));
                            }
                        } else if (d.this.i.equals(d.this.g) || d.this.k.equals(d.this.g)) {
                            if (d.this.n == 1) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.r));
                                d.this.p.setColorFilter(Color.parseColor(d.this.t));
                                d.this.q.setColorFilter(Color.parseColor(d.this.s));
                            } else if (d.this.n == 2) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.s));
                                d.this.p.setColorFilter(Color.parseColor(d.this.r));
                                d.this.q.setColorFilter(Color.parseColor(d.this.t));
                            } else if (d.this.n == 3) {
                                d.this.o.setColorFilter(Color.parseColor(d.this.t));
                                d.this.p.setColorFilter(Color.parseColor(d.this.s));
                                d.this.q.setColorFilter(Color.parseColor(d.this.r));
                            }
                        }
                        if (d.this.n >= 3) {
                            d.this.n = 0;
                        }
                        if (d.this.m != null) {
                            d.this.m.start();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f4337a == null) {
                    return;
                }
                this.u = new LinearLayout(this.f4337a);
                int[] iArrB = b(viewGroup);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    int i = iArrB[0];
                    if (i > 0) {
                        layoutParams.width = i;
                    }
                    int i2 = iArrB[1];
                    if (i2 > 0) {
                        layoutParams.height = i2;
                    }
                    layoutParams.leftMargin = iArrB[2];
                    layoutParams.topMargin = iArrB[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(this.u, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    int i3 = iArrB[0];
                    if (i3 > 0) {
                        layoutParams2.width = i3;
                    }
                    int i4 = iArrB[1];
                    if (i4 > 0) {
                        layoutParams2.height = i4;
                    }
                    layoutParams2.leftMargin = iArrB[2];
                    layoutParams2.topMargin = iArrB[3];
                    viewGroup.addView(this.u, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int i5 = iArrB[0];
                    if (i5 > 0) {
                        layoutParams3.width = i5;
                    }
                    int i6 = iArrB[1];
                    if (i6 > 0) {
                        layoutParams3.height = i6;
                    }
                    layoutParams3.leftMargin = iArrB[2];
                    layoutParams3.topMargin = iArrB[3];
                    viewGroup.addView(this.u, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    int i7 = iArrB[0];
                    if (i7 > 0) {
                        layoutParams4.width = i7;
                    }
                    int i8 = iArrB[1];
                    if (i8 > 0) {
                        layoutParams4.height = i8;
                    }
                    viewGroup.addView(this.u, layoutParams4);
                }
                b();
                d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(View view, a aVar) {
        this.f = view;
        this.e = aVar;
        c();
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    public void a() {
        try {
            this.f = null;
            this.e = null;
            this.c = null;
            this.b = null;
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.m.removeAllListeners();
            }
            this.m = null;
            this.o = null;
            this.p = null;
            this.q = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean;
        int i;
        int i2;
        int i3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                scrollClickPositionBean = this.d;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (scrollClickPositionBean != null) {
                String centerX = scrollClickPositionBean.getCenterX();
                String top = this.d.getTop();
                String width = this.d.getWidth();
                String height = this.d.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "10";
                }
                if (TextUtils.isEmpty(top) || "0".equals(top)) {
                    top = "10";
                }
                viewGroup.measure(0, 0);
                int iB = t.b(this.f4337a, viewGroup.getMeasuredWidth());
                int iB2 = t.b(this.f4337a, viewGroup.getMeasuredHeight());
                if (iB <= 0) {
                    iB = q.h(this.f4337a);
                }
                m.a("ScrollUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + x.aQ + viewGroup.getLayoutParams().width + x.aQ + viewGroup.getLayoutParams().height);
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
                }
                if (TextUtils.isEmpty(height) || "0".equals(height)) {
                    height = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
                }
                if (centerX.endsWith("%")) {
                    i = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * iB) / 100;
                } else {
                    i = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                }
                if (top.endsWith("%")) {
                    i2 = (iB2 * Integer.parseInt(top.substring(0, top.indexOf("%")))) / 100;
                } else {
                    i2 = !TextUtils.isEmpty(top) ? Integer.parseInt(top) : 0;
                }
                int i4 = 20;
                if (width.endsWith("%")) {
                    i3 = (iB * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    i3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                } else if (!TextUtils.isEmpty(width)) {
                    i4 = Integer.parseInt(height);
                }
                int iA = t.a(this.f4337a, i3);
                int iA2 = t.a(this.f4337a, i4);
                int iA3 = t.a(this.f4337a, i);
                int iA4 = t.a(this.f4337a, i2);
                iArr[0] = iA;
                iArr[1] = iA2;
                if (iA3 > 0) {
                    iArr[2] = iA3;
                }
                if (iA4 > 0) {
                    iArr[3] = iA4;
                }
                m.a("ScrollUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + x.aQ + centerX + x.aQ + top);
                return iArr;
            }
        }
        int iA5 = t.a(this.f4337a, 20.0f);
        int iA6 = t.a(this.f4337a, 10.0f);
        iArr[0] = iA5;
        iArr[1] = iA5;
        iArr[2] = iA6;
        iArr[3] = iA6;
        return iArr;
    }
}
