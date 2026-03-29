package com.bytedance.sdk.component.n.nr.u;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    public abstract List<com.bytedance.sdk.component.n.u.nr> nr(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list, String str);

    public abstract boolean nr(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar);

    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list, String str) {
        if (com.bytedance.sdk.component.n.nr.fx.u.u(i)) {
            return nr(i, nrVar, z, list, str);
        }
        if (u(nrVar)) {
            return nr(i, nrVar, z, list, str);
        }
        return null;
    }

    public abstract boolean u(com.bytedance.sdk.component.n.u.nr nrVar);

    public abstract boolean u(String str);

    public boolean u(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (com.bytedance.sdk.component.n.nr.fx.u.u(i)) {
            return u(str);
        }
        if (u(nrVar)) {
            return nr(i, str, nrVar);
        }
        return false;
    }
}
