package com.opos.mobad.service.g;

import com.opos.acs.st.STManager;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f9245a;
        private final com.opos.mobad.service.g.a b;

        public a(com.opos.mobad.service.g.a aVar, JSONObject jSONObject) {
            this.b = aVar;
            if (jSONObject == null) {
                this.f9245a = new JSONObject();
            } else {
                this.f9245a = jSONObject;
            }
        }

        public void a(int i) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorState", i);
                this.f9245a.put("data_event", 21);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.b("reportOutOuidError", e);
            }
        }

        public void b(String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f9245a.put("data_event", 7);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void c(String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f9245a.put("data_event", 19);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void d(String str) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("traceId", str);
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 10);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void e(String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crInfo", str);
                this.f9245a.put("data_event", 15);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void f(String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 27);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, int i2) {
            try {
                JSONObject jSONObject = new JSONObject();
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                jSONObject.put("tTemplateId", i);
                jSONObject.put("errorState", i2);
                this.f9245a.put("data_event", 13);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void b(String str, int i) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("failNum", i);
                this.f9245a.put("data_event", 5);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void c(String str, int i) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("failNum", i);
                this.f9245a.put("data_event", 20);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imgCache", i);
                jSONObject.put("imgAmount", i2);
                jSONObject.put("videoCache", i3);
                jSONObject.put("videoAmount", i4);
                this.f9245a.put("data_event", 1);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 28);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("soLoadErrorType", i);
                jSONObject.put("soLoadErrorMsg", str);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, String str, int i2) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorState", i);
                jSONObject.put("posId", str);
                jSONObject.put("posType", i2);
                this.f9245a.put("data_event", 25);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, String str, String str2) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 24);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tTemplateId", i);
                jSONObject.put("tInteractiveMode", str);
                jSONObject.put("aInteractiveMode", str2);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(int i, String str, JSONObject jSONObject) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crAmount", i);
                jSONObject2.put("crInfo", str);
                if (jSONObject != null) {
                    jSONObject2.put("crEnvInfo", jSONObject);
                }
                this.f9245a.put("data_event", 9);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject2.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f9245a.put("data_event", 6);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str, int i) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("errorState", i);
                this.f9245a.put("data_event", 4);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str, int i, int i2) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("errorState", i);
                jSONObject.put("coreVer", i2);
                this.f9245a.put("data_event", 18);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(String str, String str2, long j, long j2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("traceId", str);
                jSONObject.put("vDuration", j);
                jSONObject.put("aDuration", j2);
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 12);
                this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                this.b.a(this.f9245a);
            } catch (JSONException unused) {
            }
        }

        public void a(Map<String, String> map) {
            try {
                this.f9245a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f9245a.put("data_event", 26);
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    this.f9245a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                }
                this.b.a(this.f9245a);
            } catch (Exception unused) {
            }
        }
    }
}
