package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dy extends dx<String, PoiItem> {
    private PoiSearch.Query g;

    public dy(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.g = query;
    }

    private static PoiItem e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            di.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            di.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String i() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) ((cz) this).b);
        sb.append("&output=json");
        PoiSearch.Query query = this.g;
        if (query == null || dx.c(query.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(this.g.getExtensions());
        }
        sb.append("&children=1");
        sb.append("&key=" + fr.f(((cz) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return e(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/place/detail?";
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final eh.b g() {
        eh.b bVar = new eh.b();
        bVar.f2725a = f() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    private static PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return dq.e(jSONObjectOptJSONObject);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        return i();
    }
}
