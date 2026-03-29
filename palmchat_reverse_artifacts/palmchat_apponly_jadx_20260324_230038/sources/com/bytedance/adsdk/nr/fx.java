package com.bytedance.adsdk.nr;

import com.bytedance.adsdk.ugeno.b.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx implements com.bytedance.adsdk.ugeno.b.u {

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements u.InterfaceC0168u {
        private String nr;
        private com.bytedance.adsdk.nr.nr.u u;

        private u(String str) {
            this.nr = str;
            this.u = com.bytedance.adsdk.nr.nr.u.u(str);
        }

        public static u u(String str) {
            return new u(str);
        }

        @Override // com.bytedance.adsdk.ugeno.b.u.InterfaceC0168u
        public Object u(JSONObject jSONObject) {
            com.bytedance.adsdk.nr.nr.u uVar = this.u;
            if (uVar == null) {
                return this.nr;
            }
            Object objU = uVar.u(jSONObject);
            if (objU instanceof String) {
                return objU;
            }
            if (objU instanceof com.bytedance.adsdk.nr.nr.u.u) {
                return String.valueOf(my.u((com.bytedance.adsdk.nr.nr.u.u) objU));
            }
            if (objU == null || !objU.getClass().isArray()) {
                return String.valueOf(objU);
            }
            try {
                return new JSONArray(objU).toString();
            } catch (JSONException unused) {
                return String.valueOf(objU);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.u
    public u.InterfaceC0168u u(String str) {
        return u.u(str);
    }
}
