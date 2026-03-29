package defpackage;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.R$string;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qt5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20322a = 4;
    public String b;
    public JSONObject c;
    public String d;

    public qt5(String str) {
        this.d = str;
    }

    public static qt5 a(String str, String str2) {
        ma3.a("get TaskResult from Server " + str, new Object[0]);
        qt5 qt5Var = new qt5(str2);
        if (TextUtils.isEmpty(str)) {
            qt5Var.b = OpenApiManager.getContext().getString(R$string.lx_open_api_net_err);
        } else {
            try {
                qt5Var.c = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject jSONObject = qt5Var.c;
            if (jSONObject != null) {
                if (jSONObject.optString(WkParams.RETCD).equals("0")) {
                    qt5Var.f20322a = 1;
                } else {
                    qt5Var.f20322a = 0;
                }
                qt5Var.b = qt5Var.c.optString(WkParams.RETMSG);
            }
        }
        return qt5Var;
    }
}
