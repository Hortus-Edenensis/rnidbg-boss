package com.bytedance.sdk.component.utils;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface t {
    Sensor u(int i);

    void u(SensorEventListener sensorEventListener);

    boolean u(SensorEventListener sensorEventListener, Sensor sensor, int i);
}
