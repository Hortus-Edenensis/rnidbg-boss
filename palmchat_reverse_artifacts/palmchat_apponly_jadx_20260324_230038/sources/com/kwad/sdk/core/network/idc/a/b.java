package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aKr = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> JF() {
        return this.aKr;
    }

    public static b eu(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }

    @NonNull
    public final Set<String> JG() {
        return this.aKr.keySet();
    }

    public final void a(b bVar) {
        this.aKr.clear();
        if (bVar != null) {
            this.aKr.putAll(bVar.JF());
        }
    }

    @NonNull
    public final List<String> et(String str) {
        Map<String, List<String>> map = this.aKr;
        if (map == null) {
            return Collections.emptyList();
        }
        List<String> list = map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.aKr.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, aa.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aKr.clear();
        this.aKr.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aKr;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            aa.putValue(jSONObject, str, aa.S(map.get(str)));
        }
        return jSONObject;
    }
}
