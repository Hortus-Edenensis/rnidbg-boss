package com.zx.a.I8b7;

import com.zx.a.I8b7.y;
import com.zx.sdk.api.ZXIDListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class p2 extends z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, LinkedList<ZXIDListener>> f16843a = new ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.z0
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("code");
            String strOptString = jSONObject.optString("message");
            for (String str2 : this.f16843a.keySet()) {
                for (ZXIDListener zXIDListener : this.f16843a.get(str2)) {
                    if (i == 0) {
                        zXIDListener.onSuccess(a(str2, jSONObject.getString("data")));
                    } else {
                        y yVar = y.b.f16887a;
                        yVar.getClass();
                        try {
                            yVar.a(new z(yVar, i, strOptString));
                        } catch (Throwable th) {
                            r2.a(th);
                        }
                        zXIDListener.onFailed(i, strOptString);
                    }
                }
                this.f16843a.remove(str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
