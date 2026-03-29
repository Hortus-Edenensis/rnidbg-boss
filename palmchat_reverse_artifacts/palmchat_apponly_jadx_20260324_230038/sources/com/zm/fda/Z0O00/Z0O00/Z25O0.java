package com.zm.fda.Z0O00.Z0O00;

import com.huawei.openalliance.ad.constant.be;
import com.umeng.analytics.pro.f;
import com.zm.fda.O52OZ.O2O5Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16667a;
    public List<com.zm.fda.Z0O00.Z0O00.OO22Z> b;
    public int c;

    /* JADX INFO: compiled from: SearchBox */
    public static class ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Z25O0 f16668a = new Z25O0();

        public ZZ00Z a(String str) {
            this.f16668a.f16667a = str;
            return this;
        }

        public ZZ00Z a(int i) {
            this.f16668a.c = i;
            return this;
        }

        public ZZ00Z a(List<com.zm.fda.Z0O00.Z0O00.OO22Z> list) {
            this.f16668a.b = list;
            return this;
        }

        public Z25O0 a() {
            return this.f16668a;
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_count", this.b.size());
            jSONObject.put("event_level", this.c);
            jSONObject.put(be.g, this.f16667a);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("sdk_version", com.zm.fda.OO22Z.d);
            List<com.zm.fda.Z0O00.Z0O00.OO22Z> list = this.b;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (com.zm.fda.Z0O00.Z0O00.OO22Z oo22z : this.b) {
                    if (oo22z != null) {
                        try {
                            JSONObject jSONObjectA = oo22z.a(true);
                            if (jSONObjectA != null) {
                                jSONArray.put(jSONObjectA);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                jSONObject.put(f.ax, jSONArray);
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public Z25O0() {
        this.f16667a = O2O5Z.a();
    }

    public void a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        if (this.b == null) {
            this.b = Collections.synchronizedList(new ArrayList());
        }
        this.b.add(oo22z);
    }

    public List<com.zm.fda.Z0O00.Z0O00.OO22Z> a() {
        return this.b;
    }
}
