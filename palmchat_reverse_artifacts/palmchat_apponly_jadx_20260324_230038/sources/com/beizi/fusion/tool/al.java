package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.ShakeView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.opos.mobad.activity.VideoActivity;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class al {
    private static SensorManager c;
    private int A;
    private boolean B;
    private Map C;
    private boolean D;
    private double E;
    private float J;
    private int M;
    private Sensor N;
    private float O;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private boolean Y;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ShakeView f4716a;
    private boolean aa;
    private int ab;
    private int ac;
    private String ad;
    private long ae;
    private long af;
    private Context d;
    private double e;
    private double f;
    private double g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean x;
    private double y;
    private int z;
    private int l = 0;
    private int m = 0;
    private float n = -100.0f;
    private float o = -100.0f;
    private float p = -100.0f;
    private int q = 0;
    private a r = null;
    private boolean s = false;
    private int t = 200;
    private long u = 0;
    private ShakeArcView v = null;
    private int w = 0;
    private float[] F = new float[3];
    private float[] G = new float[3];
    private final SensorEventListener H = new SensorEventListener() { // from class: com.beizi.fusion.tool.al.1
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
                    if (al.this.q()) {
                        al.this.c(sensorEvent);
                    } else {
                        al.this.a(sensorEvent);
                    }
                } else if (type == 2) {
                    al.this.G = (float[]) sensorEvent.values.clone();
                } else if (type == 4) {
                    if (al.this.q()) {
                        al.this.d(sensorEvent);
                    } else {
                        al.this.b(sensorEvent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private float I = 0.0f;
    private float K = 0.0f;
    private float L = 0.0f;
    final float b = 0.85f;
    private float P = 1.0E-9f;
    private float[] Q = new float[3];
    private double ag = 0.35d;
    private float[] ah = new float[3];
    private Random ai = new Random();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void b();
    }

    public al(Context context) {
        this.d = context;
        c = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    public static Pair<Integer, Boolean> f(int i) {
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        return iRandom <= i ? new Pair<>(Integer.valueOf(iRandom), Boolean.TRUE) : new Pair<>(Integer.valueOf(iRandom), Boolean.FALSE);
    }

    private void i() {
        int i;
        ShakeArcView shakeArcView = this.v;
        if (shakeArcView == null || (i = this.w) == 0) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                shakeArcView.setMaxProgress(this.h);
            }
        } else {
            if (this.i > 0) {
                double d = this.g;
                if (d > 0.0d) {
                    shakeArcView.setMaxProgress(d);
                    return;
                }
            }
            shakeArcView.setMaxProgress(this.e);
        }
    }

    private void j() {
        if (((Boolean) f(this.k).second).booleanValue()) {
            u.a(new Runnable() { // from class: com.beizi.fusion.tool.al.2
                @Override // java.lang.Runnable
                public void run() {
                    al.this.a();
                }
            }, this.j + (((Integer) r0.first).intValue() * 10));
        }
    }

    private Map k() {
        HashMap map = new HashMap();
        map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 1);
        Map map2 = this.C;
        if (map2 == null) {
            map.put("maxAcc", Double.valueOf(l().doubleValue()));
            if (this.B) {
                map.put("angle", Integer.valueOf(m()));
            }
            return map;
        }
        double dDoubleValue = map2.containsKey("maxAcc") ? ((Double) this.C.get("maxAcc")).doubleValue() : 0.0d;
        if (dDoubleValue <= 0.0d) {
            dDoubleValue = l().doubleValue();
        }
        map.put("maxAcc", Double.valueOf(dDoubleValue));
        if (this.B) {
            int iRound = this.C.containsKey("angle") ? (int) Math.round(((Double) this.C.get("angle")).doubleValue()) : 0;
            if (iRound > 0) {
                map.put("angle", Integer.valueOf(iRound));
            } else {
                map.put("angle", Integer.valueOf(m()));
            }
        }
        return map;
    }

    private Double l() {
        return Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((((double) new Random().nextInt(TTAdConstant.STYLE_SIZE_RADIO_3_2)) / 100.0d) + 15.0d))));
    }

    private int m() {
        int iNextInt = this.A + new Random().nextInt(150 - this.A);
        return iNextInt > 120 ? iNextInt - new Random().nextInt(30) : iNextInt;
    }

    private Map n() {
        HashMap map = new HashMap();
        map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 1);
        map.put("maxAcc", Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(this.y)))));
        if (this.B) {
            map.put("angle", Long.valueOf(Math.round(this.E)));
        }
        return map;
    }

    private void o() {
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, null, this.F, this.G);
        float[] fArr2 = {degrees, 0.0f, 0.0f};
        SensorManager.getOrientation(fArr, fArr2);
        float degrees = (float) Math.toDegrees(fArr2[0]);
        if (degrees == 0.0f) {
            return;
        }
        float f = this.I;
        if (f == 0.0f) {
            this.I = degrees;
            return;
        }
        float f2 = degrees - f;
        if (Math.abs(f2) > 180.0f) {
            this.I = fArr2[0];
            return;
        }
        float f3 = this.J + f2;
        this.J = f3;
        if (f3 < this.K) {
            this.K = f3;
        }
        if (f3 > this.L) {
            this.L = f3;
        }
        double dAbs = Math.abs(this.L - this.K);
        if (dAbs <= 360.0d) {
            if (dAbs > 180.0d) {
                this.E = 360.0d - dAbs;
            } else {
                this.E = dAbs;
            }
        }
        double d = this.E;
        if (d > 120.0d) {
            this.E = d - ((double) new Random().nextInt(30));
        }
        this.I = fArr2[0];
    }

    private void p() {
        try {
            SensorManager sensorManager = c;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.N = defaultSensor;
                if (defaultSensor != null) {
                    c.registerListener(this.H, defaultSensor, 1);
                } else {
                    this.X = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return this.z == 1 && this.aa;
    }

    public void e(int i) {
        this.i = i;
    }

    public void g(int i) {
        this.t = i;
    }

    public void h(int i) {
        this.M = i;
        if (i > 0) {
            p();
        } else {
            this.X = true;
        }
    }

    public void b(double d) {
        this.f = d;
    }

    public void c(double d) {
        this.g = d;
    }

    public void d(int i) {
        this.k = i;
        if (i > 0) {
            j();
        }
    }

    public Map e() {
        int i = this.z;
        if (i == 0) {
            return null;
        }
        if (i == 2) {
            return k();
        }
        if (i == 1) {
            return this.D ? n() : k();
        }
        return null;
    }

    public double g() {
        int i = this.ac;
        return ((double) i) >= 21.5d ? i : this.ai.nextDouble() <= 0.7d ? a(this.ac, 21.5d) : b(21.5d, 49.0d);
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.j = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        float[] fArr;
        int i;
        if (sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.n == -100.0f) {
            this.n = f;
        }
        if (this.o == -100.0f) {
            this.o = f2;
        }
        if (this.p == -100.0f) {
            this.p = f3;
        }
        double dAbs = ((double) Math.abs(f - this.n)) / 9.8d;
        double dAbs2 = ((double) Math.abs(f2 - this.o)) / 9.8d;
        double dAbs3 = ((double) Math.abs(f3 - this.p)) / 9.8d;
        double d = this.g;
        if (dAbs > d) {
            this.m++;
            this.n = f;
        }
        if (dAbs2 > d) {
            this.m++;
            this.o = f2;
        }
        if (dAbs3 > d) {
            this.m++;
            this.p = f3;
        }
        if (this.D && this.B) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.F = fArr2;
            float f4 = fArr2[0] * 0.85f;
            float[] fArr3 = sensorEvent.values;
            fArr2[0] = f4 + (fArr3[0] * 0.14999998f);
            fArr2[1] = (fArr2[1] * 0.85f) + (fArr3[1] * 0.14999998f);
            fArr2[2] = (fArr2[2] * 0.85f) + (fArr3[2] * 0.14999998f);
            o();
        }
        double dA = a(f, f2, f3, this.e);
        if (dA > this.e) {
            if (this.D && this.q == 0) {
                double dA2 = a(f, f2, f3);
                if (this.y < dA2) {
                    this.y = dA2;
                }
            }
            this.q = 1;
        }
        if (this.q == 1 && b(f, f2, f3, this.f)) {
            this.q = 2;
            this.l++;
        }
        a(dAbs, dAbs2, dAbs3, dA);
        int i2 = this.h;
        if ((i2 <= 0 || this.l < i2) && ((i = this.i) <= 0 || this.m < i)) {
            return;
        }
        if (this.D && this.B && this.E < this.A) {
            this.l--;
            return;
        }
        aa.b("ShakeUtil", "mShakeCount = " + this.l + ",dstShakeCount = " + this.h + ",mRotateCount = " + this.m + ",dstRotateCount = " + this.i);
        this.Y = true;
        if (this.X) {
            a();
        }
    }

    private boolean b(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) < d;
    }

    public void c() {
        aa.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.H);
        }
        d();
        ShakeView shakeView = this.f4716a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
    }

    public void d() {
        this.s = false;
        this.l = 0;
        this.m = 0;
        this.n = -100.0f;
        this.o = -100.0f;
        this.p = -100.0f;
        this.q = 0;
        this.r = null;
        this.d = null;
        this.f4716a = null;
        this.t = 200;
        this.v = null;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.O = 0.0f;
        this.Y = false;
        if (this.M > 0) {
            this.X = false;
        }
    }

    public Map f() {
        try {
            HashMap map = new HashMap();
            map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, 1);
            if (TextUtils.isEmpty(this.ad)) {
                int iNextInt = this.ai.nextInt(100);
                if (iNextInt < 40) {
                    this.ad = "x";
                } else if (iNextInt < 80) {
                    this.ad = "y";
                } else {
                    this.ad = "z";
                }
            }
            if (q()) {
                map.put("angle", String.format("%.2f", Double.valueOf(this.E)));
                map.put("maxAcc", String.format("%.2f", Double.valueOf(this.y)));
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, this.ad);
                map.put("duration", Long.valueOf(this.af));
            } else {
                map.put("angle", String.format("%.2f", Double.valueOf(h())));
                map.put("maxAcc", String.format("%.2f", Double.valueOf(g())));
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, this.ad);
                map.put("duration", Integer.valueOf(this.ai.nextInt(50) + 3000));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public double h() {
        double d;
        double dB;
        double dNextDouble = this.ai.nextDouble();
        if (dNextDouble <= 0.75d) {
            d = this.A;
            dB = a(0.0d, 5.0d);
        } else if (dNextDouble <= 0.95d) {
            d = this.A;
            dB = a(5.0d, 10.0d);
        } else {
            d = this.A;
            dB = b(10.0d, 25.0d);
        }
        return d + dB;
    }

    public void b() {
        SensorManager sensorManager = c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.H, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.s && System.currentTimeMillis() - this.Z >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.Z = System.currentTimeMillis();
                        float f = this.O;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.P;
                            float[] fArr2 = this.Q;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.Q;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.Q;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.Q;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.U) {
                                    this.U = f6;
                                }
                            } else if (f6 < this.R) {
                                this.R = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.V) {
                                    this.V = f7;
                                }
                            } else if (f7 < this.S) {
                                this.S = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.W) {
                                    this.W = f8;
                                }
                            } else if (f8 < this.T) {
                                this.T = f8;
                            }
                            if ((Math.abs(this.R) > this.M && Math.abs(this.U) > this.M) || ((Math.abs(this.S) > this.M && Math.abs(this.V) > this.M) || (Math.abs(this.T) > this.M && Math.abs(this.W) > this.M))) {
                                aa.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.U)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.V)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.W)));
                                this.X = true;
                            }
                            if (this.Y && this.X) {
                                a();
                            }
                        }
                        this.O = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                double dA = a(fArr[0], fArr[1], fArr[2]);
                if (dA > 10.7d && this.ae > 0) {
                    this.af += System.currentTimeMillis() - this.ae;
                }
                this.ae = System.currentTimeMillis();
                if (this.y < dA) {
                    this.y = dA;
                }
                if (dA > this.ac) {
                    aa.b("ShakeUtil", "tempShakeAcc:" + dA + ";shakeMaxAngle:" + this.E + ";mShakeDurationTime:" + this.af + ";mDirection:" + this.ad);
                }
                if (this.y >= this.ac && this.E >= this.A && this.af >= this.ab) {
                    this.Y = true;
                    if (this.X) {
                        a();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.s && System.currentTimeMillis() - this.Z >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.Z = System.currentTimeMillis();
                        float f = this.O;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            double d = this.ag;
                            double d2 = ((double) f2) * d;
                            float[] fArr2 = this.ah;
                            fArr2[0] = (float) (d2 + ((1.0d - d) * ((double) fArr2[0])));
                            fArr2[1] = (float) ((d * ((double) f3)) + ((1.0d - d) * ((double) fArr2[1])));
                            fArr2[2] = (float) ((d * ((double) f4)) + ((1.0d - d) * ((double) fArr2[2])));
                            float f5 = (sensorEvent.timestamp - f) * this.P;
                            float[] fArr3 = this.Q;
                            fArr3[0] = (float) (((double) fArr3[0]) + Math.toDegrees(r5 * f5));
                            float[] fArr4 = this.Q;
                            fArr4[1] = (float) (((double) fArr4[1]) + Math.toDegrees(r10 * f5));
                            float[] fArr5 = this.Q;
                            fArr5[2] = (float) (((double) fArr5[2]) + Math.toDegrees(r11 * f5));
                            float[] fArr6 = this.Q;
                            float f6 = fArr6[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.U) {
                                    this.U = f6;
                                }
                            } else if (f6 < this.R) {
                                this.R = f6;
                            }
                            float f7 = fArr6[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.V) {
                                    this.V = f7;
                                }
                            } else if (f7 < this.S) {
                                this.S = f7;
                            }
                            float f8 = fArr6[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.W) {
                                    this.W = f8;
                                }
                            } else if (f8 < this.T) {
                                this.T = f8;
                            }
                            if (q() && ((Math.abs(this.R) > this.A && Math.abs(this.U) > this.A) || ((Math.abs(this.S) > this.A && Math.abs(this.V) > this.A) || (Math.abs(this.T) > this.A && Math.abs(this.W) > this.A)))) {
                                List listAsList = Arrays.asList(Float.valueOf(Math.abs(this.R)), Float.valueOf(Math.abs(this.U)), Float.valueOf(Math.abs(this.S)), Float.valueOf(Math.abs(this.V)), Float.valueOf(Math.abs(this.T)), Float.valueOf(Math.abs(this.W)));
                                int iIndexOf = listAsList.indexOf((Float) Collections.max(listAsList));
                                if (this.E < r4.floatValue() && (this.y < this.ac || this.E < this.A)) {
                                    this.E = r4.floatValue();
                                    if (iIndexOf == 0 || iIndexOf == 1) {
                                        this.ad = "x";
                                    } else if (iIndexOf == 2 || iIndexOf == 3) {
                                        this.ad = "y";
                                    } else if (iIndexOf == 4 || iIndexOf == 5) {
                                        this.ad = "z";
                                    }
                                }
                            }
                            if (this.M > 0) {
                                if ((Math.abs(this.R) > this.M && Math.abs(this.U) > this.M) || ((Math.abs(this.S) > this.M && Math.abs(this.V) > this.M) || (Math.abs(this.T) > this.M && Math.abs(this.W) > this.M))) {
                                    aa.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.U)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.V)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.W)));
                                    this.X = true;
                                }
                                if (this.Y && this.X) {
                                    a();
                                }
                            }
                        }
                        this.O = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeParams mShakeCount:" + shakeViewBean.getShakeCount() + ";mRotateCount:" + shakeViewBean.getRotatCount());
        try {
            this.n = -100.0f;
            this.o = -100.0f;
            this.p = -100.0f;
            this.l = 0;
            this.m = 0;
            this.q = 0;
            b(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            e(shakeViewBean.getRotatCount());
            c(shakeViewBean.getRandomClickTime());
            d(shakeViewBean.getRandomClickNum());
            g(shakeViewBean.getAnimationInterval());
            i();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double b(double d, double d2) {
        return d + ((((-Math.log(1.0d - this.ai.nextDouble())) / 1.5d) / ((-Math.log(0.0010000000000000009d)) / 1.5d)) * (d2 - d));
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            b(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            e(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean) {
        if (aliaseShakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeAliaseParams mShakeCount:" + aliaseShakeViewBean.getShakeCount() + ";mRotateCount:" + aliaseShakeViewBean.getRotatCount());
        try {
            b(aliaseShakeViewBean.getShakeCount());
            a(aliaseShakeViewBean.getShakeStartAmplitude());
            b(aliaseShakeViewBean.getShakeEndAmplitude());
            c(aliaseShakeViewBean.getRotatAmplitude());
            e(aliaseShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ShakeArcView shakeArcView, int i) {
        aa.c("ShakeUtil", "setShakeFeedback feedback:" + i);
        a(shakeArcView);
        a(i);
        i();
    }

    private void a(double d, double d2, double d3, double d4) {
        ShakeArcView shakeArcView = this.v;
        if (shakeArcView == null) {
            return;
        }
        if (this.w == 2) {
            shakeArcView.setCurrentProgress(this.l);
            return;
        }
        if (this.i > 0 && this.g > 0.0d) {
            double dDoubleValue = new BigDecimal((d < d2 || d < d3) ? (d2 < d || d2 < d3) ? (d3 < d || d3 < d2) ? 0.0d : d3 : d2 : d).setScale(2, 4).doubleValue();
            if (dDoubleValue >= 0.1d) {
                this.v.setCurrentProgress(dDoubleValue);
                return;
            } else {
                if (dDoubleValue < 0.1d) {
                    this.v.setCurrentProgress(0.0d);
                    return;
                }
                return;
            }
        }
        int i = this.h;
        if (i > 0 && this.l >= i) {
            shakeArcView.setCurrentProgress(this.e);
            return;
        }
        double dDoubleValue2 = new BigDecimal(d4).setScale(2, 4).doubleValue();
        if (dDoubleValue2 >= 1.1d) {
            this.v.setCurrentProgress(dDoubleValue2);
        } else if (dDoubleValue2 < 1.1d) {
            this.v.setCurrentProgress(0.0d);
        }
    }

    public void a(int i) {
        this.w = i;
    }

    public void a(double d) {
        this.e = d;
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public void a(ShakeArcView shakeArcView) {
        this.v = shakeArcView;
    }

    private double a(float f, float f2, float f3, double d) {
        return Math.sqrt(Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d) + Math.pow(((double) f3) / 9.8d, 2.0d));
    }

    public synchronized void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.r != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.s);
        aa.a("BeiZis", sb.toString());
        if (this.r != null && !this.s) {
            aa.a("BeiZis", "callback onShakeHappened()");
            ShakeArcView shakeArcView = this.v;
            if (shakeArcView != null && !ar.b(shakeArcView)) {
                aa.b("ShakeUtil", "mShakeCount onShakeHappened mShakeArcView is not show");
                this.n = -100.0f;
                this.o = -100.0f;
                this.p = -100.0f;
                this.l = 0;
                this.m = 0;
                this.q = 0;
                return;
            }
            this.s = true;
            this.r.b();
            ShakeView shakeView = this.f4716a;
            if (shakeView != null) {
                shakeView.stopShake();
                c();
            }
        }
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        int i6;
        aa.a("BeiZis", "enter getShakeView");
        if (this.d == null || percentPositionBean == null) {
            return null;
        }
        this.f4716a = new ShakeView(this.d);
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
        float fI = ap.i(this.d);
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
        int iA = ap.a(this.d, i7);
        int iA2 = ap.a(this.d, i6);
        int iA3 = ap.a(this.d, i3);
        int iA4 = ap.a(this.d, i4);
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
            iA4 = ap.a(this.d, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = ap.a(this.d, i) / 2;
        }
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        this.f4716a.setLayoutParams(marginLayoutParams);
        aa.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        this.f4716a.setDownloadApp(Boolean.valueOf(this.x));
        this.f4716a.startShake();
        b();
        return this.f4716a;
    }

    public void a(int i, int i2, boolean z, Map map) {
        Sensor defaultSensor;
        try {
            this.z = i;
            this.A = i2;
            this.B = z;
            this.C = map;
            if (i2 <= 0) {
                this.A = 35;
            }
            if (i == 1) {
                if (map == null) {
                    this.D = true;
                    return;
                } else if (!map.containsKey("forceUnreal")) {
                    this.D = true;
                    return;
                } else {
                    Object obj = map.get("forceUnreal");
                    if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false)) {
                        this.D = true;
                    }
                }
            }
            if (this.D && z && (defaultSensor = c.getDefaultSensor(2)) != null) {
                c.registerListener(this.H, defaultSensor, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double a(float f, float f2, float f3) {
        return Math.sqrt(Math.pow(f, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
    }

    public void a(Boolean bool) {
        this.x = bool.booleanValue();
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, Map map) {
        if (shakeViewBean == null) {
            return;
        }
        try {
            int sensorParam = shakeViewBean.getSensorParam();
            this.z = sensorParam;
            this.aa = true;
            if (sensorParam == 0) {
                this.z = 1;
            }
            this.A = shakeViewBean.getCompliantAngle();
            this.ab = shakeViewBean.getDuration();
            int maxAcc = shakeViewBean.getMaxAcc();
            this.ac = maxAcc;
            this.C = map;
            if (this.A <= 0) {
                this.A = 35;
            }
            if (this.ab <= 0) {
                this.ab = 3000;
            }
            if (maxAcc <= 0) {
                this.ac = 15;
            }
            if (this.z != 1) {
                return;
            }
            if (this.M <= 0) {
                p();
            }
            if (this.N == null) {
                this.E = h();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double a(double d, double d2) {
        return d + (this.ai.nextDouble() * (d2 - d));
    }
}
