package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class vv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f21537a = null;
    public List<String> b = null;
    public HashMap<String, a> c = null;
    public List<String> d = null;
    public List<String> e = null;
    public HashMap<String, Integer> f = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21538a;
        public int b = 0;
        public int c = 0;

        public a() {
        }

        public int d() {
            return this.c;
        }

        public int e() {
            return this.b;
        }

        public String f() {
            return this.f21538a;
        }
    }

    public vv3(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("taichikey");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                String strC = jo6.c(strOptString, "A");
                if (jSONObject.has(strOptString + "_" + strC)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(strOptString + "_" + strC);
                    if (jSONObject2 != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("request_tab_pages");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            this.f21537a = new ArrayList();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                this.f21537a.add(jSONArrayOptJSONArray.optString(i));
                            }
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("show_tab_pages");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            this.b = new ArrayList();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                this.b.add(jSONArrayOptJSONArray2.optString(i2));
                            }
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("exit_request_tab_pages");
                        if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            this.d = new ArrayList();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                                this.d.add(jSONArrayOptJSONArray3.optString(i3));
                            }
                        }
                        JSONArray jSONArrayOptJSONArray4 = jSONObject2.optJSONArray("exit_show_tab_pages");
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                            this.e = new ArrayList();
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                                this.e.add(jSONArrayOptJSONArray4.optString(i4));
                            }
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("tab_enter_limit");
                        if (jSONObjectOptJSONObject != null) {
                            this.f = new HashMap<>();
                            List<String> list = this.f21537a;
                            if (list != null && !list.isEmpty()) {
                                for (int i5 = 0; i5 < this.f21537a.size(); i5++) {
                                    String str = this.f21537a.get(i5);
                                    if (!il5.l(str) && jSONObjectOptJSONObject.has(str)) {
                                        this.f.put(str, Integer.valueOf(jSONObjectOptJSONObject.optInt(str)));
                                    }
                                }
                            }
                            List<String> list2 = this.b;
                            if (list2 != null && !list2.isEmpty()) {
                                for (int i6 = 0; i6 < this.b.size(); i6++) {
                                    String str2 = this.b.get(i6);
                                    if (!il5.l(str2) && jSONObjectOptJSONObject.has(str2)) {
                                        this.f.put(str2, Integer.valueOf(jSONObjectOptJSONObject.optInt(str2)));
                                    }
                                }
                            }
                            List<String> list3 = this.d;
                            if (list3 != null && !list3.isEmpty()) {
                                for (int i7 = 0; i7 < this.d.size(); i7++) {
                                    String str3 = this.d.get(i7);
                                    if (!il5.l(str3) && jSONObjectOptJSONObject.has(str3)) {
                                        this.f.put(str3, Integer.valueOf(jSONObjectOptJSONObject.optInt(str3)));
                                    }
                                }
                            }
                            List<String> list4 = this.e;
                            if (list4 != null && !list4.isEmpty()) {
                                for (int i8 = 0; i8 < this.e.size(); i8++) {
                                    String str4 = this.e.get(i8);
                                    if (!il5.l(str4) && jSONObjectOptJSONObject.has(str4)) {
                                        this.f.put(str4, Integer.valueOf(jSONObjectOptJSONObject.optInt(str4)));
                                    }
                                }
                            }
                        }
                        JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("request_show_frequency");
                        if (jSONArrayOptJSONArray5 == null || jSONArrayOptJSONArray5.length() <= 0) {
                            return;
                        }
                        this.c = new HashMap<>();
                        uv3.f.clear();
                        for (int i9 = 0; i9 < jSONArrayOptJSONArray5.length(); i9++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray5.optJSONObject(i9);
                            String strOptString2 = jSONObjectOptJSONObject2.optString("tab_page_name");
                            if (!TextUtils.isEmpty(strOptString2)) {
                                a aVar = new a();
                                aVar.f21538a = strOptString2;
                                aVar.c = jSONObjectOptJSONObject2.optInt("frequency_pv");
                                aVar.b = jSONObjectOptJSONObject2.optInt("frequency_time_seconds");
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    int iOptInt = jSONObjectOptJSONObject2.optInt("frequency_interval_seconds");
                                    LogUtil.d("", "SEEMEPOP createNestPopTypeModel idName " + strOptString2 + " intervalSeconds " + iOptInt);
                                    uv3.f.put(strOptString2, Integer.valueOf(iOptInt));
                                }
                                this.c.put(strOptString2, aVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                ma3.e("NestPopTypeModel init failed.", e);
            }
        }
    }

    public List<String> b() {
        return this.d;
    }

    public List<String> c() {
        return this.e;
    }

    public a d() {
        HashMap<String, a> map = this.c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.c.get("allPop");
    }

    public List<String> e() {
        return this.f21537a;
    }

    public List<String> f() {
        return this.b;
    }

    public int g(String str) {
        HashMap<String, Integer> map = this.f;
        if (map == null || map.isEmpty() || il5.l(str) || !this.f.containsKey(str)) {
            return -1;
        }
        return this.f.get(str).intValue();
    }

    public a h(String str) {
        HashMap<String, a> map = this.c;
        if (map == null || map.isEmpty() || il5.l(str) || !this.c.containsKey(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public a i(String str) {
        HashMap<String, a> map = this.c;
        if (map == null || map.isEmpty() || il5.l(str)) {
            return null;
        }
        try {
            for (Map.Entry<String, a> entry : this.c.entrySet()) {
                String key = entry.getKey();
                LogUtil.d("", "SEEMEPOP getTabPageOtherInfo key " + key + " tabPageName " + str);
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    return entry.getValue();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
