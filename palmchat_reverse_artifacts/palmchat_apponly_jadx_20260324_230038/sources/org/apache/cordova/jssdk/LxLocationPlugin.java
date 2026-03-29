package org.apache.cordova.jssdk;

import android.content.ComponentName;
import android.content.Intent;
import com.amap.api.services.district.DistrictSearchQuery;
import com.kuaishou.weapon.p0.g;
import com.zenmen.openapi.auth.widget.a;
import com.zenmen.openapi.jssdk.widget.PermissionDialogView;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.b;
import defpackage.i53;
import defpackage.n53;
import defpackage.w43;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxLocationPlugin extends CordovaPlugin implements i53 {
    private static final int PERMISSION_REQUEST_LOCATION = 0;
    private static final int PERMISSION_REQUEST_SELECT_LOCATION = 1;
    private static final int REQUEST_SELECT_LOCATION = 0;
    private CallbackContext mCallbackContext;
    private boolean mEnableMapDrag;
    private b mLocationClient;
    private int mPoiSearchRadius;

    private void initLocationClient() {
        b bVarA = b.a(this.cordova.getActivity(), null, LocationScene.WEB);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void selectLocation() {
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
        this.cordova.getActivity().startActivity(intent);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        this.mCallbackContext = callbackContext;
        if (str.equals("lx_getLocation")) {
            JSONObject jSONObject = new JSONObject(str2);
            PermissionDialogView.a aVar = new PermissionDialogView.a();
            CordovaWebView cordovaWebView = this.webView;
            aVar.f12022a = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
            aVar.b = g.g;
            aVar.c = jSONObject.optString("requestTarget");
            w43.e(this.cordova.getActivity(), aVar, new a.b() { // from class: org.apache.cordova.jssdk.LxLocationPlugin.1
                @Override // com.zenmen.openapi.auth.widget.a.b
                public void onConfirmback(int i) {
                    if (LxLocationPlugin.this.cordova.getActivity() == null) {
                        return;
                    }
                    if (i != 0) {
                        LxLocationPlugin.this.mCallbackContext.error("Permission denied");
                    } else if (LxLocationPlugin.this.webView.hasPermission(g.g)) {
                        LxLocationPlugin.this.mLocationClient.o();
                    } else {
                        LxLocationPlugin lxLocationPlugin = LxLocationPlugin.this;
                        lxLocationPlugin.webView.requestPermission(lxLocationPlugin, 0, g.g);
                    }
                }
            });
            return true;
        }
        if (str.equals("lx_selectLocation")) {
            JSONObject jSONObject2 = new JSONObject(str2);
            this.mEnableMapDrag = jSONObject2.optBoolean("enableMapDrag", true);
            this.mPoiSearchRadius = jSONObject2.optInt("poiSearchRadius", 500);
            PermissionDialogView.a aVar2 = new PermissionDialogView.a();
            CordovaWebView cordovaWebView2 = this.webView;
            aVar2.f12022a = cordovaWebView2.pluginManager.getAppInfo(cordovaWebView2.loadedUrl);
            aVar2.b = g.g;
            aVar2.c = jSONObject2.optString("requestTarget");
            w43.e(this.cordova.getActivity(), aVar2, new a.b() { // from class: org.apache.cordova.jssdk.LxLocationPlugin.2
                @Override // com.zenmen.openapi.auth.widget.a.b
                public void onConfirmback(int i) {
                    if (i != 0) {
                        LxLocationPlugin.this.mCallbackContext.error("Permission denied");
                    } else if (LxLocationPlugin.this.webView.hasPermission(g.g)) {
                        LxLocationPlugin.this.selectLocation();
                    } else {
                        LxLocationPlugin lxLocationPlugin = LxLocationPlugin.this;
                        lxLocationPlugin.webView.requestPermission(lxLocationPlugin, 1, g.g);
                    }
                }
            });
            return true;
        }
        if (!str.equals("lx_showLocation")) {
            return false;
        }
        JSONObject jSONObject3 = new JSONObject(str2);
        LocationEx locationEx = new LocationEx();
        locationEx.setLatitude(jSONObject3.optDouble("latitude", 0.0d));
        locationEx.setLongitude(jSONObject3.optDouble("longitude", 0.0d));
        locationEx.setName(jSONObject3.optString("name"));
        locationEx.setAddress(jSONObject3.optString("address"));
        showLocation(locationEx);
        callbackContext.success();
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
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

    @Override // org.apache.cordova.CordovaPlugin
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
            jSONObject3.put("address", locationEx.getAddress());
            jSONObject3.put("coorType", locationEx.getCoorType());
            jSONObject3.put("name", locationEx.getName());
            jSONObject3.put(DistrictSearchQuery.KEYWORDS_CITY, locationEx.getCity());
            jSONObject3.put("cityCode", locationEx.getCityCode());
            jSONObject3.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationEx.getProvince());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mCallbackContext.success(jSONObject3);
    }

    @Override // org.apache.cordova.CordovaPlugin
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

    @Override // org.apache.cordova.CordovaPlugin
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
