package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<cc> f190a = new ArrayList<>();

    public cd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f11466a = str;
    }

    public synchronized void a(cc ccVar) {
        int i = 0;
        while (true) {
            if (i >= this.f190a.size()) {
                break;
            }
            if (this.f190a.get(i).a(ccVar)) {
                this.f190a.set(i, ccVar);
                break;
            }
            i++;
        }
        if (i >= this.f190a.size()) {
            this.f190a.add(ccVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11466a);
        sb.append("\n");
        Iterator<cc> it = this.f190a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public cd() {
    }

    public synchronized cc a() {
        for (int size = this.f190a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f190a.get(size);
            if (ccVar.m245a()) {
                cg.a().m256a(ccVar.a());
                return ccVar;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ArrayList<cc> m247a() {
        return this.f190a;
    }

    public synchronized void a(boolean z) {
        for (int size = this.f190a.size() - 1; size >= 0; size--) {
            cc ccVar = this.f190a.get(size);
            if (z) {
                if (ccVar.c()) {
                    this.f190a.remove(size);
                }
            } else if (!ccVar.b()) {
                this.f190a.remove(size);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m246a() {
        return this.f11466a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m248a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f11466a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cc> it = this.f190a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m243a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cd a(JSONObject jSONObject) {
        this.f11466a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f190a.add(new cc(this.f11466a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
