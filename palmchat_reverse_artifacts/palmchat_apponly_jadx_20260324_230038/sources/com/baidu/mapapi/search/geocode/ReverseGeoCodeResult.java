package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3776a;
    private String b;
    private AddressComponent c;
    private LatLng d;
    private int e;
    private List<PoiInfo> f;
    private String g;
    private String h;
    private List<PoiRegionsInfo> i;
    private List<RoadInfo> j;
    private int k;

    /* JADX INFO: compiled from: SearchBox */
    public static class AddressComponent implements Parcelable {
        public static final Parcelable.Creator<AddressComponent> CREATOR = new a();
        public int adcode;
        public String city;
        public int cityLevel;
        public int countryCode;
        public String countryCodeIso;
        public String countryCodeIso2;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;
        public String townCode;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<AddressComponent> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AddressComponent createFromParcel(Parcel parcel) {
                return new AddressComponent(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AddressComponent[] newArray(int i) {
                return new AddressComponent[i];
            }
        }

        public AddressComponent() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirection() {
            return this.direction;
        }

        public String getDistance() {
            return this.distance;
        }

        public String getTown() {
            return this.town;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public void setDistance(String str) {
            this.distance = str;
        }

        public void setTown(String str) {
            this.town = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.streetNumber);
            parcel.writeString(this.street);
            parcel.writeString(this.town);
            parcel.writeString(this.district);
            parcel.writeString(this.city);
            parcel.writeString(this.province);
            parcel.writeString(this.countryName);
            parcel.writeInt(this.countryCode);
            parcel.writeInt(this.adcode);
            parcel.writeString(this.direction);
            parcel.writeString(this.distance);
            parcel.writeString(this.countryCodeIso);
            parcel.writeString(this.countryCodeIso2);
            parcel.writeString(this.townCode);
            parcel.writeInt(this.cityLevel);
        }

        public AddressComponent(Parcel parcel) {
            this.streetNumber = parcel.readString();
            this.street = parcel.readString();
            this.town = parcel.readString();
            this.district = parcel.readString();
            this.city = parcel.readString();
            this.province = parcel.readString();
            this.countryName = parcel.readString();
            this.countryCode = parcel.readInt();
            this.adcode = parcel.readInt();
            this.direction = parcel.readString();
            this.distance = parcel.readString();
            this.countryCodeIso = parcel.readString();
            this.countryCodeIso2 = parcel.readString();
            this.townCode = parcel.readString();
            this.cityLevel = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PoiRegionsInfo implements Parcelable {
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new a();
        public String directionDesc;
        public String regionName;
        public String regionTag;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<PoiRegionsInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PoiRegionsInfo createFromParcel(Parcel parcel) {
                return new PoiRegionsInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PoiRegionsInfo[] newArray(int i) {
                return new PoiRegionsInfo[i];
            }
        }

        public PoiRegionsInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirectionDesc() {
            return this.directionDesc;
        }

        public String getRegionName() {
            return this.regionName;
        }

        public String getRegionTag() {
            return this.regionTag;
        }

        public void setDirectionDesc(String str) {
            this.directionDesc = str;
        }

        public void setRegionName(String str) {
            this.regionName = str;
        }

        public void setRegionTag(String str) {
            this.regionTag = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.directionDesc);
            parcel.writeString(this.regionName);
            parcel.writeString(this.regionTag);
        }

        public PoiRegionsInfo(Parcel parcel) {
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class RoadInfo implements Parcelable {
        public static final Parcelable.Creator<RoadInfo> CREATOR = new a();
        public String distance;
        public String name;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<RoadInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RoadInfo createFromParcel(Parcel parcel) {
                return new RoadInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RoadInfo[] newArray(int i) {
                return new RoadInfo[i];
            }
        }

        public RoadInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.distance);
        }

        public RoadInfo(Parcel parcel) {
            this.name = parcel.readString();
            this.distance = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<ReverseGeoCodeResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReverseGeoCodeResult createFromParcel(Parcel parcel) {
            return new ReverseGeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReverseGeoCodeResult[] newArray(int i) {
            return new ReverseGeoCodeResult[i];
        }
    }

    public ReverseGeoCodeResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.k;
    }

    public String getAddress() {
        return this.b;
    }

    public AddressComponent getAddressDetail() {
        return this.c;
    }

    public String getBusinessCircle() {
        return this.f3776a;
    }

    public int getCityCode() {
        return this.e;
    }

    public String getFormattedPoiAddress() {
        return this.h;
    }

    public LatLng getLocation() {
        return this.d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.i;
    }

    public List<RoadInfo> getRoadInfoList() {
        return this.j;
    }

    public String getSematicDescription() {
        return this.g;
    }

    public void setAdcode(int i) {
        this.k = i;
    }

    public void setAddress(String str) {
        this.b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.f3776a = str;
    }

    public void setCityCode(int i) {
        this.e = i;
    }

    public void setFormattedPoiAddress(String str) {
        this.h = str;
    }

    public void setLocation(LatLng latLng) {
        this.d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.i = list;
    }

    public void setRoadInfoList(List<RoadInfo> list) {
        this.j = list;
    }

    public void setSematicDescription(String str) {
        this.g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
        stringBuffer.append("businessCircle = ");
        stringBuffer.append(this.f3776a);
        stringBuffer.append("; address = ");
        stringBuffer.append(this.b);
        stringBuffer.append("; location = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; sematicDescription = ");
        stringBuffer.append(this.g);
        stringBuffer.append("; formattedPoiAddress = ");
        stringBuffer.append(this.h);
        if (this.c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
            stringBuffer.append("streetNumber = ");
            stringBuffer.append(this.c.streetNumber);
            stringBuffer.append("; street = ");
            stringBuffer.append(this.c.street);
            stringBuffer.append("; town = ");
            stringBuffer.append(this.c.town);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.c.district);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.c.city);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.c.province);
            stringBuffer.append("; countryName = ");
            stringBuffer.append(this.c.countryName);
            stringBuffer.append("; countryCode = ");
            stringBuffer.append(this.c.countryCode);
            stringBuffer.append("; adcode = ");
            stringBuffer.append(this.c.adcode);
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.c.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.c.distance);
            stringBuffer.append("; countryCodeIso = ");
            stringBuffer.append(this.c.countryCodeIso);
            stringBuffer.append("; countryCodeIso2 = ");
            stringBuffer.append(this.c.countryCodeIso2);
            stringBuffer.append("; townCode = ");
            stringBuffer.append(this.c.townCode);
            stringBuffer.append("; cityLevel = ");
            stringBuffer.append(this.c.cityLevel);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        List<PoiRegionsInfo> list = this.i;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i = 0; i < this.i.size(); i++) {
                PoiRegionsInfo poiRegionsInfo = this.i.get(i);
                if (poiRegionsInfo != null) {
                    stringBuffer.append("\ndirectionDesc = ");
                    stringBuffer.append(poiRegionsInfo.getDirectionDesc());
                    stringBuffer.append("; regionName = ");
                    stringBuffer.append(poiRegionsInfo.getRegionName());
                    stringBuffer.append("; regionTag = ");
                    stringBuffer.append(poiRegionsInfo.getRegionTag());
                }
            }
            stringBuffer.append("\n#PoiRegions Info  END# \n");
        }
        List<PoiInfo> list2 = this.f;
        if (list2 != null && !list2.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                PoiInfo poiInfo = this.f.get(i2);
                if (poiInfo != null) {
                    stringBuffer.append("\n address = ");
                    stringBuffer.append(poiInfo.getAddress());
                    stringBuffer.append("; phoneNumber = ");
                    stringBuffer.append(poiInfo.getPhoneNum());
                    stringBuffer.append("; uid = ");
                    stringBuffer.append(poiInfo.getUid());
                    stringBuffer.append("; postCode = ");
                    stringBuffer.append(poiInfo.getPostCode());
                    stringBuffer.append("; name = ");
                    stringBuffer.append(poiInfo.getName());
                    stringBuffer.append("; location = ");
                    stringBuffer.append(poiInfo.getLocation());
                    stringBuffer.append("; city = ");
                    stringBuffer.append(poiInfo.getCity());
                    stringBuffer.append("; direction = ");
                    stringBuffer.append(poiInfo.getDirection());
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(poiInfo.getDistance());
                    if (poiInfo.getParentPoi() != null) {
                        stringBuffer.append("\n parentPoiAddress = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiAddress());
                        stringBuffer.append("; parentPoiDirection = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDirection());
                        stringBuffer.append("; parentPoiDistance = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDistance());
                        stringBuffer.append("; parentPoiName = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiName());
                        stringBuffer.append("; parentPoiTag = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiTag());
                        stringBuffer.append("; parentPoiUid = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiUid());
                        stringBuffer.append("; parentPoiLocation = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiLocation());
                    }
                }
            }
            stringBuffer.append("\n #PoiList Info  END# \n");
        }
        List<RoadInfo> list3 = this.j;
        if (list3 != null && !list3.isEmpty()) {
            stringBuffer.append("\n #RoadInfoList Info  BEGIN#");
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                RoadInfo roadInfo = this.j.get(i3);
                if (roadInfo != null) {
                    stringBuffer.append("; name = ");
                    stringBuffer.append(roadInfo.name);
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(roadInfo.distance);
                }
            }
            stringBuffer.append("\n #RoadInfoList Info  END# \n");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3776a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, 0);
        parcel.writeValue(this.d);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeTypedList(this.i);
        parcel.writeTypedList(this.j);
    }

    public ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        this.f3776a = parcel.readString();
        this.b = parcel.readString();
        this.c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
        this.j = parcel.createTypedArrayList(RoadInfo.CREATOR);
    }
}
