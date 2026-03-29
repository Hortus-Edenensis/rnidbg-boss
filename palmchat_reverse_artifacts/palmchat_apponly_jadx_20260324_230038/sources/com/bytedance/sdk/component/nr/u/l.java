package com.bytedance.sdk.component.nr.u;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends n implements Cloneable {
    static final List<mv> n = com.bytedance.sdk.component.nr.u.nr.jk.u(mv.HTTP_2, mv.HTTP_1_1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<mv> f5161a;
    public long b;
    public TimeUnit fx;
    public long iz;
    public Set<String> jk;
    public long nr;
    public TimeUnit pn;
    public com.bytedance.sdk.component.nr.u.u.u.u t;
    public List<a> u;
    public TimeUnit x;

    public l() {
        this(new u());
    }

    public u nr() {
        return new u(this);
    }

    public b u() {
        return null;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<mv> f5162a;
        public TimeUnit b;
        public long fx;
        public TimeUnit iz;
        public Set<String> jk;
        public TimeUnit n;
        public com.bytedance.sdk.component.nr.u.u.u.u nr;
        public long pn;
        public Bundle t;
        public final List<a> u;
        public long x;

        public u() {
            this.u = new ArrayList();
            this.fx = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.b = timeUnit;
            this.pn = 10000L;
            this.iz = timeUnit;
            this.x = 10000L;
            this.n = timeUnit;
        }

        public u fx(long j, TimeUnit timeUnit) {
            this.x = j;
            this.n = timeUnit;
            return this;
        }

        public u nr(long j, TimeUnit timeUnit) {
            this.pn = j;
            this.iz = timeUnit;
            return this;
        }

        public u u(long j, TimeUnit timeUnit) {
            this.fx = j;
            this.b = timeUnit;
            return this;
        }

        public u u(com.bytedance.sdk.component.nr.u.u.u.u uVar) {
            this.nr = uVar;
            return this;
        }

        public u u(a aVar) {
            this.u.add(aVar);
            return this;
        }

        public u u(Set<String> set) {
            this.jk = set;
            return this;
        }

        public u u(List<mv> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(mv.HTTP_1_1)) {
                if (!arrayList.contains(mv.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(mv.SPDY_3);
                        this.f5162a = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
        }

        public u(String str) {
            this.u = new ArrayList();
            this.fx = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.b = timeUnit;
            this.pn = 10000L;
            this.iz = timeUnit;
            this.x = 10000L;
            this.n = timeUnit;
            this.f5162a = l.n;
        }

        public u u(Bundle bundle) {
            this.t = bundle;
            return this;
        }

        public l u() {
            if (com.bytedance.sdk.component.nr.u.u.u.u().nr()) {
                return com.bytedance.sdk.component.nr.u.u.u.nr(this);
            }
            return com.bytedance.sdk.component.nr.u.u.u.u(this);
        }

        public u(l lVar) {
            this.u = new ArrayList();
            this.fx = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.b = timeUnit;
            this.pn = 10000L;
            this.iz = timeUnit;
            this.x = 10000L;
            this.n = timeUnit;
            this.fx = lVar.nr;
            this.b = lVar.fx;
            this.pn = lVar.b;
            this.iz = lVar.pn;
            this.x = lVar.iz;
            this.n = lVar.x;
            this.f5162a = lVar.f5161a;
            this.jk = lVar.jk;
        }
    }

    public l(u uVar) {
        this.nr = uVar.fx;
        this.b = uVar.pn;
        this.iz = uVar.x;
        this.fx = uVar.b;
        this.pn = uVar.iz;
        this.x = uVar.n;
        this.u = uVar.u;
        this.f5161a = uVar.f5162a;
        this.jk = uVar.jk;
        this.t = uVar.nr;
    }

    public nr u(s sVar) {
        return null;
    }
}
