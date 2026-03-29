package com.bytedance.adsdk.ugeno.fx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.adsdk.ugeno.nr.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.pn.mv f5029a;
    private jk b;
    private n bg;
    private iz bq;
    private float c;
    private float dw;
    private com.bytedance.adsdk.ugeno.nr.fx<View> fx;
    private c iz;
    private a jk;
    private s l;
    private JSONObject mv;
    private com.bytedance.adsdk.ugeno.pn.u.u my;
    private bg n;
    private JSONObject nr;
    private boolean o;
    private sx pn;
    private t q;
    private List<String> sx;
    private String t;
    private Context u;
    private bq x;
    private boolean s = true;
    private boolean k = false;

    public k(Context context) {
        this.u = context;
    }

    private void fx(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        try {
            if (!fxVar.h() || fxVar.d() == null || fxVar.d().iz() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", fxVar.d().iz());
            this.nr.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public com.bytedance.adsdk.ugeno.nr.fx<View> nr(a.u uVar, com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        List<a.u> listFx;
        u.C0171u c0171uN = null;
        if (!a.b(uVar)) {
            return null;
        }
        n nVar = this.bg;
        if (nVar != null) {
            nVar.nr(uVar);
        }
        String strFx = uVar.fx();
        nr nrVarU = b.u(strFx);
        if (nrVarU == null) {
            this.o = true;
            if (this.sx == null) {
                this.sx = new ArrayList();
            }
            this.sx.add(strFx);
            return null;
        }
        com.bytedance.adsdk.ugeno.nr.fx fxVarU = nrVarU.u(this.u);
        if (fxVarU == null) {
            return null;
        }
        fxVarU.x(com.bytedance.adsdk.ugeno.b.nr.u(uVar.u(), this.nr));
        fxVarU.n(strFx);
        fxVarU.fx(uVar.b());
        fxVarU.u(uVar);
        fxVarU.u(this.l);
        if (fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) {
            com.bytedance.adsdk.ugeno.nr.u uVar2 = (com.bytedance.adsdk.ugeno.nr.u) fxVar;
            fxVarU.u(uVar2);
            c0171uN = uVar2.n();
        }
        Iterator<String> itKeys = uVar.b().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strU = com.bytedance.adsdk.ugeno.b.nr.u(uVar.b().optString(next), this.nr);
            fxVarU.u(next, strU);
            if (c0171uN != null) {
                c0171uN.u(this.u, next, strU);
            }
        }
        if (fxVarU instanceof com.bytedance.adsdk.ugeno.nr.u) {
            List<a.u> listPn = uVar.pn();
            if (listPn == null || listPn.size() <= 0) {
                if (TextUtils.equals(fxVarU.bf(), "RecyclerLayout") && (listFx = this.jk.fx()) != null && listFx.size() > 0) {
                    Iterator<a.u> it = listFx.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarNr = nr(it.next(), fxVarU);
                        if (fxVarNr != null && fxVarNr.m()) {
                            ((com.bytedance.adsdk.ugeno.nr.u) fxVarU).u(fxVarNr);
                        }
                    }
                }
                return fxVarU;
            }
            if (TextUtils.equals(fxVarU.bf(), "Swiper") && listPn.size() != 1) {
                com.bytedance.sdk.component.utils.k.nr("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<a.u> it2 = listPn.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.nr.fx<View> fxVarNr2 = nr(it2.next(), fxVarU);
                if (fxVarNr2 != null && fxVarNr2.m()) {
                    ((com.bytedance.adsdk.ugeno.nr.u) fxVarU).u(fxVarNr2);
                }
            }
        }
        if (c0171uN != null) {
            fxVarU.u(c0171uN.u());
        }
        this.fx = fxVarU;
        return fxVarU;
    }

    public void u(String str, s sVar) {
        this.l = sVar;
        this.t = str;
        if (sVar != null) {
            this.nr = sVar.u();
        }
    }

    public com.bytedance.adsdk.ugeno.nr.fx<View> u(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.nr = jSONObject2;
        c cVar = this.iz;
        if (cVar != null) {
            cVar.u();
        }
        a aVar = new a(jSONObject, jSONObject2, jSONObject3);
        this.jk = aVar;
        aVar.u(this.dw, this.c);
        this.my = new com.bytedance.adsdk.ugeno.pn.u.u();
        sx sxVar = this.pn;
        if (sxVar instanceof com.bytedance.adsdk.ugeno.fx.u.nr) {
            ((com.bytedance.adsdk.ugeno.fx.u.nr) sxVar).u(this.jk.nr());
        }
        this.fx = u(this.jk.u(), (com.bytedance.adsdk.ugeno.nr.fx<View>) null);
        t tVar = this.q;
        if (tVar != null) {
            tVar.nr();
            if (this.q.fx()) {
                this.q.u(this.n);
            }
            this.q.u(this.iz);
        }
        c cVar2 = this.iz;
        if (cVar2 != null) {
            cVar2.nr();
            this.fx.u(this.iz);
            this.iz.fx();
        }
        nr(this.fx);
        if (this.iz != null) {
            dw dwVar = new dw();
            dwVar.u(0);
            dwVar.u(this.fx);
            this.iz.u(dwVar);
        }
        return this.fx;
    }

    public com.bytedance.adsdk.ugeno.nr.fx<View> u(a.u uVar, com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        List<a.u> listFx;
        u.C0171u c0171uN = null;
        if (!a.b(uVar)) {
            return null;
        }
        n nVar = this.bg;
        if (nVar != null) {
            nVar.u(uVar);
        }
        String strFx = uVar.fx();
        nr nrVarU = b.u(strFx);
        nr nrVar = nrVarU;
        if (nrVarU == null) {
            this.o = true;
            if (this.sx == null) {
                this.sx = new ArrayList();
            }
            this.sx.add(strFx);
            strFx = "View";
            uVar.u("View");
            nr nrVarU2 = b.u("View");
            nrVar = nrVarU2;
            if (nrVarU2 == null) {
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.nr.fx fxVarU = nrVar.u(this.u);
        if (fxVarU == null) {
            return null;
        }
        JSONObject jSONObjectB = uVar.b();
        fxVarU.x(com.bytedance.adsdk.ugeno.b.nr.u(uVar.u(), this.nr));
        fxVarU.n(strFx);
        fxVarU.fx(jSONObjectB);
        fxVarU.u(uVar);
        fxVarU.nr(this.nr);
        a aVar = this.jk;
        if (aVar == null) {
            fxVarU.fx(true);
        } else {
            fxVarU.fx(aVar.b());
        }
        fxVarU.u(this.l);
        fxVarU.u(this.my);
        Iterator<String> itKeys = jSONObjectB.keys();
        if (fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) {
            com.bytedance.adsdk.ugeno.nr.u uVar2 = (com.bytedance.adsdk.ugeno.nr.u) fxVar;
            c0171uN = uVar2.n();
            fxVarU.u(uVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectB.optString(next), this.nr);
            fxVarU.u(next, strU);
            t tVar = this.q;
            if (tVar != null) {
                tVar.u(next, strU);
            }
            if (c0171uN != null) {
                c0171uN.u(this.u, next, strU);
            }
        }
        if (c0171uN != null) {
            fxVarU.u(c0171uN.u());
        }
        if (fxVarU instanceof com.bytedance.adsdk.ugeno.nr.u) {
            List<a.u> listPn = uVar.pn();
            if (listPn != null && listPn.size() > 0) {
                if (TextUtils.equals(fxVarU.bf(), "Swiper") && listPn.size() != 1) {
                    com.bytedance.sdk.component.utils.k.nr("UGTemplateEngine", "Swiper must be only one widget");
                }
                try {
                    Collections.sort(listPn, new Comparator<a.u>() { // from class: com.bytedance.adsdk.ugeno.fx.k.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                        public int compare(a.u uVar3, a.u uVar4) {
                            return uVar3.b().optInt("order", 0) - uVar4.b().optInt("order", 0);
                        }
                    });
                } catch (Throwable unused) {
                }
                Iterator<a.u> it = listPn.iterator();
                while (it.hasNext()) {
                    com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU2 = u(it.next(), (com.bytedance.adsdk.ugeno.nr.fx<View>) fxVarU);
                    if (fxVarU2 != null && !fxVarU2.mh()) {
                        ((com.bytedance.adsdk.ugeno.nr.u) fxVarU).u(fxVarU2, fxVarU2.gi());
                    }
                }
            } else {
                if (TextUtils.equals(fxVarU.bf(), "RecyclerLayout") && (listFx = this.jk.fx()) != null && listFx.size() > 0) {
                    Iterator<a.u> it2 = listFx.iterator();
                    while (it2.hasNext()) {
                        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU3 = u(it2.next(), (com.bytedance.adsdk.ugeno.nr.fx<View>) fxVarU);
                        if (fxVarU3 != null && fxVarU3.m()) {
                            ((com.bytedance.adsdk.ugeno.nr.u) fxVarU).u(fxVarU3);
                        }
                    }
                }
                return fxVarU;
            }
        }
        this.fx = fxVarU;
        return fxVarU;
    }

    public void nr(JSONObject jSONObject) {
        c cVar = this.iz;
        if (cVar != null) {
            cVar.fx();
        }
        this.nr = jSONObject;
        u(this.fx, jSONObject);
        nr(this.fx);
        if (this.iz != null) {
            dw dwVar = new dw();
            dwVar.u(0);
            dwVar.u(this.fx);
            this.iz.u(dwVar);
        }
    }

    private void nr(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
        List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX;
        if (fxVar == null) {
            return;
        }
        JSONObject jSONObjectQq = fxVar.qq();
        Iterator<String> itKeys = jSONObjectQq.keys();
        com.bytedance.adsdk.ugeno.nr.u uVarRh = fxVar.rh();
        u.C0171u c0171uN = uVarRh != null ? uVarRh.n() : null;
        fx(fxVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectQq.optString(next), this.nr);
            fxVar.u(next, strU);
            if (c0171uN != null) {
                c0171uN.u(this.u, next, strU);
            }
        }
        fxVar.u(this.b);
        fxVar.u(this.pn);
        fxVar.u(this.x);
        t tVar = this.q;
        if (tVar != null) {
            fxVar.u(tVar);
        }
        iz izVar = this.bq;
        if (izVar != null) {
            fxVar.u(izVar);
        }
        com.bytedance.adsdk.ugeno.pn.mv mvVar = this.f5029a;
        if (mvVar != null) {
            fxVar.u(mvVar);
        }
        if ((fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) && (listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x()) != null && listX.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
            while (it.hasNext()) {
                nr(it.next());
            }
        }
        if (c0171uN != null) {
            fxVar.u(c0171uN.u());
        }
        fxVar.nr();
    }

    public List<String> nr() {
        return this.sx;
    }

    public com.bytedance.adsdk.ugeno.nr.fx<View> u(JSONObject jSONObject) {
        c cVar = this.iz;
        if (cVar != null) {
            cVar.u();
        }
        a aVar = new a(jSONObject, this.nr);
        this.jk = aVar;
        sx sxVar = this.pn;
        if (sxVar instanceof com.bytedance.adsdk.ugeno.fx.u.nr) {
            ((com.bytedance.adsdk.ugeno.fx.u.nr) sxVar).u(aVar.nr());
        }
        this.fx = nr(this.jk.u(), null);
        c cVar2 = this.iz;
        if (cVar2 != null) {
            cVar2.nr();
            this.fx.u(this.iz);
        }
        return this.fx;
    }

    public com.bytedance.adsdk.ugeno.nr.fx<View> u(a.u uVar) {
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarNr = nr(uVar, null);
        this.fx = fxVarNr;
        return fxVarNr;
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX;
        if (fxVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.nr.u uVarRh = fxVar.rh();
        if (uVarRh != null) {
            u.C0171u c0171uN = uVarRh.n();
            Iterator<String> itKeys = fxVar.qq().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strU = com.bytedance.adsdk.ugeno.b.nr.u(fxVar.qq().optString(next), this.nr);
                fxVar.u(next, strU);
                c0171uN.u(this.u, next, strU);
            }
            fxVar.u(c0171uN.u());
        }
        if (!(fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) || (listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x()) == null || listX.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
        while (it.hasNext()) {
            u(it.next());
        }
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        if (fxVar == null) {
            return;
        }
        if (fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) {
            fxVar.u(jSONObject);
            List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x();
            if (listX == null || listX.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
            while (it.hasNext()) {
                u(it.next(), jSONObject);
            }
            return;
        }
        fxVar.u(jSONObject);
    }

    public void u(jk jkVar) {
        this.b = jkVar;
    }

    public void u(sx sxVar) {
        com.bytedance.adsdk.ugeno.fx.u.u uVarPn = com.bytedance.adsdk.ugeno.b.u().pn();
        if (uVarPn == null) {
            this.pn = sxVar;
            return;
        }
        com.bytedance.adsdk.ugeno.fx.u.nr nrVarU = uVarPn.u(sxVar);
        if (nrVarU == null) {
            this.pn = sxVar;
            return;
        }
        nrVarU.u(this.mv);
        nrVarU.u(this.s);
        nrVarU.nr(this.k);
        a aVar = this.jk;
        if (aVar != null) {
            nrVarU.u(aVar.nr());
        }
        this.pn = nrVarU;
    }

    public void u(bq bqVar) {
        this.x = bqVar;
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX;
        if (fxVar == null) {
            return;
        }
        fxVar.u(str, objArr);
        if (!(fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) || (listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
        while (it.hasNext()) {
            u(it.next(), str, objArr);
        }
    }

    public boolean u() {
        return this.o;
    }

    public void u(n nVar) {
        this.bg = nVar;
    }
}
