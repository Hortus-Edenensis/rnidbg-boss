package com.bytedance.sdk.component.iz.fx;

import android.content.Context;
import com.bytedance.sdk.component.iz.bg;
import com.bytedance.sdk.component.iz.d;
import com.bytedance.sdk.component.iz.gi;
import com.bytedance.sdk.component.iz.ja;
import com.bytedance.sdk.component.iz.sx;
import com.bytedance.sdk.component.iz.z;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ja f5145a;
    private gi b;
    private com.bytedance.sdk.component.iz.pn fx;
    private com.bytedance.sdk.component.iz.b iz;
    private com.bytedance.sdk.component.iz.nr n;
    private ExecutorService nr;
    private d pn;
    private sx u;
    private z x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ja f5146a;
        private gi b;
        private com.bytedance.sdk.component.iz.pn fx;
        private com.bytedance.sdk.component.iz.b iz;
        private com.bytedance.sdk.component.iz.nr n;
        private ExecutorService nr;
        private d pn;
        private sx u;
        private z x;

        public u u(com.bytedance.sdk.component.iz.nr nrVar) {
            this.n = nrVar;
            return this;
        }

        public u u(ExecutorService executorService) {
            this.nr = executorService;
            return this;
        }

        public u u(com.bytedance.sdk.component.iz.pn pnVar) {
            this.fx = pnVar;
            return this;
        }

        public pn u() {
            return new pn(this);
        }
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public com.bytedance.sdk.component.iz.nr a() {
        return this.n;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public com.bytedance.sdk.component.iz.pn b() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public ja fx() {
        return this.f5145a;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public d iz() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public z n() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public ExecutorService nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public gi pn() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public sx u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.iz.bg
    public com.bytedance.sdk.component.iz.b x() {
        return this.iz;
    }

    private pn(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz;
        this.n = uVar.n;
        this.x = uVar.x;
        this.f5145a = uVar.f5146a;
    }

    public static pn u(Context context) {
        return new u().u();
    }
}
