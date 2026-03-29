package defpackage;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.peoplematch.bean.CommonResponse;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchNoticeBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ww4 implements Response.Listener<JSONObject>, Response.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uw4 f21824a;
    public String b;

    public ww4(uw4 uw4Var, String str) {
        this.f21824a = uw4Var;
        this.b = str;
    }

    @Override // com.android.volley.Response.Listener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(JSONObject jSONObject) {
        PeopleMatchNoticeBean peopleMatchNoticeBean;
        LogUtil.d("logmatch", "response url:" + this.b + " json=" + jSONObject.toString());
        this.f21824a.c();
        try {
            Type[] actualTypeArguments = ((ParameterizedType) this.f21824a.getClass().getGenericSuperclass()).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                CommonResponse commonResponse = (CommonResponse) az2.b(jSONObject.toString(), actualTypeArguments[0]);
                if (commonResponse != null) {
                    if (commonResponse.getResultCode() == 0) {
                        this.f21824a.a(commonResponse);
                        return;
                    }
                    if (commonResponse.getResultCode() == 1004 && (peopleMatchNoticeBean = (PeopleMatchNoticeBean) az2.a(jSONObject.optString("data"), PeopleMatchNoticeBean.class)) != null) {
                        Intent intent = new Intent("action_network_notice");
                        intent.putExtra("extra_notice_url", peopleMatchNoticeBean.getNoticeUrl());
                        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
                    }
                    this.f21824a.b(commonResponse.getResultCode(), commonResponse.getErrorMsg());
                    return;
                }
            }
        } catch (Exception unused) {
        }
        this.f21824a.b(-1, "");
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        LogUtil.d("logmatch", "response url:" + this.b + " onErrorResponse=" + volleyError);
        this.f21824a.c();
        this.f21824a.b(-1, "");
    }
}
