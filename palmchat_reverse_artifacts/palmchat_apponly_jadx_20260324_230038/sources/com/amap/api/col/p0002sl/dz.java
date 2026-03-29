package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.eh;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dz extends dx<String, PoiItemV2> {
    private PoiSearchV2.Query g;

    public dz(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.g = query;
    }

    private static PoiItemV2 e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            di.a(e, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            di.a(e2, "PoiSearchIdHandlerV2", "paseJSONException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String i() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) ((cz) this).b);
        sb.append("&output=json");
        PoiSearchV2.Query query = this.g;
        String strA = (query == null || query.getShowFields() == null) ? null : dx.a(this.g.getShowFields());
        if (strA != null) {
            sb.append("&show_fields=");
            sb.append(strA);
        }
        sb.append("&key=" + fr.f(((cz) this).e));
        String channel = this.g.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = this.g.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        return sb.toString();
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return e(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.c() + "/place/detail?";
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final eh.b g() {
        eh.b bVar = new eh.b();
        bVar.f2725a = f() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    private static PoiItemV2 a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return dq.f(jSONObjectOptJSONObject);
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        return i();
    }
}
