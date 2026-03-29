package com.opos.mobad.video.player.c.a.a;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.video.player.c.a.b f10280a;
    private volatile JSONObject b;
    private volatile String c;
    private volatile String d;
    private volatile long e = -1;

    public a(com.opos.mobad.video.player.c.a.b bVar) {
        this.f10280a = bVar;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
                a.this.d();
                a.this.c();
                a.this.b();
            }
        });
    }

    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.opos.mobad.video.player.c.a.b bVar;
        JSONObject jSONObjectOptJSONObject;
        if (this.b != null) {
            return this.b;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            bVar = this.f10280a;
        } catch (Throwable th) {
            th = th;
        }
        if (bVar != null) {
            String strA = bVar.a();
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject4 = new JSONObject(strA);
                try {
                    jSONObjectOptJSONObject = jSONObject4.optJSONObject("extension");
                    jSONObject = jSONObject4;
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject3 = jSONObject4;
                    com.opos.cmn.an.f.a.d("TTLightJSData", "getTTDataJson error", th);
                    jSONObject2 = jSONObject3;
                }
                if (jSONObjectOptJSONObject == null) {
                    jSONObject3 = new JSONObject();
                    jSONObject3.put("extension", jSONObject4);
                    jSONObject2 = jSONObject3;
                    jSONObject = jSONObject2;
                }
                this.b = jSONObject;
                com.opos.cmn.an.f.a.b("TTLightJSData", "getTTDataJson=" + jSONObject);
                return jSONObject;
            }
            com.opos.cmn.an.f.a.d("TTLightJSData", "getTTDataJson error", th);
            jSONObject2 = jSONObject3;
            jSONObject = jSONObject2;
            this.b = jSONObject;
            com.opos.cmn.an.f.a.b("TTLightJSData", "getTTDataJson=" + jSONObject);
            return jSONObject;
        }
        return jSONObject3;
    }

    public String b() {
        if (this.c != null) {
            return this.c;
        }
        try {
            this.c = "";
            JSONObject jSONObjectA = a();
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("extension");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("easy_playable");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("components");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(jSONObjectA.has("vertical") ? "vertical" : "horizontal");
            }
            if (jSONObjectA != null) {
                this.c = jSONObjectA.optString("entry");
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getWebUrl error", th);
        }
        com.opos.cmn.an.f.a.b("TTLightJSData", "getWebUrl=" + this.c);
        return this.c;
    }

    public String c() {
        try {
            if (this.d != null) {
                return this.d;
            }
            com.opos.mobad.video.player.c.a.b bVar = this.f10280a;
            this.d = bVar != null ? bVar.b() : "";
            com.opos.cmn.an.f.a.b("TTLightJSData", "getStatisticUrl=" + this.d);
            return this.d;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getStatisticUrl error", th);
            return "";
        }
    }

    public long d() {
        if (this.e != -1) {
            return this.e;
        }
        try {
            JSONObject jSONObjectA = a();
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("extension");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("easy_playable");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("components");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(jSONObjectA.has("vertical") ? "vertical" : "horizontal");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(com.igexin.push.core.b.Y);
            }
            if (jSONObjectA != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("videoControls");
                jSONObjectA = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? null : jSONArrayOptJSONArray.getJSONObject(0);
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("time");
            }
            jOptLong = jSONObjectA != null ? jSONObjectA.optLong("activeTime") : 3000L;
            this.e = jOptLong;
            com.opos.cmn.an.f.a.b("TTLightJSData", "getActiveTime=" + jOptLong);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getActiveTime error", th);
        }
        return jOptLong;
    }
}
