package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g87 extends yv6 {
    public g87(i17 i17Var) {
        super(i17Var);
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.f)) {
            map.putAll(vv6.c(this.f));
        }
        Map<String, String> map2 = this.c;
        if (map2 != null && map2.size() > 0 && this.f22290a.containsKey("f")) {
            try {
                JSONObject jSONObject = new JSONObject(this.f22290a.get("f"));
                for (String str : this.c.keySet()) {
                    jSONObject.put(str, this.c.get(str));
                }
                this.f22290a.put("f", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        map.putAll(this.f22290a);
        if (!map.containsKey("scheme")) {
            map.put("scheme", "oaps");
        }
        if (!map.containsKey("host")) {
            map.put("host", "instant");
        }
        return map;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        u97.t(context.getApplicationContext(), vv6.b(a()), this.f22290a, this.b, this.c, this.d, this.e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        u97.j(context, vv6.b(a()), this.f22290a, this.b, this.c, this.d, this.e);
    }
}
