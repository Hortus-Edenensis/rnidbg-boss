package com.zm.fda;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.zm.fda.O52OZ.ZZ050;
import com.zm.fda.Z0225.Z200O;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FobEventClient {
    public static final String f = "FOB-C";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16619a;
    public Context b;
    public IPubParams c;
    public Z200O d;
    public String e;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f16620a;
        public IPubParams b;
        public String c;
        public boolean d;

        public FobEventClient newClient() {
            return new FobEventClient(this);
        }

        public Builder setContext(Context context) {
            this.f16620a = context;
            return this;
        }

        public Builder setEventUrl(String str) {
            this.c = str;
            return this;
        }

        public Builder setPubParams(IPubParams iPubParams) {
            this.b = iPubParams;
            return this;
        }

        public Builder a(boolean z) {
            this.d = z;
            return this;
        }
    }

    private void a(Context context, IPubParams iPubParams, String str) {
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        if (this.b == null || iPubParams == null) {
            EventLog.d(f, "context or params is null");
            return;
        }
        this.c = iPubParams;
        this.e = str;
        com.zm.fda.O52OZ.ZZ00Z.a(iPubParams.getChanId());
        this.d = new Z200O(this.b, this.c);
        if (this.f16619a) {
            return;
        }
        O022Z.a(context, this.c);
    }

    public static void setFuncOpen(Context context, boolean z) {
        ZZ050.b(context, com.zm.fda.Z200O.ZZ00Z.g, com.zm.fda.Z200O.ZZ00Z.p, z);
    }

    public Z200O getPubParamsImp() {
        return this.d;
    }

    public void onSdkInit(Map<String, Object> map) {
        track(ZZ00Z.OO22Z.c, map);
    }

    public void track(String str) {
        track(str, new HashMap());
    }

    public FobEventClient(Builder builder) {
        EventLog.d(f, "newClient");
        boolean z = builder.d;
        this.f16619a = z;
        a(builder.f16620a, builder.b, builder.c);
        ZZ00Z.a(this);
        if (z) {
            return;
        }
        ZZ00Z.a(builder.f16620a, builder.b);
        O022Z.a(true);
    }

    public void track(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    jSONObject.put("ext", new JSONObject(map));
                }
            } catch (Throwable th) {
                Log.d(f, "track json error:", th);
            }
        }
        a(str, jSONObject);
    }

    public void track(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ext", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(str, jSONObject2);
    }

    private void a(String str, JSONObject jSONObject) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            EventLog.e(f, "track json error:" + th.getMessage());
        }
        com.zm.fda.Z0225.Z25O0 z25o0A = a();
        z25o0A.a(str);
        z25o0A.c(jSONArray.toString());
        z25o0A.a(System.currentTimeMillis());
        com.zm.fda.Z0225.O022Z.a().b(z25o0A);
    }

    private com.zm.fda.Z0225.Z25O0 a() {
        com.zm.fda.Z0225.Z25O0 z25o0 = new com.zm.fda.Z0225.Z25O0();
        z25o0.b(this.e);
        z25o0.a(this.c);
        z25o0.a(this.d);
        return z25o0;
    }
}
