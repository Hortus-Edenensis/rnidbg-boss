package com.zx.a.I8b7;

import com.zx.sdk.api.ZXIDChangedListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class q2 extends z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, LinkedList<ZXIDChangedListener>> f16849a = new ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.z0
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("code");
            for (String str2 : this.f16849a.keySet()) {
                for (ZXIDChangedListener zXIDChangedListener : this.f16849a.get(str2)) {
                    if (i == 0) {
                        zXIDChangedListener.onChange(a(str2, jSONObject.getString("data")));
                    }
                }
                this.f16849a.remove(str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
