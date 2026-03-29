package com.wifi.adsdk.sensor;

import android.hardware.SensorEvent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface OnShakeListener {
    boolean curViewVisible();

    String getCurAdSrcId();

    void onSensorChanged(SensorEvent sensorEvent);
}
