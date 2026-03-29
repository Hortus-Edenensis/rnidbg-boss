package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.sync.AlertVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17600a = "fu3";
    public static volatile fu3 b;

    public static fu3 a() {
        if (b == null) {
            synchronized (fu3.class) {
                if (b == null) {
                    b = new fu3();
                }
            }
        }
        return b;
    }

    public void b(AlertVo alertVo) {
        String str = f17600a;
        LogUtil.i(str, "updateAlertVoFromSync");
        if (alertVo == null || TextUtils.isEmpty(alertVo.text)) {
            return;
        }
        LogUtil.i(str, "updateAlertVoFromSync text:" + alertVo.text);
        try {
            JSONObject jSONObject = new JSONObject(alertVo.text);
            if (jSONObject.optLong("expireTime") > System.currentTimeMillis()) {
                lu3.b(jSONObject);
                if (!AppContext.getContext().isBackground()) {
                    ch.s().H0();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
