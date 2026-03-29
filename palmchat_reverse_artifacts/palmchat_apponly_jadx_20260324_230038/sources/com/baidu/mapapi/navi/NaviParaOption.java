package com.baidu.mapapi.navi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.umeng.analytics.pro.f;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NaviParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LatLng f3743a;
    String b;
    String c;
    LatLng d;
    String e;
    String f;
    WayPoint g;
    NaviRoutePolicy h = NaviRoutePolicy.DEFAULT;

    /* JADX INFO: compiled from: SearchBox */
    public enum NaviRoutePolicy {
        BLK,
        TIME,
        DIS,
        FEE,
        HIGHWAY,
        DEFAULT
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3745a;

        static {
            int[] iArr = new int[NaviRoutePolicy.values().length];
            f3745a = iArr;
            try {
                iArr[NaviRoutePolicy.BLK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3745a[NaviRoutePolicy.TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3745a[NaviRoutePolicy.DIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3745a[NaviRoutePolicy.FEE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3745a[NaviRoutePolicy.HIGHWAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3745a[NaviRoutePolicy.DEFAULT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public NaviParaOption endName(String str) {
        this.e = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.d = latLng;
        return this;
    }

    public NaviParaOption endUid(String str) {
        this.f = str;
        return this;
    }

    public String getEndName() {
        return this.e;
    }

    public LatLng getEndPoint() {
        return this.d;
    }

    public String getEndUid() {
        return this.f;
    }

    public String getNaviRoutePolicy() {
        int i = a.f3745a[this.h.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "DEFAULT" : "HIGHWAY" : "FEE" : "DIS" : "TIME" : "BLK";
    }

    public String getStartName() {
        return this.b;
    }

    public LatLng getStartPoint() {
        return this.f3743a;
    }

    public String getStartUid() {
        return this.c;
    }

    public JSONArray getWayPoint() {
        WayPoint wayPoint = this.g;
        JSONArray jSONArray = null;
        if (wayPoint == null) {
            return null;
        }
        List<WayPointInfo> viaPoints = wayPoint.getViaPoints();
        if (viaPoints != null && viaPoints.size() != 0) {
            jSONArray = new JSONArray();
            for (int i = 0; i < viaPoints.size(); i++) {
                JSONObject jSONObject = new JSONObject();
                WayPointInfo wayPointInfo = viaPoints.get(i);
                if (wayPointInfo != null) {
                    try {
                        if (!TextUtils.isEmpty(wayPointInfo.getWayPointName())) {
                            jSONObject.put("name", wayPointInfo.getWayPointName());
                        }
                        LatLng latLng = wayPointInfo.getLatLng();
                        if (latLng != null) {
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.gcjToBaidu(latLng);
                            }
                            jSONObject.put(f.D, latLng.longitude);
                            jSONObject.put(f.C, latLng.latitude);
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy naviRoutePolicy) {
        this.h = naviRoutePolicy;
        return this;
    }

    public NaviParaOption setWayPoint(WayPoint wayPoint) {
        if (wayPoint == null) {
            return null;
        }
        this.g = wayPoint;
        return this;
    }

    public NaviParaOption startName(String str) {
        this.b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f3743a = latLng;
        return this;
    }

    public NaviParaOption startUid(String str) {
        this.c = str;
        return this;
    }
}
