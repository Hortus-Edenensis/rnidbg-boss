package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qq implements SensorEventListener {
    private static kj mk;
    private float b;
    private float bc;
    private int bg;
    private float fx;
    private Context gc;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private float f5174jp;
    private Sensor k;
    private fx lf;
    private Sensor my;
    private boolean nb;
    private volatile long nr;
    private Sensor o;
    private float oa;
    private boolean p;
    private JSONObject pb;
    private float pn;
    private int qq;
    private Sensor s;
    private float sx;
    private t t;
    private volatile long x;
    private float z;
    private final long u = 2000;
    private boolean iz = false;
    private float n = 13.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5173a = 50.0f;
    private int jk = 0;
    private u l = null;
    private nr mv = null;
    private final long bq = 500;
    private volatile long dw = 0;
    private volatile boolean c = false;
    private volatile boolean q = false;
    private final float kj = 1.0E-9f;
    private float[] gi = new float[3];
    private long d = 0;
    private float h = 0.0f;
    private float rh = 4.0f;
    private float ja = 0.0f;
    private float[] bf = new float[3];
    private final float wq = 0.0f;
    private boolean xg = false;
    private boolean m = false;
    private boolean y = false;
    private boolean xw = false;
    private int w = 0;
    private int cj = 0;
    private int tk = 0;
    private int wi = 0;
    private int su = 0;
    private int mh = 0;
    private boolean yd = false;
    private int ay = 0;
    private int v = 0;
    private float eh = 0.0f;

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
        void u();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(float f, float f2, float f3);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(int i);
    }

    public qq(Context context, int i, boolean z, boolean z2) {
        this.t = null;
        this.nb = z;
        this.qq = i;
        this.p = z2;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.gc = applicationContext;
        if (applicationContext != null && z) {
            if (z2) {
                this.t = pn.u(context);
            } else {
                this.t = iz.u(applicationContext);
            }
        }
    }

    private void a() {
        u uVar = this.l;
        if (uVar != null) {
            uVar.u(getType());
        }
        this.nr = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.t == null || this.yd) {
            return false;
        }
        int i = this.qq;
        if (i == 1) {
            return nr();
        }
        if (i == 2) {
            return fx();
        }
        return false;
    }

    private boolean fx() {
        int i;
        t tVar = this.t;
        boolean zU = false;
        if (tVar == null) {
            return false;
        }
        try {
            if (this.bg == 0) {
                if (this.k == null) {
                    this.k = tVar.u(15);
                }
                this.iz = false;
                zU = this.t.u(this, this.k, 1);
            }
            int i2 = this.bg;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.my == null) {
                    this.my = this.t.u(4);
                }
                float f = this.rh;
                if (f != 0.0f && ((i = this.bg) == 2 || i == 4)) {
                    this.eh = (float) Math.pow(f, 2.0d);
                    if (this.o == null) {
                        this.o = this.t.u(10);
                    }
                    this.t.u(this, this.o, 1);
                }
                zU = this.t.u(this, this.my, 1);
            }
            x();
        } catch (Throwable unused) {
        }
        return zU;
    }

    private int getType() {
        return this.qq == 2 ? 2 : 1;
    }

    private int iz(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private void jk() {
        u uVar = this.l;
        if (uVar != null) {
            uVar.u(getType());
        }
        this.nr = System.currentTimeMillis();
        this.dw = 0L;
        this.q = false;
    }

    private boolean n() {
        return this.sx > this.n;
    }

    private boolean nr() {
        t tVar = this.t;
        if (tVar == null) {
            return false;
        }
        try {
            if (this.jk == 4) {
                return fx();
            }
            if (this.s == null) {
                this.s = tVar.u(1);
            }
            boolean zU = this.t.u(this, this.s, 3);
            iz();
            return zU;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void pn() {
        t tVar = this.t;
        if (tVar == null) {
            return;
        }
        tVar.u(this);
    }

    private float u(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private void x() {
        this.w = 0;
        this.cj = 0;
        this.tk = 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        fx fxVar = this.lf;
        if (fxVar != null) {
            fxVar.u();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.l == null || System.currentTimeMillis() - this.nr <= 2000) {
                return;
            }
            int i = this.jk;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                u(dSqrt > ((double) this.n), dSqrt);
                return;
            } else if (i == 2) {
                nr(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.n), sensorEvent);
                return;
            } else if (i == 3) {
                u(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.n), sensorEvent);
                return;
            } else {
                double dU = u(fAbs, fAbs2, fAbs3);
                u(dU > ((double) this.n), dU);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.bg;
            if (i2 == 3) {
                nr(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    u(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            float[] fArr2 = sensorEvent.values;
            this.ja = (float) (Math.pow(fArr2[0], 2.0d) + Math.pow(fArr2[1], 2.0d) + Math.pow(fArr2[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        nr nrVar = this.mv;
        if (nrVar != null) {
            nrVar.u(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.iz) {
            this.iz = true;
            this.fx = fAbs4;
            this.b = fAbs5;
            this.pn = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.fx) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.b) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.pn) * 180.0f;
        if (!this.xg) {
            float f = this.f5173a;
            if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.l != null && System.currentTimeMillis() - this.x > 2000) {
                this.l.u(getType());
                this.x = System.currentTimeMillis();
                this.iz = false;
                return;
            }
            return;
        }
        boolean z = this.m && fAbs7 > this.f5174jp;
        boolean z2 = this.y && fAbs8 > this.bc;
        boolean z3 = this.xw && fAbs9 > this.oa;
        if ((z || z2 || z3) && this.l != null && System.currentTimeMillis() - this.x > 2000) {
            this.l.u(getType());
            this.x = System.currentTimeMillis();
            this.iz = false;
        }
    }

    private void iz() {
        this.dw = 0L;
        this.c = false;
        this.q = false;
        this.w = 0;
        this.cj = 0;
        this.tk = 0;
        this.wi = 0;
        this.su = 0;
        this.mh = 0;
    }

    private boolean u(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean u(int i, int i2) {
        return (i | i2) == 3;
    }

    public void pn(int i) {
        this.jk = i;
    }

    private void pn(float f) {
        if (System.currentTimeMillis() - this.dw >= 500) {
            this.c = false;
            jk();
        } else if (f >= this.sx) {
            this.c = true;
            jk();
        }
    }

    private boolean u(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    private void x(float f) {
        if (!u(this.bg == 7, f) || System.currentTimeMillis() - this.x <= 2000) {
            return;
        }
        nr(false);
        u uVar = this.l;
        if (uVar != null) {
            uVar.u(getType());
        }
        this.x = System.currentTimeMillis();
    }

    public void b(int i) {
        this.yd = true;
        nr(i);
    }

    public void u(boolean z) {
        Context context;
        if (!z) {
            t tVar = this.t;
            if (tVar != null) {
                tVar.u(this);
                this.t = null;
                return;
            }
            return;
        }
        if (this.nb || this.t != null || (context = this.gc) == null) {
            return;
        }
        if (this.p) {
            this.t = pn.u(context);
        } else {
            this.t = iz.u(context);
        }
    }

    private void b(float f) {
        if (!u(this.bg == 4, f) || System.currentTimeMillis() - this.x <= 2000) {
            return;
        }
        u uVar = this.l;
        if (uVar != null) {
            uVar.u(getType());
        }
        this.x = System.currentTimeMillis();
    }

    public void nr(int i) {
        pn();
        kj kjVar = mk;
        if (kjVar != null) {
            kjVar.u(i, hashCode());
        }
    }

    private void nr(SensorEvent sensorEvent) {
        boolean z;
        float f = this.z;
        if (f != 0.0f) {
            float f2 = (sensorEvent.timestamp - f) * 1.0E-9f;
            float[] fArr = this.gi;
            float f3 = fArr[0];
            float[] fArr2 = sensorEvent.values;
            float f4 = f3 + (fArr2[0] * f2);
            fArr[0] = f4;
            fArr[1] = fArr[1] + (fArr2[1] * f2);
            fArr[2] = fArr[2] + (fArr2[2] * f2);
            float fAbs = Math.abs((float) Math.toDegrees(f4));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.gi[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.gi[2]));
            if (this.xg) {
                boolean z2 = this.m && u(fAbs, this.f5174jp);
                boolean z3 = this.y && u(fAbs2, this.bc);
                boolean z4 = this.xw && u(fAbs3, this.oa);
                if (z2 || z3 || z4) {
                    float[] fArr3 = this.gi;
                    fArr3[0] = 0.0f;
                    fArr3[1] = 0.0f;
                    fArr3[2] = 0.0f;
                    z = true;
                }
                z = false;
            } else {
                if (u(fAbs, this.f5173a) || u(fAbs2, this.f5173a) || u(fAbs3, this.f5173a)) {
                    float[] fArr4 = this.gi;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z = true;
                }
                z = false;
            }
            if (z && System.currentTimeMillis() - this.x > 2000) {
                u uVar = this.l;
                if (uVar != null) {
                    uVar.u(getType());
                }
                this.x = System.currentTimeMillis();
            }
            nr nrVar = this.mv;
            if (nrVar != null) {
                float[] fArr5 = this.gi;
                nrVar.u(fArr5[0], fArr5[1], fArr5[2]);
            }
        }
        this.z = sensorEvent.timestamp;
    }

    public void iz(int i) {
        t tVar = this.t;
        if (tVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.my == null && tVar != null) {
                this.my = tVar.u(4);
            }
            if (this.my != null) {
                this.bg = i;
                return;
            }
        }
        this.bg = 0;
    }

    public void u(u uVar) {
        this.l = uVar;
    }

    public void u(nr nrVar) {
        this.mv = nrVar;
    }

    public static void u(kj kjVar) {
        mk = kjVar;
    }

    public boolean u(int i) {
        kj kjVar;
        if (i > 0 && (kjVar = mk) != null && !kjVar.u(i)) {
            mk.u(i, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.qq.1
                @Override // java.lang.Runnable
                public void run() {
                    qq.this.b();
                }
            });
            return true;
        }
        return b();
    }

    public void fx(int i) {
        this.yd = false;
        u(i);
    }

    private void u(SensorEvent sensorEvent) {
        if (this.d != 0) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = (sensorEvent.timestamp - r0) * 1.0E-9f;
            float f5 = this.h;
            if (f5 != 0.0f) {
                if (nr(f5, f) && nr(this.h, f2) && nr(this.h, f3)) {
                    u(f, f2, f3, f4);
                } else {
                    nr(true);
                }
            } else {
                float f6 = this.eh;
                if (f6 != 0.0f && this.ja >= f6) {
                    nr(true);
                } else {
                    u(f, f2, f3, f4);
                }
            }
            if (this.bg == 7) {
                x(this.f5173a);
            } else {
                b(this.f5173a);
            }
            nr nrVar = this.mv;
            if (nrVar != null) {
                float[] fArr2 = this.bf;
                nrVar.u(fArr2[0], fArr2[1], fArr2[2]);
            }
        }
        this.d = sensorEvent.timestamp;
    }

    public void fx(JSONObject jSONObject) {
        if (this.qq != 1) {
            return;
        }
        if (jSONObject == null) {
            this.ay = 0;
            this.v = 0;
        } else {
            this.ay = jSONObject.optInt("double_direct_conf", 0);
            this.v = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void fx(float f) {
        this.sx = f;
    }

    private boolean nr(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void nr(boolean z) {
        float[] fArr = this.bf;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private boolean u(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.bf[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.bf[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.bf[2]));
        if (this.xg) {
            boolean z2 = this.m && u(fAbs, this.f5174jp);
            boolean z3 = this.y && u(fAbs2, this.bc);
            boolean z4 = this.xw && u(fAbs3, this.oa);
            if (z2 || z3 || z4) {
                return u(z, z2, z3, z4);
            }
            return false;
        }
        boolean zU = u(fAbs, f);
        boolean zU2 = u(fAbs2, f);
        boolean zU3 = u(fAbs3, f);
        if (zU || zU2 || zU3) {
            return u(z, zU, zU2, zU3);
        }
        return false;
    }

    public void nr(float f) {
        this.f5173a = f;
    }

    public void nr(JSONObject jSONObject) {
        if (this.qq != 2) {
            return;
        }
        if (jSONObject == null) {
            this.v = 0;
        } else {
            this.v = jSONObject.optInt("double_direct_match", 0);
        }
    }

    private void nr(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iU = u(fArr[0], this.w);
            int iU2 = u(fArr[1], this.cj);
            int iU3 = u(fArr[2], this.tk);
            if (nr(iU, iU2, iU3, true)) {
                u(iU, iU2, iU3, true);
                a();
            } else if (this.v == 1) {
                this.w = iU;
                this.cj = iU2;
                this.tk = iU3;
            } else {
                this.w = iU | this.w;
                this.cj |= iU2;
                this.tk = iU3 | this.tk;
            }
        }
    }

    private void u(float f, float f2, float f3, float f4) {
        float[] fArr = this.bf;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    public void u(float f) {
        this.n = f;
    }

    public void u(fx fxVar) {
        this.lf = fxVar;
    }

    public void u(JSONObject jSONObject) {
        if (this.qq != 2) {
            return;
        }
        this.pb = jSONObject;
        if (jSONObject == null) {
            this.m = false;
            this.y = false;
            this.xw = false;
        } else {
            this.m = jSONObject.has("x_threshold");
            this.f5174jp = u(this.pb.optDouble("x_threshold", 50.0d));
            this.y = this.pb.has("y_threshold");
            this.bc = u(this.pb.optDouble("y_threshold", 50.0d));
            this.xw = this.pb.has("z_threshold");
            this.oa = u(this.pb.optDouble("z_threshold", 50.0d));
        }
        this.xg = this.m || this.y || this.xw;
    }

    private boolean nr(int i, int i2, int i3, boolean z) {
        boolean zU;
        boolean zU2;
        boolean zU3;
        boolean zU4;
        int i4 = this.ay;
        if (i4 == 1) {
            int i5 = this.tk;
            zU = z ? u(i3, i5) : u(i3, i5, this.mh);
        } else if (i4 == 2) {
            int i6 = this.cj;
            zU = z ? u(i2, i6) : u(i2, i6, this.su);
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z) {
                        zU2 = u(i, this.w);
                        zU3 = u(i2, this.cj);
                        zU4 = u(i3, this.tk);
                    } else {
                        zU2 = u(i, this.w, this.wi);
                        zU3 = u(i2, this.cj, this.su);
                        zU4 = u(i3, this.tk, this.mh);
                    }
                    if (zU2 || zU3 || zU4) {
                        return true;
                    }
                } else if (z) {
                    if (u(i, this.w) && u(i2, this.cj) && u(i3, this.tk)) {
                        return true;
                    }
                } else if (u(i, this.w, this.wi) && u(i2, this.cj, this.su) && u(i3, this.tk, this.mh)) {
                    return true;
                }
                return false;
            }
            int i7 = this.w;
            zU = z ? u(i, i7) : u(i, i7, this.wi);
        }
        return zU;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public boolean u() {
        return this.c;
    }

    private float u(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    private void u(boolean z, double d) {
        if (!n() && z) {
            a();
            return;
        }
        if (z) {
            this.dw = System.currentTimeMillis();
            this.q = true;
            pn((float) d);
        } else {
            if (!this.q || System.currentTimeMillis() - this.dw < 500) {
                return;
            }
            this.c = false;
            jk();
        }
    }

    private void u(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iU = u(fArr[0], this.w);
            int iU2 = u(fArr[1], this.cj);
            int iU3 = u(fArr[2], this.tk);
            if (nr(iU, iU2, iU3, false)) {
                u(iU, iU2, iU3, true);
                a();
                return;
            }
            this.w |= iU;
            if (iU <= 0) {
                iU = this.wi;
            }
            this.wi = iU;
            this.cj |= iU2;
            if (iU2 <= 0) {
                iU2 = this.su;
            }
            this.su = iU2;
            this.tk |= iU3;
            if (iU3 <= 0) {
                iU3 = this.mh;
            }
            this.mh = iU3;
        }
    }

    private boolean u(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            nr(false);
            return true;
        }
        int iIz = z2 ? iz(this.bf[0]) : 0;
        int iIz2 = z3 ? iz(this.bf[1]) : 0;
        int iIz3 = z4 ? iz(this.bf[2]) : 0;
        if (this.bg != 7) {
            nr(false);
        }
        if (!u(iIz, this.w) && !u(iIz2, this.cj) && !u(iIz3, this.tk)) {
            if (this.v != 1) {
                u(iIz, iIz2, iIz3, false);
            } else if (z2 || z3 || z4) {
                this.w = iIz;
                this.cj = iIz2;
                this.tk = iIz3;
            }
            return false;
        }
        u(iIz, iIz2, iIz3, true);
        return true;
    }

    private void u(int i, int i2, int i3, boolean z) {
        if (z) {
            this.w = 0;
            this.cj = 0;
            this.tk = 0;
            this.wi = 0;
            this.su = 0;
            this.mh = 0;
            return;
        }
        if (i == 0) {
            i = this.w;
        }
        this.w = i;
        if (i2 == 0) {
            i2 = this.cj;
        }
        this.cj = i2;
        if (i3 == 0) {
            i3 = this.tk;
        }
        this.tk = i3;
    }

    private int u(float f, int i) {
        if (f != 0.0f) {
            return iz(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }
}
