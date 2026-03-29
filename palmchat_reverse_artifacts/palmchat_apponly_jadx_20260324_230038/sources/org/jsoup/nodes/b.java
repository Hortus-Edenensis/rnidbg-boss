package org.jsoup.nodes;

import defpackage.e96;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class b implements Iterable<a>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, a> f19830a = null;

    public void a(b bVar) {
        if (bVar.size() == 0) {
            return;
        }
        if (this.f19830a == null) {
            this.f19830a = new LinkedHashMap<>(bVar.size());
        }
        this.f19830a.putAll(bVar.f19830a);
    }

    public List<a> c() {
        if (this.f19830a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f19830a.size());
        Iterator<Map.Entry<String, a>> it = this.f19830a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b clone() {
        if (this.f19830a == null) {
            return new b();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f19830a = new LinkedHashMap<>(this.f19830a.size());
            for (a aVar : this) {
                bVar.f19830a.put(aVar.getKey(), aVar.clone());
            }
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String e(String str) {
        a aVar;
        e96.h(str);
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        return (linkedHashMap == null || (aVar = linkedHashMap.get(str)) == null) ? "" : aVar.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        LinkedHashMap<String, a> linkedHashMap2 = ((b) obj).f19830a;
        if (linkedHashMap != null) {
            if (linkedHashMap.equals(linkedHashMap2)) {
                return true;
            }
        } else if (linkedHashMap2 == null) {
            return true;
        }
        return false;
    }

    public String f(String str) {
        e96.h(str);
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap == null) {
            return "";
        }
        for (String str2 : linkedHashMap.keySet()) {
            if (str2.equalsIgnoreCase(str)) {
                return this.f19830a.get(str2).getValue();
            }
        }
        return "";
    }

    public boolean g(String str) {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        return linkedHashMap != null && linkedHashMap.containsKey(str);
    }

    public boolean h(String str) {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap == null) {
            return false;
        }
        Iterator<String> it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap != null) {
            return linkedHashMap.hashCode();
        }
        return 0;
    }

    public String i() {
        StringBuilder sb = new StringBuilder();
        try {
            j(sb, new Document("").V0());
            return sb.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        return (linkedHashMap == null || linkedHashMap.isEmpty()) ? Collections.emptyList().iterator() : this.f19830a.values().iterator();
    }

    public void j(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap == null) {
            return;
        }
        Iterator<Map.Entry<String, a>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            appendable.append(" ");
            value.f(appendable, outputSettings);
        }
    }

    public void k(String str, String str2) {
        l(new a(str, str2));
    }

    public void l(a aVar) {
        e96.j(aVar);
        if (this.f19830a == null) {
            this.f19830a = new LinkedHashMap<>(2);
        }
        this.f19830a.put(aVar.getKey(), aVar);
    }

    public void m(String str) {
        e96.h(str);
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap == null) {
            return;
        }
        for (String str2 : linkedHashMap.keySet()) {
            if (str2.equalsIgnoreCase(str)) {
                this.f19830a.remove(str2);
            }
        }
    }

    public int size() {
        LinkedHashMap<String, a> linkedHashMap = this.f19830a;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public String toString() {
        return i();
    }
}
