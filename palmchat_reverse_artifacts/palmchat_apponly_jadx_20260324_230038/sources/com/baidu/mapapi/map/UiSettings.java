package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class UiSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f3710a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f3710a = bVar;
    }

    public boolean isCompassEnabled() {
        return this.f3710a.k();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f3710a.N();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f3710a.O();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f3710a.Q();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f3710a.S();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setDoubleClickZoomEnabled(z);
        setTwoTouchClickZoomEnabled(z);
        setDoubleClickMoveZoomEnable(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f3710a.f(z);
    }

    public void setDoubleClickGesturesCenter(boolean z) {
        this.f3710a.i(z);
    }

    public void setDoubleClickMoveZoomEnable(boolean z) {
        this.f3710a.j(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.f3710a.k(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f3710a.l(z);
    }

    public void setFlingEnable(boolean z) {
        this.f3710a.m(z);
    }

    public void setInertialAnimation(boolean z) {
        this.f3710a.p(z);
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.f3710a.a(latLng);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f3710a.u(z);
    }

    public void setPointGesturesCenter(Point point) {
        this.f3710a.b(point);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f3710a.v(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f3710a.y(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.f3710a.A(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f3710a.B(z);
    }
}
