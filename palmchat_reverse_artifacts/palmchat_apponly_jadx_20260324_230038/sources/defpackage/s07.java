package defpackage;

import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class s07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<b> f20644a = new ConcurrentLinkedQueue<>();
    public static ConcurrentHashMap<Integer, b> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(JSONObject jSONObject);
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    public static String b(Object obj) {
        for (b bVar : f20644a) {
            if (bVar != null && bVar.j(obj)) {
                return bVar.k();
            }
        }
        return null;
    }

    public static JSONArray c() {
        b next;
        JSONArray jSONArray = new JSONArray();
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.n());
        }
        return jSONArray;
    }

    public static JSONArray d(String str) {
        b next;
        JSONArray jSONArray = new JSONArray();
        String[] strArrSplit = str.split("\n");
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (nv6.i(next.k())) {
                JSONArray jSONArrayD = next.d(strArrSplit);
                if (!gg7.f(jSONArrayD)) {
                    jSONArray.put(next.f(CrashType.ANR, jSONArrayD));
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray e(String str, String str2, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("header")) != null) {
                String strValueOf = String.valueOf(jSONObjectOptJSONObject.opt("aid"));
                if (nv6.k(strValueOf)) {
                    try {
                        String strL = b.l(strValueOf);
                        if (!TextUtils.isEmpty(strL)) {
                            jSONObjectOptJSONObject.put("x-auth-token", strL);
                        }
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("package"))) {
                        jSONArray2.put(jSONObjectOptJSONObject2);
                        break;
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("so_list");
                    if (!gg7.f(jSONArrayOptJSONArray)) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            if (str.contains(jSONArrayOptJSONArray.optString(i2))) {
                                jSONArray2.put(jSONObjectOptJSONObject2);
                                break;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return jSONArray2;
    }

    public static JSONArray f(Throwable th, Thread thread, File file) {
        b next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTraceElementArrT = yl7.t(th);
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (nv6.g(next.k())) {
                JSONArray jSONArrayC = next.c(stackTraceElementArrT, th);
                if (!gg7.f(jSONArrayC)) {
                    jSONArray.put(next.f(CrashType.JAVA, jSONArrayC));
                }
            } else {
                kj7.a("not enable javaCrash aid: " + next.k());
            }
        }
        if (gg7.f(jSONArray)) {
            return null;
        }
        if (file != null) {
            try {
                re7.l(new File(file, "all_data.json"), jSONArray, false);
            } catch (IOException unused) {
            }
        }
        return jSONArray;
    }

    public static void g(b bVar) {
        f20644a.add(bVar);
        if (bVar.p()) {
            b.put(4444, bVar);
        }
    }

    public static void h(File file, CrashType crashType) {
        b next;
        if (file == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (nv6.k(next.k())) {
                jSONArray.put(next.e(crashType));
            } else {
                kj7.a("not enable NativeCrash aid: " + next.k());
            }
        }
        if (gg7.f(jSONArray)) {
            return;
        }
        try {
            re7.l(new File(file, "all_data.json"), jSONArray, false);
        } catch (Exception unused) {
        }
    }

    public static void i(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject jSONObjectOptJSONObject;
        kj7.a("uploadFromFile with allData " + jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length() && (jSONObjectOptJSONObject = jSONArray.optJSONObject(i)) != null; i++) {
            if (gg7.a(jSONObjectOptJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                ev6.u(jSONObject2, jSONObject);
                ev6.u(jSONObject2, jSONObjectOptJSONObject);
                aVar.a(jSONObject2);
            } else {
                try {
                    String strL = b.l(gg7.i(jSONObjectOptJSONObject, "header", "aid"));
                    if (!TextUtils.isEmpty(strL)) {
                        JSONObject jSONObject3 = (JSONObject) jSONObjectOptJSONObject.remove("header");
                        jSONObject3.put("x-auth-token", strL);
                        jSONObjectOptJSONObject.put("header", jSONObject3);
                    }
                } catch (Throwable unused) {
                }
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        ev6.u(jSONObject4, jSONObject);
        try {
            jSONObject4.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.a(jSONObject4);
    }

    public static JSONArray j() {
        b next;
        JSONArray jSONArray = new JSONArray();
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.e(null));
        }
        return jSONArray;
    }

    public static int k() {
        return f20644a.size();
    }

    public static List<String> l() {
        b next;
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = f20644a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.k());
        }
        return arrayList;
    }
}
