package com.qq.gdt.action.h;

import com.qq.gdt.action.g.c;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.multioprocess.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if ((jSONObject == null || jSONObject.length() <= 0) && jSONObject2 != null) {
            jSONObject2.length();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject2.put(next, jSONObject.optString(next));
        }
        return jSONObject2;
    }

    public static void a(int i) {
        a(i, null, null, null);
    }

    public static void a(int i, com.qq.gdt.action.c.a aVar) {
        a(i, aVar, null, null);
    }

    public static void a(int i, com.qq.gdt.action.c.a aVar, JSONObject jSONObject) {
        a(i, aVar, jSONObject, null);
    }

    public static void a(int i, com.qq.gdt.action.c.a aVar, JSONObject jSONObject, b bVar) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                o.c("sendEvent id, jsonObject e = " + th.toString());
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (bVar != null) {
                jSONObject2 = bVar.a();
            }
            jSONObject = a(jSONObject2, jSONObject);
        } catch (Throwable th2) {
            o.a("sendEvent userMessage , ex = " + th2, new Object[0]);
        }
        c.a().a(i, aVar, jSONObject);
    }

    public static void a(int i, b bVar) {
        a(i, null, null, bVar);
    }

    public static void a(int i, JSONObject jSONObject) {
        a(i, null, jSONObject, null);
    }

    public static void a(int i, JSONObject jSONObject, b bVar) {
        a(i, null, jSONObject, bVar);
    }
}
