package com.bytedance.sdk.component.iz.fx;

import com.bytedance.sdk.component.iz.my;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b<T> implements my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5140a;
    private T b;
    private T fx;
    private int iz;
    private com.bytedance.sdk.component.iz.n jk;
    private boolean n;
    private String nr;
    private int pn;
    private int t;
    private String u;
    private Map<String, String> x;

    @Override // com.bytedance.sdk.component.iz.my
    public String getCacheKey() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getFileSize() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public Map<String, String> getHeaders() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getHeight() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public com.bytedance.sdk.component.iz.n getHttpTime() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public T getOriginResult() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public T getResult() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public String getUrl() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public int getWidth() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public boolean isGif() {
        return this.n;
    }

    @Override // com.bytedance.sdk.component.iz.my
    public boolean isLocal() {
        return this.f5140a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.iz.my
    public void setResult(Object obj) {
        this.b = this.fx;
        this.fx = obj;
    }

    public b u(fx fxVar, T t) {
        this.fx = t;
        this.u = fxVar.getMemoryCacheKey();
        this.nr = fxVar.getUrl();
        this.pn = fxVar.getWidth();
        this.iz = fxVar.getHeight();
        this.f5140a = fxVar.n();
        this.jk = fxVar.a();
        this.t = fxVar.jk();
        return this;
    }

    public b u(fx fxVar, T t, Map<String, String> map, boolean z) {
        this.x = map;
        this.n = z;
        return u(fxVar, t);
    }
}
