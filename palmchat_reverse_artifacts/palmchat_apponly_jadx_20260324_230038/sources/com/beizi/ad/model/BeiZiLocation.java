package com.beizi.ad.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BeiZiLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4473a;
    private String b;
    private String c;
    private long d;

    public BeiZiLocation() {
    }

    public String getLatitude() {
        return this.b;
    }

    public String getLongitude() {
        return this.f4473a;
    }

    public long getTime() {
        return this.d;
    }

    public String getType() {
        return this.c;
    }

    public void setLatitude(String str) {
        this.b = str;
    }

    public void setLongitude(String str) {
        this.f4473a = str;
    }

    public void setTime(long j) {
        this.d = j;
    }

    public void setType(String str) {
        this.c = str;
    }

    public BeiZiLocation(String str, String str2, String str3, long j) {
        this.f4473a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }
}
