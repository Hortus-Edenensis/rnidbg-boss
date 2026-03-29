package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class cj implements Comparable<cj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f11472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedList<cb> f206a;

    public cj() {
        this(null, 0);
    }

    public synchronized void a(cb cbVar) {
        if (cbVar != null) {
            this.f206a.add(cbVar);
            int iA = cbVar.a();
            if (iA > 0) {
                this.f11472a += cbVar.a();
            } else {
                int i = 0;
                for (int size = this.f206a.size() - 1; size >= 0 && this.f206a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f11472a += iA * i;
            }
            if (this.f206a.size() > 30) {
                this.f11472a -= this.f206a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f205a + ":" + this.f11472a;
    }

    public cj(String str) {
        this(str, 0);
    }

    public cj(String str, int i) {
        this.f206a = new LinkedList<>();
        this.f204a = 0L;
        this.f205a = str;
        this.f11472a = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cj cjVar) {
        if (cjVar == null) {
            return 1;
        }
        return cjVar.f11472a - this.f11472a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f204a);
        jSONObject.put("wt", this.f11472a);
        jSONObject.put("host", this.f205a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cb> it = this.f206a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m241a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized cj a(JSONObject jSONObject) {
        this.f204a = jSONObject.getLong("tt");
        this.f11472a = jSONObject.getInt("wt");
        this.f205a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f206a.add(new cb().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
