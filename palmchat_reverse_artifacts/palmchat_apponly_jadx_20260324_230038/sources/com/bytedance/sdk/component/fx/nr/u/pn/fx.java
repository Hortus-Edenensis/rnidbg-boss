package com.bytedance.sdk.component.fx.nr.u.pn;

import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f5135a;
    public final com.bytedance.sdk.component.fx.u.iz n;
    public final com.bytedance.sdk.component.fx.u.iz x;
    public static final com.bytedance.sdk.component.fx.u.iz u = com.bytedance.sdk.component.fx.u.iz.u(":");
    public static final com.bytedance.sdk.component.fx.u.iz nr = com.bytedance.sdk.component.fx.u.iz.u(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.fx.u.iz fx = com.bytedance.sdk.component.fx.u.iz.u(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.component.fx.u.iz b = com.bytedance.sdk.component.fx.u.iz.u(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.fx.u.iz pn = com.bytedance.sdk.component.fx.u.iz.u(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.component.fx.u.iz iz = com.bytedance.sdk.component.fx.u.iz.u(Header.TARGET_AUTHORITY_UTF8);

    public fx(String str, String str2) {
        this(com.bytedance.sdk.component.fx.u.iz.u(str), com.bytedance.sdk.component.fx.u.iz.u(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof fx) {
            fx fxVar = (fx) obj;
            if (this.x.equals(fxVar.x) && this.n.equals(fxVar.n)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.x.hashCode() + 527) * 31) + this.n.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.fx.nr.u.fx.u("%s: %s", this.x.u(), this.n.u());
    }

    public fx(com.bytedance.sdk.component.fx.u.iz izVar, String str) {
        this(izVar, com.bytedance.sdk.component.fx.u.iz.u(str));
    }

    public fx(com.bytedance.sdk.component.fx.u.iz izVar, com.bytedance.sdk.component.fx.u.iz izVar2) {
        this.x = izVar;
        this.n = izVar2;
        this.f5135a = izVar.x() + 32 + izVar2.x();
    }
}
