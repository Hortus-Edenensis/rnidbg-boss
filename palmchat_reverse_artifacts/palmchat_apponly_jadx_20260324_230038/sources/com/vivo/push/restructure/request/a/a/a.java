package com.vivo.push.restructure.request.a.a;

import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11275a;
    private int b;
    private JSONArray c;

    public a() {
        this.f11275a = 0;
        this.c = new JSONArray();
    }

    public final void a(int i) {
        this.c.put(i);
    }

    public final long b() throws JSONException {
        int i = this.f11275a;
        if (i >= this.b) {
            return 0L;
        }
        JSONArray jSONArray = this.c;
        this.f11275a = i + 1;
        return jSONArray.getLong(i);
    }

    public final String c() throws JSONException {
        int i = this.f11275a;
        if (i >= this.b) {
            return null;
        }
        JSONArray jSONArray = this.c;
        this.f11275a = i + 1;
        return jSONArray.getString(i);
    }

    public final String d() {
        JSONArray jSONArray = this.c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    public final void a(long j) {
        this.c.put(j);
    }

    public final void a(String str) {
        this.c.put(str);
    }

    public a(String str) throws JSONException {
        this.f11275a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.c = jSONArray;
        this.f11275a = 0;
        this.b = jSONArray.length();
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.c.put(it.next().a());
            }
            return;
        }
        this.c.put((Object) null);
    }

    public final int a() throws JSONException {
        int i = this.f11275a;
        if (i >= this.b) {
            return 0;
        }
        JSONArray jSONArray = this.c;
        this.f11275a = i + 1;
        return jSONArray.getInt(i);
    }

    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        T tA;
        int i = this.f11275a;
        if (i < this.b ? this.c.isNull(i) : true) {
            this.f11275a++;
            return;
        }
        JSONArray jSONArray = this.c;
        int i2 = this.f11275a;
        this.f11275a = i2 + 1;
        int i3 = jSONArray.getInt(i2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.f11275a;
            if (i5 < this.b) {
                JSONArray jSONArray2 = this.c;
                this.f11275a = i5 + 1;
                tA = aVar.a(jSONArray2.getString(i5));
            } else {
                tA = null;
            }
            list.add(tA);
        }
    }
}
