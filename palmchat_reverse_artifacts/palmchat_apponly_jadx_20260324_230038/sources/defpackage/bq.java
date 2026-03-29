package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bq extends p0 {
    @Override // defpackage.yl0
    public void e(String str, JSONObject jSONObject) {
        LogUtil.i("BaseConfigProcessor", "ConfigHelper uid=" + str + " updateConfigs =" + jSONObject);
        if (jSONObject == null || !j(false, str, jSONObject)) {
            return;
        }
        l(AppContext.getContext(), str + "key_log_configs", jSONObject.toString());
    }

    @Override // defpackage.yl0
    public void init(String str) {
        String strI;
        LogUtil.i("BaseConfigProcessor", "init uid =" + str);
        if (str != null) {
            strI = i(AppContext.getContext(), str + "key_log_configs");
            if (TextUtils.isEmpty(strI)) {
                strI = AppContext.getContext().getTrayPreferences().e("key_log_configs", "");
                if (!TextUtils.isEmpty(strI)) {
                    LogUtil.i("BaseConfigProcessor", "init use old data " + str);
                }
            }
        } else {
            strI = null;
        }
        LogUtil.i("BaseConfigProcessor", "ConfigHelper init:" + strI);
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        try {
            j(true, str, new JSONObject(strI));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
