package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class q87 extends co6<jx3> {
    public Context k;
    public int l;
    public boolean m;
    public String[] n;

    public q87(Context context, String str, int i, String[] strArr, eo6 eo6Var) {
        super(1, str, eo6Var);
        this.m = true;
        this.k = context.getApplicationContext();
        this.n = strArr;
        this.l = i;
    }

    @Override // defpackage.co6
    public byte[] e() {
        f27 f27Var = new f27();
        HashMap<String, String> mapC = f27Var.c(this.k);
        mapC.put("version", String.valueOf(this.l));
        mapC.put(az.aQ, String.valueOf(Build.VERSION.SDK_INT));
        mapC.put("brand", na7.a());
        mapC.put("osVersion", n47.f());
        JSONArray jSONArray = new JSONArray();
        String[] strArr = this.n;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("invokeId", Integer.valueOf(str).intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
            mapC.put("stateList", jSONArray.toString());
        }
        boolean z = this.m;
        if (z) {
            mapC.put(Constants.CP_GZIP, String.valueOf(z));
        }
        try {
            return f27Var.a("03600103", mapC, false).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.co6
    public Map<String, List<String>> g() {
        return null;
    }

    @Override // defpackage.co6
    public do6<jx3> n(bo6 bo6Var) {
        try {
            String str = new String(bo6Var.a(), "UTF-8");
            yw6.a("config:" + str);
            jx3 jx3VarR = r(str);
            return os.a(jx3VarR) ? do6.e(jx3VarR) : s(jx3VarR);
        } catch (UnsupportedEncodingException e) {
            return do6.a(e);
        } catch (Exception e2) {
            return do6.a(e2);
        }
    }

    public final jx3 r(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        jx3 jx3Var = new jx3();
        jx3Var.c(jSONObject.getString(WkParams.RETCD));
        if (jSONObject.has(WkParams.RETMSG)) {
            jx3Var.d(jSONObject.getString(WkParams.RETMSG));
        }
        if (jSONObject.has("req_number")) {
            jx3Var.m(jSONObject.getInt("req_number"));
        }
        if (jSONObject.has("req_duration")) {
            jx3Var.l(jSONObject.getInt("req_duration"));
        }
        jx3Var.n(jSONObject.getInt("version"));
        if (jSONObject.has("appList")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("appList");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    se seVar = new se();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has("invokeId") && jSONObject2.has("packageName")) {
                        seVar.c(jSONObject2.getInt("invokeId"));
                        seVar.d(jSONObject2.getString("packageName"));
                    }
                    arrayList.add(seVar);
                }
            }
            jx3Var.j(arrayList);
        }
        if (jSONObject.has("invokeList")) {
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = jSONObject.getJSONArray("invokeList");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    qu2 qu2Var = new qu2();
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (jSONObject3.has("packageName")) {
                        qu2Var.o(jSONObject3.getString("packageName"));
                    }
                    if (jSONObject3.has("watchType")) {
                        qu2Var.t(jSONObject3.getInt("watchType"));
                    }
                    if (jSONObject3.has("service")) {
                        qu2Var.q(jSONObject3.getString("service"));
                    }
                    if (jSONObject3.has("appAction")) {
                        qu2Var.m(jSONObject3.getString("appAction"));
                    }
                    if (jSONObject3.has(az.at)) {
                        qu2Var.r(jSONObject3.getString(az.at));
                    }
                    if (jSONObject3.has("invokeId")) {
                        qu2Var.n(jSONObject3.getInt("invokeId"));
                    }
                    if (jSONObject3.has("wakeNumber")) {
                        qu2Var.s(jSONObject3.getInt("wakeNumber"));
                    }
                    if (jSONObject3.has("activityName")) {
                        qu2Var.k(jSONObject3.getString("activityName"));
                    }
                    if (jSONObject3.has("activityUri")) {
                        qu2Var.l(jSONObject3.getString("activityUri"));
                    }
                    if (jSONObject3.has("reportUrls")) {
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("reportUrls");
                        if (jSONArray3 != null && jSONArray3.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                arrayList3.add(jSONArray3.getString(i3));
                            }
                        }
                        qu2Var.p(arrayList3);
                    }
                    arrayList2.add(qu2Var);
                }
            }
            jx3Var.k(arrayList2);
        }
        return jx3Var;
    }

    public final do6<jx3> s(aq aqVar) {
        if (aqVar == null) {
            return do6.a(new Exception("Json format error"));
        }
        String strB = aqVar.b();
        return !TextUtils.isEmpty(strB) ? do6.a(new Exception(strB)) : do6.a(new Exception("empty response message"));
    }
}
