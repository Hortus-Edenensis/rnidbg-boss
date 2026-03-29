package defpackage;

import com.oplus.instant.router.Instant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d47 extends Instant.FromBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f16974a = new HashMap();

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f16974a.keySet()) {
                jSONObject.put(str, this.f16974a.get(str));
            }
        } catch (JSONException e) {
            h87.d("FromBuilderImpl", e);
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder set(String str, String str2) {
        this.f16974a.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setScene(String str) {
        this.f16974a.put("m", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setTraceId(String str) {
        this.f16974a.put("t", str);
        return this;
    }
}
