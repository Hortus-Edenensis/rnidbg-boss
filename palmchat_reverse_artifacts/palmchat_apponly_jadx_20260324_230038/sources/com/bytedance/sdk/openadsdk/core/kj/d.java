package com.bytedance.sdk.openadsdk.core.kj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    private static final List<fx> nr = new CopyOnWriteArrayList();
    public static boolean u = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private final List<nr> fx = new ArrayList();
        private final String nr;
        private final String u;

        public b(JSONObject jSONObject) {
            this.u = jSONObject.optString("resource_url");
            this.nr = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.fx.add(new nr(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.u);
                jSONObject.put("content_hash", this.nr);
                JSONArray jSONArray = new JSONArray();
                Iterator<nr> it = this.fx.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().fx());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public List<nr> fx() {
            return this.fx;
        }

        public String nr() {
            return this.nr;
        }

        public String u() {
            return this.u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        private final List<b> fx = new ArrayList();
        private final String nr;
        private final String u;

        public fx(JSONObject jSONObject) {
            this.u = jSONObject.optString("channel");
            this.nr = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.fx.add(new b(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String b() {
            String str = this.u;
            if (fx() == null) {
                return str;
            }
            return str + "$" + com.bytedance.sdk.component.utils.x.nr(fx().nr());
        }

        public b fx() {
            if (this.fx.isEmpty()) {
                return null;
            }
            return this.fx.get(0);
        }

        public List<b> getResources() {
            return this.fx;
        }

        public String nr() {
            return this.nr;
        }

        public JSONObject pn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.u);
                jSONObject.put("prefix", this.nr);
                JSONArray jSONArray = new JSONArray();
                Iterator<b> it = this.fx.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().b());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String u() {
            return this.u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private final String b;
        private final String fx;
        private final String iz;
        private final String nr;
        private final String pn;
        private final long u;

        public nr(JSONObject jSONObject) {
            this.u = jSONObject.optLong("size", 0L);
            this.nr = jSONObject.optString("md5");
            this.fx = jSONObject.optString("content_hash");
            this.b = jSONObject.optString("url");
            this.pn = jSONObject.optString("mime_type");
            this.iz = jSONObject.optString("file_name");
        }

        public JSONObject fx() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.u);
                jSONObject.put("md5", this.nr);
                jSONObject.put("content_hash", this.fx);
                jSONObject.put("mime_type", this.pn);
                jSONObject.put("file_name", this.iz);
                jSONObject.put("url", this.b);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String nr() {
            return this.iz;
        }

        public String u() {
            return this.pn;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr(fx fxVar);

        void u(fx fxVar);
    }

    private static void nr(JSONObject jSONObject, final u uVar) {
        if (u) {
            final ArrayList arrayList = new ArrayList();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new fx(jSONObjectOptJSONObject));
                    }
                }
            }
            com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a(str) { // from class: com.bytedance.sdk.openadsdk.core.kj.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.y.oa.u().u(arrayList, uVar);
                }
            });
        }
    }

    public static void u(JSONObject jSONObject, u uVar) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.oa.u().u(uVar);
        u = jSONObject.optBoolean("h5_cache_resources_enable", false);
        nr(jSONObject, uVar);
    }

    public static List<fx> u() {
        return nr;
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            u = fxVar.get("h5_cache_resources_enable", false);
            JSONArray jSONArray = new JSONArray(fxVar.get("h5_cache_resources", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    nr.add(new fx(jSONObjectOptJSONObject));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        fxVar.put("h5_cache_resources_enable", u);
    }

    public static synchronized void nr(com.bytedance.sdk.component.b.nr.fx fxVar, fx fxVar2) {
        List<fx> list = nr;
        list.remove(fxVar2);
        JSONArray jSONArray = new JSONArray();
        Iterator<fx> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pn());
        }
        fxVar.put("h5_cache_resources", jSONArray.toString());
    }

    public static synchronized void u(com.bytedance.sdk.component.b.nr.fx fxVar, fx fxVar2) {
        List<fx> list = nr;
        list.add(fxVar2);
        JSONArray jSONArray = new JSONArray();
        Iterator<fx> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pn());
        }
        fxVar.put("h5_cache_resources", jSONArray.toString());
    }
}
