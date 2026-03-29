package com.xiaomi.push;

import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bf extends JSONArray implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11436a = 2;

    @Override // com.xiaomi.push.be
    public int a() {
        return this.f11436a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof be) {
            this.f11436a += ((be) obj).a();
        }
        return super.put(obj);
    }
}
