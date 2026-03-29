package com.bytedance.sdk.component.u;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class n {
    private l u;

    private n(l lVar) {
        this.u = lVar;
    }

    public static n u(l lVar) {
        return new n(lVar);
    }

    public <T> T u(String str, Type type) throws JSONException {
        u(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.u.u(str, type);
    }

    public <T> String u(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
            string = this.u.u(t);
        } else {
            string = t.toString();
        }
        u(string);
        return string;
    }

    private static void u(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        a.u(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }
}
