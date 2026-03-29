package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.PrivilegedAction;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3915a = "org.spongycastle.asn1.allow_unsafe_integer";

    @Override // java.security.PrivilegedAction
    public final Object run() {
        Map map = (Map) c.f3916a.get();
        return map != null ? map.get(this.f3915a) : System.getProperty(this.f3915a);
    }
}
