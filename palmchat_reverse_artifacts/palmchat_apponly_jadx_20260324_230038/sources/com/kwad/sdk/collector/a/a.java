package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import com.zm.fda.Z2500.ZZ00Z;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends d {
    private C0596a azu;

    /* JADX INFO: renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0596a {
        private List<String> azv;

        public C0596a(List<String> list) {
            this.azv = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", this.azv);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0596a c0596a = new C0596a(list);
        this.azu = c0596a;
        putBody("targetAppInfo", c0596a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody(ZZ00Z.v, BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CA();
    }
}
