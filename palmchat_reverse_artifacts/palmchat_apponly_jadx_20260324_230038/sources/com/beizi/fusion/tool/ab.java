package com.beizi.fusion.tool;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ShakeView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ab {
    private static SensorManager b;
    private float A;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private boolean J;
    private boolean K;
    private long L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ShakeView f4695a;
    private Context c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean t;
    private String u;
    private boolean w;
    private int y;
    private Sensor z;
    private int i = 0;
    private int j = 0;
    private float k = -100.0f;
    private float l = -100.0f;
    private float m = -100.0f;
    private int n = 0;
    private a o = null;
    private boolean p = false;
    private int q = 200;
    private View r = null;
    private long s = 0;
    private boolean v = false;
    private final SensorEventListener x = new SensorEventListener() { // from class: com.beizi.fusion.tool.ab.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            try {
                Sensor sensor = sensorEvent.sensor;
                if (sensor == null) {
                    return;
                }
                int type = sensor.getType();
                if (type == 1) {
                    ab.this.a(sensorEvent);
                } else if (type == 4) {
                    ab.this.b(sensorEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private float B = 1.0E-9f;
    private float[] C = new float[3];

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public ab(Context context) {
        this.c = context;
        b = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    private void e() {
        try {
            SensorManager sensorManager = b;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.z = defaultSensor;
                if (defaultSensor != null) {
                    b.registerListener(this.x, defaultSensor, 1);
                } else {
                    this.J = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(double d) {
        this.f = d;
    }

    public void d() {
        this.k = -100.0f;
        this.l = -100.0f;
        this.m = -100.0f;
        this.n = 0;
        this.q = 200;
        this.i = 0;
        this.j = 0;
        this.p = false;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.A = 0.0f;
        this.K = false;
        if (this.y > 0) {
            this.J = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        int i;
        if (System.currentTimeMillis() - this.s < 200) {
            return;
        }
        if (!ar.a(this.r)) {
            d();
            return;
        }
        if (this.v && this.t != null && !TextUtils.isEmpty(this.u) && ak.a().b(this.u) > 0) {
            a(this.t);
        }
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.k == -100.0f) {
            this.k = f;
        }
        if (this.l == -100.0f) {
            this.l = f2;
        }
        if (this.m == -100.0f) {
            this.m = f3;
        }
        double dAbs = ((double) Math.abs(f - this.k)) / 9.8d;
        double dAbs2 = ((double) Math.abs(f2 - this.l)) / 9.8d;
        double dAbs3 = ((double) Math.abs(f3 - this.m)) / 9.8d;
        double d = this.f;
        if (dAbs > d) {
            this.j++;
            this.k = f;
        }
        if (dAbs2 > d) {
            this.j++;
            this.l = f2;
        }
        if (dAbs3 > d) {
            this.j++;
            this.m = f3;
        }
        if (a(f, f2, f3, this.d)) {
            this.n = 1;
        }
        if (this.n == 1 && b(f, f2, f3, this.e)) {
            this.n = 2;
            this.i++;
        }
        int i2 = this.g;
        if ((i2 > 0 && this.i >= i2) || ((i = this.h) > 0 && this.j >= i)) {
            this.K = true;
            aa.b("ShakeUtil", "mShakeCount = " + this.i + ",dstShakeCount = " + this.g + ",mRotateCount = " + this.j + ",dstRotateCount = " + this.h);
            if (this.K && this.J) {
                a();
            }
        }
        this.s = System.currentTimeMillis();
    }

    public void b(double d) {
        this.e = d;
    }

    public void c() {
        aa.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.x);
        }
        d();
        ShakeView shakeView = this.f4695a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
        this.o = null;
        this.c = null;
        this.f4695a = null;
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        this.t = coolShakeViewBean;
    }

    private boolean b(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) < d;
    }

    public void b() {
        SensorManager sensorManager = b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.x, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.p && System.currentTimeMillis() - this.L >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.L = System.currentTimeMillis();
                        float f = this.A;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.B;
                            float[] fArr2 = this.C;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.C;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.C;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.C;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.G) {
                                    this.G = f6;
                                }
                            } else if (f6 < this.D) {
                                this.D = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.H) {
                                    this.H = f7;
                                }
                            } else if (f7 < this.E) {
                                this.E = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.I) {
                                    this.I = f8;
                                }
                            } else if (f8 < this.F) {
                                this.F = f8;
                            }
                            if ((Math.abs(this.D) > this.y && Math.abs(this.G) > this.y) || ((Math.abs(this.E) > this.y && Math.abs(this.H) > this.y) || (Math.abs(this.F) > this.y && Math.abs(this.I) > this.y))) {
                                aa.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.D)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.G)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.E)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.H)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.F)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.I)));
                                this.J = true;
                            }
                            if (this.K && this.J) {
                                a();
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

    public void c(int i) {
        this.y = i;
        if (i > 0) {
            e();
        } else {
            this.J = true;
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        aa.a("BeiZis", "setShakeParams shakeCount:" + shakeViewBean.getShakeCount() + ";rotatCount:" + shakeViewBean.getRotatCount());
        try {
            this.v = true;
            a(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            b(shakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            this.v = false;
            a(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            b(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean, String str) {
        b(coolShakeViewBean);
        a(str);
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    public void a(String str) {
        this.u = str;
    }

    private boolean a(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) > d;
    }

    public synchronized void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.o != null);
        sb.append(",!isCallBack = ");
        sb.append(this.p ? false : true);
        aa.a("BeiZis", sb.toString());
        if (this.o != null && !this.p) {
            aa.a("BeiZis", "callback onShakeHappened()");
            this.p = true;
            this.o.a();
        }
    }

    public void a(View view) {
        this.r = view;
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        int i6;
        aa.a("BeiZis", "enter getShakeView");
        if (this.c == null || percentPositionBean == null) {
            return null;
        }
        this.f4695a = new ShakeView(this.c);
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "50%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            centerY = "50%";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "180";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = "180";
        }
        float fI = ap.i(this.c);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = Integer.parseInt(centerY);
        }
        int i7 = 400;
        if (width.endsWith("%")) {
            int i8 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            if (fI >= 400.0f) {
                i5 = (i8 * 400) / 100;
                i7 = i5;
            } else {
                i7 = (((int) fI) * i8) / 100;
            }
        } else {
            i5 = Integer.parseInt(width);
            if (i5 < 400) {
                i7 = i5;
            }
        }
        if (height.endsWith("%")) {
            i6 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i7) / 100;
        } else {
            i6 = Integer.parseInt(height);
        }
        int iA = ap.a(this.c, i7);
        int iA2 = ap.a(this.c, i6);
        int iA3 = ap.a(this.c, i3);
        int iA4 = ap.a(this.c, i4);
        aa.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        if (iA == 0) {
            iA = EffectConstants.ROTATION_DEGREES_180;
        }
        if (iA2 == 0) {
            iA2 = iA;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        aa.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        if (iA4 == 0) {
            iA4 = ap.a(this.c, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = ap.a(this.c, i) / 2;
        }
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        this.f4695a.setLayoutParams(marginLayoutParams);
        aa.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        this.f4695a.setDownloadApp(Boolean.valueOf(this.w));
        this.f4695a.startShake();
        b();
        return this.f4695a;
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, String str) {
        int i3;
        int i4;
        int i5;
        int i6;
        View view;
        aa.a("BeiZis", "enter getShakeView");
        if (this.c == null || percentPositionBean == null) {
            return null;
        }
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "0";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            centerY = "0";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "120";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = BaseWrapper.ENTER_ID_OAPS_FLOWMARKET;
        }
        float fI = ap.i(this.c);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = Integer.parseInt(centerY);
        }
        int i7 = 400;
        if (width.endsWith("%")) {
            int i8 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            if (fI >= 400.0f) {
                i5 = (i8 * 400) / 100;
                i7 = i5;
            } else {
                i7 = (((int) fI) * i8) / 100;
            }
        } else {
            i5 = Integer.parseInt(width);
            if (i5 < 400) {
                i7 = i5;
            }
        }
        if (height.endsWith("%")) {
            i6 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i7) / 100;
        } else {
            i6 = Integer.parseInt(height);
        }
        int iA = ap.a(this.c, i7);
        int iA2 = ap.a(this.c, i6);
        int iA3 = ap.a(this.c, i3);
        int iA4 = ap.a(this.c, i4);
        aa.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        if (iA == 0) {
            iA = 360;
        }
        if (iA2 == 0) {
            iA2 = 108;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        aa.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        marginLayoutParams.topMargin = (ap.a(this.c, (float) i2) - iA4) - iA2;
        marginLayoutParams.leftMargin = iA3;
        if (TextUtils.isEmpty(str)) {
            ImageView imageView = new ImageView(this.c);
            if (!this.w) {
                imageView.setImageResource(R.drawable.beizi_icon_shake_native);
                view = imageView;
            } else {
                imageView.setImageResource(R.drawable.beizi_icon_shake_native_download);
                view = imageView;
            }
        } else {
            TextView textView = new TextView(this.c);
            textView.setText(str);
            textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            textView.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            view = textView;
        }
        view.setLayoutParams(marginLayoutParams);
        aa.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        b();
        return view;
    }

    public void a(Boolean bool) {
        this.w = bool.booleanValue();
    }

    public void a(boolean z) {
        this.p = !z;
    }
}
