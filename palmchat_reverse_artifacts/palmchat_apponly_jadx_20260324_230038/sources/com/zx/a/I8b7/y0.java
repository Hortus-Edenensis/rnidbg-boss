package com.zx.a.I8b7;

import com.zx.module.base.Listener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class y0 implements Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<z0>> f16888a = new HashMap();

    public synchronized void a(String str, z0 z0Var) {
        if (!this.f16888a.containsKey(str)) {
            this.f16888a.put(str, new HashSet());
        }
        this.f16888a.get(str).add(z0Var);
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(String str, String str2) {
        Set<z0> set = this.f16888a.get(str);
        if (set != null) {
            Iterator<z0> it = set.iterator();
            while (it.hasNext()) {
                it.next().a(str2);
            }
        }
    }
}
