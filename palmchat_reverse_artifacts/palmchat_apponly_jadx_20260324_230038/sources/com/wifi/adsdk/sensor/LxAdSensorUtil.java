package com.wifi.adsdk.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.wifi.adsdk.utils.LxAdLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdSensorUtil {
    private static ArrayList<OnShakeListener> allListener = new ArrayList<>();
    private static Sensor mAccelerometer = null;
    private static SensorManager mSensorManager = null;
    private static ShakeDetector mShakeDetector = null;
    public static boolean sensorDone = false;

    public static synchronized void initSensor(Context context) {
        if (!sensorDone) {
            try {
                sensorDone = true;
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                mSensorManager = sensorManager;
                mAccelerometer = sensorManager.getDefaultSensor(1);
                ShakeDetector shakeDetector = new ShakeDetector();
                mShakeDetector = shakeDetector;
                mSensorManager.registerListener(shakeDetector, mAccelerometer, 2);
                LxAdLog.d("LxAd LxAdSensorUtil initSensor mSensorManager " + mSensorManager);
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void onDestroy() {
        ShakeDetector shakeDetector;
        allListener.clear();
        try {
            LxAdLog.d("LxAd LxAdSensorUtil onDestroy mSensorManager " + mSensorManager);
            SensorManager sensorManager = mSensorManager;
            if (sensorManager != null && (shakeDetector = mShakeDetector) != null) {
                sensorManager.unregisterListener(shakeDetector);
                mSensorManager = null;
                mShakeDetector = null;
            }
            sensorDone = false;
        } catch (Exception unused) {
        }
    }

    public static synchronized void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            if (allListener.size() > 0) {
                for (int size = allListener.size() - 1; size >= 0; size--) {
                    OnShakeListener onShakeListener = allListener.get(size);
                    if (onShakeListener.curViewVisible()) {
                        onShakeListener.onSensorChanged(sensorEvent);
                        return;
                    }
                }
            }
        }
    }

    public static synchronized void removeShakeListener(OnShakeListener onShakeListener) {
        if (onShakeListener != null) {
            if (allListener.contains(onShakeListener)) {
                allListener.remove(onShakeListener);
                LxAdLog.d("LxAdSensorUtil removeShakeListener listener " + onShakeListener.getCurAdSrcId());
            }
            LxAdLog.d("LxAdSensorUtil removeShakeListener allListener size " + allListener.size());
        } else {
            LxAdLog.d("LxAdSensorUtil removeShakeListener allListener size " + allListener.size());
        }
    }

    public static synchronized void setOnShakeListener(OnShakeListener onShakeListener) {
        if (onShakeListener != null) {
            if (!allListener.contains(onShakeListener)) {
                allListener.add(onShakeListener);
            }
            LxAdLog.d("LxAdSensorUtil setOnShakeListener allListener size " + allListener.size());
        } else {
            LxAdLog.d("LxAdSensorUtil setOnShakeListener allListener size " + allListener.size());
        }
    }
}
