package com.bytedance.sdk.component.u;

import android.net.Uri;
import com.bytedance.sdk.component.u.c;
import com.bytedance.sdk.component.u.dw;
import com.bytedance.sdk.component.u.t;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class bq {
    private final dw b;
    private final c fx = o.u;
    private final Set<String> nr;
    private t.nr pn;
    private final Set<String> u;

    public bq(dw dwVar, Set<String> set, Set<String> set2) {
        this.b = dwVar;
        if (set == null || set.isEmpty()) {
            this.u = new LinkedHashSet();
        } else {
            this.u = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.nr = new LinkedHashSet();
        } else {
            this.nr = new LinkedHashSet(set2);
        }
    }

    public final synchronized q nr(String str, nr nrVar) {
        return u(str, nrVar, false);
    }

    public final synchronized q u(boolean z, String str, nr nrVar) throws dw.u {
        t.nr nrVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        q qVar = this.nr.contains(nrVar.u()) ? q.PUBLIC : null;
        for (String str2 : this.u) {
            if (uri.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                qVar = q.PRIVATE;
                break;
            }
        }
        if (qVar == null && (nrVar2 = this.pn) != null && nrVar2.u(str)) {
            if (this.pn.u(str, nrVar.u())) {
                return null;
            }
            qVar = q.PRIVATE;
        }
        q qVarU = z ? u(str, nrVar) : nr(str, nrVar);
        return qVarU != null ? qVarU : qVar;
    }

    public void nr(c.u uVar) {
        c cVar = this.fx;
        if (cVar != null) {
            cVar.nr(uVar);
        }
    }

    public final synchronized q u(String str, nr nrVar) throws dw.u {
        return u(str, nrVar, true);
    }

    public void u(t.nr nrVar) {
        this.pn = nrVar;
    }

    public void u(c.u uVar) {
        c cVar = this.fx;
        if (cVar != null) {
            cVar.u(uVar);
        }
    }

    private q u(String str, nr nrVar, boolean z) {
        dw dwVar;
        if (!z || (dwVar = this.b) == null) {
            return null;
        }
        dw.fx fxVarU = dwVar.u(str, this.u);
        if (fxVarU.fx.contains(nrVar.u())) {
            return null;
        }
        if (fxVarU.nr.contains(nrVar.u())) {
            return q.PRIVATE;
        }
        if (fxVarU.u.compareTo(nrVar.nr()) < 0) {
            return null;
        }
        return fxVarU.u;
    }
}
