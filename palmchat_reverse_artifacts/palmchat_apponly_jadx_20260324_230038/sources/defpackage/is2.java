package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.utils.WifiLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class is2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f18251a = 1;
    public static int b = 1440;

    public static void a(String str) {
        try {
            WifiLog.d("IncomePopManager loadConfig");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            f18251a = jSONObject.optInt("enable");
            b = jSONObject.optInt("frequency_minutes");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            WifiLog.d("IncomePopManager  updateConfig");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            f18251a = jSONObject.optInt("enable");
            b = jSONObject.optInt("frequency_minutes");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
