package defpackage;

import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dq3 extends wt0 {
    public static final String e = nl0.f + "/file/v3/head_img.json";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<String> f17125a;
    public Response.ErrorListener b;
    public String c;
    public boolean d;

    public dq3(Response.Listener<String> listener, Response.ErrorListener errorListener, String str, boolean z) {
        this.f17125a = listener;
        this.b = errorListener;
        this.c = str;
        this.d = z;
    }

    public void n() throws DaoException, JSONException {
        if (this.b == null || this.f17125a == null || TextUtils.isEmpty(this.c)) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        try {
            rs3 rs3Var = new rs3(k86.Z(e), this.b, this.f17125a, new File(this.c), "headImg", null);
            rs3Var.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(rs3Var);
            this.mRequests.add(rs3Var);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void o(String str, String str2) throws DaoException {
        String str3;
        if (this.b == null || this.f17125a == null || TextUtils.isEmpty(this.c)) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        String str4 = null;
        try {
            String strB0 = k86.b0(e, str, str2);
            try {
                if (AppContext.getSecretKey() == null) {
                    LogUtil.uploadInfoImmediate(str, "portrait_e", null, null, "upload portrait token is null");
                }
                str3 = strB0;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                str4 = strB0;
                e.printStackTrace();
                str3 = str4;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
        }
        rs3 rs3Var = new rs3(str3, this.b, this.f17125a, new File(this.c), "headImg", null, true);
        rs3Var.setRetryPolicy(this.d ? new DefaultRetryPolicy(20000, 0, 1.0f) : new DefaultRetryPolicy(30000, 0, 1.0f));
        normalRequestQueue.add(rs3Var);
    }
}
