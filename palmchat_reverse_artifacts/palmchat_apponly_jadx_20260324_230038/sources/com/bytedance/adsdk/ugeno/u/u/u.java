package com.bytedance.adsdk.ugeno.u.u;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u {
    private String fx;
    protected com.bytedance.adsdk.ugeno.nr.fx nr;
    protected JSONObject u;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0174u {
        public static u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
            if (fxVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new pn(fxVar, jSONObject);
                case "ripple":
                    return new nr(fxVar, jSONObject);
                case "rub_in":
                    return new fx(fxVar, jSONObject);
                case "shine":
                    return new b(fxVar, jSONObject);
                default:
                    return null;
            }
        }
    }

    public u(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        this.u = jSONObject;
        this.nr = fxVar;
        u();
    }

    public String b() {
        return this.fx;
    }

    public abstract List<PropertyValuesHolder> fx();

    public abstract void nr();

    public abstract void nr(Canvas canvas);

    public void u() {
        this.fx = this.u.optString("type");
        nr();
    }

    public abstract void u(int i, int i2);

    public abstract void u(Canvas canvas);
}
