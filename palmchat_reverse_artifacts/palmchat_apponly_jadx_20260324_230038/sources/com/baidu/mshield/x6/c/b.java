package com.baidu.mshield.x6.c;

import android.os.Build;
import android.view.InputDevice;
import com.baidu.mshield.x6.f.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static String a() {
        try {
            int[] deviceIds = InputDevice.getDeviceIds();
            JSONArray jSONArray = new JSONArray();
            for (int i : deviceIds) {
                InputDevice device = InputDevice.getDevice(i);
                if (device != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", device.getName());
                    jSONObject.put("1", device.isVirtual() ? 1 : 0);
                    jSONObject.put("2", device.getVendorId());
                    jSONObject.put("3", device.getSources());
                    String string = device.toString();
                    jSONObject.put("4", string.indexOf("Location: built-in") > 0 ? 1 : string.indexOf("Location: external") > 0 ? 2 : 0);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString().replace("   ", "");
        } catch (Exception e) {
            f.b(e);
            return "";
        }
    }

    public static boolean b() {
        try {
            return Build.VERSION.SDK_INT >= 26;
        } catch (Throwable th) {
            f.b(th);
            return false;
        }
    }
}
