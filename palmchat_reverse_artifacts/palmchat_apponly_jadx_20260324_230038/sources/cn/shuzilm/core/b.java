package cn.shuzilm.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2464a;
    final /* synthetic */ SensorManager b;
    final /* synthetic */ DUHelper c;

    public b(DUHelper dUHelper, Context context, SensorManager sensorManager) {
        this.c = dUHelper;
        this.f2464a = context;
        this.b = sensorManager;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            sensorEvent.sensor.getType();
            for (float f : fArr) {
            }
            DUHelper.onSensorChanged(this.f2464a, sensorEvent);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.b.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
