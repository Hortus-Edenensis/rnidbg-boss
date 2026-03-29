package com.bytedance.sdk.component.panglearmor.nr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.panglearmor.iz;
import com.bytedance.sdk.component.utils.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements SensorEventListener {
    private static volatile b u;
    private volatile u bg;
    private Sensor k;
    private Sensor s;
    private volatile boolean nr = false;
    private final List<Float> fx = new ArrayList(1);
    private final List<Float> b = new ArrayList(1);
    private final List<Float> pn = new ArrayList(1);
    private final List<Float> iz = new ArrayList(1);
    private final List<Float> x = new ArrayList(1);
    private final List<Float> n = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5167a = 0;
    private final int jk = 1;
    private final int t = 2;
    private final int l = 16;
    private final int mv = 32;
    private long my = 0;
    private volatile boolean o = false;
    private volatile AtomicInteger sx = new AtomicInteger(0);
    private volatile int bq = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(JSONObject jSONObject);
    }

    private b() {
        this.s = null;
        this.k = null;
        SensorManager sensorManager = (SensorManager) iz.fx().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.s = sensorManager.getDefaultSensor(1);
                this.k = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.sx.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.fx.size() > 0) {
                iz();
                return;
            }
            this.fx.add(Float.valueOf(sensorEvent.values[0]));
            this.b.add(Float.valueOf(sensorEvent.values[1]));
            this.pn.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.iz.size() > 0) {
            iz();
            return;
        }
        this.iz.add(Float.valueOf(sensorEvent.values[0]));
        this.x.add(Float.valueOf(sensorEvent.values[1]));
        this.n.add(Float.valueOf(sensorEvent.values[2]));
    }

    private synchronized void iz() {
        if (!this.nr && this.fx.size() > 0 && this.iz.size() > 0) {
            this.nr = true;
            pn();
            x.nr(new a("har") { // from class: com.bytedance.sdk.component.panglearmor.nr.b.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrU = fx.u(b.this.fx, b.this.b, b.this.pn, b.this.iz, b.this.x, b.this.n);
                        b.this.u(fArrU);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jIz = pn.u().iz();
                        long jX = pn.u().x();
                        int iFx = (int) (((pn.u().fx() / 1000) / 60) / 60);
                        if (iFx <= 0) {
                            iFx = 1;
                        }
                        jSONObject.put("azimuth_unit", jIz);
                        jSONObject.put("angle_unit", jX);
                        LinkedList<JSONObject> linkedListU = nr.u().u(0L);
                        jSONObject.put("active", Arrays.toString(fx.u(linkedListU, iFx)));
                        com.bytedance.sdk.component.panglearmor.nr.u.u().u(iFx);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.nr.u.u().fx()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.nr.u.u().nr()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.nr.u.u().b());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.nr.u.u().pn());
                        int[][] iArrU = fx.u(linkedListU, jIz, jX);
                        jSONObject.put("ax", Arrays.toString(iArrU[0]));
                        jSONObject.put("ay", Arrays.toString(iArrU[1]));
                        jSONObject.put("az", Arrays.toString(iArrU[2]));
                        int[][] iArrU2 = fx.u(nr.u().u(10800000L), jIz, jX);
                        jSONObject.put("ax3", Arrays.toString(iArrU2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrU2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrU2[2]));
                        int[][] iArrU3 = fx.u(nr.u().u(21600000L), jIz, jX);
                        jSONObject.put("ax6", Arrays.toString(iArrU3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrU3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrU3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrU));
                        jSONObject.put("timestamp", jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (b.this.bg != null) {
                        b.this.bg.u(jSONObject);
                    }
                    b.this.x();
                    b.this.o = false;
                }
            });
        } else {
            if (this.sx.get() > 3) {
                pn();
                x();
                this.o = false;
            }
        }
    }

    private void pn() {
        this.sx = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) iz.fx().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.s;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.k;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.fx.clear();
        this.b.clear();
        this.pn.clear();
        this.iz.clear();
        this.x.clear();
        this.n.clear();
    }

    public long b() {
        return this.my;
    }

    public boolean fx() {
        return this.o;
    }

    public synchronized boolean nr() {
        int i;
        int i2;
        this.bq = 0;
        if (this.o) {
            return false;
        }
        if (this.s == null || this.k == null) {
            this.bq |= this.s == null ? 2 : 0;
            int i3 = this.bq;
            if (this.k == null) {
                i = i3;
                i2 = 16;
            } else {
                i = i3;
                i2 = 0;
            }
        } else {
            this.o = false;
            SensorManager sensorManager = (SensorManager) iz.fx().getApplicationContext().getSystemService("sensor");
            i2 = 1;
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.s, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.k, 1);
                    if (zRegisterListener && zRegisterListener2) {
                        this.o = true;
                        this.nr = false;
                    } else {
                        this.bq |= 32;
                        pn();
                        x();
                    }
                } catch (Exception unused) {
                    i = this.bq;
                    i2 = 32;
                    this.bq = i | i2;
                }
                return this.o;
            }
            i = this.bq;
        }
        this.bq = i | i2;
        return this.o;
    }

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    public void u(u uVar) {
        this.bg = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float[] fArr) {
        this.my = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", b());
            jSONObject.put("val", new JSONArray(fArr));
            nr.u().u(jSONObject, "sp_angle");
            nr.u().u(o.fx(iz.fx()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
