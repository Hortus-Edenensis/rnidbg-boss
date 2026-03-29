package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MapPoi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3644a;
    LatLng b;
    String c;
    TrafficUGCType d = TrafficUGCType.NoTrafficUGC;

    /* JADX INFO: compiled from: SearchBox */
    public enum TrafficUGCType {
        NoTrafficUGC,
        TrafficConstruction,
        TrafficJam,
        TrafficBlocking,
        TrafficEmergency
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
        this.f3644a = strOptString;
        if (strOptString != null && !strOptString.equals("")) {
            this.f3644a = this.f3644a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.b = CoordUtil.decodeNodeLocation(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
        this.c = jSONObject.optString("ud");
        int i = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);
        if (i == 0) {
            this.d = TrafficUGCType.TrafficConstruction;
            return;
        }
        if (i == 2040) {
            this.d = TrafficUGCType.TrafficJam;
            return;
        }
        if (i == 2041) {
            this.d = TrafficUGCType.TrafficBlocking;
        } else if (i == 2042) {
            this.d = TrafficUGCType.TrafficEmergency;
        } else {
            this.d = TrafficUGCType.NoTrafficUGC;
        }
    }

    public String getName() {
        return this.f3644a;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public TrafficUGCType getTrafficUGCType() {
        return this.d;
    }

    public String getUid() {
        return this.c;
    }
}
