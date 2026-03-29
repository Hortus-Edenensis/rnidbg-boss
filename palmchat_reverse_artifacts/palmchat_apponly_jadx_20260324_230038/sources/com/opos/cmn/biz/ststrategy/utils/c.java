package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ex;
import com.opos.acs.st.STManager;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    private static HashSet<String> a(JSONArray jSONArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                        String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet.add(string);
                        }
                    }
                } catch (JSONException e) {
                    com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
                }
            }
        }
        return hashSet;
    }

    public static HashSet<String> b(Context context, JSONObject jSONObject) {
        HashSet<String> hashSetA = null;
        if (context != null && jSONObject != null) {
            try {
                if (jSONObject.has("data") && !jSONObject.isNull("data")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("metaList") && !jSONObject2.isNull("metaList")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("metaList");
                        if (jSONArray.length() > 0) {
                            hashSetA = a(jSONArray);
                        }
                    }
                }
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOnlineDataTypeSet=");
        sb.append(hashSetA != null ? hashSetA : ex.V);
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", sb.toString());
        return hashSetA;
    }

    public static JSONArray a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return null;
        }
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "getMetaListArray=" + jSONObject.toString());
        try {
            if (!jSONObject.has("data") || jSONObject.isNull("data")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (!jSONObject2.has("metaList") || jSONObject2.isNull("metaList")) {
                return null;
            }
            return jSONObject2.getJSONArray("metaList");
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
            return null;
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2, HashSet hashSet) {
        boolean z = false;
        if (jSONArray != null && jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                        String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                        if (!TextUtils.isEmpty(string) && hashSet != null && !hashSet.contains(string)) {
                            jSONArray2.put(jSONObject);
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e);
                }
            }
            if (jSONArray2.length() >= length) {
                com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "onlineJsonArray length:" + jSONArray2.length() + ",originLength:" + length);
                z = true;
            }
        }
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "mergeMetaFromLocalJson mergeResult:" + z);
        return z;
    }
}
