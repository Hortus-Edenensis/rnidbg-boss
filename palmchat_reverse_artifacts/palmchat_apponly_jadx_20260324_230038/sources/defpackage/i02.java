package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class i02 {
    public static i02 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, jq> f18078a = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        jq a();
    }

    public static i02 b() {
        if (b == null) {
            synchronized (i02.class) {
                if (b == null) {
                    b = new i02();
                }
            }
        }
        return b;
    }

    public synchronized jq a(String str, a aVar) {
        jq jqVar = this.f18078a.get(str);
        if (jqVar != null) {
            return jqVar;
        }
        if (aVar == null) {
            return null;
        }
        jq jqVarA = aVar.a();
        this.f18078a.put(str, jqVarA);
        return jqVarA;
    }

    public synchronized void c(String str) {
        this.f18078a.remove(str);
    }
}
