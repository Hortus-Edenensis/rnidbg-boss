package com.amap.api.col.p0002sl;

import android.content.Context;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gn extends fy {
    public Context k;

    public gn(Context context) {
        this.k = context;
        a(5000);
        b(5000);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String c() {
        return "core";
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        map.put("User-Agent", "AMAP SDK Android core 4.3.13");
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.13", "core"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        HashMap map = new HashMap();
        map.put("key", fr.f(this.k));
        String strA = fu.a();
        String strA2 = fu.a(this.k, strA, ge.b(map));
        map.put("ts", strA);
        map.put("scode", strA2);
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return fx.a().b() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }
}
