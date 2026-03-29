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
public class e {
    private long A;
    private String D;
    private AnimatorSet G;
    private String H;
    private boolean I;
    private int K;
    private Sensor L;
    private float M;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private boolean V;
    private boolean W;
    private long X;
    private boolean Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4341a;
    private AdSpacesBean.BuyerBean.ShakeViewBean b;
    private AdSpacesBean.BuyerBean.ShakeViewBean c;
    private AdSpacesBean.BuyerBean.AliaseShakeViewBean d;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean e;
    private AdSpacesBean.BuyerBean.PercentPositionBean f;
    private SensorManager l;
    private Sensor m;
    private double s;
    private double t;
    private double u;
    private int v;
    private int w;
    private double g = 9.8d;
    private int h = -100;
    private int i = 0;
    private int j = 1;
    private int k = 2;
    private a n = null;
    private float o = -100;
    private float p = -100;
    private float q = -100;
    private int r = 0;
    private int x = 0;
    private int y = 0;
    private boolean z = true;
    private boolean B = false;
    private boolean C = false;
    private int E = 80;
    private float F = 30.0f;
    private final SensorEventListener J = new SensorEventListener() { // from class: com.beizi.ad.a.a.e.4
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null) {
                return;
            }
            int type = sensor.getType();
            if (type == 1) {
                e.this.a(sensorEvent);
            } else if (type == 4) {
                e.this.b(sensorEvent);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private float N = 1.0E-9f;
    private float[] O = new float[3];

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public e(Context context, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, String str, String str2) {
        this.D = null;
        this.I = false;
        try {
            this.f4341a = context;
            this.b = shakeViewBean;
            this.D = "beizi_cool_" + str;
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(shakeViewBean.getOrderData(), str2);
            if (orderDataShakeViewBeanA != null && orderDataShakeViewBeanA.getShakeView() != null) {
                this.c = orderDataShakeViewBeanA.getShakeView();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                this.e = shakeViewBean2.getCoolShakeView();
                this.K = shakeViewBean.getRegulatoryAngle();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.c;
            if (shakeViewBean3 != null) {
                this.d = shakeViewBean3.getAliaseShakeView();
                this.f = this.c.getPosition();
                List<String> imageURL = this.c.getImageURL();
                if (imageURL != null && imageURL.size() > 0) {
                    this.H = imageURL.get(0);
                }
                this.K = this.c.getRegulatoryAngle();
            } else {
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean4 = this.b;
                if (shakeViewBean4 != null) {
                    this.d = shakeViewBean4.getAliaseShakeView();
                    this.f = this.b.getPosition();
                    List<String> imageURL2 = this.b.getImageURL();
                    if (imageURL2 != null && imageURL2.size() > 0) {
                        this.H = imageURL2.get(0);
                    }
                }
            }
            if (!f()) {
                this.I = false;
                return;
            }
            this.I = true;
            i();
            o();
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean f() {
        double shakeStartAmplitude;
        double shakeEndAmplitude;
        int shakeCount;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.c;
        if (shakeViewBean != null) {
            shakeStartAmplitude = shakeViewBean.getShakeStartAmplitude();
            shakeEndAmplitude = this.c.getShakeEndAmplitude();
            shakeCount = this.c.getShakeCount();
        } else {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                shakeStartAmplitude = shakeViewBean2.getShakeStartAmplitude();
                shakeEndAmplitude = this.b.getShakeEndAmplitude();
                shakeCount = this.b.getShakeCount();
            } else {
                shakeStartAmplitude = 0.0d;
                shakeEndAmplitude = 0.0d;
                shakeCount = 0;
            }
        }
        return shakeStartAmplitude > 0.0d && shakeEndAmplitude > 0.0d && shakeCount > 0;
    }

    private boolean g() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.e;
            if (coolShakeViewBean == null) {
                return false;
            }
            if (coolShakeViewBean.getShakeCount() > 0) {
                return true;
            }
            if (this.e.getRotatCount() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean = this.d;
            if (aliaseShakeViewBean != null && aliaseShakeViewBean != null && aliaseShakeViewBean.getPassivationTime() > 0) {
                if (this.d.getShakeCount() > 0) {
                    return true;
                }
                if (this.d.getRotatCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void i() {
        try {
            q();
            if (!n() && !m()) {
                this.B = false;
            } else if (g()) {
                this.B = true;
            } else {
                this.B = false;
            }
            if (this.B) {
                l();
            } else if (h()) {
                k();
            } else {
                j();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            m.a("ShakeUtil", "setShakeSensitivityNormal");
            q();
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.c;
            if (shakeViewBean != null) {
                b(shakeViewBean.getShakeCount());
                a(this.c.getShakeStartAmplitude());
                b(this.c.getShakeEndAmplitude());
                c(this.c.getRotatAmplitude());
                c(this.c.getRotatCount());
                return;
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                b(shakeViewBean2.getShakeCount());
                a(this.b.getShakeStartAmplitude());
                b(this.b.getShakeEndAmplitude());
                c(this.b.getRotatAmplitude());
                c(this.b.getRotatCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        try {
            if (this.d == null) {
                return;
            }
            m.a("ShakeUtil", "setShakeSensitivityAliase");
            b(this.d.getShakeCount());
            a(this.d.getShakeStartAmplitude());
            b(this.d.getShakeEndAmplitude());
            c(this.d.getRotatAmplitude());
            c(this.d.getRotatCount());
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.j();
                }
            }, a(this.d.getPassivationTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l() {
        try {
            if (this.e == null) {
                return;
            }
            m.a("ShakeUtil", "setShakeSensitivityCool");
            b(this.e.getShakeCount());
            a(this.e.getShakeStartAmplitude());
            b(this.e.getShakeEndAmplitude());
            c(this.e.getRotatAmplitude());
            c(this.e.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean m() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.e;
            if (coolShakeViewBean == null) {
                return false;
            }
            long coolTime = coolShakeViewBean.getCoolTime();
            long jLongValue = ((Long) l.d(this.f4341a, this.D, 0L)).longValue();
            if (jLongValue != 0) {
                return System.currentTimeMillis() - jLongValue < coolTime;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean n() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.e;
            if (coolShakeViewBean == null) {
                return false;
            }
            return System.currentTimeMillis() - q.a(this.f4341a) < coolShakeViewBean.getUserProtectTime();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void o() {
        try {
            m.a("ShakeUtil", "registerShakeListener");
            this.C = true;
            q();
            if (this.l == null) {
                this.l = (SensorManager) this.f4341a.getApplicationContext().getSystemService("sensor");
            }
            if (this.m == null) {
                this.m = this.l.getDefaultSensor(1);
            }
            this.l.registerListener(this.J, this.m, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void p() {
        try {
            m.a("ShakeUtil", "unRegisterShakeListener");
            this.C = false;
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.J);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void q() {
        this.x = 0;
        this.y = 0;
        int i = this.h;
        this.o = i;
        this.p = i;
        this.q = i;
        this.r = this.i;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.M = 0.0f;
        this.W = false;
        if (this.K > 0) {
            this.V = false;
        }
        this.Y = false;
    }

    private synchronized void r() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.n != null && this.z) {
            if (this.Y) {
                return;
            }
            this.Y = true;
            m.a("ShakeUtil", "callBackResult");
            b();
            if (!this.B) {
                l.c(this.f4341a, this.D, Long.valueOf(System.currentTimeMillis()));
            }
            this.n.a();
        }
    }

    private void s() {
        try {
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.L = defaultSensor;
                if (defaultSensor != null) {
                    this.l.registerListener(this.J, defaultSensor, 1);
                } else {
                    this.V = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String c() {
        return this.H;
    }

    public void d() {
        try {
            p();
            this.b = null;
            this.c = null;
            this.e = null;
            this.d = null;
            this.f = null;
            this.f4341a = null;
            this.l = null;
            this.m = null;
            this.n = null;
            AnimatorSet animatorSet = this.G;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.G = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        if (this.K > 0) {
            s();
        } else {
            this.V = true;
        }
    }

    public void c(double d) {
        this.u = d;
    }

    public void a() {
        try {
            if (!this.C && this.I) {
                this.z = true;
                i();
                o();
                e();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            this.z = false;
            p();
            q();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(int i) {
        this.w = i;
    }

    private int[] b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean;
        int i;
        int i2;
        int i3;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                percentPositionBean = this.f;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (percentPositionBean != null) {
                String centerX = percentPositionBean.getCenterX();
                String centerY = this.f.getCenterY();
                String width = this.f.getWidth();
                String height = this.f.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "10";
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = "10";
                }
                viewGroup.measure(0, 0);
                int iB = t.b(this.f4341a, viewGroup.getMeasuredWidth());
                int iB2 = t.b(this.f4341a, viewGroup.getMeasuredHeight());
                if (iB <= 0) {
                    iB = q.h(this.f4341a);
                }
                m.a("ShakeUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + x.aQ + viewGroup.getLayoutParams().width + x.aQ + viewGroup.getLayoutParams().height);
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
                int iA = t.a(this.f4341a, i3);
                int iA2 = t.a(this.f4341a, i4);
                int iA3 = t.a(this.f4341a, i);
                int iA4 = t.a(this.f4341a, i2);
                iArr[0] = iA;
                iArr[1] = iA2;
                if (iA3 > 0) {
                    iArr[2] = iA3;
                }
                if (iA4 > 0) {
                    iArr[3] = iA4;
                }
                m.a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + x.aQ + centerX + x.aQ + centerY);
                return iArr;
            }
        }
        int iA5 = t.a(this.f4341a, 20.0f);
        int iA6 = t.a(this.f4341a, 10.0f);
        iArr[0] = iA5;
        iArr[1] = iA5;
        iArr[2] = iA6;
        iArr[3] = iA6;
        return iArr;
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f4341a != null && this.I) {
                    final ImageView imageView = new ImageView(this.f4341a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                    if (!TextUtils.isEmpty(this.H)) {
                        h.a(this.f4341a).b(this.H, new h.a() { // from class: com.beizi.ad.a.a.e.2
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

    public void b(double d) {
        this.t = d;
    }

    public void b(int i) {
        this.v = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.Y && System.currentTimeMillis() - this.X >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.X = System.currentTimeMillis();
                        float f = this.M;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.N;
                            float[] fArr2 = this.O;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.O;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.O;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.O;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.S) {
                                    this.S = f6;
                                }
                            } else if (f6 < this.P) {
                                this.P = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.T) {
                                    this.T = f7;
                                }
                            } else if (f7 < this.Q) {
                                this.Q = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.U) {
                                    this.U = f8;
                                }
                            } else if (f8 < this.R) {
                                this.R = f8;
                            }
                            if ((Math.abs(this.P) > this.K && Math.abs(this.S) > this.K) || ((Math.abs(this.Q) > this.K && Math.abs(this.T) > this.K) || (Math.abs(this.R) > this.K && Math.abs(this.U) > this.K))) {
                                m.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.P)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.Q)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.U)));
                                this.V = true;
                            }
                            if (this.W && this.V) {
                                r();
                            }
                        }
                        this.M = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, this.F);
            a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, this.F, 0.0f);
            a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, -this.F);
            a(imageView, arrayList, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -this.F, 0.0f);
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.G = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.e.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (e.this.G != null) {
                                e.this.G.start();
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
                this.G.playSequentially(arrayList);
                this.G.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(ImageView imageView, List<Animator> list, String str, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, str, f, f2);
            objectAnimatorOfFloat.setDuration(this.E);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a(int i) {
        return (int) ((Math.random() * ((double) i)) + 1.0d);
    }

    public void a(double d) {
        this.s = d;
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    private double a(float f, float f2, float f3) {
        try {
            return Math.sqrt(Math.pow(((double) f) / this.g, 2.0d) + Math.pow(((double) f2) / this.g, 2.0d) + Math.pow(((double) f3) / this.g, 2.0d));
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        float[] fArr;
        try {
            if (System.currentTimeMillis() - this.A >= 100 && sensorEvent != null && this.z && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
                this.A = System.currentTimeMillis();
                double dA = a(fArr[0], fArr[1], fArr[2]);
                if (dA > this.s) {
                    this.r = this.j;
                } else if (dA <= this.t && this.r == this.j) {
                    this.r = this.k;
                    this.x++;
                }
                int i = this.v;
                if (i <= 0 || this.x < i) {
                    return;
                }
                this.W = true;
                m.b("ShakeUtil", " current: " + String.format("%.4f", Double.valueOf(dA)) + ", execute: " + this.x + ", count: " + this.v + "_" + this.w + ", shake: " + this.s + "_" + this.t);
                if (this.W && this.V) {
                    r();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
