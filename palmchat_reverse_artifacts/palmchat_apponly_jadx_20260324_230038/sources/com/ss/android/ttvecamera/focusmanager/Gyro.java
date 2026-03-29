package com.ss.android.ttvecamera.focusmanager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.ss.android.ttvecamera.TELogUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Gyro {
    private static final float ANGLE_TOLERANCE = 0.5f;
    private static final float NS2S = 1.0E-9f;
    private static final float SPEED_TOLERANCE = 0.5f;
    private static final String TAG = "Gyro";
    private final Sensor mSensor;
    private final SensorManager mSensorManager;
    private float mTimestamp;
    private final float[] mAngles = new float[3];
    private final CopyOnWriteArrayList<GyroListener> mListeners = new CopyOnWriteArrayList<>();
    private final SensorEventListener mSensorEventListener = new SensorEventListener() { // from class: com.ss.android.ttvecamera.focusmanager.Gyro.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (Gyro.this.mTimestamp != 0.0f) {
                float f = (sensorEvent.timestamp - Gyro.this.mTimestamp) * Gyro.NS2S;
                float[] fArr = sensorEvent.values;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                float[] fArr2 = Gyro.this.mAngles;
                fArr2[0] = fArr2[0] + (sensorEvent.values[0] * f);
                float[] fArr3 = Gyro.this.mAngles;
                fArr3[1] = fArr3[1] + (sensorEvent.values[1] * f);
                float[] fArr4 = Gyro.this.mAngles;
                fArr4[2] = fArr4[2] + (sensorEvent.values[2] * f);
                float fSqrt2 = (float) Math.sqrt((Gyro.this.mAngles[0] * Gyro.this.mAngles[0]) + (Gyro.this.mAngles[1] * Gyro.this.mAngles[1]) + (Gyro.this.mAngles[2] * Gyro.this.mAngles[2]));
                if (fSqrt > 0.5f || fSqrt2 > 0.5f) {
                    TELogUtils.d(Gyro.TAG, "onSensorChanged omegaMagnitude = " + fSqrt + " angle = " + fSqrt2);
                    Iterator it = Gyro.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((GyroListener) it.next()).onChange();
                    }
                    Gyro.this.clearAngle();
                }
            }
            Gyro.this.mTimestamp = sensorEvent.timestamp;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface GyroListener {
        void onChange();
    }

    public Gyro(Context context) {
        TELogUtils.d(TAG, TAG);
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            this.mSensor = sensorManager.getDefaultSensor(4);
        } else {
            this.mSensorManager = null;
            this.mSensor = null;
            TELogUtils.e(TAG, "Gyro init failed, no context");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAngle() {
        TELogUtils.d(TAG, "clearAngle");
        float[] fArr = this.mAngles;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void destroy() {
        TELogUtils.i(TAG, "destroy");
        this.mListeners.clear();
        clearAngle();
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.mSensorEventListener, this.mSensor);
        }
    }

    public void register(GyroListener gyroListener, Handler handler) {
        if (this.mSensorManager == null || this.mListeners.contains(gyroListener)) {
            return;
        }
        TELogUtils.i(TAG, "register");
        this.mListeners.add(gyroListener);
        if (this.mListeners.size() == 1) {
            try {
                this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensor, 3, handler);
            } catch (RuntimeException e) {
                TELogUtils.w(TAG, "sensorManager register listener exception occurred.", e);
                this.mListeners.remove(gyroListener);
            }
            TELogUtils.d(TAG, "sensorManager register listener");
        }
        clearAngle();
    }

    public void unregister(GyroListener gyroListener) {
        if (this.mSensorManager == null) {
            return;
        }
        TELogUtils.i(TAG, MiPushClient.COMMAND_UNREGISTER);
        this.mListeners.remove(gyroListener);
        if (this.mListeners.isEmpty()) {
            this.mSensorManager.unregisterListener(this.mSensorEventListener, this.mSensor);
            TELogUtils.d(TAG, "sensorManager unregister listener");
        }
        clearAngle();
    }
}
