package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class InputtipsQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3162a;
    private String b;
    private boolean c = false;
    private String d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.f3162a = str;
        this.b = str2;
    }

    public String getCity() {
        return this.b;
    }

    public boolean getCityLimit() {
        return this.c;
    }

    public String getKeyword() {
        return this.f3162a;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.c = z;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setType(String str) {
        this.d = str;
    }
}
