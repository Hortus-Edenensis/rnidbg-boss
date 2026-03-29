package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiResult extends SearchResult {
    public static final Parcelable.Creator<PoiResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3790a;
    private int b;
    private int c;
    private int d;
    private List<PoiInfo> e;
    private boolean f;
    private List<PoiAddrInfo> g;
    private List<CityInfo> h;
    private String i;
    private String j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<PoiResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiResult createFromParcel(Parcel parcel) {
            return new PoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiResult[] newArray(int i) {
            return new PoiResult[i];
        }
    }

    public PoiResult() {
        this.f3790a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.e;
    }

    public int getCurrentPageCapacity() {
        return this.c;
    }

    public int getCurrentPageNum() {
        return this.f3790a;
    }

    public String getQueryType() {
        return this.j;
    }

    public String getResultType() {
        return this.i;
    }

    @Deprecated
    public List<CityInfo> getSuggestCityList() {
        return this.h;
    }

    public int getTotalPageNum() {
        return this.b;
    }

    public int getTotalPoiNum() {
        return this.d;
    }

    public boolean isHasAddrInfo() {
        return this.f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f3790a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.e = list;
    }

    public void setQueryType(String str) {
        this.j = str;
    }

    public void setResultType(String str) {
        this.i = str;
    }

    @Deprecated
    public void setSuggestCityList(List<CityInfo> list) {
        this.h = list;
    }

    public void setTotalPageNum(int i) {
        this.b = i;
    }

    public void setTotalPoiNum(int i) {
        this.d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f3790a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.h);
        parcel.writeString(this.j);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f3790a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f3790a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
        this.f3790a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f = parcel.readByte() != 0;
        this.h = parcel.createTypedArrayList(CityInfo.CREATOR);
        this.j = parcel.readString();
    }
}
