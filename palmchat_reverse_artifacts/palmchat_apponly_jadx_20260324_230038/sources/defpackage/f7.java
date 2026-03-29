package defpackage;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.dao.DaoException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f7<T> extends wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17469a;
    public Response.ErrorListener b;

    public f7(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17469a = listener;
        this.b = errorListener;
    }

    public void n(ContactRequestArgs contactRequestArgs) throws DaoException, JSONException {
        String str;
        SmidHelper.x(SmidHelper.SMScene.FRIEND_ADD);
        if (this.b == null || this.f17469a == null || contactRequestArgs == null) {
            throw new DaoException(DaoException.DAO_INITIAL_ERROR_MESSAGE);
        }
        if (contactRequestArgs.i()) {
            str = nl0.n + "/friend/v1/rev_add.json";
        } else {
            str = nl0.n + ko1.a("/friend/v5/add.json", "/friend/v7/add.json");
        }
        try {
            String strZ = k86.Z(str);
            JSONObject jSONObjectS = contactRequestArgs.s();
            jSONObjectS.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObjectS);
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObjectS, this.f17469a, this.b);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
            if (nl0.k() || !"-1".equals(contactRequestArgs.h())) {
                return;
            }
            sy5.f(AppContext.getContext(), "add sourceType= -1", 0).g();
        } catch (Exception unused) {
            throw new DaoException("base 64 encode error");
        }
    }

    public LXBaseNetBean o(ContactRequestArgs contactRequestArgs) {
        SmidHelper.x(SmidHelper.SMScene.FRIEND_ADD);
        try {
            return zw4.k(new a(contactRequestArgs));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void p(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.f17469a = listener;
        this.b = errorListener;
    }

    public f7() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestArgs f17470a;

        public a(ContactRequestArgs contactRequestArgs) {
            this.f17470a = contactRequestArgs;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            String str;
            JSONObject jSONObjectS = this.f17470a.s();
            try {
                jSONObjectS.put("sdid", ac1.v());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            EncryptUtils.setLxData(jSONObjectS);
            if (this.f17470a.i()) {
                str = nl0.n + "/friend/v1/rev_add.json";
            } else {
                str = nl0.n + ko1.a("/friend/v5/add.json", "/friend/v7/add.json");
            }
            return sw4.c(1, str, jSONObjectS);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
        }
    }
}
