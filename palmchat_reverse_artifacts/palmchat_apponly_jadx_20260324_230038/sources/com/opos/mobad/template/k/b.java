package com.opos.mobad.template.k;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f10192a;
    private Context b;
    private a c;
    private long j;
    private float[] k;
    private boolean o;
    private boolean p;
    private float[] d = new float[3];
    private float[] e = new float[3];
    private float[] f = new float[9];
    private float[] g = new float[3];
    private int h = com.opos.mobad.template.e.b.a.u;
    private int i = com.opos.mobad.template.e.b.a.v;
    private float l = 0.0f;
    private float m = 0.0f;
    private boolean n = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(float f, float f2);

        void a(int i, int[] iArr);
    }

    public b(Context context, a aVar) {
        this.b = context;
        this.c = aVar;
    }

    public void a() {
        if (this.f10192a != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
        this.f10192a = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor2 = this.f10192a.getDefaultSensor(2);
        if (defaultSensor == null || defaultSensor2 == null) {
            return;
        }
        this.f10192a.registerListener(this, defaultSensor, 3);
        this.f10192a.registerListener(this, defaultSensor2, 3);
    }

    public void b() {
        this.n = false;
    }

    public void c() {
        SensorManager sensorManager = this.f10192a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f10192a = null;
        }
        this.d = new float[3];
        this.e = new float[3];
        this.f = new float[9];
        this.g = new float[3];
        this.l = 0.0f;
        this.m = 0.0f;
        this.j = 0L;
        this.o = false;
        this.p = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.n || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            this.d = (float[]) sensorEvent.values.clone();
            this.o = true;
        } else if (sensorEvent.sensor.getType() == 2) {
            this.e = (float[]) sensorEvent.values.clone();
            this.p = true;
        }
        SensorManager.getRotationMatrix(this.f, null, this.d, this.e);
        SensorManager.getOrientation(this.f, this.g);
        if (this.o && this.p) {
            if (this.j <= 0) {
                a(this.g);
                return;
            }
            float f = this.g[1];
            double d = (((double) (f - this.m)) * 180.0d) / 3.141592653589793d;
            if (d <= 0.0d) {
                a aVar = this.c;
                if (aVar != null) {
                    float f2 = this.l;
                    aVar.a(f2, f2);
                    return;
                }
                return;
            }
            int degrees = (int) Math.toDegrees(f);
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(this.l, degrees);
            }
            int i = this.h;
            if (d >= i) {
                this.n = true;
                this.k = new float[]{this.l, degrees, i, SystemClock.elapsedRealtime() - this.j};
                c();
                a aVar3 = this.c;
                if (aVar3 != null) {
                    float[] fArr2 = this.k;
                    aVar3.a(0, new int[]{(int) fArr2[0], (int) fArr2[1], (int) fArr2[2], (int) fArr2[3]});
                }
            }
        }
    }

    private void a(float[] fArr) {
        this.m = fArr[1];
        this.l = (int) Math.toDegrees(r3);
        this.j = SystemClock.elapsedRealtime();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
