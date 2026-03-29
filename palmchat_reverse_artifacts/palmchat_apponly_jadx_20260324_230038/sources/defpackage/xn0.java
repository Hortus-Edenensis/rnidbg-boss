package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xn0 {
    public static final xn0 b = new xn0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Long> f22011a = new HashMap();

    public static xn0 d() {
        return b;
    }

    public void a() {
        this.f22011a.clear();
    }

    public boolean b(String str) {
        return this.f22011a.containsKey(str);
    }

    public Long c(String str) {
        return this.f22011a.get(str);
    }

    public void e(String str, long j) {
        this.f22011a.put(str, Long.valueOf(j));
    }
}
