package com.bytedance.sdk.component.iz.b;

import com.bytedance.sdk.component.iz.qq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends u {
    private String fx;
    private int nr;
    private Throwable u;

    public n(int i, String str, Throwable th) {
        this.nr = i;
        this.fx = str;
        this.u = th;
    }

    private void nr(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        qq qqVarFx = fxVar.fx();
        if (qqVarFx != null) {
            qqVarFx.onFailed(this.nr, this.fx, this.u);
        }
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "failed";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        fxVar.u(new com.bytedance.sdk.component.iz.fx.u(this.nr, this.fx, this.u));
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
}
