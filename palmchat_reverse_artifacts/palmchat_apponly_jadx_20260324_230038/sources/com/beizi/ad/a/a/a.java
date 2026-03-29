package com.beizi.ad.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.l;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    private static final String g = "a";
    private static SensorManager q;
    private float A;
    private InterfaceC0113a B;
    private String E;
    private AnimatorSet J;
    private boolean K;
    private String L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private Context h;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean i;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean j;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean k;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean l;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean m;
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean n;
    private Sensor r;
    private String v;
    private String w;
    private String x;
    private float o = 1.0E-9f;
    private float[] p = new float[3];
    private double s = 0.0d;
    private double t = 0.0d;
    private double u = 0.0d;
    private boolean y = false;
    private int z = 0;
    private boolean C = true;
    private boolean D = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f4327a = "x";
    String b = "y";
    String c = "z";
    String d = "0";
    String e = "1";
    String f = "2";
    private int F = 350;
    private float G = 60.0f;
    private float H = 60.0f;
    private float I = 30.0f;
    private SensorEventListener S = new SensorEventListener() { // from class: com.beizi.ad.a.a.a.4
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                a.this.a(sensorEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: renamed from: com.beizi.ad.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0113a {
        void a();
    }

    public a(Context context, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, String str, String str2) {
        this.E = null;
        this.K = false;
        this.h = context;
        this.i = eulerAngleViewBean;
        this.E = "beizi_cool_" + str;
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanA = a(this.i.getOrderData(), str2);
        if (orderDataEulerAngleViewBeanA != null && orderDataEulerAngleViewBeanA.getEulerAngleRule() != null) {
            this.j = orderDataEulerAngleViewBeanA.getEulerAngleRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.i;
        if (eulerAngleViewBean2 != null) {
            this.m = eulerAngleViewBean2.getCoolRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.j;
        if (eulerAngleViewBean3 != null) {
            this.l = eulerAngleViewBean3.getNomalRule();
            this.n = this.j.getRender();
        } else {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean4 = this.i;
            if (eulerAngleViewBean4 != null) {
                this.l = eulerAngleViewBean4.getNomalRule();
                this.n = this.i.getRender();
            }
        }
        if (!e()) {
            this.K = false;
            return;
        }
        this.K = true;
        f();
        l();
    }

    private boolean e() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.l;
        if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
            for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                if (eulerAngleRuleBean != null) {
                    String axis = eulerAngleRuleBean.getAxis();
                    double angle = eulerAngleRuleBean.getAngle();
                    if (!TextUtils.isEmpty(axis) && angle > 0.0d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void f() {
        try {
            if (!j() && !i()) {
                this.y = false;
            } else if (h()) {
                this.y = true;
            } else {
                this.y = false;
            }
            if (this.y) {
                this.k = this.m;
                g();
            } else {
                this.k = this.l;
                g();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.k;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.k.getPassivationTime();
                final double angle = 0.0d;
                final double angle2 = 0.0d;
                final double angle3 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if (this.f4327a.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.s = eulerAngleRuleBean.getAngle();
                            } else {
                                this.s = eulerAngleRuleBean.getPangle();
                            }
                            angle = eulerAngleRuleBean.getAngle();
                            this.v = eulerAngleRuleBean.getDirection();
                        } else if (this.b.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.t = eulerAngleRuleBean.getAngle();
                            } else {
                                this.t = eulerAngleRuleBean.getPangle();
                            }
                            angle2 = eulerAngleRuleBean.getAngle();
                            this.w = eulerAngleRuleBean.getDirection();
                        } else if (this.c.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.u = eulerAngleRuleBean.getAngle();
                            } else {
                                this.u = eulerAngleRuleBean.getPangle();
                            }
                            angle3 = eulerAngleRuleBean.getAngle();
                            this.x = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.A = 0.0f;
                                a.this.p[0] = 0.0f;
                                a.this.p[1] = 0.0f;
                                a.this.p[2] = 0.0f;
                                a.this.s = angle;
                                a.this.t = angle2;
                                a.this.u = angle3;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, a(passivationTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.m;
            if (eulerAngleViewRuleBean != null && eulerAngleViewRuleBean != null && eulerAngleViewRuleBean.getRules() != null && this.m.getRules().size() > 0) {
                if (this.m.getStyle() != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean i() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            long coolTime = eulerAngleViewRuleBean.getCoolTime();
            long jLongValue = ((Long) l.d(this.h, this.E, 0L)).longValue();
            if (jLongValue != 0) {
                return System.currentTimeMillis() - jLongValue < coolTime;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean j() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            return System.currentTimeMillis() - q.a(this.h) < eulerAngleViewRuleBean.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void k() {
        this.A = 0.0f;
        float[] fArr = this.p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
    }

    private void l() {
        try {
            if (q == null) {
                q = (SensorManager) this.h.getApplicationContext().getSystemService("sensor");
            }
            if (this.r == null) {
                this.r = q.getDefaultSensor(4);
            }
            q.registerListener(this.S, this.r, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m() {
        try {
            m.a(g, "enter unRegisterListener");
            SensorManager sensorManager = q;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.S);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean n() {
        try {
            if (this.s > 0.0d) {
                if (this.f.equals(this.v)) {
                    if (this.p[0] > 0.0f && Math.abs(r1) >= this.s) {
                        return true;
                    }
                } else if (this.e.equals(this.v)) {
                    if (this.p[0] < 0.0f && Math.abs(r1) >= this.s) {
                        return true;
                    }
                } else if (this.d.equals(this.v)) {
                    if (Math.abs(this.p[0]) >= this.s) {
                        return true;
                    }
                } else if ("3".equals(this.v) && Math.abs(this.M) >= this.s && Math.abs(this.P) > this.s) {
                    return true;
                }
            }
            if (this.t > 0.0d) {
                if (this.f.equals(this.w)) {
                    if (this.p[1] < 0.0f && Math.abs(r1) >= this.t) {
                        return true;
                    }
                } else if (this.e.equals(this.w)) {
                    if (this.p[1] > 0.0f && Math.abs(r1) >= this.t) {
                        return true;
                    }
                } else if (this.d.equals(this.w)) {
                    if (Math.abs(this.p[1]) >= this.t) {
                        return true;
                    }
                } else if ("3".equals(this.w) && Math.abs(this.N) >= this.t && Math.abs(this.Q) > this.t) {
                    return true;
                }
            }
            if (this.u > 0.0d) {
                if (this.f.equals(this.x)) {
                    if (this.p[2] > 0.0f && Math.abs(r1) >= this.u) {
                        return true;
                    }
                } else if (this.e.equals(this.x)) {
                    if (this.p[2] < 0.0f && Math.abs(r1) >= this.u) {
                        return true;
                    }
                } else if (this.d.equals(this.x)) {
                    if (Math.abs(this.p[2]) >= this.u) {
                        return true;
                    }
                } else if ("3".equals(this.x) && Math.abs(this.O) >= this.u && Math.abs(this.R) > this.u) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void o() {
        try {
            if (this.B != null && this.C) {
                m.a(g, "onEulerAngleHappened");
                b();
                if (!this.y) {
                    l.c(this.h, this.E, Long.valueOf(System.currentTimeMillis()));
                }
                this.B.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            m();
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.h = null;
            this.B = null;
            q = null;
            this.r = null;
            AnimatorSet animatorSet = this.J;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.J = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String c() {
        return this.L;
    }

    public void b() {
        this.C = false;
        k();
        m();
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        int i;
        int i2;
        int i3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                eulerAngleRenderBean = this.n;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (eulerAngleRenderBean != null) {
                String centerX = eulerAngleRenderBean.getCenterX();
                String centerY = this.n.getCenterY();
                String width = this.n.getWidth();
                String height = this.n.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "10";
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = "10";
                }
                viewGroup.measure(0, 0);
                int iB = t.b(this.h, viewGroup.getMeasuredWidth());
                int iB2 = t.b(this.h, viewGroup.getMeasuredHeight());
                if (iB <= 0) {
                    iB = q.h(this.h);
                }
                String str = g;
                m.a(str, "position containerWidth:" + iB + ";containerHeight:" + iB2 + x.aQ + viewGroup.getLayoutParams().width + x.aQ + viewGroup.getLayoutParams().height);
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
                if (centerY.endsWith("%")) {
                    i2 = (iB2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100;
                } else {
                    i2 = !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
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
                int iA = t.a(this.h, i3);
                int iA2 = t.a(this.h, i4);
                int iA3 = t.a(this.h, i);
                int iA4 = t.a(this.h, i2);
                iArr[0] = iA;
                iArr[1] = iA2;
                if (iA3 > 0) {
                    iArr[2] = iA3;
                }
                if (iA4 > 0) {
                    iArr[3] = iA4;
                }
                m.a(str, "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + x.aQ + centerX + x.aQ + centerY);
                return iArr;
            }
        }
        int iA5 = t.a(this.h, 20.0f);
        int iA6 = t.a(this.h, 10.0f);
        iArr[0] = iA5;
        iArr[1] = iA5;
        iArr[2] = iA6;
        iArr[3] = iA6;
        return iArr;
    }

    public int a(int i) {
        return (int) ((Math.random() * ((double) i)) + 1.0d);
    }

    public void a() {
        if (this.D || !this.K) {
            return;
        }
        this.C = true;
        k();
        f();
        l();
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.B = interfaceC0113a;
    }

    public void a(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleStyleBean style;
        List<String> imgs;
        if (viewGroup != null) {
            try {
                if (this.h != null && this.K) {
                    final ImageView imageView = new ImageView(this.h);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                    AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.k;
                    if (eulerAngleViewRuleBean != null && (style = eulerAngleViewRuleBean.getStyle()) != null && (imgs = style.getImgs()) != null && imgs.size() > 0) {
                        this.L = imgs.get(0);
                    }
                    if (!TextUtils.isEmpty(this.L)) {
                        h.a(this.h).b(this.L, new h.a() { // from class: com.beizi.ad.a.a.a.2
                            @Override // com.beizi.ad.internal.e.h.a
                            public void a() {
                            }

                            @Override // com.beizi.ad.internal.e.h.a
                            public void a(Bitmap bitmap) {
                                try {
                                    ImageView imageView2 = imageView;
                                    if (imageView2 == null || bitmap == null) {
                                        return;
                                    }
                                    imageView2.setImageBitmap(bitmap);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
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
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
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
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
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
                        viewGroup.addView(imageView, layoutParams3);
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
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    a(imageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.v)) {
                if (this.f.equals(this.v)) {
                    a(imageView, arrayList, "rotationX", 0.0f, -this.G);
                    a(imageView, arrayList, "rotationX", -this.G, 0.0f);
                } else if (this.e.equals(this.v)) {
                    a(imageView, arrayList, "rotationX", 0.0f, this.G);
                    a(imageView, arrayList, "rotationX", this.G, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationX", 0.0f, this.G);
                    a(imageView, arrayList, "rotationX", this.G, 0.0f);
                    a(imageView, arrayList, "rotationX", 0.0f, -this.G);
                    a(imageView, arrayList, "rotationX", -this.G, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.w)) {
                if (this.f.equals(this.w)) {
                    a(imageView, arrayList, "rotationY", 0.0f, -this.H);
                    a(imageView, arrayList, "rotationY", -this.H, 0.0f);
                } else if (this.e.equals(this.w)) {
                    a(imageView, arrayList, "rotationY", 0.0f, this.H);
                    a(imageView, arrayList, "rotationY", this.H, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationY", 0.0f, this.H);
                    a(imageView, arrayList, "rotationY", this.H, 0.0f);
                    a(imageView, arrayList, "rotationY", 0.0f, -this.H);
                    a(imageView, arrayList, "rotationY", -this.H, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.x)) {
                if (this.f.equals(this.x)) {
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, -this.I);
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -this.I, 0.0f);
                } else if (this.e.equals(this.x)) {
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, this.I);
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, this.I, 0.0f);
                } else {
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, this.I);
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, this.I, 0.0f);
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, -this.I);
                    a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -this.I, 0.0f);
                }
            }
            if (this.J != null) {
                this.J = null;
            }
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.J = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.a.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (a.this.J != null) {
                                a.this.J.start();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.J.playSequentially(arrayList);
                this.J.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(ImageView imageView, List<Animator> list, String str, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, str, f, f2);
            objectAnimatorOfFloat.setDuration(this.F);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.C) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        float f = this.A;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.o;
                            float[] fArr2 = this.p;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.p;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.p;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.p;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.P) {
                                    this.P = f6;
                                }
                            } else if (f6 < this.M) {
                                this.M = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.Q) {
                                    this.Q = f7;
                                }
                            } else if (f7 < this.N) {
                                this.N = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.R) {
                                    this.R = f8;
                                }
                            } else if (f8 < this.O) {
                                this.O = f8;
                            }
                            m.a(g, "rotate  x: " + String.format("%.4f", Float.valueOf(this.p[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.p[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.p[2])) + ",x : " + this.s + ",y : " + this.t + ",z : " + this.u);
                            if (n()) {
                                o();
                            }
                        }
                        this.A = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
