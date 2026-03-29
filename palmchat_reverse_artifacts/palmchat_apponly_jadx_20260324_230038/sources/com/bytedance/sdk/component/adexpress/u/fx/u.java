package com.bytedance.sdk.component.adexpress.u.fx;

import android.text.TextUtils;
import android.util.Pair;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private List<C0206u> b;
    private String fx;
    private Map<String, u> iz = new ConcurrentHashMap();
    private String nr;
    private nr pn;
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private List<Pair<String, String>> fx;
        private String nr;
        private String u;

        public void nr(String str) {
            this.nr = str;
        }

        public String u() {
            return this.u;
        }

        public List<Pair<String, String>> nr() {
            return this.fx;
        }

        public void u(String str) {
            this.u = str;
        }

        public void u(List<Pair<String, String>> list) {
            this.fx = list;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.u.fx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0206u {
        private int fx;
        private String nr;
        private String u;

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0206u)) {
                return super.equals(obj);
            }
            String str2 = this.u;
            if (str2 != null) {
                C0206u c0206u = (C0206u) obj;
                if (str2.equals(c0206u.u()) && (str = this.nr) != null && str.equals(c0206u.nr())) {
                    return true;
                }
            }
            return false;
        }

        public int fx() {
            return this.fx;
        }

        public String nr() {
            return this.nr;
        }

        public String u() {
            return this.u;
        }

        public void nr(String str) {
            this.nr = str;
        }

        public void u(String str) {
            this.u = str;
        }

        public void u(int i) {
            this.fx = i;
        }
    }

    public String b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public List<C0206u> getResources() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public boolean iz() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(fx()) || TextUtils.isEmpty(nr())) ? false : true;
    }

    public String n() {
        JSONObject jSONObjectX;
        if (!iz() || (jSONObjectX = x()) == null) {
            return null;
        }
        return jSONObjectX.toString();
    }

    public String nr() {
        return this.u;
    }

    public nr pn() {
        return this.pn;
    }

    public Map<String, u> u() {
        return this.iz;
    }

    public JSONObject x() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", nr());
            jSONObject.putOpt("version", fx());
            jSONObject.putOpt("main", b());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0206u c0206u : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0206u.u());
                    jSONObject2.putOpt("md5", c0206u.nr());
                    jSONObject2.putOpt("level", Integer.valueOf(c0206u.fx()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.iz.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.iz.keySet()) {
                    u uVar = this.iz.get(str);
                    if (uVar != null) {
                        jSONObject3.put(str, uVar.x());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            nr nrVarPn = pn();
            if (nrVarPn != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", nrVarPn.u);
                jSONObject4.put("md5", nrVarPn.nr);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listNr = nrVarPn.nr();
                if (listNr != null) {
                    for (Pair<String, String> pair : listNr) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static u b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return u(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void fx(String str) {
        this.fx = str;
    }

    public void nr(String str) {
        this.nr = str;
    }

    public void u(String str) {
        this.u = str;
    }

    public void u(nr nrVar) {
        this.pn = nrVar;
    }

    public void u(List<C0206u> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.b = list;
    }

    public static u u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.u(jSONObject.optString("name"));
        uVar.nr(jSONObject.optString("version"));
        uVar.fx(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0206u c0206u = new C0206u();
                c0206u.u(jSONObjectOptJSONObject2.optString("url"));
                c0206u.nr(jSONObjectOptJSONObject2.optString("md5"));
                c0206u.u(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0206u);
            }
        }
        uVar.u(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    u uVarU = u(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (uVarU != null) {
                        uVar.u().put(next, uVarU);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            nr nrVar = new nr();
            nrVar.u(jSONObjectOptJSONObject.optString("url"));
            nrVar.nr(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                nrVar.u(arrayList2);
            }
            uVar.u(nrVar);
        }
        if (uVar.iz()) {
            return uVar;
        }
        return null;
    }
}
