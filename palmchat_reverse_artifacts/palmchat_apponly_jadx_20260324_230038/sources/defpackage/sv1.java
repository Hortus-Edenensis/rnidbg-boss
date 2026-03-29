package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20850a = 0;
    public LinkedHashMap<Integer, Integer> b;

    public sv1() {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        this.b = linkedHashMap;
        linkedHashMap.put(1, 4);
    }

    public Map.Entry<Integer, Integer> a() {
        Iterator<Map.Entry<Integer, Integer>> it = this.b.entrySet().iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("preRequestTime=" + this.f20850a);
        sb.append(",requestTime=" + this.b);
        sb.append("]");
        return sb.toString();
    }

    public sv1(boolean z) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        this.b = linkedHashMap;
        if (z) {
            linkedHashMap.put(1, 3);
        } else {
            linkedHashMap.put(1, 4);
        }
    }
}
