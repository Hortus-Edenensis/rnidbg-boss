package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import com.oplus.tblplayer.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dd<T> extends da<T, Object> {
    private int g;
    private List<String> h;
    private List<SuggestionCity> i;

    public dd(Context context, T t) {
        super(context, t);
        this.g = 0;
        this.h = new ArrayList();
        this.i = new ArrayList();
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("suggestion");
            if (jSONObjectOptJSONObject != null) {
                this.i = dq.a(jSONObjectOptJSONObject);
                this.h = dq.b(jSONObjectOptJSONObject);
            }
            this.g = jSONObject.optInt("count");
            if (((cz) this).b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) ((cz) this).b, this.g, this.i, this.h, dq.h(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) ((cz) this).b, this.g, this.i, this.h, dq.g(jSONObject));
        } catch (Exception e) {
            di.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        T t = ((cz) this).b;
        return dh.a() + "/bus/" + (t instanceof BusLineQuery ? ((BusLineQuery) t).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) ((cz) this).b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + Constants.STRING_VALUE_UNSET;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((cz) this).b;
        if (t instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(da.b(((BusLineQuery) ((cz) this).b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!dq.i(city)) {
                    String strB = da.b(city);
                    sb.append("&city=");
                    sb.append(strB);
                }
                sb.append("&keywords=" + da.b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t;
            String city2 = busStationQuery.getCity();
            if (!dq.i(city2)) {
                String strB2 = da.b(city2);
                sb.append("&city=");
                sb.append(strB2);
            }
            sb.append("&keywords=" + da.b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + fr.f(((cz) this).e));
        return sb.toString();
    }
}
