package com.baidu.platform.core.poi;

import android.text.TextUtils;
import android.util.Log;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.SearchType;
import com.cdo.oaps.ad.OapsKey;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f extends com.baidu.platform.base.b {
    private static final String b = "f";
    private int c;
    private int d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4266a;

        static {
            int[] iArr = new int[SearchType.values().length];
            f4266a = iArr;
            try {
                iArr[SearchType.POI_NEAR_BY_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4266a[SearchType.POI_IN_CITY_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4266a[SearchType.POI_IN_BOUND_SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    private PoiDetailInfo b(String str) {
        PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                return null;
            }
            poiDetailInfo.setDistance(jSONObject.optInt("distance", 0));
            poiDetailInfo.setTag(jSONObject.optString("tag"));
            poiDetailInfo.setDetailUrl(jSONObject.optString("detail_url"));
            poiDetailInfo.setType(jSONObject.optString("type"));
            poiDetailInfo.setPrice(jSONObject.optDouble(OapsKey.KEY_PRICE, 0.0d));
            poiDetailInfo.setOverallRating(jSONObject.optDouble("overall_rating", 0.0d));
            poiDetailInfo.setTasteRating(jSONObject.optDouble("taste_rating", 0.0d));
            poiDetailInfo.setServiceRating(jSONObject.optDouble("service_rating", 0.0d));
            poiDetailInfo.setEnvironmentRating(jSONObject.optDouble("environment_rating", 0.0d));
            poiDetailInfo.setFacilityRating(jSONObject.optDouble("facility_rating", 0.0d));
            poiDetailInfo.setHygieneRating(jSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailInfo.setTechnologyRating(jSONObject.optDouble("technology_rating", 0.0d));
            poiDetailInfo.setImage(jSONObject.optString("image"));
            poiDetailInfo.setImageNum(jSONObject.optInt("image_num"));
            poiDetailInfo.setGrouponNum(jSONObject.optInt("groupon_num"));
            poiDetailInfo.setCommentNum(jSONObject.optInt("comment_num"));
            poiDetailInfo.setDiscountNum(jSONObject.optInt("discount_num"));
            poiDetailInfo.setFavoriteNum(jSONObject.optInt("favorite_num"));
            poiDetailInfo.setCheckinNum(jSONObject.optInt("checkin_num"));
            poiDetailInfo.setBrand(jSONObject.optString("brand"));
            poiDetailInfo.setLabel(jSONObject.optString("label"));
            poiDetailInfo.setShopHours(jSONObject.optString("shop_hours"));
            poiDetailInfo.setLabel(jSONObject.optString("label"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("photos");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(jSONArrayOptJSONArray.optString(i))) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i));
                    }
                }
                poiDetailInfo.setPhotos(arrayList);
            }
            poiDetailInfo.naviLocation = a(jSONObject.optJSONObject("navi_location"));
            SearchType searchTypeA = a();
            if (SearchType.POI_IN_CITY_SEARCH == searchTypeA || SearchType.POI_NEAR_BY_SEARCH == searchTypeA) {
                poiDetailInfo.setPoiChildrenInfoList(b(jSONObject));
            }
            return poiDetailInfo;
        } catch (JSONException e) {
            Log.e(b, "Parse poi search detail info failed", e);
            return null;
        }
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        PoiResult poiResult = new PoiResult();
        if (str == null || str.equals("") || str.isEmpty()) {
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    poiResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return poiResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    strOptString.hashCode();
                    if (strOptString.equals("NETWORK_ERROR")) {
                        poiResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        poiResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return poiResult;
                }
            }
            if (a(str, poiResult, false)) {
                return poiResult;
            }
            poiResult.error = a(str, poiResult) ? SearchResult.ERRORNO.NO_ERROR : SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        } catch (JSONException e) {
            Log.e(b, "Parse poi search error", e);
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        }
    }

    private boolean a(String str, PoiResult poiResult) {
        if (str != null && !str.equals("") && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("status");
                if (iOptInt == 0) {
                    return a(jSONObject, poiResult);
                }
                if (iOptInt == 1) {
                    poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                } else if (iOptInt != 2) {
                    poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                } else {
                    poiResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                }
                return false;
            } catch (JSONException e) {
                Log.e(b, "Parse poi search failed", e);
                poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return false;
    }

    private boolean a(JSONObject jSONObject, PoiResult poiResult) {
        if (jSONObject != null && jSONObject.length() != 0) {
            poiResult.error = SearchResult.ERRORNO.NO_ERROR;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("results");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                String strOptString = jSONObject.optString("result_type");
                if (!TextUtils.isEmpty(strOptString)) {
                    poiResult.setResultType(strOptString);
                }
                String strOptString2 = jSONObject.optString("query_type");
                if (!TextUtils.isEmpty(strOptString2)) {
                    poiResult.setQueryType(strOptString2);
                }
                int iOptInt = jSONObject.optInt("total");
                poiResult.setTotalPoiNum(iOptInt);
                int length = jSONArrayOptJSONArray.length();
                poiResult.setCurrentPageCapacity(length);
                poiResult.setCurrentPageNum(this.c);
                if (length != 0) {
                    int i = this.d;
                    poiResult.setTotalPageNum((iOptInt / i) + (iOptInt % i > 0 ? 1 : 0));
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i2);
                    if (jSONObject2 != null && jSONObject2.length() != 0) {
                        PoiInfo poiInfo = new PoiInfo();
                        poiInfo.setName(jSONObject2.optString("name"));
                        poiInfo.setAddress(jSONObject2.optString("address"));
                        poiInfo.setProvince(jSONObject2.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                        poiInfo.setCity(jSONObject2.optString(DistrictSearchQuery.KEYWORDS_CITY));
                        poiInfo.setArea(jSONObject2.optString("area"));
                        poiInfo.setStreetId(jSONObject2.optString("street_id"));
                        poiInfo.setUid(jSONObject2.optString(DeviceInfoUtil.UID_TAG));
                        poiInfo.setPhoneNum(jSONObject2.optString("telephone"));
                        poiInfo.setDetail(jSONObject2.optInt("detail"));
                        poiInfo.setAdCode(jSONObject2.optInt("adcode"));
                        poiInfo.setLocation(a(jSONObject2.optJSONObject("location")));
                        String strOptString3 = jSONObject2.optString("detail_info");
                        if (strOptString3 != null && strOptString3.length() != 0) {
                            poiInfo.setPoiDetailInfo(b(strOptString3));
                        }
                        arrayList.add(poiInfo);
                    }
                }
                poiResult.setPoiInfo(arrayList);
                return true;
            }
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        return false;
    }

    private List<PoiChildrenInfo> b(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG));
                poiChildrenInfo.setName(jSONObjectOptJSONObject.optString("name"));
                poiChildrenInfo.setShowName(jSONObjectOptJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(jSONObjectOptJSONObject.optString("tag"));
                poiChildrenInfo.setLocation(a(jSONObjectOptJSONObject.optJSONObject("location")));
                poiChildrenInfo.setAddress(jSONObjectOptJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double dOptDouble = jSONObject.optDouble(com.umeng.analytics.pro.f.C);
        double dOptDouble2 = jSONObject.optDouble(com.umeng.analytics.pro.f.D);
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(new LatLng(dOptDouble, dOptDouble2));
        }
        return new LatLng(dOptDouble, dOptDouble2);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        int i = a.f4266a[a().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiResult((PoiResult) searchResult);
        }
    }
}
