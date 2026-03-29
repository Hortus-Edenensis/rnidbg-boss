package com.wifi.open.sec;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public final class DataUtil {
    public static void AddBool(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException unused) {
        }
    }

    public static void AddInt(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
        }
    }

    public static void AddLong(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException unused) {
        }
    }

    public static void AddString(JSONObject jSONObject, String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str2.trim())) {
            return;
        }
        try {
            jSONObject.put(str, str2.trim());
        } catch (JSONException unused) {
        }
    }

    public static void AddStringWithDef(JSONObject jSONObject, String str, String str2) {
        try {
            if (str2 == null || TextUtils.isEmpty(str2.trim())) {
                jSONObject.put(str, "-998");
            } else {
                jSONObject.put(str, str2.trim());
            }
        } catch (JSONException unused) {
        }
    }
}
