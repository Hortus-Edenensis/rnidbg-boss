package com.bytedance.sdk.openadsdk.core.gi;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.bf;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.component.a.fx.nr {
    private Context fx;
    String u = "sp_multi_ttadnet_config";
    com.bytedance.sdk.component.b.nr.fx nr = bf.u("sp_multi_ttadnet_config");

    public b(Context context) {
        this.fx = context;
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public int b() {
        return d.fx;
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public String fx() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public Context getContext() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public String[] iz() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public String nr() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public String pn() {
        return sx.fx();
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public Address u(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public int u() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public String u(Context context, String str, String str2) {
        return this.nr.get(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.fx.nr
    public void u(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.nr.put(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.nr.put(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.nr.put(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.nr.put(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.nr.put(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
