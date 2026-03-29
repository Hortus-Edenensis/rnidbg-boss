package com.beizi.ad.internal.splash;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SplashUnifiedActionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4443a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private double j;
    private int k;
    private int l;
    private int m;
    public double maxAccY;

    public int getClickType() {
        return this.f4443a;
    }

    public String getDownRawX() {
        return this.d;
    }

    public String getDownRawY() {
        return this.e;
    }

    public String getDownX() {
        return this.b;
    }

    public String getDownY() {
        return this.c;
    }

    public double getMaxAccY() {
        return this.maxAccY;
    }

    public double getMaxAccZ() {
        return this.j;
    }

    public int getTurnX() {
        return this.k;
    }

    public int getTurnY() {
        return this.l;
    }

    public int getTurnZ() {
        return this.m;
    }

    public String getUpRawX() {
        return this.h;
    }

    public String getUpRawY() {
        return this.i;
    }

    public String getUpX() {
        return this.f;
    }

    public String getUpY() {
        return this.g;
    }

    public void setClickType(int i) {
        this.f4443a = i;
    }

    public void setDownRawX(String str) {
        this.d = str;
    }

    public void setDownRawY(String str) {
        this.e = str;
    }

    public void setDownX(String str) {
        this.b = str;
    }

    public void setDownY(String str) {
        this.c = str;
    }

    public void setMaxAccY(double d) {
        this.maxAccY = d;
    }

    public void setMaxAccZ(double d) {
        this.j = d;
    }

    public void setTurnX(int i) {
        this.k = i;
    }

    public void setTurnY(int i) {
        this.l = i;
    }

    public void setTurnZ(int i) {
        this.m = i;
    }

    public void setUpRawX(String str) {
        this.h = str;
    }

    public void setUpRawY(String str) {
        this.i = str;
    }

    public void setUpX(String str) {
        this.f = str;
    }

    public void setUpY(String str) {
        this.g = str;
    }

    public String toString() {
        return "SplashUnifiedActionData{clickType=" + this.f4443a + ", downX='" + this.b + "', downY='" + this.c + "', downRawX='" + this.d + "', downRawY='" + this.e + "', upX='" + this.f + "', upY='" + this.g + "', upRawX='" + this.h + "', upRawY='" + this.i + "'}";
    }
}
