package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.col.p0002sl.ej;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class eb extends dx<ef, PoiResultV2> {
    private int g;
    private boolean h;

    public eb(Context context, ef efVar) {
        super(context, efVar);
        this.g = 0;
        this.h = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((cz) this).b;
        if (((ef) t).b != null) {
            if (((ef) t).b.getShape().equals("Bound")) {
                if (z) {
                    double dA = di.a(((ef) ((cz) this).b).b.getCenter().getLongitude());
                    double dA2 = di.a(((ef) ((cz) this).b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(dA + "," + dA2);
                }
                sb.append("&radius=");
                sb.append(((ef) ((cz) this).b).b.getRange());
                sb.append("&sortrule=");
                sb.append(c(((ef) ((cz) this).b).b.isDistanceSort()));
            } else if (((ef) ((cz) this).b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ef) ((cz) this).b).b.getLowerLeft();
                LatLonPoint upperRight = ((ef) ((cz) this).b).b.getUpperRight();
                double dA3 = di.a(lowerLeft.getLatitude());
                double dA4 = di.a(lowerLeft.getLongitude());
                double dA5 = di.a(upperRight.getLatitude());
                sb.append("&polygon=" + dA4 + "," + dA3 + x.aQ + di.a(upperRight.getLongitude()) + "," + dA5);
            } else if (((ef) ((cz) this).b).b.getShape().equals("Polygon") && (polyGonList = ((ef) ((cz) this).b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + di.a(polyGonList));
            }
        }
        String city = ((ef) ((cz) this).b).f2721a.getCity();
        if (!dx.c(city)) {
            String strB = da.b(city);
            sb.append("&region=");
            sb.append(strB);
        }
        String strB2 = da.b(((ef) ((cz) this).b).f2721a.getQueryString());
        if (!dx.c(strB2)) {
            sb.append("&keywords=");
            sb.append(strB2);
        }
        sb.append("&page_size=");
        sb.append(((ef) ((cz) this).b).f2721a.getPageSize());
        sb.append("&page_num=");
        sb.append(((ef) ((cz) this).b).f2721a.getPageNum());
        String building = ((ef) ((cz) this).b).f2721a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((ef) ((cz) this).b).f2721a.getBuilding());
        }
        String strB3 = da.b(((ef) ((cz) this).b).f2721a.getCategory());
        if (!dx.c(strB3)) {
            sb.append("&types=");
            sb.append(strB3);
        }
        String strA = dx.a(((ef) ((cz) this).b).f2721a.getShowFields());
        if (strA != null) {
            sb.append("&show_fields=");
            sb.append(strA);
        }
        sb.append("&key=");
        sb.append(fr.f(((cz) this).e));
        if (((ef) ((cz) this).b).f2721a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (this.h) {
            if (((ef) ((cz) this).b).f2721a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        String channel = ((ef) ((cz) this).b).f2721a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = ((ef) ((cz) this).b).f2721a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        T t2 = ((cz) this).b;
        if (((ef) t2).b == null && ((ef) t2).f2721a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(c(((ef) ((cz) this).b).f2721a.isDistanceSort()));
            double dA6 = di.a(((ef) ((cz) this).b).f2721a.getLocation().getLongitude());
            double dA7 = di.a(((ef) ((cz) this).b).f2721a.getLocation().getLatitude());
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
    public PoiResultV2 a(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            T t = ((cz) this).b;
            return PoiResultV2.createPagedResult(((ef) t).f2721a, ((ef) t).b, this.g, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.g = jSONObject.optInt("count");
            arrayList = dq.d(jSONObject);
        } catch (JSONException e) {
            di.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            di.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        T t2 = ((cz) this).b;
        return PoiResultV2.createPagedResult(((ef) t2).f2721a, ((ef) t2).b, this.g, arrayList);
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
        String str = dh.c() + "/place";
        T t = ((cz) this).b;
        if (((ef) t).b == null) {
            return str + "/text?";
        }
        if (((ef) t).b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.h = true;
            return str2;
        }
        if (!((ef) ((cz) this).b).b.getShape().equals("Rectangle") && !((ef) ((cz) this).b).b.getShape().equals("Polygon")) {
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
            if (((ef) ((cz) this).b).b.getShape().equals("Bound")) {
                bVar.b = new ej.a(di.a(((ef) ((cz) this).b).b.getCenter().getLatitude()), di.a(((ef) ((cz) this).b).b.getCenter().getLongitude()), dA);
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
