package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s55 implements SensorEventListener {
    public static String g = "s55";
    public static s55 h;
    public Context e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f20669a = null;
    public PowerManager.WakeLock b = null;
    public Sensor c = null;
    public PowerManager d = null;
    public boolean f = false;

    public s55(Context context) {
        this.e = context;
        d();
    }

    public static s55 c(Context context) {
        if (h == null) {
            synchronized (s55.class) {
                if (h == null) {
                    h = new s55(context);
                }
            }
        }
        return h;
    }

    public void a() {
        if (this.b != null) {
            SensorManager sensorManager = this.f20669a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            if (this.b.isHeld()) {
                this.b.release();
            }
            this.b = null;
            this.d = null;
            this.f20669a = null;
        }
    }

    public void b() {
        h = null;
    }

    public void d() {
        Context context = this.e;
        this.e = context;
        if (this.b == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f20669a = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(8);
            this.c = defaultSensor;
            if (defaultSensor != null) {
                this.f20669a.registerListener(this, defaultSensor, 3);
            }
            PowerManager powerManager = (PowerManager) this.e.getSystemService("power");
            this.d = powerManager;
            this.b = powerManager.newWakeLock(32, g);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        a();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock != null) {
            if (sensorEvent.values[0] == 0.0d) {
                this.f = true;
                if (wakeLock.isHeld()) {
                    return;
                }
                this.b.acquire();
                return;
            }
            this.f = false;
            if (wakeLock.isHeld()) {
                this.b.release();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
