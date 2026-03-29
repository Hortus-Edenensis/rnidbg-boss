package defpackage;

import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Integer> f22286a = null;
    public HashMap<Integer, a> b = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22287a;
        public int b = 0;

        public a() {
        }

        public int a() {
            return this.f22287a;
        }

        public int b() {
            return this.b;
        }

        public void c(int i) {
            this.f22287a = i;
        }

        public void d(int i) {
            this.b = i;
        }
    }

    public yv3(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            try {
                WifiLog.d("createNestPreloadModel resObject" + jSONObject.toString());
                if (jSONObject.has("scene_list") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("scene_list")) != null && jSONArrayOptJSONArray.length() > 0) {
                    this.f22286a = new ArrayList();
                    this.b = new HashMap<>();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        int iOptInt = jSONArrayOptJSONArray.optInt(i);
                        if (iOptInt != 0) {
                            this.f22286a.add(Integer.valueOf(iOptInt));
                            if (!il5.l(Integer.toString(iOptInt)) && jSONObject.has(Integer.toString(iOptInt)) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(Integer.toString(iOptInt))) != null) {
                                a aVar = new a();
                                if (jSONObjectOptJSONObject.has("request_limit")) {
                                    aVar.c(jSONObjectOptJSONObject.optInt("request_limit"));
                                }
                                if (jSONObjectOptJSONObject.has("request_n")) {
                                    aVar.d(jSONObjectOptJSONObject.optInt("request_n"));
                                }
                                this.b.put(Integer.valueOf(iOptInt), aVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                ma3.e("NestPreloadModel init failed", e);
            }
        }
    }

    public a b(int i) {
        try {
            HashMap<Integer, a> map = this.b;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return this.b.get(Integer.valueOf(i));
        } catch (Exception unused) {
            return null;
        }
    }

    public List<Integer> c() {
        return this.f22286a;
    }
}
