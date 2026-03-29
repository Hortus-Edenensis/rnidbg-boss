package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
    private double b;
    private int fx;
    private double iz;
    private String nr;
    private String pn;
    private int u;
    private double x;

    public double b() {
        return this.b;
    }

    public int fx() {
        return this.fx;
    }

    public double iz() {
        return this.iz;
    }

    public boolean n() {
        return !TextUtils.isEmpty(this.pn);
    }

    public String nr() {
        return this.nr;
    }

    public String pn() {
        return this.pn;
    }

    public int u() {
        return this.u;
    }

    public double x() {
        return this.x;
    }

    public void fx(double d) {
        this.x = d;
    }

    public void nr(int i) {
        this.fx = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public void nr(String str) {
        this.pn = str;
    }

    public void u(String str) {
        this.nr = str;
    }

    public void nr(double d) {
        this.iz = d;
    }

    public void u(double d) {
        this.b = d;
    }
}
