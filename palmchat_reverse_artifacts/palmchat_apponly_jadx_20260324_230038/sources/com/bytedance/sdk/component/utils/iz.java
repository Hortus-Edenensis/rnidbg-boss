package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements SensorEventListener, t {
    private static volatile iz u;
    private volatile Sensor b;
    private volatile Sensor fx;
    private volatile Sensor iz;
    private final SensorManager nr;
    private volatile Sensor pn;
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f5172a = new AtomicBoolean(false);
    private final AtomicBoolean jk = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> t = new ConcurrentHashMap();

    private iz(Context context) {
        this.nr = (SensorManager) context.getSystemService("sensor");
    }

    private Sensor b() {
        if (this.pn == null) {
            synchronized (iz.class) {
                if (this.pn == null) {
                    this.pn = this.nr.getDefaultSensor(4);
                }
            }
        }
        return this.pn;
    }

    private Sensor fx() {
        if (this.b == null) {
            synchronized (iz.class) {
                if (this.b == null) {
                    this.b = this.nr.getDefaultSensor(15);
                }
            }
        }
        return this.b;
    }

    private Sensor nr() {
        if (this.fx == null) {
            synchronized (iz.class) {
                if (this.fx == null) {
                    this.fx = this.nr.getDefaultSensor(1);
                }
            }
        }
        return this.fx;
    }

    private Sensor pn() {
        if (this.iz == null) {
            synchronized (iz.class) {
                if (this.iz == null) {
                    this.iz = this.nr.getDefaultSensor(10);
                }
            }
        }
        return this.iz;
    }

    public static iz u(Context context) {
        if (u == null) {
            synchronized (iz.class) {
                if (u == null) {
                    u = new iz(context);
                }
            }
        }
        return u;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.t.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.t
    public Sensor u(int i) {
        if (i == 1) {
            return nr();
        }
        if (i == 4) {
            return b();
        }
        if (i == 10) {
            return pn();
        }
        if (i != 15) {
            return null;
        }
        return fx();
    }

    @Override // com.bytedance.sdk.component.utils.t
    public boolean u(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        this.t.put(sensorEventListener, 0);
        if (sensor == this.fx) {
            if (!this.x.getAndSet(true)) {
                return this.nr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.b) {
            if (!this.n.getAndSet(true)) {
                return this.nr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.pn) {
            if (!this.f5172a.getAndSet(true)) {
                return this.nr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.iz && !this.jk.getAndSet(true)) {
            return this.nr.registerListener(this, sensor, i);
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.t
    public void u(SensorEventListener sensorEventListener) {
        this.t.remove(sensorEventListener);
        this.t.size();
        if (this.t.isEmpty()) {
            try {
                this.nr.unregisterListener(this);
            } catch (Throwable unused) {
            }
            this.x.set(false);
            this.n.set(false);
            this.f5172a.set(false);
            this.jk.set(false);
        }
    }

    public int u() {
        return this.t.size();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
