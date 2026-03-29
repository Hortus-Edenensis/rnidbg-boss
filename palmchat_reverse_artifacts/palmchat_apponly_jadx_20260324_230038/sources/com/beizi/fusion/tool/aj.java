package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class aj {
    private static AdSpacesBean.BuyerBean.ScrollClickBean j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ScrollClickView f4711a;
    int b;
    int c;
    private Context d;
    private int e;
    private int f;
    private a g = null;
    private boolean h = false;
    private int i = 200;
    private Boolean k;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a_();

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public aj(Context context) {
        this.d = context;
    }

    private void c() {
        if (((Boolean) c(this.f).second).booleanValue()) {
            u.a(new Runnable() { // from class: com.beizi.fusion.tool.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.a();
                }
            }, this.e + (((Integer) r0.first).intValue() * 10));
        }
    }

    public void b(int i) {
        this.f = i;
        c();
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean) {
        if (scrollClickBean == null) {
            return;
        }
        j = scrollClickBean;
        a(scrollClickBean.getRandomClickTime());
        b(scrollClickBean.getRandomClickNum());
    }

    public void b() {
        this.h = false;
        ScrollClickView scrollClickView = this.f4711a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
        this.g = null;
        this.d = null;
        this.f4711a = null;
        this.i = 200;
    }

    public void a(int i) {
        this.e = i;
    }

    public static Pair<Integer, Boolean> c(int i) {
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        if (iRandom <= i) {
            return new Pair<>(Integer.valueOf(iRandom), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(iRandom), Boolean.FALSE);
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.g != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.h);
        aa.a("ScrollClickUtil", sb.toString());
        if (this.g == null || this.h) {
            return;
        }
        aa.a("ScrollClickUtil", "callback onShakeHappened()");
        this.g.b("100", "200", "105", "206", "100", "200", "105", "206");
        this.h = true;
        ScrollClickView scrollClickView = this.f4711a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
    }

    public View a(final int i, final int i2, AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean) {
        String downloadDetails;
        int i3;
        int i4;
        aa.a("ScrollClickUtil", "enter getScrollClick");
        if (this.d == null || scrollClickPositionBean == null) {
            return null;
        }
        ScrollClickView scrollClickView = new ScrollClickView(this.d);
        this.f4711a = scrollClickView;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = j;
            if (scrollClickBean != null) {
                scrollClickView.setScrollDirection(scrollClickBean.getScrollDirection());
                this.f4711a.setTitleText(j.getTitle());
                this.f4711a.setTitleFont(j.getTitleFont());
                if (!this.k.booleanValue()) {
                    downloadDetails = j.getDetails();
                } else {
                    downloadDetails = j.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "下载应用";
                    }
                }
                this.f4711a.setDetailText(downloadDetails);
                this.f4711a.setDetailsFont(j.getDetailsFont());
                AdSpacesBean.BuyerBean.ScrollClickPositionBean position = j.getPosition();
                String width = position.getWidth();
                String height = position.getHeight();
                if (width.endsWith("%")) {
                    i3 = (Integer.parseInt(width.substring(0, width.indexOf("%"))) * i) / 100;
                } else {
                    i3 = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                } else {
                    i4 = Integer.parseInt(height);
                }
                this.f4711a.setHandWidth(i3);
                this.f4711a.setScrollbarHeight(i4);
                this.f4711a.buildRealView();
            }
            String top = scrollClickPositionBean.getTop();
            String centerX = scrollClickPositionBean.getCenterX();
            if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                centerX = "50%";
            }
            if (TextUtils.isEmpty(top) || "0".equals(top)) {
                top = "50%";
            }
            ap.i(this.d);
            if (centerX.endsWith("%")) {
                this.b = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
            } else {
                this.b = Integer.parseInt(centerX);
            }
            if (top.endsWith("%")) {
                this.c = (Integer.parseInt(top.substring(0, top.indexOf("%"))) * i2) / 100;
            } else {
                this.c = Integer.parseInt(top);
            }
            this.b = ap.a(this.d, this.b);
            this.c = ap.a(this.d, this.c);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            aa.a("ScrollClickUtil", "topInt = " + this.c + ",centerXInt = " + this.b + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.f4711a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.tool.aj.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ScrollClickView scrollClickView2 = aj.this.f4711a;
                    if (scrollClickView2 == null) {
                        return;
                    }
                    scrollClickView2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth = aj.this.f4711a.getMeasuredWidth();
                    aj ajVar = aj.this;
                    if (ajVar.c == 0) {
                        ajVar.c = ap.a(ajVar.d, i2) / 2;
                    }
                    aj ajVar2 = aj.this;
                    if (ajVar2.b == 0) {
                        ajVar2.b = ap.a(ajVar2.d, i) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = layoutParams;
                    aj ajVar3 = aj.this;
                    layoutParams2.topMargin = ajVar3.c;
                    layoutParams2.leftMargin = ajVar3.b - (measuredWidth / 2);
                    ajVar3.f4711a.setLayoutParams(layoutParams2);
                    aa.a("ScrollClickUtil", "topMargin = " + layoutParams.topMargin + ",leftMargin = " + layoutParams.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.f4711a.setLayoutParams(layoutParams);
            this.f4711a.postDelayed(new Runnable() { // from class: com.beizi.fusion.tool.aj.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ScrollClickView scrollClickView2 = aj.this.f4711a;
                        if (scrollClickView2 != null) {
                            scrollClickView2.startAnim();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 10L);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.f4711a;
    }

    public void a(Boolean bool) {
        this.k = bool;
    }
}
