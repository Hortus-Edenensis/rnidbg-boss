package com.bytedance.adsdk.ugeno.pn;

import com.ss.android.ttvecamera.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {
    private List<u> nr;
    private u u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private String fx = "global";
        private Map<String, Object> iz;
        private String nr;
        private Map<String, String> pn;
        private String u;

        public String b() {
            return this.u;
        }

        public Map<String, String> fx() {
            return this.pn;
        }

        public String nr() {
            return this.b;
        }

        public String pn() {
            return this.nr;
        }

        public String toString() {
            return "Action{scheme='" + this.fx + "', name='" + this.b + "', params=" + this.pn + ", host='" + this.nr + "', origin='" + this.u + "', extra=" + this.iz + '}';
        }

        public String u() {
            return this.fx;
        }

        public void b(String str) {
            this.nr = str;
        }

        public void fx(String str) {
            this.u = str;
        }

        public void nr(String str) {
            this.b = str;
        }

        public void u(String str) {
            this.fx = str;
        }

        public void u(Map<String, String> map) {
            this.pn = map;
        }
    }

    public List<u> nr() {
        return this.nr;
    }

    public u u() {
        return this.u;
    }

    public static iz u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        iz izVar = new iz();
        String strOptString = jSONObject.optString(BuildConfig.USE_CLOUD_CONFIG);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        izVar.u = l.u(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            u uVarU = l.u(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (uVarU != null) {
                arrayList.add(uVarU);
            }
        }
        izVar.nr = arrayList;
        return izVar;
    }
}
