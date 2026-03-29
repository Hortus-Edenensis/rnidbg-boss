package defpackage;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static gw5 f17826a;

    public static gw5 a() {
        if (f17826a == null) {
            f17826a = new gw5();
        }
        return f17826a;
    }

    public boolean b(String str) {
        JSONArray jSONArray;
        String strI = ts0.o().i("sdk_control");
        Log.d("third sdk", "thirdSdk = " + strI + ac1.m);
        if (TextUtils.isEmpty(strI)) {
            return true;
        }
        try {
            String strOptString = new JSONObject(strI).optString(str);
            if (TextUtils.isEmpty(strOptString) || (jSONArray = new JSONObject(strOptString).getJSONArray("channel")) == null || jSONArray.length() <= 0) {
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (string.equalsIgnoreCase(ac1.m)) {
                    Log.d("third sdk", "thirdSdkchannel = " + string + "  " + ac1.m);
                    return true;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
