package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5262a;
    private com.bytedance.sdk.openadsdk.core.gi.u.nr b;
    private com.bytedance.sdk.component.a.nr iz;
    private long jk;
    private boolean k;
    private Map<String, String> l;
    private String mv;
    private com.bytedance.sdk.openadsdk.my.fx.nr.nr my;
    private String o;
    private boolean s;
    private long sx;
    private long t;
    private boolean pn = false;
    private boolean x = false;
    private boolean n = false;
    private AtomicBoolean bg = new AtomicBoolean(false);

    public n(bc bcVar, boolean z) {
        this.nr = bcVar;
        this.s = z;
    }

    public Map<String, String> a() {
        return this.l;
    }

    public com.bytedance.sdk.openadsdk.core.gi.u.nr b() {
        return this.b;
    }

    public void fx(long j) {
        this.jk = j;
    }

    public boolean iz() {
        return this.x;
    }

    public boolean jk() {
        return this.n;
    }

    public boolean k() {
        return this.bg.get();
    }

    public com.bytedance.sdk.openadsdk.my.fx.nr.nr l() {
        return this.my;
    }

    public String mv() {
        return this.o;
    }

    public long n() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public bc nr() {
        return this.nr;
    }

    public boolean pn() {
        return this.pn;
    }

    public long s() {
        return this.sx;
    }

    public boolean t() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public int u() {
        return this.u;
    }

    public long x() {
        return this.f5262a;
    }

    public void b(long j) {
        this.t = j;
    }

    public void fx(boolean z) {
        this.n = z;
    }

    public void nr(boolean z) {
        this.x = z;
    }

    public void pn(long j) {
        this.sx = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public void u(int i) {
        this.u = i;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void nr(long j) {
        this.f5262a = j;
    }

    public void pn(boolean z) {
        this.bg.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public void u(bc bcVar) {
        this.nr = bcVar;
    }

    public void nr(String str) {
        this.o = str;
    }

    public void u(boolean z) {
        this.pn = z;
    }

    public void u(com.bytedance.sdk.component.a.nr nrVar) {
        this.iz = nrVar;
    }

    public void u(Map<String, String> map) {
        this.l = map;
    }

    public void u(String str) {
        this.mv = str;
    }

    public n(com.bytedance.sdk.openadsdk.core.gi.u.nr nrVar, bc bcVar, boolean z) {
        this.b = nrVar;
        this.nr = bcVar;
        this.s = z;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        this.my = nrVar;
    }
}
