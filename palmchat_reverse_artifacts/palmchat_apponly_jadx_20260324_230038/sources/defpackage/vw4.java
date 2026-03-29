package defpackage;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.igexin.push.core.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.tag.bean.CommonResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vw4 implements Response.Listener<JSONObject>, Response.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21547a;
    public tw4 b;

    public vw4(String str, tw4 tw4Var) {
        this.f21547a = str;
        this.b = tw4Var;
    }

    @Override // com.android.volley.Response.Listener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(JSONObject jSONObject) {
        if (jSONObject != null) {
            LogUtil.json("logsquare", jSONObject.toString(), "response: " + this.f21547a);
        } else {
            LogUtil.json("logsquare", b.m, "response: " + this.f21547a);
        }
        this.b.c();
        try {
            Type[] actualTypeArguments = ((ParameterizedType) this.b.getClass().getGenericSuperclass()).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                CommonResponse commonResponse = (CommonResponse) az2.b(jSONObject.toString(), actualTypeArguments[0]);
                if (commonResponse != null) {
                    if (commonResponse.getResultCode() != 0) {
                        this.b.b(commonResponse.getResultCode(), commonResponse.getErrorMsg());
                        return;
                    } else {
                        this.b.a(commonResponse);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b.b(-1, "");
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        LogUtil.json("logsquare", "error", "response: " + this.f21547a);
        this.b.c();
        this.b.b(-1, "");
    }
}
