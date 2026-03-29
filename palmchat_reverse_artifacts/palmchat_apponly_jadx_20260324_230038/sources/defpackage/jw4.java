package defpackage;

import com.uc.crashsdk.export.LogType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class jw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18526a;
    public long b;
    public String c;
    public List<zg> d;
    public zg e;
    public av f;
    public du5 g;
    public wq0 h;
    public ke i;
    public String j;

    public String a() {
        JSONObject jSONObjectB = b();
        return jSONObjectB != null ? jSONObjectB.toString() : "{}";
    }

    public JSONObject b() {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", String.valueOf(this.f18526a));
        map.put("time", String.valueOf(this.b));
        map.put("dhid", this.c);
        map.put("taichi_bucket", xn1.h().e().o());
        map.put("taichi_exp", xn1.h().e().q());
        map.put("taichi_group", xn1.h().e().r());
        map.put("taichi_configVersion", xn1.h().e().p());
        int i = this.f18526a;
        if (i != 1 && i != 2) {
            return null;
        }
        zg zgVar = this.e;
        if (zgVar != null) {
            zgVar.a(map);
        }
        av avVar = this.f;
        if (avVar != null) {
            avVar.a(map);
        }
        wq0 wq0Var = this.h;
        if (wq0Var != null) {
            wq0Var.a(map);
        }
        return new JSONObject(map);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", String.valueOf(this.f18526a));
            jSONObject.put("time", String.valueOf(this.b));
            String str = this.c;
            if (str != null) {
                jSONObject.put("cid", str);
            }
            int i = this.f18526a;
            if (i == 1) {
                zg zgVar = this.e;
                if (zgVar != null) {
                    jSONObject.put("app", zgVar);
                }
                av avVar = this.f;
                if (avVar != null) {
                    jSONObject.put("build", avVar);
                }
                du5 du5Var = this.g;
                if (du5Var != null) {
                    jSONObject.put("telephony", du5Var);
                }
                wq0 wq0Var = this.h;
                if (wq0Var != null) {
                    jSONObject.put("crash", wq0Var);
                }
            } else if (i == 2) {
                zg zgVar2 = this.e;
                if (zgVar2 != null) {
                    jSONObject.put("app", zgVar2);
                }
                av avVar2 = this.f;
                if (avVar2 != null) {
                    jSONObject.put("build", avVar2);
                }
                du5 du5Var2 = this.g;
                if (du5Var2 != null) {
                    jSONObject.put("telephony", du5Var2);
                }
                ke keVar = this.i;
                if (keVar != null) {
                    jSONObject.put(LogType.ANR_TYPE, keVar);
                }
            } else if (i == 101) {
                av avVar3 = this.f;
                if (avVar3 != null) {
                    jSONObject.put("build", avVar3);
                }
                String str2 = this.j;
                if (str2 != null) {
                    jSONObject.put("feedback", str2);
                }
            } else if (i == 100) {
                av avVar4 = this.f;
                if (avVar4 != null) {
                    jSONObject.put("build", avVar4);
                }
                if (this.d != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<zg> it = this.d.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObject.put("apps", jSONArray);
                }
            }
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}
