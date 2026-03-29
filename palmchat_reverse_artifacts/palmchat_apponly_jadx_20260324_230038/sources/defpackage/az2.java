package defpackage;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class az2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f1611a = new Gson();

    public static <T> T a(String str, Class<T> cls) {
        try {
            return (T) f1611a.fromJson(str, (Class) cls);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static <T> T b(String str, Type type) {
        return (T) f1611a.fromJson(str, type);
    }

    public static String c(Object obj) {
        try {
            return f1611a.toJson(obj);
        } catch (Exception unused) {
            return "";
        }
    }

    public static HashMap<String, String> d(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, (String) jSONObject.opt(next));
            }
        }
        return map;
    }
}
