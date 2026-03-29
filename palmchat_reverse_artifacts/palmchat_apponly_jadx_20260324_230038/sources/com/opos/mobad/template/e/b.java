package com.opos.mobad.template.e;

import android.hardware.SensorEventListener;
import com.opos.mobad.d.c.c;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f9426a;
    private final Map<SensorEventListener, Long> b = new ConcurrentHashMap();
    private AtomicBoolean c = new AtomicBoolean(true);

    private b() {
    }

    public static b a() {
        if (f9426a == null) {
            synchronized (b.class) {
                if (f9426a == null) {
                    f9426a = new b();
                }
            }
        }
        return f9426a;
    }

    private long b() {
        long jMax = 0;
        try {
            if (!this.b.isEmpty()) {
                for (Long l : this.b.values()) {
                    if (l != null) {
                        jMax = Math.max(l.longValue(), jMax);
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ShakeListenerManager", "getMaxRenderTime() fail", e);
        }
        return jMax;
    }

    public boolean b(SensorEventListener sensorEventListener) {
        String str;
        if (!this.c.get()) {
            str = "canShake(): false because mStatus.get()=false";
        } else {
            if (sensorEventListener != null && this.b.containsKey(sensorEventListener)) {
                Long l = this.b.get(sensorEventListener);
                long jLongValue = l == null ? -1L : l.longValue();
                long jB = b();
                boolean z = jLongValue >= jB;
                com.opos.cmn.an.f.a.b("ShakeListenerManager", "canShake(): canShake=", Boolean.valueOf(z), "rt=", Long.valueOf(jLongValue), "maxRt=", Long.valueOf(jB), "listener=", sensorEventListener);
                a(z);
                return z;
            }
            str = "canShake(): false listener is empty || not containsKey listener";
        }
        com.opos.cmn.an.f.a.b("ShakeListenerManager", str);
        return false;
    }

    public void a(SensorEventListener sensorEventListener) {
        if (sensorEventListener != null && this.b.containsKey(sensorEventListener)) {
            try {
                this.b.remove(sensorEventListener);
                com.opos.cmn.an.f.a.b("ShakeListenerManager", "unregisterListener() listener=", sensorEventListener);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ShakeListenerManager", "unregisterListener() fail", e);
            }
        }
    }

    public void a(SensorEventListener sensorEventListener, long j) {
        if (sensorEventListener == null || this.b.containsKey(sensorEventListener)) {
            return;
        }
        try {
            this.b.put(sensorEventListener, Long.valueOf(j));
            com.opos.cmn.an.f.a.b("ShakeListenerManager", "registerListener() rt=", Long.valueOf(j), "listener=", sensorEventListener);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ShakeListenerManager", "registerListener() fail", e);
        }
    }

    private void a(boolean z) {
        if (z) {
            this.c.compareAndSet(true, false);
            c.a(new Runnable() { // from class: com.opos.mobad.template.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c.compareAndSet(false, true);
                }
            }, 1000L);
        }
    }
}
