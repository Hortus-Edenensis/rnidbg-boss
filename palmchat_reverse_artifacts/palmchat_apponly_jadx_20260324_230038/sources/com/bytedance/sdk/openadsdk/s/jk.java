package com.bytedance.sdk.openadsdk.s;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    private static SensorManager iz;
    public static u u;
    protected static final float[] nr = new float[3];
    protected static final float[] fx = new float[3];
    protected static final float[] b = new float[9];
    protected static final float[] pn = new float[3];

    public static void b(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (u()) {
                return;
            }
            u uVar = u;
            if (uVar == null || !uVar.fx()) {
                SensorManager sensorManagerU = u(context);
                sensorManagerU.registerListener(sensorEventListener, sensorManagerU.getDefaultSensor(1), u(i));
                sensorManagerU.registerListener(sensorEventListener, sensorManagerU.getDefaultSensor(2), u(i));
            }
        } catch (Throwable th) {
            x.u("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void fx(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (u()) {
                return;
            }
            u uVar = u;
            if (uVar == null || !uVar.fx()) {
                SensorManager sensorManagerU = u(context);
                sensorManagerU.registerListener(sensorEventListener, sensorManagerU.getDefaultSensor(10), u(i));
            }
        } catch (Throwable th) {
            x.u("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void nr(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (u()) {
                return;
            }
            u uVar = u;
            if (uVar == null || !uVar.fx()) {
                SensorManager sensorManagerU = u(context);
                sensorManagerU.registerListener(sensorEventListener, sensorManagerU.getDefaultSensor(4), u(i));
            }
        } catch (Throwable th) {
            x.u("SensorHub", "startListenGyroscope error", th);
        }
    }

    private static int u(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void u(u uVar) {
        u = uVar;
    }

    private static SensorManager u(Context context) {
        if (iz == null) {
            synchronized (jk.class) {
                if (iz == null) {
                    iz = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return iz;
    }

    private static boolean u() {
        u uVar = u;
        return uVar == null || !uVar.nr();
    }

    public static void u(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (u()) {
                return;
            }
            u uVar = u;
            if (uVar == null || !uVar.fx()) {
                SensorManager sensorManagerU = u(context);
                sensorManagerU.registerListener(sensorEventListener, sensorManagerU.getDefaultSensor(1), u(i));
            }
        } catch (Throwable th) {
            x.u("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void u(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            u(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            x.u("SensorHub", "stopListen error", th);
        }
    }

    public static void u(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
