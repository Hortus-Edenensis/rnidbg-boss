package defpackage;

import com.wifi.ad.core.config.EventParams;
import com.wifi.csj.ad.NestCsjProvider;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18581a = "AdMDAHelper";

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18582a = null;
        public String b = null;
        public int c = 0;
        public int d = 0;
        public long e = 0;
        public long f = 0;
        public String g = null;
        public String h = null;
        public int i = 0;
        public int j = 0;
        public String k = null;
        public String l = null;
        public String m = null;
        public String n = null;
        public String o = null;

        public a a(String str) {
            this.m = str;
            return this;
        }

        public a b(String str) {
            this.h = str;
            return this;
        }

        public a c(String str) {
            this.f18582a = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a e(String str) {
            this.b = str;
            return this;
        }

        public a f(String str) {
            this.o = str;
            return this;
        }

        public a g(int i) {
            this.c = i;
            return this;
        }

        public void h() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("codeid", this.f18582a);
                jSONObject.put(com.umeng.ccg.a.x, NestCsjProvider.SDK_FROM);
                int i = this.d;
                if (i != 0) {
                    jSONObject.put(EventParams.KEY_PARAM_TEMPLATE, i);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    jSONObject.put("reaction", i2);
                }
                long j = this.e;
                if (j != 0) {
                    jSONObject.put("reqTime", j);
                }
                long j2 = this.f;
                if (j2 != 0) {
                    jSONObject.put("xrTime", j2);
                }
                int i3 = this.j;
                if (i3 != 0) {
                    jSONObject.put("code", i3);
                }
                String str = this.k;
                if (str != null) {
                    jSONObject.put("msg", str);
                }
                String str2 = this.g;
                if (str2 != null) {
                    jSONObject.put("adid", str2);
                }
                String str3 = this.h;
                if (str3 != null) {
                    jSONObject.put(WfConstant.EVENT_KEY_APP_NAME, str3);
                }
                int i4 = this.i;
                if (i4 != 0) {
                    jSONObject.put("reqNum", i4);
                }
                String str4 = this.l;
                if (str4 != null) {
                    jSONObject.put("title", str4);
                }
                String str5 = this.m;
                if (str5 != null) {
                    jSONObject.put("H5Url", str5);
                }
                String str6 = this.n;
                if (str6 != null) {
                    jSONObject.put("downloadURL", str6);
                }
                String str7 = this.o;
                if (str7 != null) {
                    jSONObject.put("packageName", str7);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.d(k6.f18581a, "reportMDA eventID = " + this.b + ", params = " + jSONObject.toString());
            zn6.d(this.b, null, jSONObject.toString());
        }

        public a i(int i) {
            this.d = i;
            return this;
        }

        public a j(String str) {
            this.l = str;
            return this;
        }
    }

    public static a b() {
        return new a();
    }
}
