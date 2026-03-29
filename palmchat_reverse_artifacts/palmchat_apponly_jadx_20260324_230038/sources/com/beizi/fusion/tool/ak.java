package com.beizi.fusion.tool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ak f4715a;
    private Map<String, Long> b = new HashMap();

    public static ak a() {
        if (f4715a == null) {
            synchronized (ak.class) {
                if (f4715a == null) {
                    f4715a = new ak();
                }
            }
        }
        return f4715a;
    }

    public long b(String str) {
        if (this.b.containsKey(str)) {
            return this.b.get(str).longValue();
        }
        return 0L;
    }

    public void a(String str, long j) {
        this.b.put(str, Long.valueOf(j));
    }

    public void a(String str) {
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }
}
