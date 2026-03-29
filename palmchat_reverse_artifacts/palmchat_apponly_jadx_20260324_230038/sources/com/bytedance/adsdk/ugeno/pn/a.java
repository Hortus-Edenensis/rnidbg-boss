package com.bytedance.adsdk.ugeno.pn;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.pn.fx.nr;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.adsdk.ugeno.pn.nr.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5037a;
    private com.bytedance.adsdk.ugeno.fx.iz b;
    private com.bytedance.adsdk.ugeno.nr.fx fx;
    private com.bytedance.adsdk.ugeno.fx.nr.u iz;
    private boolean n;
    private Map<String, List<com.bytedance.adsdk.ugeno.pn.fx.nr>> nr;
    private mv pn;
    private u u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public Map<String, com.bytedance.adsdk.ugeno.pn.fx.nr> nr;
        public Map<String, List<com.bytedance.adsdk.ugeno.pn.fx.nr>> u;

        public u(Map<String, List<com.bytedance.adsdk.ugeno.pn.fx.nr>> map, Map<String, com.bytedance.adsdk.ugeno.pn.fx.nr> map2) {
            this.u = map;
            this.nr = map2;
        }
    }

    public a(com.bytedance.adsdk.ugeno.nr.fx fxVar, u uVar) {
        this.fx = fxVar;
        this.u = uVar;
        if (uVar != null) {
            this.nr = uVar.u;
        }
        if (fxVar != null && fxVar.yd() && this.iz == null) {
            this.iz = new com.bytedance.adsdk.ugeno.fx.nr.u();
        }
    }

    public void b() {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU = u("animateState");
        if (listU == null || listU.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listU) {
            if (nrVar != null) {
                nrVar.u(this);
                nrVar.u(new Object[0]);
            }
        }
    }

    public void fx() {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> value;
        u uVar = this.u;
        if (uVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.pn.fx.nr>> entry : uVar.u.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : value) {
                    if (nrVar instanceof com.bytedance.adsdk.ugeno.pn.fx.fx) {
                        nrVar.u(this);
                        nrVar.u(new Object[0]);
                    }
                }
            }
        }
    }

    public void nr() {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU = u(com.huawei.openalliance.ad.constant.x.cz);
        if (listU == null || listU.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listU) {
            if (nrVar != null) {
                nrVar.u(this);
                nrVar.u(new Object[0]);
            }
        }
    }

    public void pn() {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU = u("timer");
        if (listU == null || listU.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listU) {
            if (nrVar != null) {
                nrVar.u(this);
                nrVar.u(new Object[0]);
            }
        }
    }

    public void u(com.bytedance.adsdk.ugeno.fx.iz izVar) {
        this.b = izVar;
    }

    public void u(mv mvVar) {
        this.pn = mvVar;
    }

    public void u() {
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU = u("shake");
        if (listU == null || listU.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listU) {
            if (nrVar != null) {
                nrVar.u(this);
                nrVar.u(new Object[0]);
            }
        }
    }

    public boolean u(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.fx.nr.u uVar;
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU = u("touchStart");
        if (listU != null && !listU.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar : listU) {
                if (nrVar instanceof com.bytedance.adsdk.ugeno.pn.fx.n) {
                    nrVar.u(this);
                    nrVar.u(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU2 = u("touchEnd");
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU3 = u("tap");
        List<com.bytedance.adsdk.ugeno.pn.fx.nr> listU4 = u("slide");
        if (listU != null && !listU.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar2 : listU2) {
                if (nrVar2 instanceof com.bytedance.adsdk.ugeno.pn.fx.x) {
                    nrVar2.u(this);
                    this.f5037a = nrVar2.u(motionEvent);
                }
            }
        }
        if ((listU3 != null && !listU3.isEmpty()) || (listU4 != null && !listU4.isEmpty())) {
            if (this.f5037a && motionEvent.getAction() == 1) {
                return true;
            }
            com.bytedance.adsdk.ugeno.fx.nr.u uVar2 = this.iz;
            if (uVar2 != null) {
                if (uVar2.u(motionEvent)) {
                    return false;
                }
                this.iz.u(this.fx, motionEvent);
            }
            if (listU3 != null && !listU3.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar3 : listU3) {
                    if (nrVar3 instanceof com.bytedance.adsdk.ugeno.pn.fx.pn) {
                        ((com.bytedance.adsdk.ugeno.pn.fx.pn) nrVar3).u(this.pn);
                        nrVar3.u(this);
                        this.x = nrVar3.u(motionEvent);
                    }
                }
            }
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && this.x) {
                return true;
            }
            if (listU4 != null && !listU4.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.pn.fx.nr nrVar4 : listU4) {
                    if (nrVar4 instanceof com.bytedance.adsdk.ugeno.pn.fx.b) {
                        nrVar4.u(this);
                        this.n = nrVar4.u(motionEvent);
                    }
                }
            }
            if ((action == 1 || action == 3) && !this.x && !this.n && (uVar = this.iz) != null) {
                uVar.u(this.fx);
            }
            return this.x || this.n;
        }
        return this.f5037a;
    }

    private void u(String str, List<iz.u> list) {
        com.bytedance.adsdk.ugeno.pn.nr.u uVarU;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (iz.u uVar : list) {
            if (uVar != null && (uVarU = u.C0172u.u(this.fx, str, uVar)) != null) {
                uVarU.u();
                uVarU.nr();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.pn.fx.nr> u(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.pn.fx.nr>> map = this.nr;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.nr.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.t
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, List<iz.u> list) {
        u(str, list);
    }

    public static a u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str) {
        com.bytedance.adsdk.ugeno.pn.fx.nr nrVarU;
        if (fxVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                u uVar = new u(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (nrVarU = nr.u.u(fxVar.a().getContext(), fxVar, jSONObjectOptJSONObject, fxVar.jk())) != null) {
                        if (uVar.u.containsKey(nrVarU.x())) {
                            List<com.bytedance.adsdk.ugeno.pn.fx.nr> list = uVar.u.get(nrVarU.x());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(nrVarU);
                                uVar.u.put(nrVarU.x(), arrayList);
                            } else {
                                list.add(nrVarU);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(nrVarU);
                            uVar.u.put(nrVarU.x(), arrayList2);
                        }
                        uVar.nr.put(nrVarU.n(), nrVarU);
                    }
                }
                return new a(fxVar, uVar);
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
