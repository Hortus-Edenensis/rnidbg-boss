package com.opos.mobad.template.k;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f10198a;
    private Context b;
    private a c;
    private long l;
    private float[] m;
    private boolean q;
    private boolean r;
    private long u;
    private long v;
    private boolean d = true;
    private float[] e = new float[3];
    private float[] f = new float[3];
    private float[] g = new float[9];
    private float[] h = new float[3];
    private int i = com.opos.mobad.template.e.b.a.r;
    private int j = com.opos.mobad.template.e.b.a.s;
    private boolean k = true;
    private float n = 0.0f;
    private float o = 0.0f;
    private boolean p = false;
    private float s = 0.0f;
    private float t = 0.0f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(float f, float f2);

        void a(int i, int[] iArr);
    }

    public e(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
        e();
    }

    private void a(float f) {
        this.o = f;
        this.n = (int) Math.toDegrees(f);
        this.l = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("TiltUtils", " markLastSensor  lastDegree " + this.n + " lastTime " + this.l + " mIsTwoWay " + this.k);
        if (this.k) {
            float f2 = this.n;
            if (f2 > 0.0f) {
                this.s = f2;
            } else {
                this.t = f2;
            }
        }
    }

    private void e() {
        Context context = this.b;
        if (context == null || context.getResources() == null || this.b.getResources().getConfiguration() == null) {
            return;
        }
        this.d = this.b.getResources().getConfiguration().orientation != 2;
    }

    public void b() {
        if (this.f10198a != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
        this.f10198a = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor2 = this.f10198a.getDefaultSensor(2);
        if (defaultSensor == null || defaultSensor2 == null) {
            return;
        }
        this.f10198a.registerListener(this, defaultSensor, 2);
        this.f10198a.registerListener(this, defaultSensor2, 2);
    }

    public void c() {
        this.p = false;
    }

    public void d() {
        SensorManager sensorManager = this.f10198a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f10198a = null;
        }
        this.e = new float[3];
        this.f = new float[3];
        this.g = new float[9];
        this.h = new float[3];
        this.n = 0.0f;
        this.o = 0.0f;
        this.l = 0L;
        this.q = false;
        this.r = false;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0L;
        this.v = 0L;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public void a(int i, int i2, boolean z) {
        this.i = i;
        this.j = i2;
        this.k = z;
        com.opos.cmn.an.f.a.b("TiltUtils", " degree " + i + " time " + i2 + " isTwoWay " + z + " mIsPortrait " + this.d);
    }

    private void a(long j) {
        com.opos.cmn.an.f.a.b("TiltUtils", " maxLeftDegree:" + this.s + " maxLeftTime:" + this.u + " maxRightDegree:" + this.t + " maxRightTime:" + this.v);
        if (j != 0 && SystemClock.elapsedRealtime() - j > this.j) {
            this.s = 0.0f;
            this.t = 0.0f;
            this.u = 0L;
            this.v = 0L;
            return;
        }
        float f = this.i / 3;
        if (Math.abs(this.s) <= f || Math.abs(this.t) <= f || Math.abs(this.s) + Math.abs(this.t) < this.i * 2) {
            return;
        }
        this.p = true;
        this.m = new float[]{this.n, Math.abs(this.s) + Math.abs(this.t), 0.0f, 0.0f};
        float[] fArr = this.m;
        fArr[2] = this.i;
        fArr[3] = SystemClock.elapsedRealtime() - j;
        com.opos.cmn.an.f.a.b("TiltUtils", "onInteractionClick maxLeftDegree:" + this.s + " maxLeftTime:" + this.u + " maxRightDegree:" + this.t + " maxRightTime:" + this.v);
        d();
        a aVar = this.c;
        if (aVar != null) {
            float[] fArr2 = this.m;
            aVar.a(1, new int[]{(int) fArr2[0], (int) fArr2[1], (int) fArr2[2], (int) fArr2[3]});
        }
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        float f;
        double d;
        float f2;
        float f3;
        long j;
        if (this.p || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            this.e = (float[]) sensorEvent.values.clone();
            this.q = true;
        } else if (sensorEvent.sensor.getType() == 2) {
            this.f = (float[]) sensorEvent.values.clone();
            this.r = true;
        }
        SensorManager.getRotationMatrix(this.g, null, this.e, this.f);
        SensorManager.getOrientation(this.g, this.h);
        if (this.q && this.r) {
            if (this.l <= 0) {
                a(this.d ? this.h[2] : this.h[1]);
                return;
            }
            char c = 0;
            if (this.k) {
                int degrees = (int) Math.toDegrees(this.d ? this.h[2] : this.h[1]);
                if (degrees > 0) {
                    float f4 = degrees;
                    if (f4 > this.s) {
                        this.s = f4;
                        this.u = SystemClock.elapsedRealtime();
                        c = 1;
                    }
                } else {
                    float f5 = degrees;
                    if (f5 < this.t) {
                        this.t = f5;
                        this.v = SystemClock.elapsedRealtime();
                        c = 2;
                    }
                }
                if (c == 1) {
                    j = this.v;
                } else if (c != 2) {
                    return;
                } else {
                    j = this.u;
                }
                a(j);
                return;
            }
            if (this.d) {
                if (this.n > 0.0f) {
                    f2 = this.o;
                    f3 = this.h[2];
                } else {
                    f2 = this.h[2];
                    f3 = this.o;
                }
                d = (((double) (f2 - f3)) * 180.0d) / 3.141592653589793d;
                f = this.h[2];
            } else {
                f = this.h[1];
                d = (((double) (f - this.o)) * 180.0d) / 3.141592653589793d;
            }
            int degrees2 = (int) Math.toDegrees(f);
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.n, degrees2);
            }
            double dAbs = Math.abs(d);
            int i = this.i;
            if (dAbs >= i) {
                this.p = true;
                this.m = new float[]{this.n, degrees2, i, SystemClock.elapsedRealtime() - this.l};
                d();
                a aVar2 = this.c;
                if (aVar2 != null) {
                    float[] fArr2 = this.m;
                    aVar2.a(1, new int[]{(int) fArr2[0], (int) fArr2[1], (int) fArr2[2], (int) fArr2[3]});
                }
            }
        }
    }

    public boolean a() {
        return this.d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
