package defpackage;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ms2 extends p0 {
    public JSONObject o = null;

    @Override // defpackage.yl0
    public void e(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        LogUtil.i("IncreConfigProcessor", "ConfigHelper uid=" + str + " updateConfigs =" + jSONObject);
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("configs")) == null) {
            return;
        }
        if (jSONObject.optInt("configType", 0) == 0 || (jSONObject2 = this.o) == null) {
            this.o = m(jSONObjectOptJSONObject);
        } else {
            n(jSONObject2, jSONObjectOptJSONObject);
        }
        j(false, str, this.o);
        l(AppContext.getContext(), str + "key_log_configs", this.o.toString());
    }

    @Override // defpackage.yl0
    public void init(String str) {
        String strI;
        LogUtil.i("IncreConfigProcessor", "init uid =" + str);
        if (str != null) {
            strI = i(AppContext.getContext(), str + "key_log_configs");
        } else {
            strI = null;
        }
        LogUtil.i("IncreConfigProcessor", "ConfigHelper init:" + strI);
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strI);
            j(true, str, jSONObject);
            this.o = jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final JSONObject m(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        JSONObject jSONObject3 = new JSONObject();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (next.startsWith("dyc|")) {
                    jSONObject3.put(next.substring(4), jSONObjectOptJSONObject);
                } else {
                    jSONObject2.put(next, jSONObjectOptJSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject2.put(DynamicConfig.JSON_KEY, jSONObject3);
        LogUtil.i("IncreConfigProcessor", "convert =" + jSONObject2);
        return jSONObject2;
    }

    public final void n(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                if (next.startsWith("dyc|")) {
                    jSONObject.optJSONObject(DynamicConfig.JSON_KEY).put(next.substring(4), jSONObjectOptJSONObject);
                } else {
                    jSONObject.put(next, jSONObjectOptJSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.i("IncreConfigProcessor", "updateJson =" + jSONObject);
    }
}
