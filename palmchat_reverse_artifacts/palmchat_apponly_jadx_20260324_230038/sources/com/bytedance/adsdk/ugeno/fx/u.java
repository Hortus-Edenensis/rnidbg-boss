package com.bytedance.adsdk.ugeno.fx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private long b;
    private List<C0169u> fx;
    private String iz;
    private float nr;
    private long pn;
    private String u;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.fx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0169u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5033a;
        private long b;
        private String fx;
        private float iz;
        private String jk;
        private float[] n;
        private float nr;
        private String pn;
        private long u;
        private float x;

        public String a() {
            return this.jk;
        }

        public long b() {
            return this.b;
        }

        public String fx() {
            return this.fx;
        }

        public String getType() {
            return this.pn;
        }

        public float iz() {
            return this.x;
        }

        public String n() {
            return this.f5033a;
        }

        public float nr() {
            return this.nr;
        }

        public float pn() {
            return this.iz;
        }

        public long u() {
            return this.u;
        }

        public float[] x() {
            return this.n;
        }

        public void b(String str) {
            this.f5033a = str;
        }

        public void fx(float f) {
            this.x = f;
        }

        public void nr(long j) {
            this.b = j;
        }

        public void u(long j) {
            this.u = j;
        }

        public void fx(String str) {
            this.jk = str;
        }

        public void nr(String str) {
            this.pn = str;
        }

        public void u(float f) {
            this.nr = f;
        }

        public void nr(float f) {
            this.iz = f;
        }

        public void u(String str) {
            this.fx = str;
        }

        public void u(float[] fArr) {
            this.n = fArr;
        }

        public static C0169u u(JSONObject jSONObject, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
            if (jSONObject == null) {
                return null;
            }
            C0169u c0169u = new C0169u();
            c0169u.u(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0169u.u(-1.0f);
            } else {
                try {
                    c0169u.u(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0169u.u(0.0f);
                }
            }
            c0169u.u(jSONObject.optString("loopMode"));
            c0169u.nr(jSONObject.optString("type"));
            if (TextUtils.equals(c0169u.getType(), "ripple")) {
                c0169u.fx(jSONObject.optString("rippleColor"));
            }
            View viewA = fxVar.a();
            Context context = viewA != null ? viewA.getContext() : null;
            if (TextUtils.equals(c0169u.getType(), "backgroundColor")) {
                String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("valueTo"), fxVar.jk());
                int iU = com.bytedance.adsdk.ugeno.iz.u.u(jSONObject.optString("valueFrom"));
                int iU2 = com.bytedance.adsdk.ugeno.iz.u.u(strU);
                c0169u.nr(iU);
                c0169u.fx(iU2);
            } else if ((TextUtils.equals(c0169u.getType(), "translateX") || TextUtils.equals(c0169u.getType(), "translateY")) && context != null) {
                try {
                    float fU = com.bytedance.adsdk.ugeno.iz.n.u(context, (float) jSONObject.optDouble("valueFrom"));
                    float fU2 = com.bytedance.adsdk.ugeno.iz.n.u(context, (float) jSONObject.optDouble("valueTo"));
                    c0169u.nr(fU);
                    c0169u.fx(fU2);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.k.nr("animation", "animation ");
                }
            } else {
                c0169u.nr((float) jSONObject.optDouble("valueFrom"));
                c0169u.fx((float) jSONObject.optDouble("valueTo"));
            }
            c0169u.b(jSONObject.optString("interpolator"));
            c0169u.nr(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("startDelay"), fxVar.jk()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0169u.getType(), "translateX") || TextUtils.equals(c0169u.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.iz.n.u(context, (float) u.u(jSONArrayOptJSONArray.optString(i), fxVar.jk()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) u.u(jSONArrayOptJSONArray.optString(i), fxVar.jk());
                        i++;
                    }
                }
                c0169u.u(fArr);
            }
            return c0169u;
        }
    }

    public long b() {
        return this.b;
    }

    public List<C0169u> fx() {
        return this.fx;
    }

    public String iz() {
        return this.iz;
    }

    public float nr() {
        return this.nr;
    }

    public long pn() {
        return this.pn;
    }

    public String u() {
        return this.u;
    }

    public void nr(long j) {
        this.pn = j;
    }

    public void u(String str) {
        this.u = str;
    }

    public void nr(String str) {
        this.iz = str;
    }

    public void u(float f) {
        this.nr = f;
    }

    public void u(List<C0169u> list) {
        this.fx = list;
    }

    public void u(long j) {
        this.b = j;
    }

    public static u u(String str, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return u(new JSONObject(str), fxVar);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static u u(JSONObject jSONObject, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        return u(jSONObject, null, fxVar);
    }

    public static u u(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.u(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            uVar.u(-1.0f);
        } else {
            try {
                uVar.u(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                uVar.u(0.0f);
            }
        }
        uVar.u(jSONObject.optLong("duration", 0L));
        uVar.nr(com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u(jSONObject.optString("startDelay"), fxVar.jk()), 0L));
        uVar.nr(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.iz.nr.u(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0169u.u(jSONObjectOptJSONObject, fxVar));
            }
            uVar.u(arrayList);
        }
        return uVar;
    }

    public static double u(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.iz.fx.u(com.bytedance.adsdk.ugeno.b.nr.u((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
