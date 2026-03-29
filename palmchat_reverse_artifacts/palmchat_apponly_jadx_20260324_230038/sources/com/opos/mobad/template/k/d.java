package com.opos.mobad.template.k;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d implements SensorEventListener {
    private long A;
    private long B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10197a;
    private a b;
    private SensorManager c;
    private Long d;
    private final boolean g;
    private float k;
    private float l;
    private float m;
    private double t;
    private long u;
    private boolean w;
    private boolean x;
    private boolean e = true;
    private boolean f = false;
    private int h = com.opos.mobad.template.e.b.a.p;
    private int i = com.opos.mobad.template.e.b.a.q;
    private int j = com.opos.mobad.template.e.b.a.C;
    private long n = 0;
    private boolean o = false;
    private float[] p = new float[3];
    private float[] q = new float[3];
    private float[] r = new float[9];
    private float[] s = new float[3];
    private int v = 0;
    private int y = 0;
    private int z = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int[] iArr);
    }

    public d(Context context, boolean z, a aVar) {
        this.f10197a = context;
        if (context != null) {
            this.f10197a = context.getApplicationContext();
        }
        this.g = z;
        this.b = aVar;
        e();
    }

    private void e() {
        Context context = this.f10197a;
        if (context == null || context.getResources() == null || this.f10197a.getResources().getConfiguration() == null) {
            return;
        }
        this.e = this.f10197a.getResources().getConfiguration().orientation != 2;
    }

    public void a() {
        this.o = false;
    }

    public void b() {
        if (this.c != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.f10197a.getSystemService("sensor");
        this.c = sensorManager;
        boolean z = this.f;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (z) {
            Sensor defaultSensor2 = this.c.getDefaultSensor(2);
            if (defaultSensor == null || defaultSensor2 == null) {
                return;
            }
            this.c.registerListener(this, defaultSensor, 2);
            this.c.registerListener(this, defaultSensor2, 2);
        } else if (defaultSensor == null) {
            return;
        } else {
            this.c.registerListener(this, defaultSensor, 1);
        }
        if (this.d == null) {
            this.d = Long.valueOf(System.currentTimeMillis());
        }
        if (this.g) {
            com.opos.mobad.template.e.b.a().a(this, this.d.longValue());
        }
    }

    public void c() {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.c = null;
        }
        this.m = 0.0f;
        this.l = 0.0f;
        this.k = 0.0f;
        this.n = 0L;
        this.p = new float[3];
        this.q = new float[3];
        this.r = new float[9];
        this.s = new float[3];
        this.t = 0.0d;
        this.u = 0L;
        this.v = 0;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = 0L;
        this.B = 0L;
        if (this.g) {
            com.opos.mobad.template.e.b.a().a(this);
        }
    }

    public void d() {
        c();
        this.b = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    private void a(float f) {
        this.v = (int) Math.toDegrees(f);
        this.u = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("ShakeUtils", " markLastSensor  lastDegree " + this.v + " lastTime " + this.u);
        int i = this.v;
        if (i > 0) {
            this.y = i;
        } else {
            this.z = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(SensorEvent sensorEvent) {
        char c;
        if (sensorEvent.sensor.getType() == 1) {
            this.p = (float[]) sensorEvent.values.clone();
            this.w = true;
        } else if (sensorEvent.sensor.getType() == 2) {
            this.q = (float[]) sensorEvent.values.clone();
            this.x = true;
        }
        SensorManager.getRotationMatrix(this.r, null, this.p, this.q);
        SensorManager.getOrientation(this.r, this.s);
        if (this.w && this.x) {
            if (this.u <= 0) {
                a(this.p);
                a(this.e ? this.s[2] : this.s[1]);
                return;
            }
            b(this.p);
            int degrees = (int) Math.toDegrees(this.e ? this.s[2] : this.s[1]);
            if (degrees > 0) {
                if (degrees > this.y) {
                    this.y = degrees;
                    this.A = SystemClock.elapsedRealtime();
                    c = 1;
                } else {
                    c = 0;
                }
            } else if (degrees < this.z) {
                this.z = degrees;
                this.B = SystemClock.elapsedRealtime();
                c = 2;
            }
            a(c == 1 ? this.B : c == 2 ? this.A : Math.min(this.B, this.A));
        }
    }

    private void c(SensorEvent sensorEvent) {
        if (this.n <= 0) {
            d(sensorEvent);
            return;
        }
        double dSqrt = Math.sqrt(Math.pow(sensorEvent.values[0] - this.k, 2.0d) + Math.pow(sensorEvent.values[1] - this.l, 2.0d) + Math.pow(sensorEvent.values[2] - this.m, 2.0d));
        float f = this.k;
        float f2 = this.l;
        float f3 = this.m;
        if (dSqrt * 1000.0d < this.i) {
            if (SystemClock.elapsedRealtime() - this.n >= this.h) {
                d(sensorEvent);
            }
        } else {
            if (this.g && !com.opos.mobad.template.e.b.a().b(this)) {
                d(sensorEvent);
                return;
            }
            this.o = true;
            a aVar = this.b;
            if (aVar == null || this.c == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            aVar.a(new int[]{(int) ((fArr[0] - f) * 100.0f), (int) ((fArr[1] - f2) * 100.0f), (int) ((fArr[2] - f3) * 100.0f)});
            com.opos.cmn.an.f.a.b("ShakeUtils", "dealSensor() xacc2:", Float.valueOf(sensorEvent.values[0]), ",yacc2:", Float.valueOf(sensorEvent.values[1]), ",zacc2:", Float.valueOf(sensorEvent.values[2]), ",xacc1:", Float.valueOf(f), ",yacc1:", Float.valueOf(f2), ",zacc1:", Float.valueOf(f3));
        }
    }

    private void d(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        this.k = fArr[0];
        this.l = fArr[1];
        this.m = fArr[2];
        this.n = SystemClock.elapsedRealtime();
    }

    private void a(long j) {
        if (j != 0 && SystemClock.elapsedRealtime() - j > this.h) {
            this.y = 0;
            this.z = 0;
            this.A = 0L;
            this.B = 0L;
            this.t = 0.0d;
            a(this.p);
            a(this.e ? this.s[2] : this.s[1]);
            return;
        }
        if (Math.abs(this.y) <= this.j || Math.abs(this.z) <= this.j || this.t * 1000.0d < this.i) {
            return;
        }
        if (this.g && !com.opos.mobad.template.e.b.a().b(this)) {
            a(this.p);
            a(this.e ? this.s[2] : this.s[1]);
            return;
        }
        this.o = true;
        int[] iArr = {this.j, this.v, Math.abs(this.y) + Math.abs(this.z)};
        com.opos.cmn.an.f.a.b("ShakeUtils", "onShake maxLeftDegree:" + this.y + " maxLeftTime:" + this.A + " maxRightDegree:" + this.z + " maxRightTime:" + this.B);
        c();
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(new int[]{iArr[0], iArr[1], iArr[2]});
            com.opos.cmn.an.f.a.b("ShakeUtils", "dealSensor() serverDegree:", Integer.valueOf(iArr[0]), ",startDegree:", Integer.valueOf(iArr[1]), ",endDegree:", Integer.valueOf(iArr[2]));
        }
    }

    private void b(float[] fArr) {
        this.t = Math.max(this.t, Math.sqrt(Math.pow(fArr[0] - this.k, 2.0d) + Math.pow(fArr[1] - this.l, 2.0d) + Math.pow(fArr[2] - this.m, 2.0d)));
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.o || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        if (this.f) {
            b(sensorEvent);
        } else {
            c(sensorEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002d A[PHI: r2
      0x002d: PHI (r2v3 int) = (r2v2 int), (r2v9 int) binds: [B:22:0x002b, B:11:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.opos.mobad.template.e.b.a aVar) {
        int i;
        if (aVar instanceof com.opos.mobad.template.e.b.e) {
            com.opos.mobad.template.e.b.e eVar = (com.opos.mobad.template.e.b.e) aVar;
            int i2 = eVar.D;
            if (i2 > 0) {
                this.h = i2;
            }
            int i3 = eVar.E;
            if (i3 > 0) {
                this.i = i3;
            }
            i = eVar.F;
            if (i >= 0) {
                this.j = i;
            }
        } else if (aVar instanceof com.opos.mobad.template.e.b.d) {
            com.opos.mobad.template.e.b.d dVar = (com.opos.mobad.template.e.b.d) aVar;
            int i4 = dVar.D;
            if (i4 > 0) {
                this.h = i4;
            }
            int i5 = dVar.E;
            if (i5 > 0) {
                this.i = i5;
            }
            i = dVar.G;
            if (i >= 0) {
            }
        }
        this.f = this.j > 0;
    }

    private void a(float[] fArr) {
        this.k = fArr[0];
        this.l = fArr[1];
        this.m = fArr[2];
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
