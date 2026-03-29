package com.amap.api.services.route;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Cost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3197a;
    private float b;
    private String c;
    private float d;
    private int e;

    public float getDuration() {
        return this.f3197a;
    }

    public float getTollDistance() {
        return this.b;
    }

    public String getTollRoad() {
        return this.c;
    }

    public float getTolls() {
        return this.d;
    }

    public int getTrafficLights() {
        return this.e;
    }

    public void setDuration(float f) {
        this.f3197a = f;
    }

    public void setTollDistance(float f) {
        this.b = f;
    }

    public void setTollRoad(String str) {
        this.c = str;
    }

    public void setTolls(float f) {
        this.d = f;
    }

    public void setTrafficLights(int i) {
        this.e = i;
    }
}
