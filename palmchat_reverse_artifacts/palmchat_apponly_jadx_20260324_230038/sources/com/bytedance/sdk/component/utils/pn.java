package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements t {
    private static volatile pn u;
    private volatile Sensor b;
    private volatile Sensor fx;
    private volatile Sensor iz;
    private final SensorManager nr;
    private volatile Sensor pn;
    private final ConcurrentHashMap<Sensor, CopyOnWriteArraySet<SensorEventListener>> x = new ConcurrentHashMap<>();
    private final SensorEventListener n = new SensorEventListener() { // from class: com.bytedance.sdk.component.utils.pn.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet;
            if (sensorEvent == null || sensorEvent.sensor == null || (copyOnWriteArraySet = (CopyOnWriteArraySet) pn.this.x.get(sensorEvent.sensor)) == null) {
                return;
            }
            for (SensorEventListener sensorEventListener : copyOnWriteArraySet) {
                if (sensorEventListener != null) {
                    sensorEventListener.onSensorChanged(sensorEvent);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    private pn(Context context) {
        this.nr = (SensorManager) context.getSystemService("sensor");
    }

    private Sensor b() {
        if (this.pn == null) {
            synchronized (pn.class) {
                if (this.pn == null) {
                    this.pn = this.nr.getDefaultSensor(4);
                }
            }
        }
        return this.pn;
    }

    private Sensor fx() {
        if (this.b == null) {
            synchronized (pn.class) {
                if (this.b == null) {
                    this.b = this.nr.getDefaultSensor(15);
                }
            }
        }
        return this.b;
    }

    private Sensor nr() {
        if (this.fx == null) {
            synchronized (pn.class) {
                if (this.fx == null) {
                    this.fx = this.nr.getDefaultSensor(1);
                }
            }
        }
        return this.fx;
    }

    private Sensor pn() {
        if (this.iz == null) {
            synchronized (pn.class) {
                if (this.iz == null) {
                    this.iz = this.nr.getDefaultSensor(10);
                }
            }
        }
        return this.iz;
    }

    public static pn u(Context context) {
        if (u == null) {
            synchronized (pn.class) {
                if (u == null) {
                    u = new pn(context);
                }
            }
        }
        return u;
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
        boolean zRegisterListener;
        if (sensorEventListener == null || sensor == null) {
            return false;
        }
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.x.get(sensor);
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.isEmpty()) {
            zRegisterListener = this.nr.registerListener(this.n, sensor, i);
            sensor.getName();
            sensorEventListener.hashCode();
        } else {
            zRegisterListener = true;
        }
        if (zRegisterListener) {
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.x.put(sensor, copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(sensorEventListener);
            sensor.getName();
            sensorEventListener.hashCode();
        }
        return zRegisterListener;
    }

    @Override // com.bytedance.sdk.component.utils.t
    public void u(SensorEventListener sensorEventListener) {
        if (sensorEventListener == null) {
            return;
        }
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.x.entrySet()) {
            if (entry != null) {
                Sensor key = entry.getKey();
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                if (value != null && value.contains(sensorEventListener)) {
                    value.remove(sensorEventListener);
                    if (key != null) {
                        key.getName();
                    }
                    sensorEventListener.hashCode();
                    if (value.isEmpty() && key != null) {
                        try {
                            this.nr.unregisterListener(this.n, key);
                        } catch (Throwable unused) {
                        }
                        key.getName();
                    }
                }
            }
        }
        u();
    }

    public int u() {
        CopyOnWriteArraySet<SensorEventListener> value;
        int size = 0;
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.x.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                size += value.size();
            }
        }
        return size;
    }
}
