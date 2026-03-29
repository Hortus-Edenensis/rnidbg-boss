package defpackage;

import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class gs extends yw4 {
    public static final String e = "gs";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Response.Listener<JSONObject> f17794a;
    public Response.ErrorListener b;
    public boolean c = true;
    public String d = "";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            yy2 yy2VarB = yy2.b(jSONObject);
            if (!yy2VarB.f22300a && gs.this.c && !lw3.b(yy2VarB.b) && !TextUtils.isEmpty(yy2VarB.c)) {
                sy5.f(AppContext.getContext(), yy2VarB.c, 0).g();
            }
            gs.this.onSuccess(jSONObject, yy2VarB);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (gs.this.c && !lw3.c(volleyError)) {
                sy5.f(AppContext.getContext(), gs.this.c(), 0).g();
            }
            gs.this.onFail(volleyError);
        }
    }

    public gs() {
        this.f17794a = null;
        this.b = null;
        this.f17794a = new a();
        this.b = new b();
    }

    public final String c() {
        return TextUtils.isEmpty(this.d) ? AppContext.getContext().getString(R.string.sent_request_failed) : this.d;
    }

    public Response.ErrorListener d() {
        return this.b;
    }

    public Response.Listener<JSONObject> e() {
        return this.f17794a;
    }

    public gs f(boolean z) {
        this.c = z;
        return this;
    }

    public gs g(boolean z, String str) {
        this.c = z;
        this.d = str;
        return this;
    }
}
