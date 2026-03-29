package com.bytedance.sdk.openadsdk.core.nr.u.u;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f5348a;
    protected com.bytedance.sdk.openadsdk.core.video.nr.nr b;
    protected boolean fx;
    private Map<String, Object> iz;
    private bc l;
    private Context mv;
    private com.bytedance.sdk.openadsdk.dw.u.nr.u.u my;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx o;
    private int pn;
    private long sx;
    private u.InterfaceC0278u t;
    boolean u;
    private String x;
    private boolean n = false;
    private int jk = Integer.MIN_VALUE;
    private boolean s = false;
    private int k = -1;
    boolean nr = true;

    public String a() {
        return this.x;
    }

    public boolean b() {
        return this.u;
    }

    public int fx() {
        return this.k;
    }

    public Context getContext() {
        return this.mv;
    }

    public com.bytedance.sdk.openadsdk.core.l.nr.fx iz() {
        return this.o;
    }

    public boolean jk() {
        return this.n;
    }

    public com.bytedance.sdk.openadsdk.core.video.nr.nr l() {
        return this.b;
    }

    public Map<String, Object> n() {
        return this.iz;
    }

    public boolean nr() {
        return this.s;
    }

    public com.bytedance.sdk.openadsdk.dw.u.nr.u.u pn() {
        return this.my;
    }

    public boolean t() {
        return this.fx;
    }

    public u.InterfaceC0278u u() {
        return this.t;
    }

    public int x() {
        return this.pn;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void fx(boolean z) {
        this.nr = z;
    }

    public void nr(boolean z) {
        this.u = z;
    }

    public void u(u.InterfaceC0278u interfaceC0278u) {
        this.t = interfaceC0278u;
    }

    public void nr(int i) {
        this.pn = i;
    }

    public void u(bc bcVar) {
        this.l = bcVar;
    }

    public void u(Context context) {
        this.mv = context;
    }

    public void u(boolean z) {
        this.s = z;
    }

    public void u(int i) {
        this.k = i;
    }

    public void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        this.my = uVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar) {
        this.o = fxVar;
    }

    public void u(Map<String, Object> map) {
        this.iz = map;
    }

    public void u(String str) {
        this.x = str;
    }

    public void u(Object obj) {
        this.f5348a = obj;
    }

    public void u(long j) {
        this.sx = j;
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.b = nrVar;
    }
}
