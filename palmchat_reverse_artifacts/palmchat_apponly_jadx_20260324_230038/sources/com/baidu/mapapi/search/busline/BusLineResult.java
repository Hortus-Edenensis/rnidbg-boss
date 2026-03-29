package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BusLineResult extends SearchResult {
    public static final Parcelable.Creator<BusLineResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3752a;
    private String b;
    private String c;
    private boolean d;
    private Date e;
    private Date f;
    private String g;
    private List<BusStation> h;
    private List<BusStep> i;
    private float j;
    private float k;
    private String l;

    /* JADX INFO: compiled from: SearchBox */
    public static class BusStation extends RouteNode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BusStep extends RouteStep {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<BusLineResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusLineResult[] newArray(int i) {
            return new BusLineResult[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusLineResult createFromParcel(Parcel parcel) {
            return new BusLineResult(parcel);
        }
    }

    public BusLineResult() {
        this.f3752a = null;
        this.b = null;
        this.h = null;
        this.i = null;
        this.l = null;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.j;
    }

    public String getBusCompany() {
        return this.f3752a;
    }

    public String getBusLineName() {
        return this.b;
    }

    public Date getEndTime() {
        return this.f;
    }

    public String getLineDirection() {
        return this.l;
    }

    public float getMaxPrice() {
        return this.k;
    }

    public String getRawName() {
        return this.c;
    }

    public Date getStartTime() {
        return this.e;
    }

    public List<BusStation> getStations() {
        return this.h;
    }

    public List<BusStep> getSteps() {
        return this.i;
    }

    public String getUid() {
        return this.g;
    }

    public boolean isMonthTicket() {
        return this.d;
    }

    public void setBasePrice(float f) {
        this.j = f;
    }

    public void setBusCompany(String str) {
        this.f3752a = str;
    }

    public void setBusLineName(String str) {
        this.b = str;
    }

    public void setEndTime(Date date) {
        this.f = date;
    }

    public void setLineDirection(String str) {
        this.l = str;
    }

    public void setMaxPrice(float f) {
        this.k = f;
    }

    public void setMonthTicket(boolean z) {
        this.d = z;
    }

    public void setRawName(String str) {
        this.c = str;
    }

    public void setStartTime(Date date) {
        this.e = date;
    }

    public void setStations(List<BusStation> list) {
        this.h = list;
    }

    public void setSteps(List<BusStep> list) {
        this.i = list;
    }

    public void setUid(String str) {
        this.g = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3752a);
        parcel.writeString(this.b);
        parcel.writeValue(Boolean.valueOf(this.d));
        parcel.writeValue(this.e);
        parcel.writeValue(this.f);
        parcel.writeString(this.g);
        parcel.writeList(this.h);
        parcel.writeList(this.i);
        parcel.writeString(this.c);
        parcel.writeString(this.l);
        parcel.writeFloat(this.k);
        parcel.writeFloat(this.j);
    }

    public BusLineResult(Parcel parcel) {
        this.f3752a = null;
        this.b = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.f3752a = parcel.readString();
        this.b = parcel.readString();
        this.d = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f = (Date) parcel.readValue(Date.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readArrayList(BusStation.class.getClassLoader());
        this.i = parcel.readArrayList(RouteStep.class.getClassLoader());
        this.c = parcel.readString();
        this.l = parcel.readString();
        this.k = parcel.readFloat();
        this.j = parcel.readFloat();
    }
}
