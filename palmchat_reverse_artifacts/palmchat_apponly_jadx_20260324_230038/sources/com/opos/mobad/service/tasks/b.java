package com.opos.mobad.service.tasks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.omes.scorpion.OmasStub;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f9248a;
    private Map<Integer, float[]> b;

    public Map<Integer, float[]> a(Context context, int[] iArr, int i) {
        return (Map) OmasStub.omasObject(0, new Object[]{this, context, iArr, Integer.valueOf(i)});
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        OmasStub.omasVoid(2, new Object[]{this, sensor, Integer.valueOf(i)});
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        OmasStub.omasVoid(3, new Object[]{this, sensorEvent});
    }

    public void a() {
        OmasStub.omasVoid(1, new Object[]{this});
    }
}
