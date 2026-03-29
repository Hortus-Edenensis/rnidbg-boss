package com.zm.fda.O52OZ;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ0O5 {
    private boolean a(Class cls) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:3:0x0002, B:5:0x0014, B:7:0x0022, B:8:0x002a, B:10:0x0030, B:20:0x0051, B:13:0x0037, B:15:0x003b, B:18:0x0046, B:19:0x004a, B:25:0x0060, B:29:0x006c, B:28:0x0068, B:21:0x0054, B:23:0x0058, B:30:0x0072), top: B:35:0x0002 }] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Object obj) {
        ?? jSONObject;
        ?? r7;
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    jSONObject = new JSONArray();
                    for (int i = 0; i < list.size(); i++) {
                        Object obj3 = list.get(i);
                        if (obj3 != null) {
                            if ((obj3 instanceof String) && obj3.getClass().isPrimitive()) {
                                jSONObject.put(obj3);
                            } else {
                                jSONObject.put(a(obj3));
                            }
                        }
                    }
                } else {
                    boolean z = obj2 instanceof Map;
                    r7 = obj2;
                    if (z) {
                        jSONObject = new JSONObject((Map) obj2);
                    }
                    jSONObject2.put(field.getName(), r7 != 0 ? "" : field.get(obj));
                }
                r7 = jSONObject;
                jSONObject2.put(field.getName(), r7 != 0 ? "" : field.get(obj));
            }
            return jSONObject2.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
