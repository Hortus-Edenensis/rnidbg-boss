package com.bytedance.sdk.component.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.u.b;
import com.bytedance.sdk.component.u.bg;
import com.bytedance.sdk.component.u.c;
import com.bytedance.sdk.component.u.dw;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class x implements c.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5171a;
    private final com.bytedance.sdk.component.u.u jk;
    private final boolean n;
    private final bq nr;
    private final n u;
    private final mv x;
    private final Map<String, nr> fx = new HashMap();
    private final Map<String, b.nr> b = new HashMap();
    private final List<my> pn = new ArrayList();
    private final Set<b> iz = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        String nr;
        boolean u;

        private u(boolean z, String str) {
            this.u = z;
            this.nr = str;
        }
    }

    public x(jk jkVar, com.bytedance.sdk.component.u.u uVar, dw dwVar) {
        this.jk = uVar;
        this.u = jkVar.b;
        bq bqVar = new bq(dwVar, jkVar.l, jkVar.mv);
        this.nr = bqVar;
        bqVar.u(this);
        bqVar.u(jkVar.my);
        this.x = jkVar.f5169a;
        this.n = jkVar.n;
        this.f5171a = jkVar.k;
    }

    private q nr(String str, nr nrVar) {
        return this.f5171a ? q.PRIVATE : this.nr.u(this.n, str, nrVar);
    }

    public u u(my myVar, iz izVar) throws Exception {
        nr nrVar = this.fx.get(myVar.b);
        if (nrVar != null) {
            try {
                q qVarNr = nr(izVar.nr, nrVar);
                izVar.b = qVarNr;
                if (qVarNr == null) {
                    throw new sx(-1);
                }
                if (nrVar instanceof pn) {
                    return u(myVar, (pn) nrVar, izVar);
                }
                if (nrVar instanceof fx) {
                    return u(myVar, (fx) nrVar, qVarNr);
                }
            } catch (dw.u e) {
                a.u("No remote permission config fetched, call pending: ".concat(String.valueOf(myVar)), e);
                this.pn.add(myVar);
                return new u(false, qq.u());
            }
        }
        b.nr nrVar2 = this.b.get(myVar.b);
        if (nrVar2 == null) {
            return null;
        }
        b bVarU = nrVar2.u();
        bVarU.u(myVar.b);
        q qVarNr2 = nr(izVar.nr, bVarU);
        izVar.b = qVarNr2;
        if (qVarNr2 != null) {
            return u(myVar, bVarU, izVar);
        }
        bVarU.pn();
        throw new sx(-1);
    }

    public void u(String str, pn<?, ?> pnVar) {
        pnVar.u(str);
        this.fx.put(str, pnVar);
    }

    public void u(String str, b.nr nrVar) {
        this.b.put(str, nrVar);
    }

    public boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.fx.containsKey(str)) {
            return true;
        }
        return this.b.containsKey(str);
    }

    public void u() {
        Iterator<b> it = this.iz.iterator();
        while (it.hasNext()) {
            it.next().iz();
        }
        this.iz.clear();
        this.fx.clear();
        this.b.clear();
        this.nr.nr(this);
    }

    private u u(my myVar, pn pnVar, iz izVar) throws Exception {
        return new u(true, qq.u(this.u.u(pnVar.u(u(myVar.pn, (nr) pnVar), izVar))));
    }

    private u u(final my myVar, final b bVar, iz izVar) throws Exception {
        this.iz.add(bVar);
        bVar.u(u(myVar.pn, bVar), izVar, new b.u() { // from class: com.bytedance.sdk.component.u.x.1
            @Override // com.bytedance.sdk.component.u.b.u
            public void u(Object obj) {
                if (x.this.jk == null) {
                    return;
                }
                x.this.jk.nr(qq.u(x.this.u.u(obj)), myVar);
                x.this.iz.remove(bVar);
            }

            @Override // com.bytedance.sdk.component.u.b.u
            public void u(Throwable th) {
                if (x.this.jk == null) {
                    return;
                }
                x.this.jk.nr(qq.u(th), myVar);
                x.this.iz.remove(bVar);
            }
        });
        return new u(false, qq.u());
    }

    private u u(final my myVar, fx fxVar, q qVar) throws Exception {
        new bg(myVar.b, qVar, new bg.u() { // from class: com.bytedance.sdk.component.u.x.2
        });
        return new u(false, qq.u());
    }

    private Object u(String str, nr nrVar) throws JSONException {
        return this.u.u(str, u(nrVar)[0]);
    }

    private static Type[] u(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
