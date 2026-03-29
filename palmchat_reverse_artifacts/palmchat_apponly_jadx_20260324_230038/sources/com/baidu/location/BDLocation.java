package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.location.Address;
import com.baidu.location.e.h;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.w;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_COOR_TYPE_BD09LL = "bd09";
    public static final String BDLOCATION_COOR_TYPE_BD09MC = "bd09mc";
    public static final String BDLOCATION_COOR_TYPE_GCJ02 = "gcj02";
    public static final String BDLOCATION_COOR_TYPE_GCJ03 = "gcj03";
    public static final String BDLOCATION_COOR_TYPE_WGS84 = "wgs84";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU = "bd_beidou";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM = "system";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() { // from class: com.baidu.location.BDLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    };
    public static final int GNSS_ACCURACY_BAD = 3;
    public static final int GNSS_ACCURACY_GOOD = 1;
    public static final int GNSS_ACCURACY_MID = 2;
    public static final int GNSS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int MOCK_GNSS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GNSS_PROBABILITY_LOW = 1;
    public static final int MOCK_GNSS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GNSS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GNSS_PROBABILITY_ZERO = 0;
    public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GPS_PROBABILITY_LOW = 1;
    public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TYPE_BMS_HD_LOCATION = 602;
    public static final int TYPE_CLOSE_LOCATION_SERVICE_SWITCH_FAIL = 69;
    public static final int TYPE_HD_LOCATION = 601;
    public static final int TYPE_LANE_HD_LOCATION = 603;
    public static final int TYPE_NO_PERMISSION_AND_CLOSE_SWITCH_FAIL = 71;
    public static final int TYPE_NO_PERMISSION_LOCATION_FAIL = 70;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCoarseLocation = 160;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGnssLocation = 61;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckFlowError = 506;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private String A;
    private String B;
    private String C;
    private double D;
    private boolean E;
    private int F;
    private int G;
    private String H;
    private int I;
    private String J;
    private int K;
    private int L;
    private int M;
    private int N;
    private String O;
    private String P;
    private String Q;
    private int R;
    private List<Poi> S;
    private String T;
    private String U;
    private String V;
    private Bundle W;
    private int X;
    private int Y;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3383a;
    private String aa;
    private String ab;
    private double ac;
    private double ad;
    private boolean ae;
    private PoiRegion af;
    private float ag;
    private double ah;
    private int ai;
    private int aj;
    private BDLocation ak;
    private Bundle al;
    private String am;
    private long an;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private String k;
    private float l;
    private int m;
    private float n;
    private boolean o;
    private int p;
    private float q;
    private String r;
    private boolean s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private Address z;

    public BDLocation() {
        this.f3383a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
    }

    private void a(Boolean bool) {
        this.y = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAcc() {
        return this.D;
    }

    public String getAdCode() {
        return this.z.adcode;
    }

    public String getAddrStr() {
        return this.z.address;
    }

    public Address getAddress() {
        return this.z;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.B;
    }

    public String getBuildingName() {
        return this.C;
    }

    public String getCity() {
        return this.z.city;
    }

    public String getCityCode() {
        return this.z.cityCode;
    }

    public String getCoorType() {
        return this.r;
    }

    public String getCountry() {
        return this.z.country;
    }

    public String getCountryCode() {
        return this.z.countryCode;
    }

    public long getDelayTime() {
        return this.Z;
    }

    @Deprecated
    public float getDerect() {
        return this.q;
    }

    public float getDirection() {
        return this.q;
    }

    public double getDisToRealLocation() {
        return this.ah;
    }

    public String getDistrict() {
        return this.z.district;
    }

    public Bundle getExtraInfo() {
        return this.al;
    }

    public Location getExtraLocation(String str) {
        Bundle bundle = this.W;
        if (bundle == null) {
            return null;
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable instanceof Location) {
            return (Location) parcelable;
        }
        return null;
    }

    public String getFloor() {
        return this.A;
    }

    public double[] getFusionLocInfo(String str) {
        return this.W.getDoubleArray(str);
    }

    public int getGnssAccuracyStatus() {
        return this.X;
    }

    public float getGnssBiasProb() {
        return this.ag;
    }

    public int getGnssCheckStatus() {
        return this.Y;
    }

    public String getGnssProvider() {
        return this.am;
    }

    @Deprecated
    public int getGpsAccuracyStatus() {
        return this.X;
    }

    @Deprecated
    public float getGpsBiasProb() {
        return this.ag;
    }

    @Deprecated
    public int getGpsCheckStatus() {
        return this.Y;
    }

    public int getInOutStatus() {
        return this.R;
    }

    public int getIndoorLocationSource() {
        return this.N;
    }

    public int getIndoorLocationSurpport() {
        return this.L;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.P;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.O;
    }

    public int getIndoorNetworkState() {
        return this.M;
    }

    public String getIndoorSurpportPolygon() {
        return this.Q;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.f3383a;
    }

    public String getLocTypeDescription() {
        return this.T;
    }

    public String getLocationDescribe() {
        return this.v;
    }

    public String getLocationID() {
        return this.U;
    }

    public int getLocationWhere() {
        return this.G;
    }

    public double getLongitude() {
        return this.d;
    }

    public int getMockGnssProbability() {
        return this.aj;
    }

    public int getMockGnssStrategy() {
        return this.ai;
    }

    @Deprecated
    public int getMockGpsProbability() {
        return this.aj;
    }

    @Deprecated
    public int getMockGpsStrategy() {
        return this.ai;
    }

    public String getNetworkLocationType() {
        return this.H;
    }

    public double getNrlLat() {
        return this.ac;
    }

    public double getNrlLon() {
        return this.ad;
    }

    public String getNrlResult() {
        return this.aa;
    }

    @Deprecated
    public int getOperators() {
        return this.I;
    }

    public List<Poi> getPoiList() {
        return this.S;
    }

    public PoiRegion getPoiRegion() {
        return this.af;
    }

    public String getProvince() {
        return this.z.province;
    }

    public float getRadius() {
        return this.j;
    }

    public BDLocation getReallLocation() {
        if (getMockGpsStrategy() > 0) {
            return this.ak;
        }
        return null;
    }

    public String getRetFields(String str) {
        return this.W.getString(str);
    }

    public String getRoadLocString() {
        return this.V;
    }

    public int getSatelliteNumber() {
        this.o = true;
        return this.p;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.v;
    }

    public String getSemanticParams() {
        return this.u;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.z.street;
    }

    public String getStreetNumber() {
        return this.z.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public long getTimeStamp() {
        return this.an;
    }

    public String getTown() {
        return this.z.town;
    }

    public String getTownCode() {
        return this.z.townCode;
    }

    public String getTraffic() {
        return this.k;
    }

    public float getTrafficConfidence() {
        return this.l;
    }

    public float getTrafficSkipProb() {
        return this.n;
    }

    public int getUserIndoorState() {
        return this.K;
    }

    public String getVdrJsonString() {
        Bundle bundle = this.W;
        if (bundle == null || !bundle.containsKey("vdr")) {
            return null;
        }
        return this.W.getString("vdr");
    }

    public String getViaductResult() {
        return this.ab;
    }

    public boolean hasAddr() {
        return this.s;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.o;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public boolean isCellChangeFlag() {
        return this.y;
    }

    public boolean isInIndoorPark() {
        return this.ae;
    }

    public boolean isIndoorLocMode() {
        return this.E;
    }

    public boolean isNrlAvailable() {
        return (this.ad == Double.MIN_VALUE || this.ac == Double.MIN_VALUE) ? false : true;
    }

    public int isParkAvailable() {
        return this.F;
    }

    public int isTrafficStation() {
        return this.m;
    }

    public void setAcc(double d) {
        this.D = d;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.z = address;
            this.s = true;
        }
    }

    public void setAddrStr(String str) {
        this.t = str;
        this.s = str != null;
    }

    public void setAltitude(double d) {
        if (d < 9999.0d) {
            this.f = d;
            this.e = true;
        }
    }

    public void setBuildingID(String str) {
        this.B = str;
    }

    public void setBuildingName(String str) {
        this.C = str;
    }

    public void setCoorType(String str) {
        this.r = str;
    }

    public void setDelayTime(long j) {
        this.Z = j;
    }

    public void setDirection(float f) {
        this.q = f;
    }

    public void setDisToRealLocation(double d) {
        this.ah = d;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putParcelable(str, location);
    }

    public void setExtrainfo(Bundle bundle) {
        this.al = bundle == null ? null : new Bundle(bundle);
    }

    public void setFloor(String str) {
        this.A = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putDoubleArray(str, dArr);
    }

    public void setGnssAccuracyStatus(int i) {
        this.X = i;
    }

    public void setGnssBiasProb(float f) {
        this.ag = f;
    }

    public void setGnssCheckStatus(int i) {
        this.Y = i;
    }

    public void setGnssProvider(String str) {
        this.am = str;
    }

    @Deprecated
    public void setGpsAccuracyStatus(int i) {
        this.X = i;
    }

    @Deprecated
    public void setGpsBiasProb(float f) {
        this.ag = f;
    }

    @Deprecated
    public void setGpsCheckStatus(int i) {
        this.Y = i;
    }

    public void setInOutStatus(int i) {
        this.R = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.E = z;
    }

    public void setIndoorLocationSource(int i) {
        this.N = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.L = i;
    }

    public void setIndoorNetworkState(int i) {
        this.M = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.Q = str;
    }

    public void setIsInIndoorPark(boolean z) {
        this.ae = z;
    }

    public void setIsTrafficStation(int i) {
        this.m = i;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLocType(int i) {
        String str;
        this.f3383a = i;
        if (i == 66) {
            str = "Offline location successful!";
        } else if (i == 67) {
            str = "Offline location failed, please check the net (wifi/cell)!";
        } else if (i == 167) {
            str = "NetWork location failed because baidu location service can not caculate the location!";
        } else if (i != 505) {
            switch (i) {
                case 61:
                    setLocTypeDescription("GPS location successful!");
                    setUserIndoorState(0);
                    setGnssProvider("system");
                    return;
                case 62:
                    str = "Location failed beacuse we can not get any loc information!";
                    break;
                case 63:
                    break;
                default:
                    switch (i) {
                        case 69:
                            str = "Location failed because the location service switch is not on";
                            break;
                        case 70:
                            str = "Location failed because the location permission is not enabled";
                            break;
                        case 71:
                            str = "Location failed because the location service switch is not on and the location permission is not enabled";
                            break;
                        default:
                            switch (i) {
                                case 160:
                                    str = "Coarse location successful";
                                    break;
                                case 161:
                                    str = "NetWork location successful!";
                                    break;
                                case 162:
                                    str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                                    break;
                                default:
                                    str = "UnKnown!";
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
        }
        setLocTypeDescription(str);
    }

    public void setLocTypeDescription(String str) {
        this.T = str;
    }

    public void setLocationDescribe(String str) {
        this.v = str;
    }

    public void setLocationID(String str) {
        this.U = str;
    }

    public void setLocationWhere(int i) {
        this.G = i;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public void setMockGnssProbability(int i) {
        this.aj = i;
    }

    public void setMockGnssStrategy(int i) {
        this.ai = i;
    }

    @Deprecated
    public void setMockGpsProbability(int i) {
        this.aj = i;
    }

    @Deprecated
    public void setMockGpsStrategy(int i) {
        this.ai = i;
    }

    public void setNetworkLocationType(String str) {
        this.H = str;
    }

    public void setNrlData(String str) {
        this.aa = str;
    }

    public void setOperators(int i) {
        this.I = i;
    }

    public void setParkAvailable(int i) {
        this.F = i;
    }

    public void setPoiList(List<Poi> list) {
        this.S = list;
    }

    public void setPoiRegion(PoiRegion poiRegion) {
        this.af = poiRegion;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setReallLocation(BDLocation bDLocation) {
        if (getMockGpsStrategy() > 0) {
            this.ak = bDLocation;
        }
    }

    public void setRetFields(String str, String str2) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putString(str, str2);
    }

    public void setRoadLocString(float f, float f2, String str, String str2) {
        String str3;
        String str4 = ((double) f) > 0.001d ? String.format("%.2f", Float.valueOf(f)) : "";
        String str5 = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
        String str6 = this.aa;
        if (str6 != null) {
            Locale locale = Locale.US;
            str3 = String.format(locale, "%s|%s,%s", str6, str4, str5);
            String str7 = this.ab;
            if (str7 != null) {
                str3 = String.format(locale, "%s|%s", str3, str7);
            }
        } else {
            str3 = null;
        }
        if (str == null) {
            str = str3;
        } else if (str3 != null) {
            str = String.format(Locale.US, "%s|%s", str3, str);
        }
        if (str2 == null) {
            str2 = str;
        } else if (str != null) {
            str2 = String.format(Locale.US, "%s|%s", str, str2);
        }
        this.V = str2;
    }

    public void setSatelliteNumber(int i) {
        this.p = i;
    }

    public void setSemanticParams(String str) {
        this.u = str;
    }

    public void setSpeed(float f) {
        this.h = f;
        this.g = true;
    }

    public void setTime(String str) {
        this.b = str;
        setLocationID(h.a(str));
    }

    public void setTimeStamp(long j) {
        this.an = j;
    }

    public void setTraffic(String str) {
        this.k = str;
    }

    public void setTrafficConfidence(float f) {
        this.l = f;
    }

    public void setTrafficSkipProb(float f) {
        this.n = f;
    }

    public void setUserIndoorState(int i) {
        this.K = i;
    }

    public void setVdrJsonValue(String str) {
        try {
            if (this.W == null) {
                this.W = new Bundle();
            }
            this.W.putString("vdr", str);
        } catch (Exception unused) {
        }
    }

    public void setViaductData(String str) {
        this.ab = str;
    }

    public String toString() {
        return "&loctype=" + getLocType() + "&lat=" + getLatitude() + "&lon=" + getLongitude() + "&radius=" + getRadius() + "&biasprob=" + getGpsBiasProb() + "&altitude=" + getAltitude() + "&speed=" + getSpeed() + "&time=" + getTimeStamp() + "&extrainfo=" + getExtraInfo();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3383a);
        parcel.writeString(this.b);
        parcel.writeLong(this.an);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeString(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p);
        parcel.writeFloat(this.q);
        parcel.writeString(this.A);
        parcel.writeInt(this.F);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeDouble(this.D);
        parcel.writeString(this.H);
        parcel.writeString(this.z.province);
        parcel.writeString(this.z.city);
        parcel.writeString(this.z.district);
        parcel.writeString(this.z.street);
        parcel.writeString(this.z.streetNumber);
        parcel.writeString(this.z.cityCode);
        parcel.writeString(this.z.address);
        parcel.writeString(this.z.country);
        parcel.writeString(this.z.countryCode);
        parcel.writeString(this.z.adcode);
        parcel.writeString(this.z.town);
        parcel.writeString(this.z.townCode);
        parcel.writeInt(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeInt(this.G);
        parcel.writeString(this.T);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.X);
        parcel.writeString(this.U);
        parcel.writeInt(this.Y);
        parcel.writeString(this.V);
        parcel.writeString(this.aa);
        parcel.writeString(this.ab);
        parcel.writeLong(this.Z);
        parcel.writeDouble(this.ac);
        parcel.writeDouble(this.ad);
        parcel.writeFloat(this.ag);
        parcel.writeDouble(this.ah);
        parcel.writeInt(this.ai);
        parcel.writeInt(this.aj);
        parcel.writeString(this.r);
        parcel.writeString(this.am);
        parcel.writeString(this.u);
        parcel.writeParcelable(this.ak, i);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.o, this.s, this.y, this.E, this.ae});
        parcel.writeList(this.S);
        parcel.writeBundle(this.W);
        parcel.writeBundle(this.al);
        parcel.writeParcelable(this.af, i);
    }

    private BDLocation(Parcel parcel) {
        this.f3383a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        this.f3383a = parcel.readInt();
        this.b = parcel.readString();
        this.an = parcel.readLong();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readString();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt();
        this.q = parcel.readFloat();
        this.A = parcel.readString();
        this.F = parcel.readInt();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readDouble();
        this.H = parcel.readString();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        this.z = new Address.Builder().country(string7).countryCode(string8).province(string).city(string2).cityCode(string6).district(string3).street(string4).streetNumber(string5).adcode(string9).town(string10).townCode(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.I = parcel.readInt();
        this.J = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.G = parcel.readInt();
        this.T = parcel.readString();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readInt();
        this.X = parcel.readInt();
        this.U = parcel.readString();
        this.Y = parcel.readInt();
        this.V = parcel.readString();
        this.aa = parcel.readString();
        this.ab = parcel.readString();
        this.Z = parcel.readLong();
        this.ac = parcel.readDouble();
        this.ad = parcel.readDouble();
        this.ag = parcel.readFloat();
        this.ah = parcel.readDouble();
        this.ai = parcel.readInt();
        this.aj = parcel.readInt();
        this.r = parcel.readString();
        this.am = parcel.readString();
        this.u = parcel.readString();
        try {
            this.ak = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.ak = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.o = zArr[3];
            this.s = zArr[4];
            this.y = zArr[5];
            this.E = zArr[6];
            this.ae = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.S = null;
        } else {
            this.S = arrayList;
        }
        try {
            this.W = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.W = new Bundle();
        }
        try {
            this.al = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.al = new Bundle();
        }
        try {
            this.af = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.af = null;
            e5.printStackTrace();
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.f3383a = 0;
        ArrayList arrayList = null;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        this.f3383a = bDLocation.f3383a;
        this.b = bDLocation.b;
        this.an = bDLocation.an;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.t = bDLocation.t;
        this.y = bDLocation.y;
        this.z = new Address.Builder().country(bDLocation.z.country).countryCode(bDLocation.z.countryCode).province(bDLocation.z.province).city(bDLocation.z.city).cityCode(bDLocation.z.cityCode).district(bDLocation.z.district).street(bDLocation.z.street).streetNumber(bDLocation.z.streetNumber).adcode(bDLocation.z.adcode).town(bDLocation.z.town).townCode(bDLocation.z.townCode).build();
        this.A = bDLocation.A;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.G = bDLocation.G;
        this.F = bDLocation.F;
        this.E = bDLocation.E;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.K = bDLocation.K;
        this.L = bDLocation.L;
        this.M = bDLocation.L;
        this.N = bDLocation.N;
        this.O = bDLocation.O;
        this.P = bDLocation.P;
        this.Q = bDLocation.Q;
        this.R = bDLocation.R;
        this.X = bDLocation.X;
        this.V = bDLocation.V;
        this.aa = bDLocation.aa;
        this.ab = bDLocation.ab;
        this.ac = bDLocation.ac;
        this.ad = bDLocation.ad;
        this.Z = bDLocation.Z;
        this.ah = bDLocation.ah;
        this.ai = bDLocation.ai;
        this.aj = bDLocation.aj;
        this.ak = bDLocation.ak;
        this.U = bDLocation.U;
        if (bDLocation.S != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.S.size(); i++) {
                Poi poi = bDLocation.S.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank(), poi.getTags(), poi.getAddr()));
            }
        }
        this.S = arrayList;
        this.T = bDLocation.T;
        this.W = bDLocation.W;
        this.Y = bDLocation.Y;
        this.ae = bDLocation.ae;
        this.af = bDLocation.af;
        this.ag = bDLocation.ag;
        this.al = bDLocation.al;
        this.am = bDLocation.am;
        this.u = bDLocation.u;
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04ed A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0544 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x055d A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x057c A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0595 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05ae A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05c7 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05d7 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x06d8 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x06e2 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TRY_LEAVE, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x06ec A[Catch: Exception -> 0x06fc, Error -> 0x07f9, TryCatch #13 {Exception -> 0x06fc, blocks: (B:315:0x06e6, B:317:0x06ec, B:318:0x06f8), top: B:404:0x06e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06f8 A[Catch: Exception -> 0x06fc, Error -> 0x07f9, TRY_LEAVE, TryCatch #13 {Exception -> 0x06fc, blocks: (B:315:0x06e6, B:317:0x06ec, B:318:0x06f8), top: B:404:0x06e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0711 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0721 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TRY_LEAVE, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0752 A[Catch: all -> 0x0755, TRY_LEAVE, TryCatch #14 {all -> 0x0755, blocks: (B:332:0x072b, B:334:0x0731, B:336:0x0737, B:338:0x073b, B:340:0x0752), top: B:405:0x072b }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x079b A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0602 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0762 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0226 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028d A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a3 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0319 A[Catch: Exception -> 0x07f5, Error -> 0x07f9, TryCatch #8 {Exception -> 0x07f5, blocks: (B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:28:0x018b, B:30:0x01ba, B:31:0x01c1, B:33:0x01c7, B:34:0x01d2, B:36:0x01d8, B:37:0x01df, B:39:0x01e5, B:40:0x01f0, B:43:0x01fa, B:45:0x0208, B:47:0x0214, B:48:0x0217, B:50:0x021e, B:52:0x0226, B:53:0x0238, B:55:0x023e, B:57:0x025c, B:59:0x0267, B:61:0x026d, B:63:0x0276, B:64:0x0283, B:65:0x0285, B:67:0x028d, B:69:0x0299, B:70:0x029b, B:72:0x02a3, B:74:0x02b1, B:76:0x02bc, B:78:0x02c4, B:80:0x02cf, B:82:0x02d7, B:84:0x02e2, B:86:0x02ea, B:88:0x02f5, B:90:0x02fd, B:92:0x0308, B:93:0x0311, B:95:0x0319, B:97:0x0325, B:99:0x032a, B:106:0x033d, B:108:0x0345, B:110:0x034d, B:112:0x0355, B:114:0x035d, B:116:0x0365, B:118:0x036d, B:120:0x0375, B:122:0x037d, B:124:0x0385, B:126:0x0391, B:128:0x0399, B:130:0x03a4, B:132:0x03ac, B:134:0x03b7, B:136:0x03bf, B:138:0x03ca, B:140:0x03d2, B:142:0x03dd, B:144:0x03e5, B:146:0x03f0, B:148:0x03f8, B:228:0x04ed, B:231:0x053c, B:233:0x0544, B:235:0x0552, B:236:0x0555, B:238:0x055d, B:240:0x0569, B:241:0x0574, B:243:0x057c, B:245:0x058a, B:246:0x058d, B:248:0x0595, B:250:0x05a3, B:251:0x05a6, B:253:0x05ae, B:255:0x05bc, B:256:0x05bf, B:258:0x05c7, B:259:0x05cf, B:261:0x05d7, B:263:0x05e3, B:264:0x05e7, B:267:0x05f0, B:268:0x05fa, B:311:0x06d0, B:313:0x06d8, B:319:0x06fc, B:322:0x0702, B:324:0x0709, B:326:0x0711, B:327:0x0719, B:329:0x0721, B:344:0x0757, B:345:0x075a, B:355:0x0793, B:357:0x079b, B:354:0x078f, B:314:0x06e2, B:310:0x06cd, B:226:0x04d3, B:230:0x052d, B:365:0x07b4, B:366:0x07b9), top: B:395:0x00bb }] */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BDLocation(String str) throws JSONException {
        ?? r2;
        boolean z;
        Exception exc;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z2;
        Exception exc2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String string;
        String str15;
        String str16;
        String string2;
        boolean z3;
        String str17;
        String str18;
        String str19;
        String string3;
        int i;
        int i2;
        String str20;
        String str21;
        String str22;
        String str23;
        String string4;
        String string5;
        String str24;
        String[] strArrSplit;
        int iIntValue;
        this.f3383a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            try {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                    int i3 = Integer.parseInt(jSONObject3.getString("error"));
                    setLocType(i3);
                    setTime(jSONObject3.getString("time"));
                    if (i3 == 61) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                        JSONObject jSONObject5 = jSONObject4.getJSONObject(OapsKey.KEY_POINT);
                        setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                        setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                        setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                        setSpeed(Float.parseFloat(jSONObject4.getString("s")));
                        setDirection(Float.parseFloat(jSONObject4.getString("d")));
                        setSatelliteNumber(Integer.parseInt(jSONObject4.getString("n")));
                        if (jSONObject4.has("is_mock")) {
                            setMockGpsStrategy(jSONObject4.getInt("is_mock"));
                        }
                        if (jSONObject4.has("h")) {
                            try {
                                setAltitude(jSONObject4.getDouble("h"));
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            if (jSONObject4.has("in_cn")) {
                                setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                            } else {
                                setLocationWhere(1);
                            }
                        } catch (Exception unused2) {
                        }
                        if (this.G != 0) {
                            setCoorType("gcj02");
                            return;
                        }
                        str2 = "wgs84";
                    } else {
                        str2 = "gcj02";
                        if (i3 == 161) {
                            JSONObject jSONObject6 = jSONObject2.getJSONObject("content");
                            JSONObject jSONObject7 = jSONObject6.getJSONObject(OapsKey.KEY_POINT);
                            setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                            setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                            setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                            if (jSONObject6.has(com.umeng.analytics.pro.f.F)) {
                                setTraffic(jSONObject6.getString(com.umeng.analytics.pro.f.F));
                            }
                            if (jSONObject6.has("traffic_prop")) {
                                setTrafficConfidence(Float.parseFloat(jSONObject6.optString("traffic_prop")));
                            }
                            if (jSONObject6.has("is_station")) {
                                setIsTrafficStation(jSONObject6.optInt("is_station"));
                            }
                            if (jSONObject6.has("traffic_skip_prop")) {
                                setTrafficSkipProb(Float.parseFloat(jSONObject6.optString("traffic_skip_prop")));
                            }
                            if (jSONObject6.has("sema")) {
                                JSONObject jSONObject8 = jSONObject6.getJSONObject("sema");
                                if (jSONObject8.has("aptag")) {
                                    String string6 = jSONObject8.getString("aptag");
                                    if (!TextUtils.isEmpty(string6)) {
                                        this.v = string6;
                                        str3 = "";
                                        if (jSONObject8.has("aptagd")) {
                                            JSONArray jSONArray = jSONObject8.getJSONObject("aptagd").getJSONArray("pois");
                                            ArrayList arrayList = new ArrayList();
                                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                                JSONObject jSONObject9 = jSONArray.getJSONObject(i4);
                                                arrayList.add(new Poi(jSONObject9.getString("pid"), jSONObject9.getString("pname"), jSONObject9.getDouble("pr"), jSONObject9.has("tags") ? jSONObject9.getString("tags") : str3, jSONObject9.has("addr") ? jSONObject9.getString("addr") : str3));
                                            }
                                            this.S = arrayList;
                                        }
                                        if (jSONObject8.has("poiregion")) {
                                            String string7 = jSONObject8.getString("poiregion");
                                            if (!TextUtils.isEmpty(string7)) {
                                                this.w = string7;
                                            }
                                        }
                                        if (jSONObject8.has("poi_regions")) {
                                            JSONObject jSONObject10 = jSONObject8.getJSONObject("poi_regions");
                                            this.af = new PoiRegion(jSONObject10.has("direction_desc") ? jSONObject10.getString("direction_desc") : str3, jSONObject10.has("name") ? jSONObject10.getString("name") : str3, jSONObject10.has("tag") ? jSONObject10.getString("tag") : str3, jSONObject10.has(DeviceInfoUtil.UID_TAG) ? jSONObject10.getString(DeviceInfoUtil.UID_TAG) : str3, jSONObject10.has(MapBundleKey.MapObjKey.OBJ_BID) ? jSONObject10.getString(MapBundleKey.MapObjKey.OBJ_BID) : str3);
                                        }
                                        if (jSONObject8.has("regular")) {
                                            String string8 = jSONObject8.getString("regular");
                                            if (!TextUtils.isEmpty(string8)) {
                                                this.x = string8;
                                            }
                                        }
                                    } else {
                                        str3 = "";
                                        this.v = str3;
                                        if (jSONObject8.has("aptagd")) {
                                        }
                                        if (jSONObject8.has("poiregion")) {
                                        }
                                        if (jSONObject8.has("poi_regions")) {
                                        }
                                        if (jSONObject8.has("regular")) {
                                        }
                                    }
                                } else {
                                    str3 = "";
                                    if (jSONObject8.has("aptagd")) {
                                    }
                                    if (jSONObject8.has("poiregion")) {
                                    }
                                    if (jSONObject8.has("poi_regions")) {
                                    }
                                    if (jSONObject8.has("regular")) {
                                    }
                                }
                            } else {
                                str3 = "";
                            }
                            if (jSONObject6.has("addr")) {
                                try {
                                    jSONObject = jSONObject6.getJSONObject("addr");
                                    z2 = true;
                                } catch (Exception unused3) {
                                    jSONObject = null;
                                    z2 = false;
                                }
                                if (jSONObject != null) {
                                    String string9 = jSONObject.has(DistrictSearchQuery.KEYWORDS_CITY) ? jSONObject.getString(DistrictSearchQuery.KEYWORDS_CITY) : str3;
                                    string3 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : str3;
                                    string = jSONObject.has("country") ? jSONObject.getString("country") : str3;
                                    String string10 = jSONObject.has(w.v) ? jSONObject.getString(w.v) : str3;
                                    if (jSONObject.has(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                                        string4 = jSONObject.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                                        str23 = string9;
                                    } else {
                                        str23 = string9;
                                        string4 = str3;
                                    }
                                    String string11 = jSONObject.has(DistrictSearchQuery.KEYWORDS_DISTRICT) ? jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT) : str3;
                                    String string12 = jSONObject.has("street") ? jSONObject.getString("street") : str3;
                                    String string13 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str3;
                                    String string14 = jSONObject.has("adcode") ? jSONObject.getString("adcode") : str3;
                                    String string15 = jSONObject.has("town") ? jSONObject.getString("town") : null;
                                    if (jSONObject.has("town_code")) {
                                        str13 = str23;
                                        str14 = "y";
                                        str4 = string12;
                                        string2 = jSONObject.getString("town_code");
                                        str17 = "x";
                                        str15 = string10;
                                        str7 = string11;
                                        str18 = string14;
                                        z3 = z2;
                                        str19 = string4;
                                        str8 = string13;
                                    } else {
                                        str13 = str23;
                                        str14 = "y";
                                        str15 = string10;
                                        str7 = string11;
                                        string2 = str3;
                                        z3 = z2;
                                        str4 = string12;
                                        str17 = "x";
                                        str19 = string4;
                                        str8 = string13;
                                        str18 = string14;
                                    }
                                    str12 = ",";
                                    str16 = string15;
                                } else {
                                    try {
                                        String[] strArrSplit2 = jSONObject6.getString("addr").split(",");
                                        int length = strArrSplit2.length;
                                        if (length > 0) {
                                            str5 = strArrSplit2[0];
                                            i = 1;
                                        } else {
                                            i = 1;
                                            str5 = null;
                                        }
                                        if (length > i) {
                                            try {
                                                str6 = strArrSplit2[i];
                                                i2 = 2;
                                            } catch (Exception e) {
                                                exc2 = e;
                                                str4 = null;
                                                str6 = null;
                                                str7 = null;
                                                str8 = null;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str25 = str9;
                                                str19 = str5;
                                                string3 = str25;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            i2 = 2;
                                            str6 = null;
                                        }
                                        if (length > i2) {
                                            try {
                                                str7 = strArrSplit2[i2];
                                            } catch (Exception e2) {
                                                exc2 = e2;
                                                str4 = null;
                                                str7 = null;
                                                str8 = null;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str252 = str9;
                                                str19 = str5;
                                                string3 = str252;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                    str24 = str12;
                                                    try {
                                                        if (string5.contains(str24)) {
                                                            iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
                                                            Integer.valueOf(strArrSplit[1]).intValue();
                                                            if (iIntValue > 0) {
                                                            }
                                                        }
                                                    } catch (Throwable th) {
                                                        th.printStackTrace();
                                                    }
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str7 = null;
                                        }
                                        if (length > 3) {
                                            try {
                                                str4 = strArrSplit2[3];
                                            } catch (Exception e3) {
                                                exc2 = e3;
                                                str4 = null;
                                                str8 = null;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str2522 = str9;
                                                str19 = str5;
                                                string3 = str2522;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str4 = null;
                                        }
                                        if (length > 4) {
                                            try {
                                                str8 = strArrSplit2[4];
                                            } catch (Exception e4) {
                                                exc2 = e4;
                                                str8 = null;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str25222 = str9;
                                                str19 = str5;
                                                string3 = str25222;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str8 = null;
                                        }
                                        if (length > 5) {
                                            try {
                                                str9 = strArrSplit2[5];
                                                str20 = str4;
                                            } catch (Exception e5) {
                                                exc2 = e5;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str252222 = str9;
                                                str19 = str5;
                                                string3 = str252222;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str20 = str4;
                                            str9 = null;
                                        }
                                        if (length > 6) {
                                            try {
                                                str10 = strArrSplit2[6];
                                            } catch (Exception e6) {
                                                str4 = str20;
                                                exc2 = e6;
                                                str10 = null;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str2522222 = str9;
                                                str19 = str5;
                                                string3 = str2522222;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str10 = null;
                                        }
                                        if (length > 7) {
                                            try {
                                                str11 = strArrSplit2[7];
                                            } catch (Exception e7) {
                                                str4 = str20;
                                                exc2 = e7;
                                                str11 = null;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str25222222 = str9;
                                                str19 = str5;
                                                string3 = str25222222;
                                                if (z3) {
                                                }
                                                if (jSONObject6.has("floor")) {
                                                }
                                                if (jSONObject6.has("indoor")) {
                                                }
                                                if (jSONObject6.has("loctp")) {
                                                }
                                                if (jSONObject6.has("bldgid")) {
                                                }
                                                if (jSONObject6.has("bldg")) {
                                                }
                                                if (jSONObject6.has("acc")) {
                                                }
                                                if (jSONObject6.has("ibav")) {
                                                }
                                                if (jSONObject6.has("indoorflags")) {
                                                }
                                                if (!jSONObject6.has("gpscs")) {
                                                }
                                                if (!jSONObject6.has("in_cn")) {
                                                }
                                                setCoorType(this.G != 0 ? "wgs84" : str22);
                                                if (jSONObject6.has("navi")) {
                                                }
                                                if (jSONObject6.has("navi_client")) {
                                                }
                                                if (jSONObject6.has("nrl_point")) {
                                                }
                                                if (jSONObject6.has("loc_nlp")) {
                                                }
                                            }
                                        } else {
                                            str11 = null;
                                        }
                                        if (length > 8) {
                                            try {
                                                str21 = strArrSplit2[8];
                                            } catch (Exception e8) {
                                                str4 = str20;
                                                exc2 = e8;
                                                exc2.printStackTrace();
                                                str12 = ",";
                                                str13 = str6;
                                                str14 = "y";
                                                string = str10;
                                                str15 = str11;
                                                str16 = null;
                                                string2 = null;
                                                z3 = false;
                                                str17 = "x";
                                                str18 = null;
                                                String str252222222 = str9;
                                                str19 = str5;
                                                string3 = str252222222;
                                            }
                                        } else {
                                            str21 = null;
                                        }
                                        str4 = str20;
                                        str12 = ",";
                                        str13 = str6;
                                        str14 = "y";
                                        string = str10;
                                        str16 = null;
                                        string2 = null;
                                        z3 = true;
                                        str18 = str21;
                                        str15 = str11;
                                        str17 = "x";
                                        String str26 = str9;
                                        str19 = str5;
                                        string3 = str26;
                                    } catch (Exception e9) {
                                        exc2 = e9;
                                        str4 = null;
                                        str5 = null;
                                    }
                                }
                                if (z3) {
                                    str22 = str2;
                                } else {
                                    str22 = str2;
                                    this.z = new Address.Builder().country(string).countryCode(str15).province(str19).city(str13).cityCode(string3).district(str7).street(str4).streetNumber(str8).adcode(str18).town(str16).townCode(string2).build();
                                    this.s = true;
                                }
                            } else {
                                str22 = str2;
                                str12 = ",";
                                str17 = "x";
                                str14 = "y";
                                this.s = false;
                                setAddrStr(null);
                            }
                            if (jSONObject6.has("floor")) {
                                String string16 = jSONObject6.getString("floor");
                                this.A = string16;
                                if (TextUtils.isEmpty(string16)) {
                                    this.A = null;
                                }
                            }
                            if (jSONObject6.has("indoor")) {
                                String string17 = jSONObject6.getString("indoor");
                                if (!TextUtils.isEmpty(string17)) {
                                    setUserIndoorState(Integer.valueOf(string17).intValue());
                                }
                            }
                            if (jSONObject6.has("loctp")) {
                                String string18 = jSONObject6.getString("loctp");
                                this.H = string18;
                                if (TextUtils.isEmpty(string18)) {
                                    this.H = null;
                                }
                            }
                            if (jSONObject6.has("bldgid")) {
                                String string19 = jSONObject6.getString("bldgid");
                                this.B = string19;
                                if (TextUtils.isEmpty(string19)) {
                                    this.B = null;
                                }
                            }
                            if (jSONObject6.has("bldg")) {
                                String string20 = jSONObject6.getString("bldg");
                                this.C = string20;
                                if (TextUtils.isEmpty(string20)) {
                                    this.C = null;
                                }
                            }
                            if (jSONObject6.has("acc")) {
                                this.D = jSONObject6.getDouble("acc");
                            }
                            if (jSONObject6.has("ibav")) {
                                String string21 = jSONObject6.getString("ibav");
                                if (!TextUtils.isEmpty(string21) && !string21.equals("0")) {
                                    this.F = Integer.valueOf(string21).intValue();
                                } else {
                                    this.F = 0;
                                }
                            }
                            if (jSONObject6.has("indoorflags")) {
                                try {
                                    JSONObject jSONObject11 = jSONObject6.getJSONObject("indoorflags");
                                    if (jSONObject11.has("area")) {
                                        int iIntValue2 = Integer.valueOf(jSONObject11.getString("area")).intValue();
                                        if (iIntValue2 == 0) {
                                            setIndoorLocationSurpport(2);
                                        } else if (iIntValue2 == 1) {
                                            setIndoorLocationSurpport(1);
                                        }
                                    }
                                    if (jSONObject11.has("support")) {
                                        setIndoorLocationSource(Integer.valueOf(jSONObject11.getString("support")).intValue());
                                    }
                                    if (jSONObject11.has("inbldg")) {
                                        this.O = jSONObject11.getString("inbldg");
                                    }
                                    if (jSONObject11.has("inbldgid")) {
                                        this.P = jSONObject11.getString("inbldgid");
                                    }
                                    if (jSONObject11.has("polygon")) {
                                        setIndoorSurpportPolygon(jSONObject11.getString("polygon"));
                                    }
                                    if (jSONObject11.has("ret_fields")) {
                                        try {
                                            for (String str27 : jSONObject11.getString("ret_fields").split("\\|")) {
                                                String[] strArrSplit3 = str27.split(ContainerUtils.KEY_VALUE_DELIMITER);
                                                if (strArrSplit3 != null && strArrSplit3.length >= 2) {
                                                    this.W.putString(strArrSplit3[0], strArrSplit3[1]);
                                                }
                                            }
                                        } catch (Exception unused4) {
                                        }
                                    }
                                    if (jSONObject11.has("inout_ble")) {
                                        int iOptInt = jSONObject11.optInt("inout_ble");
                                        setInOutStatus(iOptInt);
                                        if (iOptInt == 1) {
                                            setIsInIndoorPark(true);
                                        } else {
                                            setIsInIndoorPark(false);
                                        }
                                    } else {
                                        setInOutStatus(-1);
                                    }
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (!jSONObject6.has("gpscs")) {
                                setGpsCheckStatus(jSONObject6.getInt("gpscs"));
                            } else {
                                setGpsCheckStatus(0);
                            }
                            try {
                                if (!jSONObject6.has("in_cn")) {
                                    setLocationWhere(Integer.parseInt(jSONObject6.getString("in_cn")));
                                } else {
                                    setLocationWhere(1);
                                }
                            } catch (Exception unused5) {
                            }
                            setCoorType(this.G != 0 ? "wgs84" : str22);
                            if (jSONObject6.has("navi")) {
                                this.aa = jSONObject6.getString("navi");
                            }
                            if (jSONObject6.has("navi_client") && (string5 = jSONObject6.getString("navi_client")) != null) {
                                str24 = str12;
                                if (string5.contains(str24) && (strArrSplit = string5.split(str24)) != null && strArrSplit.length >= 2) {
                                    iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
                                    Integer.valueOf(strArrSplit[1]).intValue();
                                    if (iIntValue > 0) {
                                        this.ae = true;
                                    }
                                }
                            }
                            if (jSONObject6.has("nrl_point")) {
                                try {
                                    JSONObject jSONObject12 = jSONObject6.getJSONObject("nrl_point");
                                    String str28 = str17;
                                    if (jSONObject12.has(str28)) {
                                        String str29 = str14;
                                        if (jSONObject12.has(str29)) {
                                            this.ac = Double.parseDouble(jSONObject12.getString(str29));
                                            this.ad = Double.parseDouble(jSONObject12.getString(str28));
                                        }
                                    }
                                } catch (Throwable unused6) {
                                    this.ac = Double.MIN_VALUE;
                                    this.ad = Double.MIN_VALUE;
                                }
                            }
                            if (jSONObject6.has("loc_nlp")) {
                                return;
                            }
                            setSemanticParams(jSONObject6.getString("loc_nlp"));
                            return;
                        }
                        if (i3 != 66 && i3 != 68) {
                            if (i3 == 167) {
                                setLocationWhere(2);
                                return;
                            }
                            return;
                        }
                        JSONObject jSONObject13 = jSONObject2.getJSONObject("content");
                        JSONObject jSONObject14 = jSONObject13.getJSONObject(OapsKey.KEY_POINT);
                        setLatitude(Double.parseDouble(jSONObject14.getString("y")));
                        setLongitude(Double.parseDouble(jSONObject14.getString("x")));
                        setRadius(Float.parseFloat(jSONObject13.getString("radius")));
                        a(Boolean.valueOf(Boolean.parseBoolean(jSONObject13.getString("isCellChanged"))));
                    }
                    setCoorType(str2);
                } catch (Exception e11) {
                    exc = e11;
                    z = false;
                    exc.printStackTrace();
                    r2 = z;
                    this.f3383a = r2;
                    this.s = r2;
                }
            } catch (Exception e12) {
                z = false;
                exc = e12;
            }
        } catch (Error e13) {
            e13.printStackTrace();
            r2 = 0;
            this.f3383a = r2;
            this.s = r2;
        }
    }
}
