package org.jsoup.nodes;

import defpackage.e96;
import defpackage.jl5;
import defpackage.lc4;
import defpackage.qy3;
import defpackage.sy3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g implements Cloneable {
    public static final List<g> f = Collections.emptyList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f19832a;
    public List<g> b;
    public org.jsoup.nodes.b c;
    public String d;
    public int e;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements sy3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Appendable f19834a;
        public Document.OutputSettings b;

        public b(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f19834a = appendable;
            this.b = outputSettings;
        }

        @Override // defpackage.sy3
        public void a(g gVar, int i) {
            if (gVar.x().equals("#text")) {
                return;
            }
            try {
                gVar.B(this.f19834a, i, this.b);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        @Override // defpackage.sy3
        public void b(g gVar, int i) {
            try {
                gVar.A(this.f19834a, i, this.b);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }
    }

    public g(String str, org.jsoup.nodes.b bVar) {
        e96.j(str);
        e96.j(bVar);
        this.b = f;
        this.d = str.trim();
        this.c = bVar;
    }

    public abstract void A(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public abstract void B(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public Document C() {
        if (this instanceof Document) {
            return (Document) this;
        }
        g gVar = this.f19832a;
        if (gVar == null) {
            return null;
        }
        return gVar.C();
    }

    public g D() {
        return this.f19832a;
    }

    public final g E() {
        return this.f19832a;
    }

    public final void F(int i) {
        while (i < this.b.size()) {
            this.b.get(i).N(i);
            i++;
        }
    }

    public void G() {
        e96.j(this.f19832a);
        this.f19832a.I(this);
    }

    public g H(String str) {
        e96.j(str);
        this.c.m(str);
        return this;
    }

    public void I(g gVar) {
        e96.d(gVar.f19832a == this);
        int i = gVar.e;
        this.b.remove(i);
        F(i);
        gVar.f19832a = null;
    }

    public void J(g gVar) {
        g gVar2 = gVar.f19832a;
        if (gVar2 != null) {
            gVar2.I(gVar);
        }
        gVar.M(this);
    }

    public void K(g gVar, g gVar2) {
        e96.d(gVar.f19832a == this);
        e96.j(gVar2);
        g gVar3 = gVar2.f19832a;
        if (gVar3 != null) {
            gVar3.I(gVar2);
        }
        int i = gVar.e;
        this.b.set(i, gVar2);
        gVar2.f19832a = this;
        gVar2.N(i);
        gVar.f19832a = null;
    }

    public void L(String str) {
        e96.j(str);
        Q(new a(str));
    }

    public void M(g gVar) {
        g gVar2 = this.f19832a;
        if (gVar2 != null) {
            gVar2.I(this);
        }
        this.f19832a = gVar;
    }

    public void N(int i) {
        this.e = i;
    }

    public int O() {
        return this.e;
    }

    public List<g> P() {
        g gVar = this.f19832a;
        if (gVar == null) {
            return Collections.emptyList();
        }
        List<g> list = gVar.b;
        ArrayList arrayList = new ArrayList(list.size() - 1);
        for (g gVar2 : list) {
            if (gVar2 != this) {
                arrayList.add(gVar2);
            }
        }
        return arrayList;
    }

    public g Q(sy3 sy3Var) {
        e96.j(sy3Var);
        new qy3(sy3Var).a(this);
        return this;
    }

    public g R() {
        e96.j(this.f19832a);
        g gVar = this.b.size() > 0 ? this.b.get(0) : null;
        this.f19832a.b(this.e, o());
        G();
        return gVar;
    }

    public g S(String str) {
        e96.h(str);
        List<g> listB = lc4.b(str, D() instanceof f ? (f) D() : null, i());
        g gVar = listB.get(0);
        if (gVar == null || !(gVar instanceof f)) {
            return null;
        }
        f fVar = (f) gVar;
        f fVarS = s(fVar);
        this.f19832a.K(this, fVar);
        fVarS.c(this);
        if (listB.size() > 0) {
            for (int i = 0; i < listB.size(); i++) {
                g gVar2 = listB.get(i);
                gVar2.f19832a.I(gVar2);
                fVar.Z(gVar2);
            }
        }
        return this;
    }

    public String a(String str) {
        e96.h(str);
        return !u(str) ? "" : jl5.k(this.d, f(str));
    }

    public void b(int i, g... gVarArr) {
        e96.f(gVarArr);
        r();
        for (int length = gVarArr.length - 1; length >= 0; length--) {
            g gVar = gVarArr[length];
            J(gVar);
            this.b.add(i, gVar);
            F(i);
        }
    }

    public void c(g... gVarArr) {
        for (g gVar : gVarArr) {
            J(gVar);
            r();
            this.b.add(gVar);
            gVar.N(this.b.size() - 1);
        }
    }

    public final void d(int i, String str) {
        e96.j(str);
        e96.j(this.f19832a);
        List<g> listB = lc4.b(str, D() instanceof f ? (f) D() : null, i());
        this.f19832a.b(i, (g[]) listB.toArray(new g[listB.size()]));
    }

    public g e(String str) {
        d(this.e + 1, str);
        return this;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String f(String str) {
        e96.j(str);
        String strF = this.c.f(str);
        return strF.length() > 0 ? strF : str.toLowerCase().startsWith("abs:") ? a(str.substring(4)) : "";
    }

    public g g(String str, String str2) {
        this.c.k(str, str2);
        return this;
    }

    public org.jsoup.nodes.b h() {
        return this.c;
    }

    public String i() {
        return this.d;
    }

    public g j(String str) {
        d(this.e, str);
        return this;
    }

    public g k(g gVar) {
        e96.j(gVar);
        e96.j(this.f19832a);
        this.f19832a.b(this.e, gVar);
        return this;
    }

    public g l(int i) {
        return this.b.get(i);
    }

    public final int m() {
        return this.b.size();
    }

    public List<g> n() {
        return Collections.unmodifiableList(this.b);
    }

    public g[] o() {
        return (g[]) this.b.toArray(new g[m()]);
    }

    @Override // 
    public g k0() {
        g gVarQ = q(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(gVarQ);
        while (!linkedList.isEmpty()) {
            g gVar = (g) linkedList.remove();
            for (int i = 0; i < gVar.b.size(); i++) {
                g gVarQ2 = gVar.b.get(i).q(gVar);
                gVar.b.set(i, gVarQ2);
                linkedList.add(gVarQ2);
            }
        }
        return gVarQ;
    }

    public g q(g gVar) {
        try {
            g gVar2 = (g) super.clone();
            gVar2.f19832a = gVar;
            gVar2.e = gVar == null ? 0 : this.e;
            org.jsoup.nodes.b bVar = this.c;
            gVar2.c = bVar != null ? bVar.clone() : null;
            gVar2.d = this.d;
            gVar2.b = new ArrayList(this.b.size());
            Iterator<g> it = this.b.iterator();
            while (it.hasNext()) {
                gVar2.b.add(it.next());
            }
            return gVar2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void r() {
        if (this.b == f) {
            this.b = new ArrayList(4);
        }
    }

    public final f s(f fVar) {
        Elements elementsG0 = fVar.g0();
        return elementsG0.size() > 0 ? s(elementsG0.get(0)) : fVar;
    }

    public Document.OutputSettings t() {
        return (C() != null ? C() : new Document("")).V0();
    }

    public String toString() {
        return y();
    }

    public boolean u(String str) {
        e96.j(str);
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (this.c.h(strSubstring) && !a(strSubstring).equals("")) {
                return true;
            }
        }
        return this.c.h(str);
    }

    public void v(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("\n").append(jl5.j(i * outputSettings.f()));
    }

    public g w() {
        g gVar = this.f19832a;
        if (gVar == null) {
            return null;
        }
        List<g> list = gVar.b;
        int i = this.e + 1;
        if (list.size() > i) {
            return list.get(i);
        }
        return null;
    }

    public abstract String x();

    public String y() {
        StringBuilder sb = new StringBuilder(128);
        z(sb);
        return sb.toString();
    }

    public void z(Appendable appendable) {
        new qy3(new b(appendable, t())).a(this);
    }

    public g(String str) {
        this(str, new org.jsoup.nodes.b());
    }

    public g() {
        this.b = f;
        this.c = null;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements sy3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19833a;

        public a(String str) {
            this.f19833a = str;
        }

        @Override // defpackage.sy3
        public void b(g gVar, int i) {
            gVar.d = this.f19833a;
        }

        @Override // defpackage.sy3
        public void a(g gVar, int i) {
        }
    }
}
