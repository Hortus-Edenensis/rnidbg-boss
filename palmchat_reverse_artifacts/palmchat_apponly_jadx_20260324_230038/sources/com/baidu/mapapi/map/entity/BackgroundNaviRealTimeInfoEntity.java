package com.baidu.mapapi.map.entity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BackgroundNaviRealTimeInfoEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f3732a;
    private double b;
    private double c;
    private double d;
    private int e;
    private double f;
    private double g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private int o;
    private int p;

    public int getMapLevel() {
        return this.m;
    }

    public int getNaviScene() {
        return this.p;
    }

    public int getNaviType() {
        return this.o;
    }

    public int getRotateAngle() {
        return this.h;
    }

    public int getRouteAngle() {
        return this.i;
    }

    public double getStCurRouteProjectPosX() {
        return this.f;
    }

    public double getStCurRouteProjectPosY() {
        return this.g;
    }

    public double getStCurStartPosX() {
        return this.c;
    }

    public double getStCurStartPosY() {
        return this.d;
    }

    public double getStPosX() {
        return this.f3732a;
    }

    public double getStPosY() {
        return this.b;
    }

    public int getnCurRouteShapeIdx() {
        return this.e;
    }

    public boolean isbGuide() {
        return this.l;
    }

    public boolean isbIsNearOrFarawayStatus() {
        return this.j;
    }

    public boolean isbMatchPosLinkIsUnverified() {
        return this.k;
    }

    public boolean isbRedLine() {
        return this.n;
    }

    public void setMapLevel(int i) {
        this.m = i;
    }

    public void setNaviScene(int i) {
        this.p = i;
    }

    public void setNaviType(int i) {
        this.o = i;
    }

    public void setRotateAngle(int i) {
        this.h = i;
    }

    public void setRouteAngle(int i) {
        this.i = i;
    }

    public void setStCurRouteProjectPosX(double d) {
        this.f = d;
    }

    public void setStCurRouteProjectPosY(double d) {
        this.g = d;
    }

    public void setStCurStartPosX(double d) {
        this.c = d;
    }

    public void setStCurStartPosY(double d) {
        this.d = d;
    }

    public void setStPosX(double d) {
        this.f3732a = d;
    }

    public void setStPosY(double d) {
        this.b = d;
    }

    public void setbGuide(boolean z) {
        this.l = z;
    }

    public void setbIsNearOrFarawayStatus(boolean z) {
        this.j = z;
    }

    public void setbMatchPosLinkIsUnverified(boolean z) {
        this.k = z;
    }

    public void setbRedLine(boolean z) {
        this.n = z;
    }

    public void setnCurRouteShapeIdx(int i) {
        this.e = i;
    }
}
