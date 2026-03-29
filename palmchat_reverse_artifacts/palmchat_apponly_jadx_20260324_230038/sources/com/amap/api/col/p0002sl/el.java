package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.col.p0002sl.ej;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class el extends da<RegeocodeQuery, RegeocodeAddress> {
    public el(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(di.a(((RegeocodeQuery) ((cz) this).b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(di.a(((RegeocodeQuery) ((cz) this).b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((cz) this).b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) ((cz) this).b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((cz) this).b).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) ((cz) this).b).getMode());
        }
        if (TextUtils.isEmpty(((RegeocodeQuery) ((cz) this).b).getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) ((cz) this).b).getExtensions());
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) ((cz) this).b).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) ((cz) this).b).getLatLonType());
        sb.append("&key=");
        sb.append(fr.f(((cz) this).e));
        return sb.toString();
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (jSONObjectOptJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(dq.a(jSONObjectOptJSONObject, "formatted_address"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("addressComponent");
            if (jSONObjectOptJSONObject2 != null) {
                dq.a(jSONObjectOptJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(dq.c(jSONObjectOptJSONObject));
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("roads");
            if (jSONArrayOptJSONArray != null) {
                dq.b(jSONArrayOptJSONArray, regeocodeAddress);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("roadinters");
            if (jSONArrayOptJSONArray2 != null) {
                dq.a(jSONArrayOptJSONArray2, regeocodeAddress);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("aois");
            if (jSONArrayOptJSONArray3 != null) {
                dq.c(jSONArrayOptJSONArray3, regeocodeAddress);
            }
        } catch (JSONException e) {
            di.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        return regeocodeAddress;
    }

    private static ej i() {
        ei eiVarA = eh.a().a("regeo");
        if (eiVarA == null) {
            return null;
        }
        return (ej) eiVarA;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/geocode/regeo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.cz
    public final eh.b g() {
        ej ejVarI = i();
        double dA = ejVarI != null ? ejVarI.a() : 0.0d;
        eh.b bVar = new eh.b();
        bVar.f2725a = f() + b(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t = ((cz) this).b;
        if (t != 0 && ((RegeocodeQuery) t).getPoint() != null) {
            bVar.b = new ej.a(((RegeocodeQuery) ((cz) this).b).getPoint().getLatitude(), ((RegeocodeQuery) ((cz) this).b).getPoint().getLongitude(), dA);
        }
        return bVar;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        return b(true);
    }
}
