package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k extends com.opos.mobad.template.cmn.baseview.d implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9397a;
    private int b;
    private int c;
    private Paint d;
    private int e;
    private LinearGradient f;
    private int[] g;
    private float h;
    private SensorManager i;
    private boolean j;
    private boolean k;
    private float[] l;
    private float[] m;
    private float[] n;
    private float[] o;
    private float p;
    private long q;
    private float r;
    private boolean s;

    public k(Context context, boolean z, int i) {
        super(context);
        this.g = new int[]{16777215, 16777215, 16777215};
        this.l = new float[3];
        this.m = new float[3];
        this.n = new float[9];
        this.o = new float[3];
        this.p = 0.0f;
        this.f9397a = context;
        this.k = z;
        this.b = i;
        f();
        d();
    }

    private void d() {
        if (this.j) {
            this.d = new Paint();
            this.c = com.opos.cmn.an.h.f.a.a(this.f9397a, 44.0f);
            this.h = com.opos.cmn.an.h.f.a.a(this.f9397a, 42.0f);
            this.e = com.opos.cmn.an.h.f.a.a(this.f9397a, 1.0f);
            this.f = new LinearGradient(0.0f, 0.0f, this.b, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    private void e() {
        if (this.j) {
            this.d = new Paint();
            this.e = com.opos.cmn.an.h.f.a.a(this.f9397a, 1.0f);
            this.f = new LinearGradient(0.0f, 0.0f, this.b, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    private void f() {
        Sensor defaultSensor;
        Sensor defaultSensor2 = null;
        try {
            SensorManager sensorManager = (SensorManager) this.f9397a.getSystemService("sensor");
            defaultSensor = sensorManager.getDefaultSensor(1);
            try {
                defaultSensor2 = sensorManager.getDefaultSensor(2);
            } catch (Throwable th) {
                th = th;
                com.opos.cmn.an.f.a.b("LightView", "shake animal check", th);
            }
        } catch (Throwable th2) {
            th = th2;
            defaultSensor = null;
        }
        this.j = (defaultSensor == null || defaultSensor2 == null) ? false : true;
    }

    private void g() {
        if (this.j) {
            SensorManager sensorManager = this.i;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.i = null;
            }
            this.l = new float[3];
            this.m = new float[3];
            this.n = new float[9];
            this.o = new float[3];
            this.p = 0.0f;
            this.q = 0L;
            this.r = 0.0f;
        }
    }

    private void h() {
        if (this.j && this.i == null) {
            SensorManager sensorManager = (SensorManager) this.f9397a.getSystemService("sensor");
            this.i = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = this.i.getDefaultSensor(2);
            if (defaultSensor == null || defaultSensor2 == null) {
                return;
            }
            this.i.registerListener(this, defaultSensor, 3);
            this.i.registerListener(this, defaultSensor2, 3);
        }
    }

    private void i() {
        this.s = true;
        this.f = new LinearGradient(this.b, 0.0f, 0.0f, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    private void j() {
        this.s = false;
        this.f = new LinearGradient(0.0f, 0.0f, this.b, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    private void k() {
        this.f = this.s ? new LinearGradient(this.b, 0.0f, 0.0f, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP) : new LinearGradient(0.0f, 0.0f, this.b, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.g = new int[]{16777215, 16777215, 16777215};
        this.f = new LinearGradient(0.0f, 0.0f, this.b, 0.0f, this.g, (float[]) null, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void a() {
        if (this.j) {
            g();
        }
    }

    public void b() {
        if (this.j) {
            h();
        }
    }

    public void c() {
        if (this.j) {
            this.g = new int[]{-1, 16777215, 16777215};
            k();
            this.g = new int[]{-1, -1, 16777215};
            k();
            this.g = new int[]{-1, -1, -1};
            k();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.mobad.template.cmn.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.l();
                }
            }, 1000L);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j) {
            this.d.reset();
            this.d.setAntiAlias(true);
            this.d.setShader(this.f);
            this.d.setStrokeWidth(this.e);
            this.d.setStyle(Paint.Style.STROKE);
            RectF rectF = new RectF(0.0f, 0.0f, this.b, this.c);
            float f = this.h;
            canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.d);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public k(Context context, boolean z, int i, int i2, int i3) {
        super(context);
        this.g = new int[]{16777215, 16777215, 16777215};
        this.l = new float[3];
        this.m = new float[3];
        this.n = new float[9];
        this.o = new float[3];
        this.p = 0.0f;
        this.f9397a = context;
        this.k = z;
        this.b = i;
        this.c = i2;
        this.h = i3;
        f();
        e();
    }

    private void a(float f) {
        this.g = new int[]{f >= 30.0f ? -1 : Color.argb(Math.min(Double.valueOf(BigDecimal.valueOf((f / 30.0f) * 255.0f).setScale(0, RoundingMode.HALF_UP).doubleValue()).intValue(), 255), 255, 255, 255), 16777215, 16777215};
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.j && sensorEvent != null && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
            if (sensorEvent.sensor.getType() == 1) {
                this.l = (float[]) sensorEvent.values.clone();
            } else if (sensorEvent.sensor.getType() == 2) {
                this.m = (float[]) sensorEvent.values.clone();
            }
            SensorManager.getRotationMatrix(this.n, null, this.l, this.m);
            SensorManager.getOrientation(this.n, this.o);
            float degrees = (float) Math.toDegrees(this.k ? this.o[2] : this.o[1]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            float fAbs = Math.abs(degrees);
            if (jCurrentTimeMillis - this.q <= 100 || Math.abs(fAbs - this.r) <= 1.0f) {
                return;
            }
            this.q = jCurrentTimeMillis;
            this.r = fAbs;
            if (this.p == degrees) {
                return;
            }
            this.p = degrees;
            a(Math.abs(degrees));
            if (!this.k ? degrees > 0.0f : degrees <= 0.0f) {
                i();
            } else {
                j();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
