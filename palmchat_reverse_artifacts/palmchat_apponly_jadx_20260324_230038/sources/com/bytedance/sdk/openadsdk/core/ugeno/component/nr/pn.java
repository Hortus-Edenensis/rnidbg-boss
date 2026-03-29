package com.bytedance.sdk.openadsdk.core.ugeno.component.nr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.fx.a;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.jk;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.nr.u;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends RecyclerView.u<RecyclerView.q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jk f5381a;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b b;
    private Context fx;
    private Object iz;
    private sx jk;
    private boolean n = true;
    private Map<Integer, a.u> nr;
    private fx pn;
    private bq t;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> u;
    private b x;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void u(RecyclerView.q qVar, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class nr extends RecyclerView.q {
        public nr(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn$pn, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0294pn extends RecyclerView.q implements u {
        com.bytedance.adsdk.ugeno.nr.fx o;
        k sx;

        public C0294pn(View view) {
            super(view);
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public void L_() {
            if (pn.this.b != null) {
                pn.this.b.nr(this.o);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public void M_() {
            if (pn.this.b != null) {
                pn.this.b.u(this.o);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn.u
        public View fx() {
            return this.o.a();
        }

        public com.bytedance.adsdk.ugeno.nr.fx gi() {
            return this.o;
        }

        public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
            this.o = fxVar;
        }

        public void u(k kVar) {
            this.sx = kVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void L_();

        void M_();

        View fx();
    }

    public pn(Context context) {
        this.fx = context;
    }

    public void u(Map<Integer, a.u> map) {
        this.nr = map;
    }

    public void u(List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> list) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.addAll(list);
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b bVar) {
        this.b = bVar;
    }

    public void u(jk jkVar) {
        this.f5381a = jkVar;
    }

    public void u(sx sxVar) {
        this.jk = sxVar;
    }

    public void u(bq bqVar) {
        this.t = bqVar;
    }

    public void u(fx fxVar) {
        this.pn = fxVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public RecyclerView.q u(ViewGroup viewGroup, int i) {
        a.u uVar = this.nr.get(Integer.valueOf(i));
        k kVar = new k(this.fx);
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(uVar);
        kVar.u(fxVarU);
        if (fxVarU != null) {
            fxVarU.u(new ViewGroup.LayoutParams(fxVarU.wq(), fxVarU.pb()));
            C0294pn c0294pn = new C0294pn(fxVarU.a());
            c0294pn.u((com.bytedance.adsdk.ugeno.nr.fx) fxVarU);
            c0294pn.u(kVar);
            return c0294pn;
        }
        return new nr(new View(this.fx));
    }

    public void u(b bVar) {
        this.x = bVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public int u(int i) {
        return this.u.get(i).nr();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void u(RecyclerView.q qVar, int i, List<Object> list) {
        b bVar;
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null && this.iz != null && TextUtils.equals(obj.toString(), this.iz.toString()) && (bVar = this.x) != null) {
                    bVar.u(qVar, i);
                }
            }
            return;
        }
        u(qVar, i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void u(RecyclerView.q qVar, int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx fxVar;
        com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b bVar;
        if (qVar == null || (fxVar = this.u.get(i)) == null || !(qVar instanceof C0294pn)) {
            return;
        }
        JSONObject jSONObjectU = fxVar.u();
        C0294pn c0294pn = (C0294pn) qVar;
        c0294pn.o.u(new ViewGroup.LayoutParams(c0294pn.o.wq(), c0294pn.o.pb()));
        u(jSONObjectU, c0294pn.gi());
        u(this.fx, jSONObjectU, c0294pn.gi());
        if (i == 0 && (bVar = this.b) != null && this.n) {
            this.n = false;
            bVar.u(c0294pn.o);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public int u() {
        return this.u.size();
    }

    public void u(Object obj) {
        this.iz = obj;
    }

    public void u(JSONObject jSONObject, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
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
                u(jSONObject, it.next());
            }
            return;
        }
        fxVar.u(jSONObject);
    }

    public void u(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        if (fxVar instanceof com.bytedance.adsdk.ugeno.nr.u) {
            fxVar.u(this.f5381a);
            fxVar.u(this.jk);
            fxVar.nr(true);
            fxVar.nr();
            List<com.bytedance.adsdk.ugeno.nr.fx<View>> listX = ((com.bytedance.adsdk.ugeno.nr.u) fxVar).x();
            if (listX == null || listX.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.nr.fx<View>> it = listX.iterator();
            while (it.hasNext()) {
                u(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectQq = fxVar.qq();
        Iterator<String> itKeys = jSONObjectQq.keys();
        com.bytedance.adsdk.ugeno.nr.u uVarRh = fxVar.rh();
        u.C0171u c0171uN = uVarRh != null ? uVarRh.n() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strU = com.bytedance.adsdk.ugeno.b.nr.u(jSONObjectQq.optString(next), jSONObject);
            fxVar.u(next, strU);
            fxVar.u(this.f5381a);
            fxVar.u(this.jk);
            if (c0171uN != null) {
                c0171uN.u(context, next, strU);
            }
        }
        fxVar.nr(true);
        fxVar.nr();
    }
}
