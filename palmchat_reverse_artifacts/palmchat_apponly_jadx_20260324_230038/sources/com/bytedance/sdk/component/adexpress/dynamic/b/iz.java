package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.b.pn;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.huawei.hms.ads.ld;
import com.huawei.openalliance.ad.constant.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static HashMap<String, String> x;
    private u b;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.fx fx;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.b iz;
    private JSONObject nr;
    private fx pn;
    private JSONObject u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        boolean fx;
        float nr;
        float u;

        public static u u(JSONObject jSONObject) {
            u uVar = new u();
            if (jSONObject != null) {
                uVar.u = (float) jSONObject.optDouble("width");
                uVar.nr = (float) jSONObject.optDouble("height");
                uVar.fx = jSONObject.optBoolean("isLandscape");
            }
            return uVar;
        }
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        x = map;
        map.put(MediaFormat.KEY_SUBTITLE, "description");
        x.put(az.at, "source|app.app_name");
        x.put(RedPacketPullNewPlugin.ACTION_SCREENSHOT, "dynamic_creative.screenshot");
    }

    public iz(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.u = jSONObject;
        this.nr = jSONObject2;
        this.fx = new com.bytedance.sdk.component.adexpress.dynamic.fx.fx(jSONObject2);
        this.b = u.u(jSONObject3);
        this.iz = com.bytedance.sdk.component.adexpress.dynamic.fx.b.u(jSONObject4);
    }

    private void nr(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        com.bytedance.sdk.component.adexpress.dynamic.fx.fx fxVar;
        Object objU;
        Object objU2;
        Object objU3;
        Object objU4;
        if (nVar == null || (fxVar = this.fx) == null || (objU = fxVar.u("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objU);
        if (TextUtils.isEmpty(strValueOf) || (objU2 = this.fx.u("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objU2);
        if (TextUtils.isEmpty(strValueOf2) || (objU3 = this.fx.u("description")) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objU3);
        if (TextUtils.isEmpty(strValueOf3) || (objU4 = this.fx.u("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objU4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objU5 = this.fx.u("app.app_name");
        Object objU6 = this.fx.u(az.at);
        if (objU5 == null && objU6 == null) {
            return;
        }
        if (objU5 == null) {
            objU5 = objU6;
        }
        String strValueOf5 = String.valueOf(objU5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        nVar.u(ld.f6599a, strValueOf);
        nVar.u("title", strValueOf2);
        nVar.u("description", strValueOf3);
        nVar.u("icon", strValueOf4);
        nVar.u("app_name", strValueOf5);
        nVar.u(true);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.fx.n u(double d, int i, double d2, String str, mv mvVar) {
        JSONObject jSONObject;
        this.fx.u();
        try {
            jSONObject = new JSONObject(this.iz.nr);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVarU = u(b.u(this.u, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.fx.n) null);
        u(nVarU);
        pn pnVar = new pn(d, i, d2, str, mvVar);
        pn.u uVar = new pn.u();
        u uVar2 = this.b;
        uVar.u = uVar2.u;
        uVar.nr = uVar2.nr;
        uVar.fx = 0.0f;
        pnVar.u(uVar);
        pnVar.u(nVarU, 0.0f, 0.0f);
        pnVar.u();
        com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar = pnVar.u;
        if (nrVar.b == 65536.0f) {
            return null;
        }
        return nrVar.iz;
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        int iU;
        if (nVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null) {
            iU = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().k();
        } else {
            iU = com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext());
        }
        int iNr = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), iU);
        u uVar = this.b;
        float fMin = uVar.fx ? uVar.u : Math.min(uVar.u, iNr);
        if (this.b.nr == 0.0f) {
            nVar.pn(fMin);
            nVar.jk().pn().jk("auto");
            nVar.iz(0.0f);
        } else {
            nVar.pn(fMin);
            int iNr2 = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), com.bytedance.sdk.component.adexpress.b.n.fx(com.bytedance.sdk.component.adexpress.b.getContext()));
            u uVar2 = this.b;
            nVar.iz(uVar2.fx ? uVar2.nr : Math.min(uVar2.nr, iNr2));
            nVar.jk().pn().jk("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.fx.n u(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.iz != null) {
                fx fxVar = new fx();
                this.pn = fxVar;
                JSONObject jSONObjectU = fxVar.u(this.iz.u, iOptInt, jSONObject);
                if (jSONObjectU != null) {
                    jSONObject = jSONObjectU;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVarU = u(jSONObject);
        nVarU.u(nVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            nVarU.u((List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>) null);
            return nVarU;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = nVarU.jk().pn().tm();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.fx.n nVarU2 = u(jSONArrayOptJSONArray2.optJSONObject(i2), nVarU);
                    if (com.bytedance.sdk.component.adexpress.b.u() && "skip-with-time".equals(nVarU.jk().getType()) && !"transparent".equals(nVarU.q()) && !TextUtils.isEmpty(nVarU.q())) {
                        nVarU2.fx(nVarU.q());
                    }
                    arrayList.add(nVarU2);
                    arrayList3.add(nVarU2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            nVarU.u(arrayList);
        }
        if (arrayList2.size() > 0) {
            nVarU.nr(arrayList2);
        }
        return nVarU;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.fx.n u(JSONObject jSONObject) {
        String strU;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        a.u(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectU = a.u(strOptString, a.u(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar = new com.bytedance.sdk.component.adexpress.dynamic.fx.n();
        if (TextUtils.isEmpty(strOptString2)) {
            nVar.nr(String.valueOf(nVar.hashCode()));
        } else {
            nVar.nr(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            nr(nVar);
            nVar.fx((float) jSONObjectOptJSONObject.optDouble("x"));
            nVar.b((float) jSONObjectOptJSONObject.optDouble("y"));
            nVar.pn((float) jSONObjectOptJSONObject.optDouble("width"));
            nVar.iz((float) jSONObjectOptJSONObject.optDouble("height"));
            nVar.x(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.fx.pn pnVar = new com.bytedance.sdk.component.adexpress.dynamic.fx.pn();
            pnVar.u(strOptString);
            pnVar.nr(jSONObjectOptJSONObject.optString("data"));
            pnVar.fx(jSONObjectOptJSONObject.optString("filterData"));
            pnVar.b(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarU = com.bytedance.sdk.component.adexpress.dynamic.fx.iz.u(jSONObjectOptJSONObject);
            pnVar.u(izVarU);
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarU2 = com.bytedance.sdk.component.adexpress.dynamic.fx.iz.u(jSONObjectU);
            if (izVarU2 == null) {
                pnVar.nr(izVarU);
            } else {
                pnVar.nr(izVarU2);
            }
            u(izVarU);
            u(izVarU2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.nr) != null) {
                u(pnVar, jSONObject2.optInt("image_mode"));
            }
            String type = pnVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = pnVar.pn();
            if (x.containsKey(type) && !izVarPn.ay()) {
                izVarPn.bq(x.get(type));
            }
            if (izVarPn.ay()) {
                strU = pnVar.nr();
            } else {
                strU = u(pnVar.nr());
            }
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strU = u("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strU = u("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && izVarU.ic()) {
                    strU = u("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(u()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                pnVar.nr(strU + "adx:" + u());
            } else {
                pnVar.nr(strU);
            }
            pnVar.fx(u(pnVar.fx()));
            nVar.u(pnVar);
        }
        return nVar;
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.pn pnVar, int i) {
        int iLastIndexOf;
        if (i != 5 && i != 15 && i != 50 && i != 154) {
            pnVar.u("image");
            String strU = a.u("image");
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = pnVar.pn();
            izVarPn.bq(strU);
            pnVar.x().bq(strU);
            String strU2 = a.u("image", "clickArea");
            if (!TextUtils.isEmpty(strU2)) {
                izVarPn.k(strU2);
                pnVar.x().k(strU2);
            }
            JSONObject jSONObjectXh = izVarPn.xh();
            if (jSONObjectXh != null) {
                izVarPn.q(jSONObjectXh.optString("imageLottieTosPath"));
                izVarPn.l(jSONObjectXh.optBoolean("animationsLoop"));
                izVarPn.z(jSONObjectXh.optInt("lottieAppNameMaxLength"));
                izVarPn.d(jSONObjectXh.optInt("lottieAdDescMaxLength"));
                izVarPn.gi(jSONObjectXh.optInt("lottieAdTitleMaxLength"));
            }
            pnVar.nr(strU);
            if (strU != null && (iLastIndexOf = strU.lastIndexOf(".")) > 0) {
                String strSubstring = strU.substring(0, iLastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", u(strSubstring + ".width"));
                    jSONObject.put("height", u(strSubstring + ".height"));
                } catch (JSONException unused) {
                }
                pnVar.b(jSONObject.toString());
            }
            izVarPn.uk();
            return;
        }
        pnVar.u("video");
        String strU3 = a.u("video");
        pnVar.pn().bq(strU3);
        String strU4 = a.u("video", "clickArea");
        if (!TextUtils.isEmpty(strU4)) {
            pnVar.pn().k(strU4);
            pnVar.x().k(strU4);
        }
        pnVar.x().bq(strU3);
        pnVar.nr(strU3);
        pnVar.pn().r();
    }

    private String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.fx.nr(str2)) {
                String strValueOf = String.valueOf(this.fx.u(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String u() {
        com.bytedance.sdk.component.adexpress.dynamic.fx.fx fxVar = this.fx;
        return fxVar == null ? "" : String.valueOf(fxVar.u("adx_name"));
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVar) {
        if (izVar == null) {
            return;
        }
        String strH = izVar.h();
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            String strB = com.bytedance.sdk.component.adexpress.b.n.b(com.bytedance.sdk.component.adexpress.b.getContext());
            if ("zh".equals(strB)) {
                strB = "cn";
            }
            if (!TextUtils.isEmpty(strB) && izVar.iz() != null) {
                String strOptString = izVar.iz().optString(strB);
                if (!TextUtils.isEmpty(strOptString)) {
                    strH = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strH)) {
            return;
        }
        int iIndexOf = strH.indexOf("{{");
        int iIndexOf2 = strH.indexOf("}}");
        if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf2 >= iIndexOf) {
            String strU = u(strH.substring(iIndexOf + 2, iIndexOf2));
            StringBuilder sb = new StringBuilder(strH.substring(0, iIndexOf));
            if (!TextUtils.isEmpty(strU)) {
                sb.append(strU);
            }
            sb.append(strH.substring(iIndexOf2 + 2));
            izVar.l(sb.toString());
            return;
        }
        izVar.l(strH);
    }
}
