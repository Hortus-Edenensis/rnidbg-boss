package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItemV2.1
        private static PoiItem a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i) {
            return a(i);
        }

        private static PoiItem[] a(int i) {
            return new PoiItem[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3142a;
    private String b;
    private String c;
    private String d;
    private final LatLonPoint e;
    private final String f;
    private final String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private List<SubPoiItemV2> m;
    private Business n;
    private IndoorDataV2 o;
    private PoiNavi p;
    private List<Photo> q;

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.d = "";
        this.m = new ArrayList();
        this.q = new ArrayList();
        this.f3142a = str;
        this.e = latLonPoint;
        this.f = str2;
        this.g = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PoiItemV2 poiItemV2 = (PoiItemV2) obj;
        String str = this.f3142a;
        if (str == null) {
            if (poiItemV2.f3142a != null) {
                return false;
            }
        } else if (!str.equals(poiItemV2.f3142a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.b;
    }

    public String getAdName() {
        return this.k;
    }

    public Business getBusiness() {
        return this.n;
    }

    public String getCityCode() {
        return this.c;
    }

    public String getCityName() {
        return this.j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public List<Photo> getPhotos() {
        return this.q;
    }

    public String getPoiId() {
        return this.f3142a;
    }

    public PoiNavi getPoiNavi() {
        return this.p;
    }

    public String getProvinceCode() {
        return this.l;
    }

    public String getProvinceName() {
        return this.i;
    }

    public String getSnippet() {
        return this.g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.m;
    }

    public String getTitle() {
        return this.f;
    }

    public String getTypeCode() {
        return this.h;
    }

    public String getTypeDes() {
        return this.d;
    }

    public int hashCode() {
        String str = this.f3142a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.b = str;
    }

    public void setAdName(String str) {
        this.k = str;
    }

    public void setBusiness(Business business) {
        this.n = business;
    }

    public void setCityCode(String str) {
        this.c = str;
    }

    public void setCityName(String str) {
        this.j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.l = str;
    }

    public void setProvinceName(String str) {
        this.i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.m = list;
    }

    public void setTypeCode(String str) {
        this.h = str;
    }

    public void setTypeDes(String str) {
        this.d = str;
    }

    public String toString() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3142a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.c);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.h);
        parcel.writeList(this.m);
        parcel.writeValue(this.n);
        parcel.writeValue(this.o);
        parcel.writeValue(this.p);
        parcel.writeTypedList(this.q);
    }

    public PoiItemV2(Parcel parcel) {
        this.d = "";
        this.m = new ArrayList();
        this.q = new ArrayList();
        this.f3142a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.c = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.h = parcel.readString();
        this.m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
