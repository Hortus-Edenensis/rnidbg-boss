package com.bytedance.adsdk.ugeno.fx;

import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.EventParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5027a;
    private JSONObject b;
    private String fx;
    private JSONObject iz;
    private float n;
    private JSONObject nr;
    private String pn;
    private JSONObject u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5028a;
        private JSONObject b;
        private JSONObject fx;
        private u iz;
        private boolean jk;
        private String n;
        private String nr;
        private LinkedList<u> pn;
        private String u;
        private String x;

        public JSONObject iz() {
            return this.b;
        }

        public List<u> pn() {
            return this.pn;
        }

        public String toString() {
            return "UGNode{id='" + this.u + "', name='" + this.nr + "'}";
        }

        public JSONObject b() {
            return this.fx;
        }

        public String fx() {
            return this.nr;
        }

        public String nr() {
            return this.x;
        }

        public void nr(boolean z) {
            this.jk = z;
        }

        public String u() {
            return this.u;
        }

        public void nr(u uVar) {
            if (this.pn == null) {
                this.pn = new LinkedList<>();
            }
            this.pn.addLast(uVar);
        }

        public void u(String str) {
            this.nr = str;
        }

        public void u(boolean z) {
            this.f5028a = z;
        }

        public void u(u uVar) {
            if (this.pn == null) {
                this.pn = new LinkedList<>();
            }
            this.pn.add(uVar);
        }

        public void u(int i, u uVar) {
            if (this.pn == null) {
                this.pn = new LinkedList<>();
            }
            this.pn.add(i, uVar);
        }
    }

    public a(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    private u pn() {
        if (!b()) {
            return u(this.u, (u) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.n;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.f5027a;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            JSONObject jSONObject2 = this.b;
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("xSize");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    if (jSONObject3.optInt("width") > 0) {
                        jSONObject.put("width", jSONObject3.optInt("width"));
                    }
                    if (jSONObject3.optInt("height") > 0) {
                        jSONObject.put("height", jSONObject3.optInt("height"));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        u uVar = new u();
        uVar.nr = "View";
        uVar.u = "virtualNode";
        uVar.fx = jSONObject;
        uVar.iz = null;
        uVar.x = this.fx;
        uVar.n = this.pn;
        uVar.u(u(this.u, uVar));
        return uVar;
    }

    public boolean b() {
        return this.x;
    }

    public List<u> fx() {
        if (this.nr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.nr.keys();
        while (itKeys.hasNext()) {
            u uVarU = u(this.nr.optJSONObject(itKeys.next()), (u) null);
            if (uVarU != null) {
                arrayList.add(uVarU);
            }
        }
        return arrayList;
    }

    public String nr() {
        return this.fx;
    }

    public u u() {
        return pn();
    }

    public a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.u = jSONObject.optJSONObject("body");
            } else {
                this.u = jSONObject.optJSONObject("main_template");
            }
            this.nr = jSONObject.optJSONObject("sub_templates");
            JSONObject jSONObjectOptJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.x = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.fx = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.fx = "3.0";
                    }
                } else {
                    this.fx = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.pn = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.fx = "3.0";
                this.x = true;
            }
            this.b = jSONObject2;
            this.iz = jSONObject3;
        }
    }

    public static boolean b(u uVar) {
        return (uVar == null || uVar.fx == null) ? false : true;
    }

    public boolean nr(u uVar) {
        JSONObject jSONObjectB;
        if (uVar == null || (jSONObjectB = uVar.b()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectB.optString("height"), "match_parent");
    }

    public void u(float f, float f2) {
        this.n = f;
        this.f5027a = f2;
    }

    private u u(JSONObject jSONObject, u uVar) {
        String strOptString;
        String strOptString2;
        u uVarU;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        u uVar2 = new u();
        uVar2.u = strOptString3;
        if (!this.x || !TextUtils.equals("Video", strOptString)) {
            uVar2.nr = strOptString;
        } else {
            uVar2.nr = strOptString + "V3";
        }
        uVar2.fx = jSONObject2;
        uVar2.iz = uVar;
        uVar2.x = this.fx;
        uVar2.n = this.pn;
        if (jSONObject2.has("i18n")) {
            uVar2.b = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            u(jSONObject, uVar2.fx);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectOptJSONObject.optString("id"), this.b);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.nr;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strU);
                        uVarU = u(jSONObjectOptJSONObject, uVar2);
                    } else {
                        uVarU = null;
                    }
                } else {
                    uVarU = u(jSONObjectOptJSONObject, uVar2);
                }
                if (uVarU != null) {
                    uVarU.nr(nr(uVarU));
                    uVarU.u(u(uVarU));
                }
                if (fx(uVarU)) {
                    i++;
                    uVar2.nr(uVarU);
                } else if (uVarU != null) {
                    uVar2.u(i2 - i, uVarU);
                }
            }
        }
        return uVar2;
    }

    public boolean fx(u uVar) {
        JSONObject jSONObjectB;
        if (uVar == null || (jSONObjectB = uVar.b()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectB.optString(EventParams.KEY_CT_SDK_POSITION), "absolute");
    }

    public boolean u(u uVar) {
        JSONObject jSONObjectB;
        if (uVar == null || (jSONObjectB = uVar.b()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectB.optString("width"), "match_parent");
    }

    private void u(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.iz == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.iz.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, f.ax) && jSONObject3.has(f.ax)) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.iz.nr.u(jSONObject3.optJSONArray(f.ax), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }
}
