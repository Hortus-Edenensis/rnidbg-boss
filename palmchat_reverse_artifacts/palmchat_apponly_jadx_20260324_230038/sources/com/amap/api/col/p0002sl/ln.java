package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.model.MyLocationStyle;
import com.umeng.analytics.pro.f;
import j$.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2974a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public long d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 63;
    public int h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.d);
            jSONObject.put("lon", this.c);
            jSONObject.put(f.C, this.b);
            jSONObject.put("radius", this.e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f2974a);
            jSONObject.put("reType", this.g);
            jSONObject.put("reSubType", this.h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ln.class == obj.getClass()) {
            ln lnVar = (ln) obj;
            if (this.f2974a == lnVar.f2974a && Double.compare(lnVar.b, this.b) == 0 && Double.compare(lnVar.c, this.c) == 0 && this.d == lnVar.d && this.e == lnVar.e && this.f == lnVar.f && this.g == lnVar.g && this.h == lnVar.h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2974a), Double.valueOf(this.b), Double.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h));
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optDouble(f.C, this.b);
            this.c = jSONObject.optDouble("lon", this.c);
            this.f2974a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.f2974a);
            this.g = jSONObject.optInt("reType", this.g);
            this.h = jSONObject.optInt("reSubType", this.h);
            this.e = jSONObject.optInt("radius", this.e);
            this.d = jSONObject.optLong("time", this.d);
        } catch (Throwable th) {
            me.a(th, "CoreUtil", "transformLocation");
        }
    }
}
