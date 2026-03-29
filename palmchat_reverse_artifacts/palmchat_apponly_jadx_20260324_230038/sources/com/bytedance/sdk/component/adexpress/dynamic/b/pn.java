package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.b.nr;
import com.bytedance.sdk.component.adexpress.nr.mv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private u b;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.n fx;
    protected nr nr;
    public com.bytedance.sdk.component.adexpress.dynamic.fx.nr u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        float fx;
        float nr;
        float u;
    }

    public pn(double d, int i, double d2, String str, mv mvVar) {
        this.nr = new nr(d, i, d2, str, mvVar);
    }

    public void u(u uVar) {
        this.b = uVar;
    }

    public void u() {
        this.nr.u();
    }

    public void u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar, float f, float f2) {
        if (nVar != null) {
            this.fx = nVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2 = this.fx;
        float fN = nVar2.n();
        float fA = nVar2.a();
        float f3 = TextUtils.equals(nVar2.jk().pn().gi(), "fixed") ? fA : 65536.0f;
        this.nr.u();
        this.nr.fx(nVar2, fN, f3);
        nr.fx fxVarU = this.nr.u(nVar2);
        com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar = new com.bytedance.sdk.component.adexpress.dynamic.fx.nr();
        nrVar.u = f;
        nrVar.nr = f2;
        if (fxVarU != null) {
            fN = fxVarU.u;
        }
        nrVar.fx = fN;
        if (fxVarU != null) {
            fA = fxVarU.nr;
        }
        nrVar.b = fA;
        nrVar.pn = "root";
        nrVar.f5086a = 1280.0f;
        nrVar.iz = nVar2;
        nVar2.fx(f);
        nrVar.iz.b(nrVar.nr);
        nrVar.iz.pn(nrVar.fx);
        nrVar.iz.iz(nrVar.b);
        com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVarU = u(nrVar, 0.0f);
        this.u = nrVarU;
        u(nrVarU);
    }

    public void u(com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        nrVar.iz.jk().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.nr>> list = nrVar.x;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.fx.nr> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.nr> it = list2.iterator();
                while (it.hasNext()) {
                    u(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0320  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.component.adexpress.dynamic.fx.nr u(com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar, float f) {
        float fU;
        float fU2;
        float f2;
        float f3;
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVar;
        float fU3;
        float fU4;
        float f4;
        List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list;
        float f5;
        com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar2;
        com.bytedance.sdk.component.adexpress.dynamic.fx.a aVarU;
        float f6;
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar;
        com.bytedance.sdk.component.adexpress.dynamic.fx.a aVarU2;
        float f7;
        com.bytedance.sdk.component.adexpress.dynamic.fx.a aVar;
        nr.fx fxVarU;
        nr.fx fxVarU2;
        com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar3 = nrVar;
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2 = nrVar3.iz;
        if (nVar2 == null) {
            return nrVar3;
        }
        nVar2.dw();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> listO = nVar2.o();
        if (listO == null || listO.size() <= 0) {
            return nrVar3;
        }
        com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn = nVar2.jk().pn();
        float fO = izVarPn.o();
        float fMy = izVarPn.my();
        float fS = izVarPn.s();
        float fK = izVarPn.k();
        float fL = izVarPn.l();
        String strBc = izVarPn.bc();
        String strXw = izVarPn.xw();
        float f8 = nrVar3.u + fK;
        float f9 = nrVar3.nr + fO;
        float f10 = fL * 2.0f;
        float f11 = ((nrVar3.fx - fK) - fMy) - f10;
        float f12 = ((nrVar3.b - fO) - fS) - f10;
        com.bytedance.sdk.component.adexpress.dynamic.fx.a aVar2 = new com.bytedance.sdk.component.adexpress.dynamic.fx.a(f8, f9);
        if (nrVar3.x == null) {
            nrVar3.x = new ArrayList();
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> it = listO.iterator();
        float f13 = 0.0f;
        while (it.hasNext()) {
            nr.fx fxVarU3 = this.nr.u(it.next());
            if (fxVarU3 != null) {
                f13 += fxVarU3.nr;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f13 >= f12) {
            fU = 0.0f;
            fU2 = 0.0f;
        } else {
            if (TextUtils.equals(strXw, "center")) {
                fU = (f12 - f13) / 2.0f;
            } else if (TextUtils.equals(strXw, "flex-end")) {
                fU = f12 - f13;
            } else if (TextUtils.equals(strXw, "space-around")) {
                fU = jk.u((f12 - f13) / (listO.size() + 1));
                fU2 = fU;
            } else {
                if (TextUtils.equals(strXw, "space-between") && listO.size() > 1) {
                    fU2 = jk.u((f12 - f13) / (listO.size() - 1));
                    fU = 0.0f;
                }
                fU = 0.0f;
            }
            fU2 = 0.0f;
        }
        aVar2.nr += fU;
        float f14 = f;
        int i = 0;
        while (i < listO.size()) {
            List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list2 = listO.get(i);
            int i2 = i + 1;
            List<List<com.bytedance.sdk.component.adexpress.dynamic.fx.n>> list3 = listO;
            if (i2 >= nrVar3.x.size()) {
                int size = (i2 - nrVar3.x.size()) + 1;
                f3 = f14;
                int i3 = 0;
                while (i3 < size) {
                    nrVar3.x.add(new ArrayList());
                    i3++;
                    size = size;
                    fU2 = fU2;
                }
                f2 = fU2;
            } else {
                f2 = fU2;
                f3 = f14;
            }
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it2 = list2.iterator();
            float f15 = 0.0f;
            while (true) {
                izVar = izVarPn;
                if (!it2.hasNext()) {
                    break;
                }
                com.bytedance.sdk.component.adexpress.dynamic.fx.n next = it2.next();
                com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn2 = next.jk().pn();
                String strD = izVarPn2.d();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it3 = it2;
                int iLf = izVarPn2.lf();
                if (!TextUtils.equals(strD, "flex") && iLf != 1 && iLf != 2 && (fxVarU2 = this.nr.u(next)) != null) {
                    f15 += fxVarU2.u;
                }
                izVarPn = izVar;
                it2 = it3;
            }
            float fMax = Math.max(f11 - f15, 0.0f);
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it4 = list2.iterator();
            float f16 = 0.0f;
            while (it4.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.fx.n next2 = it4.next();
                com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn3 = next2.jk().pn();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it5 = it4;
                if (izVarPn3.lf() != 1 && izVarPn3.lf() != 2 && (fxVarU = this.nr.u(next2)) != null) {
                    f16 += fxVarU.u;
                }
                it4 = it5;
            }
            if (f16 >= f11) {
                fU3 = 0.0f;
                fU4 = 0.0f;
            } else {
                if (TextUtils.equals(strBc, "center")) {
                    fU3 = (f11 - f16) / 2.0f;
                } else if (TextUtils.equals(strBc, "flex-end")) {
                    fU3 = f11 - f16;
                } else if (TextUtils.equals(strBc, str2)) {
                    fU3 = jk.u((f11 - f16) / (list2.size() + 1));
                    fU4 = fU3;
                } else {
                    if (TextUtils.equals(strBc, str) && list2.size() > 1) {
                        fU4 = jk.u((f11 - f16) / (list2.size() - 1.0f));
                        fU3 = 0.0f;
                    }
                    fU3 = 0.0f;
                }
                fU4 = 0.0f;
            }
            aVar2.u += fU3;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it6 = list2.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.fx.n next3 = it6.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it7 = it6;
                float f17 = this.nr.u(next3) != null ? this.nr.u(next3).nr : 0.0f;
                com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn4 = next3.jk().pn();
                String str3 = str;
                fMax2 = Math.max(fMax2, (izVarPn4.lf() == 1 || izVarPn4.lf() == 2) ? 0.0f : f17);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it8 = list2.iterator();
            f14 = f3;
            while (it8.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.fx.n next4 = it8.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.n> it9 = it8;
                nr.fx fxVarU4 = this.nr.u(next4);
                String str5 = str2;
                com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVarPn5 = next4.jk().pn();
                String str6 = strBc;
                float fCj = izVarPn5.cj();
                float f18 = f14;
                float fSu = izVarPn5.su();
                float f19 = f11;
                float fTk = izVarPn5.tk();
                float f20 = fU4;
                float fWi = izVarPn5.wi();
                com.bytedance.sdk.component.adexpress.dynamic.fx.a aVar3 = aVar2;
                float f21 = fxVarU4 == null ? 0.0f : fxVarU4.u;
                if (fxVarU4 == null) {
                    list = list2;
                    f4 = 0.0f;
                } else {
                    f4 = fxVarU4.nr;
                    list = list2;
                }
                com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar3 = nVar2;
                float f22 = TextUtils.equals(nVar2.fx(), "root") ? i2 : f18;
                int i4 = i2;
                if (izVarPn5.lf() == 1) {
                    f5 = f22;
                    nrVar2 = nrVar;
                    aVarU = u(nrVar2, izVarPn5, (f21 - fSu) - fWi, (f4 - fCj) - fTk);
                } else {
                    f5 = f22;
                    nrVar2 = nrVar;
                    aVarU = aVar3;
                }
                com.bytedance.sdk.component.adexpress.dynamic.fx.a aVar4 = aVarU;
                if (izVarPn5.lf() == 2) {
                    f6 = fMax;
                    nVar = next4;
                    aVarU2 = u(izVarPn5, this.nr.u(this.fx), new nr.fx((f21 - fSu) - fWi, (f4 - fCj) - fTk));
                } else {
                    f6 = fMax;
                    nVar = next4;
                    aVarU2 = aVar4;
                }
                String strRg = izVar.rg();
                if (fMax2 <= f4 || TextUtils.equals(strRg, "flex-start")) {
                    f7 = 0.0f;
                } else {
                    strRg.hashCode();
                    if (strRg.equals("center")) {
                        f7 = (fMax2 - f4) / 2.0f;
                    } else if (strRg.equals("flex-end")) {
                        f7 = fMax2 - f4;
                    }
                }
                com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar4 = new com.bytedance.sdk.component.adexpress.dynamic.fx.nr();
                nrVar4.u = aVarU2.u + fWi;
                nrVar4.nr = aVarU2.nr + fCj + f7;
                nrVar4.fx = (f21 - fSu) - fWi;
                nrVar4.b = (f4 - fCj) - fTk;
                nrVar4.pn = nrVar2.pn + "." + nVar.fx();
                nrVar4.n = nrVar2;
                com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar4 = nVar;
                nrVar4.iz = nVar4;
                fMax = f6;
                nrVar4.f5086a = fMax;
                List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> list4 = list;
                nrVar4.jk = list4;
                nVar4.fx(nrVar4.u);
                nrVar4.iz.b(nrVar4.nr);
                nrVar4.iz.pn(nrVar4.fx);
                nrVar4.iz.iz(nrVar4.b);
                float f23 = f5;
                nrVar2.x.get(i4).add(u(nrVar4, f23));
                if (izVarPn5.lf() == 1) {
                    aVar = aVar3;
                } else if (izVarPn5.lf() != 2) {
                    aVar = aVar3;
                    aVar.u += f21 + f20;
                } else {
                    aVar = aVar3;
                }
                list2 = list4;
                f14 = f23;
                aVar2 = aVar;
                i2 = i4;
                strBc = str6;
                str2 = str5;
                f11 = f19;
                fU4 = f20;
                nVar2 = nVar3;
                it8 = it9;
            }
            com.bytedance.sdk.component.adexpress.dynamic.fx.a aVar5 = aVar2;
            aVar5.u = f8;
            aVar5.nr += fMax2 + f2;
            nrVar3 = nrVar;
            i = i2;
            strBc = strBc;
            listO = list3;
            izVarPn = izVar;
            fU2 = f2;
            str = str4;
            nVar2 = nVar2;
        }
        return nrVar3;
    }

    private com.bytedance.sdk.component.adexpress.dynamic.fx.a u(com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVar, nr.fx fxVar, nr.fx fxVar2) {
        float fJu = izVar.ju();
        float fJw = izVar.jw();
        float fZx = izVar.zx();
        float fUq = izVar.uq();
        boolean zGc = izVar.gc();
        boolean zMk = izVar.mk();
        boolean zP = izVar.p();
        boolean zKw = izVar.kw();
        if (!zGc) {
            if (zMk) {
                float f = this.b.u;
                fJu = ((f != 0.0f ? Math.min(f, fxVar.u) : fxVar.u) - fZx) - fxVar2.u;
            } else {
                fJu = 0.0f;
            }
        }
        if (!zP) {
            if (zKw) {
                float f2 = this.b.nr;
                if (f2 == 0.0f) {
                    f2 = fxVar.nr;
                }
                fJw = (f2 - fUq) - fxVar2.nr;
            } else {
                fJw = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.fx.a(fJu, fJw);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.fx.a u(com.bytedance.sdk.component.adexpress.dynamic.fx.nr nrVar, com.bytedance.sdk.component.adexpress.dynamic.fx.iz izVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = nrVar.u;
        float f6 = nrVar.nr;
        float fJu = izVar.ju();
        float fJw = izVar.jw();
        float fZx = izVar.zx();
        float fUq = izVar.uq();
        boolean zGc = izVar.gc();
        boolean zMk = izVar.mk();
        boolean zP = izVar.p();
        boolean zKw = izVar.kw();
        String strNb = izVar.nb();
        float f7 = nrVar.fx;
        float f8 = nrVar.b;
        if (TextUtils.equals(strNb, "0")) {
            if (zGc) {
                f5 = nrVar.u + fJu;
            } else if (zMk) {
                f5 = ((nrVar.u + f7) - fZx) - f;
            }
            if (zP) {
                f4 = nrVar.nr;
                f6 = f4 + fJw;
            } else if (zKw) {
                f3 = nrVar.nr;
                f6 = ((f3 + f8) - fUq) - f2;
            }
        } else if (TextUtils.equals(strNb, "1")) {
            f5 = nrVar.u + ((f7 - f) / 2.0f);
            if (zP) {
                f4 = nrVar.nr;
                f6 = f4 + fJw;
            } else if (zKw) {
                f3 = nrVar.nr;
                f6 = ((f3 + f8) - fUq) - f2;
            }
        } else if (TextUtils.equals(strNb, "2")) {
            f6 = nrVar.nr + ((f8 - f2) / 2.0f);
            if (zGc) {
                f5 = nrVar.u + fJu;
            } else if (zMk) {
                f5 = ((nrVar.u + f7) - fZx) - f;
            }
        } else if (TextUtils.equals(strNb, "3")) {
            f5 = nrVar.u + ((f7 - f) / 2.0f);
            f6 = nrVar.nr + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.fx.a(f5, f6);
    }
}
