package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.update.AppInfo;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c56<T> extends wt0 {
    public static final String c = nl0.c + "/smooth/v6/update";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f1895a;
    public Response.ErrorListener b;

    public c56(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f1895a = listener;
        this.b = errorListener;
    }

    public final String n() {
        if (!jo6.a("LX-45298", false) || !wb1.g() || !p()) {
            return ac1.m;
        }
        return ac1.m + "_64";
    }

    public void o(int i, UpdateManager.UpdateScene updateScene) throws DaoException, JSONException {
        if (this.b == null || this.f1895a == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", n());
            AppInfo appInfo = new AppInfo(AppContext.getContext());
            jSONObject.put(WkParams.IMEI, appInfo.imei);
            jSONObject.put(RedirectRespWrapper.KEY_VERCODE, appInfo.version.code);
            jSONObject.put(RedirectRespWrapper.KEY_VERNAME, appInfo.version.name);
            jSONObject.put("locale", Locale.getDefault().toString());
            jSONObject.put("pfm", BaseWrapper.ENTER_ID_TOOLKIT);
            jSONObject.put("ospv", ac1.e);
            jSONObject.put("wh", me1.g() + "-" + me1.f());
            LocationEx locationExI = d.g().i(172800000L);
            if (k86.L(locationExI)) {
                jSONObject.put("longitude", "" + locationExI.getLongitude());
                jSONObject.put("latitude", "" + locationExI.getLatitude());
            } else {
                jSONObject.put("longitude", "");
                jSONObject.put("latitude", "");
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            String str = k86.b0(c, AccountUtils.q(AppContext.getContext(), false), AccountUtils.o(AppContext.getContext())) + "&updateType=" + i + "&isBlockUser=" + (updateScene == UpdateManager.UpdateScene.LOGIN_FORBIDDEN);
            LogUtil.json("logupdate", jSONObject.toString(), "request: " + str);
            normalRequestQueue.add(new JsonObjectRequest(1, str, jSONObject, this.f1895a, this.b));
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public final boolean p() {
        String strB = vs0.a().b("arch64SupportChannel");
        return strB != null && strB.contains(ac1.m);
    }
}
