package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private List<String> nr;
    private String u;

    public x(Map<String, Object> map) {
        this.u = "";
        this.nr = new ArrayList();
        try {
            this.u = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.nr = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nr.add(jSONArray.optString(i));
            }
        } catch (Exception unused) {
        }
    }

    public List<String> nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }
}
