package defpackage;

import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20122a;
    public JSONObject b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20123a;
        public JSONObject b = new JSONObject();
        public boolean c = true;

        public static Object d(Object obj) {
            if (obj == null) {
                return JSONObject.NULL;
            }
            if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
            return obj;
        }

        public a a(String str, Object obj) {
            try {
                this.b.put(str, d(obj));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

        public pw4 b() {
            pw4 pw4Var = new pw4();
            pw4Var.f(this.f20123a);
            pw4Var.d(this.b);
            pw4Var.e(this.c);
            return pw4Var;
        }

        public a c(String str) {
            this.f20123a = str;
            return this;
        }
    }

    public JSONObject a() {
        return this.b;
    }

    public String b() {
        return this.f20122a;
    }

    public boolean c() {
        return this.c;
    }

    public void d(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(String str) {
        this.f20122a = str;
    }

    public pw4() {
    }
}
