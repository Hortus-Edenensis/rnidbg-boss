package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dv extends da<NearbySearch.NearbyQuery, NearbySearchResult> {
    private Context g;
    private NearbySearch.NearbyQuery h;

    public dv(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.g = context;
        this.h = nearbyQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.h.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> arrayListA = dq.a(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(arrayListA);
            return nearbySearchResult;
        } catch (JSONException e) {
            di.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.d() + "/nearby/around";
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(fr.f(this.g));
        LatLonPoint centerPoint = this.h.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.h.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.h.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.h.getTimeRange());
        return stringBuffer.toString();
    }
}
