package defpackage;

import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class je5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet<IpPort> f18393a;
    public LinkedHashSet<IpPort> b;
    public LinkedHashSet<IpPort> c;
    public LinkedHashSet<IpPort> d;
    public LinkedHashSet<IpPort> e;
    public JSONObject f;
    public transient IpPort g;
    public boolean h;

    public je5(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f18393a = b(jSONObject, "ips");
            this.b = b(jSONObject, "ssl_ips");
            this.c = b(jSONObject, "http_report");
            this.d = b(jSONObject, "https_report");
            this.e = b(jSONObject, "sis_ips");
            this.h = jSONObject.optBoolean("data_report");
            this.f = jSONObject.optJSONObject("tcp_report");
            k63.a("sis", "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    public boolean a() {
        LinkedHashSet<IpPort> linkedHashSet;
        LinkedHashSet<IpPort> linkedHashSet2 = this.f18393a;
        return (linkedHashSet2 == null || linkedHashSet2.isEmpty()) && ((linkedHashSet = this.b) == null || linkedHashSet.isEmpty());
    }

    public final LinkedHashSet<IpPort> b(JSONObject jSONObject, String str) {
        LinkedHashSet<IpPort> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    IpPort ipPortFromString = IpPort.fromString(jSONArrayOptJSONArray.optString(i, null));
                    if (ipPortFromString != null && ipPortFromString.isLegal()) {
                        linkedHashSet.add(ipPortFromString);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }
}
