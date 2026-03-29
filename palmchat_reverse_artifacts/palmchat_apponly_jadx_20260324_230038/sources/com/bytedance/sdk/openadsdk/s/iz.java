package com.bytedance.sdk.openadsdk.s;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.wifi.ad.core.config.EventParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private WeakReference<n> nr;
    private Context u;
    private Map<String, u> fx = new HashMap();
    private SensorEventListener b = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.s.iz.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            n nVarB;
            if (sensorEvent.sensor.getType() != 1 || (nVarB = iz.this.b()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                nVarB.u("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private SensorEventListener pn = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.s.iz.12
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            n nVarB;
            if (sensorEvent.sensor.getType() != 4 || (nVarB = iz.this.b()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                nVarB.u("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private SensorEventListener iz = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.s.iz.23
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            n nVarB;
            if (sensorEvent.sensor.getType() != 10 || (nVarB = iz.this.b()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                nVarB.u("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private SensorEventListener x = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.s.iz.34
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = jk.nr;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = jk.fx;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = jk.b;
            SensorManager.getRotationMatrix(fArr5, null, jk.nr, jk.fx);
            float[] fArr6 = jk.pn;
            SensorManager.getOrientation(fArr5, fArr6);
            n nVarB = iz.this.b();
            if (nVarB == null) {
                return;
            }
            float f = fArr6[0];
            float f2 = fArr6[1];
            float f3 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                nVarB.u("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        JSONObject u(JSONObject jSONObject) throws Throwable;
    }

    public iz(n nVar) {
        this.u = nVar.getContext();
        this.nr = new WeakReference<>(nVar);
        fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n b() {
        WeakReference<n> weakReference = this.nr;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void fx() {
        this.fx.put("adInfo", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.45
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                if (nVarB == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectBg = nVarB.bg();
                if (jSONObjectBg != null) {
                    jSONObjectBg.put("code", 1);
                    return jSONObjectBg;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.fx.put("appInfo", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.56
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put(WfConstant.EVENT_KEY_APP_NAME, "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = iz.this.u().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                n nVarB = iz.this.b();
                if (nVarB != null) {
                    jSONObject2.put("deviceId", nVarB.iz());
                    jSONObject2.put(EventParams.KEY_PARAM_NETTYPE, nVarB.my());
                    jSONObject2.put("innerAppName", nVarB.fx());
                    jSONObject2.put(WfConstant.EVENT_KEY_APP_NAME, nVarB.b());
                    jSONObject2.put("appVersion", nVarB.pn());
                    Map<String, String> mapU = nVarB.u();
                    for (String str : mapU.keySet()) {
                        jSONObject2.put(str, mapU.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.fx.put("playableSDKInfo", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.61
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put(WfConstant.EVENT_KEY_APP_NAME, "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.fx.put("subscribe_app_ad", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.62
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("download_app_ad", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.63
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("isViewable", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.2
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                if (nVarB == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", nVarB.n());
                return jSONObject3;
            }
        });
        this.fx.put("getVolume", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.3
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                if (nVarB == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", nVarB.x());
                return jSONObject3;
            }
        });
        this.fx.put("getScreenSize", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.4
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                if (nVarB == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSx = nVarB.sx();
                jSONObjectSx.put("code", 1);
                return jSONObjectSx;
            }
        });
        this.fx.put("start_accelerometer_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.5
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.u("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                jk.u(iz.this.u, iz.this.b, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("close_accelerometer_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.6
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, iz.this.b);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("start_gyro_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.7
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.u("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                jk.nr(iz.this.u, iz.this.pn, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("close_gyro_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.8
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, iz.this.pn);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("start_accelerometer_grativityless_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.9
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.u("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                jk.fx(iz.this.u, iz.this.iz, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("close_accelerometer_grativityless_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.10
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, iz.this.iz);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("start_rotation_vector_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.11
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.u("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                jk.b(iz.this.u, iz.this.x, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("close_rotation_vector_observer", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.13
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, iz.this.x);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("device_shake", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.14
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("device_shake_short", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.15
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jk.u(iz.this.u, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.u("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.fx.put("playable_style", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.16
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectNr = nVarB.nr();
                jSONObjectNr.put("code", 1);
                return jSONObjectNr;
            }
        });
        this.fx.put("sendReward", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.17
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.dw();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("webview_time_track", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.18
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.fx.put("playable_event", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.19
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.nr(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("reportAd", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.20
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("close", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.21
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("openAdLandPageLinks", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.22
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("get_viewport", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.24
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectBq = nVarB.bq();
                jSONObjectBq.put("code", 1);
                return jSONObjectBq;
            }
        });
        this.fx.put("jssdk_load_finish", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.25
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.h();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_material_render_result", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.26
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.t(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("detect_change_playable_click", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.27
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectA = nVarB.a();
                jSONObjectA.put("code", 1);
                return jSONObjectA;
            }
        });
        this.fx.put("check_camera_permission", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.28
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectL = nVarB.l();
                jSONObjectL.put("code", 1);
                return jSONObjectL;
            }
        });
        this.fx.put("check_external_storage", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.29
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectMv = nVarB.mv();
                if (jSONObjectMv.isNull("result")) {
                    jSONObjectMv.put("code", -1);
                } else {
                    jSONObjectMv.put("code", 1);
                }
                return jSONObjectMv;
            }
        });
        this.fx.put("playable_open_camera", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.30
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.u(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_pick_photo", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.31
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.nr(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_download_media_in_photos", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.32
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.fx(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_preventTouchEvent", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.33
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.b(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_settings_info", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.35
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectS = nVarB.s();
                jSONObjectS.put("code", 1);
                return jSONObjectS;
            }
        });
        this.fx.put("playable_load_main_scene", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.36
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.c();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_enter_section", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.37
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.iz(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_end", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.38
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.q();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_finish_play_playable", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.39
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.qq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_transfrom_module_show", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.40
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.kj();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_transfrom_module_change_color", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.41
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.z();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_set_scroll_rect", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.42
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_click_area", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.43
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.x(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_real_play_start", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.44
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_material_first_frame_show", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.46
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.gi();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_stuck_check_pong", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.47
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.d();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_material_adnormal_mask", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.48
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                nVarB.n(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_long_press_panel", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.49
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_alpha_player_play", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.50
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_transfrom_module_highlight", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.51
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_send_click_event", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.52
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_query_media_permission_declare", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.53
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectA = nVarB.a(jSONObject);
                jSONObjectA.put("code", 1);
                return jSONObjectA;
            }
        });
        this.fx.put("playable_query_media_permission_enable", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.54
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                n nVarB = iz.this.b();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarB == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectJk = nVarB.jk(jSONObject);
                jSONObjectJk.put("code", 1);
                return jSONObjectJk;
            }
        });
        this.fx.put("playable_apply_media_permission", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.55
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_start_kws", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.57
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_close_kws", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.58
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_video_preload_task_add", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.59
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.fx.put("playable_video_preload_task_cancel", new u() { // from class: com.bytedance.sdk.openadsdk.s.iz.60
            @Override // com.bytedance.sdk.openadsdk.s.iz.u
            public JSONObject u(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.s.u uVarPn = iz.this.pn();
                JSONObject jSONObject2 = new JSONObject();
                if (uVarPn == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.s.u pn() {
        n nVarB = b();
        if (nVarB == null) {
            return null;
        }
        return nVarB.o();
    }

    public void nr() {
        jk.u(this.u, this.b);
        jk.u(this.u, this.pn);
        jk.u(this.u, this.iz);
        jk.u(this.u, this.x);
    }

    public Set<String> u() {
        return this.fx.keySet();
    }

    public JSONObject u(String str, JSONObject jSONObject) {
        try {
            u uVar = this.fx.get(str);
            if (uVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return uVar.u(jSONObject);
        } catch (Throwable th) {
            x.u("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
