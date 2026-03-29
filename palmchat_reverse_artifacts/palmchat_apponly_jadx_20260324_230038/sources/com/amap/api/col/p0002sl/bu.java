package com.amap.api.col.p0002sl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Marker;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class bu implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f2660a;
    private Sensor b;
    private float e;
    private Context f;
    private ah g;
    private Marker h;
    private long c = 0;
    private final int d = 100;
    private boolean i = true;

    public bu(Context context, ah ahVar) {
        this.f = context.getApplicationContext();
        this.g = ahVar;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f2660a = sensorManager;
            this.b = sensorManager.getDefaultSensor(3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        Sensor sensor;
        SensorManager sensorManager = this.f2660a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 3);
    }

    public final void b() {
        Sensor sensor;
        SensorManager sensorManager = this.f2660a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.unregisterListener(this, sensor);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.c >= 100 && sensorEvent.sensor.getType() == 3) {
                float fA = (sensorEvent.values[0] + a(this.f)) % 360.0f;
                if (fA > 180.0f) {
                    fA -= 360.0f;
                } else if (fA < -180.0f) {
                    fA += 360.0f;
                }
                if (Math.abs(this.e - fA) >= 3.0f) {
                    if (Float.isNaN(fA)) {
                        fA = 0.0f;
                    }
                    this.e = fA;
                    Marker marker = this.h;
                    if (marker != null) {
                        try {
                            if (this.i) {
                                CameraPosition cameraPosition = this.g.getCameraPosition();
                                this.g.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(cameraPosition.target, cameraPosition.zoom, cameraPosition.tilt, this.e)));
                                this.h.setRotateAngle(-this.e);
                            } else {
                                marker.setRotateAngle(360.0f - fA);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    this.c = System.currentTimeMillis();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void a(Marker marker) {
        this.h = marker;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    private static int a(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            return rotation != 2 ? rotation != 3 ? 0 : -90 : EffectConstants.ROTATION_DEGREES_180;
        }
        return 90;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
