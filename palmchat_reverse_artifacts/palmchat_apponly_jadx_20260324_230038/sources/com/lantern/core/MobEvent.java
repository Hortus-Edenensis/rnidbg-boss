package com.lantern.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.core.business.EventManager;
import com.lantern.core.business.IPubParams;
import com.lantern.core.business.ParamHelper;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MobEvent {
    private static EventManager manager = null;
    public static boolean notSticky = false;

    public static int getForceDnsIpv6() {
        return manager.getForceDnsIpv6();
    }

    public static String getVersionName(Context context) {
        return "1.0.3-lx";
    }

    public static synchronized void init(Context context, IPubParams iPubParams) {
        if (manager != null) {
            return;
        }
        Log.i("CX_EVENT", "MobEvent INIT!");
        ParamHelper.setParams(iPubParams);
        manager = new EventManager(context, iPubParams);
    }

    public static void onEvent(String str) {
        onEvent(str, "", null);
    }

    public static void onEventExtra(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEventExtra(str, jSONObject);
    }

    public static void onEventSource(String str, String str2) {
        onEvent(str, str2, null);
    }

    public static void onExtEvent(String str, Map<String, Object> map) {
        onExtEvent(str, new JSONObject(map));
    }

    public static void sendImd() {
        EventManager eventManager = manager;
        if (eventManager != null) {
            eventManager.sendImd();
        }
    }

    public static void setOpenType(int i) {
        EventManager eventManager = manager;
        if (eventManager != null) {
            eventManager.setOpenType(i);
        }
    }

    public static void uploadTmpFiles() {
        manager.uploadFiles();
    }

    public static void onEvent(String str, String str2, JSONArray jSONArray) {
        if (manager == null || TextUtils.isEmpty(str)) {
            return;
        }
        String string = "";
        if (str2 == null) {
            str2 = "";
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            try {
                                Object obj = jSONObject.get(next);
                                if (obj != null && !(obj instanceof String)) {
                                    jSONObject.put(next, String.valueOf(obj));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            string = jSONArray.toString();
        }
        manager.addEvent(str, str2, string);
    }

    public static void onExtEvent(String str, JSONObject jSONObject) {
        onEventExtra(str, jSONObject.toString());
    }

    public static void onEventExtra(String str, JSONArray jSONArray) {
        onEvent(str, "", jSONArray);
    }

    @Deprecated
    public static void onEventExtra(String str, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            jSONArray.put(jSONObject);
        }
        onEvent(str, "", jSONArray);
    }
}
