package defpackage;

import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wg extends wr<String, Void, qt5> {
    public static final String[] c = {"grantApp", "lx_checkJsApi", "lx_getLocation", "lx_selectLocation", "lx_showLocation", "lx_pay", "lx_getPaySupportPlatform", "lx_getUserAgent", "lx_getDeviceInfo", "lx_getPrivDeviceInfo", "lx_getDeviceId", "lx_getWebViewSize", "lx_closeWebView", "lx_shareText", "lx_shareWeb", "lx_shareImage", "lx_shareSVideo", "lx_shareNameCard", "lx_shareMiniApp", "lx_login"};

    public wg(pt5<qt5> pt5Var) {
        super(pt5Var, wg.class.getSimpleName());
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qt5 doInBackground(String... strArr) {
        String strG = n44.g();
        if (strArr.length > 2 && strArr[2].equals(TurnInfo.TYPE_NATIVE)) {
            strG = n44.d();
        }
        return qt5.a(wn.i(strG, b(strArr[0], strArr[1])), this.b);
    }

    public final Map<String, String> b(String str, String str2) {
        Map<String, String> mapA = m44.a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("host", str2);
            str = jSONObject.toString();
        } catch (JSONException e) {
            ma3.c(e);
        }
        mapA.put(BaseConstants.EVENT_LABEL_EXTRA, str);
        return ja5.c(null, mapA, "lxf48f512f7d6a47c2", "b25a6fa5cad0420e8cb9c6776f8c323e");
    }
}
