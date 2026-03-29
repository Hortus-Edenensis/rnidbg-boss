package com.bytedance.sdk.component.u;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.u.t;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    mv f5169a;
    n b;
    boolean iz;
    s jk;
    boolean k;
    t.nr my;
    boolean n;
    u nr;
    private Looper o;
    Context pn;
    boolean s;
    com.bytedance.sdk.component.mv.fx u;
    boolean x;
    String fx = "IESJSBridge";
    String t = "host";
    final Set<String> l = new LinkedHashSet();
    final Set<String> mv = new LinkedHashSet();

    public jk(com.bytedance.sdk.component.mv.fx fxVar) {
        this.u = fxVar;
    }

    private void b() {
        if ((this.u == null && !this.s && this.nr == null) || ((TextUtils.isEmpty(this.fx) && this.u != null) || this.b == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public Looper fx() {
        return this.o;
    }

    public Context getContext() {
        return this.pn;
    }

    public jk nr(boolean z) {
        this.x = z;
        return this;
    }

    public jk u(u uVar) {
        this.nr = uVar;
        return this;
    }

    public o nr() {
        b();
        return new o(this);
    }

    public jk u(String str) {
        this.fx = str;
        return this;
    }

    public jk u(l lVar) {
        this.b = n.u(lVar);
        return this;
    }

    public jk u(boolean z) {
        this.iz = z;
        return this;
    }

    public jk u() {
        this.k = true;
        return this;
    }

    public jk() {
    }
}
