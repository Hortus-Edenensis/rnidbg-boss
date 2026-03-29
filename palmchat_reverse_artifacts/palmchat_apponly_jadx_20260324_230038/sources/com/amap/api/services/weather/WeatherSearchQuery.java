package com.amap.api.services.weather;

import com.amap.api.col.p0002sl.di;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3283a;
    private int b;

    public WeatherSearchQuery(String str, int i) {
        this.f3283a = str;
        this.b = i;
    }

    public String getCity() {
        return this.f3283a;
    }

    public int getType() {
        return this.b;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m40clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            di.a(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f3283a, this.b);
    }

    public WeatherSearchQuery() {
        this.b = 1;
    }
}
