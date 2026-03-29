package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0594a {
        int axO;
        String axP;
        transient File axQ;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean EU() {
            return this.axO == 1;
        }

        public final boolean EV() {
            return this.axO == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.axO = jSONObject.optInt("dynamicType");
            this.axP = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final String toString() {
            return "Data{dynamicType=" + this.axO + ", dynamicUrl='" + this.axP + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.axQ + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        C0594a axR;
        String errorMsg;
        long result;

        public final boolean isLegal() {
            return this.result == 1 && this.axR != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0594a c0594a = new C0594a();
            this.axR = c0594a;
            c0594a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.axR + '}';
        }
    }
}
