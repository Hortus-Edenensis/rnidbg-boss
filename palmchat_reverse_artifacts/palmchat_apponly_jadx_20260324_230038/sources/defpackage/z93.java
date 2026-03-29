package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22381a;

    public z93(JSONObject jSONObject) {
        this.f22381a = jSONObject;
        if (jSONObject == null) {
            this.f22381a = new JSONObject();
        }
    }

    public String a(String str, String str2) {
        return this.f22381a.optString(str, str2);
    }
}
