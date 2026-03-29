package com.bytedance.sdk.openadsdk.core.kj;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nr.b;
import com.ss.bytertc.engine.type.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    private String bq;
    private boolean k;
    private View mv;
    private String q;
    private int qq;
    private View s;
    private String sx;
    private float u = -1.0f;
    private float nr = -1.0f;
    private float fx = -1.0f;
    private float b = -1.0f;
    private long pn = -1;
    private long iz = -1;
    private int x = -1;
    private int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5310a = ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE;
    private boolean jk = true;
    private int t = 0;
    private int l = 0;
    private byte my = 0;
    private boolean o = false;
    private int bg = -1;
    private SparseArray<b.u> dw = new SparseArray<>();
    private List<Integer> c = new ArrayList();
    private boolean kj = false;

    public View a() {
        return this.s;
    }

    public int b() {
        return this.x;
    }

    public float bg() {
        return this.b;
    }

    public String bq() {
        return this.sx;
    }

    public String c() {
        return this.bq;
    }

    public int dw() {
        return this.bg;
    }

    public boolean fx() {
        return this.qq == 2;
    }

    public int iz() {
        return this.f5310a;
    }

    public int jk() {
        return this.t;
    }

    public long k() {
        return this.iz;
    }

    public SparseArray<b.u> l() {
        return this.dw;
    }

    public List<Integer> mv() {
        return this.c;
    }

    public float my() {
        return this.u;
    }

    public View n() {
        return this.mv;
    }

    public byte nr() {
        return this.my;
    }

    public float o() {
        return this.nr;
    }

    public int pn() {
        return this.n;
    }

    public String q() {
        return this.q;
    }

    public long s() {
        return this.pn;
    }

    public float sx() {
        return this.fx;
    }

    public int t() {
        return this.l;
    }

    public void u(boolean z) {
        this.kj = z;
    }

    public boolean x() {
        return this.jk;
    }

    public void b(int i) {
        this.f5310a = i;
    }

    public void fx(int i) {
        this.n = i;
    }

    public void iz(int i) {
        this.l = i;
    }

    public void nr(int i) {
        this.x = i;
    }

    public void pn(int i) {
        this.t = i;
    }

    public boolean u() {
        return this.kj;
    }

    public void x(int i) {
        this.bg = i;
    }

    public void b(float f) {
        this.b = f;
    }

    public void fx(float f) {
        this.fx = f;
    }

    public void nr(boolean z) {
        this.jk = z;
    }

    public void u(byte b) {
        this.my = b;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public void fx(boolean z) {
        this.k = z;
    }

    public void nr(View view) {
        this.s = (View) new WeakReference(view).get();
    }

    public void u(int i) {
        this.qq = i;
    }

    public void fx(String str) {
        this.q = str;
    }

    public void nr(long j) {
        this.iz = j;
    }

    public void u(View view) {
        this.mv = (View) new WeakReference(view).get();
    }

    public void nr(float f) {
        this.nr = f;
    }

    public void u(SparseArray<b.u> sparseArray) {
        this.dw = sparseArray;
    }

    public void nr(String str) {
        this.bq = str;
    }

    public void u(long j) {
        this.pn = j;
    }

    public void u(float f) {
        this.u = f;
    }

    public void u(String str) {
        this.sx = str;
    }
}
