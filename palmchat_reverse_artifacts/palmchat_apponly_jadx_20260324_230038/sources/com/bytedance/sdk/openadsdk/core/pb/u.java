package com.bytedance.sdk.openadsdk.core.pb;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public int c;
    public int dw;
    public List<String> s;
    public String u;
    public int nr = 1;
    public int fx = 2;
    public int b = 1;
    public int pn = 0;
    public int iz = 1;
    public int x = 3;
    public int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5355a = 0;
    public int jk = 0;
    public int t = TTAdConstant.STYLE_SIZE_RADIO_3_2;
    public int l = 2000;
    public boolean mv = false;
    public int k = 2;
    public int my = 100;
    public int o = 0;
    public boolean sx = false;
    public boolean bg = false;
    public long bq = 0;

    private u() {
    }

    public static u u() {
        return new u();
    }

    public u a(int i) {
        this.fx = i;
        return this;
    }

    public u b(int i) {
        this.jk = i;
        return this;
    }

    public int fx() {
        return this.dw;
    }

    public u iz(int i) {
        this.n = i;
        return this;
    }

    public u jk(int i) {
        this.b = i;
        return this;
    }

    public u k(int i) {
        this.o = i;
        return this;
    }

    public u l(int i) {
        this.iz = i;
        return this;
    }

    public u mv(int i) {
        this.k = i;
        return this;
    }

    public u n(int i) {
        this.nr = i;
        return this;
    }

    public int nr() {
        return this.c;
    }

    public u pn(int i) {
        this.t = i;
        return this;
    }

    public u s(int i) {
        this.my = i;
        return this;
    }

    public u t(int i) {
        this.pn = i;
        return this;
    }

    public u x(int i) {
        this.f5355a = i;
        return this;
    }

    public u fx(int i) {
        this.l = i;
        return this;
    }

    public u nr(int i) {
        this.dw = i;
        return this;
    }

    public u u(int i) {
        this.c = i;
        return this;
    }

    public u fx(boolean z) {
        this.mv = z;
        return this;
    }

    public u nr(boolean z) {
        this.bg = z;
        return this;
    }

    public u u(boolean z) {
        this.sx = z;
        return this;
    }

    public u u(long j) {
        this.bq = j;
        return this;
    }

    public u u(String str) {
        this.u = str;
        return this;
    }
}
