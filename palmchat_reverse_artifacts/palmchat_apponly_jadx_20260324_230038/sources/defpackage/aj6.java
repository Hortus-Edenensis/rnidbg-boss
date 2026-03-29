package defpackage;

import defpackage.ds0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class aj6 implements ds0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1244a;
    public JSONObject b;

    public aj6() {
    }

    public JSONObject a() {
        return this.b;
    }

    public String b() {
        return this.f1244a;
    }

    public void c(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void d(String str) {
        this.f1244a = str;
    }

    public aj6(String str, JSONObject jSONObject) {
        this.f1244a = str;
        this.b = jSONObject;
    }
}
