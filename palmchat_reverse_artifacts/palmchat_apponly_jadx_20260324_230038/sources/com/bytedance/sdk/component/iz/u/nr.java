package com.bytedance.sdk.component.iz.u;

import com.bytedance.sdk.component.iz.l;
import com.bytedance.sdk.component.iz.sx;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static sx u() {
        return new sx() { // from class: com.bytedance.sdk.component.iz.u.nr.1
            private WeakHashMap<String, String> u = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.iz.sx
            public String nr(l lVar) {
                return u(lVar.getUrl());
            }

            @Override // com.bytedance.sdk.component.iz.sx
            public String u(l lVar) {
                return u(lVar.getUrl() + "#width=" + lVar.getWidth() + "#height=" + lVar.getHeight() + "#scaletype=" + lVar.getScaleType() + "#bitmapConfig=" + lVar.getBitmapConfig());
            }

            private String u(String str) {
                String str2 = this.u.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strU = com.bytedance.sdk.component.iz.fx.fx.fx.u(str);
                this.u.put(str, strU);
                return strU;
            }
        };
    }
}
