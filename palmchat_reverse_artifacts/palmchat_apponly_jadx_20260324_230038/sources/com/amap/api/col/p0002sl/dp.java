package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dp extends da<InputtipsQuery, ArrayList<Tip>> {
    public dp(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return dq.j(new JSONObject(str));
        } catch (JSONException e) {
            di.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/assistant/inputtips?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String strB = da.b(((InputtipsQuery) ((cz) this).b).getKeyword());
        if (!TextUtils.isEmpty(strB)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(strB);
        }
        String city = ((InputtipsQuery) ((cz) this).b).getCity();
        if (!dq.i(city)) {
            String strB2 = da.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(strB2);
        }
        String type = ((InputtipsQuery) ((cz) this).b).getType();
        if (!dq.i(type)) {
            String strB3 = da.b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(strB3);
        }
        if (((InputtipsQuery) ((cz) this).b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) ((cz) this).b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(fr.f(((cz) this).e));
        return stringBuffer.toString();
    }
}
