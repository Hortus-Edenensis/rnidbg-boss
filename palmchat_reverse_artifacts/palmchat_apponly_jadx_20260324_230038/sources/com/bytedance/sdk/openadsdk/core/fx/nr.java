package com.bytedance.sdk.openadsdk.core.fx;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr u;
    private volatile SharedPreferences nr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sp_dynamic_tmpl_config", 0);
    private volatile SharedPreferences fx = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sp_dynamic_tmpl_config_v3", 0);

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new nr();
                }
            }
        }
        return u;
    }

    public void delete(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strNr = nr(str, null, z);
            if (TextUtils.isEmpty(strNr)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strNr);
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        i = -1;
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("id"))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    jSONArray.remove(i);
                    u(str, jSONArray.toString(), z);
                }
            }
        } catch (Exception unused) {
        }
    }

    public JSONArray nr(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!fx.u().u(i)) {
            return u(str);
        }
        try {
            final String strNr = nr(str, null, true);
            x.nr(new a("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.fx.nr.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.openadsdk.core.nativeexpress.u.u> setU = com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.u().u(str);
                        JSONArray jSONArray = new JSONArray();
                        if (setU == null || setU.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar : setU) {
                                if (uVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    String[] strArrSplit = uVar.u().split("_");
                                    if (strArrSplit.length == 2) {
                                        jSONObject.put("id", strArrSplit[1]);
                                        jSONObject.put("md5", uVar.nr());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (!(strNr == null && z) && jSONArray.toString().equals(strNr)) {
                            return;
                        }
                        nr.this.u(str, jSONArray.toString(), true);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strNr)) {
                return null;
            }
            return new JSONArray(strNr);
        } catch (Exception unused) {
            return null;
        }
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.u.fx.fx fxVar, boolean z) {
        if (fxVar == null || fxVar.nr() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strNr = nr(str, null, z);
            JSONArray jSONArray = strNr == null ? new JSONArray() : new JSONArray(strNr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", fxVar.nr());
            jSONObject.put("md5", fxVar.fx());
            jSONArray.put(jSONObject);
            u(str, jSONArray.toString(), z);
        } catch (Exception unused) {
        }
    }

    public void u(String str, String str2) {
        delete(str, str2, false);
    }

    public String nr(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.fx;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.nr;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (fx.u().nr()) {
                return com.bytedance.sdk.component.x.fx.u.nr.nr(str3, str, str2);
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void u(String str, com.bytedance.sdk.component.adexpress.u.fx.fx fxVar) {
        update(str, fxVar, false);
    }

    public JSONArray u(final String str, int i) {
        try {
            final String strNr = nr(str, null, false);
            x.nr(new a("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.fx.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.component.adexpress.u.fx.nr> setU = com.bytedance.sdk.component.adexpress.u.nr.nr.u(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (setU == null || setU.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.component.adexpress.u.fx.nr nrVar : setU) {
                                if (nrVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", nrVar.nr());
                                    jSONObject.put("md5", nrVar.fx());
                                    jSONArray.put(jSONObject);
                                }
                            }
                            z = true;
                        }
                        if (!(strNr == null && z) && jSONArray.toString().equals(strNr)) {
                            return;
                        }
                        nr.this.u(str, jSONArray.toString(), false);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strNr)) {
                return null;
            }
            return new JSONArray(strNr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray u(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.nativeexpress.u.u> setU = com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.u().u(str);
            if (setU != null && setU.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar : setU) {
                    if (uVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = uVar.u().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", uVar.nr());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            k.u("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void u(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.fx;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.nr;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (fx.u().nr()) {
                com.bytedance.sdk.component.x.fx.u.nr.u(str3, str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}
