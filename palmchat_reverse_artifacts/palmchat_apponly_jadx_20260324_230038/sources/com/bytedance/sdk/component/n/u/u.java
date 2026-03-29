package com.bytedance.sdk.component.n.u;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.n.nr.b.nr.u f5159a;
    private Context b;
    private String fx;
    private com.bytedance.sdk.component.n.nr.b.nr.u iz;
    private boolean jk;
    private AtomicBoolean l;
    private int mv;
    private com.bytedance.sdk.component.n.nr.b.nr.u n;
    private jk nr;
    private com.bytedance.sdk.component.n.nr.b.nr.u pn;
    private int s;
    private b t;
    private iz u;
    private com.bytedance.sdk.component.n.nr.b.nr.u x;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.n.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0226u {
        private com.bytedance.sdk.component.n.nr.b.nr.u b;
        private com.bytedance.sdk.component.n.nr.b.nr.u fx;
        private boolean iz;
        private String l;
        private Context mv;
        private iz n;
        private com.bytedance.sdk.component.n.nr.b.nr.u nr;
        private com.bytedance.sdk.component.n.nr.b.nr.u pn;
        private jk u;
        private b x;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f5160a = new AtomicBoolean(false);
        private int jk = 5000;
        private int t = 10;

        public C0226u fx(com.bytedance.sdk.component.n.nr.b.nr.u uVar) {
            this.b = uVar;
            return this;
        }

        public C0226u nr(boolean z) {
            this.iz = z;
            return this;
        }

        public C0226u u(Context context) {
            this.mv = context;
            return this;
        }

        public C0226u nr(com.bytedance.sdk.component.n.nr.b.nr.u uVar) {
            this.fx = uVar;
            return this;
        }

        public C0226u u(String str) {
            this.l = str;
            return this;
        }

        public C0226u u(boolean z) {
            this.f5160a.set(z);
            return this;
        }

        public C0226u u(iz izVar) {
            this.n = izVar;
            return this;
        }

        public C0226u u(b bVar) {
            this.x = bVar;
            return this;
        }

        public C0226u u(com.bytedance.sdk.component.n.nr.b.nr.u uVar) {
            this.nr = uVar;
            return this;
        }

        public u u() {
            u uVar = new u();
            uVar.nr = this.u;
            uVar.pn = this.nr;
            uVar.iz = this.fx;
            uVar.x = this.b;
            uVar.n = this.pn;
            uVar.jk = this.iz;
            uVar.t = this.x;
            uVar.u = this.n;
            uVar.l = this.f5160a;
            uVar.fx = this.l;
            uVar.b = this.mv;
            uVar.s = this.t;
            uVar.mv = this.jk;
            return uVar;
        }
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public com.bytedance.sdk.component.n.nr.b.nr.u a() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public Context getContext() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public com.bytedance.sdk.component.n.nr.b.nr.u iz() {
        return this.f5159a;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public jk jk() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public com.bytedance.sdk.component.n.nr.b.nr.u n() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public String pn() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public boolean t() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public com.bytedance.sdk.component.n.nr.b.nr.u x() {
        return this.pn;
    }

    private u() {
        this.l = new AtomicBoolean(false);
        this.mv = 200;
        this.s = 10;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public b b() {
        return this.t;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public boolean fx() {
        return this.l.get();
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public iz nr() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public com.bytedance.sdk.component.n.nr.b.nr.u u() {
        return this.n;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public void u(iz izVar) {
        this.u = izVar;
    }

    @Override // com.bytedance.sdk.component.n.u.pn
    public void u(boolean z) {
        this.l.set(z);
    }
}
