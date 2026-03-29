package org.apache.cordova.jssdk;

import android.os.CountDownTimer;
import android.util.Log;
import com.amap.api.services.district.DistrictSearchQuery;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.b;
import com.zenmen.palmchat.location.d;
import defpackage.hx3;
import defpackage.i53;
import defpackage.n53;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocationPlugin extends CordovaPlugin implements i53 {
    private static final String TAG = "DevicePlugin";
    private CallbackContext mCallbackContext;
    private CountDownTimer mCountDownTimer = new CountDownTimer(30000, 1000) { // from class: org.apache.cordova.jssdk.LocationPlugin.1
        @Override // android.os.CountDownTimer
        public void onFinish() {
            LocationPlugin.this.onLocationReceived(d.g().i(1800000L), 0, "");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    };
    private b mLocationClient;
    private LocationEx mMyLocation;

    private void getLocation() {
        b bVarA = b.a(this.cordova.getActivity(), null, LocationScene.WEB);
        this.mLocationClient = bVarA;
        bVarA.i(this);
        this.mMyLocation = null;
        this.mLocationClient.o();
        this.mCountDownTimer.start();
    }

    private boolean isLocationValid(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        if (!Action.ACTION_GET_LOCATION.equals(str)) {
            return false;
        }
        getLocation();
        return true;
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        this.mCountDownTimer.cancel();
        this.mLocationClient.q();
        if (this.mMyLocation == null && isLocationValid(locationEx)) {
            this.mMyLocation = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), "", locationEx.getAddress());
            if (!hx3.m(this.cordova.getActivity())) {
                this.mCallbackContext.error("Failed to get location");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("latitude", this.mMyLocation.getLatitude());
                jSONObject.put("longitude", this.mMyLocation.getLongitude());
                jSONObject.put("coorType", this.mMyLocation.getCoorType());
                jSONObject.put("address", this.mMyLocation.getAddress());
                jSONObject.put("name", locationEx.getName());
                jSONObject.put("cityCode", locationEx.getCityCode());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, locationEx.getCity());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationEx.getProvince());
                this.mCallbackContext.success(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
    }
}
