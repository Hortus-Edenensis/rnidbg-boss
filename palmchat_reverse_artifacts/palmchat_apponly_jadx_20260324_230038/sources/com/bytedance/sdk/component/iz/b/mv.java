package com.bytedance.sdk.component.iz.b;

import com.bytedance.sdk.component.iz.qq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv<T> extends u {
    private byte[] b;
    private boolean fx;
    private com.bytedance.sdk.component.iz.x nr;
    private T u;

    public mv(T t, byte[] bArr, com.bytedance.sdk.component.iz.x xVar, boolean z) {
        this.u = t;
        this.nr = xVar;
        this.fx = z;
        this.b = bArr;
    }

    private Map<String, String> nr() {
        com.bytedance.sdk.component.iz.x xVar = this.nr;
        if (xVar != null) {
            return xVar.pn();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "success";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        String strMy = fxVar.my();
        Map<String, List<com.bytedance.sdk.component.iz.fx.fx>> mapX = fxVar.l().x();
        List<com.bytedance.sdk.component.iz.fx.fx> list = mapX.get(strMy);
        if (list == null) {
            nr(fxVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.iz.fx.fx> it = list.iterator();
            while (it.hasNext()) {
                nr(it.next());
            }
            list.clear();
            mapX.remove(strMy);
        }
    }

    private void nr(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        qq qqVarFx = fxVar.fx();
        int iPn = fxVar.pn();
        if (qqVarFx != null) {
            T t = this.u;
            if (iPn == 3) {
                com.bytedance.sdk.component.iz.nr nrVarMv = fxVar.mv();
                if (this.b == null && nrVarMv.isRawMemoryCache()) {
                    this.b = fxVar.l().nr(nrVarMv).u(fxVar.getRawCacheKey());
                }
                T t2 = (T) this.b;
                if (t2 == null) {
                    t2 = this.u;
                }
                t = (T) t2;
                if (!(t instanceof byte[])) {
                    qqVarFx.onFailed(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (iPn == 2 && (t instanceof byte[])) {
                try {
                    t = (T) fxVar.l().u(fxVar).u((byte[]) t);
                } catch (Throwable th) {
                    qqVarFx.onFailed(2000, "decode failed", th);
                    return;
                }
            }
            qqVarFx.onSuccess(new com.bytedance.sdk.component.iz.fx.b().u(fxVar, t, nr(), this.fx));
        }
    }
}
