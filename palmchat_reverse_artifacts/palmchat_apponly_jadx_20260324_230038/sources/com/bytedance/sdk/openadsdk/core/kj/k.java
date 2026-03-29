package com.bytedance.sdk.openadsdk.core.kj;

import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public double b;
    public double fx;
    public double nr;
    public double u;

    public k(double d, double d2, double d3, double d4) {
        this.u = d;
        this.nr = d2;
        this.fx = d3;
        this.b = d4;
    }

    public static k nr(k kVar, k kVar2) {
        if (kVar == null) {
            return kVar2;
        }
        if (kVar2 == null) {
            return null;
        }
        double d = kVar.u;
        double d2 = kVar.nr;
        double d3 = kVar.fx + d;
        double d4 = kVar.b + d2;
        double d5 = kVar2.u;
        double d6 = kVar2.nr;
        double d7 = kVar2.fx + d5;
        double d8 = kVar2.b + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new k(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }

    public boolean u(double d, double d2) {
        double d3 = this.fx;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.b;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.u;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.nr;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static k u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(OapsKey.KEY_POINT);
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("size");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 2 || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
            return null;
        }
        return new k(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
    }

    public static JSONObject u(k kVar) {
        if (kVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, kVar.u);
            jSONArray.put(1, kVar.nr);
            jSONObject.put(OapsKey.KEY_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, kVar.fx);
            jSONArray2.put(1, kVar.b);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static double u(k kVar, k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0.0d;
        }
        double d = kVar.u;
        double d2 = kVar.nr;
        double d3 = kVar.fx + d;
        double d4 = kVar.b + d2;
        double d5 = kVar2.u;
        double d6 = kVar2.nr;
        double d7 = kVar2.fx + d5;
        double d8 = kVar2.b + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }
}
