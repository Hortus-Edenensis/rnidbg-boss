package org.apache.cordova.jssdk.general;

import com.amap.api.services.district.DistrictSearchQuery;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.b;
import com.zenmen.palmchat.location.d;
import defpackage.i53;
import defpackage.n53;
import defpackage.v93;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocationPlugin extends SubPlugin implements i53 {
    private static final int PERMISSION_REQUEST_LOCATION = 0;
    private static final int PERMISSION_REQUEST_SELECT_LOCATION = 1;
    private static final int REQUEST_SELECT_LOCATION = 0;
    private v93 mCallback;
    private b mLocationClient;

    private void initLocationAndStart() {
        if (this.mLocationClient == null) {
            this.mLocationClient = b.a(this.mCordovaInterface.getWebView().getContext(), null, LocationScene.WEB);
        }
        this.mLocationClient.i(this);
        this.mLocationClient.o();
    }

    private boolean isLocationValid(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        JSONObject jSONObjectMakeErrorArgsMsg;
        this.mCallback = v93Var;
        str.hashCode();
        if (str.equals(Action.ACTION_GET_LOCATION)) {
            if (this.mCordovaInterface.hasPermission(g.g)) {
                initLocationAndStart();
                return;
            } else {
                this.mCordovaInterface.requestPermission(this, 0, g.g);
                return;
            }
        }
        if (!str.equals(Action.ACTION_GET_LAST_LOCATION)) {
            super.exec(str, jSONObject, v93Var);
            return;
        }
        LocationEx locationExI = d.g().i(Long.MAX_VALUE);
        if (isLocationValid(locationExI)) {
            jSONObjectMakeErrorArgsMsg = makeDefaultSucMsg();
            try {
                jSONObjectMakeErrorArgsMsg.put("latitude", locationExI.getLatitude());
                jSONObjectMakeErrorArgsMsg.put("longitude", locationExI.getLongitude());
                jSONObjectMakeErrorArgsMsg.put("coorType", locationExI.getCoorType());
                jSONObjectMakeErrorArgsMsg.put("address", locationExI.getAddress());
                jSONObjectMakeErrorArgsMsg.put("name", locationExI.getName());
                jSONObjectMakeErrorArgsMsg.put("cityCode", locationExI.getCityCode());
                jSONObjectMakeErrorArgsMsg.put(DistrictSearchQuery.KEYWORDS_CITY, locationExI.getCity());
                jSONObjectMakeErrorArgsMsg.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationExI.getProvince());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            jSONObjectMakeErrorArgsMsg = makeErrorArgsMsg();
        }
        this.mCallback.a(jSONObjectMakeErrorArgsMsg);
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        JSONObject jSONObjectMakeErrorArgsMsg;
        b bVar = this.mLocationClient;
        if (bVar != null) {
            bVar.r(this);
            this.mLocationClient.q();
        }
        if (isLocationValid(locationEx)) {
            jSONObjectMakeErrorArgsMsg = makeDefaultSucMsg();
            try {
                jSONObjectMakeErrorArgsMsg.put("latitude", locationEx.getLatitude());
                jSONObjectMakeErrorArgsMsg.put("longitude", locationEx.getLongitude());
                jSONObjectMakeErrorArgsMsg.put("coorType", locationEx.getCoorType());
                jSONObjectMakeErrorArgsMsg.put("address", locationEx.getAddress());
                jSONObjectMakeErrorArgsMsg.put("name", locationEx.getName());
                jSONObjectMakeErrorArgsMsg.put("cityCode", locationEx.getCityCode());
                jSONObjectMakeErrorArgsMsg.put(DistrictSearchQuery.KEYWORDS_CITY, locationEx.getCity());
                jSONObjectMakeErrorArgsMsg.put(DistrictSearchQuery.KEYWORDS_PROVINCE, locationEx.getProvince());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            jSONObjectMakeErrorArgsMsg = makeErrorArgsMsg();
        }
        this.mCallback.a(jSONObjectMakeErrorArgsMsg);
    }

    @Override // defpackage.ib3
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        super.onRequestPermissionResult(i, strArr, iArr);
        if (i == 0 && iArr.length > 0 && iArr[0] == 0) {
            initLocationAndStart();
        } else {
            if (i == 1 && iArr.length > 0 && iArr[0] == 0) {
                return;
            }
            this.mCallback.a(makePermissionDeniedArgsMsg());
        }
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
    }
}
