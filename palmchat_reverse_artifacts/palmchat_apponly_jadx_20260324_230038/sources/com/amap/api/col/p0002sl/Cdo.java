package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.amap.api.col.2sl.do, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Cdo extends da<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public Cdo(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("count") && jSONObject.getInt("count") > 0) ? dq.i(jSONObject) : arrayList;
        } catch (JSONException e) {
            di.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            di.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/geocode/geo?";
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final eh.b g() {
        eh.b bVar = new eh.b();
        bVar.f2725a = f() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(da.b(((GeocodeQuery) ((cz) this).b).getLocationName()));
        String city = ((GeocodeQuery) ((cz) this).b).getCity();
        if (!dq.i(city)) {
            String strB = da.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strB);
        }
        if (!dq.i(((GeocodeQuery) ((cz) this).b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(da.b(((GeocodeQuery) ((cz) this).b).getCountry()));
        }
        stringBuffer.append("&key=" + fr.f(((cz) this).e));
        return stringBuffer.toString();
    }
}
