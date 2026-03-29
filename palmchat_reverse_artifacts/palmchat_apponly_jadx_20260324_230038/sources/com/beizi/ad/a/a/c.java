package com.beizi.ad.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.model.AdSpacesBean;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4334a;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean b;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean c;
    private a d = null;
    private AdSpacesBean.BuyerBean.PercentPositionBean e;
    private String f;
    private String g;
    private double h;
    private String i;
    private int j;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public c(Context context, AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean, String str, boolean z) {
        this.f = null;
        this.g = null;
        this.h = 0.0d;
        this.i = null;
        this.j = 0;
        try {
            this.f4334a = context;
            this.b = regionalClickViewBean;
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanA = a(regionalClickViewBean.getOrderData(), str);
            if (orderDataRegionalClickViewBeanA != null && orderDataRegionalClickViewBeanA.getRegionalClickView() != null) {
                this.c = orderDataRegionalClickViewBeanA.getRegionalClickView();
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.c;
            if (regionalClickViewBean2 != null) {
                if (z) {
                    String downloadTitle = regionalClickViewBean2.getDownloadTitle();
                    this.i = downloadTitle;
                    if (TextUtils.isEmpty(downloadTitle)) {
                        this.i = "点击下载应用";
                    }
                } else {
                    this.i = regionalClickViewBean2.getTitle();
                }
                this.e = this.c.getPosition();
                this.f = this.c.getTitleColor();
                this.g = this.c.getBackgroundColor();
                this.h = this.c.getBackgroundAlpha();
                this.j = this.c.getIsDisableClick();
            } else {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean3 = this.b;
                if (regionalClickViewBean3 != null) {
                    if (z) {
                        String downloadTitle2 = regionalClickViewBean3.getDownloadTitle();
                        this.i = downloadTitle2;
                        if (TextUtils.isEmpty(downloadTitle2)) {
                            this.i = "点击下载应用";
                        }
                    } else {
                        this.i = regionalClickViewBean3.getTitle();
                    }
                    this.e = this.b.getPosition();
                    this.f = this.b.getTitleColor();
                    this.g = this.b.getBackgroundColor();
                    this.h = this.b.getBackgroundAlpha();
                    this.j = this.b.getIsDisableClick();
                }
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = "点击跳转网页或第三方应用";
            }
            if (TextUtils.isEmpty(this.g)) {
                this.g = "#3976FF";
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = "#FFFFFF";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                percentPositionBean = this.e;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (percentPositionBean != null) {
                String centerX = percentPositionBean.getCenterX();
                String centerY = this.e.getCenterY();
                String width = this.e.getWidth();
                String height = this.e.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "0";
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = "0";
                }
                viewGroup.measure(0, 0);
                int iB = t.b(this.f4334a, viewGroup.getMeasuredWidth());
                int iB2 = t.b(this.f4334a, viewGroup.getMeasuredHeight());
                if (iB <= 0) {
                    iB = q.h(this.f4334a);
                }
                m.a("RegionClickUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + x.aQ + viewGroup.getLayoutParams().width + x.aQ + viewGroup.getLayoutParams().height);
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = String.valueOf(iB);
                }
                if (TextUtils.isEmpty(height) || "0".equals(height)) {
                    height = BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER;
                }
                int i = centerX.endsWith("%") ? (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * iB) / 100 : !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                int i2 = centerY.endsWith("%") ? (iB2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100 : !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
                int i3 = width.endsWith("%") ? (iB * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100 : !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 0;
                int i4 = height.endsWith("%") ? (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100 : !TextUtils.isEmpty(width) ? Integer.parseInt(height) : 40;
                int iA = t.a(this.f4334a, i3);
                int iA2 = t.a(this.f4334a, i4);
                int iA3 = t.a(this.f4334a, i);
                int iA4 = t.a(this.f4334a, i2);
                iArr[0] = iA;
                iArr[1] = iA2;
                if (iA3 > 0) {
                    iArr[2] = iA3;
                }
                if (iA4 > 0) {
                    iArr[3] = iA4;
                }
                m.a("RegionClickUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + x.aQ + centerX + x.aQ + centerY);
                return iArr;
            }
        }
        int i5 = viewGroup.getLayoutParams().width;
        int iA5 = t.a(this.f4334a, 40.0f);
        iArr[0] = i5;
        iArr[1] = iA5;
        iArr[2] = 0;
        iArr[3] = 0;
        return iArr;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f4334a == null) {
                    return;
                }
                TextView textView = new TextView(this.f4334a);
                textView.setVisibility(0);
                textView.setLines(1);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.j == 0) {
                    textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        float f4335a;
                        float b;
                        float c;
                        float d;
                        float e;
                        float f;

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.f4335a = motionEvent.getX();
                                this.b = motionEvent.getY();
                                this.c = motionEvent.getRawX();
                                this.d = motionEvent.getRawY();
                                this.e = motionEvent.getX();
                                this.f = motionEvent.getY();
                            } else if (action != 1) {
                                if (action == 2) {
                                    this.e = motionEvent.getX();
                                    this.f = motionEvent.getY();
                                }
                            } else if (Math.abs(this.e - this.f4335a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && c.this.d != null) {
                                c.this.d.a(String.valueOf(this.f4335a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f4335a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
                            }
                            return true;
                        }
                    });
                }
                if (!TextUtils.isEmpty(this.i)) {
                    textView.setText(this.i);
                }
                if (TextUtils.isEmpty(this.f)) {
                    this.f = "#FFFFFF";
                }
                if (!TextUtils.isEmpty(this.f) && this.f.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(this.f));
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.g = "#80000000";
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (!TextUtils.isEmpty(this.g) && this.g.startsWith("#")) {
                    gradientDrawable.setColor(Color.parseColor(this.g));
                }
                double d = this.h;
                if (d > 0.0d) {
                    gradientDrawable.setAlpha((int) (d * 255.0d));
                }
                gradientDrawable.setCornerRadius(t.a(this.f4334a, 7.0f));
                textView.setBackgroundDrawable(gradientDrawable);
                int[] iArrB = b(viewGroup);
                try {
                    textView.setTextSize(2, (float) (iArrB[1] > 0 ? t.b(this.f4334a, r7) / 3 : 14.0d));
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                    viewGroup.addView(textView, layoutParams);
                    return;
                }
                if (viewGroup instanceof FrameLayout) {
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
                    viewGroup.addView(textView, layoutParams2);
                    return;
                }
                if (!(viewGroup instanceof LinearLayout)) {
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
                    int i5 = iArrB[0];
                    if (i5 > 0) {
                        layoutParams3.width = i5;
                    }
                    int i6 = iArrB[1];
                    if (i6 > 0) {
                        layoutParams3.height = i6;
                    }
                    viewGroup.addView(textView, layoutParams3);
                    return;
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int i7 = iArrB[0];
                if (i7 > 0) {
                    layoutParams4.width = i7;
                }
                int i8 = iArrB[1];
                if (i8 > 0) {
                    layoutParams4.height = i8;
                }
                layoutParams4.leftMargin = iArrB[2];
                layoutParams4.topMargin = iArrB[3];
                viewGroup.addView(textView, layoutParams4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.e = null;
        this.d = null;
        this.f4334a = null;
    }

    public void a(LinearLayout linearLayout, TextView textView) {
        if (linearLayout == null || textView == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.i)) {
                textView.setText(this.i);
            }
            if (this.j != 0) {
                return;
            }
            linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                float f4336a;
                float b;
                float c;
                float d;
                float e;
                float f;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        this.f4336a = motionEvent.getX();
                        this.b = motionEvent.getY();
                        this.c = motionEvent.getRawX();
                        this.d = motionEvent.getRawY();
                        this.e = motionEvent.getX();
                        this.f = motionEvent.getY();
                    } else if (action != 1) {
                        if (action == 2) {
                            this.e = motionEvent.getX();
                            this.f = motionEvent.getY();
                        }
                    } else if (Math.abs(this.e - this.f4336a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && c.this.d != null) {
                        c.this.d.a(String.valueOf(this.f4336a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f4336a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    public String a() {
        return this.g;
    }
}
