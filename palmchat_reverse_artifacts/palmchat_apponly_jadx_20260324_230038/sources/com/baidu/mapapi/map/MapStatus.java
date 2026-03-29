package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f3646a;
    private double b;
    public final LatLngBounds bound;
    s c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<MapStatus> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStatus createFromParcel(Parcel parcel) {
            return new MapStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStatus[] newArray(int i) {
            return new MapStatus[i];
        }
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        if (latLng != null) {
            this.f3646a = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.b = CoordUtil.ll2mc(latLng).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public static MapStatus a(s sVar) {
        if (sVar == null) {
            return null;
        }
        float f = sVar.b;
        double d = sVar.e;
        double d2 = sVar.d;
        LatLng latLngMc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
        float f2 = sVar.c;
        float f3 = sVar.f3992a;
        Point point = new Point(sVar.f, sVar.g);
        LatLng latLngMc2ll2 = CoordUtil.mc2ll(new GeoPoint(sVar.k.e.getDoubleY(), sVar.k.e.getDoubleX()));
        LatLng latLngMc2ll3 = CoordUtil.mc2ll(new GeoPoint(sVar.k.f.getDoubleY(), sVar.k.f.getDoubleX()));
        LatLng latLngMc2ll4 = CoordUtil.mc2ll(new GeoPoint(sVar.k.h.getDoubleY(), sVar.k.h.getDoubleX()));
        LatLng latLngMc2ll5 = CoordUtil.mc2ll(new GeoPoint(sVar.k.g.getDoubleY(), sVar.k.g.getDoubleX()));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLngMc2ll2);
        builder.include(latLngMc2ll3);
        builder.include(latLngMc2ll4);
        builder.include(latLngMc2ll5);
        WinRound winRound = sVar.j;
        LatLngBounds latLngBoundsBuild = builder.build();
        latLngBoundsBuild.setCenter(CoordUtil.mc2ll(new GeoPoint(((sVar.k.g.getDoubleY() - sVar.k.e.getDoubleY()) / 2.0d) + sVar.k.e.getDoubleY(), ((sVar.k.g.getDoubleX() - sVar.k.e.getDoubleX()) / 2.0d) + sVar.k.e.getDoubleX())));
        return new MapStatus(f, latLngMc2ll, f2, f3, point, sVar, d2, d, latLngBoundsBuild, winRound);
    }

    public double b() {
        return this.f3646a;
    }

    public double c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.target != null) {
            sb.append("target lat: " + this.target.latitude + "\n");
            sb.append("target lng: " + this.target.longitude + "\n");
        }
        if (this.targetScreen != null) {
            sb.append("target screen x: " + this.targetScreen.x + "\n");
            sb.append("target screen y: " + this.targetScreen.y + "\n");
        }
        sb.append("zoom: " + this.zoom + "\n");
        sb.append("rotate: " + this.rotate + "\n");
        sb.append("overlook: " + this.overlook + "\n");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i);
        parcel.writeParcelable(this.bound, i);
        parcel.writeDouble(this.f3646a);
        parcel.writeDouble(this.b);
    }

    public s b(s sVar) {
        if (sVar == null) {
            return null;
        }
        float f = this.rotate;
        if (f != -2.1474836E9f) {
            sVar.b = (int) f;
        }
        float f2 = this.zoom;
        if (f2 != -2.1474836E9f) {
            sVar.f3992a = f2;
        }
        float f3 = this.overlook;
        if (f3 != -2.1474836E9f) {
            sVar.c = (int) f3;
        }
        if (this.target != null) {
            sVar.d = this.f3646a;
            sVar.e = this.b;
        }
        Point point = this.targetScreen;
        if (point != null) {
            sVar.f = point.x;
            sVar.g = point.y;
        }
        return sVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f3647a;
        private LatLng b;
        private float c;
        private float d;
        private Point e;
        private LatLngBounds f;
        private double g;
        private double h;
        private final float i;

        public Builder() {
            this.f3647a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
        }

        private float a(float f) {
            if (15.0f == f) {
                return 15.5f;
            }
            return f;
        }

        public MapStatus build() {
            return new MapStatus(this.f3647a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder overlook(float f) {
            this.c = f;
            return this;
        }

        public Builder rotate(float f) {
            this.f3647a = f;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.e = point;
            return this;
        }

        public Builder zoom(float f) {
            this.d = a(f);
            return this;
        }

        public Builder(MapStatus mapStatus) {
            this.f3647a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
            this.f3647a = mapStatus.rotate;
            this.b = mapStatus.target;
            this.c = mapStatus.overlook;
            this.d = mapStatus.zoom;
            this.e = mapStatus.targetScreen;
            this.g = mapStatus.b();
            this.h = mapStatus.c();
        }
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, double d, double d2, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.f3646a = d;
        this.b = d2;
        this.bound = latLngBounds;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, s sVar, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.c = sVar;
        this.f3646a = d;
        this.b = d2;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    public MapStatus(Parcel parcel) {
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.f3646a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public s a() {
        return b(new s());
    }
}
