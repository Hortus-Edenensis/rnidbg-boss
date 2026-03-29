package defpackage;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22406a;
    public String b;
    public String c;
    public int d;
    public String e;
    public boolean f;
    public boolean g;
    public String h;

    public void a(HashMap<String, String> map) {
        String str = this.f22406a;
        if (str != null) {
            map.put("name", str);
        }
        String str2 = this.b;
        if (str2 != null) {
            map.put("packageName", str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            map.put("processName", str3);
        }
        map.put("versioncode", String.valueOf(this.d));
        String str4 = this.e;
        if (str4 != null) {
            map.put("versionName", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            map.put("installer", str5);
        }
        map.put("channelid", xn1.h().e().d());
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f22406a;
            if (str != null) {
                jSONObject.put("name", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put("packageName", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("processName", str3);
            }
            jSONObject.put("versioncode", String.valueOf(this.d));
            String str4 = this.e;
            if (str4 != null) {
                jSONObject.put("versionName", str4);
            }
            jSONObject.put("system", this.f);
            jSONObject.put("enabled", this.g);
            String str5 = this.h;
            if (str5 != null) {
                jSONObject.put("installer", str5);
            }
            jSONObject.put("channelid", xn1.h().e().d());
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}
