package com.amap.api.maps2d.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MyTrafficStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3104a = -16735735;
    private int b = -35576;
    private int c = -1441006;
    private int d = -7208950;

    public int getCongestedColor() {
        return this.c;
    }

    public int getSeriousCongestedColor() {
        return this.d;
    }

    public int getSlowColor() {
        return this.b;
    }

    public int getSmoothColor() {
        return this.f3104a;
    }

    public void setCongestedColor(int i) {
        this.c = i;
    }

    public void setSeriousCongestedColor(int i) {
        this.d = i;
    }

    public void setSlowColor(int i) {
        this.b = i;
    }

    public void setSmoothColor(int i) {
        this.f3104a = i;
    }
}
