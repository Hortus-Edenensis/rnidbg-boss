package com.bytedance.sdk.component.iz.nr;

import com.bytedance.sdk.component.iz.n;
import com.bytedance.sdk.component.iz.x;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b<T> implements x {
    private String b;
    private T fx;
    private int nr;
    private n pn;
    Map<String, String> u;

    public b(int i, T t, String str) {
        this.nr = i;
        this.fx = t;
        this.b = str;
    }

    @Override // com.bytedance.sdk.component.iz.x
    public String b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.x
    public T fx() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.x
    public int nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.x
    public Map<String, String> pn() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.iz.x
    public n u() {
        return this.pn;
    }

    public void u(n nVar) {
        this.pn = nVar;
    }

    public b(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.u = map;
    }
}
