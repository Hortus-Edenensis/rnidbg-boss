package com.baidu.mapapi.map.entity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BackgroundNaviLocEntity {
    private float b;
    private float c;
    private float f;
    private float g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3731a = -1;
    private double d = -1.0d;
    private double e = -1.0d;
    private double h = -1.0d;
    private double i = -1.0d;

    public int getCurRouteShapeIdx() {
        return this.f3731a;
    }

    public float getGpsDirection() {
        return this.b;
    }

    public double getGpsLatitude() {
        return this.e;
    }

    public double getGpsLongitude() {
        return this.d;
    }

    public float getGpsSpeed() {
        return this.c;
    }

    public float getPostDirection() {
        return this.f;
    }

    public double getPostLatitude() {
        return this.i;
    }

    public double getPostLongitude() {
        return this.h;
    }

    public float getPostSpeed() {
        return this.g;
    }

    public boolean isValid() {
        return (this.e == -1.0d || this.d == -1.0d || this.i == -1.0d || this.h == -1.0d) ? false : true;
    }

    public void setCurRouteShapeIdx(int i) {
        this.f3731a = i;
    }

    public void setGpsDirection(float f) {
        this.b = f;
    }

    public void setGpsLatitude(double d) {
        this.e = d;
    }

    public void setGpsLongitude(double d) {
        this.d = d;
    }

    public void setGpsSpeed(float f) {
        this.c = f;
    }

    public void setPostDirection(float f) {
        this.f = f;
    }

    public void setPostLatitude(double d) {
        this.i = d;
    }

    public void setPostLongitude(double d) {
        this.h = d;
    }

    public void setPostSpeed(float f) {
        this.g = f;
    }
}
