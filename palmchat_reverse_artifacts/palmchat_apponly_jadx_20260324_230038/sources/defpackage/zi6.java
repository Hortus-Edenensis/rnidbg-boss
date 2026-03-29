package defpackage;

import android.content.Context;
import android.content.Intent;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.zenmen.palmchat.QRCodeScan.WebLoginActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zi6 extends bo2 {
    public static final String d = "zi6";
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22434a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f22434a = context;
            this.b = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(zi6.d, "response: " + jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            Intent intent = new Intent(this.f22434a, (Class<?>) WebLoginActivity.class);
            intent.putExtra("web_login_uuid", this.b);
            intent.putExtra("web_login_result", iOptInt == 0 ? "web_login_success" : "web_login_fail");
            this.f22434a.startActivity(intent);
            zi6.this.f1790a.onFinish(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22435a;
        public final /* synthetic */ String b;

        public b(Context context, String str) {
            this.f22435a = context;
            this.b = str;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(zi6.d, "error: " + volleyError.toString());
            Intent intent = new Intent(this.f22435a, (Class<?>) WebLoginActivity.class);
            intent.putExtra("web_login_uuid", this.b);
            intent.putExtra("web_login_result", "web_login_fail");
            this.f22435a.startActivity(intent);
            zi6.this.f1790a.onFinish(false);
        }
    }

    public zi6(FrameworkBaseActivity frameworkBaseActivity, bo2.a aVar) {
        super(frameworkBaseActivity, aVar);
        this.c = frameworkBaseActivity;
    }

    @Override // defpackage.bo2
    public void a(String str) {
        c(this.c, str);
    }

    public final void c(Context context, String str) {
        String strSubstring = str.substring(6);
        HashMap map = new HashMap();
        map.put(Constant.MAP_KEY_UUID, strSubstring);
        try {
            new pj6(new a(context, strSubstring), new b(context, strSubstring), map).p();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
