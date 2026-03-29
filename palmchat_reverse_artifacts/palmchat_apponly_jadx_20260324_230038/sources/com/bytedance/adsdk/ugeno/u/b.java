package com.bytedance.adsdk.ugeno.u;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.u.fx;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static float[] fx(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayU = com.bytedance.adsdk.ugeno.iz.nr.u(str, (JSONArray) null);
        if (jSONArrayU != null && jSONArrayU.length() == 2) {
            fArr[0] = (float) jSONArrayU.optDouble(0);
            fArr[1] = (float) jSONArrayU.optDouble(1);
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Interpolator nr(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1965072618:
                b = !str.equals("ease_in") ? (byte) -1 : (byte) 0;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    b = 3;
                    break;
                }
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    b = 2;
                    break;
                }
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    b = 1;
                    break;
                }
                break;
        }
        return b != 0 ? b != 1 ? b != 2 ? new LinearInterpolator() : new DecelerateInterpolator() : new AccelerateDecelerateInterpolator() : new AccelerateInterpolator();
    }

    public static int u(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static List<fx> u(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(u(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static fx.u nr(String str, JSONObject jSONObject) {
        JSONArray jSONArrayU;
        if (TextUtils.isEmpty(str) || (jSONArrayU = com.bytedance.adsdk.ugeno.iz.nr.u(str, (JSONArray) null)) == null || jSONArrayU.length() != 2) {
            return null;
        }
        fx.u uVar = new fx.u();
        uVar.u = com.bytedance.adsdk.ugeno.b.nr.u(jSONArrayU.optString(0), jSONObject);
        uVar.nr = com.bytedance.adsdk.ugeno.b.nr.u(jSONArrayU.optString(1), jSONObject);
        return uVar;
    }

    public static fx u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        fx fxVar = new fx();
        fxVar.nr(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("delay"), jSONObject2), 0L));
        fxVar.fx(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("name"), jSONObject2));
        fxVar.nr(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("playState"), jSONObject2), 1));
        fxVar.u(Math.max(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("duration"), jSONObject2), 0L), 0L));
        fxVar.u(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("playCount"), jSONObject2), 1));
        fxVar.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("playDirection"), jSONObject2));
        fxVar.u(nr(jSONObject.optString("transformOrigin"), jSONObject2));
        fxVar.nr(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        fxVar.u(jSONObject.optJSONObject("effect"));
        fxVar.u(u(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return fxVar;
    }

    public static Map<String, TreeMap<Float, String>> u(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble("offset");
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectOptJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectOptJSONObject.optString(next), jSONObject));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1408024454) {
            b = (iHashCode == -1039745817 && str.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) ? (byte) 1 : (byte) -1;
        } else if (str.equals("alternate")) {
            b = 0;
        }
        return b != 0 ? 1 : 2;
    }

    public static int u(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}
