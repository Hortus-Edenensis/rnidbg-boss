package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class xy2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f22080a = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        String a(j jVar);
    }

    public static Map<String, a> a() {
        return f22080a;
    }

    public static void b(String str, a aVar) {
        f22080a.put(str, aVar);
    }
}
