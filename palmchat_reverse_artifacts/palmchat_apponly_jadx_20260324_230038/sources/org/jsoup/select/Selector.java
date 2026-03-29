package org.jsoup.select;

import defpackage.e96;
import defpackage.tg0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Selector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19835a;
    public final f b;

    /* JADX INFO: compiled from: SearchBox */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    public Selector(String str, f fVar) {
        e96.j(str);
        String strTrim = str.trim();
        e96.h(strTrim);
        e96.j(fVar);
        this.f19835a = c.s(strTrim);
        this.b = fVar;
    }

    public static Elements a(Collection<f> collection, Collection<f> collection2) {
        boolean z;
        Elements elements = new Elements();
        for (f fVar : collection) {
            Iterator<f> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (fVar.equals(it.next())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                elements.add(fVar);
            }
        }
        return elements;
    }

    public static Elements c(String str, Iterable<f> iterable) {
        e96.h(str);
        e96.j(iterable);
        b bVarS = c.s(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            for (f fVar : e(bVarS, it.next())) {
                if (!identityHashMap.containsKey(fVar)) {
                    arrayList.add(fVar);
                    identityHashMap.put(fVar, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<f>) arrayList);
    }

    public static Elements d(String str, f fVar) {
        return new Selector(str, fVar).b();
    }

    public static Elements e(b bVar, f fVar) {
        return new Selector(bVar, fVar).b();
    }

    public final Elements b() {
        return tg0.a(this.f19835a, this.b);
    }

    public Selector(b bVar, f fVar) {
        e96.j(bVar);
        e96.j(fVar);
        this.f19835a = bVar;
        this.b = fVar;
    }
}
