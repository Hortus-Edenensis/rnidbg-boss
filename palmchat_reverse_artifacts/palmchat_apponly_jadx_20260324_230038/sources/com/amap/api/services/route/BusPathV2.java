package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BusPathV2 extends Path {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new Parcelable.Creator<BusPathV2>() { // from class: com.amap.api.services.route.BusPathV2.1
        private static BusPathV2 a(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPathV2[] newArray(int i) {
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3191a;
    private boolean b;
    private float c;
    private float d;
    private List<BusStepV2> e;

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.e = new ArrayList();
        this.f3191a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.b = zArr[0];
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.d;
    }

    public float getCost() {
        return this.f3191a;
    }

    public List<BusStepV2> getSteps() {
        return this.e;
    }

    public float getWalkDistance() {
        return this.c;
    }

    public boolean isNightBus() {
        return this.b;
    }

    public void setBusDistance(float f) {
        this.d = f;
    }

    public void setCost(float f) {
        this.f3191a = f;
    }

    public void setNightBus(boolean z) {
        this.b = z;
    }

    public void setSteps(List<BusStepV2> list) {
        this.e = list;
    }

    public void setWalkDistance(float f) {
        this.c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3191a);
        parcel.writeBooleanArray(new boolean[]{this.b});
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeTypedList(this.e);
    }

    public BusPathV2() {
        this.e = new ArrayList();
    }
}
