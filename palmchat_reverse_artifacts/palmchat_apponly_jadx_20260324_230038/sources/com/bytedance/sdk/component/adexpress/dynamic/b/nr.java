package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.nr.mv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mv f5080a;
    private int iz;
    private String n;
    private double pn;
    private double x;
    public Map<String, fx> u = new HashMap();
    public Map<String, fx> nr = new HashMap();
    public Map<String, fx> fx = new HashMap();
    private double b = Math.random();

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        float nr;
        float u;

        public fx() {
        }

        public fx(float f, float f2) {
            this.u = f;
            this.nr = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.u + ", height=" + this.nr + '}';
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.b.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0204nr {
        double b;
        int fx;
        int nr;
        float pn;
        float u;

        public static JSONObject u(C0204nr c0204nr) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0204nr.u);
                jSONObject.put("letterSpacing", c0204nr.nr);
                jSONObject.put("lineHeight", c0204nr.b);
                jSONObject.put("maxWidth", c0204nr.pn);
                jSONObject.put("fontWeight", c0204nr.fx);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Cloneable {
        float fx;
        boolean nr;
        float u;

        public Object clone() {
            try {
                return (u) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    public nr(double d, int i, double d2, String str, mv mvVar) {
        this.pn = d;
        this.iz = i;
        this.x = d2;
        this.n = str;
        this.f5080a = mvVar;
    }

    private fx iz(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar.jk().pn();
        float fSx = izVarPn.sx();
        int iYd = izVarPn.yd();
        double dMh = izVarPn.mh();
        int iV = izVarPn.v();
        boolean zOa = izVarPn.oa();
        boolean zEh = izVarPn.eh();
        int iW = izVarPn.w();
        C0204nr c0204nr = new C0204nr();
        c0204nr.u = fSx;
        c0204nr.nr = iYd;
        c0204nr.fx = iV;
        c0204nr.b = dMh;
        c0204nr.pn = f;
        return u(nVar.jk().nr(), c0204nr, zOa, zEh, iW, nVar);
    }

    private fx pn(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        String str = nVar.fx() + "_" + f + "_" + f2;
        if (this.fx.containsKey(str)) {
            return this.fx.get(str);
        }
        fx fxVarIz = iz(nVar, f, f2);
        this.fx.put(str, fxVarIz);
        return fxVarIz;
    }

    public fx b(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        float fMin;
        fx fxVar = new fx();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            fxVar.u = 0.0f;
            fxVar.nr = 0.0f;
            return fxVar;
        }
        if (nVar.sx()) {
            return u(nVar, f, f2);
        }
        float fN = nVar.n();
        float fA = nVar.a();
        float fK = nVar.k();
        float fMy = nVar.my();
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar.jk().pn();
        String strD = izVarPn.d();
        String strGi = izVarPn.gi();
        float fMin2 = ((TextUtils.equals(strD, "flex") || TextUtils.equals(strD, "auto")) ? f : Math.min(fN, f)) - fK;
        if (TextUtils.equals(strGi, "scale")) {
            fMin = Math.round(fMin2 / fA) + fMy;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fMy) * fA);
            }
        } else {
            fMin = (TextUtils.equals(strGi, "auto") || TextUtils.equals(strGi, "flex")) ? f2 : Math.min(fA, f2);
        }
        float f4 = fMin - fMy;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO = nVar.o();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it = listO.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> next = it.next();
            fx fxVar2 = fxVar;
            fx fxVarNr = nr(next, fMin2, f4);
            if (nr(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, fxVarNr.u);
            }
            float f5 = f3;
            fMax2 = nVar.jk().getType().equals("carousel") ? Math.max(nVar.a(), fxVarNr.nr) : fMax2 + fxVarNr.nr;
            fxVar = fxVar2;
            it = it2;
            f3 = f5;
        }
        fx fxVar3 = fxVar;
        if (TextUtils.equals(strD, "auto")) {
            if (f3 == listO.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list : listO) {
                    fx(list);
                    nr(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strGi, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                u(listO, fMin2, f4);
            }
        } else if ((TextUtils.equals(strGi, "fixed") || TextUtils.equals(strGi, "flex")) && f4 < fMax2) {
            u(listO, fMin2, f4);
        }
        fxVar3.u = Math.min(fMin2 + fK, f);
        fxVar3.nr = Math.min(f4 + fMy, f2);
        return fxVar3;
    }

    public fx fx(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        if (nVar == null) {
            return null;
        }
        fx fxVarU = u(nVar);
        if (fxVarU != null && (fxVarU.u != 0.0f || fxVarU.nr != 0.0f)) {
            return fxVarU;
        }
        fx fxVarB = b(nVar, f, f2);
        u(nVar, fxVarB);
        return fxVarB;
    }

    public fx nr(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        fx fxVar = new fx();
        if (nVar.jk().pn() == null) {
            return fxVar;
        }
        fx fxVarPn = pn(nVar, f, f2);
        float f3 = fxVarPn.u;
        float f4 = fxVarPn.nr;
        fxVar.u = Math.min(f3, f);
        fxVar.nr = Math.min(f4, f2);
        return fxVar;
    }

    public fx u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(nVar.jk().nr()) && nVar.jk().pn().f() == null) {
            return new fx(0.0f, 0.0f);
        }
        if (TextUtils.equals(nVar.jk().getType(), "creative-playable-bait")) {
            return new fx(0.0f, 0.0f);
        }
        float fN = nVar.n();
        float fA = nVar.a();
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar.jk().pn();
        String strD = izVarPn.d();
        String strGi = izVarPn.gi();
        float fMv = nVar.mv();
        float fS = nVar.s();
        float fK = nVar.k();
        float fMy = nVar.my();
        if (TextUtils.equals(strD, "fixed")) {
            f = Math.min(fN, f);
            if (TextUtils.equals(strGi, "auto")) {
                f3 = nr(nVar, f - fK, f2 - fMy).nr;
                fA = f3 + fMy;
            }
        } else if (TextUtils.equals(strD, "auto")) {
            fx fxVarNr = nr(nVar, f - fK, f2 - fMy);
            f = fxVarNr.u + fK;
            if (TextUtils.equals(strGi, "auto")) {
                f3 = fxVarNr.nr;
                fA = f3 + fMy;
            }
        } else if (!TextUtils.equals(strD, "flex")) {
            f = fN;
        } else if (TextUtils.equals(strGi, "auto")) {
            f3 = nr(nVar, f - fK, f2 - fMy).nr;
            fA = f3 + fMy;
        }
        if (TextUtils.equals(strGi, "scale")) {
            float fRound = Math.round((f - fMv) / fA) + fS;
            if (fRound > f2) {
                f = Math.round((f2 - fS) * fA) + fMv;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strGi, "fixed")) {
            f2 = Math.min(fA + fS, f2);
        } else if (!TextUtils.equals(strGi, "flex")) {
            f2 = fA;
        }
        fx fxVar = new fx();
        fxVar.u = f;
        fxVar.nr = f2;
        return fxVar;
    }

    private fx fx(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list, float f, float f2) {
        float fMax;
        b(list);
        fx fxVar = new fx();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar.jk().pn();
            if (izVarPn.lf() == 1 || izVarPn.lf() == 2) {
                arrayList.add(nVar);
            }
            if (izVarPn.lf() != 1 && izVarPn.lf() != 2) {
                arrayList2.add(nVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fx((com.bytedance.sdk.component.adexpress.dynamic.fx.n) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return fxVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(fx(it2.next(), f, f2).u));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2 = arrayList2.get(i);
            String strD = nVar2.jk().pn().d();
            float fN = nVar2.n();
            boolean zEquals = TextUtils.equals(strD, "flex");
            if (TextUtils.equals(strD, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO = nVar2.o();
                if (listO == null || listO.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it3 = listO.iterator();
                    while (it3.hasNext()) {
                        if (nr(it3.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            u uVar = new u();
            if (!zEquals) {
                fN = ((Float) arrayList3.get(i)).floatValue();
            }
            uVar.u = fN;
            uVar.nr = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            uVar.fx = fMax;
            arrayList4.add(uVar);
            i++;
        }
        u(arrayList4, f, arrayList2);
        List<u> listU = jk.u(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listU.get(i2).u;
            if (((Float) arrayList3.get(i2)).floatValue() != listU.get(i2).u) {
                b(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!nr(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar3 = arrayList2.get(i4);
            fx fxVarFx = fx(nVar3, listU.get(i4).u, f2);
            if (!nr(nVar3)) {
                fMax = Math.max(fMax, fxVarFx.nr);
            }
            arrayList5.add(fxVarFx);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((fx) it5.next()).nr));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar4 = arrayList2.get(i5);
                if (nr(nVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    b(nVar4);
                    fx(nVar4, listU.get(i5).u, fMax);
                }
            }
        }
        fxVar.u = f3;
        fxVar.nr = fMax;
        return fxVar;
    }

    private boolean nr(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list) {
        boolean z;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().jk().pn().d(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar : list) {
                if (TextUtils.equals(nVar.jk().pn().d(), "auto") && (listO = nVar.o()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list2 : listO) {
                        i++;
                        if (!nr(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private String pn(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        return nVar.fx();
    }

    private fx nr(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list, float f, float f2) {
        fx fxVarU = u(list);
        if (fxVarU != null && (fxVarU.u != 0.0f || fxVarU.nr != 0.0f)) {
            return fxVarU;
        }
        fx fxVarFx = fx(list, f, f2);
        u(list, fxVarFx);
        return fxVarFx;
    }

    private boolean nr(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        if (nVar == null) {
            return false;
        }
        if (TextUtils.equals(nVar.jk().pn().gi(), "flex")) {
            return true;
        }
        return fx(nVar);
    }

    private fx u(String str, C0204nr c0204nr, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        return t.u(str, nVar.jk().getType(), C0204nr.u(c0204nr).toString(), z, z2, i, nVar, this.pn, this.iz, this.x, this.n, this.f5080a);
    }

    private void u(List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (u(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list2 : list) {
            u uVar = new u();
            boolean zU = u(list2, !z);
            uVar.u = zU ? 1.0f : nr(list2, f, f2).nr;
            uVar.nr = !zU;
            arrayList.add(uVar);
        }
        List<u> listU = jk.u(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((u) arrayList.get(i)).u != listU.get(i).u) {
                List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list3 = list.get(i);
                fx(list3);
                nr(list3, f, listU.get(i).u);
            }
        }
    }

    private void b(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        this.u.remove(pn(nVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO = nVar.o();
        if (listO == null || listO.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it = listO.iterator();
        while (it.hasNext()) {
            fx(it.next());
        }
    }

    private String b(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strFx = list.get(i).fx();
            if (i < list.size() - 1) {
                sb.append(strFx);
                sb.append("-");
            } else {
                sb.append(strFx);
            }
        }
        return sb.toString();
    }

    private boolean u(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list, boolean z) {
        boolean z2;
        for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar.jk().pn();
            String strGi = izVarPn.gi();
            if (TextUtils.equals(strGi, "flex") || (z && ((TextUtils.equals(izVarPn.d(), "flex") && TextUtils.equals(izVarPn.gi(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.fx.pn.u.get(nVar.jk().getType()).intValue() == 7) || TextUtils.equals(strGi, "flex")))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it = list.iterator();
        while (it.hasNext()) {
            if (fx(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean fx(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO;
        if (!nVar.sx() && TextUtils.equals(nVar.jk().pn().gi(), "auto") && (listO = nVar.o()) != null && listO.size() > 0) {
            if (listO.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it = listO.get(0).iterator();
                while (it.hasNext()) {
                    if (!nr(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it2 = listO.iterator();
            while (it2.hasNext()) {
                if (u(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void u(List<u> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list2) {
        float f2 = 0.0f;
        for (u uVar : list) {
            if (uVar.nr) {
                f2 += uVar.u;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).nr && list2.get(i2).c()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    u uVar2 = list.get(i3);
                    if (uVar2.nr && list2.get(i3).c()) {
                        uVar2.u -= fCeil;
                    }
                }
            }
        }
    }

    private void fx(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.nr.remove(b(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public void u() {
        this.fx.clear();
        this.u.clear();
        this.nr.clear();
    }

    public fx u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        return this.u.get(pn(nVar));
    }

    public fx u(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list) {
        return this.nr.get(b(list));
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, fx fxVar) {
        this.u.put(pn(nVar), fxVar);
    }

    private void u(List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list, fx fxVar) {
        this.nr.put(b(list), fxVar);
    }
}
