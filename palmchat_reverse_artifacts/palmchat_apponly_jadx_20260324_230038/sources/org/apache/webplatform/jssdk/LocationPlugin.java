package org.apache.webplatform.jssdk;

import android.content.ComponentName;
import android.content.Intent;
import com.amap.api.services.district.DistrictSearchQuery;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.b;
import defpackage.i53;
import defpackage.n53;
import java.util.List;
import org.apache.cordova.jssdk.general.Action;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocationPlugin extends CordovaPlugin implements i53 {
    private static final int PERMISSION_REQUEST_LOCATION = 0;
    private static final int PERMISSION_REQUEST_SELECT_LOCATION = 1;
    private static final int REQUEST_SELECT_LOCATION = 0;
    private CallbackContext mCallbackContext;
    private boolean mEnableMapDrag;
    private b mLocationClient;
    private int mPoiSearchRadius;

    private void initLocationClient() {
        b bVarA = b.a(this.cordova.getContext(), null, LocationScene.WEB);
        this.mLocationClient = bVarA;
        bVarA.i(this);
    }

    private boolean isLocationValid(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    private void selectLocation() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.cordova.getActivity(), "com.zenmen.palmchat.location.LocationSelectActivity"));
        intent.putExtra("enable_map_drag", this.mEnableMapDrag);
        intent.putExtra("poi_search_radius", this.mPoiSearchRadius);
        this.cordova.startActivityForResult(this, intent, 0);
    }

    private void showLocation(LocationEx locationEx) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.cordova.getActivity(), "com.zenmen.palmchat.location.LocationViewActivity"));
        intent.putExtra("location", locationEx);
        intent.putExtra("showPopupMenu", false);
        this.cordova.getContext().startActivity(intent);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        this.mCallbackContext = callbackContext;
        if (str.equals(Action.ACTION_GET_LOCATION)) {
            if (this.cordova.hasPermission(g.g)) {
                this.mLocationClient.o();
            } else {
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                if (sPUtil.a(scene, "key_h5_location_require", false)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", -1);
                    jSONObject.put("msg", "permission denied");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", jSONObject);
                    this.mCallbackContext.success(jSONObject2);
                } else {
                    sPUtil.t(scene, "key_h5_location_require", Boolean.TRUE);
                    this.cordova.requestPermission(this, 0, g.g);
                }
            }
            return true;
        }
        if (str.equals("selectLocation")) {
            this.mEnableMapDrag = jSONArray.optBoolean(0, true);
            this.mPoiSearchRadius = jSONArray.optInt(1, 500);
            if (this.cordova.hasPermission(g.g)) {
                selectLocation();
            } else {
                this.cordova.requestPermission(this, 1, g.g);
            }
            return true;
        }
        if (!str.equals("showLocation")) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject != null) {
            LocationEx locationEx = new LocationEx();
            locationEx.setLatitude(jSONObjectOptJSONObject.optDouble("latitude", 0.0d));
            locationEx.setLongitude(jSONObjectOptJSONObject.optDouble("longitude", 0.0d));
            locationEx.setName(jSONObjectOptJSONObject.optString("name"));
            locationEx.setAddress(jSONObjectOptJSONObject.optString("address"));
            showLocation(locationEx);
        }
        callbackContext.success();
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0 || i2 != -1) {
            this.mCallbackContext.error("");
            return;
        }
        LocationEx locationEx = (LocationEx) intent.getParcelableExtra("location");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("latitude", locationEx.getLatitude());
            jSONObject.put("longitude", locationEx.getLongitude());
            jSONObject.put("address", locationEx.getAddress());
            jSONObject.put("name", locationEx.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mCallbackContext.success(jSONObject);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        this.mLocationClient.r(this);
        this.mLocationClient.q();
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        if (!isLocationValid(locationEx)) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -2);
                jSONObject2.put("msg", "location invalid");
                jSONObject.put("error", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mCallbackContext.success(jSONObject);
            return;
        }
        this.mLocationClient.q();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("latitude", locationEx.getLatitude());
            jSONObject3.put("longitude", locationEx.getLongitude());
            jSONObject3.put("coorType", locationEx.getCoorType());
            jSONObject3.put("address", locationEx.getAddress());
            jSONObject3.put("name", locationEx.getName());
            jSONObject3.put("cityCode", locationEx.getCityCode());
            jSONObject3.put(DistrictSearchQuery.KEYWORDS_CITY, locationEx.getCity());
            jSONObject3.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationEx.getProvince());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mCallbackContext.success(jSONObject3);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        super.onRequestPermissionResult(i, strArr, iArr);
        if (i == 0 && iArr.length > 0 && iArr[0] == 0) {
            this.mLocationClient.o();
            return;
        }
        if (i == 1 && iArr.length > 0 && iArr[0] == 0) {
            selectLocation();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", -1);
        jSONObject.put("msg", "permission denied");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("error", jSONObject);
        this.mCallbackContext.success(jSONObject2);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void pluginInitialize() {
        super.pluginInitialize();
        initLocationClient();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
    }
}
