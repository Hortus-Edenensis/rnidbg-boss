package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RouteParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LatLng f3844a;
    LatLng b;
    String c;
    String d;
    String e;
    String f;
    String g;
    EBusStrategyType h = EBusStrategyType.bus_recommend_way;

    /* JADX INFO: compiled from: SearchBox */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.h = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.d = str;
        return this;
    }

    public RouteParaOption endPoiId(String str) {
        this.g = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.h;
    }

    public String getCityName() {
        return this.e;
    }

    public String getEndName() {
        return this.d;
    }

    public String getEndPoiId() {
        return this.g;
    }

    public LatLng getEndPoint() {
        return this.b;
    }

    public String getStartName() {
        return this.c;
    }

    public String getStartPoiId() {
        return this.f;
    }

    public LatLng getStartPoint() {
        return this.f3844a;
    }

    public RouteParaOption startName(String str) {
        this.c = str;
        return this;
    }

    public RouteParaOption startPoiId(String str) {
        this.f = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f3844a = latLng;
        return this;
    }
}
