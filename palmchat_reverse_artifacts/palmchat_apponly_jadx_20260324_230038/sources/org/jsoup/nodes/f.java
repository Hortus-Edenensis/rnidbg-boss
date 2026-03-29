package org.jsoup.nodes;

import com.qq.gdt.action.ActionUtils;
import defpackage.bt5;
import defpackage.e96;
import defpackage.jl5;
import defpackage.kc4;
import defpackage.lc4;
import defpackage.qy3;
import defpackage.sy3;
import defpackage.tg0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.jsoup.select.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class f extends g {
    public static final Pattern h = Pattern.compile("\\s+");
    public bt5 g;

    public f(bt5 bt5Var, String str, b bVar) {
        super(str, bVar);
        e96.j(bt5Var);
        this.g = bt5Var;
    }

    public static boolean E0(g gVar) {
        if (gVar == null || !(gVar instanceof f)) {
            return false;
        }
        f fVar = (f) gVar;
        return fVar.g.h() || (fVar.D() != null && fVar.D().g.h());
    }

    public static void V(f fVar, Elements elements) {
        f fVarD = fVar.D();
        if (fVarD == null || fVarD.K0().equals("#root")) {
            return;
        }
        elements.add(fVarD);
        V(fVarD, elements);
    }

    public static void a0(StringBuilder sb, h hVar) {
        String strU = hVar.U();
        if (E0(hVar.f19832a)) {
            sb.append(strU);
        } else {
            jl5.a(sb, strU, h.W(sb));
        }
    }

    public static void b0(f fVar, StringBuilder sb) {
        if (!fVar.g.b().equals("br") || h.W(sb)) {
            return;
        }
        sb.append(" ");
    }

    public static <E extends f> Integer x0(f fVar, List<E> list) {
        e96.j(fVar);
        e96.j(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == fVar) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @Override // org.jsoup.nodes.g
    public void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.h() && ((this.g.a() || ((D() != null && D().J0().a()) || outputSettings.g())) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0))) {
            v(appendable, i, outputSettings);
        }
        appendable.append("<").append(K0());
        this.c.j(appendable, outputSettings);
        if (!this.b.isEmpty() || !this.g.g()) {
            appendable.append(">");
        } else if (outputSettings.i() == Document.OutputSettings.Syntax.html && this.g.d()) {
            appendable.append(Typography.greater);
        } else {
            appendable.append(" />");
        }
    }

    public final void A0(StringBuilder sb) {
        for (g gVar : this.b) {
            if (gVar instanceof h) {
                a0(sb, (h) gVar);
            } else if (gVar instanceof f) {
                b0((f) gVar, sb);
            }
        }
    }

    @Override // org.jsoup.nodes.g
    public void B(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (this.b.isEmpty() && this.g.g()) {
            return;
        }
        if (outputSettings.h() && !this.b.isEmpty() && (this.g.a() || (outputSettings.g() && (this.b.size() > 1 || (this.b.size() == 1 && !(this.b.get(0) instanceof h)))))) {
            v(appendable, i, outputSettings);
        }
        appendable.append("</").append(K0()).append(">");
    }

    @Override // org.jsoup.nodes.g
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public final f D() {
        return (f) this.f19832a;
    }

    public Elements C0() {
        Elements elements = new Elements();
        V(this, elements);
        return elements;
    }

    public f D0(String str) {
        e96.j(str);
        List<g> listB = lc4.b(str, this, i());
        b(0, (g[]) listB.toArray(new g[listB.size()]));
        return this;
    }

    public f F0() {
        if (this.f19832a == null) {
            return null;
        }
        Elements elementsG0 = D().g0();
        Integer numX0 = x0(this, elementsG0);
        e96.j(numX0);
        if (numX0.intValue() > 0) {
            return elementsG0.get(numX0.intValue() - 1);
        }
        return null;
    }

    public f G0(String str) {
        e96.j(str);
        Set<String> setI0 = i0();
        setI0.remove(str);
        j0(setI0);
        return this;
    }

    public Elements H0(String str) {
        return Selector.d(str, this);
    }

    public Elements I0() {
        if (this.f19832a == null) {
            return new Elements(0);
        }
        Elements elementsG0 = D().g0();
        Elements elements = new Elements(elementsG0.size() - 1);
        for (f fVar : elementsG0) {
            if (fVar != this) {
                elements.add(fVar);
            }
        }
        return elements;
    }

    public bt5 J0() {
        return this.g;
    }

    public String K0() {
        return this.g.b();
    }

    public f L0(String str) {
        e96.i(str, "Tag name must not be empty.");
        this.g = bt5.k(str, kc4.d);
        return this;
    }

    public String M0() {
        StringBuilder sb = new StringBuilder();
        new qy3(new a(sb)).a(this);
        return sb.toString().trim();
    }

    public f N0(String str) {
        e96.j(str);
        m0();
        Z(new h(str, this.d));
        return this;
    }

    public f O0(String str) {
        e96.j(str);
        Set<String> setI0 = i0();
        if (setI0.contains(str)) {
            setI0.remove(str);
        } else {
            setI0.add(str);
        }
        j0(setI0);
        return this;
    }

    public String P0() {
        return K0().equals("textarea") ? M0() : f(ActionUtils.PAYMENT_AMOUNT);
    }

    public f Q0(String str) {
        if (K0().equals("textarea")) {
            N0(str);
        } else {
            c0(ActionUtils.PAYMENT_AMOUNT, str);
        }
        return this;
    }

    public f R0(String str) {
        return (f) super.S(str);
    }

    public f W(String str) {
        e96.j(str);
        Set<String> setI0 = i0();
        setI0.add(str);
        j0(setI0);
        return this;
    }

    public f X(String str) {
        return (f) super.e(str);
    }

    public f Y(String str) {
        e96.j(str);
        List<g> listB = lc4.b(str, this, i());
        c((g[]) listB.toArray(new g[listB.size()]));
        return this;
    }

    public f Z(g gVar) {
        e96.j(gVar);
        J(gVar);
        r();
        this.b.add(gVar);
        gVar.N(this.b.size() - 1);
        return this;
    }

    public f c0(String str, String str2) {
        super.g(str, str2);
        return this;
    }

    public f d0(String str) {
        return (f) super.j(str);
    }

    public f e0(g gVar) {
        return (f) super.k(gVar);
    }

    public f f0(int i) {
        return g0().get(i);
    }

    public Elements g0() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (g gVar : this.b) {
            if (gVar instanceof f) {
                arrayList.add((f) gVar);
            }
        }
        return new Elements((List<f>) arrayList);
    }

    public String h0() {
        return f("class").trim();
    }

    public Set<String> i0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(h.split(h0())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public f j0(Set<String> set) {
        e96.j(set);
        this.c.k("class", jl5.g(set, " "));
        return this;
    }

    @Override // org.jsoup.nodes.g
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public f p() {
        return (f) super.p();
    }

    public Integer l0() {
        if (D() == null) {
            return 0;
        }
        return x0(this, D().g0());
    }

    public f m0() {
        this.b.clear();
        return this;
    }

    public Elements n0() {
        return tg0.a(new b.a(), this);
    }

    public Elements o0(String str, String str2) {
        return tg0.a(new b.e(str, str2), this);
    }

    public Elements p0(String str, String str2) {
        return tg0.a(new b.j(str, str2), this);
    }

    public Elements q0(String str) {
        e96.h(str);
        return tg0.a(new b.h0(str.toLowerCase().trim()), this);
    }

    public boolean r0(String str) {
        String strE = this.c.e("class");
        int length = strE.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(strE);
            }
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(strE.charAt(i2))) {
                    if (!z) {
                        continue;
                    } else {
                        if (i2 - i == length2 && strE.regionMatches(true, i, str, 0, length2)) {
                            return true;
                        }
                        z = false;
                    }
                } else if (!z) {
                    i = i2;
                    z = true;
                }
            }
            if (z && length - i == length2) {
                return strE.regionMatches(true, i, str, 0, length2);
            }
        }
        return false;
    }

    public boolean s0() {
        for (g gVar : this.b) {
            if (gVar instanceof h) {
                if (!((h) gVar).V()) {
                    return true;
                }
            } else if ((gVar instanceof f) && ((f) gVar).s0()) {
                return true;
            }
        }
        return false;
    }

    public String t0() {
        StringBuilder sb = new StringBuilder();
        v0(sb);
        boolean zH = t().h();
        String string = sb.toString();
        return zH ? string.trim() : string;
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return y();
    }

    public f u0(String str) {
        m0();
        Y(str);
        return this;
    }

    public final void v0(StringBuilder sb) {
        Iterator<g> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().z(sb);
        }
    }

    public String w0() {
        return this.c.f("id");
    }

    @Override // org.jsoup.nodes.g
    public String x() {
        return this.g.b();
    }

    public boolean y0() {
        return this.g.c();
    }

    public String z0() {
        StringBuilder sb = new StringBuilder();
        A0(sb);
        return sb.toString().trim();
    }

    public f(bt5 bt5Var, String str) {
        this(bt5Var, str, new b());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements sy3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f19831a;

        public a(StringBuilder sb) {
            this.f19831a = sb;
        }

        @Override // defpackage.sy3
        public void b(g gVar, int i) {
            if (gVar instanceof h) {
                f.a0(this.f19831a, (h) gVar);
            } else if (gVar instanceof f) {
                f fVar = (f) gVar;
                if (this.f19831a.length() > 0) {
                    if ((fVar.y0() || fVar.g.b().equals("br")) && !h.W(this.f19831a)) {
                        this.f19831a.append(" ");
                    }
                }
            }
        }

        @Override // defpackage.sy3
        public void a(g gVar, int i) {
        }
    }
}
