package defpackage;

import android.content.Context;
import com.baidu.location.LocationConst;
import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class m47 extends co6 {
    public Context k;
    public Map<Integer, Integer> l;
    public boolean m;

    public m47(Context context, String str, Map<Integer, Integer> map, eo6 eo6Var) {
        super(1, str, eo6Var);
        this.m = true;
        this.k = context.getApplicationContext();
        this.l = map;
    }

    @Override // defpackage.co6
    public byte[] e() {
        f27 f27Var = new f27();
        HashMap<String, String> mapC = f27Var.c(this.k);
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Integer, Integer> entry : this.l.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("invokeId", key);
                jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, value);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        mapC.put("resultList", jSONArray.toString());
        yw6.a("feedback params : " + jSONArray.toString());
        boolean z = this.m;
        if (z) {
            mapC.put(Constants.CP_GZIP, String.valueOf(z));
        }
        try {
            return f27Var.a("03600104", mapC, false).getBytes("UTF-8");
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
    public do6 n(bo6 bo6Var) {
        try {
            yw6.a("feedback result:" + new String(bo6Var.a(), "UTF-8"));
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
