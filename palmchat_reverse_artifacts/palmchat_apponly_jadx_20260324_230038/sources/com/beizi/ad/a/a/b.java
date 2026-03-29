package com.beizi.ad.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4332a;
    private AdSpacesBean.BuyerBean.FullScreenClickBean b;
    private AdSpacesBean.BuyerBean.FullScreenClickBean c;
    private int e;
    private a d = null;
    private boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public b(Context context, AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean, String str) {
        this.f4332a = context;
        this.b = fullScreenClickBean;
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanA = a(fullScreenClickBean.getOrderData(), str);
        if (orderDataFullScreenClickBeanA != null && orderDataFullScreenClickBeanA.getFullScreenClick() != null) {
            this.c = orderDataFullScreenClickBeanA.getFullScreenClick();
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean2 = this.c;
        if (fullScreenClickBean2 != null) {
            this.e = fullScreenClickBean2.getRandomClickNum();
            return;
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean3 = this.b;
        if (fullScreenClickBean3 != null) {
            this.e = fullScreenClickBean3.getRandomClickNum();
        }
    }

    public void a(View view, final a aVar) {
        if (view == null || aVar == null || !a(this.e)) {
            return;
        }
        this.f = true;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f4333a;
            float b;
            float c;
            float d;
            float e;
            float f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a aVar2;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f4333a = motionEvent.getX();
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
                } else if (Math.abs(this.e - this.f4333a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && (aVar2 = aVar) != null) {
                    aVar2.a(String.valueOf(this.f4333a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f4333a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
                }
                return true;
            }
        });
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.f4332a = null;
    }

    public static boolean a(int i) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i;
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    public boolean a() {
        return this.f;
    }
}
