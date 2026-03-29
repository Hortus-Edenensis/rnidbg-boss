package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class bk {
    private static bk bfG;
    private SensorManager bfH;

    public static bk Tt() {
        if (bfG == null) {
            synchronized (bk.class) {
                if (bfG == null) {
                    bfG = new bk();
                }
            }
        }
        return bfG;
    }

    private static boolean Tu() {
        return !bc.useSensorManagerDisable();
    }

    private boolean Tv() {
        boolean zTu = Tu();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + zTu);
        if (zTu) {
            return true;
        }
        this.bfH = null;
        return false;
    }

    private SensorManager dY(Context context) {
        if (this.bfH == null) {
            this.bfH = (SensorManager) context.getSystemService("sensor");
        }
        return this.bfH;
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (Tv()) {
            return dY(context);
        }
        return null;
    }

    public final Sensor getDefaultSensor(Context context, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i);
        if (Tv()) {
            return dY(context).getDefaultSensor(i);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!Tv()) {
            return false;
        }
        try {
            return dY(context).registerListener(sensorEventListener, sensor, i);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (Tv() && (sensorManager = this.bfH) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
