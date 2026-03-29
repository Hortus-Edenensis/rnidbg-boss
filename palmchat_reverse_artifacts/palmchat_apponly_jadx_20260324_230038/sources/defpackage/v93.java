package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21386a;
    public ab3 b;

    public v93(String str, ab3 ab3Var) {
        this.b = ab3Var;
        this.f21386a = str;
    }

    public void a(JSONObject jSONObject) {
        this.b.onResult(this.f21386a, jSONObject);
    }
}
