package defpackage;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class vf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21430a;
    public String b;
    public JSONObject c;
    public byte[] d;

    public vf7(int i) {
        this.f21430a = i;
    }

    public boolean a() {
        return this.f21430a != 207;
    }

    public byte[] b() {
        return this.d;
    }

    public vf7(int i, String str) {
        this.f21430a = i;
        this.b = str;
    }

    public vf7(int i, Throwable th) {
        this.f21430a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public vf7(int i, JSONObject jSONObject) {
        this.f21430a = i;
        this.c = jSONObject;
    }

    public vf7(int i, byte[] bArr) {
        this.f21430a = i;
        this.d = bArr;
    }
}
