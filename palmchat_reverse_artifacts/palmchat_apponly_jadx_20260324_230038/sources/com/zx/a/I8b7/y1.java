package com.zx.a.I8b7;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class y1 extends JSONArray {
    public y1(String str) throws JSONException {
        super(str);
    }

    public synchronized void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            super.remove(0);
            r2.b("removeM " + i2);
        }
    }

    @Override // org.json.JSONArray
    public synchronized String getString(int i) throws JSONException {
        return super.getString(i);
    }

    @Override // org.json.JSONArray
    public synchronized JSONArray put(boolean z) {
        return super.put(z);
    }

    @Override // org.json.JSONArray
    public synchronized Object remove(int i) {
        return super.remove(i);
    }

    @Override // org.json.JSONArray
    public synchronized String toString() {
        return super.toString();
    }

    public y1() {
    }

    @Override // org.json.JSONArray
    public synchronized JSONArray put(Object obj) {
        return super.put(obj);
    }

    public synchronized int a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < length(); i++) {
            synchronized (this) {
                if (!super.getString(i).startsWith(str)) {
                }
            }
            return i;
        }
        return -1;
    }

    @Override // org.json.JSONArray
    public synchronized JSONArray put(int i, Object obj) throws JSONException {
        return super.put(i, obj);
    }
}
