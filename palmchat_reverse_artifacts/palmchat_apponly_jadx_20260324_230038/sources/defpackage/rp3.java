package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.webplatform.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class rp3 {
    public static rp3 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20532a;

    public static rp3 f() {
        if (b == null) {
            synchronized (rp3.class) {
                if (b == null) {
                    b = new rp3();
                }
            }
        }
        return b;
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(jSONObject.getJSONObject(DynamicConfig.JSON_KEY).getJSONObject("miniApp").getString(BaseConstants.EVENT_LABEL_EXTRA)).optJSONArray("defaultApp");
                if (jSONArrayOptJSONArray != null) {
                    b.n().e(str, jSONArrayOptJSONArray);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f20532a > 600000) {
            this.f20532a = jCurrentTimeMillis;
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MINI_PROGRAMS);
            if (dynamicConfig == null || !dynamicConfig.isEnable()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONObject(dynamicConfig.getExtra()).getJSONArray("autoUpdate");
                if (jSONArray.length() > 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    b.n().g(strArr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = new JSONObject(jSONObject.getJSONObject(DynamicConfig.JSON_KEY).getJSONObject("miniApp").getString(BaseConstants.EVENT_LABEL_EXTRA)).getJSONArray("autoUpdate");
                if (jSONArray.length() > 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    b.n().g(strArr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String d(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = context.getContentResolver().query(hq3.f18029a, null, "web_id=?", new String[]{str}, null);
                if (cursorQuery != null) {
                    strM = cursorQuery.moveToNext() ? b.m(str, cursorQuery.getInt(cursorQuery.getColumnIndex("version"))) : null;
                    cursorQuery.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strM;
    }

    public int e(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(hq3.f18029a, null, "web_id=?", new String[]{str}, null);
        if (cursorQuery != null) {
            i = cursorQuery.moveToNext() ? cursorQuery.getInt(cursorQuery.getColumnIndex("version")) : -1;
            cursorQuery.close();
        }
        return i;
    }
}
