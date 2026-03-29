package defpackage;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.bh;
import com.ss.android.download.api.constant.BaseConstants;
import com.tide.protocol.util.TdFileUtils;
import defpackage.vy5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.c;
import org.jsoup.nodes.d;
import org.jsoup.nodes.f;
import org.jsoup.nodes.g;
import org.jsoup.nodes.h;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class aj2 extends n16 {
    public bj2 k;
    public bj2 l;
    public f n;
    public z02 o;
    public f p;
    public static final String[] x = {"applet", "caption", "html", "table", TdFileUtils.PLUGIN_FILE, "th", "marquee", "object"};
    public static final String[] y = {"ol", "ul"};
    public static final String[] z = {"button"};
    public static final String[] A = {"html", "table"};
    public static final String[] B = {"optgroup", "option"};
    public static final String[] C = {"dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"};
    public static final String[] D = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", b.y, "dd", BaseConstants.MARKET_URI_AUTHORITY_DETAIL, MapBundleKey.MapObjKey.OBJ_DIR, "div", CmcdConfiguration.KEY_DEADLINE, "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", bh.Code, "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", RemoteMessageConst.MessageBody.PARAM, "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", TdFileUtils.PLUGIN_FILE, "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    public boolean m = false;
    public ArrayList<f> q = new ArrayList<>();
    public List<String> r = new ArrayList();
    public vy5.f s = new vy5.f();
    public boolean t = true;
    public boolean u = false;
    public boolean v = false;
    public String[] w = {null};

    public List<String> A() {
        return this.r;
    }

    public void A0(f fVar) {
        this.n = fVar;
    }

    public ArrayList<f> B() {
        return this.d;
    }

    public bj2 B0() {
        return this.k;
    }

    public boolean C(String str) {
        return F(str, z);
    }

    public void C0(bj2 bj2Var) {
        this.k = bj2Var;
    }

    public boolean D(String str) {
        return F(str, y);
    }

    public boolean E(String str) {
        return F(str, null);
    }

    public boolean F(String str, String[] strArr) {
        return I(str, x, strArr);
    }

    public boolean G(String[] strArr) {
        return J(strArr, x, null);
    }

    public boolean H(String str) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            String strX = this.d.get(size).x();
            if (strX.equals(str)) {
                return true;
            }
            if (!jl5.b(strX, B)) {
                return false;
            }
        }
        e96.a("Should not be reachable");
        return false;
    }

    public final boolean I(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.w;
        strArr3[0] = str;
        return J(strArr3, strArr, strArr2);
    }

    public final boolean J(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            String strX = this.d.get(size).x();
            if (jl5.b(strX, strArr)) {
                return true;
            }
            if (jl5.b(strX, strArr2)) {
                return false;
            }
            if (strArr3 != null && jl5.b(strX, strArr3)) {
                return false;
            }
        }
        e96.a("Should not be reachable");
        return false;
    }

    public boolean K(String str) {
        return I(str, A, null);
    }

    public f L(vy5.g gVar) {
        if (!gVar.y()) {
            f fVar = new f(bt5.k(gVar.A(), this.h), this.e, this.h.a(gVar.j));
            O(fVar);
            return fVar;
        }
        f fVarP = P(gVar);
        this.d.add(fVarP);
        this.b.v(zy5.Data);
        this.b.k(this.s.l().z(fVarP.K0()));
        return fVarP;
    }

    public void M(vy5.b bVar) {
        String strK0 = a().K0();
        a().Z((strK0.equals("script") || strK0.equals("style")) ? new d(bVar.p(), this.e) : new h(bVar.p(), this.e));
    }

    public void N(vy5.c cVar) {
        T(new c(cVar.o(), this.e));
    }

    public void O(f fVar) {
        T(fVar);
        this.d.add(fVar);
    }

    public f P(vy5.g gVar) {
        bt5 bt5VarK = bt5.k(gVar.A(), this.h);
        f fVar = new f(bt5VarK, this.e, gVar.j);
        T(fVar);
        if (gVar.y()) {
            if (!bt5VarK.f()) {
                bt5VarK.j();
                this.b.a();
            } else if (bt5VarK.g()) {
                this.b.a();
            }
        }
        return fVar;
    }

    public z02 Q(vy5.g gVar, boolean z2) {
        z02 z02Var = new z02(bt5.k(gVar.A(), this.h), this.e, gVar.j);
        y0(z02Var);
        T(z02Var);
        if (z2) {
            this.d.add(z02Var);
        }
        return z02Var;
    }

    public void R(g gVar) {
        f fVarJ;
        f fVarY = y("table");
        boolean z2 = false;
        if (fVarY == null) {
            fVarJ = this.d.get(0);
        } else if (fVarY.D() != null) {
            fVarJ = fVarY.D();
            z2 = true;
        } else {
            fVarJ = j(fVarY);
        }
        if (!z2) {
            fVarJ.Z(gVar);
        } else {
            e96.j(fVarY);
            fVarY.e0(gVar);
        }
    }

    public void S() {
        this.q.add(null);
    }

    public final void T(g gVar) {
        z02 z02Var;
        if (this.d.size() == 0) {
            this.c.Z(gVar);
        } else if (X()) {
            R(gVar);
        } else {
            a().Z(gVar);
        }
        if (gVar instanceof f) {
            f fVar = (f) gVar;
            if (!fVar.J0().e() || (z02Var = this.o) == null) {
                return;
            }
            z02Var.S0(fVar);
        }
    }

    public void U(f fVar, f fVar2) {
        int iLastIndexOf = this.d.lastIndexOf(fVar);
        e96.d(iLastIndexOf != -1);
        this.d.add(iLastIndexOf + 1, fVar2);
    }

    public f V(String str) {
        f fVar = new f(bt5.k(str, this.h), this.e);
        O(fVar);
        return fVar;
    }

    public final boolean W(ArrayList<f> arrayList, f fVar) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == fVar) {
                return true;
            }
        }
        return false;
    }

    public boolean X() {
        return this.u;
    }

    public boolean Y() {
        return this.v;
    }

    public boolean Z(f fVar) {
        return W(this.q, fVar);
    }

    public final boolean a0(f fVar, f fVar2) {
        return fVar.x().equals(fVar2.x()) && fVar.h().equals(fVar2.h());
    }

    @Override // defpackage.n16
    public kc4 b() {
        return kc4.c;
    }

    public boolean b0(f fVar) {
        return jl5.b(fVar.x(), D);
    }

    public f c0() {
        if (this.q.size() <= 0) {
            return null;
        }
        return this.q.get(r0.size() - 1);
    }

    @Override // defpackage.n16
    public Document d(String str, String str2, jc4 jc4Var, kc4 kc4Var) {
        this.k = bj2.Initial;
        this.m = false;
        return super.d(str, str2, jc4Var, kc4Var);
    }

    public void d0() {
        this.l = this.k;
    }

    @Override // defpackage.n16
    public boolean e(vy5 vy5Var) {
        this.f = vy5Var;
        return this.k.process(vy5Var, this);
    }

    public void e0(f fVar) {
        if (this.m) {
            return;
        }
        String strA = fVar.a("href");
        if (strA.length() != 0) {
            this.e = strA;
            this.m = true;
            this.c.L(strA);
        }
    }

    public void f0() {
        this.r = new ArrayList();
    }

    public boolean g0(f fVar) {
        return W(this.d, fVar);
    }

    @Override // defpackage.n16
    public /* bridge */ /* synthetic */ boolean h(String str, org.jsoup.nodes.b bVar) {
        return super.h(str, bVar);
    }

    public bj2 h0() {
        return this.l;
    }

    public List<g> i0(String str, f fVar, String str2, jc4 jc4Var, kc4 kc4Var) {
        f fVar2;
        this.k = bj2.Initial;
        c(str, str2, jc4Var, kc4Var);
        this.p = fVar;
        this.v = true;
        if (fVar != null) {
            if (fVar.C() != null) {
                this.c.X0(fVar.C().W0());
            }
            String strK0 = fVar.K0();
            if (jl5.b(strK0, "title", "textarea")) {
                this.b.v(zy5.Rcdata);
            } else if (jl5.b(strK0, "iframe", "noembed", "noframes", "style", "xmp")) {
                this.b.v(zy5.Rawtext);
            } else if (strK0.equals("script")) {
                this.b.v(zy5.ScriptData);
            } else if (!strK0.equals("noscript") && strK0.equals("plaintext")) {
                this.b.v(zy5.Data);
            } else {
                this.b.v(zy5.Data);
            }
            fVar2 = new f(bt5.k("html", kc4Var), str2);
            this.c.Z(fVar2);
            this.d.add(fVar2);
            x0();
            Elements elementsC0 = fVar.C0();
            elementsC0.add(0, fVar);
            Iterator<f> it = elementsC0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (next instanceof z02) {
                    this.o = (z02) next;
                    break;
                }
            }
        } else {
            fVar2 = null;
        }
        i();
        return (fVar == null || fVar2 == null) ? this.c.n() : fVar2.n();
    }

    public f j(f fVar) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            if (this.d.get(size) == fVar) {
                return this.d.get(size - 1);
            }
        }
        return null;
    }

    public f j0() {
        return this.d.remove(this.d.size() - 1);
    }

    public void k() {
        while (!this.q.isEmpty() && t0() != null) {
        }
    }

    public void k0(String str) {
        for (int size = this.d.size() - 1; size >= 0 && !this.d.get(size).x().equals(str); size--) {
            this.d.remove(size);
        }
    }

    public final void l(String... strArr) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            f fVar = this.d.get(size);
            if (jl5.b(fVar.x(), strArr) || fVar.x().equals("html")) {
                return;
            }
            this.d.remove(size);
        }
    }

    public void l0(String str) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            f fVar = this.d.get(size);
            this.d.remove(size);
            if (fVar.x().equals(str)) {
                return;
            }
        }
    }

    public void m() {
        l("tbody", "tfoot", "thead");
    }

    public void m0(String... strArr) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            f fVar = this.d.get(size);
            this.d.remove(size);
            if (jl5.b(fVar.x(), strArr)) {
                return;
            }
        }
    }

    public void n() {
        l("table");
    }

    public boolean n0(vy5 vy5Var, bj2 bj2Var) {
        this.f = vy5Var;
        return bj2Var.process(vy5Var, this);
    }

    public void o() {
        l("tr");
    }

    public void o0(f fVar) {
        this.d.add(fVar);
    }

    public void p(bj2 bj2Var) {
        if (this.g.o()) {
            this.g.add(new ic4(this.f19414a.D(), "Unexpected token [%s] when in state [%s]", this.f.n(), bj2Var));
        }
    }

    public void p0(f fVar) {
        int size = this.q.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                f fVar2 = this.q.get(size);
                if (fVar2 == null) {
                    break;
                }
                if (a0(fVar, fVar2)) {
                    i++;
                }
                if (i == 3) {
                    this.q.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.q.add(fVar);
    }

    public void q(boolean z2) {
        this.t = z2;
    }

    public void q0() {
        f fVarC0 = c0();
        if (fVarC0 == null || g0(fVarC0)) {
            return;
        }
        boolean z2 = true;
        int size = this.q.size() - 1;
        int i = size;
        while (i != 0) {
            i--;
            fVarC0 = this.q.get(i);
            if (fVarC0 == null || g0(fVarC0)) {
                z2 = false;
                break;
            }
        }
        while (true) {
            if (!z2) {
                i++;
                fVarC0 = this.q.get(i);
            }
            e96.j(fVarC0);
            f fVarV = V(fVarC0.x());
            fVarV.h().a(fVarC0.h());
            this.q.set(i, fVarV);
            if (i == size) {
                return;
            } else {
                z2 = false;
            }
        }
    }

    public boolean r() {
        return this.t;
    }

    public void r0(f fVar) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            if (this.q.get(size) == fVar) {
                this.q.remove(size);
                return;
            }
        }
    }

    public void s() {
        t(null);
    }

    public boolean s0(f fVar) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            if (this.d.get(size) == fVar) {
                this.d.remove(size);
                return true;
            }
        }
        return false;
    }

    public void t(String str) {
        while (str != null && !a().x().equals(str) && jl5.b(a().x(), C)) {
            j0();
        }
    }

    public f t0() {
        int size = this.q.size();
        if (size > 0) {
            return this.q.remove(size - 1);
        }
        return null;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f + ", state=" + this.k + ", currentElement=" + a() + '}';
    }

    public f u(String str) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            f fVar = this.q.get(size);
            if (fVar == null) {
                return null;
            }
            if (fVar.x().equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    public void u0(f fVar, f fVar2) {
        v0(this.q, fVar, fVar2);
    }

    public String v() {
        return this.e;
    }

    public final void v0(ArrayList<f> arrayList, f fVar, f fVar2) {
        int iLastIndexOf = arrayList.lastIndexOf(fVar);
        e96.d(iLastIndexOf != -1);
        arrayList.set(iLastIndexOf, fVar2);
    }

    public Document w() {
        return this.c;
    }

    public void w0(f fVar, f fVar2) {
        v0(this.d, fVar, fVar2);
    }

    public z02 x() {
        return this.o;
    }

    public void x0() {
        boolean z2 = false;
        for (int size = this.d.size() - 1; size >= 0; size--) {
            f fVar = this.d.get(size);
            if (size == 0) {
                fVar = this.p;
                z2 = true;
            }
            String strX = fVar.x();
            if ("select".equals(strX)) {
                C0(bj2.InSelect);
                return;
            }
            if (TdFileUtils.PLUGIN_FILE.equals(strX) || ("th".equals(strX) && !z2)) {
                C0(bj2.InCell);
                return;
            }
            if ("tr".equals(strX)) {
                C0(bj2.InRow);
                return;
            }
            if ("tbody".equals(strX) || "thead".equals(strX) || "tfoot".equals(strX)) {
                C0(bj2.InTableBody);
                return;
            }
            if ("caption".equals(strX)) {
                C0(bj2.InCaption);
                return;
            }
            if ("colgroup".equals(strX)) {
                C0(bj2.InColumnGroup);
                return;
            }
            if ("table".equals(strX)) {
                C0(bj2.InTable);
                return;
            }
            if ("head".equals(strX)) {
                C0(bj2.InBody);
                return;
            }
            if ("body".equals(strX)) {
                C0(bj2.InBody);
                return;
            }
            if ("frameset".equals(strX)) {
                C0(bj2.InFrameset);
                return;
            } else if ("html".equals(strX)) {
                C0(bj2.BeforeHead);
                return;
            } else {
                if (z2) {
                    C0(bj2.InBody);
                    return;
                }
            }
        }
    }

    public f y(String str) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            f fVar = this.d.get(size);
            if (fVar.x().equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    public void y0(z02 z02Var) {
        this.o = z02Var;
    }

    public f z() {
        return this.n;
    }

    public void z0(boolean z2) {
        this.u = z2;
    }
}
