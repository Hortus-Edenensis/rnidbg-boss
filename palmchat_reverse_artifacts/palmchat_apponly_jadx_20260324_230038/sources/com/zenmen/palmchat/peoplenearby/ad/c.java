package com.zenmen.palmchat.peoplenearby.ad;

import com.baidu.location.LocationConst;
import com.wifi.csj.ad.NestCsjProvider;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zn6;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14986a = null;
        public String b = null;
        public JSONObject c = null;
        public int d = 0;
        public long e = 0;
        public String f = null;
        public int g = -1;
        public String h = null;
        public long i = 0;
        public int j = 0;
        public String k = null;
        public int l = -1;
        public int m = -1;

        public a a(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a d(int i) {
            this.j = i;
            return this;
        }

        public a e(String str) {
            this.f14986a = str;
            return this;
        }

        public a f(String str) {
            this.b = str;
            return this;
        }

        public a g(String str) {
            this.k = str;
            return this;
        }

        public a h(int i) {
            this.l = i;
            return this;
        }

        public a i(int i) {
            this.d = i;
            return this;
        }

        public void j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("codeid", this.f14986a);
                jSONObject.put(com.umeng.ccg.a.x, NestCsjProvider.SDK_FROM);
                int i = this.d;
                if (i != 0) {
                    jSONObject.put("reaction", i);
                }
                long j = this.e;
                if (j != 0) {
                    jSONObject.put("reqTime", j);
                }
                String str = this.f;
                if (str != null) {
                    jSONObject.put("adid", str);
                }
                int i2 = this.g;
                if (i2 >= 0) {
                    jSONObject.put("rewardAdType", i2);
                }
                int i3 = this.l;
                if (i3 >= 0) {
                    jSONObject.put("num", i3);
                }
                int i4 = this.m;
                if (i4 != -1) {
                    jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, i4);
                }
                String str2 = this.h;
                if (str2 != null) {
                    jSONObject.put("appname", str2);
                }
                long j2 = this.i;
                if (j2 != 0) {
                    jSONObject.put("reqfailTime", j2);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    jSONObject.put("code", i5);
                }
                String str3 = this.k;
                if (str3 != null) {
                    jSONObject.put("msg", str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.d("logad", "reportMDA eventID = " + this.b + ", params = " + jSONObject.toString());
            zn6.d(this.b, null, jSONObject.toString());
        }

        public void k() {
            JSONObject jSONObject = this.c;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("codeid", this.f14986a);
                jSONObject.put(com.umeng.ccg.a.x, NestCsjProvider.SDK_FROM);
                int i = this.d;
                if (i != 0) {
                    jSONObject.put("reaction", i);
                }
                long j = this.e;
                if (j != 0) {
                    jSONObject.put("reqTime", j);
                }
                String str = this.f;
                if (str != null) {
                    jSONObject.put("adid", str);
                }
                int i2 = this.g;
                if (i2 >= 0) {
                    jSONObject.put("rewardAdType", i2);
                }
                int i3 = this.l;
                if (i3 >= 0) {
                    jSONObject.put("num", i3);
                }
                int i4 = this.m;
                if (i4 != -1) {
                    jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, i4);
                }
                String str2 = this.h;
                if (str2 != null) {
                    jSONObject.put("appname", str2);
                }
                long j2 = this.i;
                if (j2 != 0) {
                    jSONObject.put("reqfailTime", j2);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    jSONObject.put("code", i5);
                }
                String str3 = this.k;
                if (str3 != null) {
                    jSONObject.put("msg", str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            zn6.d(this.b, null, jSONObject.toString());
        }

        public a l(long j) {
            this.e = j;
            return this;
        }

        public a m(int i) {
            this.g = i;
            return this;
        }

        public a n(int i) {
            this.m = i;
            return this;
        }
    }

    public static a a() {
        return new a();
    }
}
