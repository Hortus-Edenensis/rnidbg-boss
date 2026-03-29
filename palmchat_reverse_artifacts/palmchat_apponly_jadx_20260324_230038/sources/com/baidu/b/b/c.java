package com.baidu.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3308a;
    private Map b = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        List a();
    }

    public c(a aVar) {
        this.f3308a = aVar;
        for (com.baidu.b.b.a aVar2 : aVar.a()) {
            this.b.put(aVar2.a(), aVar2);
        }
    }

    public List a() {
        return new ArrayList(this.b.values());
    }
}
