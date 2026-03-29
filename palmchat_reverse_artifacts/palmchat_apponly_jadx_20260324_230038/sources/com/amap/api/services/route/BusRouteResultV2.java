package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BusRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new Parcelable.Creator<BusRouteResultV2>() { // from class: com.amap.api.services.route.BusRouteResultV2.1
        private static BusRouteResultV2 a(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2[] newArray(int i) {
            return a(i);
        }

        private static BusRouteResultV2[] a(int i) {
            return new BusRouteResultV2[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3193a;
    private List<BusPathV2> b;
    private RouteSearchV2.BusRouteQuery c;
    private float d;

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.b = new ArrayList();
        this.f3193a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.c = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.d = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.c;
    }

    public float getDistance() {
        return this.d;
    }

    public List<BusPathV2> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.f3193a;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.c = busRouteQuery;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public void setPaths(List<BusPathV2> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.f3193a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3193a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
    }

    public BusRouteResultV2() {
        this.b = new ArrayList();
    }
}
