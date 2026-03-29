package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MarkerOptions extends OverlayOptions {
    int G;
    Bundle I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3658a;
    private BitmapDescriptor b;
    private BmBitmapResource c;
    private float i;
    private TitleOptions j;
    private String k;
    private int l;
    private int m;
    private ArrayList<BitmapDescriptor> o;
    private Point x;
    private InfoWindow z;
    private float d = 0.5f;
    private int e = 2;
    private float f = 1.0f;
    private boolean g = true;
    private boolean h = false;
    private boolean n = false;
    private int p = 20;
    private int q = 160;
    private float r = 1.0f;
    private float s = 1.0f;
    private float t = 1.0f;
    private int u = 0;
    private int v = MarkerAnimateType.none.ordinal();
    private boolean w = false;
    private boolean y = true;
    private int A = Integer.MAX_VALUE;
    private boolean B = false;
    private int C = 4;
    private int D = 22;
    private boolean E = false;
    private boolean F = false;
    boolean H = true;

    /* JADX INFO: compiled from: SearchBox */
    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    public MarkerOptions alpha(float f) {
        if (f < 0.0f || f > 1.0f) {
            this.t = 1.0f;
            return this;
        }
        this.t = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.d = f;
            this.f = f2;
        }
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.v = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions bitmapResource(BmBitmapResource bmBitmapResource) {
        this.c = bmBitmapResource;
        return this;
    }

    public MarkerOptions clickable(boolean z) {
        this.y = z;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.h = z;
        return this;
    }

    public MarkerOptions endLevel(int i) {
        this.D = i;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.I = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.x = point;
        this.w = true;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.n = z;
        return this;
    }

    public float getAlpha() {
        return this.t;
    }

    public float getAnchorX() {
        return this.d;
    }

    public float getAnchorY() {
        return this.f;
    }

    public MarkerAnimateType getAnimateType() {
        int i = this.v;
        return i != 1 ? i != 2 ? i != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
    }

    public BmBitmapResource getBmBitmapResource() {
        return this.c;
    }

    public int getEndLevel() {
        return this.D;
    }

    public Bundle getExtraInfo() {
        return this.I;
    }

    public boolean getForceDisPlay() {
        return this.B;
    }

    public int getHeight() {
        return this.u;
    }

    public BitmapDescriptor getIcon() {
        return this.b;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.o;
    }

    public int getInterval() {
        return this.q;
    }

    public boolean getIsClickable() {
        return this.y;
    }

    public boolean getJoinCollision() {
        return this.E;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Marker marker = new Marker();
        marker.d = this.H;
        marker.c = this.G;
        marker.e = this.I;
        LatLng latLng = this.f3658a;
        if (latLng == null) {
            throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
        }
        marker.g = latLng;
        BitmapDescriptor bitmapDescriptor = this.b;
        if (bitmapDescriptor == null && this.o == null && this.c == null) {
            throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
        }
        marker.h = bitmapDescriptor;
        marker.i = this.c;
        marker.l = this.d;
        marker.m = this.f;
        marker.k = this.e;
        marker.n = this.g;
        marker.o = this.h;
        marker.p = this.i;
        marker.r = this.j;
        marker.t = this.l;
        marker.u = this.m;
        marker.v = this.n;
        marker.G = this.o;
        marker.J = this.p;
        marker.F = this.q;
        marker.x = this.t;
        marker.E = this.u;
        marker.L = this.r;
        marker.M = this.s;
        marker.y = this.v;
        marker.z = this.w;
        marker.P = this.z;
        marker.A = this.y;
        marker.S = this.A;
        marker.D = this.B;
        marker.U = this.C;
        marker.V = this.D;
        marker.B = this.E;
        marker.C = this.F;
        Point point = this.x;
        if (point != null) {
            marker.O = point;
        }
        return marker;
    }

    public int getPeriod() {
        return this.p;
    }

    public LatLng getPosition() {
        return this.f3658a;
    }

    public int getPriority() {
        return this.A;
    }

    public float getRotate() {
        return this.i;
    }

    public int getStartLevel() {
        return this.C;
    }

    @Deprecated
    public String getTitle() {
        return this.k;
    }

    public TitleOptions getTitleOptions() {
        return this.j;
    }

    public int getZIndex() {
        return this.G;
    }

    public MarkerOptions height(int i) {
        if (i < 0) {
            this.u = 0;
            return this;
        }
        this.u = i;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.b = bitmapDescriptor;
        return this;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
        }
        if (arrayList.isEmpty()) {
            return this;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null || arrayList.get(i).f3610a == null) {
                return this;
            }
        }
        this.o = arrayList;
        return this;
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        this.z = infoWindow;
        return this;
    }

    public MarkerOptions interval(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's interval must be greater than zero ");
        }
        this.q = i;
        return this;
    }

    public boolean isDraggable() {
        return this.h;
    }

    public boolean isFlat() {
        return this.n;
    }

    public MarkerOptions isForceDisPlay(boolean z) {
        this.B = z;
        return this;
    }

    public MarkerOptions isJoinCollision(boolean z) {
        this.E = z;
        return this;
    }

    public boolean isPerspective() {
        return this.g;
    }

    public boolean isPoiCollided() {
        return this.F;
    }

    public boolean isVisible() {
        return this.H;
    }

    public MarkerOptions period(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
        }
        this.p = i;
        return this;
    }

    public MarkerOptions perspective(boolean z) {
        this.g = z;
        return this;
    }

    public MarkerOptions poiCollided(boolean z) {
        this.F = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
        }
        this.f3658a = latLng;
        return this;
    }

    public MarkerOptions priority(int i) {
        this.A = i;
        return this;
    }

    public MarkerOptions rotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.i = f % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.r = f;
        return this;
    }

    public MarkerOptions scaleY(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.s = f;
        return this;
    }

    public MarkerOptions startLevel(int i) {
        this.C = i;
        return this;
    }

    public MarkerOptions title(String str) {
        this.k = str;
        return this;
    }

    public MarkerOptions titleOptions(TitleOptions titleOptions) {
        this.j = titleOptions;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.H = z;
        return this;
    }

    public MarkerOptions xOffset(int i) {
        this.m = i;
        return this;
    }

    public MarkerOptions yOffset(int i) {
        this.l = i;
        return this;
    }

    public MarkerOptions zIndex(int i) {
        this.G = i;
        return this;
    }
}
