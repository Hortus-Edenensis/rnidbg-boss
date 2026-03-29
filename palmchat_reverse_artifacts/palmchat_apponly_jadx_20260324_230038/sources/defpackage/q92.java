package defpackage;

import com.android.volley.LxRetryCacheHelper;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q92 extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f20205a;
    public Response.ErrorListener b;

    public q92(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f20205a = listener;
        this.b = errorListener;
    }

    public void n(String str, String str2) throws DaoException {
        if (this.b == null || this.f20205a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        if (str == null || "0".equals(str)) {
            str = "";
        }
        String str3 = nl0.z + "/userem.getUserDetail.v4";
        try {
            String strA = xn3.a();
            String strF0 = k86.f0(k86.a0(str3, strA) + "&fuid=" + str, "fexid", str2);
            LocationEx locationExI = d.g().i(Long.MAX_VALUE);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fexid", str2);
            jSONObject.put("fuid", str);
            jSONObject.put("reqId", strA);
            if (locationExI != null) {
                jSONObject.put("cityCode", locationExI.getCityCode());
                jSONObject.put("longitude", locationExI.getLongitude());
                jSONObject.put("latitude", locationExI.getLatitude());
            }
            LogUtil.json("logportrait", jSONObject.toString(), "/userem.getUserDetail.v4");
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strF0, jSONObject, this.f20205a, this.b);
            aw awVarB = aw.b(jSONObject);
            if (str.equals(AccountUtils.p(AppContext.getContext()))) {
                awVarB.d = false;
            }
            encryptedJsonRequest.setCacheConfig(awVarB);
            if (LxRetryCacheHelper.needRetry()) {
                encryptedJsonRequest.setRetryPolicy(wt0.genRetryPolicy());
            }
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }
}
