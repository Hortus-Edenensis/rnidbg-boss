package defpackage;

import com.lantern.auth.server.WkParams;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1575a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public void a(HashMap<String, String> map) {
        String str = this.f1575a;
        if (str != null) {
            map.put("device", str);
        }
        String str2 = this.b;
        if (str2 != null) {
            map.put(WkParams.MODEL, str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            map.put("product", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            map.put("board", str4);
        }
        String str5 = this.e;
        if (str5 != null) {
            map.put("firmware", str5);
        }
        map.put("sdk_int", String.valueOf(this.f));
        String str6 = this.g;
        if (str6 != null) {
            map.put("baseband", str6);
        }
        String str7 = this.h;
        if (str7 != null) {
            map.put("kernel", str7);
        }
        String str8 = this.i;
        if (str8 != null) {
            map.put("buildIncremental", str8);
        }
        String str9 = this.j;
        if (str9 != null) {
            map.put("buildDisplay", str9);
        }
        String str10 = this.k;
        if (str10 != null) {
            map.put("buildType", str10);
        }
        String str11 = this.m;
        if (str11 != null) {
            map.put("serial", str11);
        }
        String str12 = this.n;
        if (str12 != null) {
            map.put("manufacture", str12);
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f1575a;
            if (str != null) {
                jSONObject.put("device", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put(WkParams.MODEL, str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("product", str3);
            }
            String str4 = this.d;
            if (str4 != null) {
                jSONObject.put("board", str4);
            }
            String str5 = this.e;
            if (str5 != null) {
                jSONObject.put("firmware", str5);
            }
            jSONObject.put("sdk_int", this.f);
            String str6 = this.g;
            if (str6 != null) {
                jSONObject.put("baseband", str6);
            }
            String str7 = this.h;
            if (str7 != null) {
                jSONObject.put("kernel", str7);
            }
            String str8 = this.i;
            if (str8 != null) {
                jSONObject.put("buildIncremental", str8);
            }
            String str9 = this.j;
            if (str9 != null) {
                jSONObject.put("buildDisplay", str9);
            }
            String str10 = this.k;
            if (str10 != null) {
                jSONObject.put("buildType", str10);
            }
            String str11 = this.m;
            if (str11 != null) {
                jSONObject.put("serial", str11);
            }
            String str12 = this.n;
            if (str12 != null) {
                jSONObject.put("manufacture", str12);
            }
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}
