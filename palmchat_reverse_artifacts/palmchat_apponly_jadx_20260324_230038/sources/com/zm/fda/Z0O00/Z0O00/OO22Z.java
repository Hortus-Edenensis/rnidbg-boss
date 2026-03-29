package com.zm.fda.Z0O00.Z0O00;

import android.text.TextUtils;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.utils.EventLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16665a;
    public String b;
    public com.zm.fda.Z0O00.Z0O00.ZZ00Z c;
    public String d;
    public String e;
    public long f;
    public int g;
    public String h;
    public int i;

    /* JADX INFO: compiled from: SearchBox */
    public static class ZZ00Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OO22Z f16666a = new OO22Z();

        public ZZ00Z a(String str) {
            this.f16666a.b = str;
            return this;
        }

        public ZZ00Z b(String str) {
            this.f16666a.h = str;
            return this;
        }

        public ZZ00Z c(String str) {
            this.f16666a.e = str;
            return this;
        }

        public ZZ00Z d(String str) {
            this.f16666a.d = str;
            return this;
        }

        public ZZ00Z a(com.zm.fda.Z0O00.Z0O00.ZZ00Z zz00z) {
            this.f16666a.c = zz00z;
            return this;
        }

        public ZZ00Z b(int i) {
            this.f16666a.i = i;
            return this;
        }

        public ZZ00Z a(long j) {
            this.f16666a.f = j;
            return this;
        }

        public ZZ00Z a(int i) {
            this.f16666a.g = i;
            return this;
        }

        public ZZ00Z a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            try {
                this.f16666a.b = jSONObject.optString("event_id");
                this.f16666a.d = jSONObject.optString("pubInfo");
                this.f16666a.f = jSONObject.optLong("bean_id");
                this.f16666a.g = jSONObject.optInt("event_level", 1);
                this.f16666a.e = jSONObject.optString("msg");
                this.f16666a.h = jSONObject.optString("event_url");
            } catch (Exception unused) {
            }
            return this;
        }

        public OO22Z a() {
            return this.f16666a;
        }
    }

    public String e() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        com.zm.fda.Z0O00.Z0O00.ZZ00Z zz00z = this.c;
        if (zz00z == null) {
            return null;
        }
        try {
            JSONObject jSONObjectA = zz00z.a();
            if (jSONObjectA == null) {
                return null;
            }
            String string = jSONObjectA.toString();
            this.d = string;
            return string;
        } catch (Throwable th) {
            EventLog.e("fob_fda", "getEventInfo error:" + th.getMessage());
            return null;
        }
    }

    public String f() {
        return this.h;
    }

    public int g() {
        return this.g;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        if (TextUtils.isEmpty(this.f16665a)) {
            this.f16665a = this.b + this.f;
        }
        return this.f16665a;
    }

    public int j() {
        return this.i;
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.b);
    }

    public String toString() {
        return "FdaEventBean{eventId='" + this.b + "', pubInfoStr='" + this.d + "', msg='" + this.e + "', beanId=" + this.f + ", level=" + this.g + ", eventUrl='" + this.h + "', saveSource=" + this.i + '}';
    }

    public OO22Z() {
        this.g = 1;
        this.f = O2O5Z.b();
    }

    public byte[] c() {
        try {
            if (e() != null) {
                return O2O5Z.a(e().getBytes());
            }
        } catch (Exception unused) {
        }
        return new byte[0];
    }

    public String d() {
        return this.b;
    }

    public byte[] b() {
        try {
            String str = this.e;
            if (str != null) {
                return O2O5Z.a(str.getBytes());
            }
        } catch (Exception unused) {
        }
        return new byte[0];
    }

    public long a() {
        return this.f;
    }

    public JSONObject a(boolean z) {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_id", this.b);
            jSONObject.put("pubInfo", e());
            jSONObject.put("event_level", this.g);
            String str = this.e;
            if (str == null) {
                str = "";
            }
            jSONObject.put("msg", str);
            if (!z) {
                jSONObject.put("bean_id", this.f);
                jSONObject.put("event_url", this.h);
                jSONObject.put("save_source", this.i);
            }
            return jSONObject;
        } catch (JSONException e) {
            EventLog.e("fob_fda", "object2Json error:" + e.getMessage());
            return null;
        }
    }
}
