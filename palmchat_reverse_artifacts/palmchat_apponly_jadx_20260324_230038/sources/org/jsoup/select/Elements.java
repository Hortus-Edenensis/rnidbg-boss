package org.jsoup.select;

import defpackage.e96;
import defpackage.qy3;
import defpackage.sy3;
import defpackage.z02;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.jsoup.nodes.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Elements extends ArrayList<f> {
    public Elements() {
    }

    public Elements addClass(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().W(str);
        }
        return this;
    }

    public Elements after(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().X(str);
        }
        return this;
    }

    public Elements append(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().Y(str);
        }
        return this;
    }

    public String attr(String str) {
        for (f fVar : this) {
            if (fVar.u(str)) {
                return fVar.f(str);
            }
        }
        return "";
    }

    public Elements before(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().d0(str);
        }
        return this;
    }

    public Elements empty() {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().m0();
        }
        return this;
    }

    public Elements eq(int i) {
        return size() > i ? new Elements(get(i)) : new Elements();
    }

    public f first() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public List<z02> forms() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this) {
            if (fVar instanceof z02) {
                arrayList.add((z02) fVar);
            }
        }
        return arrayList;
    }

    public boolean hasAttr(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            if (it.next().u(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasClass(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            if (it.next().r0(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasText() {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            if (it.next().s0()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder sb = new StringBuilder();
        for (f fVar : this) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(fVar.t0());
        }
        return sb.toString();
    }

    public boolean is(String str) {
        return !select(str).isEmpty();
    }

    public f last() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public Elements not(String str) {
        return Selector.a(this, Selector.c(str, this));
    }

    public String outerHtml() {
        StringBuilder sb = new StringBuilder();
        for (f fVar : this) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(fVar.y());
        }
        return sb.toString();
    }

    public Elements parents() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next().C0());
        }
        return new Elements(linkedHashSet);
    }

    public Elements prepend(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().D0(str);
        }
        return this;
    }

    public Elements remove() {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().G();
        }
        return this;
    }

    public Elements removeAttr(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().H(str);
        }
        return this;
    }

    public Elements removeClass(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().G0(str);
        }
        return this;
    }

    public Elements select(String str) {
        return Selector.c(str, this);
    }

    public Elements tagName(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().L0(str);
        }
        return this;
    }

    public String text() {
        StringBuilder sb = new StringBuilder();
        for (f fVar : this) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(fVar.M0());
        }
        return sb.toString();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements toggleClass(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().O0(str);
        }
        return this;
    }

    public Elements traverse(sy3 sy3Var) {
        e96.j(sy3Var);
        qy3 qy3Var = new qy3(sy3Var);
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            qy3Var.a(it.next());
        }
        return this;
    }

    public Elements unwrap() {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().R();
        }
        return this;
    }

    public String val() {
        return size() > 0 ? first().P0() : "";
    }

    public Elements wrap(String str) {
        e96.h(str);
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().R0(str);
        }
        return this;
    }

    public Elements(int i) {
        super(i);
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            elements.add(it.next().p());
        }
        return elements;
    }

    public Elements(Collection<f> collection) {
        super(collection);
    }

    public Elements val(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().Q0(str);
        }
        return this;
    }

    public Elements(List<f> list) {
        super(list);
    }

    public Elements attr(String str, String str2) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().c0(str, str2);
        }
        return this;
    }

    public Elements(f... fVarArr) {
        super(Arrays.asList(fVarArr));
    }

    public Elements html(String str) {
        Iterator<f> it = iterator();
        while (it.hasNext()) {
            it.next().u0(str);
        }
        return this;
    }
}
