package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.w;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.baidu.platform.base.b {
    private LatLng b(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(jSONObjectOptJSONObject.optDouble("y"), jSONObjectOptJSONObject.optDouble("x"));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    private ReverseGeoCodeResult.AddressComponent c(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || TextUtils.isEmpty(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        ReverseGeoCodeResult.AddressComponent addressComponent = new ReverseGeoCodeResult.AddressComponent();
        addressComponent.city = jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        addressComponent.setTown(jSONObjectOptJSONObject.optString("town"));
        addressComponent.district = jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_DISTRICT);
        addressComponent.province = jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE);
        addressComponent.adcode = jSONObjectOptJSONObject.optInt("adcode");
        addressComponent.street = jSONObjectOptJSONObject.optString("street");
        addressComponent.streetNumber = jSONObjectOptJSONObject.optString("street_number");
        addressComponent.countryName = jSONObjectOptJSONObject.optString("country");
        addressComponent.countryCode = jSONObjectOptJSONObject.optInt(w.v);
        addressComponent.setDirection(jSONObjectOptJSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        addressComponent.setDistance(jSONObjectOptJSONObject.optString("distance"));
        addressComponent.countryCodeIso = jSONObjectOptJSONObject.optString("country_code_iso");
        addressComponent.countryCodeIso2 = jSONObjectOptJSONObject.optString("country_code_iso2");
        addressComponent.townCode = jSONObjectOptJSONObject.optString("town_code");
        addressComponent.cityLevel = jSONObjectOptJSONObject.optInt("cityLevel");
        return addressComponent;
    }

    private List<ReverseGeoCodeResult.PoiRegionsInfo> d(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                ReverseGeoCodeResult.PoiRegionsInfo poiRegionsInfo = new ReverseGeoCodeResult.PoiRegionsInfo();
                poiRegionsInfo.setDirectionDesc(jSONObjectOptJSONObject.optString("direction_desc"));
                poiRegionsInfo.setRegionName(jSONObjectOptJSONObject.optString("name"));
                poiRegionsInfo.setRegionTag(jSONObjectOptJSONObject.optString("tag"));
                arrayList.add(poiRegionsInfo);
            }
        }
        return arrayList;
    }

    private List<ReverseGeoCodeResult.RoadInfo> e(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                ReverseGeoCodeResult.RoadInfo roadInfo = new ReverseGeoCodeResult.RoadInfo();
                roadInfo.name = jSONObjectOptJSONObject.optString("name");
                roadInfo.distance = jSONObjectOptJSONObject.optString("distance");
                arrayList.add(roadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        ReverseGeoCodeResult reverseGeoCodeResult = new ReverseGeoCodeResult();
        if (str == null || str.equals("")) {
            reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return reverseGeoCodeResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    reverseGeoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return reverseGeoCodeResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return reverseGeoCodeResult;
                }
            }
            if (!a(str, (SearchResult) reverseGeoCodeResult, false)) {
                a(str, reverseGeoCodeResult);
            }
            return reverseGeoCodeResult;
        } catch (Exception unused) {
            reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return reverseGeoCodeResult;
        }
    }

    private boolean a(String str, ReverseGeoCodeResult reverseGeoCodeResult) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    int iOptInt = jSONObject.optInt("status");
                    if (iOptInt == 0) {
                        if (a(jSONObject, reverseGeoCodeResult)) {
                            return true;
                        }
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return false;
                    }
                    if (iOptInt == 1) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    } else if (iOptInt != 2) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    } else {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    }
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
        }
        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return false;
    }

    private boolean a(JSONObject jSONObject, ReverseGeoCodeResult reverseGeoCodeResult) {
        JSONObject jSONObjectOptJSONObject;
        String str;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null) {
            return false;
        }
        reverseGeoCodeResult.setCityCode(jSONObjectOptJSONObject.optInt("cityCode"));
        reverseGeoCodeResult.setAddress(jSONObjectOptJSONObject.optString("formatted_address"));
        reverseGeoCodeResult.setBusinessCircle(jSONObjectOptJSONObject.optString("business"));
        ReverseGeoCodeResult.AddressComponent addressComponentC = c(jSONObjectOptJSONObject, "addressComponent");
        reverseGeoCodeResult.setAddressDetail(addressComponentC);
        reverseGeoCodeResult.setLocation(a(jSONObjectOptJSONObject, "location"));
        if (addressComponentC != null) {
            str = addressComponentC.city;
            reverseGeoCodeResult.setAdcode(addressComponentC.adcode);
        } else {
            str = "";
        }
        reverseGeoCodeResult.setPoiList(a(jSONObjectOptJSONObject, "pois", str));
        reverseGeoCodeResult.setSematicDescription(jSONObjectOptJSONObject.optString("sematic_description"));
        reverseGeoCodeResult.setFormattedPoiAddress(jSONObjectOptJSONObject.optString("formatted_address_poi"));
        reverseGeoCodeResult.setPoiRegionsInfoList(d(jSONObjectOptJSONObject, "poiRegions"));
        reverseGeoCodeResult.setRoadInfoList(e(jSONObjectOptJSONObject, "roads"));
        reverseGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private LatLng a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(jSONObjectOptJSONObject.optDouble(f.C), jSONObjectOptJSONObject.optDouble(f.D));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    private List<PoiInfo> a(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || str == null || "".equals(str) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.setAddress(jSONObjectOptJSONObject.optString("addr"));
                poiInfo.setPhoneNum(jSONObjectOptJSONObject.optString("tel"));
                poiInfo.setUid(jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG));
                poiInfo.setPostCode(jSONObjectOptJSONObject.optString("zip"));
                poiInfo.setName(jSONObjectOptJSONObject.optString("name"));
                poiInfo.setLocation(b(jSONObjectOptJSONObject, OapsKey.KEY_POINT));
                poiInfo.setCity(str2);
                poiInfo.setDirection(jSONObjectOptJSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                poiInfo.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                poiInfo.setTag(jSONObjectOptJSONObject.optString("tag"));
                poiInfo.setParentPoi(a(jSONObjectOptJSONObject.optJSONObject("parent_poi")));
                arrayList.add(poiInfo);
            }
        }
        return arrayList;
    }

    private PoiInfo.ParentPoiInfo a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        PoiInfo.ParentPoiInfo parentPoiInfo = new PoiInfo.ParentPoiInfo();
        parentPoiInfo.setParentPoiAddress(jSONObject.optString("addr"));
        parentPoiInfo.setParentPoiDirection(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        parentPoiInfo.setParentPoiDistance(jSONObject.optInt("distance"));
        parentPoiInfo.setParentPoiName(jSONObject.optString("name"));
        parentPoiInfo.setParentPoiTag(jSONObject.optString("tag"));
        parentPoiInfo.setParentPoiUid(jSONObject.optString(DeviceInfoUtil.UID_TAG));
        parentPoiInfo.setParentPoiLocation(b(jSONObject, OapsKey.KEY_POINT));
        return parentPoiInfo;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetReverseGeoCodeResult((ReverseGeoCodeResult) searchResult);
    }
}
