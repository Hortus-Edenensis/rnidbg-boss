package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class aw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f1591a = {"88888010", "88888027"};
    public String[] b = {"88888003", "88888024", "88888009", "88888012", "88888005", "88888026", "88888014", "88888023"};
    public int c;
    public List<String> d;
    public List<String> e;
    public List<String> f;
    public int g;
    public int h;

    public aw3(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                String strO = zv3.o();
                if (jSONObject.has(strO) && (jSONObject2 = jSONObject.getJSONObject(strO)) != null) {
                    this.c = jSONObject2.optInt("adRequestTime");
                    this.g = jSONObject2.optInt("frequencyTime");
                    this.h = jSONObject2.optInt("frequencyPv");
                    if (jSONObject2.has("nativeAdType")) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("nativeAdType");
                        this.d = new ArrayList();
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                            this.d.addAll(Arrays.asList(this.f1591a));
                        } else {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                this.d.add(jSONArrayOptJSONArray.optString(i));
                            }
                        }
                    }
                    if (jSONObject2.has("nativeAdType2")) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("nativeAdType2");
                        this.e = new ArrayList();
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                            this.e.addAll(Arrays.asList(this.b));
                        } else {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                this.e.add(jSONArrayOptJSONArray2.optString(i2));
                            }
                        }
                    }
                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("templateAdType");
                    if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                        return;
                    }
                    this.f = new ArrayList();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        this.f.add(jSONArrayOptJSONArray3.optString(i3));
                    }
                }
            } catch (Exception e) {
                ma3.e("NestPublicTypeModel init failed.", e);
            }
        }
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.g;
    }

    public List<String> e() {
        List<String> list = this.d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.d;
    }

    public List<String> f() {
        List<String> list = this.e;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.e;
    }

    public List<String> g() {
        List<String> list = this.f;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f;
    }
}
