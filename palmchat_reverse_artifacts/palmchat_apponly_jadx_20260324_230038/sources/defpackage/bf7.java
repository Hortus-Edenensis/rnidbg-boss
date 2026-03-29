package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1704a;
    public String b;
    public JSONObject c;

    public bf7(int i) {
        this.f1704a = i;
    }

    public boolean a() {
        return this.f1704a == 0;
    }

    public bf7(int i, Throwable th) {
        this.f1704a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public bf7(int i, String str) {
        this.f1704a = i;
        this.b = str;
    }

    public bf7(int i, JSONObject jSONObject) {
        this.f1704a = i;
        this.c = jSONObject;
    }
}
