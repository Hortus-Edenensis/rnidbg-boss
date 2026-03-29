package com.bytedance.sdk.openadsdk.core.kj;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5317a;
    public String b;
    public int fx = 1;
    public com.bytedance.sdk.openadsdk.my.fx.fx.nr iz;
    private long jk;
    private JSONObject l;
    private long n;
    public int nr;
    public ArrayList<Integer> pn;
    private long t;
    public String u;
    private int x;

    public long a() {
        return this.n;
    }

    public String b() {
        return this.b;
    }

    public int fx() {
        return this.x;
    }

    public int iz() {
        return this.fx;
    }

    public long jk() {
        return this.f5317a;
    }

    public long l() {
        return this.t;
    }

    public ArrayList<Integer> n() {
        return this.pn;
    }

    public int nr() {
        return this.nr;
    }

    public JSONObject pn() {
        return this.l;
    }

    public long t() {
        return this.jk;
    }

    public String u() {
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr x() {
        return this.iz;
    }

    public void b(long j) {
        this.t = j;
    }

    public void fx(int i) {
        this.fx = i;
    }

    public void nr(int i) {
        this.x = i;
    }

    public void u(String str) {
        this.u = str;
    }

    public void fx(long j) {
        this.jk = j;
    }

    public void nr(String str) {
        this.b = str;
    }

    public void u(int i) {
        this.nr = i;
    }

    public void nr(long j) {
        this.f5317a = j;
    }

    public void u(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.iz = nrVar;
    }

    public void u(ArrayList<Integer> arrayList) {
        this.pn = arrayList;
    }

    public static void u(nr nrVar) {
        int iNr;
        if (nrVar == null || nrVar.x() == null || (iNr = nrVar.nr()) >= 0 || iNr == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.nr.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObjectPn = nr.this.pn();
                if (jSONObjectPn == null) {
                    jSONObjectPn = new JSONObject();
                }
                jSONObjectPn.put("from", nr.this.iz());
                jSONObjectPn.put("err_code", nr.this.nr());
                jSONObjectPn.put("err_msg", nr.this.b());
                jSONObjectPn.put("server_res_str", nr.this.u());
                if (nr.this.n() != null && nr.this.n().size() > 0) {
                    jSONObjectPn.put("mate_unavailable_code_list", new JSONArray((Collection) nr.this.n()).toString());
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("rd_client_custom_error").u(nr.this.x().bq()).nr(jSONObjectPn.toString());
            }
        }, "rd_client_custom_error");
    }

    public void u(long j) {
        this.n = j;
    }
}
