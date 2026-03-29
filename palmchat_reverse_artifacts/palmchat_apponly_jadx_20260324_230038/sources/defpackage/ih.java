package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.dao.DaoException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ih<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f18163a;
    public Response.ErrorListener b;
    public ContactRequestArgs d;
    public boolean c = true;
    public Response.Listener<JSONObject> e = new a();
    public Response.ErrorListener f = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                if (ih.this.c) {
                    sy5.e(AppContext.getContext(), R.string.sent, 0).g();
                }
                i55.b(ih.this.d);
            } else if (iOptInt == 1) {
                if (ih.this.c) {
                    sy5.e(AppContext.getContext(), R.string.sent, 0).g();
                }
                i55.b(ih.this.d);
            } else if (iOptInt == 1318) {
                if (ih.this.c) {
                    sy5.e(AppContext.getContext(), R.string.send_refuse, 0).g();
                }
            } else if (iOptInt == 7001) {
                if (ih.this.c) {
                    sy5.e(AppContext.getContext(), R.string.send_failed_too_often, 0).g();
                }
            } else if (iOptInt != 1320 && iOptInt != 1321 && ih.this.c) {
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
            ih.this.f18163a.onResponse(jSONObject);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (ih.this.c) {
                sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
            }
            ih.this.b.onErrorResponse(volleyError);
        }
    }

    public ih(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f18163a = listener;
        this.b = errorListener;
    }

    public void r(ContactRequestArgs contactRequestArgs) throws DaoException, JSONException {
        String str;
        if (this.b == null || this.f18163a == null || contactRequestArgs == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        this.d = contactRequestArgs;
        if (contactRequestArgs.i()) {
            str = nl0.n + "/friend/v1/rev_apply.json";
        } else {
            str = nl0.n + ko1.a("/friend/v5/apply.json", "/friend/v7/apply.json");
        }
        try {
            String strZ = k86.Z(str);
            JSONObject jSONObjectS = contactRequestArgs.s();
            jSONObjectS.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObjectS);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObjectS, this.e, this.f);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
            if (nl0.k() || !"-1".equals(contactRequestArgs.h())) {
                return;
            }
            sy5.f(AppContext.getContext(), "apply sourceType= -1", 0).g();
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void s(HashMap<String, T> map) throws DaoException, JSONException {
        if (this.b == null || this.f18163a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(nl0.n + ko1.a("/friend/v5/multi_apply.json", "/friend/v6/multi_apply.json"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObject);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f18163a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void t(JSONObject jSONObject) throws DaoException {
        if (this.b == null || this.f18163a == null || jSONObject == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.c);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f18163a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void u(HashMap<String, T> map) throws DaoException, JSONException {
        if (this.b == null || this.f18163a == null || map == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        try {
            String strZ = k86.Z(vm0.s);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, T> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, this.f18163a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public void v(boolean z) {
        this.c = z;
    }
}
