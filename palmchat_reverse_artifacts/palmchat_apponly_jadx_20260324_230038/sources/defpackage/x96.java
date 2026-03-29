package defpackage;

import android.os.Build;
import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class x96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21907a = "x96";
    public static ArrayList<String> b = new ArrayList<>();
    public static String[] c = new String[0];
    public static boolean d = true;
    public static String[] e = {"m1 metal"};

    public static boolean a(JSONObject jSONObject) {
        LogUtil.i(f21907a, "parseVideoBlackListConfig :" + jSONObject);
        ArrayList<String> arrayList = new ArrayList<>();
        boolean z = false;
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("vbListConfig");
            boolean z2 = true;
            if (jSONObjectOptJSONObject != null) {
                LogUtil.i(f21907a, "vblConfig:" + jSONObject);
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enable", true);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("blackList");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            arrayList.add(jSONArrayOptJSONArray.getString(i));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            z2 = zOptBoolean;
                        }
                    }
                    z2 = zOptBoolean;
                    z = true;
                } else {
                    z2 = zOptBoolean;
                    z = true;
                }
            }
            if (z) {
                Log.d(f21907a, "sShared enable =  " + z2);
                d = z2;
                b.clear();
                b = arrayList;
            }
        }
        return z;
    }

    public static boolean b() {
        boolean z = false;
        for (String str : c) {
            String str2 = Build.MODEL;
            if (str.equals(str2)) {
                Log.i(f21907a, "supportSharedContext model Id: " + str2);
                return true;
            }
        }
        for (String str3 : b) {
            String str4 = Build.MODEL;
            if (str3.equals(str4)) {
                Log.i(f21907a, "supportSharedContext model Id: " + str4);
                z = true;
            }
            if (str4.indexOf(str3) >= 0) {
                z = true;
            }
        }
        return d ? z : !z;
    }
}
