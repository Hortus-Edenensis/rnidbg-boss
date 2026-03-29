package com.kwad.sdk.collector;

import android.text.TextUtils;
import com.baidu.location.LocationConst;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int azs;
    private String azr;
    private int state;

    public g(String str, int i) {
        this.azr = str;
        this.state = i;
    }

    private String Fv() {
        int iLastIndexOf;
        String str = this.azr;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (iLastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(iLastIndexOf + 1) : str : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Fv());
            jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return jSONObject;
    }

    public static JSONArray w(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }
}
