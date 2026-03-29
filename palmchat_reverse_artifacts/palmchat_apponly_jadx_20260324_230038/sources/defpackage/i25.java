package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class i25 extends JSONObject {
    public i25() {
    }

    public String a() {
        try {
            return getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
            return "主动打招呼更容易结交好友哦~";
        }
    }

    public int b() {
        try {
            return getInt("order");
        } catch (JSONException e) {
            e.printStackTrace();
            return 3;
        }
    }

    public boolean c() {
        return !TextUtils.isEmpty(a()) && b() > 0;
    }

    public i25(String str) throws JSONException {
        super(str);
    }
}
