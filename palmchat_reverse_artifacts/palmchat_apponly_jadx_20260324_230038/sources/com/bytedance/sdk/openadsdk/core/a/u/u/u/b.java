package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.wq;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    public b(bc bcVar, Context context, String str, com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVar, String str2) {
        this.u = bcVar;
        this.nr = context;
        this.fx = str;
        this.b = fxVar;
        this.pn = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u.u
    public com.bytedance.sdk.openadsdk.core.l.u.nr b(final Map<String, Object> map) {
        final int iFx = u.fx(map);
        String str = this.fx;
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(str, str, jp.dw(this.u), iFx);
        map.put("action_type_button", 2);
        bc bcVar = this.u;
        if (bcVar != null && !TextUtils.isEmpty(bcVar.lk())) {
            map.put("id", Long.valueOf(Double.valueOf(this.u.lk()).longValue()));
        }
        if (!fx(iFx)) {
            u(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.l.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.l.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.b.1
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(0, iFx);
                b bVar = b.this;
                bVar.b.u(bVar.nr(iFx));
                map.remove("downloadButtonClickListener");
                if (b.this.u((com.bytedance.sdk.openadsdk.core.kj.b) null, (com.bytedance.sdk.openadsdk.core.l.u.nr) null, map)) {
                    return;
                }
                b.this.u(map, true);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }
        };
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(map, nrVar);
        return nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u.u
    public boolean fx(int i) {
        Function<SparseArray<Object>, Object> function = this.f5204a;
        return function != null && com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(function, i) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u.u
    public void nr(boolean z, int i) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(z, com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.u, this.iz), i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u.u
    public com.bytedance.sdk.openadsdk.core.l.u.pn u(Map<String, Object> map, final wq<String, Object> wqVar) {
        final int iFx = u.fx(wqVar);
        return new com.bytedance.sdk.openadsdk.core.l.u.pn() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.b.2
            @Override // com.bytedance.sdk.openadsdk.core.l.u.pn
            public void onItemClick() {
                if (b.this.x || b.this.u.hl()) {
                    com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.nr(1, iFx);
                    wqVar.remove("itemClickListener");
                    b.this.f5204a.apply(com.bytedance.sdk.openadsdk.my.b.u().u(17).u(Void.class).u(0, wqVar).nr());
                    return;
                }
                b bVar = b.this;
                bc bcVar = bVar.u;
                Context context = bVar.nr;
                String str = bVar.fx;
                com.bytedance.sdk.openadsdk.core.a.u.u.nr.u uVar = new com.bytedance.sdk.openadsdk.core.a.u.u.nr.u(bcVar, context, str, jp.nr(str));
                uVar.fx(true);
                uVar.u((Map<String, Object>) new HashMap());
            }
        };
    }
}
