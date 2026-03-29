package com.bytedance.sdk.component.nr.u.u.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.fx.nr.b;
import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.c;
import com.bytedance.sdk.component.fx.nr.dw;
import com.bytedance.sdk.component.fx.nr.gi;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.nr.u.k;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends l {
    q l;
    com.bytedance.sdk.component.nr.u.b mv;

    public iz(l.u uVar) {
        super(uVar);
        u(uVar);
        this.mv = new x(this.l);
    }

    private boolean fx(k kVar) {
        return (kVar == null || kVar.iz != k.u.STRING_TYPE || TextUtils.isEmpty(kVar.b)) ? false : true;
    }

    private boolean nr(k kVar) {
        byte[] bArr;
        return kVar != null && kVar.iz == k.u.BYTE_ARRAY_TYPE && (bArr = kVar.pn) != null && bArr.length > 0;
    }

    private void u(l.u uVar) {
        q.u uVar2 = new q.u();
        uVar2.qq = (int) uVar.fx;
        uVar2.rh = uVar.b;
        uVar2.kj = (int) uVar.pn;
        uVar2.ja = uVar.iz;
        uVar2.z = (int) uVar.x;
        uVar2.bf = uVar.n;
        uVar2.h = uVar.jk;
        uVar2.d = uVar.t;
        uVar2.u(new fx(uVar.nr));
        List<com.bytedance.sdk.component.nr.u.a> list = uVar.u;
        if (list != null && !list.isEmpty()) {
            for (final com.bytedance.sdk.component.nr.u.a aVar : list) {
                uVar2.u(new bq() { // from class: com.bytedance.sdk.component.nr.u.u.u.iz.1
                    @Override // com.bytedance.sdk.component.fx.nr.bq
                    public h u(bq.u uVar3) throws IOException {
                        return ((a) aVar.u(new pn(uVar3))).u;
                    }
                });
            }
        }
        this.l = uVar2.u();
    }

    @Override // com.bytedance.sdk.component.nr.u.l
    public com.bytedance.sdk.component.nr.u.b u() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.component.nr.u.l
    public com.bytedance.sdk.component.nr.u.nr u(s sVar) {
        if (sVar == null) {
            return null;
        }
        z.u uVar = new z.u();
        uVar.u(sVar.u());
        if (sVar.nr() != null) {
            uVar.u(sVar.nr().u());
        }
        if (sVar.iz() != null) {
            if (fx(sVar.iz())) {
                uVar.u(sVar.fx(), gi.u(dw.u(sVar.iz().fx.toString()), sVar.iz().b));
            } else if (u(sVar.iz())) {
                uVar.u(sVar.fx(), new c.u().u(c.pn).u(sVar.iz().nr(), sVar.iz().u(), gi.u(dw.u("multipart/form-data"), sVar.iz().pn)).u());
            } else if (nr(sVar.iz())) {
                uVar.u(sVar.fx(), gi.u(dw.u(sVar.iz().fx.toString()), sVar.iz().pn));
            }
        }
        if (sVar.pn() != null && sVar.pn().u) {
            uVar.u(new b.u().u().fx());
        }
        if (sVar.b() != null && sVar.b().size() > 0) {
            for (Map.Entry<String, List<String>> entry : sVar.b().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    uVar.u(entry.getKey(), it.next());
                }
            }
        }
        return new b(this.l.u(uVar.u()));
    }

    private boolean u(k kVar) {
        byte[] bArr;
        return kVar != null && kVar.iz == k.u.FILE_TYPE && (bArr = kVar.pn) != null && bArr.length > 0;
    }
}
