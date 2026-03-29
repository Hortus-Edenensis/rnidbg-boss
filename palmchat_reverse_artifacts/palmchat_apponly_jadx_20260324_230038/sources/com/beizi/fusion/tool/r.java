package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.EulerAngleView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r {
    private static SensorManager j;
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4744a;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean b;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean c;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean d;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean e;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f;
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean g;
    private Sensor k;
    private String o;
    private String p;
    private String q;
    private float t;
    private EulerAngleView u;
    private a v;
    private String x;
    private Boolean y;
    private float z;
    private float h = 1.0E-9f;
    private float[] i = new float[3];
    private double l = 0.0d;
    private double m = 0.0d;
    private double n = 0.0d;
    private boolean r = false;
    private int s = 0;
    private boolean w = false;
    private SensorEventListener F = new SensorEventListener() { // from class: com.beizi.fusion.tool.r.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                r.this.a(sensorEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public r(Context context, String str, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2) {
        this.x = null;
        j = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        this.f4744a = context;
        this.b = eulerAngleViewBean;
        this.c = eulerAngleViewBean2;
        this.x = "splash_cool_" + str;
        c();
        d();
    }

    private void d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.d;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.d.getPassivationTime();
                final double angle = 0.0d;
                final double angle2 = 0.0d;
                final double angle3 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.l = eulerAngleRuleBean.getAngle();
                            } else {
                                this.l = eulerAngleRuleBean.getPangle();
                            }
                            angle = eulerAngleRuleBean.getAngle();
                            this.o = eulerAngleRuleBean.getDirection();
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.m = eulerAngleRuleBean.getAngle();
                            } else {
                                this.m = eulerAngleRuleBean.getPangle();
                            }
                            angle2 = eulerAngleRuleBean.getAngle();
                            this.p = eulerAngleRuleBean.getDirection();
                        } else if ("z".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.n = eulerAngleRuleBean.getAngle();
                            } else {
                                this.n = eulerAngleRuleBean.getPangle();
                            }
                            angle3 = eulerAngleRuleBean.getAngle();
                            this.q = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.tool.r.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                r.this.r = true;
                                r.this.t = 0.0f;
                                r.this.i[0] = 0.0f;
                                r.this.i[1] = 0.0f;
                                r.this.i[2] = 0.0f;
                                r.this.l = angle;
                                r.this.m = angle2;
                                r.this.n = angle3;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, af.b(passivationTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean e() {
        try {
            if (this.l > 0.0d) {
                if ("2".equals(this.o)) {
                    if (this.i[0] > 0.0f && Math.abs(r1) >= this.l) {
                        return true;
                    }
                } else if ("1".equals(this.o)) {
                    if (this.i[0] < 0.0f && Math.abs(r1) >= this.l) {
                        return true;
                    }
                } else if ("0".equals(this.o)) {
                    if (Math.abs(this.i[0]) >= this.l) {
                        return true;
                    }
                } else if ("3".equals(this.o) && Math.abs(this.z) >= this.l && Math.abs(this.C) > this.l) {
                    return true;
                }
            }
            if (this.m > 0.0d) {
                if ("2".equals(this.p)) {
                    if (this.i[1] < 0.0f && Math.abs(r1) >= this.m) {
                        return true;
                    }
                } else if ("1".equals(this.p)) {
                    if (this.i[1] > 0.0f && Math.abs(r1) >= this.m) {
                        return true;
                    }
                } else if ("0".equals(this.p)) {
                    if (Math.abs(this.i[1]) >= this.m) {
                        return true;
                    }
                } else if ("3".equals(this.p) && Math.abs(this.A) >= this.m && Math.abs(this.D) > this.m) {
                    return true;
                }
            }
            if (this.n > 0.0d) {
                if ("2".equals(this.q)) {
                    if (this.i[2] > 0.0f && Math.abs(r1) >= this.n) {
                        return true;
                    }
                } else if ("1".equals(this.q)) {
                    if (this.i[2] < 0.0f && Math.abs(r1) >= this.n) {
                        return true;
                    }
                } else if ("0".equals(this.q)) {
                    if (Math.abs(this.i[2]) >= this.n) {
                        return true;
                    }
                } else if ("3".equals(this.q) && Math.abs(this.B) >= this.n && Math.abs(this.E) > this.n) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void f() {
        try {
            if (this.v == null || this.w || !ar.b(this.u)) {
                return;
            }
            this.w = true;
            if (this.r && this.f != null) {
                an.a(this.f4744a, this.x, (Object) Long.valueOf(System.currentTimeMillis()));
            }
            this.v.a();
            b();
            aa.a("ShakeUtil", "onEulerAngleHappened");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(long j2) {
        try {
            return System.currentTimeMillis() - ap.p(this.f4744a).longValue() < j2;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = this.b;
            if (eulerAngleViewBean != null) {
                this.f = eulerAngleViewBean.getCoolRule();
            }
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.c;
            if (eulerAngleViewBean2 != null) {
                this.e = eulerAngleViewBean2.getNomalRule();
                this.g = this.c.getRender();
            } else {
                AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.b;
                if (eulerAngleViewBean3 != null) {
                    this.e = eulerAngleViewBean3.getNomalRule();
                    this.g = this.b.getRender();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f;
            if (eulerAngleViewRuleBean == null) {
                this.r = true;
                this.d = this.e;
            } else if (a(eulerAngleViewRuleBean.getCoolTime())) {
                this.r = false;
                this.d = this.f;
            } else if (b(this.f.getUserProtectTime())) {
                this.r = false;
                this.d = this.f;
            } else {
                this.r = true;
                this.d = this.e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        try {
            aa.a("BeiZis", "enter unRegisterListener");
            SensorManager sensorManager = j;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.F);
            }
            EulerAngleView eulerAngleView = this.u;
            if (eulerAngleView != null) {
                eulerAngleView.onDestroy();
            }
            this.u = null;
            this.f4744a = null;
            this.v = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(long j2) {
        try {
            long jLongValue = ((Long) an.b(this.f4744a, this.x, 0L)).longValue();
            if (jLongValue != 0) {
                return System.currentTimeMillis() - jLongValue < j2;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a() {
        try {
            SensorManager sensorManager = j;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.k = defaultSensor;
                if (defaultSensor != null) {
                    j.registerListener(this.F, defaultSensor, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        String centerX;
        String centerY;
        String width;
        String height;
        int iA;
        int iA2;
        int i3;
        int i4;
        try {
            if (this.f4744a != null && (eulerAngleRenderBean = this.g) != null && viewGroup != null) {
                if (eulerAngleRenderBean != null) {
                    centerX = eulerAngleRenderBean.getCenterX();
                    centerY = this.g.getCenterY();
                    width = this.g.getWidth();
                    height = this.g.getHeight();
                } else {
                    centerX = null;
                    centerY = null;
                    width = null;
                    height = null;
                }
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "85%";
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = "50%";
                }
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = "120";
                }
                if (TextUtils.isEmpty(height) || "0".equals(height)) {
                    height = "120";
                }
                float fI = ap.i(this.f4744a);
                int i5 = 100;
                if (centerX.endsWith("%")) {
                    iA = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
                } else {
                    iA = Integer.parseInt(centerX);
                }
                if (centerY.endsWith("%")) {
                    iA2 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
                } else {
                    iA2 = Integer.parseInt(centerY);
                }
                if (width.endsWith("%")) {
                    i3 = (((int) fI) * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    i3 = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                } else {
                    i4 = Integer.parseInt(height);
                }
                if (i3 == 0) {
                    i3 = 100;
                }
                if (i4 != 0) {
                    i5 = i4;
                }
                if (iA2 == 0) {
                    iA2 = ap.a(this.f4744a, i2) / 2;
                }
                if (iA == 0) {
                    iA = ap.a(this.f4744a, i) / 2;
                }
                int iA3 = ap.a(this.f4744a, i3);
                int iA4 = ap.a(this.f4744a, i5);
                int iA5 = ap.a(this.f4744a, iA);
                int iA6 = ap.a(this.f4744a, iA2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                EulerAngleView eulerAngleView = new EulerAngleView(this.f4744a);
                this.u = eulerAngleView;
                eulerAngleView.setEulerAngleViewRuleBean(this.d);
                this.u.setEulerAngleRenderBean(this.g);
                this.u.setAnimationViewWidthAndHeight(iA3, iA4);
                this.u.setDownloadApp(this.y);
                this.u.buildEulerAngleView();
                this.u.measure(0, 0);
                int measuredWidth = this.u.getMeasuredWidth();
                int measuredHeight = this.u.getMeasuredHeight();
                aa.a("BeiZis", "centerYInt = " + iA6 + ",centerXInt = " + iA5 + ",adWidthDp = " + i + ",adHeightDp = " + i2 + ",widthInt = " + iA3 + ",heightInt = " + iA4 + ",viewWidth = " + measuredWidth + ",viewHeight = " + measuredHeight);
                layoutParams.topMargin = iA6 - (measuredHeight / 2);
                layoutParams.leftMargin = iA5 - (measuredWidth / 2);
                viewGroup.addView(this.u, layoutParams);
                this.u.startContinuousRotations();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.v = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.w) {
                    return;
                }
                Sensor sensor = sensorEvent.sensor;
                float[] fArr = sensorEvent.values;
                int type = sensor.getType();
                if (fArr != null && type == 4) {
                    float f = this.t;
                    if (f != 0.0f) {
                        float f2 = fArr[0];
                        float f3 = fArr[1];
                        float f4 = fArr[2];
                        float f5 = (sensorEvent.timestamp - f) * this.h;
                        float[] fArr2 = this.i;
                        fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                        float[] fArr3 = this.i;
                        fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                        float[] fArr4 = this.i;
                        fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                        float[] fArr5 = this.i;
                        float f6 = fArr5[0];
                        if (f6 > 0.0f) {
                            if (f6 > this.C) {
                                this.C = f6;
                            }
                        } else if (f6 < this.z) {
                            this.z = f6;
                        }
                        float f7 = fArr5[1];
                        if (f7 > 0.0f) {
                            if (f7 > this.D) {
                                this.D = f7;
                            }
                        } else if (f7 < this.A) {
                            this.A = f7;
                        }
                        float f8 = fArr5[2];
                        if (f8 > 0.0f) {
                            if (f8 > this.E) {
                                this.E = f8;
                            }
                        } else if (f8 < this.B) {
                            this.B = f8;
                        }
                        EulerAngleView eulerAngleView = this.u;
                        if (eulerAngleView != null) {
                            eulerAngleView.setAngle(this.l, this.m, this.n);
                            EulerAngleView eulerAngleView2 = this.u;
                            float[] fArr6 = this.i;
                            eulerAngleView2.setCurrentProgress(fArr6[0], fArr6[1], fArr6[2]);
                        }
                        aa.a("ShakeUtil", "rotate  x: " + String.format("%.4f", Float.valueOf(this.i[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.i[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.i[2])) + ",x : " + this.l + ",y : " + this.m + ",z : " + this.n);
                        if (e()) {
                            f();
                        }
                    }
                    this.t = sensorEvent.timestamp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Boolean bool) {
        this.y = bool;
    }
}
