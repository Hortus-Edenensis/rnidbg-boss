package com.kwad.components.core.innerEc.followuser;

import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.h;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c extends com.kwad.sdk.core.network.d {
    private Map<String, String> Sd;
    private a Se;

    public c(Map<String, String> map, a aVar) {
        this.Sd = map;
        this.Se = aVar;
        rb();
        rc();
    }

    private static String d(Map<String, String> map) {
        Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : setEntrySet) {
            arrayList.add(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i != size - 1) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    private void rb() {
        addHeader("Cookie", d(this.Sd));
    }

    private void rc() {
        putBody("toUserId", this.Se.RZ);
        putBody("fType", this.Se.Sa);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Cs();
    }
}
