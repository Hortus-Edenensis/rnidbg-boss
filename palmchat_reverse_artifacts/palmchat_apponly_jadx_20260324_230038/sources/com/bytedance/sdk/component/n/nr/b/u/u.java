package com.bytedance.sdk.component.n.nr.b.u;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.n.u.nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5154a;
    private byte b;
    private byte fx;
    private long iz;
    private byte jk;
    private int l;
    private String n;
    private nr nr;
    private long pn;
    private String t;
    protected JSONObject u;
    private long x;

    public u(String str, JSONObject jSONObject) {
        this.f5154a = str;
        this.u = jSONObject;
    }

    public static com.bytedance.sdk.component.n.u.nr b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            u uVar = new u();
            uVar.u((byte) iOptInt);
            uVar.nr((byte) iOptInt2);
            uVar.u(jSONObject.optJSONObject("event"));
            uVar.u(jSONObject.optString("localId"));
            uVar.nr(jSONObject.optString("genTime"));
            uVar.u(jSONObject.optInt("channel"));
            return uVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public long a() {
        return this.iz;
    }

    public void fx(String str) {
        this.t = str;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public String iz() {
        if (TextUtils.isEmpty(this.f5154a)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f5154a);
            jSONObject.put("event", x());
            jSONObject.put("genTime", t());
            jSONObject.put("priority", (int) this.b);
            jSONObject.put("type", (int) this.fx);
            jSONObject.put("channel", this.l);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String jk() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public long n() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public byte nr() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public byte pn() {
        return this.b;
    }

    public String t() {
        return this.n;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public nr u() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public synchronized JSONObject x() {
        nr nrVar;
        if (this.u == null && (nrVar = this.nr) != null) {
            this.u = nrVar.u(jk());
        }
        return this.u;
    }

    public void fx(byte b) {
        this.jk = b;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void nr(String str) {
        this.n = str;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void u(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public String fx() {
        return this.f5154a;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void nr(long j) {
        this.iz = j;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void u(byte b) {
        this.fx = b;
    }

    public u(String str, nr nrVar) {
        this.f5154a = str;
        this.nr = nrVar;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void fx(long j) {
        this.x = j;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void nr(byte b) {
        this.b = b;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void u(String str) {
        this.f5154a = str;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void u(long j) {
        this.pn = j;
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public void u(int i) {
        this.l = i;
    }

    private u() {
    }

    @Override // com.bytedance.sdk.component.n.u.nr
    public byte b() {
        return this.fx;
    }
}
