package com.kwad.sdk.api.loader;

import com.baidu.mapapi.SDKInitializer;
import com.kwad.sdk.api.loader.a;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l {
    public static int ayz;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private int ayA;
        private int ayB;
        private String ayC;
        private String ayD;
        private long ayE;
        private int ayF;
        private String ayG;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ap(long j) {
            this.ayE = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cE(String str) {
            this.ayC = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cF(String str) {
            this.ayD = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cG(String str) {
            this.ayG = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cI(int i) {
            this.ayA = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cJ(int i) {
            this.ayB = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cK(int i) {
            this.ayF = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.ayA));
                jSONObject.putOpt("update_count", Integer.valueOf(this.ayB));
                jSONObject.putOpt("dynamic_version", this.ayC);
                jSONObject.putOpt(WfConstant.EXTRA_KEY_DOWNLOAD_URL, this.ayD);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.ayE));
                jSONObject.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(this.ayF));
                jSONObject.putOpt("error_msg", this.ayG);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.ayA + ", update_count=" + this.ayB + ", dynamic_version='" + this.ayC + "', download_url='" + this.ayD + "', duration_ms=" + this.ayE + ", error_code=" + this.ayF + ", error_msg='" + this.ayG + "'}";
        }
    }

    public static void a(a.C0594a c0594a) {
        ayz++;
        a(1, c0594a, 0L, 0, "");
    }

    public static void b(a.C0594a c0594a) {
        a(5, c0594a, 0L, 0, "");
    }

    public static void b(a.C0594a c0594a, long j) {
        a(6, c0594a, j, 0, "");
    }

    public static void a(a.C0594a c0594a, long j) {
        a(2, c0594a, j, 0, "");
    }

    public static void b(a.C0594a c0594a, int i, String str) {
        a(7, c0594a, 0L, i, str);
    }

    public static void a(a.C0594a c0594a, long j, String str) {
        a(3, c0594a, j, 0, str);
    }

    public static void a(a.C0594a c0594a, int i, String str) {
        a(4, c0594a, 0L, i, str);
    }

    private static void a(int i, a.C0594a c0594a, long j, int i2, String str) {
        if (c0594a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).cI(i).cJ(ayz).cE(c0594a.sdkVersion).cF(c0594a.axP).ap(j).cK(i2).cG(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
