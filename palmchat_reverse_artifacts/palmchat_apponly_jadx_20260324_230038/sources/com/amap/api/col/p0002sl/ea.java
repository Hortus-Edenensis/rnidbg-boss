package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.col.p0002sl.ej;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ea extends dx<ee, PoiResult> {
    private int g;
    private boolean h;
    private List<String> i;
    private List<SuggestionCity> j;

    public ea(Context context, ee eeVar) {
        super(context, eeVar);
        this.g = 0;
        this.h = false;
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((cz) this).b;
        if (((ee) t).b != null) {
            if (((ee) t).b.getShape().equals("Bound")) {
                if (z) {
                    double dA = di.a(((ee) ((cz) this).b).b.getCenter().getLongitude());
                    double dA2 = di.a(((ee) ((cz) this).b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(dA + "," + dA2);
                }
                sb.append("&radius=");
                sb.append(((ee) ((cz) this).b).b.getRange());
                sb.append("&sortrule=");
                sb.append(c(((ee) ((cz) this).b).b.isDistanceSort()));
            } else if (((ee) ((cz) this).b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ee) ((cz) this).b).b.getLowerLeft();
                LatLonPoint upperRight = ((ee) ((cz) this).b).b.getUpperRight();
                double dA3 = di.a(lowerLeft.getLatitude());
                double dA4 = di.a(lowerLeft.getLongitude());
                double dA5 = di.a(upperRight.getLatitude());
                sb.append("&polygon=" + dA4 + "," + dA3 + x.aQ + di.a(upperRight.getLongitude()) + "," + dA5);
            } else if (((ee) ((cz) this).b).b.getShape().equals("Polygon") && (polyGonList = ((ee) ((cz) this).b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + di.a(polyGonList));
            }
        }
        String city = ((ee) ((cz) this).b).f2720a.getCity();
        if (!dx.c(city)) {
            String strB = da.b(city);
            sb.append("&city=");
            sb.append(strB);
        }
        String strB2 = da.b(((ee) ((cz) this).b).f2720a.getQueryString());
        if (!dx.c(strB2)) {
            sb.append("&keywords=");
            sb.append(strB2);
        }
        sb.append("&offset=");
        sb.append(((ee) ((cz) this).b).f2720a.getPageSize());
        sb.append("&page=");
        sb.append(((ee) ((cz) this).b).f2720a.getPageNum());
        String building = ((ee) ((cz) this).b).f2720a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((ee) ((cz) this).b).f2720a.getBuilding());
        }
        String strB3 = da.b(((ee) ((cz) this).b).f2720a.getCategory());
        if (!dx.c(strB3)) {
            sb.append("&types=");
            sb.append(strB3);
        }
        if (dx.c(((ee) ((cz) this).b).f2720a.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((ee) ((cz) this).b).f2720a.getExtensions());
        }
        sb.append("&key=");
        sb.append(fr.f(((cz) this).e));
        if (((ee) ((cz) this).b).f2720a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((ee) ((cz) this).b).f2720a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.h) {
            if (((ee) ((cz) this).b).f2720a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = ((cz) this).b;
        if (((ee) t2).b == null && ((ee) t2).f2720a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(c(((ee) ((cz) this).b).f2720a.isDistanceSort()));
            double dA6 = di.a(((ee) ((cz) this).b).f2720a.getLocation().getLongitude());
            double dA7 = di.a(((ee) ((cz) this).b).f2720a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(dA6 + "," + dA7);
        }
        return sb.toString();
    }

    private static String c(boolean z) {
        return z ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public PoiResult a(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t = ((cz) this).b;
            return PoiResult.createPagedResult(((ee) t).f2720a, ((ee) t).b, this.i, this.j, ((ee) t).f2720a.getPageSize(), this.g, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.g = jSONObject.optInt("count");
            arrayList = dq.c(jSONObject);
        } catch (JSONException e) {
            di.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            di.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t2 = ((cz) this).b;
            return PoiResult.createPagedResult(((ee) t2).f2720a, ((ee) t2).b, this.i, this.j, ((ee) t2).f2720a.getPageSize(), this.g, arrayList);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("suggestion");
        if (jSONObjectOptJSONObject == null) {
            T t3 = ((cz) this).b;
            return PoiResult.createPagedResult(((ee) t3).f2720a, ((ee) t3).b, this.i, this.j, ((ee) t3).f2720a.getPageSize(), this.g, arrayList);
        }
        this.j = dq.a(jSONObjectOptJSONObject);
        this.i = dq.b(jSONObjectOptJSONObject);
        T t4 = ((cz) this).b;
        return PoiResult.createPagedResult(((ee) t4).f2720a, ((ee) t4).b, this.i, this.j, ((ee) t4).f2720a.getPageSize(), this.g, arrayList);
    }

    private static ej i() {
        ei eiVarA = eh.a().a("regeo");
        if (eiVarA == null) {
            return null;
        }
        return (ej) eiVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        String str = dh.a() + "/place";
        T t = ((cz) this).b;
        if (((ee) t).b == null) {
            return str + "/text?";
        }
        if (((ee) t).b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.h = true;
            return str2;
        }
        if (!((ee) ((cz) this).b).b.getShape().equals("Rectangle") && !((ee) ((cz) this).b).b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.cz
    public final eh.b g() {
        eh.b bVar = new eh.b();
        if (this.h) {
            ej ejVarI = i();
            double dA = ejVarI != null ? ejVarI.a() : 0.0d;
            bVar.f2725a = f() + b(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((ee) ((cz) this).b).b.getShape().equals("Bound")) {
                bVar.b = new ej.a(di.a(((ee) ((cz) this).b).b.getCenter().getLatitude()), di.a(((ee) ((cz) this).b).b.getCenter().getLongitude()), dA);
            }
        } else {
            bVar.f2725a = f() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        return b(true);
    }
}
