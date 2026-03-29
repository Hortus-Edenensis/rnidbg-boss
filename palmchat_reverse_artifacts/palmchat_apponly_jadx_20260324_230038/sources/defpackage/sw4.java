package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sw4 {
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public aw o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Object> f20862a = null;
    public HashMap<String, String> b = null;
    public int c = 2;
    public boolean d = false;
    public JSONObject e = null;
    public int j = 1;
    public int k = 1;
    public ux4 l = new ux4(10000, 0, 1.0f);
    public boolean m = false;
    public String n = null;

    public static sw4 a(int i, String str) {
        sw4 sw4Var = new sw4();
        sw4Var.j = i;
        sw4Var.f = str;
        sw4Var.h = true;
        return sw4Var;
    }

    public static sw4 b(int i, String str, HashMap<String, Object> map) {
        sw4 sw4VarA = a(i, str);
        sw4VarA.f20862a = map;
        return sw4VarA;
    }

    public static sw4 c(int i, String str, JSONObject jSONObject) {
        sw4 sw4VarA = a(i, str);
        sw4VarA.e = jSONObject;
        return sw4VarA;
    }

    public JSONObject d() {
        JSONObject jSONObject;
        if (this.f20862a != null) {
            jSONObject = new JSONObject(this.f20862a);
        } else {
            jSONObject = this.e;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
        }
        LogUtil.i("RequestArgs", " body= " + jSONObject + " url =" + this.f);
        return jSONObject;
    }

    public sw4 e(String str) {
        this.n = str;
        return this;
    }

    public sw4 f(boolean z) {
        this.m = z;
        return this;
    }
}
