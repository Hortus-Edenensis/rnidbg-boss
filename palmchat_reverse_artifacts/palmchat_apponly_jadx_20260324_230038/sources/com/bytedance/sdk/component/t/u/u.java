package com.bytedance.sdk.component.t.u;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.t.b.b;
import com.bytedance.sdk.component.t.b.pn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f5168a;
    private String b;
    private com.bytedance.sdk.component.t.fx.u fx;
    private b iz;
    private int jk = 1;
    private String n;
    private Map<String, Object> nr;
    private String pn;
    private com.bytedance.sdk.component.t.b.nr t;
    private JSONObject u;
    private b x;

    public u(com.bytedance.sdk.component.t.fx.u uVar, JSONObject jSONObject, Map<String, Object> map) {
        this.fx = uVar;
        this.u = jSONObject;
        this.nr = map;
    }

    private void n() {
        if (this.jk != 2) {
            com.bytedance.sdk.component.t.fx.u uVar = this.fx;
            if (uVar == null) {
                return;
            } else {
                this.n = uVar.nr();
            }
        }
        if (!TextUtils.isEmpty(this.n)) {
            this.b = Uri.parse(this.n).getHost();
        }
        if (!TextUtils.isEmpty(this.b)) {
            String str = this.b.split("/")[0];
            this.b = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.b.length();
            }
            this.b = this.b.substring(0, iIndexOf);
        }
        nr(this.n);
    }

    public String b() {
        return this.pn;
    }

    public JSONObject fx() {
        return this.u;
    }

    public void iz() {
        n();
        com.bytedance.sdk.component.t.b.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.u();
        } else {
            com.bytedance.sdk.component.t.x.u.u().u(this.b, this, new com.bytedance.sdk.component.t.b.u() { // from class: com.bytedance.sdk.component.t.u.u.1
            });
        }
    }

    public Map<String, Object> nr() {
        return this.f5168a;
    }

    public b pn() {
        return this.iz;
    }

    public Map<String, Object> u() {
        return this.nr;
    }

    public com.bytedance.sdk.component.t.fx.u x() {
        return this.fx;
    }

    private void nr(String str) {
        JSONObject jSONObjectU = com.bytedance.sdk.component.t.n.nr.u(str);
        if (jSONObjectU == null) {
            return;
        }
        Iterator<String> itKeys = jSONObjectU.keys();
        this.f5168a = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectU.opt(next);
                if (objOpt instanceof String) {
                    objOpt = u((String) objOpt, this.u);
                }
                this.f5168a.put(next, objOpt);
            }
        }
    }

    public void u(String str) {
        this.pn = str;
    }

    public void u(b bVar) {
        if (bVar instanceof nr) {
            this.iz = bVar;
        } else {
            this.x = bVar;
        }
    }

    public u(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.u = jSONObject;
        this.nr = map;
    }

    private static Object u(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith("}")) ? com.bytedance.adsdk.nr.nr.u.u(str.substring(2, str.length() - 1)).u(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void u(com.bytedance.sdk.component.t.b.nr nrVar) {
        this.t = nrVar;
    }

    public void nr(Map<String, Object> map) {
        pn pnVarNr;
        pn pnVarNr2;
        b bVar = this.iz;
        if (bVar != null && (pnVarNr2 = bVar.nr()) != null) {
            pnVarNr2.nr(this, this.nr);
        }
        b bVar2 = this.x;
        if (bVar2 == null || (pnVarNr = bVar2.nr()) == null) {
            return;
        }
        pnVarNr.nr(this, map);
    }

    public void u(Map<String, Object> map) {
        pn pnVarNr;
        pn pnVarNr2;
        b bVar = this.iz;
        if (bVar != null && (pnVarNr2 = bVar.nr()) != null) {
            pnVarNr2.u(this, map);
        }
        b bVar2 = this.x;
        if (bVar2 == null || (pnVarNr = bVar2.nr()) == null) {
            return;
        }
        pnVarNr.u(this, map);
    }
}
