package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TruckNaviOption extends NaviParaOption {
    int i;
    double j;
    double k;
    double l;
    double m;
    double n;
    int o;
    boolean p;
    String q;
    int r;
    int s;
    int t;
    int u;
    int v;

    public int getAxleCount() {
        return this.o;
    }

    public double getAxleWeight() {
        return this.n;
    }

    public int getDisplacement() {
        return this.s;
    }

    public int getEmissionLimit() {
        return this.u;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getEndName() {
        return super.getEndName();
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public LatLng getEndPoint() {
        return super.getEndPoint();
    }

    public double getHeight() {
        return this.j;
    }

    public boolean getIsTrailer() {
        return this.p;
    }

    public double getLength() {
        return this.m;
    }

    public int getLoadWeight() {
        return this.v;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getNaviRoutePolicy() {
        return super.getNaviRoutePolicy();
    }

    public int getPlateColor() {
        return this.r;
    }

    public String getPlateNumber() {
        return this.q;
    }

    public int getPowerType() {
        return this.t;
    }

    public int getTruckType() {
        return this.i;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public JSONArray getWayPoint() {
        return super.getWayPoint();
    }

    public double getWeight() {
        return this.l;
    }

    public double getWidth() {
        return this.k;
    }

    public TruckNaviOption setAxleCount(int i) {
        this.o = i;
        return this;
    }

    public TruckNaviOption setAxleWeight(double d) {
        this.n = d;
        return this;
    }

    public TruckNaviOption setDisplacement(int i) {
        this.s = i;
        return this;
    }

    public TruckNaviOption setEmissionLimit(int i) {
        this.u = i;
        return this;
    }

    public TruckNaviOption setHeight(double d) {
        this.j = d;
        return this;
    }

    public TruckNaviOption setIsTrailer(boolean z) {
        this.p = z;
        return this;
    }

    public TruckNaviOption setLength(double d) {
        this.m = d;
        return this;
    }

    public TruckNaviOption setLoadWeight(int i) {
        this.v = i;
        return this;
    }

    public TruckNaviOption setPlateColor(int i) {
        this.r = i;
        return this;
    }

    public TruckNaviOption setPlateNumber(String str) {
        this.q = str;
        return this;
    }

    public TruckNaviOption setPowerType(int i) {
        this.t = i;
        return this;
    }

    public TruckNaviOption setTruckType(int i) {
        this.i = i;
        return this;
    }

    public TruckNaviOption setWeight(double d) {
        this.l = d;
        return this;
    }

    public TruckNaviOption setWidth(double d) {
        this.k = d;
        return this;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endName(String str) {
        return (TruckNaviOption) super.endName(str);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endPoint(LatLng latLng) {
        return (TruckNaviOption) super.endPoint(latLng);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy naviRoutePolicy) {
        return (TruckNaviOption) super.setNaviRoutePolicy(naviRoutePolicy);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setWayPoint(WayPoint wayPoint) {
        return (TruckNaviOption) super.setWayPoint(wayPoint);
    }
}
